package com.fyber.inneractive.sdk.network;

import com.fyber.inneractive.sdk.util.IAlog;
import org.json.JSONArray;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.network.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C3129e implements E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f1920a;
    public final /* synthetic */ JSONArray b;
    public final /* synthetic */ long c;

    public C3129e(String str, JSONArray jSONArray, long j) {
        this.f1920a = str;
        this.b = jSONArray;
        this.c = j;
    }

    @Override // com.fyber.inneractive.sdk.network.E
    public final void a(Object obj, Exception exc, boolean z) {
        String str = (String) obj;
        IAlog.a("Event Request: Hitting URL finished: %s, body: %s", this.f1920a, this.b);
        if (exc == null) {
            IAlog.a("Event Request: Hitting URL response code: %s", str);
        } else {
            IAlog.a("Event Request: Hitting URL failed: %s", exc);
        }
        IAlog.a("Event Request: Url hit took %s millis", Long.valueOf(System.currentTimeMillis() - this.c));
    }
}
