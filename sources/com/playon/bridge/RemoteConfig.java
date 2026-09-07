package com.playon.bridge;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import com.playon.bridge.common.AsyncTaskExecutor;
import com.playon.bridge.common.Log;
import com.playon.bridge.common.SdkInitializationListener;
import com.pubmatic.sdk.common.POBCommonConstants;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class RemoteConfig {
    protected static final int CONFIG_REFRESH_DELAY_SECONDS = 30;
    private SdkInitializationListener isInitialized;
    private final Activity mActivity;
    private CountDownTimer progressTick;
    private Drawable rewardEndLevelPopup;
    private Drawable rewardInLevelPopup;
    protected final String TAG = Log.makeTag("RemoteConfig");
    ConfigRequest configRequest = new ConfigRequest();
    private int protectionTimes = 3;
    private int protectionDelayMs = 30000;
    private int skipMs = 15000;
    private int minSkipMs = 10000;
    private int muteMs = 10000;
    private int minMuteMs = 5000;
    private int adExpire = 3600000;
    private int adPauseInterval = POBCommonConstants.BANNER_BID_EXPIRE_TIME_IN_MILLIS;
    private int maxAdVolume = 100;
    private int minAdVolume = 0;
    private int volumeBreakPoint = 100;
    private int requestWaitTime = 20;
    private int rewardInLevelTimeMs = 15000;
    private int rewardEndLevelTimeMs = 0;
    private int rewardMinVolumeLevel = 20;
    private boolean impressionCallbackEnabled = false;
    private int sessionTimeOut = 1800;

    public Drawable getInLevelPopUpImage() {
        return this.rewardInLevelPopup;
    }

    public Drawable getEndLevelPopUpImage() {
        return this.rewardEndLevelPopup;
    }

    public int getProtectionTimes() {
        return this.protectionTimes;
    }

    public int getProtectionDelayMs() {
        return this.protectionDelayMs;
    }

    public int getSkipMs() {
        return this.skipMs;
    }

    public int getMinSkipMs() {
        return this.minSkipMs;
    }

    public int getMuteMs() {
        return this.muteMs;
    }

    public int getMinMuteMs() {
        return this.minMuteMs;
    }

    public int getAdExpire() {
        return this.adExpire;
    }

    public int getAdPauseInterval() {
        return this.adPauseInterval;
    }

    public int getMaxAdVolume() {
        return this.maxAdVolume;
    }

    public int getMinAdVolume() {
        return this.minAdVolume;
    }

    public int getVolumeBreakPoint() {
        return this.volumeBreakPoint;
    }

    public int getRequestWaitTime() {
        return this.requestWaitTime;
    }

    public int getRewardInLevelTimeMs() {
        return this.rewardInLevelTimeMs;
    }

    public int getRewardEndLevelTimeMs() {
        return this.rewardEndLevelTimeMs;
    }

    public int getRewardMinVolumeLevel() {
        return this.rewardMinVolumeLevel;
    }

    public int getRewardInLevelTimeSeconds() {
        return this.rewardInLevelTimeMs / 1000;
    }

    public int getRewardEndLevelTimeSeconds() {
        return this.rewardEndLevelTimeMs / 1000;
    }

    public boolean getImpressionCallbackEnabled() {
        return this.impressionCallbackEnabled;
    }

    public int getSessionTimeOut() {
        return this.sessionTimeOut;
    }

    public RemoteConfig(Activity activity, SdkInitializationListener sdkInitializationListener) {
        this.mActivity = activity;
        this.isInitialized = sdkInitializationListener;
        this.rewardInLevelPopup = activity.getResources().getDrawable(R.drawable.inlevel_popup);
        this.rewardEndLevelPopup = activity.getResources().getDrawable(R.drawable.endlevel_popup);
        downloadConfig();
    }

    public void downloadConfig() {
        BaseUrlGenerator baseUrlGenerator = new BaseUrlGenerator();
        baseUrlGenerator.initUrlString("v1/config/package/" + PlayOnManager.getInstance().getPersonalInfo().getApplicationID());
        baseUrlGenerator.appendApiKey();
        baseUrlGenerator.appendAppInfo();
        baseUrlGenerator.appendFreshRequestID();
        baseUrlGenerator.appendSDKInfo();
        baseUrlGenerator.appendEngineInfo();
        baseUrlGenerator.appendCustomAttributes();
        this.configRequest.executeAsync(baseUrlGenerator.getFinalUrlString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RefreshWaitForSeconds(final float f) {
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.playon.bridge.RemoteConfig$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5489lambda$RefreshWaitForSeconds$0$complayonbridgeRemoteConfig(f);
            }
        });
    }

    /* JADX WARN: Type inference failed for: r7v4, types: [com.playon.bridge.RemoteConfig$1] */
    /* JADX INFO: renamed from: lambda$RefreshWaitForSeconds$0$com-playon-bridge-RemoteConfig, reason: not valid java name */
    /* synthetic */ void m5489lambda$RefreshWaitForSeconds$0$complayonbridgeRemoteConfig(float f) {
        long j = (long) (f * 1000.0f);
        try {
            CountDownTimer countDownTimer = this.progressTick;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.progressTick = new CountDownTimer(j, j) { // from class: com.playon.bridge.RemoteConfig.1
                @Override // android.os.CountDownTimer
                public void onTick(long j2) {
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    RemoteConfig.this.downloadConfig();
                }
            }.start();
        } catch (Exception unused) {
            Log.d(this.TAG, "CountDownTimerRemoteConfig exception");
        }
    }

    protected void onPause() {
        CountDownTimer countDownTimer = this.progressTick;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    protected void onResume() {
        RefreshWaitForSeconds(5.0f);
    }

    private class ConfigRequest extends AsyncTaskExecutor<String> {
        private ConfigRequest() {
        }

        private String inputStreamToString(InputStream inputStream) {
            StringBuilder sb = new StringBuilder();
            try {
                try {
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                    try {
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        while (true) {
                            try {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                }
                                sb.append(line);
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
                        return sb.toString();
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
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /* JADX WARN: Code duplicated, block: B:34:0x0065  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r1v2 */
        private Drawable URLToImage(String str) throws Throwable {
            HttpURLConnection httpURLConnection;
            ?? r1 = 0;
            try {
                try {
                    httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    try {
                        httpURLConnection.connect();
                        InputStream inputStream = httpURLConnection.getInputStream();
                        try {
                            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStream);
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            BitmapDrawable bitmapDrawable = new BitmapDrawable(Resources.getSystem(), bitmapDecodeStream);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            return bitmapDrawable;
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable th3) {
                                        th.addSuppressed(th3);
                                    }
                                }
                                throw th2;
                            }
                        }
                    } catch (IOException e) {
                        e = e;
                        Log.w(AsyncTaskExecutor.TAG, "Failed to download Image from url: " + e.getMessage());
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return null;
                    }
                } catch (IOException e2) {
                    e = e2;
                    httpURLConnection = null;
                } catch (Throwable th4) {
                    th = th4;
                    if (r1 != 0) {
                        r1.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
                r1 = str;
                if (r1 != 0) {
                    r1.disconnect();
                }
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Code duplicated, block: B:108:0x02e8  */
        /* JADX WARN: Code duplicated, block: B:114:? A[SYNTHETIC] */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.playon.bridge.common.AsyncTaskExecutor
        public void doInBackground(String... strArr) throws Throwable {
            Throwable th;
            HttpsURLConnection httpsURLConnection;
            Exception exc;
            HttpsURLConnection httpsURLConnection2;
            UnknownHostException unknownHostException;
            FileNotFoundException fileNotFoundException;
            char c;
            String str = "Download exception ";
            char c2 = 0;
            try {
                try {
                    if (strArr[0] != null) {
                        httpsURLConnection2 = (HttpsURLConnection) new URL(strArr[0]).openConnection();
                        try {
                            httpsURLConnection2.setReadTimeout(10000);
                            httpsURLConnection2.setConnectTimeout(15000);
                            httpsURLConnection2.setRequestMethod("GET");
                            httpsURLConnection2.setDoInput(true);
                            httpsURLConnection2.connect();
                            int responseCode = httpsURLConnection2.getResponseCode();
                            if (responseCode == 200) {
                                String strInputStreamToString = inputStreamToString(httpsURLConnection2.getInputStream());
                                Log.d(AsyncTaskExecutor.TAG, "CONFIGS: " + strInputStreamToString);
                                JSONObject jSONObject = new JSONObject(strInputStreamToString);
                                if (!jSONObject.isNull("requests_wait_time")) {
                                    RemoteConfig.this.requestWaitTime = jSONObject.getInt("requests_wait_time") * 1000;
                                }
                                if (!jSONObject.isNull("protection_capping")) {
                                    RemoteConfig.this.protectionTimes = jSONObject.getInt("protection_capping");
                                }
                                if (!jSONObject.isNull("protection_wait_time")) {
                                    RemoteConfig.this.protectionDelayMs = jSONObject.getInt("protection_wait_time") * 1000;
                                }
                                if (!jSONObject.isNull("skip_wait_time")) {
                                    RemoteConfig.this.skipMs = jSONObject.getInt("skip_wait_time") * 1000;
                                }
                                if (!jSONObject.isNull("min_skip_wait_time")) {
                                    RemoteConfig.this.minSkipMs = jSONObject.getInt("min_skip_wait_time") * 1000;
                                }
                                if (!jSONObject.isNull("mute_wait_time")) {
                                    RemoteConfig.this.muteMs = jSONObject.getInt("mute_wait_time") * 1000;
                                }
                                if (!jSONObject.isNull("min_mute_wait_time")) {
                                    RemoteConfig.this.minMuteMs = jSONObject.getInt("min_mute_wait_time") * 1000;
                                }
                                if (!jSONObject.isNull("max_ad_volume")) {
                                    RemoteConfig.this.maxAdVolume = jSONObject.getInt("max_ad_volume");
                                }
                                if (!jSONObject.isNull("min_ad_volume")) {
                                    RemoteConfig.this.minAdVolume = jSONObject.getInt("min_ad_volume");
                                }
                                if (!jSONObject.isNull("volume_break_point")) {
                                    RemoteConfig.this.volumeBreakPoint = jSONObject.getInt("volume_break_point");
                                }
                                if (!jSONObject.isNull("cache_interval")) {
                                    RemoteConfig.this.adExpire = jSONObject.getInt("cache_interval") * 1000;
                                }
                                if (!jSONObject.isNull("pause_interval")) {
                                    RemoteConfig.this.adPauseInterval = jSONObject.getInt("pause_interval") * 1000;
                                }
                                if (!jSONObject.isNull("reward_inlevel_time")) {
                                    RemoteConfig.this.rewardInLevelTimeMs = jSONObject.getInt("reward_inlevel_time") * 1000;
                                }
                                if (!jSONObject.isNull("reward_endlevel_time")) {
                                    RemoteConfig.this.rewardEndLevelTimeMs = jSONObject.getInt("reward_endlevel_time") * 1000;
                                }
                                if (!jSONObject.isNull("reward_min_volume_level")) {
                                    RemoteConfig.this.rewardMinVolumeLevel = jSONObject.getInt("reward_min_volume_level");
                                }
                                if (!jSONObject.isNull("reward_inlevel_popup")) {
                                    RemoteConfig.this.rewardInLevelPopup = URLToImage(jSONObject.getString("reward_inlevel_popup"));
                                }
                                if (!jSONObject.isNull("reward_endlevel_popup")) {
                                    RemoteConfig.this.rewardEndLevelPopup = URLToImage(jSONObject.getString("reward_endlevel_popup"));
                                }
                                if (!jSONObject.isNull("impression_callback_enabled")) {
                                    RemoteConfig.this.impressionCallbackEnabled = jSONObject.getBoolean("impression_callback_enabled");
                                }
                                if (!jSONObject.isNull("session_timeout")) {
                                    RemoteConfig.this.sessionTimeOut = jSONObject.getInt("session_timeout");
                                }
                                if (RemoteConfig.this.isInitialized != null) {
                                    RemoteConfig.this.isInitialized.onInitializationFinished();
                                    RemoteConfig.this.isInitialized = null;
                                }
                                Log.d(AsyncTaskExecutor.TAG, "Configs Loaded: " + strArr[0]);
                                PlayOnManager.getInstance().getSettings().RefreshWaitForSeconds(3600.0f);
                            } else {
                                Log.w(AsyncTaskExecutor.TAG, "Download Exception: Make sure, your app is added on Remote " + responseCode + " " + strArr[0]);
                                c2 = 4;
                            }
                        } catch (FileNotFoundException e) {
                            fileNotFoundException = e;
                            Log.w(AsyncTaskExecutor.TAG, fileNotFoundException, "Download exception: " + strArr[0]);
                            if (httpsURLConnection2 != null) {
                                httpsURLConnection2.disconnect();
                            }
                            c = 2;
                        } catch (UnknownHostException e2) {
                            unknownHostException = e2;
                            Log.w(AsyncTaskExecutor.TAG, unknownHostException, "Download exception " + strArr[0]);
                            if (httpsURLConnection2 != null) {
                                httpsURLConnection2.disconnect();
                            }
                            c = 1;
                        } catch (Exception e3) {
                            exc = e3;
                            Log.w(AsyncTaskExecutor.TAG, exc, "Exception: " + strArr[0]);
                            if (httpsURLConnection2 != null) {
                                httpsURLConnection2.disconnect();
                            }
                            c = 3;
                        }
                    } else {
                        httpsURLConnection2 = null;
                    }
                    if (httpsURLConnection2 != null) {
                        httpsURLConnection2.disconnect();
                    }
                    c = c2;
                } catch (FileNotFoundException e4) {
                    fileNotFoundException = e4;
                    httpsURLConnection2 = null;
                } catch (UnknownHostException e5) {
                    unknownHostException = e5;
                    httpsURLConnection2 = null;
                } catch (Exception e6) {
                    exc = e6;
                    httpsURLConnection2 = null;
                } catch (Throwable th2) {
                    th = th2;
                    httpsURLConnection = 0;
                    if (httpsURLConnection != 0) {
                        throw th;
                    }
                    httpsURLConnection.disconnect();
                    throw th;
                }
                if (c > 0) {
                    PlayOnManager.getInstance().getSettings().RefreshWaitForSeconds(30.0f);
                }
            } catch (Throwable th3) {
                th = th3;
                httpsURLConnection = str;
                if (httpsURLConnection != 0) {
                    throw th;
                }
                httpsURLConnection.disconnect();
                throw th;
            }
        }
    }
}
