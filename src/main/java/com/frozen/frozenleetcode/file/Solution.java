package com.frozen.frozenleetcode.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
/**
 * 请在此类中完成解决方案，需要实现init完成数据初始化，实现process完成数据的处理逻辑。
 * 
 * @author zhangyue
 * @date 2019年3月4日 下午3:38:00
 */
public class Solution {

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
                e.printStackTrace();
                //log.error("writeFileBio readFileBio ", e);
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

}
