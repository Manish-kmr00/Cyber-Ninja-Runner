package com.mbridge.msdk.out;

/* JADX INFO: loaded from: classes6.dex */
public interface BaseTrackingListener {
    void onFinishRedirection(Campaign campaign, String str);

    void onRedirectionFailed(Campaign campaign, String str);

    void onStartRedirection(Campaign campaign, String str);
}
