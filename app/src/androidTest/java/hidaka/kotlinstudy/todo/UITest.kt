package hidaka.kotlinstudy.todo


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class UITest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun uITest() {
        val cardView = onView(
            allOf(
                withId(R.id.pages_recycler_view_vh_card_view),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.main_recycler_view),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        cardView.perform(click())

        val actionMenuItemView = onView(
            allOf(
                withId(R.id.page_detail_toolbar_action_delete), withContentDescription("Delete"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.toolbar),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        actionMenuItemView.perform(click())

        val floatingActionButton = onView(
            allOf(
                withId(R.id.page_detail_floating_action_button),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.main_fragment_host),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        floatingActionButton.perform(click())

        val appCompatEditText = onView(
            allOf(
                withId(R.id.component_page_form_title), withText("あかさたな"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.page_form_component_host),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatEditText.perform(replaceText(""))

        val appCompatEditText2 = onView(
            allOf(
                withId(R.id.component_page_form_title),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.page_form_component_host),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatEditText2.perform(closeSoftKeyboard())

        val floatingActionButton2 = onView(
            allOf(
                withId(R.id.page_new_floating_action_button),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.main_fragment_host),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        floatingActionButton2.perform(click())

        val appCompatEditText3 = onView(
            allOf(
                withId(R.id.component_page_form_title),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.page_form_component_host),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatEditText3.perform(replaceText("O"), closeSoftKeyboard())

        val floatingActionButton3 = onView(
            allOf(
                withId(R.id.page_new_floating_action_button),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.main_fragment_host),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        floatingActionButton3.perform(click())

        val appCompatImageButton = onView(
            allOf(
                withContentDescription("上へ移動"),
                childAtPosition(
                    allOf(
                        withId(R.id.toolbar),
                        childAtPosition(
                            withClassName(`is`("android.widget.FrameLayout")),
                            0
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatImageButton.perform(click())

        val floatingActionButton4 = onView(
            allOf(
                withId(R.id.main_floating_action_button),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.main_fragment_host),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        floatingActionButton4.perform(click())

        val floatingActionButton5 = onView(
            allOf(
                withId(R.id.page_new_floating_action_button),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.main_fragment_host),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        floatingActionButton5.perform(click())

        val appCompatEditText4 = onView(
            allOf(
                withId(R.id.component_page_form_content),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.page_form_component_host),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatEditText4.perform(replaceText("K"), closeSoftKeyboard())

        val floatingActionButton6 = onView(
            allOf(
                withId(R.id.page_new_floating_action_button),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.main_fragment_host),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        floatingActionButton6.perform(click())

        val appCompatImageButton2 = onView(
            allOf(
                withContentDescription("上へ移動"),
                childAtPosition(
                    allOf(
                        withId(R.id.toolbar),
                        childAtPosition(
                            withClassName(`is`("android.widget.FrameLayout")),
                            0
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatImageButton2.perform(click())

        val floatingActionButton7 = onView(
            allOf(
                withId(R.id.main_floating_action_button),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.main_fragment_host),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        floatingActionButton7.perform(click())

        val appCompatEditText5 = onView(
            allOf(
                withId(R.id.component_page_form_title),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.page_form_component_host),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatEditText5.perform(replaceText("I"), closeSoftKeyboard())

        val floatingActionButton8 = onView(
            allOf(
                withId(R.id.page_new_floating_action_button),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.main_fragment_host),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        floatingActionButton8.perform(click())
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
