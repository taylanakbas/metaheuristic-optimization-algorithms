package live.problems.production;

import live.base.OptimizationProblem;
import live.base.Solution;

public class ProductionProblem implements OptimizationProblem {
    @Override
    public double objective(Solution s) {

        IntegerVector iv = (IntegerVector) s;
        return 5*iv.nodes[0] + 4*iv.nodes[1];

    }

    @Override
    public boolean isFeasible(Solution s) {
        IntegerVector iv = (IntegerVector) s;
        return  ( iv.nodes.length==2)&&
                ( iv.nodes[0]>=0)&&
                ( iv.nodes[1]>=0)&&
                ( iv.nodes[0]*6 + iv.nodes[1]*4<=24) &&
                ( iv.nodes[0] + iv.nodes[1]*2<=6) ;
    }

    @Override
    public boolean isMinimisation() {
        return false;
    }
}
