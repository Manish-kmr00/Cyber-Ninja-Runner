package com.fyber.inneractive.sdk.cache.session;

import java.util.HashMap;

/* JADX INFO: loaded from: classes11.dex */
public final class h extends HashMap {
    public h() {
        for (com.fyber.inneractive.sdk.cache.session.enums.c cVar : com.fyber.inneractive.sdk.cache.session.enums.c.values()) {
            if (cVar != com.fyber.inneractive.sdk.cache.session.enums.c.NONE) {
                put(cVar, new g(0, 0, 0, System.currentTimeMillis()));
            }
        }
    }
}
