package live.algorithm;

import live.algorithm.terminalcondition.Iterative;
import live.base.EvaluatedSolution;
import live.base.OptimizationProblem;
import live.base.SolutionGenerator;

public abstract class AbstractSMetaheuristic extends AbstractMetaheuristic implements SMetaheuristic, Iterative {

    protected EvaluatedSolution currentSolution;
    private TerminalCondition terminalCondition;
    private long iterationCount;
    private SolutionGenerator initialSolutionGenerator;
    private boolean printSteps;

    public  AbstractSMetaheuristic(TerminalCondition terminalCondition, SolutionGenerator solutionGenerator, boolean printSteps){
        this.terminalCondition = terminalCondition;
        this.initialSolutionGenerator = solutionGenerator;
        this.printSteps = printSteps;
    }
    @Override
    protected  void perform(OptimizationProblem problem){
        while (! terminalCondition.isSatisfied(this,problem,currentSolution)){
            updateCurrentSolution(problem);
            if(currentSolution == null){
                System.out.println("OUTER: " +iterationCount);
                System.out.println("BEST: " +bestSolution.getCost());
                break;
            }
            updateBest(problem,currentSolution);
            iterationCount++;
            if (printSteps){
                printStats();
            }
        }
    }

    private void printStats() {
        System.out.println("["+ iterationCount+"] " + currentSolution + " Best:" + bestSolution );
    }
    protected abstract void updateCurrentSolution(OptimizationProblem problem);

    @Override
    protected void init(OptimizationProblem problem){
        iterationCount = 0;
        terminalCondition.init(problem);
        if(currentSolution == null){
            currentSolution = initialSolutionGenerator.generate(problem);
        }
    }
    @Override
    public void  setCurrentSolution(EvaluatedSolution solution){
        currentSolution = solution;
    }
    public long getIterationCount(){
        return iterationCount;
    }








}
