package com.ump.ishiharacolorblindtest


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.ump.ishiharacolorblindtest.view.HomeActivity
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class HomeActivityTest2 {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(HomeActivity::class.java)

    @Test
    fun mainActivityTest2() {
        val cardView = onView(
            allOf(
                withId(R.id.item_2),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    7
                ),
                isDisplayed()
            )
        )
        cardView.perform(click())

        val textInputEditText = onView(
            allOf(
                withId(R.id.textFieldEditText), isDisplayed()
            )
        )
        textInputEditText.perform(replaceText("12"), closeSoftKeyboard())

        val textInputEditText2 = onView(
            allOf(
                withId(R.id.textFieldEditText),
                withText("12"),
                isDisplayed()
            )
        )
        textInputEditText2.perform(pressImeActionButton())

        val appCompatButton = onView(
            allOf(
                withId(R.id.submitButtton),
                withText("Halaman Selanjutnya"),
                isDisplayed()
            )
        )
        appCompatButton.perform(click())
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
