package dnnUtil.dnnMessage;

import dnnUtil.dnnModel.DnnTrainingPackage;

public class DnnTrainingPackageMessage extends DnnMessage {

	private static final long serialVersionUID = 1L;
	
	private DnnTrainingPackage mMessageContent;
	
	public DnnTrainingPackageMessage(DnnTrainingPackage trainingPackage) {
		mMessageContent = trainingPackage;
		mMessageType = MessageType.TRAININGPACKAGE;
	}

	@Override
	public DnnTrainingPackage getContent() {
		return mMessageContent;
	}

}
