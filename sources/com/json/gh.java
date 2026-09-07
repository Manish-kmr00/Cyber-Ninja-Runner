package com.json;

import com.json.sdk.utils.SDKUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes10.dex */
public class gh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<String, Object> f3723a = new HashMap<>();

    public gh a(String str, Object obj) {
        if (obj != null) {
            this.f3723a.put(str, SDKUtils.encodeString(obj.toString()));
        }
        return this;
    }

    public HashMap<String, Object> a() {
        return this.f3723a;
    }
}
