package com.trailaider.app.ui.activity.inbox;

import com.trailaider.app.base.BaseView;
import com.trailaider.app.data.model.chat.MessageResponseData;

import java.util.List;

/**
 * Created by gajanand on 10/2/18.
 */

interface InboxView extends BaseView{

    void setInboxList(List<MessageResponseData> list);
}
