package com.pubmatic.sdk.openwrap.core.signal;

import com.pubmatic.sdk.common.POBInstanceProvider;
import com.pubmatic.sdk.openwrap.core.POBBanner;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import com.pubmatic.sdk.openwrap.core.POBImpression;
import com.pubmatic.sdk.openwrap.core.POBRequest;
import com.pubmatic.sdk.openwrap.core.POBVideo;
import kotlin.Metadata;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/pubmatic/sdk/openwrap/core/signal/POBALMAXImpression;", "Lcom/pubmatic/sdk/openwrap/core/POBImpression;", "isRewarded", "", "isInterstitial", "(ZZ)V", "getImpressionJson", "Lorg/json/JSONObject;", "openwrapcore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class POBALMAXImpression extends POBImpression {
    public POBALMAXImpression(boolean z, boolean z2) {
        super("NA", "", z, z2);
    }

    @Override // com.pubmatic.sdk.openwrap.core.POBImpression
    public JSONObject getImpressionJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (POBInstanceProvider.getSdkConfig().isUseInternalBrowser()) {
            jSONObject.put(POBConstants.KEY_CLICK_BROWSER, 0);
        } else {
            jSONObject.put(POBConstants.KEY_CLICK_BROWSER, 1);
        }
        jSONObject.put(POBConstants.KEY_DISPLAY_MANAGER, "PubMatic_OpenWrap_SDK");
        jSONObject.put(POBConstants.KEY_DISPLAY_MANAGER_VERSION, "4.5.1");
        JSONObject extJson = getExtJson(null);
        if (extJson != null && extJson.length() > 0) {
            jSONObject.putOpt("ext", extJson);
        }
        POBBanner banner = getBanner();
        if (banner != null) {
            POBRequest.AdPosition adPosition = this.adPosition;
            if (adPosition != POBRequest.AdPosition.UNKNOWN) {
                banner.setAdPosition(adPosition);
            }
            jSONObject.put("banner", banner.getRTBJson(banner.getSupportedAPIs(false), false));
        }
        POBVideo video = getVideo();
        if (video != null) {
            POBRequest.AdPosition adPosition2 = this.adPosition;
            if (adPosition2 != POBRequest.AdPosition.UNKNOWN) {
                video.setPosition(adPosition2);
            }
            jSONObject.put("video", video.getRTBJson());
        }
        return jSONObject;
    }
}
