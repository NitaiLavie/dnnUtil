package dnnUtil.dnnMessage;

import dnnUtil.dnnModel.DnnModelDescriptor;

public class DnnValidationMessage extends DnnMessage {
	static final long serialVersionUID = 1L;
	private DnnModelDescriptor mMessageContent;
	
	public DnnValidationMessage(String senderName, DnnModelDescriptor messageContent){
		mMessageType = MessageType.MODELVALIDATION;
		mMessageContent = messageContent;
		mSenderName = senderName;
	}
	
	@Override
	public DnnModelDescriptor getContent() {
		return mMessageContent;
	}

}






