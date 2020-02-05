fun main() {

    //    pakai list buat dijadikan database ala-ala
    val choose = listOf("batu", "gunting", "kertas")
    val contArray = arrayOf(Player("Coba","Yeah"))
    val playerData = mutableListOf((Player("","")))
    println(playerData)
    for (i in 1..2) {
        println("Selamat datang di mini-games Gunting Batu Kertas!")
        println("=======================================")
        //    Input untuk player1 dan player2 dan convert ke String
        println("Masukan nama pemain $i")
        val playerName = readLine()!!.toString()
        println("Pemain $i silahkan pilih \"Batu\" \"Gunting\" atau \"Kertas\"")
        val playerChoose = readLine()!!.toString()
        playerData.add(Player(playerName, playerChoose))
//        println(playerData[i].name)
    }

    var result = check(playerData[1].choose,playerData[2].choose,choose)
    playerData[result as Int].printData()


}

//Inputan user masuk ke sini, berjumpa dengan rules-rules.
fun play(user1: String, user2: String): Any {
    var i = 0
    when {user1 == "batu" && user2 == "gunting"  -> i = 1
        user1 == "gunting" && user2 == "kertas" -> i = 1
        user1 == "kertas" && user2 == "batu" -> i = 1
        user1 == user2 -> println("Seri! Ayo coba lagi")
        else -> i = 2

    }
    return i
}

//Function ini gunanya buat cek inputan user, agar tidak input selain gunting, batu, dan kertas
fun check (user1: String, user2: String, options: List<String>): Any {

//    agar ga repot sama besar kecil, ubah aja semua jadi huruf kecil hehe
    val user1lowerCase = user1.toLowerCase()
    val user2lowerCase = user2.toLowerCase()
    var i = 0

//    membandingkan jika input user tidak ada di list
    if (user1lowerCase !in options || user2lowerCase !in options) {
        println("Mohon masukan kembali pilihan anda")
    }
//    Gatau kenapa kalau ga di define perbandingan user harus ada di list kaya gini, dia error terus
    else if (user1lowerCase in options && user2lowerCase in options){
      var i = play(user1lowerCase, user2lowerCase)
        return i
    }
    else (println("Mohon masukan kembali pilihan anda"))
    return i
}