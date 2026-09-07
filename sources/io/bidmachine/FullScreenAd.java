package io.bidmachine;

import android.content.Context;
import io.bidmachine.AdListener;
import io.bidmachine.FullScreenAd;
import io.bidmachine.FullScreenAdObject;
import io.bidmachine.FullScreenAdRequest;
import io.bidmachine.core.Logger;
import io.bidmachine.models.AdObjectParams;
import io.bidmachine.unified.UnifiedFullscreenAdRequestParams;
import io.bidmachine.utils.BMError;

/* JADX INFO: loaded from: classes12.dex */
public abstract class FullScreenAd<SelfType extends FullScreenAd<SelfType, AdRequestType, AdObjectType, ListenerType>, AdRequestType extends FullScreenAdRequest<AdRequestType>, AdObjectType extends FullScreenAdObject<AdRequestType>, ListenerType extends AdListener<SelfType>> extends BidMachineAd<SelfType, AdRequestType, AdObjectType, AdObjectParams, UnifiedFullscreenAdRequestParams, ListenerType> {
    protected FullScreenAd(Context context, AdsType adsType) {
        super(context, adsType);
    }

    public void show() {
        AdObjectType adobjecttypePrepareShow = prepareShow(true);
        if (adobjecttypePrepareShow == null) {
            return;
        }
        try {
            resetTracked();
            adobjecttypePrepareShow.show(getContextProvider());
        } catch (Throwable th) {
            Logger.w(th);
            processShowFail(BMError.throwable("Exception showing fullscreen object", th));
        }
    }

    private void resetTracked() {
        this.isFinishTracked.set(false);
        this.isCloseTracked.set(false);
    }
}
