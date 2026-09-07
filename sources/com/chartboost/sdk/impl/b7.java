package com.chartboost.sdk.impl;

import android.util.Log;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.chartboost.sdk.LoggingLevel;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\t\u0010\bJ#\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\n\u0010\bJ#\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u000b\u0010\bJ#\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\f\u0010\bJ+\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0003¢\u0006\u0004\b\u0007\u0010\u000fJ\u0019\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0007\u0010\u0012J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000e\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\t\u0010\u0014R\u0016\u0010\u000e\u001a\u00020\u00158\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/chartboost/sdk/impl/b7;", "", "", "msg", "", "throwable", "", "a", "(Ljava/lang/String;Ljava/lang/Throwable;)V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "e", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "d", "Lcom/chartboost/sdk/impl/b7$a;", "level", "(Lcom/chartboost/sdk/impl/b7$a;Ljava/lang/String;Ljava/lang/Throwable;)V", "", "stackTraceLevel", "(I)Ljava/lang/String;", "Ljava/lang/StackTraceElement;", "(I)Ljava/lang/StackTraceElement;", "Lcom/chartboost/sdk/LoggingLevel;", "Lcom/chartboost/sdk/LoggingLevel;", "<init>", "()V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class b7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b7 f976a = new b7();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public static LoggingLevel level = LoggingLevel.INTEGRATION;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/chartboost/sdk/impl/b7$a;", "", "<init>", "(Ljava/lang/String;I)V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "d", "e", InneractiveMediationDefs.GENDER_FEMALE, "g", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
    public enum a {
        DEBUG,
        ERROR,
        WARNING,
        INFO,
        VERBOSE,
        WTF
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f977a;

        static {
            int[] iArr = new int[a.values().length];
            try {
                iArr[a.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[a.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[a.WARNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[a.INFO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[a.VERBOSE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[a.WTF.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f977a = iArr;
        }
    }

    @JvmStatic
    public static final void a(String msg, Throwable throwable) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        f976a.a(a.DEBUG, msg, throwable);
    }

    @JvmStatic
    public static final void b(String msg, Throwable throwable) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        f976a.a(a.ERROR, msg, throwable);
    }

    @JvmStatic
    public static final void c(String msg, Throwable throwable) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        f976a.a(a.INFO, msg, throwable);
    }

    @JvmStatic
    public static final void d(String msg, Throwable throwable) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        f976a.a(a.VERBOSE, msg, throwable);
    }

    @JvmStatic
    public static final void e(String msg, Throwable throwable) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        f976a.a(a.WARNING, msg, throwable);
    }

    public static /* synthetic */ void a(String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        a(str, th);
    }

    public static /* synthetic */ void b(String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        b(str, th);
    }

    public final StackTraceElement b(int level2) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length > level2) {
            return stackTrace[level2];
        }
        return null;
    }

    public static /* synthetic */ void c(String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        c(str, th);
    }

    public static /* synthetic */ void d(String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        e(str, th);
    }

    public final String a(int stackTraceLevel) {
        StackTraceElement stackTraceElementB = b(stackTraceLevel);
        if (stackTraceElementB != null) {
            StringBuilder sb = new StringBuilder();
            String className = stackTraceElementB.getClassName();
            Intrinsics.checkNotNullExpressionValue(className, "it.className");
            String string = sb.append(StringsKt.substringAfterLast$default(className, '.', (String) null, 2, (Object) null)).append('.').append(stackTraceElementB.getMethodName()).append("():").toString();
            if (string != null) {
                return string;
            }
        }
        return "";
    }

    public static /* synthetic */ String a(b7 b7Var, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 8;
        }
        return b7Var.a(i);
    }

    public final void a(a level2, String msg, Throwable throwable) {
        if (level == LoggingLevel.ALL || level == LoggingLevel.INTEGRATION) {
            String str = a(this, 0, 1, (Object) null) + ' ' + msg;
            switch (b.f977a[level2.ordinal()]) {
                case 1:
                    Log.d("[ChartboostMonetization]", str, throwable);
                    break;
                case 2:
                    Log.e("[ChartboostMonetization]", str, throwable);
                    break;
                case 3:
                    Log.w("[ChartboostMonetization]", str, throwable);
                    break;
                case 4:
                    Log.i("[ChartboostMonetization]", str, throwable);
                    break;
                case 5:
                    Log.v("[ChartboostMonetization]", str, throwable);
                    break;
                case 6:
                    Log.wtf("[ChartboostMonetization]", str, throwable);
                    break;
            }
        }
    }
}
