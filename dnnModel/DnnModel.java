package dnnUtil.dnnModel;

import java.util.HashMap;
import java.util.Map;

public class DnnModel {

	private static enum W_Type {
		WEIGHT, BIAS
	}

	// DnnModel members
	private DnnModelDescriptor mModelDescriptor;
	private DnnTrainingData mTrainingData;
	private Map<Integer,Map<W_Type,float[]>> mWeightsData;

	// DnnModel constructors
	public DnnModel(DnnModelParameters modelParameters){
		mWeightsData = new HashMap<>();
		createModel(modelParameters);
	}

	public DnnModel(DnnModelDescriptor modelDescriptor){
		mWeightsData = new HashMap<>();
		mModelDescriptor = modelDescriptor;
		loadModel(mModelDescriptor);
	}

	// DnnModel Methods
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
	public void loadTrainingData(){
		jniLoadTrainingData();
	}
	public DnnTrainingData getTrainingData(DnnTrainingDescriptor trainingDescriptor){
		//Todo: add implementation
		return null;
	}

	// Java Native Interface callback methods
	private void setLayerWeights(float[] weights, int layerIndex){
		if(!mWeightsData.containsKey(layerIndex)){
			mWeightsData.put(layerIndex,new HashMap<W_Type,float[]>());
		}
		mWeightsData.get(layerIndex).put(W_Type.WEIGHT,weights);
	}
	private void setLayerBiases(float[] biases, int layerIndex){
		if(!mWeightsData.containsKey(layerIndex)){
			mWeightsData.put(layerIndex,new HashMap<W_Type,float[]>());
		}
		mWeightsData.get(layerIndex).put(W_Type.BIAS,biases);
	}
	private float[] getLayerWeights(int layerIndex){
		if(!mWeightsData.containsKey(layerIndex)){
			// in case the layer doesn't exist will create it and return null
			mWeightsData.put(layerIndex,new HashMap<W_Type,float[]>());
			mWeightsData.get(layerIndex).put(W_Type.WEIGHT,null);
		}
		return mWeightsData.get(layerIndex).get(W_Type.WEIGHT);
	}
	private float[] getLayerBiases(int layerIndex){
		if(!mWeightsData.containsKey(layerIndex)){
			// in case the layer doesn't exist will create it and return null
			mWeightsData.put(layerIndex,new HashMap<W_Type,float[]>());
			mWeightsData.get(layerIndex).put(W_Type.BIAS,null);
		}
		return mWeightsData.get(layerIndex).get(W_Type.BIAS);
	}

	private void setTrainingData(){
		//Todo: fill in
	}


	// Java Native Interface methods
	private native byte[] jniCreateModel();
	private native byte[] jniUpdateModel();

	private native void jniLoadModel(byte[] binaryData);
	private native byte[] jniTrainModel();

	private native void jniLoadTrainingData();
}
