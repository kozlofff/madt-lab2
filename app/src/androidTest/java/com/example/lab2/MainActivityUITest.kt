package com.example.lab2

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Before
    fun launchActivity() {
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun testWordCount() {
        onView(withId(R.id.editText)).perform(typeText("Kaunas Vilnius Klaipeda"))
        onView(withId(R.id.spinner)).perform(click())
        onView(withText("Words")).perform(click());

        onView(withId(R.id.countButton)).perform(click())

        onView(withId(R.id.resultTextView)).check(matches(withText("Result: 3")))
    }

    @Test
    fun testCharacterCount() {
        onView(withId(R.id.editText)).perform(typeText("Kaunas Vilnius Klaipeda"))
        onView(withId(R.id.spinner)).perform(click())
        onView(withText("Characters")).perform(click());

        onView(withId(R.id.countButton)).perform(click())

        onView(withId(R.id.resultTextView)).check(matches(withText("Result: 23")))
    }
}
