package _004_tournament_winner.solution2

// Space: O(n)
// Time: O(n)

fun tournamentWinner(competitions: List<List<String>>, results: List<Int>): String {
    val winnersMap = mutableMapOf<String, Int>()

    competitions.forEachIndexed { index, (homeTeam, awayTeam) ->
        val winner = if (results[index] == 1) homeTeam else awayTeam
        winnersMap[winner] = winnersMap.getOrDefault(winner, 0) + 3
    }

    return winnersMap.maxByOrNull { it.value }?.key ?: ""
}

fun main() {
    val competitions = listOf(
        listOf("HTML", "C#"),
        listOf("C#", "Python"),
        listOf("Python", "HTML"),
    )
    val results = listOf(0, 0, 1)
    println(tournamentWinner(competitions, results))
}
