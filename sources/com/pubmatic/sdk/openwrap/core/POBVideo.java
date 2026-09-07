package com.pubmatic.sdk.openwrap.core;

import com.pubmatic.sdk.common.POBAdSize;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.pubmatic.sdk.common.POBInstanceProvider;
import com.pubmatic.sdk.video.player.POBVideoPlayer;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class POBVideo {
    protected static final int BOXING_ALLOWED = 1;
    protected static final int PLAYBACK_END = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Linearity f7738a;
    private POBRequest.AdPosition b = POBRequest.AdPosition.UNKNOWN;
    private final Placement c;
    private final Plcmt d;
    private final POBAdSize e;
    private JSONArray f;
    protected static final int[] PROTOCOLS = {2, 3, 5, 6, 7, 8, 11, 12, 13, 14};
    protected static final String[] MIMES = POBVideoPlayer.SupportedMediaType.getStringValues();
    protected static final int[] DELIVERY = {2};
    protected static final int[] COMPANION_TYPE = {1, 2, 3};

    public enum Linearity {
        LINEAR(1),
        NON_LINEAR(2);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f7739a;

        Linearity(int i) {
            this.f7739a = i;
        }

        public int getValue() {
            return this.f7739a;
        }
    }

    public enum Placement {
        IN_BANNER(2),
        INTERSTITIAL(5);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f7740a;

        Placement(int i) {
            this.f7740a = i;
        }

        public int getValue() {
            return this.f7740a;
        }
    }

    public enum Plcmt {
        STANDALONE(4),
        INTERSTITIAL(3);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f7741a;

        Plcmt(int i) {
            this.f7741a = i;
        }

        public int getValue() {
            return this.f7741a;
        }
    }

    public POBVideo(Placement placement, Plcmt plcmt, Linearity linearity, POBAdSize pOBAdSize) {
        this.e = pOBAdSize;
        this.c = placement;
        this.f7738a = linearity;
        this.d = plcmt;
    }

    public POBAdSize getAdSize() {
        return this.e;
    }

    public JSONArray getCompanionAds() {
        return this.f;
    }

    public Linearity getLinearity() {
        return this.f7738a;
    }

    public POBRequest.AdPosition getPosition() {
        return this.b;
    }

    public JSONObject getRTBJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("w", this.e.getAdWidth());
        jSONObject.put("h", this.e.getAdHeight());
        if (this.f == null) {
            POBBanner pOBBanner = new POBBanner(this.e);
            pOBBanner.setAdPosition(this.b);
            this.f = new JSONArray(new JSONObject[]{pOBBanner.getRTBJson(new HashSet(), true)});
        }
        jSONObject.put(POBConstants.KEY_VIDEO_COMPANION_AD, this.f);
        jSONObject.put(POBConstants.KEY_POSITION, this.b.getValue());
        jSONObject.put(POBConstants.KEY_VIDEO_PROTOCOLS, new JSONArray(PROTOCOLS));
        jSONObject.put("mimes", new JSONArray(MIMES));
        jSONObject.put(POBConstants.KEY_VIDEO_LINEARITY, this.f7738a.getValue());
        jSONObject.put(POBConstants.KEY_VIDEO_BOXING_ALLOWED, 1);
        jSONObject.put("delivery", new JSONArray(DELIVERY));
        jSONObject.put(POBConstants.KEY_VIDEO_COMPANION_TYPE, new JSONArray(COMPANION_TYPE));
        jSONObject.put("placement", this.c.getValue());
        jSONObject.put(POBConstants.KEY_VIDEO_PLCMT, this.d.getValue());
        jSONObject.put(POBConstants.KEY_VIDEO_PLAYBACK_END, 1);
        jSONObject.put(POBConstants.KEY_VIDEO_START_DELAY, 0);
        jSONObject.put(POBConstants.KEY_VIDEO_MIN_BITRATE, 250);
        jSONObject.put(POBConstants.KEY_VIDEO_MAX_BITRATE, 5000);
        Set<Integer> supportedAPIs = getSupportedAPIs();
        if (!supportedAPIs.isEmpty()) {
            jSONObject.put("api", new JSONArray((Collection) supportedAPIs));
        }
        return jSONObject;
    }

    protected Set<Integer> getSupportedAPIs() {
        HashSet hashSet = new HashSet();
        if (POBInstanceProvider.getSdkConfig().getMeasurementProvider(POBCommonConstants.VIDEO_MEASUREMENT_PROVIDER_CLASS) != null) {
            hashSet.add(Integer.valueOf(POBRequest.API.OMSDK.getValue()));
        }
        return hashSet;
    }

    public void setCompanionAds(JSONArray jSONArray) {
        this.f = jSONArray;
    }

    public void setPosition(POBRequest.AdPosition adPosition) {
        this.b = adPosition;
    }
}
