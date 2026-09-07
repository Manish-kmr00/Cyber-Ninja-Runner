package com.yandex.mobile.ads.impl;

import com.playon.bridge.Ad;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class qz0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final fz0 f10059a;

    public final hz0 a(JSONObject jsonAsset) {
        t4 t4Var;
        Intrinsics.checkNotNullParameter(jsonAsset, "jsonMediationNetwork");
        try {
            rq0.f10131a.getClass();
            String strA = rq0.a("adapter", jsonAsset);
            Intrinsics.checkNotNullParameter(jsonAsset, "parent");
            Intrinsics.checkNotNullParameter("network_data", "name");
            JSONObject jSONObject = jsonAsset.getJSONObject("network_data");
            Map mapCreateMapBuilder = MapsKt.createMapBuilder();
            Iterator<String> itKeys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(itKeys, "keys(...)");
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Intrinsics.checkNotNull(next);
                String string = jSONObject.getString(next);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                mapCreateMapBuilder.put(next, string);
            }
            Map mapBuild = MapsKt.build(mapCreateMapBuilder);
            if (mapBuild.isEmpty()) {
                return null;
            }
            List listC = rq0.c("click_tracking_urls", jsonAsset);
            List listC2 = rq0.c(Ad.IMPRESSION_TRACKING_URLS, jsonAsset);
            List listC3 = rq0.c("ad_response_tracking_urls", jsonAsset);
            Map mapA = rq0.a(jsonAsset);
            if (jsonAsset.has("impression_data")) {
                this.f10059a.getClass();
                Intrinsics.checkNotNullParameter(jsonAsset, "jsonObject");
                Intrinsics.checkNotNullParameter("impression_data", "attributeName");
                try {
                    Intrinsics.checkNotNullParameter(jsonAsset, "jsonAsset");
                    Intrinsics.checkNotNullParameter("impression_data", "jsonAttribute");
                    String string2 = jsonAsset.getString("impression_data");
                    Intrinsics.checkNotNull(string2);
                    if (string2.length() == 0 || Intrinsics.areEqual("null", string2)) {
                        throw new JSONException("Json has not required attributes");
                    }
                    t4Var = new t4(string2);
                } catch (Exception unused) {
                    op0.b(new Object[0]);
                    t4Var = null;
                }
            } else {
                t4Var = null;
            }
            return new hz0(strA, mapBuild, listC2, listC, listC3, t4Var, mapA);
        } catch (JSONException unused2) {
            op0.c(new Object[0]);
            return null;
        }
    }

    public /* synthetic */ qz0() {
        this(new fz0());
    }

    public qz0(fz0 impressionDataParser) {
        Intrinsics.checkNotNullParameter(impressionDataParser, "impressionDataParser");
        this.f10059a = impressionDataParser;
    }
}
