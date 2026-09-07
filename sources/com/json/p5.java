package com.json;

import android.text.TextUtils;
import com.amazon.device.ads.DTBMetricsConfiguration;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.json.mediationsdk.d;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.utils.IronSourceConstants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010'\u001a\u00020$¢\u0006\u0004\b9\u0010:J\u0082\u0001\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\nH\u0002J@\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0018\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\u0019\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010\u000fH\u0002J\u0018\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u001a\u00100\u001a\u00020,8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b\u0019\u0010/R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107¨\u0006;"}, d2 = {"Lcom/ironsource/p5;", "Lcom/ironsource/xv;", "Lcom/ironsource/d0;", "adInstanceFactory", "Lcom/ironsource/yv;", "waterfallFetcherListener", "", "Lcom/ironsource/m5;", "newWaterfall", "", "", "Lcom/ironsource/h0;", "adInstancePayloads", "auctionId", "genericNotifications", "Lorg/json/JSONObject;", "genericParams", "configurations", "", "auctionTrial", "", "elapsedTime", "troubleshootErrorCode", "troubleshootErrorMessage", "", "a", "errorCode", "errorMessage", IronSourceConstants.AUCTION_FALLBACK, "Lcom/ironsource/zv;", "waterfallInstances", DTBMetricsConfiguration.CONFIG_DIR, "Lcom/ironsource/w2;", "e", "Lcom/ironsource/w2;", "adTools", "Lcom/ironsource/w1;", InneractiveMediationDefs.GENDER_FEMALE, "Lcom/ironsource/w1;", "adUnitData", "Lcom/ironsource/q5;", "g", "Lcom/ironsource/q5;", "auctioneer", "Lcom/ironsource/xo;", "h", "Lcom/ironsource/xo;", "()Lcom/ironsource/xo;", "outcomeReporter", "Lcom/ironsource/fo;", "i", "Lcom/ironsource/fo;", "fallbackWaterfallFetcher", "Lcom/ironsource/r5;", "j", "Lcom/ironsource/r5;", "completionListenerStrongReference", "<init>", "(Lcom/ironsource/w2;Lcom/ironsource/w1;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class p5 extends xv {

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final w2 adTools;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final w1 adUnitData;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final q5 auctioneer;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final xo outcomeReporter;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private final fo fallbackWaterfallFetcher;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private r5 completionListenerStrongReference;

    @Metadata(d1 = {"\u0000A\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001Jr\u0010\u0015\u001a\u00020\u00142\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0016J0\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0006H\u0016¨\u0006\u001a"}, d2 = {"com/ironsource/p5$a", "Lcom/ironsource/r5;", "", "Lcom/ironsource/m5;", "newWaterfall", "", "", "Lcom/ironsource/h0;", "adInstancePayloads", "auctionId", "genericNotifications", "Lorg/json/JSONObject;", "genericParams", "configurations", "", "auctionTrial", "", "elapsedTime", "troubleshootErrorCode", "troubleshootErrorMessage", "", "a", "errorCode", "errorMessage", IronSourceConstants.AUCTION_FALLBACK, "errorReason", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements r5 {
        final /* synthetic */ d0 b;
        final /* synthetic */ yv c;

        a(d0 d0Var, yv yvVar) {
            this.b = d0Var;
            this.c = yvVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(p5 this$0, d0 adInstanceFactory, yv waterfallFetcherListener, int i, String errorMessage, int i2, String auctionFallback, long j) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(adInstanceFactory, "$adInstanceFactory");
            Intrinsics.checkNotNullParameter(waterfallFetcherListener, "$waterfallFetcherListener");
            Intrinsics.checkNotNullParameter(errorMessage, "$errorMessage");
            Intrinsics.checkNotNullParameter(auctionFallback, "$auctionFallback");
            this$0.completionListenerStrongReference = null;
            this$0.a(adInstanceFactory, waterfallFetcherListener, i, errorMessage, i2, auctionFallback, j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(p5 this$0, d0 adInstanceFactory, yv waterfallFetcherListener, List newWaterfall, Map adInstancePayloads, String auctionId, m5 m5Var, JSONObject jSONObject, JSONObject jSONObject2, int i, long j, int i2, String str) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(adInstanceFactory, "$adInstanceFactory");
            Intrinsics.checkNotNullParameter(waterfallFetcherListener, "$waterfallFetcherListener");
            Intrinsics.checkNotNullParameter(newWaterfall, "$newWaterfall");
            Intrinsics.checkNotNullParameter(adInstancePayloads, "$adInstancePayloads");
            Intrinsics.checkNotNullParameter(auctionId, "$auctionId");
            this$0.completionListenerStrongReference = null;
            this$0.a(adInstanceFactory, waterfallFetcherListener, newWaterfall, adInstancePayloads, auctionId, m5Var, jSONObject, jSONObject2, i, j, i2, str);
        }

        @Override // com.json.r5
        public void a(int errorCode, String errorReason) {
            Intrinsics.checkNotNullParameter(errorReason, "errorReason");
            this.c.a(errorCode, errorReason);
        }

        @Override // com.json.r5
        public void a(final int errorCode, final String errorMessage, final int auctionTrial, final String auctionFallback, final long elapsedTime) {
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            Intrinsics.checkNotNullParameter(auctionFallback, "auctionFallback");
            w2 w2Var = p5.this.adTools;
            final p5 p5Var = p5.this;
            final d0 d0Var = this.b;
            final yv yvVar = this.c;
            w2Var.a(new Runnable() { // from class: com.ironsource.p5$a$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    p5.a.a(p5Var, d0Var, yvVar, errorCode, errorMessage, auctionTrial, auctionFallback, elapsedTime);
                }
            });
        }

        @Override // com.json.r5
        public void a(final List<m5> newWaterfall, final Map<String, h0> adInstancePayloads, final String auctionId, final m5 genericNotifications, final JSONObject genericParams, final JSONObject configurations, final int auctionTrial, final long elapsedTime, final int troubleshootErrorCode, final String troubleshootErrorMessage) {
            Intrinsics.checkNotNullParameter(newWaterfall, "newWaterfall");
            Intrinsics.checkNotNullParameter(adInstancePayloads, "adInstancePayloads");
            Intrinsics.checkNotNullParameter(auctionId, "auctionId");
            w2 w2Var = p5.this.adTools;
            final p5 p5Var = p5.this;
            final d0 d0Var = this.b;
            final yv yvVar = this.c;
            w2Var.a(new Runnable() { // from class: com.ironsource.p5$a$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    p5.a.a(p5Var, d0Var, yvVar, newWaterfall, adInstancePayloads, auctionId, genericNotifications, genericParams, configurations, auctionTrial, elapsedTime, troubleshootErrorCode, troubleshootErrorMessage);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p5(w2 adTools, w1 adUnitData) {
        super(adTools, adUnitData);
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(adUnitData, "adUnitData");
        this.adTools = adTools;
        this.adUnitData = adUnitData;
        q5 q5Var = new q5(adTools, adUnitData);
        this.auctioneer = q5Var;
        this.outcomeReporter = q5Var.getOutcomeReporter();
        this.fallbackWaterfallFetcher = new fo(adTools, adUnitData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(d0 adInstanceFactory, yv waterfallFetcherListener, int errorCode, String errorMessage, int auctionTrial, String auctionFallback, long elapsedTime) {
        IronLog.INTERNAL.verbose(o1.a(this.adTools, "Auction failed | moving to fallback waterfall (error " + errorCode + " - " + errorMessage + ')', (String) null, 2, (Object) null));
        this.adTools.getEventSender().getCom.ironsource.b4.f java.lang.String().a(elapsedTime, errorCode, errorMessage);
        this.fallbackWaterfallFetcher.a(waterfallFetcherListener, auctionTrial, auctionFallback, adInstanceFactory);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(d0 adInstanceFactory, yv waterfallFetcherListener, List<m5> newWaterfall, Map<String, h0> adInstancePayloads, String auctionId, m5 genericNotifications, JSONObject genericParams, JSONObject configurations, int auctionTrial, long elapsedTime, int troubleshootErrorCode, String troubleshootErrorMessage) {
        IronLog.INTERNAL.verbose(o1.a(this.adTools, (String) null, (String) null, 3, (Object) null));
        j5 j5Var = new j5(auctionId, genericParams, genericNotifications, auctionTrial, "");
        if (!TextUtils.isEmpty(troubleshootErrorMessage)) {
            this.adTools.getEventSender().getTroubleshoot().a(troubleshootErrorCode, troubleshootErrorMessage);
        }
        a(configurations);
        zv zvVarA = a(newWaterfall, adInstancePayloads, j5Var, adInstanceFactory);
        this.adTools.getEventSender().a(new u4(j5Var));
        this.adTools.getEventSender().getCom.ironsource.b4.f java.lang.String().a(elapsedTime, this.adUnitData.v());
        this.adTools.getEventSender().getCom.ironsource.b4.f java.lang.String().c(zvVarA.d());
        a(zvVarA, waterfallFetcherListener);
    }

    private final void a(zv waterfallInstances, yv waterfallFetcherListener) {
        this.adTools.getAuctionHistory().a(waterfallInstances);
        waterfallFetcherListener.a(waterfallInstances);
    }

    private final void a(JSONObject config) {
        int i;
        try {
            if (config == null) {
                this.adUnitData.b(false);
                IronLog.INTERNAL.verbose(o1.a(this.adTools, "loading configuration from auction response is null, using the following: " + this.adUnitData.v(), (String) null, 2, (Object) null));
                return;
            }
            try {
                if (config.has(d.x) && (i = config.getInt(d.x)) > 0) {
                    this.adUnitData.a(i);
                }
                if (config.has(d.y)) {
                    this.adUnitData.a(config.getBoolean(d.y));
                }
                this.adUnitData.b(config.optBoolean(d.z, false));
                IronLog.INTERNAL.verbose(o1.a(this.adTools, this.adUnitData.v(), (String) null, 2, (Object) null));
            } catch (JSONException e) {
                o9.d().a(e);
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.error("failed to update loading configuration for" + this.adUnitData.getAdProperties().getCom.ironsource.mediationsdk.impressionData.ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT java.lang.String() + " Error: " + e.getMessage());
                ironLog.verbose(o1.a(this.adTools, this.adUnitData.v(), (String) null, 2, (Object) null));
            }
        } catch (Throwable th) {
            IronLog.INTERNAL.verbose(o1.a(this.adTools, this.adUnitData.v(), (String) null, 2, (Object) null));
            throw th;
        }
    }

    @Override // com.json.xv
    /* JADX INFO: renamed from: a, reason: from getter */
    public xo getOutcomeReporter() {
        return this.outcomeReporter;
    }

    @Override // com.json.xv
    public void a(d0 adInstanceFactory, yv waterfallFetcherListener) {
        Intrinsics.checkNotNullParameter(adInstanceFactory, "adInstanceFactory");
        Intrinsics.checkNotNullParameter(waterfallFetcherListener, "waterfallFetcherListener");
        a aVar = new a(adInstanceFactory, waterfallFetcherListener);
        this.auctioneer.a(aVar);
        this.completionListenerStrongReference = aVar;
    }
}
