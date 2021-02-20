package uwu.smsgamer.nerualtest;

import uwu.smsgamer.nerualtest.nodes.StaticNode;

public class NeuralTest {
    public static void main(String[] args) {
        NeuralSettings settings = new NeuralSettings(3, 1, 7, 1);
        StaticNode[] nodes = new StaticNode[]{new StaticNode(settings, 0),
          new StaticNode(settings, 0), new StaticNode(settings, 0),};
        settings.setInstances(5, nodes);
        settings.setNodes();
        for (NeuralInstance instance : settings.instances) {
            System.out.println(instance.outputNodes[0].getOutput());
        }
        System.out.println("====================================================");
        nodes[0].value = 1;
        for (NeuralInstance instance : settings.instances) {
            System.out.println(instance.outputNodes[0].getOutput());
        }
        System.out.println("====================================================");
        nodes[1].value = 1;
        for (NeuralInstance instance : settings.instances) {
            System.out.println(instance.outputNodes[0].getOutput());
        }
        System.out.println("====================================================");
    }
}
