package onkar.com.duraapp.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import onkar.com.duraapp.R

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
    }

    fun onBackClick(view: View){
        onBackPressed()
    }
}
