package dnnUtil.dnnMessage;

import dnnUtil.dnnModel.DnnWeightsData;

public class DnnWeightsMessage extends DnnMessage{
	
	private static final long serialVersionUID = 1L;
	
	public DnnWeightsMessage(String senderName, DnnWeightsData messageContent) {
		mMessageType = MessageType.WEIGHTS;
		mMessageContent = messageContent;
		mSenderName = senderName;
	}
	private DnnWeightsData mMessageContent;
	
	@Override
	public DnnWeightsData getContent() {
		return mMessageContent;
	}

}
