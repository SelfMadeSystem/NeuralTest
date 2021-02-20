package uwu.smsgamer.nerualtest;

import uwu.smsgamer.nerualtest.nodes.StaticNode;

import java.util.Random;

public class NeuralSettings {
    public Random random = new Random();

    public int inputs;
    public int outputs;
    public int height;
    public float bounds;
    public NeuralInstance[] instances;

    public NeuralSettings(int inputs, int outputs, int height, float bounds) {
        this.inputs = inputs;
        this.outputs = outputs;
        this.height = height;
        this.bounds = bounds;
    }

    public void setInstances(int amount, StaticNode[] inputNodes) {
        this.instances = new NeuralInstance[amount];
        for (int i = 0; i < this.instances.length; i++) {
            this.instances[i] = new NeuralInstance(this, inputNodes);
        }
    }

    public float random(float amount) {
        return this.random.nextFloat() * amount * 2 - amount;
    }

    public float random() {
        return random(this.bounds);
    }

    public void setNodes() {
        for (int i = 0; i < this.instances.length; i++) {
            this.instances[i].setNodes();
        }
    }
}
