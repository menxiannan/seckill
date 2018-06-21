package org.seckill.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 12084
 * @create 2018-06-21 8:46
 */

public class RegexUtil {

    public static boolean t1(String regexStr, String context) {

        if (Pattern.matches(regexStr, context)) {
            return true;
        }

        return false;
    }

    public static void t2() {
        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(\\D*)(\\d)(.*)";
        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        if (m.find()) {
            System.out.println(m.group(0));
            System.out.println(m.group(1));
            System.out.println(m.group(2));
            System.out.println(m.group(3));
        } else {
            System.out.println("NO MATCH");

        }
    }

    public static void main(String[] args) {
//        String reg = ".*mxn";
//        String str = "mxn";
//        System.out.println(t1(reg, str));

        t2();

    }


}
