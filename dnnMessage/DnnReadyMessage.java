package dnnUtil.dnnMessage;

/**
 * Created by nitai on 09/05/17.
 */

public class DnnReadyMessage extends DnnMessage{

    /**
     * Signals the Dnn server that the client is ready with the attached model version
     */
    private static final long serialVersionUID = 2L;
    private Integer mMessageContent;

    public DnnReadyMessage(String senderName, Integer messageContent){
        mMessageContent = messageContent; // model version
        mMessageType = MessageType.READY;
        mSenderName = senderName;
    }
    @Override
    public Integer getContent() {

        return mMessageContent;
    }



}