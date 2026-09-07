package io.appmetrica.analytics.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class G7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Pa f11156a;
    public String b = "";

    public G7(Pa pa) {
        this.f11156a = pa;
    }

    public final void a(String str, boolean z) {
        if (str != null) {
            if ((str.length() > 0 ? str : null) == null || Intrinsics.areEqual(this.b, str)) {
                return;
            }
            this.b = str;
            this.f11156a.a(str, z);
        }
    }
}
