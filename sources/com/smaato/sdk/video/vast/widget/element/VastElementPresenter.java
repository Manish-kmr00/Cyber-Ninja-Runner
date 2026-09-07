package com.smaato.sdk.video.vast.widget.element;

/* JADX INFO: loaded from: classes2.dex */
public interface VastElementPresenter {

    public interface Listener {
        void onRenderProcessGone();

        void onVastElementClicked(String str);

        void onVastElementError(int i);

        void onVastElementRendered();
    }

    void attachView(VastElementView vastElementView);

    void detachView();

    boolean isValidUrl(String str);

    void logError(VastElementException vastElementException);

    void onClicked(String str);

    void onConfigurationChanged();

    void onContentLoaded();

    void onContentStartedToLoad();

    void onError(VastElementException vastElementException);

    void onRenderProcessGone();

    void setListener(Listener listener);
}
