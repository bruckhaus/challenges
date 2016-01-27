public class StringSimilarity {
    // String Similarity   Coding Strings Knuth Morris Prat Algorithm Algorithms difficult
    // QUESTION DESCRIPTION
    // For two strings A and B, we define the similarity of the strings to be the length of the longest prefix common
    // to both strings. For example, the similarity of strings “abc” and “abd” is 2, while the similarity of strings
    // “aaa” and “aaab” is 3.
    // Calculate the sum of similarities of a string S with each of its suffixes, including the string itself as the
    // first suffix.
    // Input Format:
    // The first line contains the number of test cases T. Each of the next T lines contains a string each.
    // Output Format:
    // Output T lines, each containing one integer that is the answer for the corresponding test case.
    // Constraints:
    //         1 ≤ T ≤ 10
    // The length of each string is at most 100,000
    // The strings contain only lowercase characters [a-z].
    // Sample Input 0:
    //         2
    // ababaa
    //         aa
    // Sample Output 0:
    //         11
    //         3
    // Explanation 0:
    // For the first case, the suffixes of the string are “ababaa”, “babaa”, “abaa”, “baa”, “aa” and “a”. The
    // similarities of each of these strings with the string “ababaa” are 6,0,3,0,1,1 respectively. Thus the answer is
    // 6 + 0 + 3 + 0 + 1 + 1 = 11.
    // For the second case, the answer is 2 + 1 = 3.

    public static void main(String[] args) {
        // TODO: implement StringSimilarity
    }

}
