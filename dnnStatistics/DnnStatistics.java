package dnnUtil.dnnStatistics;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class DnnStatistics implements Serializable {
	static final long serialVersionUID = 4L;

	private Map<String,String> mStats;
	private String mClientName;
	private Long mStartTrainingTime = (long)0; // in milliseconds since epoch time
	private Long mFinishTrainingTime = (long)0; // in milliseconds since epoch time
	private String mDeviceName;
	private String mMemoryFootprint;
	private Integer mNumberOfTrainedEpochs = 0;
	private String mSuccesRate;
	private Integer mModelNumber = 0;
	private Integer mServerInteractionCount = 0;
	
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
	public String getStatisticsCSVHeader(){
		String csvHeader ="";
		for (Map.Entry<String, String> statKey: mStats.entrySet()) {
			csvHeader += statKey.getKey() + ",";
		}
		csvHeader += "\n";
		return csvHeader;
	}
	
	public String getStatisticsInCSV(){
		updateStatsMap();
		String statsCSV="";
		for (Map.Entry<String, String> statKey: mStats.entrySet()) {
			if(statKey.getValue() != null){
				statsCSV += statKey.getValue() + ",";
			}else{
				statsCSV += ",";
			}
		}
		statsCSV += "\n";
		return statsCSV;
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
		mStats.put("Client_Name", mClientName);
		mStats.put("Device_Name", mDeviceName);
		mStats.put("Model_Number", mModelNumber.toString());
		mStats.put("Start_Training_Time", mStartTrainingTime.toString());
		mStats.put("Finish_Training_Time", mFinishTrainingTime.toString());
		mStats.put("Number_Of_Trained_Epochs",mNumberOfTrainedEpochs.toString());
		mStats.put("Memory_Footprint",mMemoryFootprint);
		mStats.put("Succes_Rate", mSuccesRate);
		mStats.put("Server_Interaction_Count", new Integer(mServerInteractionCount).toString());		
		
	}
	
}
