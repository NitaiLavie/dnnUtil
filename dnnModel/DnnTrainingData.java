package dnnUtil.dnnModel;

import java.io.Serializable;

/**
 * Created by nitai on 15/04/17.
 */

public class DnnTrainingData implements Serializable {
    static final long serialVersionUID = 1L;

    //TODO: changel primitie types if we want to send this object as serialized
    private String[] mLabels;
    private int[] mLabelsData;
    private float[][] mData;

    public DnnTrainingData(int numOfLabels, int numOfData){
        mLabels = new String[numOfLabels];
        mLabelsData = new int[numOfData]; // label_t
        mData = new float[numOfData][]; // vec_t
    }

    protected void setLabels(String[] labels){
        mLabels = labels;
    }
    protected void setLabelsData(int[] labelsData){
        mLabelsData = labelsData;
    }
    protected void setData(float[][] data){
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

    protected void setIndexLabel(int index, String label){
        mLabels[index] = label;
    }
    protected void setIndexLabelData(int index, int labelData){
        mLabelsData[index] = labelData;
    }
    protected void setIndexData(int index, float[] data){
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
