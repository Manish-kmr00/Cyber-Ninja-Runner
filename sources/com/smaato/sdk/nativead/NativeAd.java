package com.smaato.sdk.nativead;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.smaato.sdk.core.SmaatoSdk;
import com.smaato.sdk.core.lifecycle.Lifecycle;
import com.smaato.sdk.core.lifecycle.Lifecycling;
import com.smaato.sdk.core.util.LogUtil;
import com.smaato.sdk.nativead.view.NativeAdDelegate;

/* JADX INFO: loaded from: classes4.dex */
public class NativeAd {
    private final NativeAdRequest nativeAdRequest;

    public interface Listener {
        void onAdClicked(NativeAd nativeAd);

        void onAdFailedToLoad(NativeAd nativeAd, NativeAdError nativeAdError);

        void onAdImpressed(NativeAd nativeAd);

        void onAdLoaded(NativeAd nativeAd, NativeAdRenderer nativeAdRenderer);

        void onTtlExpired(NativeAd nativeAd);
    }

    public NativeAd(NativeAdRequest nativeAdRequest) {
        this.nativeAdRequest = nativeAdRequest;
    }

    public NativeAdRequest request() {
        return this.nativeAdRequest;
    }

    public static void loadAd(LifecycleOwner lifecycleOwner, NativeAdRequest nativeAdRequest, Listener listener) {
        loadAd(Lifecycling.wrap(lifecycleOwner), nativeAdRequest, listener);
    }

    public static void loadAd(View view, NativeAdRequest nativeAdRequest, Listener listener) {
        loadAd(Lifecycling.of(view), nativeAdRequest, listener);
    }

    public static void loadAd(Lifecycle lifecycle, NativeAdRequest nativeAdRequest, Listener listener) {
        if (!SmaatoSdk.isSmaatoSdkInitialised()) {
            LogUtil.logSmaatoInitMissing();
            if (listener != null) {
                listener.onAdFailedToLoad(new NativeAd(nativeAdRequest), NativeAdError.SDK_INITIALISATION_ERROR);
                return;
            }
            return;
        }
        new NativeAdDelegate().loadAd(lifecycle, nativeAdRequest, listener);
    }
}
