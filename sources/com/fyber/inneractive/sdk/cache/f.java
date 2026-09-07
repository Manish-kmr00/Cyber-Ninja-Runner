package com.fyber.inneractive.sdk.cache;

import com.fyber.inneractive.sdk.network.E;

/* JADX INFO: loaded from: classes11.dex */
public final class f implements E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f1637a;

    public f(i iVar) {
        this.f1637a = iVar;
    }

    @Override // com.fyber.inneractive.sdk.network.E
    public final void a(Object obj, Exception exc, boolean z) {
        String str = (String) obj;
        if (str != null) {
            this.f1637a.b = str;
        }
    }
}
