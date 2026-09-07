package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes12.dex */
public final class w22 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final tj f10529a;

    public final String a(Context context, String body) {
        i50 i50VarU;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(body, "body");
        int i = iw1.l;
        cu1 cu1VarA = iw1.a.a().a(context);
        if (cu1VarA == null || (i50VarU = cu1VarA.u()) == null) {
            i50VarU = i50.c;
        }
        t01 t01Var = new t01(i50VarU.c(), i50VarU.b());
        byte[] bytes = body.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] bArrA = t01Var.a(bytes);
        if (bArrA == null) {
            return null;
        }
        this.f10529a.getClass();
        return tj.a(bArrA);
    }

    public /* synthetic */ w22() {
        this(new tj());
    }

    public w22(tj base64Encoder) {
        Intrinsics.checkNotNullParameter(base64Encoder, "base64Encoder");
        this.f10529a = base64Encoder;
    }
}
