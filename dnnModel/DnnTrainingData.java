package dnnUtil.dnnModel;

import java.io.Serializable;

/**
 * Created by nitai on 15/04/17.
 */

public class DnnTrainingData implements Serializable {
    static final long serialVersionUID = 2L;

    Integer mNumOfData;
    Integer mSizeOfData;
    Integer mNumOfLabels;
    private String[] mLabels;
    private Integer[] mLabelsData;
    private Float[] mData;

    public DnnTrainingData(int numOfLabels, int numOfData, int sizeOfData){
        mNumOfData = numOfData;
        mSizeOfData = sizeOfData;
        mNumOfLabels = numOfLabels;
    }

    protected void setLabels(String[] labels){
        mLabels = labels;
    }
    protected void setLabelsData(int[] labelsData){
        mLabelsData = new Integer[labelsData.length];
        for(int i=0; i<labelsData.length; i++){
            mLabelsData[i] = labelsData[i];
        }
    }
    protected void setData(float[] data){
        mData = new Float[data.length];
        for(int i=0; i<data.length; i++){
            mData[i] = data[i];
        }
    }

    public String[] getLabels(){
        return mLabels;
    }
    public int[] getLabelsData(){
        int[] labels = new int[mLabelsData.length];
        for(int i=0; i<mLabelsData.length; i++){
            labels[i] = mLabelsData[i];
        }
        return labels;
    }
    public float[] getData(){
        float[] data = new float[mLabelsData.length];
        for(int i=0; i<mData.length; i++){
            data[i] = mData[i];
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
