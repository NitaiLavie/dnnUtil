package dnnUtil.dnnModel;

import java.io.Serializable;

import dnnUtil.dnnStatistics.DnnValidationResult;
//import android.support.annotation.Keep;

import dnnUtil.dnnStatistics.DnnValidationResult;

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
    private DnnWeightsData mOldWeightsData;
	private int mNumberOfTrainingObjects;
	private int mNumberOfTestingObjects;

	// DnnModel constructors =======================================================================
	public DnnModel(DnnModelParameters modelParameters){
		mModelVersion = 0;
		mNumberOfTrainingObjects = 50000; //Todo: changes this, hard coding numbers is a bad practice
		createModel(modelParameters); // maybe change this to get parameters?
	}

	public DnnModel(DnnModelDescriptor modelDescriptor){
		mModelVersion = modelDescriptor.getModelVersion();
		mModelDescriptor = modelDescriptor;
		loadModel(mModelDescriptor);
	}

	// DnnModel Methods ============================================================================
	synchronized private void createModel(DnnModelParameters modelParameters){
		byte[] binaryData = jniCreateModel();
		mModelDescriptor = new DnnModelDescriptor(binaryData, mModelVersion);
		jniGetWeightsData();
	}
	synchronized private void loadModel(DnnModelDescriptor modelDescriptor){
		jniLoadModel(modelDescriptor.getBinaryData());
		jniGetWeightsData();
	}
	synchronized public void trainModel(){
        mOldWeightsData = mWeightsData.deepcopy();
		jniTrainModel();
		//byte[] binaryData = jniTrainModel();
		//mModelDescriptor.setBinaryData(binaryData);
	}
	synchronized public DnnValidationResult validateModel(){
		float resultAccuracy = jniValidateModel();
		return new DnnValidationResult(mModelVersion, resultAccuracy);
	}
	synchronized public int loadTrainingData(String dataFile, String labelsFile, String dataSet){
		mNumberOfTrainingObjects = jniLoadTrainingData(dataFile, labelsFile, dataSet);
		return mNumberOfTrainingObjects;
	}
	synchronized public DnnTrainingData getTrainingData(DnnTrainingDescriptor trainingDescriptor){
		jniGetTrainingData(trainingDescriptor.getBeginning(), trainingDescriptor.getEnd());
		return mTrainingData;
	}
	synchronized public void setTrainingData(DnnTrainingData trainingData){
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
	synchronized public DnnWeightsData getWeightsData(){
		jniGetWeightsData();
		return mWeightsData;
	}
	synchronized public void setWeightsData(DnnWeightsData weightsData){
		setWeightsData(weightsData, mModelVersion+1);
	}
	synchronized public void setWeightsData(DnnWeightsData weightsData, int modelVersion){
		mModelVersion = modelVersion;
		mWeightsData = weightsData;
		byte[] binaryData = jniSetWeightsData();
		mModelDescriptor = new DnnModelDescriptor(binaryData, mModelVersion);
	}
	synchronized public DnnDeltaData getDeltaData(){
		jniGetWeightsData();
		return new DnnDeltaData(mWeightsData, mOldWeightsData);
	}
	synchronized public void setDeltaData(DnnDeltaData deltaData){
		setWeightsData(mWeightsData.addWeights(deltaData), mModelVersion+1);
	}
	synchronized public int getModelVersion(){
		return mModelVersion;
	}
	synchronized public DnnModelDescriptor getModelDescriptor(){
		return mModelDescriptor;
	}
	synchronized public Integer getNumberOfTrainingObjects() {
		return mNumberOfTrainingObjects;
	}
	synchronized public Integer getNumberOfTestingObjects(){
		return mNumberOfTestingObjects;
	}


	// Java Native Interface callback methods ======================================================
	//@Keep
	synchronized private void initWeightsData_callback(){
		mWeightsData = new DnnWeightsData();
	}
	//@Keep
	synchronized private void setLayerWeights_callback(float[] weights, int layerIndex){
		mWeightsData.setLayerWeights(weights, layerIndex);
	}
	//@Keep
	synchronized private void setLayerBiases_callback(float[] biases, int layerIndex){
		mWeightsData.setLayerBiases(biases, layerIndex);
	}
	//@Keep
	synchronized private void getLayerWeightsData_callback(int layerIndex){
		float[] weights = mWeightsData.getLayerWeights(layerIndex);
		float[] biases =  mWeightsData.getLayerBiases(layerIndex);
		jniSetLayerWeightsData(layerIndex, weights, biases);
	}

	//@Keep
	synchronized private void initTrainingData_callback(int numOfLabels, int numOfData, int sizeOfData){
		mTrainingData = new DnnTrainingData(numOfLabels, numOfData, sizeOfData);
	}
	//@Keep
	synchronized private void setTrainingData_callback(int[] labels, float[] data){
		mTrainingData.setLabelsData(labels);
		mTrainingData.setData(data);
	}

	// Java Native Interface methods ===============================================================
	synchronized private native byte[] jniCreateModel();
	synchronized private native byte[] jniUpdateModel();

	synchronized private native void jniLoadModel(byte[] binaryData);
	synchronized private native void jniTrainModel();
	synchronized private native float jniValidateModel();

	private native int jniLoadTrainingData(String dataFile, String labelsFile, String dataSet);
	private native void jniGetTrainingData(int startIndex, int endIndex);
	private native void jniSetTrainingData(float[] data, int[] labels, int numOfData, int dataSize, int numOfLabels);

	private native void jniGetWeightsData();
	private native byte[] jniSetWeightsData();
	private native void jniSetLayerWeightsData(int layer, float[] weights, float[] biases);

}
