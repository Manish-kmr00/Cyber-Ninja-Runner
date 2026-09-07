package com.fyber.inneractive.sdk.ignite;

import com.fyber.inneractive.sdk.network.E;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes11.dex */
public final class f implements E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f1848a;

    public f(String str) {
        this.f1848a = str;
    }

    @Override // com.fyber.inneractive.sdk.network.E
    public final void a(Object obj, Exception exc, boolean z) {
        String str = (String) obj;
        IAlog.a("Hit Request: Hitting URL finished: %s", this.f1848a);
        if (exc == null) {
            IAlog.a("Hit Request: Hitting URL response code: %s", str);
        } else {
            IAlog.a("Hit Request: Hitting URL failed: %s", exc);
        }
    }
}
