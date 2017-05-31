package dnnUtil.dnnMessage;

import dnnUtil.dnnModel.DnnDeltaData;

public class DnnDeltaMessage extends DnnMessage {
	private static final long serialVersionUID = 1L;
	
	private DnnDeltaData mMessageContent;
	
	public DnnDeltaMessage(DnnDeltaData delta) {
		mMessageContent = delta;
		mMessageType = MessageType.DELTA;
	}
	@Override
	public DnnDeltaData getContent() {
		return mMessageContent;
	}

}
