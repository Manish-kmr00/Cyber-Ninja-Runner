package com.playon.bridge;

import android.os.Bundle;
import com.facebook.internal.AnalyticsEvents;
import com.playon.bridge.common.AsyncTaskExecutor;
import com.playon.bridge.common.Log;
import com.playon.bridge.common.util.Assert;
import java.io.FileNotFoundException;
import java.net.URL;
import java.net.UnknownHostException;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: classes10.dex */
public final class AdLoader {
    public static final int ERROR_NETWORK_NOT_AVAILABLE = 8054;
    public static final int ERROR_NO_INVENTORY = 8004;
    public static final int ERROR_UNKNOWN = 8003;
    public static final int ERROR_UNKNOWN_HOST = 8001;
    private final String TAG = Log.makeTag("AdLoader");
    private Bundle mAd;
    private String mAdRequest;
    private int mError;
    private AdLoaderListener mListener;
    private VastParsingTask mVastParsingTask;

    public interface AdLoaderListener {
        void onAdLoaded(AdLoader adLoader, Bundle bundle);

        void onAdLoadingError(AdLoader adLoader, int i);
    }

    public void load(String str) {
        cancel();
        if (str == null) {
            return;
        }
        this.mAd = null;
        this.mError = 0;
        this.mAdRequest = str;
        Log.d(this.TAG, "Loading ad request: " + str);
        VastParsingTask vastParsingTask = new VastParsingTask();
        this.mVastParsingTask = vastParsingTask;
        vastParsingTask.executeAsync(str);
    }

    public void cancel() {
        VastParsingTask vastParsingTask = this.mVastParsingTask;
        if (vastParsingTask != null) {
            vastParsingTask.cancel(true);
            this.mVastParsingTask = null;
        }
    }

    private Bundle getAd() {
        return this.mAd;
    }

    private int getError() {
        return this.mError;
    }

    public void setListener(AdLoaderListener adLoaderListener) {
        this.mListener = adLoaderListener;
    }

    public AdLoaderListener getListener() {
        return this.mListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdLoaded(Bundle bundle) {
        Log.d(this.TAG, "Ad request loaded: " + this.mAdRequest);
        this.mAd = bundle;
        AdLoaderListener adLoaderListener = this.mListener;
        if (adLoaderListener != null) {
            adLoaderListener.onAdLoaded(this, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(int i) {
        Log.w(this.TAG, "Error: " + debugErrorToStr(i));
        this.mError = i;
        AdLoaderListener adLoaderListener = this.mListener;
        if (adLoaderListener != null) {
            adLoaderListener.onAdLoadingError(this, i);
        }
    }

    public static String debugErrorToStr(int i) {
        if (i == 0) {
            return "No error";
        }
        if (i == 8001) {
            return "Unknown host";
        }
        if (i == 8054) {
            return "Network not available";
        }
        if (i == 8003) {
            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
        if (i == 8004) {
            return "No ad inventory";
        }
        Assert.failUnhandledValue(Log.makeTag("AdLoader"), i, "debugErrorToStr");
        return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }

    private class VastParsingTask extends AsyncTaskExecutor<String> {
        private Bundle ad;
        private volatile int mParseError;

        private VastParsingTask() {
            this.ad = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.playon.bridge.common.AsyncTaskExecutor
        public void doInBackground(String... strArr) throws Throwable {
            AdParser adParser = new AdParser();
            HttpsURLConnection httpsURLConnection = null;
            try {
                try {
                    if (strArr[0] != null) {
                        HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) new URL(strArr[0]).openConnection();
                        try {
                            httpsURLConnection2.setReadTimeout(10000);
                            httpsURLConnection2.setConnectTimeout(15000);
                            httpsURLConnection2.setRequestMethod("GET");
                            httpsURLConnection2.setDoInput(true);
                            httpsURLConnection2.connect();
                            int responseCode = httpsURLConnection2.getResponseCode();
                            Log.d(AsyncTaskExecutor.TAG, "Response:" + responseCode);
                            if (responseCode == 200) {
                                this.ad = adParser.parse(httpsURLConnection2.getInputStream());
                            }
                            httpsURLConnection = httpsURLConnection2;
                        } catch (FileNotFoundException e) {
                            e = e;
                            httpsURLConnection = httpsURLConnection2;
                            Log.w(AsyncTaskExecutor.TAG, e, "Download exception: " + strArr[0]);
                            this.mParseError = 8003;
                            if (httpsURLConnection == null) {
                                return;
                            }
                        } catch (UnknownHostException e2) {
                            e = e2;
                            httpsURLConnection = httpsURLConnection2;
                            Log.w(AsyncTaskExecutor.TAG, e, "Download exception");
                            this.mParseError = 8001;
                            if (httpsURLConnection == null) {
                                return;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            httpsURLConnection = httpsURLConnection2;
                            this.mParseError = 8003;
                            Log.e(AsyncTaskExecutor.TAG, e, "VAST parser exception: " + strArr[0]);
                            if (httpsURLConnection == null) {
                                return;
                            }
                        } catch (Throwable th) {
                            th = th;
                            httpsURLConnection = httpsURLConnection2;
                            if (httpsURLConnection != null) {
                                httpsURLConnection.disconnect();
                            }
                            throw th;
                        }
                    }
                    if (httpsURLConnection == null) {
                        return;
                    }
                } catch (FileNotFoundException e4) {
                    e = e4;
                } catch (UnknownHostException e5) {
                    e = e5;
                } catch (Exception e6) {
                    e = e6;
                }
                httpsURLConnection.disconnect();
            } catch (Throwable th2) {
                th = th2;
            }
        }

        @Override // com.playon.bridge.common.AsyncTaskExecutor
        protected void onPostExecute() {
            if (AdLoader.this.mVastParsingTask == this) {
                AdLoader.this.mVastParsingTask = null;
                if (this.mParseError != 0) {
                    AdLoader.this.onError(this.mParseError);
                    return;
                }
                Bundle bundle = this.ad;
                if (bundle == null || bundle.isEmpty() || this.ad.getString("url") == null) {
                    AdLoader.this.onError(8004);
                } else {
                    AdLoader.this.onAdLoaded(this.ad);
                }
            }
        }
    }
}
