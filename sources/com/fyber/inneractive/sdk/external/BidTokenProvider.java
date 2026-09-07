package com.fyber.inneractive.sdk.external;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.bidder.C3054b;
import com.fyber.inneractive.sdk.config.C3085o;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.network.C3146w;
import com.fyber.inneractive.sdk.network.EnumC3143t;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class BidTokenProvider {
    public static String getBidderToken() {
        if (!InneractiveAdManager.wasInitialized()) {
            IAlog.b("BidTokenProvider: Cannot generate token. Please init Fyber Marketplace SDK.", new Object[0]);
            return null;
        }
        C3054b c3054b = C3054b.h;
        c3054b.getClass();
        if (IAConfigManager.d()) {
            IAlog.a("%sTCF purpose 1 disabled, returning null", IAlog.a(c3054b));
            return null;
        }
        if (c3054b.e.get() == null) {
            IAConfigManager.b();
            synchronized (c3054b.g) {
                c3054b.b();
            }
        } else {
            c3054b.d();
        }
        String str = (String) c3054b.e.get();
        IAConfigManager iAConfigManager = IAConfigManager.O;
        String str2 = iAConfigManager.l;
        C3085o c3085o = iAConfigManager.u.b;
        String str3 = "token_size_limit";
        int iA = c3085o.a("token_size_limit", 4000, 1);
        if (!TextUtils.isEmpty(str2)) {
            str3 = "token_size_limit_" + str2.toLowerCase(Locale.US);
        }
        int iA2 = c3085o.a(str3, iA, 1);
        if (str == null || str.getBytes().length <= iA2) {
            IAlog.c("token = %s", str);
            return str;
        }
        C3146w c3146w = new C3146w(EnumC3143t.TOKEN_EXCEEDS_LIMIT);
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str2)) {
            str2 = "unknown";
        }
        try {
            jSONObject.put("mediator", str2);
        } catch (Exception unused) {
            IAlog.f("Got exception adding param to json object: %s, %s", "mediator", str2);
        }
        Integer numValueOf = Integer.valueOf(str.getBytes().length);
        try {
            jSONObject.put("token_size", numValueOf);
        } catch (Exception unused2) {
            IAlog.f("Got exception adding param to json object: %s, %s", "token_size", numValueOf);
        }
        Integer numValueOf2 = Integer.valueOf(iA2);
        try {
            jSONObject.put("token_limit", numValueOf2);
        } catch (Exception unused3) {
            IAlog.f("Got exception adding param to json object: %s, %s", "token_limit", numValueOf2);
        }
        c3146w.f.put(jSONObject);
        c3146w.a((String) null);
        IAlog.c("token exceeds the limit, returning null", new Object[0]);
        return null;
    }
}
