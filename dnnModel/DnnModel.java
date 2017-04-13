package dnnUtil.dnnModel;

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
		jniCreateModel();
	}
	private void loadModel(DnnModelDescriptor modelDescriptor){
		jniLoadModel();
	}
	public void updateModel(DnnModelDelta modelDelta){
		jniUpdateModel();
	}
	public void trainModel(){
		jniTrainModel();
	}

	//

	// Java Native Interface methods
	private native void jniCreateModel();
	private native void jniUpdateModel();
	private native void jniLoadModel();
	private native void jniTrainModel();

}
