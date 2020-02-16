package onkar.com.duraapp.activites

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.transition.TransitionManager
import android.text.Editable
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*
import onkar.com.duraapp.AppConstants
import onkar.com.duraapp.R
import onkar.com.duraapp.model.RegisterUserModel
import onkar.com.duraapp.model.RegisterUserResponseModel
import onkar.com.duraapp.model.VerifyRequestModel
import onkar.com.duraapp.model.VerifyResponseModel
import onkar.com.duraapp.web_controller.RetrofitMain
import onkar.com.duraapp.web_controller.RetrofitServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    private var isLogin = false
    private var isOtp = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        isLogin = intent.getBooleanExtra("isLogin", false)

        if (isLogin) {
            tv_end.text = "don't have an account? sign up"
            tv_label.text = "login"
            tv_fp.visibility = View.VISIBLE
            btn_action.text = "login"
        } else {
            tv_end.text = "already have an account? login"
            tv_label.text = "sign up"
            tv_fp.visibility = View.GONE
            btn_action.text = "sign up"
        }

        btn_action.setOnClickListener {
            if (isOtp) {
                val verifyRequestModel = VerifyRequestModel(et_email.text.toString(), et_pass.text.toString())
                val progressDialog = ProgressDialog.show(this, "", "Loading...")

                val retrofit = RetrofitMain.getRetrofit().create(RetrofitServices::class.java)
                val call = retrofit.verifyOTP(verifyRequestModel)
                call.enqueue(object : Callback<VerifyResponseModel> {
                    override fun onFailure(call: Call<VerifyResponseModel>?, t: Throwable?) {
                        progressDialog.dismiss()
                    }

                    override fun onResponse(call: Call<VerifyResponseModel>?, response: Response<VerifyResponseModel>?) {
                        progressDialog.dismiss()
                        try {
                            val model = response!!.body()
                            handleOtpLogin(model)
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }

                })
            } else {

//                val intent = Intent(this, HomeActivity::class.java)
//                startActivity(intent)
                val registerUserModel = RegisterUserModel(et_email.text.toString())
                val progressDialog = ProgressDialog.show(this, "", "Loading...")

                val retrofit = RetrofitMain.getRetrofit().create(RetrofitServices::class.java)
                val call = retrofit.regsiterUser(registerUserModel)
                call.enqueue(object : Callback<RegisterUserResponseModel> {
                    override fun onFailure(call: Call<RegisterUserResponseModel>?, t: Throwable?) {
                        progressDialog.dismiss()
                    }

                    override fun onResponse(call: Call<RegisterUserResponseModel>?, response: Response<RegisterUserResponseModel>?) {
                        progressDialog.dismiss()
                        try {
                            val model = response!!.body()
                            handleOTPUI(model)
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }

                })
            }

        }
    }

    private fun handleOtpLogin(model: VerifyResponseModel?) {
        AppConstants.getInstance().verifyResponseModel = model
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    private fun handleOTPUI(model: RegisterUserResponseModel?) {
        isOtp = true
        TransitionManager.beginDelayedTransition(root)
        et_pass.visibility = View.VISIBLE
        et_email.visibility = View.GONE

        et_pass.setText(model!!.otp.toString())
    }
}
