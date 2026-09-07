package com.pubmatic.sdk.crashanalytics;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.utility.POBSharedPreferenceUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0003¢\u0006\u0004\b\u0007\u0010\rJ\u0017\u0010\u0007\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0007\u0010\u0011J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0007\u0010\u0013J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0007\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00108\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0017\u0010#\u001a\u00020\u001e8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lcom/pubmatic/sdk/crashanalytics/POBANRReader;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "a", "()V", "Landroid/app/ApplicationExitInfo;", "applicationExitInfo", "", "timeStamp", "(Landroid/app/ApplicationExitInfo;J)V", "Ljava/io/InputStream;", "inputStream", "", "(Ljava/io/InputStream;)Ljava/lang/String;", "data", "(Ljava/lang/String;)Ljava/lang/String;", "(J)V", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/String;", "tag", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "J", "timeStampCheckPoint", "Lorg/json/JSONArray;", "d", "Lorg/json/JSONArray;", "getJsonArray", "()Lorg/json/JSONArray;", "jsonArray", "crashanalytics_release"}, k = 1, mv = {1, 7, 1})
public final class POBANRReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final String tag;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private long timeStampCheckPoint;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final JSONArray jsonArray;

    public POBANRReader(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.tag = "POBANRReader";
        this.jsonArray = new JSONArray();
        SharedPreferences namedSharedPreference = POBSharedPreferenceUtil.getNamedSharedPreference(context, POBCommonConstants.SHARED_PREF_NAME);
        this.timeStampCheckPoint = namedSharedPreference != null ? namedSharedPreference.getLong(POBCrashAnalyticsConstants.ANR_TIMESTAMP_KEY, 0L) : 0L;
        if (Build.VERSION.SDK_INT >= 30) {
            a();
        } else {
            POBLog.debug("POBANRReader", "Cannot read ANRs as current OS version is below Android 11.", new Object[0]);
        }
    }

    private final void a() {
        try {
            Object systemService = this.context.getSystemService("activity");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            List<ApplicationExitInfo> historicalProcessExitReasons = ((ActivityManager) systemService).getHistoricalProcessExitReasons(this.context.getPackageName(), 0, 10);
            Intrinsics.checkNotNullExpressionValue(historicalProcessExitReasons, "activityManager.getHisto…ntext.packageName, 0, 10)");
            long j = 0;
            for (ApplicationExitInfo applicationExitInfo : historicalProcessExitReasons) {
                if (applicationExitInfo.getReason() == 6) {
                    long timestamp = applicationExitInfo.getTimestamp();
                    if (j == 0) {
                        j = timestamp;
                    }
                    long j2 = this.timeStampCheckPoint;
                    if (j2 == 0) {
                        Intrinsics.checkNotNullExpressionValue(applicationExitInfo, "applicationExitInfo");
                        a(applicationExitInfo, timestamp);
                    } else if (timestamp > j2) {
                        Intrinsics.checkNotNullExpressionValue(applicationExitInfo, "applicationExitInfo");
                        a(applicationExitInfo, timestamp);
                    }
                }
            }
            if (j != 0) {
                a(j);
            }
        } catch (Exception e) {
            POBLog.debug(this.tag, e.getClass().getName() + " caught while fetching the historical process exit reasons. Message -> " + e.getMessage() + '.', new Object[0]);
        }
    }

    public final Context getContext() {
        return this.context;
    }

    public final JSONArray getJsonArray() {
        return this.jsonArray;
    }

    private final void a(ApplicationExitInfo applicationExitInfo, long timeStamp) throws IOException {
        String strA;
        InputStream traceInputStream = applicationExitInfo.getTraceInputStream();
        if (traceInputStream == null || (strA = a(a(traceInputStream))) == null || !StringsKt.contains$default((CharSequence) strA, (CharSequence) POBCrashAnalyticsConstants.OW_FILTER, false, 2, (Object) null)) {
            return;
        }
        this.jsonArray.put(new POBCrashHelper(POBCrashAnalyticsConstants.ANR_FULL_FORM, strA, timeStamp).getCrashJson(this.context));
    }

    private final String a(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line != null) {
                    sb.append(line).append("\n");
                } else {
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(bufferedReader, null);
                    String string = sb.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "stringBuilder.toString()");
                    return string;
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(bufferedReader, th);
                    throw th2;
                }
            }
        }
    }

    private final String a(String data) {
        MatchResult matchResultFind$default = Regex.find$default(new Regex("\"main\" prio=.*?(?=\n\n)", RegexOption.DOT_MATCHES_ALL), data, 0, 2, null);
        if (matchResultFind$default != null) {
            return matchResultFind$default.getValue();
        }
        return null;
    }

    private final void a(long timeStamp) {
        POBSharedPreferenceUtil.writeValueInSharedPreference(this.context, POBCommonConstants.SHARED_PREF_NAME, POBCrashAnalyticsConstants.ANR_TIMESTAMP_KEY, Long.valueOf(timeStamp));
    }
}
