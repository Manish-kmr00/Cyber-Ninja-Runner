package com.smaato.sdk.video.vast.widget.element;

/* JADX INFO: loaded from: classes7.dex */
public class NoOpVastElementPresenter implements VastElementPresenter {
    @Override // com.smaato.sdk.video.vast.widget.element.VastElementPresenter
    public void attachView(VastElementView vastElementView) {
    }

    @Override // com.smaato.sdk.video.vast.widget.element.VastElementPresenter
    public void detachView() {
    }

    @Override // com.smaato.sdk.video.vast.widget.element.VastElementPresenter
    public boolean isValidUrl(String str) {
        return false;
    }

    @Override // com.smaato.sdk.video.vast.widget.element.VastElementPresenter
    public void logError(VastElementException vastElementException) {
    }

    @Override // com.smaato.sdk.video.vast.widget.element.VastElementPresenter
    public void onClicked(String str) {
    }

    @Override // com.smaato.sdk.video.vast.widget.element.VastElementPresenter
    public void onConfigurationChanged() {
    }

    @Override // com.smaato.sdk.video.vast.widget.element.VastElementPresenter
    public void onContentLoaded() {
    }

    @Override // com.smaato.sdk.video.vast.widget.element.VastElementPresenter
    public void onContentStartedToLoad() {
    }

    @Override // com.smaato.sdk.video.vast.widget.element.VastElementPresenter
    public void onError(VastElementException vastElementException) {
    }

    @Override // com.smaato.sdk.video.vast.widget.element.VastElementPresenter
    public void onRenderProcessGone() {
    }

    @Override // com.smaato.sdk.video.vast.widget.element.VastElementPresenter
    public void setListener(VastElementPresenter.Listener listener) {
    }
}
