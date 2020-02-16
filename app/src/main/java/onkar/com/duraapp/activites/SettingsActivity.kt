package onkar.com.duraapp.activites

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_settings.*
import onkar.com.duraapp.AppConstants
import onkar.com.duraapp.R
import onkar.com.duraapp.model.ProfileResponseModel
import onkar.com.duraapp.web_controller.RetrofitMain
import onkar.com.duraapp.web_controller.RetrofitServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        getProfile()
    }

    private fun getProfile() {
        val progressDialog = ProgressDialog.show(this, "", "Loading...")

        val retrofit = RetrofitMain.getRetrofit().create(RetrofitServices::class.java)
        val call = retrofit.getProfile("token " + AppConstants.getInstance().verifyResponseModel.token)
        call.enqueue(object : Callback<ProfileResponseModel> {
            override fun onFailure(call: Call<ProfileResponseModel>?, t: Throwable?) {
                progressDialog.dismiss()
            }

            override fun onResponse(call: Call<ProfileResponseModel>?, response: Response<ProfileResponseModel>?) {
                progressDialog.dismiss()
                try {
                    val model = response!!.body()
                    setToUi(model)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

        })
    }

    private fun setToUi(model: ProfileResponseModel?) {
        if (model == null || model.name == null || model.name == "null" ||  model.name.isEmpty()){
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
        else{
            tv_name.text = model.name
            val te = model.email + "   +91 " + model.phone + "\n\n\n" + model.address
            tv_all.text = te
            tv_live.text = model.getiLive()
            tv_am.text = model.getiAm()
        }
    }

    fun onEditClick(view: View){
        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
    }

    fun onReferClick(view: View){
        val intent = Intent(this, ReferActivity::class.java)
        startActivity(intent)
    }

    fun onSupportClick(view: View){
        val intent = Intent(this, HelpActivity::class.java)
        startActivity(intent)
    }

    fun onGuideClick(view: View){
        val intent = Intent(this, GuideActivity::class.java)
        startActivity(intent)
    }

    fun onBackClick(view: View){
        onBackPressed()
    }
}
