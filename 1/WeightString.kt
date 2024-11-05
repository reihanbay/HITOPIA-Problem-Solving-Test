fun weightStr(str: String, query: Array<Int>) : Array<String> {
    var weightChar = intArrayOf()

    for (a in str.indices) {
        val weight = str[a].lowercaseChar() - 'a' + 1
        if (a!=0 && str[a]==str[a-1]) {
            weightChar[weightChar.lastIndex]+=weight
        } else {
            weightChar+=weight
        }
    }
    var arrResult : Array<String> = arrayOf()
    for (i in query.indices) {
        arrResult += if (query[i] == weightChar[i]) "Yes" else "No"
    }

    //Kode dibawah hanya untuk memperlihatkan perbedaan
    println("query ${query.joinToString()}")
    println("weightArr ${weightChar.joinToString()}")

    return arrResult
}

fun main() {
    println(weightStr("abbcccd", arrayOf(1, 3, 9, 8)).joinToString());
}