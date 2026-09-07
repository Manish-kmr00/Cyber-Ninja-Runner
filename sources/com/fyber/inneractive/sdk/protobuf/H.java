package com.fyber.inneractive.sdk.protobuf;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public final class H {
    public static volatile H b;
    public static final H c = new H();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f2257a = Collections.emptyMap();

    public static H a() {
        H h = b;
        if (h == null) {
            synchronized (H.class) {
                h = b;
                if (h == null) {
                    Class cls = F.f2254a;
                    H h2 = null;
                    if (cls != null) {
                        try {
                            h2 = (H) cls.getDeclaredMethod("getEmptyRegistry", null).invoke(null, null);
                        } catch (Exception unused) {
                        }
                    }
                    if (h2 == null) {
                        h2 = c;
                    }
                    b = h2;
                    h = h2;
                }
            }
        }
        return h;
    }

    public final Y a(int i, E0 e0) {
        return (Y) this.f2257a.get(new G(i, e0));
    }
}
