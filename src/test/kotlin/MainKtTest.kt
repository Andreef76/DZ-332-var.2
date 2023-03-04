import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun testTaxCalculationVisa() {    // ВАРИАНТ СРАВНЕНИЯ 1
        val card = "Visa"
        val translation = 400
        val transfersMonth = 0

        val result = taxCalculation(card, translation, transfersMonth)
        assertEquals(35.0, result, 0.001)
    }

    @Test
    fun testTaxCalculationVisaProcent() {     // ВАРИАНТ СРАВНЕНИЯ 2.  приводим значение к String и сравниваем
        val card = "Visa"
        val translation = 20000
        val transfersMonth = 0
        val result = String.format("%.3f", taxCalculation(card, translation, transfersMonth))
        assertEquals("150,000", result)
    }
    @Test
    fun testTaxCalculationMir() {    // ВАРИАНТ СРАВНЕНИЯ 1
        val card = "Mir"
        val translation = 400
        val transfersMonth = 0

        val result = taxCalculation(card, translation, transfersMonth)
        assertEquals(35.0, result, 0.001)
    }

    @Test
    fun testTaxCalculationMirProcent() {     // ВАРИАНТ СРАВНЕНИЯ 2.  приводим значение к String и сравниваем (сравнение до 3х знаков после запятой)
        val card = "Mir"
        val translation = 20000
        val transfersMonth = 0
        val result = String.format("%.3f", taxCalculation(card, translation, transfersMonth))
        assertEquals("150,000", result)
    }

    @Test
    fun testTaxCalculationMaestro() {
        val card = "Maestro"
        val translation = 74000
        val transfersMonth = 0

        val result = taxCalculation(card, translation, transfersMonth)
        assertEquals(0.0, result, 0.001)
    }
    @Test
    fun testTaxCalculationMaestroProcent() {
        val card = "Maestro"
        val translation = 80000
        val transfersMonth = 0
        val result = taxCalculation(card, translation, transfersMonth)
        assertEquals(500.0, result, 0.001)
    }
    @Test
    fun testTaxCalculationMastercard() {
        val card = "Mastercard"
        val translation = 74000
        val transfersMonth = 0

        val result = taxCalculation(card, translation, transfersMonth)
        assertEquals(0.0, result, 0.001)
    }
    @Test
    fun testTaxCalculationMastercardProcent() {
        val card = "Mastercard"
        val translation = 80000
        val transfersMonth = 0
        val result = taxCalculation(card, translation, transfersMonth)
        assertEquals(500.0, result, 0.001)
    }
    @Test
    fun testTaxCalculationVK_Play() {
        val card = "VK_Play"
        val translation = 74000
        val transfersMonth = 0

        val result = taxCalculation(card, translation, transfersMonth)
        assertEquals(0.0, result, 0.001)
    }

    @Test
    fun testMaxAmountMonthExcess() {
        val translation = 500000
        val transfersMonth = 100001

        val result = maxAmountMonth(card, translation, transfersMonth)
        assertEquals(-1, result)
    }
    @Test
    fun testMaxAmountMonth() {
        val translation = 400000
        val transfersMonth = 100001

        val result = maxAmountMonth(card, translation, transfersMonth)
        assertEquals(0, result)
    }

    @Test
    fun testText() {
        val card = "VK_Play"
        val translation = 500000
        val transfersMonth = 100001
        val txt = "Вы превысили сумму максимальных платежей  в этом месяце"

        val result = text(card, translation, transfersMonth)
        assertEquals(txt, result)
    }
    @Test
    fun testTextElse() {
        val card = "VK_Play"
        val translation = 500000
        val transfersMonth = 100000
        val txt = (
                "Комиссия за текущий перевод по карте $card составляет - ${
                    taxCalculation(card, translation, transfersMonth)
                } рублей"
                )

        val result = text(card, translation, transfersMonth)
        assertEquals(txt, result)
    }
}
