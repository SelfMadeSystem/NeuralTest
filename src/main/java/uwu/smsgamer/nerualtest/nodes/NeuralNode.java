package uwu.smsgamer.nerualtest.nodes;

import uwu.smsgamer.nerualtest.NeuralSettings;

public class NeuralNode extends AbstractNode {
    public AbstractNode[] inputs;
    public float[] weights;
    public float[] adds;
    public int inputCount;

    public NeuralNode(NeuralSettings settings, int inputCount) {
        super(settings);
        this.inputCount = inputCount;
        this.inputs = new AbstractNode[inputCount];
        for (int i = 0; i < this.inputs.length; i++) {
            this.inputs[i] = new StaticNode(settings, 0);
        }
        this.weights = new float[inputCount];
        this.adds = new float[inputCount];
        randomizeWeights();
    }

    public void setNodes(AbstractNode[] nodes) {
        this.inputs = nodes;
        this.checkSize();
    }

    public void randomizeWeights() {
        for (int i = 0; i < this.weights.length; i++) this.weights[i] = settings.random();
        for (int i = 0; i < this.adds.length; i++) this.adds[i] = settings.random();
    }

    @Override
    public float getOutput() {
        float result = 0;
        for (int i = 0; i < inputCount; i++)
            result += (this.inputs[i].getOutput() + this.adds[i]) * this.weights[i];
        return result;
    }

    @Override
    public void vary(float amount) {
        for (int i = 0; i < inputCount; i++) {
            this.weights[i] += this.settings.random(amount);
            this.adds[i] += this.settings.random(amount);
        }
    }

    protected void checkSize() {
        if (this.inputCount <= 0) throw new IllegalStateException("Input count is less than zero!");
        if (this.inputs.length != this.inputCount) throw new IllegalStateException("Inputs length not same as input count!");
        if (this.weights.length != this.inputCount) throw new IllegalStateException("Weights length not same as input count!");
        if (this.adds.length != this.inputCount) throw new IllegalStateException("Adds length not same as input count!");
    }
}
