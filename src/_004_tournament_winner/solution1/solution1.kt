package _004_tournament_winner.solution1

// Space: O(n)
// Time: O(n)

fun tournamentWinner(competitions: List<List<String>>, results: List<Int>): String {
    val winnersMap = mutableMapOf<String, Int>()
    competitions.forEachIndexed { index, competition ->
        val winner = if (results[index] == 1) {
            competition.first()
        } else {
            competition.second()
        }
        winnersMap[winner] = winnersMap[winner]?.plus(3) ?: 3
    }
    var bigger = competitions.getFirstOfFirst()
    winnersMap.forEach { (key: String, value: Int) ->
        val current = winnersMap[bigger]
        if (current == null || current < value) {
            bigger = key
        }
    }
    return bigger
}

private fun List<String>.second(): String = this[1]

private fun List<List<String>>.getFirstOfFirst() = first().first()

fun main() {
    val competitions = listOf(
        listOf("HTML", "C#"),
        listOf("C#", "Python"),
        listOf("Python", "HTML"),
    )
    val results = listOf(0, 0, 1)
    println(tournamentWinner(competitions, results))
}
