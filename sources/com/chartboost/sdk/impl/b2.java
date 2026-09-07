package com.chartboost.sdk.impl;

import android.content.Context;
import com.chartboost.sdk.Mediation;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u008f\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u000e\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010!\u001a\u00020\u000e\u0012\u0006\u0010#\u001a\u00020\"\u0012\b\u0010%\u001a\u0004\u0018\u00010$\u0012\u0006\u0010'\u001a\u00020&\u0012\b\u0010)\u001a\u0004\u0018\u00010(\u0012\b\u0010+\u001a\u0004\u0018\u00010*\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u0010/\u001a\u00020.\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u00101\u001a\u000200\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001a¢\u0006\u0004\b2\u00103J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u00064"}, d2 = {"Lcom/chartboost/sdk/impl/b2;", "Lcom/chartboost/sdk/impl/o2;", "Landroid/content/Context;", "context", "Lcom/chartboost/sdk/impl/vb;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Landroid/content/Context;)Lcom/chartboost/sdk/impl/vb;", "", "w", "()V", "Lcom/chartboost/sdk/impl/ka;", "event", "track", "(Lcom/chartboost/sdk/impl/ka;)V", "", "O", "Ljava/lang/String;", "templateHtml", "Lcom/chartboost/sdk/impl/i6;", "P", "Lcom/chartboost/sdk/impl/i6;", "impressionInterface", "Lcom/chartboost/sdk/impl/g7;", "Q", "Lcom/chartboost/sdk/impl/g7;", "nativeBridgeCommand", "Lcom/chartboost/sdk/impl/m4;", "R", "Lcom/chartboost/sdk/impl/m4;", "eventTracker", "location", "Lcom/chartboost/sdk/impl/d7;", "mtype", "adUnitParameters", "Lcom/chartboost/sdk/impl/f5;", "fileCache", "Lcom/chartboost/sdk/impl/g2;", "networkRequestService", "Lcom/chartboost/sdk/impl/sa;", "uiPoster", "Lcom/chartboost/sdk/impl/l2;", "templateProxy", "Lcom/chartboost/sdk/Mediation;", "mediation", "Lcom/chartboost/sdk/impl/s7;", "openMeasurementImpressionCallback", "Lcom/chartboost/sdk/impl/j0;", "adUnitRendererCallback", "Lcom/chartboost/sdk/impl/yb;", "webViewTimeoutInterface", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lcom/chartboost/sdk/impl/d7;Ljava/lang/String;Lcom/chartboost/sdk/impl/f5;Lcom/chartboost/sdk/impl/g2;Lcom/chartboost/sdk/impl/sa;Lcom/chartboost/sdk/impl/l2;Lcom/chartboost/sdk/Mediation;Ljava/lang/String;Lcom/chartboost/sdk/impl/s7;Lcom/chartboost/sdk/impl/j0;Lcom/chartboost/sdk/impl/i6;Lcom/chartboost/sdk/impl/yb;Lcom/chartboost/sdk/impl/g7;Lcom/chartboost/sdk/impl/m4;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class b2 extends o2 {

    /* JADX INFO: renamed from: O, reason: from kotlin metadata */
    public final String templateHtml;

    /* JADX INFO: renamed from: P, reason: from kotlin metadata */
    public final i6 impressionInterface;

    /* JADX INFO: renamed from: Q, reason: from kotlin metadata */
    public final g7 nativeBridgeCommand;

    /* JADX INFO: renamed from: R, reason: from kotlin metadata */
    public final m4 eventTracker;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b2(Context context, String location, d7 mtype, String adUnitParameters, f5 fileCache, g2 g2Var, sa uiPoster, l2 l2Var, Mediation mediation, String str, s7 openMeasurementImpressionCallback, j0 adUnitRendererCallback, i6 impressionInterface, yb webViewTimeoutInterface, g7 nativeBridgeCommand, m4 eventTracker) {
        super(context, location, mtype, adUnitParameters, uiPoster, fileCache, g2Var, l2Var, mediation, str, openMeasurementImpressionCallback, adUnitRendererCallback, webViewTimeoutInterface, eventTracker, null, 16384, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(mtype, "mtype");
        Intrinsics.checkNotNullParameter(adUnitParameters, "adUnitParameters");
        Intrinsics.checkNotNullParameter(fileCache, "fileCache");
        Intrinsics.checkNotNullParameter(uiPoster, "uiPoster");
        Intrinsics.checkNotNullParameter(openMeasurementImpressionCallback, "openMeasurementImpressionCallback");
        Intrinsics.checkNotNullParameter(adUnitRendererCallback, "adUnitRendererCallback");
        Intrinsics.checkNotNullParameter(impressionInterface, "impressionInterface");
        Intrinsics.checkNotNullParameter(webViewTimeoutInterface, "webViewTimeoutInterface");
        Intrinsics.checkNotNullParameter(nativeBridgeCommand, "nativeBridgeCommand");
        Intrinsics.checkNotNullParameter(eventTracker, "eventTracker");
        this.templateHtml = str;
        this.impressionInterface = impressionInterface;
        this.nativeBridgeCommand = nativeBridgeCommand;
        this.eventTracker = eventTracker;
    }

    @Override // com.chartboost.sdk.impl.o2
    public vb b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.nativeBridgeCommand.a(this.impressionInterface);
        String str = this.templateHtml;
        if (str == null || StringsKt.isBlank(str)) {
            b7.b("templateHtml must not be null or blank", null, 2, null);
            return null;
        }
        try {
            return new f7(context, this.templateHtml, getCustomWebViewInterface(), this.impressionInterface, getBaseExternalPathURL(), this.nativeBridgeCommand, this.eventTracker, null, 128, null);
        } catch (Exception e) {
            c("Can't instantiate MraidWebViewBase: " + e);
            return null;
        }
    }

    @Override // com.chartboost.sdk.impl.o2, com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: track */
    public void mo4741track(ka event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.mo4741track(event);
    }

    @Override // com.chartboost.sdk.impl.o2
    public void w() {
    }
}
