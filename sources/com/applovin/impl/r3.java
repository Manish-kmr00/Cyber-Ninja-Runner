package com.applovin.impl;

import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class r3 {
    private static final HashMap d = new HashMap();
    private static final Object e = new Object();
    private static final HashMap f = new HashMap();
    private static final Object g = new Object();
    private static final HashMap h = new LinkedHashMap();
    private static final Object i = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.k f604a;
    private final JSONObject b = a(o3.h8);
    private final JSONObject c = a(o3.g8);

    public r3(com.applovin.impl.sdk.k kVar) {
        this.f604a = kVar;
        a((String) y4.a(x4.J, (Object) null, com.applovin.impl.sdk.k.o()), q3.a.AD_UNIT_ID);
        a((String) y4.a(x4.K, (Object) null, com.applovin.impl.sdk.k.o()), q3.a.AD_FORMAT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long a(Long l, Long l2) {
        return l;
    }

    private JSONObject a(v4 v4Var) {
        return JsonUtils.jsonObjectFromJsonString((String) this.f604a.a(v4Var), new JSONObject());
    }

    private Map b(p3 p3Var, q3 q3Var, p3.b bVar) {
        if (!a(p3Var, q3Var, bVar) || !b(p3Var, q3Var)) {
            return null;
        }
        String strB = q3Var.b();
        HashMap mapA = a(q3Var.a());
        Object objB = b(q3Var.a());
        HashMap map = new HashMap();
        synchronized (objB) {
            if (q3Var instanceof n3) {
                a((n3) q3Var, mapA);
            }
            HashMap map2 = (HashMap) mapA.get(strB);
            if (map2 == null) {
                map2 = new HashMap();
                mapA.put(strB, map2);
            }
            Iterator it = p3Var.b().iterator();
            while (it.hasNext()) {
                String strB2 = ((p3.a) it.next()).b();
                HashMap map3 = (HashMap) map2.get(strB2);
                if (map3 == null) {
                    map3 = new HashMap();
                    map2.put(strB2, map3);
                }
                Object objA = bVar.a(map3.get(p3Var));
                map3.put(p3Var, objA);
                map.put(strB2, objA);
            }
        }
        Boolean bool = (Boolean) this.f604a.a(o3.j8);
        if (p3Var.a(p3.a.INSTALL) && bool.booleanValue()) {
            b(q3Var);
        }
        return map;
    }

    private x4 c(q3.a aVar) {
        if (aVar == q3.a.AD_UNIT_ID) {
            return x4.J;
        }
        if (aVar == q3.a.AD_FORMAT) {
            return x4.K;
        }
        return null;
    }

    public Map a(p3 p3Var, q3 q3Var) {
        return b(p3Var, q3Var, new p3.b() { // from class: com.applovin.impl.r3$$ExternalSyntheticLambda0
            @Override // com.applovin.impl.p3.b
            public final Object a(Object obj) {
                return r3.a((Long) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long a(Long l) {
        return Long.valueOf(l != null ? 1 + l.longValue() : 1L);
    }

    public void a(p3 p3Var, q3 q3Var, final Long l) {
        b(p3Var, q3Var, new p3.b() { // from class: com.applovin.impl.r3$$ExternalSyntheticLambda1
            @Override // com.applovin.impl.p3.b
            public final Object a(Object obj) {
                return r3.a(l, (Long) obj);
            }
        });
    }

    public Map a(p3 p3Var, q3.a aVar) {
        return a(p3Var, aVar, p3.a.SESSION);
    }

    private Map a(p3 p3Var, q3.a aVar, p3.a aVar2) {
        HashMap mapA = a(aVar);
        Object objB = b(aVar);
        HashMap map = new HashMap();
        synchronized (objB) {
            for (String str : mapA.keySet()) {
                HashMap map2 = (HashMap) mapA.get(str);
                String strB = aVar2.b();
                if (map2 != null && map2.containsKey(strB)) {
                    HashMap map3 = (HashMap) map2.get(strB);
                    if (aVar == q3.a.AD) {
                        map.put(g3.a(str).b(), map3.get(p3Var));
                    } else {
                        map.put(str, map3.get(p3Var));
                    }
                }
            }
        }
        return map;
    }

    private void a(n3 n3Var, Map map) {
        MaxAdFormat maxAdFormatA = n3Var.c().a();
        Integer integer = JsonUtils.getInteger(this.c, maxAdFormatA.getLabel(), null);
        if (integer == null) {
            return;
        }
        Iterator it = map.keySet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (g3.a((String) it.next()).a().equals(maxAdFormatA)) {
                i2++;
            }
        }
        if (i2 < integer.intValue()) {
            return;
        }
        Iterator it2 = map.entrySet().iterator();
        while (it2.hasNext() && i2 >= integer.intValue()) {
            if (g3.a((String) ((Map.Entry) it2.next()).getKey()).a().equals(maxAdFormatA)) {
                it2.remove();
                i2--;
            }
        }
    }

    private Object b(q3.a aVar) {
        if (aVar == q3.a.AD_UNIT_ID) {
            return e;
        }
        if (aVar == q3.a.AD_FORMAT) {
            return g;
        }
        return i;
    }

    private boolean b(p3 p3Var, q3 q3Var) {
        Iterator<String> itKeys = this.b.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (next.equals(q3Var.a().toString().toLowerCase()) && JsonUtils.valueExists(JsonUtils.getJSONArray(this.b, next, new JSONArray()), p3Var.a())) {
                return false;
            }
        }
        return true;
    }

    private HashMap a(q3.a aVar) {
        if (aVar == q3.a.AD_UNIT_ID) {
            return d;
        }
        if (aVar == q3.a.AD_FORMAT) {
            return f;
        }
        return h;
    }

    private void b(q3 q3Var) {
        x4 x4VarC = c(q3Var.a());
        if (x4VarC == null) {
            return;
        }
        y4.b(x4VarC, a((Map) a(q3Var)), com.applovin.impl.sdk.k.o());
    }

    private boolean a(p3 p3Var, q3 q3Var, p3.b bVar) {
        if (p3Var == null) {
            this.f604a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f604a.O().b("MediationStatsManager", "Failed to update stat, no stat provided");
            }
            return false;
        }
        if (q3Var == null) {
            this.f604a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f604a.O().b("MediationStatsManager", "Failed to update stat, no dimension key provided");
            }
            return false;
        }
        if (bVar != null) {
            return true;
        }
        this.f604a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f604a.O().b("MediationStatsManager", "Failed to update stat, no stat updater provided");
        }
        return false;
    }

    private HashMap a(q3 q3Var) {
        HashMap map = new HashMap();
        HashMap mapA = a(q3Var.a());
        synchronized (b(q3Var.a())) {
            for (Map.Entry entry : mapA.entrySet()) {
                String str = (String) entry.getKey();
                HashMap map2 = (HashMap) entry.getValue();
                if (!CollectionUtils.isEmpty(map2)) {
                    HashMap map3 = (HashMap) map2.get(p3.a.INSTALL.b());
                    if (!CollectionUtils.isEmpty(map3)) {
                        map.put(str, new HashMap(map3));
                    }
                }
            }
        }
        return map;
    }

    private String a(Map map) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : map.entrySet()) {
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry entry2 : ((HashMap) entry.getValue()).entrySet()) {
                p3 p3Var = (p3) entry2.getKey();
                Object value = entry2.getValue();
                if (value != null) {
                    JsonUtils.putObject(jSONObject2, p3Var.toString(), value);
                }
            }
            JsonUtils.putJSONObject(jSONObject, (String) entry.getKey(), jSONObject2);
        }
        return jSONObject.toString();
    }

    private void a(String str, q3.a aVar) {
        if (StringUtils.isValidString(str)) {
            HashMap mapA = a(aVar);
            Object objB = b(aVar);
            Map<String, Object> stringObjectMap = JsonUtils.toStringObjectMap(str);
            synchronized (objB) {
                for (Map.Entry<String, Object> entry : stringObjectMap.entrySet()) {
                    String key = entry.getKey();
                    HashMap map = new HashMap();
                    for (Map.Entry entry2 : ((Map) entry.getValue()).entrySet()) {
                        p3 p3VarA = p3.a((String) entry2.getKey());
                        if (p3VarA != null) {
                            map.put(p3VarA, a(entry2.getValue()));
                        }
                    }
                    if (!CollectionUtils.isEmpty(map)) {
                        HashMap map2 = new HashMap();
                        map2.put(p3.a.INSTALL.b(), map);
                        mapA.put(key, map2);
                    }
                }
            }
        }
    }

    private Object a(Object obj) {
        return obj instanceof Integer ? Long.valueOf(((Integer) obj).longValue()) : obj;
    }
}
