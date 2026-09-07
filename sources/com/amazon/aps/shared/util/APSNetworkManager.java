package com.amazon.aps.shared.util;

import android.content.Context;
import android.util.Log;
import com.amazon.aps.shared.APSAnalytics;
import com.amazon.aps.shared.ApsMetrics;
import com.amazon.aps.shared.analytics.APSEvent;
import com.amazon.aps.shared.analytics.APSEventSeverity;
import com.safedk.android.internal.partials.AmazonPublisherServicesNetworkBridge;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class APSNetworkManager {
    private static final String API_HEADER = "x-api-key";
    private static final int BUFFER_SIZE = 1024;
    private static final String CONTENT_TYPE_HEADER = "Content-Type";
    private static final String CONTENT_TYPE_VALUE = "application/json";
    private static final String HTTP_POST_METHOD = "POST";
    private static long SCHEDULE_INTERVAL = 10;
    private static final int SOCK_TIMEOUT = 10000;
    private static final String TAG = "APSNetworkManager";
    private static APSNetworkManager apsNetworkManager;
    private Context context;
    private final ExecutorService executor = Executors.newFixedThreadPool(2);
    private boolean shutdownInProgress = false;

    private APSNetworkManager(Context context) {
        this.context = context;
        Runtime.getRuntime().addShutdownHook(new Thread() { // from class: com.amazon.aps.shared.util.APSNetworkManager.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    APSNetworkManager.this.shutdownInProgress = true;
                    Log.d(APSNetworkManager.TAG, "App is shutting down, terminating the thread executor");
                    APSNetworkManager.this.executor.shutdown();
                } catch (RuntimeException e) {
                    Log.e(APSNetworkManager.TAG, "Error in stopping the executor", e);
                }
            }
        });
    }

    public static APSNetworkManager getInstance(Context context) {
        if (apsNetworkManager == null) {
            apsNetworkManager = new APSNetworkManager(context);
        }
        return apsNetworkManager;
    }

    public void sendRemoteLog(APSEvent aPSEvent) {
        if (aPSEvent.getEventSeverity() == APSEventSeverity.FATAL) {
            sendData(APSAnalytics.getHttpUrl(), APSAnalytics.getApiKey(), aPSEvent.toJsonPayload());
        }
    }

    public void sendMetrics(JSONObject jSONObject) {
        if (jSONObject != null) {
            sendData(ApsMetrics.INSTANCE.getEndpointUrl(), ApsMetrics.INSTANCE.getApiKey(), jSONObject.toString());
        }
    }

    private synchronized void execute(Runnable runnable) {
        try {
            if (!this.shutdownInProgress) {
                this.executor.execute(runnable);
            }
        } catch (InternalError e) {
            Log.e(TAG, "Internal error in executing the thread", e);
            handleError(e);
        } catch (RuntimeException e2) {
            Log.e(TAG, "Error running the thread", e2);
        }
    }

    private void handleError(InternalError internalError) {
        if (internalError.getLocalizedMessage().contains("shutdown")) {
            Log.e(TAG, "Got the shutdown signal", internalError);
        }
    }

    private boolean setConfigsInConnection(HttpsURLConnection httpsURLConnection, String str) {
        try {
            httpsURLConnection.setReadTimeout(10000);
            httpsURLConnection.setConnectTimeout(10000);
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setChunkedStreamingMode(0);
            httpsURLConnection.setRequestMethod("POST");
            httpsURLConnection.setRequestProperty("Content-Type", "application/json");
            httpsURLConnection.setRequestProperty(API_HEADER, str);
            httpsURLConnection.connect();
            return true;
        } catch (IOException e) {
            Log.e(TAG, "Error in setting the connection parameter:", e);
            return false;
        }
    }

    private void closeStreamsAndConnection(InputStream inputStream, OutputStream outputStream, HttpsURLConnection httpsURLConnection) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException | RuntimeException e) {
                Log.e(TAG, "Unable to close the out stream", e);
            }
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException | RuntimeException e2) {
                Log.e(TAG, "Unable to close the in stream", e2);
            }
        }
        try {
            AmazonPublisherServicesNetworkBridge.httpUrlConnectionDisconnect(httpsURLConnection);
        } catch (RuntimeException e3) {
            Log.e(TAG, "Unable to close the url connection", e3);
        }
    }

    private void sendData(final String str, final String str2, final String str3) {
        execute(new Runnable() { // from class: com.amazon.aps.shared.util.APSNetworkManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f$0.m4377lambda$sendData$0$comamazonapssharedutilAPSNetworkManager(str, str2, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v7, types: [java.net.HttpURLConnection, java.net.URLConnection, javax.net.ssl.HttpsURLConnection] */
    /* JADX INFO: renamed from: sendDataAsync, reason: merged with bridge method [inline-methods] */
    public boolean m4377lambda$sendData$0$comamazonapssharedutilAPSNetworkManager(String str, String str2, String str3) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                str = (HttpsURLConnection) new URL(str).openConnection();
                try {
                    if (setConfigsInConnection(str, str2)) {
                        bufferedOutputStream = new BufferedOutputStream(AmazonPublisherServicesNetworkBridge.urlConnectionGetOutputStream(str));
                        try {
                            bufferedOutputStream.write(str3.getBytes());
                            bufferedOutputStream.flush();
                            String str4 = TAG;
                            Log.d(str4, "Sending the event data: " + str3);
                            int iHttpUrlConnectionGetResponseCode = AmazonPublisherServicesNetworkBridge.httpUrlConnectionGetResponseCode(str);
                            Log.d(str4, "Response code received : " + iHttpUrlConnectionGetResponseCode);
                            if (iHttpUrlConnectionGetResponseCode == 200) {
                                byte[] bArr = new byte[1024];
                                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(AmazonPublisherServicesNetworkBridge.urlConnectionGetInputStream(str));
                                try {
                                    bufferedInputStream2.read(bArr);
                                    Log.d(str4, "Response received: ".concat(new String(bArr)));
                                    closeStreamsAndConnection(bufferedInputStream2, bufferedOutputStream, str);
                                    return true;
                                } catch (IOException e) {
                                    e = e;
                                    bufferedInputStream = bufferedInputStream2;
                                    Log.e(TAG, "Error in sendData: ", e);
                                    closeStreamsAndConnection(bufferedInputStream, bufferedOutputStream, str);
                                    return false;
                                } catch (RuntimeException e2) {
                                    e = e2;
                                    bufferedInputStream = bufferedInputStream2;
                                    Log.e(TAG, "Error in sendData: ", e);
                                    closeStreamsAndConnection(bufferedInputStream, bufferedOutputStream, str);
                                    return false;
                                } catch (Throwable th) {
                                    th = th;
                                    bufferedInputStream = bufferedInputStream2;
                                    closeStreamsAndConnection(bufferedInputStream, bufferedOutputStream, str);
                                    throw th;
                                }
                            }
                        } catch (IOException e3) {
                            e = e3;
                        } catch (RuntimeException e4) {
                            e = e4;
                        }
                    } else {
                        bufferedOutputStream = null;
                    }
                    closeStreamsAndConnection(null, bufferedOutputStream, str);
                    return false;
                } catch (IOException e5) {
                    e = e5;
                    bufferedOutputStream = null;
                    Log.e(TAG, "Error in sendData: ", e);
                    closeStreamsAndConnection(bufferedInputStream, bufferedOutputStream, str);
                    return false;
                } catch (RuntimeException e6) {
                    e = e6;
                    bufferedOutputStream = null;
                    Log.e(TAG, "Error in sendData: ", e);
                    closeStreamsAndConnection(bufferedInputStream, bufferedOutputStream, str);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream = null;
                }
            } catch (IOException e7) {
                e = e7;
                str = 0;
                bufferedOutputStream = null;
                Log.e(TAG, "Error in sendData: ", e);
                closeStreamsAndConnection(bufferedInputStream, bufferedOutputStream, str);
                return false;
            } catch (RuntimeException e8) {
                e = e8;
                str = 0;
                bufferedOutputStream = null;
                Log.e(TAG, "Error in sendData: ", e);
                closeStreamsAndConnection(bufferedInputStream, bufferedOutputStream, str);
                return false;
            } catch (Throwable th3) {
                th = th3;
                str = 0;
                bufferedOutputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }
}
