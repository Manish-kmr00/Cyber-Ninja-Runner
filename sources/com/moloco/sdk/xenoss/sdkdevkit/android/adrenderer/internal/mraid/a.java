package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid;

import android.content.Context;
import android.util.TypedValue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6625a = new a();

    public final float a(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public final int b(float f, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (int) (a(f, context) + 0.5f);
    }

    public final float c(float f, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return f * a(context);
    }

    public final int d(float f, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (int) (c(f, context) + 0.5f);
    }

    public final float e(float f, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return f / a(context);
    }

    public final int f(float f, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (int) (e(f, context) + 0.5f);
    }

    public final float a(float f, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public final int b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return f(context.getResources().getDisplayMetrics().heightPixels, context);
    }

    public final int c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return f(context.getResources().getDisplayMetrics().widthPixels, context);
    }
}
