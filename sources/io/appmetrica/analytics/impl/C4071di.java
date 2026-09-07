package io.appmetrica.analytics.impl;

import java.util.Map;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.di, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C4071di implements Pn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f11517a;

    public C4071di(Map<String, ?> map) {
        this.f11517a = map;
    }

    @Override // io.appmetrica.analytics.impl.Pn
    public final Nn a(String str) {
        return this.f11517a.containsKey(str) ? new Nn(this, false, String.format("Failed to activate AppMetrica with provided apiKey ApiKey %s has already been used by another reporter.", str)) : new Nn(this, true, "");
    }
}
