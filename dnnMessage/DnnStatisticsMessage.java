package dnnUtil.dnnMessage;

import dnnUtil.dnnStatistics.DnnStatistics;

public class DnnStatisticsMessage extends DnnMessage {
	static final long serialVersionUID = 1L;
	
	private DnnStatistics mMessageContent;
	
	public  DnnStatisticsMessage(String senderName, DnnStatistics messageContent) {
		mMessageType = MessageType.STATISTICS;
		mMessageContent = messageContent;
		mSenderName = senderName;
	}
	@Override
	public DnnStatistics getContent() {
		return mMessageContent;
	}

}
