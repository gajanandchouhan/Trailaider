package com.trailaider.app.ui.activity.profile;

import com.trailaider.app.base.BaseView;
import com.trailaider.app.data.model.login.LoginResponseData;

/**
 * Created by gajanand on 9/1/18.
 */

public interface ProfileView extends BaseView{

    void setProfileData(LoginResponseData data);
}
