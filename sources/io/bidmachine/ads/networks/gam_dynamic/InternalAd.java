package io.bidmachine.ads.networks.gam_dynamic;

import android.content.Context;
import io.bidmachine.AdsFormat;
import io.bidmachine.ExpirationHandler;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import io.bidmachine.protobuf.Waterfall;
import io.bidmachine.utils.BMError;
import io.bidmachine.utils.ProtoUtils;
import io.bidmachine.utils.Tag;
import io.bidmachine.utils.lazy.LazyValue;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes7.dex */
public abstract class InternalAd implements InternalAdData, ExpirationHandler.Listener {
    private final Waterfall.Configuration.AdUnit adUnit;
    private final AdsFormat adsFormat;
    private final ExpirationHandler expirationHandler;
    private final InternalAdListener internalAdListener;
    private InternalAdLoadData internalAdLoadData;
    private final Tag tag;
    private final TaskExecutor taskExecutor;
    private WeakReference<InternalAdPresentListener> weakAdPresentListener;
    private volatile Status status = Status.Idle;
    private final Map<String, Object> customParamsMap = new ConcurrentHashMap();

    enum Status {
        Idle,
        Loading,
        Loaded,
        Showing,
        Shown,
        Expired
    }

    protected abstract void destroyAd() throws Throwable;

    protected abstract void loadAd(Context context, InternalLoadListener internalLoadListener) throws Throwable;

    InternalAd(NetworkParams networkParams, TaskExecutor taskExecutor, AdsFormat adsFormat, Waterfall.Configuration.AdUnit adUnit, InternalAdListener internalAdListener) {
        this.tag = new Tag(networkParams.getNetworkName() + "Ad");
        this.taskExecutor = taskExecutor;
        this.adsFormat = adsFormat;
        this.adUnit = adUnit;
        this.internalAdListener = internalAdListener;
        this.expirationHandler = new ExpirationHandler(adUnit.getExpirationTime(), this);
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.InternalAdData
    public String getAdUnitId() {
        return getAdUnit().getAdUnitId();
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.InternalAdData
    public double getPrice() {
        return getAdUnit().getPrice();
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.InternalAdData
    public Map<String, Object> getCustomParamsMap() {
        return this.customParamsMap;
    }

    public AdsFormat getAdsFormat() {
        return this.adsFormat;
    }

    public Waterfall.Configuration.AdUnit getAdUnit() {
        return this.adUnit;
    }

    public InternalAdPresentListener getAdPresentListener() {
        WeakReference<InternalAdPresentListener> weakReference = this.weakAdPresentListener;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public void setAdPresentListener(InternalAdPresentListener internalAdPresentListener) {
        this.weakAdPresentListener = new WeakReference<>(internalAdPresentListener);
    }

    public InternalAdLoadData getInternalAdLoadData() {
        return this.internalAdLoadData;
    }

    public void setCustomParam(String str, Object obj) {
        this.customParamsMap.put(str, obj);
    }

    @Override // io.bidmachine.ExpirationHandler.Listener
    public void onExpired() {
        if (isShown()) {
            return;
        }
        Logger.d(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.gam_dynamic.InternalAd$$ExternalSyntheticLambda5
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return this.f$0.m7390xb93813ba();
            }
        });
        this.internalAdListener.onAdExpired(this);
        setStatus(Status.Expired);
        InternalAdPresentListener adPresentListener = getAdPresentListener();
        if (adPresentListener != null) {
            adPresentListener.onAdExpired();
        }
        destroy(true);
    }

    /* JADX INFO: renamed from: lambda$onExpired$0$io-bidmachine-ads-networks-gam_dynamic-InternalAd, reason: not valid java name */
    /* synthetic */ String m7390xb93813ba() {
        return String.format("onExpired (%s)", GAMUtils.toString(this.adUnit));
    }

    public void onAdLoaded(InternalAdLoadData internalAdLoadData) {
        this.internalAdLoadData = internalAdLoadData;
        final Waterfall.Result.EstimatedPrice price = internalAdLoadData != null ? internalAdLoadData.getPrice() : null;
        Logger.d(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.gam_dynamic.InternalAd$$ExternalSyntheticLambda2
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return this.f$0.m7388xe72d1456(price);
            }
        });
        String strEncodeToString = ProtoUtils.encodeToString(price);
        if (strEncodeToString != null) {
            setCustomParam("gam_estimated_price", strEncodeToString);
        }
        setStatus(Status.Loaded);
        this.expirationHandler.start();
    }

    /* JADX INFO: renamed from: lambda$onAdLoaded$1$io-bidmachine-ads-networks-gam_dynamic-InternalAd, reason: not valid java name */
    /* synthetic */ String m7388xe72d1456(Waterfall.Result.EstimatedPrice estimatedPrice) {
        return String.format("onAdLoaded (%s, %s)", GAMUtils.toString(this.adUnit), GAMUtils.toString(estimatedPrice));
    }

    /* JADX INFO: renamed from: lambda$onAdShown$2$io-bidmachine-ads-networks-gam_dynamic-InternalAd, reason: not valid java name */
    /* synthetic */ String m7389x9632cc45() {
        return String.format("onAdShown (%s)", GAMUtils.toString(this.adUnit));
    }

    public void onAdShown() {
        Logger.d(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.gam_dynamic.InternalAd$$ExternalSyntheticLambda7
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return this.f$0.m7389x9632cc45();
            }
        });
        this.internalAdListener.onAdShown(this);
        setStatus(Status.Shown);
        this.expirationHandler.stop();
    }

    public void onPaidEvent(final Waterfall.Result.EstimatedPrice estimatedPrice) {
        Logger.d(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.gam_dynamic.InternalAd$$ExternalSyntheticLambda1
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return this.f$0.m7391xceac7186(estimatedPrice);
            }
        });
        String strEncodeToString = ProtoUtils.encodeToString(estimatedPrice);
        if (strEncodeToString != null) {
            setCustomParam("gam_estimated_price", strEncodeToString);
        }
        this.internalAdListener.onPaidEvent(this);
    }

    /* JADX INFO: renamed from: lambda$onPaidEvent$3$io-bidmachine-ads-networks-gam_dynamic-InternalAd, reason: not valid java name */
    /* synthetic */ String m7391xceac7186(Waterfall.Result.EstimatedPrice estimatedPrice) {
        return String.format("onPaidEvent (%s, %s)", GAMUtils.toString(this.adUnit), GAMUtils.toString(estimatedPrice));
    }

    public void destroy() {
        destroy(isShown());
    }

    void destroy(boolean z) {
        try {
            Logger.d(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.gam_dynamic.InternalAd$$ExternalSyntheticLambda6
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    return this.f$0.m7385xfb2c6d32();
                }
            });
            WeakReference<InternalAdPresentListener> weakReference = this.weakAdPresentListener;
            if (weakReference != null) {
                weakReference.clear();
            }
            this.weakAdPresentListener = null;
            if (z) {
                release();
            }
            this.internalAdListener.onAdDestroyed(this, z);
        } catch (Throwable th) {
            Logger.w(th);
        }
    }

    /* JADX INFO: renamed from: lambda$destroy$4$io-bidmachine-ads-networks-gam_dynamic-InternalAd, reason: not valid java name */
    /* synthetic */ String m7385xfb2c6d32() {
        return String.format("destroy (%s)", GAMUtils.toString(this.adUnit));
    }

    protected void onBackground(Runnable runnable) {
        this.taskExecutor.execute(runnable);
    }

    /* JADX INFO: renamed from: lambda$load$5$io-bidmachine-ads-networks-gam_dynamic-InternalAd, reason: not valid java name */
    /* synthetic */ String m7386lambda$load$5$iobidmachineadsnetworksgam_dynamicInternalAd() {
        return String.format("load (%s)", GAMUtils.toString(this.adUnit));
    }

    final void load(Context context, final InternalLoadListener internalLoadListener) {
        Logger.d(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.gam_dynamic.InternalAd$$ExternalSyntheticLambda3
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return this.f$0.m7386lambda$load$5$iobidmachineadsnetworksgam_dynamicInternalAd();
            }
        });
        final Context applicationContext = context.getApplicationContext();
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.ads.networks.gam_dynamic.InternalAd$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m7387lambda$load$6$iobidmachineadsnetworksgam_dynamicInternalAd(applicationContext, internalLoadListener);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$load$6$io-bidmachine-ads-networks-gam_dynamic-InternalAd, reason: not valid java name */
    /* synthetic */ void m7387lambda$load$6$iobidmachineadsnetworksgam_dynamicInternalAd(Context context, InternalLoadListener internalLoadListener) {
        try {
            setStatus(Status.Loading);
            loadAd(context, internalLoadListener);
        } catch (Throwable th) {
            Logger.w(th);
            internalLoadListener.onAdLoadFailed(this, BMError.throwable("Exception loading InternalAd object", th));
        }
    }

    void release() {
        this.expirationHandler.stop();
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.ads.networks.gam_dynamic.InternalAd$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m7392x37c25202();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$release$7$io-bidmachine-ads-networks-gam_dynamic-InternalAd, reason: not valid java name */
    /* synthetic */ void m7392x37c25202() {
        try {
            destroyAd();
        } catch (Throwable th) {
            Logger.w(th);
        }
    }

    void setStatus(Status status) {
        this.status = status;
    }

    boolean isLoaded() {
        return this.status == Status.Loaded;
    }

    boolean isShown() {
        Status status = this.status;
        return status != null && status.ordinal() >= Status.Shown.ordinal();
    }

    boolean isExpired() {
        return this.status == Status.Expired;
    }

    public String toString() {
        return this.tag + ", " + GAMUtils.toString(this.adUnit);
    }
}
