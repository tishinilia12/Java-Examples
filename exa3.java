//http://acm.timus.ru/problem.aspx?space=1&num=1073
import java.util.*;
public class exa3 {

    public static void main(String[] args) {
        Locale.setDefault(new Locale("C"));
        Scanner sc=new Scanner(System.in,"UTF-8");;
        int n= sc.nextInt();
        int v[]=new int[n+1];
        for(int i=0;i<n;i++){
            v[i]=100000000;
        }
        v[n]=0;
        for(int i=n;i>0;i--){
            for(int j=1;j*j<=i;j++){
                v[i-j*j]=Math.min(v[i]+1,v[i-j*j]);
            }
        }
        System.out.println(v[0]);
    }
}
