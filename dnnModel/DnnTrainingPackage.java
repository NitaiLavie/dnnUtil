package dnnUtil.dnnModel;

import java.io.Serializable;

public class DnnTrainingPackage implements Serializable {
	static final long serialVersionUID = 1L;
	
	private DnnModelDescriptor mModelDescriptor;
	private DnnTrainingDescriptor mTrainingDescriptor;
	
	public DnnTrainingPackage(DnnModelDescriptor modelDescriptor,DnnTrainingDescriptor trainingDescriptor){
		setModel(modelDescriptor);
		setTrainingDescriptor(trainingDescriptor);
		
	}

	public DnnModelDescriptor getModelDescriptor() {
		return mModelDescriptor;
	}

	public void setModel(DnnModelDescriptor modelDescriptor) {
		this.mModelDescriptor = modelDescriptor;
	}

	public DnnTrainingDescriptor getTrainingDescriptor() {
		return mTrainingDescriptor;
	}

	public void setTrainingDescriptor(DnnTrainingDescriptor trainingDescriptor) {
		this.mTrainingDescriptor = trainingDescriptor;
	}

}
