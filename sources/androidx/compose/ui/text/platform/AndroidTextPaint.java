package androidx.compose.ui.text.platform;

import android.text.TextPaint;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.text.style.TextDecoration;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidTextPaint.android.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J%\u0010\u000f\u001a\u00020\u00102\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u001a\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000eR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/text/platform/AndroidTextPaint;", "Landroid/text/TextPaint;", "flags", "", "density", "", "(IF)V", "brush", "Landroidx/compose/ui/graphics/Brush;", "brushSize", "Landroidx/compose/ui/geometry/Size;", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "setBrush", "", ContentDisposition.Parameters.Size, "setBrush-d16Qtg0", "(Landroidx/compose/ui/graphics/Brush;J)V", "setColor", "color", "Landroidx/compose/ui/graphics/Color;", "setColor-8_81llA", "(J)V", "setShadow", "setTextDecoration", "ui-text_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AndroidTextPaint extends TextPaint {
    private Brush brush;
    private Size brushSize;
    private Shadow shadow;
    private TextDecoration textDecoration;

    public AndroidTextPaint(int i, float f) {
        super(i);
        this.density = f;
        this.textDecoration = TextDecoration.INSTANCE.getNone();
        this.shadow = Shadow.INSTANCE.getNone();
    }

    public final void setTextDecoration(TextDecoration textDecoration) {
        if (textDecoration == null) {
            textDecoration = TextDecoration.INSTANCE.getNone();
        }
        if (Intrinsics.areEqual(this.textDecoration, textDecoration)) {
            return;
        }
        this.textDecoration = textDecoration;
        setUnderlineText(textDecoration.contains(TextDecoration.INSTANCE.getUnderline()));
        setStrikeThruText(this.textDecoration.contains(TextDecoration.INSTANCE.getLineThrough()));
    }

    public final void setShadow(Shadow shadow) {
        if (shadow == null) {
            shadow = Shadow.INSTANCE.getNone();
        }
        if (Intrinsics.areEqual(this.shadow, shadow)) {
            return;
        }
        this.shadow = shadow;
        if (Intrinsics.areEqual(shadow, Shadow.INSTANCE.getNone())) {
            clearShadowLayer();
        } else {
            setShadowLayer(this.shadow.getBlurRadius(), Offset.m1395getXimpl(this.shadow.getOffset()), Offset.m1396getYimpl(this.shadow.getOffset()), ColorKt.m1686toArgb8_81llA(this.shadow.getColor()));
        }
    }

    /* JADX INFO: renamed from: setBrush-d16Qtg0, reason: not valid java name */
    public final void m3683setBrushd16Qtg0(Brush brush, long size) {
        if (brush == null) {
            setShader(null);
            return;
        }
        if (Intrinsics.areEqual(this.brush, brush)) {
            Size size2 = this.brushSize;
            if (size2 == null ? false : Size.m1460equalsimpl0(size2.getPackedValue(), size)) {
                return;
            }
        }
        this.brush = brush;
        this.brushSize = Size.m1452boximpl(size);
        if (brush instanceof SolidColor) {
            setShader(null);
            m3684setColor8_81llA(((SolidColor) brush).getValue());
        } else if (brush instanceof ShaderBrush) {
            if (size != Size.INSTANCE.m1472getUnspecifiedNHjbRc()) {
                setShader(((ShaderBrush) brush).mo1600createShaderuvyYCjk(size));
            }
        }
    }

    /* JADX INFO: renamed from: setColor-8_81llA, reason: not valid java name */
    public final void m3684setColor8_81llA(long color) {
        int iM1686toArgb8_81llA;
        if (color == Color.INSTANCE.m1667getUnspecified0d7_KjU() || getColor() == (iM1686toArgb8_81llA = ColorKt.m1686toArgb8_81llA(color))) {
            return;
        }
        setColor(iM1686toArgb8_81llA);
    }
}
