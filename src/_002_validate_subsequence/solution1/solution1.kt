package _002_validate_subsequence.solution1

/**
Time Complexity

O(n*m): Where n is the size of array and m is the size of sequence. The .contains() method inside the forEach loop for
every element of the array makes this a nested operation because .contains() itself can take O(m) time in the worst case
(where m is the size of sequence).
This results in O(n*m) time complexity for the section of the code that constructs newSequence.

The comparison of sequence and newSequence is linear with respect to the length of sequence, which is O(m) in the worst case.
However, this part is dominated by the earlier O(n*m) complexity, and thus, it doesn't change the overall time complexity.

Space Complexity
O(m): The space complexity is primarily influenced by the creation of newSequence, which in the worst case could have
elements equal to the number of elements in sequence (i.e., all elements of sequence are also in array and are unique).
Since newSequence can grow to the size of sequence, the space complexity is O(m), where m is the length of sequence.
 */

fun isValidSubsequence(array: List<Int>, sequence: List<Int>): Boolean {
    if (sequence.size > array.size) return false
    if (sequence.size == array.size) return array == sequence
    val newSequence = mutableListOf<Int>()
    array.forEach { arrayNumber ->
        if (sequence.contains(arrayNumber)) {
            newSequence.add(arrayNumber)
        }
    }
    if (sequence.size > newSequence.size) return false
    sequence.forEachIndexed { index, element ->
        if (element != newSequence[index]) return false
    }
    return true
}

fun main() {
    val array = listOf(5, 1, 22, 25, 6, -1, 8, 10)
    val sequence = listOf(1, 6, -1, -1)
    println(isValidSubsequence(array, sequence))
}
