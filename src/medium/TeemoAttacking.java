package medium;

/**
 * Development IDE: IntelliJ IDEA
 * Author: irving
 * Project Name: leetcode-Array
 * Date: 2019-01-09
 */
public class TeemoAttacking {

    public static void main(String[] args) {
        int[] timeSeries = {1, 4};
        new TeemoAttacking().findPoisonedDuration(timeSeries, 2);
    }

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int elapse = timeSeries.length == 0 ? 0 : duration;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            if (timeSeries[i + 1] - timeSeries[i] < duration) {
                elapse += timeSeries[i + 1] - timeSeries[i];
            } else {
                elapse += duration;
            }
        }
        return elapse;
    }
}
