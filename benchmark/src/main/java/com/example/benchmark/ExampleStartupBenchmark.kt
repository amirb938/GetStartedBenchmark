package com.example.benchmark

import androidx.benchmark.macro.CompilationMode
import androidx.benchmark.macro.FrameTimingMetric
import androidx.benchmark.macro.MacrobenchmarkScope
import androidx.benchmark.macro.StartupMode
import androidx.benchmark.macro.StartupTimingMetric
import androidx.benchmark.macro.junit4.MacrobenchmarkRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.Direction
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.Until
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExampleStartupBenchmark {
    @get:Rule
    val benchmarkRule = MacrobenchmarkRule()

    @Test
    fun startup() = benchmarkRule.measureRepeated(
        packageName = "ir.huma.bench",
        metrics = listOf(
            StartupTimingMetric()
        ),
        iterations = 2,
        startupMode = StartupMode.COLD,
        compilationMode = CompilationMode.None()
    ) {
        pressHome()
        startActivityAndWait()
    }

    @Test
    fun scroll() = benchmarkRule.measureRepeated(
        packageName = "ir.huma.bench",
        metrics = listOf(
            FrameTimingMetric()
        ),
        iterations = 2,
        startupMode = StartupMode.COLD,
        compilationMode = CompilationMode.None()
    ) {
        pressHome()
        startActivityAndWait()
        val uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        repeat(15) { uiDevice.pressDPadDown() }
    }
}