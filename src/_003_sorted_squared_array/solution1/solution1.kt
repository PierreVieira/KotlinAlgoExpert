package _003_sorted_squared_array.solution1

// Time: O(n*log(n))
// Space: O(n)

fun sortedSquaredArray(array: List<Int>): List<Int> {
    return array.map {
        it * it
    }.sorted()
}

fun main() {
    val array = listOf(-2, -1)
    println(sortedSquaredArray(array))
}
