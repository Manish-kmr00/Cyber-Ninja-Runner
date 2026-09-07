package com.five_corp.ad.internal.ad.custom_layout;

import java.util.ArrayList;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes8.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1277a;
    public final int b;
    public final ArrayList c;
    public final ArrayList d;

    public d(int i, int i2, ArrayList arrayList, ArrayList arrayList2) {
        this.f1277a = i;
        this.b = i2;
        this.c = arrayList;
        this.d = arrayList2;
    }

    public final String toString() {
        return "CustomLayoutConfig{width=" + this.f1277a + ", height=" + this.b + ", objects=" + this.c + ", clicks=" + this.d + AbstractJsonLexerKt.END_OBJ;
    }
}
