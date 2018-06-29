package com.trailaider.app.data.network;


import android.content.Context;


import com.trailaider.app.R;
import com.trailaider.app.data.model.BaseResponseModel;
import com.trailaider.app.data.model.chat.MessageResponseModel;
import com.trailaider.app.data.model.chat.SendMessageResponseModel;
import com.trailaider.app.data.model.login.LoginResponseData;
import com.trailaider.app.data.model.login.LoginResponseModel;
import com.trailaider.app.data.model.review.ReviewResponseModel;
import com.trailaider.app.data.model.trek.TrekResponseModel;
import com.trailaider.app.data.model.userprofile.UserProfileResponseModel;
import com.trailaider.app.utils.CommonUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Retrofit;


/**
 * Created by JAIN COMPUTERS on 11/18/2017.
 */

public class ApiController implements RequestType {

    private static ApiController apiController;
    private static ApiInterface apiInterface;
    private String language = "en";


    public static ApiController getInstance() {
        if (apiController == null) {
            apiController = new ApiController();
            Retrofit client = ApiClient.getClient();
            apiInterface = client.create(ApiInterface.class);
        }
        return apiController;
    }

    public void call(Context mContext, byte reqTyoe, ResponseHandler handler, HashMap<String, String> body) {
        if (!CheckNetworkState.isOnline(mContext)) {
            CommonUtils.showSnakeBar(mContext, mContext.getString(R.string.no_internet));
            return;
        }
        Map<String, RequestBody> stringMultipartParamsParams = getStringMultipartParamsParams(body);

        switch (reqTyoe) {
            case REQ_TYPE_LOGIN:
                Observable<LoginResponseModel> login = apiInterface.login(stringMultipartParamsParams);
                login.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new ResponseObserver<LoginResponseModel>(handler));
                break;
            case REQ_TYPE_REGISTER:
                Observable<LoginResponseModel> register = apiInterface.register(stringMultipartParamsParams);
                register.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new ResponseObserver<LoginResponseModel>(handler));
                break;
            case REQ_TYPE_FORGOT_PASS:
                Observable<BaseResponseModel> forgotPass = apiInterface.forgetPassword(stringMultipartParamsParams);
                forgotPass.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new ResponseObserver<BaseResponseModel>(handler));
                break;

            case REQ_TYPE_VERIFY_OTP:
                Observable<BaseResponseModel> verfyotp = apiInterface.verifyOtp(stringMultipartParamsParams);
                verfyotp.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new ResponseObserver<BaseResponseModel>(handler));
                break;

            case REQ_TYPE_CHANGE_PASSWORD:
                Observable<BaseResponseModel> changePass = apiInterface.changePassword(stringMultipartParamsParams);
                changePass.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new ResponseObserver<BaseResponseModel>(handler));
                break;

            /*case REQ_TYPE_ADD_TREK:
                Observable<BaseResponseModel> addTrek = apiInterface.addTrek(stringMultipartParamsParams);
                addTrek.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new ResponseObserver<BaseResponseModel>(handler));
                break;*/

            case REQ_TYPE_ADD_RATING:
                Observable<BaseResponseModel> addRating = apiInterface.addRating(stringMultipartParamsParams);
                addRating.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new ResponseObserver<BaseResponseModel>(handler));
                break;

            case SEND_SMS:
                Observable<SendMessageResponseModel> sendMessageResponseModelObservable = apiInterface.sendMessage(stringMultipartParamsParams);
                sendMessageResponseModelObservable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new ResponseObserver<SendMessageResponseModel>(handler));
                break;

            case REQ_TYPE_ADD_FRIEND:
                Observable<BaseResponseModel> addFrined = apiInterface.addFriend(stringMultipartParamsParams);
                addFrined.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new ResponseObserver<BaseResponseModel>(handler));
                break;

            case REQ_RESET_PASS:
                Observable<BaseResponseModel> reset = apiInterface.resetPassword(stringMultipartParamsParams);
                reset.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new ResponseObserver<BaseResponseModel>(handler));
                break;

            case REQ_ACCEPT:
                Observable<BaseResponseModel> acceptObservable = apiInterface.acceptFriend(stringMultipartParamsParams);
                acceptObservable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new ResponseObserver<BaseResponseModel>(handler));
                break;

            case REQ_REJECT:
                Observable<BaseResponseModel> rejectObservable = apiInterface.recjectFriend(stringMultipartParamsParams);
                rejectObservable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new ResponseObserver<BaseResponseModel>(handler));
                break;

            case REQ_UNFRIEND:
                Observable<BaseResponseModel> unfriedObservable = apiInterface.unFriend(stringMultipartParamsParams);
                unfriedObservable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new ResponseObserver<BaseResponseModel>(handler));
                break;
            case REQ_GET_COURSES:
                Observable<BaseResponseModel> getCoureseObservable = apiInterface.getCourses(stringMultipartParamsParams);
                getCoureseObservable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new ResponseObserver<BaseResponseModel>(handler));
                break;

        }
    }

    public void call(Context mContext, byte reqTyoe, ResponseHandler handler, Map<String, String> params, Map<String, File> files) {
        try {
            if (!CheckNetworkState.isOnline(mContext)) {
                CommonUtils.showSnakeBar(mContext, mContext.getString(R.string.no_internet));
                return;
            }

            Map<String, RequestBody> stringMultipartParamsParams = getStringMultipartParamsParams(params);
            List<MultipartBody.Part> filesMultipart = getFilesMultipart(files);
            switch (reqTyoe) {
                case REQ_TYPE_UPDATE_PROFILE:
                    Observable<LoginResponseModel> updateAboutObservable = apiInterface.updateProfile(stringMultipartParamsParams, filesMultipart.size() > 0 ? filesMultipart.get(0) : null);
                    updateAboutObservable.subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new ResponseObserver<LoginResponseModel>(handler));
                    break;


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private Map<String, RequestBody> getStringMultipartParamsParams(Map<String, String> params) {
        Map<String, RequestBody> stringParams = new HashMap<>();
        if (params != null) {
            Set<Map.Entry<String, String>> entries = params.entrySet();
            for (Map.Entry<String, String> entry : entries) {
                RequestBody requestBody =
                        RequestBody.create(
                                MediaType.parse("multipart/form-data"), entry.getValue());
                stringParams.put(entry.getKey(), requestBody);
            }
        }
        return stringParams;
    }

    private List<MultipartBody.Part> getFilesMultipart(Map<String, File> params) {
        List<MultipartBody.Part> files = new ArrayList<>();
        if (params != null) {
            Set<Map.Entry<String, File>> entries = params.entrySet();
            for (Map.Entry<String, File> entry : entries) {
                RequestBody requestFile =
                        RequestBody.create(MediaType.parse("multipart/form-data"), entry.getValue());
                // MultipartBody.Part is used to send also the actual file name
                MultipartBody.Part formData = MultipartBody.Part.createFormData(entry.getKey(), entry.getValue().getName(), requestFile);
                files.add(formData);
            }

        }
        return files;
    }

    public void callMulipleImageUpoloads(byte reqTypeUpdateInsideImages, ResponseHandler responseHandler, RequestBody fileParams) {
        switch (reqTypeUpdateInsideImages) {
            case REQ_ADD_REVIEW:
                Observable<BaseResponseModel> updateInsideImageObservable = apiInterface.addReview(fileParams);
                updateInsideImageObservable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new ResponseObserver<BaseResponseModel>(responseHandler));
                break;
            case REQ_TYPE_ADD_TREK:
                Observable<BaseResponseModel> addTrekObservable = apiInterface.addTrek(fileParams);
                addTrekObservable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new ResponseObserver<BaseResponseModel>(responseHandler));
                break;
        }
    }

    public void callGet(byte reqTyoe, ResponseHandler handler, HashMap<String, String> body) {
        switch (reqTyoe) {
            case REQ_TYPE_GET_TREK:
                Observable<TrekResponseModel> getTrek = apiInterface.getTrek(body);
                getTrek.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new ResponseObserver<TrekResponseModel>(handler));
                break;
            case REQ_TYPE_GET_REVIEW:
                Observable<ReviewResponseModel> getReview = apiInterface.getReviews(body);
                getReview.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new ResponseObserver<ReviewResponseModel>(handler));
                break;

            case REQ_TYPE_GET_PROFILE:
                Observable<UserProfileResponseModel> getProfile = apiInterface.getFriendProfile(body);
                getProfile.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new ResponseObserver<UserProfileResponseModel>(handler));
                break;
            case GET_CHAT:
                Observable<MessageResponseModel> getChat = apiInterface.getMessage(body);
                getChat.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new ResponseObserver<MessageResponseModel>(handler));
                break;

            case GET_INBOX:
                Observable<MessageResponseModel> getInboxObservable = apiInterface.getInbox(body);
                getInboxObservable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new ResponseObserver<MessageResponseModel>(handler));
                break;
        }
    }

}
