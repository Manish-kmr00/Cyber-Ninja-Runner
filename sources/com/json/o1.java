package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.json.lifecycle.b;
import com.json.mediationsdk.ISBannerSize;
import com.json.mediationsdk.IronSource;
import com.json.mediationsdk.impressionData.ImpressionData;
import com.json.mediationsdk.l;
import com.json.mediationsdk.model.Placement;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.unity3d.mediation.LevelPlay;
import com.unity3d.mediation.LevelPlayAdSize;
import io.ktor.http.ContentDisposition;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0005B\u0019\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\u001d\u0012\u0006\u0010/\u001a\u00020.¢\u0006\u0004\b0\u00101B\u0019\b\u0016\u0012\u0006\u00102\u001a\u00020\u0000\u0012\u0006\u0010/\u001a\u00020.¢\u0006\u0004\b0\u00103J \u0010\u0005\u001a\u00020\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0007J\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u0005\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\b\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0002J\u0016\u0010\u0007\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u0010J\"\u0010\u0005\u001a\u00020\u00172\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0005\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0018J\u000e\u0010\u0007\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\u001c\u001a\u00020\u001bR\u001a\u0010\u000b\u001a\u00020\u001d8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b\f\u0010\u001fR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0017\u0010(\u001a\u00020$8\u0006¢\u0006\f\n\u0004\b\f\u0010%\u001a\u0004\b&\u0010'R\u0014\u0010+\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010*R\u0014\u0010-\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010,¨\u00064"}, d2 = {"Lcom/ironsource/o1;", "Lcom/ironsource/vl;", "", "message", "suffix", "a", "Lcom/ironsource/lifecycle/b;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "placementName", "Lcom/ironsource/mediationsdk/model/Placement;", "Lcom/unity3d/mediation/LevelPlay$AdFormat;", ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT, "d", "adUnitId", "Lcom/ironsource/i7$b;", "Lcom/ironsource/td$a;", "", InneractiveMediationDefs.GENDER_FEMALE, "", "", "data", "Lcom/ironsource/mediationsdk/ISBannerSize;", ContentDisposition.Parameters.Size, "", "Lcom/unity3d/mediation/LevelPlayAdSize;", "adSize", "", "", "g", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "()Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "Lcom/ironsource/vt$b;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/ironsource/vt$b;", "logFactory", "Lcom/ironsource/ac;", "Lcom/ironsource/ac;", "e", "()Lcom/ironsource/ac;", "eventSender", "Lcom/ironsource/wh;", "Lcom/ironsource/wh;", "sdkConfigService", "J", "ONE_HOUR_IN_MILLIS", "Lcom/ironsource/e2$b;", "level", "<init>", "(Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;Lcom/ironsource/e2$b;)V", "adTools", "(Lcom/ironsource/o1;Lcom/ironsource/e2$b;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public class o1 extends vl {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final IronSource.AD_UNIT adFormat;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final vt.b logFactory;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final ac eventSender;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final wh sdkConfigService;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final long ONE_HOUR_IN_MILLIS;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\n"}, d2 = {"Lcom/ironsource/o1$a;", "", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT, "Lcom/ironsource/e2$b;", "level", "Lcom/ironsource/o1;", "a", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f4100a = new a();

        private a() {
        }

        @JvmStatic
        public static final o1 a(IronSource.AD_UNIT adFormat, e2.b level) {
            Intrinsics.checkNotNullParameter(adFormat, "adFormat");
            Intrinsics.checkNotNullParameter(level, "level");
            return new o1(adFormat, level);
        }
    }

    public o1(IronSource.AD_UNIT adFormat, e2.b level) {
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        Intrinsics.checkNotNullParameter(level, "level");
        this.sdkConfigService = mm.INSTANCE.d().t();
        this.ONE_HOUR_IN_MILLIS = TimeUnit.HOURS.toMillis(1L);
        this.adFormat = adFormat;
        this.eventSender = new ac(adFormat, level, null, null, 12, null);
        vt.b bVarA = vt.a(adFormat);
        Intrinsics.checkNotNullExpressionValue(bVarA, "createLogFactory(adFormat)");
        this.logFactory = bVarA;
    }

    public o1(o1 adTools, e2.b level) {
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(level, "level");
        this.sdkConfigService = mm.INSTANCE.d().t();
        this.ONE_HOUR_IN_MILLIS = TimeUnit.HOURS.toMillis(1L);
        IronSource.AD_UNIT ad_unit = adTools.adFormat;
        this.adFormat = ad_unit;
        this.logFactory = adTools.logFactory;
        this.eventSender = new ac(ad_unit, level, adTools.eventSender.c(), null, 8, null);
    }

    public static /* synthetic */ String a(o1 o1Var, String str, String str2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createLogMessage");
        }
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        return o1Var.a(str, str2);
    }

    public final ISBannerSize a(LevelPlayAdSize adSize) {
        Intrinsics.checkNotNullParameter(adSize, "adSize");
        return new l1().b(adSize);
    }

    public final Placement a(LevelPlay.AdFormat adFormat, String placementName) {
        el elVarA;
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        if (placementName == null || (elVarA = this.sdkConfigService.a()) == null) {
            return null;
        }
        return elVarA.b(adFormat, placementName);
    }

    public final Placement a(String placementName) {
        Intrinsics.checkNotNullParameter(placementName, "placementName");
        el elVarA = this.sdkConfigService.a();
        if (elVarA == null) {
            throw new IllegalStateException("Error getting sdk configurations");
        }
        Placement placementB = elVarA.b(LevelPlay.AdFormat.BANNER, placementName);
        if (placementB != null) {
            return placementB;
        }
        throw new IllegalStateException("Error getting placement");
    }

    public final String a(String message, String suffix) {
        String strA = this.logFactory.a(message, suffix);
        Intrinsics.checkNotNullExpressionValue(strA, "logFactory.createLogMessage(message, suffix)");
        return strA;
    }

    public final void a(Map<String, Object> data, ISBannerSize size) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(size, "size");
        l.a(data, size);
    }

    public final long b(LevelPlay.AdFormat adFormat) {
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        el elVarA = this.sdkConfigService.a();
        return elVarA != null ? elVarA.b(adFormat) : this.ONE_HOUR_IN_MILLIS;
    }

    public final i7.b b(String adUnitId) {
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        el elVarA = this.sdkConfigService.a();
        if (elVarA != null) {
            return elVarA.a(adUnitId);
        }
        throw new IllegalStateException("Error getting sdk configurations");
    }

    public final b b() {
        b bVarD = b.d();
        Intrinsics.checkNotNullExpressionValue(bVarD, "getInstance()");
        return bVarD;
    }

    public final td.a b(LevelPlay.AdFormat adFormat, String adUnitId) {
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        el elVarA = this.sdkConfigService.a();
        if (elVarA != null) {
            return elVarA.a(adFormat, adUnitId);
        }
        throw new IllegalStateException("Error getting sdk configurations");
    }

    public final String c() {
        return a(this, (String) null, (String) null, 3, (Object) null);
    }

    public final String c(String str) {
        return a(this, str, (String) null, 2, (Object) null);
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    protected final IronSource.AD_UNIT getAdFormat() {
        return this.adFormat;
    }

    public final Placement d(String placementName) {
        Intrinsics.checkNotNullParameter(placementName, "placementName");
        el elVarA = this.sdkConfigService.a();
        if (elVarA == null) {
            throw new IllegalStateException("Error getting sdk configurations");
        }
        Placement placementB = elVarA.b(LevelPlay.AdFormat.NATIVE_AD, placementName);
        if (placementB != null) {
            return placementB;
        }
        throw new IllegalStateException("Error getting sdk configurations");
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final ac getEventSender() {
        return this.eventSender;
    }

    public final int f() {
        return mm.INSTANCE.d().k().a(this.adFormat);
    }

    public final boolean g() {
        return mm.INSTANCE.d().t().c();
    }
}
