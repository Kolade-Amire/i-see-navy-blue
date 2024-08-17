package code.leetcode75;



/*
You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.

Return the merged string.



Example 1:

Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"
Explanation: The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r
Example 2:

Input: word1 = "ab", word2 = "pqrs"
Output: "apbqrs"
Explanation: Notice that as word2 is longer, "rs" is appended to the end.
word1:  a   b
word2:    p   q   r   s
merged: a p b q   r   s
Example 3:

Input: word1 = "abcd", word2 = "pq"
Output: "apbqcd"
Explanation: Notice that as word1 is longer, "cd" is appended to the end.
word1:  a   b   c   d
word2:    p   q
merged: a p b q c   d


Constraints:

1 <= word1.length, word2.length <= 100
word1 and word2 consist of lowercase English letters.
 */


public class MergeStringsAlt {

    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc", "pqr"));
        System.out.println(mergeAlternately("ab", "pqrs"));
        System.out.println(mergeAlternately("abcd", "pq"));
    }

    //Approach 1
    public static String mergeAlternately(String word1, String word2) {
        StringBuilder mergedString = new StringBuilder();


        int shortestStringLength = Math.min(word1.length(), word2.length());
        String longestString = word1.length() >= word2.length() ? word1 : word2;

        //uses the length of the shortest string for the loop to match the characters evenly
        for (int i = 0; i < shortestStringLength; i++) {
            mergedString.append(word1.charAt(i)).append(word2.charAt(i));
        }

        //merges the remaining characters from the longest string to the merged string
        String leftOverString = longestString.substring(shortestStringLength);
        return mergedString.toString()+leftOverString;
    }


    //Approach 2
    public static String mergeAlternately2(String word1, String word2) {

        StringBuilder mergedString = new StringBuilder();

        int i = 0, j = 0;
        // Loop through both strings
        while (i < word1.length() && j < word2.length()) {
            mergedString.append(word1.charAt(i));  // Add character from word1
            mergedString.append(word2.charAt(j));  // Add character from word2
            i++;
            j++;
        }

        // Append the remaining characters from word1, if any
        while (i < word1.length()) {
            mergedString.append(word1.charAt(i));
            i++;
        }

        // Append the remaining characters from word2, if any
        while (j < word2.length()) {
            mergedString.append(word2.charAt(j));
            j++;
        }

        return mergedString.toString();
    }
}
