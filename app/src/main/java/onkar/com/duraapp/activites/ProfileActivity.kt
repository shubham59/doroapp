package onkar.com.duraapp.activites

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_profile.*
import onkar.com.duraapp.AppConstants
import onkar.com.duraapp.R
import onkar.com.duraapp.model.ProfileRequestModel
import onkar.com.duraapp.model.ProfileResponseModel
import onkar.com.duraapp.web_controller.RetrofitMain
import onkar.com.duraapp.web_controller.RetrofitServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        button2.setOnClickListener {
            val name = et_name.text.toString()
            val email = et_email.text.toString()
            val phone = et_phone.text.toString()
            val address = et_address.text.toString()

            val profileModel = ProfileRequestModel()
            profileModel.name = name
            profileModel.phone = phone
            profileModel.email = email
            profileModel.address = address
            profileModel.setiAm("an individual")
            profileModel.setiLive("by myself")

            if (radioGroup2.checkedRadioButtonId == radioButton2.id){
                profileModel.setiLive("with my family")
            }
            if (radioGroup3.checkedRadioButtonId == radioButton4.id){
                profileModel.setiLive("with a ngo / organisation")
            }

            saveProfile(profileModel)
        }
    }

    private fun saveProfile(profileModel: ProfileRequestModel) {
        val progressDialog = ProgressDialog.show(this, "", "Loading...")

        val retrofit = RetrofitMain.getRetrofit().create(RetrofitServices::class.java)
        val call = retrofit.saveProfile(profileModel, "token " + AppConstants.getInstance().verifyResponseModel.token)
        call.enqueue(object : Callback<ProfileResponseModel> {
            override fun onFailure(call: Call<ProfileResponseModel>?, t: Throwable?) {
                progressDialog.dismiss()
            }

            override fun onResponse(call: Call<ProfileResponseModel>?, response: Response<ProfileResponseModel>?) {
                progressDialog.dismiss()
                try {
                    val model = response!!.body()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

        })
    }

    fun onBackClick(view: View){
        onBackPressed()
    }
}
