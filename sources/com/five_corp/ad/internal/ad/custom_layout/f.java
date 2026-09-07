package com.five_corp.ad.internal.ad.custom_layout;

import java.util.ArrayList;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes8.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f1279a;
    public final ArrayList b;
    public final int c;

    public f(boolean z, ArrayList arrayList, int i) {
        this.f1279a = z;
        this.b = arrayList;
        this.c = i;
    }

    public final String toString() {
        return "CustomLayoutObjectAnimatedImage{repeated=" + this.f1279a + ", images=" + this.b + ", periodMs=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }
}
