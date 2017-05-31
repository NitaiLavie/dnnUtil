package dnnUtil.dnnStatistics;

import java.io.Serializable;

public class DnnValidationResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final Float mAccuracy;
	private final Integer mModelVersion;
	
	public DnnValidationResult(Integer modelVersion, Float accuracy){
		mModelVersion = modelVersion;
		mAccuracy = accuracy;
	}
	
	public Integer getModelVersion(){
		return mModelVersion;
	}
	public Float getAccuracy(){
		return mAccuracy;
	}
	

}
