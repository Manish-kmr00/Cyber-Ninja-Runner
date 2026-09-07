package com.chartboost.sdk.impl;

import com.pubmatic.sdk.nativead.POBNativeConstants;
import java.net.URL;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class fb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1017a;
    public final URL b;
    public final String c;

    public fb(String str, URL url, String str2) {
        this.f1017a = str;
        this.b = url;
        this.c = str2;
    }

    public static fb a(String str, URL url, String str2) {
        ld.a(str, "VendorKey is null or empty");
        ld.a(url, "ResourceURL is null");
        ld.a(str2, "VerificationParameters is null or empty");
        return new fb(str, url, str2);
    }

    public String b() {
        return this.f1017a;
    }

    public String c() {
        return this.c;
    }

    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        vc.a(jSONObject, POBNativeConstants.NATIVE_VENDOR_KEY, this.f1017a);
        vc.a(jSONObject, "resourceUrl", this.b.toString());
        vc.a(jSONObject, "verificationParameters", this.c);
        return jSONObject;
    }

    public URL a() {
        return this.b;
    }
}
