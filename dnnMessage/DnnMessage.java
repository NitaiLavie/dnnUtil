package dnnUtil.dnnMessage;

import java.io.Serializable;

public abstract class DnnMessage implements Serializable {
	static final long serialVersionUID = 2L;
	// defines the message type
	public static enum MessageType{
		MODEL, WEIGHTS, TEST, STRING, STATISTICS, READY, HELLO, TRAININGDATA 
	}
	
	protected String mSenderName;
	
	protected MessageType mMessageType;
	
	//@returns the type of the message
	public MessageType getMessageType(){
		return this.mMessageType;
	}
	
	//@returns the content of the message
	public abstract Object getContent();
	
	public String getSenderName(){
		return mSenderName;
	}
}
