package onkar.com.duraapp.fragments

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.fragment_adoption_data.*
import okhttp3.ResponseBody
import onkar.com.duraapp.AppConstants

import onkar.com.duraapp.R
import onkar.com.duraapp.model.OwnRequestModel
import onkar.com.duraapp.web_controller.RetrofitMain
import onkar.com.duraapp.web_controller.RetrofitServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AdoptionDataFragment : Fragment() {

    private var listener: OnDataFragmentInteractionListener? = null
    private lateinit var ownLayout: LinearLayout
    private lateinit var foundLayout: LinearLayout

    private var selected = 0

    private val genderArray = arrayOf("male", "female")
    private val breedArray = arrayOf("Labrado", "German Shepherd", "Golden Retriever", "Beagle", "Husky", "St. Bernard", "nard", "Pug", "Pomeranian", "Great Dane", "Boxer", "Indian Mongrel", "Others")
    private val ageArray = arrayOf("pup", "pup 1")
    private val injuredArray = arrayOf("yes", "no")
    private val vaccinatedArray = arrayOf("yes", "no")

    private lateinit var spinner_injured: AutoCompleteTextView
    private lateinit var spinner_vac: AutoCompleteTextView
    private lateinit var spinner_age: AutoCompleteTextView
    private lateinit var spinner_age_1: AutoCompleteTextView
    private lateinit var spinner_breed: AutoCompleteTextView
    private lateinit var spinner_breed_1: AutoCompleteTextView
    private lateinit var spinner_gender: AutoCompleteTextView
    private lateinit var spinner_gender_1: AutoCompleteTextView

    private fun setUpSpinner(v: View) {
        spinner_injured = v.findViewById(R.id.spinner_injured)
        spinner_vac = v.findViewById(R.id.spinner_vac)
        spinner_age =  v.findViewById(R.id.spinner_age)
        spinner_age_1 =  v.findViewById(R.id.spinner_age_1)
        spinner_breed =  v.findViewById(R.id.spinner_breed)
        spinner_breed_1 =  v.findViewById(R.id.spinner_breed_1)
        spinner_gender =  v.findViewById(R.id.spinner_gender)
        spinner_gender_1 =  v.findViewById(R.id.spinner_gender_1)


        val aa = ArrayAdapter(context!!, android.R.layout.simple_spinner_item, ageArray)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val ga = ArrayAdapter(context!!, android.R.layout.simple_spinner_item, genderArray)
        ga.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val ba = ArrayAdapter(context!!, android.R.layout.simple_spinner_item, breedArray)
        ba.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val ia = ArrayAdapter(context!!, android.R.layout.simple_spinner_item, injuredArray)
        ia.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val va = ArrayAdapter(context!!, android.R.layout.simple_spinner_item, vaccinatedArray)
        va.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner_injured.setAdapter(ia)
        spinner_vac.setAdapter(va)

        spinner_age.setAdapter(aa)
        spinner_age_1.setAdapter(aa)
        spinner_breed.setAdapter(ba)
        spinner_breed_1.setAdapter(ba)
        spinner_gender.setAdapter(ga)
        spinner_gender_1.setAdapter(ga)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_adoption_data, container, false)
        ownLayout = view.findViewById(R.id.own_layout)
        foundLayout = view.findViewById(R.id.found_layout)

        setUpSpinner(view)

        view.findViewById<Button>(R.id.button2).setOnClickListener { makeAndSaveData() }
        view.findViewById<Button>(R.id.button3).setOnClickListener { makeAndSaveData() }

        return view
    }

    fun radioSelected(type: Int) {
        if (type == 0) {
            ownLayout.visibility = View.VISIBLE
            foundLayout.visibility = View.GONE
        } else {
            foundLayout.visibility = View.VISIBLE
            ownLayout.visibility = View.GONE
        }

        selected = type
    }

    fun makeAndSaveData() {
        val list = ArrayList<OwnRequestModel>()
        if (selected == 1) {
            val model = OwnRequestModel(spinner_age_1.hint.toString().trim(), spinner_age_1.text.toString().trim(), "full_length")
            val model1 = OwnRequestModel(spinner_breed_1.hint.toString().trim(), spinner_breed_1.text.toString().trim(), "objective")
            val model2 = OwnRequestModel(et_l_find_1.hint.toString().trim(), et_find_1.text.toString().trim(), "full_length")
            val model3 = OwnRequestModel(spinner_gender_1.hint.toString().trim(), spinner_gender_1.text.toString().trim(), "objective")
            val model4 = OwnRequestModel(spinner_injured.hint.toString().trim(), spinner_injured.text.toString().trim(), "objective")
            val model5 = OwnRequestModel(et_l_other_1.hint.toString().trim(), et_other_1.text.toString().trim(), "full_length")

            list.add(model)
            list.add(model1)
            list.add(model2)
            list.add(model3)
            list.add(model4)
            list.add(model5)
        } else {
            val model = OwnRequestModel(et_l_name.hint.toString().trim(), et_name.text.toString().trim(), "full_length")
            val model1 = OwnRequestModel(spinner_age.hint.toString().trim(), spinner_age.text.toString().trim(), "objective")
            val model2 = OwnRequestModel(spinner_gender.hint.toString().trim(), spinner_gender.text.toString().trim(), "objective")
            val model3 = OwnRequestModel(spinner_vac.hint.toString().trim(), spinner_vac.text.toString().trim(), "objective")
            val model4 = OwnRequestModel(et_l_why.hint.toString().trim(), et_why.text.toString().trim(), "full_length")
            val model5 = OwnRequestModel(et_l_family.hint.toString().trim(), et_family.text.toString().trim(), "full_length")
            val model6 = OwnRequestModel(et_l_food.hint.toString().trim(), et_food.text.toString().trim(), "full_length")
            val model7 = OwnRequestModel(et_l_other.hint.toString().trim(), et_other.text.toString().trim(), "full_length")
            val model8 = OwnRequestModel(spinner_breed.hint.toString().trim(), spinner_breed.text.toString().trim(), "objective")

            list.add(model)
            list.add(model1)
            list.add(model2)
            list.add(model3)
            list.add(model4)
            list.add(model5)
            list.add(model6)
            list.add(model7)
            list.add(model8)
        }

        saveToServer(list)
    }

    fun saveToServer(list: List<OwnRequestModel>) {
        if (selected == 0) {
            val progressDialog = ProgressDialog.show(context, "", "Loading...")

            val retrofit = RetrofitMain.getRetrofit().create(RetrofitServices::class.java)
            val call = retrofit.ownDog(list, "token " + AppConstants.getInstance().verifyResponseModel.token)
            call.enqueue(object : Callback<ResponseBody> {
                override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
                    progressDialog.dismiss()
                }

                override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {
                    progressDialog.dismiss()
                    try {
                        val model = response!!.body()
                        if (model != null){
                            activity!!.finish()
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }

            })
        } else {
            val progressDialog = ProgressDialog.show(context, "", "Loading...")

            val retrofit = RetrofitMain.getRetrofit().create(RetrofitServices::class.java)
            val call = retrofit.foundDog(list, "token " + AppConstants.getInstance().verifyResponseModel.token)
            call.enqueue(object : Callback<ResponseBody> {
                override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
                    progressDialog.dismiss()
                }

                override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {
                    progressDialog.dismiss()
                    try {
                        val model = response!!.body()
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }

            })
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnDataFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnDataFragmentInteractionListener {
        fun onDataFragmentInteraction()
    }

    companion object {
        @JvmStatic
        fun newInstance() = AdoptionDataFragment()
    }
}
