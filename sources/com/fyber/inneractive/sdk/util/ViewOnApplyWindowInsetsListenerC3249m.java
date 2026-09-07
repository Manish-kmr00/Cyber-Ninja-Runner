package com.fyber.inneractive.sdk.util;

import android.graphics.Insets;
import android.view.View;
import android.view.WindowInsets;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.util.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class ViewOnApplyWindowInsetsListenerC3249m implements View.OnApplyWindowInsetsListener {
    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        Insets insets = windowInsets.getInsets(WindowInsets.Type.displayCutout());
        int iC = AbstractC3251o.c();
        if (iC == 1) {
            view.setPadding(insets.left, 0, 0, 0);
        } else if (iC == 2) {
            view.setPadding(0, 0, 0, insets.bottom);
        } else if (iC != 3) {
            view.setPadding(0, insets.top, 0, 0);
        } else {
            view.setPadding(0, 0, insets.right, 0);
        }
        return windowInsets;
    }
}
