package dnnUtil.dnnModel;

import java.io.Serializable;
import java.nio.ByteBuffer;

/**
 * Created by nitai on 13/04/17.
 */

public class DnnModelDescriptor implements Serializable {
    static final long serialVersionUID = 1L;

    private byte[] mBinaryData;
    public DnnModelDescriptor(byte[] binaryData){
        mBinaryData = binaryData;
    }
    public void setBinaryData(byte[] binaryData){
        mBinaryData = binaryData;
    }
    public byte[] getBinaryData(){
        return mBinaryData;
    }
}
