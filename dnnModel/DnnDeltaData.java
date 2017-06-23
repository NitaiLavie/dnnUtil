package dnnUtil.dnnModel;

public class DnnDeltaData extends DnnWeightsData{
    static final long serialVersionUID = 2L;

    private Integer mModelVersion;

    public DnnDeltaData(Integer modelVersion, DnnWeightsData newWeights, DnnWeightsData oldWeights){
        mModelVersion = modelVersion;
        mWeightsData = newWeights.mWeightsData;
        mWeightsData = subtractWeights(oldWeights).mWeightsData;
    }

    public DnnWeightsData subtractWeights(DnnWeightsData subtractedWeightsData){
        DnnWeightsData updatedWeightsData = new DnnWeightsData();
        for(Integer layerIndex : mWeightsData.keySet()){
            float[] weights = getLayerWeights(layerIndex);
            float[] newWeights = subtractedWeightsData.getLayerWeights(layerIndex);
            float[] updatedWeights = new float[weights.length];

            for(int weightIndex = 0; weightIndex < weights.length; weightIndex ++){
                updatedWeights[weightIndex] = weights[weightIndex] - newWeights[weightIndex];
            }
            updatedWeightsData.setLayerWeights(updatedWeights, layerIndex);

            float[] biases = getLayerBiases(layerIndex);
            float[] newBiases = subtractedWeightsData.getLayerBiases(layerIndex);
            float[] updatedBiases= new float[biases.length];

            for(int biasIndex = 0; biasIndex < biases.length; biasIndex ++){
                updatedBiases[biasIndex] = biases[biasIndex] - newBiases[biasIndex];
            }
            updatedWeightsData.setLayerBiases(updatedBiases, layerIndex);
        }
        return updatedWeightsData;
    }

    public Integer getModelVesrsion() {
        return mModelVersion;
    }

}
