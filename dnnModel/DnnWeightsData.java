package dnnUtil.dnnModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by nitai on 29/04/17.
 */

public class DnnWeightsData implements Serializable {
    static final long serialVersionUID = 1L;

    private enum W_Type {
        WEIGHT, BIAS
    }
    private class W_Vec extends ArrayList<Float>{}
    private class Layer_Weights extends HashMap<W_Type,W_Vec>{}
    private ArrayList<Layer_Weights> mWeightsData;

    public DnnWeightsData(){
        mWeightsData = new ArrayList<>();
    }

    public void setLayerWeights(float[] weights, int layerIndex){
        W_Vec vec = new W_Vec();
        for(int i = 0; i<weights.length; i++){
            vec.add(weights[i]);
        }

        Layer_Weights layer;
        try{
            layer = mWeightsData.get(layerIndex);
            layer.put(W_Type.WEIGHT, vec);
        } catch (IndexOutOfBoundsException e){
            layer = new Layer_Weights();
            layer.put(W_Type.WEIGHT, vec);
            mWeightsData.add(layerIndex,layer);
        }
    }
    public void setLayerBiases(float[] biases, int layerIndex){
        W_Vec vec = new W_Vec();
        for(int i = 0; i<biases.length; i++){
            vec.add(biases[i]);
        }

        Layer_Weights layer;
        try{
            layer = mWeightsData.get(layerIndex);
            layer.put(W_Type.BIAS, vec);
        } catch (IndexOutOfBoundsException e){
            layer = new Layer_Weights();
            layer.put(W_Type.BIAS, vec);
            mWeightsData.add(layerIndex,layer);
        }
    }
    public float[] getLayerWeights(int layerIndex){
        float[] layerWeights;
        try{
            Layer_Weights layer = mWeightsData.get(layerIndex);
            W_Vec vec = layer.get(W_Type.WEIGHT);
            layerWeights = new float[vec.size()];
            for( int i = 0; i<layerWeights.length; i++){
                layerWeights[i] = vec.get(i);
            }
        } catch ( IndexOutOfBoundsException e ) {
            layerWeights = new float[0];
        }

        return layerWeights;
    }
    public float[] getLayerBiases(int layerIndex){
        float[] layerBiases;
        try{
            Layer_Weights layer = mWeightsData.get(layerIndex);
            W_Vec vec = layer.get(W_Type.BIAS);
            layerBiases = new float[vec.size()];
            for( int i = 0; i<layerBiases.length; i++){
                layerBiases[i] = vec.get(i);
            }
        } catch ( IndexOutOfBoundsException e ) {
            layerBiases = new float[0];
        }

        return layerBiases;
    }

}
