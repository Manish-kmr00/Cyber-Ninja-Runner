package com.pubmatic.sdk.common;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\fJ \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'J\b\u0010\n\u001a\u00020\u000bH&¨\u0006\r"}, d2 = {"Lcom/pubmatic/sdk/common/OpenWrapSDKInitializer;", "", MobileAdsBridgeBase.initializeMethodName, "", "context", "Landroid/content/Context;", "sdkConfig", "Lcom/pubmatic/sdk/common/OpenWrapSDKConfig;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/pubmatic/sdk/common/OpenWrapSDKInitializer$Listener;", "isInitialized", "", "Listener", "common_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface OpenWrapSDKInitializer {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/pubmatic/sdk/common/OpenWrapSDKInitializer$Listener;", "", "onFailure", "", "error", "Lcom/pubmatic/sdk/common/POBError;", "onSuccess", "common_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface Listener {
        void onFailure(POBError error);

        void onSuccess();
    }

    void initialize(Context context, OpenWrapSDKConfig sdkConfig, Listener listener);

    boolean isInitialized();
}
