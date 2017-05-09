package dnnUtil.dnnMessage;

import dnnUtil.dnnModel.DnnTrainingData;

public class DnnTrainingDataMessage extends DnnMessage {

	private static final long serialVersionUID = 1L;
	
	private DnnTrainingData mMessageContent;
	
	public DnnTrainingDataMessage(DnnTrainingData dnnTrainingData) {
		mMessageContent = dnnTrainingData;
		mMessageType = MessageType.TRAININGDATA;
	}

	@Override
	public DnnTrainingData getContent() {
		return mMessageContent;
	}

}
