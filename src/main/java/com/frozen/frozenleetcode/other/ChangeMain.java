package com.frozen.frozenleetcode.other;

/**
 * @Auther: frozen
 * @Date: 2019/4/21 21:15
 * @Description:
 */
public class ChangeMain {
    public static void main(String[] args){
        ChangeMain changeMain = new ChangeMain();
        int amount = 5;
        int[] coins = {1, 2, 5};
        System.out.println(changeMain.change(amount,coins));
    }
    public int change(int amount, int[] coins) {
        int[] dp=new int[amount+1];
        dp[0]=1;
        for(int i=coins.length-1;i>=0;i--){//先找大面额，再找小面额
            for(int j=0;j<amount+1;j++){
                if(j-coins[i]>=0){
                    dp[j]+=dp[j-coins[i]];
                }
            }
        }
        return dp[amount];
    }
}
