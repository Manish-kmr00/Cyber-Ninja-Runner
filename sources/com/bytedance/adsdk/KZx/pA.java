package com.bytedance.adsdk.KZx;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.adsdk.Og.JG;
import com.bytedance.adsdk.Og.SGo;
import com.bytedance.adsdk.Og.ZZv;
import com.bytedance.adsdk.ugeno.KZx.Og;
import com.bytedance.adsdk.ugeno.Og.KZx;
import com.bytedance.adsdk.ugeno.SD.omh;
import java.util.HashMap;

/* JADX INFO: loaded from: classes10.dex */
public class pA extends KZx<JG> {
    protected ImageView.ScaleType KZx;
    protected HashMap<String, Bitmap> Og;
    private float Xj;
    protected ImageView.ScaleType ZZv;
    private int dGZ;
    private String guZ;
    private boolean npn;
    protected String pA;
    private boolean qQU;

    @Deprecated
    private boolean rjD;
    private float vkV;

    public pA(Context context) {
        super(context);
        this.guZ = "images";
        this.vkV = 1.0f;
        this.KZx = ImageView.ScaleType.FIT_CENTER;
        this.ZZv = ImageView.ScaleType.FIT_XY;
        this.Og = new HashMap<>();
    }

    @Override // com.bytedance.adsdk.ugeno.Og.KZx
    /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
    public JG ZZv() {
        JG jg = new JG(this.ML);
        jg.pA(this);
        return jg;
    }

    @Override // com.bytedance.adsdk.ugeno.Og.KZx
    public void Og() {
        super.Og();
        ((JG) this.omh).setProgress(this.Xj);
        if (this.vkV <= 0.0f) {
            this.vkV = 1.0f;
        }
        ((JG) this.omh).setSpeed(this.vkV);
        if (this.pA.startsWith("local")) {
            ((JG) this.omh).setAnimation(SD(this.pA));
            ((JG) this.omh).setImageAssetsFolder(this.guZ);
        } else {
            ((JG) this.omh).setAnimationFromUrl(this.pA);
        }
        ((JG) this.omh).setImageAssetDelegate(new AnonymousClass1());
        if (roi()) {
            ((JG) this.omh).setScaleType(this.ZZv);
        } else {
            ((JG) this.omh).setScaleType(this.KZx);
        }
        if (roi()) {
            ((JG) this.omh).setRepeatCount(this.dGZ);
        } else {
            ((JG) this.omh).pA(this.rjD);
        }
        KZx();
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.KZx.pA$1, reason: invalid class name */
    class AnonymousClass1 implements ZZv {
        AnonymousClass1() {
        }

        @Override // com.bytedance.adsdk.Og.ZZv
        public Bitmap pA(final SGo sGo) {
            final String strPA;
            if (sGo == null) {
                return null;
            }
            String strSGo = sGo.SGo();
            String strBzk = sGo.Bzk();
            if (!TextUtils.isEmpty(strSGo) && TextUtils.isEmpty(strBzk)) {
                strPA = Og.pA(strSGo, pA.this.SD);
            } else if (!TextUtils.isEmpty(strBzk) && TextUtils.isEmpty(strSGo)) {
                strPA = Og.pA(strBzk, pA.this.SD);
            } else {
                strPA = (TextUtils.isEmpty(strBzk) || TextUtils.isEmpty(strSGo)) ? null : Og.pA(strSGo, pA.this.SD) + Og.pA(strBzk, pA.this.SD);
            }
            if (TextUtils.isEmpty(strPA)) {
                return null;
            }
            Bitmap bitmap = pA.this.Og.get(strPA);
            if (bitmap != null) {
                return bitmap;
            }
            com.bytedance.adsdk.ugeno.ZZv.pA().Og().pA(pA.this.WV, strPA, new com.bytedance.adsdk.ugeno.pA.InterfaceC0181pA() { // from class: com.bytedance.adsdk.KZx.pA.1.1
                @Override // com.bytedance.adsdk.ugeno.pA.InterfaceC0181pA
                public void pA(Bitmap bitmap2) {
                    if (bitmap2 != null) {
                        final Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap2, sGo.pA(), sGo.Og(), false);
                        pA.this.Og.put(strPA, bitmapCreateScaledBitmap);
                        omh.pA(new Runnable() { // from class: com.bytedance.adsdk.KZx.pA.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ((JG) pA.this.omh).pA(sGo.omh(), bitmapCreateScaledBitmap);
                            }
                        });
                    }
                }
            });
            return pA.this.Og.get(strPA);
        }
    }

    protected void KZx() {
        ((JG) this.omh).pA();
    }

    @Override // com.bytedance.adsdk.ugeno.Og.KZx
    public void pA(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.pA(str, str2);
        str.hashCode();
        switch (str) {
            case "scaleMode":
                this.ZZv = Bzk(str2);
                break;
            case "scaleType":
                this.KZx = omh(str2);
                break;
            case "progress":
                this.Xj = com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, 0.0f);
                break;
            case "imagePath":
                this.guZ = str2;
                break;
            case "autoReverse":
                this.npn = com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, false);
                break;
            case "src":
                this.pA = str2;
                break;
            case "loop":
                if (roi()) {
                    this.dGZ = com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, 0);
                    break;
                } else {
                    this.rjD = com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, false);
                    break;
                }
                break;
            case "speed":
                this.vkV = com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, 1.0f);
                break;
            case "autoPlay":
                this.qQU = com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, false);
                break;
            case "autoplay":
                this.qQU = com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, true);
                break;
        }
    }

    private String SD(String str) {
        if (TextUtils.isEmpty(str) || !str.contains("local")) {
            return "";
        }
        if (str.contains("shake_phone")) {
            return "lottie_json/shake_phone.json";
        }
        return str.contains("swipe_right") ? "lottie_json/swipe_right.json" : "";
    }

    private ImageView.ScaleType omh(String str) {
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
            case "fitXY":
                return ImageView.ScaleType.FIT_XY;
            case "fitCenter":
                return ImageView.ScaleType.FIT_CENTER;
            case "centerCrop":
                return ImageView.ScaleType.CENTER_CROP;
            default:
                return scaleType;
        }
    }

    private ImageView.ScaleType Bzk(String str) {
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
        str.hashCode();
        switch (str) {
            case "center":
            case "none":
                return ImageView.ScaleType.CENTER;
            case "fit":
                return ImageView.ScaleType.FIT_CENTER;
            case "crop":
                return ImageView.ScaleType.CENTER_CROP;
            case "fill":
                return ImageView.ScaleType.FIT_XY;
            default:
                return scaleType;
        }
    }
}
