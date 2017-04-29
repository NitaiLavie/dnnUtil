package dnnUtil.dnnModel;

import java.io.Serializable;
//import android.support.annotation.Keep;

public class DnnModel implements Serializable {
	static final long serialVersionUID = 1L;

	static{
		System.loadLibrary("native-dnn-model");
	}

	// DnnModel members ============================================================================
	private DnnModelDescriptor mModelDescriptor;
	private DnnTrainingData mTrainingData;
	private DnnWeightsData mWeightsData;
	private int mNumberOfTrainingObjects;

	// DnnModel constructors =======================================================================
	public DnnModel(DnnModelParameters modelParameters){
		mNumberOfTrainingObjects = loadTrainingData();
		createModel(modelParameters);
	}

	public DnnModel(DnnModelDescriptor modelDescriptor){
		mModelDescriptor = modelDescriptor;
		loadModel(mModelDescriptor);
	}

	// DnnModel Methods ============================================================================
	private void createModel(DnnModelParameters modelParameters){
		byte[] binaryData = jniCreateModel();
		mModelDescriptor = new DnnModelDescriptor(binaryData);

	}
	private void loadModel(DnnModelDescriptor modelDescriptor){
		jniLoadModel(mModelDescriptor.getBinaryData());
	}
	public void updateModel(DnnModelDelta modelDelta){
		byte[] binaryData = jniUpdateModel();
		mModelDescriptor.setBinaryData(binaryData);
	}
	public void trainModel(){
		byte[] binaryData = jniTrainModel();
		mModelDescriptor.setBinaryData(binaryData);
	}
	public int loadTrainingData(){
		return jniLoadTrainingData();
	}
	public DnnTrainingData getTrainingData(DnnTrainingDescriptor trainingDescriptor){
		jniGetTraingData(trainingDescriptor.getBeginning(), trainingDescriptor.getEnd());
		return mTrainingData;
	}
	public void setTrainingData(DnnTrainingData trainingData){
		mTrainingData = trainingData;
		mNumberOfTrainingObjects = mTrainingData.getNumOfData();
		int numOfData = mTrainingData.getNumOfData();
		int dataSize = mTrainingData.getSizeOfData();
		float[] data = new float[numOfData*dataSize];
		int[] labels = new int[numOfData];
		float[] line;
		for(int i = 0; i<numOfData; i++){
			labels[i] = mTrainingData.getIndexLabelData(i);
			line = mTrainingData.getIndexData(i);
			for(int j=0; j<dataSize; j++){
				data[i*dataSize + j] = line[j];
			}
		}
	}
	public DnnModelDescriptor getModelDescriptor(){
		return mModelDescriptor;
	}

	// Java Native Interface callback methods ======================================================
	//@Keep
	private void setLayerWeights(float[] weights, int layerIndex){
		mWeightsData.setLayerWeights(weights, layerIndex);
	}
	//@Keep
	private void setLayerBiases(float[] biases, int layerIndex){
		mWeightsData.setLayerBiases(biases, layerIndex);
	}
	//@Keep
	private float[] getLayerWeights(int layerIndex){
		return mWeightsData.getLayerWeights(layerIndex);
	}
	//@Keep
	private float[] getLayerBiases(int layerIndex){
		return mWeightsData.getLayerBiases(layerIndex);
	}

	//@Keep
	private void initTrainingData(int numOfLabels, int numOfData, int sizeOfData){
		mTrainingData = new DnnTrainingData(numOfLabels, numOfData, sizeOfData);
	}
	//@Keep
	private void setIndexTrainingData(int index, int label, float[] data){
		mTrainingData.setIndexLabelData(index, label);
		mTrainingData.setIndexData(index, data);
	}
	//@Keep
	private int getTrainingDataSize(){
		return mTrainingData.getNumOfData();
	}
	//@Keep
	private float[] getIndexTrainingData(int index){
		return mTrainingData.getIndexData(index);
	}
	//@Keep
	private int getIndexTrainingLabelData(int index){
		return mTrainingData.getIndexLabelData(index);
	}



	// Java Native Interface methods ===============================================================
	private native byte[] jniCreateModel();
	private native byte[] jniUpdateModel();

	private native void jniLoadModel(byte[] binaryData);
	private native byte[] jniTrainModel();

	private native int jniLoadTrainingData();
	private native void jniGetTraingData(int startIndex, int endIndex);
	private native void jniSetTrainingData(float[] data, int[] labels, int numOfData, int dataSize);
}
