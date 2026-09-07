package com.safedk.android.utils;

import android.os.Bundle;
import com.google.android.gms.ads.MobileAds;
import com.mbridge.msdk.out.MBConfiguration;
import com.safedk.android.SafeDK;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import io.bidmachine.BidMachine;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public class SdksMapping {
    public static final String KEY_INSTALLED_MEDIATION_ADAPTERS = "installed_mediation_adapters";
    public static final String KEY_INSTALLED_MEDIATION_ADAPTERS_CLASS = "class";
    public static final String KEY_INSTALLED_MEDIATION_ADAPTERS_SDK_VERSION = "sdk_version";
    private static final String TAG = "SdksMapping";
    private static Set<String> redirectSupportedSdks;
    private static boolean topicSdkVersionsUpdated;
    private static TreeMap<String, String> sdkPackageToName = new TreeMap<>(Collections.reverseOrder());
    private static TreeMap<String, String> sdkPackageToUUID = new TreeMap<>(Collections.reverseOrder());
    private static TreeMap<String, String> sdkPackages = new TreeMap<>(Collections.reverseOrder());
    public static TreeMap<String, String> sdkPackageUUIDToVersion = new TreeMap<>(Collections.reverseOrder());
    private static TreeMap<String, String> sdkAdaptersUUID = new TreeMap<>(Collections.reverseOrder());

    static {
        sdkPackageToName.put("io.presage", "Ogury");
        sdkPackages.put(h.t, "io.presage");
        sdkPackageToUUID.put("io.presage", "bc4f405872168091578ff3b1b238ac9d");
        sdkPackages.put("io.presage", "io.presage");
        sdkAdaptersUUID.put("com.applovin.mediation.adapters.OguryPresageMediationAdapter", "bc4f405872168091578ff3b1b238ac9d");
        sdkPackageToName.put("io.bidmachine", BidMachine.NAME);
        sdkPackages.put("com.explorestack", "io.bidmachine");
        sdkPackageToUUID.put("io.bidmachine", "b15e56a960628ffab498ee9fff6d7c1d");
        sdkPackages.put("io.bidmachine", "io.bidmachine");
        sdkAdaptersUUID.put("com.applovin.mediation.adapters.BidMachineMediationAdapter", "b15e56a960628ffab498ee9fff6d7c1d");
        sdkPackageToName.put(h.y, "Yandex");
        sdkPackageToUUID.put(h.y, "3e33901c9e3dbb997f2acd3343628f45");
        sdkPackages.put(h.y, h.y);
        sdkAdaptersUUID.put("com.applovin.mediation.adapters.YandexMediationAdapter", "3e33901c9e3dbb997f2acd3343628f45");
        sdkPackageToName.put(h.d, "LiftoffMonetize");
        sdkPackageToUUID.put(h.d, "217e8f437c9fc4244d6e74653ac8a8c7");
        sdkPackages.put(h.d, h.d);
        sdkAdaptersUUID.put("com.applovin.mediation.adapters.VungleMediationAdapter", "217e8f437c9fc4244d6e74653ac8a8c7");
        sdkPackageToName.put(h.C, "Verve");
        sdkPackages.put("net.pubnative", h.C);
        sdkPackageToUUID.put(h.C, "9d2482ebc91b768376ff604812009a27");
        sdkPackages.put(h.C, h.C);
        sdkAdaptersUUID.put("com.applovin.mediation.adapters.VerveMediationAdapter", "9d2482ebc91b768376ff604812009a27");
        sdkPackageToName.put("com.unity3d.ads", "UnityAds");
        sdkPackages.put("com.unity3d.services.banners", "com.unity3d.ads");
        sdkPackages.put(h.l, "com.unity3d.ads");
        sdkPackageToUUID.put("com.unity3d.ads", "daaea35726ab7cd457ab61d4538fb822");
        sdkPackages.put("com.unity3d.ads", "com.unity3d.ads");
        sdkAdaptersUUID.put("com.applovin.mediation.adapters.UnityAdsMediationAdapter", "daaea35726ab7cd457ab61d4538fb822");
        sdkPackageToName.put(h.f, "IronSource");
        sdkPackages.put("com.ironsource", h.f);
        sdkPackageToUUID.put(h.f, "b9b88d70c3d018bfbda46cd93ba3ddca");
        sdkPackages.put(h.f, h.f);
        sdkAdaptersUUID.put("com.applovin.mediation.adapters.IronSourceMediationAdapter", "b9b88d70c3d018bfbda46cd93ba3ddca");
        sdkPackageToName.put(h.v, "Smaato");
        sdkPackageToUUID.put(h.v, "05d97eb6bebee2dc1cf8f4db8d56c22c");
        sdkPackages.put(h.v, h.v);
        sdkAdaptersUUID.put("com.applovin.mediation.adapters.SmaatoMediationAdapter", "05d97eb6bebee2dc1cf8f4db8d56c22c");
        sdkPackageToName.put(h.F, "PubMatic");
        sdkPackageToUUID.put(h.F, "b22aaa348bcb8a472af27d73ae6fb3f4");
        sdkPackages.put(h.F, h.F);
        sdkAdaptersUUID.put("com.applovin.mediation.adapters.PubMaticMediationAdapter", "b22aaa348bcb8a472af27d73ae6fb3f4");
        sdkPackageToName.put(h.D, "MolocoAds");
        sdkPackageToUUID.put(h.D, "213ac5b6803852323d73a1292440d7be");
        sdkPackages.put(h.D, h.D);
        sdkAdaptersUUID.put("com.applovin.mediation.adapters.MolocoMediationAdapter", "213ac5b6803852323d73a1292440d7be");
        sdkPackageToName.put(h.o, "Mintegral");
        sdkPackages.put(MBConfiguration.LOG_TAG, h.o);
        sdkPackageToUUID.put(h.o, "1be9e72506f3307ce6a9e78d26d65bd0");
        sdkPackages.put(h.o, h.o);
        sdkAdaptersUUID.put("com.applovin.mediation.adapters.MintegralMediationAdapter", "1be9e72506f3307ce6a9e78d26d65bd0");
        sdkPackageToName.put(h.p, "DTExchange");
        sdkPackages.put("com.fyber.inneractive", h.p);
        sdkPackageToUUID.put(h.p, "d41ed920405e4bd14f3a42cd93c43d89");
        sdkPackages.put(h.p, h.p);
        sdkAdaptersUUID.put("com.applovin.mediation.adapters.InneractiveMediationAdapter", "d41ed920405e4bd14f3a42cd93c43d89");
        sdkPackageToName.put(h.i, "InMobi");
        sdkPackageToUUID.put(h.i, "7eac188d3286b05ccbba774f63a2c049");
        sdkPackages.put(h.i, h.i);
        sdkAdaptersUUID.put("com.applovin.mediation.adapters.InMobiMediationAdapter", "7eac188d3286b05ccbba774f63a2c049");
        sdkPackageToName.put(h.h, "AdMob");
        sdkPackages.put("com.google.android.gms.internal", h.h);
        sdkPackages.put(MobileAds.ERROR_DOMAIN, h.h);
        sdkPackages.put("com.google.unity.ads", h.h);
        sdkPackageToUUID.put(h.h, "29015bbfcc182d80e7f75bd2c38e4521");
        sdkPackages.put(h.h, h.h);
        sdkAdaptersUUID.put("com.applovin.mediation.adapters.GoogleMediationAdapter", "29015bbfcc182d80e7f75bd2c38e4521");
        sdkPackageToName.put("com.five_corp.ad", "LINE");
        sdkPackageToUUID.put("com.five_corp.ad", "afdbbdbd3c73ca05c4f06ef94ef506fb");
        sdkPackages.put("com.five_corp.ad", "com.five_corp.ad");
        sdkAdaptersUUID.put("com.applovin.mediation.adapters.LineMediationAdapter", "afdbbdbd3c73ca05c4f06ef94ef506fb");
        sdkPackageToName.put(h.c, "Chartboost");
        sdkPackageToUUID.put(h.c, "c4d1f1775f251f03dce94fdf267a7b89");
        sdkPackages.put(h.c, h.c);
        sdkAdaptersUUID.put("com.applovin.mediation.adapters.ChartboostMediationAdapter", "c4d1f1775f251f03dce94fdf267a7b89");
        sdkPackageToName.put(h.u, "Pangle");
        sdkPackageToUUID.put(h.u, "dd2971b0681141d57b221687791ad1bd");
        sdkPackages.put(h.u, h.u);
        sdkAdaptersUUID.put("com.applovin.mediation.adapters.ByteDanceMediationAdapter", "dd2971b0681141d57b221687791ad1bd");
        sdkPackageToName.put(h.f8160a, "AppLovin");
        sdkPackageToUUID.put(h.f8160a, "74616804a7dc29147dfb0afe122a9fd2");
        sdkPackages.put(h.f8160a, h.f8160a);
        sdkAdaptersUUID.put("com.applovin.mediation.adapters.AppLovinMediationAdapter", "74616804a7dc29147dfb0afe122a9fd2");
        sdkPackageToName.put(h.A, "AmazonPublisherServices");
        sdkPackages.put("com.amazon.aps.shared", h.A);
        sdkPackages.put("com.amazon.aps.ads", h.A);
        sdkPackageToUUID.put(h.A, "d17c8c244936f66bcfdcf4e676e6203c");
        sdkPackages.put(h.A, h.A);
        sdkAdaptersUUID.put("com.applovin.mediation.adapters.AmazonAdMarketplaceMediationAdapter", "d17c8c244936f66bcfdcf4e676e6203c");
    }

    public static TreeMap<String, String> getSdkAdaptersUUID() {
        return sdkAdaptersUUID;
    }

    public static void setTopicSdkVersionsUpdated() {
        topicSdkVersionsUpdated = true;
        Logger.d(TAG, "set topic sdk versions updated, sdkPackageToUUID=" + sdkPackageToUUID.toString());
        Logger.d(TAG, "set topic sdk versions updated, redirectSupprotedSdks=" + redirectSupportedSdks.toString());
    }

    public static boolean isTopicSdkVersionsUpdated() {
        return topicSdkVersionsUpdated;
    }

    public static void init() {
        printAllSdkVersions();
    }

    public static void initForInitTests() {
        sdkPackages.put("com.applovin.adview.StaticInterstitialActivity", h.f8160a);
        sdkPackages.put("com.google.ads.AdActivity1", h.h);
        sdkPackages.put("com.inmobi.StaticInterstitialActivity", h.i);
    }

    public static String getSdkPackageByClass(String className) {
        if (className != null) {
            for (String str : sdkPackages.keySet()) {
                if (className.startsWith(str)) {
                    return sdkPackages.get(str);
                }
            }
        }
        return null;
    }

    public static String getSdkNameByPackage(String packageName) {
        return sdkPackageToName.get(packageName);
    }

    public static String getSdkUUIDByPackage(String packageName) {
        if (!SafeDK.f7941a.equals(packageName)) {
            String packageName2 = sdkPackageToUUID.get(packageName);
            Logger.d(TAG, "get sdk UUID by package " + packageName + " , result = " + packageName2);
            return packageName2;
        }
        return packageName;
    }

    public static String getSdkPackageByPackageUUID(String uuid) {
        for (Map.Entry<String, String> entry : sdkPackageToUUID.entrySet()) {
            if (entry.getValue().equals(uuid)) {
                Logger.d(TAG, "get sdk package by package UUID returns " + entry.getKey() + " for UUID " + entry.getValue());
                return entry.getKey();
            }
        }
        Logger.d(TAG, "sdk UUID not valid: " + uuid);
        return null;
    }

    public static String getSdkVersionByPackage(String packageName) {
        String sdkUUIDByPackage = getSdkUUIDByPackage(packageName);
        Logger.d(TAG, "get sdk version by package,packageName = " + packageName + ", uuid = " + sdkUUIDByPackage);
        if (sdkUUIDByPackage != null) {
            return sdkPackageUUIDToVersion.get(sdkUUIDByPackage);
        }
        return null;
    }

    public static Set<String> getAllSdkNames() {
        return new HashSet(sdkPackageToName.values());
    }

    public static Map<String, String> getAllSdkVersionsMap() {
        return sdkPackageUUIDToVersion;
    }

    public static void printAllSdkVersions() {
        Logger.d(TAG, "print all sdk versions, sdkPackages=" + sdkPackages.toString());
        Logger.d(TAG, "print all sdk versions, sdkPackageToName=" + sdkPackageToName.toString());
        Logger.d(TAG, "print all sdk versions, sdkPackageToUUID=" + sdkPackageToUUID.toString());
        Logger.d(TAG, "print all sdk versions, sdkPackageUUIDToVersion=" + sdkPackageUUIDToVersion.toString());
        Logger.d(TAG, "print all sdk versions, sdkAdaptersUUID=" + sdkAdaptersUUID.toString());
        Iterator<Map.Entry<String, String>> it = sdkPackageToName.entrySet().iterator();
        Logger.d(TAG, "print all sdk versions, sdks detected: " + sdkPackageToName.entrySet().size() + " sdks with versions: " + sdkPackageUUIDToVersion.entrySet().size());
        while (it.hasNext()) {
            String key = it.next().getKey();
            Logger.d(TAG, String.format("print all sdk versions, sdk package: %s, version: %s", key, sdkPackageUUIDToVersion.get(sdkPackageToUUID.get(key))));
        }
    }

    public static Set<String> getAllSdkPackages() {
        return sdkPackageToName.keySet();
    }

    public static boolean isSameSdkByPackages(String package1, String package2) {
        if (package1 == null || package2 == null) {
            return false;
        }
        String sdkNameByPackage = getSdkNameByPackage(package1);
        String sdkNameByPackage2 = getSdkNameByPackage(package2);
        if (sdkNameByPackage == null || sdkNameByPackage2 == null) {
            return false;
        }
        return sdkNameByPackage.equals(sdkNameByPackage2) || sdkNameByPackage.regionMatches(false, 0, sdkNameByPackage2, 0, 5);
    }

    public static void updateSdkVersionIfNeeded(String className, String version) {
        if (!isTopicSdkVersionsUpdated()) {
            if (sdkAdaptersUUID.get(className) == null) {
                Logger.d(TAG, "Cannot find UUID for package " + className);
                return;
            }
            String str = sdkAdaptersUUID.get(className);
            Logger.d(TAG, "update sdk version if needed, UUID for class " + className + " is " + str);
            if (!sdkPackageUUIDToVersion.containsKey(str) || (sdkPackageUUIDToVersion.containsKey(str) && version != null && !version.isEmpty() && !sdkPackageUUIDToVersion.get(str).equals(version))) {
                sdkPackageUUIDToVersion.put(str, version);
                Logger.d(TAG, "update sdk version if needed, class " + className + " (uuid " + str + ") updated to " + version);
                Logger.d(TAG, "update sdk version if needed, get discovery by package " + getSdkPackageByPackageUUID(str) + ", uuid " + str);
                Logger.d(TAG, "update sdk version if needed, discoveries  " + CreativeInfoManager.e());
            } else {
                Logger.d(TAG, "update sdk version if needed, cannot update class " + className + " (uuid " + str + ") , version = " + version);
            }
            if (redirectSupportedSdks == null) {
                redirectSupportedSdks = new HashSet();
            }
            if (sdkAdaptersUUID.containsValue(str)) {
                Logger.d(TAG, "Adding " + className + " , package UUID " + str + " to redirect supported sdks");
                redirectSupportedSdks.add(str);
            } else {
                Logger.d(TAG, "Not adding " + className + " , package UUID " + str + " to redirect supported sdks");
            }
            Logger.d(TAG, "get redirect supported sdks : " + getRedirectSupportedSdks().toString());
        }
    }

    public static void setMaxAdapterVersions(Bundle bundle) {
        try {
            n.b(TAG, "get max adapter versions started, Bundle = " + bundle);
            if (bundle.containsKey(KEY_INSTALLED_MEDIATION_ADAPTERS)) {
                Logger.d(TAG, "get max adapter versions, processing " + KEY_INSTALLED_MEDIATION_ADAPTERS.toUpperCase());
                ArrayList<Bundle> parcelableArrayList = bundle.getParcelableArrayList(KEY_INSTALLED_MEDIATION_ADAPTERS);
                if (parcelableArrayList != null) {
                    for (Bundle bundle2 : parcelableArrayList) {
                        String string = bundle2.getString(KEY_INSTALLED_MEDIATION_ADAPTERS_CLASS);
                        String string2 = bundle2.getString("sdk_version");
                        Logger.d(TAG, "get max adapter versions, class : " + string + ", version = " + string2);
                        if (string2 != null && string2.length() > 0) {
                            updateSdkVersionIfNeeded(string, string2);
                        }
                    }
                    setTopicSdkVersionsUpdated();
                } else {
                    Logger.d(TAG, "extracting value for key installed_mediation_adapters produced null value, skipping");
                }
                printAllSdkVersions();
                return;
            }
            Logger.d(TAG, "get max adapter versions, no adapter class version received from MAX");
        } catch (Throwable th) {
            Logger.e(TAG, "get max adapter versions, exception extracting " + KEY_INSTALLED_MEDIATION_ADAPTERS.toUpperCase(), th);
        }
    }

    public static Set<String> getRedirectSupportedSdks() {
        Logger.d(TAG, "get redirect supported sdks started, sdkAdaptersUUID=" + sdkAdaptersUUID.values());
        return !isTopicSdkVersionsUpdated() ? new HashSet(sdkAdaptersUUID.values()) : redirectSupportedSdks;
    }

    public static String getMainSdkPackage(String sdkpackage) {
        if (h.m.equals(sdkpackage)) {
            return "com.unity3d.ads";
        }
        if (h.g.equals(sdkpackage)) {
            return h.f;
        }
        return sdkpackage;
    }
}
