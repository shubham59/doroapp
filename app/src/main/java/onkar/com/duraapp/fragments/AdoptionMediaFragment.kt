package onkar.com.duraapp.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import onkar.com.duraapp.R


class AdoptionMediaFragment : Fragment() {
    private var listener: OnMediaFragmentInteractionListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_adoption_media, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnMediaFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnMediaFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onMediaFragmentInteraction(uri: Uri)
    }

    companion object {
        @JvmStatic
        fun newInstance() = AdoptionMediaFragment()
    }
}
