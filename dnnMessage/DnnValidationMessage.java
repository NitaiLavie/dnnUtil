package dnnUtil.dnnMessage;

import dnnUtil.dnnModel.DnnBundle;

public class DnnValidationMessage extends DnnMessage {
	static final long serialVersionUID = 1L;
	private DnnBundle mMessageContent;
	
	public DnnValidationMessage(String senderName, DnnBundle messageContent){
		mMessageType = MessageType.VALIDATE;
		mMessageContent = messageContent;
		mSenderName = senderName;
	}
	
	@Override
	public DnnBundle getContent() {
		return mMessageContent;
	}

}






