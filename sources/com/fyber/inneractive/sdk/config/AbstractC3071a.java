package com.fyber.inneractive.sdk.config;

import com.fyber.inneractive.sdk.util.IAlog;
import java.util.HashMap;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.config.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public abstract class AbstractC3071a {
    public static T a(String str) {
        IAConfigManager iAConfigManager = IAConfigManager.O;
        HashMap map = iAConfigManager.b;
        if (map != null && map.containsKey(str)) {
            return (T) iAConfigManager.b.get(str);
        }
        IAlog.c("Requested unit config doesn't exists - %s", str);
        return null;
    }
}
