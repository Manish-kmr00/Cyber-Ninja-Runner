package com.bytedance.sdk.openadsdk.Bzk;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.sdk.component.ML.BSW;
import com.bytedance.sdk.component.ML.oX;
import com.bytedance.sdk.openadsdk.core.Sn;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.xy;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes4.dex */
public class KZx implements oX<Bitmap> {
    private final String Og = "ImageLoaderToViewWrapper";
    private final WeakReference<ImageView> pA;

    @Override // com.bytedance.sdk.component.ML.oX
    public void pA(int i, String str, Throwable th) {
    }

    public static oX pA(yFO yfo, String str, ImageView imageView) {
        return new Og(yfo, str, new KZx(imageView));
    }

    private KZx(ImageView imageView) {
        this.pA = new WeakReference<>(imageView);
    }

    @Override // com.bytedance.sdk.component.ML.oX
    public void pA(BSW<Bitmap> bsw) {
        final ImageView imageView = this.pA.get();
        if (imageView == null || !(bsw.Og() instanceof Bitmap)) {
            return;
        }
        final Bitmap bitmapOg = bsw.Og();
        if (xy.ML()) {
            imageView.setImageBitmap(bitmapOg);
        } else {
            Sn.KZx().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.Bzk.KZx.1
                @Override // java.lang.Runnable
                public void run() {
                    imageView.setImageBitmap(bitmapOg);
                }
            });
        }
    }
}
