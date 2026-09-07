package com.chartboost.sdk.impl;

import android.content.Context;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import com.chartboost.sdk.Mediation;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001BÅ\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010*\u001a\u00020\u000b\u0012\u0006\u0010,\u001a\u00020+\u0012\u0006\u0010-\u001a\u00020\u000b\u0012\u0006\u0010/\u001a\u00020.\u0012\b\u00101\u001a\u0004\u0018\u000100\u0012\u0006\u00103\u001a\u000202\u0012\b\u00105\u001a\u0004\u0018\u000104\u0012\b\u00107\u001a\u0004\u0018\u000106\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u00109\u001a\u000208\u0012\u0006\u0010;\u001a\u00020:\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010=\u001a\u00020<\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0019\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\b\b\u0002\u0010$\u001a\u00020!\u0012\u0014\b\u0002\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020&0%¢\u0006\u0004\b>\u0010?J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R \u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020&0%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006@"}, d2 = {"Lcom/chartboost/sdk/impl/v1;", "Lcom/chartboost/sdk/impl/o2;", "Landroid/content/Context;", "context", "Lcom/chartboost/sdk/impl/vb;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Landroid/content/Context;)Lcom/chartboost/sdk/impl/vb;", "", "w", "()V", VastAttributes.HORIZONTAL_POSITION, "", "O", "Ljava/lang/String;", "baseUrl", "P", "html", "Lcom/chartboost/sdk/impl/s6;", "Q", "Lcom/chartboost/sdk/impl/s6;", "infoIcon", "Lcom/chartboost/sdk/impl/i6;", "R", "Lcom/chartboost/sdk/impl/i6;", "impressionInterface", "", ExifInterface.LATITUDE_SOUTH, "Ljava/util/List;", "scripts", "Lcom/chartboost/sdk/impl/m4;", "T", "Lcom/chartboost/sdk/impl/m4;", "eventTracker", "Lkotlinx/coroutines/CoroutineDispatcher;", "U", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lkotlin/Function1;", "Lcom/chartboost/sdk/impl/p2;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/jvm/functions/Function1;", "cbWebViewFactory", "location", "Lcom/chartboost/sdk/impl/d7;", "mtype", "adUnitParameters", "Lcom/chartboost/sdk/impl/f5;", "fileCache", "Lcom/chartboost/sdk/impl/g2;", "networkRequestService", "Lcom/chartboost/sdk/impl/sa;", "uiPoster", "Lcom/chartboost/sdk/impl/l2;", "templateProxy", "Lcom/chartboost/sdk/Mediation;", "mediation", "Lcom/chartboost/sdk/impl/s7;", "openMeasurementImpressionCallback", "Lcom/chartboost/sdk/impl/j0;", "adUnitRendererCallback", "Lcom/chartboost/sdk/impl/yb;", "webViewTimeoutInterface", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lcom/chartboost/sdk/impl/d7;Ljava/lang/String;Lcom/chartboost/sdk/impl/f5;Lcom/chartboost/sdk/impl/g2;Lcom/chartboost/sdk/impl/sa;Lcom/chartboost/sdk/impl/l2;Lcom/chartboost/sdk/Mediation;Ljava/lang/String;Ljava/lang/String;Lcom/chartboost/sdk/impl/s6;Lcom/chartboost/sdk/impl/s7;Lcom/chartboost/sdk/impl/j0;Lcom/chartboost/sdk/impl/i6;Lcom/chartboost/sdk/impl/yb;Ljava/util/List;Lcom/chartboost/sdk/impl/m4;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function1;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class v1 extends o2 {

    /* JADX INFO: renamed from: O, reason: from kotlin metadata */
    public final String baseUrl;

    /* JADX INFO: renamed from: P, reason: from kotlin metadata */
    public final String html;

    /* JADX INFO: renamed from: Q, reason: from kotlin metadata */
    public final s6 infoIcon;

    /* JADX INFO: renamed from: R, reason: from kotlin metadata */
    public final i6 impressionInterface;

    /* JADX INFO: renamed from: S, reason: from kotlin metadata */
    public final List<String> scripts;

    /* JADX INFO: renamed from: T, reason: from kotlin metadata */
    public final m4 eventTracker;

    /* JADX INFO: renamed from: U, reason: from kotlin metadata */
    public final CoroutineDispatcher dispatcher;

    /* JADX INFO: renamed from: V, reason: from kotlin metadata */
    public final Function1<Context, p2> cbWebViewFactory;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/content/Context;", "it", "Lcom/chartboost/sdk/impl/t1;", "a", "(Landroid/content/Context;)Lcom/chartboost/sdk/impl/t1;"}, k = 3, mv = {1, 8, 0})
    public static final class a extends Lambda implements Function1<Context, t1> {
        public static final a b = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final t1 invoke(Context it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new t1(it);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public v1(Context context, String location, d7 mtype, String adUnitParameters, f5 fileCache, g2 g2Var, sa uiPoster, l2 l2Var, Mediation mediation, String baseUrl, String str, s6 infoIcon, s7 openMeasurementImpressionCallback, j0 adUnitRendererCallback, i6 impressionInterface, yb webViewTimeoutInterface, List<String> scripts, m4 eventTracker, CoroutineDispatcher dispatcher, Function1<? super Context, ? extends p2> cbWebViewFactory) {
        super(context, location, mtype, adUnitParameters, uiPoster, fileCache, g2Var, l2Var, mediation, str, openMeasurementImpressionCallback, adUnitRendererCallback, webViewTimeoutInterface, eventTracker, null, 16384, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(mtype, "mtype");
        Intrinsics.checkNotNullParameter(adUnitParameters, "adUnitParameters");
        Intrinsics.checkNotNullParameter(fileCache, "fileCache");
        Intrinsics.checkNotNullParameter(uiPoster, "uiPoster");
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(infoIcon, "infoIcon");
        Intrinsics.checkNotNullParameter(openMeasurementImpressionCallback, "openMeasurementImpressionCallback");
        Intrinsics.checkNotNullParameter(adUnitRendererCallback, "adUnitRendererCallback");
        Intrinsics.checkNotNullParameter(impressionInterface, "impressionInterface");
        Intrinsics.checkNotNullParameter(webViewTimeoutInterface, "webViewTimeoutInterface");
        Intrinsics.checkNotNullParameter(scripts, "scripts");
        Intrinsics.checkNotNullParameter(eventTracker, "eventTracker");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(cbWebViewFactory, "cbWebViewFactory");
        this.baseUrl = baseUrl;
        this.html = str;
        this.infoIcon = infoIcon;
        this.impressionInterface = impressionInterface;
        this.scripts = scripts;
        this.eventTracker = eventTracker;
        this.dispatcher = dispatcher;
        this.cbWebViewFactory = cbWebViewFactory;
    }

    @Override // com.chartboost.sdk.impl.o2
    public vb b(Context context) {
        vb vbVar;
        Unit unit;
        Intrinsics.checkNotNullParameter(context, "context");
        String str = this.html;
        if (str == null || StringsKt.isBlank(str)) {
            b7.b("html must not be null or blank", null, 2, null);
            return null;
        }
        try {
            vbVar = null;
            try {
                o5 o5Var = new o5(context, this.baseUrl, this.html, this.infoIcon, this.eventTracker, getCustomWebViewInterface(), this.impressionInterface, this.dispatcher, this.cbWebViewFactory, null, 512, null);
                RelativeLayout webViewContainer = o5Var.getWebViewContainer();
                if (webViewContainer != null) {
                    o5Var.a(webViewContainer);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    b7.b("webViewContainer null when creating HtmlWebViewBase", null, 2, null);
                }
                return o5Var;
            } catch (Exception e) {
                e = e;
                vb vbVar2 = vbVar;
                c("Can't instantiate WebViewBase: " + e);
                return vbVar2;
            }
        } catch (Exception e2) {
            e = e2;
            vbVar = null;
        }
    }

    @Override // com.chartboost.sdk.impl.o2
    public void w() {
    }

    @Override // com.chartboost.sdk.impl.o2
    public void x() {
        p2 webView;
        super.x();
        this.impressionInterface.g();
        vb view = getView();
        if (view == null || (webView = view.getWebView()) == null) {
            return;
        }
        Iterator<T> it = this.scripts.iterator();
        while (it.hasNext()) {
            webView.evaluateJavascript((String) it.next(), null);
        }
    }

    public /* synthetic */ v1(Context context, String str, d7 d7Var, String str2, f5 f5Var, g2 g2Var, sa saVar, l2 l2Var, Mediation mediation, String str3, String str4, s6 s6Var, s7 s7Var, j0 j0Var, i6 i6Var, yb ybVar, List list, m4 m4Var, CoroutineDispatcher coroutineDispatcher, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, d7Var, str2, f5Var, g2Var, saVar, l2Var, mediation, str3, str4, s6Var, s7Var, j0Var, i6Var, ybVar, list, m4Var, (i & 262144) != 0 ? Dispatchers.getMain() : coroutineDispatcher, (i & 524288) != 0 ? a.b : function1);
    }
}
