package com.chartboost.sdk.impl;

import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.chartboost.sdk.internal.Model.CBError;
import com.chartboost.sdk.view.CBImpressionActivity;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import io.bidmachine.iab.vast.tags.VastAttributes;
import io.bidmachine.unified.UnifiedMediationParams;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B/\u0012\u0006\u0010t\u001a\u00020r\u0012\u0006\u0010z\u001a\u00020\u0001\u0012\u0006\u0010{\u001a\u00020\u0002\u0012\u0006\u0010|\u001a\u00020\u0003\u0012\u0006\u0010}\u001a\u00020\u0004¢\u0006\u0004\b~\u0010\u007fJ\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\"\u0010\r\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000bH\u0096\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0006H\u0096\u0001¢\u0006\u0004\b\u000f\u0010\bJ\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b\u0012\u0010\u0013J*\u0010\r\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0096\u0001¢\u0006\u0004\b\r\u0010\u0019J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b\r\u0010\u0013J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b\u000f\u0010\u0013J,\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001bH\u0096\u0001¢\u0006\u0004\b\u000f\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0006H\u0096\u0001¢\u0006\u0004\b\u001f\u0010\bJ\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0017H\u0096\u0001¢\u0006\u0004\b\r\u0010!J\u0018\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0015H\u0096\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010\r\u001a\u00020\u0006H\u0096\u0001¢\u0006\u0004\b\r\u0010\bJ,\u0010\r\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001bH\u0096\u0001¢\u0006\u0004\b\r\u0010\u001eJ\u0010\u0010%\u001a\u00020\u0006H\u0096\u0001¢\u0006\u0004\b%\u0010\bJ \u0010\r\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00172\u0006\u0010'\u001a\u00020&H\u0096\u0001¢\u0006\u0004\b\r\u0010(J\u001a\u0010\r\u001a\u00020\u00062\b\u0010*\u001a\u0004\u0018\u00010)H\u0096\u0001¢\u0006\u0004\b\r\u0010+J\u0012\u0010,\u001a\u0004\u0018\u00010)H\u0096\u0001¢\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020\u0015H\u0096\u0001¢\u0006\u0004\b.\u0010/J\u0010\u00100\u001a\u00020\u0015H\u0096\u0001¢\u0006\u0004\b0\u0010/J\u0010\u00101\u001a\u00020\u0015H\u0096\u0001¢\u0006\u0004\b1\u0010/J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u000202H\u0096\u0001¢\u0006\u0004\b\r\u00103J\u0010\u0010#\u001a\u00020\u0006H\u0096\u0001¢\u0006\u0004\b#\u0010\bJ\u0010\u0010\u0012\u001a\u00020\u0006H\u0096\u0001¢\u0006\u0004\b\u0012\u0010\bJ\u0010\u00104\u001a\u00020\u0006H\u0096\u0001¢\u0006\u0004\b4\u0010\bJ\u0010\u00105\u001a\u00020\u0006H\u0096\u0001¢\u0006\u0004\b5\u0010\bJ\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u0015H\u0096\u0001¢\u0006\u0004\b\u000f\u0010$J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u0015H\u0096\u0001¢\u0006\u0004\b\u0012\u0010$J\u0018\u00109\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u0015H\u0096\u0001¢\u0006\u0004\b9\u0010$J\u0010\u0010:\u001a\u00020\u0006H\u0096\u0001¢\u0006\u0004\b:\u0010\bJ\r\u0010;\u001a\u00020\u0006¢\u0006\u0004\b;\u0010\bJ\r\u0010<\u001a\u00020\u0006¢\u0006\u0004\b<\u0010\bJ\r\u0010=\u001a\u00020\u0006¢\u0006\u0004\b=\u0010\bJ\r\u0010>\u001a\u00020\u0006¢\u0006\u0004\b>\u0010\bJ\u000f\u0010?\u001a\u00020\u0017H\u0016¢\u0006\u0004\b?\u0010@J\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010A\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u000f\u0010!J\r\u00109\u001a\u00020\u0006¢\u0006\u0004\b9\u0010\bJ\r\u0010B\u001a\u00020\t¢\u0006\u0004\bB\u0010CJ\r\u0010D\u001a\u00020\u0015¢\u0006\u0004\bD\u0010/J\r\u0010E\u001a\u00020\t¢\u0006\u0004\bE\u0010CJ\r\u0010F\u001a\u00020\u0006¢\u0006\u0004\bF\u0010\bJ\r\u0010G\u001a\u00020\u0015¢\u0006\u0004\bG\u0010/J\u000f\u0010I\u001a\u0004\u0018\u00010H¢\u0006\u0004\bI\u0010JJ\r\u0010L\u001a\u00020K¢\u0006\u0004\bL\u0010MJ\r\u0010N\u001a\u00020\u0006¢\u0006\u0004\bN\u0010\bJ\u0015\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u000202¢\u0006\u0004\b\u000f\u00103J\r\u0010O\u001a\u00020\u0006¢\u0006\u0004\bO\u0010\bJ\u0015\u0010\r\u001a\u00020\u00062\u0006\u0010P\u001a\u00020\t¢\u0006\u0004\b\r\u0010QJ\u001d\u0010\r\u001a\u00020\u00062\u0006\u0010R\u001a\u00020\u00152\u0006\u0010S\u001a\u00020\t¢\u0006\u0004\b\r\u0010TJ\r\u0010U\u001a\u00020\u0006¢\u0006\u0004\bU\u0010\bJ\r\u0010V\u001a\u00020\u0006¢\u0006\u0004\bV\u0010\bJ\r\u0010W\u001a\u00020\u0006¢\u0006\u0004\bW\u0010\bJ\r\u0010X\u001a\u00020\u0006¢\u0006\u0004\bX\u0010\bJ\r\u0010Y\u001a\u00020\u0006¢\u0006\u0004\bY\u0010\bJ\r\u0010Z\u001a\u00020\u0006¢\u0006\u0004\bZ\u0010\bJ%\u0010\r\u001a\u00020\u00062\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\\0[2\b\u0010^\u001a\u0004\u0018\u00010K¢\u0006\u0004\b\r\u0010_J\u001d\u0010\r\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010`\u001a\u00020\u001b¢\u0006\u0004\b\r\u0010aJ\u0015\u0010\r\u001a\u00020\u00062\u0006\u0010b\u001a\u00020\u001b¢\u0006\u0004\b\r\u0010cJ\u0015\u0010\u000f\u001a\u00020\u00062\u0006\u0010b\u001a\u00020\u001b¢\u0006\u0004\b\u000f\u0010cJ\r\u0010d\u001a\u00020\u0006¢\u0006\u0004\bd\u0010\bJ\u0015\u0010\r\u001a\u00020\u00062\u0006\u0010f\u001a\u00020e¢\u0006\u0004\b\r\u0010gJ\u0015\u0010\r\u001a\u00020\u00062\u0006\u0010i\u001a\u00020h¢\u0006\u0004\b\r\u0010jJ\u0015\u00109\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b9\u0010\u0013J\r\u0010k\u001a\u00020\t¢\u0006\u0004\bk\u0010CJ\r\u0010l\u001a\u00020\t¢\u0006\u0004\bl\u0010CJ\r\u0010m\u001a\u00020\t¢\u0006\u0004\bm\u0010CJ\r\u0010n\u001a\u00020\t¢\u0006\u0004\bn\u0010CJ\r\u0010o\u001a\u00020\t¢\u0006\u0004\bo\u0010CJ\r\u0010p\u001a\u00020\t¢\u0006\u0004\bp\u0010CJ\r\u0010q\u001a\u00020\u0006¢\u0006\u0004\bq\u0010\bR\u0014\u0010t\u001a\u00020r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010sR\u0016\u0010 \u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010uR\u001c\u0010w\u001a\u00020\u00158\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\bv\u0010/\"\u0004\b\u001f\u0010$R\u001c\u0010y\u001a\u00020\u00158\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\bx\u0010/\"\u0004\b\r\u0010$¨\u0006\u0080\u0001"}, d2 = {"Lcom/chartboost/sdk/impl/y1;", "Lcom/chartboost/sdk/impl/y5;", "Lcom/chartboost/sdk/impl/g6;", "Lcom/chartboost/sdk/impl/z5;", "Lcom/chartboost/sdk/impl/q6;", "", "", "D", "()V", "", "url", "Lcom/chartboost/sdk/internal/Model/CBError$a;", "error", "a", "(Ljava/lang/String;Lcom/chartboost/sdk/internal/Model/CBError$a;)V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/chartboost/sdk/impl/m2;", "cbUrl", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "(Lcom/chartboost/sdk/impl/m2;)V", "urlFromCreative", "", "shouldDismiss", "Lcom/chartboost/sdk/impl/l6;", "impressionState", "(Ljava/lang/String;Ljava/lang/Boolean;Lcom/chartboost/sdk/impl/l6;)Z", "location", "", "videoPosition", "videoDuration", "(Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;)V", "e", "state", "(Lcom/chartboost/sdk/impl/l6;)V", "close", InneractiveMediationDefs.GENDER_FEMALE, "(Z)V", "l", "Lcom/chartboost/sdk/view/CBImpressionActivity;", "activity", "(Lcom/chartboost/sdk/impl/l6;Lcom/chartboost/sdk/view/CBImpressionActivity;)V", "Landroid/view/ViewGroup;", "hostView", "(Landroid/view/ViewGroup;)V", "o", "()Landroid/view/ViewGroup;", "m", "()Z", CampaignEx.JSON_KEY_AD_K, "h", "Lcom/chartboost/sdk/internal/Model/CBError$b;", "(Lcom/chartboost/sdk/internal/Model/CBError$b;)V", "g", "j", "showProcessed", "showSent", VastAttributes.VISIBLE, "d", "n", "L", "M", "I", "G", "s", "()Lcom/chartboost/sdk/impl/l6;", "newState", ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP, "()Ljava/lang/String;", "N", CampaignEx.JSON_KEY_AD_Q, "R", ExifInterface.LONGITUDE_EAST, "Lcom/chartboost/sdk/impl/vb;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lcom/chartboost/sdk/impl/vb;", "", "z", "()I", "Q", "C", "event", "(Ljava/lang/String;)V", "allowOrientationChange", "forceOrientation", "(ZLjava/lang/String;)V", "H", "K", "J", "p", "F", "P", "", "Lcom/chartboost/sdk/impl/fb;", "verificationScriptResourceList", UnifiedMediationParams.KEY_SKIP_OFFSET, "(Ljava/util/List;Ljava/lang/Integer;)V", "currentInSec", "(FF)V", POBConstants.KEY_POSITION, "(F)V", "O", "Lcom/chartboost/sdk/impl/h8;", "playerState", "(Lcom/chartboost/sdk/impl/h8;)V", "Lcom/chartboost/sdk/impl/db;", "vastVideoEvent", "(Lcom/chartboost/sdk/impl/db;)V", VastAttributes.HORIZONTAL_POSITION, "v", ApsMetricsDataMap.APSMETRICS_FIELD_URL, VastAttributes.VERTICAL_POSITION, "w", "r", "B", "Lcom/chartboost/sdk/impl/e6;", "Lcom/chartboost/sdk/impl/e6;", "impressionDependency", "Lcom/chartboost/sdk/impl/l6;", "getClick", "click", "i", "wasImpressionSignaled", "impressionClick", "impressionDismiss", "impressionComplete", "impressionView", "<init>", "(Lcom/chartboost/sdk/impl/e6;Lcom/chartboost/sdk/impl/y5;Lcom/chartboost/sdk/impl/g6;Lcom/chartboost/sdk/impl/z5;Lcom/chartboost/sdk/impl/q6;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class y1 implements y5, g6, z5, q6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final e6 impressionDependency;
    public final /* synthetic */ y5 b;
    public final /* synthetic */ g6 c;
    public final /* synthetic */ z5 d;
    public final /* synthetic */ q6 e;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public l6 state;

    public y1(e6 impressionDependency, y5 impressionClick, g6 impressionDismiss, z5 impressionComplete, q6 impressionView) {
        Intrinsics.checkNotNullParameter(impressionDependency, "impressionDependency");
        Intrinsics.checkNotNullParameter(impressionClick, "impressionClick");
        Intrinsics.checkNotNullParameter(impressionDismiss, "impressionDismiss");
        Intrinsics.checkNotNullParameter(impressionComplete, "impressionComplete");
        Intrinsics.checkNotNullParameter(impressionView, "impressionView");
        this.impressionDependency = impressionDependency;
        this.b = impressionClick;
        this.c = impressionDismiss;
        this.d = impressionComplete;
        this.e = impressionView;
        this.state = l6.LOADING;
    }

    @Override // com.chartboost.sdk.impl.y5
    public void a(String url, CBError.a error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.b.a(url, error);
    }

    @Override // com.chartboost.sdk.impl.y5
    public void b() {
        this.b.b();
    }

    @Override // com.chartboost.sdk.impl.y5
    public void c(m2 cbUrl) {
        Intrinsics.checkNotNullParameter(cbUrl, "cbUrl");
        this.b.c(cbUrl);
    }

    @Override // com.chartboost.sdk.impl.g6
    public void e() {
        this.c.e();
    }

    @Override // com.chartboost.sdk.impl.q6
    public void f() {
        this.e.f();
    }

    @Override // com.chartboost.sdk.impl.q6
    public void g() {
        this.e.g();
    }

    @Override // com.chartboost.sdk.impl.q6
    public boolean h() {
        return this.e.h();
    }

    @Override // com.chartboost.sdk.impl.q6
    public boolean i() {
        return this.e.i();
    }

    @Override // com.chartboost.sdk.impl.q6
    public void j() {
        this.e.j();
    }

    @Override // com.chartboost.sdk.impl.q6
    public boolean k() {
        return this.e.k();
    }

    @Override // com.chartboost.sdk.impl.q6
    public void l() {
        this.e.l();
    }

    @Override // com.chartboost.sdk.impl.q6
    public boolean m() {
        return this.e.m();
    }

    @Override // com.chartboost.sdk.impl.q6
    public void n() {
        this.e.n();
    }

    @Override // com.chartboost.sdk.impl.q6
    public ViewGroup o() {
        return this.e.o();
    }

    @Override // com.chartboost.sdk.impl.q6
    public void a(l6 state, CBImpressionActivity activity) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.e.a(state, activity);
    }

    public final void b(CBError.b error) {
        Intrinsics.checkNotNullParameter(error, "error");
        if (k()) {
            this.impressionDependency.getAdUnitRendererImpressionCallback().p();
        } else {
            a(error);
        }
    }

    @Override // com.chartboost.sdk.impl.q6
    public void c() {
        this.e.c();
    }

    @Override // com.chartboost.sdk.impl.y5
    public void e(boolean z) {
        this.b.e(z);
    }

    @Override // com.chartboost.sdk.impl.g6
    public void f(boolean close) {
        this.c.f(close);
    }

    @Override // com.chartboost.sdk.impl.q6
    public void a(ViewGroup hostView) {
        this.e.a(hostView);
    }

    @Override // com.chartboost.sdk.impl.q6
    public void c(boolean showSent) {
        this.e.c(showSent);
    }

    @Override // com.chartboost.sdk.impl.z5
    public void a() {
        this.d.a();
    }

    @Override // com.chartboost.sdk.impl.y5
    public boolean a(String urlFromCreative, Boolean shouldDismiss, l6 impressionState) {
        Intrinsics.checkNotNullParameter(urlFromCreative, "urlFromCreative");
        Intrinsics.checkNotNullParameter(impressionState, "impressionState");
        return this.b.a(urlFromCreative, shouldDismiss, impressionState);
    }

    @Override // com.chartboost.sdk.impl.g6
    public void a(l6 state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.c.a(state);
    }

    @Override // com.chartboost.sdk.impl.q6
    public void a(CBError.b error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.e.a(error);
    }

    @Override // com.chartboost.sdk.impl.y5
    public void a(m2 cbUrl) {
        Intrinsics.checkNotNullParameter(cbUrl, "cbUrl");
        this.b.a(cbUrl);
    }

    public final void a(List<fb> verificationScriptResourceList, Integer skipOffset) {
        Intrinsics.checkNotNullParameter(verificationScriptResourceList, "verificationScriptResourceList");
        this.impressionDependency.getViewProtocol().a(verificationScriptResourceList, skipOffset);
    }

    public final void L() {
        this.state = l6.LOADING;
        CBError.b bVarA = this.impressionDependency.getViewProtocol().A();
        if (bVarA == null) {
            j();
        } else {
            b(bVarA);
        }
    }

    public final void M() {
        a(this.impressionDependency.getLocation(), Float.valueOf(this.impressionDependency.getViewProtocol().getVideoPosition()), Float.valueOf(this.impressionDependency.getViewProtocol().getVideoDuration()));
    }

    public final void I() {
        if (this.state != l6.DISPLAYED || k()) {
            return;
        }
        n();
        c(true);
    }

    public final void G() {
        b(this.impressionDependency.getLocation(), Float.valueOf(this.impressionDependency.getViewProtocol().getVideoPosition()), Float.valueOf(this.impressionDependency.getViewProtocol().getVideoDuration()));
        b();
    }

    /* JADX INFO: renamed from: s, reason: from getter */
    public l6 getState() {
        return this.state;
    }

    public final void d() {
        a(this.state);
    }

    @Override // com.chartboost.sdk.impl.q6
    public void d(boolean visible) {
        this.e.d(visible);
    }

    public final void d(m2 cbUrl) {
        Intrinsics.checkNotNullParameter(cbUrl, "cbUrl");
        a(cbUrl.getUrl(), cbUrl.getShouldDismiss(), this.state);
    }

    public final String t() {
        return this.impressionDependency.getLocation();
    }

    public final boolean N() {
        return this.impressionDependency.getAdTypeTraits().getShouldDisplayOnHostView();
    }

    public final String q() {
        return this.impressionDependency.getAdUnit().getImpressionId();
    }

    public final void R() {
        this.impressionDependency.getViewProtocol().f();
    }

    public final boolean E() {
        if (this.impressionDependency.getViewProtocol().getView() != null) {
            vb view = this.impressionDependency.getViewProtocol().getView();
            if ((view != null ? view.getRootView() : null) != null) {
                return false;
            }
        }
        return true;
    }

    public final vb A() {
        return this.impressionDependency.getViewProtocol().getView();
    }

    public final int z() {
        if (this.impressionDependency.getViewProtocol() instanceof pb) {
            return ((pb) this.impressionDependency.getViewProtocol()).G();
        }
        return -1;
    }

    public final void Q() {
        this.impressionDependency.getViewProtocol().w();
    }

    @Override // com.chartboost.sdk.impl.y5
    public void b(m2 cbUrl) {
        Intrinsics.checkNotNullParameter(cbUrl, "cbUrl");
        this.b.b(cbUrl);
    }

    public void b(l6 newState) {
        Intrinsics.checkNotNullParameter(newState, "newState");
        this.state = newState;
    }

    public final void C() {
        if (k() && Intrinsics.areEqual(this.impressionDependency.getAdTypeTraits(), u.c.g)) {
            B();
        }
    }

    public final void H() {
        if (this.impressionDependency.getImpressionCounter().getOnRewardedVideoCompletedPlayCount() <= 1) {
            D();
            d6 impressionCounter = this.impressionDependency.getImpressionCounter();
            impressionCounter.c(impressionCounter.getOnRewardedVideoCompletedPlayCount() + 1);
        }
    }

    public final void K() {
        try {
            o2 viewProtocol = this.impressionDependency.getViewProtocol();
            Intrinsics.checkNotNull(viewProtocol, "null cannot be cast to non-null type com.chartboost.sdk.internal.video.VideoProtocol");
            ((pb) viewProtocol).M();
        } catch (Exception e) {
            b7.b("Invalid play video command", e);
        }
    }

    public final void J() {
        try {
            o2 viewProtocol = this.impressionDependency.getViewProtocol();
            Intrinsics.checkNotNull(viewProtocol, "null cannot be cast to non-null type com.chartboost.sdk.internal.video.VideoProtocol");
            ((pb) viewProtocol).L();
        } catch (Exception e) {
            b7.b("Invalid pause video command", e);
        }
    }

    public final void p() {
        try {
            o2 viewProtocol = this.impressionDependency.getViewProtocol();
            Intrinsics.checkNotNull(viewProtocol, "null cannot be cast to non-null type com.chartboost.sdk.internal.video.VideoProtocol");
            ((pb) viewProtocol).E();
        } catch (Exception e) {
            b7.b("Invalid close video command", e);
        }
    }

    public final void F() {
        try {
            if (this.impressionDependency.getViewProtocol() instanceof pb) {
                ((pb) this.impressionDependency.getViewProtocol()).I();
            } else {
                this.impressionDependency.getViewProtocol().v();
                this.impressionDependency.getViewProtocol().a(db.VOLUME_CHANGE);
            }
        } catch (Exception e) {
            b7.b("Invalid mute video command", e);
        }
    }

    public final void P() {
        try {
            if (this.impressionDependency.getViewProtocol() instanceof pb) {
                ((pb) this.impressionDependency.getViewProtocol()).O();
            } else {
                this.impressionDependency.getViewProtocol().D();
                this.impressionDependency.getViewProtocol().a(db.VOLUME_CHANGE);
            }
        } catch (Exception e) {
            b7.b("Invalid unmute video command", e);
        }
    }

    @Override // com.chartboost.sdk.impl.q6
    public void b(boolean showProcessed) {
        this.e.b(showProcessed);
    }

    public final void O() {
        if (this.impressionDependency.getImpressionCounter().getOnVideoCompletedPlayCount() <= 1) {
            B();
            D();
            d6 impressionCounter = this.impressionDependency.getImpressionCounter();
            impressionCounter.d(impressionCounter.getOnVideoCompletedPlayCount() + 1);
        }
    }

    public final String x() {
        return this.impressionDependency.getViewProtocol().o();
    }

    public final String v() {
        return this.impressionDependency.getViewProtocol().k();
    }

    public final String u() {
        return this.impressionDependency.getViewProtocol().i();
    }

    public final String y() {
        return this.impressionDependency.getViewProtocol().p();
    }

    public final String w() {
        return this.impressionDependency.getViewProtocol().m();
    }

    public final String r() {
        return this.impressionDependency.getAdUnit().t();
    }

    public final void B() {
        if (this.impressionDependency.getImpressionCounter().getImpressionNotifyDidCompleteAdPlayCount() <= 1) {
            a();
            d6 impressionCounter = this.impressionDependency.getImpressionCounter();
            impressionCounter.a(impressionCounter.getImpressionNotifyDidCompleteAdPlayCount() + 1);
        }
    }

    public final void D() {
        if (this.impressionDependency.getImpressionCounter().getImpressionSendVideoCompleteRequestPlayCount() <= 1) {
            M();
            d6 impressionCounter = this.impressionDependency.getImpressionCounter();
            impressionCounter.b(impressionCounter.getImpressionSendVideoCompleteRequestPlayCount() + 1);
        }
    }

    public final void b(float pos) {
        this.impressionDependency.getViewProtocol().b(pos);
    }

    @Override // com.chartboost.sdk.impl.y5
    public void b(String location, Float videoPosition, Float videoDuration) {
        Intrinsics.checkNotNullParameter(location, "location");
        this.b.b(location, videoPosition, videoDuration);
    }

    public final void a(float videoDuration, float currentInSec) {
        this.impressionDependency.getViewProtocol().a(videoDuration, currentInSec);
    }

    @Override // com.chartboost.sdk.impl.z5
    public void a(String location, Float videoPosition, Float videoDuration) {
        Intrinsics.checkNotNullParameter(location, "location");
        this.d.a(location, videoPosition, videoDuration);
    }

    public final void a(String event) {
        List<String> list;
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.length() <= 0 || (list = this.impressionDependency.getAdUnit().l().get(event)) == null) {
            return;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            this.impressionDependency.getViewProtocol().d((String) it.next());
        }
    }

    public final void a(db vastVideoEvent) {
        Intrinsics.checkNotNullParameter(vastVideoEvent, "vastVideoEvent");
        this.impressionDependency.getViewProtocol().a(vastVideoEvent);
    }

    public final void a(boolean allowOrientationChange, String forceOrientation) {
        Intrinsics.checkNotNullParameter(forceOrientation, "forceOrientation");
        this.impressionDependency.getViewProtocol().a(allowOrientationChange, forceOrientation);
    }

    public final void a(float pos) {
        this.impressionDependency.getViewProtocol().a(pos);
    }

    @Override // com.chartboost.sdk.impl.q6
    public void a(boolean z) {
        this.e.a(z);
    }

    public final void a(h8 playerState) {
        Intrinsics.checkNotNullParameter(playerState, "playerState");
        this.impressionDependency.getViewProtocol().a(playerState);
    }
}
