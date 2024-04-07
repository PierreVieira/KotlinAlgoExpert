package _001_two_numbers_sum.solution2

// Time: O(n)
// Space: O(n)

fun twoNumberSum(array: MutableList<Int>, targetSum: Int): List<Int> { // O(n)
    val numbers = mutableSetOf<Int>()
    array.forEach { number ->
        val targetNumber = targetSum - number
        if (targetNumber in numbers) {
            return listOf(targetNumber, number)
        } else {
            numbers.add(number)
        }
    }
    return emptyList()
}

fun main() {
    val array = mutableListOf(3, 5, -4, 8, 11, 1, -1, 6)
    println(twoNumberSum(array, 10))
}
