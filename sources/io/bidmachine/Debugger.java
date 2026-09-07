package io.bidmachine;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import io.bidmachine.core.Utils;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
class Debugger {
    private static final String DIR_NAME = "features";
    private static final String FILE_NAME = "DebugParameters.json";
    private static final String PARAMETER_CONSENT = "consent";
    private static final String PARAMETER_COPPA = "coppa";
    private static final String PARAMETER_ENDPOINT = "endpoint";
    private static final String PARAMETER_GDPR_STRING = "GDPRString";
    private static final String PARAMETER_LOGGING_ENABLED = "loggingEnabled";
    private static final String PARAMETER_SUBJECT_TO_GDPR = "subjectToGDPR";
    private static final String PARAMETER_TEST_MODE = "testMode";
    private static final String PARAMETER_US_PRIVACY_STRING = "usPrivacyString";
    private static final String TAG = "Debugger";

    Debugger() {
    }

    static void setup(Context context) {
        try {
            File externalFilesDirDirty = Utils.getExternalFilesDirDirty(context);
            if (externalFilesDirDirty == null) {
                return;
            }
            File file = new File(externalFilesDirDirty, "features/DebugParameters.json");
            if (file.exists()) {
                Log.d(TAG, "Debug file founded");
                String file2 = Utils.readFile(file);
                if (TextUtils.isEmpty(file2)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(file2);
                if (jSONObject.has(PARAMETER_LOGGING_ENABLED)) {
                    BidMachine.setLoggingEnabled(jSONObject.optBoolean(PARAMETER_LOGGING_ENABLED));
                }
                if (jSONObject.has(PARAMETER_TEST_MODE)) {
                    BidMachine.setTestMode(jSONObject.optBoolean(PARAMETER_TEST_MODE));
                }
                if (jSONObject.has("endpoint")) {
                    String strOptString = jSONObject.optString("endpoint");
                    if (!TextUtils.isEmpty(strOptString) && Utils.isHttpUrl(strOptString)) {
                        BidMachine.setEndpoint(strOptString);
                    }
                }
                if (jSONObject.has("coppa")) {
                    BidMachine.setCoppa(Boolean.valueOf(jSONObject.optBoolean("coppa")));
                }
                if (jSONObject.has(PARAMETER_US_PRIVACY_STRING)) {
                    BidMachine.setUSPrivacyString(jSONObject.optString(PARAMETER_US_PRIVACY_STRING));
                }
                if (jSONObject.has(PARAMETER_SUBJECT_TO_GDPR)) {
                    BidMachine.setSubjectToGDPR(Boolean.valueOf(jSONObject.optBoolean(PARAMETER_SUBJECT_TO_GDPR)));
                }
                if (jSONObject.has("consent")) {
                    BidMachine.setConsentConfig(jSONObject.optBoolean("consent"), jSONObject.has(PARAMETER_GDPR_STRING) ? jSONObject.optString(PARAMETER_GDPR_STRING) : null);
                }
            }
        } catch (Throwable th) {
            Log.w(TAG, th);
        }
    }
}
