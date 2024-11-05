

fun main() {
    balanceBracket("{ [ ( ] ) }")
}
fun balanceBracket(inp: String) : String {
    val openCloseBracket = hashMapOf('}' to '{', ']' to '[', ')' to '(')
    val arrString = inp.replace(" ","").toCharArray()
    var isBalance = "false"
    val arrOpenBrckt = mutableListOf<Char>()
    for (i in 0..arrString.size-1) {
        if (openCloseBracket.containsValue(arrString[i])) {
            arrOpenBrckt.add(arrString[i]) // Memasukan ke list/stack openBracket(StackTemporary)
        } else {
            if (arrOpenBrckt.last() == openCloseBracket[arrString[i]]) { // Jika lastIndex StackTemporary cocok dengan closeBracket
                arrOpenBrckt.removeLast() // menghapus index terakhir
                isBalance = "YES"
            } else { //Jika tidak cocok sudah pasti tidak balance
                isBalance = "NO"
                break
            }
        }
    }
    return isBalance
}