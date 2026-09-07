package com.smaato.sdk.richmedia.mraid.mvp;

/* JADX INFO: loaded from: classes11.dex */
public interface Presenter<T> {
    void attachView(T t);

    void destroy();

    void detachView();
}
