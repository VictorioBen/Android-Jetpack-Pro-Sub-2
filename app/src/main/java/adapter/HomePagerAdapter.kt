package adapter

import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import ui.movies.MovieFragment

import ui.tv.TvShowFragment

class HomePagerAdapter(fm:FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 2;
    }



    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> {
                MovieFragment()
            }
            1 -> {
                TvShowFragment()
            }
            else -> {
                MovieFragment()
            }
        }
    }





    @Nullable
    override fun getPageTitle(position: Int): CharSequence? {
        when(position) {
            0 -> {
                return "Movie"
            }
            1 -> {
                return "Tv Show"
            }

        }
        return super.getPageTitle(position)
    }


}