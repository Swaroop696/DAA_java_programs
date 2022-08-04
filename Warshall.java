
package warshall;

import java.util.Scanner;

public class Warshall {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n;
        System.out.println("Enter the number of vertices");
        n=scan.nextInt();
        int adj[][]=new int[n][n];
        System.out.println("Enter the adjascency matrix");
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                adj[i][j]=scan.nextInt();
            }
        }
        
        System.out.println("Entered adjascency matrix");
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(adj[i][j]+" ");
            }System.out.println();
        }
        
        
        for(int k=0;k<n;k++)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    adj[i][j]= adj[i][j] | (adj[k][j] & adj[i][k]);
                }
            }
        }
        
        System.out.println("The final matrix is");
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(adj[i][j]+" ");
            }System.out.println();
        }
    }
    
}
