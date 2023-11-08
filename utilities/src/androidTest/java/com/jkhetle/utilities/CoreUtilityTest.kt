package com.jkhetle.utilities

import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert
import org.junit.Test

class CoreUtilityTest {

    @Test
    fun isInternetConnectedUnitTest_connected_true() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val isNetworkAvailable = CoreUtility.isInternetConnected(context)
        Assert.assertEquals(true, isNetworkAvailable)
    }
}
