package dnnUtil.dnnStatistics;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class DnnStatistics implements Serializable {
	static final long serialVersionUID = 5L;

	private Map<String,String> mStats;
	private String mClientName;
	private String mTask;
	private Long mStartTrainingTime = (long)0; // in milliseconds since epoch time
	private Long mFinishTrainingTime = (long)0; // in milliseconds since epoch time
	private String mDeviceName;
	private String mMemoryFootprint;
	private Integer mNumberOfTrainedEpochs = 0;
	private Integer mModelNumber = 0;
	private Integer mServerInteractionCount = 0;
	private Boolean mIsCharging = false;
	private Float mStartBatteryLevel;
	private Float mFinishBatteryLevel;
	
	public DnnStatistics(){
		mStats = new LinkedHashMap<>();
	}

	public String getClientName() {
		return mClientName;
	}
	public void setClientName(String mClientName) {
		this.mClientName = mClientName;
	}
	public String getTask(){
		return mTask;
	}
	public void setTask(String task){
		this.mTask = task;
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
	public boolean getIsCharging(){
		return mIsCharging;
	}
	public void setIsChargin(boolean isCharging){
		this.mIsCharging = isCharging;
	}
	public float getStartBatteryLevel(){
		return mStartBatteryLevel;
	}
	public void setStartBatteryLevel(float startBatteryLevel){
		this.mStartBatteryLevel = startBatteryLevel;
	}
	public float getFinishBatteryLevel(){
		return mFinishBatteryLevel;
	}
	public void setFinishBatteryLevel(float finishBatteryLevel){
		this.mFinishBatteryLevel = finishBatteryLevel;
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
		mStats.put("Task",mTask);
		mStats.put("Device_Name", mDeviceName);
		mStats.put("Model_Number", mModelNumber.toString());
		mStats.put("Start_Training_Time", mStartTrainingTime.toString());
		mStats.put("Finish_Training_Time", mFinishTrainingTime.toString());
		mStats.put("Number_Of_Trained_Epochs",mNumberOfTrainedEpochs.toString());
		mStats.put("Memory_Footprint",mMemoryFootprint);
		mStats.put("Server_Interaction_Count", mServerInteractionCount.toString());
		mStats.put("Is_Charging", mIsCharging.toString());
		mStats.put("Start_Battery_Level", mStartBatteryLevel.toString());
		mStats.put("Finish_Battery_Level", mFinishBatteryLevel.toString());
		
	}
	
}
