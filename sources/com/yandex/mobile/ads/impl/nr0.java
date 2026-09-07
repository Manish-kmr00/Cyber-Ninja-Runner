package com.yandex.mobile.ads.impl;

import com.pubmatic.sdk.nativead.POBNativeConstants;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes5.dex */
public final class nr0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ch f9748a;
    private final wk2 b;
    private final sr0 c;

    public nr0(lp1 reporter, ch assetsJsonParser) {
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(assetsJsonParser, "assetsJsonParser");
        this.f9748a = assetsJsonParser;
        this.b = new wk2();
        this.c = new sr0(reporter);
    }

    public final mr0 a(XmlPullParser parser, wj base64EncodingParameters) throws JSONException {
        Intrinsics.checkNotNullParameter(parser, "parser");
        Intrinsics.checkNotNullParameter(base64EncodingParameters, "base64EncodingParameters");
        try {
            mr0.a aVar = new mr0.a();
            this.b.getClass();
            JSONObject jSONObject = new JSONObject(wk2.c(parser));
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (Intrinsics.areEqual(POBNativeConstants.NATIVE_ASSETS, next)) {
                    aVar.a(this.f9748a.a(jSONObject, base64EncodingParameters));
                } else if (Intrinsics.areEqual("link", next)) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                    sr0 sr0Var = this.c;
                    Intrinsics.checkNotNull(jSONObject2);
                    aVar.a(sr0Var.a(jSONObject2, base64EncodingParameters));
                }
            }
            return aVar.a();
        } catch (Exception e) {
            throw new JSONException(e.getMessage());
        }
    }
}
