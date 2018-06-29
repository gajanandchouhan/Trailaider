package com.trailaider.app.ui.activity.siginin;

import com.trailaider.app.base.BaseView;
import com.trailaider.app.data.model.login.LoginResponseData;

/**
 * Created by gajanand on 7/1/18.
 */

interface SignInView extends BaseView{
    void moveToHome(LoginResponseData data);
}
