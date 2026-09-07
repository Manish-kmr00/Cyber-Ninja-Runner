package com.ogury.ad.internal;

import android.graphics.Rect;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class z9 {
    public static Rect a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        if (rect.width() != view.getWidth()) {
            rect.right = view.getWidth() + rect.left;
        }
        if (rect.height() != view.getHeight()) {
            rect.bottom = view.getHeight() + rect.top;
        }
        return rect;
    }

    public static Rect b(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Rect rect = new Rect();
        try {
            if (view.isAttachedToWindow()) {
                view.getGlobalVisibleRect(rect);
            }
        } catch (Exception e) {
            u3 u3Var = u3.f7411a;
            String str = "View is not ready: " + e.getMessage();
            u3Var.getClass();
        }
        return rect;
    }

    public static Rect c(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Rect rect = new Rect();
        try {
            if (view.isAttachedToWindow()) {
                view.getWindowVisibleDisplayFrame(rect);
            }
        } catch (Exception e) {
            u3 u3Var = u3.f7411a;
            String str = "View is not ready: " + e.getMessage();
            u3Var.getClass();
        }
        return rect;
    }
}
