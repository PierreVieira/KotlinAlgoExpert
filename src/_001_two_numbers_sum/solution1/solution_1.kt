package _001_two_numbers_sum.solution1

// Time: O(n^2)
// Space: O(1)

fun twoNumberSum(array: MutableList<Int>, targetSum: Int): List<Int> { // O(n^2)
    for (i in 0..array.size - 2) {
        for (j in i + 1..array.size - 1) {
            val n1 = array[i]
            val n2 = array[j]
            val sum = n1 + n2
            if (sum == targetSum) {
                return listOf(n1, n2)
            }
        }
    }
    return emptyList()
}

fun main() {
    val array = mutableListOf(3, 5, -4, 8, 11, 1, -1, 6)
    println(twoNumberSum(array, 10))
}
