package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.json.mediationsdk.c;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.model.NetworkSettings;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 %2\u00020\u0001:\u0001\u000bB\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u001a¢\u0006\u0004\b#\u0010$J,\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010\u000b\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\u0018\u0010\u000b\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H&J8\u0010\u000b\u001a\u00020\u00162\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001a\u0010\"\u001a\u00020\u001e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u000b\u0010!¨\u0006&"}, d2 = {"Lcom/ironsource/xv;", "", "Lcom/ironsource/m5;", "item", "Lcom/ironsource/j5;", "auctionData", "Lcom/ironsource/d0;", "adInstanceFactory", "Lcom/ironsource/h0;", "adInstancePayload", "Lcom/ironsource/a0;", "a", "", "message", "instanceName", "", "Lcom/ironsource/yv;", "waterfallFetcherListener", "", "waterfallItems", "", "adInstancePayloads", "Lcom/ironsource/zv;", "Lcom/ironsource/w2;", "Lcom/ironsource/w2;", "adTools", "Lcom/ironsource/w1;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/ironsource/w1;", "adUnitData", "Lcom/ironsource/xo;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/ironsource/xo;", "()Lcom/ironsource/xo;", "outcomeReporter", "<init>", "(Lcom/ironsource/w2;Lcom/ironsource/w1;)V", "d", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public abstract class xv {

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final w2 adTools;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final w1 adUnitData;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final xo outcomeReporter;

    /* JADX INFO: renamed from: com.ironsource.xv$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\n"}, d2 = {"Lcom/ironsource/xv$a;", "", "Lcom/ironsource/w2;", "adTools", "Lcom/ironsource/w1;", "adUnitData", "Lcom/ironsource/xv;", "a", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final xv a(w2 adTools, w1 adUnitData) {
            Intrinsics.checkNotNullParameter(adTools, "adTools");
            Intrinsics.checkNotNullParameter(adUnitData, "adUnitData");
            return adUnitData.t() ? new p5(adTools, adUnitData) : new fo(adTools, adUnitData);
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/ironsource/xv$b", "Lcom/ironsource/xo;", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements xo {
        b() {
        }
    }

    public xv(w2 adTools, w1 adUnitData) {
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(adUnitData, "adUnitData");
        this.adTools = adTools;
        this.adUnitData = adUnitData;
        this.outcomeReporter = new b();
    }

    private final a0 a(m5 item, j5 auctionData, d0 adInstanceFactory, h0 adInstancePayload) {
        String strC;
        String str;
        w1 w1Var = this.adUnitData;
        String strC2 = item.c();
        Intrinsics.checkNotNullExpressionValue(strC2, "item.instanceName");
        NetworkSettings networkSettingsA = w1Var.a(strC2);
        if (networkSettingsA == null) {
            strC = item.c();
            Intrinsics.checkNotNullExpressionValue(strC, "item.instanceName");
            str = "Could not find matching provider settings for auction response item";
        } else {
            if (adInstancePayload != null) {
                c.b().b(networkSettingsA, this.adUnitData.getAdProperties().getCom.ironsource.mediationsdk.impressionData.ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT java.lang.String(), this.adUnitData.getAdProperties().getAdId());
                int iF = this.adTools.f();
                w1 w1Var2 = this.adUnitData;
                return adInstanceFactory.a(new b0(w1Var2, networkSettingsA, auctionData, new c3(networkSettingsA, w1Var2.b(networkSettingsA), this.adUnitData.getAdProperties().getCom.ironsource.mediationsdk.impressionData.ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT java.lang.String()), item, iF), adInstancePayload);
            }
            strC = item.c();
            Intrinsics.checkNotNullExpressionValue(strC, "item.instanceName");
            str = "Could not find matching adInstancePayload for auction response item";
        }
        a(str, strC);
        return null;
    }

    private final void a(String message, String instanceName) {
        String str = message + " - item = " + instanceName;
        IronLog.INTERNAL.error(o1.a(this.adTools, str, (String) null, 2, (Object) null));
        this.adTools.getEventSender().getTroubleshoot().h(str);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public xo getOutcomeReporter() {
        return this.outcomeReporter;
    }

    public final zv a(List<? extends m5> waterfallItems, Map<String, h0> adInstancePayloads, j5 auctionData, d0 adInstanceFactory) {
        Intrinsics.checkNotNullParameter(waterfallItems, "waterfallItems");
        Intrinsics.checkNotNullParameter(adInstancePayloads, "adInstancePayloads");
        Intrinsics.checkNotNullParameter(auctionData, "auctionData");
        Intrinsics.checkNotNullParameter(adInstanceFactory, "adInstanceFactory");
        IronLog.INTERNAL.verbose(o1.a(this.adTools, "waterfall.size() = " + waterfallItems.size(), (String) null, 2, (Object) null));
        ArrayList arrayList = new ArrayList();
        int size = waterfallItems.size();
        for (int i = 0; i < size; i++) {
            m5 m5Var = waterfallItems.get(i);
            a0 a0VarA = a(m5Var, auctionData, adInstanceFactory, adInstancePayloads.get(m5Var.c()));
            if (a0VarA != null && a0VarA.g() != null) {
                arrayList.add(a0VarA);
            }
        }
        zv zvVar = new zv(arrayList);
        IronLog.INTERNAL.verbose(o1.a(this.adTools, "updateWaterfall() - next waterfall is " + zvVar + ".toWaterfallString()", (String) null, 2, (Object) null));
        return zvVar;
    }

    public abstract void a(d0 adInstanceFactory, yv waterfallFetcherListener);
}
