package com.pubmatic.sdk.crashanalytics;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.pubmatic.sdk.common.POBError;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.network.POBHttpRequest;
import com.pubmatic.sdk.common.network.POBNetworkHandler;
import com.pubmatic.sdk.common.network.POBNetworkResult;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/pubmatic/sdk/crashanalytics/POBCrashReporter;", "", "<init>", "()V", "", "requestBody", "Lcom/pubmatic/sdk/common/network/POBHttpRequest;", "a", "(Ljava/lang/String;)Lcom/pubmatic/sdk/common/network/POBHttpRequest;", "Lcom/pubmatic/sdk/common/network/POBNetworkHandler;", "networkHandler", "Lorg/json/JSONObject;", "crashJsonObject", "Lcom/pubmatic/sdk/crashanalytics/POBCrashReporterListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "reportCrash", "(Lcom/pubmatic/sdk/common/network/POBNetworkHandler;Lorg/json/JSONObject;Lcom/pubmatic/sdk/crashanalytics/POBCrashReporterListener;)V", "crashanalytics_release"}, k = 1, mv = {1, 7, 1})
public final class POBCrashReporter {
    public static final POBCrashReporter INSTANCE = new POBCrashReporter();

    private POBCrashReporter() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(POBNetworkResult pOBNetworkResult) {
        if (pOBNetworkResult != null) {
            POBLog.debug("POBCrashReporter", pOBNetworkResult.toString(), new Object[0]);
        }
    }

    public final void reportCrash(POBNetworkHandler networkHandler, JSONObject crashJsonObject, final POBCrashReporterListener listener) {
        Intrinsics.checkNotNullParameter(networkHandler, "networkHandler");
        Intrinsics.checkNotNullParameter(crashJsonObject, "crashJsonObject");
        String string = crashJsonObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "crashJsonObject.toString()");
        networkHandler.sendJSONRequest(a(string), new POBNetworkHandler.POBNetworkListener<JSONObject>() { // from class: com.pubmatic.sdk.crashanalytics.POBCrashReporter.reportCrash.1
            @Override // com.pubmatic.sdk.common.network.POBNetworkHandler.POBNetworkListener
            public void onFailure(POBError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                POBLog.debug("POBCrashReporter", "Diagnostic data sync completed with error: " + error, new Object[0]);
                POBCrashReporterListener pOBCrashReporterListener = listener;
                if (pOBCrashReporterListener != null) {
                    pOBCrashReporterListener.onFailure();
                }
            }

            @Override // com.pubmatic.sdk.common.network.POBNetworkHandler.POBNetworkListener
            public void onSuccess(JSONObject response) {
                POBLog.debug("POBCrashReporter", String.valueOf(response), new Object[0]);
                POBLog.debug("POBCrashReporter", "Diagnostic data sync completed.", new Object[0]);
                POBCrashReporterListener pOBCrashReporterListener = listener;
                if (pOBCrashReporterListener != null) {
                    pOBCrashReporterListener.onSuccess();
                }
            }
        }, new POBNetworkHandler.POBNetworkResultListener() { // from class: com.pubmatic.sdk.crashanalytics.POBCrashReporter$$ExternalSyntheticLambda0
            @Override // com.pubmatic.sdk.common.network.POBNetworkHandler.POBNetworkResultListener
            public final void onResult(POBNetworkResult pOBNetworkResult) {
                POBCrashReporter.a(pOBNetworkResult);
            }
        });
    }

    private final POBHttpRequest a(String requestBody) {
        HashMap map = new HashMap();
        map.put("Content-Type", "application/json");
        POBHttpRequest pOBHttpRequest = new POBHttpRequest();
        pOBHttpRequest.setRequestMethod(POBHttpRequest.HTTP_METHOD.POST);
        pOBHttpRequest.setPostData(requestBody);
        pOBHttpRequest.setUrl(POBCrashAnalyticsConstants.REPORT_SERVER_URL);
        pOBHttpRequest.setRetryCount(3);
        pOBHttpRequest.setTimeout(5000);
        pOBHttpRequest.setHeaders(map);
        POBLog.debug("POBCrashReporter", "Sending request to crashlytics - : %s", pOBHttpRequest.toString());
        return pOBHttpRequest;
    }
}
