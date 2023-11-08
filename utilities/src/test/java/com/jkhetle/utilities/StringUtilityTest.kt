package com.jkhetle.utilities

import org.junit.Assert
import org.junit.Test

class StringUtilityTest {

    @Test
    fun testFromMinutesToHHmm_input_value_110_expected_1h_50mins() {
        val result = StringUtility.fromMinutesToHHmm(110)
        Assert.assertEquals("1h 50mins", result)
    }

    @Test
    fun testFromMinutesToHHmm_input_value_112_expected_1h_50mins() {
        val result = StringUtility.fromMinutesToHHmm(112)
        Assert.assertNotEquals("1h 50mins", result)
    }

    @Test
    fun testFromMinutesToHHmm_input_value_0_expected_0h_00mins() {
        val result = StringUtility.fromMinutesToHHmm(0)
        Assert.assertEquals("0h 00mins", result)
    }
}
