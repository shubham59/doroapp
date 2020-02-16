package onkar.com.duraapp.activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import onkar.com.duraapp.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    fun onLoginClick(view: View){
        val intent = Intent(this, LoginActivity::class.java)
        intent.putExtra("isLogin", true)
        startActivity(intent)
    }

    fun onSignUpClick(view: View){
        val intent = Intent(this, LoginActivity::class.java)
        intent.putExtra("isLogin", false)
        startActivity(intent)
    }
}
