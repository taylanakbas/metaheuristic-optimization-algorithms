package live.problems.tsp;
/**
 * author:taylanakbas
 **/

import live.base.Solution;
import java.util.Arrays;

public class Permutation implements Solution {
    int vector[];
    public Permutation(int[] vector) { this.vector = vector;}
    public int length() { return vector.length;}
    public void swap(int i1, int i2){
        int tmp = vector[i1];
        vector[i1] = vector[i2];
        vector[i2] = tmp;
    }
    public int get(int idx){ return  vector[idx]; }
    @Override
    public Solution clone() {
        int newVector[] = Arrays.copyOf(vector,vector.length);
        return new Permutation(newVector);
    }
    @Override
    public String toString() { return Arrays.toString(vector);}
}
