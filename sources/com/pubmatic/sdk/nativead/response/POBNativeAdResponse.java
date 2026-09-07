package com.pubmatic.sdk.nativead.response;

import com.pubmatic.sdk.openwrap.core.nativead.POBNativeEventTrackingMethod;
import com.pubmatic.sdk.openwrap.core.nativead.POBNativeEventType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public class POBNativeAdResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7704a;
    private final Map b;
    private final POBNativeAdLinkResponse c;
    private final List d;
    private final String e;
    private final List f;
    private final String g;

    public POBNativeAdResponse(String str, List<POBNativeAdResponseAsset> list, POBNativeAdLinkResponse pOBNativeAdLinkResponse, List<String> list2, String str2, List<POBNativeAdResponseEventTracker> list3, String str3) {
        this.f7704a = str;
        this.b = a(list);
        this.c = pOBNativeAdLinkResponse;
        this.d = list2;
        this.e = str2;
        this.f = list3;
        this.g = str3;
    }

    private Map a(List list) {
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            POBNativeAdResponseAsset pOBNativeAdResponseAsset = (POBNativeAdResponseAsset) it.next();
            map.put(Integer.valueOf(pOBNativeAdResponseAsset.getAssetId()), pOBNativeAdResponseAsset);
        }
        return map;
    }

    public POBNativeAdResponseAsset getAsset(int i) {
        return (POBNativeAdResponseAsset) this.b.get(Integer.valueOf(i));
    }

    public Map<Integer, POBNativeAdResponseAsset> getAssets() {
        return this.b;
    }

    public List<POBNativeAdResponseEventTracker> getEventTrackers() {
        return this.f;
    }

    public List<String> getImpressionTrackers() {
        return this.d;
    }

    public String getJsTracker() {
        return this.e;
    }

    public POBNativeAdLinkResponse getLink() {
        return this.c;
    }

    public String getPrivacyUrl() {
        return this.g;
    }

    public String getVersion() {
        return this.f7704a;
    }

    public String toString() {
        return "Version: " + this.f7704a + "\nAssets: " + this.b + "\nLink: " + this.c + "\nImpression Trackers: " + this.d + "\nJS Tracker: " + this.e + "\nEvent Trackers: " + this.f + "\nPrivacy: " + this.g;
    }

    public List<POBNativeAdResponseEventTracker> getEventTrackers(POBNativeEventType pOBNativeEventType, POBNativeEventTrackingMethod pOBNativeEventTrackingMethod) {
        if (this.f == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (POBNativeAdResponseEventTracker pOBNativeAdResponseEventTracker : this.f) {
            if (pOBNativeAdResponseEventTracker != null && pOBNativeAdResponseEventTracker.getType() == pOBNativeEventType && pOBNativeAdResponseEventTracker.getTrackingMethod() == pOBNativeEventTrackingMethod) {
                arrayList.add(pOBNativeAdResponseEventTracker);
            }
        }
        return arrayList;
    }
}
