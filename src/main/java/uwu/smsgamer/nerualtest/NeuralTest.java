package uwu.smsgamer.nerualtest;

import uwu.smsgamer.nerualtest.nodes.StaticNode;

public class NeuralTest {
    public static void main(String[] args) {
        NeuralSettings settings = new NeuralSettings(15, 3, 4, 1);
        settings.setInstances(5, new StaticNode[]{new StaticNode(settings, 0),
          new StaticNode(settings, 0), new StaticNode(settings, 0),
          new StaticNode(settings, 0), new StaticNode(settings, 0),new StaticNode(settings, 0),
          new StaticNode(settings, 0), new StaticNode(settings, 0),
          new StaticNode(settings, 0), new StaticNode(settings, 0),new StaticNode(settings, 0),
          new StaticNode(settings, 0), new StaticNode(settings, 0),
          new StaticNode(settings, 0), new StaticNode(settings, 0),});
        for (int i = 0; i < settings.instances.length; i++) {
            settings.instances[i].setNodes();
        }
    }
}
