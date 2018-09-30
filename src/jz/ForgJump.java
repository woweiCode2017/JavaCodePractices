package jz;


import java.util.Scanner;

/**
 * Created by 11239 on 2018/7/20.
 * 一只青蛙依次跳1或2级，跳上N级台阶有多少中跳法
 * 第一次跳1级，还需要继续跳n-1级
 * 第一次跳2级，还需要跳n-2级
 * 故f(n)=f(n-1)+f(n-2)=2^(n-1)种解法
 */
public class ForgJump {

    public static void main(String[] args) {
       // int [] numbers={1,2,0};
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine().trim());
        int index = 1;
        int numbers[] =new int[num];
        while(num-- > 0){
            numbers[index++] = Integer.parseInt(scanner.nextLine());
        }
        System.out.print(getCount(numbers));
    }

    public static int getCount(int [] numbers){
        //健壮性检验
        if(numbers.length==0)
            return 0;
        if(numbers[0]==0)
            return 0;
        //1.获取数组中所有0，绑定到前一个数字上
        int totalCount=numbers.length;
        int zeroCount=0;
        int[] zeroNumbers=new int[totalCount];
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]==0){
               // zeroNumbers[zeroCount]= (new Integer((''+numbers[i - 1])+ numbers[i])).intValue();
                zeroCount++;
            }
        }
        int trueNumber=totalCount-zeroCount*2;

        //2.破译出这些数字的字母，A对应65-90   a97-122   0-9（48-57）
         return getallCount(trueNumber);
    }

    private static int getallCount(int trueNumber) {
        if (trueNumber==1){
            return 1;
        }
        if(trueNumber==2){
            return 2;
        }
        return getallCount(trueNumber-1)+getallCount(trueNumber-2);
    }

}
