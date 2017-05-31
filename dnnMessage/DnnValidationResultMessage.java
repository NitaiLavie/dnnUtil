package dnnUtil.dnnMessage;

import dnnUtil.dnnStatistics.DnnValidationResult;

public class DnnValidationResultMessage extends DnnMessage {
	static final long serialVersionUID = 1L;
	
	private DnnValidationResult mMessageContent;
	
	public DnnValidationResultMessage(String senderName, DnnValidationResult result) {
			mMessageContent = result;
			mSenderName = senderName;
			mMessageType = MessageType.VALIDATIONRESULT;
	}
		
	@Override
	public DnnValidationResult getContent() {
		return mMessageContent;
	}

}
