package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes13.dex */
public final class tc1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10286a;
    public final byte[] b;
    public final Map<String, String> c;
    public final List<hf0> d;
    public final boolean e;

    @Deprecated
    public tc1() {
        throw null;
    }

    private tc1(int i, byte[] bArr, Map map, List list, boolean z) {
        this.f10286a = i;
        this.b = bArr;
        this.c = map;
        if (list == null) {
            this.d = null;
        } else {
            this.d = Collections.unmodifiableList(list);
        }
        this.e = z;
    }

    @Deprecated
    public tc1(int i, byte[] bArr, Map map, boolean z) {
        this(i, bArr, map, a((Map<String, String>) map), z);
    }

    public tc1(int i, byte[] bArr, boolean z, long j, List<hf0> list) {
        this(i, bArr, a(list), list, z);
    }

    private static List<hf0> a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        if (map.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(new hf0(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }

    private static Map<String, String> a(List<hf0> list) {
        if (list == null) {
            return null;
        }
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (hf0 hf0Var : list) {
            treeMap.put(hf0Var.a(), hf0Var.b());
        }
        return treeMap;
    }
}
