package uwu.smsgamer.nerualtest;

import uwu.smsgamer.nerualtest.nodes.StaticNode;

import java.util.*;

public class NeuralSettings {
    public Random random = new Random();

    public int inputs;
    public int outputs;
    public int height;
    public float bounds;
    public float vary;
    public NeuralInstance[] instances;

    public NeuralSettings(int inputs, int outputs, int height, float bounds, float vary) {
        this.inputs = inputs;
        this.outputs = outputs;
        this.height = height;
        this.bounds = bounds;
        this.vary = vary;
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
        for (NeuralInstance instance : this.instances) instance.setNodes();
    }

    public void keepAndReplicate(int[] keepers) {
        int kLen = keepers.length;
        NeuralInstance[] keep = new NeuralInstance[kLen];
        for (int i = 0; i < kLen; i++) {
            int keeper = keepers[i];
            keep[i] = this.instances[keeper];
        }
        this.instances = Arrays.copyOf(keep, this.instances.length);
        for (int i = kLen; i < this.instances.length; i++) {
            this.instances[i] = keep[i % kLen].clone();
            this.instances[i].vary(vary);
        }
    }
}
