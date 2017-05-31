package dnnUtil.dnnModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class DnnDeltaData extends DnnWeightsData{
    static final long serialVersionUID = 1L;

    public DnnDeltaData(DnnWeightsData newWeights, DnnWeightsData oldWeights){
        mWeightsData = newWeights.mWeightsData;
        mWeightsData = subtractWeights(oldWeights).mWeightsData;
    }

    public DnnWeightsData subtractWeights(DnnWeightsData subtractedWeightsData){
        DnnWeightsData updatedWeightsData = new DnnWeightsData();
        for(int layerIndex = 0; layerIndex < mWeightsData.size(); layerIndex++){
            float[] weights = getLayerWeights(layerIndex);
            float[] newWeights = subtractedWeightsData.getLayerWeights(layerIndex);
            float[] updatedWeights = new float[weights.length];

            for(int weightIndex = 0; weightIndex < weights.length; weightIndex ++){
                updatedWeights[weightIndex] = weights[weightIndex] - newWeights[weightIndex];
            }
            updatedWeightsData.setLayerWeights(updatedWeights, layerIndex);

            float[] biases = getLayerWeights(layerIndex);
            float[] newBiases = subtractedWeightsData.getLayerWeights(layerIndex);
            float[] updatedBiases= new float[biases.length];

            for(int biasIndex = 0; biasIndex < biases.length; biasIndex ++){
                updatedBiases[biasIndex] = biases[biasIndex] - newBiases[biasIndex];
            }
            updatedWeightsData.setLayerBiases(updatedBiases, layerIndex);
        }
        return updatedWeightsData;
    }

}
