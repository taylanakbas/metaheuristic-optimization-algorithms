package live.algorithm.sa;
/**
 * author:taylanakbas
 **/

import live.algorithm.UpdateStrategy;
import live.base.EvaluatedSolution;
import live.base.OptimizationProblem;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;

public class CoolingUS implements UpdateStrategy {
    double temperature;
    double coolingRate;
    int inner;
    boolean selectBetter;
    private NeighborGenerator neighborGenerator;

    public CoolingUS(double temperature, double coolingRate, NeighborGenerator neighborGenerator, boolean selectBetter){
        this.temperature = temperature;
        this.coolingRate = coolingRate;
        this.neighborGenerator = neighborGenerator;
        this.selectBetter = selectBetter;
        inner = 0;
    }
    @Override
    public EvaluatedSolution getNextSolution(OptimizationProblem problem, EvaluatedSolution currentSolution) {

        ArrayList<EvaluatedSolution> solutions =  generateNeighbors(problem,currentSolution);
        if(solutions.isEmpty())
            return null;
        System.out.println("Temp:" + this.temperature);
        Random r = new SecureRandom();
        while (temperature > 1) {
            temperature *=  1 - coolingRate; // Temperature update
            for (int i = 0; i < solutions.size(); i++) {
                this.inner++;
                int idx = r.nextInt(solutions.size());
                double newCost = solutions.get(idx).getCost(); // Get randomly selected neighbor's cost
                if ( newCost < currentSolution.getCost()){
                    return solutions.get(idx); // Accept neighbor solution
                }else{
                    if (acceptanceProbability(newCost, currentSolution.getCost()) > r.nextDouble()){
                        return solutions.get(idx); // Accept neighbor solution with probability
                    }
                }
            }
        }
        //System.out.println("INNER: " +  this.inner);
        return null;
    }
    private double acceptanceProbability(double newCost, double currentCost){
        return Math.exp((currentCost - newCost) / this.temperature);
    }
    private ArrayList<EvaluatedSolution> generateNeighbors(OptimizationProblem problem, EvaluatedSolution currentSolution) {
        ArrayList<EvaluatedSolution> solutions = neighborGenerator.generate(problem,currentSolution);
        return solutions;
    }
}