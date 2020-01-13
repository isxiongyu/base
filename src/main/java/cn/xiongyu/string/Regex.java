package cn.xiongyu.string;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * ClassName: Regex
 * Package: cn.xiongyu.string
 * Description:
 * Date: 19-10-9 上午11:25
 * Author: xiongyu
 */
public class Regex {

    public List<String> removeComments(String[] source) {
        //   //
        String regex1 = ".*//.*";
        //   /*
        String regex2 = ".*/\\*.*";
        //   */
        String regex3 = ".*\\*/.*";
        //   //.../*
        String regex4 = ".*//.*/\\*.*";
        //   /*...//
        String regex5 = ".*/\\*.*//.*";
        //   /*...//
        String regex6 = ".*/\\*.*/\\*/.*";
        List<String> result = new ArrayList<>();
        System.out.println(source.length);
        for (int i = 0; i < source.length; i++) {
            if (source[i] == null)
                continue;
            if (!Pattern.matches(regex1, source[i]) && !Pattern.matches(regex2, source[i])) {
                result.add(source[i]);
            } else if (Pattern.matches(regex6, source[i])) {
                StringBuffer sb = new StringBuffer(source[i]);
                int left = 0;
                int right = 0;
                for (int j = 0; j < source[i].length() - 1; j++) {
                    if (source[i].substring(j, j + 2).equals("/\\*")) {
                        left = j;
                    }
                    if (source[i].substring(j, j + 2).equals("\\*/")) {
                        right = j + 2;
                    }
                    sb.delete(left, right);
                }
                result.add(sb.toString());
            } else if (Pattern.matches(regex2, source[i]) && !Pattern.matches(regex4, source[i])) {
                for (int j = 0; j < source[i].length() - 1; j++) {
                    if (source[i].substring(j, j + 2).equals("/\\*")) {
                        if (j == 0)
                            break;
                        result.add(source[i].substring(0, j));
                    }
                }
                i++;
                while (!Pattern.matches(regex3, source[i])) {
                    i++;
                }
                for (int j = 0; j < source[i].length() - 1; j++) {
                    if (source[i].substring(j, j + 2).equals("\\*/")) {
                        if (j == source[i].length() - 2)
                            break;
                        result.add(source[i].substring(j + 2));
                    }
                }
            }else if (Pattern.matches(regex1, source[i]) && !Pattern.matches(regex5, source[i])) {
                for (int j = 0; j < source[i].length() - 1; j++) {
                    if (source[i].substring(j, j + 2).equals("//")) {
                        if (j == 0)
                            break;
                        result.add(source[i].substring(0, j));
                    }
                }
            } else {
                result.add(source[i]);
            }
        }
        return result;
    }

//    public static void main(String[] args) {
//        String regex = ".*//.*/\\*.*";
//        String s = "sdfkjsd//lkf/*djfshjdkkfsd";
//        boolean matches = Pattern.matches(regex, s);
//        System.out.println(matches);
//    }
    public static void main(String[] args) {
        String[] sources = new String[]{"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"};
        Regex regex = new Regex();
        List result = regex.removeComments(sources);
        System.out.println(result);
    }
}
