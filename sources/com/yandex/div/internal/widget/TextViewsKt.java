package com.yandex.div.internal.widget;

import android.os.Build;
import android.widget.TextView;
import com.safedk.android.analytics.reporters.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextViews.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a\b\u0010\t\u001a\u00020\nH\u0001\u001a\f\u0010\u000b\u001a\u00020\n*\u00020\u0002H\u0000\u001a\u0014\u0010\f\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\r\u001a\u00020\u0006H\u0000\u001a\u0016\u0010\u000e\u001a\u00020\u0006*\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0006H\u0007\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0006*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"fontHeight", "", "Landroid/widget/TextView;", "getFontHeight", "(Landroid/widget/TextView;)F", "fontHeightInt", "", "getFontHeightInt", "(Landroid/widget/TextView;)I", "checkHyphenationSupported", "", "isHyphenationEnabled", "lineAt", "vertical", "textHeight", b.d, "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class TextViewsKt {
    public static final float getFontHeight(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        return textView.getPaint().getFontMetrics(null);
    }

    public static final int getFontHeightInt(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        return textView.getPaint().getFontMetricsInt(null);
    }

    public static /* synthetic */ int textHeight$default(TextView textView, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -1;
        }
        return textHeight(textView, i);
    }

    public static final int textHeight(TextView textView, int i) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        if (textView.getLayout() == null) {
            return 0;
        }
        if (i <= 0) {
            return textView.getLayout().getHeight();
        }
        return i > textView.getLayout().getLineCount() ? textView.getLayout().getHeight() : textView.getLayout().getLineTop(i) - textView.getLayout().getLineTop(0);
    }

    public static final int lineAt(TextView textView, int i) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        if (textView.getLayout() == null) {
            return 0;
        }
        return textView.getLayout().getLineForVertical(i);
    }

    public static final boolean checkHyphenationSupported() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static final boolean isHyphenationEnabled(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        return checkHyphenationSupported() && textView.getHyphenationFrequency() != 0;
    }
}
