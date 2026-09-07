package com.pubmatic.sdk.openwrap.core;

import com.pubmatic.sdk.common.POBError;
import com.pubmatic.sdk.common.base.POBBaseBidder;
import com.pubmatic.sdk.common.base.POBBidderListener;
import com.pubmatic.sdk.common.base.POBBidderResult;
import com.pubmatic.sdk.common.base.POBBidding;
import com.pubmatic.sdk.common.models.POBAdResponse;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class POBBiddingManager extends POBBaseBidder<POBBid> implements POBBidderListener<POBBid> {
    private final POBBidding b;
    private POBAdResponse c;

    public POBBiddingManager(POBBidding<POBBid> pOBBidding) {
        this.b = pOBBidding;
        pOBBidding.setBidderListener(this);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type com.pubmatic.sdk.common.base.POBBidding to com.pubmatic.sdk.openwrap.core.POBBiddingManager for r6v1 'this'  com.pubmatic.sdk.common.base.POBBidding
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    private void a(com.pubmatic.sdk.common.base.POBBidding r7) {
        /*
            r6 = this;
            java.lang.String r0 = r7.getIdentifier()
            java.util.Map r7 = r7.getBidderResults()
            java.lang.Object r7 = r7.get(r0)
            com.pubmatic.sdk.common.base.POBBidderResult r7 = (com.pubmatic.sdk.common.base.POBBidderResult) r7
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            if (r7 == 0) goto L37
            com.pubmatic.sdk.common.network.POBNetworkResult r2 = r7.getNetworkResult()
            if (r2 == 0) goto L2a
            java.lang.String r2 = r2.toString()
            java.lang.Object[] r0 = new java.lang.Object[]{r0, r2}
            java.lang.String r2 = "POBBiddingManager"
            java.lang.String r3 = "Network result for bidder %s is : %s"
            com.pubmatic.sdk.common.log.POBLog.info(r2, r3, r0)
        L2a:
            com.pubmatic.sdk.common.models.POBAdResponse r7 = r7.getAdResponse()
            if (r7 == 0) goto L37
            java.util.List r7 = r7.getBids()
            r1.addAll(r7)
        L37:
            com.pubmatic.sdk.common.base.POBBidderListener<T extends com.pubmatic.sdk.common.base.POBAdDescriptor> r7 = r6.bidderListener
            if (r7 == 0) goto Laa
            boolean r7 = r1.isEmpty()
            if (r7 != 0) goto La7
            com.pubmatic.sdk.common.base.POBBidding r7 = r6.b
            com.pubmatic.sdk.common.models.POBAdResponse r7 = r7.getAdResponse()
            if (r7 == 0) goto L50
            com.pubmatic.sdk.common.base.POBBidding r7 = r6.b
            com.pubmatic.sdk.common.models.POBAdResponse r7 = r7.getAdResponse()
            goto L54
        L50:
            com.pubmatic.sdk.common.models.POBAdResponse r7 = com.pubmatic.sdk.common.models.POBAdResponse.defaultResponse()
        L54:
            java.util.List r0 = r7.getBids()
            boolean r7 = r7.isSendAllBidsEnabled()
            r2 = 0
            r3 = 0
            if (r7 == 0) goto L87
            java.util.Iterator r7 = r0.iterator()
        L64:
            boolean r4 = r7.hasNext()
            if (r4 == 0) goto L77
            java.lang.Object r4 = r7.next()
            com.pubmatic.sdk.openwrap.core.POBBid r4 = (com.pubmatic.sdk.openwrap.core.POBBid) r4
            boolean r5 = r4.isServerSideAuctionWinner()
            if (r5 == 0) goto L64
            r3 = r4
        L77:
            if (r3 != 0) goto L94
            boolean r7 = r0.isEmpty()
            if (r7 != 0) goto L94
            java.lang.Object r7 = r0.get(r2)
            r3 = r7
            com.pubmatic.sdk.openwrap.core.POBBid r3 = (com.pubmatic.sdk.openwrap.core.POBBid) r3
            goto L94
        L87:
            boolean r7 = r1.isEmpty()
            if (r7 != 0) goto L94
            java.lang.Object r7 = r1.get(r2)
            r3 = r7
            com.pubmatic.sdk.openwrap.core.POBBid r3 = (com.pubmatic.sdk.openwrap.core.POBBid) r3
        L94:
            if (r3 == 0) goto La0
            com.pubmatic.sdk.common.models.POBAdResponse r7 = r6.a(r3, r0)
            com.pubmatic.sdk.common.base.POBBidderListener<T extends com.pubmatic.sdk.common.base.POBAdDescriptor> r0 = r6.bidderListener
            r0.onBidsFetched(r6, r7)
            goto La3
        La0:
            r6.a()
        La3:
            r1.clear()
            goto Laa
        La7:
            r6.a()
        Laa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pubmatic.sdk.openwrap.core.POBBiddingManager.a(com.pubmatic.sdk.common.base.POBBidding):void");
    }

    public static POBBid getWinningBid(POBAdResponse<POBBid> pOBAdResponse) {
        if (pOBAdResponse != null) {
            return (POBBid) pOBAdResponse.getWinningBid();
        }
        return null;
    }

    @Override // com.pubmatic.sdk.common.base.POBBidding
    public void destroy() {
        this.b.destroy();
    }

    @Override // com.pubmatic.sdk.common.base.POBBidding
    public POBAdResponse<POBBid> getAdResponse() {
        return this.c;
    }

    @Override // com.pubmatic.sdk.common.base.POBBidding
    public Map<String, POBBidderResult<POBBid>> getBidderResults() {
        return this.b.getBidderResults();
    }

    @Override // com.pubmatic.sdk.common.base.POBBidderListener
    public void onBidsFailed(POBBidding<POBBid> pOBBidding, POBError pOBError) {
        a(pOBBidding);
    }

    @Override // com.pubmatic.sdk.common.base.POBBidderListener
    public void onBidsFetched(POBBidding<POBBid> pOBBidding, POBAdResponse<POBBid> pOBAdResponse) {
        a(pOBBidding);
    }

    @Override // com.pubmatic.sdk.common.base.POBBidding
    public void requestBid() {
        this.b.requestBid();
    }

    private POBAdResponse a(POBBid pOBBid, List list) {
        POBAdResponse.Builder builder = new POBAdResponse.Builder(list);
        builder.setWinningBid(pOBBid);
        POBAdResponse adResponse = this.b.getAdResponse();
        if (adResponse != null) {
            builder.setRefreshInterval(adResponse.getRefreshInterval());
            builder.setSendAllBidsState(adResponse.isSendAllBidsEnabled());
            builder.setNbrCode(adResponse.getNbrCode());
        } else {
            builder.setRefreshInterval(30);
        }
        builder.setServerSidePartnerBids(list);
        POBAdResponse pOBAdResponseBuild = builder.build();
        this.c = pOBAdResponseBuild;
        return pOBAdResponseBuild;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type com.pubmatic.sdk.common.base.POBBidding to com.pubmatic.sdk.openwrap.core.POBBiddingManager for r4v1 'this'  com.pubmatic.sdk.common.base.POBBidding
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    private void a() {
        /*
            r4 = this;
            com.pubmatic.sdk.common.base.POBBidding r0 = r4.b
            java.util.Map r0 = r0.getBidderResults()
            com.pubmatic.sdk.common.base.POBBidding r1 = r4.b
            java.lang.String r1 = r1.getIdentifier()
            java.lang.Object r0 = r0.get(r1)
            com.pubmatic.sdk.common.base.POBBidderResult r0 = (com.pubmatic.sdk.common.base.POBBidderResult) r0
            if (r0 == 0) goto L52
            com.pubmatic.sdk.common.models.POBAdResponse r1 = r0.getAdResponse()
            if (r1 == 0) goto L33
            java.lang.Integer r2 = r1.getNbrCode()
            if (r2 == 0) goto L33
            java.util.Locale r0 = java.util.Locale.getDefault()
            java.lang.Integer r1 = r1.getNbrCode()
            java.lang.Object[] r1 = new java.lang.Object[]{r1}
            java.lang.String r2 = "No ads available, reason(NBR): %s"
            java.lang.String r0 = java.lang.String.format(r0, r2, r1)
            goto L54
        L33:
            com.pubmatic.sdk.common.POBError r1 = r0.getError()
            if (r1 == 0) goto L52
            com.pubmatic.sdk.common.base.POBBidding r1 = r4.b
            java.lang.String r1 = r1.getIdentifier()
            com.pubmatic.sdk.common.POBError r0 = r0.getError()
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r0 = new java.lang.Object[]{r1, r0}
            java.lang.String r1 = " %s : %s"
            java.lang.String r0 = java.lang.String.format(r1, r0)
            goto L54
        L52:
            java.lang.String r0 = "No Ads available from any bidder"
        L54:
            com.pubmatic.sdk.common.base.POBBidderListener<T extends com.pubmatic.sdk.common.base.POBAdDescriptor> r1 = r4.bidderListener
            if (r1 == 0) goto L62
            com.pubmatic.sdk.common.POBError r2 = new com.pubmatic.sdk.common.POBError
            r3 = 1002(0x3ea, float:1.404E-42)
            r2.<init>(r3, r0)
            r1.onBidsFailed(r4, r2)
        L62:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pubmatic.sdk.openwrap.core.POBBiddingManager.a():void");
    }
}
