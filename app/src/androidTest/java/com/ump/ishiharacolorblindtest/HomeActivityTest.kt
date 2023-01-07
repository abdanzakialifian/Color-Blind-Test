package com.ump.ishiharacolorblindtest

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.ump.ishiharacolorblindtest.view.HomeActivity
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class HomeActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(HomeActivity::class.java)

    @Test
    fun mainActivityTest() {
        val cardView = onView(
            allOf(
                withId(R.id.item_2),
                isDisplayed()
            )
        )
        cardView.perform(click())

        val textInputEditText = onView(
            allOf(
                withId(R.id.textFieldEditText),
                isDisplayed()
            )
        )
        textInputEditText.perform(replaceText("12"), closeSoftKeyboard())

        val textInputEditText2 = onView(
            allOf(
                withId(R.id.textFieldEditText), withText("12"),
                isDisplayed()
            )
        )
        textInputEditText2.perform(pressImeActionButton())

        val appCompatButton = onView(
            allOf(
                withId(R.id.submitButtton), withText("Halaman Selanjutnya"),
                isDisplayed()
            )
        )
        appCompatButton.perform(click())

        val textInputEditText3 = onView(
            allOf(
                withId(R.id.textFieldEditText),
                isDisplayed()
            )
        )
        textInputEditText3.perform(replaceText("8"), closeSoftKeyboard())

        val textInputEditText4 = onView(
            allOf(
                withId(R.id.textFieldEditText), withText("8"),
                isDisplayed()
            )
        )
        textInputEditText4.perform(pressImeActionButton())

        val appCompatButton2 = onView(
            allOf(
                withId(R.id.submitButtton), withText("Halaman Selanjutnya"),
                isDisplayed()
            )
        )
        appCompatButton2.perform(click())

        val textInputEditText5 = onView(
            allOf(
                withId(R.id.textFieldEditText),
                isDisplayed()
            )
        )
        textInputEditText5.perform(replaceText("5"), closeSoftKeyboard())

        val textInputEditText6 = onView(
            allOf(
                withId(R.id.textFieldEditText), withText("5"),
                isDisplayed()
            )
        )
        textInputEditText6.perform(pressImeActionButton())

        val appCompatButton3 = onView(
            allOf(
                withId(R.id.submitButtton), withText("Halaman Selanjutnya"),
                isDisplayed()
            )
        )
        appCompatButton3.perform(click())

        val textInputEditText7 = onView(
            allOf(
                withId(R.id.textFieldEditText),
                isDisplayed()
            )
        )
        textInputEditText7.perform(replaceText("29"), closeSoftKeyboard())

        val textInputEditText8 = onView(
            allOf(
                withId(R.id.textFieldEditText), withText("29"),
                isDisplayed()
            )
        )
        textInputEditText8.perform(pressImeActionButton())

        val appCompatButton4 = onView(
            allOf(
                withId(R.id.submitButtton), withText("Halaman Selanjutnya"),
                isDisplayed()
            )
        )
        appCompatButton4.perform(click())

        val textInputEditText9 = onView(
            allOf(
                withId(R.id.textFieldEditText),
                isDisplayed()
            )
        )
        textInputEditText9.perform(replaceText("74"), closeSoftKeyboard())

        val textInputEditText10 = onView(
            allOf(
                withId(R.id.textFieldEditText), withText("74"),
                isDisplayed()
            )
        )
        textInputEditText10.perform(pressImeActionButton())

        val appCompatButton5 = onView(
            allOf(
                withId(R.id.submitButtton), withText("Halaman Selanjutnya"),
                isDisplayed()
            )
        )
        appCompatButton5.perform(click())

        val textInputEditText11 = onView(
            allOf(
                withId(R.id.textFieldEditText),
                isDisplayed()
            )
        )
        textInputEditText11.perform(replaceText("7"), closeSoftKeyboard())

        val textInputEditText12 = onView(
            allOf(
                withId(R.id.textFieldEditText), withText("7"),
                isDisplayed()
            )
        )
        textInputEditText12.perform(pressImeActionButton())

        val appCompatButton6 = onView(
            allOf(
                withId(R.id.submitButtton), withText("Halaman Selanjutnya"),
                isDisplayed()
            )
        )
        appCompatButton6.perform(click())

        val textInputEditText13 = onView(
            allOf(
                withId(R.id.textFieldEditText),
                isDisplayed()
            )
        )
        textInputEditText13.perform(replaceText("45"), closeSoftKeyboard())

        val textInputEditText14 = onView(
            allOf(
                withId(R.id.textFieldEditText), withText("45"),
                isDisplayed()
            )
        )
        textInputEditText14.perform(pressImeActionButton())

        val appCompatButton7 = onView(
            allOf(
                withId(R.id.submitButtton), withText("Halaman Selanjutnya"),
                isDisplayed()
            )
        )
        appCompatButton7.perform(click())

        val textInputEditText15 = onView(
            allOf(
                withId(R.id.textFieldEditText),
                isDisplayed()
            )
        )
        textInputEditText15.perform(replaceText("2"), closeSoftKeyboard())

        val textInputEditText16 = onView(
            allOf(
                withId(R.id.textFieldEditText), withText("2"),
                isDisplayed()
            )
        )
        textInputEditText16.perform(pressImeActionButton())

        val appCompatButton8 = onView(
            allOf(
                withId(R.id.submitButtton), withText("Halaman Selanjutnya"),
                isDisplayed()
            )
        )
        appCompatButton8.perform(click())

        val appCompatImageView = onView(
            allOf(
                withId(R.id.img_option3),
                isDisplayed()
            )
        )
        appCompatImageView.perform(click())

        val appCompatButton9 = onView(
            allOf(
                withId(R.id.submitButtton), withText("Halaman Selanjutnya"),
                isDisplayed()
            )
        )
        appCompatButton9.perform(click())

        val textInputEditText17 = onView(
            allOf(
                withId(R.id.textFieldEditText),
                isDisplayed()
            )
        )
        textInputEditText17.perform(replaceText("16"), closeSoftKeyboard())

        val textInputEditText18 = onView(
            allOf(
                withId(R.id.textFieldEditText), withText("16"),
                isDisplayed()
            )
        )
        textInputEditText18.perform(pressImeActionButton())

        val appCompatButton10 = onView(
            allOf(
                withId(R.id.submitButtton), withText("Halaman Selanjutnya"),
                isDisplayed()
            )
        )
        appCompatButton10.perform(click())

        val appCompatImageView2 = onView(
            allOf(
                withId(R.id.img_option3),
                isDisplayed()
            )
        )
        appCompatImageView2.perform(click())

        val appCompatButton11 = onView(
            allOf(
                withId(R.id.submitButtton), withText("Halaman Selanjutnya"),
                isDisplayed()
            )
        )
        appCompatButton11.perform(click())

        val textInputEditText19 = onView(
            allOf(
                withId(R.id.textFieldEditText),
                isDisplayed()
            )
        )
        textInputEditText19.perform(replaceText("35"), closeSoftKeyboard())

        val textInputEditText20 = onView(
            allOf(
                withId(R.id.textFieldEditText), withText("35"),
                isDisplayed()
            )
        )
        textInputEditText20.perform(pressImeActionButton())

        val appCompatButton12 = onView(
            allOf(
                withId(R.id.submitButtton), withText("Halaman Selanjutnya"),
                isDisplayed()
            )
        )
        appCompatButton12.perform(click())

        val textInputEditText21 = onView(
            allOf(
                withId(R.id.textFieldEditText),
                isDisplayed()
            )
        )
        textInputEditText21.perform(replaceText("96"), closeSoftKeyboard())

        val textInputEditText22 = onView(
            allOf(
                withId(R.id.textFieldEditText), withText("96"),
                isDisplayed()
            )
        )
        textInputEditText22.perform(pressImeActionButton())

        val appCompatButton13 = onView(
            allOf(
                withId(R.id.submitButtton), withText("Halaman Selanjutnya"),
                isDisplayed()
            )
        )
        appCompatButton13.perform(click())

        val appCompatImageView3 = onView(
            allOf(
                withId(R.id.img_option2),
                isDisplayed()
            )
        )
        appCompatImageView3.perform(click())

        val appCompatButton14 = onView(
            allOf(
                withId(R.id.submitButtton), withText("Selesai"),
                isDisplayed()
            )
        )
        appCompatButton14.perform(click())

        val appCompatButton15 = onView(
            allOf(
                withId(R.id.backBtn), withText("Menu Home"),
                isDisplayed()
            )
        )
        appCompatButton15.perform(click())
    }
}
