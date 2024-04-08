package _005_non_constructible_change.solution1

// Space: O(n * 2^n)
// Time: O(n^2 * 2^n)

import kotlin.math.pow

private fun List<Int>.getBitTable(): List<List<Int>> {
    val numberOfLines = size
    val numberOfColumns = 2.0.pow(numberOfLines).toInt()
    val matrix = MutableList(numberOfLines) {
        MutableList(numberOfColumns) { 0 }
    }
    var variation = 1
    for (i in matrix.lastIndex downTo 0) {
        var variationCounter = 0
        var currentAttribution = 0
        for (j in 0..matrix[i].lastIndex) {
            if (variationCounter == variation) {
                currentAttribution = if (currentAttribution == 0) 1 else 0
                variationCounter = 0
            }
            matrix[i][j] = currentAttribution
            variationCounter += 1
        }
        variation *= 2
    }
    return matrix
}

private fun getBitsFromColum(bitTable: List<List<Int>>, columIndex: Int): List<Int> {
    val bits = mutableListOf<Int>()
    for (rowIndex in 0..bitTable.lastIndex) {
        bits.add(bitTable[rowIndex][columIndex])
    }
    return bits
}

private fun getCoinsFilteredBasedOnBits(coins: List<Int>, bits: List<Int>): List<Int> = coins.mapIndexedNotNull { index: Int, element: Int ->
    element.takeIf {
        bits[index] == 1
    }
}

private fun isPossibleChange(coins: List<Int>, change: Int, bitTable: List<List<Int>>): Boolean {
    for (j in 0..bitTable[0].lastIndex) {
        val bits = getBitsFromColum(bitTable, j)
        val coinsFiltered = getCoinsFilteredBasedOnBits(coins, bits)
        if (coinsFiltered.sum() == change) {
            return true
        }
    }
    return false
}


fun nonConstructibleChange(coins: MutableList<Int>): Int {
    if (coins.isEmpty()) return 1
    val maxChange = coins.sum()
    val bitTable = coins.getBitTable()
    for (change in 0..maxChange) {
        if (!isPossibleChange(coins, change, bitTable)) {
            return change
        }
    }
    return maxChange + 1
}

fun main() {
//    val coins = mutableListOf(1, 2, 5)
    val coins = mutableListOf(5, 7, 1, 1, 2, 3, 22)
    println(nonConstructibleChange(coins))
}
