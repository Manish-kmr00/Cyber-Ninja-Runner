package androidx.compose.ui.text.style;

import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.text.SpanStyleKt;
import com.yandex.div.core.timer.TimerController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextDrawStyle.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"lerp", "Landroidx/compose/ui/text/style/TextDrawStyle;", "start", TimerController.STOP_COMMAND, "fraction", "", "ui-text_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TextDrawStyleKt {
    public static final TextDrawStyle lerp(TextDrawStyle start, TextDrawStyle stop, float f) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(stop, "stop");
        if (!(start instanceof BrushStyle) && !(stop instanceof BrushStyle)) {
            return TextDrawStyle.INSTANCE.m3769from8_81llA(ColorKt.m1683lerpjxsXWHM(start.mo3714getColor0d7_KjU(), stop.mo3714getColor0d7_KjU(), f));
        }
        return (TextDrawStyle) SpanStyleKt.lerpDiscrete(start, stop, f);
    }
}
