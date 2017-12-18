package com.java8;

import java.util.ArrayList;

/**
 * 2017/12/18 面试真遇到了写快排序，添加了重复元素处理
 * 
 * @author ChuRo
 *
 */
public class QuickSort {

  public QuickSort() {
    // TODO Auto-generated constructor stub
  }

  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(46);
    list.add(4);
    list.add(4);
    list.add(56);
    list.add(36);
    list.add(36);
    list.add(36);
    list.add(99);
    list.add(12);
    list.add(10);
    list.add(2);
    list.add(15);
    ArrayList<Integer> listRes = sort(list);
    System.out.println(listRes);
  }

  public static ArrayList<Integer> sort(ArrayList<Integer> list) {
    if (list.size() <= 1)
      return list; // 遞歸的出口,只有一個元素的序列或空序列本身就是有序的
    Integer baseInt = list.get(0); // 把序列第一個元素作為基準點
    ArrayList<Integer> leftList = new ArrayList<>(); // 左序列
    ArrayList<Integer> midList = new ArrayList<>(); // 中序列，重复元素
    ArrayList<Integer> rightList = new ArrayList<>(); // 右序列
    for (Integer integer : list) {
      if (integer < baseInt) { // 比基準點小的放入左序列
        leftList.add(integer);
      }
      if (integer > baseInt) { // 比基準點大的放入中间序列
        rightList.add(integer);// 如需去除重复可不使用集合，只添加一次到结果集合即可
      }
      if (integer == baseInt) { // 比基準點大的放入右序列
        midList.add(integer);
      }
    }
    ArrayList<Integer> resList = new ArrayList<>(); // 結果序列,將由排好序的左序列,基準點,和右序列串接成
    resList.addAll(sort(leftList)); // 遞歸調用自己對左序列排序 串接到結果序列
    // resList.add(baseInt); // 基準點 串接到結果序列，将去重
    resList.addAll(midList); // 基準點 串接到結果序列，保留重复元素
    resList.addAll(sort(rightList)); // 遞歸調用自己對右序列排序 串接到結果序列
    return resList;
  }

}
