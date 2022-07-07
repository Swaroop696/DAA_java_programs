import java.util.Scanner;
public class knap{
    int get_next(double p_w[],int N){
        int index = -1;
        double largest = p_w[0];
        for(int i =0;i<N;i++){
            if(p_w[i] >= largest)
            {
                largest = p_w[i];
                index = i;
            }
        }
        p_w[index] = -1;
        return index;
    }
    void fill_knap(int N,double C ,double p[],double w[],double[] p_w){
        double cw=0,cp=0;
        int flag[] = new int[N];
        for(int i=0;i<N;i++){
            flag[i] = 0;
        }
        while(cw < C){
            int item = get_next(p_w,N);
            flag[item] = 1;
            if(item == (-1))
                break;
            if((cw + w[item]) <= C){
                cp += p[item];
                cw += w[item];
            }

            else{
                cp += p[item]*((C-cw)/w[item]);
                break;
            }
        }
        for(int i=0;i<N;i++){
            if(flag[i] == 0){
                System.out.println("object " + (i+1) + " was not picked.");
            }
            else{
                System.out.println("object " + (i+1) + " was picked.");
            }
        }
        System.out.println("max profit obtained is : " + cp);

    }
    public static void main(String args[]){
        knap n = new knap();
        double p[] = new double[20];
        double w[] = new double[20];
        double ratio[] = new double[20];
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of elements : ");
        int N = scan.nextInt();
        System.out.println("Enter profits : ");
        for(int i =0;i<N;i++){
            p[i] = scan.nextDouble();
        }      
        System.out.println("Enter weights : ");
        for(int i =0;i<N;i++){
            w[i] = scan.nextDouble();
        }
        System.out.print("Enter capacity : ");
        double C = scan.nextDouble();
        for(int i=0;i<N;i++){
            ratio[i] = p[i]/w[i]; // int/int will not be converted to int
        }

        n.fill_knap(N, C, p, w, ratio);
        scan.close();
    }
}
