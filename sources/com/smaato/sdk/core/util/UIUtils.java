package com.smaato.sdk.core.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.smaato.sdk.core.util.fi.Function;

/* JADX INFO: loaded from: classes9.dex */
public final class UIUtils {
    public static int dpToPx(float f, float f2) {
        return (int) ((f * f2) + 0.5f);
    }

    public static int dpToPx(Context context, float f) {
        return (int) (f * context.getResources().getDisplayMetrics().density);
    }

    public static int pxToDp(Context context, float f) {
        return Math.round(f / context.getResources().getDisplayMetrics().density);
    }

    public static int getDisplayWidthInDp() {
        return scale(new Function() { // from class: com.smaato.sdk.core.util.UIUtils$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Function
            public final Object apply(Object obj) {
                return Integer.valueOf(((DisplayMetrics) obj).widthPixels);
            }
        });
    }

    public static int getDisplayHeightInDp() {
        return scale(new Function() { // from class: com.smaato.sdk.core.util.UIUtils$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Function
            public final Object apply(Object obj) {
                return Integer.valueOf(((DisplayMetrics) obj).heightPixels);
            }
        });
    }

    public static float getNormalizedSize(Float f) {
        if (f == null || f.floatValue() <= 0.0f) {
            return 0.0f;
        }
        return f.floatValue();
    }

    public static Size getDisplaySizeInDp(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return new Size(pxToDp(context, displayMetrics.widthPixels), pxToDp(context, displayMetrics.heightPixels));
    }

    private static int scale(Function function) {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        return (int) (((Integer) function.apply(displayMetrics)).intValue() / displayMetrics.density);
    }
}
