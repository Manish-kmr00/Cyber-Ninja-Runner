package com.yandex.mobile.ads.impl;

import java.util.LinkedHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class xj1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j82 f10660a;
    private final e80 b;

    public final vj1 a(JSONObject jsonObject) throws JSONException, p61 {
        Object objM7904constructorimpl;
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        String strA = f91.a(jsonObject, "jsonAsset", "package", "jsonAttribute", "package");
        if (strA == null || strA.length() == 0 || Intrinsics.areEqual(strA, "null")) {
            throw new p61("Native Ad json has not required attributes");
        }
        Intrinsics.checkNotNull(strA);
        this.f10660a.getClass();
        String strA2 = j82.a("url", jsonObject);
        LinkedHashMap linkedHashMapA = this.b.a(jsonObject.optJSONObject("extras"));
        Intrinsics.checkNotNullParameter(jsonObject, "<this>");
        Intrinsics.checkNotNullParameter("flags", "name");
        try {
            Result.Companion companion = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(Integer.valueOf(jsonObject.getInt("flags")));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        uy uyVar = null;
        if (Result.m7910isFailureimpl(objM7904constructorimpl)) {
            objM7904constructorimpl = null;
        }
        Integer num = (Integer) objM7904constructorimpl;
        String strA3 = sq0.a("launchMode", jsonObject);
        uy.b.getClass();
        for (uy uyVar2 : uy.a()) {
            if (StringsKt.equals(uyVar2.name(), strA3, true)) {
                uyVar = uyVar2;
                break;
            }
        }
        uy uyVar3 = uyVar;
        return new vj1(strA, strA2, linkedHashMapA, num, uyVar3 == null ? uy.c : uyVar3);
    }

    public /* synthetic */ xj1(j82 j82Var) {
        this(j82Var, new e80());
    }

    public xj1(j82 urlJsonParser, e80 extrasParser) {
        Intrinsics.checkNotNullParameter(urlJsonParser, "urlJsonParser");
        Intrinsics.checkNotNullParameter(extrasParser, "extrasParser");
        this.f10660a = urlJsonParser;
        this.b = extrasParser;
    }
}
