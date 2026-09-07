package com.moloco.sdk.internal;

import android.text.TextUtils;
import android.util.Log;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.json.b9;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\bÇ\u0002\u0018\u00002\u00020\u0001:\u000556789B\t\b\u0002¢\u0006\u0004\b4\u00102J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J\f\u0010\u000b\u001a\u00020\u0007*\u00020\u0007H\u0002J\f\u0010\f\u001a\u00020\u0007*\u00020\u0007H\u0002J\u001d\u0010\u0010\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\"\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u0012J\"\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u0012J.\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0013\u001a\u00020\u0012J.\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0013\u001a\u00020\u0012J.\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0013\u001a\u00020\u0012J\u001e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0007J\u001a\u0010\u001e\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00072\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0016J\u0006\u0010\u001f\u001a\u00020\u0007J\u0017\u0010$\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H\u0001¢\u0006\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010'R$\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u00020(j\b\u0012\u0004\u0012\u00020\u0002`)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R*\u00103\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u00128F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b1\u00102\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u0006:"}, d2 = {"Lcom/moloco/sdk/internal/MolocoLogger;", "", "Lcom/moloco/sdk/internal/MolocoLogger$LoggerListener;", "loggerListener", "", "addListener", "removeListener", "", "tag", "msg", "fireListeners", "prefixWithMolocoName", "prefixWithMethodName", "", "Ljava/lang/StackTraceElement;", "stackTraceArray", "findMostRelevantStackTrace", "([Ljava/lang/StackTraceElement;)Ljava/lang/StackTraceElement;", "", "forceLogging", "debug", "debugBuildLog", "", "exception", "info", "warn", "error", "isDebugBuild", "adapter", "throwable", "tlog", "getCallingMethodName", "Lcom/moloco/sdk/internal/MolocoLogger$c;", com.safedk.android.utils.j.c, "setConfiguration$moloco_sdk_release", "(Lcom/moloco/sdk/internal/MolocoLogger$c;)V", "setConfiguration", "MOLOCO_TAG", "Ljava/lang/String;", "Lcom/moloco/sdk/internal/MolocoLogger$c;", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "listeners", "Ljava/util/LinkedHashSet;", "value", "getLogEnabled", "()Z", "setLogEnabled", "(Z)V", "getLogEnabled$annotations", "()V", "logEnabled", "<init>", "a", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "d", "LoggerListener", "moloco-sdk_release"}, k = 1, mv = {1, 8, 0})
public final class MolocoLogger {
    private static final String MOLOCO_TAG = "Moloco";
    public static final MolocoLogger INSTANCE = new MolocoLogger();
    private static c configuration = new d(new b());
    private static final LinkedHashSet<LoggerListener> listeners = new LinkedHashSet<>();
    public static final int $stable = 8;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/moloco/sdk/internal/MolocoLogger$LoggerListener;", "", "onLog", "", "tag", "", "msg", "moloco-sdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface LoggerListener {
        void onLog(String tag, String msg);
    }

    public interface a {
        void a(boolean z);

        boolean a();
    }

    public static final class b implements a {
        public static final C0530b b = new C0530b(null);
        public static final String c = "debug.moloco.internal_logging";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f6059a;

        public static final class a extends Lambda implements Function0<Unit> {
            public a() {
                super(0);
            }

            public final void a() {
                b bVar = b.this;
                bVar.a(bVar.b());
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.internal.MolocoLogger$b$b, reason: collision with other inner class name */
        public static final class C0530b {
            public /* synthetic */ C0530b(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public C0530b() {
            }
        }

        public b() {
            ThreadsKt.thread$default(false, false, null, null, 0, new a(), 31, null);
        }

        public final boolean b() {
            return Boolean.parseBoolean(a(c));
        }

        @Override // com.moloco.sdk.internal.MolocoLogger.a
        public boolean a() {
            return this.f6059a;
        }

        @Override // com.moloco.sdk.internal.MolocoLogger.a
        public void a(boolean z) {
            this.f6059a = z;
        }

        public final String a(String str) {
            try {
                Object objInvoke = Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
                Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.String");
                String str2 = (String) objInvoke;
                try {
                    if (TextUtils.isEmpty(str2)) {
                        return null;
                    }
                } catch (Exception unused) {
                }
                return str2;
            } catch (Exception unused2) {
                return null;
            }
        }
    }

    public interface c {
        void a(boolean z);

        boolean a();

        boolean b();

        boolean c();
    }

    public static final class d implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f6061a;
        public boolean b;

        public d(a adb) {
            Intrinsics.checkNotNullParameter(adb, "adb");
            this.f6061a = adb;
        }

        @Override // com.moloco.sdk.internal.MolocoLogger.c
        public boolean a() {
            return this.f6061a.a();
        }

        @Override // com.moloco.sdk.internal.MolocoLogger.c
        public boolean b() {
            return this.b;
        }

        @Override // com.moloco.sdk.internal.MolocoLogger.c
        public boolean c() {
            return false;
        }

        @Override // com.moloco.sdk.internal.MolocoLogger.c
        public void a(boolean z) {
            this.b = z;
        }
    }

    private MolocoLogger() {
    }

    @JvmStatic
    public static final void addListener(LoggerListener loggerListener) {
        Intrinsics.checkNotNullParameter(loggerListener, "loggerListener");
        listeners.add(loggerListener);
    }

    public static /* synthetic */ void debug$default(MolocoLogger molocoLogger, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = MOLOCO_TAG;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        molocoLogger.debug(str, str2, z);
    }

    public static /* synthetic */ void debugBuildLog$default(MolocoLogger molocoLogger, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = MOLOCO_TAG;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        molocoLogger.debugBuildLog(str, str2, z);
    }

    public static /* synthetic */ void error$default(MolocoLogger molocoLogger, String str, String str2, Throwable th, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = MOLOCO_TAG;
        }
        if ((i & 4) != 0) {
            th = null;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        molocoLogger.error(str, str2, th, z);
    }

    private final StackTraceElement findMostRelevantStackTrace(StackTraceElement[] stackTraceArray) {
        for (StackTraceElement stackTraceElement : stackTraceArray) {
            if (!Intrinsics.areEqual(stackTraceElement.getClassName(), INSTANCE.getClass().getCanonicalName())) {
                return stackTraceElement;
            }
        }
        return (StackTraceElement) ArraysKt.first(stackTraceArray);
    }

    private final void fireListeners(String tag, String msg) {
        Iterator<T> it = listeners.iterator();
        while (it.hasNext()) {
            ((LoggerListener) it.next()).onLog(INSTANCE.prefixWithMolocoName(tag), msg);
        }
    }

    public static final boolean getLogEnabled() {
        c cVar = configuration;
        return cVar.c() || cVar.a() || cVar.b();
    }

    @JvmStatic
    public static /* synthetic */ void getLogEnabled$annotations() {
    }

    public static /* synthetic */ void info$default(MolocoLogger molocoLogger, String str, String str2, Throwable th, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = MOLOCO_TAG;
        }
        if ((i & 4) != 0) {
            th = null;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        molocoLogger.info(str, str2, th, z);
    }

    private final String prefixWithMethodName(String str) {
        try {
            return b9.i.d + getCallingMethodName() + "] " + str;
        } catch (Exception unused) {
            return str;
        }
    }

    private final String prefixWithMolocoName(String str) {
        return StringsKt.startsWith$default(str, MOLOCO_TAG, false, 2, (Object) null) ? str : MOLOCO_TAG + str;
    }

    @JvmStatic
    public static final void removeListener(LoggerListener loggerListener) {
        Intrinsics.checkNotNullParameter(loggerListener, "loggerListener");
        listeners.remove(loggerListener);
    }

    public static final void setLogEnabled(boolean z) {
        configuration.a(z);
    }

    public static /* synthetic */ void tlog$default(MolocoLogger molocoLogger, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        molocoLogger.tlog(str, th);
    }

    public static /* synthetic */ void warn$default(MolocoLogger molocoLogger, String str, String str2, Throwable th, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = MOLOCO_TAG;
        }
        if ((i & 4) != 0) {
            th = null;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        molocoLogger.warn(str, str2, th, z);
    }

    public final void adapter(String tag, boolean isDebugBuild, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (getLogEnabled() || isDebugBuild) {
            Log.i(prefixWithMolocoName(tag), prefixWithMethodName(msg));
        }
    }

    public final void debug(String tag, String msg, boolean forceLogging) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (getLogEnabled() || forceLogging) {
            String strPrefixWithMolocoName = prefixWithMolocoName(tag);
            String strPrefixWithMethodName = prefixWithMethodName(msg);
            Log.d(strPrefixWithMolocoName, strPrefixWithMethodName);
            fireListeners(strPrefixWithMolocoName, strPrefixWithMethodName);
        }
    }

    public final void debugBuildLog(String tag, String msg, boolean forceLogging) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
    }

    public final void error(String tag, String msg, Throwable exception, boolean forceLogging) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (getLogEnabled() || forceLogging) {
            String strPrefixWithMolocoName = prefixWithMolocoName(tag);
            String strPrefixWithMethodName = prefixWithMethodName(msg);
            Log.e(strPrefixWithMolocoName, strPrefixWithMethodName, exception);
            fireListeners(strPrefixWithMolocoName, strPrefixWithMethodName);
        }
    }

    public final String getCallingMethodName() throws ClassNotFoundException {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        Intrinsics.checkNotNullExpressionValue(stackTrace, "Throwable().stackTrace");
        StackTraceElement stackTraceElementFindMostRelevantStackTrace = findMostRelevantStackTrace(stackTrace);
        String className = stackTraceElementFindMostRelevantStackTrace.getClassName();
        stackTraceElementFindMostRelevantStackTrace.getMethodName();
        Class<?> cls = Class.forName(className);
        cls.isAnonymousClass();
        cls.getDeclaredMethods();
        String methodName = stackTraceElementFindMostRelevantStackTrace.getMethodName();
        if (Intrinsics.areEqual(methodName, "invokeSuspend")) {
            String className2 = stackTraceElementFindMostRelevantStackTrace.getClassName();
            Intrinsics.checkNotNullExpressionValue(className2, "stackTraceElement.className");
            methodName = StringsKt.substringAfterLast$default(StringsKt.removeSuffix(className2, (CharSequence) "$1"), "$", (String) null, 2, (Object) null);
        }
        Intrinsics.checkNotNullExpressionValue(methodName, "stackTraceElement.method…t\n            }\n        }");
        return methodName;
    }

    public final void info(String tag, String msg, Throwable exception, boolean forceLogging) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (getLogEnabled() || forceLogging) {
            String strPrefixWithMolocoName = prefixWithMolocoName(tag);
            String strPrefixWithMethodName = prefixWithMethodName(msg);
            Log.i(strPrefixWithMolocoName, strPrefixWithMethodName, exception);
            fireListeners(strPrefixWithMolocoName, strPrefixWithMethodName);
        }
    }

    public final void setConfiguration$moloco_sdk_release(c configuration2) {
        Intrinsics.checkNotNullParameter(configuration2, "configuration");
        configuration = configuration2;
    }

    public final void tlog(String msg, Throwable throwable) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Log.i("==tlog==", prefixWithMethodName(msg), throwable);
    }

    public final void warn(String tag, String msg, Throwable exception, boolean forceLogging) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (getLogEnabled() || forceLogging) {
            String strPrefixWithMolocoName = prefixWithMolocoName(tag);
            String strPrefixWithMethodName = prefixWithMethodName(msg);
            Log.w(strPrefixWithMolocoName, strPrefixWithMethodName, exception);
            fireListeners(strPrefixWithMolocoName, strPrefixWithMethodName);
        }
    }
}
