package com.algorithm.sort

object QuickSort2Scala {

  def quickSort(arr:Array[Int], left: Int, right: Int): Unit = {
    if (left >= right) {
      return
    }

    val base = arr(left) // 定义变量保存基准数
    var i = left // 定义变量i，指向最左边
    var j = right // 定义j ,指向最右边

    //println(arr.mkString(","))
    //当i和j不相遇的时候，再循环中进行检索
    while(i != j){
      //先由j从右往左检索比基准数小的，如果检索到比基准数小的就停下
      while(arr(j) >= base && i < j){
        j -= 1
      }
      while(arr(i) <= base && i < j){
        i += 1
      }

      //代码走到这里i停下，j也停下，然后交换i和j位置的元素
      swap(arr, i, j)
    }
    //println(arr.mkString(","))

    //如果上面while条件不成立就会跳出这个循环，说明 i和j相遇了
    //如果i和j相遇了，就交换基准数这个元素和相遇位置的元素
    //把相遇元素的值赋给基准数这个位置的元素
    swap(arr, left, i)
    quickSort(arr, left, i - 1)
    quickSort(arr, j + 1, right)
  }

  def swap(arr:Array[Int], i: Int, j: Int): Unit = {
    val temp = arr(i)
    arr(i) = arr(j)
    arr(j) = temp
  }

  def main(args: Array[String]): Unit = {
    val array1 = Array(0, 5, 3, 2, 2, 10, 8, 6, 7, 6)
    val array2 = Array(2, -5, -45, -2, 5, 5, -10, -5, -4)
    quickSort(array1, 0, array1.length - 1)
    quickSort(array2, 0, array2.length - 1)
    println(array1.mkString(","))
    println(array2.mkString(","))
  }
}
