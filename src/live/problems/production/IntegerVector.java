package live.problems.production;

import live.base.Solution;

import java.util.Arrays;

public class IntegerVector implements Solution {
    int nodes[];

    public IntegerVector(int[] nodes) {
        this.nodes = nodes;
    }

    public String toString()
    {
        return Arrays.toString(nodes);
    }

    public  int[] getNodes(){ return nodes;}

    @Override
    public Solution clone() {
        int newNodes[] = Arrays.copyOf(nodes,nodes.length);
        return new IntegerVector(newNodes);
    }
}
