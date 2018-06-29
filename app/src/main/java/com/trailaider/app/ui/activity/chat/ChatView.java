package com.trailaider.app.ui.activity.chat;

import com.trailaider.app.base.BaseView;
import com.trailaider.app.data.model.chat.MessageResponseData;

import java.util.List;

/**
 * Created by gajanand on 11/2/18.
 */

public interface ChatView extends BaseView {

    void setMessageList(List<MessageResponseData> list);

    void onMessageSent(MessageResponseData data);
}
