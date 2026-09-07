package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.networktasks.internal.NetworkResponseHandler;
import io.appmetrica.analytics.networktasks.internal.ResponseDataHolder;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.tl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4472tl implements NetworkResponseHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Al f11786a;
    public final C4355p3 b;

    public C4472tl() {
        this(new Al(), new C4355p3());
    }

    @Override // io.appmetrica.analytics.networktasks.internal.NetworkResponseHandler
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Fl handle(ResponseDataHolder responseDataHolder) {
        String strOptString;
        String strOptString2;
        if (200 == responseDataHolder.getResponseCode()) {
            byte[] responseData = responseDataHolder.getResponseData();
            Map<String, List<String>> responseHeaders = responseDataHolder.getResponseHeaders();
            List list = responseHeaders != null ? (List) CollectionUtils.getFromMapIgnoreCase(responseHeaders, "Content-Encoding") : null;
            if (!In.a((Collection) list) && "encrypted".equals(list.get(0))) {
                responseData = this.b.a(responseDataHolder.getResponseData());
            }
            if (responseData != null) {
                Al al = this.f11786a;
                al.getClass();
                Fl fl = new Fl();
                try {
                    al.i.getClass();
                    C4263lb c4263lb = new C4263lb(new String(responseData, "UTF-8"));
                    JSONObject jSONObjectOptJSONObject = c4263lb.optJSONObject("device_id");
                    if (jSONObjectOptJSONObject != null) {
                        strOptString = jSONObjectOptJSONObject.optString("hash");
                        strOptString2 = jSONObjectOptJSONObject.optString("value");
                    } else {
                        strOptString = "";
                        strOptString2 = "";
                    }
                    fl.h = strOptString2;
                    fl.i = strOptString;
                    al.a(fl, c4263lb);
                    fl.f11146a = TextUtils.isEmpty(fl.i) ? 1 : 2;
                } catch (Throwable unused) {
                    fl = new Fl();
                    fl.f11146a = 1;
                }
                if (2 == fl.f11146a) {
                    return fl;
                }
            }
        }
        return null;
    }

    public C4472tl(Al al, C4355p3 c4355p3) {
        this.f11786a = al;
        this.b = c4355p3;
    }
}
