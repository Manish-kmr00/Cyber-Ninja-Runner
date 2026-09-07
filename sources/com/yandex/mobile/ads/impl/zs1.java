package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class zs1<T extends View> {
    public static View a(Context context, Class layoutClass, int i, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(layoutClass, "layoutClass");
        try {
            return (View) layoutClass.cast(LayoutInflater.from(context).inflate(i, viewGroup, false));
        } catch (Exception e) {
            op0.b(e);
            return null;
        }
    }
}
