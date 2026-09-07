package com.pubmatic.sdk.nativead;

import android.content.Context;
import android.os.Trace;
import com.pubmatic.sdk.common.POBAdServerSignalingEventListener;
import com.pubmatic.sdk.common.POBDataType;
import com.pubmatic.sdk.common.POBError;
import com.pubmatic.sdk.common.POBInstanceProvider;
import com.pubmatic.sdk.common.base.POBBidderListener;
import com.pubmatic.sdk.common.base.POBBidding;
import com.pubmatic.sdk.common.base.POBBidsProvider;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.log.POBLogConstants;
import com.pubmatic.sdk.common.models.POBAdResponse;
import com.pubmatic.sdk.common.models.POBProfileInfo;
import com.pubmatic.sdk.nativead.datatype.POBNativeTemplateType;
import com.pubmatic.sdk.nativead.response.POBNativeAdParser;
import com.pubmatic.sdk.nativead.response.POBNativeAdResponse;
import com.pubmatic.sdk.openwrap.core.POBBid;
import com.pubmatic.sdk.openwrap.core.POBBidEvent;
import com.pubmatic.sdk.openwrap.core.POBBidEventHelper;
import com.pubmatic.sdk.openwrap.core.POBBidEventListener;
import com.pubmatic.sdk.openwrap.core.POBBiddingManager;
import com.pubmatic.sdk.openwrap.core.POBOWPartnerHelper;
import com.pubmatic.sdk.openwrap.core.POBRequest;
import com.pubmatic.sdk.video.POBVideoLogConstants;

/* JADX INFO: loaded from: classes8.dex */
public class POBNativeAdManager implements POBAdServerSignalingEventListener, POBBidEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f7685a;
    private final POBNativeTemplateType b;
    private final POBNativeAdEventBridge c;
    private POBNativeAdManagerListener d;
    private POBBiddingManager e;
    private POBAdResponse f;
    private POBBidEventListener g;
    private POBDataType.POBAdState h = POBDataType.POBAdState.DEFAULT;
    private c i;

    public interface POBNativeAdManagerListener {
        void onAdReceived(POBNativeAdManager pOBNativeAdManager, POBNativeAd pOBNativeAd);

        void onFailedToLoad(POBNativeAdManager pOBNativeAdManager, POBError pOBError);
    }

    private class b implements POBBidderListener {
        private b() {
        }

        private void a(POBError pOBError, POBBidEventListener pOBBidEventListener) {
            POBNativeAdManager.this.h = POBDataType.POBAdState.BID_FAILED;
            POBLog.info("POBNativeAdManager", POBLogConstants.MSG_FMT_BID_EVENT_ERROR, pOBError.getErrorMessage());
            pOBBidEventListener.onBidFailed(POBNativeAdManager.this, pOBError);
        }

        @Override // com.pubmatic.sdk.common.base.POBBidderListener
        public void onBidsFailed(POBBidding pOBBidding, POBError pOBError) {
            POBLog.error("POBNativeAdManager", POBLogConstants.MSG_DEBUG_BIDS_FAILED, pOBError.getErrorMessage());
            if (POBNativeAdManager.this.g != null) {
                a(pOBError, POBNativeAdManager.this.g);
            } else if (POBNativeAdManager.this.c instanceof POBDefaultNativeEventHandler.POBDefaultNativeAdEventBridge) {
                POBNativeAdManager.this.a(pOBError);
            } else {
                POBNativeAdManager.this.a((POBBid) null);
            }
        }

        @Override // com.pubmatic.sdk.common.base.POBBidderListener
        public void onBidsFetched(POBBidding pOBBidding, POBAdResponse pOBAdResponse) {
            POBBid pOBBid;
            if (((POBBid) pOBAdResponse.getWinningBid()) != null) {
                POBAdResponse.Builder builderUpdateWithRefreshIntervalAndExpiryTimeout = new POBAdResponse.Builder(pOBAdResponse).updateWithRefreshIntervalAndExpiryTimeout("native");
                POBNativeAdManager.this.f = builderUpdateWithRefreshIntervalAndExpiryTimeout.build();
                pOBBid = (POBBid) POBNativeAdManager.this.f.getWinningBid();
            } else {
                pOBBid = null;
            }
            if (pOBBid != null) {
                POBLog.debug("POBNativeAdManager", POBLogConstants.MSG_DEBUG_BIDS_FETCHED, pOBBid.getImpressionId(), Double.valueOf(pOBBid.getPrice()));
                if (pOBBid.getRawBid() != null) {
                    POBInstanceProvider.getCacheManager(POBNativeAdManager.this.f7685a).saveReceivedBid(pOBBid.getRawBid());
                }
            }
            if (POBNativeAdManager.this.g == null) {
                POBNativeAdManager.this.a(pOBBid);
                return;
            }
            if (pOBBid == null || pOBBid.getStatus() != 1) {
                a(new POBError(1002, "No ads available"), POBNativeAdManager.this.g);
                return;
            }
            POBNativeAdManager.this.h = POBDataType.POBAdState.BID_RECEIVED;
            POBLog.debug("POBNativeAdManager", POBLogConstants.MSG_BID_EVENT_SHARING_BIDS, new Object[0]);
            POBNativeAdManager.this.g.onBidReceived(POBNativeAdManager.this, pOBBid);
        }
    }

    interface c {
        void onBidFailure(POBNativeAdManager pOBNativeAdManager);
    }

    public POBNativeAdManager(Context context, POBNativeTemplateType pOBNativeTemplateType, POBNativeAdEventBridge pOBNativeAdEventBridge) {
        this.f7685a = context;
        this.b = pOBNativeTemplateType;
        this.c = pOBNativeAdEventBridge;
        pOBNativeAdEventBridge.setSignalingEventListener(this);
    }

    @Override // com.pubmatic.sdk.openwrap.core.POBBidEvent
    public POBBid getBid() {
        return POBBiddingManager.getWinningBid(this.f);
    }

    @Override // com.pubmatic.sdk.common.POBAdServerSignalingEventListener
    public POBBidsProvider getBidsProvider() {
        return this.f;
    }

    public void loadAd(POBRequest pOBRequest, POBProfileInfo pOBProfileInfo) {
        a(pOBRequest, pOBProfileInfo).requestBid();
    }

    @Override // com.pubmatic.sdk.common.POBAdServerSignalingEventListener
    public void onAdServerWin() {
        a((POBNativeAdResponse) null);
    }

    @Override // com.pubmatic.sdk.common.POBAdServerSignalingEventListener
    public void onFailed(POBError pOBError) {
        a(pOBError);
    }

    @Override // com.pubmatic.sdk.common.POBAdServerSignalingEventListener
    public void onOpenWrapPartnerWin(String str) {
        POBAdResponse pOBAdResponse = this.f;
        if (pOBAdResponse != null) {
            POBBid pOBBid = (POBBid) pOBAdResponse.getBid(str);
            if (pOBBid == null) {
                POBLog.debug("POBNativeAdManager", "bidId is invalid in onOpenWrapPartnerWin", new Object[0]);
            } else if (pOBBid != this.f.getWinningBid()) {
                POBAdResponse.Builder builder = new POBAdResponse.Builder(this.f);
                builder.updateWinningBid(pOBBid);
                this.f = builder.build();
            }
            a();
        }
    }

    @Override // com.pubmatic.sdk.openwrap.core.POBBidEvent
    public void proceedOnError(POBBidEvent.BidEventError bidEventError, String str) {
        if (this.g == null) {
            POBLog.warn("POBNativeAdManager", POBLogConstants.WARN_MSG_BID_EVENT_NOT_IMPLEMENTED, new Object[0]);
            return;
        }
        POBDataType.POBAdState pOBAdState = this.h;
        if (pOBAdState != POBDataType.POBAdState.BID_RECEIVED && pOBAdState != POBDataType.POBAdState.BID_FAILED) {
            POBLog.warn("POBNativeAdManager", POBLogConstants.MSG_NATIVE_AD_PROCEED_WARNING, new Object[0]);
            return;
        }
        POBLog.info("POBNativeAdManager", POBLogConstants.INFO_MSG_BID_EVENT_PROCEED_ON_ERROR, new Object[0]);
        if (!(this.c instanceof POBDefaultNativeEventHandler.POBDefaultNativeAdEventBridge)) {
            b();
            return;
        }
        POBLog.info("POBNativeAdManager", POBVideoLogConstants.INFO_MSG_BID_EVENT_PROCEED_ON_ERROR_CODE_AND_MSG, bidEventError.toString(), str);
        this.h = POBDataType.POBAdState.DEFAULT;
        c cVar = this.i;
        if (cVar != null) {
            cVar.onBidFailure(this);
        }
    }

    @Override // com.pubmatic.sdk.openwrap.core.POBBidEvent
    public boolean proceedToLoadAd() {
        if (this.g == null) {
            POBLog.warn("POBNativeAdManager", POBLogConstants.WARN_MSG_BID_EVENT_NOT_IMPLEMENTED, new Object[0]);
            return false;
        }
        POBDataType.POBAdState pOBAdState = this.h;
        if (pOBAdState != POBDataType.POBAdState.BID_RECEIVED && pOBAdState != POBDataType.POBAdState.BID_FAILED) {
            POBLog.warn("POBNativeAdManager", POBLogConstants.MSG_NATIVE_AD_PROCEED_WARNING, new Object[0]);
            return false;
        }
        POBLog.info("POBNativeAdManager", POBLogConstants.INFO_MSG_BID_EVENT_PROCEED_TO_LOAD, new Object[0]);
        POBBid winningBid = POBBiddingManager.getWinningBid(this.f);
        if (winningBid == null || !winningBid.isExpired()) {
            POBLog.debug("POBNativeAdManager", POBLogConstants.MSG_PROCEEDING_WITH_BID, new Object[0]);
            a(winningBid);
            return true;
        }
        POBLog.info("POBNativeAdManager", POBVideoLogConstants.MSG_BID_EXPIRED, new Object[0]);
        POBError pOBErrorConvertToPOBError = POBBidEventHelper.convertToPOBError(POBBidEvent.BidEventError.BID_EXPIRED);
        if (this.c instanceof POBDefaultNativeEventHandler.POBDefaultNativeAdEventBridge) {
            a(pOBErrorConvertToPOBError);
            return false;
        }
        POBLog.warn("POBNativeAdManager", POBLogConstants.MSG_AD_EXPIRED_PROCEEDING_IGNORING_OPENWRAP_BID, new Object[0]);
        b();
        return true;
    }

    @Override // com.pubmatic.sdk.openwrap.core.POBBidEvent
    public void setBidEventListener(POBBidEventListener pOBBidEventListener) {
        this.g = pOBBidEventListener;
    }

    public void setListener(POBNativeAdManagerListener pOBNativeAdManagerListener) {
        this.d = pOBNativeAdManagerListener;
    }

    private void b(POBError pOBError) {
        POBLog.error("POBNativeAdManager", POBLogConstants.MSG_FAILED_TO_LOAD + pOBError, new Object[0]);
        POBNativeAdManagerListener pOBNativeAdManagerListener = this.d;
        if (pOBNativeAdManagerListener != null) {
            pOBNativeAdManagerListener.onFailedToLoad(this, pOBError);
        }
    }

    private void b() {
        if (this.f != null) {
            this.f = new POBAdResponse.Builder(this.f).setWinningBid(null).build();
        }
        POBLog.info("POBNativeAdManager", "Proceeding with bid. Ad server integration is " + this.c.getClass().getSimpleName(), new Object[0]);
        a((POBBid) null);
    }

    void a(c cVar) {
        this.i = cVar;
    }

    private POBBidding a(POBRequest pOBRequest, POBProfileInfo pOBProfileInfo) {
        if (this.e == null) {
            this.e = new POBBiddingManager(POBOWPartnerHelper.createPOBManager(this.f7685a, pOBRequest, pOBProfileInfo));
            this.e.setBidderListener(new b());
        }
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(POBError pOBError) {
        this.h = POBDataType.POBAdState.DEFAULT;
        b(pOBError);
    }

    private void a(POBNativeAdResponse pOBNativeAdResponse) {
        this.h = POBDataType.POBAdState.DEFAULT;
        POBNativeAdProvider pOBNativeAdProvider = new POBNativeAdProvider(this.f7685a, this.b, this.c);
        POBAdResponse pOBAdResponse = this.f;
        if (pOBAdResponse != null) {
            pOBNativeAdProvider.setBid((POBBid) pOBAdResponse.getWinningBid());
        }
        pOBNativeAdProvider.setNativeAdResponse(pOBNativeAdResponse);
        POBNativeAdManagerListener pOBNativeAdManagerListener = this.d;
        if (pOBNativeAdManagerListener != null) {
            pOBNativeAdManagerListener.onAdReceived(this, pOBNativeAdProvider);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(POBBid pOBBid) {
        Trace.endSection();
        this.h = POBDataType.POBAdState.LOADING;
        this.c.requestAd(pOBBid);
    }

    private void a() {
        POBError pOBError;
        POBBid winningBid = POBBiddingManager.getWinningBid(this.f);
        if (winningBid != null) {
            winningBid.setHasWon(true);
            POBNativeAdParser pOBNativeAdParser = new POBNativeAdParser();
            String renderableContent = winningBid.getRenderableContent();
            if (renderableContent != null) {
                try {
                    a(pOBNativeAdParser.parseNativeAdResponse(renderableContent));
                    return;
                } catch (Exception e) {
                    pOBError = new POBError(1007, String.format(POBNativeLogConstants.NATIVE_INVALID_RESPONSE, e.getMessage()));
                }
            } else {
                pOBError = new POBError(1007, POBNativeLogConstants.NATIVE_EMPTY_RESPONSE);
            }
        } else {
            pOBError = new POBError(1006, POBLogConstants.MSG_INTERNAL_NATIVE_ERROR);
        }
        a(pOBError);
    }
}
