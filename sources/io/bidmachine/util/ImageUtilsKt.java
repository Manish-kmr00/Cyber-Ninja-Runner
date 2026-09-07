package io.bidmachine.util;

import android.graphics.Bitmap;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageUtils.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0002¨\u0006\u0007"}, d2 = {"compressSafely", "", "Landroid/graphics/Bitmap;", "outputStream", "Ljava/io/OutputStream;", "recycleSafely", "", "bidmachine-android-util_d_0_4_0"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ImageUtilsKt {
    public static final boolean compressSafely(Bitmap bitmap, OutputStream outputStream) {
        Intrinsics.checkNotNullParameter(bitmap, "<this>");
        Intrinsics.checkNotNullParameter(outputStream, "outputStream");
        try {
            bitmap.compress(Bitmap.CompressFormat.PNG, 85, outputStream);
            recycleSafely(bitmap);
            return true;
        } catch (Throwable unused) {
            recycleSafely(bitmap);
            return false;
        }
    }

    public static final void recycleSafely(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "<this>");
        try {
            bitmap.recycle();
            Unit unit = Unit.INSTANCE;
        } catch (Throwable unused) {
        }
    }
}
