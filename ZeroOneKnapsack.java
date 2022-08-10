import java.util.Scanner;

public class ZeroOneKnapsack{
    public static void DynamicKnapsack(int n, int[] w, int[] v, int[][] V, int W){
        for(int j = 0; j <= W; j++){
            V[0][j] = 0;
        }

        for(int i = 0; i <= n; i++){
            V[i][0] = 0;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= W; j++){
                if(w[i] <= j){
                    V[i][j] = Math.max(V[i - 1][j], v[i] + V[i - 1][j - w[i]]);
                }
                else{
                    V[i][j] = V[i - 1][j];
                }
            }
        }

        for(int i = 0; i < n+1; i++){
            for(int j = 0; j < W+1; j++){
                System.out.print(V[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Optimal Solution: " + V[n][W]);
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = in.nextInt();
        int[] w = new int[n + 1];
        int[] v = new int[n + 1];

        System.out.print("Enter the capacity of the knapsack: ");
        int W = in.nextInt();
        int[][] V = new int[n + 1][W + 1];

        System.out.print("Enter the weights accordingly: ");
        for(int i = 1; i <= n; i++){
            w[i] = in.nextInt();
        }

        System.out.print("Enter the profits accordingly: ");
        for(int i = 1; i <= n; i++){
            v[i] = in.nextInt();
        }

        DynamicKnapsack(n, w, v, V, W);
    }
}
