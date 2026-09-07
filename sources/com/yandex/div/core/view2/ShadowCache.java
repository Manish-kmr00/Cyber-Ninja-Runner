package com.yandex.div.core.view2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.drawable.shapes.RoundRectShape;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: ShadowCache.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\"B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006H\u0002J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u001e\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006J$\u0010\u0014\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u0006H\u0002J4\u0010\u001d\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0006H\u0002J\f\u0010!\u001a\u00020\u000e*\u00020\u001bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/yandex/div/core/view2/ShadowCache;", "", "()V", "EDGE_OFFSET", "", "MAX_BLUR", "", "MIN_BLUR", "REGIONS_COLOR", "paint", "Landroid/graphics/Paint;", "shadowMap", "", "Lcom/yandex/div/core/view2/ShadowCache$ShadowCacheKey;", "Landroid/graphics/NinePatch;", "createNewShadow", "context", "Landroid/content/Context;", "radii", "", "blur", "createNinePatchChunk", "", "width", "height", "getShadow", "", "Landroid/graphics/Bitmap;", "out", "drawNewShadow", "rectWidth", "rectHeight", "scale", "toNinePatch", "ShadowCacheKey", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ShadowCache {
    private static final int EDGE_OFFSET = 1;
    private static final float MAX_BLUR = 25.0f;
    private static final float MIN_BLUR = 1.0f;
    private static final int REGIONS_COLOR = 1;
    public static final ShadowCache INSTANCE = new ShadowCache();
    private static final Paint paint = new Paint();
    private static final Map<ShadowCacheKey, NinePatch> shadowMap = new LinkedHashMap();

    private ShadowCache() {
    }

    public final NinePatch getShadow(Context context, float[] radii, float blur) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(radii, "radii");
        Map<ShadowCacheKey, NinePatch> map = shadowMap;
        ShadowCacheKey shadowCacheKey = new ShadowCacheKey(radii, blur);
        NinePatch ninePatchCreateNewShadow = map.get(shadowCacheKey);
        if (ninePatchCreateNewShadow == null) {
            ninePatchCreateNewShadow = INSTANCE.createNewShadow(context, radii, blur);
            map.put(shadowCacheKey, ninePatchCreateNewShadow);
        }
        return ninePatchCreateNewShadow;
    }

    private final NinePatch createNewShadow(Context context, float[] radii, float blur) {
        float fMax = blur + Math.max(radii[1] + radii[2], radii[5] + radii[6]);
        float fMax2 = blur + Math.max(radii[0] + radii[7], radii[3] + radii[4]);
        float fCoerceIn = RangesKt.coerceIn(blur, 1.0f, MAX_BLUR);
        float f = blur <= MAX_BLUR ? 1.0f : MAX_BLUR / blur;
        float f2 = blur * 2;
        int i = (int) ((fMax + f2) * f);
        int i2 = (int) ((f2 + fMax2) * f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ALPHA_8);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(\n          ….Config.ALPHA_8\n        )");
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(i, i2, Bitmap.Config.ALPHA_8);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap2, "createBitmap(\n          ….Config.ALPHA_8\n        )");
        drawNewShadow(bitmapCreateBitmap, fMax, fMax2, radii, fCoerceIn, f);
        blur(bitmapCreateBitmap, context, bitmapCreateBitmap2, fCoerceIn);
        bitmapCreateBitmap.recycle();
        if (f < 1.0f) {
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapCreateBitmap2, (int) (bitmapCreateBitmap2.getWidth() / f), (int) (bitmapCreateBitmap2.getHeight() / f), true);
            bitmapCreateBitmap2.recycle();
            bitmapCreateBitmap2 = bitmapCreateScaledBitmap;
        }
        return toNinePatch(bitmapCreateBitmap2);
    }

    private final void drawNewShadow(Bitmap bitmap, float f, float f2, float[] fArr, float f3, float f4) {
        RoundRectShape roundRectShape = new RoundRectShape(fArr, null, null);
        roundRectShape.resize(f, f2);
        Canvas canvas = new Canvas();
        canvas.setBitmap(bitmap);
        int iSave = canvas.save();
        canvas.translate(f3, f3);
        try {
            iSave = canvas.save();
            canvas.scale(f4, f4, 0.0f, 0.0f);
            try {
                roundRectShape.draw(canvas, paint);
                canvas.restoreToCount(iSave);
            } finally {
                canvas.restoreToCount(iSave);
            }
        } catch (Throwable th) {
            canvas.restoreToCount(iSave);
            throw th;
        }
    }

    private final void blur(Bitmap bitmap, Context context, Bitmap bitmap2, float f) {
        RenderScript renderScriptCreate = RenderScript.create(context);
        ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.A_8(renderScriptCreate));
        Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmap);
        Allocation allocationCreateFromBitmap2 = Allocation.createFromBitmap(renderScriptCreate, bitmap2);
        scriptIntrinsicBlurCreate.setRadius(f);
        scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
        scriptIntrinsicBlurCreate.forEach(allocationCreateFromBitmap2);
        allocationCreateFromBitmap2.copyTo(bitmap2);
        allocationCreateFromBitmap2.destroy();
        allocationCreateFromBitmap.destroy();
        scriptIntrinsicBlurCreate.destroy();
    }

    private final NinePatch toNinePatch(Bitmap bitmap) {
        return new NinePatch(bitmap, createNinePatchChunk(bitmap.getWidth(), bitmap.getHeight()));
    }

    private final byte[] createNinePatchChunk(int width, int height) {
        int i = height / 2;
        int i2 = width / 2;
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(84).order(ByteOrder.nativeOrder());
        byteBufferOrder.put((byte) 1);
        byteBufferOrder.put((byte) 2);
        byteBufferOrder.put((byte) 2);
        byteBufferOrder.put((byte) 9);
        byteBufferOrder.putInt(0);
        byteBufferOrder.putInt(0);
        byteBufferOrder.putInt(0);
        byteBufferOrder.putInt(0);
        byteBufferOrder.putInt(0);
        byteBufferOrder.putInt(0);
        byteBufferOrder.putInt(0);
        byteBufferOrder.putInt(i2 - 1);
        byteBufferOrder.putInt(i2 + 1);
        byteBufferOrder.putInt(i - 1);
        byteBufferOrder.putInt(i + 1);
        for (int i3 = 0; i3 < 9; i3++) {
            byteBufferOrder.putInt(1);
        }
        byte[] bArrArray = byteBufferOrder.array();
        Intrinsics.checkNotNullExpressionValue(bArrArray, "buffer.array()");
        return bArrArray;
    }

    /* JADX INFO: compiled from: ShadowCache.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/yandex/div/core/view2/ShadowCache$ShadowCacheKey;", "", "radii", "", "blur", "", "([FF)V", "getBlur", "()F", "getRadii", "()[F", "equals", "", "other", "hashCode", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ShadowCacheKey {
        private final float blur;
        private final float[] radii;

        public ShadowCacheKey(float[] radii, float f) {
            Intrinsics.checkNotNullParameter(radii, "radii");
            this.radii = radii;
            this.blur = f;
        }

        public final float[] getRadii() {
            return this.radii;
        }

        public final float getBlur() {
            return this.blur;
        }

        public boolean equals(Object other) {
            if (!(other instanceof ShadowCacheKey)) {
                return false;
            }
            ShadowCacheKey shadowCacheKey = (ShadowCacheKey) other;
            return this.blur == shadowCacheKey.blur && Arrays.equals(this.radii, shadowCacheKey.radii);
        }

        public int hashCode() {
            return (Arrays.hashCode(this.radii) * 31) + Float.hashCode(this.blur);
        }
    }
}
