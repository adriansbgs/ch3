fun main() {
    //Kalimat pembuka
    println("Selamat datang di gunting batu kertas")
    println("Player 1 silahkan pilih \"Batu\" \"Gunting\" atau \"Kertas\"")

//    Input untuk player1 dan player2 dan convert ke String
    val choose = listOf("batu", "gunting", "kertas")
    val player1 = readLine()!!.toString()
    println("Mantap! Player 2 silahkan pilih \"Batu\" \"Gunting\" atau \"Kertas\"")
    val player2 = readLine()!!.toString()
    play(player1,player2)

}

//Definisi rule-rule. ignoreCase dipakai untuk mengabaikan besar kecil huruf

fun play(user1: String, user2: String) {
    when {user1.equals("batu", true) && user2.equals("gunting", true)  -> println("Pemain 1 menang")
        user1.equals("gunting", true) && user2.equals("kertas", true)-> println ("Pemain 1 menang")
        user1.equals("kertas", true) && user2.equals("batu", true)-> println("Pemain 1 menang")
//        user1 !== "batu" || user1 !== "kertas" || user1 !== "gunting" -> println("Harap input dengan benar")
        else -> println("Pemain 2 menang")

    }
}

//fun check (user1: String, user2: String, options: List<String>) {
//    val iterator = options.listIterator()
//    for (item in iterator) {
//        if (item.equals(user1, true) && item.equals(user2, true)) {
////            play(user1, user2)
//        } else {
//            println("Mohon masukan kembali pilihan anda")
//            break
//        }
//    }
//}