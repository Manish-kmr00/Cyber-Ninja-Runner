package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class jp implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9342a;

    public jp(String actionType) {
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        this.f9342a = actionType;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof jp) && Intrinsics.areEqual(this.f9342a, ((jp) obj).f9342a);
    }

    public final int hashCode() {
        return this.f9342a.hashCode();
    }

    public final String toString() {
        return "CloseAction(actionType=" + this.f9342a + ")";
    }

    @Override // com.yandex.mobile.ads.impl.x
    public final String a() {
        return this.f9342a;
    }
}
