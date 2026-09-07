package com.json;

import android.adservices.measurement.MeasurementManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.OutcomeReceiver;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.amazon.device.ads.DtbDeviceData;
import com.json.mediationsdk.utils.IronSourceUtils;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0010\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001a¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0001\u0012\b\u0012\u00060\fj\u0002`\r0\u000bH\u0003J\b\u0010\u000e\u001a\u00020\tH\u0002J\u0012\u0010\u0005\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0011R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/ironsource/eq;", "", "Landroid/content/Context;", "context", "Landroid/net/Uri;", "a", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "", "", "d", "Landroid/os/OutcomeReceiver;", "Ljava/lang/Exception;", "Lkotlin/Exception;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "reason", "Lcom/ironsource/rf;", "Lcom/ironsource/rf;", "eventManager", "Lkotlin/Function0;", "", "Lkotlin/jvm/functions/Function0;", "getTimeFunction", "Lcom/ironsource/xf;", "Lcom/ironsource/xf;", "serviceProvider", "Ljava/util/concurrent/Executor;", "Ljava/util/concurrent/Executor;", "executor", "<init>", "(Lcom/ironsource/rf;Lkotlin/jvm/functions/Function0;Lcom/ironsource/xf;Ljava/util/concurrent/Executor;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class eq {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final rf eventManager;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final Function0<Long> getTimeFunction;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final xf serviceProvider;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final Executor executor;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class a extends FunctionReferenceImpl implements Function0<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f3670a = new a();

        a() {
            super(0, System.class, "currentTimeMillis", "currentTimeMillis()J", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Long invoke() {
            return Long.valueOf(System.currentTimeMillis());
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0001J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0014\u0010\t\u001a\u00020\u00062\n\u0010\b\u001a\u00060\u0003j\u0002`\u0004H\u0016¨\u0006\n"}, d2 = {"com/ironsource/eq$b", "Landroid/os/OutcomeReceiver;", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "result", "", "onResult", "error", "a", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements OutcomeReceiver<Object, Exception> {
        b() {
        }

        @Override // android.os.OutcomeReceiver
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(Exception error) {
            Intrinsics.checkNotNullParameter(error, "error");
            eq.this.a(error.getMessage());
        }

        @Override // android.os.OutcomeReceiver
        public void onResult(Object result) {
            eq.this.c();
        }
    }

    public eq() {
        this(null, null, null, null, 15, null);
    }

    public eq(rf eventManager, Function0<Long> getTimeFunction, xf serviceProvider, Executor executor) {
        Intrinsics.checkNotNullParameter(eventManager, "eventManager");
        Intrinsics.checkNotNullParameter(getTimeFunction, "getTimeFunction");
        Intrinsics.checkNotNullParameter(serviceProvider, "serviceProvider");
        Intrinsics.checkNotNullParameter(executor, "executor");
        this.eventManager = eventManager;
        this.getTimeFunction = getTimeFunction;
        this.serviceProvider = serviceProvider;
        this.executor = executor;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ eq(rf rfVar, Function0 function0, xf xfVar, Executor executor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            rfVar = ar.i();
            Intrinsics.checkNotNullExpressionValue(rfVar, "getInstance()");
        }
        function0 = (i & 2) != 0 ? a.f3670a : function0;
        xfVar = (i & 4) != 0 ? mm.INSTANCE.d() : xfVar;
        if ((i & 8) != 0) {
            executor = Executors.newSingleThreadExecutor();
            Intrinsics.checkNotNullExpressionValue(executor, "newSingleThreadExecutor()");
        }
        this(rfVar, function0, xfVar, executor);
    }

    private final Uri a(Context context) {
        nf nfVarF = this.serviceProvider.f();
        String connectionType = IronSourceUtils.getConnectionType(context);
        Uri uriBuild = new Uri.Builder().scheme("https").authority("android-att.ironsrc.mobi").path("register_trigger").appendQueryParameter(DtbDeviceData.DEVICE_DATA_OS_VERSION_KEY, Build.VERSION.RELEASE).appendQueryParameter("apiLevel", String.valueOf(Build.VERSION.SDK_INT)).appendQueryParameter(b9.i.l, Build.MODEL).appendQueryParameter("sdkVersion", IronSourceUtils.getSDKVersion()).appendQueryParameter("bundleID", context.getPackageName()).appendQueryParameter(fe.Q0, nfVarF.p(context)).appendQueryParameter(fe.G0, nfVarF.G(context)).appendQueryParameter("auid", nfVarF.t(context)).appendQueryParameter("isFirstSession", String.valueOf(b(context))).appendQueryParameter("coppa", b()).appendQueryParameter(fe.e0, String.valueOf(k1.a())).appendQueryParameter("origin", "1").appendQueryParameter("timestamp", String.valueOf(this.getTimeFunction.invoke().longValue())).appendQueryParameter(b9.i.x, nfVarF.b(context)).appendQueryParameter("deviceCarrier", nfVarF.j(context)).appendQueryParameter(b9.i.t, connectionType).appendQueryParameter(x8.b, String.valueOf(StringsKt.equals(connectionType, x8.b, true))).build();
        Intrinsics.checkNotNullExpressionValue(uriBuild, "Builder()\n        .schem…arameter\n        .build()");
        return uriBuild;
    }

    private final OutcomeReceiver<Object, Exception> a() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String reason) {
        this.eventManager.a(new zb(56, IronSourceNetworkBridge.jsonObjectInit().put("reason", reason)));
    }

    private final String b() {
        ConcurrentHashMap<String, List<String>> concurrentHashMapC = qk.b().c();
        List<String> list = concurrentHashMapC != null ? concurrentHashMapC.get(com.json.mediationsdk.metadata.a.b) : null;
        String str = list != null ? (String) CollectionsKt.first((List) list) : null;
        return str == null ? "" : str;
    }

    private final boolean b(Context context) {
        return IronSourceUtils.getFirstSession(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() {
        this.eventManager.a(new zb(55, null));
    }

    private final void d() {
        this.eventManager.a(new zb(54, null));
    }

    public final void c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        d();
        try {
            MeasurementManager measurementManagerA = k1.a(context);
            if (measurementManagerA == null) {
                a("could not obtain measurement manager");
            } else {
                measurementManagerA.registerTrigger(a(context), this.executor, a());
            }
        } catch (Exception e) {
            a(e.getMessage());
            o9.d().a(e);
        }
    }
}
