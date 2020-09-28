package live.problems.tsp;
/**
 * author:taylanakbas
 **/
import live.algorithm.Metaheuristic;
import live.algorithm.ga.*;
import live.algorithm.sa.CoolingUS;
import live.algorithm.sa.SimulatedAnnealing;
import live.algorithm.terminalcondition.MaxIterationTC;
import live.base.OptimizationProblem;
import live.base.Solution;

import live.problems.tsp.instances.Point;
import live.problems.tsp.solutiongenerator.TSPRandomPermutationSG;

import java.io.*;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;

public class TSP implements OptimizationProblem {

    double[][] distMatrix;
    private final String base_path = "/Users/taylanakbas/Desktop/OptimizationProblem/src/live/problems/tsp/instances/";
    private final String extension = ".csv";
    public TSP(){}

     @Override
    public double objective(Solution s) {
        Permutation p = (Permutation) s;
        int totalDistance = 0;
        for (int i = 0; i < this.distMatrix.length - 1; i++) {
            totalDistance += this.distMatrix[ p.vector[i] ][ p.vector[i+1] ];
        }
        return totalDistance + this.distMatrix[p.vector[p.vector.length - 1]][p.vector[0]];  // Adds the distance between final and origin point to total distance
    }
    @Override
    public boolean isFeasible(Solution s) {
         Permutation p = (Permutation) s;
         return (p.vector.length == this.distMatrix.length);
    }
    @Override
    public boolean isMinimisation() {
        return true;
    }

    public void readInstance(String instance){

        String fullPath = base_path + instance + extension;
        BufferedReader br;
        String delimiter = ",";
        String line;
        ArrayList<Point> plist = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(fullPath));
            while ((line = br.readLine()) != null) {
                String[] val = line.split(delimiter);
                Point point = new Point(Double.parseDouble(val[1]),Double.parseDouble(val[2]));
                plist.add(point);
            }
            double[][] matrix = new double[plist.size()][plist.size()];
            for (int r = 0 ; r < plist.size() ; r++){
                for (int c = 0; c < plist.size(); c++) {
                    double d = plist.get(r).getDistance(plist.get(c));
                    matrix[r][c] = d;
                }
            }
            this.distMatrix = matrix;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getMatrixSize(){ return this.distMatrix.length; }
    public void initRandomDistMatrix(int size, int bound){
        double[][] distMatrix = new double[size][size];
        Random rand = new SecureRandom();
        for (int r = 0 ; r < size ; r++){
            for (int c = 0; c < size; c++) {
                distMatrix[r][c] = rand.nextInt(bound) + 1; // Random distance
            }
        }
        this.distMatrix = distMatrix;
    }
    public void printDistanceMatrix(){
        System.out.println("Distance Matrix");
        int n = this.distMatrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf(distMatrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){

        TSP p = new TSP();
        // To read instance, change base_path.
        p.readInstance("a280"); // a280 - berlin52 - bier127  - ch130 - d493

        //p.initRandomDistMatrix(100,10);
        //p.printDistanceMatrix();
//        Metaheuristic alg = new SimulatedAnnealing(
//                new CoolingUS(500,0.0001, new RandomNG(),true),
//                new MaxIterationTC(50000),
//                new TSPRandomPermutationSG(p.getMatrixSize()), true);

        Metaheuristic alg = new GA(
                new RandomPermutationPG(p.getMatrixSize()),
                new RoulletteWheelSelection(),
                new SinglePointCO(),
                new SwapMutation(),
                new RandomReplacement(),
                100,
                0.001,
                0.5,
                100);

        final long startTime = System.nanoTime();
        alg.solve(p);
        final long duration =  System.nanoTime() - startTime;
        System.out.println("RUN-TIME:" + duration / 1000000); // Prints run-time(ms)
    }


}
