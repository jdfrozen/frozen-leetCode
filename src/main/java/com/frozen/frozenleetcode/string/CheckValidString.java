package com.frozen.frozenleetcode.string;

import java.util.LinkedList;

/**
 * @author: Frozen
 * @create: 2019-07-14 20:09
 * @description: 678. 有效的括号字符串
 **/
public class CheckValidString {
    public static void main(String[] args) {
        CheckValidString checkValidString = new CheckValidString();
        String s = "";
        boolean result = checkValidString.checkValidString(s);
        System.out.println(result);
    }

    public boolean checkValidString(String s) {
        if(s==null){
            return false;
        }
        final char a = '(';
        final char b = ')';
        final char cs = '*';
        LinkedList<Character> listLeft = new LinkedList();
        LinkedList listWhere = new LinkedList();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (a == c) {
                listLeft.add(c);
                continue;
            }
            if (a == cs) {
                listWhere.add(c);
                continue;
            }
            if (a == b) {
                int lsize = listLeft.size();
                int wsize = listWhere.size();
                if (lsize == 0 && listWhere.size() == 0) {
                    return false;
                }
                if (lsize > 0) {
                    listLeft.removeLast();
                    continue;
                }
                if (wsize > 0) {
                    listWhere.removeLast();
                    continue;
                }
            }
        }
        if(listLeft.size()>listWhere.size()){
            return false;
        }
        return true;
    }
}
