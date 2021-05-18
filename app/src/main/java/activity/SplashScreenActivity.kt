package activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.submission.victorio_jetpackpro.R

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler(Looper.getMainLooper()).postDelayed({ //Menuju halaman lain
            val a = Intent(this@SplashScreenActivity, HomeActivity::class.java)
            startActivity(a)
            finish()
        }, 2500)
    }
}