package com.bytedance.sdk.component.adexpress.JG;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class SGo extends com.bytedance.adsdk.Og.JG {
    private String Og;
    private Map<String, Bitmap> pA;

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    public void setAnimationsLoop(boolean z) {
    }

    public void setData(Map<String, String> map) {
    }

    public void setLottieAdDescMaxLength(int i) {
    }

    public void setLottieAdTitleMaxLength(int i) {
    }

    public void setLottieAppNameMaxLength(int i) {
    }

    public SGo(Context context) {
        super(context);
        this.pA = new HashMap();
    }

    public void setImageLottieTosPath(String str) {
        this.Og = str;
    }

    public void omh() {
        if (TextUtils.isEmpty(this.Og)) {
            return;
        }
        setProgress(0.0f);
        pA(true);
        setAnimationFromUrl(this.Og);
        setImageAssetDelegate(new com.bytedance.adsdk.Og.ZZv() { // from class: com.bytedance.sdk.component.adexpress.JG.SGo.1
            @Override // com.bytedance.adsdk.Og.ZZv
            public Bitmap pA(final com.bytedance.adsdk.Og.SGo sGo) {
                final String strOmh = sGo.omh();
                String strSGo = sGo.SGo();
                String strBzk = sGo.Bzk();
                if (TextUtils.equals(strOmh, "image_0") && TextUtils.equals(strBzk, "Lark20201123-180048_2.png")) {
                    strBzk = "hand.png";
                }
                Bitmap bitmap = (Bitmap) SGo.this.pA.get(strOmh);
                if (bitmap != null) {
                    return bitmap;
                }
                new Object[]{"dirName is : ", strSGo, "fileName is : ", strBzk};
                if (TextUtils.isEmpty(strSGo) || !TextUtils.isEmpty(strBzk)) {
                    if (!TextUtils.isEmpty(strBzk) && TextUtils.isEmpty(strSGo)) {
                        strSGo = strBzk;
                    } else if (!TextUtils.isEmpty(strBzk) && !TextUtils.isEmpty(strSGo)) {
                        strSGo = strSGo + strBzk;
                    } else {
                        strSGo = "";
                    }
                }
                if (TextUtils.isEmpty(strSGo)) {
                    return null;
                }
                com.bytedance.sdk.component.ML.SGo sGoPA = com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().ML().pA(strSGo).pA(new com.bytedance.sdk.component.ML.omh() { // from class: com.bytedance.sdk.component.adexpress.JG.SGo.1.1
                    @Override // com.bytedance.sdk.component.ML.omh
                    public Bitmap pA(Bitmap bitmap2) {
                        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap2, sGo.pA(), sGo.Og(), false);
                        SGo.this.pA.put(strOmh, bitmapCreateScaledBitmap);
                        return bitmapCreateScaledBitmap;
                    }
                });
                SGo sGo2 = SGo.this;
                sGoPA.pA(new pA(sGo2, sGo, strOmh, sGo2.pA));
                return (Bitmap) SGo.this.pA.get(strOmh);
            }
        });
        pA();
    }

    private static class pA implements com.bytedance.sdk.component.ML.oX<Bitmap> {
        private final String KZx;
        private final com.bytedance.adsdk.Og.SGo Og;
        private final Map<String, Bitmap> ZZv;
        private final WeakReference<SGo> pA;

        @Override // com.bytedance.sdk.component.ML.oX
        public void pA(int i, String str, Throwable th) {
        }

        public pA(SGo sGo, com.bytedance.adsdk.Og.SGo sGo2, String str, Map<String, Bitmap> map) {
            this.pA = new WeakReference<>(sGo);
            this.Og = sGo2;
            this.KZx = str;
            this.ZZv = map;
        }

        @Override // com.bytedance.sdk.component.ML.oX
        public void pA(com.bytedance.sdk.component.ML.BSW<Bitmap> bsw) {
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bsw.Og(), this.Og.pA(), this.Og.Og(), false);
            this.ZZv.put(this.KZx, bitmapCreateScaledBitmap);
            SGo sGo = this.pA.get();
            if (sGo != null) {
                sGo.pA(this.Og.omh(), bitmapCreateScaledBitmap);
            }
        }
    }
}
