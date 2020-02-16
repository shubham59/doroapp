package onkar.com.duraapp.activites

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_adoption.*
import onkar.com.duraapp.R
import onkar.com.duraapp.fragments.AdoptionDataFragment
import onkar.com.duraapp.fragments.AdoptionMediaFragment

class AdoptionActivity : AppCompatActivity(), AdoptionMediaFragment.OnMediaFragmentInteractionListener, AdoptionDataFragment.OnDataFragmentInteractionListener {
    override fun onDataFragmentInteraction() {
        supportFragmentManager.beginTransaction().replace(R.id.container, AdoptionMediaFragment.newInstance()).commitAllowingStateLoss()
    }

    override fun onMediaFragmentInteraction(uri: Uri) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adoption)

        val frag = AdoptionDataFragment.newInstance()
        supportFragmentManager.beginTransaction().replace(R.id.container, frag).commitAllowingStateLoss()

        rg.setOnCheckedChangeListener { _, id ->
            if (id == radioButton5.id){
                frag.radioSelected(0)
            }
            else{
                frag.radioSelected(1)
            }
        }
    }

    fun onBackClick(view: View){
        onBackPressed()
    }
}
