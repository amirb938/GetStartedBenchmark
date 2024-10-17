package com.example.benchmark

import androidx.benchmark.macro.FrameTimingMetric
import androidx.benchmark.macro.StartupMode
import androidx.benchmark.macro.StartupTimingMetric
import androidx.benchmark.macro.junit4.MacrobenchmarkRule
import androidx.test.ext.junit.runners.AndroidJUnit4
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
        iterations = 5,
        startupMode = StartupMode.COLD
    ) {
        device.pressBack()
        startActivityAndWait()
    }

    @Test
    fun scroll() = benchmarkRule.measureRepeated(
        packageName = "ir.huma.bench",
        metrics = listOf(
            FrameTimingMetric()
        ),
        iterations = 5,
        startupMode = StartupMode.COLD
    ) {
        device.pressBack()
        startActivityAndWait()
        repeat(15) { device.pressDPadDown() }
    }
}