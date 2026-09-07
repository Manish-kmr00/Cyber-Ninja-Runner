package androidx.compose.foundation.text.selection;

import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: SelectionAdjustment.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"ensureAtLeastOneChar", "Landroidx/compose/ui/text/TextRange;", "offset", "", "lastOffset", "isStartHandle", "", "previousHandlesCrossed", "(IIZZ)J", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class SelectionAdjustmentKt {
    public static final long ensureAtLeastOneChar(int i, int i2, boolean z, boolean z2) {
        if (i2 == 0) {
            return TextRangeKt.TextRange(i, i);
        }
        if (i == 0) {
            if (z) {
                return TextRangeKt.TextRange(1, 0);
            }
            return TextRangeKt.TextRange(0, 1);
        }
        if (i == i2) {
            if (z) {
                return TextRangeKt.TextRange(i2 - 1, i2);
            }
            return TextRangeKt.TextRange(i2, i2 - 1);
        }
        if (z) {
            if (!z2) {
                return TextRangeKt.TextRange(i - 1, i);
            }
            return TextRangeKt.TextRange(i + 1, i);
        }
        if (!z2) {
            return TextRangeKt.TextRange(i, i + 1);
        }
        return TextRangeKt.TextRange(i, i - 1);
    }
}
