import java.util.Scanner;

public class dijkstras {
void dijk(int am[][],int src ,int n)
{  
      //boolean[] vis = new boolean[30];
        int dist[]=new int[30];
int vis[]=new int[40];
for(int i=0;i<n;i++)
{ dist[i]=am[src][i];
vis[i]=0;
}
vis[src]=1;
for(int i=1;i<n;i++)
{
int unvis=0;
int min=999;
for(int j=0;j<n;j++)
{
    if((vis[j]==0)&&(dist[j]<min))
     {
unvis=j;
min=dist[j];
      }
}  
  vis[unvis]=1;
  for(int v=0;v<n;v++)
  {
  if(dist[unvis]+am[unvis][v]<dist[v])
  {
  dist[v]=dist[unvis]+am[unvis][v];
 
  }
 
  }

}

for(int i=0;i<n;i++)
System.out.println("to vertex"+(i+1)+" is "+dist[i]);






}



  public static void main(String[] args)
  {
 Scanner sc=new Scanner(System.in);
 int src,n,i,j;
 System.out.println("enter the number of vertices");
 n=sc.nextInt();
 System.out.println("enter the adjecency matrix");
 int am[][]=new int[30][30];

 for(i=0;i<n;i++)
 for(j=0;j<n;j++)
 {
 am[i][j]=sc.nextInt();
 }
 System.out.println("the entered adjecency matrix is");
 for(i=0;i<n;i++) {
 for(j=0;j<n;j++)
 System.out.print(am[i][j]+"\t");
  System.out.println("");
 }
 System.out.println("enter the source vertex");
 src=sc.nextInt();
 System.out.println("the shortest path from sourcr vertex to all other vertices are\n");
 dijkstras ob =new dijkstras();
ob.dijk(am,src,n);

 
 
  }

}