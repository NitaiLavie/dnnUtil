package dnnUtil.dnnModel;

import java.io.Serializable;

public class DnnBundle implements Serializable {
	static final long serialVersionUID = 1L;
	
	private DnnModelDescriptor mModelDescriptor;
	private DnnIndex mIndexData;
	
	public DnnBundle(DnnModelDescriptor modelDescriptor ,DnnIndex indexData){
		setModel(modelDescriptor);
		setIndexData(indexData);		
	}
	public DnnModelDescriptor getModelDescriptor() {
		return mModelDescriptor;
	}

	public void setModel(DnnModelDescriptor modelDescriptor) {
		this.mModelDescriptor = modelDescriptor;
	}

	public DnnIndex getIndexData() {
		return mIndexData;
	}

	public void setIndexData(DnnIndex indexData) {
		this.mIndexData = indexData;
	}

}
