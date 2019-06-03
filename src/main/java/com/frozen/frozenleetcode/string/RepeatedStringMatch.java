package com.frozen.frozenleetcode.string;

/**
 * @author: Frozen
 * @create: 2019-06-03 09:59
 * @description: 686.  Repeated String Match
 * Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.
 * For example, with A = "abcd" and B = "cdabcdab".
 * Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").
 * Note:
 * The length of A and B will be between 1 and 10000.
 **/
public class RepeatedStringMatch {
    public static void main(String[] args){
        RepeatedStringMatch repeatedStringMatch = new RepeatedStringMatch();
        String A = "abcd";
        String B = "cdabcdab";
        System.out.println(repeatedStringMatch.repeatedStringMatch( A,  B));
    }
    public int repeatedStringMatch(String A, String B) {
        if(A==null||B==null||A==""||B==""||A.length()==0||B.length()==0){
            return -1;
        }
        byte[] a = A.getBytes();
        byte[] b = A.getBytes();
        int indexb = 0;
        for(int indexa = 0;indexa<A.length();indexa++){
            if(b[indexb]==a[indexa]){
                for(;indexb<B.length();indexb++){

                }
            }
        }
        if(indexb<=B.length()-1){
            return -1;
        }
        return -1;
    }
}
