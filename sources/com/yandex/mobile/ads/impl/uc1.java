package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONException;

/* JADX INFO: loaded from: classes11.dex */
public final class uc1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final on1 f10377a;
    private final pn1 b;

    public final tc1 a(np1<?> request) {
        Intrinsics.checkNotNullParameter(request, "request");
        String strA = this.b.a(request);
        if (strA != null) {
            try {
                this.f10377a.getClass();
                nn1 nn1VarA = on1.a(strA);
                byte[] bytes = nn1VarA.a().getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                return new tc1(200, bytes, nn1VarA.b(), false);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public /* synthetic */ uc1() {
        this(new on1(), pn1.b.a());
    }

    public uc1(on1 readyResponseDecoder, pn1 readyResponseStorage) {
        Intrinsics.checkNotNullParameter(readyResponseDecoder, "readyResponseDecoder");
        Intrinsics.checkNotNullParameter(readyResponseStorage, "readyResponseStorage");
        this.f10377a = readyResponseDecoder;
        this.b = readyResponseStorage;
    }
}
