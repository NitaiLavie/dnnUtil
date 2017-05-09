package dnnUtil.dnnMessage;

/**
 * Created by nitai on 09/05/17.
 */

public class DnnReadyMessage extends DnnMessage{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String mMessageContent;

    public DnnReadyMessage(String senderName, String messageContent){
        mMessageContent = messageContent;
        mMessageType = MessageType.READY;
        mSenderName = senderName;
    }
    @Override
    public String getContent() {

        return mMessageContent;
    }



}