package io.bidmachine.nativead.view;

import android.view.ViewGroup;

/* JADX INFO: loaded from: classes12.dex */
public class NativeAdContainerBridge {
    public static void configureContainer(NativeAdContainer nativeAdContainer, ViewGroup viewGroup) {
        nativeAdContainer.configureContainer(viewGroup);
    }

    public static void deConfigureContainer(NativeAdContainer nativeAdContainer) {
        nativeAdContainer.deConfigureContainer();
    }
}
