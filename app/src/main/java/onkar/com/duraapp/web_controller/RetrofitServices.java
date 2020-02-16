package onkar.com.duraapp.web_controller;

import java.util.List;

import okhttp3.ResponseBody;
import onkar.com.duraapp.model.OwnRequestModel;
import onkar.com.duraapp.model.PostResponseModel;
import onkar.com.duraapp.model.ProfileRequestModel;
import onkar.com.duraapp.model.ProfileResponseModel;
import onkar.com.duraapp.model.RegisterUserModel;
import onkar.com.duraapp.model.RegisterUserResponseModel;
import onkar.com.duraapp.model.VerifyRequestModel;
import onkar.com.duraapp.model.VerifyResponseModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface RetrofitServices {

    @POST("auth/register/")
    Call<RegisterUserResponseModel> regsiterUser(@Body RegisterUserModel registerUserModel);

    @POST("auth/verify/")
    Call<VerifyResponseModel> verifyOTP(@Body VerifyRequestModel requestModel);

    @POST("/auth/profile/")
    Call<ProfileResponseModel> saveProfile(@Body ProfileRequestModel model, @Header("Authorization") String token);

    @GET("/auth/profile/")
    Call<ProfileResponseModel> getProfile(@Header("Authorization") String token);

    @POST("/qna/poster/own/")
    Call<ResponseBody> ownDog(@Body List<OwnRequestModel> models, @Header("Authorization") String token);

    @POST("/qna/poster/found/")
    Call<ResponseBody> foundDog(@Body List<OwnRequestModel> models, @Header("Authorization") String token);

    @GET("/qna/poster/own/")
    Call<List<PostResponseModel>> getOwnPosts(@Header("Authorization") String token);

    @GET("/qna/poster/found/")
    Call<List<PostResponseModel>> getFoundPosts(@Header("Authorization") String token);
}
