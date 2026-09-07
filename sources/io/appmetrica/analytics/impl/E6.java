package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
import io.appmetrica.analytics.internal.IdentifiersResult;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class E6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4522vl f11117a = new C4522vl();
    public Map b = MapsKt.emptyMap();
    public Map c = MapsKt.emptyMap();
    public IdentifiersResult d;

    public final synchronized void a(IdentifiersResult identifiersResult) {
        HashMap map;
        Map mapEmptyMap;
        List listA;
        String str;
        IdentifiersResult identifiersResult2 = this.d;
        String str2 = identifiersResult2 != null ? identifiersResult2.id : null;
        if (str2 == null || str2.length() == 0 || ((str = identifiersResult.id) != null && str.length() != 0)) {
            this.d = identifiersResult;
            String str3 = identifiersResult.id;
            if (str3 == null) {
                map = null;
            } else {
                map = new HashMap();
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        try {
                            ArrayList arrayListA = AbstractC4288mb.a(new JSONArray(jSONObject.optString(next)));
                            if (arrayListA != null) {
                                map.put(next, arrayListA);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
            if (map != null) {
                mapEmptyMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
                for (Map.Entry entry : map.entrySet()) {
                    Object key = entry.getKey();
                    List list = (List) entry.getValue();
                    mapEmptyMap.put(key, new IdentifiersResult(String.valueOf(In.a((Collection) list) ? null : new JSONArray((Collection) list)), identifiersResult.status, identifiersResult.errorExplanation));
                }
            } else {
                mapEmptyMap = MapsKt.emptyMap();
            }
            this.c = mapEmptyMap;
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(mapEmptyMap.size()));
            for (Map.Entry entry2 : mapEmptyMap.entrySet()) {
                Object key2 = entry2.getKey();
                String str4 = ((IdentifiersResult) entry2.getValue()).id;
                if (str4 == null) {
                    listA = null;
                } else {
                    try {
                        listA = AbstractC4288mb.a(new JSONArray(str4));
                    } catch (Throwable unused3) {
                        listA = null;
                    }
                }
                if (listA == null) {
                    listA = CollectionsKt.emptyList();
                }
                linkedHashMap.put(key2, listA);
            }
            this.b = linkedHashMap;
        }
    }

    public final synchronized void a(List list, HashMap map) {
        IdentifierStatus identifierStatus;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            List list2 = (List) this.b.get(str);
            if (list2 != null && !list2.isEmpty()) {
                linkedHashMap.put(str, list2);
            }
        }
        C4522vl c4522vl = this.f11117a;
        String strA = AbstractC4288mb.a((Map) linkedHashMap);
        IdentifiersResult identifiersResult = this.d;
        if (identifiersResult == null || (identifierStatus = identifiersResult.status) == null) {
            identifierStatus = IdentifierStatus.UNKNOWN;
        }
        map.put("appmetrica_custom_sdk_hosts", c4522vl.a(new IdentifiersResult(strA, identifierStatus, identifiersResult != null ? identifiersResult.errorExplanation : null)));
    }
}
