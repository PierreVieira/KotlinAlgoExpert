package _005_non_constructible_change.solution2

// Space complexity: O(1)
// Time complexity: O(n * log(n))

fun nonConstructibleChange(coins: MutableList<Int>): Int {
    coins.sort()
    var currentMinNotPossible = 1
    for (coin in coins) {
        if (coin > currentMinNotPossible) {
            break
        }
        currentMinNotPossible += coin
    }
    return currentMinNotPossible
}

fun main() {
    //    val coins = mutableListOf(1, 2, 5)
    val coins = mutableListOf(5, 7, 1, 1, 2, 3, 22)
    println(nonConstructibleChange(coins))
}
