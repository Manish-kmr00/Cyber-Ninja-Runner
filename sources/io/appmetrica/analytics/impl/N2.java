package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences;

/* JADX INFO: loaded from: classes5.dex */
public abstract class N2 implements ModulePreferences {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Wk f11263a;

    public N2(Wk wk) {
        this.f11263a = wk;
    }

    public abstract String a(String str);

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final boolean getBoolean(String str, boolean z) {
        return ((AbstractC4564xd) this.f11263a).c(str, z);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final int getInt(String str, int i) {
        return ((AbstractC4564xd) this.f11263a).c(str, i);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final long getLong(String str, long j) {
        return ((AbstractC4564xd) this.f11263a).c(a(str), j);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final String getString(String str, String str2) {
        return ((AbstractC4564xd) this.f11263a).c(a(str), str2);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final void putBoolean(String str, boolean z) {
        AbstractC4564xd abstractC4564xd = (AbstractC4564xd) this.f11263a;
        ((Me) ((Wk) abstractC4564xd.b(abstractC4564xd.f(a(str)), z))).b();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final void putInt(String str, int i) {
        AbstractC4564xd abstractC4564xd = (AbstractC4564xd) this.f11263a;
        ((Me) ((Wk) abstractC4564xd.b(abstractC4564xd.f(str), i))).b();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final void putLong(String str, long j) {
        AbstractC4564xd abstractC4564xd = (AbstractC4564xd) this.f11263a;
        ((Me) ((Wk) abstractC4564xd.b(abstractC4564xd.f(a(str)), j))).b();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final void putString(String str, String str2) {
        AbstractC4564xd abstractC4564xd = (AbstractC4564xd) this.f11263a;
        ((Me) ((Wk) abstractC4564xd.b(abstractC4564xd.f(a(str)), str2))).b();
    }
}
