package androidx.compose.ui.text.input;

import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;

/* JADX INFO: compiled from: EditingBuffer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0006"}, d2 = {"updateRangeAfterDelete", "Landroidx/compose/ui/text/TextRange;", TypedValues.AttributesType.S_TARGET, "deleted", "updateRangeAfterDelete-pWDy79M", "(JJ)J", "ui-text_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class EditingBufferKt {
    /* JADX INFO: renamed from: updateRangeAfterDelete-pWDy79M, reason: not valid java name */
    public static final long m3612updateRangeAfterDeletepWDy79M(long j, long j2) {
        int iM3485getLengthimpl;
        int iM3487getMinimpl = TextRange.m3487getMinimpl(j);
        int iM3486getMaximpl = TextRange.m3486getMaximpl(j);
        if (TextRange.m3491intersects5zctL8(j2, j)) {
            if (TextRange.m3479contains5zctL8(j2, j)) {
                iM3487getMinimpl = TextRange.m3487getMinimpl(j2);
                iM3486getMaximpl = iM3487getMinimpl;
            } else {
                if (TextRange.m3479contains5zctL8(j, j2)) {
                    iM3485getLengthimpl = TextRange.m3485getLengthimpl(j2);
                } else if (TextRange.m3480containsimpl(j2, iM3487getMinimpl)) {
                    iM3487getMinimpl = TextRange.m3487getMinimpl(j2);
                    iM3485getLengthimpl = TextRange.m3485getLengthimpl(j2);
                } else {
                    iM3486getMaximpl = TextRange.m3487getMinimpl(j2);
                }
                iM3486getMaximpl -= iM3485getLengthimpl;
            }
        } else if (iM3486getMaximpl > TextRange.m3487getMinimpl(j2)) {
            iM3487getMinimpl -= TextRange.m3485getLengthimpl(j2);
            iM3485getLengthimpl = TextRange.m3485getLengthimpl(j2);
            iM3486getMaximpl -= iM3485getLengthimpl;
        }
        return TextRangeKt.TextRange(iM3487getMinimpl, iM3486getMaximpl);
    }
}
