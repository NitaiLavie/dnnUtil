package dnnUtil.dnnModel;

import java.io.Serializable;

public class DnnTrainingPackage implements Serializable {
	static final long serialVersionUID = 1L;
	
	private DnnModel mModel;
	private DnnTrainingDescriptor mTrainingDescriptor;
	
	public DnnTrainingPackage(DnnModel model,DnnTrainingDescriptor trainingDescriptor){
		setModel(model);
		setTrainingDescriptor(trainingDescriptor);
		
	}

	public DnnModel getModel() {
		return mModel;
	}

	public void setModel(DnnModel mModel) {
		this.mModel = mModel;
	}

	public DnnTrainingDescriptor getTrainingDescriptor() {
		return mTrainingDescriptor;
	}

	public void setTrainingDescriptor(DnnTrainingDescriptor mTrainingDescriptor) {
		this.mTrainingDescriptor = mTrainingDescriptor;
	}

}
