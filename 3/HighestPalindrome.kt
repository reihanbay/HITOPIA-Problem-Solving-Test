/**
 * Given a string representing a number, the goal is to find the highest possible palindrome that can be formed by changing at most 'k' digits in the string. A palindrome is a number that reads the same backward as forward.
 *
 * You are given a string 's' representing a number and an integer 'k'. The task is to find the highest palindrome that can be formed by changing at most 'k' digits in the string 's'.
 *
 *
 * Example 1:
 * Input:
 * s: 3943
 * k: 1
 * Palindrome:
 * 1. 3943  => 3993
 * 2. 3943 => 3443
 * Output: 3993
 * Explanation: Among the possible palindromes obtained, the highest palindrome is 3993 since 3993 > 3443.
 *
 * Example 2:
 * Input:
 * s: 932239
 * k: 2
 * Palindrome:
 * 1. 932239 => palindrome
 * 2. Further Replacement (k = 2): => 992299
 * Output: 992299
 * Explanation: Among the possible palindromes obtained, the highest palindrome is 992299 since 992299 > 932239.
 *
 * Rules:
 * 1. If a palindrome cannot be formed from the given string even after 'k' replacements, and the string does not represent a valid number, output '-1'.
 * 2. Do not use built-in functions or tools for searching, filtering, or sorting.
 * 3. Avoid using loops.
 * 4. Only use recursion to solve the problem.
 *
 * Task:
 * Create a recursive function to solve the Highest Palindrome problem!
 * */

fun main() {
    println(highestPalindrome(2, "932239"))
}

//Eksekusi string
fun highestPalindrome(k : Int, s: String = "3943") : Int {
    val charArrPalindrome = s.toCharArray()
    val digitIndex = charArrPalindrome.size
    var highestDigit = '0'

    //membuatbaseCase
    fun makePalindrome(left: Int, right: Int, countForm: Int) : Int {
        println(countForm)
        if (countForm <= 0||left>=right) return charArrPalindrome.joinToString("").trim().toInt()
        val leftValue = charArrPalindrome[left]
        val rightValue = charArrPalindrome[right]
        if (leftValue != rightValue) {
            if (leftValue>rightValue) {
                if (highestDigit>leftValue) {
                    charArrPalindrome[right] = highestDigit
                } else {
                    charArrPalindrome[right] = leftValue
                }
                highestDigit = leftValue
            } else {
                if (highestDigit>rightValue) {
                    charArrPalindrome[left] = highestDigit
                } else {
                    charArrPalindrome[left] = rightValue
                }
                highestDigit = rightValue
            }
            return makePalindrome(left+1, right-1, countForm-1)
        } else {
            if (highestDigit>leftValue) {
                charArrPalindrome[right] = highestDigit
                charArrPalindrome[left] = highestDigit
                return makePalindrome(left+1, right-1, countForm-2)
            } else {
                highestDigit = leftValue
                return makePalindrome(left+1, right-1, countForm)
            }

        }
    }
    return makePalindrome(0, digitIndex-1, k)
}
