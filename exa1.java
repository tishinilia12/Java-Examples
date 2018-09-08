//   http://acm.timus.ru/problem.aspx?space=1&num=1821
import java.util.*;
class Triple <T1 extends Comparable<T1>,
T2 extends Comparable<T2>,T3 extends Comparable<T3>>
 implements Comparable<Triple <T1, T2,T3>>{
    public T1 first;
    public T2 second;
    public T3 third;
    public int compareTo(Triple<T1,T2,T3> a){
        int b=this.first.compareTo(a.first);
        if(b!=0){
            return b;
        }
        b=this.second.compareTo(a.second);
        if(b!=0){
            return b;
        }
        b=this.third.compareTo(a.third);
        return b;
    }
}
public class exa1 {
    public static int f(Scanner sc){
        String a=sc.next();
        int b = (int) a.charAt(0) * 6000;
        b+= (int) a.charAt(1) * 600;
        b+=(int)a.charAt(3)*100;
        b+=(int)a.charAt(4)*10;
        b+=(int)a.charAt(6);
        return b;
    }
    public static void main(String[] args) {
        Locale.setDefault(new Locale("C"));
        Scanner sc=new Scanner(System.in,"UTF-8");
        int n=sc.nextInt();
        Vector<Triple<Integer,Integer,String>> v=
                new Vector<Triple<Integer,Integer,String>>();
        Triple<Integer,Integer,String> tmp=new
                Triple<Integer,Integer,String>();
        int a=0;
        for(int i=0;i<n;i++){
            tmp=new Triple<Integer,Integer,String>();
            tmp.third=sc.next();
            tmp.second=HW.f(sc);
            tmp.first=tmp.second+a;
            a+=300;
            v.add(tmp);
        }
        /*for(int i=0;i<v.size();i++){
            tmp=v.elementAt(i);
            System.out.println(tmp.second);
        }*/
        Collections.sort(v);
        Vector<String> vs=new Vector<String>();
        int max=1000000000;
        //System.out.println(max);
        for(int i=0;i<v.size();i++){
            tmp=v.elementAt(i);
            /*System.out.print(tmp.first+" ");
            System.out.print(tmp.second+" ");
            System.out.println(tmp.third);*/
            if(tmp.second<max){
                max=tmp.second;
                vs.add(tmp.third);
            }
        }
        System.out.println(vs.size());
        Collections.sort(vs);
        for(int i=0;i<vs.size();i++){
            System.out.println(vs.elementAt(i));
        }
    }
}
