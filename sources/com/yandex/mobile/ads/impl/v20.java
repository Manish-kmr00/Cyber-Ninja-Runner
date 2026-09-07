package com.yandex.mobile.ads.impl;

import android.net.Uri;
import com.yandex.div2.DivBase;
import com.yandex.div2.DivExtension;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class v20 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f20 f10443a;

    public final u20 a(DivBase divBase) {
        Object objM7904constructorimpl;
        Intrinsics.checkNotNullParameter(divBase, "divBase");
        this.f10443a.getClass();
        DivExtension divExtensionA = f20.a(divBase, "click");
        if (divExtensionA == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            JSONObject jSONObject = divExtensionA.params;
            objM7904constructorimpl = Result.m7904constructorimpl(Uri.parse(jSONObject != null ? jSONObject.getString("url") : null));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7910isFailureimpl(objM7904constructorimpl)) {
            objM7904constructorimpl = null;
        }
        Uri uri = (Uri) objM7904constructorimpl;
        if (uri != null) {
            return new u20(uri);
        }
        return null;
    }

    public /* synthetic */ v20(int i) {
        this(new f20());
    }

    public v20(f20 divExtensionProvider) {
        Intrinsics.checkNotNullParameter(divExtensionProvider, "divExtensionProvider");
        this.f10443a = divExtensionProvider;
    }
}
