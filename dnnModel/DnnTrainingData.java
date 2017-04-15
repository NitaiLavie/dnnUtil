package dnnUtil.dnnModel;

/**
 * Created by nitai on 15/04/17.
 */

public class DnnTrainingData {

    private String[] mLabels;
    private byte[] mLabelsData;
    private byte[][] mData;

    public DnnTrainingData(){

    }

    void setLabels(String[] labels){
        mLabels = labels;
    }
    void setLabelsData(byte[] labelsData){
        mLabelsData = labelsData;
    }
    void setData(byte[][] data){
        mData = data;
    }

    String[] getLabels(){
        return mLabels;
    }
    byte[] getLabelsData(){
        return mLabelsData;
    }
    byte[][] getData(){
        return mData;
    }

}
