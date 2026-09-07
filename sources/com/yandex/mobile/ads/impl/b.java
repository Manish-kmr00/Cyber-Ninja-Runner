package com.yandex.mobile.ads.impl;

import android.net.Uri;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o82 f8462a;

    public b(o82 urlUtils) {
        Intrinsics.checkNotNullParameter(urlUtils, "urlUtils");
        this.f8462a = urlUtils;
    }

    @Override // com.yandex.mobile.ads.impl.a
    public final boolean a(String str) {
        Object objM7904constructorimpl;
        this.f8462a.getClass();
        try {
            Result.Companion companion = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(Uri.parse(str).getPathSegments());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        String str2 = null;
        if (Result.m7910isFailureimpl(objM7904constructorimpl)) {
            objM7904constructorimpl = null;
        }
        List list = (List) objM7904constructorimpl;
        if (list != null && !list.isEmpty()) {
            str2 = (String) list.get(0);
        }
        return Intrinsics.areEqual("appcry", str2);
    }
}
