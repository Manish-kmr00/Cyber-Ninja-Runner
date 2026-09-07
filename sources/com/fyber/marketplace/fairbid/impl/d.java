package com.fyber.marketplace.fairbid.impl;

import com.fyber.inneractive.sdk.network.InterfaceC3139o;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class d implements InterfaceC3139o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map f2433a;
    public final /* synthetic */ String b;

    public d(Map map, String str) {
        this.f2433a = map;
        this.b = str;
    }

    @Override // com.fyber.inneractive.sdk.network.InterfaceC3139o
    public final StringBuffer a() {
        return new StringBuffer(this.b);
    }

    @Override // com.fyber.inneractive.sdk.network.InterfaceC3139o
    public final Map b() {
        return this.f2433a;
    }
}
