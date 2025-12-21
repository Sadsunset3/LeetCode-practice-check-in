package com.SadSunset;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Array {
    //702.二分查找
    //给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
    // 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
    @Test
    public  void test702() {
        //传入参数
        int [] nums = {-1,0,3,5,9,12};
        int target=9;
        //测试
        System.out.println(Answer702(nums, target));
    }
        public int Answer702(int[] nums, int target) {
            int left = 0, right = nums.length - 1, middle=0;
            while(left <= right) {
                middle = (left + right) / 2;
                if (target < nums[middle]) {
                    right=middle-1;
                }
                else if (target > nums[middle]){
                    left=middle+1;
                }
                else {
                    return middle;
                }
            }
            return -1;
        }


        //27. 移除元素
        //给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，
        // 并返回移除后数组的新长度。
        //不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并原地修改输入数组。
        //元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
    @Test
    public void test27(){
        int[] nums={3,2,2,3};
        int val= 3;
        System.out.println(Answer27(nums, val));
    }
    public int Answer27(int[] nums ,int val){
        int length = nums.length;
        for(int i=0;i<length;i++) {
            if(nums[i]==val){
                for (int e =i+1 ; e <length ; e++) {
                    nums[e-1]=nums[e];
                }
                i--;
                length--;
            }
        }
        return length;
    }


    //977.有序数组的平方
    //给你一个按 非递减顺序 排序的整数数组 nums，
    // 返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
    @Test
    public void test977(){
        int[] nums={-4,-1,0,3,10};
        System.out.println(Arrays.toString(Answer977(nums)));
    }
    public  int[] Answer977(int[] nums ){
        for (int i=0;i<nums.length;i++){
         nums[i]*=nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }


//    209.长度最小的子数组
//    给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的
//     连续 子数组，
//     并返回其长度。如果不存在符合条件的子数组，返回 0。
    @Test
    public void test209(){
        int[] nums={2,3,1,2,4};
        int target=7;
        //暴力解法
        System.out.println("暴力解法结果:"+Answer209(nums,target));
        //滑动窗口解法
        System.out.println("滑动窗口解法结果："+minSubArrayLen(nums,target));
    }
        //暴力
        public  int Answer209(int[] nums,int target ){
            int result =nums.length; // 最终的结果
            int sum = 0; // 子序列的数值之和
            int subLength = 2;// 子序列的长度
            for (int i = 0; i <nums.length; i++) { // 设置子序列起点为i
                sum = 0;
                for (int j = i; j < nums.length; j++) { // 设置子序列终止位置为j
                    sum += nums[j];
                    if (sum >= target) { // 一旦发现子序列和超过了target，更新result
                        subLength = j - i + 1; // 取子序列的长度
                        result = Math.min(result, subLength);
                        break; // 因为我们是找符合条件最短的子序列，所以一旦符合条件就break
                    }
                }
            }
            return result;
        }
        //滑动窗口
    public int minSubArrayLen(int[] nums,int target) {
        int result = Integer.MAX_VALUE;
        int sum = 0;                    // 滑动窗口内元素之和
        int i = 0;                      // 滑动窗口的起始位置（左指针）

        for (int j = 0; j < nums.length; j++) { // j 是滑动窗口的结束位置（右指针）
            sum += nums[j];
            // 当窗口内和 >= s 时，尝试缩小窗口（移动左指针）
            while (sum >= target) {
                int subLength = j - i + 1;               // 当前窗口长度
                result = Math.min(result, subLength);    // 更新最小长度
                sum -= nums[i];                          // 移除左边界元素
                i++;                                     // 左指针右移
            }
        }

        // 如果 result 未被更新，说明没找到满足条件的子数组
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    //59.螺旋矩阵II
    //给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
    //示例:
    //输入: 3 输出: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
    @Test
    public void test59(){
        int n =3;
        System.out.println(Arrays.deepToString(Answer59(n)));
    }

    private static int[][] Answer59(int n) {
        int[][] nums=new int[n][n];
        int startX = 0, startY = 0;  // 每一圈的起始点
        int offset = 1;
        int count = 1;  // 矩阵中需要填写的数字
        int loop = 1; // 记录当前的圈数
        int i, j; // j 代表列, i 代表行;

        while (loop <= n / 2) {

            // 顶部
            // 左闭右开，所以判断循环结束时， j 不能等于 n - offset
            for (j = startY; j < n - offset; j++) {
                nums[startX][j] = count++;
            }

            // 右列
            // 左闭右开，所以判断循环结束时， i 不能等于 n - offset
            for (i = startX; i < n - offset; i++) {
                nums[i][j] = count++;
            }

            // 底部
            // 左闭右开，所以判断循环结束时， j != startY
            for (; j > startY; j--) {
                nums[i][j] = count++;
            }

            // 左列
            // 左闭右开，所以判断循环结束时， i != startX
            for (; i > startX; i--) {
                nums[i][j] = count++;
            }
            startX++;
            startY++;
            offset++;
            loop++;
        }
        if (n % 2 == 1) { // n 为奇数时，单独处理矩阵中心的值
            nums[startX][startY] = count;
        }
        return nums;
    }

}
