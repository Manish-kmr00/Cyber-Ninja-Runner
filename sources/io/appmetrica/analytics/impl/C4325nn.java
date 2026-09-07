package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.nn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4325nn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4076dn f11690a;
    public final S b;
    public final List c;
    public final String d;
    public final String e;
    public final Map f;
    public final String g;
    public final Boolean h;

    public C4325nn(C4076dn c4076dn, S s, ArrayList arrayList, String str, String str2, Map map, String str3, Boolean bool) {
        this.f11690a = c4076dn;
        this.b = s;
        this.c = arrayList;
        this.d = str;
        this.e = str2;
        this.f = map;
        this.g = str3;
        this.h = bool;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        C4076dn c4076dn = this.f11690a;
        if (c4076dn != null) {
            for (C4124fl c4124fl : c4076dn.c) {
                sb.append("at " + c4124fl.f11556a + "." + c4124fl.e + "(" + c4124fl.b + ":" + c4124fl.c + ":" + c4124fl.d + ")\n");
            }
        }
        return "UnhandledException{exception=" + this.f11690a + "\n" + sb.toString() + AbstractJsonLexerKt.END_OBJ;
    }
}
