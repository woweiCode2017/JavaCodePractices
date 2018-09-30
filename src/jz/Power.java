package jz;

/**
 * Created by 11239 on 2018/7/29.
 * 给定一个double类型的浮点数 base
 * 和一个int类型的整数 exponent
 * 求base的exponent次方
 */
public class Power {
    public static double Power(double base,int exponent){
        if(exponent==0)
            return 1;
        if(exponent==1)
            return base;
        double result=1.0;
        int exOld=exponent>0?exponent:-exponent;
        while(exOld!=0){
            if((exOld&1)==1)
                result*=base;
            exOld>>=1;
            base*=base;
        }
        return exponent>0?result:1/result;
    }

}
