package onkar.com.duraapp.fragments


import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentPagerAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_posts.*
import okhttp3.ResponseBody
import onkar.com.duraapp.AppConstants
import onkar.com.duraapp.R
import onkar.com.duraapp.activites.AdoptionActivity
import onkar.com.duraapp.adapters.FragmentPostAdapter
import onkar.com.duraapp.model.OwnModel
import onkar.com.duraapp.model.OwnRequestModel
import onkar.com.duraapp.model.PostResponseModel
import onkar.com.duraapp.web_controller.RetrofitMain
import onkar.com.duraapp.web_controller.RetrofitServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PostsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_posts, container, false)

        view.findViewById<TextView>(R.id.textView19).setOnClickListener {
            val intent = Intent(context, AdoptionActivity::class.java)
            startActivity(intent)
        }

        getDataFromServer()

        return view
    }

    private fun getDataFromServer() {
        val progressDialog = ProgressDialog.show(context, "", "Loading...")
        val retrofit = RetrofitMain.getRetrofit().create(RetrofitServices::class.java)
        val call = retrofit.getOwnPosts("token " + AppConstants.getInstance().verifyResponseModel.token)
        call.enqueue(object : Callback<List<PostResponseModel>> {
            override fun onFailure(call: Call<List<PostResponseModel>>?, t: Throwable?) {
                progressDialog.dismiss()
            }

            override fun onResponse(call: Call<List<PostResponseModel>>?, response: Response<List<PostResponseModel>>?) {
                progressDialog.dismiss()
                try {
                    val model = response!!.body()
                    getOtherDataFromServer(model)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

        })
    }

    private fun getOtherDataFromServer(model: List<PostResponseModel>?) {
        val progressDialog = ProgressDialog.show(context, "", "Loading...")
        val retrofit = RetrofitMain.getRetrofit().create(RetrofitServices::class.java)
        val call = retrofit.getFoundPosts("token " + AppConstants.getInstance().verifyResponseModel.token)
        call.enqueue(object : Callback<List<PostResponseModel>> {
            override fun onFailure(call: Call<List<PostResponseModel>>?, t: Throwable?) {
                progressDialog.dismiss()
            }

            override fun onResponse(call: Call<List<PostResponseModel>>?, response: Response<List<PostResponseModel>>?) {
                progressDialog.dismiss()
                try {
                    val models = response!!.body()
                    mergeBothData(model, models)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

        })
    }

    private fun mergeBothData(model: List<PostResponseModel>?, models: List<PostResponseModel>?) {
        val list = mutableListOf<OwnModel>()
        for (tempModel in model!!) {
            val tempModel1 = OwnModel()
            for (mo in tempModel.details) {
                when (mo.question.toLowerCase()) {
                    "name of the dog" -> tempModel1.name = mo.answer
                    "breed", "breed of the dog" -> tempModel1.breed = mo.answer
                    "age" -> tempModel1.age = mo.answer
                    "gender" -> tempModel1.gender = mo.answer
                    "is the dog vaccinated" -> tempModel1.vaccination = mo.answer
                }
            }
            list.add(tempModel1)
        }
        rv1.layoutManager = LinearLayoutManager(activity)
        rv1.adapter = FragmentPostAdapter(list)

        val list1 = mutableListOf<OwnModel>()
        for (tempModel in models!!) {
            val tempModel1 = OwnModel()
            for (mo in tempModel.details) {
                when (mo.question.toLowerCase()) {
                    "name of the dog" -> tempModel1.name = mo.answer
                    "breed", "breed of the dog" -> tempModel1.breed = mo.answer
                    "age" -> tempModel1.age = mo.answer
                    "gender" -> tempModel1.gender = mo.answer
                    "is the dog vaccinated" -> tempModel1.vaccination = mo.answer
                }
            }
            list1.add(tempModel1)
        }
        rv2.layoutManager = LinearLayoutManager(activity)
        rv2.adapter = FragmentPostAdapter(list1)
    }


    companion object {
        @JvmStatic
        fun newInstance() = PostsFragment()
    }
}
