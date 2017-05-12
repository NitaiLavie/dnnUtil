package dnnUtil.dnnTimer;

/**
 * Created by nitai on 12/05/17.
 */

public class DnnTimer {
    /**
     * measures time passed between start and stop in milliseconds in milliseconds
     * when start measuring sets time to 0
     */
    long mStartTime;
    long mStopTime;
    long mTime;

    public DnnTimer(){
        mStartTime = 0;
        mStopTime = 0;
        mTime = 0;
    }

    public void start(){
        mTime = 0;
        mStartTime = System.currentTimeMillis();
    }

    public void stop(){
        mStopTime = System.currentTimeMillis();
        mTime = mStopTime - mStartTime;
    }

    public long getTime(){
        return mTime;
    }
}
