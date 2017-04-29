package dnnUtil.dnnModel;

import java.io.Serializable;

public class DnnTrainingPackage implements Serializable {
	static final long serialVersionUID = 1L;
	
	private DnnModelDescriptor mModelDescriptor;
	private DnnTrainingData mTrainingData;
	
	public DnnTrainingPackage(DnnModelDescriptor modelDescriptor,DnnTrainingData trainingData){
		setModel(modelDescriptor);
		setTrainingData(trainingData);
		
	}

	public DnnModelDescriptor getModelDescriptor() {
		return mModelDescriptor;
	}

	public void setModel(DnnModelDescriptor modelDescriptor) {
		this.mModelDescriptor = modelDescriptor;
	}

	public DnnTrainingData getTrainingData() {
		return mTrainingData;
	}

	public void setTrainingData(DnnTrainingData trainingData) {
		this.mTrainingData = trainingData;
	}

}
