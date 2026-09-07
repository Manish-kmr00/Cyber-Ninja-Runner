package com.playon.bridge;

import android.app.Activity;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.iab.omid.library.odeeoio.Omid;
import com.playon.bridge.common.AsyncTaskExecutor;
import com.playon.bridge.common.CompositeSdkInitializationListener;
import com.playon.bridge.common.DefaultConsentData;
import com.playon.bridge.common.Log;
import com.playon.bridge.common.SdkInitializationListener;
import com.playon.bridge.common.util.LocationUtil;
import com.playon.bridge.common.util.Preconditions;
import com.playon.bridge.dto.consent.ConsentType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class PlayOnManager {
    public static final String SDK_VERSION = "2.0.9";
    private static PlayOnManager instance;
    Date _engageSessionInterruptBeginTime;
    Date _engageSessionInterruptEndTime;
    Date _engageSessionStartupTime;
    String _trackingEventURL;
    private ClientMetadata mClientMetadata;
    private PersonalInfoManager mPersonalInfo;
    private RemoteConfig mRemoteConfigs;
    private SdkInitializationListener onInitialization;
    protected final String TAG = Log.makeTag("PlayOnManager");
    private boolean initialized = false;
    private boolean initializeLocked = false;
    private boolean isPaused = false;
    private final DefaultConsentData consentData = new DefaultConsentData();
    private final ArrayList<AdUnit> adUnitsArray = new ArrayList<>();
    int _engageSessionLength = 0;
    SdkInitializationListener allInitializationsFinished = new SdkInitializationListener() { // from class: com.playon.bridge.PlayOnManager$$ExternalSyntheticLambda2
        @Override // com.playon.bridge.common.SdkInitializationListener
        public final void onInitializationFinished() {
            this.f$0.m5487lambda$new$2$complayonbridgePlayOnManager();
        }
    };

    public interface AdActivity {
        void onClick();

        void onError(int i);

        void onImpression(ImpressionData impressionData);

        void onReward(float f);

        void onShow();

        void onSuccess();
    }

    public interface AdListener {
        void onAvailabilityChanged(boolean z);

        void onClick();

        void onClose();

        void onImpression(ImpressionData impressionData);

        void onReward(float f);

        void onShow();
    }

    public static PlayOnManager getInstance() {
        if (instance == null) {
            instance = new PlayOnManager();
        }
        return instance;
    }

    public void initialize(final Activity activity, String str) {
        if (this.initialized || this.initializeLocked) {
            return;
        }
        this.initializeLocked = true;
        Preconditions.checkNotNull(activity);
        final CompositeSdkInitializationListener compositeSdkInitializationListener = new CompositeSdkInitializationListener(this.allInitializationsFinished, 3);
        LocationUtil.prefetchNetworkLocation(activity.getApplicationContext());
        PersonalInfoManager personalInfoManager = new PersonalInfoManager(activity, str, compositeSdkInitializationListener);
        this.mPersonalInfo = personalInfoManager;
        this.consentData.processDefaultValues(personalInfoManager);
        this.mRemoteConfigs = new RemoteConfig(activity, compositeSdkInitializationListener);
        new InitializeRequest(new SdkInitializationListener() { // from class: com.playon.bridge.PlayOnManager$$ExternalSyntheticLambda0
            @Override // com.playon.bridge.common.SdkInitializationListener
            public final void onInitializationFinished() {
                this.f$0.m5486lambda$initialize$0$complayonbridgePlayOnManager(activity, compositeSdkInitializationListener);
            }
        }).executeAsync();
        if (Omid.isActive()) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.playon.bridge.PlayOnManager$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                Omid.activate(activity);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initialize$0$com-playon-bridge-PlayOnManager, reason: not valid java name */
    /* synthetic */ void m5486lambda$initialize$0$complayonbridgePlayOnManager(Activity activity, CompositeSdkInitializationListener compositeSdkInitializationListener) {
        this.mClientMetadata = new ClientMetadata(activity, compositeSdkInitializationListener);
    }

    /* JADX INFO: renamed from: lambda$new$2$com-playon-bridge-PlayOnManager, reason: not valid java name */
    /* synthetic */ void m5487lambda$new$2$complayonbridgePlayOnManager() {
        Log.i(this.TAG, "Initialization Finished");
        this.initialized = true;
        this.initializeLocked = false;
        SdkInitializationListener sdkInitializationListener = this.onInitialization;
        if (sdkInitializationListener != null) {
            sdkInitializationListener.onInitializationFinished();
        }
        for (int i = 0; i < this.adUnitsArray.size(); i++) {
            this.adUnitsArray.get(i).loadAd();
        }
    }

    public boolean isInitialized() {
        return this.initialized;
    }

    protected void AddAdUnit(AdUnit adUnit) {
        this.adUnitsArray.add(adUnit);
    }

    protected void RemoveAdUnit(AdUnit adUnit) {
        this.adUnitsArray.remove(adUnit);
    }

    protected RemoteConfig getSettings() {
        return this.mRemoteConfigs;
    }

    protected PersonalInfoManager getPersonalInfo() {
        return this.mPersonalInfo;
    }

    protected ClientMetadata getClientMetadata() {
        return this.mClientMetadata;
    }

    public float getDeviceVolumeLevel() {
        ClientMetadata clientMetadata = this.mClientMetadata;
        if (clientMetadata == null) {
            Log.w(this.TAG, "Unavailable to detect Device Volume Level. Sent -1. Please make sure PlayOnManager is initialized.");
            return -1.0f;
        }
        return clientMetadata.getDeviceVolumeLevel();
    }

    public void setEngineInformation(String str, String str2) {
        BaseUrlGenerator.setEngineInfo(str, str2);
    }

    public void setLogLevel(Log.LogLevel logLevel) {
        Log.level = logLevel;
    }

    public void addCustomAttribute(String str, String str2) {
        BaseUrlGenerator.addCustomAttribute(str, str2);
    }

    public List<Map.Entry<String, String>> getCustomAttributes() {
        return BaseUrlGenerator.getCustomAttributes();
    }

    public List<Map.Entry<String, String>> getCustomAttributes(String str) {
        return BaseUrlGenerator.getCustomAttributes(str);
    }

    public String getConsentString() {
        if (isPersonalInfoNotInitialized("ConsentString")) {
            return this.consentData.getConsentStr();
        }
        return getPersonalInfo().getConsentString();
    }

    public boolean isGeneralConsentGiven() {
        if (isPersonalInfoNotInitialized("isGeneralConsentGiven")) {
            return this.consentData.isGeneralConsentGiven();
        }
        return getPersonalInfo().isGeneralConsentGiven();
    }

    public void clearConsentString() {
        if (this.mPersonalInfo == null) {
            this.consentData.clearConsentString();
        } else {
            getPersonalInfo().clearConsentString();
        }
    }

    public void setGdprConsent(boolean z) {
        if (this.mPersonalInfo == null) {
            this.consentData.setGdprConsent(z, null);
        } else {
            getPersonalInfo().setGdprConsent(z, null);
        }
    }

    public void setGdprConsent(boolean z, String str) {
        if (this.mPersonalInfo == null) {
            this.consentData.setGdprConsent(z, str);
        } else {
            getPersonalInfo().setGdprConsent(z, str);
        }
    }

    public void setConsentString(String str) {
        if (this.mPersonalInfo == null) {
            this.consentData.setConsentStr(str);
        } else {
            getPersonalInfo().setConsentString(str);
        }
    }

    public void setDoNotSell(boolean z) {
        if (this.mPersonalInfo == null) {
            this.consentData.setDoNotSell(z, null);
        } else {
            getPersonalInfo().setDoNotSell(z, null);
        }
    }

    public void setDoNotSell(boolean z, String str) {
        if (this.mPersonalInfo == null) {
            this.consentData.setDoNotSell(z, str);
        } else {
            getPersonalInfo().setDoNotSell(z, str);
        }
    }

    public void clearForceRegulationType() {
        if (this.mPersonalInfo == null) {
            this.consentData.clearForceRegulationType();
        } else {
            getPersonalInfo().clearForceRegulationType();
        }
    }

    public void forceRegulationType(ConsentType consentType) {
        if (this.mPersonalInfo == null) {
            this.consentData.forceRegulationType(consentType);
        } else {
            getPersonalInfo().forceRegulationType(consentType);
        }
    }

    public ConsentType getRegulationType() {
        if (isPersonalInfoNotInitialized("RegulationType")) {
            return ConsentType.Undefined;
        }
        return getPersonalInfo().getRegulationType();
    }

    private boolean isPersonalInfoNotInitialized(String str) {
        if (this.mPersonalInfo != null) {
            return false;
        }
        Log.e(this.TAG, "Default " + str + " value is retrieved.\nPlease initialize PlayOnManager before retrieving actual " + str + " value");
        return true;
    }

    public void setIsChildDirected(boolean z) {
        PersonalInfoManager personalInfoManager = this.mPersonalInfo;
        if (personalInfoManager == null) {
            this.consentData.setChildDirected(z);
        } else {
            personalInfoManager.setIsChildDirected(z);
        }
    }

    public boolean getIsChildDirected() {
        if (isPersonalInfoNotInitialized("isChildDirected")) {
            return this.consentData.isChildDirected();
        }
        return this.mPersonalInfo.getIsChildDirected().booleanValue();
    }

    public void clearCustomAttributes() {
        BaseUrlGenerator.clearCustomAttributes();
    }

    public void removeCustomAttribute(String str) {
        BaseUrlGenerator.removeCustomAttribute(str);
    }

    public void setOnInitializationListener(SdkInitializationListener sdkInitializationListener) {
        this.onInitialization = sdkInitializationListener;
    }

    public SdkInitializationListener getOnInitializationListener() {
        return this.onInitialization;
    }

    public void OnPause() {
        this.isPaused = true;
        RemoteConfig remoteConfig = this.mRemoteConfigs;
        if (remoteConfig != null) {
            remoteConfig.onPause();
        }
        if (isInitialized()) {
            Preconditions.checkNotNull(this.adUnitsArray);
            for (int i = 0; i < this.adUnitsArray.size(); i++) {
                this.adUnitsArray.get(i).onPause();
            }
            this._engageSessionInterruptBeginTime = Calendar.getInstance().getTime();
        }
    }

    public void OnResume() {
        this.isPaused = false;
        if (!isInitialized()) {
            this.initializeLocked = false;
            return;
        }
        Preconditions.checkNotNull(this.mRemoteConfigs);
        Preconditions.checkNotNull(this.adUnitsArray);
        for (int i = 0; i < this.adUnitsArray.size(); i++) {
            this.adUnitsArray.get(i).onResume();
        }
        if (this._engageSessionInterruptBeginTime == null) {
            this._engageSessionInterruptBeginTime = Calendar.getInstance().getTime();
        }
        if (this._engageSessionStartupTime == null) {
            this._engageSessionStartupTime = Calendar.getInstance().getTime();
        }
        this._engageSessionInterruptEndTime = Calendar.getInstance().getTime();
        this._engageSessionLength = (int) (((long) this._engageSessionLength) + (this._engageSessionInterruptBeginTime.getTime() - this._engageSessionStartupTime.getTime()));
        Date date = this._engageSessionInterruptEndTime;
        this._engageSessionStartupTime = date;
        if ((date.getTime() - this._engageSessionInterruptBeginTime.getTime()) / 1000 > getSettings().getSessionTimeOut()) {
            sessionEndEvent();
            sessionStartEvent();
        }
        this.mRemoteConfigs.onResume();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sessionStartEvent() {
        this._engageSessionStartupTime = Calendar.getInstance().getTime();
        this._engageSessionLength = 0;
        String string = UUID.randomUUID().toString();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event_id", "sessionStart");
            jSONObject.put(SDKAnalyticsEvents.PARAMETER_SESSION_ID, string);
            jSONObject.put("playon_id", getPersonalInfo().getPlayOnIdentifier());
            jSONObject.put("package_id", getPersonalInfo().getApplicationID());
            jSONObject.put("sdk_version", "2.0.9");
            jSONObject.put("platform", "android");
            Ad.postCustomEvent(this._trackingEventURL, jSONObject);
        } catch (Exception e) {
            Log.w(this.TAG, "Post exception: " + e.getMessage());
        }
        getPersonalInfo().setSessionID(string);
    }

    private void sessionEndEvent() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event_id", "sessionEnd");
            jSONObject.put(SDKAnalyticsEvents.PARAMETER_SESSION_ID, getPersonalInfo().getSessionID());
            jSONObject.put("playon_id", getPersonalInfo().getPlayOnIdentifier());
            jSONObject.put("package_id", getPersonalInfo().getApplicationID());
            jSONObject.put("sdk_version", "2.0.9");
            jSONObject.put("platform", "android");
            jSONObject.put("session_length", this._engageSessionLength / 1000);
            Ad.postCustomEvent(this._trackingEventURL, jSONObject);
        } catch (Exception e) {
            Log.w(this.TAG, "Post exception: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class InitializeRequest extends AsyncTaskExecutor<SdkInitializationListener> {
        private SdkInitializationListener initListener;

        private InitializeRequest(SdkInitializationListener sdkInitializationListener) {
            this.initListener = sdkInitializationListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void executeAsync() {
            executeAsync(this.initListener);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Code duplicated, block: B:85:0x01a2 A[PHI: r6
  0x01a2: PHI (r6v9 ??) = (r6v32 ??), (r6v33 ??) binds: [B:84:0x01a0, B:88:0x01b5] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v10 */
        /* JADX WARN: Type inference failed for: r6v11 */
        /* JADX WARN: Type inference failed for: r6v13 */
        /* JADX WARN: Type inference failed for: r6v14 */
        /* JADX WARN: Type inference failed for: r6v15 */
        /* JADX WARN: Type inference failed for: r6v20 */
        /* JADX WARN: Type inference failed for: r6v26 */
        /* JADX WARN: Type inference failed for: r6v27 */
        /* JADX WARN: Type inference failed for: r6v28 */
        /* JADX WARN: Type inference failed for: r6v29 */
        /* JADX WARN: Type inference failed for: r6v30 */
        /* JADX WARN: Type inference failed for: r6v31 */
        /* JADX WARN: Type inference failed for: r6v32 */
        /* JADX WARN: Type inference failed for: r6v33 */
        /* JADX WARN: Type inference failed for: r6v5 */
        /* JADX WARN: Type inference failed for: r6v6 */
        /* JADX WARN: Type inference failed for: r6v7, types: [javax.net.ssl.HttpsURLConnection] */
        /* JADX WARN: Type inference failed for: r6v8 */
        /* JADX WARN: Type inference failed for: r6v9, types: [javax.net.ssl.HttpsURLConnection] */
        @Override // com.playon.bridge.common.AsyncTaskExecutor
        public void doInBackground(SdkInitializationListener... sdkInitializationListenerArr) throws Throwable {
            int responseCode;
            Preconditions.checkNotNull(PlayOnManager.this.mPersonalInfo);
            BaseUrlGenerator baseUrlGenerator = new BaseUrlGenerator();
            baseUrlGenerator.initUrlString("v1/initialize");
            baseUrlGenerator.appendApiKey();
            baseUrlGenerator.appendAppInfo();
            baseUrlGenerator.appendFreshRequestID();
            baseUrlGenerator.appendSDKInfo();
            baseUrlGenerator.appendEngineInfo();
            baseUrlGenerator.appendCustomAttributes();
            Log.d(AsyncTaskExecutor.TAG, "Initialization: " + baseUrlGenerator.getFinalUrlString());
            ?? r6 = 0;
            r6 = 0;
            r6 = 0;
            r6 = 0;
            try {
                try {
                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(baseUrlGenerator.getFinalUrlString()).openConnection();
                    try {
                        httpsURLConnection.setReadTimeout(10000);
                        httpsURLConnection.setConnectTimeout(15000);
                        httpsURLConnection.setRequestMethod("GET");
                        httpsURLConnection.setDoInput(true);
                        httpsURLConnection.connect();
                        responseCode = httpsURLConnection.getResponseCode();
                        if (responseCode == 200) {
                            Log.d(AsyncTaskExecutor.TAG, "Request Code: " + responseCode);
                            StringBuilder sb = new StringBuilder();
                            try {
                                InputStream inputStream = httpsURLConnection.getInputStream();
                                try {
                                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                                    try {
                                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                                        while (true) {
                                            try {
                                                String line = bufferedReader.readLine();
                                                if (line == null) {
                                                    break;
                                                } else {
                                                    sb.append(line);
                                                }
                                            } catch (Throwable th) {
                                                try {
                                                    throw th;
                                                } catch (Throwable th2) {
                                                    try {
                                                        bufferedReader.close();
                                                    } catch (Throwable th3) {
                                                        th.addSuppressed(th3);
                                                    }
                                                    throw th2;
                                                }
                                            }
                                            try {
                                                throw th;
                                            } catch (Throwable th4) {
                                                try {
                                                    inputStreamReader.close();
                                                } catch (Throwable th5) {
                                                    th.addSuppressed(th5);
                                                }
                                                throw th4;
                                            }
                                        }
                                        bufferedReader.close();
                                        inputStreamReader.close();
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        JSONObject jSONObject = new JSONObject(sb.toString());
                                        if (jSONObject.isNull("gdpr_applies")) {
                                            Log.d(AsyncTaskExecutor.TAG, "gdpr_applies value is missing, something wrong");
                                        } else {
                                            PlayOnManager.this.mPersonalInfo.setIsGdprApplied(jSONObject.getBoolean("gdpr_applies"));
                                        }
                                        if (jSONObject.isNull("ccpa_applies")) {
                                            Log.d(AsyncTaskExecutor.TAG, "ccpa_applies value is missing, something wrong");
                                        } else {
                                            PlayOnManager.this.mPersonalInfo.setIsCcpaApplied(jSONObject.getBoolean("ccpa_applies"));
                                        }
                                        if (jSONObject.isNull("tracking_session_event_api")) {
                                            Log.d(AsyncTaskExecutor.TAG, "tracking_session_event_api value is missing, something wrong");
                                        } else {
                                            PlayOnManager.this._trackingEventURL = jSONObject.getString("tracking_session_event_api");
                                        }
                                        if (jSONObject.isNull("country")) {
                                            Log.d(AsyncTaskExecutor.TAG, "country value is missing, something wrong");
                                        } else {
                                            PlayOnManager.this.mPersonalInfo.SetCountry(jSONObject.getString("country"));
                                        }
                                        PlayOnManager.this.sessionStartEvent();
                                        sdkInitializationListenerArr[0].onInitializationFinished();
                                        r6 = jSONObject;
                                    } catch (Throwable th6) {
                                        throw th6;
                                    }
                                } catch (Throwable th7) {
                                    try {
                                        throw th7;
                                    } catch (Throwable th8) {
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (Throwable th9) {
                                                th7.addSuppressed(th9);
                                            }
                                        }
                                        throw th8;
                                    }
                                }
                            } catch (Exception e) {
                                Log.w(AsyncTaskExecutor.TAG, "exception in initialization", e);
                            }
                        } else if (responseCode == 401) {
                            Log.w(AsyncTaskExecutor.TAG, "exception initialization, API_KEY error");
                        } else {
                            Log.w(AsyncTaskExecutor.TAG, "exception initialization, something went wrong");
                        }
                        if (httpsURLConnection != null) {
                            r6 = responseCode;
                            r6 = responseCode;
                            httpsURLConnection.disconnect();
                        }
                    } catch (UnknownHostException e2) {
                        e = e2;
                        r6 = httpsURLConnection;
                        Log.w(AsyncTaskExecutor.TAG, "device is offline, refreshing", e);
                        refreshWaitForSeconds(30);
                        r6 = r6;
                        if (r6 != 0) {
                            r6.disconnect();
                        }
                    } catch (IOException e3) {
                        e = e3;
                        r6 = httpsURLConnection;
                        Log.w(AsyncTaskExecutor.TAG, "exception initialization event", e);
                        r6 = r6;
                        if (r6 != 0) {
                            r6.disconnect();
                        }
                    } catch (JSONException e4) {
                        e = e4;
                        r6 = httpsURLConnection;
                        Log.w(AsyncTaskExecutor.TAG, "exception initialization event", e);
                        r6 = r6;
                        if (r6 != 0) {
                            r6.disconnect();
                        }
                    } catch (Throwable th10) {
                        th = th10;
                        r6 = httpsURLConnection;
                        if (r6 != 0) {
                            r6.disconnect();
                        }
                        throw th;
                    }
                } catch (UnknownHostException e5) {
                    e = e5;
                } catch (IOException e6) {
                    e = e6;
                } catch (JSONException e7) {
                    e = e7;
                }
                r6 = responseCode;
                r6 = responseCode;
            } catch (Throwable th11) {
                th = th11;
            }
        }

        private void refreshWaitForSeconds(int i) {
            if (PlayOnManager.this.isPaused) {
                return;
            }
            executeAsyncWithDelay(i, new Runnable() { // from class: com.playon.bridge.PlayOnManager$InitializeRequest$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    this.f$0.m5488xb02012b0();
                }
            });
        }

        /* JADX INFO: renamed from: lambda$refreshWaitForSeconds$0$com-playon-bridge-PlayOnManager$InitializeRequest, reason: not valid java name */
        /* synthetic */ void m5488xb02012b0() throws Throwable {
            doInBackground(this.initListener);
        }
    }
}
