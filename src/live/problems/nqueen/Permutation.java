package live.problems.nqueen;

import live.base.Solution;

import java.util.Arrays;

public class Permutation implements Solution {

    int nodes[];

    public Permutation(int[] nodes){ this.nodes = nodes; }
    public int getNode(int index) { return nodes[index]; }
    public int length(){ return nodes.length; }
    public void swap(int i1, int i2){
        int tmp = nodes[i1];
        nodes[i1] = nodes[i2];
        nodes[i2] = tmp;
    }
    @Override
    public Solution clone() {
        int newNodes[] = Arrays.copyOf(nodes,nodes.length);
        return new Permutation(newNodes);
    }
    @Override
    public String toString() {
        return Arrays.toString(nodes);
    }
}
