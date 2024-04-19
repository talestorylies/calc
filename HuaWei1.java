package suanfa;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.min;

public class HuaWei1 {
    /**
     *
     * 给定一个非空字符串S，其被N个‘-’分隔成N+1的子串，给定正整数K，要求除第一个子串外，其余的子串每K个字符组成新的子串，并用‘-’分隔。对于新组成的每一个子串，如果它含有的小写字母比大写字母多，则将这个子串的所有大写字母转换为小写字母；反之，如果它含有的大写字母比小写字母多，则将这个子串的所有小写字母转换为大写字母；大小写字母的数量相等时，不做转换。
     * 输入描述:
     * 输入为两行，第一行为参数K，第二行为字符串S。
     * 输出描述:
     * 输出转换后的字符串。
     * 示例1
     * 输入
     * 3
     * 12abc-abCABc-4aB@
     * 输出
     * 12abc-abc-ABC-4aB-@
     * 说明
     * 子串为12abc、abCABc、4aB@，第一个子串保留，后面的子串每3个字符一组为abC、ABc、4aB、@，abC中小写字母较多，转换为abc，ABc中大写字母较多，转换为ABC，4aB中大小写字母都为1个，不做转换，@中没有字母，连起来即12abc-abc-ABC-4aB-@
     * 示例2
     * 输入
     * 12
     * 12abc-abCABc-4aB@
     * 输出
     * 12abc-abCABc4aB@
     * 说明
     * 子串为12abc、abCABc、4aB@，第一个子串保留，后面的子串每12个字符一组为abCABc4aB@，这个子串中大小写字母都为4个，不做转换，连起来即12abc-abCABc4aB@
     *
     * 作者：yaozi
     * 链接：https://leetcode.cn/circle/discuss/niKSMZ/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * **/
public static String translate(String s, int k){
    StringBuilder result = new StringBuilder();
    StringBuilder temp =new StringBuilder();

   int index = s.indexOf("-");
   String headstr = s.substring(0,index);
   String leftstr = s.substring(index+1);


    leftstr = leftstr.replace("-","");
   result.append(headstr).append("-");
   int upcount =0;
   int lowcount=0;
   for(int i=0;i<leftstr.length();i++){
       char c = leftstr.charAt(i);
       temp.append(c);

       if(Character.isUpperCase(c)){upcount++;}
       if(Character.isLowerCase(c)){lowcount++;}

       if (temp.length()==k){

           if(lowcount>upcount){
               result.append( temp.toString().toLowerCase());
           }
           if (lowcount<upcount){
               result.append( temp.toString().toUpperCase());
           }else {result.append(temp);}

           result.append("-");
           temp.setLength(0);
           upcount =0;
           lowcount=0;
       }
   }

    // 处理最后一个子串
    if (temp.length() > 0) {
        if (upcount > lowcount) {
            result.append(temp.toString().toUpperCase());
        } else if (lowcount > upcount) {
            result.append(temp.toString().toLowerCase());
        } else {
            result.append(temp);
        }
    }

return result.toString();
}
















    public static String trans(String str, int k) {
        StringBuilder result = new StringBuilder();

        // 拆分头部和子串
        int index = str.indexOf('-');
        String heads = str.substring(0, index);
        String s = str.substring(index + 1);
        // 将子串中的-移除
        s = s.replace("-", "");

        // 处理第一个子串
        result.append(heads);

        // 处理剩余的子串
        StringBuilder temp = new StringBuilder();
        int upcount = 0, lowcount = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            temp.append(c);
            if (Character.isLowerCase(c)) {
                lowcount++;
            } else {
                upcount++;
            }

            // 每 k 个字符为一组，处理转换并添加到结果中
            if (temp.length() == k) {
                result.append("-");
                if (upcount > lowcount) {
                    result.append(temp.toString().toUpperCase());
                } else if (lowcount > upcount) {
                    result.append(temp.toString().toLowerCase());
                } else {
                    result.append(temp);
                }

                temp.setLength(0);
                upcount = 0;
                lowcount = 0;
            }
        }

        // 处理最后一个子串
        if (temp.length() > 0) {
            if (upcount > lowcount) {
                result.append("-");
                result.append(temp.toString().toUpperCase());
            } else if (lowcount > upcount) {
                result.append(temp.toString().toLowerCase());
            } else {
                result.append("-").append(temp);
            }
        }

        return result.toString();
    }




    public static void main(String[] args){
        String s = "12abc-abc-ABC-4aB-@";
        System.out.print("原字符串：\n "+s +"\n");

       System.out.print("\n translate 新字符串：\n "+ translate(s,4)+"\n");
        System.out.print("\n trans 新字符串：\n "+ trans(s,4)+"\n");




//        char[] ch ={'A','B','C','D','E','F'};
//
//        String str = new String(ch);
//        int a1 = str.indexOf('c');
//        int a2 =  str.indexOf('A');


    }
}
