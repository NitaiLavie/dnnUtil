package dnnUtil.dnnStatistics;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class DnnStatistics implements Serializable {
	static final long serialVersionUID = 3L;

	private Map<String,String> mStats;
	private String mClientName;
	private Long mStartTrainingTime; // in milliseconds since epoch time
	private Long mFinishTrainingTime; // in milliseconds since epoch time
	private String mDeviceName;
	private String mMemoryFootprint;
	private Integer mNumberOfTrainedEpochs;
	private String mSuccesRate;
	private Integer mModelNumber;
	private Integer mServerInteractionCount;
	
	public DnnStatistics(){
		mStats = new LinkedHashMap<>();
		
	}
	public String getClientName() {
		return mClientName;
	}
	public void setClientName(String mClientName) {
		this.mClientName = mClientName;
	}
	public Long getStartTrainingTime() {
		return mStartTrainingTime;
	}
	public void setStartTrainingTime(Long mStartTrainingTime) {
		this.mStartTrainingTime = mStartTrainingTime;
	}
	public Long getFinishTrainingTime() {
		return mFinishTrainingTime;
	}
	public void setFinishTrainingTime(Long mFinishTrainingTime) {
		this.mFinishTrainingTime = mFinishTrainingTime;
	}
	public String getDeviceName() {
		return mDeviceName;
	}
	public void setDeviceName(String mDeviceName) {
		this.mDeviceName = mDeviceName;
	}
	public String getMemoryFootprint() {
		return mMemoryFootprint;
	}
	public void setMemoryFootprint(String mMemoryFootprint) {
		this.mMemoryFootprint = mMemoryFootprint;
	}
	public Integer getNumberOfTrainedEpochs() {
		return mNumberOfTrainedEpochs;
	}
	public void setNumberOfTrainedEpochs(Integer mNumberOfTrainedEpochs) {
		this.mNumberOfTrainedEpochs = mNumberOfTrainedEpochs;
	}
	public String getSuccesRate() {
		return mSuccesRate;
	}
	public void setSuccesRate(String mSuccesRate) {
		this.mSuccesRate = mSuccesRate;
	}
	public Integer getModelNumber() {
		return mModelNumber;
	}
	public void setModelNumber(Integer mModelNumber) {
		this.mModelNumber = mModelNumber;
	}
	public int getServerInteractionCount() {
		return mServerInteractionCount;
	}
	public void setServerInteractionCount(int mServerInteractionCount) {
		this.mServerInteractionCount = mServerInteractionCount;
	}

	public String getStatistics(){
		updateStatsMap();
		String stats ="";
		for (Map.Entry<String, String> statKey: mStats.entrySet()) {
			if(statKey.getValue() != null){
				stats += statKey.getKey() + ": " + statKey.getValue() + "\n";
			}
		}
		return stats;
	}
	public Map<String,String> getStats() {
		updateStatsMap();
		return mStats;
	}
	public void setStats(Map<String,String> mStats) {
		this.mStats = mStats;
	}
	private void updateStatsMap(){
		mStats.put("Client Name", mClientName);
		mStats.put("Device Name", mDeviceName);
		mStats.put("Model Number", mModelNumber.toString());
		mStats.put("Start Training Time", mStartTrainingTime.toString());
		mStats.put("Finish Training Time", mFinishTrainingTime.toString());
		mStats.put("Number Of Trained Epochs",mNumberOfTrainedEpochs.toString());
		mStats.put("Memory Footprint",mMemoryFootprint);
		mStats.put("Succes Rate", mSuccesRate);
		mStats.put("Server Interaction Count", new Integer(mServerInteractionCount).toString());		
		
	}
	
}
