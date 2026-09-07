package io.appmetrica.analytics.impl;

import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class Ej implements Xa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f11125a;
    public final /* synthetic */ Map b;

    public Ej(String str, Map map) {
        this.f11125a = str;
        this.b = map;
    }

    @Override // io.appmetrica.analytics.impl.Xa
    public final void a(Ya ya) {
        ya.reportEvent(this.f11125a, this.b);
    }
}
