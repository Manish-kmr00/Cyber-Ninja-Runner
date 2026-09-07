package com.fyber.inneractive.sdk.config.global;

import com.fyber.inneractive.sdk.util.IAlog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1696a;
    public int b;
    public final ArrayList c = new ArrayList();
    public final ArrayList d = new ArrayList();

    public static void a(b bVar, JSONObject jSONObject, boolean z) {
        d cVar;
        if (jSONObject != null) {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                next.getClass();
                next.hashCode();
                switch (next) {
                    case "demand":
                        cVar = new c(jSONObject.getJSONArray(next), z);
                        break;
                    case "pub_id":
                        cVar = new i(jSONObject.getJSONArray(next), z);
                        break;
                    case "placement_type":
                        cVar = new h(jSONObject.getJSONArray(next), z);
                        break;
                    case "os":
                        cVar = new f(z, jSONObject.getString(next));
                        break;
                    case "sdk":
                        cVar = new j(z, jSONObject.getString(next));
                        break;
                    default:
                        cVar = null;
                        break;
                }
                if (cVar != null) {
                    bVar.d.add(cVar);
                } else {
                    IAlog.a("b: Unsupported filter type: " + next, new Object[0]);
                }
            }
        }
    }

    public final String toString() {
        return String.format("experiment: id=%s, variants=%s, filters=%s", this.f1696a, this.c, this.d);
    }
}
