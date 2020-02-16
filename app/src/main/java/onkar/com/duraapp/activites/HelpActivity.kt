package onkar.com.duraapp.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import onkar.com.duraapp.R

class HelpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)
    }

    fun onBackClick(view: View){
        onBackPressed()
    }
}
