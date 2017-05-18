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
    private ArrayList<String> mLabels;
    private ArrayList<Integer> mLabelsData;
    private ArrayList<Float> mData;

    public DnnTrainingData(int numOfLabels, int numOfData, int sizeOfData){
        mNumOfData = numOfData;
        mSizeOfData = sizeOfData;
        mNumOfLabels = numOfLabels;
        mLabels = new ArrayList<>();
        mLabelsData = new ArrayList<>(); // label_t
        mData = new ArrayList<>(); // vec_t
    }

    protected void setLabels(String[] labels){
        mLabels = (ArrayList<String>) Arrays.asList(labels);
    }
    protected void setLabelsData(int[] labelsData){
        Integer[] tmp = ArrayUtils.toObject(labelsData);
        mLabelsData = (ArrayList<Integer>) Arrays.asList(tmp);
    }
    protected void setData(float[] data){
        Float[] tmp = ArrayUtils.toObject(data);
        mData = (ArrayList<Float>) Arrays.asList(tmp);
    }

    public String[] getLabels(){
        return mLabels.toArray(new String[mLabels.size()]);
    }
    public int[] getLabelsData(){
        Integer[] tmp = mLabelsData.toArray(new Integer[mLabelsData.size()]);
        return ArrayUtils.toPrimitive(tmp);
    }
    public float[] getData(){
        Float[] tmp = mData.toArray(new Float[mData.size()]);
        return ArrayUtils.toPrimitive(tmp);
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
