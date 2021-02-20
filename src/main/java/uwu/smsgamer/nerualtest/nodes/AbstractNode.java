package uwu.smsgamer.nerualtest.nodes;

import uwu.smsgamer.nerualtest.NeuralSettings;

public abstract class AbstractNode {
    public final NeuralSettings settings;

    protected AbstractNode(NeuralSettings settings) {
        this.settings = settings;
    }

    public abstract float getOutput();
    public abstract void vary(float amount);
}
