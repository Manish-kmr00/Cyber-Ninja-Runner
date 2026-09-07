package com.yandex.mobile.ads.impl;

import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class fd0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final qs f8885a;

    public final void a(Window window, RelativeLayout rootView) {
        Intrinsics.checkNotNullParameter(window, "window");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        WindowCompat.setDecorFitsSystemWindows(window, false);
        if (pa.a(30)) {
            window.getAttributes().layoutInDisplayCutoutMode = 3;
        } else if (pa.a(28)) {
            window.getAttributes().layoutInDisplayCutoutMode = 1;
        }
        if (!pa.a(28) || this.f8885a == qs.i) {
            return;
        }
        a(rootView);
    }

    public fd0(qs qsVar) {
        this.f8885a = qsVar;
    }

    private static void a(RelativeLayout relativeLayout) {
        ViewCompat.setOnApplyWindowInsetsListener(relativeLayout, new OnApplyWindowInsetsListener() { // from class: com.yandex.mobile.ads.impl.fd0$$ExternalSyntheticLambda0
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return fd0.a(view, windowInsetsCompat);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat a(View v, WindowInsetsCompat windowInsets) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
        Insets insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout());
        Intrinsics.checkNotNullExpressionValue(insets, "getInsets(...)");
        v.setPadding(insets.left, insets.top, insets.right, insets.bottom);
        return WindowInsetsCompat.CONSUMED;
    }
}
