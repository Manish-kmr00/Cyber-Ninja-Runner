package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class yx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10777a;
    private final int b;
    private final Integer c;
    private final int d;

    public yx(String text, int i, Integer num, int i2) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.f10777a = text;
        this.b = i;
        this.c = num;
        this.d = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof yx)) {
            return false;
        }
        yx yxVar = (yx) obj;
        return Intrinsics.areEqual(this.f10777a, yxVar.f10777a) && this.b == yxVar.b && Intrinsics.areEqual(this.c, yxVar.c) && this.d == yxVar.d;
    }

    public final int hashCode() {
        int iA = wx1.a(this.b, this.f10777a.hashCode() * 31, 31);
        Integer num = this.c;
        return Integer.hashCode(this.d) + ((iA + (num == null ? 0 : num.hashCode())) * 31);
    }

    public final String toString() {
        return "DebugPanelTextWithIcon(text=" + this.f10777a + ", color=" + this.b + ", icon=" + this.c + ", style=" + this.d + ")";
    }

    public final String d() {
        return this.f10777a;
    }

    public final int a() {
        return this.b;
    }

    public final Integer b() {
        return this.c;
    }

    public final int c() {
        return this.d;
    }

    public /* synthetic */ yx(String str, int i, Integer num, int i2, int i3) {
        this(str, (i3 & 2) != 0 ? R.attr.debug_panel_label_primary : i, (i3 & 4) != 0 ? null : num, (i3 & 8) != 0 ? R.style.DebugPanelText_Body1 : i2);
    }
}
