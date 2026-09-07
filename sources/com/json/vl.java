package com.json;

import android.content.Context;
import android.os.Handler;
import android.view.Choreographer;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.json.environment.thread.IronSourceThreadManager;
import com.json.mediationsdk.IronSource;
import com.json.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.json.mediationsdk.impressionData.ImpressionData;
import com.json.mediationsdk.integration.IntegrationHelper;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import com.unity3d.mediation.LevelPlay;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b-\u0010.J\u0018\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007J\u0018\u0010\u0006\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0007J\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0007J\u001a\u0010\u0006\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\r\u001a\u00020\u0004H\u0007J\u001e\u0010\u0006\u001a\u00020\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u00122\b\b\u0002\u0010\r\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0006\u001a\u00020\u0014J\u000e\u0010\u0006\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0015J'\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00172\u0012\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u0017\"\u00020\u0018¢\u0006\u0004\b\u0006\u0010\u001bJ\u000e\u0010\u0006\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0018J\u001e\u0010\u0006\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u0002J\u001e\u0010\u0006\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\"2\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u0006\u001a\u00020\t2\u0006\u0010$\u001a\u00020#2\u0006\u0010!\u001a\u00020\u0004J(\u0010\u0006\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00182\u0006\u0010'\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010\u0002J \u0010\u0006\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u00022\u0006\u0010'\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010\u0002J \u0010\u000b\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u00022\u0006\u0010'\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010\u0002R\u0014\u0010,\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010+¨\u0006/"}, d2 = {"Lcom/ironsource/vl;", "", "", "responseOrigin", "", "delayTimeAfterInitProcessInMS", "a", "Ljava/lang/Runnable;", "runnable", "", "d", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "delay", "callback", "e", "Lcom/ironsource/hr;", "safeRunnable", "Lkotlin/Function0;", "action", "Landroid/os/Handler;", "Landroid/content/Context;", "context", "", "Lcom/unity3d/mediation/LevelPlay$AdFormat;", "adFormats", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "([Lcom/unity3d/mediation/LevelPlay$AdFormat;)[Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT, "Lcom/ironsource/mediationsdk/adunit/adapter/internal/AdapterBaseInterface;", "networkAdapter", "providerName", "", "duration", "Lcom/ironsource/ls$a;", "Lcom/ironsource/mr;", "error", "placementName", "", "errorCode", "errorMessage", "adUnitId", "Lcom/ironsource/xi;", "Lcom/ironsource/xi;", "thread", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public class vl {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final xi thread = new xi(null, 1, 0 == true ? 1 : 0);

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/ironsource/vl$a", "Lcom/ironsource/hr;", "", "a", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends hr {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f4538a;

        a(Runnable runnable) {
            this.f4538a = runnable;
        }

        @Override // com.json.hr
        public void a() {
            this.f4538a.run();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/ironsource/vl$b", "Lcom/ironsource/hr;", "", "a", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends hr {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f4539a;

        b(Function0<Unit> function0) {
            this.f4539a = function0;
        }

        @Override // com.json.hr
        public void a() {
            this.f4539a.invoke();
        }
    }

    private final String a(String responseOrigin, long delayTimeAfterInitProcessInMS) {
        return "responseOrigin=" + responseOrigin + ";delayTimeAfterInitProcess=" + delayTimeAfterInitProcessInMS;
    }

    public static /* synthetic */ void a(vl vlVar, hr hrVar, long j, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: postTask");
        }
        if ((i & 2) != 0) {
            j = 0;
        }
        vlVar.a(hrVar, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(vl this$0, Runnable runnable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(runnable, "$runnable");
        this$0.thread.b(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(vl this$0, Runnable runnable, long j) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(runnable, "$runnable");
        this$0.b(runnable);
    }

    public static /* synthetic */ void a(vl vlVar, Runnable runnable, long j, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: postOnUIThread");
        }
        if ((i & 2) != 0) {
            j = 0;
        }
        vlVar.a(runnable, j);
    }

    public static /* synthetic */ void a(vl vlVar, Function0 function0, long j, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: postTask");
        }
        if ((i & 2) != 0) {
            j = 0;
        }
        vlVar.a((Function0<Unit>) function0, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(final vl this$0, final Runnable runnable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(runnable, "$runnable");
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: com.ironsource.vl$$ExternalSyntheticLambda1
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j) {
                vl.a(this.f$0, runnable, j);
            }
        });
    }

    public final Handler a() {
        return this.thread.getHandler();
    }

    public final IronSource.AD_UNIT a(LevelPlay.AdFormat adFormat) {
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        return com.unity3d.mediation.a.a(adFormat);
    }

    public final void a(long duration, ls.a responseOrigin, long delayTimeAfterInitProcessInMS) {
        Intrinsics.checkNotNullParameter(responseOrigin, "responseOrigin");
        JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit();
        jSONObjectJsonObjectInit.put("isMultipleAdUnits", 1);
        jSONObjectJsonObjectInit.put("duration", duration);
        String strA = responseOrigin.a();
        Intrinsics.checkNotNullExpressionValue(strA, "responseOrigin.value");
        jSONObjectJsonObjectInit.put(IronSourceConstants.EVENTS_EXT1, a(strA, delayTimeAfterInitProcessInMS));
        vt.a(IronSourceConstants.SDK_INIT_SUCCESS, jSONObjectJsonObjectInit);
    }

    public final void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IntegrationHelper.validateIntegration(context.getApplicationContext());
    }

    public final void a(hr safeRunnable) {
        Intrinsics.checkNotNullParameter(safeRunnable, "safeRunnable");
        a(this, safeRunnable, 0L, 2, (Object) null);
    }

    public final void a(hr safeRunnable, long delay) {
        Intrinsics.checkNotNullParameter(safeRunnable, "safeRunnable");
        this.thread.a(safeRunnable, delay);
    }

    public final void a(mr error, long duration) {
        Intrinsics.checkNotNullParameter(error, "error");
        JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit();
        jSONObjectJsonObjectInit.put("errorCode", error.c());
        jSONObjectJsonObjectInit.put("reason", error.d());
        jSONObjectJsonObjectInit.put("isMultipleAdUnits", 1);
        jSONObjectJsonObjectInit.put("duration", duration);
        vt.a(IronSourceConstants.SDK_INIT_FAILED, jSONObjectJsonObjectInit);
    }

    public final void a(Runnable callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.thread.a(callback);
    }

    public final void a(Runnable runnable, long delay) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new a(runnable), delay);
    }

    public final void a(String adUnitId, int errorCode, String errorMessage) throws JSONException {
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit();
        jSONObjectJsonObjectInit.put("errorCode", errorCode);
        jSONObjectJsonObjectInit.putOpt("reason", errorMessage);
        jSONObjectJsonObjectInit.put("mediationAdUnitId", adUnitId);
        jSONObjectJsonObjectInit.put("isMultipleAdUnits", 1);
        vt.a(IronSourceConstants.TROUBLESHOOTING_AD_UNIT_CAPPING_PARSE_ERROR, jSONObjectJsonObjectInit);
    }

    public final void a(String placementName, LevelPlay.AdFormat adFormat, int errorCode, String errorMessage) throws JSONException {
        Intrinsics.checkNotNullParameter(placementName, "placementName");
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit();
        jSONObjectJsonObjectInit.put("errorCode", errorCode);
        jSONObjectJsonObjectInit.putOpt("reason", errorMessage);
        jSONObjectJsonObjectInit.put("placement", placementName);
        jSONObjectJsonObjectInit.put(fl.EVENTS_LEVEL_PLAY_AD_FORMAT_NAME, adFormat.getValue());
        jSONObjectJsonObjectInit.put("adf", vt.b(com.unity3d.mediation.a.a(adFormat)));
        jSONObjectJsonObjectInit.put("isMultipleAdUnits", 1);
        vt.a(IronSourceConstants.TROUBLESHOOTING_PLACEMENT_CAPPING_PARSE_ERROR, jSONObjectJsonObjectInit);
    }

    public final void a(Function0<Unit> action, long delay) {
        Intrinsics.checkNotNullParameter(action, "action");
        a((hr) new b(action), delay);
    }

    public final boolean a(AdapterBaseInterface networkAdapter, IronSource.AD_UNIT adFormat, String providerName) {
        Intrinsics.checkNotNullParameter(networkAdapter, "networkAdapter");
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        return vt.a(networkAdapter, adFormat, providerName);
    }

    public final IronSource.AD_UNIT[] a(LevelPlay.AdFormat... adFormats) {
        Intrinsics.checkNotNullParameter(adFormats, "adFormats");
        ArrayList arrayList = new ArrayList();
        for (LevelPlay.AdFormat adFormat : adFormats) {
            arrayList.add(a(adFormat));
        }
        return (IronSource.AD_UNIT[]) arrayList.toArray(new IronSource.AD_UNIT[0]);
    }

    public final void b(hr safeRunnable) {
        Intrinsics.checkNotNullParameter(safeRunnable, "safeRunnable");
        this.thread.a(safeRunnable);
    }

    public final void b(final Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        a(this, new Runnable() { // from class: com.ironsource.vl$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                vl.a(this.f$0, runnable);
            }
        }, 0L, 2, (Object) null);
    }

    public final void b(String adUnitId, int errorCode, String errorMessage) throws JSONException {
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit();
        jSONObjectJsonObjectInit.put("errorCode", errorCode);
        jSONObjectJsonObjectInit.putOpt("reason", errorMessage);
        jSONObjectJsonObjectInit.put("mediationAdUnitId", adUnitId);
        jSONObjectJsonObjectInit.put("isMultipleAdUnits", 1);
        vt.a(IronSourceConstants.TROUBLESHOOTING_AD_UNIT_REWARD_PARSE_ERROR, jSONObjectJsonObjectInit);
    }

    public final void c(final Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        a(this, new Runnable() { // from class: com.ironsource.vl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                vl.b(this.f$0, runnable);
            }
        }, 0L, 2, (Object) null);
    }

    public final void d(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        this.thread.b(runnable);
    }

    public final void e(Runnable callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        IronSourceThreadManager.postOnUiThreadTask$default(IronSourceThreadManager.INSTANCE, callback, 0L, 2, null);
    }
}
