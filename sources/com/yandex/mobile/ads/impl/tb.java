package com.yandex.mobile.ads.impl;

import android.app.Dialog;
import android.content.Context;
import android.view.ViewGroup;
import android.view.Window;
import com.yandex.mobile.ads.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class tb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f10281a;
    private final rb b;
    private final ob c;

    public tb(vb adtuneOptOutWebView, Context context, rb adtuneOptOutContainerCreator, ob adtuneControlsConfigurator) {
        Intrinsics.checkNotNullParameter(adtuneOptOutWebView, "adtuneOptOutWebView");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adtuneOptOutContainerCreator, "adtuneOptOutContainerCreator");
        Intrinsics.checkNotNullParameter(adtuneControlsConfigurator, "adtuneControlsConfigurator");
        this.f10281a = context;
        this.b = adtuneOptOutContainerCreator;
        this.c = adtuneControlsConfigurator;
    }

    public final Dialog a() {
        Dialog dialog = new Dialog(this.f10281a, R.style.MonetizationAdsInternal_BottomAdtuneDialog);
        ViewGroup viewGroupA = this.b.a();
        this.c.a(viewGroupA, dialog);
        dialog.setContentView(viewGroupA);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setGravity(80);
        }
        return dialog;
    }
}
