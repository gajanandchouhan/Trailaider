package com.trailaider.app.ui.fragment.trek;

import com.trailaider.app.base.BaseView;
import com.trailaider.app.data.model.trek.TrekResponseData;

import java.util.List;

/**
 * Created by gajanand on 12/1/18.
 */

interface TrekView extends BaseView {
    void setTrekList(List<TrekResponseData> data);

}
