package com.applovin.impl.sdk.nativeAd;

import android.text.TextUtils;
import com.applovin.impl.b6;
import com.applovin.impl.e6;
import com.applovin.impl.g5;
import com.applovin.impl.q2;
import com.applovin.impl.r0;
import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.o;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.v5;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class AppLovinNativeAdService {
    private static final String TAG = "AppLovinNativeAdService";
    private final o logger;
    private final k sdk;

    public AppLovinNativeAdService(k kVar) {
        this.sdk = kVar;
        this.logger = kVar.O();
    }

    public void loadNextAdForAdToken(String str, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        String strTrim = str != null ? str.trim() : null;
        if (TextUtils.isEmpty(strTrim)) {
            o.h(TAG, "Empty ad token");
            q2.b(appLovinNativeAdLoadListener, new AppLovinError(-8, "Empty ad token"));
            return;
        }
        com.applovin.impl.k kVar = new com.applovin.impl.k(strTrim, this.sdk);
        if (kVar.c() == com.applovin.impl.k.a.REGULAR) {
            if (o.a()) {
                this.logger.a(TAG, "Loading next ad for token: " + kVar);
            }
            this.sdk.r0().a((g5) new v5(kVar, appLovinNativeAdLoadListener, this.sdk), b6.b.CORE);
            return;
        }
        if (kVar.c() != com.applovin.impl.k.a.AD_RESPONSE_JSON) {
            AppLovinError appLovinError = new AppLovinError(-8, "Invalid token type");
            o.h(TAG, "Invalid token type");
            q2.b(appLovinNativeAdLoadListener, appLovinError);
            return;
        }
        JSONObject jSONObjectA = kVar.a();
        if (jSONObjectA == null) {
            String str2 = "Unable to retrieve ad response JSON from token: " + kVar.b();
            AppLovinError appLovinError2 = new AppLovinError(-8, str2);
            o.h(TAG, str2);
            q2.b(appLovinNativeAdLoadListener, appLovinError2);
            return;
        }
        r0.c(jSONObjectA, this.sdk);
        r0.b(jSONObjectA, this.sdk);
        r0.a(jSONObjectA, this.sdk);
        if (JsonUtils.getJSONArray(jSONObjectA, "ads", new JSONArray()).length() > 0) {
            if (o.a()) {
                this.logger.a(TAG, "Rendering ad for token: " + kVar);
            }
            this.sdk.r0().a((g5) new e6(jSONObjectA, appLovinNativeAdLoadListener, this.sdk), b6.b.CORE);
        } else {
            if (o.a()) {
                this.logger.b(TAG, "No ad returned from the server for token: " + kVar);
            }
            q2.b(appLovinNativeAdLoadListener, AppLovinError.NO_FILL);
        }
    }
}
