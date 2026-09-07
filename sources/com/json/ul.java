package com.json;

import android.content.Context;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.json.environment.thread.IronSourceThreadManager;
import com.json.mediationsdk.IronSource;
import com.json.mediationsdk.impressionData.ImpressionData;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.unity3d.mediation.LevelPlay;
import com.unity3d.mediation.LevelPlayConfiguration;
import com.unity3d.mediation.LevelPlayInitError;
import com.unity3d.mediation.LevelPlayInitListener;
import com.unity3d.mediation.LevelPlayInitRequest;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b!\u0010\"J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J2\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u001e\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0011H\u0002J*\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0018\u0010\u000e\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\"\u0010\u000e\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\"\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\u00188\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\u001f¨\u0006#"}, d2 = {"Lcom/ironsource/ul;", "", "Landroid/content/Context;", "context", "Lcom/unity3d/mediation/LevelPlayInitRequest;", "initRequest", "Lcom/unity3d/mediation/LevelPlayInitListener;", "initializationListener", "", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/ironsource/kr;", "sdkConfig", "Lcom/ironsource/ib;", "initDuration", "a", "", "delay", "Lkotlin/Function0;", "successCallback", "Lcom/ironsource/el;", "levelPlayConfig", "delayTimeAfterInitProcessInMS", "Lcom/unity3d/mediation/LevelPlay$AdFormat;", ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT, "", "Lcom/ironsource/mr;", "error", "Lcom/ironsource/vl;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/ironsource/vl;", "tools", "Z", "ENABLE_STANDALONE_INIT", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class ul {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ul f4497a = new ul();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private static final vl tools = new vl();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private static final boolean ENABLE_STANDALONE_INIT = false;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"com/ironsource/ul$a", "Lcom/ironsource/qr;", "Lcom/ironsource/kr;", "sdkConfig", "", "a", "Lcom/ironsource/mr;", "error", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements qr {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LevelPlayInitRequest f4498a;
        final /* synthetic */ Context b;
        final /* synthetic */ ib c;
        final /* synthetic */ LevelPlayInitListener d;

        a(LevelPlayInitRequest levelPlayInitRequest, Context context, ib ibVar, LevelPlayInitListener levelPlayInitListener) {
            this.f4498a = levelPlayInitRequest;
            this.b = context;
            this.c = ibVar;
            this.d = levelPlayInitListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(LevelPlayInitListener levelPlayInitListener, ib initDuration, mr error) {
            Intrinsics.checkNotNullParameter(initDuration, "$initDuration");
            Intrinsics.checkNotNullParameter(error, "$error");
            ul.f4497a.a(levelPlayInitListener, initDuration, error);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(LevelPlayInitRequest initRequest, kr sdkConfig, Context context, ib initDuration, LevelPlayInitListener levelPlayInitListener) {
            Intrinsics.checkNotNullParameter(initRequest, "$initRequest");
            Intrinsics.checkNotNullParameter(sdkConfig, "$sdkConfig");
            Intrinsics.checkNotNullParameter(context, "$context");
            Intrinsics.checkNotNullParameter(initDuration, "$initDuration");
            ul.f4497a.a(initRequest, sdkConfig, context, initDuration, levelPlayInitListener);
        }

        @Override // com.json.qr
        public void a(final kr sdkConfig) {
            Intrinsics.checkNotNullParameter(sdkConfig, "sdkConfig");
            vl vlVar = ul.tools;
            final LevelPlayInitRequest levelPlayInitRequest = this.f4498a;
            final Context context = this.b;
            final ib ibVar = this.c;
            final LevelPlayInitListener levelPlayInitListener = this.d;
            vlVar.a(new Runnable() { // from class: com.ironsource.ul$a$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ul.a.a(levelPlayInitRequest, sdkConfig, context, ibVar, levelPlayInitListener);
                }
            });
        }

        @Override // com.json.qr
        public void a(final mr error) {
            Intrinsics.checkNotNullParameter(error, "error");
            vl vlVar = ul.tools;
            final LevelPlayInitListener levelPlayInitListener = this.d;
            final ib ibVar = this.c;
            vlVar.a(new Runnable() { // from class: com.ironsource.ul$a$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    ul.a.a(levelPlayInitListener, ibVar, error);
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"com/ironsource/ul$b", "Lcom/ironsource/qr;", "Lcom/ironsource/kr;", "sdkConfig", "", "a", "Lcom/ironsource/mr;", "error", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements qr {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LevelPlayInitRequest f4499a;
        final /* synthetic */ Context b;
        final /* synthetic */ ib c;
        final /* synthetic */ LevelPlayInitListener d;

        b(LevelPlayInitRequest levelPlayInitRequest, Context context, ib ibVar, LevelPlayInitListener levelPlayInitListener) {
            this.f4499a = levelPlayInitRequest;
            this.b = context;
            this.c = ibVar;
            this.d = levelPlayInitListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(LevelPlayInitListener levelPlayInitListener, ib initDuration, mr error) {
            Intrinsics.checkNotNullParameter(initDuration, "$initDuration");
            Intrinsics.checkNotNullParameter(error, "$error");
            ul.f4497a.a(levelPlayInitListener, initDuration, error);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(LevelPlayInitRequest initRequest, kr sdkConfig, Context context, ib initDuration, LevelPlayInitListener levelPlayInitListener) {
            Intrinsics.checkNotNullParameter(initRequest, "$initRequest");
            Intrinsics.checkNotNullParameter(sdkConfig, "$sdkConfig");
            Intrinsics.checkNotNullParameter(context, "$context");
            Intrinsics.checkNotNullParameter(initDuration, "$initDuration");
            ul.f4497a.a(initRequest, sdkConfig, context, initDuration, levelPlayInitListener);
        }

        @Override // com.json.qr
        public void a(final kr sdkConfig) {
            Intrinsics.checkNotNullParameter(sdkConfig, "sdkConfig");
            vl vlVar = ul.tools;
            final LevelPlayInitRequest levelPlayInitRequest = this.f4499a;
            final Context context = this.b;
            final ib ibVar = this.c;
            final LevelPlayInitListener levelPlayInitListener = this.d;
            vlVar.a(new Runnable() { // from class: com.ironsource.ul$b$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ul.b.a(levelPlayInitRequest, sdkConfig, context, ibVar, levelPlayInitListener);
                }
            });
        }

        @Override // com.json.qr
        public void a(final mr error) {
            Intrinsics.checkNotNullParameter(error, "error");
            vl vlVar = ul.tools;
            final LevelPlayInitListener levelPlayInitListener = this.d;
            final ib ibVar = this.c;
            vlVar.a(new Runnable() { // from class: com.ironsource.ul$b$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    ul.b.a(levelPlayInitListener, ibVar, error);
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 8, 0})
    static final class c extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ el f4500a;
        final /* synthetic */ ib b;
        final /* synthetic */ long c;
        final /* synthetic */ LevelPlayInitListener d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(el elVar, ib ibVar, long j, LevelPlayInitListener levelPlayInitListener) {
            super(0);
            this.f4500a = elVar;
            this.b = ibVar;
            this.c = j;
            this.d = levelPlayInitListener;
        }

        public final void a() {
            ul.f4497a.a(this.f4500a, this.b, this.c, this.d);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    private ul() {
    }

    private final void a(long delay, Function0<Unit> successCallback) {
        if (mm.INSTANCE.d().t().getIsSDKInitialized() || delay <= 0) {
            successCallback.invoke();
        } else {
            tools.a(successCallback, delay);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final el levelPlayConfig, ib initDuration, long delayTimeAfterInitProcessInMS, final LevelPlayInitListener initializationListener) {
        mm.INSTANCE.a().D().d();
        long jA = ib.a(initDuration);
        vl vlVar = tools;
        vlVar.a(jA, levelPlayConfig.f(), delayTimeAfterInitProcessInMS);
        vlVar.e(new Runnable() { // from class: com.ironsource.ul$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                ul.a(initializationListener, levelPlayConfig);
            }
        });
    }

    public static /* synthetic */ void a(ul ulVar, Context context, LevelPlayInitRequest levelPlayInitRequest, LevelPlayInitListener levelPlayInitListener, int i, Object obj) {
        if ((i & 4) != 0) {
            levelPlayInitListener = null;
        }
        ulVar.a(context, levelPlayInitRequest, levelPlayInitListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LevelPlayInitListener levelPlayInitListener, el levelPlayConfig) {
        Intrinsics.checkNotNullParameter(levelPlayConfig, "$levelPlayConfig");
        if (levelPlayInitListener != null) {
            levelPlayInitListener.onInitSuccess(new LevelPlayConfiguration(levelPlayConfig.j()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final LevelPlayInitListener initializationListener, ib initDuration, final mr error) {
        long jA = ib.a(initDuration);
        vl vlVar = tools;
        vlVar.a(error, jA);
        vlVar.e(new Runnable() { // from class: com.ironsource.ul$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ul.a(initializationListener, error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LevelPlayInitListener levelPlayInitListener, mr error) {
        Intrinsics.checkNotNullParameter(error, "$error");
        if (levelPlayInitListener != null) {
            levelPlayInitListener.onInitFailed(new LevelPlayInitError(error));
        }
    }

    private final void a(LevelPlayInitRequest initRequest, el levelPlayConfig) {
        LevelPlay.AdFormat adFormat = LevelPlay.AdFormat.REWARDED;
        if (a(initRequest, adFormat) && levelPlayConfig.d().c().getRewardedVideoConfigurations() != null) {
            sq.Companion aVar = sq.INSTANCE;
            IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.REWARDED_VIDEO;
            sq sqVarA = aVar.a(new f1(ad_unit, lf.f3858a.a(), "", null, null, 24, null), levelPlayConfig, true);
            List<zn> listC = levelPlayConfig.c(adFormat);
            e2.b bVar = e2.b.MEDIATION;
            new xp(new w2(new o1(ad_unit, bVar), sqVarA, bVar), adFormat, listC, sqVarA).a();
        }
        LevelPlay.AdFormat adFormat2 = LevelPlay.AdFormat.INTERSTITIAL;
        if (a(initRequest, adFormat2) && levelPlayConfig.d().c().getInterstitialConfigurations() != null) {
            kj.Companion aVar2 = kj.INSTANCE;
            IronSource.AD_UNIT ad_unit2 = IronSource.AD_UNIT.INTERSTITIAL;
            kj kjVarA = aVar2.a(new f1(ad_unit2, lf.f3858a.a(), "", null, null, 24, null), levelPlayConfig, true);
            List<zn> listC2 = levelPlayConfig.c(adFormat2);
            e2.b bVar2 = e2.b.MEDIATION;
            new xp(new w2(new o1(ad_unit2, bVar2), kjVarA, bVar2), adFormat2, listC2, kjVarA).a();
        }
        LevelPlay.AdFormat adFormat3 = LevelPlay.AdFormat.BANNER;
        if (!a(initRequest, adFormat3) || levelPlayConfig.d().c().getBannerConfigurations() == null) {
            return;
        }
        m6 m6VarA = m6.INSTANCE.a(new j6(), levelPlayConfig, true);
        List<zn> listC3 = levelPlayConfig.c(adFormat3);
        IronSource.AD_UNIT ad_unit3 = IronSource.AD_UNIT.BANNER;
        e2.b bVar3 = e2.b.MEDIATION;
        new xp(new w2(new o1(ad_unit3, bVar3), m6VarA, bVar3), adFormat3, listC3, m6VarA).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(LevelPlayInitRequest initRequest, kr sdkConfig, Context context, ib initDuration, LevelPlayInitListener initializationListener) {
        mm.Companion companion = mm.INSTANCE;
        wh.a aVarD = companion.a().D();
        el elVar = new el(sdkConfig);
        if (elVar.k()) {
            tools.a(context);
        }
        zf.a aVarA = companion.a().a();
        vl vlVar = tools;
        elVar.b(vlVar).a(aVarA);
        elVar.a(vlVar).a(companion.a().w());
        elVar.c(vlVar).a(companion.a().A());
        ul ulVar = f4497a;
        ulVar.a(initRequest, elVar);
        long jB = companion.d().d().b();
        ulVar.a(jB, new c(elVar, initDuration, jB, initializationListener));
        aVarD.a(elVar);
        if (sdkConfig.a().getShouldRegisterTrigger()) {
            new eq(null, null, null, IronSourceThreadManager.INSTANCE.getThreadPoolExecutor(), 7, null).c(context);
        }
    }

    private final boolean a(LevelPlayInitRequest initRequest, LevelPlay.AdFormat adFormat) {
        return !initRequest.getLegacyAdFormats().contains(adFormat);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Context context, LevelPlayInitRequest initRequest, LevelPlayInitListener levelPlayInitListener) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(initRequest, "$initRequest");
        f4497a.c(context, initRequest, levelPlayInitListener);
    }

    private final void c(Context context, LevelPlayInitRequest initRequest, LevelPlayInitListener initializationListener) {
        ib ibVar = new ib();
        vl vlVar = tools;
        LevelPlay.AdFormat[] adFormatArr = (LevelPlay.AdFormat[]) initRequest.getLegacyAdFormats().toArray(new LevelPlay.AdFormat[0]);
        rr rrVar = new rr(initRequest.getAppKey(), initRequest.getUserId(), ArraysKt.toMutableList(vlVar.a((LevelPlay.AdFormat[]) Arrays.copyOf(adFormatArr, adFormatArr.length))));
        rrVar.e().isEmpty();
        yr.f4631a.a(context, rrVar, new a(initRequest, context, ibVar, initializationListener));
    }

    public final void a(final Context context, final LevelPlayInitRequest initRequest, final LevelPlayInitListener initializationListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initRequest, "initRequest");
        tools.d(new Runnable() { // from class: com.ironsource.ul$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                ul.b(context, initRequest, initializationListener);
            }
        });
    }
}
