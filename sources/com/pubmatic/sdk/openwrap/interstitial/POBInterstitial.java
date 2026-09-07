package com.pubmatic.sdk.openwrap.interstitial;

import android.content.Context;
import android.os.Trace;
import com.pubmatic.sdk.common.OpenWrapSDK;
import com.pubmatic.sdk.common.OpenWrapSDKConfig;
import com.pubmatic.sdk.common.OpenWrapSDKInitializer;
import com.pubmatic.sdk.common.POBAdFormat;
import com.pubmatic.sdk.common.POBAdSize;
import com.pubmatic.sdk.common.POBDataType;
import com.pubmatic.sdk.common.POBError;
import com.pubmatic.sdk.common.POBInstanceProvider;
import com.pubmatic.sdk.common.base.POBAdDescriptor;
import com.pubmatic.sdk.common.base.POBBaseBidder;
import com.pubmatic.sdk.common.base.POBBidderListener;
import com.pubmatic.sdk.common.base.POBBidding;
import com.pubmatic.sdk.common.base.POBBidsProvider;
import com.pubmatic.sdk.common.cache.POBCacheManager;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.log.POBLogConstants;
import com.pubmatic.sdk.common.models.POBAdResponse;
import com.pubmatic.sdk.common.models.POBProfileInfo;
import com.pubmatic.sdk.common.ui.POBInterstitialRendererListener;
import com.pubmatic.sdk.common.ui.POBInterstitialRendering;
import com.pubmatic.sdk.common.ui.POBVideoAdEventListener;
import com.pubmatic.sdk.common.utility.POBTimeoutHandler;
import com.pubmatic.sdk.common.utility.POBUtils;
import com.pubmatic.sdk.openwrap.core.POBAdsHelper;
import com.pubmatic.sdk.openwrap.core.POBBanner;
import com.pubmatic.sdk.openwrap.core.POBBid;
import com.pubmatic.sdk.openwrap.core.POBBidEvent;
import com.pubmatic.sdk.openwrap.core.POBBidEventHelper;
import com.pubmatic.sdk.openwrap.core.POBBidEventListener;
import com.pubmatic.sdk.openwrap.core.POBBiddingManager;
import com.pubmatic.sdk.openwrap.core.POBExtBidHandler;
import com.pubmatic.sdk.openwrap.core.POBFullScreenAdInteractionListener;
import com.pubmatic.sdk.openwrap.core.POBImpression;
import com.pubmatic.sdk.openwrap.core.POBOWPartnerHelper;
import com.pubmatic.sdk.openwrap.core.POBRenderer;
import com.pubmatic.sdk.openwrap.core.POBRequest;
import com.pubmatic.sdk.openwrap.core.POBVideo;
import com.pubmatic.sdk.video.POBVideoLogConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes8.dex */
public class POBInterstitial implements POBBidEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f7767a;
    private final POBInterstitialRendererListener b;
    private final Map c;
    private POBBaseBidder d;
    private POBInterstitialEvent e;
    private POBFullScreenAdInteractionListener f;
    private POBInterstitialListener g;
    private POBVideoListener h;
    private POBInterstitialRendering i;
    private POBDataType.POBAdState j;
    private int k;
    private POBVideoAdEventListener l;
    private POBRequest m;
    private POBTimeoutHandler n;
    private POBBidEventListener o;
    private boolean p;
    private POBAdResponse q;
    private POBCacheManager r;
    private boolean s;

    public static class POBInterstitialListener {
        public void onAdClicked(POBInterstitial pOBInterstitial) {
        }

        public void onAdClosed(POBInterstitial pOBInterstitial) {
        }

        public void onAdExpired(POBInterstitial pOBInterstitial) {
        }

        public void onAdFailedToLoad(POBInterstitial pOBInterstitial, POBError pOBError) {
        }

        public void onAdFailedToShow(POBInterstitial pOBInterstitial, POBError pOBError) {
        }

        public void onAdImpression(POBInterstitial pOBInterstitial) {
        }

        public void onAdOpened(POBInterstitial pOBInterstitial) {
        }

        public void onAdReceived(POBInterstitial pOBInterstitial) {
        }

        public void onAppLeaving(POBInterstitial pOBInterstitial) {
        }
    }

    public static class POBVideoListener {
        public void onVideoPlaybackCompleted(POBInterstitial pOBInterstitial) {
        }
    }

    class a implements OpenWrapSDKInitializer.Listener {
        a() {
        }

        @Override // com.pubmatic.sdk.common.OpenWrapSDKInitializer.Listener
        public void onFailure(POBError pOBError) {
            POBInterstitial.this.p = true;
            POBLog.error("POBInterstitial", POBLogConstants.SDK_INITIALIZATION_FAILED + pOBError, new Object[0]);
            if (POBInterstitial.this.j == POBDataType.POBAdState.LOAD_DEFERRED) {
                POBInterstitial.this.a(pOBError, true);
            }
        }

        @Override // com.pubmatic.sdk.common.OpenWrapSDKInitializer.Listener
        public void onSuccess() {
            POBInterstitial.this.p = true;
            POBLog.verbose("POBInterstitial", POBLogConstants.SDK_INITIALIZATION_SUCCESS, new Object[0]);
            if (POBInterstitial.this.j == POBDataType.POBAdState.LOAD_DEFERRED) {
                POBInterstitial.this.l();
                POBInterstitial.this.e();
            }
        }
    }

    class b implements POBTimeoutHandler.POBTimeoutHandlerListener {
        b() {
        }

        @Override // com.pubmatic.sdk.common.utility.POBTimeoutHandler.POBTimeoutHandlerListener
        public void onTimeout() {
            if (POBInterstitial.this.j == POBDataType.POBAdState.LOAD_DEFERRED) {
                POBInterstitial.this.e();
            }
        }
    }

    static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7770a;

        static {
            int[] iArr = new int[POBDataType.POBAdState.values().length];
            f7770a = iArr;
            try {
                iArr[POBDataType.POBAdState.LOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7770a[POBDataType.POBAdState.LOAD_DEFERRED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7770a[POBDataType.POBAdState.SHOWING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7770a[POBDataType.POBAdState.READY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7770a[POBDataType.POBAdState.AD_SERVER_READY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7770a[POBDataType.POBAdState.BID_RECEIVED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f7770a[POBDataType.POBAdState.BID_FAILED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private class d implements POBBidderListener {
        private d() {
        }

        @Override // com.pubmatic.sdk.common.base.POBBidderListener
        public void onBidsFailed(POBBidding pOBBidding, POBError pOBError) {
            POBLog.debug("POBInterstitial", POBLogConstants.MSG_DEBUG_BIDS_FAILED, pOBError.toString());
            if (POBInterstitial.this.o != null) {
                POBInterstitial.this.j = POBDataType.POBAdState.BID_FAILED;
                POBLog.info("POBInterstitial", POBLogConstants.MSG_FMT_BID_EVENT_ERROR, pOBError.getErrorMessage());
                POBInterstitial.this.o.onBidFailed(POBInterstitial.this, pOBError);
                return;
            }
            if (POBInterstitial.this.e instanceof POBDefaultInterstitialEventHandler) {
                POBInterstitial.this.a(pOBError, true);
            } else {
                POBInterstitial.this.b((POBBid) null);
            }
        }

        @Override // com.pubmatic.sdk.common.base.POBBidderListener
        public void onBidsFetched(POBBidding pOBBidding, POBAdResponse pOBAdResponse) {
            POBInterstitial.this.q = POBAdsHelper.updateResponseUsingPlacementType(pOBAdResponse, "interstitial");
            POBBid pOBBid = (POBBid) POBInterstitial.this.q.getWinningBid();
            if (pOBBid != null) {
                POBLog.debug("POBInterstitial", POBLogConstants.MSG_DEBUG_BIDS_FETCHED, pOBBid.getImpressionId(), Double.valueOf(pOBBid.getPrice()));
                if (pOBBid.getRawBid() != null) {
                    POBInstanceProvider.getCacheManager(POBInterstitial.this.f7767a).saveReceivedBid(pOBBid.getRawBid());
                }
            }
            if (POBInterstitial.this.o == null) {
                POBInterstitial.this.b(pOBBid);
                return;
            }
            if (pOBBid != null && pOBBid.getStatus() == 1) {
                POBInterstitial.this.j = POBDataType.POBAdState.BID_RECEIVED;
                POBLog.debug("POBInterstitial", POBLogConstants.MSG_BID_EVENT_SHARING_BIDS, new Object[0]);
                POBInterstitial.this.o.onBidReceived(POBInterstitial.this, pOBBid);
                return;
            }
            POBInterstitial.this.j = POBDataType.POBAdState.BID_FAILED;
            POBError pOBError = new POBError(1002, "No ads available");
            POBLog.info("POBInterstitial", POBLogConstants.MSG_FMT_BID_EVENT_ERROR, pOBError.getErrorMessage());
            POBInterstitial.this.o.onBidFailed(POBInterstitial.this, pOBError);
        }

        /* synthetic */ d(POBInterstitial pOBInterstitial, a aVar) {
            this();
        }
    }

    private class e implements POBInterstitialEventListener {
        private e() {
        }

        private void a() {
            POBLog.debug("POBInterstitial", "PartnerBidWin", new Object[0]);
            POBBid winningBid = POBBiddingManager.getWinningBid(POBInterstitial.this.q);
            if (winningBid != null) {
                winningBid.setHasWon(true);
                POBUtils.logBidWinningStatus(winningBid.hasWon(), winningBid.getPartnerName());
                String partnerName = winningBid.getPartnerName();
                if (POBInterstitial.this.e != null && partnerName != null) {
                    POBInterstitial pOBInterstitial = POBInterstitial.this;
                    pOBInterstitial.i = pOBInterstitial.e.getRenderer(partnerName);
                }
                if (POBInterstitial.this.i == null) {
                    POBInterstitial pOBInterstitial2 = POBInterstitial.this;
                    pOBInterstitial2.i = pOBInterstitial2.a(winningBid);
                }
                POBInterstitial.this.i.setAdRendererListener(POBInterstitial.this.b);
                POBInterstitial.this.i.setVideoAdEventListener(POBInterstitial.this.l);
                if (winningBid.getRawBid() != null) {
                    POBInstanceProvider.getCacheManager(POBInterstitial.this.f7767a).saveRenderedBid(winningBid.getRawBid());
                }
                POBInterstitial.this.i.renderAd(winningBid);
            }
        }

        @Override // com.pubmatic.sdk.openwrap.core.POBAdEventListener
        public POBBidsProvider getBidsProvider() {
            return POBInterstitial.this.q;
        }

        @Override // com.pubmatic.sdk.openwrap.interstitial.POBInterstitialEventListener
        public Map getCustomData() {
            return POBInterstitial.this.c;
        }

        @Override // com.pubmatic.sdk.openwrap.core.POBAdEventListener
        public void onAdClick() {
            POBInterstitial.this.f();
        }

        @Override // com.pubmatic.sdk.openwrap.core.POBAdEventListener
        public void onAdClosed() {
            POBInterstitial.this.g();
        }

        @Override // com.pubmatic.sdk.openwrap.interstitial.POBInterstitialEventListener
        public void onAdExpired() {
            POBInterstitial.this.b();
        }

        @Override // com.pubmatic.sdk.openwrap.core.POBAdEventListener
        public void onAdImpression() {
            POBInterstitial.this.h();
        }

        @Override // com.pubmatic.sdk.openwrap.core.POBAdEventListener
        public void onAdLeftApplication() {
            POBInterstitial.this.k();
        }

        @Override // com.pubmatic.sdk.openwrap.core.POBAdEventListener
        public void onAdOpened() {
            POBInterstitial.this.i();
        }

        @Override // com.pubmatic.sdk.openwrap.interstitial.POBInterstitialEventListener
        public void onAdServerWin() {
            Trace.endSection();
            POBBid winningBid = POBBiddingManager.getWinningBid(POBInterstitial.this.q);
            if (winningBid != null) {
                POBUtils.logBidWinningStatus(winningBid.hasWon(), winningBid.getPartnerName());
            } else {
                POBLog.debug("POBInterstitial", "AdServerWin", new Object[0]);
            }
            POBInterstitial.this.j = POBDataType.POBAdState.AD_SERVER_READY;
            POBInterstitial.this.c();
        }

        @Override // com.pubmatic.sdk.openwrap.interstitial.POBInterstitialEventListener
        public void onFailedToLoad(POBError pOBError) {
            POBInterstitial.this.a(pOBError, true);
        }

        @Override // com.pubmatic.sdk.openwrap.interstitial.POBInterstitialEventListener
        public void onFailedToShow(POBError pOBError) {
            POBInterstitial.this.j = POBDataType.POBAdState.DEFAULT;
            POBInterstitial.this.b(pOBError);
        }

        @Override // com.pubmatic.sdk.openwrap.interstitial.POBInterstitialEventListener
        public void onOpenWrapPartnerWin(String str) {
            if (POBInterstitial.this.q != null) {
                POBBid pOBBid = (POBBid) POBInterstitial.this.q.getBid(str);
                if (pOBBid != null) {
                    POBAdResponse.Builder builderUpdateWinningBid = new POBAdResponse.Builder(POBInterstitial.this.q).updateWinningBid(pOBBid);
                    POBInterstitial.this.q = builderUpdateWinningBid.build();
                } else {
                    POBLog.debug("POBInterstitial", POBLogConstants.MSG_INVALID_BIDID, new Object[0]);
                }
            }
            a();
        }

        /* synthetic */ e(POBInterstitial pOBInterstitial, a aVar) {
            this();
        }
    }

    private class f implements POBInterstitialRendererListener {
        private f() {
        }

        private void a(POBError pOBError) {
            if (POBInterstitial.this.f != null) {
                POBInterstitial.this.f.trackAdFailed(pOBError);
            }
        }

        @Override // com.pubmatic.sdk.common.ui.POBInterstitialRendererListener
        public void onAdClicked() {
            POBInterstitial.this.f();
            if (POBInterstitial.this.f != null) {
                POBInterstitial.this.f.trackClick();
            }
        }

        @Override // com.pubmatic.sdk.common.ui.POBInterstitialRendererListener
        public void onAdExpired() {
            a(new POBError(1011, "Ad Expired"));
            POBInterstitial.this.b();
        }

        @Override // com.pubmatic.sdk.common.ui.POBInterstitialRendererListener
        public void onAdImpression() {
            if (POBInterstitial.this.s) {
                return;
            }
            POBAdsHelper.recordImpressionDepth(POBInterstitial.this.f7767a, POBAdFormat.INTERSTITIAL);
            POBInterstitial.this.h();
        }

        @Override // com.pubmatic.sdk.common.ui.POBInterstitialRendererListener
        public void onAdInteractionStarted() {
            POBInterstitial.this.i();
            if (POBInterstitial.this.s) {
                POBAdsHelper.recordImpressionDepth(POBInterstitial.this.f7767a, POBAdFormat.INTERSTITIAL);
                POBInterstitial.this.h();
            }
            POBBid winningBid = POBBiddingManager.getWinningBid(POBInterstitial.this.q);
            if (POBInterstitial.this.f != null) {
                if (winningBid != null && winningBid.isVideo()) {
                    POBInterstitial.this.f.trackImpression();
                }
                POBInterstitial.this.f.trackAdShown();
            }
        }

        @Override // com.pubmatic.sdk.common.ui.POBInterstitialRendererListener
        public void onAdInteractionStopped() {
            POBInterstitial.this.g();
            if (POBInterstitial.this.f != null) {
                POBInterstitial.this.f.trackAdDismissed();
            }
        }

        @Override // com.pubmatic.sdk.common.ui.POBInterstitialRendererListener
        public void onAdRender(POBAdDescriptor pOBAdDescriptor) {
            POBLog.info("POBInterstitial", hashCode() + " : ******** onAdRender() ********", new Object[0]);
            POBInterstitial.this.c();
            POBBid winningBid = POBBiddingManager.getWinningBid(POBInterstitial.this.q);
            if (POBInterstitial.this.f == null || winningBid == null || winningBid.isVideo()) {
                return;
            }
            POBInterstitial.this.f.trackImpression();
        }

        @Override // com.pubmatic.sdk.common.ui.POBInterstitialRendererListener
        public void onAdRenderingFailed(POBError pOBError) {
            boolean z = (POBInterstitial.this.j == POBDataType.POBAdState.SHOWING || POBInterstitial.this.j == POBDataType.POBAdState.SHOWN) ? false : true;
            a(pOBError);
            POBInterstitial.this.a(pOBError, z);
        }

        @Override // com.pubmatic.sdk.common.ui.POBInterstitialRendererListener
        public void onAdUnload() {
        }

        @Override // com.pubmatic.sdk.common.ui.POBInterstitialRendererListener
        public void onLeavingApplication() {
            POBInterstitial.this.k();
        }

        @Override // com.pubmatic.sdk.common.ui.POBInterstitialRendererListener
        public void onRenderProcessGone() {
            POBInterstitial.this.j = POBDataType.POBAdState.DEFAULT;
        }

        /* synthetic */ f(POBInterstitial pOBInterstitial, a aVar) {
            this();
        }
    }

    private class g implements POBVideoAdEventListener {
        private g() {
        }

        @Override // com.pubmatic.sdk.common.ui.POBVideoAdEventListener
        public void onVideoAdEvent(POBDataType.POBVideoAdEventType pOBVideoAdEventType) {
            POBLog.debug("POBInterstitial", "Interstitial Video Ad event: " + pOBVideoAdEventType, new Object[0]);
            if (POBInterstitial.this.h == null || POBDataType.POBVideoAdEventType.COMPLETE != pOBVideoAdEventType) {
                return;
            }
            POBInterstitial.this.h.onVideoPlaybackCompleted(POBInterstitial.this);
        }

        /* synthetic */ g(POBInterstitial pOBInterstitial, a aVar) {
            this();
        }
    }

    public POBInterstitial(Context context, String str, int i, String str2) {
        this(context, str, i, str2, new POBDefaultInterstitialEventHandler());
    }

    public void destroy() {
        POBBaseBidder pOBBaseBidder = this.d;
        if (pOBBaseBidder != null) {
            pOBBaseBidder.destroy();
            this.d = null;
        }
        l();
        this.j = POBDataType.POBAdState.DEFAULT;
        POBInterstitialRendering pOBInterstitialRendering = this.i;
        if (pOBInterstitialRendering != null) {
            pOBInterstitialRendering.destroy();
        }
        POBInterstitialEvent pOBInterstitialEvent = this.e;
        if (pOBInterstitialEvent != null) {
            pOBInterstitialEvent.destroy();
        }
        this.h = null;
        this.g = null;
        this.l = null;
    }

    public POBRequest getAdRequest() {
        POBRequest pOBRequest = this.m;
        if (pOBRequest != null) {
            return pOBRequest;
        }
        POBLog.warn("POBInterstitial", POBLogConstants.MSG_AD_OBJECT_INVALID, new Object[0]);
        return null;
    }

    @Override // com.pubmatic.sdk.openwrap.core.POBBidEvent
    public POBBid getBid() {
        return POBBiddingManager.getWinningBid(this.q);
    }

    public POBImpression getImpression() {
        return POBAdsHelper.getImpression(this.m);
    }

    public boolean isReady() {
        return this.j.equals(POBDataType.POBAdState.READY) || this.j.equals(POBDataType.POBAdState.AD_SERVER_READY);
    }

    public void loadAd() {
        Trace.beginSection("POB Interstitial Load Ad");
        Trace.beginSection("POB Request Building");
        POBImpression impression = getImpression();
        if (this.m == null || impression == null) {
            a(new POBError(1001, POBLogConstants.MSG_MISSING_INPUT_PARAMS));
            POBLog.error("POBInterstitial", POBLogConstants.MSG_MISSING_INPUT_PARAMS, new Object[0]);
            return;
        }
        switch (c.f7770a[this.j.ordinal()]) {
            case 1:
            case 2:
                POBLog.debug("POBInterstitial", POBLogConstants.MSG_AD_LOADING_ERROR, new Object[0]);
                return;
            case 3:
                POBLog.debug("POBInterstitial", POBLogConstants.MSG_AD_SHOWING, new Object[0]);
                return;
            case 4:
            case 5:
                POBLog.error("POBInterstitial", POBLogConstants.MSG_AD_LOADED_ERROR, new Object[0]);
                c();
                return;
            case 6:
                POBLog.debug("POBInterstitial", POBLogConstants.MSG_BID_EVENT_SHARING_BIDS, new Object[0]);
                POBBid bid = getBid();
                if (this.o != null && bid != null && !bid.isExpired()) {
                    this.o.onBidReceived(this, bid);
                    return;
                }
                POBLog.info("POBInterstitial", POBLogConstants.MSG_AD_EXPIRED_ERROR, new Object[0]);
                break;
        }
        if (this.p) {
            e();
        } else {
            this.j = POBDataType.POBAdState.LOAD_DEFERRED;
            m();
        }
    }

    @Override // com.pubmatic.sdk.openwrap.core.POBBidEvent
    public void proceedOnError(POBBidEvent.BidEventError bidEventError, String str) {
        if (this.o == null) {
            POBLog.warn("POBInterstitial", POBLogConstants.WARN_MSG_BID_EVENT_NOT_IMPLEMENTED, new Object[0]);
            return;
        }
        POBDataType.POBAdState pOBAdState = this.j;
        if (pOBAdState != POBDataType.POBAdState.BID_RECEIVED && pOBAdState != POBDataType.POBAdState.BID_FAILED) {
            POBLog.warn("POBInterstitial", POBLogConstants.WARN_MSG_BID_EVENT_INVALID_STATE, new Object[0]);
            return;
        }
        POBLog.info("POBInterstitial", POBLogConstants.INFO_MSG_BID_EVENT_PROCEED_ON_ERROR, new Object[0]);
        if (!(this.e instanceof POBDefaultInterstitialEventHandler)) {
            d();
        } else {
            POBLog.info("POBInterstitial", POBVideoLogConstants.INFO_MSG_BID_EVENT_PROCEED_ON_ERROR_CODE_AND_MSG, bidEventError.toString(), str);
            this.j = POBDataType.POBAdState.DEFAULT;
        }
    }

    @Override // com.pubmatic.sdk.openwrap.core.POBBidEvent
    public boolean proceedToLoadAd() {
        if (this.o == null) {
            POBLog.warn("POBInterstitial", POBLogConstants.WARN_MSG_BID_EVENT_NOT_IMPLEMENTED, new Object[0]);
            return false;
        }
        POBDataType.POBAdState pOBAdState = this.j;
        if (pOBAdState != POBDataType.POBAdState.BID_RECEIVED && pOBAdState != POBDataType.POBAdState.BID_FAILED) {
            POBLog.warn("POBInterstitial", POBLogConstants.MSG_BID_NOT_RECEIVED_WARNING, new Object[0]);
            return false;
        }
        POBLog.info("POBInterstitial", POBLogConstants.INFO_MSG_BID_EVENT_PROCEED_TO_LOAD, new Object[0]);
        POBBid winningBid = POBBiddingManager.getWinningBid(this.q);
        if (winningBid == null || !winningBid.isExpired()) {
            POBLog.debug("POBInterstitial", POBLogConstants.MSG_PROCEEDING_WITH_BID, new Object[0]);
            this.j = POBDataType.POBAdState.LOADING;
            b(winningBid);
            return true;
        }
        POBError pOBErrorConvertToPOBError = POBBidEventHelper.convertToPOBError(POBBidEvent.BidEventError.BID_EXPIRED);
        if (this.e instanceof POBDefaultInterstitialEventHandler) {
            a(pOBErrorConvertToPOBError, true);
            return false;
        }
        POBLog.warn("POBInterstitial", POBLogConstants.MSG_AD_EXPIRED_PROCEEDING_IGNORING_OPENWRAP_BID, new Object[0]);
        d();
        return true;
    }

    @Override // com.pubmatic.sdk.openwrap.core.POBBidEvent
    public void setBidEventListener(POBBidEventListener pOBBidEventListener) {
        this.o = pOBBidEventListener;
    }

    public void setListener(POBInterstitialListener pOBInterstitialListener) {
        this.g = pOBInterstitialListener;
    }

    public void setVideoListener(POBVideoListener pOBVideoListener) {
        this.h = pOBVideoListener;
    }

    public void show() {
        POBError pOBError;
        POBInterstitialRendering pOBInterstitialRendering;
        if (this.e != null && this.j.equals(POBDataType.POBAdState.AD_SERVER_READY)) {
            this.j = POBDataType.POBAdState.SHOWING;
            this.e.show();
        } else if (isReady() && (pOBInterstitialRendering = this.i) != null) {
            this.j = POBDataType.POBAdState.SHOWING;
            pOBInterstitialRendering.show(this.k);
        } else {
            if (this.j.equals(POBDataType.POBAdState.EXPIRED)) {
                pOBError = new POBError(1011, POBLogConstants.MSG_AD_EXPIRED_ERROR);
            } else {
                pOBError = this.j.equals(POBDataType.POBAdState.SHOWN) ? new POBError(2001, POBLogConstants.MSG_AD_ALREADY_SHOWN_ERROR) : new POBError(2002, POBLogConstants.MSG_AD_NOT_READY_ERROR);
            }
            b(pOBError);
        }
    }

    public POBInterstitial(Context context) {
        this(context, new POBDefaultInterstitialEventHandler());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.j != POBDataType.POBAdState.AD_SERVER_READY) {
            this.j = POBDataType.POBAdState.READY;
        }
        j();
    }

    private void d() {
        this.j = POBDataType.POBAdState.LOADING;
        if (this.q != null) {
            this.q = new POBAdResponse.Builder(this.q).setWinningBid(null).build();
        }
        if (this.e != null) {
            POBLog.info("POBInterstitial", "Proceeding with bid. Ad server integration is " + this.e.getClass().getSimpleName(), new Object[0]);
        }
        b((POBBid) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        POBLog.info("POBInterstitial", POBLogConstants.MSG_REQUESTING_LOAD, this.j);
        this.q = null;
        if (this.m != null) {
            POBAdSize interstitialAdSize = POBUtils.getInterstitialAdSize(this.f7767a.getApplicationContext());
            POBImpression impression = getImpression();
            if (impression != null) {
                this.j = POBDataType.POBAdState.LOADING;
                impression.setVideo(new POBVideo(POBVideo.Placement.INTERSTITIAL, POBVideo.Plcmt.INTERSTITIAL, POBVideo.Linearity.LINEAR, interstitialAdSize));
                impression.setBanner(new POBBanner(interstitialAdSize));
                int deviceOrientation = POBUtils.getDeviceOrientation(this.f7767a.getApplicationContext());
                this.k = deviceOrientation;
                this.c.put("orientation", Integer.valueOf(deviceOrientation));
                a(this.m).requestBid();
                return;
            }
        }
        a(new POBError(1001, POBLogConstants.MSG_MISSING_INPUT_PARAMS), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        POBInterstitialListener pOBInterstitialListener = this.g;
        if (pOBInterstitialListener != null) {
            pOBInterstitialListener.onAdClicked(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.j = POBDataType.POBAdState.SHOWN;
        POBInterstitialListener pOBInterstitialListener = this.g;
        if (pOBInterstitialListener != null) {
            pOBInterstitialListener.onAdClosed(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        POBInterstitialListener pOBInterstitialListener = this.g;
        if (pOBInterstitialListener != null) {
            pOBInterstitialListener.onAdImpression(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        POBInterstitialListener pOBInterstitialListener = this.g;
        if (pOBInterstitialListener != null) {
            pOBInterstitialListener.onAdOpened(this);
        }
    }

    private void j() {
        Trace.endSection();
        POBInterstitialListener pOBInterstitialListener = this.g;
        if (pOBInterstitialListener != null) {
            pOBInterstitialListener.onAdReceived(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        POBInterstitialListener pOBInterstitialListener = this.g;
        if (pOBInterstitialListener != null) {
            pOBInterstitialListener.onAppLeaving(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        POBTimeoutHandler pOBTimeoutHandler = this.n;
        if (pOBTimeoutHandler != null) {
            pOBTimeoutHandler.cancel();
        }
        this.n = null;
    }

    private void m() {
        POBLog.debug("POBInterstitial", POBLogConstants.MSG_SCHEDULE_LOAD_AD_DELAY, new Object[0]);
        POBTimeoutHandler pOBTimeoutHandler = new POBTimeoutHandler(new b());
        this.n = pOBTimeoutHandler;
        pOBTimeoutHandler.start(500L);
    }

    public POBInterstitial(Context context, String str, int i, String str2, POBInterstitialEvent pOBInterstitialEvent) {
        this(context, pOBInterstitialEvent);
        a(context, str, i, str2, pOBInterstitialEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(POBError pOBError) {
        POBLog.error("POBInterstitial", POBLogConstants.MSG_FAILED_TO_SHOW + pOBError, new Object[0]);
        POBInterstitialListener pOBInterstitialListener = this.g;
        if (pOBInterstitialListener != null) {
            pOBInterstitialListener.onAdFailedToShow(this, pOBError);
        }
    }

    private POBInterstitial(Context context, POBInterstitialEvent pOBInterstitialEvent) {
        this.p = false;
        this.f7767a = context;
        this.j = POBDataType.POBAdState.DEFAULT;
        this.c = new HashMap();
        a aVar = null;
        this.b = new f(this, aVar);
        this.l = new g(this, aVar);
        if (pOBInterstitialEvent != null) {
            this.e = pOBInterstitialEvent;
            pOBInterstitialEvent.setEventListener(new e(this, aVar));
        }
    }

    private POBBaseBidder b(String str) {
        POBExtBidHandler pOBExtBidHandler = new POBExtBidHandler(str);
        this.d = pOBExtBidHandler;
        pOBExtBidHandler.setBidderListener(new d(this, null));
        return this.d;
    }

    private void a(Context context, String str, int i, String str2, POBInterstitialEvent pOBInterstitialEvent) {
        if (POBAdsHelper.validate(context, str, str2, pOBInterstitialEvent)) {
            if (!this.p) {
                OpenWrapSDK.initialize(context, new OpenWrapSDKConfig.Builder(str, new ArrayList(Collections.singletonList(Integer.valueOf(i)))).build(), new a());
            }
            this.m = POBRequest.createInstance(str, i, POBAdFormat.INTERSTITIAL, a(str2));
            this.r = POBInstanceProvider.getCacheManager(context.getApplicationContext());
            return;
        }
        POBLog.error("POBInterstitial", new POBError(1001, POBLogConstants.MSG_MISSING_INPUT_PARAMS).toString(), new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(POBBid pOBBid) {
        if (this.e != null) {
            Trace.endSection();
            this.e.requestAd(pOBBid);
            this.f = this.e.getAdInteractionListener();
            return;
        }
        POBLog.warn("POBInterstitial", POBLogConstants.MSG_FAILED_BID_EVENT, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.j = POBDataType.POBAdState.EXPIRED;
        POBInterstitialRendering pOBInterstitialRendering = this.i;
        if (pOBInterstitialRendering != null) {
            pOBInterstitialRendering.destroy();
            this.i = null;
        }
        POBInterstitialListener pOBInterstitialListener = this.g;
        if (pOBInterstitialListener != null) {
            pOBInterstitialListener.onAdExpired(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(POBError pOBError, boolean z) {
        this.j = POBDataType.POBAdState.DEFAULT;
        if (z) {
            a(pOBError);
        } else {
            b(pOBError);
        }
    }

    private POBImpression a(String str) {
        POBImpression pOBImpression = new POBImpression(a(), str);
        pOBImpression.setAdPosition(POBRequest.AdPosition.FULL_SCREEN);
        pOBImpression.setInterstitial(true);
        return pOBImpression;
    }

    private void a(POBError pOBError) {
        Trace.endSection();
        POBLog.error("POBInterstitial", POBLogConstants.MSG_FAILED_TO_LOAD + pOBError, new Object[0]);
        POBInterstitialListener pOBInterstitialListener = this.g;
        if (pOBInterstitialListener != null) {
            pOBInterstitialListener.onAdFailedToLoad(this, pOBError);
        }
    }

    private String a() {
        return UUID.randomUUID().toString();
    }

    private POBBidding a(POBRequest pOBRequest) {
        POBProfileInfo profileInfo;
        if (this.d == null) {
            a aVar = null;
            if (this.r != null) {
                profileInfo = this.r.getProfileInfo(String.valueOf(pOBRequest.getProfileId()));
            } else {
                profileInfo = null;
            }
            this.d = new POBBiddingManager(POBOWPartnerHelper.createPOBManager(this.f7767a, pOBRequest, profileInfo));
            this.d.setBidderListener(new d(this, aVar));
        }
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public POBInterstitialRendering a(POBBid pOBBid) {
        return POBRenderer.getInterstitialRenderer(this.f7767a.getApplicationContext(), pOBBid);
    }

    public void loadAd(String str) {
        this.s = true;
        if (!POBUtils.isNullOrEmpty(str)) {
            Trace.beginSection("POB Interstitial Load Ad");
            Trace.beginSection("POB Response Parsing");
            int i = c.f7770a[this.j.ordinal()];
            if (i == 1) {
                POBLog.debug("POBInterstitial", POBLogConstants.MSG_AD_LOADING_ERROR, new Object[0]);
                return;
            }
            if (i == 3) {
                POBLog.debug("POBInterstitial", POBLogConstants.MSG_AD_SHOWING, new Object[0]);
                return;
            }
            if (i != 4) {
                this.j = POBDataType.POBAdState.LOADING;
                POBBaseBidder pOBBaseBidderB = b(str);
                this.d = pOBBaseBidderB;
                pOBBaseBidderB.requestBid();
                return;
            }
            POBLog.error("POBInterstitial", POBLogConstants.MSG_AD_LOADED_ERROR, new Object[0]);
            c();
            return;
        }
        a(new POBError(1007, POBLogConstants.MSG_MISSING_BID_RESPONSE));
        POBLog.error("POBInterstitial", POBLogConstants.MSG_MISSING_BID_RESPONSE, new Object[0]);
    }
}
