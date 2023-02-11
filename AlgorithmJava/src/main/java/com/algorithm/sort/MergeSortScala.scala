package com.algorithm.sort

/**
 * 算法描述:
 * 1.把长度为n的输入序列分成两个长度为n/2的子序列；
 * 2.对这两个子序列分别采用归并排序；
 * 3.将两个排序好的子序列合并成一个最终的排序序列。
 */
object MergeSortScala {

  def mergeSort(arr: Array[Int]): Array[Int] = {
    val len = arr.length
    if (len < 2) {
      return arr
    }

    val middle = len / 2
    val left = arr.slice(0, middle)
    val right = arr.slice(middle, arr.length)
    merge(mergeSort(left), mergeSort(right))
  }

  def merge(left: Array[Int], right: Array[Int]): Array[Int] = {
    val result = new Array[Int](left.length + right.length)
    var i = 0
    var li, ri = 0

    while (li < left.length && ri < right.length) {
      if (left(li) <= right(ri)) {
        result(i) = left(li)
        li += 1
      } else {
        result(i) = right(ri)
        ri += 1
      }
      i += 1
    }

    while (li < left.length) {
      result(i) = left(li)
      li += 1
      i += 1
    }

    while (ri < right.length) {
      result(i) = right(ri)
      ri += 1
      i += 1
    }

    result
  }

  def main(args: Array[String]): Unit = {
    val array1 = Array(0, 5, 3, 2, 2, 10, 8, 6, 7, 6)
    val array2 = Array(2, -5, -45, -2, 5, 5, -10, -5, -4)
    println(mergeSort(array1).mkString(","))
    println(mergeSort(array2).mkString(","))
  }
}
