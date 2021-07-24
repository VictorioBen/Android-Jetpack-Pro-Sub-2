package ui.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.*
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.google.android.material.tabs.TabLayout
import com.submission.victorio_jetpackpro.R
import org.hamcrest.CoreMatchers.allOf
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import utils.EspressoIdlingResources

class HomeActivityMovieTest {


    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResources.countingIdlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResources.countingIdlingResource)
    }

    @Test
    fun loadMovies() {
        onView(withId(R.id.rvMovie))
            .check(matches(isDisplayed()))
        onView(withId(R.id.rvMovie))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(20))
    }

    @Test
    fun loadTvShow() {
        onView(withId(R.id.tabHome)).perform(selectTabAtPosition(1))
        onView(withId(R.id.rvTvShow)).check(matches(isDisplayed()))
        onView(withId(R.id.rvTvShow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(20))

    }


    @Test
    fun loadDetailMovies() {
        onView(withId(R.id.rvMovie))
            .check(matches(isDisplayed()))
        onView(withId(R.id.rvMovie))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(20))
        onView(withId(R.id.rvMovie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                10,
                click()
            )
        )

        onView(withId(R.id.txtMvTitleDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.txtMvTaglineDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.txtMvDurationDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.txtMvRelease)).check(matches(isDisplayed()))
        onView(withId(R.id.txtMvStatus)).check(matches(isDisplayed()))
        onView(withId(R.id.imageMovieDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.txtMvSynopsisDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.txtMvRateDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.imgMoviePreview)).check(matches(isDisplayed()))


    }


    @Test
    fun loadDetailTvShow() {
        onView(withId(R.id.tabHome)).perform(selectTabAtPosition(1))
        onView(withId(R.id.rvTvShow)).check(matches(isDisplayed()))
        onView(withId(R.id.rvTvShow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(20))
        onView(withId(R.id.rvTvShow)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                10,
                click()
            )
        )

        onView(withId(R.id.txtTitleTvDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.txtTagline)).check(matches(isDisplayed()))
        onView(withId(R.id.txtFirstAirDate)).check(matches(isDisplayed()))
        onView(withId(R.id.txtSeason)).check(matches(isDisplayed()))
        onView(withId(R.id.txtEpisode)).check(matches(isDisplayed()))
        onView(withId(R.id.txtRuntime)).check(matches(isDisplayed()))
        onView(withId(R.id.imageTvDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.imgTvPreview)).check(matches(isDisplayed()))
        onView(withId(R.id.txtSynopsisTvDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.txtRateTvDetail)).check(matches(isDisplayed()))




        Espresso.closeSoftKeyboard()

        Espresso.pressBack()
    }

    private fun selectTabAtPosition(tabIndex: Int): ViewAction {
        return object : ViewAction {
            override fun getDescription() = "with tab at index $tabIndex"

            override fun getConstraints() =
                allOf(isDisplayed(), isAssignableFrom(TabLayout::class.java))

            override fun perform(uiController: UiController, view: View) {
                val tabLayout = view as TabLayout
                val tabAtIndex: TabLayout.Tab = tabLayout.getTabAt(tabIndex)
                    ?: throw PerformException.Builder()
                        .withCause(Throwable("No tab at index $tabIndex"))
                        .build()

                tabAtIndex.select()
            }
        }
    }





}
