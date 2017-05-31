package dnnUtil.dnnMessage;

import dnnUtil.dnnModel.DnnBundle;

public class DnnTrainMessage extends DnnMessage {
	private static final long serialVersionUID = 1L;
	
	private DnnBundle mMessageContent;

	public DnnTrainMessage(DnnBundle trainingPackage) {
		mMessageContent =trainingPackage;
		mMessageType = MessageType.TRAIN;
	}
	
	@Override
	public DnnBundle getContent() {
		return mMessageContent;
	}

}
