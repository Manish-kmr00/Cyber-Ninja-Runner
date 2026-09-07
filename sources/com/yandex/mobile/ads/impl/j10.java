package com.yandex.mobile.ads.impl;

import android.app.Dialog;
import android.content.DialogInterface;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class j10 implements wr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Dialog f9276a;

    public final void a(Dialog dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        this.f9276a = dialog;
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.yandex.mobile.ads.impl.j10$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                j10.a(this.f$0, dialogInterface);
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.wr
    public final void f() {
        Dialog dialog = this.f9276a;
        if (dialog != null) {
            k10.a(dialog);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(j10 this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Dialog dialog = this$0.f9276a;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
        }
        this$0.f9276a = null;
    }
}
