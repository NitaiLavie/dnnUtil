package dnnUtil.dnnMessage;

import dnnUtil.dnnModel.DnnModelDescriptor;

public class DnnModelMessage extends DnnMessage{
	static final long serialVersionUID = 1L;

	private DnnModelDescriptor mMessageContent;

	public DnnModelMessage(String senderName, DnnModelDescriptor messageContent){
		mMessageType = MessageType.MODEL;
		mMessageContent = messageContent;
		mSenderName = senderName;
	}

	@Override
	public DnnModelDescriptor getContent() {
		return mMessageContent;
	}
}




