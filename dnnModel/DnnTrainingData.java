package dnnUtil.dnnModel;

import java.io.Serializable;

/**
 * Created by nitai on 15/04/17.
 */

public class DnnTrainingData implements Serializable {
    static final long serialVersionUID = 1L;

    private String[] mLabels;
    private int[] mLabelsData;
    private float[][] mData;

    public DnnTrainingData(int numOfLabels, int numOfData){
        mLabels = new String[numOfLabels];
        mLabelsData = new int[numOfData]; // label_t
        mData = new float[numOfData][]; // vec_t
    }

    public void setLabels(String[] labels){
        mLabels = labels;
    }
    public void setLabelsData(int[] labelsData){
        mLabelsData = labelsData;
    }
    public void setData(float[][] data){
        mData = data;
    }

    public String[] getLabels(){
        return mLabels;
    }
    public int[] getLabelsData(){
        return mLabelsData;
    }
    public float[][] getData(){
        return mData;
    }

    public void setIndexLabel(int index, String label){
        mLabels[index] = label;
    }
    public void setIndexLabelData(int index, int labelData){
        mLabelsData[index] = labelData;
    }
    public void setIndexData(int index, float[] data){
        mData[index] = data;
    }

    public String getIndexLabel(int index){
        return mLabels[index];
    }
    public int getIndexLabelData(int index){
        return mLabelsData[index];
    }
    public float[] getIndexData(int index){
        return mData[index];
    }

    public int getSize(){
        return mLabelsData.length;
    }

}
