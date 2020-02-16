package onkar.com.duraapp.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import onkar.com.duraapp.R
import onkar.com.duraapp.activites.AboutActivity
import onkar.com.duraapp.activites.SettingsActivity

class HomeFragment : Fragment() {

    private lateinit var listener: OnHomeFragmentInteraction

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        view.findViewById<ImageView>(R.id.img_settings).setOnClickListener { onSettingsClick() }
        view.findViewById<Button>(R.id.button).setOnClickListener { onAboutClick() }
        view.findViewById<RelativeLayout>(R.id.option_adopt).setOnClickListener { onAdoptClick() }

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnHomeFragmentInteraction){
            listener = context
        }
    }


    private fun onAdoptClick() {
        listener.onAdoptClick()
    }

    private fun onAboutClick() {
        val intent = Intent(activity, AboutActivity::class.java)
        startActivity(intent)
    }

    private fun onSettingsClick() {
        val intent = Intent(activity, SettingsActivity::class.java)
        startActivity(intent)
    }

    interface OnHomeFragmentInteraction {
        fun onAdoptClick()
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}
