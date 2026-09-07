package com.pubmatic.sdk.common.cache;

import android.content.Context;
import android.webkit.WebSettings;
import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import com.pubmatic.sdk.common.OpenWrapSDKConfig;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.pubmatic.sdk.common.POBCrashAnalysing;
import com.pubmatic.sdk.common.POBError;
import com.pubmatic.sdk.common.POBInstanceProvider;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.log.POBLogConstants;
import com.pubmatic.sdk.common.models.POBProfileInfo;
import com.pubmatic.sdk.common.network.POBHttpRequest;
import com.pubmatic.sdk.common.network.POBMultipleRequestsHandler;
import com.pubmatic.sdk.common.network.POBNetworkHandler;
import com.pubmatic.sdk.common.network.POBNetworkMonitor;
import com.pubmatic.sdk.common.network.POBResponse;
import com.pubmatic.sdk.common.taskhandler.POBTaskHandler;
import com.pubmatic.sdk.common.utility.POBUtils;
import com.pubmatic.sdk.common.viewability.POBMeasurementProvider;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class POBCacheManager {
    private final Context b;
    private final POBNetworkHandler c;
    private volatile String g;
    private String h;
    private String i;
    private boolean n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7567a = "POBCacheManager";
    private final Object j = new Object();
    private final Object k = new Object();
    private final Queue l = new ArrayDeque(3);
    private final Queue m = new ArrayDeque(3);
    private final AtomicBoolean o = new AtomicBoolean();
    private final Map d = Collections.synchronizedMap(new HashMap());
    private final Set e = Collections.synchronizedSet(new HashSet());
    private final AtomicReference f = new AtomicReference(null);

    public interface ProfileResultListener {
        void onProfileResult(boolean z);
    }

    public interface UserAgentListener {
        void onUserAgentReceived(String str);
    }

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (POBCacheManager.this.g != null) {
                return;
            }
            synchronized (POBCacheManager.this.k) {
                POBCacheManager pOBCacheManager = POBCacheManager.this;
                pOBCacheManager.g = POBUtils.readFromAssets(pOBCacheManager.b, POBCommonConstants.POB_MRAID_JS);
            }
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ UserAgentListener f7569a;

        b(UserAgentListener userAgentListener) {
            this.f7569a = userAgentListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (POBCacheManager.this.j) {
                POBCacheManager pOBCacheManager = POBCacheManager.this;
                pOBCacheManager.i = pOBCacheManager.fetchUserAgent();
                this.f7569a.onUserAgentReceived(POBCacheManager.this.i);
            }
        }
    }

    class c implements POBNetworkHandler.POBNetworkListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ProfileResultListener f7570a;

        c(ProfileResultListener profileResultListener) {
            this.f7570a = profileResultListener;
        }

        @Override // com.pubmatic.sdk.common.network.POBNetworkHandler.POBNetworkListener
        public void onFailure(POBError pOBError) {
        }

        @Override // com.pubmatic.sdk.common.network.POBNetworkHandler.POBNetworkListener
        public void onSuccess(Map map) {
            if (map == null || map.isEmpty()) {
                POBLog.error("POBCacheManager", "Failed to fetch profile info from CDN. Empty response.", new Object[0]);
            } else {
                POBCacheManager.this.a(map, this.f7570a);
            }
        }
    }

    public POBCacheManager(Context context, POBNetworkHandler pOBNetworkHandler) {
        this.b = context.getApplicationContext();
        this.c = pOBNetworkHandler;
    }

    public void fetchProfileConfigs(final Context context, OpenWrapSDKConfig openWrapSDKConfig) {
        a(openWrapSDKConfig.getPublisherId(), new HashSet(openWrapSDKConfig.getProfileIds()), !POBUtils.isDebugBuild(context) ? new ProfileResultListener() { // from class: com.pubmatic.sdk.common.cache.POBCacheManager$$ExternalSyntheticLambda0
            @Override // com.pubmatic.sdk.common.cache.POBCacheManager.ProfileResultListener
            public final void onProfileResult(boolean z) {
                this.f$0.a(context, z);
            }
        } : null);
    }

    public String fetchUserAgent() {
        String str = this.i;
        if (str != null) {
            return str;
        }
        try {
            return WebSettings.getDefaultUserAgent(this.b);
        } catch (Exception e) {
            POBLog.error("POBCacheManager", "Failed to retrieve user agent from web view, %s", e.getLocalizedMessage());
            try {
                String property = System.getProperty("http.agent");
                return property != null ? property : "";
            } catch (Exception e2) {
                POBLog.error("POBCacheManager", "Failed to retrieve user agent (using http.agent) from WebView, %s", e2.getLocalizedMessage());
                return "";
            }
        }
    }

    public void generateUserAgent(UserAgentListener userAgentListener) {
        String str = this.i;
        if (str != null) {
            userAgentListener.onUserAgentReceived(str);
        }
        POBTaskHandler.getInstance().runOnBackgroundThread(new b(userAgentListener));
    }

    public JSONArray getCachedBidResponses() {
        JSONArray jSONArray = new JSONArray();
        Iterator it = this.m.iterator();
        while (it.hasNext()) {
            jSONArray.put((JSONObject) it.next());
        }
        Iterator it2 = this.l.iterator();
        while (it2.hasNext()) {
            jSONArray.put((JSONObject) it2.next());
        }
        return jSONArray;
    }

    public String getMraidJs() {
        if (this.g == null) {
            this.g = POBUtils.readFromAssets(this.b, POBCommonConstants.POB_MRAID_JS);
        }
        return this.g;
    }

    public POBProfileInfo getProfileInfo(String str) {
        return (POBProfileInfo) this.d.get(str);
    }

    public String getPublisherId() {
        return this.h;
    }

    public String getUserAgent() {
        String str = this.i;
        return str == null ? "" : str;
    }

    public void loadInternalServiceJS(POBMeasurementProvider.POBScriptListener pOBScriptListener) {
        String str = (String) this.f.get();
        if (str != null) {
            pOBScriptListener.onMeasurementScriptReceived(str);
        } else {
            c(pOBScriptListener);
        }
    }

    public void loadMraidJs() {
        if (this.g != null) {
            return;
        }
        POBTaskHandler.getInstance().runOnBackgroundThread(new a());
    }

    public void saveReceivedBid(JSONObject jSONObject) {
        if (this.l.size() == 3) {
            this.l.remove();
        }
        this.l.add(jSONObject);
    }

    public void saveRenderedBid(JSONObject jSONObject) {
        this.l.remove(jSONObject);
        if (this.m.size() == 3) {
            this.m.remove();
        }
        this.m.add(jSONObject);
    }

    public boolean verifyCrashAnalyticsStatus() {
        Iterator it = this.d.values().iterator();
        while (it.hasNext()) {
            if (!((POBProfileInfo) it.next()).isCrashAnalyticsEnabled()) {
                return false;
            }
        }
        return true;
    }

    private void c(final POBMeasurementProvider.POBScriptListener pOBScriptListener) {
        POBTaskHandler.getInstance().runOnBackgroundThread(new Runnable() { // from class: com.pubmatic.sdk.common.cache.POBCacheManager$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(pOBScriptListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(final POBMeasurementProvider.POBScriptListener pOBScriptListener) {
        MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.f, null, POBUtils.readFromAssets(this.b, POBCommonConstants.INTERNAL_SERVICE_FILE_NAME));
        POBTaskHandler.getInstance().runOnMainThread(new Runnable() { // from class: com.pubmatic.sdk.common.cache.POBCacheManager$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(pOBScriptListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(POBMeasurementProvider.POBScriptListener pOBScriptListener) {
        String str = (String) this.f.get();
        if (str != null) {
            pOBScriptListener.onMeasurementScriptReceived(str);
        } else {
            pOBScriptListener.onFailedToReceiveMeasurementScript(1);
        }
    }

    private void b(Context context, boolean z) {
        POBCrashAnalysing crashAnalytics = POBInstanceProvider.getCrashAnalytics();
        if (crashAnalytics == null) {
            POBLog.debug("POBCacheManager", POBLogConstants.CRASHANALYTICS_NOT_INITIALISED, new Object[0]);
            return;
        }
        boolean z2 = this.n;
        if (!z2 && z) {
            this.n = true;
            crashAnalytics.initialize(context);
        } else if (z2 && !z) {
            this.n = false;
            crashAnalytics.invalidate();
        }
        POBLog.debug("POBCacheManager", POBLogConstants.CRASHANALYTICS_ENABLED + this.n, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Context context, boolean z) {
        if (z) {
            b(context, verifyCrashAnalyticsStatus());
        }
    }

    private void a(String str, Set set, ProfileResultListener profileResultListener) {
        this.h = str;
        this.o.set(false);
        ArrayList arrayList = new ArrayList();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            int iIntValue = ((Integer) it.next()).intValue();
            String strValueOf = String.valueOf(iIntValue);
            if (!this.e.contains(strValueOf)) {
                POBProfileInfo pOBProfileInfo = (POBProfileInfo) this.d.get(strValueOf);
                if (pOBProfileInfo != null && !pOBProfileInfo.isProfileInfoExpired()) {
                    POBLog.debug("POBCacheManager", POBLogConstants.PROFILE_INFO_ALREADY_AVAILABLE, strValueOf);
                } else if (!POBNetworkMonitor.isNetworkAvailable(this.b)) {
                    a(new POBError(1003, "No network available"), strValueOf);
                } else {
                    String strA = a(str, iIntValue);
                    POBHttpRequest pOBHttpRequest = new POBHttpRequest();
                    pOBHttpRequest.setUrl(strA);
                    pOBHttpRequest.setRequestTag(strValueOf);
                    POBLog.debug("POBCacheManager", "Requesting profile config with url - : %s", strA);
                    pOBHttpRequest.setTimeout(1000);
                    this.e.add(strValueOf);
                    arrayList.add(pOBHttpRequest);
                }
            }
        }
        new POBMultipleRequestsHandler(this.c).sendRequests(arrayList, new c(profileResultListener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map map, ProfileResultListener profileResultListener) {
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            POBResponse pOBResponse = (POBResponse) entry.getValue();
            if (pOBResponse instanceof POBResponse.Success) {
                POBLog.debug("POBCacheManager", POBLogConstants.PROFILE_CONFIG_FETCH_SUCCESSFUL, str, pOBResponse);
                try {
                    this.d.put(str, POBProfileInfo.build(new JSONObject(((POBResponse.Success) pOBResponse).getResponse())));
                    this.e.remove(str);
                    this.o.set(true);
                } catch (JSONException e) {
                    a(new POBError(1007, e.getMessage() != null ? e.getMessage() : "Error while parsing profile info."), str);
                }
            } else if (pOBResponse instanceof POBResponse.Error) {
                a(((POBResponse.Error) pOBResponse).getError(), str);
            }
        }
        if (profileResultListener != null) {
            profileResultListener.onProfileResult(this.o.get());
        }
    }

    private void a(POBError pOBError, String str) {
        POBLog.error("POBCacheManager", POBLogConstants.PROFILE_CONFIG_FETCH_FAILED, str, pOBError.getErrorMessage());
        if (pOBError.getErrorCode() != 1003) {
            this.d.put(str, new POBProfileInfo());
            this.o.set(true);
        }
        this.e.remove(str);
    }

    private String a(String str, int i) {
        return String.format(Locale.ENGLISH, "https://ads.pubmatic.com/AdServer/js/pwt/%s/%d/config.json", str, Integer.valueOf(i));
    }
}
