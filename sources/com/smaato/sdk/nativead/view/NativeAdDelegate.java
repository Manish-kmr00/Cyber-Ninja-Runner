package com.smaato.sdk.nativead.view;

import com.smaato.sdk.core.lifecycle.Lifecycle;
import com.smaato.sdk.core.mvvm.view.SmaatoSdkViewDelegate;
import com.smaato.sdk.core.ui.AdContentView;
import com.smaato.sdk.core.util.diinjection.Inject;
import com.smaato.sdk.nativead.NativeAd;
import com.smaato.sdk.nativead.NativeAdRequest;
import com.smaato.sdk.nativead.viewmodel.NativeAdViewModel;

/* JADX INFO: loaded from: classes13.dex */
public class NativeAdDelegate extends SmaatoSdkViewDelegate {

    @Inject
    NativeAdViewModel nativeAdViewModel;

    @Override // com.smaato.sdk.core.mvvm.view.SmaatoSdkViewDelegate
    protected void onPredrawOfAdContentView(AdContentView adContentView) {
    }

    public void loadAd(Lifecycle lifecycle, NativeAdRequest nativeAdRequest, NativeAd.Listener listener) {
        this.nativeAdViewModel.loadAd(lifecycle, nativeAdRequest, listener);
    }
}
