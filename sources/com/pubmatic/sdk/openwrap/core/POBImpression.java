package com.pubmatic.sdk.openwrap.core;

import com.pubmatic.sdk.common.POBInstanceProvider;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.utility.POBUtils;
import com.safedk.android.analytics.brandsafety.l;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class POBImpression {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map f7728a;
    protected POBRequest.AdPosition adPosition;
    protected final String adUnitId;
    private POBBanner b;
    private POBVideo c;
    private POBNative d;
    private boolean e;
    private boolean f;
    protected String gpid;
    protected final String id;
    protected String pmZoneId;
    protected String testCreativeId;

    public POBImpression(String str, String str2) {
        this.id = str;
        this.adUnitId = str2;
        this.adPosition = POBRequest.AdPosition.UNKNOWN;
    }

    Map a() {
        return this.f7728a;
    }

    String b() {
        return this.pmZoneId;
    }

    public POBRequest.AdPosition getAdPosition() {
        return this.adPosition;
    }

    public String getAdUnitId() {
        return this.adUnitId;
    }

    public POBBanner getBanner() {
        return this.b;
    }

    protected String getCustomData() {
        Map mapA = a();
        if (mapA != null && !mapA.isEmpty()) {
            StringBuilder sb = null;
            for (String str : mapA.keySet()) {
                if (sb == null) {
                    sb = new StringBuilder();
                } else {
                    sb.append(l.ad);
                }
                sb.append(str);
                sb.append("=");
                List<String> list = (List) mapA.get(str);
                if (list != null) {
                    int i = 0;
                    for (String str2 : list) {
                        if (i > 0) {
                            sb.append(StringUtils.COMMA);
                        }
                        sb.append(str2);
                        i++;
                    }
                }
            }
            if (sb != null) {
                return sb.toString();
            }
        }
        return null;
    }

    protected JSONObject getExtJson(JSONArray jSONArray) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (jSONArray != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("keywords", jSONArray);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.putOpt("pubmatic", jSONObject2);
                jSONObject.putOpt("bidder", jSONObject3);
            }
            if (!POBUtils.isNullOrEmpty(this.gpid)) {
                jSONObject.putOpt(POBConstants.KEY_GPID, this.gpid);
            } else if (!POBUtils.isNullOrEmpty(this.adUnitId)) {
                jSONObject.putOpt(POBConstants.KEY_GPID, this.adUnitId);
            }
            if (this.f) {
                jSONObject.putOpt("reward", 1);
            }
            return jSONObject;
        } catch (JSONException unused) {
            POBLog.warn("POBImpression", "Not able to generate Ext Json.", new Object[0]);
            return null;
        }
    }

    public String getId() {
        return this.id;
    }

    public JSONObject getImpressionJson() throws JSONException {
        JSONArray jSONArray;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.id);
        if (POBInstanceProvider.getSdkConfig().isUseInternalBrowser()) {
            jSONObject.put(POBConstants.KEY_CLICK_BROWSER, 0);
        } else {
            jSONObject.put(POBConstants.KEY_CLICK_BROWSER, 1);
        }
        jSONObject.put(POBConstants.KEY_DISPLAY_MANAGER, "PubMatic_OpenWrap_SDK");
        jSONObject.put(POBConstants.KEY_DISPLAY_MANAGER_VERSION, "4.5.1");
        jSONObject.put(POBConstants.KEY_TAG_ID, this.adUnitId);
        String strB = b();
        if (POBUtils.isNullOrEmpty(strB)) {
            jSONArray = null;
        } else {
            jSONArray = new JSONArray();
            jSONArray.put(putKeyValueObject(POBConstants.KEY_PM_ZONE_ID, strB));
        }
        String testCreativeId = getTestCreativeId();
        if (!POBUtils.isNullOrEmpty(testCreativeId)) {
            if (jSONArray == null) {
                jSONArray = new JSONArray();
            }
            jSONArray.put(putKeyValueObject(POBConstants.KEY_TEST_CREATIVE_ID, testCreativeId));
        }
        String customData = getCustomData();
        if (customData != null) {
            if (jSONArray == null) {
                jSONArray = new JSONArray();
            }
            jSONArray.put(putKeyValueObject(POBConstants.KEY_DCTR, customData));
        }
        JSONObject extJson = getExtJson(jSONArray);
        if (extJson != null && extJson.length() > 0) {
            jSONObject.putOpt("ext", extJson);
        }
        jSONObject.put(POBConstants.KEY_SECURE, POBInstanceProvider.getSdkConfig().isRequestSecureCreative() ? 1 : 0);
        POBBanner pOBBanner = this.b;
        if (pOBBanner != null) {
            pOBBanner.setAdPosition(this.adPosition);
            POBBanner pOBBanner2 = this.b;
            jSONObject.put("banner", pOBBanner2.getRTBJson(pOBBanner2.getSupportedAPIs(false), false));
        }
        POBVideo pOBVideo = this.c;
        if (pOBVideo != null) {
            pOBVideo.setPosition(this.adPosition);
            jSONObject.put("video", this.c.getRTBJson());
        }
        POBNative pOBNative = this.d;
        if (pOBNative != null) {
            jSONObject.put("native", pOBNative.getRTBJson());
        }
        jSONObject.put(POBConstants.KEY_INTERSTITIAL, this.e ? 1 : 0);
        return jSONObject;
    }

    public POBNative getNative() {
        return this.d;
    }

    public String getTestCreativeId() {
        return this.testCreativeId;
    }

    public POBVideo getVideo() {
        return this.c;
    }

    public boolean isInterstitial() {
        return this.e;
    }

    public boolean isRewardedAd() {
        return this.f;
    }

    protected JSONObject putKeyValueObject(String str, Object... objArr) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("key", str);
            jSONObject.putOpt("value", new JSONArray(objArr));
        } catch (JSONException unused) {
            POBLog.warn("POBImpression", "Not able to generate Json with key/value pair.", new Object[0]);
        }
        return jSONObject;
    }

    public void setAdPosition(POBRequest.AdPosition adPosition) {
        this.adPosition = adPosition;
    }

    public void setBanner(POBBanner pOBBanner) {
        this.b = pOBBanner;
    }

    public void setCustomParam(Map<String, List<String>> map) {
        this.f7728a = map;
    }

    public void setGpid(String str) {
        this.gpid = str;
    }

    public void setInterstitial(boolean z) {
        this.e = z;
    }

    public void setNative(POBNative pOBNative) {
        this.d = pOBNative;
    }

    public void setPMZoneId(String str) {
        this.pmZoneId = str;
    }

    public void setTestCreativeId(String str) {
        this.testCreativeId = str;
    }

    public void setVideo(POBVideo pOBVideo) {
        this.c = pOBVideo;
    }

    public POBImpression(String str, String str2, boolean z, boolean z2) {
        this(str, str2);
        this.f = z;
        this.e = z2;
    }
}
