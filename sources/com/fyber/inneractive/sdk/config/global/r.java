package com.fyber.inneractive.sdk.config.global;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.AbstractC3081k;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.global.features.s;
import com.fyber.inneractive.sdk.config.global.features.w;
import com.fyber.inneractive.sdk.util.EnumC3259x;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.InterfaceC3258w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1707a = "";
    public final HashMap b;
    public JSONArray c;

    public r() {
        HashMap map = new HashMap();
        map.put(w.class, new w());
        map.put(com.fyber.inneractive.sdk.config.global.features.d.class, new com.fyber.inneractive.sdk.config.global.features.d());
        map.put(com.fyber.inneractive.sdk.config.global.features.m.class, new com.fyber.inneractive.sdk.config.global.features.m());
        map.put(com.fyber.inneractive.sdk.config.global.features.f.class, new com.fyber.inneractive.sdk.config.global.features.f());
        map.put(com.fyber.inneractive.sdk.config.global.features.l.class, new com.fyber.inneractive.sdk.config.global.features.l());
        map.put(com.fyber.inneractive.sdk.config.global.features.e.class, new com.fyber.inneractive.sdk.config.global.features.e());
        map.put(s.class, new s());
        map.put(com.fyber.inneractive.sdk.config.global.features.i.class, new com.fyber.inneractive.sdk.config.global.features.i());
        map.put(com.fyber.inneractive.sdk.config.global.features.j.class, new com.fyber.inneractive.sdk.config.global.features.j());
        map.put(com.fyber.inneractive.sdk.config.global.features.r.class, new com.fyber.inneractive.sdk.config.global.features.r());
        map.put(com.fyber.inneractive.sdk.config.global.features.o.class, new com.fyber.inneractive.sdk.config.global.features.o());
        map.put(com.fyber.inneractive.sdk.config.global.features.c.class, new com.fyber.inneractive.sdk.config.global.features.c());
        map.put(com.fyber.inneractive.sdk.config.global.features.n.class, new com.fyber.inneractive.sdk.config.global.features.n());
        map.put(com.fyber.inneractive.sdk.config.global.features.b.class, new com.fyber.inneractive.sdk.config.global.features.b());
        map.put(com.fyber.inneractive.sdk.config.global.features.g.class, new com.fyber.inneractive.sdk.config.global.features.g());
        map.put(com.fyber.inneractive.sdk.config.global.features.k.class, new com.fyber.inneractive.sdk.config.global.features.k());
        this.b = map;
        this.c = null;
        HashMap map2 = new HashMap();
        for (Map.Entry entry : map.entrySet()) {
            map2.put((Class) entry.getKey(), ((com.fyber.inneractive.sdk.config.global.features.h) entry.getValue()).c());
        }
        this.b = map2;
        IAlog.a("%s: created. Supported features: %s", "SupportedFeaturesProvider", map2);
    }

    public static r a() {
        int i = AbstractC3081k.f1710a;
        String property = System.getProperty("ia.testEnvironmentConfiguration.featuresConfig");
        boolean z = false;
        if (!TextUtils.isEmpty(property)) {
            try {
                IAConfigManager.O.z.f1695a = l.a(new JSONObject(property));
                z = true;
            } catch (Exception unused) {
                IAlog.a("failed parsing local features json", new Object[0]);
            }
        }
        r rVar = new r();
        if (z) {
            IAConfigManager iAConfigManager = IAConfigManager.O;
            iAConfigManager.M.a(true, "");
            iAConfigManager.E.a(iAConfigManager.M);
        }
        return rVar;
    }

    public final JSONArray b() {
        JSONArray jSONArray = this.c;
        if (jSONArray == null || jSONArray.length() == 0) {
            JSONArray jSONArrayA = g.a(this.b, false);
            this.c = jSONArrayA;
            IAlog.a("%s: active experiments json set = %s", "SupportedFeaturesProvider", jSONArrayA);
        }
        return this.c;
    }

    public final void a(e eVar) {
        for (com.fyber.inneractive.sdk.config.global.features.h hVar : this.b.values()) {
            hVar.getClass();
            ArrayList arrayList = new ArrayList(hVar.c.values());
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                b bVar = (b) arrayList.get(size);
                ArrayList<d> arrayList2 = bVar.d;
                if (arrayList2 != null) {
                    for (d dVar : arrayList2) {
                        if (dVar.a(eVar)) {
                            hVar.c.remove(bVar.f1696a);
                            hVar.d.remove(bVar.f1696a);
                            this.c = null;
                            IAlog.a("%s: Experiment %s filtered! after response %s", "SupportedFeaturesProvider", bVar.f1696a, dVar);
                            break;
                        }
                    }
                }
            }
        }
    }

    public final com.fyber.inneractive.sdk.config.global.features.h a(Class cls) {
        if (this.b.containsKey(cls)) {
            com.fyber.inneractive.sdk.config.global.features.h hVar = (com.fyber.inneractive.sdk.config.global.features.h) this.b.get(cls);
            if (cls.isInstance(hVar)) {
                return hVar;
            }
        }
        try {
            return (com.fyber.inneractive.sdk.config.global.features.h) cls.getConstructor(null).newInstance(null);
        } catch (Exception e) {
            IAlog.a("Couldn't create a feature for %s", e, cls.getName());
            return null;
        }
    }

    public final void a(boolean z, String str) {
        k kVar;
        this.f1707a = str;
        a aVar = IAConfigManager.O.z;
        aVar.b = this;
        for (com.fyber.inneractive.sdk.config.global.features.h hVar : this.b.values()) {
            boolean z2 = hVar instanceof com.fyber.inneractive.sdk.config.global.features.p;
            if ((z2 && z) || (!z2 && !z)) {
                l lVar = aVar.f1695a;
                if (hVar != null && lVar != null) {
                    q qVar = (q) lVar.f1704a.get(hVar.b);
                    if (qVar != null) {
                        hVar.f1706a = qVar.f1706a;
                        IAlog.a("%s: Feature before variant merge: %s", "a", hVar);
                        HashMap map = qVar.c;
                        Iterator it = map.keySet().iterator();
                        while (it.hasNext()) {
                            b bVar = (b) map.get((String) it.next());
                            if (bVar != null) {
                                int iNextInt = new Random().nextInt(100) + 1;
                                if (bVar.b < iNextInt) {
                                    IAlog.a("%s: Experiment '%s' filtered! rand: %d, with perc: %d", "a", bVar.f1696a, Integer.valueOf(iNextInt), Integer.valueOf(bVar.b));
                                } else {
                                    ArrayList arrayList = bVar.d;
                                    if (arrayList != null) {
                                        Iterator it2 = arrayList.iterator();
                                        while (true) {
                                            if (it2.hasNext()) {
                                                d dVar = (d) it2.next();
                                                try {
                                                    Long lValueOf = Long.valueOf(IAConfigManager.O.d);
                                                    e eVar = new e();
                                                    eVar.b = lValueOf;
                                                    eVar.c = com.fyber.inneractive.sdk.serverapi.b.a(aVar.b.f1707a);
                                                    if (dVar.a(eVar)) {
                                                        IAlog.a("%s: Experiment '%s' filtered! with %s", "a", bVar.f1696a, dVar);
                                                    } else {
                                                        continue;
                                                    }
                                                } catch (NumberFormatException unused) {
                                                    IAlog.a("%s: invalid publisherId", "a");
                                                }
                                            }
                                        }
                                    }
                                    int i = 0;
                                    if (hVar instanceof w) {
                                        Iterator it3 = bVar.c.iterator();
                                        while (true) {
                                            if (it3.hasNext()) {
                                                k kVar2 = (k) it3.next();
                                                n nVar = kVar2.f1706a;
                                                if (nVar != null && nVar.b() != null && kVar2.f1706a.b().containsKey("use_fmp_cache_mechanism")) {
                                                    InterfaceC3258w interfaceC3258w = (InterfaceC3258w) IAConfigManager.O.J.get(EnumC3259x.Video);
                                                    if (!(interfaceC3258w != null ? interfaceC3258w.a() : false)) {
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    IAlog.a("%s: Experiment '%s' NOT filtered! rand: %d, with perc: %d", "a", bVar.f1696a, Integer.valueOf(iNextInt), Integer.valueOf(bVar.b));
                                    ArrayList arrayList2 = bVar.c;
                                    int iNextInt2 = new Random().nextInt(100) + 1;
                                    IAlog.a("%s: selectVariant for experiment '%s' generated random number: %d", "a", bVar.f1696a, Integer.valueOf(iNextInt2));
                                    Iterator it4 = arrayList2.iterator();
                                    while (true) {
                                        if (!it4.hasNext()) {
                                            kVar = null;
                                            break;
                                        }
                                        kVar = (k) it4.next();
                                        i += kVar.c;
                                        IAlog.a("%s: selectVariant variant found: %s", "a", kVar);
                                        if (i >= iNextInt2) {
                                            break;
                                        } else {
                                            IAlog.a("%s: selectVariant variant '%s' percentage outside selected range", "a", kVar.b);
                                        }
                                    }
                                    if (kVar != null) {
                                        IAlog.a("%s: experiment '%s' variant selected! %s", "a", bVar.f1696a, kVar);
                                    } else {
                                        IAlog.a("%s: experiment '%s' no variant was selected! using control group", "a", bVar.f1696a);
                                    }
                                    hVar.c.put(bVar.f1696a, bVar);
                                    if (kVar != null) {
                                        hVar.d.put(bVar.f1696a, kVar);
                                    }
                                }
                            }
                        }
                    }
                    IAlog.a("%s: Feature after variant merge: %s", "a", hVar);
                }
            }
        }
    }
}
