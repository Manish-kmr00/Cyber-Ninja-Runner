package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.json.environment.ContextProvider;
import com.json.mediationsdk.e;
import com.json.mediationsdk.f;
import com.json.mediationsdk.i;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.json.mediationsdk.utils.IronSourceUtils;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0012¢\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0018\u0010\u0007\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001d\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\t\u0010\u001c¨\u0006 "}, d2 = {"Lcom/ironsource/q5;", "", "Lcom/ironsource/q4;", b4.f, "Lcom/ironsource/r5;", "completionListener", "", "a", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "", "sessionDepth", "Lcom/ironsource/mediationsdk/i;", "", "message", "Lcom/ironsource/w2;", "Lcom/ironsource/w2;", "adTools", "Lcom/ironsource/w1;", "Lcom/ironsource/w1;", "adUnitData", "Lcom/ironsource/mediationsdk/e;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/ironsource/mediationsdk/e;", "auctionHandler", "Lcom/ironsource/d5;", "d", "Lcom/ironsource/d5;", "()Lcom/ironsource/d5;", "outcomeReporter", "<init>", "(Lcom/ironsource/w2;Lcom/ironsource/w1;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public class q5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final w2 adTools;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final w1 adUnitData;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final e auctionHandler;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final d5 outcomeReporter;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"com/ironsource/q5$a", "Lcom/ironsource/q4$d;", "Lcom/ironsource/q4;", b4.f, "", "a", "", "error", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements q4.d {
        final /* synthetic */ r5 b;

        a(r5 r5Var) {
            this.b = r5Var;
        }

        @Override // com.ironsource.q4.d
        public void a(q4 auction) {
            Intrinsics.checkNotNullParameter(auction, "auction");
            q5.this.b(auction, this.b);
        }

        @Override // com.ironsource.q4.d
        public void a(q4 auction, String error) {
            Intrinsics.checkNotNullParameter(auction, "auction");
            Intrinsics.checkNotNullParameter(error, "error");
            q5.this.b(auction, this.b);
        }
    }

    @Metadata(d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J^\u0010\u0012\u001a\u00020\u00112\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0016J0\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016¨\u0006\u0016"}, d2 = {"com/ironsource/q5$b", "Lcom/ironsource/s4;", "", "Lcom/ironsource/m5;", "newWaterfall", "", "auctionId", "genericNotifications", "Lorg/json/JSONObject;", "genericParams", "configurations", "", "auctionTrial", "", "elapsedTime", "troubleshootErrorCode", "troubleshootErrorMessage", "", "a", "errorCode", "errorMessage", IronSourceConstants.AUCTION_FALLBACK, "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements s4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ r5 f4186a;
        final /* synthetic */ q4 b;

        b(r5 r5Var, q4 q4Var) {
            this.f4186a = r5Var;
            this.b = q4Var;
        }

        @Override // com.json.s4
        public void a(int errorCode, String errorMessage, int auctionTrial, String auctionFallback, long elapsedTime) {
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            Intrinsics.checkNotNullParameter(auctionFallback, "auctionFallback");
            this.f4186a.a(errorCode, errorMessage, auctionTrial, auctionFallback, elapsedTime);
        }

        @Override // com.json.s4
        public void a(List<m5> newWaterfall, String auctionId, m5 genericNotifications, JSONObject genericParams, JSONObject configurations, int auctionTrial, long elapsedTime, int troubleshootErrorCode, String troubleshootErrorMessage) {
            Intrinsics.checkNotNullParameter(newWaterfall, "newWaterfall");
            Intrinsics.checkNotNullParameter(auctionId, "auctionId");
            this.f4186a.a(newWaterfall, this.b.c(), auctionId, genericNotifications, genericParams, configurations, auctionTrial, elapsedTime, troubleshootErrorCode, troubleshootErrorMessage);
        }
    }

    public q5(w2 adTools, w1 adUnitData) {
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(adUnitData, "adUnitData");
        this.adTools = adTools;
        this.adUnitData = adUnitData;
        o5 auctionSettings = adUnitData.getAuctionSettings();
        String sessionId = IronSourceUtils.getSessionId();
        Intrinsics.checkNotNullExpressionValue(sessionId, "getSessionId()");
        e eVar = new e(new f(auctionSettings, sessionId));
        this.auctionHandler = eVar;
        this.outcomeReporter = new d5(adTools, eVar);
    }

    private final i a(q4 auction, int sessionDepth) {
        i iVar = new i(this.adUnitData.getAdProperties().getCom.ironsource.mediationsdk.impressionData.ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT java.lang.String());
        iVar.b(IronSourceUtils.isEncryptedResponse());
        iVar.a(auction.getAuctionRequestData().a());
        iVar.a(auction.getAuctionRequestData().b());
        iVar.a(this.adTools.getAuctionHistory());
        iVar.a(sessionDepth);
        iVar.a(this.adTools.l());
        eu testSuiteLoadAdConfig = this.adUnitData.getAdProperties().getTestSuiteLoadAdConfig();
        iVar.e(testSuiteLoadAdConfig != null ? testSuiteLoadAdConfig.b() : false);
        g5 auctionRequestEnricher = this.adTools.getAuctionRequestEnricher();
        if (auctionRequestEnricher != null) {
            auctionRequestEnricher.a(iVar);
        }
        return iVar;
    }

    private final String a() {
        return o1.a(this.adTools, (String) null, (String) null, 2, (Object) null);
    }

    private final String a(String message) {
        return o1.a(this.adTools, message, (String) null, 2, (Object) null);
    }

    private final void a(q4 auction, r5 completionListener) {
        if (auction.f()) {
            auction.a(new a(completionListener));
        } else {
            b(auction, completionListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(q4 auction, r5 listener) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(a("auction waterfallString = " + ((Object) auction.getAuctionRequestData().getWaterfallString())));
        if (!auction.g()) {
            ironLog.verbose(a("auction failed - no candidates"));
            this.adTools.getEventSender().getCom.ironsource.b4.f java.lang.String().a(1005, "No candidates available for auctioning");
            listener.a(a2.e(this.adUnitData.getAdProperties().getCom.ironsource.mediationsdk.impressionData.ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT java.lang.String()), "no available ad to load");
        } else {
            this.adTools.getEventSender().getCom.ironsource.b4.f java.lang.String().b(auction.getAuctionRequestData().getWaterfallString().toString());
            this.auctionHandler.a(ContextProvider.getInstance().getApplicationContext(), a(auction, this.adTools.f()), new b(listener, auction));
        }
    }

    public void a(r5 completionListener) {
        Intrinsics.checkNotNullParameter(completionListener, "completionListener");
        IronLog.INTERNAL.verbose(a());
        this.adTools.getEventSender().getCom.ironsource.b4.f java.lang.String().a();
        a(new q4(this.adTools, this.adUnitData), completionListener);
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final d5 getOutcomeReporter() {
        return this.outcomeReporter;
    }
}
