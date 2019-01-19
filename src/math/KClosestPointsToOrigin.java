package math;

/**
 * {@see <a href="https://leetcode.com/problems/k-closest-points-to-origin/"></a>}
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 * <p>
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 * <p>
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 * Example 2:
 * <p>
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 */
public class KClosestPointsToOrigin {

    public static void main(String[] args) {
        System.out.println(Math.sqrt(4));
        int[][] a = {{1, 3}, {-2, 2}};
        System.out.println(new KClosestPointsToOrigin().kClosest(a, 2));
    }

    public int[][] kClosest(int[][] points, int K) {
        int min = 0xfffffff, max = 0, row = points.length, cow = points[0].length;
        if (K == cow) return points;
        int[][] res = new int[K][2];
        for (int i = 0; i < row; i++) {
            double distance = 0;
            for (int j = 0; j < cow; j++) distance += Math.pow(points[i][j], 2);
            distance = Math.sqrt(distance);
            System.out.println(distance);
        }
        return res;
    }
}
