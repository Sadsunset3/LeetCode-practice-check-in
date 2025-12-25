package com.SadSunset;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Hashtable {
    //242.有效的字母异位词
    //传入参数
    //给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
    //示例 1: 输入: s = "anagram", t = "nagaram" 输出: true
    //示例 2: 输入: s = "rat", t = "car" 输出: false
    //说明: 你可以假设字符串只包含小写字母。
    @Test
    public  void Tile242() {
        System.out.println(Answer242("anagram", "nagaram"));
    }
    public boolean Answer242(String s, String t) {
        //定义一个字典记录26位的字母，其中数组的索引就为字母对应的ASCII
        int[] arrys=new int[26];
        //统计s每个字符串出现的次数
        for (int i = 0; i < s.length(); i++) {
            arrys[s.charAt(i)-'a']+=1;
        }
        //统计t每个字符串出现的次数，直接在上面记录过的s中减
        for (int i = 0; i < t.length(); i++) {
            arrys[t.charAt(i)-'a']-=1;
        }
        //遍历字典，如果其中有不为0的项，就是s字符串与t字符串中没恰好消去的项
        for (int a:arrys){
         if (a!=0){
             return false;
         }
        }
        return true;
    }
    //349. 两个数组的交集
    //题意：给定两个数组，编写一个函数来计算它们的交集
    //说明： 输出结果中的每个元素一定是唯一的。 我们可以不考虑输出结果的顺序。
    @Test
    public  void Tile349() {
        //nums1 = [1,2,2,1], nums2 = [2,2]
        int [] nums1={1,2,2,1};
        int[] nums2={2,2};
        System.out.println(Arrays.toString(Answer349(nums1, nums2)));
    }
    public int[] Answer349(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        //遍历数组1
        for (int i : nums1) {
            set1.add(i);
        }
        //遍历数组2的过程中判断哈希表中是否存在该元素
        for (int i : nums2) {
            if (set1.contains(i)) {
                resSet.add(i);
            }
        }
        int[] arr = new int[resSet.size()];
        int j = 0;
        for(int i : resSet){
            arr[j++] = i;
        }

        return arr;
    }


    //202. 快乐数
    //编写一个算法来判断一个数 n 是不是快乐数。
    //「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
    //如果 n 是快乐数就返回 True ；不是，则返回 False 。
    @Test
    public  void Tile202() {
        int n = 19;
        System.out.println(Answer202(n));
    }
    public boolean Answer202(int n) {
        Set<Integer> record =new HashSet<>();
        while(n!=1 && !record.contains(n)){
            record.add(n);
            int res=0;
            while(n!=0){
                res+=(n%10)*(n%10);
                n=n/10;
            }
            n=res;
        }
        return n==1;
    }

    @Test
    //1. 两数之和
    //给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
    //你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
    public  void Tile1() {
        int[] nums={2,7,11,15};
        int  target = 9;
        System.out.println(Arrays.toString(Answer1(nums, target)));
    }
    public int[] Answer1(int[] nums, int target) {
        int[] res=new int[2];
        if(nums == null || nums.length == 0){
            return res;
        }
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length ; i++) {
            if(map.containsKey(target-nums[i])){
               res[0]=map.get(target-nums[i]);
               res[1]=i;
                return  res;
            }
            map.put(nums[i],i);
        }
        return res;
    }


    //454.四数相加II
    //给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
    //为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -2^28 到 2^28 - 1 之间，最终结果不会超过 2^31 - 1 。
    @Test
    public  void Tile454() {
        int[] nums1={1,2};
        int[] nums2={-2,-1};
        int[] nums3={-1,2};
        int[] nums4={0,2};
        System.out.println((Answer454(nums1,nums2,nums3,nums4)));
    }
    public int Answer454(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res=0;
        Map<Integer,Integer> map=new HashMap<>();
        //nums1,nums2
        for(int i:nums1) {
            for (int j:nums2) {
                int sum=i+j;
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
        }
        for (int i: nums3) {
            for (int j : nums4) {
                res += map.getOrDefault(-i - j, 0);
            }
        }
        return res;
    }

}
