package com.bytedance.sdk.component.adexpress.ZZv;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class JG {
    private static final byte[] pA = pA("VP8X");

    private static byte[] pA(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException unused) {
            return new byte[1];
        }
    }

    private static void KZx(ImageView imageView, byte[] bArr, int i, int i2) {
        ZZv(imageView, bArr, i, i2);
    }

    public static void pA(ImageView imageView, byte[] bArr, int i, int i2) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                imageView.setImageDrawable(ImageDecoder.decodeDrawable(ImageDecoder.createSource(byteBufferWrap)));
            } catch (IOException unused) {
            }
        } else {
            ZZv(imageView, bArr, i, i2);
        }
    }

    private static void ZZv(ImageView imageView, byte[] bArr, int i, int i2) {
        Bitmap bitmapPA = new com.bytedance.sdk.component.ML.KZx.Og.pA(i, i2, imageView.getScaleType(), Bitmap.Config.ARGB_4444, i, i2).pA(bArr);
        if (bitmapPA != null) {
            imageView.setImageBitmap(bitmapPA);
        }
    }

    public static void Og(ImageView imageView, byte[] bArr, int i, int i2) {
        if (TextUtils.equals("png", com.bytedance.sdk.component.utils.omh.pA(Arrays.copyOfRange(bArr, 0, com.bytedance.sdk.component.utils.omh.pA())))) {
            KZx(imageView, bArr, i, i2);
        } else {
            pA(imageView, bArr, i, i2);
        }
    }

    public static boolean pA(byte[] bArr, int i) {
        try {
            boolean zPA = pA(bArr, i + 12, pA);
            int i2 = i + 20;
            if (bArr.length <= i2) {
                return false;
            }
            boolean z = (bArr[i2] & 2) == 2;
            if (zPA && z) {
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static boolean pA(byte[] bArr, int i, byte[] bArr2) {
        if (bArr2 == null || bArr == null || bArr2.length + i > bArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if (bArr[i2 + i] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }
}
