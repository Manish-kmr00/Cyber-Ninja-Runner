package com.unity3d.mediation.rewarded;

import android.app.Activity;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.json.e2;
import com.json.ed;
import com.json.gl;
import com.json.lf;
import com.json.mediationsdk.IronSource;
import com.json.mm;
import com.json.o1;
import com.json.q9;
import com.json.sl;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.safedk.android.analytics.brandsafety.creatives.discoveries.h;
import com.unity3d.mediation.LevelPlay;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0011\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001aB\u0019\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u0019\u0010\u001dJ\u0006\u0010\u0003\u001a\u00020\u0002J\u001c\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\u0006\u0010\n\u001a\u00020\tJ\u0010\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bR\u0017\u0010\u0012\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0018\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/unity3d/mediation/rewarded/LevelPlayRewardedAd;", "", "", "loadAd", "Landroid/app/Activity;", "activity", "", "placementName", h.ac, "", "isAdReady", "Lcom/unity3d/mediation/rewarded/LevelPlayRewardedAdListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setListener", "a", "Ljava/lang/String;", "getAdUnitId", "()Ljava/lang/String;", "adUnitId", "Lcom/ironsource/sl;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/ironsource/sl;", "adInternal", "getAdId", "adId", "<init>", "(Ljava/lang/String;)V", "Lcom/ironsource/gl$b;", "payload", "(Ljava/lang/String;Lcom/ironsource/gl$b;)V", "Companion", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class LevelPlayRewardedAd {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String adUnitId;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final sl adInternal;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/unity3d/mediation/rewarded/LevelPlayRewardedAd$Companion;", "", "()V", "isPlacementCapped", "", "placementName", "", "mediationsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final boolean isPlacementCapped(String placementName) {
            Intrinsics.checkNotNullParameter(placementName, "placementName");
            return gl.INSTANCE.a(placementName, LevelPlay.AdFormat.REWARDED);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LevelPlayRewardedAd(String adUnitId) {
        this(adUnitId, new gl.b(new o1(IronSource.AD_UNIT.REWARDED_VIDEO, e2.b.MEDIATION), new ed(), mm.INSTANCE.d(), new q9.a(), lf.f3858a));
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
    }

    public LevelPlayRewardedAd(String adUnitId, gl.b payload) {
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(payload, "payload");
        this.adUnitId = adUnitId;
        this.adInternal = new sl(adUnitId, payload.getAdTools(), payload.getAdControllerFactory(), payload.getProvider(), payload.getCurrentTimeProvider(), payload.getIdFactory());
    }

    @JvmStatic
    public static final boolean isPlacementCapped(String str) {
        return INSTANCE.isPlacementCapped(str);
    }

    public static /* synthetic */ void showAd$default(LevelPlayRewardedAd levelPlayRewardedAd, Activity activity, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        levelPlayRewardedAd.showAd(activity, str);
    }

    public final String getAdId() {
        return this.adInternal.a();
    }

    public final String getAdUnitId() {
        return this.adUnitId;
    }

    public final boolean isAdReady() {
        return this.adInternal.b();
    }

    public final void loadAd() {
        this.adInternal.c();
    }

    public final void setListener(LevelPlayRewardedAdListener listener) {
        this.adInternal.a(listener);
    }

    public final void showAd(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        showAd$default(this, activity, null, 2, null);
    }

    public final void showAd(Activity activity, String placementName) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.adInternal.a(activity, placementName);
    }
}
