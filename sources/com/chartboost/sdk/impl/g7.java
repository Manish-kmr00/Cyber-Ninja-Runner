package com.chartboost.sdk.impl;

import android.content.ActivityNotFoundException;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.pubmatic.sdk.nativead.POBNativeConstants;
import io.bidmachine.unified.UnifiedMediationParams;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u001c\u0012\u0006\u0010!\u001a\u00020\u001f¢\u0006\u0004\b,\u0010-J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u000bJ\u0019\u0010\u0007\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u0019\u0010\u0010\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u000eJ\u0019\u0010\u0012\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0012\u0010\u000eJ\u0019\u0010\u0013\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0013\u0010\u000eJ\u0019\u0010\u0014\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0014\u0010\u000eJ\u0019\u0010\r\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0015\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0015\u0010\u000eJ\u0019\u0010\f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\f\u0010\u000eJ\u0019\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0010\u0010\u000bJ\u000f\u0010\u0013\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0013\u0010\u000bJ\u000f\u0010\u0011\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0011\u0010\u000bJ\u001d\u0010\u0013\u001a\u00020\u0006*\u0004\u0018\u00010\u00022\u0006\u0010\u0016\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0017J\u0015\u0010\u0007\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u0007\u0010\u001aJ\r\u0010\u0007\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\u000bJ\u001f\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001b\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\u0017R\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001dR\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010 R$\u0010'\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010#\u001a\u0004\b$\u0010%\"\u0004\b\u0007\u0010&R\u0016\u0010*\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010)R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010+¨\u0006."}, d2 = {"Lcom/chartboost/sdk/impl/g7;", "", "Lorg/json/JSONObject;", "args", "Lcom/chartboost/sdk/impl/h7;", "nativeCmd", "", "a", "(Lorg/json/JSONObject;Lcom/chartboost/sdk/impl/h7;)Ljava/lang/String;", "", "g", "()V", InneractiveMediationDefs.GENDER_FEMALE, "e", "(Lorg/json/JSONObject;)V", "i", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "d", CampaignEx.JSON_KEY_AD_K, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "j", "h", "logMsg", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;", "Lcom/chartboost/sdk/impl/i6;", "impressionInterface", "(Lcom/chartboost/sdk/impl/i6;)V", com.ironsource.b9.f.b, "Lcom/chartboost/sdk/impl/sa;", "Lcom/chartboost/sdk/impl/sa;", "uiPost", "Lcom/chartboost/sdk/impl/wa;", "Lcom/chartboost/sdk/impl/wa;", "urlParser", "Lcom/chartboost/sdk/impl/n5;", "Lcom/chartboost/sdk/impl/n5;", "getHideViewCallback", "()Lcom/chartboost/sdk/impl/n5;", "(Lcom/chartboost/sdk/impl/n5;)V", "hideViewCallback", "", "F", "videoDuration", "Lcom/chartboost/sdk/impl/i6;", "<init>", "(Lcom/chartboost/sdk/impl/sa;Lcom/chartboost/sdk/impl/wa;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class g7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final sa uiPost;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final wa urlParser;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public n5 hideViewCallback;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public float videoDuration;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public i6 impressionInterface;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1029a;

        static {
            int[] iArr = new int[h7.values().length];
            try {
                iArr[h7.GET_PARAMETERS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[h7.GET_MAX_SIZE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[h7.GET_SCREEN_SIZE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[h7.GET_CURRENT_POSITION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[h7.GET_DEFAULT_POSITION.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[h7.GET_ORIENTATION_PROPERTIES.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[h7.CLICK.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[h7.CLOSE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[h7.SKIPPED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[h7.VIDEO_COMPLETED.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[h7.VIDEO_RESUMED.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[h7.VIDEO_PAUSED.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[h7.VIDEO_REPLAY.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[h7.CURRENT_VIDEO_DURATION.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[h7.TOTAL_VIDEO_DURATION.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[h7.SHOW.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[h7.ERROR.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[h7.WARNING.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[h7.DEBUG.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[h7.TRACKING.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[h7.OPEN_URL.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[h7.SET_ORIENTATION_PROPERTIES.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[h7.REWARD.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[h7.REWARDED_VIDEO_COMPLETED.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[h7.PLAY_VIDEO.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[h7.PAUSE_VIDEO.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr[h7.CLOSE_VIDEO.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr[h7.MUTE_VIDEO.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr[h7.UNMUTE_VIDEO.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                iArr[h7.OM_MEASUREMENT_RESOURCES.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                iArr[h7.START.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                iArr[h7.BUFFER_START.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                iArr[h7.BUFFER_END.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                iArr[h7.VIDEO_FINISHED.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                iArr[h7.VIDEO_STARTED.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                iArr[h7.ON_FOREGROUND.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                iArr[h7.VIDEO_ENDED.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                iArr[h7.VIDEO_FAILED.ordinal()] = 38;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                iArr[h7.PLAYBACK_TIME.ordinal()] = 39;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                iArr[h7.ON_BACKGROUND.ordinal()] = 40;
            } catch (NoSuchFieldError unused40) {
            }
            f1029a = iArr;
        }
    }

    public g7(sa uiPost, wa urlParser) {
        Intrinsics.checkNotNullParameter(uiPost, "uiPost");
        Intrinsics.checkNotNullParameter(urlParser, "urlParser");
        this.uiPost = uiPost;
        this.urlParser = urlParser;
    }

    public final void a() {
        this.impressionInterface = null;
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 8, 0})
    public static final class l extends Lambda implements Function0<Unit> {
        public final /* synthetic */ JSONObject c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(JSONObject jSONObject) {
            super(0);
            this.c = jSONObject;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }

        public final void a() {
            i6 i6Var = g7.this.impressionInterface;
            if (i6Var != null) {
                i6Var.b(g7.this.urlParser.b(this.c));
            }
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 8, 0})
    public static final class v extends Lambda implements Function0<Unit> {
        public v() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }

        public final void a() {
            Unit unit;
            i6 i6Var = g7.this.impressionInterface;
            if (i6Var != null) {
                i6Var.D();
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                b7.a("Impression interface is missing in template close", (Throwable) null, 2, (Object) null);
            }
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 8, 0})
    public static final class w extends Lambda implements Function0<Unit> {
        public w() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }

        public final void a() {
            i6 i6Var = g7.this.impressionInterface;
            if (i6Var != null) {
                i6Var.a(db.SKIP);
            }
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 8, 0})
    public static final class x extends Lambda implements Function0<Unit> {
        public x() {
            super(0);
        }

        public final void a() {
            g7.this.g();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 8, 0})
    public static final class y extends Lambda implements Function0<Unit> {
        public y() {
            super(0);
        }

        public final void a() {
            g7.this.f();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 8, 0})
    public static final class z extends Lambda implements Function0<Unit> {
        public z() {
            super(0);
        }

        public final void a() {
            g7.this.e();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 8, 0})
    public static final class a0 extends Lambda implements Function0<Unit> {
        public static final a0 b = new a0();

        public a0() {
            super(0);
        }

        public final void a() {
            b7.b("Video replay command is run", null, 2, null);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 8, 0})
    public static final class b0 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ JSONObject c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b0(JSONObject jSONObject) {
            super(0);
            this.c = jSONObject;
        }

        public final void a() {
            g7.this.a(this.c);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 8, 0})
    public static final class c0 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ JSONObject c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c0(JSONObject jSONObject) {
            super(0);
            this.c = jSONObject;
        }

        public final void a() {
            g7.this.i(this.c);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 8, 0})
    public static final class b extends Lambda implements Function0<Unit> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }

        public final void a() {
            Unit unit;
            i6 i6Var = g7.this.impressionInterface;
            if (i6Var != null) {
                i6Var.g();
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                b7.a("Impression interface is missing in template show", (Throwable) null, 2, (Object) null);
            }
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 8, 0})
    public static final class c extends Lambda implements Function0<Unit> {
        public final /* synthetic */ JSONObject c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(JSONObject jSONObject) {
            super(0);
            this.c = jSONObject;
        }

        public final void a() {
            g7.this.c(this.c);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 8, 0})
    public static final class d extends Lambda implements Function0<Unit> {
        public final /* synthetic */ JSONObject c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(JSONObject jSONObject) {
            super(0);
            this.c = jSONObject;
        }

        public final void a() {
            g7.this.k(this.c);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 8, 0})
    public static final class e extends Lambda implements Function0<Unit> {
        public final /* synthetic */ JSONObject c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(JSONObject jSONObject) {
            super(0);
            this.c = jSONObject;
        }

        public final void a() {
            g7.this.b(this.c);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 8, 0})
    public static final class f extends Lambda implements Function0<Unit> {
        public final /* synthetic */ JSONObject c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(JSONObject jSONObject) {
            super(0);
            this.c = jSONObject;
        }

        public final void a() {
            g7.this.j(this.c);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 8, 0})
    public static final class g extends Lambda implements Function0<Unit> {
        public final /* synthetic */ JSONObject c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(JSONObject jSONObject) {
            super(0);
            this.c = jSONObject;
        }

        public final void a() {
            g7.this.e(this.c);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 8, 0})
    public static final class h extends Lambda implements Function0<Unit> {
        public final /* synthetic */ JSONObject c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(JSONObject jSONObject) {
            super(0);
            this.c = jSONObject;
        }

        public final void a() {
            g7.this.h(this.c);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 8, 0})
    public static final class i extends Lambda implements Function0<Unit> {
        public i() {
            super(0);
        }

        public final void a() {
            i6 i6Var = g7.this.impressionInterface;
            if (i6Var != null) {
                i6Var.u();
            }
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 8, 0})
    public static final class j extends Lambda implements Function0<Unit> {
        public j() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }

        public final void a() {
            Unit unit;
            i6 i6Var = g7.this.impressionInterface;
            if (i6Var != null) {
                i6Var.z();
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                b7.a("Impression interface is missing in template rewarded video completed", (Throwable) null, 2, (Object) null);
            }
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 8, 0})
    public static final class k extends Lambda implements Function0<Unit> {
        public k() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }

        public final void a() {
            Unit unit;
            i6 i6Var = g7.this.impressionInterface;
            if (i6Var != null) {
                i6Var.k();
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                b7.a("Impression interface is missing in template play video", (Throwable) null, 2, (Object) null);
            }
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 8, 0})
    public static final class m extends Lambda implements Function0<Unit> {
        public m() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }

        public final void a() {
            Unit unit;
            i6 i6Var = g7.this.impressionInterface;
            if (i6Var != null) {
                i6Var.m();
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                b7.a("Impression interface is missing in template pause video", (Throwable) null, 2, (Object) null);
            }
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 8, 0})
    public static final class n extends Lambda implements Function0<Unit> {
        public n() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }

        public final void a() {
            Unit unit;
            i6 i6Var = g7.this.impressionInterface;
            if (i6Var != null) {
                i6Var.t();
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                b7.a("Impression interface is missing in template close video", (Throwable) null, 2, (Object) null);
            }
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 8, 0})
    public static final class o extends Lambda implements Function0<Unit> {
        public o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }

        public final void a() {
            Unit unit;
            i6 i6Var = g7.this.impressionInterface;
            if (i6Var != null) {
                i6Var.f();
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                b7.a("Impression interface is missing in template mute video", (Throwable) null, 2, (Object) null);
            }
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 8, 0})
    public static final class p extends Lambda implements Function0<Unit> {
        public p() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }

        public final void a() {
            Unit unit;
            i6 i6Var = g7.this.impressionInterface;
            if (i6Var != null) {
                i6Var.c();
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                b7.a("Impression interface is missing in template unmute video", (Throwable) null, 2, (Object) null);
            }
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 8, 0})
    public static final class q extends Lambda implements Function0<Unit> {
        public final /* synthetic */ JSONObject c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(JSONObject jSONObject) {
            super(0);
            this.c = jSONObject;
        }

        public final void a() {
            g7.this.f(this.c);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 8, 0})
    public static final class r extends Lambda implements Function0<Unit> {
        public final /* synthetic */ JSONObject c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(JSONObject jSONObject) {
            super(0);
            this.c = jSONObject;
        }

        public final void a() {
            g7.this.g(this.c);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 8, 0})
    public static final class s extends Lambda implements Function0<Unit> {
        public s() {
            super(0);
        }

        public final void a() {
            g7.this.c();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 8, 0})
    public static final class t extends Lambda implements Function0<Unit> {
        public t() {
            super(0);
        }

        public final void a() {
            g7.this.b();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 8, 0})
    public static final class u extends Lambda implements Function0<Unit> {
        public u() {
            super(0);
        }

        public final void a() {
            g7.this.d();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    public final void i(JSONObject args) {
        float fOptDouble;
        Unit unit;
        if (args != null) {
            try {
                fOptDouble = (float) args.optDouble("duration", 0.0d);
            } catch (Exception e2) {
                k(new JSONObject().put("message", "Parsing exception unknown field for total player duration: " + e2));
                return;
            }
        } else {
            fOptDouble = 0.0f;
        }
        float f2 = fOptDouble * 1000;
        b7.a("######### JS->Native Video total player duration" + f2, (Throwable) null, 2, (Object) null);
        this.videoDuration = f2;
        i6 i6Var = this.impressionInterface;
        if (i6Var != null) {
            i6Var.b(f2);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            b7.a("Impression interface is missing in totalVideoDuration", (Throwable) null, 2, (Object) null);
        }
    }

    public final void k(JSONObject args) {
        String string;
        b7.a("Javascript warning occurred", (Throwable) null, 2, (Object) null);
        if (args != null) {
            try {
                string = args.getString("message");
            } catch (Exception unused) {
                i6 i6Var = this.impressionInterface;
                if (i6Var != null) {
                    i6Var.e("Warning message is empty");
                    return;
                }
                return;
            }
        } else {
            string = null;
        }
        if (string == null) {
            string = "Missing message argument";
        }
        b7.a("JS->Native Warning message: " + string, (Throwable) null, 2, (Object) null);
        i6 i6Var2 = this.impressionInterface;
        if (i6Var2 != null) {
            i6Var2.e(string);
        }
    }

    public final void c(JSONObject args) {
        b7.a("Javascript Error occurred " + args, (Throwable) null, 2, (Object) null);
        d(args);
        try {
            i6 i6Var = this.impressionInterface;
            if (i6Var != null) {
                i6Var.j();
                if (i6Var.c(b(args, "JS->Native Error message: ")) != null) {
                    return;
                }
            }
            b7.a("Impression interface is missing in error", (Throwable) null, 2, (Object) null);
            Unit unit = Unit.INSTANCE;
        } catch (Exception unused) {
            b7.b("Error message is empty", null, 2, null);
            i6 i6Var2 = this.impressionInterface;
            if (i6Var2 != null) {
                i6Var2.c("");
            }
        }
    }

    public final void a(JSONObject args) {
        float f2;
        Unit unit;
        if (args != null) {
            try {
                f2 = (float) args.getDouble("duration");
            } catch (Exception e2) {
                k(new JSONObject().put("message", "Parsing exception unknown field for current player duration: " + e2));
                return;
            }
        } else {
            f2 = 0.0f;
        }
        if (f2 > 0.0f) {
            float f3 = f2 * 1000;
            b7.a("######### JS->Native Video current player duration: " + f3, (Throwable) null, 2, (Object) null);
            i6 i6Var = this.impressionInterface;
            if (i6Var != null) {
                i6Var.a(f3);
                i6Var.a(this.videoDuration, f3);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                b7.a("Impression interface is missing in currentVideoDuration", (Throwable) null, 2, (Object) null);
            }
        }
    }

    public final String a(JSONObject args, String functionName) {
        Intrinsics.checkNotNullParameter(functionName, "functionName");
        h7 h7VarA = h7.INSTANCE.a(functionName);
        if (h7VarA == null) {
            b7.d("Native event unknown: " + functionName, null, 2, null);
            return "Function name not recognized.";
        }
        b7.a("TEMPLATE EVENT: " + h7VarA.getCmdName(), (Throwable) null, 2, (Object) null);
        return a(args, h7VarA);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0030  */
    public final void j(JSONObject args) {
        Unit unit;
        Unit unit2;
        if (args != null) {
            try {
                String string = args.getString("event");
                if (string != null) {
                    i6 i6Var = this.impressionInterface;
                    if (i6Var != null) {
                        i6Var.d(string);
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit == null) {
                        b7.a("JS->Native Track VAST event message: " + string, (Throwable) null, 2, (Object) null);
                    }
                    unit2 = Unit.INSTANCE;
                } else {
                    unit2 = null;
                }
            } catch (Exception e2) {
                b7.b("Exception while parsing webview VAST tracking", e2);
                return;
            }
        } else {
            unit2 = null;
        }
        if (unit2 == null) {
            b7.b("Tracking command received but event is missing!", null, 2, null);
        }
    }

    public final void b(JSONObject args) {
        try {
            b7.a("Debug message: " + b(args, "JS->Native Debug message: "), (Throwable) null, 2, (Object) null);
        } catch (Exception e2) {
            b7.b("Exception occurred while parsing the message for webview debug track event", e2);
        }
    }

    public final void e(JSONObject args) {
        Unit unit;
        try {
            i6 i6Var = this.impressionInterface;
            if (i6Var != null) {
                i6Var.c(this.urlParser.b(args));
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                b7.a("Impression interface is missing in openUrl", (Throwable) null, 2, (Object) null);
            }
        } catch (ActivityNotFoundException e2) {
            b7.b("ActivityNotFoundException occured when opening a url in a browser", e2);
        } catch (Exception e3) {
            b7.b("Exception while opening a browser view with MRAID url", e3);
        }
    }

    public final void h(JSONObject args) {
        Unit unit;
        boolean zOptBoolean = true;
        if (args != null) {
            try {
                zOptBoolean = args.optBoolean("allowOrientationChange", true);
            } catch (Exception unused) {
                b7.b("Invalid set orientation command", null, 2, null);
                return;
            }
        }
        String str = "none";
        String strOptString = args != null ? args.optString("forceOrientation", "none") : null;
        if (strOptString != null) {
            str = strOptString;
        }
        i6 i6Var = this.impressionInterface;
        if (i6Var != null) {
            i6Var.a(zOptBoolean, str);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            b7.a("Impression interface is missing in setOrientation", (Throwable) null, 2, (Object) null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0081  */
    public final void f(JSONObject args) {
        List<fb> list;
        Unit unit;
        Unit unit2;
        if (args != null) {
            try {
                String string = args.getString("resources");
                if (string != null) {
                    if (string.length() == 0) {
                        list = CollectionsKt.emptyList();
                    } else {
                        List<JSONObject> listAsList = b5.asList(new JSONArray(string));
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listAsList, 10));
                        for (JSONObject jSONObject : listAsList) {
                            arrayList.add(fb.a(jSONObject.getString(POBNativeConstants.NATIVE_VENDOR_KEY), new URL(jSONObject.getString("url")), jSONObject.getString("params")));
                        }
                        list = CollectionsKt.toList(arrayList);
                    }
                    int iOptInt = args.optInt(UnifiedMediationParams.KEY_SKIP_OFFSET);
                    i6 i6Var = this.impressionInterface;
                    if (i6Var != null) {
                        i6Var.a(list, Integer.valueOf(iOptInt));
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit == null) {
                        b7.a("Impression interface is missing in runOmResources", (Throwable) null, 2, (Object) null);
                    }
                    unit2 = Unit.INSTANCE;
                } else {
                    unit2 = null;
                }
            } catch (Exception e2) {
                b7.b("Invalid om resources command", e2);
                return;
            }
        } else {
            unit2 = null;
        }
        if (unit2 == null) {
            b7.b("Invalid om resources command: missing json", null, 2, null);
        }
    }

    public final void a(n5 n5Var) {
        this.hideViewCallback = n5Var;
    }

    public final void a(i6 impressionInterface) {
        Intrinsics.checkNotNullParameter(impressionInterface, "impressionInterface");
        this.impressionInterface = impressionInterface;
    }

    public final void g(JSONObject args) {
        Unit unit;
        double dOptDouble = 0.0d;
        if (args != null) {
            try {
                dOptDouble = args.optDouble("duration", 0.0d);
            } catch (Exception e2) {
                b7.b("Invalid start command", e2);
                return;
            }
        }
        this.videoDuration = (float) dOptDouble;
        i6 i6Var = this.impressionInterface;
        if (i6Var != null) {
            i6Var.a(db.START);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            b7.a("Impression interface is missing in runStart", (Throwable) null, 2, (Object) null);
        }
    }

    public final String a(JSONObject args, h7 nativeCmd) {
        String strL;
        String strI;
        String strW;
        String strC;
        String strN;
        String strX;
        switch (a.f1029a[nativeCmd.ordinal()]) {
            case 1:
                b7.a("JavaScript to native " + nativeCmd.getCmdName() + " callback triggered.", (Throwable) null, 2, (Object) null);
                i6 i6Var = this.impressionInterface;
                return (i6Var == null || (strL = i6Var.l()) == null) ? "" : strL;
            case 2:
                b7.a("JavaScript to native " + nativeCmd.getCmdName() + " callback triggered.", (Throwable) null, 2, (Object) null);
                i6 i6Var2 = this.impressionInterface;
                return (i6Var2 == null || (strI = i6Var2.i()) == null) ? "" : strI;
            case 3:
                b7.a("JavaScript to native " + nativeCmd.getCmdName() + " callback triggered.", (Throwable) null, 2, (Object) null);
                i6 i6Var3 = this.impressionInterface;
                return (i6Var3 == null || (strW = i6Var3.w()) == null) ? "" : strW;
            case 4:
                b7.a("JavaScript to native " + nativeCmd.getCmdName() + " callback triggered.", (Throwable) null, 2, (Object) null);
                i6 i6Var4 = this.impressionInterface;
                return (i6Var4 == null || (strC = i6Var4.C()) == null) ? "" : strC;
            case 5:
                b7.a("JavaScript to native " + nativeCmd.getCmdName() + " callback triggered.", (Throwable) null, 2, (Object) null);
                i6 i6Var5 = this.impressionInterface;
                return (i6Var5 == null || (strN = i6Var5.n()) == null) ? "" : strN;
            case 6:
                b7.a("JavaScript to native " + nativeCmd.getCmdName() + " callback triggered.", (Throwable) null, 2, (Object) null);
                i6 i6Var6 = this.impressionInterface;
                return (i6Var6 == null || (strX = i6Var6.x()) == null) ? "" : strX;
            case 7:
                this.uiPost.a(new l(args));
                return "Native function successfully called.";
            case 8:
                this.uiPost.a(new v());
                return "Native function successfully called.";
            case 9:
                this.uiPost.a(new w());
                return "Native function successfully called.";
            case 10:
                this.uiPost.a(new x());
                return "Native function successfully called.";
            case 11:
                this.uiPost.a(new y());
                return "Native function successfully called.";
            case 12:
                this.uiPost.a(new z());
                return "Native function successfully called.";
            case 13:
                this.uiPost.a(a0.b);
                return "Native function successfully called.";
            case 14:
                this.uiPost.a(new b0(args));
                return "Native function successfully called.";
            case 15:
                this.uiPost.a(new c0(args));
                return "Native function successfully called.";
            case 16:
                this.uiPost.a(new b());
                return "Native function successfully called.";
            case 17:
                this.uiPost.a(new c(args));
                return "Native function successfully called.";
            case 18:
                this.uiPost.a(new d(args));
                return "Native function successfully called.";
            case 19:
                this.uiPost.a(new e(args));
                return "Native function successfully called.";
            case 20:
                this.uiPost.a(new f(args));
                return "Native function successfully called.";
            case 21:
                this.uiPost.a(new g(args));
                return "Native function successfully called.";
            case 22:
                this.uiPost.a(new h(args));
                return "Native function successfully called.";
            case 23:
                this.uiPost.a(new i());
                return "Native function successfully called.";
            case 24:
                this.uiPost.a(new j());
                return "Native function successfully called.";
            case 25:
                this.uiPost.a(new k());
                return "Native function successfully called.";
            case 26:
                this.uiPost.a(new m());
                return "Native function successfully called.";
            case 27:
                this.uiPost.a(new n());
                return "Native function successfully called.";
            case 28:
                this.uiPost.a(new o());
                return "Native function successfully called.";
            case 29:
                this.uiPost.a(new p());
                return "Native function successfully called.";
            case 30:
                this.uiPost.a(new q(args));
                return "Native function successfully called.";
            case 31:
                this.uiPost.a(new r(args));
                return "Native function successfully called.";
            case 32:
                this.uiPost.a(new s());
                return "Native function successfully called.";
            case 33:
                this.uiPost.a(new t());
                return "Native function successfully called.";
            case 34:
                this.uiPost.a(new u());
                return "Native function successfully called.";
            default:
                return "Native function successfully called.";
        }
    }

    public final void d() {
        Unit unit;
        try {
            i6 i6Var = this.impressionInterface;
            if (i6Var != null) {
                i6Var.a(db.COMPLETED);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                b7.a("Impression interface is missing in runVideoFinished", (Throwable) null, 2, (Object) null);
            }
        } catch (Exception e2) {
            b7.b("Invalid buffer end command", e2);
        }
    }

    public final void d(JSONObject args) {
        String strOptString;
        if (k9.f1061a.d() && args != null && (strOptString = args.optString("msg")) != null && Intrinsics.areEqual(strOptString, "crash sdk")) {
            throw new RuntimeException("test crash");
        }
    }

    public final void e() {
        Unit unit;
        i6 i6Var = this.impressionInterface;
        if (i6Var != null) {
            i6Var.a(h8.PAUSED);
            i6Var.a(db.PAUSE);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            b7.a("Impression interface is missing in runVideoResumedCommand", (Throwable) null, 2, (Object) null);
        }
    }

    public final void g() {
        Unit unit;
        n5 n5Var = this.hideViewCallback;
        if (n5Var != null) {
            n5Var.onHideCustomView();
        }
        i6 i6Var = this.impressionInterface;
        if (i6Var != null) {
            i6Var.a(h8.IDLE);
            i6Var.o();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            b7.a("Impression interface is missing in videoCompleted", (Throwable) null, 2, (Object) null);
        }
    }

    public final void c() {
        Unit unit;
        try {
            i6 i6Var = this.impressionInterface;
            if (i6Var != null) {
                i6Var.a(db.BUFFER_START);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                b7.a("Impression interface is missing in runBufferStart", (Throwable) null, 2, (Object) null);
            }
        } catch (Exception e2) {
            b7.b("Invalid bufer start command", e2);
        }
    }

    public final String b(JSONObject jSONObject, String str) {
        String string = jSONObject != null ? jSONObject.getString("message") : null;
        if (string == null) {
            string = "";
        }
        b7.a(str + string, (Throwable) null, 2, (Object) null);
        return string;
    }

    public final void f() {
        Unit unit;
        i6 i6Var = this.impressionInterface;
        if (i6Var != null) {
            i6Var.a(db.RESUME);
            i6Var.a(h8.PLAYING);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            b7.a("Impression interface is missing in runVideoResumedCommand", (Throwable) null, 2, (Object) null);
        }
    }

    public final void b() {
        Unit unit;
        try {
            i6 i6Var = this.impressionInterface;
            if (i6Var != null) {
                i6Var.a(db.BUFFER_END);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                b7.a("Impression interface is missing in runBufferEnd", (Throwable) null, 2, (Object) null);
            }
        } catch (Exception e2) {
            b7.b("Invalid buffer end command", e2);
        }
    }
}
