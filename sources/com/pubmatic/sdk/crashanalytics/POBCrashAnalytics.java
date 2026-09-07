package com.pubmatic.sdk.crashanalytics;

import android.content.Context;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.pubmatic.sdk.common.POBCrashAnalysing;
import com.pubmatic.sdk.common.POBInstanceProvider;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.network.POBNetworkHandler;
import com.pubmatic.sdk.common.taskhandler.POBTaskHandler;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0002\r\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/pubmatic/sdk/crashanalytics/POBCrashAnalytics;", "Lcom/pubmatic/sdk/common/POBCrashAnalysing;", "()V", "crashHandler", "Lcom/pubmatic/sdk/crashanalytics/POBCrashHandler;", "isInitialized", "", MobileAdsBridgeBase.initializeMethodName, "", "context", "Landroid/content/Context;", "invalidate", "readCrash", "Companion", "POBCrashReporterListenerImpl", "crashanalytics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class POBCrashAnalytics implements POBCrashAnalysing {
    private static final String TAG = "POBCrashAnalytics";
    private POBCrashHandler crashHandler;
    private boolean isInitialized;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/pubmatic/sdk/crashanalytics/POBCrashAnalytics$POBCrashReporterListenerImpl;", "Lcom/pubmatic/sdk/crashanalytics/POBCrashReporterListener;", "Landroid/content/Context;", "context", "Lorg/json/JSONArray;", "reqJSONArray", "<init>", "(Lcom/pubmatic/sdk/crashanalytics/POBCrashAnalytics;Landroid/content/Context;Lorg/json/JSONArray;)V", "", "onSuccess", "()V", "onFailure", "a", "Landroid/content/Context;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lorg/json/JSONArray;", "crashanalytics_release"}, k = 1, mv = {1, 7, 1})
    public final class POBCrashReporterListenerImpl implements POBCrashReporterListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final Context context;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private final JSONArray reqJSONArray;
        final /* synthetic */ POBCrashAnalytics c;

        public POBCrashReporterListenerImpl(POBCrashAnalytics pOBCrashAnalytics, Context context, JSONArray reqJSONArray) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(reqJSONArray, "reqJSONArray");
            this.c = pOBCrashAnalytics;
            this.context = context;
            this.reqJSONArray = reqJSONArray;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(POBCrashReporterListenerImpl this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.reqJSONArray.length() != 0) {
                while (this$0.reqJSONArray.length() > 10) {
                    this$0.reqJSONArray.remove(0);
                }
                Context context = this$0.context;
                String string = this$0.reqJSONArray.toString();
                Intrinsics.checkNotNullExpressionValue(string, "reqJSONArray.toString()");
                POBCrashAnalyticsUtils.writeToFile(context, POBCrashAnalyticsConstants.CRASH_DATA_FILE, string);
                POBCrashStorage.INSTANCE.setCrashJsonArray(this$0.reqJSONArray);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(POBCrashReporterListenerImpl this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            POBCrashAnalyticsUtils.writeToFile(this$0.context, POBCrashAnalyticsConstants.CRASH_DATA_FILE, "");
            POBCrashStorage.INSTANCE.clear();
        }

        @Override // com.pubmatic.sdk.crashanalytics.POBCrashReporterListener
        public void onFailure() {
            POBTaskHandler.INSTANCE.getInstance().runOnBackgroundThread(new Runnable() { // from class: com.pubmatic.sdk.crashanalytics.POBCrashAnalytics$POBCrashReporterListenerImpl$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    POBCrashAnalytics.POBCrashReporterListenerImpl.a(this.f$0);
                }
            });
        }

        @Override // com.pubmatic.sdk.crashanalytics.POBCrashReporterListener
        public void onSuccess() {
            POBTaskHandler.INSTANCE.getInstance().runOnBackgroundThread(new Runnable() { // from class: com.pubmatic.sdk.crashanalytics.POBCrashAnalytics$POBCrashReporterListenerImpl$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    POBCrashAnalytics.POBCrashReporterListenerImpl.b(this.f$0);
                }
            });
        }
    }

    static final class a extends Lambda implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f7655a;
        final /* synthetic */ POBCrashAnalytics b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, POBCrashAnalytics pOBCrashAnalytics) {
            super(0);
            this.f7655a = context;
            this.b = pOBCrashAnalytics;
        }

        public final void a() throws JSONException {
            JSONArray jSONArray = new JSONArray();
            String fromFile = POBCrashAnalyticsUtils.readFromFile(this.f7655a, POBCrashAnalyticsConstants.CRASH_DATA_FILE);
            if (fromFile != null) {
                try {
                    jSONArray = new JSONArray(fromFile);
                } catch (JSONException e) {
                    POBLog.debug(POBCrashAnalytics.TAG, "Exception occurred while converting stringified jsonto JSONArray. Message -> " + e.getMessage() + '.', new Object[0]);
                }
            }
            POBCrashStorage.INSTANCE.setCrashJsonArray(jSONArray);
            JSONArray jsonArray = new POBANRReader(this.f7655a).getJsonArray();
            int length = jsonArray.length();
            for (int i = 0; i < length; i++) {
                jSONArray.put(jsonArray.getJSONObject(i));
            }
            if (jSONArray.length() == 0) {
                POBLog.debug(POBCrashAnalytics.TAG, "No previously saved diagnostic data found.", new Object[0]);
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(POBCrashAnalyticsConstants.CRASHES_KEY, jSONArray);
            POBCrashReporter pOBCrashReporter = POBCrashReporter.INSTANCE;
            POBNetworkHandler networkHandler = POBInstanceProvider.getNetworkHandler(this.f7655a);
            Intrinsics.checkNotNullExpressionValue(networkHandler, "getNetworkHandler(context)");
            pOBCrashReporter.reportCrash(networkHandler, jSONObject, new POBCrashReporterListenerImpl(this.b, this.f7655a, jSONArray));
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() throws JSONException {
            a();
            return Unit.INSTANCE;
        }
    }

    private final void readCrash(Context context) {
        ThreadsKt.thread$default(true, false, null, null, 0, new a(context, this), 30, null);
    }

    @Override // com.pubmatic.sdk.common.POBCrashAnalysing
    public void initialize(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.isInitialized) {
            return;
        }
        POBCrashHandler pOBCrashHandler = new POBCrashHandler(context, Thread.getDefaultUncaughtExceptionHandler());
        this.crashHandler = pOBCrashHandler;
        Thread.setDefaultUncaughtExceptionHandler(pOBCrashHandler);
        readCrash(context);
        this.isInitialized = true;
    }

    @Override // com.pubmatic.sdk.common.POBCrashAnalysing
    public void invalidate() {
        POBCrashStorage.INSTANCE.clear();
        if (this.isInitialized) {
            POBCrashHandler pOBCrashHandler = this.crashHandler;
            if (pOBCrashHandler != null) {
                pOBCrashHandler.destroy();
            }
            this.crashHandler = null;
            this.isInitialized = false;
        }
    }
}
