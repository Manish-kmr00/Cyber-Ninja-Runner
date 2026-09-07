package net.pubnative.lite.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.pubnative.lite.sdk.HyBidError;
import net.pubnative.lite.sdk.HyBidErrorCode;
import net.pubnative.lite.sdk.analytics.Reporting;
import net.pubnative.lite.sdk.models.AdRequest;
import net.pubnative.lite.sdk.models.AdResponse;
import net.pubnative.lite.sdk.models.PNAdRequest;
import net.pubnative.lite.sdk.network.PNHttpClient;
import net.pubnative.lite.sdk.utils.AdRequestRegistry;
import net.pubnative.lite.sdk.utils.PNApiUrlComposer;
import net.pubnative.lite.sdk.utils.json.JsonOperations;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class PNApiClient implements ApiClient {
    private static final String TAG = "PNApiClient";
    private String mApiUrl = "https://api.pubnative.net/";
    private final Context mContext;
    private JSONObject mPlacementParams;

    @Override // net.pubnative.lite.sdk.api.ApiClient
    public void setCustomUrl(String str) {
    }

    @Override // net.pubnative.lite.sdk.api.ApiClient
    public String getApiUrl() {
        return this.mApiUrl;
    }

    @Override // net.pubnative.lite.sdk.api.ApiClient
    public void setApiUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mApiUrl = str;
    }

    public PNApiClient(Context context) {
        this.mContext = context;
    }

    @Override // net.pubnative.lite.sdk.api.ApiClient
    public void getAd(AdRequest adRequest, String str, ApiClient.AdRequestListener adRequestListener) {
        getAd(getAdRequestURL(adRequest), str, adRequestListener);
    }

    @Override // net.pubnative.lite.sdk.api.ApiClient
    public void getAd(final String str, String str2, final ApiClient.AdRequestListener adRequestListener) {
        this.mPlacementParams = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            if (adRequestListener != null) {
                adRequestListener.onFailure(new HyBidError(HyBidErrorCode.INVALID_URL));
            }
        } else {
            final long jCurrentTimeMillis = System.currentTimeMillis();
            HashMap map = new HashMap();
            if (!TextUtils.isEmpty(str2)) {
                map.put("User-Agent", str2);
            }
            PNHttpClient.makeRequest(this.mContext, str, map, null, new PNHttpClient.Listener() { // from class: net.pubnative.lite.sdk.api.PNApiClient.1
                @Override // net.pubnative.lite.sdk.network.PNHttpClient.Listener
                public void onSuccess(String str3, Map<String, List<String>> map2) {
                    PNApiClient.this.registerAdRequest(str, str3, jCurrentTimeMillis);
                    PNApiClient.this.processStream(str3, adRequestListener);
                }

                @Override // net.pubnative.lite.sdk.network.PNHttpClient.Listener
                public void onFailure(Throwable th) {
                    PNApiClient.this.registerAdRequest(str, th.getMessage(), jCurrentTimeMillis);
                    if (adRequestListener != null) {
                        Log.d(PNApiClient.TAG, HyBidErrorCode.SERVER_ERROR_PREFIX.getMessage() + th.getMessage());
                        adRequestListener.onFailure(new HyBidError(HyBidErrorCode.SERVER_ERROR_PREFIX, th));
                    }
                }
            });
        }
    }

    @Override // net.pubnative.lite.sdk.api.ApiClient
    public Context getContext() {
        return this.mContext;
    }

    @Override // net.pubnative.lite.sdk.api.ApiClient
    public void trackUrl(String str, String str2, String str3, ApiClient.TrackUrlListener trackUrlListener) {
        sendTrackingRequest(str, str2, str3, trackUrlListener);
    }

    private void sendTrackingRequest(String str, String str2, final String str3, final ApiClient.TrackUrlListener trackUrlListener) {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            map.put("User-Agent", str2);
        }
        PNHttpClient.makeRequest(this.mContext, str, map, null, false, true, new PNHttpClient.Listener() { // from class: net.pubnative.lite.sdk.api.PNApiClient.2
            @Override // net.pubnative.lite.sdk.network.PNHttpClient.Listener
            public void onSuccess(String str4, Map<String, List<String>> map2) {
                ApiClient.TrackUrlListener trackUrlListener2 = trackUrlListener;
                if (trackUrlListener2 != null) {
                    trackUrlListener2.onSuccess();
                }
            }

            @Override // net.pubnative.lite.sdk.network.PNHttpClient.Listener
            public void onFailure(Throwable th) {
                ApiClient.TrackUrlListener trackUrlListener2 = trackUrlListener;
                if (trackUrlListener2 != null) {
                    trackUrlListener2.onFailure(new HyBidError(HyBidErrorCode.ERROR_TRACKING_URL, th));
                }
            }

            @Override // net.pubnative.lite.sdk.network.PNHttpClient.Listener
            public void onFinally(String str4, int i) {
                trackUrlListener.onFinally(str4, str3, i);
            }
        });
    }

    @Override // net.pubnative.lite.sdk.api.ApiClient
    public void trackJS(String str, ApiClient.TrackJSListener trackJSListener) {
        if (TextUtils.isEmpty(str)) {
            if (trackJSListener != null) {
                trackJSListener.onFailure(new HyBidError(HyBidErrorCode.ERROR_TRACKING_JS, "Empty JS tracking beacon"));
                return;
            }
            return;
        }
        try {
            WebView webView = new WebView(this.mContext);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.evaluateJavascript(processJS(str), null);
            if (trackJSListener != null) {
                trackJSListener.onSuccess(str);
            }
        } catch (RuntimeException unused) {
            if (trackJSListener != null) {
                trackJSListener.onFailure(new HyBidError(HyBidErrorCode.ERROR_TRACKING_JS, "Error tracking JS beacon. No webview to evaluate JS."));
            }
        }
    }

    private String processJS(String str) {
        return str.replace("<script>", "").replace("</script>", "");
    }

    protected String getAdRequestURL(AdRequest adRequest) {
        return PNApiUrlComposer.buildUrl(this.mApiUrl, (PNAdRequest) adRequest);
    }

    @Override // net.pubnative.lite.sdk.api.ApiClient
    public void processStream(String str, ApiClient.AdRequestListener adRequestListener) {
        AdResponse adResponse = null;
        try {
            AdResponse adResponse2 = new AdResponse(new JSONObject(str));
            e = null;
            adResponse = adResponse2;
        } catch (Error e) {
            e = new HyBidError(HyBidErrorCode.PARSER_ERROR, e);
        } catch (Exception e2) {
            e = e2;
        }
        processStream(adResponse, e, adRequestListener);
    }

    @Override // net.pubnative.lite.sdk.api.ApiClient
    public void processStream(String str, AdRequest adRequest, Integer num, Integer num2, ApiClient.AdRequestListener adRequestListener) {
        processStream(str, adRequestListener);
    }

    @Override // net.pubnative.lite.sdk.api.ApiClient
    public void processStream(AdResponse adResponse, Exception exc, ApiClient.AdRequestListener adRequestListener) {
        if (exc != null) {
            adRequestListener.onFailure(new HyBidError(HyBidErrorCode.PARSER_ERROR, exc));
            return;
        }
        if (adResponse == null) {
            adRequestListener.onFailure(new HyBidError(HyBidErrorCode.PARSER_ERROR));
            return;
        }
        if ("ok".equals(adResponse.status)) {
            if (adResponse.ads != null && !adResponse.ads.isEmpty()) {
                adRequestListener.onSuccess(adResponse.ads.get(0));
                return;
            } else {
                adRequestListener.onFailure(new HyBidError(HyBidErrorCode.NO_FILL));
                return;
            }
        }
        Log.d(TAG, HyBidErrorCode.SERVER_ERROR_PREFIX.getMessage() + adResponse.error_message);
        adRequestListener.onFailure(new HyBidError(HyBidErrorCode.SERVER_ERROR_PREFIX, new Exception(adResponse.error_message)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerAdRequest(String str, String str2, long j) {
        long jCurrentTimeMillis = System.currentTimeMillis() - j;
        JsonOperations.putJsonString(this.mPlacementParams, Reporting.Key.AD_REQUEST, str);
        JsonOperations.putJsonString(this.mPlacementParams, Reporting.Key.AD_RESPONSE, str2);
        JsonOperations.putJsonLong(this.mPlacementParams, Reporting.Key.RESPONSE_TIME, jCurrentTimeMillis);
        AdRequestRegistry.getInstance().setLastAdRequest(str, str2, jCurrentTimeMillis);
    }

    @Override // net.pubnative.lite.sdk.api.ApiClient
    public JSONObject getPlacementParams() {
        return this.mPlacementParams;
    }
}
