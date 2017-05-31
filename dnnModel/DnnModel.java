package dnnUtil.dnnModel;

import java.io.Serializable;
//import android.support.annotation.Keep;

public class DnnModel implements Serializable {
	static final long serialVersionUID = 1L;

	static{
		System.loadLibrary("native-dnn-model");
	}

	// DnnModel members ============================================================================
	private int mModelVersion;
	private DnnModelDescriptor mModelDescriptor;
	private DnnTrainingData mTrainingData;
	private DnnWeightsData mWeightsData;
	private int mNumberOfTrainingObjects;
	private int mNumberOfTestingObjects;

	// DnnModel constructors =======================================================================
	public DnnModel(DnnModelParameters modelParameters){
		mModelVersion = 0;
		mNumberOfTrainingObjects = 50000; //Todo: changes this, hard coding numbers is a bad practice
		createModel(modelParameters); // maybe change this to get parameters?
	}

	public DnnModel(DnnModelDescriptor modelDescriptor, int modelVersion){
		mModelVersion = modelVersion;
		mModelDescriptor = modelDescriptor;
		loadModel(mModelDescriptor);
	}

	// DnnModel Methods ============================================================================
	private void createModel(DnnModelParameters modelParameters){
		byte[] binaryData = jniCreateModel();
		mModelDescriptor = new DnnModelDescriptor(binaryData, mModelVersion);
		jniGetWeightsData();
	}
	private void loadModel(DnnModelDescriptor modelDescriptor){
		jniLoadModel(mModelDescriptor.getBinaryData());
		jniGetWeightsData();
	}
	public void trainModel(){
		jniTrainModel();
		//byte[] binaryData = jniTrainModel();
		//mModelDescriptor.setBinaryData(binaryData);
	}
	public DnnValidationResult validateModel(){
		float resultAccuracy = jniValidateModel();
		return new DnnValidationResult(mModelVersion, resultAccuracy);
	}
	public int loadTrainingData(String dataFile, String labelsFile, String dataSet){
		mNumberOfTrainingObjects = jniLoadTrainingData(dataFile, labelsFile, dataSet);
		return mNumberOfTrainingObjects;
	}
	public DnnTrainingData getTrainingData(DnnTrainingDescriptor trainingDescriptor){
		jniGetTrainingData(trainingDescriptor.getBeginning(), trainingDescriptor.getEnd());
		return mTrainingData;
	}
	public void setTrainingData(DnnTrainingData trainingData){
		mTrainingData = trainingData;
		mNumberOfTrainingObjects = mTrainingData.getNumOfData();
		jniSetTrainingData(
				mTrainingData.getData(),
				mTrainingData.getLabelsData(),
				mTrainingData.getNumOfData(),
				mTrainingData.getSizeOfData(),
				mTrainingData.getNumOfLabels()
		);
	}
	public DnnWeightsData getWeightsData(){
		jniGetWeightsData();
		return mWeightsData;
	}
	public void setWeightsData(DnnWeightsData weightsData){
		setWeightsData(weightsData, mModelVersion+1);
	}
	public void setWeightsData(DnnWeightsData weightsData, int modelVersion){
		mModelVersion = modelVersion;
		mWeightsData = weightsData;
		byte[] binaryData = jniSetWeightsData();
		mModelDescriptor = new DnnModelDescriptor(binaryData, mModelVersion);
	}
	public DnnDeltaData getDeltaData(){
		DnnWeightsData oldWeights = mWeightsData;
		jniGetWeightsData();
		return new DnnDeltaData(mWeightsData, oldWeights);
	}
	public void setDeltaData(DnnDeltaData deltaData){
		setWeightsData(mWeightsData.addWeights(deltaData), mModelVersion+1);
	}
	public int getModelVersion(){
		return mModelVersion;
	}
	public DnnModelDescriptor getModelDescriptor(){
		return mModelDescriptor;
	}
	public Integer getNumberOfTrainingObjects() {
		return mNumberOfTrainingObjects;
	}
	public Integer getNumberOfTestingObjects(){
		return mNumberOfTestingObjects;
	}


	// Java Native Interface callback methods ======================================================
	//@Keep
	private void initWeightsData_callback(){
		mWeightsData = new DnnWeightsData();
	}
	//@Keep
	private void setLayerWeights_callback(float[] weights, int layerIndex){
		mWeightsData.setLayerWeights(weights, layerIndex);
	}
	//@Keep
	private void setLayerBiases_callback(float[] biases, int layerIndex){
		mWeightsData.setLayerBiases(biases, layerIndex);
	}
	//@Keep
	private void getLayerWeightsData_callback(int layerIndex){
		float[] weights = mWeightsData.getLayerWeights(layerIndex);
		float[] biases =  mWeightsData.getLayerBiases(layerIndex);
		jniSetLayerWeightsData(layerIndex, weights, biases);
	}

	//@Keep
	private void initTrainingData_callback(int numOfLabels, int numOfData, int sizeOfData){
		mTrainingData = new DnnTrainingData(numOfLabels, numOfData, sizeOfData);
	}
	//@Keep
	private void setTrainingData_callback(int[] labels, float[] data){
		mTrainingData.setLabelsData(labels);
		mTrainingData.setData(data);
	}

	// Java Native Interface methods ===============================================================
	private native byte[] jniCreateModel();
	private native byte[] jniUpdateModel();

	private native void jniLoadModel(byte[] binaryData);
	private native void jniTrainModel();
	private native float jniValidateModel();

	private native int jniLoadTrainingData(String dataFile, String labelsFile, String dataSet);
	private native void jniGetTrainingData(int startIndex, int endIndex);
	private native void jniSetTrainingData(float[] data, int[] labels, int numOfData, int dataSize, int numOfLabels);

	private native void jniGetWeightsData();
	private native byte[] jniSetWeightsData();
	private native void jniSetLayerWeightsData(int layer, float[] weights, float[] biases);

}
