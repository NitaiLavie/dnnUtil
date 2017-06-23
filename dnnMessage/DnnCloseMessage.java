package dnnUtil.dnnMessage;

public class DnnCloseMessage extends DnnMessage {
	private static final long serialVersionUID = 1L;
	
	private String mMessageContent;
	public DnnCloseMessage(String senderName, String messageContent) {
		mMessageContent = messageContent;
		mMessageType = MessageType.CLOSE;
		mSenderName = senderName;
	}
	
	@Override
	public String getContent() {
		return mMessageContent;
	}

}
