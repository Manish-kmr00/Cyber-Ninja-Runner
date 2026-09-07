package com.mbridge.msdk.dycreator.error;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: DyError.java */
/* JADX INFO: loaded from: classes9.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4865a;
    private String b;

    public a(b bVar) {
        if (bVar != null) {
            this.f4865a = bVar.a();
            this.b = bVar.b();
        }
    }

    public String toString() {
        return "DyError{errorCode=" + this.f4865a + AbstractJsonLexerKt.END_OBJ;
    }

    public a(int i, String str) {
        this.f4865a = i;
        this.b = str;
    }
}
