package com.pubmatic.sdk.crashanalytics;

import android.content.Context;
import com.json.uc;
import com.pubmatic.sdk.common.log.POBLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\b\u0010\tJ'\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/pubmatic/sdk/crashanalytics/POBCrashAnalyticsUtils;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", uc.c.b, "readFromFile", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;", "crashData", "", "writeToFile", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "crashanalytics_release"}, k = 1, mv = {1, 7, 1})
public final class POBCrashAnalyticsUtils {
    public static final POBCrashAnalyticsUtils INSTANCE = new POBCrashAnalyticsUtils();

    private POBCrashAnalyticsUtils() {
    }

    /* JADX WARN: Code duplicated, block: B:26:0x007e  */
    /* JADX WARN: Code duplicated, block: B:37:? A[RETURN, SYNTHETIC] */
    @JvmStatic
    public static final String readFromFile(Context context, String fileName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        File file = new File(context.getFilesDir(), fileName);
        if (!file.exists()) {
            POBLog.debug("POBCrashAnalyticsUtils", fileName + " is not present in internal storage.", new Object[0]);
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            Reader inputStreamReader = new InputStreamReader(new FileInputStream(file), Charsets.UTF_8);
            BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line);
                    if (sb.length() == 0) {
                        return null;
                    }
                    return sb.toString();
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(bufferedReader, th);
                        throw th2;
                    }
                }
                POBLog.debug("POBCrashAnalyticsUtils", "IOException caught while reading data from file: " + fileName + ". IOException Message -> " + e.getMessage(), new Object[0]);
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(bufferedReader, null);
        } catch (IOException e) {
            POBLog.debug("POBCrashAnalyticsUtils", "IOException caught while reading data from file: " + fileName + ". IOException Message -> " + e.getMessage(), new Object[0]);
        }
        if (sb.length() == 0) {
            return null;
        }
        return sb.toString();
    }

    @JvmStatic
    public static final void writeToFile(Context context, String fileName, String crashData) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(crashData, "crashData");
        try {
            FileOutputStream fileOutputStreamOpenFileOutput = context.openFileOutput(fileName, 0);
            try {
                byte[] bytes = crashData.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                fileOutputStreamOpenFileOutput.write(bytes);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(fileOutputStreamOpenFileOutput, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(fileOutputStreamOpenFileOutput, th);
                    throw th2;
                }
            }
        } catch (Exception e) {
            POBLog.debug("POBCrashAnalyticsUtils", "Exception caught while writing crash data to " + fileName + ". Message -> " + e.getMessage() + '.', new Object[0]);
        }
    }
}
