import java.util.*;
import java.io.*;
import java.math.*;


public class Send {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("C"));
        Scanner sc=new Scanner(System.in,"UTF-8");
        int n= sc.nextInt();
        int m=sc.nextInt();
        int a =sc.nextInt();
        int b = sc.nextInt();
        long g0= sc.nextInt();
        long x=sc.nextInt();
        long y =sc.nextInt();
        long z = sc.nextInt();
        int v[][] = new int[n][m];
        int v1[][] = new int[n][m-b+1];
        //System.out.println
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                v[i][j]=(int) g0;
                g0=(g0*x+y)%z;
            }
        }
        for(int i=0;i<n;i++){
            Deque<Integer> dq=new LinkedList<Integer>();
            for(int j=0;j<m;j++){
                while(!dq.isEmpty() && dq.getLast()>v[i][j]){
                    dq.removeLast();
                }
                dq.addLast(v[i][j]);
                if(j>=b-1){
                    v1[i][j-b+1]=dq.getFirst();
                    if(dq.getFirst()==v[i][j-b+1]){
                        dq.removeFirst();
                    }
                }
            }
        }
        long ans=0;
        for(int j=0;j<m-b+1;j++){
            Deque<Integer> dq=new LinkedList<Integer>();
            for(int i=0;i<n;i++){
                while(!dq.isEmpty() && dq.getLast()>v1[i][j]){
                    dq.removeLast();
                }
                dq.addLast(v1[i][j]);
                if(i>=a-1){
                    ans+=(long)dq.getFirst();
                    if(dq.getFirst()==v1[i-a+1][j]){
                        dq.removeFirst();
                    }
                }
            }
        }
        System.out.println(ans);
    }
}