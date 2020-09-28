package live.algorithm.ga;

import live.base.EvaluatedSolution;

import java.util.ArrayList;

/**
 * @author taylanakbas
 **/
public class SimplePopulation implements Population {

    ArrayList<EvaluatedSolution> solutions = new ArrayList<>();
    @Override
    public void add(EvaluatedSolution solution) {
        solutions.add(solution);
    }
    public ArrayList<EvaluatedSolution> getPopulation(){
        return solutions;
    }
    @Override
    public void remove(EvaluatedSolution solution) {
        solutions.remove(solution);
    }
    @Override
    public int size() {
        return solutions.size();
    }
}
