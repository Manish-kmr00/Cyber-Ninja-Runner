package com.fyber.inneractive.sdk.protobuf;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.protobuf.z0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3236z0 extends LinkedHashMap {
    public static final C3236z0 b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2306a;

    static {
        C3236z0 c3236z0 = new C3236z0();
        b = c3236z0;
        c3236z0.f2306a = false;
    }

    public C3236z0() {
        this.f2306a = true;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void clear() {
        if (!this.f2306a) {
            throw new UnsupportedOperationException();
        }
        super.clear();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (this != map) {
                if (size() == map.size()) {
                    for (Map.Entry entry : entrySet()) {
                        if (map.containsKey(entry.getKey())) {
                            Object value = entry.getValue();
                            Object obj2 = map.get(entry.getKey());
                            if (!(((value instanceof byte[]) && (obj2 instanceof byte[])) ? Arrays.equals((byte[]) value, (byte[]) obj2) : value.equals(obj2))) {
                            }
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int iHashCode;
        int i = 0;
        for (Map.Entry entry : entrySet()) {
            Object key = entry.getKey();
            int iHashCode2 = 1;
            if (key instanceof byte[]) {
                byte[] bArr = (byte[]) key;
                Charset charset = AbstractC3205m0.f2291a;
                iHashCode = bArr.length;
                for (byte b2 : bArr) {
                    iHashCode = (iHashCode * 31) + b2;
                }
                if (iHashCode == 0) {
                    iHashCode = 1;
                }
            } else {
                if (key instanceof InterfaceC3181e0) {
                    throw new UnsupportedOperationException();
                }
                iHashCode = key.hashCode();
            }
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                byte[] bArr2 = (byte[]) value;
                Charset charset2 = AbstractC3205m0.f2291a;
                int length = bArr2.length;
                for (byte b3 : bArr2) {
                    length = (length * 31) + b3;
                }
                if (length != 0) {
                    iHashCode2 = length;
                }
            } else {
                if (value instanceof InterfaceC3181e0) {
                    throw new UnsupportedOperationException();
                }
                iHashCode2 = value.hashCode();
            }
            i += iHashCode ^ iHashCode2;
        }
        return i;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        if (!this.f2306a) {
            throw new UnsupportedOperationException();
        }
        Charset charset = AbstractC3205m0.f2291a;
        obj.getClass();
        obj2.getClass();
        return super.put(obj, obj2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map map) {
        if (!this.f2306a) {
            throw new UnsupportedOperationException();
        }
        for (Object obj : map.keySet()) {
            Charset charset = AbstractC3205m0.f2291a;
            obj.getClass();
            map.get(obj).getClass();
        }
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        if (this.f2306a) {
            return super.remove(obj);
        }
        throw new UnsupportedOperationException();
    }

    public C3236z0(Map map) {
        super(map);
        this.f2306a = true;
    }
}
