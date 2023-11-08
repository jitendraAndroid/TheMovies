package com.jkhetle.utilities

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CoreUtilityUnitTest {

    @Test
    fun isInternetConnectedUnitTest_connected_true() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val isNetworkAvailable = CoreUtility.isInternetConnected(context)
        Assert.assertEquals(true, isNetworkAvailable)
    }


}