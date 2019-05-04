package com.frozen.frozenleetcode.file;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 框架主函数
 *
 * @author zhangyue
 * @date 2019年3月4日 下午5:32:34
 */
@Slf4j
public class MainFrame {

    private static BufferedWriter bw = null;
    private static final char DOT = ',';
    private static final char NEWLINE = '\n';

    public static void main(String[] args) throws Exception {
//        if (!argsCheck(args)) {
//            System.out.println("params not match: " + Arrays.toString(args)
//                    + ", need inputfile outputfile tempdir!");
//            System.exit(0);
//        }

        final String inputFile = "input.txt";// 输入文件
        final String outputFile = "output.txt";// 输出文件
        final String useTimeFile = "useTime.txt";// 运行用时
        final String tempDir = "tempDir";// 计算用临时目录

        long totalTime = 0;

        try {

            bw = Files.newBufferedWriter(Paths.get(outputFile), StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);

            Solution solution = new Solution();

            // 初始化
            solution.init(tempDir);

            // 执行主体
            long startTime = System.nanoTime();
            solution.process(inputFile);
            long endTime = System.nanoTime();

            // 计时
            totalTime = (endTime - startTime) / 1000;
            Files.write(Paths.get(useTimeFile), String.valueOf(totalTime).getBytes(),
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

        } finally {
            closeWriter(bw);
        }

        System.exit(0);

    }

    private static boolean argsCheck(String[] str) {
        return str == null || str.length == 4;
    }

    public static void addSet(final String[] result) throws Exception {
        int size = result.length;
        bw.write(result[0]);
        for (int i = 1; i < size; i++) {
            bw.write(DOT);
            bw.write(result[i]);
        }
        bw.write(NEWLINE);
    }

    private static void closeWriter(BufferedWriter bw) throws IOException {
        if (bw != null) {
            bw.close();
        }
    }

    public static class Solution {

        /**
         * 初始化
         *
         * @param tempDir 可读写的临时目录
         */
        public void init(String tempDir) throws Exception {
            // 此部分不计入执行用时，提供了临时目录用于暂存数据，请合理发挥。
        }

        /**
         * 主体逻辑实现demo，实现代码时请注意逻辑严谨性，涉及到操作文件时，保证文件有开有闭等。
         *
         * @param inputPath 输入文件路径，请不要hack它-_-。
         */
        public void process(String inputPath) throws Exception {
            //倒排索引
            Map<String, Set<String>> invertedIndexMap = new HashMap<>();
            //保存路径
            Set<Set<String>> route = new HashSet<>();
            //try-with-resources
            try (FileReader reader = new FileReader(inputPath);
                 BufferedReader br = new BufferedReader(reader)
            ) {
                String line;
                // 一次读入一行数据
                while ((line = br.readLine()) != null) {
                    String[] keys = line.split(",");
                    boolean flag = true;
                    Set<String> newSet = new HashSet<>();
                    //倒排索引值
                    //分割后循环每一行
                    for (String key : keys) {
                        newSet.add(key);
                        Set<String>  invertedIndexSet = invertedIndexMap.get(key);
                        if (invertedIndexSet != null) {
                            newSet.addAll(invertedIndexSet);
                            for(String k:invertedIndexSet){
                                invertedIndexMap.put(k,newSet);
                            }
                        }else{
                            invertedIndexMap.put(key,newSet);
                        }
                    }
                }
            } catch (Exception e) {
                log.error("writeFileBio readFileBio ", e);
            }
            for (Set<String>  invertedIndexSet : invertedIndexMap.values()) {
                route.add(invertedIndexSet);
            }
            for (Set<String> set : route) {
                //请通过此方法写出答案，每调用一次会输出一行记录。
                String[] array = set.toArray(new String[0]);
                MainFrame.addSet(array);
            }
        }

//        private static class InvertedIndex {
//            private Set<String> invertedIndexSet;
//
//            public Set<String> getInvertedIndexSet() {
//                return invertedIndexSet;
//            }
//
//            public void setInvertedIndexSet(Set<String> invertedIndexSet) {
//                this.invertedIndexSet = invertedIndexSet;
//            }
//        }
    }

}