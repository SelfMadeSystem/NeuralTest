package uwu.smsgamer.nerualtest.nodes;

import uwu.smsgamer.nerualtest.NeuralSettings;

public class StaticNode extends AbstractNode {
    public float value;

    public StaticNode(NeuralSettings settings, float value) {
        super(settings);
        this.value = value;
    }

    @Override
    public float getOutput() {
        return value;
    }

    @Override
    public void vary(float amount) {
        // static; don't do shit
    }
}
