package dnnUtil.dnnModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by nitai on 15/04/17.
 */

public class DnnTrainingData implements Serializable {
    static final long serialVersionUID = 1L;

    //TODO: changel primitie types if we want to send this object as serialized
    private HashMap<Integer, String> mLabels;
    Integer mNumOfData;
    Integer mSizeOfData;
    Integer mNumOfLabels;
    private ArrayList<Integer> mLabelsData;
    private ArrayList<ArrayList<Float>> mData;

    public DnnTrainingData(int numOfLabels, int numOfData, int sizeOfData){
        mNumOfData = numOfData;
        mSizeOfData = sizeOfData;
        mNumOfLabels = numOfLabels;
        mLabels = new HashMap<>();
        mLabelsData = new ArrayList<>(); // label_t
        mData = new ArrayList<>(); // vec_t
    }

    protected void setLabels(String[] labels){
        for(int i=0; i< labels.length; i++){
            mLabels.put(i,labels[i]);
        }
    }
    protected void setLabelsData(int[] labelsData){
        for(int i=0; i< labelsData.length; i++){
            mLabelsData.add(labelsData[i]);
        }
    }
    protected void setData(float[][] data){
        for(int i = 0; i<data.length; i++){
            mData.add(new ArrayList<Float>());
            for(int j = 0; j < data[i].length; j++){
                mData.get(i).add(data[i][j]);
            }
        }
    }

    public String[] getLabels(){
        String[] labels = new String[mLabels.keySet().size()];
        for(int i=0; i< labels.length; i++){
            labels[i] = mLabels.get(i);
        }
        return labels;
    }
    public int[] getLabelsData(){
        int[] labelsData = new int[mLabelsData.size()];
        for(int i=0; i< labelsData.length; i++){
            labelsData[i] = mLabelsData.get(i);
        }
        return labelsData;
    }
    public float[][] getData(){
        float[][] data = new float[mData.size()][mData.get(0).size()];
        for(int i = 0; i<data.length; i++){
            for(int j = 0; j < data[i].length; j++){
                data[i][j] = mData.get(i).get(j);
            }
        }
        return data;
    }

    protected void setIndexLabel(int index, String label){
        mLabels.put(index, label);
    }
    protected void setIndexLabelData(int index, int labelData){
        mLabelsData.add(index, labelData);
    }
    protected void setIndexData(int index, float[] data){
        mData.add(index, new ArrayList<Float>());
        for(int j = 0; j < data.length; j++){
            mData.get(index).add(data[j]);
        }
    }

    public String getIndexLabel(int index){
        return mLabels.get(index);
    }
    public int getIndexLabelData(int index){
        return mLabelsData.get(index);
    }
    public float[] getIndexData(int index){
        float[] data = new float[mData.get(index).size()];
        for(int j = 0; j < data.length; j++){
            data[j] = mData.get(index).get(j);
        }
        return data;
    }

    public int getNumOfData(){
        return mNumOfData;
    }
    public int getNumOfLabels(){
        return mNumOfLabels;
    }
    public int getSizeOfData(){
        return mSizeOfData;
    }

}
