package com.decmoon.decluna;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {


        String bug1 = "GEOContains(ROW,R);CountryContains(US,ZH);MyContains(A,B,C)";

        String s1 = s(bug1);
        System.out.println("===============================");

        System.out.println("main :  " + s1);
    }


    public static String s(String string) {
        final String reg_sp = "\\^";
        final String sp = "^";
        String finalString = "";
        if (string.contains(sp)) {
            String[] split = string.split(reg_sp);
            for (String s : split)
                finalString += as(s) + "^";
        } else
            finalString = as(string);

        if (finalString.contains(",")) {
            String f = finalString;
            while (f.contains(","))
                f = s(finalString);
            return f;
        }
        return finalString;
    }

    private static String as(String string) {
        final String sp = ",";
        final String lk = "(";
        final String fh = ";";
        if (!(string.length() - 1 == string.lastIndexOf(";")))
            string += fh;
        int location;
        if ((location = string.indexOf(sp)) != -1) {
            String before = string.substring(0, location);
            String temp = string.substring(location);
            String now = temp.substring(1);
            String after = now.substring(now.indexOf(fh));
            int lkLocation = before.lastIndexOf(lk);
            String beforeWithout;
            if (before.contains("^"))
                beforeWithout = before.substring(before.lastIndexOf("^") + 1, lkLocation);
            else
                beforeWithout = before.substring(0, lkLocation);
            String newString = before + ")" + after;
            String finalString = newString + "^" + beforeWithout + "(" + now;
            return finalString;
        } else
            return string;
    }


}
