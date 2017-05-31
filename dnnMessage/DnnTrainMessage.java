package dnnUtil.dnnMessage;

import dnnUtil.dnnModel.DnnIndex;

public class DnnTrainMessage extends DnnMessage {
	private static final long serialVersionUID = 1L;
	
	private DnnIndex mMessageContent;

	public DnnTrainMessage(DnnIndex trainingIndex) {
		mMessageContent =trainingIndex;
		mMessageType = MessageType.TRAIN;
	}
	
	@Override
	public DnnIndex getContent() {
		return mMessageContent;
	}

}
