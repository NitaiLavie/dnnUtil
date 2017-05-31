package dnnUtil.dnnModel;

public class DnnTrainingIndex {
	private Integer mDataSize;		
	private String mDataType;		// either train, validate OR test
	private Integer mDataIndex;
	private String mDataSet;		// mnist OR cifar10
	
	public DnnTrainingIndex(Integer dataSize, String dataType, Integer dataIndex, String dataSet) {
		setDataSize(dataSize);
		setDataType(dataType);
		setDataIndex(dataIndex);
		setDataSet(dataSet);
	}

	public Integer getDataSize() {
		return mDataSize;
	}

	public void setDataSize(Integer mDataSize) {
		this.mDataSize = mDataSize;
	}

	public String getDataType() {
		return mDataType;
	}

	public void setDataType(String mDataType) {
		this.mDataType = mDataType;
	}

	public Integer getDataIndex() {
		return mDataIndex;
	}

	public void setDataIndex(Integer mDataIndex) {
		this.mDataIndex = mDataIndex;
	}

	public String getDataSet() {
		return mDataSet;
	}

	public void setDataSet(String mDataSet) {
		this.mDataSet = mDataSet;
	}

}
