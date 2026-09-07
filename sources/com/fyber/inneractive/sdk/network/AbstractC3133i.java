package com.fyber.inneractive.sdk.network;

import com.fyber.inneractive.sdk.util.IAlog;
import java.io.BufferedInputStream;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.network.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractC3133i {
    public static FilterInputStream a(InputStream inputStream, boolean z) {
        FilterInputStream bufferedInputStream;
        try {
            if (z) {
                IAlog.a("HttpExecutorBase: getInputStream found gzip encoding", new Object[0]);
                bufferedInputStream = new GZIPInputStream(inputStream);
            } else {
                IAlog.a("HttpExecutorBase: getInputStream no gzip encoding", new Object[0]);
                bufferedInputStream = new BufferedInputStream(inputStream);
            }
            return bufferedInputStream;
        } catch (Exception unused) {
            return null;
        }
    }

    public static C3136l a(FilterInputStream filterInputStream, int i, String str, Map map, String str2) throws C3126b, q0 {
        try {
            C3136l c3136l = new C3136l(filterInputStream, i, str, map, str2);
            if (c3136l.f1924a / 100 != 5) {
                return c3136l;
            }
            throw new C3126b(String.format("server returned error %d", Integer.valueOf(c3136l.f1924a)));
        } catch (C3126b e) {
            IAlog.a("failed executing network request", e, new Object[0]);
            throw new C3126b(e);
        } catch (Exception e2) {
            IAlog.a("failed reading network response", e2, new Object[0]);
            throw new q0(e2);
        }
    }
}
