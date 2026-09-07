package com.fyber.inneractive.sdk.network;

import com.fyber.inneractive.sdk.util.IAlog;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.network.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C3147x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f1935a = new JSONObject();

    public final C3147x a(Object obj, String str) {
        try {
            this.f1935a.put(str, obj);
        } catch (Exception unused) {
            IAlog.f("Got exception adding param to json object: %s, %s", str, obj);
        }
        return this;
    }
}
