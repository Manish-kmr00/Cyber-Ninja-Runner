package com.pubmatic.sdk.common.network;

import android.net.Uri;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.pubmatic.sdk.common.POBError;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.utility.POBUtils;
import com.pubmatic.sdk.common.view.POBWebView;
import com.safedk.android.internal.partials.PubMaticNetworkBridge;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class POBTrackerHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final POBNetworkHandler f7615a;

    class a implements POBNetworkHandler.POBNetworkListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f7616a;

        a(String str) {
            this.f7616a = str;
        }

        @Override // com.pubmatic.sdk.common.network.POBNetworkHandler.POBNetworkListener
        public void onFailure(POBError pOBError) {
            POBLog.error("PMTrackerHandler", "Failed to execute tracker url : " + this.f7616a, "\n Error : " + pOBError.getErrorMessage());
        }

        @Override // com.pubmatic.sdk.common.network.POBNetworkHandler.POBNetworkListener
        public void onSuccess(String str) {
            POBLog.debug("PMTrackerHandler", "Successfully executed tracker url : " + this.f7616a, new Object[0]);
        }
    }

    public POBTrackerHandler(POBNetworkHandler pOBNetworkHandler) {
        this.f7615a = pOBNetworkHandler;
    }

    public static List<String> sanitizeURLScheme(List<String> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                String strSanitizeURLScheme = sanitizeURLScheme(it.next(), z);
                if (strSanitizeURLScheme != null) {
                    arrayList.add(strSanitizeURLScheme);
                }
            }
        } else {
            POBLog.debug("PMTrackerHandler", "Unable to sanitize urls as list is null", new Object[0]);
        }
        return arrayList;
    }

    public void executeJsScripts(POBWebView pOBWebView, String str) {
        POBLog.debug("PMTrackerHandler", "Executing js tracker script: " + str, new Object[0]);
        pOBWebView.getSettings().setJavaScriptEnabled(true);
        PubMaticNetworkBridge.webviewLoadDataWithBaseURL(pOBWebView, null, str, POBCommonConstants.CONTENT_TYPE_HTML, StandardCharsets.UTF_8.name(), null);
    }

    public void handleTrackersForError(List<String> list, Map<Object, Object> map, Map<String, String> map2) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (String strBuildUriWithQueryParams : list) {
            Uri uri = Uri.parse(strBuildUriWithQueryParams);
            String host = uri.getHost();
            if (map2 != null && !map2.isEmpty() && host != null && host.contains(POBCommonConstants.PUBMATIC_IDENTIFIER_FOR_ERROR_TRACKER_URL)) {
                strBuildUriWithQueryParams = POBUtils.buildUriWithQueryParams(uri, map2);
            }
            sendTracker(strBuildUriWithQueryParams, map);
        }
    }

    public void sendTracker(String str) {
        if (POBUtils.isNullOrEmpty(str)) {
            POBLog.error("PMTrackerHandler", "Failed to execute tracker url: " + str, new Object[0]);
            return;
        }
        POBLog.debug("PMTrackerHandler", "Executing tracker for url: %s", str);
        POBHttpRequest pOBHttpRequest = new POBHttpRequest();
        pOBHttpRequest.setUrl(str);
        pOBHttpRequest.setRetryCount(3);
        pOBHttpRequest.setRequestMethod(POBHttpRequest.HTTP_METHOD.GET);
        pOBHttpRequest.setTimeout(10000);
        this.f7615a.sendRequest(pOBHttpRequest, new a(str));
    }

    public void sendTrackers(List<String> list) {
        if (list == null || list.isEmpty()) {
            POBLog.error("PMTrackerHandler", "Failed to execute tracker url: " + list, new Object[0]);
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            sendTracker(it.next());
        }
    }

    public void sendTrackers(List<String> list, Map<Object, Object> map) {
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            sendTracker(it.next(), map);
        }
    }

    public static String sanitizeURLScheme(String str, boolean z) {
        String str2;
        try {
            if (!POBUtils.isNullOrEmpty(str)) {
                Uri uri = Uri.parse(str);
                if (uri == null || uri.getScheme() != null) {
                    return str;
                }
                Uri.Builder builderBuildUpon = uri.buildUpon();
                if (z) {
                    str2 = "https";
                } else {
                    str2 = "http";
                }
                return builderBuildUpon.scheme(str2).build().toString();
            }
            POBLog.debug("PMTrackerHandler", "Unable to sanitize url - %s", str);
            return null;
        } catch (Exception e) {
            POBLog.debug("PMTrackerHandler", "Error occurred while sanitizing url %s. Reason - %s", str, e.getMessage());
        }
    }

    public void sendTracker(String str, Map<Object, Object> map) {
        if (!POBUtils.isNullOrEmpty(str)) {
            if (map != null && map.size() > 0) {
                for (Map.Entry<Object, Object> entry : map.entrySet()) {
                    str = str.replace(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
                }
            }
            sendTracker(str);
            return;
        }
        POBLog.error("PMTrackerHandler", "Empty tracker url.", new Object[0]);
    }

    public void sendTracker(String str, String str2, String str3) {
        if (!POBUtils.isNullOrEmpty(str)) {
            if (str2 != null && str3 != null) {
                str = str.replace(str2, str3);
            }
            sendTracker(str);
            return;
        }
        POBLog.error("PMTrackerHandler", "Unable to send tracker for url - %s.", str);
    }
}
