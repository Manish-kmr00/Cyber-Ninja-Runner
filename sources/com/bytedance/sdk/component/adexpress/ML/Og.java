package com.bytedance.sdk.component.adexpress.ML;

/* JADX INFO: loaded from: classes11.dex */
public interface Og {
    String adInfo();

    String appInfo();

    void changeVideoState(String str);

    void chooseAdResult(String str);

    void clickEvent(String str);

    void dynamicTrack(String str);

    String getCurrentVideoState();

    String getData(String str);

    String getTemplateInfo();

    void initRenderFinish();

    void muteVideo(String str);

    void pA(String str);

    void renderDidFinish(String str);

    void skipVideo();
}
