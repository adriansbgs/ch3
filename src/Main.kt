fun main() {

    //    pakai list buat dijadikan database ala-ala
    val choose = listOf("batu", "gunting", "kertas")
    var playerChoose = ""
    val playerData = mutableListOf((Player("", "")))
    for (i in 1..2) {
        println("Selamat datang di mini-games Gunting Batu Kertas!")
        println("=======================================")
        //    Input untuk player1 dan player2 dan convert ke String
        println("Masukan nama pemain $i")
        val playerName = readLine()!!.toString()
        println("Pemain $i silahkan pilih \"Batu\" \"Gunting\" atau \"Kertas\"")
        do {
            playerChoose = readLine()!!.toString()
            var j = check(playerChoose, choose)

        } while (j !== 1)

        playerData.add(Player(playerName, playerChoose))
    }
    var result = play(playerData[1].choose.toLowerCase(), playerData[2].choose.toLowerCase())
    playerData[result as Int].printData()

}

//Inputan user masuk ke sini, berjumpa dengan rules-rules.
fun play(user1: String, user2: String): Any {
    var i = 0
    when {
        user1 == "batu" && user2 == "gunting" -> i = 1
        user1 == "gunting" && user2 == "kertas" -> i = 1
        user1 == "kertas" && user2 == "batu" -> i = 1
        user1 == user2 -> println("Seri! Ayo coba lagi")
        else -> i = 2
    }
    return i
}

//Function ini gunanya buat cek inputan user, agar tidak input selain gunting, batu, dan kertas
fun check(user1: String, options: List<String>): Any {

//    agar ga repot dengan besar kecil, ubah aja semua jadi huruf kecil hehe
    val user1lowerCase = user1.toLowerCase()
    var i = 0

//    membandingkan jika input user tidak ada di list
    if (user1lowerCase !in options) {
        println("Mohon masukan kembali pilihan anda")
        i = 0
    }
    else if (user1lowerCase in options) {
        i = 1

    } else (println("Mohon masukan kembali pilihan anda"))
    return i
}