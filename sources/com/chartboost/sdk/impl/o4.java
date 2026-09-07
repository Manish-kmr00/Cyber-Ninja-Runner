package com.chartboost.sdk.impl;

import com.amazon.device.ads.DTBMetricsConfiguration;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.pubnative.lite.sdk.analytics.Reporting;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b!\u0010\u001aJ \u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0096\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0096\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0096\u0001¢\u0006\u0004\b\f\u0010\u000bJ\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0096\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0096\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0096\u0001¢\u0006\u0004\b\u0015\u0010\u000bJ\u0014\u0010\n\u001a\u00020\b*\u00020\bH\u0096\u0001¢\u0006\u0004\b\n\u0010\u0016J\u0014\u0010\f\u001a\u00020\b*\u00020\bH\u0096\u0001¢\u0006\u0004\b\f\u0010\u0016J\u0014\u0010\u000f\u001a\u00020\r*\u00020\rH\u0096\u0001¢\u0006\u0004\b\u000f\u0010\u0017J\u0014\u0010\u0013\u001a\u00020\u0011*\u00020\u0011H\u0096\u0001¢\u0006\u0004\b\u0013\u0010\u0018J\u0014\u0010\u0015\u001a\u00020\b*\u00020\bH\u0096\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0019\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010\u0019\u001a\u00020\u0002*\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b\u0019\u0010 ¨\u0006\""}, d2 = {"Lcom/chartboost/sdk/impl/o4;", "Lcom/chartboost/sdk/impl/m4;", "", "type", "location", "", "clear", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/chartboost/sdk/impl/ka;", "event", "clearFromStorage", "(Lcom/chartboost/sdk/impl/ka;)V", "persist", "Lcom/chartboost/sdk/impl/ia;", DTBMetricsConfiguration.CONFIG_DIR, ToolBar.REFRESH, "(Lcom/chartboost/sdk/impl/ia;)V", "Lcom/chartboost/sdk/impl/da;", Reporting.Key.CLICK_SOURCE_TYPE_AD, com.ironsource.b9.h.U, "(Lcom/chartboost/sdk/impl/da;)V", "track", "(Lcom/chartboost/sdk/impl/ka;)Lcom/chartboost/sdk/impl/ka;", "(Lcom/chartboost/sdk/impl/ia;)Lcom/chartboost/sdk/impl/ia;", "(Lcom/chartboost/sdk/impl/da;)Lcom/chartboost/sdk/impl/da;", "a", "()V", "", "throwable", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Ljava/lang/Throwable;)Z", "(Ljava/lang/Throwable;)Ljava/lang/String;", "<init>", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class o4 implements m4 {
    public static final o4 b = new o4();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m4 f1092a = fa.a();

    public final void a() {
        final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.chartboost.sdk.impl.o4$$ExternalSyntheticLambda0
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public final void uncaughtException(Thread thread, Throwable th) {
                o4.a(defaultUncaughtExceptionHandler, thread, th);
            }
        });
    }

    @Override // com.chartboost.sdk.impl.l4
    public void clear(String type, String location) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(location, "location");
        this.f1092a.clear(type, location);
    }

    @Override // com.chartboost.sdk.impl.m4
    public ka clearFromStorage(ka kaVar) {
        Intrinsics.checkNotNullParameter(kaVar, "<this>");
        return this.f1092a.clearFromStorage(kaVar);
    }

    @Override // com.chartboost.sdk.impl.m4
    public ka persist(ka kaVar) {
        Intrinsics.checkNotNullParameter(kaVar, "<this>");
        return this.f1092a.persist(kaVar);
    }

    @Override // com.chartboost.sdk.impl.m4
    public ia refresh(ia iaVar) {
        Intrinsics.checkNotNullParameter(iaVar, "<this>");
        return this.f1092a.refresh(iaVar);
    }

    @Override // com.chartboost.sdk.impl.m4
    public da store(da daVar) {
        Intrinsics.checkNotNullParameter(daVar, "<this>");
        return this.f1092a.store(daVar);
    }

    @Override // com.chartboost.sdk.impl.m4
    public ka track(ka kaVar) {
        Intrinsics.checkNotNullParameter(kaVar, "<this>");
        return this.f1092a.track(kaVar);
    }

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: clearFromStorage */
    public void mo4737clearFromStorage(ka event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.f1092a.mo4737clearFromStorage(event);
    }

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: persist */
    public void mo4738persist(ka event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.f1092a.mo4738persist(event);
    }

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: refresh */
    public void mo4739refresh(ia config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.f1092a.mo4739refresh(config);
    }

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: store */
    public void mo4740store(da ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        this.f1092a.mo4740store(ad);
    }

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: track */
    public void mo4741track(ka event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.f1092a.mo4741track(event);
    }

    public static final void a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Thread thread, Throwable throwable) {
        o4 o4Var = b;
        Intrinsics.checkNotNullExpressionValue(throwable, "throwable");
        if (o4Var.b(throwable)) {
            o4Var.track((ka) new j4(ma.i.DISMISS_MISSING, o4Var.a(throwable), null, null, null, 28, null));
        }
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, throwable);
        }
    }

    public final String a(Throwable th) {
        String string = new JSONObject().put("reason", "dismiss_event due to the unhandled exceptions").put("error", String.valueOf(th)).toString();
        Intrinsics.checkNotNullExpressionValue(string, "JSONObject().put(\"reason…rrorMessage}\").toString()");
        return string;
    }

    public final boolean b(Throwable throwable) {
        String className;
        StackTraceElement[] stackTrace = throwable.getStackTrace();
        Intrinsics.checkNotNullExpressionValue(stackTrace, "throwable.stackTrace");
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (stackTraceElement != null && (className = stackTraceElement.getClassName()) != null) {
                Intrinsics.checkNotNullExpressionValue(className, "className");
                if (StringsKt.startsWith$default(className, "com.chartboost.sdk", false, 2, (Object) null)) {
                    return true;
                }
            }
        }
        return false;
    }
}
