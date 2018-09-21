//http://acm.timus.ru/problem.aspx?space=1&num=1671
import java.util.*;
public class exa2 {
    static int count;
    static int t[];
    static void bild(int n){
        count=n;
        t=new int[n];
        for(int i=0;i<n;i++){
            t[i]=i;
        }
    }
    static int find(int a){
        if(t[a]==a){
            return a;
        }
        return t[a]=find(t[a]);
    }
    static void join(int a,int b){
        int q=(int)(Math.random()*1000);
        if(find(a)==find(b)){
            return;
        }
        count--;
        if(q%2==0){
            t[find(a)]=find(b);
        }else{
            t[find(b)]=find(a);
        }
    }
    public static void main(String[] args) {
        Locale.setDefault(new Locale("C"));
        Scanner sc=new Scanner(System.in,"UTF-8");;
        int n=sc.nextInt();
        int m=sc.nextInt();
        int v[][]=new int[m][2];
        for(int i=0;i<m;i++){
            v[i][0]=sc.nextInt();
            v[i][0]--;
            v[i][1]=sc.nextInt();
            v[i][1]--;
        }
        int t=sc.nextInt();
        int tmp[]=new int [t];
        int ans[]=new int [t];
        Set<Integer> mySet=new HashSet<>();
        for(int i=t-1;i>=0;i--){
            int x=sc.nextInt();
            x--;
            tmp[i]=x;
            mySet.add(x);
        }
        bild(n);
        for(int i=0;i<m;i++){
            if(!mySet.contains(i)){
                join(v[i][0],v[i][1]);
            }
        }
        for(int i=0;i<t;i++){
            ans[i]=count;
            join(v[tmp[i]][0],v[tmp[i]][1]);
        }
        for(int i=0;i<t/2;i++){
            int x= ans[i];
            ans[i]=ans[t-1-i];
            ans[t-1-i]=x;
        }
        for(int i=0;i<t;i++){
            System.out.print(ans[i]+" ");
        }
    }
}
