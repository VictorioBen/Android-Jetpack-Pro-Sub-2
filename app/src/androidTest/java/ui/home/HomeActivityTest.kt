package ui.home

import android.view.View
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.PerformException
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.google.android.material.tabs.TabLayout
import com.submission.victorio_jetpackpro.R
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import ui.tv.detail.DetailTvActivity
import utils.dataDummy.DataDummy

class HomeActivityMovieTest {
    private val dummyMovie = DataDummy.generateDummyMovies()
    private val dummyTvShow = DataDummy.generateDummyTvShow()

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)


    @Test
    fun loadMovies() {
        onView(withId(R.id.rvMovie)).check(matches(isDisplayed()))
        onView(withId(R.id.rvMovie)).perform(
                RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                        dummyMovie.size
                )
        )
    }


    @Test
    fun loadDetailMovies() {

        onView(withId(R.id.rvMovie)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                        0,
                        click()
                )
        )

        onView(withId(R.id.txtTitleDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.txtTitleDetail)).check(matches(withText(dummyMovie[0].title)))

        onView(withId(R.id.txtGenreDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.txtGenreDetail)).check(matches(withText(dummyMovie[0].genre)))

        onView(withId(R.id.txtDurationDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.txtDurationDetail)).check(matches(withText(dummyMovie[0].duration)))

        onView(withId(R.id.txtDirectorDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.txtDirectorDetail)).check(matches(withText(dummyMovie[0].director)))

        onView(withId(R.id.txtAgeDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.txtAgeDetail)).check(matches(withText(dummyMovie[0].age)))

        onView(withId(R.id.imageMovieDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.imageMovieDetail)).check(matches(withDrawable(dummyMovie[0].poster)))

        onView(withId(R.id.txtSynopsisDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.txtSynopsisDetail)).check(matches(withText(dummyMovie[0].synopsis)))

        onView(withId(R.id.txtRateDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.txtRateDetail)).check(matches(withText(dummyMovie[0].rating)))


    }

    @Test
    fun loadTvShow() {
        onView(withId(R.id.tabHome)).perform(selectTabAtPosition(1))
        onView(withId(R.id.rvTvShow)).check(matches(isDisplayed()))
        onView(withId(R.id.rvTvShow)).perform(
                RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                        dummyTvShow.size

                )
        )

    }

    @Test
    fun loadDetailTvShow() {
        onView(withId(R.id.tabHome)).perform(selectTabAtPosition(1))
        onView(withId(R.id.rvTvShow)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                        0,
                        click()
                )
        )
        val detailTvScenario = ActivityScenario.launch(DetailTvActivity::class.java)

        onView(withId(R.id.txtTitleTvDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.txtGenreTvDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.txtDurationTvDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.txtDirectorTvDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.txtAgeTvDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.imageTvDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.txtSynopsisTvDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.txtRateTvDetail)).check(matches(isDisplayed()))

        detailTvScenario.close()
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


    private fun withDrawable(@DrawableRes id: Int) = object : TypeSafeMatcher<View>() {
        override fun describeTo(description: Description) {
            description.appendText("ImageView with drawable same as drawable with id $id")
        }

        override fun matchesSafely(item: View?): Boolean {


            return item is ImageView
        }
    }


}
