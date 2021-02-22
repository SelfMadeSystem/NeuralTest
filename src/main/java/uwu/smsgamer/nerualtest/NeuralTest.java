package uwu.smsgamer.nerualtest;

import uwu.smsgamer.nerualtest.nodes.StaticNode;

public class NeuralTest {
    public static void main(String[] args) {
        NeuralSettings settings = new NeuralSettings(3, 1, 2, 1, 0.025f);
        StaticNode[] nodes = new StaticNode[]{new StaticNode(settings, 0),
          new StaticNode(settings, 0), new StaticNode(settings, 0),};
        settings.setInstances(20, nodes);
        settings.setNodes();
        settings.keepAndReplicate(new int[]{getClosest(settings)});
        System.out.println("=======================================");
        settings.keepAndReplicate(new int[]{getClosest(settings)});
        System.out.println("=======================================");
        settings.keepAndReplicate(new int[]{getClosest(settings)});
        System.out.println("=======================================");
        settings.keepAndReplicate(new int[]{getClosest(settings)});

    }

    public static int getClosest(NeuralSettings settings) {
        int closest = 0;
        double diff = 0;
        NeuralInstance[] instances = settings.instances;
        for (int i = 0; i < instances.length; i++) {
            NeuralInstance instance = instances[i];
            float output = instance.outputNodes[0].getOutput();
            System.out.println(output);
            if (Math.abs(output) > diff) {
                diff = Math.abs(output);
                closest = i;
            }
        }
        return closest;
    }
}
