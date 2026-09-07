package com.yandex.mobile.ads.impl;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class kz {
    public static final kz c = new kz(Collections.emptyMap());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9462a;
    private final Map<String, byte[]> b;

    public final long b() {
        byte[] bArr = this.b.get("exo_len");
        if (bArr != null) {
            return ByteBuffer.wrap(bArr).getLong();
        }
        return -1L;
    }

    public final String c() {
        byte[] bArr = this.b.get("exo_redir");
        if (bArr != null) {
            return new String(bArr, ko.c);
        }
        return null;
    }

    public kz() {
        this(Collections.emptyMap());
    }

    public final kz a(bs bsVar) {
        byte[] bytes;
        HashMap map = new HashMap(this.b);
        List<String> listB = bsVar.b();
        for (int i = 0; i < listB.size(); i++) {
            map.remove(listB.get(i));
        }
        for (Map.Entry<String, Object> entry : bsVar.a().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Long) {
                bytes = ByteBuffer.allocate(8).putLong(((Long) value).longValue()).array();
            } else if (value instanceof String) {
                bytes = ((String) value).getBytes(ko.c);
            } else if (value instanceof byte[]) {
                bytes = (byte[]) value;
            } else {
                throw new IllegalArgumentException();
            }
            map.put(key, bytes);
        }
        Map<String, byte[]> map2 = this.b;
        if (map2.size() == map.size()) {
            for (Map.Entry<String, byte[]> entry2 : map2.entrySet()) {
                if (!Arrays.equals(entry2.getValue(), (byte[]) map.get(entry2.getKey()))) {
                }
            }
            return this;
        }
        return new kz(map);
    }

    public kz(Map<String, byte[]> map) {
        this.b = Collections.unmodifiableMap(map);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || kz.class != obj.getClass()) {
            return false;
        }
        Map<String, byte[]> map = this.b;
        Map<String, byte[]> map2 = ((kz) obj).b;
        if (map.size() == map2.size()) {
            for (Map.Entry<String, byte[]> entry : map.entrySet()) {
                if (!Arrays.equals(entry.getValue(), map2.get(entry.getKey()))) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        if (this.f9462a == 0) {
            int iHashCode = 0;
            for (Map.Entry<String, byte[]> entry : this.b.entrySet()) {
                iHashCode += Arrays.hashCode(entry.getValue()) ^ entry.getKey().hashCode();
            }
            this.f9462a = iHashCode;
        }
        return this.f9462a;
    }

    public final Set<Map.Entry<String, byte[]>> a() {
        return this.b.entrySet();
    }
}
