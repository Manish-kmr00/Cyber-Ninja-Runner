package com.chartboost.sdk.impl;

import android.content.Context;
import android.view.SurfaceView;
import androidx.exifinterface.media.ExifInterface;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.chartboost.sdk.Mediation;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.bidmachine.iab.vast.tags.VastAttributes;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 y2\u00020\u00012\u00020\u0002:\u0001\u0018B¬\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010i\u001a\u00020\u0010\u0012\u0006\u0010k\u001a\u00020j\u0012\u0006\u0010l\u001a\u00020\u0010\u0012\u0006\u0010B\u001a\u00020A\u0012\u0006\u0010/\u001a\u00020-\u0012\u0006\u0010n\u001a\u00020m\u0012\u0006\u00103\u001a\u000200\u0012\u0006\u00106\u001a\u00020\u0010\u0012\b\u0010:\u001a\u0004\u0018\u000107\u0012{\u0010G\u001aw\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110>¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(?\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(@\u0012\u0013\u0012\u00110A¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(B\u0012\u0013\u0012\u00110-¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020C0;j\u0002`D\u0012\u0006\u0010p\u001a\u00020o\u0012\u0006\u0010I\u001a\u00020\u0010\u0012\u0006\u0010r\u001a\u00020q\u0012\u0006\u0010t\u001a\u00020s\u0012\u0006\u0010M\u001a\u00020J\u0012\u0006\u0010v\u001a\u00020u\u0012\u0006\u0010Q\u001a\u00020N\u0012\u0006\u0010U\u001a\u00020R\u0012\u0014\b\u0002\u0010Y\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\t0V¢\u0006\u0004\bw\u0010xJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u0011\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\u0013J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0005J\u000f\u0010\u001a\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001a\u0010\u0005J\u000f\u0010\u001b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001b\u0010\u0005J\u000f\u0010\u001c\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001c\u0010\u0005J\r\u0010\u001d\u001a\u00020\u0003¢\u0006\u0004\b\u001d\u0010\u0005J\r\u0010\u001e\u001a\u00020\u0003¢\u0006\u0004\b\u001e\u0010\u0005J\r\u0010\u001f\u001a\u00020\u0003¢\u0006\u0004\b\u001f\u0010\u0005J\r\u0010 \u001a\u00020\u0003¢\u0006\u0004\b \u0010\u0005J\r\u0010!\u001a\u00020\u0003¢\u0006\u0004\b!\u0010\u0005J\u0011\u0010$\u001a\u00060\"j\u0002`#¢\u0006\u0004\b$\u0010%J\u000f\u0010\u0018\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0018\u0010\u0005J\u0017\u0010\u0018\u001a\u00020\u00032\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b\u0018\u0010(J\u0017\u0010\u000e\u001a\u00020\u00032\u0006\u0010)\u001a\u00020&H\u0016¢\u0006\u0004\b\u000e\u0010(J\u000f\u0010*\u001a\u00020\u0003H\u0016¢\u0006\u0004\b*\u0010\u0005J\u0017\u0010\u000e\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u000e\u0010\u0013J\u000f\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u0005J\u000f\u0010,\u001a\u00020\u0003H\u0016¢\u0006\u0004\b,\u0010\u0005R\u0014\u0010/\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010.R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u00106\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0004\u0018\u0001078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0089\u0001\u0010G\u001aw\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110>¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(?\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(@\u0012\u0013\u0012\u00110A¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(B\u0012\u0013\u0012\u00110-¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020C0;j\u0002`D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010I\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u00105R\u0014\u0010M\u001a\u00020J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010Q\u001a\u00020N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0014\u0010U\u001a\u00020R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010TR \u0010Y\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\t0V8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010[\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010\bR\u0016\u0010]\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010\bR\u0016\u0010_\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010\bR\u0016\u0010a\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010 R\u0018\u0010e\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u0018\u0010h\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010g¨\u0006z"}, d2 = {"Lcom/chartboost/sdk/impl/pb;", "Lcom/chartboost/sdk/impl/o2;", "Lcom/chartboost/sdk/impl/q0;", "", "N", "()V", "F", "K", "J", "Lcom/chartboost/sdk/impl/p2;", "H", "()Lcom/chartboost/sdk/impl/p2;", "", "infoEvent", "a", "(Z)V", "", "trackingMsg", InneractiveMediationDefs.GENDER_FEMALE, "(Ljava/lang/String;)V", "e", "Landroid/content/Context;", "context", "Lcom/chartboost/sdk/impl/vb;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Landroid/content/Context;)Lcom/chartboost/sdk/impl/vb;", "z", VastAttributes.VERTICAL_POSITION, "w", "M", "L", ExifInterface.LONGITUDE_EAST, "I", "O", "", "Lcom/chartboost/sdk/internal/video/repository/DownloadState;", "G", "()I", "", "duration", "(J)V", com.ironsource.b9.h.L, "d", "error", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/chartboost/sdk/impl/f5;", "Lcom/chartboost/sdk/impl/f5;", "fileCache", "Lcom/chartboost/sdk/impl/qb;", "P", "Lcom/chartboost/sdk/impl/qb;", "videoRepository", "Q", "Ljava/lang/String;", "videoFilename", "Lcom/chartboost/sdk/Mediation;", "R", "Lcom/chartboost/sdk/Mediation;", "mediation", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "Landroid/view/SurfaceView;", "surface", "callback", "Lcom/chartboost/sdk/impl/sa;", "uiPoster", "Lcom/chartboost/sdk/impl/p0;", "Lcom/chartboost/sdk/internal/di/AdsVideoPlayerFactory;", ExifInterface.LATITUDE_SOUTH, "Lkotlin/jvm/functions/Function5;", "adsVideoPlayerFactory", "T", "templateHtml", "Lcom/chartboost/sdk/impl/i6;", "U", "Lcom/chartboost/sdk/impl/i6;", "impressionInterface", "Lcom/chartboost/sdk/impl/g7;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/chartboost/sdk/impl/g7;", "nativeBridgeCommand", "Lcom/chartboost/sdk/impl/m4;", ExifInterface.LONGITUDE_WEST, "Lcom/chartboost/sdk/impl/m4;", "eventTracker", "Lkotlin/Function1;", "X", "Lkotlin/jvm/functions/Function1;", "cbWebViewFactory", "Y", "protocolVideoDuration", "Z", "videoPlayTimestamp", "a0", "videoStartTimestamp", "b0", "getAssetDownloadStateAtVideoStart", "Lcom/chartboost/sdk/impl/hb;", "c0", "Lcom/chartboost/sdk/impl/hb;", "videoBase", "d0", "Lcom/chartboost/sdk/impl/p0;", "videoPlayer", "location", "Lcom/chartboost/sdk/impl/d7;", "mtype", "adUnitParameters", "Lcom/chartboost/sdk/impl/l2;", "templateProxy", "Lcom/chartboost/sdk/impl/g2;", "networkService", "Lcom/chartboost/sdk/impl/s7;", "openMeasurementImpressionCallback", "Lcom/chartboost/sdk/impl/j0;", "adUnitRendererImpressionCallback", "Lcom/chartboost/sdk/impl/yb;", "webViewTimeoutInterface", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lcom/chartboost/sdk/impl/d7;Ljava/lang/String;Lcom/chartboost/sdk/impl/sa;Lcom/chartboost/sdk/impl/f5;Lcom/chartboost/sdk/impl/l2;Lcom/chartboost/sdk/impl/qb;Ljava/lang/String;Lcom/chartboost/sdk/Mediation;Lkotlin/jvm/functions/Function5;Lcom/chartboost/sdk/impl/g2;Ljava/lang/String;Lcom/chartboost/sdk/impl/s7;Lcom/chartboost/sdk/impl/j0;Lcom/chartboost/sdk/impl/i6;Lcom/chartboost/sdk/impl/yb;Lcom/chartboost/sdk/impl/g7;Lcom/chartboost/sdk/impl/m4;Lkotlin/jvm/functions/Function1;)V", "e0", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class pb extends o2 implements q0 {

    /* JADX INFO: renamed from: O, reason: from kotlin metadata */
    public final f5 fileCache;

    /* JADX INFO: renamed from: P, reason: from kotlin metadata */
    public final qb videoRepository;

    /* JADX INFO: renamed from: Q, reason: from kotlin metadata */
    public final String videoFilename;

    /* JADX INFO: renamed from: R, reason: from kotlin metadata */
    public final Mediation mediation;

    /* JADX INFO: renamed from: S, reason: from kotlin metadata */
    public final Function5<Context, SurfaceView, q0, sa, f5, p0> adsVideoPlayerFactory;

    /* JADX INFO: renamed from: T, reason: from kotlin metadata */
    public final String templateHtml;

    /* JADX INFO: renamed from: U, reason: from kotlin metadata */
    public final i6 impressionInterface;

    /* JADX INFO: renamed from: V, reason: from kotlin metadata */
    public final g7 nativeBridgeCommand;

    /* JADX INFO: renamed from: W, reason: from kotlin metadata */
    public final m4 eventTracker;

    /* JADX INFO: renamed from: X, reason: from kotlin metadata */
    public final Function1<Context, p2> cbWebViewFactory;

    /* JADX INFO: renamed from: Y, reason: from kotlin metadata */
    public long protocolVideoDuration;

    /* JADX INFO: renamed from: Z, reason: from kotlin metadata */
    public long videoPlayTimestamp;

    /* JADX INFO: renamed from: a0, reason: from kotlin metadata */
    public long videoStartTimestamp;

    /* JADX INFO: renamed from: b0, reason: from kotlin metadata */
    public int getAssetDownloadStateAtVideoStart;

    /* JADX INFO: renamed from: c0, reason: from kotlin metadata */
    public hb videoBase;

    /* JADX INFO: renamed from: d0, reason: from kotlin metadata */
    public p0 videoPlayer;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/content/Context;", "it", "Lcom/chartboost/sdk/impl/p2;", "a", "(Landroid/content/Context;)Lcom/chartboost/sdk/impl/p2;"}, k = 3, mv = {1, 8, 0})
    public static final class a extends Lambda implements Function1<Context, p2> {
        public static final a b = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final p2 invoke(Context it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new p2(it);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public pb(Context context, String location, d7 mtype, String adUnitParameters, sa uiPoster, f5 fileCache, l2 templateProxy, qb videoRepository, String videoFilename, Mediation mediation, Function5<? super Context, ? super SurfaceView, ? super q0, ? super sa, ? super f5, ? extends p0> adsVideoPlayerFactory, g2 networkService, String templateHtml, s7 openMeasurementImpressionCallback, j0 adUnitRendererImpressionCallback, i6 impressionInterface, yb webViewTimeoutInterface, g7 nativeBridgeCommand, m4 eventTracker, Function1<? super Context, ? extends p2> cbWebViewFactory) {
        super(context, location, mtype, adUnitParameters, uiPoster, fileCache, networkService, templateProxy, mediation, templateHtml, openMeasurementImpressionCallback, adUnitRendererImpressionCallback, webViewTimeoutInterface, eventTracker, null, 16384, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(mtype, "mtype");
        Intrinsics.checkNotNullParameter(adUnitParameters, "adUnitParameters");
        Intrinsics.checkNotNullParameter(uiPoster, "uiPoster");
        Intrinsics.checkNotNullParameter(fileCache, "fileCache");
        Intrinsics.checkNotNullParameter(templateProxy, "templateProxy");
        Intrinsics.checkNotNullParameter(videoRepository, "videoRepository");
        Intrinsics.checkNotNullParameter(videoFilename, "videoFilename");
        Intrinsics.checkNotNullParameter(adsVideoPlayerFactory, "adsVideoPlayerFactory");
        Intrinsics.checkNotNullParameter(networkService, "networkService");
        Intrinsics.checkNotNullParameter(templateHtml, "templateHtml");
        Intrinsics.checkNotNullParameter(openMeasurementImpressionCallback, "openMeasurementImpressionCallback");
        Intrinsics.checkNotNullParameter(adUnitRendererImpressionCallback, "adUnitRendererImpressionCallback");
        Intrinsics.checkNotNullParameter(impressionInterface, "impressionInterface");
        Intrinsics.checkNotNullParameter(webViewTimeoutInterface, "webViewTimeoutInterface");
        Intrinsics.checkNotNullParameter(nativeBridgeCommand, "nativeBridgeCommand");
        Intrinsics.checkNotNullParameter(eventTracker, "eventTracker");
        Intrinsics.checkNotNullParameter(cbWebViewFactory, "cbWebViewFactory");
        this.fileCache = fileCache;
        this.videoRepository = videoRepository;
        this.videoFilename = videoFilename;
        this.mediation = mediation;
        this.adsVideoPlayerFactory = adsVideoPlayerFactory;
        this.templateHtml = templateHtml;
        this.impressionInterface = impressionInterface;
        this.nativeBridgeCommand = nativeBridgeCommand;
        this.eventTracker = eventTracker;
        this.cbWebViewFactory = cbWebViewFactory;
    }

    @Override // com.chartboost.sdk.impl.o2
    public vb b(Context context) {
        hb hbVar;
        Unit unit;
        Intrinsics.checkNotNullParameter(context, "context");
        this.nativeBridgeCommand.a(this.impressionInterface);
        b7.a("createViewObject()", (Throwable) null, 2, (Object) null);
        try {
            SurfaceView surfaceView = new SurfaceView(context);
            try {
                hbVar = new hb(context, this.templateHtml, getCustomWebViewInterface(), this.impressionInterface, this.nativeBridgeCommand, getBaseExternalPathURL(), surfaceView, null, this.eventTracker, this.cbWebViewFactory, 128, null);
            } catch (Exception e) {
                c("Can't instantiate VideoBase: " + e);
                hbVar = null;
            }
            this.videoBase = hbVar;
            p0 p0VarInvoke = this.adsVideoPlayerFactory.invoke(context, surfaceView, this, getUiPoster(), this.fileCache);
            gb gbVarB = this.videoRepository.b(this.videoFilename);
            if (gbVarB != null) {
                p0VarInvoke.a(gbVarB);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                b7.b("Video asset not found in the repository", null, 2, null);
            }
            this.videoPlayer = p0VarInvoke;
            return this.videoBase;
        } catch (Exception e2) {
            c("Can't instantiate SurfaceView: " + e2);
            return null;
        }
    }

    @Override // com.chartboost.sdk.impl.o2
    public void f() {
        b7.a("destroyView()", (Throwable) null, 2, (Object) null);
        F();
        super.f();
    }

    public /* synthetic */ pb(Context context, String str, d7 d7Var, String str2, sa saVar, f5 f5Var, l2 l2Var, qb qbVar, String str3, Mediation mediation, Function5 function5, g2 g2Var, String str4, s7 s7Var, j0 j0Var, i6 i6Var, yb ybVar, g7 g7Var, m4 m4Var, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, d7Var, str2, saVar, f5Var, l2Var, qbVar, str3, mediation, function5, g2Var, str4, s7Var, j0Var, i6Var, ybVar, g7Var, m4Var, (i & 524288) != 0 ? a.b : function1);
    }

    @Override // com.chartboost.sdk.impl.o2
    public void z() {
        b7.c("onResume()", null, 2, null);
        this.videoRepository.a(null, 1, false);
        p0 p0Var = this.videoPlayer;
        if (p0Var != null) {
            l1 l1Var = p0Var instanceof l1 ? (l1) p0Var : null;
            if (l1Var != null) {
                l1Var.a();
            }
            p0Var.play();
        }
        super.z();
    }

    @Override // com.chartboost.sdk.impl.o2
    public void y() {
        b7.c("onPause()", null, 2, null);
        p0 p0Var = this.videoPlayer;
        if (p0Var != null) {
            p0Var.pause();
        }
        super.y();
    }

    @Override // com.chartboost.sdk.impl.o2
    public void w() {
        hb hbVar = this.videoBase;
        int width = hbVar != null ? hbVar.getWidth() : 0;
        hb hbVar2 = this.videoBase;
        int height = hbVar2 != null ? hbVar2.getHeight() : 0;
        p0 p0Var = this.videoPlayer;
        if (!(p0Var instanceof l9)) {
            p0Var = null;
        }
        if (p0Var != null) {
            p0Var.a(width, height);
        }
    }

    public final void M() {
        b7.a("playVideo()", (Throwable) null, 2, (Object) null);
        N();
        this.videoPlayTimestamp = x9.a();
        p0 p0Var = this.videoPlayer;
        if (p0Var != null) {
            p0Var.play();
        }
    }

    public final void N() {
        getOpenMeasurementImpressionCallback().a(g8.FULLSCREEN);
        p0 p0Var = this.videoPlayer;
        if (p0Var != null && !p0Var.getWasMediaStartedForTheFirstTime()) {
            s7 openMeasurementImpressionCallback = getOpenMeasurementImpressionCallback();
            float f = this.protocolVideoDuration / 1000.0f;
            p0 p0Var2 = this.videoPlayer;
            openMeasurementImpressionCallback.a(f, p0Var2 != null ? p0Var2.getMediaPlayerVolume() : 1.0f);
            return;
        }
        getOpenMeasurementImpressionCallback().b();
    }

    public final void L() {
        b7.a("pauseVideo()", (Throwable) null, 2, (Object) null);
        getOpenMeasurementImpressionCallback().c();
        p0 p0Var = this.videoPlayer;
        if (p0Var != null) {
            p0Var.pause();
        }
    }

    public final void E() {
        F();
    }

    public final void I() {
        p0 p0Var = this.videoPlayer;
        if (p0Var != null) {
            p0Var.f();
        }
        getOpenMeasurementImpressionCallback().a(0.0f);
    }

    public final void O() {
        p0 p0Var = this.videoPlayer;
        if (p0Var != null) {
            p0Var.c();
        }
        getOpenMeasurementImpressionCallback().a(1.0f);
    }

    public final int G() {
        b7.a("getAssetDownloadStateNow()", (Throwable) null, 2, (Object) null);
        gb gbVarB = this.videoRepository.b(this.videoFilename);
        if (gbVarB != null) {
            return this.videoRepository.a(gbVarB);
        }
        return 0;
    }

    @Override // com.chartboost.sdk.impl.q0
    public void d() {
        b7.a("onVideoDisplayCompleted", (Throwable) null, 2, (Object) null);
        a(true);
        J();
        getOpenMeasurementImpressionCallback().a();
    }

    @Override // com.chartboost.sdk.impl.q0
    public void a() {
        getOpenMeasurementImpressionCallback().a(true);
    }

    @Override // com.chartboost.sdk.impl.q0
    public void a(String error) {
        Intrinsics.checkNotNullParameter(error, "error");
        b7.a("onVideoDisplayError: " + error, (Throwable) null, 2, (Object) null);
        a(false);
        l2 templateProxy = getTemplateProxy();
        if (templateProxy != null) {
            templateProxy.d(H(), getLocation(), getAdTypeTraitsName());
        }
        F();
        c(error);
    }

    @Override // com.chartboost.sdk.impl.q0
    public void c() {
        getOpenMeasurementImpressionCallback().a(false);
    }

    public final void F() {
        p0 p0Var = this.videoPlayer;
        if (p0Var != null) {
            p0Var.stop();
        }
        hb hbVar = this.videoBase;
        if (hbVar != null) {
            hbVar.b();
        }
        this.videoPlayer = null;
        this.videoBase = null;
    }

    public final void K() {
        b7.a("notifyTemplateVideoStarted() duration: " + this.protocolVideoDuration, (Throwable) null, 2, (Object) null);
        l2 templateProxy = getTemplateProxy();
        if (templateProxy != null) {
            templateProxy.b(H(), this.protocolVideoDuration / 1000.0f, getLocation(), getAdTypeTraitsName());
        }
    }

    public final void J() {
        l2 templateProxy = getTemplateProxy();
        if (templateProxy != null) {
            templateProxy.c(H(), getLocation(), getAdTypeTraitsName());
        }
    }

    public final p2 H() {
        hb hbVar = this.videoBase;
        if (hbVar != null) {
            return hbVar.getWebView();
        }
        return null;
    }

    public final void e(String trackingMsg) {
        long jA;
        long jA2;
        j4 j4Var = new j4(ma.j.FINISH_FAILURE, trackingMsg, getAdTypeTraitsName(), getLocation(), this.mediation);
        if (this.videoStartTimestamp == 0) {
            jA = this.videoPlayTimestamp;
            jA2 = x9.a();
        } else {
            jA = x9.a();
            jA2 = this.videoStartTimestamp;
        }
        j4Var.a(jA - jA2);
        j4Var.a(true);
        j4Var.b(false);
        track((ka) j4Var);
    }

    @Override // com.chartboost.sdk.impl.q0
    public void b(long duration) {
        b7.a("onVideoDisplayPrepared ready to receive signal from template, duration: " + duration, (Throwable) null, 2, (Object) null);
        this.getAssetDownloadStateAtVideoStart = G();
        this.protocolVideoDuration = duration;
        x();
    }

    public final void f(String trackingMsg) {
        r6 r6Var = new r6(ma.j.FINISH_SUCCESS, trackingMsg, getAdTypeTraitsName(), getLocation(), this.mediation, null, 32, null);
        r6Var.a(this.videoStartTimestamp - this.videoPlayTimestamp);
        r6Var.a(true);
        r6Var.b(false);
        track((ka) r6Var);
    }

    @Override // com.chartboost.sdk.impl.q0
    public void b() {
        b7.a("onVideoDisplayStarted", (Throwable) null, 2, (Object) null);
        K();
        this.videoStartTimestamp = x9.a();
    }

    @Override // com.chartboost.sdk.impl.q0
    public void a(long position) {
        float f = position / 1000.0f;
        float f2 = this.protocolVideoDuration / 1000.0f;
        if (k9.f1061a.d()) {
            b7.c("onVideoDisplayProgress: " + f + '/' + f2, null, 2, null);
        }
        l2 templateProxy = getTemplateProxy();
        if (templateProxy != null) {
            templateProxy.a(H(), f, getLocation(), getAdTypeTraitsName());
        }
        a(f2, f);
    }

    public final void a(boolean infoEvent) {
        String strValueOf = String.valueOf(this.getAssetDownloadStateAtVideoStart);
        if (infoEvent) {
            f(strValueOf);
        } else {
            e(strValueOf);
        }
    }
}
