package com.jkhetle.utilities

import java.util.concurrent.TimeUnit

object StringUtility {
    fun fromMinutesToHHmm(minutes: Int): String {
        val hours = TimeUnit.MINUTES.toHours(minutes.toLong())
        val remainMinutes = minutes - TimeUnit.HOURS.toMinutes(hours)
        return String.format("%1dh %02dmins", hours, remainMinutes)
    }
}
