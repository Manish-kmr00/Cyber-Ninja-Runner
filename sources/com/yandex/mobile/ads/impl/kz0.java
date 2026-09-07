package com.yandex.mobile.ads.impl;

import com.monetization.ads.mediation.banner.MediatedBannerSize;
import io.ktor.http.ContentDisposition;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class kz0 {
    public static JSONObject a(hz0 mediationNetwork, String bidderToken, MediatedBannerSize mediatedBannerSize) {
        Intrinsics.checkNotNullParameter(mediationNetwork, "mediationNetwork");
        Intrinsics.checkNotNullParameter(bidderToken, "bidderToken");
        String strE = mediationNetwork.e();
        Map<String, String> mapF = mediationNetwork.f();
        Map<String, String> mapI = mediationNetwork.i();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("adapter", strE);
            if (mapF != null) {
                jSONObject.put("bidding_info", new JSONObject(mapF));
            }
            jSONObject.put("network_data", new JSONObject(mapI));
            jSONObject.put("bidder_token", bidderToken);
            if (mediatedBannerSize == null) {
                return jSONObject;
            }
            jSONObject.put(ContentDisposition.Parameters.Size, new JSONObject(mediatedBannerSize.toSizeData()));
            return jSONObject;
        } catch (JSONException unused) {
            op0.c(new Object[0]);
            return null;
        }
    }
}
