package com.yandex.mobile.ads.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class wj1 {
    public static Intent a(Context context, vj1 preferredPackage) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(preferredPackage, "preferredPackage");
        String strE = preferredPackage.e();
        String strD = preferredPackage.d();
        Map<String, Object> mapA = preferredPackage.a();
        Integer numB = preferredPackage.b();
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(strE));
        if (numB == null || !(context instanceof Activity)) {
            intent.addFlags((numB != null ? numB.intValue() : 0) | 1342177280);
        } else {
            intent.addFlags(numB.intValue());
        }
        intent.setPackage(strD);
        if (mapA != null) {
            for (Map.Entry<String, Object> entry : mapA.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value instanceof Boolean) {
                    intent.putExtra(key, ((Boolean) value).booleanValue());
                } else if (value instanceof Integer) {
                    intent.putExtra(key, ((Number) value).intValue());
                } else if (value instanceof String) {
                    intent.putExtra(key, (String) value);
                } else if (value instanceof c80) {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        ((c80) value).getClass();
                        Result.m7904constructorimpl(intent.putExtra(key, (Parcelable) null));
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        Result.m7904constructorimpl(ResultKt.createFailure(th));
                    }
                }
            }
        }
        return intent;
    }
}
