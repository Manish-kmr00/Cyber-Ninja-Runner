package com.fyber.inneractive.sdk.flow.endcard;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.flow.V;
import com.fyber.inneractive.sdk.network.C3146w;
import com.fyber.inneractive.sdk.network.E;
import com.fyber.inneractive.sdk.network.EnumC3143t;
import com.fyber.inneractive.sdk.network.d0;
import com.fyber.inneractive.sdk.util.IAlog;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class u implements E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f1800a;
    public final /* synthetic */ v b;

    public u(v vVar, w wVar) {
        this.b = vVar;
        this.f1800a = wVar;
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00d3  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r6v11, types: [java.lang.Throwable] */
    @Override // com.fyber.inneractive.sdk.network.E
    public final void a(Object obj, Exception exc, boolean z) {
        boolean zEqualsIgnoreCase;
        Bitmap bitmap;
        d0 d0Var = (d0) obj;
        if (exc == 0 && d0Var != null && d0Var.b == null && (bitmap = d0Var.f1919a) != null) {
            w wVar = this.f1800a;
            Bitmap bitmap2 = wVar.c;
            if (bitmap2 != null) {
                bitmap2.recycle();
            }
            wVar.c = bitmap;
            wVar.d.setImageBitmap(bitmap);
            this.b.k();
            return;
        }
        String message = d0Var != null ? d0Var.b : null;
        v vVar = this.b;
        IAlog.a("%s sending VAST_COMPANION_FAILED_LOADING event", vVar.f1789a);
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(message)) {
            if (exc == 0) {
                message = null;
            } else {
                do {
                    message = exc.getMessage();
                    exc = exc.getCause();
                } while (exc != 0);
            }
        }
        if (!TextUtils.isEmpty(message)) {
            try {
                jSONObject.put("reason", message);
            } catch (Exception unused) {
                IAlog.f("Got exception adding param to json object: %s, %s", "reason", message);
            }
        }
        JSONObject jSONObjectA = vVar.e.a();
        try {
            jSONObject.put("companion_data", jSONObjectA);
        } catch (Exception unused2) {
            IAlog.f("Got exception adding param to json object: %s, %s", "companion_data", jSONObjectA);
        }
        V v = vVar.b;
        EnumC3143t enumC3143t = EnumC3143t.VAST_COMPANION_FAILED_LOADING;
        InneractiveAdRequest inneractiveAdRequest = v.c;
        com.fyber.inneractive.sdk.response.g gVar = v.d;
        JSONArray jSONArray = v.f;
        C3146w c3146w = new C3146w(gVar);
        c3146w.b = enumC3143t;
        c3146w.f1934a = inneractiveAdRequest;
        c3146w.d = jSONArray;
        c3146w.f.put(jSONObject);
        c3146w.a((String) null);
        v vVar2 = this.b;
        String str = vVar2.e.f;
        com.fyber.inneractive.sdk.model.vast.k kVar = vVar2.f;
        if (TextUtils.isEmpty(str)) {
            zEqualsIgnoreCase = false;
        } else {
            zEqualsIgnoreCase = true;
            String strSubstring = str.substring(str.lastIndexOf(46) + 1);
            if (!kVar.extension.equalsIgnoreCase(strSubstring)) {
                com.fyber.inneractive.sdk.model.vast.k kVar2 = com.fyber.inneractive.sdk.model.vast.k.Jpeg;
                if (kVar == kVar2) {
                    zEqualsIgnoreCase = com.fyber.inneractive.sdk.model.vast.k.Jpg.extension.equalsIgnoreCase(strSubstring);
                } else if (kVar == com.fyber.inneractive.sdk.model.vast.k.Jpg) {
                    zEqualsIgnoreCase = kVar2.extension.equalsIgnoreCase(strSubstring);
                } else {
                    zEqualsIgnoreCase = false;
                }
            }
        }
        if (zEqualsIgnoreCase) {
            return;
        }
        V v2 = this.b.b;
        EnumC3143t enumC3143t2 = EnumC3143t.VAST_COMPANION_INCOMPATIBLE_MIMETYPE;
        InneractiveAdRequest inneractiveAdRequest2 = v2.c;
        com.fyber.inneractive.sdk.response.g gVar2 = v2.d;
        JSONArray jSONArray2 = v2.f;
        C3146w c3146w2 = new C3146w(gVar2);
        c3146w2.b = enumC3143t2;
        c3146w2.f1934a = inneractiveAdRequest2;
        c3146w2.d = jSONArray2;
        c3146w2.a((String) null);
    }
}
