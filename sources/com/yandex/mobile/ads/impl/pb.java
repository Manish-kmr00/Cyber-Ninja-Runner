package com.yandex.mobile.ads.impl;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.ViewGroup;
import android.view.Window;
import com.yandex.mobile.ads.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class pb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9907a;
    private final mb b;
    private final ob c;

    public pb(Activity context, bc adtuneWebView, mb adtuneContainerCreator, ob adtuneControlsConfigurator) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adtuneWebView, "adtuneWebView");
        Intrinsics.checkNotNullParameter(adtuneContainerCreator, "adtuneContainerCreator");
        Intrinsics.checkNotNullParameter(adtuneControlsConfigurator, "adtuneControlsConfigurator");
        this.f9907a = context;
        this.b = adtuneContainerCreator;
        this.c = adtuneControlsConfigurator;
    }

    public final Dialog a() {
        Dialog dialog = new Dialog(this.f9907a, R.style.MonetizationAdsInternal_BottomAdtuneDialog);
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
