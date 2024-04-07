package _003_sorted_squared_array.solution2

import kotlin.math.absoluteValue

// Time: O(n)
// Space: O(n)

fun sortedSquaredArray(array: List<Int>): List<Int> {
    var pointerStart = 0
    var pointerEnd = array.lastIndex
    val newArray = Array(array.size) { 0 }
    for (currentNewArrayIndex in array.lastIndex downTo 0) {
        val valueStart = array[pointerStart].absoluteValue
        val valueEnd = array[pointerEnd].absoluteValue
        if (valueStart > valueEnd) {
            newArray[currentNewArrayIndex] = valueStart * valueStart
            pointerStart++
        } else {
            newArray[currentNewArrayIndex] = valueEnd * valueEnd
            pointerEnd--
        }
    }
    return newArray.toList()
}

fun main() {
//    val array = listOf(-2, -1, 0, 1, 2)
//    val array = listOf(-50, -13, -2, -1, 0, 0, 1, 1, 2, 3, 19, 20)
    val array = listOf(1, 2, 3, 5, 6, 8, 9)
    println(sortedSquaredArray(array))
}
