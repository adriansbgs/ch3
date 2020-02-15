class Main() {
    companion object : winnerInterface {
        //Inputan user masuk ke sini, berjumpa dengan rules-rules.
        fun play(user1: String, user2: String, counter1: Int, counter2: Int): Any {
            var i: Int? = null
            when {
                user1 == "batu" && user2 == "gunting" -> i = counter1
                user1 == "gunting" && user2 == "kertas" -> i = counter1
                user1 == "kertas" && user2 == "batu" -> i = counter1
                user1 == user2 -> i = -1
                else -> i = counter2
            }
            return i
        }

        //Function ini gunanya buat cek inputan user, agar tidak input selain gunting, batu, dan kertas
        fun check(user1: String, options: List<String>): Any {

            val user1lowerCase = user1.toLowerCase()
            var i = 0

            if (user1lowerCase !in options) {
                println("Mohon masukan kembali pilihan anda")
                i = 0
            } else if (user1lowerCase in options) {
                i = 1

            } else (println("Mohon masukan kembali pilihan anda"))
            return i
        }

        var counter1 = -1
        var counter2 = 0

        @JvmStatic
        fun main(args: Array<String>) {

            val choose = listOf("batu", "gunting", "kertas")
            var playerChoose: String? = null
            val winnerDB = mutableListOf<String>()
            val playerData = mutableListOf(Player("", ""))
            var playAgain = "n"
            var j = 0
            var score = Score(this)
            do {
                for (i in 1..2) {
                    println("Selamat datang di mini-games Gunting Batu Kertas!")
                    println("=======================================")
                    //    Input untuk player1 dan player2 dan convert ke String
                    var playerName = ""
                    if (playAgain == "n") {
                        println("Masukan nama pemain $i")
                        playerName = readLine()!!.toString()
                    } else {
                        playerName = playerData[i].name
                    }
                    println("Pemain $i silahkan pilih \"Batu\" \"Gunting\" atau \"Kertas\"")
                    do {
                        playerChoose = readLine()!!.toString()
                        val j = check(playerChoose, choose)

                    } while (j !== 1)

                    playerData.add(Player(playerName, playerChoose))
                }
                counter1 += 2
                counter2 += 2
                var result = play(
                    playerData[counter1].choose!!.toLowerCase(),
                    playerData[counter2].choose!!.toLowerCase(),
                    counter1,
                    counter2
                )
                if (result == -1) {
                    println("Seri! Ayo coba lagi")
                } else if (result !== -1) {
                    playerData[result as Int].printData()
                    winnerDB.add(playerData[result].name)
                    score.score(winnerDB, playerData[result].name)
                    println("Mau main lagi? (Y)/(N)")
                    playAgain = readLine()!!.toLowerCase()
                }

            } while (playAgain == "y")
        }

        override fun kirimdata(winners: MutableList<String>) {

        }

    }
}