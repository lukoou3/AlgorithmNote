package com.algorithm.search

object BinarySearch {

  def binarySearchByRecursion(arr:Array[Int], key: Int, left: Int, right: Int): Int = {
    if(left > right ){
      return -1
    }

    val middle  = (left+right) / 2
    if (key < arr(middle)){
      //向左递归查找
      binarySearchByRecursion(arr, key, left, middle - 1)
    }else if(key > arr(middle)){
      //向右递归查找
      binarySearchByRecursion(arr, key , middle + 1, right)
    }else{
      //查找到，返回下标
      middle
    }

  }

  def binarySearch(arr:Array[Int], key: Int): Int = {
    var left = 0
    var right = arr.length - 1

    while(left <= right){
      val middle  = (left+right) / 2
      if(key < arr(middle)){
        right = middle - 1;
      }else if(key > arr(middle)){
        left = middle + 1;
      }else{
        return middle;
      }
    }

    -1
  }

  def main(args: Array[String]): Unit = {
    val array = Array(0, 5, 7, 9, 10, 15, 20)
    val keys = Array(0, 15, 27)

    for (key <- keys) {
      println(key, binarySearch(array, key), binarySearchByRecursion(array, key, 0, array.length - 1))
    }

  }
}
