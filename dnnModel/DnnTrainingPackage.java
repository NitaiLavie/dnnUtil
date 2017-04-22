package dnnUtil.dnnModel;

import java.io.Serializable;

public class DnnTrainingPackage implements Serializable {
	static final long serialVersionUID = 1L;
	
	private DnnModelDescriptor mModelDescriptor;
	private DnnTrainingDescriptor mTrainingDescriptor;
	
	public DnnTrainingPackage(DnnModel model,DnnTrainingDescriptor trainingDescriptor){
		setModel(model);
		setTrainingDescriptor(trainingDescriptor);
		
	}

	public DnnModelDescriptor getModelDescriptor() {
		return mModelDescriptor;
	}

	public void setModel(DnnModel mModel) {
		this.mModelDescriptor = mModelDescriptor;
	}

	public DnnTrainingDescriptor getTrainingDescriptor() {
		return mTrainingDescriptor;
	}

	public void setTrainingDescriptor(DnnTrainingDescriptor mTrainingDescriptor) {
		this.mTrainingDescriptor = mTrainingDescriptor;
	}

}
