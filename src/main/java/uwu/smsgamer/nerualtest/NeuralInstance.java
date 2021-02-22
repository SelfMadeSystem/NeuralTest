package uwu.smsgamer.nerualtest;

import uwu.smsgamer.nerualtest.nodes.*;

public class NeuralInstance implements Cloneable {
    public NeuralSettings settings;
    public int inputs;
    public int outputs;
    public int height;
    public float bounds;
    public StaticNode[] inputNodes;
    public NeuralNode[] outputNodes;

    public NeuralInstance(NeuralSettings settings, StaticNode[] inputNodes) {
        this.settings = settings;
        this.inputs = settings.inputs;
        this.outputs = settings.outputs;
        this.height = settings.height;
        this.bounds = settings.bounds;
        this.inputNodes = inputNodes;
        this.outputNodes = new NeuralNode[this.outputs];
    }

    public NeuralInstance(NeuralInstance instance) {
        this.settings = instance.settings;
        this.inputs = instance.inputs;
        this.outputs = instance.outputs;
        this.height = instance.height;
        this.bounds = instance.bounds;
        this.inputNodes = instance.inputNodes;
        this.outputNodes = instance.outputNodes;
    }

    public int[] getAmounts() {
        int[] result = new int[height];
        result[height - 1] = inputs;
        result[0] = outputs;
        float taper = (inputs - outputs) / (float) height;
        float current = outputs;
        for (int i = 1; i < result.length - 1; i++) {
            current += taper;
            result[i] = (int) current;
        }
        return result;
    }

    public void setNodes() {
        int[] amounts = getAmounts();
        AbstractNode[] setNodes = inputNodes;
        for (int i = amounts.length - 2; i >= 0; i--) {
            int amount = amounts[i];
            NeuralNode[] nodes = new NeuralNode[amount];
            for (int j = 0; j < amount; j++) {
                NeuralNode node = nodes[j] = new NeuralNode(settings, amounts[i + 1]);
                node.setNodes(setNodes);
            }
            setNodes = nodes;
        }
        assert setNodes instanceof NeuralNode[];
        outputNodes = (NeuralNode[]) setNodes;
    }

    public void vary(float amount) {
        for (NeuralNode node : outputNodes) {
            node.vary(amount);
        }
    }

    @Override
    public NeuralInstance clone() {
        try {
            NeuralInstance clone = (NeuralInstance) super.clone();
            clone.outputNodes = new NeuralNode[outputNodes.length];
            for (int i = 0; i < outputNodes.length; i++) {
                clone.outputNodes[i] = outputNodes[i].clone();
            }
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
