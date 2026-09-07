package com.bytedance.adsdk.ugeno.Bzk.ZZv;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.SD.ZZv;
import com.bytedance.adsdk.ugeno.SD.omh;

/* JADX INFO: loaded from: classes8.dex */
public class KZx extends com.bytedance.adsdk.ugeno.Og.KZx<pA> {
    protected boolean KZx;
    protected ImageView.ScaleType Og;
    private int ZZv;
    private float guZ;
    private float npn;
    protected String pA;

    public KZx(Context context) {
        super(context);
        this.Og = ImageView.ScaleType.FIT_XY;
        this.ZZv = -1;
        this.guZ = -1.0f;
        this.npn = -1.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.Og.KZx
    public void Og() {
        super.Og();
        KZx();
        ((pA) this.omh).setScaleType(this.Og);
        ((pA) this.omh).setBorderColor(this.SXO);
        ((pA) this.omh).setCornerRadius(this.fN);
        ((pA) this.omh).setBorderWidth(this.lx);
        if (this.ZZv != -1) {
            ((pA) this.omh).setColorFilter(this.ZZv);
        }
    }

    public void omh(String str) {
        this.pA = str;
    }

    private void KZx() {
        if (TextUtils.isEmpty(this.pA)) {
            return;
        }
        ((pA) this.omh).setImageDrawable(null);
        if (this.pA.startsWith("local://")) {
            try {
                ((pA) this.omh).setImageResource(ZZv.pA(this.ML, this.pA.replace("local://", "")));
            } catch (Throwable unused) {
            }
        } else {
            if (this.pA.startsWith("@")) {
                try {
                    ((pA) this.omh).setImageResource(Integer.parseInt(this.pA.substring(1)));
                    return;
                } catch (Exception unused2) {
                    return;
                }
            }
            fN();
        }
    }

    private void fN() {
        if (this.guZ > 0.0f) {
            com.bytedance.adsdk.ugeno.ZZv.pA().Og().pA(this.WV, this.pA, new com.bytedance.adsdk.ugeno.pA.InterfaceC0181pA() { // from class: com.bytedance.adsdk.ugeno.Bzk.ZZv.KZx.1
                @Override // com.bytedance.adsdk.ugeno.pA.InterfaceC0181pA
                public void pA(Bitmap bitmap) {
                    if (bitmap == null) {
                        return;
                    }
                    final Bitmap bitmapPA = omh.pA(KZx.this.ML, bitmap, (int) KZx.this.guZ);
                    if (bitmapPA != null) {
                        omh.pA(new Runnable() { // from class: com.bytedance.adsdk.ugeno.Bzk.ZZv.KZx.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ((pA) KZx.this.omh).setImageBitmap(bitmapPA);
                            }
                        });
                    }
                    if (KZx.this.KZx || KZx.this.npn > 0.0f) {
                        Bitmap bitmapPA2 = omh.pA(KZx.this.ML, bitmap, KZx.this.npn > 0.0f ? (int) KZx.this.npn : 10);
                        if (bitmapPA2 != null) {
                            final BitmapDrawable bitmapDrawable = new BitmapDrawable(KZx.this.ML.getResources(), bitmapPA2);
                            omh.pA(new Runnable() { // from class: com.bytedance.adsdk.ugeno.Bzk.ZZv.KZx.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    ((pA) KZx.this.omh).setBackground(bitmapDrawable);
                                }
                            });
                        }
                    }
                }
            });
            return;
        }
        com.bytedance.adsdk.ugeno.ZZv.pA().Og().pA(this.WV, this.pA, (ImageView) this.omh, ((pA) this.omh).getWidth(), ((pA) this.omh).getHeight());
        if (this.KZx || this.npn > 0.0f) {
            com.bytedance.adsdk.ugeno.ZZv.pA().Og().pA(this.WV, this.pA, new com.bytedance.adsdk.ugeno.pA.InterfaceC0181pA() { // from class: com.bytedance.adsdk.ugeno.Bzk.ZZv.KZx.2
                @Override // com.bytedance.adsdk.ugeno.pA.InterfaceC0181pA
                public void pA(Bitmap bitmap) {
                    if (bitmap == null) {
                        return;
                    }
                    final Bitmap bitmapPA = omh.pA(KZx.this.ML, bitmap, KZx.this.npn > 0.0f ? (int) KZx.this.npn : 10);
                    omh.pA(new Runnable() { // from class: com.bytedance.adsdk.ugeno.Bzk.ZZv.KZx.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (bitmapPA != null) {
                                ((pA) KZx.this.omh).setBackground(new BitmapDrawable(KZx.this.ML.getResources(), bitmapPA));
                            }
                        }
                    });
                }
            });
        }
    }

    @Override // com.bytedance.adsdk.ugeno.Og.KZx
    /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
    public pA ZZv() {
        pA pAVar = new pA(this.ML);
        pAVar.pA(this);
        return pAVar;
    }

    @Override // com.bytedance.adsdk.ugeno.Og.KZx
    public void pA(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.pA(str, str2);
        str.hashCode();
        switch (str) {
            case "scaleMode":
            case "scaleType":
                this.Og = SD(str2);
                break;
            case "imageBlur":
                this.guZ = com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, -1.0f);
                break;
            case "isBgGaussianBlur":
                this.KZx = com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, false);
                break;
            case "src":
                this.pA = str2;
                break;
            case "tintColor":
                this.ZZv = com.bytedance.adsdk.ugeno.SD.pA.pA(str2);
                break;
            case "imageBgBlur":
                this.npn = com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, -1.0f);
                break;
        }
    }

    private ImageView.ScaleType SD(String str) {
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
        str.hashCode();
        switch (str) {
            case "center":
                return ImageView.ScaleType.CENTER;
            case "fitEnd":
                return ImageView.ScaleType.FIT_END;
            case "fitStart":
                return ImageView.ScaleType.FIT_START;
            case "centerInside":
                return ImageView.ScaleType.CENTER_INSIDE;
            case "fit":
            case "fitCenter":
                return ImageView.ScaleType.FIT_CENTER;
            case "crop":
            case "centerCrop":
                return ImageView.ScaleType.CENTER_CROP;
            case "fill":
            case "fitXY":
                return ImageView.ScaleType.FIT_XY;
            default:
                return scaleType;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.Og.KZx, com.bytedance.adsdk.ugeno.KZx
    public void SD() {
        super.SD();
        ((pA) this.omh).post(new Runnable() { // from class: com.bytedance.adsdk.ugeno.Bzk.ZZv.KZx.3
            @Override // java.lang.Runnable
            public void run() {
                Drawable drawable = ((pA) KZx.this.omh).getDrawable();
                if (Build.VERSION.SDK_INT < 28 || !(drawable instanceof AnimatedImageDrawable)) {
                    return;
                }
                ((AnimatedImageDrawable) drawable).start();
            }
        });
    }

    @Override // com.bytedance.adsdk.ugeno.Og.KZx, com.bytedance.adsdk.ugeno.KZx
    public void omh() {
        super.omh();
        Drawable drawable = ((pA) this.omh).getDrawable();
        if (Build.VERSION.SDK_INT < 28 || !(drawable instanceof AnimatedImageDrawable)) {
            return;
        }
        ((AnimatedImageDrawable) drawable).stop();
    }
}
