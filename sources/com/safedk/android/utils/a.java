package com.safedk.android.utils;

import com.safedk.android.analytics.brandsafety.creatives.AdNetworkConfiguration;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes11.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f8154a = "ConfigurationHelper";
    public static final Set<String> b = new HashSet(Arrays.asList("CONTENTCAT", "PLAYBACKMETHODS", "STOREID", "STOREURL", "CACHEBUSTING", "TIMESTAMP", "ADCATEGORIES", "ADCOUNT", "ADTYPE", "BLOCKEDADCATEGORIES", "BREAKMAXADLENGTH", "BREAKMAXADS", "BREAKMAXDURATION", "BREAKMINADLENGTH", "BREAKPOSITION", "CONTENTPLAYHEAD", "MEDIAPLAYHEAD", "PLACEMENTTYPE", "TRANSACTIONID", "UNIVERSALADID", "CLIENTUA", "DEVICEIP", "DEVICEUA", "IFA", "IFATYPE", "LATLONG", "SERVERSIDE", "SERVERUA", "APPBUNDLE", "DOMAIN", "PAGEURL", "APIFRAMEWORKS", "CLICKTYPE", "EXTENSIONS", "MEDIAMIME", "OMIDPARTNER", "PLAYERCAPABILITIES", "VASTVERSIONS", "VERIFICATIONVENDORS", "ADPLAYHEAD", "ADSERVINGID", "ASvastMacroQueryParams.RI", "CONTENTID", "CONTENTURI", "INVENTORYSTATE", "PLAYERSIZE", "PLAYERSTATE", "PODSEQUENCE", "CLICKPOS", "ERRORCODE", "REASON", "GDPRCONSENT", "LIMITADTRACKING", "REGULATIONS"));

    public static boolean a(String str) {
        boolean z = false;
        com.safedk.android.analytics.brandsafety.creatives.b bVarJ = CreativeInfoManager.j(str);
        if (bVarJ == null) {
            Logger.d(f8154a, "cannot determine config item SUPPORTS_BANNER_IMPRESSION_TRACKING for sdk " + str);
        }
        if (bVarJ != null && bVarJ.b(AdNetworkConfiguration.SUPPORTS_BANNER_IMPRESSION_TRACKING)) {
            z = true;
        }
        Logger.d(f8154a, "isBannerMonitoringSupported returned " + z + " for sdk " + str);
        return z;
    }
}
