package com.xq.mylib

//fun max(vararg nums:Int):Int{
//    var maxNum = Int.MIN_VALUE
//    for (num in nums){
//        maxNum = kotlin.math.max(num, maxNum)
//    }
//    return maxNum
//}

fun <T:Comparable<T>> max(vararg nums:T):T{
    var maxNum = nums[0]
    for (num in nums){
        if (num > maxNum){
            maxNum = num
        }
    }
    return maxNum
}

fun main() {
    val a = 10.8
    val b = 10.5
    val c = 10.1
    val res = max(a,b,c)
    println(res)
}