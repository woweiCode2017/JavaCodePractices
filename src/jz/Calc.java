package jz;

import java.util.Scanner;

/**
 * Created by 11239 on 2018/7/19.
 * 在棋盘路径上，随机生成几个配送点，配送员从原点出发，配送完成后回到原点，已知几个配送点坐标，求最短路线
 *
 * 可采用图论中的贪婪算法，求最小路径
 *
 * 贪婪算法
 */
public class Calc {
        private static int[][] distanceMat; // 距离矩阵
        static int[] colable;
        static int[] row;
        static int calculate(String[] locations) {

            int pointNum=locations.length;
            distanceMat= new int[pointNum][pointNum];

            for (int i = 0; i < pointNum - 1; i++) {
                distanceMat[i][i] = 0;
                for (int j = i + 1; j < pointNum; j++) {
                    distanceMat[i][j]=distance(locations[i],locations[j]);
                    distanceMat[j][i]=distanceMat[i][j];
                }
            }

            colable = new int[pointNum];
            colable[0] = 0;
            for (int i = 1; i < pointNum; i++) {
                colable[i] = 1;
            }

            row = new int[pointNum];
            for (int i = 0; i < pointNum; i++) {
                row[i] = 1;
            }

            int[] temp = new int[pointNum];
            String path="0";

            int s=0;//计算距离
            int i=0;//当前节点
            int j=0;//下一个节点
            //默认从0开始
            while(row[i]==1){
                //复制一行
                for (int k = 0; k < pointNum; k++) {
                    temp[k] = distanceMat[i][k];
                }
                j = selectmin(temp,pointNum);
                //找出下一节点
                row[i] = 0;//行置0，表示已经选过
                colable[j] = 0;//列0，表示已经走过

                path+="-->" + j;
                s = s + distanceMat[i][j];
                i = j;//当前节点指向下一节点
            }
            System.out.println("路径:" + path);
            return s;
        }

        public static int selectmin(int[] p,int pointnum){
            int j = 0, m = p[0], k = 0;
            //寻找第一个可用节点，注意最后一次寻找，没有可用节点
            while (colable[j] == 0) {
                j++;
                if(j>=pointnum){
                    //没有可用节点，说明已结束，最后一次为 *-->0
                    m = p[0];
                    break;
                }
                else{
                    m = p[j];
                }
            }
            //从可用节点J开始往后扫描，找出距离最小节点
            for (; j < pointnum; j++) {
                if (colable[j] == 1) {
                    if (m >= p[j]) {
                        m = p[j];
                        k = j;
                    }
                }
            }
            return k;
        }


        static int distance(String firstP,String secondP) {
            String[] fpoints=firstP.split(",");
            int fpX=Integer.parseInt(fpoints[0]);
            int fpY=Integer.parseInt(fpoints[1]);

            String[] spoints=secondP.split(",");
            int spX=Integer.parseInt(spoints[0]);
            int spY=Integer.parseInt(spoints[1]);

            int dis=Math.abs(fpX-spX)+Math.abs(fpY-spY);
            return dis;
        }

        public static void main(String[] args){
            Scanner scanner = new Scanner(System.in);
            int num = Integer.parseInt(scanner.nextLine().trim());
            int index = 1;
            String[] locations = new String[num+1];
            locations[0]="0,0";
            while(num-- > 0){
                locations[index++] = scanner.nextLine();
            }

            System.out.println(calculate(locations));
        }
    }

