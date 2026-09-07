package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class kt1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final v32 f9448a;

    public final Point a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        final WindowManager windowManager = (WindowManager) systemService;
        v32 v32Var = this.f9448a;
        Callable callable = new Callable() { // from class: com.yandex.mobile.ads.impl.kt1$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return kt1.a(windowManager);
            }
        };
        v32Var.getClass();
        final Display display = (Display) v32.a(callable, windowManager, "getting display", "WindowManager");
        final Point point = new Point(0, 0);
        v32 v32Var2 = this.f9448a;
        Callable tryBlock = new Callable() { // from class: com.yandex.mobile.ads.impl.kt1$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return kt1.a(display, point, this);
            }
        };
        v32Var2.getClass();
        Intrinsics.checkNotNullParameter(tryBlock, "tryBlock");
        Intrinsics.checkNotNullParameter("getting display metrics", "whileWhat");
        Intrinsics.checkNotNullParameter("Display", "whatIsNull");
        Object objA = v32.a(tryBlock, display, "getting display metrics", "Display");
        Object obj = point;
        if (objA != null) {
            obj = objA;
        }
        return (Point) obj;
    }

    public /* synthetic */ kt1() {
        this(new v32());
    }

    public kt1(v32 systemServiceUtils) {
        Intrinsics.checkNotNullParameter(systemServiceUtils, "systemServiceUtils");
        this.f9448a = systemServiceUtils;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Display a(WindowManager windowManager) {
        Intrinsics.checkNotNullParameter(windowManager, "$windowManager");
        return windowManager.getDefaultDisplay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Point a(Display display, Point defaultPoint, kt1 this$0) {
        Intrinsics.checkNotNullParameter(defaultPoint, "$defaultPoint");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (display == null) {
            return defaultPoint;
        }
        this$0.getClass();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getRealMetrics(displayMetrics);
        return new Point(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }
}
