package com.yandex.mobile.ads.impl;

import android.app.Activity;
import android.app.Dialog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class k10 {
    public static final void a(Dialog dialog) {
        Intrinsics.checkNotNullParameter(dialog, "<this>");
        Activity ownerActivity = dialog.getOwnerActivity();
        boolean z = ownerActivity == null || !(ownerActivity.isFinishing() || ownerActivity.isDestroyed());
        if (dialog.isShowing() && z) {
            try {
                dialog.dismiss();
            } catch (Exception unused) {
                Object[] args = new Object[0];
                int i = op0.b;
                Intrinsics.checkNotNullParameter(args, "args");
            }
        }
    }
}
