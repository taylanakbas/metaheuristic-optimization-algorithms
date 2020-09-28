package live.problems.production.solutiongenerator;

import live.base.OptimizationProblem;
import live.base.EvaluatedSolution;
import live.base.SimpleEvaluatedSolution;
import live.base.Solution;
import live.base.SolutionGenerator;

import live.problems.production.IntegerVector;
import live.problems.production.ProductionProblem;


import java.security.SecureRandom;
import java.util.Random;

public class ProductionProblemRandomSG implements SolutionGenerator {
    @Override
    public EvaluatedSolution generate(OptimizationProblem problem) {

        int nodes[] = new int[2];

        Random r=  new SecureRandom();
        nodes[0] = r.nextInt(10);
        nodes[1] = r.nextInt(10);
        Solution s = new IntegerVector(nodes);
        return new SimpleEvaluatedSolution(s, problem.objective(s));
    }


    public static void main(String[] args) {

        SolutionGenerator sg = new ProductionProblemRandomSG();
        OptimizationProblem pp = new ProductionProblem();


        for (int i = 0; i < 100; i++) {
            EvaluatedSolution s = sg.generate(pp);

            System.out.println(s  + " Objective:" + s.getCost() + " Feasibille:"+ pp.isFeasible(s.getSolution()));
        }
    }
}
