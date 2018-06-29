package com.trailaider.app.ui.activity.userprofile;

import com.trailaider.app.base.BaseView;
import com.trailaider.app.data.model.userprofile.UserProfileData;

/**
 * Created by gajanand on 28/1/18.
 */

public interface UserProfileView extends BaseView {
    void setUserData(UserProfileData data);

    void onFriendAdded();
}
