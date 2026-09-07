package com.pubmatic.sdk.nativead;

import android.content.Context;
import android.os.Trace;
import com.pubmatic.sdk.common.OpenWrapSDK;
import com.pubmatic.sdk.common.OpenWrapSDKConfig;
import com.pubmatic.sdk.common.OpenWrapSDKInitializer;
import com.pubmatic.sdk.common.POBAdFormat;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.pubmatic.sdk.common.POBDataType;
import com.pubmatic.sdk.common.POBError;
import com.pubmatic.sdk.common.POBInstanceProvider;
import com.pubmatic.sdk.common.cache.POBCacheManager;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.log.POBLogConstants;
import com.pubmatic.sdk.common.models.POBProfileInfo;
import com.pubmatic.sdk.common.taskhandler.POBTaskHandler;
import com.pubmatic.sdk.common.utility.POBTimeoutHandler;
import com.pubmatic.sdk.common.utility.POBUtils;
import com.pubmatic.sdk.nativead.datatype.POBNativeTemplateType;
import com.pubmatic.sdk.nativead.request.POBBaseNativeRequestAsset;
import com.pubmatic.sdk.nativead.request.POBNativeRequestDataAsset;
import com.pubmatic.sdk.nativead.request.POBNativeRequestEventTracker;
import com.pubmatic.sdk.nativead.request.POBNativeRequestImageAsset;
import com.pubmatic.sdk.nativead.request.POBNativeRequestTitleAsset;
import com.pubmatic.sdk.openwrap.core.POBAdsHelper;
import com.pubmatic.sdk.openwrap.core.POBBaseAd;
import com.pubmatic.sdk.openwrap.core.POBBidEventListener;
import com.pubmatic.sdk.openwrap.core.POBImpression;
import com.pubmatic.sdk.openwrap.core.POBRequest;
import com.pubmatic.sdk.openwrap.core.nativead.POBNativeDataAssetType;
import com.pubmatic.sdk.openwrap.core.nativead.POBNativeEventTrackingMethod;
import com.pubmatic.sdk.openwrap.core.nativead.POBNativeEventType;
import com.pubmatic.sdk.openwrap.core.nativead.POBNativeImageAssetType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: loaded from: classes9.dex */
public class POBNativeAdLoader implements POBBaseAd, POBNativeAdManager.POBNativeAdManagerListener, POBNativeAdManager.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f7680a;
    private final POBNativeTemplateType b;
    private POBNativeAdEvent c;
    private POBNativeAdLoaderListener d;
    private POBRequest e;
    private POBCacheManager f;
    private POBTimeoutHandler g;
    private final Set h;
    private int i;
    private boolean j;
    private boolean k;
    private final POBNativeAdLoaderConfig l;
    private POBNativeBuilder m;
    private POBBidEventListener n;
    private POBDataType.POBAdState o;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ POBError f7681a;

        a(POBError pOBError) {
            this.f7681a = pOBError;
        }

        @Override // java.lang.Runnable
        public void run() {
            POBNativeAdLoader.this.a(this.f7681a);
        }
    }

    class b implements POBTimeoutHandler.POBTimeoutHandlerListener {
        b() {
        }

        @Override // com.pubmatic.sdk.common.utility.POBTimeoutHandler.POBTimeoutHandlerListener
        public void onTimeout() {
            POBNativeAdLoader.this.d();
        }
    }

    class c implements OpenWrapSDKInitializer.Listener {
        c() {
        }

        @Override // com.pubmatic.sdk.common.OpenWrapSDKInitializer.Listener
        public void onFailure(POBError pOBError) {
            POBNativeAdLoader.this.j = true;
            POBLog.error("POBNativeAdLoader", POBLogConstants.SDK_INITIALIZATION_FAILED + pOBError, new Object[0]);
            if (POBNativeAdLoader.this.o == POBDataType.POBAdState.LOAD_DEFERRED) {
                POBNativeAdLoader.this.a(pOBError);
            }
        }

        @Override // com.pubmatic.sdk.common.OpenWrapSDKInitializer.Listener
        public void onSuccess() {
            POBNativeAdLoader.this.j = true;
            POBLog.verbose("POBNativeAdLoader", POBLogConstants.SDK_INITIALIZATION_SUCCESS, new Object[0]);
            if (POBNativeAdLoader.this.o == POBDataType.POBAdState.LOAD_DEFERRED) {
                POBNativeAdLoader.this.e();
                POBNativeAdLoader.this.d();
            }
        }
    }

    public POBNativeAdLoader(Context context, String str, int i, String str2, POBNativeTemplateType pOBNativeTemplateType, POBNativeAdEvent pOBNativeAdEvent) {
        this.j = false;
        this.k = false;
        this.o = POBDataType.POBAdState.DEFAULT;
        this.f7680a = context;
        this.b = pOBNativeTemplateType;
        this.l = new POBNativeAdLoaderConfig();
        this.h = Collections.synchronizedSet(new LinkedHashSet(5));
        a(context, str, i, str2, pOBNativeTemplateType, pOBNativeAdEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.o == POBDataType.POBAdState.LOAD_DEFERRED) {
            for (int i = 0; i < this.i; i++) {
                c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        POBTimeoutHandler pOBTimeoutHandler = this.g;
        if (pOBTimeoutHandler != null) {
            pOBTimeoutHandler.cancel();
        }
        this.g = null;
    }

    private void f() {
        POBLog.debug("POBNativeAdLoader", POBLogConstants.MSG_SCHEDULE_LOAD_AD_DELAY, new Object[0]);
        POBTimeoutHandler pOBTimeoutHandler = new POBTimeoutHandler(new b());
        this.g = pOBTimeoutHandler;
        pOBTimeoutHandler.start(500L);
    }

    @Override // com.pubmatic.sdk.openwrap.core.POBBaseAd
    public void destroy() {
        this.o = POBDataType.POBAdState.DEFAULT;
        this.k = false;
        e();
        this.h.clear();
    }

    @Override // com.pubmatic.sdk.openwrap.core.POBBaseAd
    public POBRequest getAdRequest() {
        POBRequest pOBRequest = this.e;
        if (pOBRequest != null) {
            return pOBRequest;
        }
        POBLog.warn("POBNativeAdLoader", POBLogConstants.MSG_AD_OBJECT_INVALID, new Object[0]);
        return null;
    }

    public POBNativeAdLoaderConfig getConfig() {
        return this.l;
    }

    @Override // com.pubmatic.sdk.openwrap.core.POBBaseAd
    public POBImpression getImpression() {
        return POBAdsHelper.getImpression(this.e);
    }

    @Override // com.pubmatic.sdk.openwrap.core.POBBaseAd
    public void loadAd() {
        Trace.beginSection("POB Native Load Ad");
        Trace.beginSection("POB Request Building");
        if (this.m == null) {
            a(new POBError(1001, POBNativeConstants.CUSTOM_TEMPLATE_NULL_ASSETS));
            return;
        }
        if (getAdRequest() == null || this.c == null) {
            a(new POBError(1001, POBLogConstants.MSG_MISSING_INPUT_PARAMS));
            return;
        }
        int i = this.i;
        if (i >= 5) {
            POBTaskHandler.getInstance().runOnMainThread(new a(new POBError(1012, String.format(Locale.ENGLISH, POBLogConstants.AD_LOAD_THRESHOLD_MSG, 5))));
            return;
        }
        this.i = i + 1;
        if (this.j) {
            c();
            return;
        }
        this.o = POBDataType.POBAdState.LOAD_DEFERRED;
        if (this.k) {
            return;
        }
        f();
        this.k = true;
    }

    @Override // com.pubmatic.sdk.nativead.POBNativeAdManager.POBNativeAdManagerListener
    public void onAdReceived(POBNativeAdManager pOBNativeAdManager, POBNativeAd pOBNativeAd) {
        Trace.endSection();
        a(pOBNativeAdManager);
        POBNativeAdLoaderListener pOBNativeAdLoaderListener = this.d;
        if (pOBNativeAdLoaderListener != null) {
            pOBNativeAdLoaderListener.onAdReceived(this, pOBNativeAd);
        }
    }

    @Override // com.pubmatic.sdk.nativead.POBNativeAdManager.c
    public void onBidFailure(POBNativeAdManager pOBNativeAdManager) {
        this.o = POBDataType.POBAdState.BID_FAILED;
        a(pOBNativeAdManager);
    }

    @Override // com.pubmatic.sdk.nativead.POBNativeAdManager.POBNativeAdManagerListener
    public void onFailedToLoad(POBNativeAdManager pOBNativeAdManager, POBError pOBError) {
        Trace.endSection();
        a(pOBNativeAdManager);
        POBNativeAdLoaderListener pOBNativeAdLoaderListener = this.d;
        if (pOBNativeAdLoaderListener != null) {
            pOBNativeAdLoaderListener.onFailedToLoad(this, pOBError);
        }
    }

    public void setAdLoaderListener(POBNativeAdLoaderListener pOBNativeAdLoaderListener) {
        this.d = pOBNativeAdLoaderListener;
    }

    public void setBidEventListener(POBBidEventListener pOBBidEventListener) {
        this.n = pOBBidEventListener;
    }

    public void setNativeCustomAssets(List<POBBaseNativeRequestAsset> list) {
        if (!POBNativeTemplateType.CUSTOM.equals(this.b)) {
            POBLog.warn("POBNativeAdLoader", POBNativeLogConstants.STANDARD_TEMPLATE_CUSTOM_ASSETS, new Object[0]);
        } else {
            if (POBUtils.isListNullOrEmpty(list)) {
                return;
            }
            a(list);
        }
    }

    private String b() {
        return UUID.randomUUID().toString();
    }

    private void c() {
        POBNativeAdEvent pOBNativeAdEvent;
        this.o = POBDataType.POBAdState.LOADING;
        if (this.e == null || (pOBNativeAdEvent = this.c) == null) {
            a(new POBError(1001, POBLogConstants.MSG_MISSING_INPUT_PARAMS));
        } else {
            a(this.e, pOBNativeAdEvent.createNativeAdEventBridge());
        }
    }

    private void a(POBRequest pOBRequest, POBNativeAdEventBridge pOBNativeAdEventBridge) {
        POBProfileInfo profileInfo;
        if (this.f != null) {
            profileInfo = this.f.getProfileInfo(String.valueOf(pOBRequest.getProfileId()));
        } else {
            profileInfo = null;
        }
        POBNativeAdManager pOBNativeAdManager = new POBNativeAdManager(this.f7680a, this.b, pOBNativeAdEventBridge);
        pOBNativeAdManager.setListener(this);
        POBBidEventListener pOBBidEventListener = this.n;
        if (pOBBidEventListener != null) {
            pOBNativeAdManager.setBidEventListener(pOBBidEventListener);
            pOBNativeAdManager.a(this);
        }
        this.h.add(pOBNativeAdManager);
        pOBNativeAdManager.loadAd(pOBRequest, profileInfo);
    }

    private void a(Context context, String str, int i, String str2, POBNativeTemplateType pOBNativeTemplateType, POBNativeAdEvent pOBNativeAdEvent) {
        if (POBAdsHelper.validate(context, str, str2, pOBNativeAdEvent) && pOBNativeTemplateType != null) {
            if (!this.j) {
                OpenWrapSDK.initialize(context, new OpenWrapSDKConfig.Builder(str, new ArrayList(Collections.singletonList(Integer.valueOf(i)))).build(), new c());
            }
            this.c = pOBNativeAdEvent;
            this.e = POBRequest.createInstance(str, i, POBAdFormat.NATIVE, new POBImpression(b(), str2, false, false));
            this.f = POBInstanceProvider.getCacheManager(context.getApplicationContext());
            if (POBNativeTemplateType.CUSTOM.equals(pOBNativeTemplateType)) {
                return;
            }
            a(a(pOBNativeTemplateType));
            return;
        }
        a(new POBError(1001, POBLogConstants.MSG_MISSING_INPUT_PARAMS));
    }

    public POBNativeAdLoader(Context context, String str, int i, String str2, POBNativeTemplateType pOBNativeTemplateType) {
        this(context, str, i, str2, pOBNativeTemplateType, new POBDefaultNativeEventHandler());
    }

    private void a(List list) {
        HashSet hashSet = new HashSet();
        if (POBInstanceProvider.getSdkConfig().getMeasurementProvider(POBCommonConstants.NATIVE_MEASUREMENT_PROVIDER_CLASS) != null) {
            hashSet.add(Integer.valueOf(POBRequest.API.OMSDK.getValue()));
        }
        POBNativeBuilder pOBNativeBuilder = new POBNativeBuilder(list, a(), hashSet);
        this.m = pOBNativeBuilder;
        pOBNativeBuilder.setConfig(this.l);
        POBImpression impression = getImpression();
        if (impression != null) {
            impression.setNative(this.m);
        }
    }

    private List a() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(POBNativeEventTrackingMethod.IMAGE);
        arrayList.add(POBNativeEventTrackingMethod.JAVASCRIPT);
        POBNativeRequestEventTracker pOBNativeRequestEventTracker = new POBNativeRequestEventTracker(POBNativeEventType.IMPRESSION, arrayList);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList2.add(pOBNativeRequestEventTracker);
        return arrayList2;
    }

    private List a(POBNativeTemplateType pOBNativeTemplateType) {
        POBNativeRequestTitleAsset pOBNativeRequestTitleAsset = new POBNativeRequestTitleAsset(1, true, 25);
        POBNativeRequestDataAsset pOBNativeRequestDataAsset = new POBNativeRequestDataAsset(3, true, POBNativeDataAssetType.DESCRIPTION);
        pOBNativeRequestDataAsset.setLength(90);
        POBNativeRequestImageAsset pOBNativeRequestImageAsset = new POBNativeRequestImageAsset(2, true, POBNativeImageAssetType.ICON, 50, 50);
        POBNativeRequestDataAsset pOBNativeRequestDataAsset2 = new POBNativeRequestDataAsset(4, true, POBNativeDataAssetType.CTA_TEXT);
        pOBNativeRequestDataAsset2.setLength(15);
        ArrayList arrayList = new ArrayList();
        arrayList.add(pOBNativeRequestTitleAsset);
        arrayList.add(pOBNativeRequestDataAsset);
        arrayList.add(pOBNativeRequestImageAsset);
        arrayList.add(pOBNativeRequestDataAsset2);
        if (pOBNativeTemplateType == POBNativeTemplateType.MEDIUM) {
            arrayList.add(new POBNativeRequestImageAsset(5, true, POBNativeImageAssetType.MAIN, POBNativeConstants.POB_NATIVE_MAIN_IMG_W, POBNativeConstants.POB_NATIVE_MAIN_IMG_H));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(POBError pOBError) {
        Trace.endSection();
        Trace.endSection();
        POBLog.error("POBNativeAdLoader", pOBError.toString(), new Object[0]);
        POBNativeAdLoaderListener pOBNativeAdLoaderListener = this.d;
        if (pOBNativeAdLoaderListener != null) {
            pOBNativeAdLoaderListener.onFailedToLoad(this, pOBError);
        }
    }

    private void a(POBNativeAdManager pOBNativeAdManager) {
        this.i--;
        this.h.remove(pOBNativeAdManager);
    }
}
