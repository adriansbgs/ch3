class Score(var winnerData:winnerInterface) {
    fun score(listWinner: MutableList<String>, currentWinner: String) {
        var winnerTimes = listWinner.count{it == "$currentWinner"}
        println("skor sementara")
        println("$currentWinner dengan skor $winnerTimes")
        winnerData.kirimdata(listWinner)
    }
}