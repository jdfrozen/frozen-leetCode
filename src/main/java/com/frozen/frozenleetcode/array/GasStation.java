package com.frozen.frozenleetcode.array;

/**
 * @author: Frozen
 * @create: 2019-06-09 12:50
 * @description: 134. Gas Station
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * <p>
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * <p>
 * Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.
 * <p>
 * Note:
 * <p>
 * If there exists a solution, it is guaranteed to be unique.
 * Both input arrays are non-empty and have the same length.
 * Each element in the input arrays is a non-negative integer.
 * Example 1:
 * <p>
 * Input:
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 * <p>
 * Output: 3
 * <p>
 * Explanation:
 * Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
 * Travel to station 4. Your tank = 4 - 1 + 5 = 8
 * Travel to station 0. Your tank = 8 - 2 + 1 = 7
 * Travel to station 1. Your tank = 7 - 3 + 2 = 6
 * Travel to station 2. Your tank = 6 - 4 + 3 = 5
 * Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
 * Therefore, return 3 as the starting index.
 * <p>
 **/
public class GasStation {
    public static void main(String[] args) {
        GasStation gasStation = new GasStation();
        int[] gas = new int[]{2};
        int[] cost = new int[]{2};
        System.out.println(gasStation.canCompleteCircuit(gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas==null||cost==null){
            return -1;
        }
        if(gas.length!=cost.length){
            return -1;
        }
        for(int i=0;i<gas.length;i++){
            if(gas[i]>=cost[i]){
                //begin
                if(isBegin( gas, cost,i)){
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 判断是否能够走完一环
     * @param gas
     * @param cost
     * @param index
     * @return
     */
    private boolean isBegin(int[] gas, int[] cost,int index){
        int length = gas.length;
        int costtemp=0;
        for(int i=0;i<gas.length;i++){
            int temp = index;
            if(index>=length){
                temp = index%length;
            }
            //如果到达不了下一站，则返回false
            costtemp = costtemp+gas[temp]-cost[temp];
            if(costtemp<0){
                return false;
            }
            index++;
        }
        return true;
    }
}
