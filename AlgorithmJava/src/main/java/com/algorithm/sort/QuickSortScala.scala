package com.algorithm.sort

/**
 * 算法描述:
 * 1.从数列中挑出一个元素，称为 “基准”（pivot）；
 * 2.重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
 * 3.递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 */
object QuickSortScala {

  def quickSort(arr:Array[Int], left: Int, right: Int): Unit = {
    if (left < right) {
      // 获取划分子数组的位置
      val position = partition(arr, left, right)
      // 左子数组递归调用
      quickSort(arr, left, position -1)
      // 右子数组递归调用
      quickSort(arr, position + 1, right)
    }
  }

  def partition(arr:Array[Int], left: Int, right: Int): Int = {
    val pivot = left
    var index = pivot + 1
    var i = index

    while(i <= right){
      if (arr(i) < arr(pivot)) {
        swap(arr, i, index)
        index += 1
      }
      i += 1
    }

    swap(arr, pivot, index - 1)
    index-1
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
