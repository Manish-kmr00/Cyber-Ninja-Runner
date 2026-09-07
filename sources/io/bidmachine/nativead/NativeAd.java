package io.bidmachine.nativead;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import io.bidmachine.AdProcessCallback;
import io.bidmachine.AdsType;
import io.bidmachine.BidMachineAd;
import io.bidmachine.ContextProvider;
import io.bidmachine.ImageData;
import io.bidmachine.NetworkAdapter;
import io.bidmachine.models.AdObjectParams;
import io.bidmachine.nativead.view.NativeMediaView;
import io.bidmachine.unified.UnifiedNativeAd;
import io.bidmachine.unified.UnifiedNativeAdRequestParams;
import java.util.Set;

/* JADX INFO: loaded from: classes12.dex */
public final class NativeAd extends BidMachineAd<NativeAd, NativeRequest, NativeAdObject, AdObjectParams, UnifiedNativeAdRequestParams, NativeListener> implements NativePublicData, NativeContainer {
    public NativeAd(Context context) {
        super(context, AdsType.Native);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.bidmachine.BidMachineAd
    public NativeAdObject createAdObject(ContextProvider contextProvider, NativeRequest nativeRequest, NetworkAdapter networkAdapter, AdObjectParams adObjectParams, AdProcessCallback adProcessCallback) {
        UnifiedNativeAd unifiedNativeAdCreateNativeAd = networkAdapter.createNativeAd();
        if (unifiedNativeAdCreateNativeAd == null) {
            return null;
        }
        return new NativeAdObject(contextProvider, adProcessCallback, nativeRequest, adObjectParams, unifiedNativeAdCreateNativeAd);
    }

    @Override // io.bidmachine.nativead.NativePublicData
    public String getTitle() {
        if (hasLoadedObject()) {
            return getLoadedAdObject().getTitle();
        }
        return null;
    }

    @Override // io.bidmachine.nativead.NativePublicData
    public String getDescription() {
        if (hasLoadedObject()) {
            return getLoadedAdObject().getDescription();
        }
        return null;
    }

    @Override // io.bidmachine.nativead.NativePublicData
    public String getCallToAction() {
        if (hasLoadedObject()) {
            return getLoadedAdObject().getCallToAction();
        }
        return null;
    }

    @Override // io.bidmachine.nativead.NativePublicData
    public float getRating() {
        if (hasLoadedObject()) {
            return getLoadedAdObject().getRating();
        }
        return -1.0f;
    }

    @Override // io.bidmachine.nativead.NativePublicData
    public ImageData getIcon() {
        if (hasLoadedObject()) {
            return getLoadedAdObject().getIcon();
        }
        return null;
    }

    @Override // io.bidmachine.nativead.NativePublicData
    public ImageData getMainImage() {
        if (hasLoadedObject()) {
            return getLoadedAdObject().getMainImage();
        }
        return null;
    }

    @Override // io.bidmachine.nativead.NativePublicData
    public boolean hasVideo() {
        return hasLoadedObject() && getLoadedAdObject().hasVideo();
    }

    @Override // io.bidmachine.nativead.NativeContainer
    public View getProviderView(Context context) {
        if (hasLoadedObject()) {
            return getLoadedAdObject().getProviderView(context);
        }
        return null;
    }

    @Override // io.bidmachine.nativead.NativeContainer
    public void registerView(ViewGroup viewGroup, View view, NativeMediaView nativeMediaView, Set<View> set) {
        NativeAdObject nativeAdObjectPrepareShow = prepareShow(false);
        if (nativeAdObjectPrepareShow == null) {
            return;
        }
        nativeAdObjectPrepareShow.registerView(viewGroup, view, nativeMediaView, set);
    }

    @Override // io.bidmachine.nativead.NativeContainer
    public void unregisterView() {
        if (hasLoadedObject()) {
            getLoadedAdObject().unregisterView();
        }
    }

    @Override // io.bidmachine.nativead.NativeContainer
    public boolean isViewRegistered() {
        return hasLoadedObject() && getLoadedAdObject().isViewRegistered();
    }

    public NativePublicData getAdData() {
        return getLoadedAdObject();
    }

    private boolean hasLoadedObject() {
        if (getLoadedAdObject() != null) {
            return true;
        }
        log("not loaded, please load ads first");
        return false;
    }
}
