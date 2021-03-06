package dnnUtil.dnnModel;

import java.io.Serializable;

public class DnnTrainingDescriptor implements Serializable{
	static final long serialVersionUID = 1L;

	private Integer mBeginning;
	private Integer mEnd;

	public DnnTrainingDescriptor(int beginning, int end){
		setBeginning(beginning);
		setEnd(end);
	}
	public int getBeginning() {
		return mBeginning;
	}
	private void setBeginning(int mBeginning) {
		this.mBeginning = mBeginning;
	}
	public int getEnd() {
		return mEnd;
	}
	private void setEnd(int mEnd) {
		this.mEnd = mEnd;
	}

}
