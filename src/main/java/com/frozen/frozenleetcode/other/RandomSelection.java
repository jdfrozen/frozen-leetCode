package com.frozen.frozenleetcode.other;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: Frozen
 * @create: 2019-07-23 17:04
 * @description: 随机选择
 **/
public class RandomSelection {
    /**
     * 随机选择
     *
     * @param ipList
     * @return
     */
    public List<String> randomNodeSelector(List<String> ipList) {
        if (ipList.size() <= 3) {
            return ipList;
        }
        //随机对象
        Random random = new Random();
        int size = ipList.size();
        Set<String> totals = new HashSet<>();
        ArrayList<String> resultList = new ArrayList<>();
        while (totals.size() < 3) {//获取3个
            //随机再集合里取出元素，添加到新哈希集合
            totals.add(ipList.get(random.nextInt(size)));
        }
        return  totals.stream().collect(Collectors.toList());
    }
}
