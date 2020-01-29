fun main() {
    //Kalimat pembuka
    println("Selamat datang di gunting batu kertas")
    println("Pemain 1 silahkan pilih \"Batu\" \"Gunting\" atau \"Kertas\"")

//    pakai list buat dijadikan database ala-ala
    val choose = listOf("batu", "gunting", "kertas")

    //    Input untuk player1 dan player2 dan convert ke String
    val player1 = readLine()!!.toString()
    println("Mantap! Pemain 2 silahkan pilih \"Batu\" \"Gunting\" atau \"Kertas\"")
    val player2 = readLine()!!.toString()
    check(player1,player2,choose)

}

//Inputan user masuk ke sini, berjumpa dengan rules-rules.
fun play(user1: String, user2: String) {
    when {user1 == "batu" && user2 == "gunting"  -> println("Pemain 1 menang")
        user1 == "gunting" && user2 == "kertas" -> println("Pemain 1 menang")
        user1 == "kertas" && user2 == "batu" -> println("Pemain 1 menang")
        user1 == user2 -> println("Seri! Ayo coba lagi")
        else -> println("Pemain 2 menang")

    }
}

//Function ini gunanya buat cek inputan user, agar tidak input selain gunting, batu, dan kertas
fun check (user1: String, user2: String, options: List<String>) {

//    agar ga repot sama besar kecil, ubah aja semua jadi huruf kecil hehe
    val user1lowerCase = user1.toLowerCase()
    val user2lowerCase = user2.toLowerCase()

//    membandingkan jika input user tidak ada di list
    if (user1lowerCase !in options && user2lowerCase !in options) {
        println("Mohon masukan kembali pilihan anda")
    }
//    Gatau kenapa kalau ga di define perbandingan user harus ada di list kaya gini, dia error terus
    else if (user1lowerCase in options && user2lowerCase in options){
        play(user1lowerCase, user2lowerCase)
    }
    else (println("Mohon masukan kembali pilihan anda"))
}