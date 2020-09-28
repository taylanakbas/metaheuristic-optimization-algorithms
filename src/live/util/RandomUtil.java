package live.util;

import java.security.SecureRandom;
import java.util.Random;

/**
 * @author taylanakbas
 **/
public class RandomUtil {

    static Random rng = new SecureRandom();
    public static boolean nextBoolean(double p){
        int n = rng.nextInt(10000);
        return  (n < 10000*p);
    }
    public static int nextInt(int max,int min){
        return (int) ((Math.random() * (max - min)) + min);
    }
    public static double nextDouble(){
        return rng.nextDouble();
    }

}
