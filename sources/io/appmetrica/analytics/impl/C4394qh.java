package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.qh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4394qh extends Yg {
    public C4394qh(L6 l6) {
        super(l6);
    }

    @Override // io.appmetrica.analytics.impl.Yg, io.appmetrica.analytics.impl.Zg
    public final boolean a(Boolean bool) {
        return !this.f11438a.isRestrictedForReporter() && ((Boolean) WrapUtils.getOrDefault(bool, Boolean.TRUE)).booleanValue();
    }
}
