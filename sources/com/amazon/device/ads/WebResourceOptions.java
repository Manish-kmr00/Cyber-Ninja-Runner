package com.amazon.device.ads;

import com.google.firebase.sessions.settings.RemoteSettings;
import com.pubmatic.sdk.common.POBCommonConstants;

/* JADX INFO: loaded from: classes7.dex */
public class WebResourceOptions {
    private static String cdnHost;
    private static String[] jsNames = {"aps-mraid.js", "dtb-m.js", POBCommonConstants.INTERNAL_SERVICE_FILE_NAME};
    private static boolean useLocalOnly;

    static void setCDNHost(String str) {
        if (str.equals(cdnHost)) {
            return;
        }
        cdnHost = str;
        DtbSharedPreferences.getInstance().resetWebResoucesLastPing();
        WebResourceService.getInstance().deleteWebDirContent();
    }

    static String getCDNHost(String str) {
        String str2 = cdnHost;
        if (str2 == null) {
            str2 = DtbConstants.DTB_WEB_RESOURCES;
        }
        if (POBCommonConstants.INTERNAL_SERVICE_FILE_NAME.equals(str)) {
            str2 = "video-player.aps.amazon-adsystem.com/static/omsdk/" + DtbConstants.INTEGRATED_OM_VERSION;
        }
        return !str2.endsWith(RemoteSettings.FORWARD_SLASH_STRING) ? str2 + RemoteSettings.FORWARD_SLASH_STRING : str2;
    }

    static void setCDNResources(String[] strArr) {
        jsNames = strArr;
    }

    static String[] getCDNResources() {
        return jsNames;
    }

    static void setLocalSourcesOnly(boolean z) {
        useLocalOnly = z;
    }

    public static boolean isLocalSourcesOnly() {
        return useLocalOnly;
    }
}
