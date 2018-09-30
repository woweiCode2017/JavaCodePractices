package jz;

/**
 * Created by 11239 on 2018/7/28.
 *
 * f(0)=0;f(1)=1
 * f(n)=f(n-1)+f(n-2)
 * 求斐波那契数列的第n项
 */
public class Fibonacci {
    public int Fibonacci(int n){
        int [] result={0,1};
        if(n<2){
            return result[n];
        }
        int first=0,second=1;
        int num=0;
        for(int i=2;i<=n;i++){
           num=first+second;
           first=second;
           second=num;
        }
        return num;
    }
}
