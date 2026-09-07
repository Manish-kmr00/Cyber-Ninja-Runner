package androidx.compose.ui.text.font;

import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FontSynthesis.android.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a9\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\f"}, d2 = {"synthesizeTypeface", "", "Landroidx/compose/ui/text/font/FontSynthesis;", "typeface", "font", "Landroidx/compose/ui/text/font/Font;", "requestedWeight", "Landroidx/compose/ui/text/font/FontWeight;", "requestedStyle", "Landroidx/compose/ui/text/font/FontStyle;", "synthesizeTypeface-FxwP2eA", "(ILjava/lang/Object;Landroidx/compose/ui/text/font/Font;Landroidx/compose/ui/text/font/FontWeight;I)Ljava/lang/Object;", "ui-text_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class FontSynthesis_androidKt {
    /* JADX INFO: renamed from: synthesizeTypeface-FxwP2eA, reason: not valid java name */
    public static final Object m3587synthesizeTypefaceFxwP2eA(int i, Object typeface, Font font, FontWeight requestedWeight, int i2) {
        int weight;
        boolean zM3568equalsimpl0;
        android.graphics.Typeface typefaceCreate;
        Intrinsics.checkNotNullParameter(typeface, "typeface");
        Intrinsics.checkNotNullParameter(font, "font");
        Intrinsics.checkNotNullParameter(requestedWeight, "requestedWeight");
        if (!(typeface instanceof android.graphics.Typeface)) {
            return typeface;
        }
        boolean z = FontSynthesis.m3580isWeightOnimpl$ui_text_release(i) && !Intrinsics.areEqual(font.getWeight(), requestedWeight) && requestedWeight.compareTo(AndroidFontUtils_androidKt.getAndroidBold(FontWeight.INSTANCE)) >= 0 && font.getWeight().compareTo(AndroidFontUtils_androidKt.getAndroidBold(FontWeight.INSTANCE)) < 0;
        boolean z2 = FontSynthesis.m3579isStyleOnimpl$ui_text_release(i) && !FontStyle.m3568equalsimpl0(i2, font.getStyle());
        if (!z2 && !z) {
            return typeface;
        }
        if (Build.VERSION.SDK_INT < 28) {
            typefaceCreate = android.graphics.Typeface.create((android.graphics.Typeface) typeface, AndroidFontUtils_androidKt.getAndroidTypefaceStyle(z, z2 && FontStyle.m3568equalsimpl0(i2, FontStyle.INSTANCE.m3572getItalic_LCdwA())));
        } else {
            if (z) {
                weight = requestedWeight.getWeight();
            } else {
                weight = font.getWeight().getWeight();
            }
            if (z2) {
                zM3568equalsimpl0 = FontStyle.m3568equalsimpl0(i2, FontStyle.INSTANCE.m3572getItalic_LCdwA());
            } else {
                zM3568equalsimpl0 = FontStyle.m3568equalsimpl0(font.getStyle(), FontStyle.INSTANCE.m3572getItalic_LCdwA());
            }
            typefaceCreate = TypefaceHelperMethodsApi28.INSTANCE.create((android.graphics.Typeface) typeface, weight, zM3568equalsimpl0);
        }
        Intrinsics.checkNotNullExpressionValue(typefaceCreate, "if (Build.VERSION.SDK_IN…ht, finalFontStyle)\n    }");
        return typefaceCreate;
    }
}
