package com.trailaider.app.data.network;

/**
 * Created by JAIN COMPUTERS on 11/18/2017.
 */

public interface ResponseHandler<T> {

    void onResponse(T t);
    void onError();
}
