package ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.submission.victorio_jetpackpro.R



class HomeActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        val viewPager = findViewById<ViewPager>(R.id.homePager)
        viewPager?.adapter = HomePagerAdapter(this,supportFragmentManager)

        val tabLayout = findViewById<TabLayout>(R.id.tabHome)
        tabLayout?.setupWithViewPager(viewPager)

    }



}