package com.bytedance.sdk.openadsdk.utils;

import android.graphics.Bitmap;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes13.dex */
public class eG implements com.bytedance.sdk.component.ML.oX<Bitmap> {
    private final WeakReference<ImageView> pA;

    public eG(ImageView imageView) {
        this.pA = new WeakReference<>(imageView);
    }

    @Override // com.bytedance.sdk.component.ML.oX
    public void pA(com.bytedance.sdk.component.ML.BSW<Bitmap> bsw) {
        ImageView imageView = this.pA.get();
        if (imageView == null) {
            return;
        }
        if (bsw != null) {
            try {
                if (bsw.Og() != null) {
                    imageView.setImageBitmap(bsw.Og());
                    return;
                }
            } catch (Throwable unused) {
                imageView.setVisibility(8);
                return;
            }
        }
        imageView.setVisibility(8);
    }

    @Override // com.bytedance.sdk.component.ML.oX
    public void pA(int i, String str, Throwable th) {
        ImageView imageView = this.pA.get();
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(8);
    }
}
