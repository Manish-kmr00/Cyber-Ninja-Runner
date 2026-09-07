package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.Typeface;
import com.yandex.div.core.font.DivTypefaceProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class j30 implements DivTypefaceProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9283a;

    public j30(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f9283a = context;
    }

    @Override // com.yandex.div.core.font.DivTypefaceProvider
    public final Typeface getBold() {
        Typeface typefaceA;
        bc0 bc0VarA = cc0.a(this.f9283a);
        return (bc0VarA == null || (typefaceA = bc0VarA.a()) == null) ? Typeface.DEFAULT_BOLD : typefaceA;
    }

    @Override // com.yandex.div.core.font.DivTypefaceProvider
    public final Typeface getLight() {
        bc0 bc0VarA = cc0.a(this.f9283a);
        if (bc0VarA != null) {
            return bc0VarA.b();
        }
        return null;
    }

    @Override // com.yandex.div.core.font.DivTypefaceProvider
    public final Typeface getMedium() {
        bc0 bc0VarA = cc0.a(this.f9283a);
        if (bc0VarA != null) {
            return bc0VarA.c();
        }
        return null;
    }

    @Override // com.yandex.div.core.font.DivTypefaceProvider
    public final Typeface getRegular() {
        bc0 bc0VarA = cc0.a(this.f9283a);
        if (bc0VarA != null) {
            return bc0VarA.d();
        }
        return null;
    }
}
