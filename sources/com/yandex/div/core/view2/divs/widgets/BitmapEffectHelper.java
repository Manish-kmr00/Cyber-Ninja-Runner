package com.yandex.div.core.view2.divs.widgets;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.yandex.div.core.dagger.DivScope;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BitmapEffectHelper.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\tJ\u0015\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/yandex/div/core/view2/divs/widgets/BitmapEffectHelper;", "", "renderScript", "Landroid/renderscript/RenderScript;", "(Landroid/renderscript/RenderScript;)V", "blurBitmap", "Landroid/graphics/Bitmap;", "bitmap", "radius", "", "mirrorBitmap", "mirrorBitmap$div_release", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@DivScope
public final class BitmapEffectHelper {
    private final RenderScript renderScript;

    @Inject
    public BitmapEffectHelper(RenderScript renderScript) {
        Intrinsics.checkNotNullParameter(renderScript, "renderScript");
        this.renderScript = renderScript;
    }

    public final Bitmap blurBitmap(Bitmap bitmap, int radius) {
        float f;
        Bitmap result;
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        if (radius == 0) {
            return bitmap;
        }
        if (radius > 25) {
            f = (radius * 1.0f) / 25;
            radius = 25;
        } else {
            f = 1.0f;
        }
        if (f == 1.0f) {
            result = bitmap.copy(bitmap.getConfig(), false);
        } else {
            result = Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() / f), (int) (bitmap.getHeight() / f), false);
        }
        Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(this.renderScript, result);
        Allocation allocationCreateTyped = Allocation.createTyped(this.renderScript, allocationCreateFromBitmap.getType());
        RenderScript renderScript = this.renderScript;
        ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
        scriptIntrinsicBlurCreate.setRadius(radius);
        scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
        scriptIntrinsicBlurCreate.forEach(allocationCreateTyped);
        allocationCreateTyped.copyTo(result);
        allocationCreateFromBitmap.destroy();
        allocationCreateTyped.destroy();
        scriptIntrinsicBlurCreate.destroy();
        Intrinsics.checkNotNullExpressionValue(result, "result");
        return result;
    }

    public final Bitmap mirrorBitmap$div_release(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Matrix matrix = new Matrix();
        matrix.preScale(-1.0f, 1.0f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(\n          …lter = */ false\n        )");
        bitmapCreateBitmap.setDensity(160);
        return bitmapCreateBitmap;
    }
}
