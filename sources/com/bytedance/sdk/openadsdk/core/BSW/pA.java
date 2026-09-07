package com.bytedance.sdk.openadsdk.core.BSW;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.core.omh;
import com.bytedance.sdk.component.ML.BSW;
import com.bytedance.sdk.component.ML.SGo;
import com.bytedance.sdk.component.ML.oX;
import com.bytedance.sdk.component.adexpress.ZZv.JG;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.Bzk.ZZv;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.widget.ML;
import com.bytedance.sdk.openadsdk.utils.DX;
import com.bytedance.sdk.openadsdk.utils.xy;
import com.safedk.android.analytics.brandsafety.creatives.discoveries.d;
import com.safedk.android.internal.partials.PangleFilesBridge;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class pA implements com.bytedance.adsdk.ugeno.pA {

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.BSW.pA$pA, reason: collision with other inner class name */
    public interface InterfaceC0229pA {
        void pA(Drawable drawable);
    }

    @Override // com.bytedance.adsdk.ugeno.pA
    public void pA(omh omhVar, String str, ImageView imageView) {
        String strPA = pA(str);
        if (imageView instanceof ML) {
            ML ml = (ML) imageView;
            ml.setAdjustViewBounds(true);
            ml.setBackgroundColor(0);
            ZZv.pA(strPA).KZx(3).pA(Bitmap.Config.RGB_565).pA(new Og(ml));
            return;
        }
        SGo sGoPA = ZZv.pA(strPA);
        pA(omhVar, sGoPA, strPA);
        sGoPA.pA(imageView);
    }

    private static class Og implements oX {
        private WeakReference<ML> pA;

        @Override // com.bytedance.sdk.component.ML.oX
        public void pA(int i, String str, Throwable th) {
        }

        public Og(ML ml) {
            this.pA = new WeakReference<>(ml);
        }

        @Override // com.bytedance.sdk.component.ML.oX
        public void pA(BSW bsw) {
            try {
                ML ml = this.pA.get();
                if (ml == null) {
                    return;
                }
                Object objOg = bsw.Og();
                if (objOg instanceof byte[]) {
                    if (bsw.ML()) {
                        ml.pA((byte[]) objOg, false);
                        ml.setRepeatConfig(true);
                        ml.Og();
                        return;
                    }
                    ml.setImageDrawable(DX.pA((byte[]) objOg, 0));
                    return;
                }
                if (objOg instanceof Bitmap) {
                    ml.setImageBitmap((Bitmap) objOg);
                }
            } catch (Throwable th) {
                pA(1002, "", th);
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.pA
    public void pA(omh omhVar, String str, ImageView imageView, int i, int i2) {
        String strPA = pA(str);
        SGo sGoKZx = ZZv.pA(strPA).KZx(3);
        pA(omhVar, sGoKZx, strPA);
        sGoKZx.pA(new KZx(imageView, this, i, i2), 4);
    }

    private static class KZx implements oX {
        private final int KZx;
        private final pA Og;
        private final int ZZv;
        private final WeakReference<ImageView> pA;

        @Override // com.bytedance.sdk.component.ML.oX
        public void pA(int i, String str, Throwable th) {
        }

        public KZx(ImageView imageView, pA pAVar, int i, int i2) {
            this.pA = new WeakReference<>(imageView);
            this.Og = pAVar;
            this.KZx = i;
            this.ZZv = i2;
        }

        @Override // com.bytedance.sdk.component.ML.oX
        public void pA(BSW bsw) {
            try {
                final ImageView imageView = this.pA.get();
                if (imageView == null) {
                    return;
                }
                final Object objOg = bsw.Og();
                if (objOg instanceof byte[]) {
                    if (bsw.ML()) {
                        if (Build.VERSION.SDK_INT <= 30) {
                            this.Og.pA((byte[]) objOg, imageView);
                            return;
                        } else {
                            this.Og.pA(imageView, (byte[]) objOg, this.KZx, this.ZZv);
                            return;
                        }
                    }
                    if (this.Og.pA((byte[]) objOg)) {
                        this.Og.pA(imageView, (byte[]) objOg, this.KZx, this.ZZv);
                        return;
                    }
                    final Bitmap bitmapPA = new com.bytedance.sdk.component.ML.KZx.Og.pA(this.KZx, this.ZZv, imageView.getScaleType(), Bitmap.Config.RGB_565, this.KZx, this.ZZv).pA((byte[]) objOg);
                    if (bitmapPA != null) {
                        xy.pA((Runnable) new com.bytedance.sdk.component.omh.omh("load_static_img") { // from class: com.bytedance.sdk.openadsdk.core.BSW.pA.KZx.1
                            @Override // java.lang.Runnable
                            public void run() {
                                imageView.setImageBitmap(bitmapPA);
                            }
                        });
                        return;
                    }
                    return;
                }
                if (objOg instanceof Bitmap) {
                    xy.pA((Runnable) new com.bytedance.sdk.component.omh.omh("ug_load_bitmap") { // from class: com.bytedance.sdk.openadsdk.core.BSW.pA.KZx.2
                        @Override // java.lang.Runnable
                        public void run() {
                            imageView.setImageBitmap((Bitmap) objOg);
                        }
                    });
                }
            } catch (Throwable th) {
                WV.pA("ImageLoaderProvider", th.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(final ImageView imageView, byte[] bArr, int i, int i2) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                final Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(ImageDecoder.createSource(byteBufferWrap));
                if (drawableDecodeDrawable != null) {
                    xy.pA((Runnable) new com.bytedance.sdk.component.omh.omh("loadAnimatedDrawable") { // from class: com.bytedance.sdk.openadsdk.core.BSW.pA.1
                        @Override // java.lang.Runnable
                        public void run() {
                            imageView.setImageDrawable(drawableDecodeDrawable);
                        }
                    });
                    return;
                }
                return;
            } catch (IOException e) {
                WV.pA("ImageLoaderProvider", e.getMessage());
                return;
            }
        }
        Og(imageView, bArr, i, i2);
    }

    private void Og(final ImageView imageView, byte[] bArr, int i, int i2) {
        final Bitmap bitmapPA = new com.bytedance.sdk.component.ML.KZx.Og.pA(i, i2, imageView.getScaleType(), Bitmap.Config.ARGB_4444, i, i2).pA(bArr);
        if (bitmapPA != null) {
            xy.pA((Runnable) new com.bytedance.sdk.component.omh.omh("loadStaticImage") { // from class: com.bytedance.sdk.openadsdk.core.BSW.pA.2
                @Override // java.lang.Runnable
                public void run() {
                    imageView.setImageBitmap(bitmapPA);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(byte[] bArr, final ImageView imageView) {
        try {
            WV.pA("ImageLoaderProvider", "load animation image");
            pA(bArr, new InterfaceC0229pA() { // from class: com.bytedance.sdk.openadsdk.core.BSW.pA.3
                @Override // com.bytedance.sdk.openadsdk.core.BSW.pA.InterfaceC0229pA
                public void pA(final Drawable drawable) {
                    xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.BSW.pA.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (Build.VERSION.SDK_INT >= 28) {
                                Drawable drawable2 = drawable;
                                if (drawable2 instanceof AnimatedImageDrawable) {
                                    ((AnimatedImageDrawable) drawable2).start();
                                }
                            }
                            imageView.setImageDrawable(drawable);
                        }
                    });
                }
            });
        } catch (Exception e) {
            WV.pA("ImageLoaderProvider", e.getMessage());
        }
    }

    private void pA(final byte[] bArr, final InterfaceC0229pA interfaceC0229pA) {
        xy.Og(new com.bytedance.sdk.component.omh.omh("pag_animation_drawable") { // from class: com.bytedance.sdk.openadsdk.core.BSW.pA.4
            @Override // java.lang.Runnable
            public void run() {
                Drawable drawableOg = pA.this.Og(bArr);
                InterfaceC0229pA interfaceC0229pA2 = interfaceC0229pA;
                if (interfaceC0229pA2 != null) {
                    interfaceC0229pA2.pA(drawableOg);
                }
            }
        });
    }

    public boolean pA(byte[] bArr) {
        return JG.pA(bArr, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable Og(byte[] bArr) {
        FileOutputStream fileOutputStreamFileOutputStreamCtor;
        try {
            boolean zKZx = com.bytedance.sdk.openadsdk.multipro.Og.KZx();
            File filePA = com.bytedance.sdk.component.utils.JG.pA(aBv.pA(), zKZx, zKZx ? "UGEN_GIF_AD_CACHE/" : "/UGEN_GIF_CACHE/", "TT_UGEN_GIF_FILE");
            fileOutputStreamFileOutputStreamCtor = PangleFilesBridge.fileOutputStreamCtor(filePA);
            try {
                fileOutputStreamFileOutputStreamCtor.write(bArr, 0, bArr.length);
                if (Build.VERSION.SDK_INT >= 28) {
                    Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(ImageDecoder.createSource(filePA));
                    try {
                        fileOutputStreamFileOutputStreamCtor.close();
                    } catch (Throwable unused) {
                    }
                    return drawableDecodeDrawable;
                }
                BitmapDrawable bitmapDrawable = new BitmapDrawable(aBv.pA().getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                try {
                    fileOutputStreamFileOutputStreamCtor.close();
                } catch (Throwable unused2) {
                }
                return bitmapDrawable;
            } catch (Throwable th) {
                th = th;
                try {
                    WV.pA("ImageLoaderProvider", "GifView  getSourceByFile fail : ", th);
                    return null;
                } finally {
                    if (fileOutputStreamFileOutputStreamCtor != null) {
                        try {
                            fileOutputStreamFileOutputStreamCtor.close();
                        } catch (Throwable unused3) {
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStreamFileOutputStreamCtor = null;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.pA
    public void pA(omh omhVar, String str, com.bytedance.adsdk.ugeno.pA.InterfaceC0181pA interfaceC0181pA) {
        Og(omhVar, pA(str), interfaceC0181pA);
    }

    public void Og(omh omhVar, String str, final com.bytedance.adsdk.ugeno.pA.InterfaceC0181pA interfaceC0181pA) {
        SGo sGoKZx = ZZv.pA(str).KZx(1);
        pA(omhVar, sGoKZx, str);
        sGoKZx.pA(new oX() { // from class: com.bytedance.sdk.openadsdk.core.BSW.pA.5
            @Override // com.bytedance.sdk.component.ML.oX
            public void pA(BSW bsw) {
                if (bsw == null) {
                    interfaceC0181pA.pA(null);
                    return;
                }
                if (interfaceC0181pA != null) {
                    Object objOg = bsw.Og();
                    if (objOg instanceof Bitmap) {
                        interfaceC0181pA.pA((Bitmap) objOg);
                        return;
                    }
                    if (bsw.Og() instanceof byte[]) {
                        try {
                            interfaceC0181pA.pA(BitmapFactory.decodeByteArray((byte[]) bsw.Og(), 0, ((byte[]) bsw.Og()).length));
                            return;
                        } catch (Throwable unused) {
                        }
                    }
                    interfaceC0181pA.pA(null);
                }
            }

            @Override // com.bytedance.sdk.component.ML.oX
            public void pA(int i, String str2, Throwable th) {
                com.bytedance.adsdk.ugeno.pA.InterfaceC0181pA interfaceC0181pA2 = interfaceC0181pA;
                if (interfaceC0181pA2 != null) {
                    interfaceC0181pA2.pA(null);
                }
            }
        }, 4);
    }

    private void pA(omh omhVar, SGo sGo, String str) {
        Map<String, Object> mapOg;
        if (omhVar == null || (mapOg = omhVar.Og()) == null) {
            return;
        }
        Object obj = mapOg.get("image_info");
        if (obj instanceof Map) {
            sGo.pA((String) ((Map) obj).get(str));
        }
        String str2 = (String) mapOg.get("cache_dir");
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        sGo.Og(str2);
    }

    private String pA(String str) {
        if (TextUtils.isEmpty(str) || str.startsWith(d.v) || str.startsWith("https://")) {
            return str;
        }
        if (str.indexOf(46) < 0) {
            str = str + ".png";
        }
        return com.bytedance.sdk.openadsdk.core.settings.oX.vkV().Gag() + "static/" + str;
    }
}
