package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceReferrer;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.mg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4293mg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11673a;
    public final String b;
    public final Si c;

    public C4293mg(ECommerceReferrer eCommerceReferrer) {
        this(eCommerceReferrer.getType(), eCommerceReferrer.getIdentifier(), eCommerceReferrer.getScreen() == null ? null : new Si(eCommerceReferrer.getScreen()));
    }

    public final String toString() {
        return "ReferrerWrapper{type='" + this.f11673a + "', identifier='" + this.b + "', screen=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public C4293mg(String str, String str2, Si si) {
        this.f11673a = str;
        this.b = str2;
        this.c = si;
    }
}
