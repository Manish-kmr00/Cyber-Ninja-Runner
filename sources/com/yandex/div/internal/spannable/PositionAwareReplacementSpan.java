package com.yandex.div.internal.spannable;

import android.graphics.Paint;
import android.os.Build;
import android.text.style.ReplacementSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PositionAwareReplacementSpan.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&J0\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002¨\u0006\u0010"}, d2 = {"Lcom/yandex/div/internal/spannable/PositionAwareReplacementSpan;", "Landroid/text/style/ReplacementSpan;", "()V", "adjustSize", "", "paint", "Landroid/graphics/Paint;", "text", "", "start", "end", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "getSize", "updateFontMetrics", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class PositionAwareReplacementSpan extends ReplacementSpan {
    public abstract int adjustSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm);

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        Intrinsics.checkNotNullParameter(text, "text");
        updateFontMetrics(start, fm);
        return adjustSize(paint, text, start, end, fm);
    }

    private final void updateFontMetrics(int start, Paint.FontMetricsInt fm) {
        if (fm == null || start != 0 || Build.VERSION.SDK_INT >= 28) {
            return;
        }
        fm.top = 0;
        fm.ascent = 0;
        fm.bottom = 0;
        fm.descent = 0;
        fm.leading = 0;
    }
}
