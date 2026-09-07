package com.pubmatic.sdk.crashanalytics;

import android.content.Context;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0013R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/pubmatic/sdk/crashanalytics/POBCrashHandler;", "Ljava/lang/Thread$UncaughtExceptionHandler;", "Landroid/content/Context;", "context", "uncaughtExceptionHandler", "<init>", "(Landroid/content/Context;Ljava/lang/Thread$UncaughtExceptionHandler;)V", "", "throwable", "", "a", "(Ljava/lang/Throwable;)Ljava/lang/String;", "Ljava/lang/Thread;", "thread", "", "uncaughtException", "(Ljava/lang/Thread;Ljava/lang/Throwable;)V", "destroy", "()V", "Landroid/content/Context;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/Thread$UncaughtExceptionHandler;", "crashanalytics_release"}, k = 1, mv = {1, 7, 1})
public final class POBCrashHandler implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final Thread.UncaughtExceptionHandler uncaughtExceptionHandler;

    public POBCrashHandler(Context context, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.uncaughtExceptionHandler = uncaughtExceptionHandler;
    }

    private final String a(Throwable throwable) throws IOException {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        throwable.printStackTrace(printWriter);
        String string = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(string, "stringWriter.toString()");
        stringWriter.close();
        printWriter.close();
        if (StringsKt.contains((CharSequence) string, (CharSequence) POBCrashAnalyticsConstants.OW_FILTER, true)) {
            return string;
        }
        return null;
    }

    public final void destroy() {
        Thread.setDefaultUncaughtExceptionHandler(this.uncaughtExceptionHandler);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable throwable) throws IOException {
        Intrinsics.checkNotNullParameter(thread, "thread");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        String strA = a(throwable);
        if (strA != null) {
            POBCrashStorage pOBCrashStorage = POBCrashStorage.INSTANCE;
            if (pOBCrashStorage.getCrashJsonArray().length() == 10) {
                pOBCrashStorage.getCrashJsonArray().remove(0);
            }
            JSONArray crashJsonArray = pOBCrashStorage.getCrashJsonArray();
            String name = throwable.getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "throwable.javaClass.name");
            crashJsonArray.put(new POBCrashHelper(name, strA, System.currentTimeMillis()).getCrashJson(this.context));
            Context context = this.context;
            String string = pOBCrashStorage.getCrashJsonArray().toString();
            Intrinsics.checkNotNullExpressionValue(string, "POBCrashStorage.crashJsonArray.toString()");
            POBCrashAnalyticsUtils.writeToFile(context, POBCrashAnalyticsConstants.CRASH_DATA_FILE, string);
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.uncaughtExceptionHandler;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, throwable);
        }
    }
}
