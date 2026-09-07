package com.five_corp.ad.internal.ad.custom_layout;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes8.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1284a;
    public final String b;
    public final String c;
    public final int d;
    public final boolean e;
    public final boolean f;
    public final Integer g;
    public final Integer h;

    public k(String str, String str2, String str3, int i, Boolean bool, Boolean bool2, Integer num, Integer num2) {
        this.f1284a = str;
        this.b = str2;
        this.c = str3;
        if (i != 0) {
            this.d = i;
        } else {
            this.d = 1;
        }
        this.e = bool != null ? bool.booleanValue() : true;
        this.f = bool2 != null ? bool2.booleanValue() : false;
        this.g = num;
        this.h = num2;
    }

    public final String toString() {
        return "CustomLayoutObjectText{text='" + this.f1284a + "', textColorArgb='" + this.b + "', backgroundColorArgb='" + this.c + "', gravity='" + m.a(this.d) + "', isRenderFrame='" + this.e + "', fontSize='" + this.g + "', tvsHackHorizontalSpace=" + this.h + AbstractJsonLexerKt.END_OBJ;
    }
}
