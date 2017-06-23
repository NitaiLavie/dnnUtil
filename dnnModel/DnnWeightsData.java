package dnnUtil.dnnModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by nitai on 29/04/17.
 */

public class DnnWeightsData implements Serializable {
    static final long serialVersionUID = 5L;

    public static final Integer WEIGHT  = 0;
    public static final Integer BIAS    = 1;

    protected class W_Vec extends ArrayList<Float>{
        static final long serialVersionUID = 1L;
    }
    protected class Layer_Weights extends HashMap<Integer,W_Vec>{
        static final long serialVersionUID = 1L;
    }
    protected HashMap<Integer,Layer_Weights> mWeightsData;

    public DnnWeightsData(){
        mWeightsData = new HashMap<>();
    }
    
    public DnnWeightsData addWeights(DnnWeightsData addedWeightsData){
    	DnnWeightsData updatedWeightsData = new DnnWeightsData();
    	for(Integer layerIndex : mWeightsData.keySet()){
    		float[] weights = getLayerWeights(layerIndex);
    		float[] newWeights = addedWeightsData.getLayerWeights(layerIndex);
    		float[] updatedWeights = new float[weights.length];

    		for(int weightIndex = 0; weightIndex < weights.length; weightIndex ++){
    			updatedWeights[weightIndex] = weights[weightIndex] + newWeights[weightIndex]; 
    		}
    		updatedWeightsData.setLayerWeights(updatedWeights, layerIndex);
    		
    		float[] biases = getLayerBiases(layerIndex);
    		float[] newBiases = addedWeightsData.getLayerBiases(layerIndex);
    		float[] updatedBiases= new float[biases.length];

    		for(int biasIndex = 0; biasIndex < biases.length; biasIndex ++){
    			updatedBiases[biasIndex] = biases[biasIndex] + newBiases[biasIndex]; 
    		}
    		updatedWeightsData.setLayerBiases(updatedBiases, layerIndex);
    	}
    	return updatedWeightsData;
    }
    
    public void scaleWeights(Float scale){
    	for(Integer layerIndex : mWeightsData.keySet()){
    		float[] weights = getLayerWeights(layerIndex);
    		for(int weightIndex = 0; weightIndex < weights.length; weightIndex ++){
    			weights[weightIndex] = weights[weightIndex] * scale; 
    		}
    		setLayerWeights(weights, layerIndex);  
    		float[] baiases = getLayerBiases(layerIndex);
    		for(int weightIndex = 0; weightIndex < baiases.length; weightIndex ++){
    			baiases[weightIndex] = baiases[weightIndex] * scale; 
    		}
    		setLayerBiases(baiases, layerIndex); 
    	}
    }
    
    public void setLayerWeights(float[] weights, int layerIndex){
        W_Vec vec = new W_Vec();
        for(int i = 0; i<weights.length; i++){
            vec.add(weights[i]);
        }

        Layer_Weights layer = mWeightsData.get(layerIndex);
        if(layer != null) {
            layer.put(WEIGHT, vec);
        } else{
            layer = new Layer_Weights();
            layer.put(WEIGHT, vec);
            mWeightsData.put(layerIndex,layer);
        }
    }
    public void setLayerBiases(float[] biases, int layerIndex){
        W_Vec vec = new W_Vec();
        for(int i = 0; i<biases.length; i++){
            vec.add(biases[i]);
        }

        Layer_Weights layer = mWeightsData.get(layerIndex);
        if(layer != null){
            layer.put(BIAS, vec);
        } else {
            layer = new Layer_Weights();
            layer.put(BIAS, vec);
            mWeightsData.put(layerIndex,layer);
        }
    }
    public float[] getLayerWeights(int layerIndex){
        float[] layerWeights;

        Layer_Weights layer = mWeightsData.get(layerIndex);
        if(layer != null){
            W_Vec vec = layer.get(WEIGHT);
            if(vec != null) {
                layerWeights = new float[vec.size()];
                for (int i = 0; i < layerWeights.length; i++) {
                    layerWeights[i] = vec.get(i);
                }
            } else {
                layerWeights = new float[0];
            }
        } else {
            layerWeights = new float[0];
        }

        return layerWeights;
    }
    public float[] getLayerBiases(int layerIndex){
        float[] layerBiases;
        Layer_Weights layer = mWeightsData.get(layerIndex);
        if(layer != null){
            W_Vec vec = layer.get(BIAS);
            if(vec != null) {
                layerBiases = new float[vec.size()];
                for (int i = 0; i < layerBiases.length; i++) {
                    layerBiases[i] = vec.get(i);
                }
            } else {
                layerBiases = new float[0];
            }
        } else {
            layerBiases = new float[0];
        }
        return layerBiases;
    }

    public DnnWeightsData deepcopy(){
        DnnWeightsData weightsCopy = new DnnWeightsData();
        for(Integer layerKey : this.mWeightsData.keySet()){
            Layer_Weights layer = mWeightsData.get(layerKey);
            Layer_Weights layerCopy = new Layer_Weights();
            for(Integer vecKey : layer.keySet()){
                W_Vec vec = layer.get(vecKey);
                W_Vec vecCopy = new W_Vec();
                for(int i = 0; i<vec.size(); i++){
                    vecCopy.add(new Float(vec.get(i).floatValue()));
                }
                layerCopy.put(vecKey,vecCopy);
            }
            weightsCopy.mWeightsData.put(layerKey,layerCopy);
        }
        return weightsCopy;
    }
}
