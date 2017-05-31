package dnnUtil.dnnMessage;

import dnnUtil.dnnModel.DnnIndex;

public class DnnValidateMessage extends DnnMessage {
	private static final long serialVersionUID = 1L;
	
	private DnnIndex mMessageContent;

	public DnnValidateMessage(DnnIndex trainingIndex) {
		mMessageContent =trainingIndex;
		mMessageType = MessageType.VALIDATE;
	}
	
	@Override
	public DnnIndex getContent() {
		return mMessageContent;
	}

}
