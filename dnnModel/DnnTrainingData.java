package dnnUtil.dnnModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.lang3.ArrayUtils;

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
        mLabelsData = ArrayUtils.toObject(labelsData);
    }
    protected void setData(float[] data){
        mData = ArrayUtils.toObject(data);
    }

    public String[] getLabels(){
        return mLabels;
    }
    public int[] getLabelsData(){
        return ArrayUtils.toPrimitive(mLabelsData);
    }
    public float[] getData(){
        return ArrayUtils.toPrimitive(mData);
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
