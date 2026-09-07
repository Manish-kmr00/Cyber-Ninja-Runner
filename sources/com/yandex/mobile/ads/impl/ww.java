package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class ww {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10597a;
    private final int b;
    private final int c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ww)) {
            return false;
        }
        ww wwVar = (ww) obj;
        return Intrinsics.areEqual(this.f10597a, wwVar.f10597a) && this.b == wwVar.b && this.c == wwVar.c;
    }

    public final int hashCode() {
        return Integer.hashCode(this.c) + wx1.a(this.b, this.f10597a.hashCode() * 31, 31);
    }

    public final String toString() {
        return "DebugPanelColoredText(text=" + this.f10597a + ", color=" + this.b + ", style=" + this.c + ")";
    }

    public ww(int i, int i2, String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.f10597a = text;
        this.b = i;
        this.c = i2;
    }

    public final String c() {
        return this.f10597a;
    }

    public final int a() {
        return this.b;
    }

    public final int b() {
        return this.c;
    }

    public /* synthetic */ ww(String str, int i) {
        this(i, R.style.DebugPanelText_Body2, str);
    }
}
