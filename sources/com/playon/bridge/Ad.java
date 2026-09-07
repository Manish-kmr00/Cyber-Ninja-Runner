package com.playon.bridge;

import android.net.Uri;
import com.playon.bridge.common.AsyncTaskExecutor;
import com.playon.bridge.common.Log;
import com.playon.bridge.common.util.Preconditions;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class Ad {
    public static final String ADVERIFICATIONS = "verifications";
    public static final String COMPANION = "companion";
    public static final String COMPANION_CLICK_THROUGH_EVENT = "companion_click_through_events";
    public static final String COMPANION_CLICK_TRACKING_EVENT = "companion_click_tracking_events";
    public static final String COMPANION_TRACKING_EVENTS = "companion_tracking_events";
    public static final String DURATION = "duration";
    public static final String FORMAT = "format";
    public static final String HEIGHT = "height";
    public static final String HTML = "html";
    public static final String IMPRESSION_INTERNAL_TRACKING_URLS = "impression_internal_tracking_urls";
    public static final String IMPRESSION_TRACKING_URLS = "impression_tracking_urls";
    public static final String MEDIA_TRACKING_EVENTS = "media_tracking_events";
    public static final String MIME_TYPE = "mime_type";
    public static final String PRICING = "price";
    public static final String PRICINGCURRENCY = "price_currency";
    public static final String PRICINGMODEL = "price_model";
    public static final String PRICINGVALUE = "price_value";
    public static final String REWARD_GRANTED_CALLBACK_URL = "reward_granted_callback_url";
    public static final String REWARD_REJECTED_CALLBACK_URL = "reward_rejected_callback_url";
    public static final String SOUND_VISUALISER_ENABLED = "sound_visualiser_enabled";
    private static final String TAG = Log.makeTag("Ad");
    public static final String TITLE = "title";
    public static final String TRACKINGEVENTPAYLOAD = "tracking_event_payload";
    public static final String TRACKINGEVENTURL = "tracking_event_url";
    public static final String URL = "url";
    public static final String VERIFICATIONPARAM = "param";
    public static final String VERIFICATIONRESOURCE = "resource";
    public static final String VERIFICATIONVENDOR = "vendor";
    public static final String WIDTH = "width";

    private Ad() {
    }

    public static void postCustomEvent(String str, final JSONObject jSONObject) {
        if (str == null) {
            return;
        }
        new AsyncTaskExecutor<String>() { // from class: com.playon.bridge.Ad.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.playon.bridge.common.AsyncTaskExecutor
            public void doInBackground(String... strArr) throws Throwable {
                postingUrlTask(strArr[0], jSONObject);
            }

            private void postingUrlTask(String str2, JSONObject jSONObject2) throws Throwable {
                HttpsURLConnection httpsURLConnection = null;
                try {
                    try {
                        HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) new URL(str2).openConnection();
                        try {
                            httpsURLConnection2.setReadTimeout(10000);
                            httpsURLConnection2.setConnectTimeout(15000);
                            httpsURLConnection2.setRequestMethod("POST");
                            httpsURLConnection2.setRequestProperty("Content-Type", "application/json; utf-8");
                            httpsURLConnection2.setRequestProperty("Accept", "application/json");
                            httpsURLConnection2.setDoOutput(true);
                            httpsURLConnection2.connect();
                            if (jSONObject2 != null) {
                                OutputStream outputStream = httpsURLConnection2.getOutputStream();
                                try {
                                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                                    try {
                                        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                                        try {
                                            bufferedWriter.write(jSONObject2.toString());
                                            bufferedWriter.flush();
                                            bufferedWriter.close();
                                            outputStreamWriter.close();
                                            if (outputStream != null) {
                                                outputStream.close();
                                            }
                                        } catch (Throwable th) {
                                            try {
                                                throw th;
                                            } catch (Throwable th2) {
                                                try {
                                                    bufferedWriter.close();
                                                } catch (Throwable th3) {
                                                    th.addSuppressed(th3);
                                                }
                                                throw th2;
                                            }
                                        }
                                    } catch (Throwable th4) {
                                        try {
                                            throw th4;
                                        } catch (Throwable th5) {
                                            try {
                                                outputStreamWriter.close();
                                            } catch (Throwable th6) {
                                                th4.addSuppressed(th6);
                                            }
                                            throw th5;
                                        }
                                    }
                                } catch (Throwable th7) {
                                    try {
                                        throw th7;
                                    } catch (Throwable th8) {
                                        if (outputStream != null) {
                                            try {
                                                outputStream.close();
                                            } catch (Throwable th9) {
                                                th7.addSuppressed(th9);
                                            }
                                        }
                                        throw th8;
                                    }
                                }
                            }
                            int responseCode = httpsURLConnection2.getResponseCode();
                            Log.d(AsyncTaskExecutor.TAG, responseCode + " Posted: " + str2);
                            if (responseCode != 200) {
                                Log.w(AsyncTaskExecutor.TAG, "Posted failed: " + str2);
                            }
                            if (httpsURLConnection2 != null) {
                                httpsURLConnection2.disconnect();
                            }
                        } catch (IOException e) {
                            e = e;
                            httpsURLConnection = httpsURLConnection2;
                            Log.e(AsyncTaskExecutor.TAG, e, "Posted exception for: " + str2);
                            if (httpsURLConnection != null) {
                                httpsURLConnection.disconnect();
                            }
                        } catch (Throwable th10) {
                            th = th10;
                            httpsURLConnection = httpsURLConnection2;
                            if (httpsURLConnection != null) {
                                httpsURLConnection.disconnect();
                            }
                            throw th;
                        }
                    } catch (IOException e2) {
                        e = e2;
                    }
                } catch (Throwable th11) {
                    th = th11;
                }
            }
        }.executeAsync(str);
    }

    public static void trackURL(String str) {
        if (str == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        trackUrls(arrayList);
    }

    public static void trackUrls(ArrayList<String> arrayList) {
        if (arrayList == null) {
            return;
        }
        Preconditions.checkNotNull(arrayList);
        new TrackUrTask().executeAsync((String[]) arrayList.toArray(new String[0]));
    }

    public static void trackInternalUrls(ArrayList<String> arrayList, HashMap<String, String> map) {
        if (arrayList == null) {
            return;
        }
        Preconditions.checkNotNull(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            Uri.Builder builderBuildUpon = Uri.parse(arrayList.get(i)).buildUpon();
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    builderBuildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
                }
            }
            arrayList.set(i, builderBuildUpon.toString());
        }
        new TrackUrTask().executeAsync((String[]) arrayList.toArray(new String[0]));
    }

    private static class TrackUrTask extends AsyncTaskExecutor<String> {
        private TrackUrTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.playon.bridge.common.AsyncTaskExecutor
        public void doInBackground(String... strArr) throws Throwable {
            for (String str : strArr) {
                trackUrlBackgroundThread(str);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1 */
        /* JADX WARN: Type inference failed for: r3v11, types: [int] */
        /* JADX WARN: Type inference failed for: r3v12 */
        /* JADX WARN: Type inference failed for: r3v2, types: [javax.net.ssl.HttpsURLConnection] */
        /* JADX WARN: Type inference failed for: r3v3, types: [javax.net.ssl.HttpsURLConnection] */
        /* JADX WARN: Type inference failed for: r3v4 */
        /* JADX WARN: Type inference failed for: r3v6 */
        /* JADX WARN: Type inference failed for: r3v7 */
        /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.StringBuilder] */
        /* JADX WARN: Type inference failed for: r5v7, types: [java.lang.StringBuilder] */
        private void trackUrlBackgroundThread(String str) throws Throwable {
            Preconditions.checkNotNull(str);
            ?? responseCode = 0;
            responseCode = 0;
            try {
                try {
                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
                    try {
                        httpsURLConnection.setReadTimeout(10000);
                        httpsURLConnection.setConnectTimeout(15000);
                        httpsURLConnection.setRequestMethod("GET");
                        httpsURLConnection.setDoInput(true);
                        httpsURLConnection.connect();
                        responseCode = httpsURLConnection.getResponseCode();
                        Log.d(AsyncTaskExecutor.TAG, responseCode + " Tracking: " + str);
                        if (responseCode != 200) {
                            Log.w(AsyncTaskExecutor.TAG, "Tracking failed: " + responseCode);
                        }
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                    } catch (IOException e) {
                        e = e;
                        responseCode = httpsURLConnection;
                        Log.e(AsyncTaskExecutor.TAG, e, "Tracking exception for: " + str);
                        if (responseCode != 0) {
                            responseCode.disconnect();
                        }
                    } catch (Throwable th) {
                        th = th;
                        responseCode = httpsURLConnection;
                        if (responseCode != 0) {
                            responseCode.disconnect();
                        }
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }
}
