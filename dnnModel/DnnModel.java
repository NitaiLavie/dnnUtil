package dnnUtil.dnnModel;

import android.support.annotation.Keep;

public class DnnModel {

	// DnnModel members
	private DnnModelDescriptor mModelDescriptor;

	// DnnModel constructors
	public DnnModel(DnnModelParameters modelParameters){
		//Todo: add constructor behaviour
	}

	public DnnModel(DnnModelDescriptor modelDescriptor){
		mModelDescriptor = modelDescriptor;
		//Todo: add constructor behaviour
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

	//

	// Java Native Interface methods
	private native byte[] jniCreateModel();
	private native byte[] jniUpdateModel();
	private native void jniLoadModel(byte[] binaryData);
	private native byte[] jniTrainModel();

}
