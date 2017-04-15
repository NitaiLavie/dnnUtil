package dnnUtil.dnnStatistics;

import java.util.LinkedHashMap;
import java.util.Map;

public class DnnStatistics {

	private Map<String,String> mStats;
	private String mClientName;
	private String mStartTrainingTime;
	private String mFinishTrainingTime;
	private String mDeviceName;
	private String mMemoryFootprint;
	private String mNumberOfTrainedEpochs;
	private String mSuccesRate;
	private String mModelNumber;
	private int mServerInteractionCount;
	
	public DnnStatistics(){
		mStats = new LinkedHashMap<>();
		
	}
	public String getClientName() {
		return mClientName;
	}
	public void setClientName(String mClientName) {
		this.mClientName = mClientName;
	}
	public String getStartTrainingTime() {
		return mStartTrainingTime;
	}
	public void setStartTrainingTime(String mStartTrainingTime) {
		this.mStartTrainingTime = mStartTrainingTime;
	}
	public String getFinishTrainingTime() {
		return mFinishTrainingTime;
	}
	public void setFinishTrainingTime(String mFinishTrainingTime) {
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
	public String getNumberOfTrainedEpochs() {
		return mNumberOfTrainedEpochs;
	}
	public void setNumberOfTrainedEpochs(String mNumberOfTrainedEpochs) {
		this.mNumberOfTrainedEpochs = mNumberOfTrainedEpochs;
	}
	public String getSuccesRate() {
		return mSuccesRate;
	}
	public void setSuccesRate(String mSuccesRate) {
		this.mSuccesRate = mSuccesRate;
	}
	public String getModelNumber() {
		return mModelNumber;
	}
	public void setModelNumber(String mModelNumber) {
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
		mStats.put("Model Number", mModelNumber);
		mStats.put("Start Training Time", mStartTrainingTime);
		mStats.put("Finish Training Time", mFinishTrainingTime);
		mStats.put("Number Of Trained Epochs",mNumberOfTrainedEpochs);
		mStats.put("Memory Footprint",mMemoryFootprint);
		mStats.put("Succes Rate", mSuccesRate);
		mStats.put("Server Interaction Count", new Integer(mServerInteractionCount).toString());		
		
	}
	
}
