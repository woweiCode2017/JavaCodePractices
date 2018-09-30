package jz;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by 11239 on 2018/7/22.
 *
 * @ 输入：字符串
 * @ 输出：这个字符串是不是有效ip(分别判断了IPv4和IPv6)
 * @ note: 在IPv4中 0.0.0.0段的ip视为无效
 * 在IPv6中 :: 视为有效ip
 */

//**判断规则：first 首先判断字符串是否只包含数字，(:)，(.)
//                  如果不成立，直接输出不是有效ip
//            second 判断是否只包含 数字和(.)
//                  如果成立判断是否是有效IPv4 --> IPv4断定
//                  如果不成立，判断是否是有效IPv6
//  using Java

public class IsIP {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String str = s.nextLine();
            if (!Pattern.matches("[0-9a-fA-F:.]+", str)) {
                System.out.println("不是一个有效的ip地址");
            } else if (Pattern.matches("[0-9]+[.][0-9]+[.][0-9]+[.][0-9]+", str)) {  //判断是否是ipv4格式
                isIPv4(str);
            }
            //==========以下为IPv6的判断=================
            else if (Pattern.matches("([0-9a-fA-F]{1,4}[:]){7}[0-9a-fA-F]{1,4}", str)) {
                System.out.println("是一个有效的ip地址");
            } else if (str == "::") {
                System.out.println("是一个有效的ip地址");
            } else if (Pattern.matches("^(([0-9a-f]{1,4}:){1,6})((:[0-9a-f]{1,4}){1,6})", str)) {//判断2::2:2:22是否有效
                str = str.replaceAll(":", " ");
                String[] strings = str.split("\\s+");
                if (str.length() <= 7) {
                    System.out.println("是一个有效的ip地址");
                } else
                    System.out.println("不是一个有效的ip地址");
            } else if (Pattern.matches("([0-9a-fA-F]{1,4}:){1,7}:", str)) {   //判断 1:1::
                System.out.println("是一个有效的ip地址");
            } else if (Pattern.matches(":(:[0-9a-fA-F]{1,4}){1,7}", str)) {  //判断 ::1:1
                System.out.println("是一个有效的ip地址");
            } else if (Pattern.matches("([0-9a-fA-F]{1,4}:){6}(([0-9]+.){3}[0-9]+)", str)) {  //判断 4:4:4:4:4:4:10.90.20.0是否有效
                str = str.substring(str.lastIndexOf(":") + 1, str.length());
                iPv6IncludeIPv4(str);
            } else if (Pattern.matches("([0-9a-fA-F]{1,4}:){1,5}:(([0-9]+.){3}[0-9]+)", str)) { // 判断 1::1.1.1.1
                str = str.substring(str.lastIndexOf(":") + 1, str.length());
                iPv6IncludeIPv4(str);
            } else if (Pattern.matches("::([0-9a-fA-F]{1,4}:){0,5}(([0-9]+.){3}[0-9]+)", str)) {  // 判断  ::1.1.1.1
                str = str.substring(str.lastIndexOf(":") + 1, str.length());
                iPv6IncludeIPv4(str);
            } else if (Pattern.matches("([0-9a-fA-F]{1,4}:){1,4}(:[0-9a-fA-F]{1,4}){1,4}:(([0-9]+.){3}[0-9]+)", str)) {  //判断 1::1:1:1.1.1.1
                String m = str.substring(0, str.lastIndexOf(":"));
                String[] mm = m.replaceAll(":", " ").split("\\s+");
                if (mm.length <= 5) {
                    str = str.substring(str.lastIndexOf(":") + 1, str.length());
                    iPv6IncludeIPv4(str);
                } else {
                    System.out.println("不是一个有效的ip地址");
                }
            } else {
                System.out.println("不是一个有效的ip地址");
            }
        }
    }

    public static void isIPv4(String str) {
        String[] sp = str.split("\\.");
        //判断每个字段的范围是否有效  另外需要判断 10.01.0.0是不合法的 10.0.0.0是有效的
        if (Integer.parseInt(sp[0]) > 0 && Integer.parseInt(sp[0]) < 256 && sp[0].equals(String.valueOf(Integer.parseInt(sp[0]))) &&
                Integer.parseInt(sp[1]) >= 0 && Integer.parseInt(sp[1]) < 256 && sp[1].equals(String.valueOf(Integer.parseInt(sp[1]))) &&
                Integer.parseInt(sp[2]) >= 0 && Integer.parseInt(sp[2]) < 256 && sp[2].equals(String.valueOf(Integer.parseInt(sp[2]))) &&
                Integer.parseInt(sp[3]) >= 0 && Integer.parseInt(sp[3]) < 256 && sp[3].equals(String.valueOf(Integer.parseInt(sp[3]))))
            System.out.println("是一个有效的ip地址");
        else
            System.out.println("不是一个有效的ip地址");
    }

    public static void iPv6IncludeIPv4(String str) {
        String[] sp = str.split("\\.");
        //判断每个字段的范围是否有效  另外需要判断 10.01.0.0是不合法的 10.0.0.0是有效的
        if (Integer.parseInt(sp[0]) >= 0 && Integer.parseInt(sp[0]) < 256 && sp[0].equals(String.valueOf(Integer.parseInt(sp[0]))) &&
                Integer.parseInt(sp[1]) >= 0 && Integer.parseInt(sp[1]) < 256 && sp[1].equals(String.valueOf(Integer.parseInt(sp[1]))) &&
                Integer.parseInt(sp[2]) >= 0 && Integer.parseInt(sp[2]) < 256 && sp[2].equals(String.valueOf(Integer.parseInt(sp[2]))) &&
                Integer.parseInt(sp[3]) >= 0 && Integer.parseInt(sp[3]) < 256 && sp[3].equals(String.valueOf(Integer.parseInt(sp[3]))))
            System.out.println("是一个有效的ip地址");
        else
            System.out.println("不是一个有效的ip地址");
    }
}

