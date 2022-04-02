package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.Test

class StatisticsUtilsTest {

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {
        val tasks = listOf(
            Task("title", "desc", isCompleted = false)
        )

        val result = getActiveAndCompletedStats(tasks)

        assertThat(result.completedTasksPercent, equalTo(0f))
        assertThat(result.activeTasksPercent, equalTo(100f))
    }

    @Test
    fun getActiveAndCompletedStats_noActive_returnsZeroHundred() {
        val tasks = listOf(
            Task("title", "desc", isCompleted = true)
        )

        val result = getActiveAndCompletedStats(tasks)

        assertThat(result.completedTasksPercent, equalTo(100f))
        assertThat(result.activeTasksPercent, equalTo(0f))
    }

    @Test
    fun getActiveAndCompletedStats_both_returnsFortySixty() {
        val tasks = listOf(
            Task("title", "desc", isCompleted = true),
            Task("title", "desc", isCompleted = true),
            Task("title", "desc", isCompleted = false),
            Task("title", "desc", isCompleted = false),
            Task("title", "desc", isCompleted = false),
        )

        val result = getActiveAndCompletedStats(tasks)

        assertThat(result.completedTasksPercent, equalTo(40f))
        assertThat(result.activeTasksPercent, equalTo(60f))
    }

    @Test
    fun getActiveAndCompletedStats_null_returnsZeros() {
        val tasks = null

        val result = getActiveAndCompletedStats(tasks)

        assertThat(result.completedTasksPercent, equalTo(0f))
        assertThat(result.activeTasksPercent, equalTo(0f))
    }

    @Test
    fun getActiveAndCompletedStats_empty_returnsZeros() {
        val tasks = emptyList<Task>()

        val result = getActiveAndCompletedStats(tasks)

        assertThat(result.completedTasksPercent, equalTo(0f))
        assertThat(result.activeTasksPercent, equalTo(0f))
    }

}
