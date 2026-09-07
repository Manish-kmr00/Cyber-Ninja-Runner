package com.pubmatic.sdk.common.cache;

import com.pubmatic.sdk.common.log.POBLog;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public class POBCacheService {
    private static POBCacheService b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f7571a = Collections.synchronizedMap(new HashMap());

    private POBCacheService() {
    }

    public static synchronized POBCacheService getInstance() {
        if (b == null) {
            b = new POBCacheService();
        }
        return b;
    }

    public <T> Map<String, T> getService(String str) {
        Map<String, T> map;
        try {
            map = (Map) this.f7571a.get(str);
        } catch (Exception unused) {
            POBLog.error("POBCacheService", "Couldn't find cache for - %s", str);
            map = null;
        }
        if (map != null) {
            return map;
        }
        Map<String, T> mapSynchronizedMap = Collections.synchronizedMap(new HashMap());
        this.f7571a.put(str, mapSynchronizedMap);
        return mapSynchronizedMap;
    }
}
