package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes13.dex */
public final class Ca extends M2 {
    public final C4611za b;
    public final C4611za c;
    public final Ba d;

    public Ca(int i, int i2, int i3) {
        this(i, new C4611za(i2), new C4611za(i3));
    }

    public Ca(int i, C4611za c4611za, C4611za c4611za2) {
        super(i);
        this.d = new Ba();
        this.b = c4611za;
        this.c = c4611za2;
    }

    @Override // io.appmetrica.analytics.impl.M2, io.appmetrica.analytics.impl.Aa
    public final C4225jn a(Map<String, String> map) {
        HashMap map2;
        int bytesTruncated;
        int i = 0;
        if (map != null) {
            map2 = new HashMap();
            Set<Map.Entry<String, String>> setEntrySet = map.entrySet();
            Map.Entry[] entryArr = (Map.Entry[]) setEntrySet.toArray(new Map.Entry[setEntrySet.size()]);
            Arrays.sort(entryArr, this.d);
            int length = entryArr.length;
            bytesTruncated = 0;
            int i2 = 0;
            boolean z = false;
            int i3 = 0;
            while (i < length) {
                Map.Entry entry = entryArr[i];
                C4225jn c4225jnA = this.b.a((String) entry.getKey());
                C4225jn c4225jnA2 = this.c.a((String) entry.getValue());
                int utf8BytesLength = StringUtils.getUtf8BytesLength((String) entry.getValue()) + StringUtils.getUtf8BytesLength((String) entry.getKey());
                int utf8BytesLength2 = StringUtils.getUtf8BytesLength((String) c4225jnA2.f11624a) + StringUtils.getUtf8BytesLength((String) c4225jnA.f11624a);
                if (z || utf8BytesLength2 + i3 > this.f11252a) {
                    i2++;
                    bytesTruncated += utf8BytesLength;
                    z = true;
                } else {
                    bytesTruncated = c4225jnA2.b.getBytesTruncated() + c4225jnA.b.getBytesTruncated() + bytesTruncated;
                    int utf8BytesLength3 = StringUtils.getUtf8BytesLength((String) c4225jnA2.f11624a) + StringUtils.getUtf8BytesLength((String) c4225jnA.f11624a) + i3;
                    map2.put((String) c4225jnA.f11624a, (String) c4225jnA2.f11624a);
                    i3 = utf8BytesLength3;
                }
                i++;
            }
            i = i2;
        } else {
            map2 = null;
            bytesTruncated = 0;
        }
        return new C4225jn(map2, new E4(i, bytesTruncated));
    }
}
