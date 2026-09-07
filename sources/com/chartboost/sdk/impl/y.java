package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.amazon.device.ads.DTBMetricsConfiguration;
import com.chartboost.sdk.Mediation;
import com.chartboost.sdk.internal.Model.CBError;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import com.smaato.sdk.video.vast.model.Ad;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.pubnative.lite.sdk.analytics.Reporting;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    jadx.core.utils.exceptions.JadxRuntimeException: CodeVar not initialized for name set in SSAVar: r16v0 ??
    	at jadx.core.dex.instructions.args.SSAVar.setName(SSAVar.java:216)
    	at jadx.core.dex.instructions.args.RegisterArg.setName(RegisterArg.java:111)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.renameMethodArgs(KotlinMetadataDecompilePass.kt:54)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:34)
    */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BQ\u0012\u0006\u0010K\u001a\u00020I\u0012\u0006\u0010N\u001a\u00020L\u0012\u0006\u0010Q\u001a\u00020O\u0012\u0006\u0010T\u001a\u00020R\u0012\u0006\u0010W\u001a\u00020U\u0012\u0006\u0010Z\u001a\u00020X\u0012\u0006\u0010]\u001a\u00020[\u0012\b\u0010`\u001a\u0004\u0018\u00010^\u0012\u0006\u0010c\u001a\u00020\u0003¢\u0006\u0004\bo\u0010pJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u001f\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u001b\u0010\u000e\u001a\u00020\u0006*\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u0010J\u001b\u0010\f\u001a\u00020\u0006*\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\u0010J\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\bJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\bJ\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\bJ\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\bJ!\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u000e\u0010\u0016J\u0019\u0010\u000e\u001a\u00020\u00172\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u000e\u0010\u0018J\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\bJ\u001f\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u000e\u0010\u0019J\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\f\u0010\u0019J#\u0010\u000e\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0004\b\u000e\u0010 J\u001f\u0010\u000e\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u000e\u0010#J\u001b\u0010\u000e\u001a\u00020\u0006*\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u000e\u0010$J#\u0010\u000e\u001a\u00020\u0006*\u00020\u00142\u0006\u0010%\u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u000e\u0010&J \u0010(\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001aH\u0096\u0001¢\u0006\u0004\b(\u0010)J\u0018\u0010,\u001a\u00020\u00062\u0006\u0010+\u001a\u00020*H\u0096\u0001¢\u0006\u0004\b,\u0010-J\u0018\u0010.\u001a\u00020\u00062\u0006\u0010+\u001a\u00020*H\u0096\u0001¢\u0006\u0004\b.\u0010-J\u0018\u00101\u001a\u00020\u00062\u0006\u00100\u001a\u00020/H\u0096\u0001¢\u0006\u0004\b1\u00102J\u0018\u00105\u001a\u00020\u00062\u0006\u00104\u001a\u000203H\u0096\u0001¢\u0006\u0004\b5\u00106J\u0018\u00107\u001a\u00020\u00062\u0006\u0010+\u001a\u00020*H\u0096\u0001¢\u0006\u0004\b7\u0010-J\u0014\u0010,\u001a\u00020**\u00020*H\u0096\u0001¢\u0006\u0004\b,\u00108J\u0014\u0010.\u001a\u00020**\u00020*H\u0096\u0001¢\u0006\u0004\b.\u00108J\u0014\u00101\u001a\u00020/*\u00020/H\u0096\u0001¢\u0006\u0004\b1\u00109J\u0014\u00105\u001a\u000203*\u000203H\u0096\u0001¢\u0006\u0004\b5\u0010:J\u0014\u00107\u001a\u00020**\u00020*H\u0096\u0001¢\u0006\u0004\b7\u00108J\u000f\u0010\u000e\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000e\u0010;J5\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010=\u001a\u00020<2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010?¢\u0006\u0004\b\u000e\u0010AJ\r\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010BJ\u001f\u0010\u000e\u001a\u00020\u00062\u0006\u0010C\u001a\u00020\u00042\u0006\u0010E\u001a\u00020DH\u0016¢\u0006\u0004\b\u000e\u0010FJ\u001f\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010G\u001a\u00020!H\u0016¢\u0006\u0004\b\u000e\u0010HR\u0014\u0010K\u001a\u00020I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010JR\u0014\u0010N\u001a\u00020L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010MR\u0014\u0010Q\u001a\u00020O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010PR\u0014\u0010T\u001a\u00020R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010SR\u0014\u0010W\u001a\u00020U8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010VR\u0014\u0010Z\u001a\u00020X8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010YR\u0014\u0010]\u001a\u00020[8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\\R\u0016\u0010`\u001a\u0004\u0018\u00010^8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010_R\u0014\u0010c\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0018\u0010f\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010hR\u0018\u0010@\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u0014\u0010n\u001a\u00020k8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bl\u0010m¨\u0006q"}, d2 = {"Lcom/chartboost/sdk/impl/y;", "Lcom/chartboost/sdk/impl/a0;", "Lcom/chartboost/sdk/impl/f1;", "Lcom/chartboost/sdk/impl/m4;", "Lcom/chartboost/sdk/impl/y0;", "appRequest", "", "h", "(Lcom/chartboost/sdk/impl/y0;)V", "g", "Lcom/chartboost/sdk/impl/z6;", "params", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Lcom/chartboost/sdk/impl/y0;Lcom/chartboost/sdk/impl/z6;)V", "a", "Lcom/chartboost/sdk/impl/a7;", "(Lcom/chartboost/sdk/impl/a7;Lcom/chartboost/sdk/impl/y0;)V", "d", "e", InneractiveMediationDefs.GENDER_FEMALE, "Lcom/chartboost/sdk/internal/Model/CBError;", "error", "(Lcom/chartboost/sdk/impl/y0;Lcom/chartboost/sdk/internal/Model/CBError;)V", "Lcom/chartboost/sdk/internal/Model/CBError$b;", "(Lcom/chartboost/sdk/internal/Model/CBError;)Lcom/chartboost/sdk/internal/Model/CBError$b;", "(Lcom/chartboost/sdk/impl/y0;Lcom/chartboost/sdk/internal/Model/CBError$b;)V", "", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "(Lcom/chartboost/sdk/impl/y0;)Ljava/lang/String;", "location", "Lcom/chartboost/sdk/impl/v;", "adUnit", "(Ljava/lang/String;Lcom/chartboost/sdk/impl/v;)V", "Lcom/chartboost/sdk/impl/ma;", com.ironsource.b9.h.j0, "(Lcom/chartboost/sdk/impl/ma;Ljava/lang/String;)V", "(Lcom/chartboost/sdk/internal/Model/CBError;Ljava/lang/String;)V", "name", "(Lcom/chartboost/sdk/internal/Model/CBError;Lcom/chartboost/sdk/impl/ma;Ljava/lang/String;)V", "type", "clear", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/chartboost/sdk/impl/ka;", "event", "clearFromStorage", "(Lcom/chartboost/sdk/impl/ka;)V", "persist", "Lcom/chartboost/sdk/impl/ia;", DTBMetricsConfiguration.CONFIG_DIR, ToolBar.REFRESH, "(Lcom/chartboost/sdk/impl/ia;)V", "Lcom/chartboost/sdk/impl/da;", Reporting.Key.CLICK_SOURCE_TYPE_AD, com.ironsource.b9.h.U, "(Lcom/chartboost/sdk/impl/da;)V", "track", "(Lcom/chartboost/sdk/impl/ka;)Lcom/chartboost/sdk/impl/ka;", "(Lcom/chartboost/sdk/impl/ia;)Lcom/chartboost/sdk/impl/ia;", "(Lcom/chartboost/sdk/impl/da;)Lcom/chartboost/sdk/impl/da;", "()Lcom/chartboost/sdk/impl/y0;", "Lcom/chartboost/sdk/impl/z;", "callback", "bidResponse", "Lcom/chartboost/sdk/impl/w;", "bannerData", "(Ljava/lang/String;Lcom/chartboost/sdk/impl/z;Ljava/lang/String;Lcom/chartboost/sdk/impl/w;)V", "()V", "request", "Lcom/chartboost/sdk/impl/g1;", "resultAsset", "(Lcom/chartboost/sdk/impl/y0;Lcom/chartboost/sdk/impl/g1;)V", "trackingEventName", "(Lcom/chartboost/sdk/impl/y0;Lcom/chartboost/sdk/impl/ma;)V", "Lcom/chartboost/sdk/impl/u;", "Lcom/chartboost/sdk/impl/u;", Ad.AD_TYPE, "Lcom/chartboost/sdk/impl/f5;", "Lcom/chartboost/sdk/impl/f5;", "fileCache", "Lcom/chartboost/sdk/impl/h2;", "Lcom/chartboost/sdk/impl/h2;", "reachability", "Lcom/chartboost/sdk/impl/qb;", "Lcom/chartboost/sdk/impl/qb;", "videoRepository", "Lcom/chartboost/sdk/impl/j1;", "Lcom/chartboost/sdk/impl/j1;", "assetsDownloader", "Lcom/chartboost/sdk/impl/l;", "Lcom/chartboost/sdk/impl/l;", "adLoader", "Lcom/chartboost/sdk/impl/c8;", "Lcom/chartboost/sdk/impl/c8;", "ortbLoader", "Lcom/chartboost/sdk/Mediation;", "Lcom/chartboost/sdk/Mediation;", "mediation", "i", "Lcom/chartboost/sdk/impl/m4;", "eventTracker", "j", "Lcom/chartboost/sdk/impl/y0;", "appRequestStored", CampaignEx.JSON_KEY_AD_K, "Lcom/chartboost/sdk/impl/z;", "l", "Lcom/chartboost/sdk/impl/w;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "m", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isLoading", "<init>", "(Lcom/chartboost/sdk/impl/u;Lcom/chartboost/sdk/impl/f5;Lcom/chartboost/sdk/impl/h2;Lcom/chartboost/sdk/impl/qb;Lcom/chartboost/sdk/impl/j1;Lcom/chartboost/sdk/impl/l;Lcom/chartboost/sdk/impl/c8;Lcom/chartboost/sdk/Mediation;Lcom/chartboost/sdk/impl/m4;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class y implements a0, f1, m4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f1195a;
    public final f5 b;
    public final h2 c;
    public final qb d;
    public final j1 e;
    public final l f;
    public final c8 g;
    public final Mediation h;
    public final m4 i;
    public y0 j;
    public z k;
    public w l;
    public final AtomicBoolean m;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1196a;

        static {
            int[] iArr = new int[g1.values().length];
            try {
                iArr[g1.FAILURE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[g1.READY_TO_SHOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[g1.SUCCESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f1196a = iArr;
        }
    }

    public y(u adType, f5 fileCache, h2 reachability, qb videoRepository, j1 assetsDownloader, l adLoader, c8 ortbLoader, Mediation mediation, m4 eventTracker) {
        Intrinsics.checkNotNullParameter(adType, "adType");
        Intrinsics.checkNotNullParameter(fileCache, "fileCache");
        Intrinsics.checkNotNullParameter(reachability, "reachability");
        Intrinsics.checkNotNullParameter(videoRepository, "videoRepository");
        Intrinsics.checkNotNullParameter(assetsDownloader, "assetsDownloader");
        Intrinsics.checkNotNullParameter(adLoader, "adLoader");
        Intrinsics.checkNotNullParameter(ortbLoader, "ortbLoader");
        Intrinsics.checkNotNullParameter(eventTracker, "eventTracker");
        this.f1195a = adType;
        this.b = fileCache;
        this.c = reachability;
        this.d = videoRepository;
        this.e = assetsDownloader;
        this.f = adLoader;
        this.g = ortbLoader;
        this.h = mediation;
        this.i = eventTracker;
        this.m = new AtomicBoolean(false);
    }

    @Override // com.chartboost.sdk.impl.l4
    public void clear(String type, String location) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(location, "location");
        this.i.clear(type, location);
    }

    @Override // com.chartboost.sdk.impl.m4
    public ka clearFromStorage(ka kaVar) {
        Intrinsics.checkNotNullParameter(kaVar, "<this>");
        return this.i.clearFromStorage(kaVar);
    }

    @Override // com.chartboost.sdk.impl.m4
    public ka persist(ka kaVar) {
        Intrinsics.checkNotNullParameter(kaVar, "<this>");
        return this.i.persist(kaVar);
    }

    @Override // com.chartboost.sdk.impl.m4
    public ia refresh(ia iaVar) {
        Intrinsics.checkNotNullParameter(iaVar, "<this>");
        return this.i.refresh(iaVar);
    }

    @Override // com.chartboost.sdk.impl.m4
    public da store(da daVar) {
        Intrinsics.checkNotNullParameter(daVar, "<this>");
        return this.i.store(daVar);
    }

    @Override // com.chartboost.sdk.impl.m4
    public ka track(ka kaVar) {
        Intrinsics.checkNotNullParameter(kaVar, "<this>");
        return this.i.track(kaVar);
    }

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: clearFromStorage */
    public void mo4737clearFromStorage(ka event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.i.mo4737clearFromStorage(event);
    }

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: persist */
    public void mo4738persist(ka event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.i.mo4738persist(event);
    }

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: refresh */
    public void mo4739refresh(ia config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.i.mo4739refresh(config);
    }

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: store */
    public void mo4740store(da ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        this.i.mo4740store(ad);
    }

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: track */
    public void mo4741track(ka event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.i.mo4741track(event);
    }

    public final void h(y0 appRequest) {
        try {
            g(appRequest);
        } catch (Exception e2) {
            b7.b("sendAdGetRequest", e2);
            a(appRequest, new CBError(CBError.c.MISCELLANEOUS, "error sending ad-get request"));
        }
    }

    public final void g(y0 appRequest) {
        w wVar = this.l;
        Integer numValueOf = wVar != null ? Integer.valueOf(wVar.getBannerHeight()) : null;
        w wVar2 = this.l;
        Pair<Function2<y0, z6, Unit>, z6> pairA = c0.f982a.a(appRequest, new z6(appRequest, true, numValueOf, wVar2 != null ? Integer.valueOf(wVar2.getBannerWidth()) : null), new d(this), new e(this));
        pairA.component1().invoke(appRequest, pairA.component2());
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class d extends FunctionReferenceImpl implements Function2<y0, z6, Unit> {
        public d(Object obj) {
            super(2, obj, y.class, "loadOpenRTBAd", "loadOpenRTBAd(Lcom/chartboost/sdk/internal/AdUnitManager/data/AppRequest;Lcom/chartboost/sdk/internal/AdUnitManager/loaders/LoadParams;)V", 0);
        }

        public final void a(y0 p0, z6 p1) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            Intrinsics.checkNotNullParameter(p1, "p1");
            ((y) this.receiver).b(p0, p1);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(y0 y0Var, z6 z6Var) {
            a(y0Var, z6Var);
            return Unit.INSTANCE;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class e extends FunctionReferenceImpl implements Function2<y0, z6, Unit> {
        public e(Object obj) {
            super(2, obj, y.class, "loadAdGet", "loadAdGet(Lcom/chartboost/sdk/internal/AdUnitManager/data/AppRequest;Lcom/chartboost/sdk/internal/AdUnitManager/loaders/LoadParams;)V", 0);
        }

        public final void a(y0 p0, z6 p1) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            Intrinsics.checkNotNullParameter(p1, "p1");
            ((y) this.receiver).a(p0, p1);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(y0 y0Var, z6 z6Var) {
            a(y0Var, z6Var);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/chartboost/sdk/impl/a7;", "", "a", "(Lcom/chartboost/sdk/impl/a7;)V"}, k = 3, mv = {1, 8, 0})
    public static final class c extends Lambda implements Function1<a7, Unit> {
        public final /* synthetic */ y0 b;
        public final /* synthetic */ y c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(y0 y0Var, y yVar) {
            super(1);
            this.b = y0Var;
            this.c = yVar;
        }

        public final void a(a7 loadAd) {
            Intrinsics.checkNotNullParameter(loadAd, "$this$loadAd");
            n.a(loadAd, new a(this.b, this.c), new b(this.c, this.b));
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/chartboost/sdk/impl/a7;", "", "a", "(Lcom/chartboost/sdk/impl/a7;)V"}, k = 3, mv = {1, 8, 0})
        public static final class a extends Lambda implements Function1<a7, Unit> {
            public final /* synthetic */ y0 b;
            public final /* synthetic */ y c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(y0 y0Var, y yVar) {
                super(1);
                this.b = y0Var;
                this.c = yVar;
            }

            public final void a(a7 fold) {
                Intrinsics.checkNotNullParameter(fold, "$this$fold");
                this.b.a(fold.getAdUnit());
                this.c.e(this.b);
                this.c.b(fold, this.b);
                this.c.a(this.b, ma.a.FINISH_SUCCESS);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(a7 a7Var) {
                a(a7Var);
                return Unit.INSTANCE;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/chartboost/sdk/impl/a7;", "Lcom/chartboost/sdk/internal/Model/CBError;", "it", "", "a", "(Lcom/chartboost/sdk/impl/a7;Lcom/chartboost/sdk/internal/Model/CBError;)V"}, k = 3, mv = {1, 8, 0})
        public static final class b extends Lambda implements Function2<a7, CBError, Unit> {
            public final /* synthetic */ y b;
            public final /* synthetic */ y0 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(y yVar, y0 y0Var) {
                super(2);
                this.b = yVar;
                this.c = y0Var;
            }

            public final void a(a7 fold, CBError it) {
                Intrinsics.checkNotNullParameter(fold, "$this$fold");
                Intrinsics.checkNotNullParameter(it, "it");
                this.b.a(fold, this.c);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(a7 a7Var, CBError cBError) {
                a(a7Var, cBError);
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(a7 a7Var) {
            a(a7Var);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/chartboost/sdk/impl/a7;", "", "a", "(Lcom/chartboost/sdk/impl/a7;)V"}, k = 3, mv = {1, 8, 0})
    public static final class b extends Lambda implements Function1<a7, Unit> {
        public final /* synthetic */ y0 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(y0 y0Var) {
            super(1);
            this.c = y0Var;
        }

        public final void a(a7 loadAd) {
            Intrinsics.checkNotNullParameter(loadAd, "$this$loadAd");
            n.a(loadAd, new a(y.this, this.c), new C0265b(y.this, this.c));
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/chartboost/sdk/impl/a7;", "", "a", "(Lcom/chartboost/sdk/impl/a7;)V"}, k = 3, mv = {1, 8, 0})
        public static final class a extends Lambda implements Function1<a7, Unit> {
            public final /* synthetic */ y b;
            public final /* synthetic */ y0 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(y yVar, y0 y0Var) {
                super(1);
                this.b = yVar;
                this.c = y0Var;
            }

            public final void a(a7 fold) {
                Intrinsics.checkNotNullParameter(fold, "$this$fold");
                this.b.b(fold, this.c);
                this.b.b(this.c);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(a7 a7Var) {
                a(a7Var);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.chartboost.sdk.impl.y$b$b, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/chartboost/sdk/impl/a7;", "Lcom/chartboost/sdk/internal/Model/CBError;", "error", "", "a", "(Lcom/chartboost/sdk/impl/a7;Lcom/chartboost/sdk/internal/Model/CBError;)V"}, k = 3, mv = {1, 8, 0})
        public static final class C0265b extends Lambda implements Function2<a7, CBError, Unit> {
            public final /* synthetic */ y b;
            public final /* synthetic */ y0 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0265b(y yVar, y0 y0Var) {
                super(2);
                this.b = yVar;
                this.c = y0Var;
            }

            public final void a(a7 fold, CBError error) {
                Intrinsics.checkNotNullParameter(fold, "$this$fold");
                Intrinsics.checkNotNullParameter(error, "error");
                this.b.a(error, this.c.getLocation());
                this.b.a(fold, this.c);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(a7 a7Var, CBError cBError) {
                a(a7Var, cBError);
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(a7 a7Var) {
            a(a7Var);
            return Unit.INSTANCE;
        }
    }

    public final void d(y0 appRequest) {
        b(appRequest, CBError.b.ASSETS_DOWNLOAD_FAILURE);
        f(appRequest);
    }

    public final void e(y0 appRequest) {
        String str;
        String videoFilename;
        v adUnit = appRequest.getAdUnit();
        if (adUnit == null || !adUnit.getIsPrecacheVideoAd()) {
            return;
        }
        qb qbVar = this.d;
        v adUnit2 = appRequest.getAdUnit();
        String str2 = "";
        if (adUnit2 == null || (str = adUnit2.getIo.bidmachine.unified.UnifiedMediationParams.KEY_VIDEO_URL java.lang.String()) == null) {
            str = "";
        }
        v adUnit3 = appRequest.getAdUnit();
        if (adUnit3 != null && (videoFilename = adUnit3.getVideoFilename()) != null) {
            str2 = videoFilename;
        }
        qbVar.a(str, str2, false, null);
    }

    public final void f(y0 appRequest) {
        a(appRequest);
        appRequest.a((v) null);
        this.m.set(false);
    }

    public final String c(y0 appRequest) {
        v adUnit = appRequest.getAdUnit();
        if (adUnit != null) {
            return adUnit.getImpressionId();
        }
        return null;
    }

    public final void b(y0 appRequest) {
        this.e.a(appRequest, this.f1195a.getName(), this, this);
    }

    public final void a(y0 appRequest) {
        String name;
        m4 m4Var = this.i;
        v adUnit = appRequest.getAdUnit();
        if (adUnit == null || (name = adUnit.getName()) == null) {
            name = "";
        }
        m4Var.clear(name, appRequest.getLocation());
    }

    public final void b(y0 appRequest, z6 params) {
        this.g.a(params, new c(appRequest, this));
    }

    public final void b() {
        if (this.m.get()) {
            return;
        }
        y0 y0Var = this.j;
        if (y0Var != null) {
            a(y0Var);
            y0Var.a((v) null);
        }
        this.j = null;
    }

    public final void a(a7 a7Var, y0 y0Var) {
        a(y0Var.getLocation(), (v) null);
        a(y0Var, a7Var.getError());
    }

    public final y0 a() {
        return this.j;
    }

    public final void b(y0 appRequest, CBError.b error) {
        this.m.set(false);
        a(appRequest, error);
        if (error == CBError.b.NO_AD_FOUND) {
            return;
        }
        StringBuilder sbAppend = new StringBuilder("reportError: adTypeTraits: ").append(this.f1195a.getName()).append(" reason: cache  format: web error: ").append(error).append(" adId: ");
        v adUnit = appRequest.getAdUnit();
        b7.b(sbAppend.append(adUnit != null ? adUnit.getAdId() : null).append(" appRequest.location: ").append(appRequest.getLocation()).toString(), null, 2, null);
    }

    public final CBError.b a(CBError error) {
        return (error != null ? error.getImpressionError() : null) != null ? error.getImpressionError() : CBError.b.INTERNAL;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r14v0 ??, still in use, count: 2, list:
          (r14v0 ?? I:com.chartboost.sdk.impl.y0) from 0x0064: INVOKE (r14v0 ?? I:com.chartboost.sdk.impl.y0), (r19v0 ?? I:com.chartboost.sdk.impl.w) VIRTUAL call: com.chartboost.sdk.impl.y0.a(com.chartboost.sdk.impl.w):void A[MD:(com.chartboost.sdk.impl.w):void (m)] (LINE:992)
          (r14v0 ?? I:com.chartboost.sdk.impl.y0) from 0x0067: IPUT (r14v0 ?? I:com.chartboost.sdk.impl.y0), (r15v0 'this' ?? I:com.chartboost.sdk.impl.y A[IMMUTABLE_TYPE, THIS]) (LINE:993) com.chartboost.sdk.impl.y.j com.chartboost.sdk.impl.y0
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    public final void a(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r14v0 ??, still in use, count: 2, list:
          (r14v0 ?? I:com.chartboost.sdk.impl.y0) from 0x0064: INVOKE (r14v0 ?? I:com.chartboost.sdk.impl.y0), (r19v0 ?? I:com.chartboost.sdk.impl.w) VIRTUAL call: com.chartboost.sdk.impl.y0.a(com.chartboost.sdk.impl.w):void A[MD:(com.chartboost.sdk.impl.w):void (m)] (LINE:992)
          (r14v0 ?? I:com.chartboost.sdk.impl.y0) from 0x0067: IPUT (r14v0 ?? I:com.chartboost.sdk.impl.y0), (r15v0 'this' ?? I:com.chartboost.sdk.impl.y A[IMMUTABLE_TYPE, THIS]) (LINE:993) com.chartboost.sdk.impl.y.j com.chartboost.sdk.impl.y0
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r16v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:215)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
        	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
        	at jadx.core.ProcessClass.process(ProcessClass.java:89)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
        */

    public static /* synthetic */ void a(y yVar, String str, z zVar, String str2, w wVar, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            wVar = null;
        }
        yVar.a(str, zVar, str2, wVar);
    }

    public final void b(a7 a7Var, y0 y0Var) {
        a(y0Var.getLocation(), a7Var.getAdUnit());
        y0Var.a(a7Var.getAdUnit());
    }

    public final void a(y0 appRequest, z6 params) {
        this.f.a(params, new b(appRequest));
    }

    public final void a(y0 appRequest, CBError error) {
        b(appRequest, a(error));
        f(appRequest);
    }

    @Override // com.chartboost.sdk.impl.a0
    public void a(y0 appRequest, ma trackingEventName) {
        Intrinsics.checkNotNullParameter(appRequest, "appRequest");
        Intrinsics.checkNotNullParameter(trackingEventName, "trackingEventName");
        z zVar = this.k;
        if (zVar != null) {
            zVar.a(c(appRequest), trackingEventName);
        }
        this.m.set(false);
    }

    @Override // com.chartboost.sdk.impl.f1
    public void a(y0 request, g1 resultAsset) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(resultAsset, "resultAsset");
        int i = a.f1196a[resultAsset.ordinal()];
        if (i == 1) {
            d(request);
        } else if (i == 2) {
            b7.a("onAssetDownloaded: Ready to show", (Throwable) null, 2, (Object) null);
        } else {
            if (i != 3) {
                return;
            }
            b7.a("onAssetDownloaded: Success", (Throwable) null, 2, (Object) null);
        }
    }

    public final void a(y0 appRequest, CBError.b error) {
        z zVar = this.k;
        if (zVar != null) {
            zVar.a(c(appRequest), error);
        }
    }

    public final void a(String location, v adUnit) {
        String template;
        String strB;
        String str;
        String str2;
        String impressionId;
        if (location == null) {
            location = "no location";
        }
        store(new da(location, this.f1195a.getName(), (adUnit == null || (impressionId = adUnit.getImpressionId()) == null) ? "" : impressionId, (adUnit == null || (str2 = adUnit.getNet.pubnative.lite.sdk.analytics.Reporting.Key.CREATIVE java.lang.String()) == null) ? "" : str2, (adUnit == null || (str = adUnit.getCom.smaato.sdk.video.vast.model.MediaFile.MEDIA_TYPE java.lang.String()) == null) ? "" : str, (adUnit == null || (strB = adUnit.b()) == null) ? "" : strB, (adUnit == null || (template = adUnit.getTemplate()) == null) ? "" : template, x.a(this.l)));
    }

    public final void a(CBError cBError, String str) {
        CBError.d type = cBError.getType();
        if (type == CBError.c.HTTP_NOT_FOUND || type == CBError.c.HTTP_NOT_OK) {
            a(cBError, ma.a.SERVER_ERROR, str);
        } else if (type == CBError.c.UNSUPPORTED_OS_VERSION) {
            a(cBError, ma.f.UNSUPPORTED_OS_VERSION, str);
        } else {
            a(cBError, ma.a.REQUEST_ERROR, str);
        }
    }

    public final void a(CBError cBError, ma maVar, String str) {
        String message = cBError.getMessage();
        if (message == null) {
            message = "";
        }
        track((ka) new j4(maVar, message, this.f1195a.getName(), str, this.h));
    }

    public final void a(ma eventName, String location) {
        track((ka) new r6(eventName, "", this.f1195a.getName(), location, this.h, null, 32, null));
    }
}
