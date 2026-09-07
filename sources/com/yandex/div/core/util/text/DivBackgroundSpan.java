package com.yandex.div.core.util.text;

import android.text.TextPaint;
import android.text.style.UnderlineSpan;
import androidx.compose.material.OutlinedTextFieldKt;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.yandex.div2.DivTextRangeBackground;
import com.yandex.div2.DivTextRangeBorder;
import io.appmetrica.analytics.impl.J2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivBackgroundSpan.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/yandex/div/core/util/text/DivBackgroundSpan;", "Landroid/text/style/UnderlineSpan;", OutlinedTextFieldKt.BorderId, "Lcom/yandex/div2/DivTextRangeBorder;", J2.g, "Lcom/yandex/div2/DivTextRangeBackground;", "(Lcom/yandex/div2/DivTextRangeBorder;Lcom/yandex/div2/DivTextRangeBackground;)V", "getBackground", "()Lcom/yandex/div2/DivTextRangeBackground;", "getBorder", "()Lcom/yandex/div2/DivTextRangeBorder;", "updateDrawState", "", ApsMetricsDataMap.APSMETRICS_FIELD_SCREENSIZE, "Landroid/text/TextPaint;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivBackgroundSpan extends UnderlineSpan {
    private final DivTextRangeBackground background;
    private final DivTextRangeBorder border;

    public final DivTextRangeBorder getBorder() {
        return this.border;
    }

    public final DivTextRangeBackground getBackground() {
        return this.background;
    }

    public DivBackgroundSpan(DivTextRangeBorder divTextRangeBorder, DivTextRangeBackground divTextRangeBackground) {
        this.border = divTextRangeBorder;
        this.background = divTextRangeBackground;
    }

    @Override // android.text.style.UnderlineSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint ds) {
        Intrinsics.checkNotNullParameter(ds, "ds");
        ds.setUnderlineText(false);
    }
}
