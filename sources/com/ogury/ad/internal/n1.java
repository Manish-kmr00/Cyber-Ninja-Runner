package com.ogury.ad.internal;

import com.google.common.net.HttpHeaders;
import com.ogury.core.internal.network.HeadersLoader;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class n1 implements HeadersLoader {
    @Override // com.ogury.core.internal.network.HeadersLoader
    public Map<String, String> loadHeaders() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("Content-Type", "application/json");
        linkedHashMap.put(HttpHeaders.ACCEPT_ENCODING, "gzip");
        linkedHashMap.put("Content-Encoding", "gzip");
        return linkedHashMap;
    }
}
