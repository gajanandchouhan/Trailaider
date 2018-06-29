package com.trailaider.app.ui.fragment.friends;

import com.trailaider.app.base.BaseView;

/**
 * Created by gajanand on 26/2/18.
 */

public interface FriendView extends BaseView {
    void onUnfriended();

    void onAccepted();

    void onReject();
}
