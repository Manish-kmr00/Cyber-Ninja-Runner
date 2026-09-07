package com.mbridge.msdk.mbnative.cache;

import com.mbridge.msdk.out.Campaign;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: NativeCacheFactory.java */
/* JADX INFO: loaded from: classes4.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<Integer, b<String, List<Campaign>>> f5183a = new HashMap();

    public static b<String, List<Campaign>> a(int i) {
        if (f5183a.containsKey(Integer.valueOf(i))) {
            return f5183a.get(Integer.valueOf(i));
        }
        a aVar = new a(i);
        f5183a.put(Integer.valueOf(i), aVar);
        return aVar;
    }
}
