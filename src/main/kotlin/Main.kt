var card = "Maestro"         // "Maestro"  "Visa"  "Mir" "VK_Play"
var translation = 80000           // сумма перевода
var transfersMonth = 700        // сумма переводов в месяц


fun main() {
    println("${text(card, translation, transfersMonth)}")
}
fun text(card: String, translation: Int, transfersMonth: Int): String {
    if (maxAmountMonth(card, translation, transfersMonth) == -1) {
        return ("Вы превысили сумму максимальных платежей  в этом месяце")
    } else {
        return (
                "Комиссия за текущий перевод по карте $card составляет - ${
                    taxCalculation(card, translation, transfersMonth)
                } рублей"
                )
    }
}

fun taxCalculation(card: String, translation: Int, transfersMonth: Int): Double {
    return when (card) {
        "Mastercard", "Maestro" -> (if (translation < 75_000) 0 else (translation * 0.006 + 20)).toDouble()
        "Visa", "Mir" -> (if (translation * 0.0075 < 35) 35 else translation * 0.0075).toDouble()
        else -> 0.0
    }
}
fun maxAmountMonth(card: String, translation: Int, transfersMonth: Int): Int{
    if ((translation + transfersMonth) > 600000) {
        return -1
    } else {
        return 0
    }
}
