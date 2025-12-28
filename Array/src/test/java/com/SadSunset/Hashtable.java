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


    //383.赎金信
    //给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，
    // 判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
    //(题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
    //ransomNote 和 magazine 由小写英文字母组成
    @Test
    public  void Tile383() {
        String ransomNote = "a", magazine = "b";
        System.out.println(Answer383(ransomNote,magazine));
    }
    public boolean Answer383(String ransomNote, String magazine) {
        int[] recod=new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            recod[ransomNote.charAt(i)-'a']+=1;
        }
        for (int i = 0; i <magazine.length() ; i++) {
            recod[magazine.charAt(i)-'a']-=1;
        }
        for (int a:recod){
            if(a>0){
                return false;
            }
        }
        return true;
    }

    //15. 三数之和
    //给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
    //注意： 答案中不可以包含重复的三元组。
    //示例：
    //给定数组 nums = [-1, 0, 1, 2, -1, -4]，
    //满足要求的三元组集合为： [ [-1, 0, 1], [-1, -1, 2] ]

    @Test
    public  void Tile15() {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> list=Answer15(nums);
        System.out.println(Answer15(nums));
    }
    public List<List<Integer>> Answer15(int[] nums) {
        //双指针解法
        //定义结果集
        List<List<Integer>> result=new ArrayList<>();
        //定义左右指针
        //对数组排序
        Arrays.sort(nums);
        //遍历数组
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0){
                return result;
            }
            int left=i+1,right=nums.length-1;
            if (i > 0 && nums[i] == nums[i - 1]) {  // 去重a
                continue;
            }
            while (left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(sum>0){
                    right--;
                } else if (sum<0) {
                    left++;
                } else{
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left<right && nums[left]==nums[left+1])left++;
                    while (left<right && nums[right]==nums[right-1])right--;

                        left++;
                        right--;
                }
            }
        }
        return result;
    }




    //18. 四数之和
    //题意：给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
    // 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
    //注意：
    //答案中不可以包含重复的四元组。
    //示例： 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。 满足要求的四元组集合为：
    // [ [-1, 0, 0, 1], [-2, -1, 1, 2], [-2, 0, 0, 2] ]
    @Test
    public  void Tile18() {
        int[] nums = {1,0,-1,0,-2,2};
        int target=0;
        List<List<Integer>> list=Answer15(nums);
        System.out.println(Answer15(nums));
    }

    public List<List<Integer>> Answer18(int[] nums, int target) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        for (int k = 0; k < nums.length; k++) {
            // 剪枝处理
            if (nums[k] > target && nums[k] >= 0)break;
            // 对nums[k]去重
            if (k > 0 && nums[k] == nums[k - 1])continue;
            for (int i = k+1; i <nums.length ; i++) {
                if (i > k + 1 && nums[i] == nums[i - 1]) continue;
                int right=nums.length-1,left=i + 1;
                while (left<right) {
                    int sum = nums[i] + nums[k] + nums[right] + nums[left];
                    if (sum > target) right--;
                    else if (sum < target) left++;
                    else {
                        result.add(Arrays.asList(nums[i], nums[k], nums[right], nums[left]));
                            while (left < right && nums[left] == nums[left + 1]) left++;
                            while (left < right && nums[right] == nums[right - 1]) right--;
                            left++;
                            right--;

                    }
                }
            }
        }
            return result;
    }

}
