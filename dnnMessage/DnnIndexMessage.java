package dnnUtil.dnnMessage;

import dnnUtil.dnnModel.DnnTrainingIndex;

public class DnnIndexMessage extends DnnMessage {
	private static final long serialVersionUID = 1L;
	
	private DnnTrainingIndex mMessageContent;

	public DnnIndexMessage(DnnTrainingIndex trainingIndex) {
		mMessageContent =trainingIndex;
		mMessageType = MessageType.INDEX;
	}
	
	@Override
	public DnnTrainingIndex getContent() {
		return mMessageContent;
	}

}
