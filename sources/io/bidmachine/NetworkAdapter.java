package io.bidmachine;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import io.bidmachine.core.Logger;
import io.bidmachine.unified.UnifiedBannerAd;
import io.bidmachine.unified.UnifiedFullscreenAd;
import io.bidmachine.unified.UnifiedNativeAd;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes10.dex */
public abstract class NetworkAdapter {
    private final int adapterMinDeviceApiVersion;
    private final String adapterVersion;
    private final String compiledNetworkSdkVersion;
    private final String key;
    private String networkSdkVersion;
    private final AdsType[] supportedTypes;
    private final AtomicBoolean isInitializing = new AtomicBoolean(false);
    private final AtomicBoolean isInitialized = new AtomicBoolean(false);
    private final Set<InternalNetworkInitializationCallback> initializeCallbackSet = new CopyOnWriteArraySet();

    public void clearAuction(NetworkAdUnit networkAdUnit) throws Throwable {
    }

    public String getNetworkSdkVersion() throws Throwable {
        return null;
    }

    protected abstract boolean isNetworkInitializationStatusCheckSupported();

    protected abstract boolean isNetworkInitialized(ContextProvider contextProvider) throws Throwable;

    public void onLossAuction(NetworkAdUnit networkAdUnit) throws Throwable {
    }

    protected abstract void onNetworkInitialize(ContextProvider contextProvider, InitializationParams initializationParams, NetworkConfigParams networkConfigParams, NetworkInitializationCallback networkInitializationCallback) throws Throwable;

    public void onWinAuction(NetworkAdUnit networkAdUnit) throws Throwable {
    }

    public void setLogging(boolean z) throws Throwable {
    }

    protected NetworkAdapter(String str, String str2, String str3, int i, AdsType[] adsTypeArr) {
        this.key = str;
        this.compiledNetworkSdkVersion = str2;
        this.adapterVersion = str3;
        this.adapterMinDeviceApiVersion = i;
        this.supportedTypes = adsTypeArr;
    }

    public String getKey() {
        return this.key;
    }

    public String getAdapterVersion() {
        return this.adapterVersion;
    }

    public int getAdapterMinDeviceApiVersion() {
        return this.adapterMinDeviceApiVersion;
    }

    public AdsType[] getSupportedTypes() {
        return this.supportedTypes;
    }

    public final String obtainNetworkSdkVersion() {
        if (!TextUtils.isEmpty(this.networkSdkVersion)) {
            return this.networkSdkVersion;
        }
        try {
            String networkSdkVersion = getNetworkSdkVersion();
            this.networkSdkVersion = networkSdkVersion;
            if (!TextUtils.isEmpty(networkSdkVersion)) {
                return this.networkSdkVersion;
            }
        } catch (Throwable unused) {
        }
        return this.compiledNetworkSdkVersion;
    }

    public final void initialize(ContextProvider contextProvider, InitializationParams initializationParams, NetworkConfigParams networkConfigParams, InternalNetworkInitializationCallback internalNetworkInitializationCallback) throws Throwable {
        if (Build.VERSION.SDK_INT < this.adapterMinDeviceApiVersion) {
            internalNetworkInitializationCallback.onFail(this, "minSdkVersion is " + this.adapterMinDeviceApiVersion);
            return;
        }
        if (isInitialized(contextProvider)) {
            internalNetworkInitializationCallback.onSuccess(this);
            return;
        }
        if (isSkipInitialization(networkConfigParams)) {
            if (!isNetworkInitializationStatusCheckSupported()) {
                Logger.d(getKey(), "Network initialization status check is not supported, force initialization to true");
                this.isInitialized.set(true);
            }
            Logger.d(getKey(), "Network initialization is skipped");
            internalNetworkInitializationCallback.onSuccess(this);
            return;
        }
        this.initializeCallbackSet.add(internalNetworkInitializationCallback);
        if (this.isInitializing.compareAndSet(false, true)) {
            onNetworkInitialize(contextProvider, initializationParams, networkConfigParams, new NetworkInitializationCallback() { // from class: io.bidmachine.NetworkAdapter.1
                @Override // io.bidmachine.NetworkInitializationCallback
                public void onSuccess() {
                    NetworkAdapter.this.isInitialized.set(true);
                    NetworkAdapter.this.isInitializing.set(false);
                    Iterator it = NetworkAdapter.this.initializeCallbackSet.iterator();
                    while (it.hasNext()) {
                        ((InternalNetworkInitializationCallback) it.next()).onSuccess(NetworkAdapter.this);
                    }
                    NetworkAdapter.this.initializeCallbackSet.clear();
                }

                @Override // io.bidmachine.NetworkInitializationCallback
                public void onFail(String str) {
                    NetworkAdapter.this.isInitialized.set(false);
                    NetworkAdapter.this.isInitializing.set(false);
                    Iterator it = NetworkAdapter.this.initializeCallbackSet.iterator();
                    while (it.hasNext()) {
                        ((InternalNetworkInitializationCallback) it.next()).onFail(NetworkAdapter.this, str);
                    }
                    NetworkAdapter.this.initializeCallbackSet.clear();
                }
            });
        }
    }

    public final boolean isInitialized(Context context) {
        return isInitialized(new SimpleContextProvider(context));
    }

    public final boolean isInitialized(ContextProvider contextProvider) {
        if (this.isInitialized.get()) {
            return true;
        }
        try {
            boolean zIsNetworkInitialized = isNetworkInitialized(contextProvider);
            this.isInitialized.compareAndSet(false, zIsNetworkInitialized);
            return zIsNetworkInitialized;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final boolean isInitializing() {
        return this.isInitializing.get();
    }

    public static boolean isSkipInitialization(NetworkConfigParams networkConfigParams) {
        return Boolean.parseBoolean(networkConfigParams.getFromNetworkParams("skip_initialization"));
    }

    public UnifiedBannerAd createBanner() {
        throw new IllegalArgumentException(getKey() + " adapter does not support banner");
    }

    public UnifiedFullscreenAd createInterstitial() {
        throw new IllegalArgumentException(getKey() + " adapter does not support static interstitial");
    }

    public UnifiedFullscreenAd createRewarded() {
        throw new IllegalArgumentException(getKey() + " adapter does not support rewarded interstitial");
    }

    public UnifiedNativeAd createNativeAd() {
        throw new IllegalArgumentException(getKey() + " adapter does not support native ads");
    }

    public boolean isAdsTypeSupported(AdsType adsType) {
        for (AdsType adsType2 : this.supportedTypes) {
            if (adsType2 == adsType) {
                return true;
            }
        }
        return false;
    }
}
