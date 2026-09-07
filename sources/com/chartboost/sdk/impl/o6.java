package com.chartboost.sdk.impl;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.chartboost.sdk.internal.Model.CBError;
import com.chartboost.sdk.view.CBImpressionActivity;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.json.ug;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010+\u001a\u00020)\u0012\u0006\u0010.\u001a\u00020,\u0012\u0006\u00101\u001a\u00020/\u0012\b\u0010=\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u00104\u001a\u000202\u0012\u0006\u00107\u001a\u000205\u0012\u0006\u0010:\u001a\u000208¢\u0006\u0004\bF\u0010GJ\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\tJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000bJ\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\tJ\u000f\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u000bJ\u0017\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\tJ\u000f\u0010\u0014\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u000bJ\u000f\u0010\u0015\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u0017\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0014\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001b\u0010\u0016J\u000f\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0016J\u000f\u0010\u001c\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001c\u0010\u0016J\u000f\u0010\u001d\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001d\u0010\u0016J\u001f\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\u0014\u0010\"J\u0019\u0010\u0014\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0014\u0010$J\u001f\u0010\u0014\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b\u0014\u0010'J\u0017\u0010\u0014\u001a\u00020\u00072\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b\u0014\u0010(R\u0014\u0010+\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010*R\u0014\u0010.\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010-R\u0014\u00101\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u00100R\u0014\u00104\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u00103R\u0014\u00107\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u00106R\u0014\u0010:\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u00109R\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00020;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010<R\u0016\u0010?\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010>R\u0016\u0010A\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010>R\"\u0010B\u001a\u00020\u00058\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010>\u001a\u0004\b@\u0010\u000b\"\u0004\b\u0014\u0010\tR\u0016\u0010C\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010>R\u0016\u0010D\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010>R\u0016\u0010E\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010>¨\u0006H"}, d2 = {"Lcom/chartboost/sdk/impl/o6;", "Lcom/chartboost/sdk/impl/q6;", "Landroid/view/ViewGroup;", "o", "()Landroid/view/ViewGroup;", "", VastAttributes.VISIBLE, "", "d", "(Z)V", "h", "()Z", "showProcessed", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "m", "showSent", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, CampaignEx.JSON_KEY_AD_K, "impressionClose", "e", "a", "j", "()V", "n", "Lcom/chartboost/sdk/internal/Model/CBError$b;", "error", "(Lcom/chartboost/sdk/internal/Model/CBError$b;)V", "g", InneractiveMediationDefs.GENDER_FEMALE, "l", "Lcom/chartboost/sdk/impl/l6;", "state", "Lcom/chartboost/sdk/view/CBImpressionActivity;", "activity", "(Lcom/chartboost/sdk/impl/l6;Lcom/chartboost/sdk/view/CBImpressionActivity;)V", "hostView", "(Landroid/view/ViewGroup;)V", "Landroid/view/View;", "adView", "(Landroid/view/ViewGroup;Landroid/view/View;)V", "(Lcom/chartboost/sdk/view/CBImpressionActivity;)V", "Lcom/chartboost/sdk/impl/y0;", "Lcom/chartboost/sdk/impl/y0;", "appRequest", "Lcom/chartboost/sdk/impl/o2;", "Lcom/chartboost/sdk/impl/o2;", "viewProtocol", "Lcom/chartboost/sdk/impl/g4;", "Lcom/chartboost/sdk/impl/g4;", "downloader", "Lcom/chartboost/sdk/impl/j0;", "Lcom/chartboost/sdk/impl/j0;", "adUnitRendererImpressionCallback", "Lcom/chartboost/sdk/impl/j6;", "Lcom/chartboost/sdk/impl/j6;", "impressionIntermediateCallback", "Lcom/chartboost/sdk/impl/x5;", "Lcom/chartboost/sdk/impl/x5;", "impressionClickCallback", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "bannerView", "Z", ug.k, "i", "isShowProcessed", "wasImpressionSignaled", "isPaused", "isVideoShowSent", "impressionClosed", "<init>", "(Lcom/chartboost/sdk/impl/y0;Lcom/chartboost/sdk/impl/o2;Lcom/chartboost/sdk/impl/g4;Landroid/view/ViewGroup;Lcom/chartboost/sdk/impl/j0;Lcom/chartboost/sdk/impl/j6;Lcom/chartboost/sdk/impl/x5;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class o6 implements q6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final y0 appRequest;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final o2 viewProtocol;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final g4 downloader;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final j0 adUnitRendererImpressionCallback;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final j6 impressionIntermediateCallback;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final x5 impressionClickCallback;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final WeakReference<ViewGroup> bannerView;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public boolean isVisible;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public boolean isShowProcessed;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public boolean wasImpressionSignaled;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public boolean isPaused;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public boolean isVideoShowSent;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public boolean impressionClosed;

    public o6(y0 appRequest, o2 viewProtocol, g4 downloader, ViewGroup viewGroup, j0 adUnitRendererImpressionCallback, j6 impressionIntermediateCallback, x5 impressionClickCallback) {
        Intrinsics.checkNotNullParameter(appRequest, "appRequest");
        Intrinsics.checkNotNullParameter(viewProtocol, "viewProtocol");
        Intrinsics.checkNotNullParameter(downloader, "downloader");
        Intrinsics.checkNotNullParameter(adUnitRendererImpressionCallback, "adUnitRendererImpressionCallback");
        Intrinsics.checkNotNullParameter(impressionIntermediateCallback, "impressionIntermediateCallback");
        Intrinsics.checkNotNullParameter(impressionClickCallback, "impressionClickCallback");
        this.appRequest = appRequest;
        this.viewProtocol = viewProtocol;
        this.downloader = downloader;
        this.adUnitRendererImpressionCallback = adUnitRendererImpressionCallback;
        this.impressionIntermediateCallback = impressionIntermediateCallback;
        this.impressionClickCallback = impressionClickCallback;
        this.bannerView = new WeakReference<>(viewGroup);
    }

    @Override // com.chartboost.sdk.impl.q6
    /* JADX INFO: renamed from: i, reason: from getter */
    public boolean getWasImpressionSignaled() {
        return this.wasImpressionSignaled;
    }

    @Override // com.chartboost.sdk.impl.q6
    public ViewGroup o() {
        return this.bannerView.get();
    }

    @Override // com.chartboost.sdk.impl.q6
    public void d(boolean visible) {
        this.isVisible = visible;
    }

    @Override // com.chartboost.sdk.impl.q6
    /* JADX INFO: renamed from: h, reason: from getter */
    public boolean getIsVisible() {
        return this.isVisible;
    }

    @Override // com.chartboost.sdk.impl.q6
    public void b(boolean showProcessed) {
        this.isShowProcessed = showProcessed;
    }

    @Override // com.chartboost.sdk.impl.q6
    /* JADX INFO: renamed from: m, reason: from getter */
    public boolean getIsShowProcessed() {
        return this.isShowProcessed;
    }

    @Override // com.chartboost.sdk.impl.q6
    /* JADX INFO: renamed from: k, reason: from getter */
    public boolean getIsVideoShowSent() {
        return this.isVideoShowSent;
    }

    public void e(boolean impressionClose) {
        this.impressionClosed = impressionClose;
    }

    @Override // com.chartboost.sdk.impl.q6
    public void j() {
        this.adUnitRendererImpressionCallback.v();
    }

    @Override // com.chartboost.sdk.impl.q6
    public void n() {
        this.adUnitRendererImpressionCallback.a(this.appRequest);
    }

    @Override // com.chartboost.sdk.impl.q6
    public void g() {
        this.impressionClickCallback.a(false);
    }

    @Override // com.chartboost.sdk.impl.q6
    public void c() {
        this.impressionClickCallback.a(false);
        if (this.isPaused) {
            this.isPaused = false;
            this.viewProtocol.z();
        }
    }

    @Override // com.chartboost.sdk.impl.q6
    public void f() {
        if (this.isPaused) {
            return;
        }
        this.isPaused = true;
        this.viewProtocol.y();
    }

    @Override // com.chartboost.sdk.impl.q6
    public void l() {
        if (getImpressionClosed()) {
            return;
        }
        e(true);
        if (getIsVideoShowSent()) {
            this.impressionIntermediateCallback.e();
        } else {
            a(CBError.b.INTERNAL);
        }
        this.viewProtocol.a(db.SKIP);
        this.impressionIntermediateCallback.h();
        this.viewProtocol.C();
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 8, 0})
    public static final class a extends Lambda implements Function0<Unit> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }

        public final void a() {
            b7.b("Cannot display on host because view was not created!", null, 2, null);
            o6.this.a(CBError.b.ERROR_CREATING_VIEW);
        }
    }

    public final void a(ViewGroup hostView, View adView) {
        Unit unit;
        Context context;
        this.impressionIntermediateCallback.a(l6.DISPLAYED);
        vb view = this.viewProtocol.getView();
        if (view == null || (context = view.getContext()) == null) {
            unit = null;
        } else {
            this.adUnitRendererImpressionCallback.a(context);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            b7.b("Missing context on onImpressionViewCreated", null, 2, null);
        }
        hostView.addView(adView);
        this.downloader.a();
    }

    @Override // com.chartboost.sdk.impl.q6
    public void a(l6 state, CBImpressionActivity activity) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (state != l6.LOADING) {
            a(activity);
        } else {
            b7.a("displayOnActivity invalid state: " + state, (Throwable) null, 2, (Object) null);
        }
    }

    @Override // com.chartboost.sdk.impl.q6
    public void c(boolean showSent) {
        this.isVideoShowSent = showSent;
    }

    public final void a(CBImpressionActivity activity) {
        this.impressionIntermediateCallback.a(l6.DISPLAYED);
        try {
            CBError.b bVarA = this.viewProtocol.a(activity);
            if (bVarA != null) {
                a(bVarA);
            } else {
                b7.c("Displaying the impression", null, 2, null);
            }
        } catch (Exception e) {
            b7.b("Cannot create view in protocol", e);
            a(CBError.b.ERROR_CREATING_VIEW);
        }
    }

    @Override // com.chartboost.sdk.impl.q6
    public void a(ViewGroup hostView) {
        try {
            if (hostView == null) {
                b7.b("Cannot display on host because it is null!", null, 2, null);
                a(CBError.b.ERROR_DISPLAYING_VIEW);
                return;
            }
            CBError.b bVarA = this.viewProtocol.a(hostView);
            if (bVarA != null) {
                b7.b("displayOnHostView tryCreatingViewOnHostView error " + bVarA, null, 2, null);
                a(bVarA);
                return;
            }
            vb view = this.viewProtocol.getView();
            if (view != null) {
                a(hostView, view);
                Unit unit = Unit.INSTANCE;
            } else {
                new a();
            }
        } catch (Exception e) {
            b7.b("displayOnHostView e", e);
            a(CBError.b.ERROR_CREATING_VIEW);
        }
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public boolean getImpressionClosed() {
        return this.impressionClosed;
    }

    @Override // com.chartboost.sdk.impl.q6
    public void a(CBError.b error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.isVideoShowSent = true;
        this.adUnitRendererImpressionCallback.a(this.appRequest, error);
    }

    @Override // com.chartboost.sdk.impl.q6
    public void a(boolean z) {
        this.wasImpressionSignaled = z;
    }
}
