package live.algorithm.ga;

import live.base.EvaluatedSolution;

import java.util.ArrayList;

/**
 * @author taylanakbas
 **/
public interface Population {
    public void add(EvaluatedSolution solution);
    public void remove(EvaluatedSolution solution);
    public  int size();
    public ArrayList<EvaluatedSolution> getPopulation();
}
