package com.pubmatic.sdk.openwrap.core;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.pubmatic.sdk.common.POBError;
import com.pubmatic.sdk.common.base.POBAdBuilding;
import com.pubmatic.sdk.common.base.POBBaseBidder;
import com.pubmatic.sdk.common.base.POBBidderListener;
import com.pubmatic.sdk.common.base.POBBidderResult;
import com.pubmatic.sdk.common.base.POBResponseParsing;
import com.pubmatic.sdk.common.models.POBAdResponse;
import com.pubmatic.sdk.openwrap.core.internal.POBBidsBuilder;
import com.pubmatic.sdk.openwrap.core.internal.POBResponseParser;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u00032\b\u0012\u0004\u0012\u00020\u00020\u0004B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u000f2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0016\u0010\u0013J!\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00180\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001c\u001a\u00020\u000f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u001d\u0010\"\u001a\u00020\u000f2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016¢\u0006\u0004\b\"\u0010\u001dR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u001e\u00101\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100¨\u00062"}, d2 = {"Lcom/pubmatic/sdk/openwrap/core/POBExtBidHandler;", "Lcom/pubmatic/sdk/common/base/POBBaseBidder;", "Lcom/pubmatic/sdk/openwrap/core/POBBid;", "Lcom/pubmatic/sdk/common/base/POBResponseParsing$POBResponseParserListener;", "Lcom/pubmatic/sdk/common/base/POBAdBuilding$POBAdBuilderListener;", "", "bidResponse", "<init>", "(Ljava/lang/String;)V", "Lcom/pubmatic/sdk/common/models/POBAdResponse;", "adDescriptor", "a", "(Lcom/pubmatic/sdk/common/models/POBAdResponse;)Lcom/pubmatic/sdk/common/models/POBAdResponse;", "Lcom/pubmatic/sdk/common/base/POBBidderListener;", "biddingListener", "", "setBidderListener", "(Lcom/pubmatic/sdk/common/base/POBBidderListener;)V", "requestBid", "()V", "getAdResponse", "()Lcom/pubmatic/sdk/common/models/POBAdResponse;", "destroy", "", "Lcom/pubmatic/sdk/common/base/POBBidderResult;", "getBidderResults", "()Ljava/util/Map;", "adResponse", "parserOnSuccess", "(Lcom/pubmatic/sdk/common/models/POBAdResponse;)V", "Lcom/pubmatic/sdk/common/POBError;", "error", "parserOnError", "(Lcom/pubmatic/sdk/common/POBError;)V", "adBuilderOnSuccess", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/String;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/pubmatic/sdk/common/base/POBBidderListener;", "Lcom/pubmatic/sdk/common/base/POBResponseParsing;", "d", "Lcom/pubmatic/sdk/common/base/POBResponseParsing;", "responseParsing", "Lcom/pubmatic/sdk/common/base/POBAdBuilding;", "e", "Lcom/pubmatic/sdk/common/base/POBAdBuilding;", "mAdBuilder", InneractiveMediationDefs.GENDER_FEMALE, "Lcom/pubmatic/sdk/common/models/POBAdResponse;", "finalResponse", "openwrapcore_release"}, k = 1, mv = {1, 7, 1})
public final class POBExtBidHandler extends POBBaseBidder<POBBid> implements POBResponseParsing.POBResponseParserListener<POBBid>, POBAdBuilding.POBAdBuilderListener<POBBid> {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final String bidResponse;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private POBBidderListener biddingListener;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final POBResponseParsing responseParsing;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final POBAdBuilding mAdBuilder;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private POBAdResponse finalResponse;

    public POBExtBidHandler(String bidResponse) {
        Intrinsics.checkNotNullParameter(bidResponse, "bidResponse");
        this.bidResponse = bidResponse;
        POBResponseParser pOBResponseParser = new POBResponseParser();
        this.responseParsing = pOBResponseParser;
        pOBResponseParser.setListener(this);
        POBBidsBuilder pOBBidsBuilder = new POBBidsBuilder();
        this.mAdBuilder = pOBBidsBuilder;
        pOBBidsBuilder.setListener(this);
        setIdentifier("EXT_BID_HANDLER");
    }

    private final POBAdResponse a(POBAdResponse adDescriptor) {
        List bids = adDescriptor.getBids();
        Intrinsics.checkNotNullExpressionValue(bids, "adDescriptor.bids");
        if (bids.isEmpty()) {
            return null;
        }
        POBBid pOBBid = (POBBid) adDescriptor.getBids().get(0);
        POBAdResponse.Builder builder = new POBAdResponse.Builder(adDescriptor.getBids());
        builder.setWinningBid(pOBBid);
        builder.setRefreshInterval(0);
        builder.setServerSidePartnerBids(adDescriptor.getBids());
        return builder.build();
    }

    @Override // com.pubmatic.sdk.common.base.POBAdBuilding.POBAdBuilderListener
    public void adBuilderOnSuccess(POBAdResponse<POBBid> adDescriptor) {
        Unit unit;
        Intrinsics.checkNotNullParameter(adDescriptor, "adDescriptor");
        POBAdResponse pOBAdResponseA = a(adDescriptor);
        this.finalResponse = pOBAdResponseA;
        if (pOBAdResponseA != null) {
            POBBidderListener pOBBidderListener = this.biddingListener;
            if (pOBBidderListener != null) {
                pOBBidderListener.onBidsFetched(this, pOBAdResponseA);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit != null) {
                return;
            }
        }
        POBBidderListener pOBBidderListener2 = this.biddingListener;
        if (pOBBidderListener2 != null) {
            pOBBidderListener2.onBidsFailed(this, new POBError(1002, "No ads available"));
            Unit unit2 = Unit.INSTANCE;
        }
    }

    @Override // com.pubmatic.sdk.common.base.POBBidding
    public void destroy() {
        this.bidderListener = null;
        this.finalResponse = null;
    }

    @Override // com.pubmatic.sdk.common.base.POBBidding
    public POBAdResponse<POBBid> getAdResponse() {
        return this.finalResponse;
    }

    @Override // com.pubmatic.sdk.common.base.POBBidding
    public Map<String, POBBidderResult<POBBid>> getBidderResults() {
        return new HashMap();
    }

    @Override // com.pubmatic.sdk.common.base.POBResponseParsing.POBResponseParserListener
    public void parserOnError(POBError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        POBBidderListener pOBBidderListener = this.biddingListener;
        if (pOBBidderListener != null) {
            pOBBidderListener.onBidsFailed(this, error);
        }
    }

    @Override // com.pubmatic.sdk.common.base.POBResponseParsing.POBResponseParserListener
    public void parserOnSuccess(POBAdResponse<POBBid> adResponse) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        this.mAdBuilder.build(new POBAdResponse.Builder(adResponse).build());
    }

    @Override // com.pubmatic.sdk.common.base.POBBidding
    public void requestBid() {
        try {
            this.responseParsing.parse(new JSONObject(this.bidResponse));
        } catch (JSONException e) {
            POBBidderListener pOBBidderListener = this.biddingListener;
            if (pOBBidderListener != null) {
                pOBBidderListener.onBidsFailed(this, new POBError(1007, e.toString()));
            }
        }
    }

    @Override // com.pubmatic.sdk.common.base.POBBaseBidder, com.pubmatic.sdk.common.base.POBBidding
    public void setBidderListener(POBBidderListener<POBBid> biddingListener) {
        this.biddingListener = biddingListener;
    }
}
