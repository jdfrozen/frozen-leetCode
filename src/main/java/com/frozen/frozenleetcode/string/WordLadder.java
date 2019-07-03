package com.frozen.frozenleetcode.string;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Frozen
 * @create: 2019-07-01 09:39
 * @description: 127. Word Ladder
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 * <p>
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 * <p>
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 **/
public class WordLadder {
    public static void main(String[] args) {
        WordLadder wordLadder = new WordLadder();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordLadder.ladderLength(beginWord, endWord, wordList);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (StringUtils.isEmpty(beginWord) || StringUtils.isEmpty(endWord) || CollectionUtils.isEmpty(wordList)) {
            return 0;
        }

        return 0;
    }
}
