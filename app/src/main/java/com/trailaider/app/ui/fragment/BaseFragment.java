package com.trailaider.app.ui.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.trailaider.app.base.BaseView;

/**
 * Created by gajanand on 4/1/18.
 */

public abstract class BaseFragment extends Fragment implements View.OnClickListener,BaseView{

    private ProgressDialog dialog;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeView(view);
        initializePresenter();
    }

    protected abstract void initializeView(View view);

    protected abstract void initializePresenter();

    @Override
    public void onClick(View view) {

    }

    @Override
    public void showProgress() {
        dialog = ProgressDialog.show(getActivity(), "", "", true, false);
    }

    @Override
    public void hideProgress() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}
