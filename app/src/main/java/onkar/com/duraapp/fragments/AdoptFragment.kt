package onkar.com.duraapp.fragments


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import onkar.com.duraapp.R
import onkar.com.duraapp.activites.PostDetailActivity
import onkar.com.duraapp.adapters.AdapterClickListener
import onkar.com.duraapp.adapters.AdoptAdapter


class AdoptFragment : Fragment(), AdapterClickListener {
    override fun onItemClick(pos: Int) {
        val intent = Intent(context, PostDetailActivity::class.java)
        startActivity(intent)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_adopt, container, false)

        val rv = view.findViewById<RecyclerView>(R.id.rv)
        rv.adapter = AdoptAdapter(this)

        view.findViewById<TextView>(R.id.textView2).setOnClickListener { openAlert(view) }
        view.findViewById<ImageView>(R.id.imageView).setOnClickListener { openAlert(view) }

        return view
    }

    fun openAlert(view: View) {
        val builder = AlertDialog.Builder(context!!)
                .setItems(R.array.city_array) { _, which ->
                    val city = resources.getStringArray(R.array.city_array)[which]
                    view.findViewById<TextView>(R.id.textView2).text = city
                }
        builder.setTitle("select city")
        builder.create().show()
    }

    companion object {
        @JvmStatic
        fun newInstance() = AdoptFragment()
    }
}
