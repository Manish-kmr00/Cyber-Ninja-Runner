package com.fyber.inneractive.sdk.measurement;

import com.fyber.inneractive.sdk.network.E;

/* JADX INFO: loaded from: classes12.dex */
public final class c implements E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f1857a;

    public c(e eVar) {
        this.f1857a = eVar;
    }

    @Override // com.fyber.inneractive.sdk.network.E
    public final void a(Object obj, Exception exc, boolean z) {
        String str = (String) obj;
        if (str != null) {
            this.f1857a.d = str;
        }
    }
}
