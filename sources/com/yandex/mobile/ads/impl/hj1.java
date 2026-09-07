package com.yandex.mobile.ads.impl;

import android.os.Build;
import android.widget.PopupMenu;
import java.lang.reflect.Field;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class hj1 {
    public static void a(PopupMenu obj) {
        Object obj2;
        Intrinsics.checkNotNullParameter(obj, "popupMenu");
        if (Build.VERSION.SDK_INT >= 29) {
            obj.setForceShowIcon(true);
            return;
        }
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter("mPopup", "fieldName");
        try {
            Field declaredField = obj.getClass().getDeclaredField("mPopup");
            declaredField.setAccessible(true);
            obj2 = declaredField.get(obj);
            try {
                declaredField.setAccessible(false);
            } catch (Throwable unused) {
                Object[] args = {"mPopup"};
                int i = op0.b;
                Intrinsics.checkNotNullParameter(args, "args");
            }
        } catch (Throwable unused2) {
            obj2 = null;
        }
        if (obj2 == null) {
            return;
        }
        try {
            obj2.getClass().getMethod("setForceShowIcon", Boolean.TYPE).invoke(obj2, Boolean.TRUE);
        } catch (Exception unused3) {
            Object[] args2 = new Object[0];
            int i2 = op0.b;
            Intrinsics.checkNotNullParameter(args2, "args");
        }
    }
}
