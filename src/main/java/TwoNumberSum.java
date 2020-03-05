import java.util.Arrays;

public class TwoNumberSum {


    public static int[] toNumberSum(int[]a , int targetSum) {

        int pair[] = {0,0};

        int left = 0;
        int right = 0;

        Arrays.sort(a);

        System.out.println("==> a[] " + Arrays.toString(a));

        for(left = 0, right = a.length -1; (right >= 0)  && (left <= a.length -1 ); ) {

            if(left == right) {
                break;
            }
            int sum = a[left] + a[right];
            if (sum > targetSum) {
                right--;
            } else if (sum < targetSum) {
                left++;
            } else if (sum == targetSum) {
                pair[0] = a[left];
                pair[1] = a[right];
                break;
            }
        }

        if((pair[0] == 0) && (pair[1] == 0)) {
            return null;
        } else {
            return pair;
        }
    }

    public static void main(String args[]) {

        System.out.println("Hello World");

        int a[] = {2,3,1,7,9,5};

        System.out.println(Arrays.toString(toNumberSum(a, 8)));

    }
}
