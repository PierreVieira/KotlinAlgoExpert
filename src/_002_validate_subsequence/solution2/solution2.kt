package _002_validate_subsequence.solution2

// Time: O(n)
// Space: O(1)

fun isValidSubsequence(array: List<Int>, sequence: List<Int>): Boolean {
    var pointerSequenceIndex = 0
    array.forEach { element ->
        if (element == sequence[pointerSequenceIndex]) pointerSequenceIndex++
        if (pointerSequenceIndex == sequence.size) return true
    }
    return false
}

fun main() {
    val array = listOf(5, 1, 22, 25, 6, -1, 8, 10)
    val sequence = listOf(1, 6, -1, -1)
    println(isValidSubsequence(array, sequence))
}
