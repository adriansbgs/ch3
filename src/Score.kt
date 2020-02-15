class Score(var winnerData: winnerInterface) {
    fun score(listWinner: MutableList<String>, currentWinner: String, currentLoser: String) {
        val winnerTimes = listWinner.count { it == "$currentWinner" }
        val loserTimes = listWinner.count { it == "$currentLoser" }
        println("===Skor Sementara===")
        println("$currentWinner $winnerTimes : $loserTimes $currentLoser ")
        when {
            winnerTimes < loserTimes -> {
                println("Bisa-bisanya si-$currentLoser menang, ayo semangat $currentWinner, main lagiii!")
            }
            loserTimes < winnerTimes -> {
                println("Bisa-bisanya si-$currentWinner menang, ayo semangat $currentLoser, main lagiii!")
            }
            else -> println("Nah nah nah! Udah mau nyusul nih skornya, lagi lah!")
        }
        winnerData.kirimdata(listWinner)
    }
}