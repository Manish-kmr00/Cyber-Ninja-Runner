package androidx.compose.ui.text.platform.style;

import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ShaderBrush;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ShaderBrushSpan.android.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R%\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/platform/style/ShaderBrushSpan;", "Landroid/text/style/CharacterStyle;", "Landroid/text/style/UpdateAppearance;", "shaderBrush", "Landroidx/compose/ui/graphics/ShaderBrush;", "(Landroidx/compose/ui/graphics/ShaderBrush;)V", "getShaderBrush", "()Landroidx/compose/ui/graphics/ShaderBrush;", ContentDisposition.Parameters.Size, "Landroidx/compose/ui/geometry/Size;", "getSize-VsRJwc0", "()Landroidx/compose/ui/geometry/Size;", "setSize-iaC8Vc4", "(Landroidx/compose/ui/geometry/Size;)V", "updateDrawState", "", "textPaint", "Landroid/text/TextPaint;", "ui-text_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ShaderBrushSpan extends CharacterStyle implements UpdateAppearance {
    private final ShaderBrush shaderBrush;
    private Size size;

    public final ShaderBrush getShaderBrush() {
        return this.shaderBrush;
    }

    public ShaderBrushSpan(ShaderBrush shaderBrush) {
        Intrinsics.checkNotNullParameter(shaderBrush, "shaderBrush");
        this.shaderBrush = shaderBrush;
    }

    /* JADX INFO: renamed from: getSize-VsRJwc0, reason: not valid java name and from getter */
    public final Size getSize() {
        return this.size;
    }

    /* JADX INFO: renamed from: setSize-iaC8Vc4, reason: not valid java name */
    public final void m3699setSizeiaC8Vc4(Size size) {
        this.size = size;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        Size size;
        if (textPaint == null || (size = this.size) == null) {
            return;
        }
        textPaint.setShader(this.shaderBrush.mo1600createShaderuvyYCjk(size.getPackedValue()));
    }
}
