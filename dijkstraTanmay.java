import java.util.Scanner;
class dijkstra{
    static void dijkstras(int cam[][],int n,int s,int path[],int d[]){
        int i,min,unvis=0,j,k;
        boolean vis[]=new boolean[n];
        for(i=0;i<n;i++)//initial setup
        {
            vis[i]=false;
            d[i]=cam[s][i];
            path[i]=999;
        }
        vis[s]=true;
        for(i=0;i<n;i++)
        {
            min=999;
            for(j=0;j<n;j++)
                if(!vis[j])
                    if(d[j]<min)
                    {
                        min=d[i];
                        unvis=i;
                    }
            vis[unvis]=true;
            for(j=0;j<n;j++)
                if((cam[unvis][j]!=999)&&(!vis[j]))
                    if(d[j]>(d[unvis]+cam[unvis][j]))
                    {
                        d[j]=d[unvis]+cam[unvis][j];
                        path[j]=unvis;
                    }
        }
    }
    static void print(int path[],int i){
        if(path[i]!=999){
            print(path,path[i]);
            System.out.print("->"+(path[i]+1));
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("n : ");
        int n=sc.nextInt();
        int i,j;
        int cam[][]=new int[n][n];
        System.out.println("enter cost adjacency matrix :-");
        for(i=0;i<n;i++)
            for(j=0;j<n;j++)
                cam[i][j]=sc.nextInt();
        System.out.print("source : ");
        int s=sc.nextInt();
        s=s-1;
        int path[]=new int[n];
        int dis[]=new int[n];
        dijkstras(cam,n,s,path,dis);
        System.out.println("The shortest path to all vertices from source :"+(s+1)+":-");
        for(i=0;i<n;i++){
            System.out.print((i+1)+": "+dis[i]+"= ["+(s+1));
            print(path,i);
            System.out.println("->"+(i+1)+"]");
        }

    }
}