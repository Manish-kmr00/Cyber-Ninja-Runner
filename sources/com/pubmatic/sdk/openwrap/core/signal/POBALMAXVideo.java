package com.pubmatic.sdk.openwrap.core.signal;

import com.pubmatic.sdk.common.POBAdSize;
import com.pubmatic.sdk.openwrap.core.POBBanner;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import com.pubmatic.sdk.openwrap.core.POBRequest;
import com.pubmatic.sdk.openwrap.core.POBVideo;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/pubmatic/sdk/openwrap/core/signal/POBALMAXVideo;", "Lcom/pubmatic/sdk/openwrap/core/POBVideo;", "Lcom/pubmatic/sdk/openwrap/core/POBVideo$Placement;", "placement", "Lcom/pubmatic/sdk/openwrap/core/POBVideo$Plcmt;", POBConstants.KEY_VIDEO_PLCMT, "Lcom/pubmatic/sdk/openwrap/core/POBVideo$Linearity;", POBConstants.KEY_VIDEO_LINEARITY, "Lcom/pubmatic/sdk/common/POBAdSize;", "adSize", "<init>", "(Lcom/pubmatic/sdk/openwrap/core/POBVideo$Placement;Lcom/pubmatic/sdk/openwrap/core/POBVideo$Plcmt;Lcom/pubmatic/sdk/openwrap/core/POBVideo$Linearity;Lcom/pubmatic/sdk/common/POBAdSize;)V", "Lorg/json/JSONObject;", "getRTBJson", "()Lorg/json/JSONObject;", "g", "Lcom/pubmatic/sdk/openwrap/core/POBVideo$Placement;", "getPlacement", "()Lcom/pubmatic/sdk/openwrap/core/POBVideo$Placement;", "h", "Lcom/pubmatic/sdk/openwrap/core/POBVideo$Plcmt;", "getPlcmt", "()Lcom/pubmatic/sdk/openwrap/core/POBVideo$Plcmt;", "openwrapcore_release"}, k = 1, mv = {1, 7, 1})
public final class POBALMAXVideo extends POBVideo {

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final POBVideo.Placement placement;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final POBVideo.Plcmt plcmt;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public POBALMAXVideo(POBVideo.Placement placement, POBVideo.Plcmt plcmt, POBVideo.Linearity linearity, POBAdSize adSize) {
        super(placement, plcmt, linearity, adSize);
        Intrinsics.checkNotNullParameter(placement, "placement");
        Intrinsics.checkNotNullParameter(plcmt, "plcmt");
        Intrinsics.checkNotNullParameter(linearity, "linearity");
        Intrinsics.checkNotNullParameter(adSize, "adSize");
        this.placement = placement;
        this.plcmt = plcmt;
    }

    public final POBVideo.Placement getPlacement() {
        return this.placement;
    }

    public final POBVideo.Plcmt getPlcmt() {
        return this.plcmt;
    }

    @Override // com.pubmatic.sdk.openwrap.core.POBVideo
    public JSONObject getRTBJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (this.placement == POBVideo.Placement.INTERSTITIAL) {
            jSONObject.put("w", getAdSize().getAdWidth());
            jSONObject.put("h", getAdSize().getAdHeight());
        }
        if (getCompanionAds() == null) {
            POBBanner pOBBanner = new POBBanner(getAdSize());
            pOBBanner.setAdPosition(getPosition());
            setCompanionAds(new JSONArray(new JSONObject[]{pOBBanner.getRTBJson(new HashSet(), true)}));
        }
        jSONObject.put(POBConstants.KEY_VIDEO_COMPANION_AD, getCompanionAds());
        POBRequest.AdPosition position = getPosition();
        if (position != null) {
            jSONObject.put(POBConstants.KEY_POSITION, position.getValue());
        }
        jSONObject.put(POBConstants.KEY_VIDEO_PROTOCOLS, new JSONArray(POBVideo.PROTOCOLS));
        jSONObject.put("mimes", new JSONArray(POBVideo.MIMES));
        jSONObject.put(POBConstants.KEY_VIDEO_LINEARITY, getLinearity().getValue());
        jSONObject.put(POBConstants.KEY_VIDEO_BOXING_ALLOWED, 1);
        jSONObject.put("delivery", new JSONArray(POBVideo.DELIVERY));
        jSONObject.put(POBConstants.KEY_VIDEO_COMPANION_TYPE, new JSONArray(POBVideo.COMPANION_TYPE));
        jSONObject.put("placement", this.placement.getValue());
        jSONObject.put(POBConstants.KEY_VIDEO_PLCMT, this.plcmt.getValue());
        jSONObject.put(POBConstants.KEY_VIDEO_MIN_BITRATE, 250);
        jSONObject.put(POBConstants.KEY_VIDEO_MAX_BITRATE, 5000);
        jSONObject.put(POBConstants.KEY_VIDEO_PLAYBACK_END, 1);
        jSONObject.put(POBConstants.KEY_VIDEO_START_DELAY, 0);
        Set<Integer> supportedAPIs = getSupportedAPIs();
        Intrinsics.checkNotNullExpressionValue(supportedAPIs, "getSupportedAPIs()");
        if (!supportedAPIs.isEmpty()) {
            jSONObject.put("api", new JSONArray((Collection) supportedAPIs));
        }
        return jSONObject;
    }
}
