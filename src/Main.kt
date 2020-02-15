class Main() {
    companion object : winnerInterface {
        //Inputan user masuk ke sini, berjumpa dengan rules-rules.
        private fun play(user1: String, user2: String, counter1: Int, counter2: Int): Any {
            var i: Int? = null
            i = when {
                user1 == "batu" && user2 == "gunting" -> counter1
                user1 == "gunting" && user2 == "kertas" -> counter1
                user1 == "kertas" && user2 == "batu" -> counter1
                user1 == user2 -> -1
                else -> counter2
            }
            return i
        }

        //Function ini gunanya buat cek inputan user, agar tidak input selain gunting, batu, dan kertas
        private fun check(user1: String, options: List<String>): Any {

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

        private var counter1 = -1
        private var counter2 = 0

        @JvmStatic
        fun main(args: Array<String>) {

            val choose = listOf("batu", "gunting", "kertas")
            var playerChoose: String? = null
            val winnerDB = mutableListOf<String>()
            val playerData = mutableListOf(Player("", ""))
            var playAgain = "n"
            var j = 0
            var score = Score(this)

            println("Selamat datang di mini-game Gunting, Batu, Kertas!")
            println("===================================================")

            do {
                for (i in 1..2) {
                    //    Input untuk player1 dan player2 dan convert ke String
                    var playerName = ""
                    if (playAgain == "n") {
                        println("Masukan nama kamu wahai pemain $i")
                        playerName = readLine()!!.toString()
                    } else {
                        println()
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
                val result = play(
                    playerData[counter1].choose!!.toLowerCase(),
                    playerData[counter2].choose!!.toLowerCase(),
                    counter1,
                    counter2
                )
                if (result == -1) {
                    println("Seri! Jangan-jangan kalian jodoh ciye. Ayo coba lagi")
                    println("Lagi ga nih? (Y)/(N)")
                    playAgain = readLine()!!.toLowerCase()
                    if (playAgain == "y") {
                        println("Asiiik! Babak penentuan nih. Let's Go!!!")
                    }
                } else if (result !== -1) {
                    playerData[result as Int].printData()
                    winnerDB.add(playerData[result].name)
                    if (result == counter1) {
                        score.score(winnerDB, playerData[counter1].name, playerData[counter2].name)
                    } else if (result == counter2) {
                        score.score(winnerDB, playerData[counter2].name, playerData[counter1].name)
                    }
                    println("Main lagi ga? Kali aja menang abis ini (Y)/(N)")
                    playAgain = readLine()!!.toLowerCase()
                    if (playAgain == "y") {
                        println("Mantap! Mari adu suit!!")
                    }
                }

            } while (playAgain == "y")
            println("Yah udahan :( Terimakasih sudah mau bermain!")
        }

        override fun kirimdata(winners: MutableList<String>) {
        }


    }
}