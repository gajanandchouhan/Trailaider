package com.trailaider.app.data.network;


import com.trailaider.app.data.CourseApiResponse;
import com.trailaider.app.data.model.BaseResponseModel;
import com.trailaider.app.data.model.chat.MessageResponseModel;
import com.trailaider.app.data.model.chat.SendMessageResponseModel;
import com.trailaider.app.data.model.login.LoginResponseModel;
import com.trailaider.app.data.model.review.ReviewResponseModel;
import com.trailaider.app.data.model.trek.TrekResponseModel;
import com.trailaider.app.data.model.userprofile.UserProfileResponseModel;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.QueryMap;

/**
 * Created by JAIN COMPUTERS on 11/18/2017.
 */

public interface ApiInterface {
    @Multipart
    @POST("login")
    Observable<LoginResponseModel> login(@PartMap() Map<String, RequestBody> partMap);

    @Multipart
    @POST("register")
    Observable<LoginResponseModel> register(@PartMap() Map<String, RequestBody> partMap);

    @Multipart
    @POST("forgetPassword")
    Observable<BaseResponseModel> forgetPassword(@PartMap() Map<String, RequestBody> partMap);

    @Multipart
    @POST("verifyOtp")
    Observable<BaseResponseModel> verifyOtp(@PartMap() Map<String, RequestBody> partMap);

    @Multipart
    @POST("changePassword")
    Observable<BaseResponseModel> changePassword(@PartMap() Map<String, RequestBody> partMap);

    @Multipart
    @POST("updateProfile")
    Observable<LoginResponseModel> updateProfile(@PartMap() Map<String, RequestBody> stringParams, @Part MultipartBody.Part part);

    @POST("addTrek")
    Observable<BaseResponseModel> addTrek(@Body RequestBody fileParams);

    @GET("getTreks")
    Observable<TrekResponseModel> getTrek(@QueryMap Map<String, String> stringParams);

    @POST("addReview")
    Observable<BaseResponseModel> addReview(@Body RequestBody fileParams);

    @GET("getReviews")
    Observable<ReviewResponseModel> getReviews(@QueryMap Map<String, String> stringParams);

    @Multipart
    @POST("addRating")
    Observable<BaseResponseModel> addRating(@PartMap() Map<String, RequestBody> stringParams);

    @GET("getUserProfile")
    Observable<UserProfileResponseModel> getFriendProfile(@QueryMap Map<String, String> stringParams);

    @Multipart
    @POST("addFriend")
    Observable<BaseResponseModel> addFriend(@PartMap() Map<String, RequestBody> stringParams);

    @GET("getMessages")
    Observable<MessageResponseModel> getMessage(@QueryMap Map<String, String> stringParams);

    @Multipart
    @POST("sendMessage")
    Observable<SendMessageResponseModel> sendMessage(@PartMap() Map<String, RequestBody> stringParams);

    @GET("inboxList")
    Observable<MessageResponseModel> getInbox(@QueryMap Map<String, String> body);

    @Multipart
    @POST("resetPassword")
    Observable<BaseResponseModel> resetPassword(@PartMap() Map<String, RequestBody> stringParams);

    @Multipart
    @POST("unFriendRequest")
    Observable<BaseResponseModel> unFriend(@PartMap() Map<String, RequestBody> stringParams);


    @Multipart
    @POST("acceptFriendRequest")
    Observable<BaseResponseModel> acceptFriend(@PartMap() Map<String, RequestBody> stringParams);

    @Multipart
    @POST("rejectFriendRequest")
    Observable<BaseResponseModel> recjectFriend(@PartMap() Map<String, RequestBody> stringParams);

    @Multipart
    @POST("getCourse")
    Observable<CourseApiResponse> getCourses(@PartMap() Map<String, RequestBody> stringParams);
}
