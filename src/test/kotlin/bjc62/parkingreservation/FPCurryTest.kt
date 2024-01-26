package bjc62.parkingreservation

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FPCurryTest {
    @Test
    fun testHourToSecond() {
        val hourToSeconds = convertToSeconds("hour")
        assertEquals(3600, hourToSeconds(1))
    }

    @Test
    fun testMinuteToSecond() {
        val minuteToSeconds = convertToSeconds("minute")
        assertEquals(120, minuteToSeconds(2))
    }

    @Test
    fun testConcatCurryFunction() {
        assertEquals(180, convertToSeconds("minute")(3))
    }

    // curry
    private fun convertToSeconds(timeUnit: String): (Int) -> Int {
        when (timeUnit) {
            "hour" -> return { value -> value * 60 * 60 }
            "minute" -> return { value -> value * 60 }
            else -> throw IllegalArgumentException()
        }
    }

    interface SecondConverter {
        fun convert(value: Int): Int
    }

    class MinuteToSecondConverter: SecondConverter {
        override fun convert(value: Int): Int {
            return value * 60
        }
    }

    class HourToSecondConverter: SecondConverter {
        override fun convert(value: Int): Int {
            return value * 60 * 60
        }
    }

    @Test
    fun `equivalent in OOP minute to second`() {
        val minuteToSecondConverter = MinuteToSecondConverter()
        assertEquals(180, minuteToSecondConverter.convert(3))
    }

    @Test
    fun `equivalent in OOP hour to second`() {
        val hourToSecondConverter = HourToSecondConverter()
        assertEquals(2*60*60, hourToSecondConverter.convert(2))
    }
}
