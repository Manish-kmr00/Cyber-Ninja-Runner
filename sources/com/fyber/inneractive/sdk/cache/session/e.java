package com.fyber.inneractive.sdk.cache.session;

import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i f1647a = new i();
    public final Object c = new Object();
    public final Object d = new Object();
    public final a b = new a();

    public static JSONObject a(e eVar) {
        eVar.getClass();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("currentSession", eVar.f1647a.a());
            for (Map.Entry entry : eVar.b.entrySet()) {
                JSONArray jSONArray = new JSONArray();
                com.fyber.inneractive.sdk.cache.session.enums.c cVar = (com.fyber.inneractive.sdk.cache.session.enums.c) entry.getKey();
                Iterator it = ((PriorityQueue) entry.getValue()).iterator();
                while (it.hasNext()) {
                    jSONArray.put(((g) it.next()).a(true, true));
                }
                jSONObject.put(cVar.name(), jSONArray);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public final void a(com.fyber.inneractive.sdk.cache.session.enums.c cVar, g gVar) {
        synchronized (this.d) {
            k kVar = (k) this.b.get(cVar);
            if (kVar != null) {
                kVar.add(gVar);
            }
        }
    }
}
