package com.trailaider.app.ui.activity.signup;

import com.trailaider.app.base.BaseView;
import com.trailaider.app.data.model.login.LoginResponseData;

/**
 * Created by gajanand on 7/1/18.
 */

interface SignUpView extends BaseView{
    void moveToOtp(LoginResponseData data);
}
