package androidx.compose.ui.text.platform.extensions;

import android.graphics.Typeface;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.platform.AndroidTextPaint;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextPaintExtensions.android.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001aG\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012&\u0010\u0004\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0000ø\u0001\u0000\u001a\f\u0010\r\u001a\u00020\u000e*\u00020\u0001H\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"applySpanStyle", "Landroidx/compose/ui/text/SpanStyle;", "Landroidx/compose/ui/text/platform/AndroidTextPaint;", "style", "resolveTypeface", "Lkotlin/Function4;", "Landroidx/compose/ui/text/font/FontFamily;", "Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontStyle;", "Landroidx/compose/ui/text/font/FontSynthesis;", "Landroid/graphics/Typeface;", "density", "Landroidx/compose/ui/unit/Density;", "hasFontAttributes", "", "ui-text_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TextPaintExtensions_androidKt {
    public static final SpanStyle applySpanStyle(AndroidTextPaint androidTextPaint, SpanStyle style, Function4<? super FontFamily, ? super FontWeight, ? super FontStyle, ? super FontSynthesis, ? extends Typeface> resolveTypeface, Density density) {
        long jM4035getUnspecifiedXSAIIZE;
        long background;
        BaselineShift baselineShift;
        Intrinsics.checkNotNullParameter(androidTextPaint, "<this>");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(resolveTypeface, "resolveTypeface");
        Intrinsics.checkNotNullParameter(density, "density");
        long jM4023getTypeUIouoOA = TextUnit.m4023getTypeUIouoOA(style.getFontSize());
        if (TextUnitType.m4052equalsimpl0(jM4023getTypeUIouoOA, TextUnitType.INSTANCE.m4057getSpUIouoOA())) {
            androidTextPaint.setTextSize(density.mo317toPxR2X_6o(style.getFontSize()));
        } else if (TextUnitType.m4052equalsimpl0(jM4023getTypeUIouoOA, TextUnitType.INSTANCE.m4056getEmUIouoOA())) {
            androidTextPaint.setTextSize(androidTextPaint.getTextSize() * TextUnit.m4024getValueimpl(style.getFontSize()));
        }
        if (hasFontAttributes(style)) {
            FontFamily fontFamily = style.getFontFamily();
            FontWeight fontWeight = style.getFontWeight();
            if (fontWeight == null) {
                fontWeight = FontWeight.INSTANCE.getNormal();
            }
            FontStyle fontStyle = style.getFontStyle();
            FontStyle fontStyleM3565boximpl = FontStyle.m3565boximpl(fontStyle != null ? fontStyle.m3571unboximpl() : FontStyle.INSTANCE.m3573getNormal_LCdwA());
            FontSynthesis fontSynthesis = style.getFontSynthesis();
            androidTextPaint.setTypeface(resolveTypeface.invoke(fontFamily, fontWeight, fontStyleM3565boximpl, FontSynthesis.m3574boximpl(fontSynthesis != null ? fontSynthesis.getValue() : FontSynthesis.INSTANCE.m3583getAllGVVA2EU())));
        }
        if (style.getLocaleList() != null && !Intrinsics.areEqual(style.getLocaleList(), LocaleList.INSTANCE.getCurrent())) {
            LocaleListHelperMethods.INSTANCE.setTextLocales(androidTextPaint, style.getLocaleList());
        }
        long jM4023getTypeUIouoOA2 = TextUnit.m4023getTypeUIouoOA(style.getLetterSpacing());
        if (TextUnitType.m4052equalsimpl0(jM4023getTypeUIouoOA2, TextUnitType.INSTANCE.m4056getEmUIouoOA())) {
            androidTextPaint.setLetterSpacing(TextUnit.m4024getValueimpl(style.getLetterSpacing()));
        } else {
            TextUnitType.m4052equalsimpl0(jM4023getTypeUIouoOA2, TextUnitType.INSTANCE.m4057getSpUIouoOA());
        }
        if (style.getFontFeatureSettings() != null && !Intrinsics.areEqual(style.getFontFeatureSettings(), "")) {
            androidTextPaint.setFontFeatureSettings(style.getFontFeatureSettings());
        }
        if (style.getTextGeometricTransform() != null && !Intrinsics.areEqual(style.getTextGeometricTransform(), TextGeometricTransform.INSTANCE.getNone$ui_text_release())) {
            androidTextPaint.setTextScaleX(androidTextPaint.getTextScaleX() * style.getTextGeometricTransform().getScaleX());
            androidTextPaint.setTextSkewX(androidTextPaint.getTextSkewX() + style.getTextGeometricTransform().getSkewX());
        }
        androidTextPaint.m3684setColor8_81llA(style.m3462getColor0d7_KjU());
        androidTextPaint.m3683setBrushd16Qtg0(style.getBrush(), Size.INSTANCE.m1472getUnspecifiedNHjbRc());
        androidTextPaint.setShadow(style.getShadow());
        androidTextPaint.setTextDecoration(style.getTextDecoration());
        if (TextUnitType.m4052equalsimpl0(TextUnit.m4023getTypeUIouoOA(style.getLetterSpacing()), TextUnitType.INSTANCE.m4057getSpUIouoOA()) && TextUnit.m4024getValueimpl(style.getLetterSpacing()) != 0.0f) {
            jM4035getUnspecifiedXSAIIZE = style.getLetterSpacing();
        } else {
            jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
        }
        long j = jM4035getUnspecifiedXSAIIZE;
        if (Color.m1632equalsimpl0(style.getBackground(), Color.INSTANCE.m1666getTransparent0d7_KjU())) {
            background = Color.INSTANCE.m1667getUnspecified0d7_KjU();
        } else {
            background = style.getBackground();
        }
        long j2 = background;
        BaselineShift baselineShift2 = style.getBaselineShift();
        if (baselineShift2 == null ? false : BaselineShift.m3703equalsimpl0(baselineShift2.m3706unboximpl(), BaselineShift.INSTANCE.m3710getNoney9eOQZs())) {
            baselineShift = null;
        } else {
            baselineShift = style.getBaselineShift();
        }
        return new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, j, baselineShift, (TextGeometricTransform) null, (LocaleList) null, j2, (TextDecoration) null, (Shadow) null, 13951, (DefaultConstructorMarker) null);
    }

    public static final boolean hasFontAttributes(SpanStyle spanStyle) {
        Intrinsics.checkNotNullParameter(spanStyle, "<this>");
        return (spanStyle.getFontFamily() == null && spanStyle.getFontStyle() == null && spanStyle.getFontWeight() == null) ? false : true;
    }
}
