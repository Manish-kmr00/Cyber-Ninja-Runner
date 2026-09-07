package com.json;

import android.content.Context;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.json.mediationsdk.ISBannerSize;
import com.json.mediationsdk.ISContainerParams;
import com.json.mediationsdk.IronSource;
import com.json.mediationsdk.l;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.unity3d.mediation.LevelPlayAdSize;
import io.ktor.http.ContentDisposition;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u0005\u0010\bJ\u001e\u0010\u0006\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tJ\u0006\u0010\r\u001a\u00020\fJ\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eJ\u000e\u0010\u0006\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010J\u0017\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u000f\u0010\u0014J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u001c¨\u0006 "}, d2 = {"Lcom/ironsource/l1;", "Lcom/ironsource/vl;", "Lcom/unity3d/mediation/LevelPlayAdSize;", ContentDisposition.Parameters.Size, "Lcom/ironsource/mediationsdk/ISBannerSize;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "a", "", "()Ljava/lang/Float;", "", "message", "suffix", "", "d", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "", "width", "Landroid/content/Context;", "context", "(Landroid/content/Context;)Ljava/lang/Integer;", "Lcom/ironsource/ac;", "Lcom/ironsource/ac;", "eventSender", "Lcom/ironsource/vt$b;", "Lcom/ironsource/vt$b;", "logFactory", "Lcom/ironsource/wh;", "Lcom/ironsource/wh;", "sdkConfigService", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class l1 extends vl {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final ac eventSender;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final vt.b logFactory;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final wh sdkConfigService;

    public l1() {
        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.BANNER;
        this.eventSender = new ac(ad_unit, e2.b.MEDIATION, null, null, 12, null);
        vt.b bVarA = vt.a(ad_unit);
        Intrinsics.checkNotNullExpressionValue(bVarA, "createLogFactory(IronSource.AD_UNIT.BANNER)");
        this.logFactory = bVarA;
        this.sdkConfigService = mm.INSTANCE.d().t();
    }

    private final ISBannerSize a(LevelPlayAdSize size) {
        LevelPlayAdSize fallbackAdSize = size.getFallbackAdSize();
        if (fallbackAdSize == null) {
            fallbackAdSize = LevelPlayAdSize.BANNER;
        }
        ISBannerSize iSBannerSizeB = b(fallbackAdSize);
        iSBannerSizeB.setAdaptive(true);
        iSBannerSizeB.containerParams = new ISContainerParams(size.getWidth(), size.getHeight());
        return iSBannerSizeB;
    }

    public static /* synthetic */ String a(l1 l1Var, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        return l1Var.a(str, str2);
    }

    private final ISBannerSize c(LevelPlayAdSize size) {
        if (Intrinsics.areEqual(size, LevelPlayAdSize.LARGE)) {
            return new ISBannerSize(l.b, size.getWidth(), size.getHeight());
        }
        if (Intrinsics.areEqual(size, LevelPlayAdSize.MEDIUM_RECTANGLE)) {
            return new ISBannerSize(l.c, size.getWidth(), size.getHeight());
        }
        if (Intrinsics.areEqual(size, LevelPlayAdSize.LEADERBOARD)) {
            return new ISBannerSize(l.e, 0, 0);
        }
        return Intrinsics.areEqual(size, LevelPlayAdSize.INSTANCE.createCustomSize(size.getWidth(), size.getHeight())) ? new ISBannerSize(size.getWidth(), size.getHeight()) : new ISBannerSize("BANNER", size.getWidth(), size.getHeight());
    }

    private final Float c() {
        el elVarA = this.sdkConfigService.a();
        Float fValueOf = elVarA != null ? Float.valueOf(elVarA.i()) : null;
        if (fValueOf != null) {
            return fValueOf;
        }
        this.eventSender.getTroubleshoot().f("MaxScreenSizePercentageForBannerHeight is null: Error getting sdk configurations");
        return null;
    }

    public final int a(int width) {
        return l.a(width);
    }

    public final String a(String message, String suffix) {
        String strA = this.logFactory.a(message, suffix);
        Intrinsics.checkNotNullExpressionValue(strA, "logFactory.createLogMessage(message, suffix)");
        return strA;
    }

    public final ISBannerSize b(LevelPlayAdSize size) {
        Intrinsics.checkNotNullParameter(size, "size");
        boolean isAdaptive = size.getIsAdaptive();
        if (isAdaptive) {
            return a(size);
        }
        if (isAdaptive) {
            throw new NoWhenBranchMatchedException();
        }
        return c(size);
    }

    public final Integer b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Float fC = c();
        if (fC != null) {
            return Integer.valueOf(MathKt.roundToInt(fC.floatValue() * bb.f3555a.a(context)));
        }
        return null;
    }

    public final List<LevelPlayAdSize> b() {
        el elVarA = this.sdkConfigService.a();
        if (elVarA != null) {
            return elVarA.h();
        }
        throw new IllegalStateException("Error getting sdk configurations");
    }

    public final boolean d() {
        return mm.INSTANCE.d().t().getIsSDKInitialized();
    }
}
