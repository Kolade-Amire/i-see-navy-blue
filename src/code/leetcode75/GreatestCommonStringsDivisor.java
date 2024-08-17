package code.leetcode75;



/*
For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).

Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.



Example 1:

Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"
Example 2:

Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"
Example 3:

Input: str1 = "LEET", str2 = "CODE"
Output: ""


Constraints:

1 <= str1.length, str2.length <= 1000
str1 and str2 consist of English uppercase letters.
 */


public class GreatestCommonStringsDivisor {
    public static void main(String[] args) {
        System.out.printf("""
                        Approach 1
                        %s
                        %s
                        %s
                        """, gcdOfStrings("ABCABC", "ABC"), gcdOfStrings("ABABAB", "AB"), gcdOfStrings("LEET", "CODE"));




    }

    public static String gcdOfStrings(String str1, String str2) {
        int gcdValue = gcd(str1.length(), str2.length());

        String gcdString = str1.substring(0, gcdValue);

        int quotient1 = str1.length() / gcdValue;
        int quotient2 = str2.length() / gcdValue;

        //reconstructing the strings to see if they match
        StringBuilder str1Builder = new StringBuilder().append(String.valueOf(gcdString).repeat(quotient1));
        StringBuilder str2Builder = new StringBuilder().append(String.valueOf(gcdString).repeat(quotient2));

        if (str1Builder.toString().equals(str1) && str2Builder.toString().equals(str2)) {
            return gcdString;
        }


        return "";
    }


    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    //Approach 2
    public String gcdOfStrings2(String str1, String str2) {
        if (str1.length() < str2.length())
            return gcdOfStrings2(str2, str1);
        if (!str1.startsWith(str2))
            return "";
        if (str2.isEmpty())
            return str1;
        return gcdOfStrings2(str2, mod(str1, str2));
    }

    private String mod(String s1, final String s2) {
        while (s1.startsWith(s2))
            s1 = s1.substring(s2.length());
        return s1;
    }
}
