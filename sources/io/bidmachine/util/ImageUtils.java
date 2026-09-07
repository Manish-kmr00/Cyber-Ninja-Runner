package io.bidmachine.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.safedk.android.internal.partials.BidMachineFilesBridge;
import io.bidmachine.util.file.FileUtilsKt;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageUtils.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\nH\u0007J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\nH\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J \u0010\u0011\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\nH\u0007J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\nH\u0007J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\nH\u0007J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\nH\u0007J\u0018\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\bH\u0007J\"\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\nH\u0007¨\u0006\u0017"}, d2 = {"Lio/bidmachine/util/ImageUtils;", "", "()V", "compressSafely", "", "bitmap", "Landroid/graphics/Bitmap;", "outputStream", "Ljava/io/OutputStream;", "createDefaultBitmapFactoryOptions", "Landroid/graphics/BitmapFactory$Options;", "getImageByFile", "file", "Ljava/io/File;", "bitmapFactoryOptions", "recycleSafely", "", "saveImageWithCompress", "byteImage", "", "toBitmap", "toBitmapWithCompress", "writeBitmapWithCompress", "bidmachine-android-util_d_0_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ImageUtils {
    public static final ImageUtils INSTANCE = new ImageUtils();

    private ImageUtils() {
    }

    @JvmStatic
    public static final BitmapFactory.Options createDefaultBitmapFactoryOptions() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        return options;
    }

    @JvmStatic
    public static final Bitmap toBitmap(File file, BitmapFactory.Options bitmapFactoryOptions) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(bitmapFactoryOptions, "bitmapFactoryOptions");
        try {
            return BitmapFactory.decodeFile(file.getPath(), bitmapFactoryOptions);
        } catch (Throwable unused) {
            return null;
        }
    }

    @JvmStatic
    public static final Bitmap toBitmap(byte[] byteImage, BitmapFactory.Options bitmapFactoryOptions) {
        Intrinsics.checkNotNullParameter(byteImage, "byteImage");
        Intrinsics.checkNotNullParameter(bitmapFactoryOptions, "bitmapFactoryOptions");
        try {
            return BitmapFactory.decodeByteArray(byteImage, 0, byteImage.length, bitmapFactoryOptions);
        } catch (Throwable unused) {
            return null;
        }
    }

    @JvmStatic
    public static final Bitmap toBitmapWithCompress(byte[] byteImage) {
        Intrinsics.checkNotNullParameter(byteImage, "byteImage");
        return toBitmapWithCompress(byteImage, createDefaultBitmapFactoryOptions());
    }

    @JvmStatic
    public static final Bitmap toBitmapWithCompress(byte[] byteImage, BitmapFactory.Options bitmapFactoryOptions) {
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        Intrinsics.checkNotNullParameter(byteImage, "byteImage");
        Intrinsics.checkNotNullParameter(bitmapFactoryOptions, "bitmapFactoryOptions");
        bitmapFactoryOptions.inJustDecodeBounds = false;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(byteImage.length);
            try {
                if (writeBitmapWithCompress(byteImage, byteArrayOutputStream, bitmapFactoryOptions)) {
                    byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                    try {
                        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(byteArrayInputStream);
                        UtilsKt.finalize(byteArrayOutputStream);
                        UtilsKt.closeSafely(byteArrayInputStream);
                        return bitmapDecodeStream;
                    } catch (Throwable unused) {
                    }
                } else {
                    UtilsKt.finalize(byteArrayOutputStream);
                    UtilsKt.closeSafely(null);
                    return null;
                }
            } catch (Throwable unused2) {
                byteArrayInputStream = null;
            }
        } catch (Throwable unused3) {
            byteArrayInputStream = null;
            byteArrayOutputStream = null;
        }
        UtilsKt.finalize(byteArrayOutputStream);
        UtilsKt.closeSafely(byteArrayInputStream);
        return null;
    }

    @JvmStatic
    public static final boolean writeBitmapWithCompress(byte[] byteImage, OutputStream outputStream) {
        Intrinsics.checkNotNullParameter(byteImage, "byteImage");
        Intrinsics.checkNotNullParameter(outputStream, "outputStream");
        return writeBitmapWithCompress(byteImage, outputStream, createDefaultBitmapFactoryOptions());
    }

    public static /* synthetic */ boolean writeBitmapWithCompress$default(byte[] bArr, OutputStream outputStream, BitmapFactory.Options options, int i, Object obj) {
        if ((i & 4) != 0) {
            options = createDefaultBitmapFactoryOptions();
        }
        return writeBitmapWithCompress(bArr, outputStream, options);
    }

    @JvmStatic
    public static final boolean writeBitmapWithCompress(byte[] byteImage, OutputStream outputStream, BitmapFactory.Options bitmapFactoryOptions) {
        Intrinsics.checkNotNullParameter(byteImage, "byteImage");
        Intrinsics.checkNotNullParameter(outputStream, "outputStream");
        Intrinsics.checkNotNullParameter(bitmapFactoryOptions, "bitmapFactoryOptions");
        Bitmap bitmap = toBitmap(byteImage, bitmapFactoryOptions);
        if (bitmap != null) {
            return ImageUtilsKt.compressSafely(bitmap, outputStream);
        }
        return false;
    }

    @JvmStatic
    public static final boolean compressSafely(Bitmap bitmap, OutputStream outputStream) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(outputStream, "outputStream");
        return ImageUtilsKt.compressSafely(bitmap, outputStream);
    }

    @JvmStatic
    public static final void recycleSafely(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        ImageUtilsKt.recycleSafely(bitmap);
    }

    @JvmStatic
    public static final Bitmap getImageByFile(File file, BitmapFactory.Options bitmapFactoryOptions) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(bitmapFactoryOptions, "bitmapFactoryOptions");
        if (FileUtilsKt.isNullOrEmpty(file)) {
            return null;
        }
        return toBitmap(file, bitmapFactoryOptions);
    }

    @JvmStatic
    public static final boolean saveImageWithCompress(File file, byte[] byteImage) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(byteImage, "byteImage");
        return saveImageWithCompress(file, byteImage, createDefaultBitmapFactoryOptions());
    }

    @JvmStatic
    public static final boolean saveImageWithCompress(File file, byte[] byteImage, BitmapFactory.Options bitmapFactoryOptions) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(byteImage, "byteImage");
        Intrinsics.checkNotNullParameter(bitmapFactoryOptions, "bitmapFactoryOptions");
        bitmapFactoryOptions.inJustDecodeBounds = false;
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStreamFileOutputStreamCtor = BidMachineFilesBridge.fileOutputStreamCtor(file);
            try {
                writeBitmapWithCompress(byteImage, fileOutputStreamFileOutputStreamCtor, bitmapFactoryOptions);
                UtilsKt.finalize(fileOutputStreamFileOutputStreamCtor);
                return true;
            } catch (Throwable unused) {
                fileOutputStream = fileOutputStreamFileOutputStreamCtor;
                UtilsKt.finalize(fileOutputStream);
                return false;
            }
        } catch (Throwable unused2) {
        }
    }
}
