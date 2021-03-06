package dnnUtil.dnnModel;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by nitai on 13/04/17.
 */

public class DnnModelDescriptor implements Serializable {
    static final long serialVersionUID = 1L;

    private Integer mModelVersion;
    private ArrayList<Byte> mBinaryData;

    public DnnModelDescriptor(byte[] binaryData, int modelVersion){
        mModelVersion = modelVersion;
        mBinaryData = new ArrayList<>();
        for(int i = 0; i < binaryData.length; i++){
            mBinaryData.add(binaryData[i]);
        }
    }
    public void setBinaryData(byte[] binaryData){
        for(int i = 0; i < binaryData.length; i++){
            mBinaryData.add(binaryData[i]);
        }
    }
    public byte[] getBinaryData(){
        byte[] binaryData = new byte[mBinaryData.size()];
        for(int i = 0; i < binaryData.length; i++){
            binaryData[i] = mBinaryData.get(i);
        }
        return binaryData;
    }
    public Integer getModelVersion(){
    	return mModelVersion;
    }
}
