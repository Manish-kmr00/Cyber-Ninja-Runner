package com.mbridge.msdk.foundation.tools;

import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: StringSetEncoder.java */
/* JADX INFO: loaded from: classes6.dex */
class x0 implements FastKV.b<Set<String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final x0 f5079a = new x0();

    private x0() {
    }

    @Override // com.mbridge.msdk.foundation.tools.FastKV.b
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Set<String> a(byte[] bArr, int i, int i2) {
        int i3;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (i2 > 0) {
            z zVar = new z(bArr, i);
            int i4 = i + i2;
            while (true) {
                i3 = zVar.b;
                if (i3 >= i4) {
                    break;
                }
                linkedHashSet.add(zVar.e(zVar.g()));
            }
            if (i3 != i4) {
                throw new IllegalArgumentException("Invalid String set");
            }
        }
        return linkedHashSet;
    }

    @Override // com.mbridge.msdk.foundation.tools.FastKV.b
    public byte[] a(Set<String> set) {
        if (set.isEmpty()) {
            return new byte[0];
        }
        int size = set.size();
        int[] iArr = new int[size];
        String[] strArr = new String[size];
        int iF = 0;
        int i = 0;
        for (String str : set) {
            if (str == null) {
                iF += 5;
                iArr[i] = -1;
            } else {
                int iB = z.b(str);
                strArr[i] = str;
                iArr[i] = iB;
                iF += z.f(iB) + iB;
            }
            i++;
        }
        z zVar = new z(iF);
        for (int i2 = 0; i2 < size; i2++) {
            int i3 = iArr[i2];
            zVar.h(i3);
            if (i3 >= 0) {
                zVar.c(strArr[i2]);
            }
        }
        return zVar.f5080a;
    }

    @Override // com.mbridge.msdk.foundation.tools.FastKV.b
    public String a() {
        return "StringSet";
    }
}
