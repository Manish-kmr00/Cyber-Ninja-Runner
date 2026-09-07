package com.bytedance.sdk.openadsdk.aBv;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.sdk.component.ML.BSW;
import com.bytedance.sdk.component.ML.omh;
import com.bytedance.sdk.component.Og.pA.ZZv;
import com.bytedance.sdk.component.Og.pA.pA.pA.Bzk;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.DX;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.core.settings.oX;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.bytedance.sdk.openadsdk.utils.xy;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
public class KZx {
    private static volatile KZx pA;
    private com.bytedance.sdk.openadsdk.aBv.pA.KZx KZx;
    private final com.bytedance.sdk.component.SD.pA Og;

    public static KZx pA() {
        if (pA == null) {
            synchronized (KZx.class) {
                if (pA == null) {
                    pA = new KZx(aBv.pA());
                }
            }
        }
        return pA;
    }

    private KZx(Context context) {
        com.bytedance.sdk.component.SD.pA pAVarPA = new com.bytedance.sdk.component.SD.pA.C0196pA().pA(10000L, TimeUnit.MILLISECONDS).Og(10000L, TimeUnit.MILLISECONDS).KZx(10000L, TimeUnit.MILLISECONDS).pA(true).pA();
        this.Og = pAVarPA;
        com.bytedance.sdk.component.Og.pA.pA.pA.pA.pA(new Bzk() { // from class: com.bytedance.sdk.openadsdk.aBv.KZx.1
            @Override // com.bytedance.sdk.component.Og.pA.pA.pA.Bzk
            public ExecutorService pA() {
                if (oX.vkV().npn()) {
                    return xy.SGo();
                }
                return null;
            }

            @Override // com.bytedance.sdk.component.Og.pA.pA.pA.Bzk
            public boolean Og() {
                return oX.vkV().npn();
            }
        });
        ZZv zZvPA = pAVarPA.ML().pA();
        if (zZvPA != null) {
            zZvPA.pA(32);
        }
    }

    public com.bytedance.sdk.component.SD.pA Og() {
        return this.Og;
    }

    public com.bytedance.sdk.openadsdk.aBv.pA.KZx KZx() {
        ZZv();
        return this.KZx;
    }

    public void pA(String str, int i, int i2, ImageView imageView, yFO yfo) {
        com.bytedance.sdk.openadsdk.Bzk.ZZv.pA(str).pA(i).Og(i2).ML(Vgu.ZZv(aBv.pA())).ZZv(Vgu.KZx(aBv.pA())).KZx(2).pA(com.bytedance.sdk.openadsdk.Bzk.KZx.pA(yfo, str, imageView));
    }

    public void pA(int i, final ImageView imageView, final yFO yfo) {
        com.bytedance.sdk.openadsdk.Bzk.ZZv.pA(yfo.JG()).pA(i).Og(i).ML(Vgu.ZZv(aBv.pA())).ZZv(Vgu.KZx(aBv.pA())).KZx(2).pA(com.bytedance.sdk.openadsdk.Bzk.KZx.pA(yfo, yfo.JG(), imageView));
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.aBv.KZx.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/aBv/KZx$2;->onClick(Landroid/view/View;)V");
                    CreativeInfoManager.onViewClicked(h.u, view);
                    safedk_KZx$2_onClick_de18ec1c917df86e572ce3f434dd295a(view);
                }

                public void safedk_KZx$2_onClick_de18ec1c917df86e572ce3f434dd295a(View p0) {
                    if (imageView.getDrawable() != null) {
                        Intent intent = new Intent();
                        String strSD = yfo.SD();
                        intent.setAction("android.intent.action.VIEW");
                        intent.setData(Uri.parse(strSD));
                        try {
                            com.bytedance.sdk.component.utils.Og.pA(aBv.pA(), intent, null);
                        } catch (Exception unused) {
                        }
                    }
                }
            });
        }
    }

    public void pA(DX dx, ImageView imageView, yFO yfo) {
        if (dx == null || TextUtils.isEmpty(dx.pA()) || imageView == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.Bzk.ZZv.pA(dx).KZx(2).pA(com.bytedance.sdk.openadsdk.Bzk.KZx.pA(yfo, dx.pA(), imageView));
    }

    public void pA(String str, View view) {
        if (view == null || TextUtils.isEmpty(str)) {
            return;
        }
        final WeakReference weakReference = new WeakReference(view);
        com.bytedance.sdk.openadsdk.Bzk.ZZv.pA(str).KZx(2).pA(new omh() { // from class: com.bytedance.sdk.openadsdk.aBv.KZx.4
            @Override // com.bytedance.sdk.component.ML.omh
            public Bitmap pA(Bitmap bitmap) {
                View view2 = (View) weakReference.get();
                if (view2 == null) {
                    return null;
                }
                return com.bytedance.sdk.component.adexpress.ZZv.pA.pA(view2.getContext(), bitmap, 10);
            }
        }).pA(new com.bytedance.sdk.component.ML.oX<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.aBv.KZx.3
            @Override // com.bytedance.sdk.component.ML.oX
            public void pA(int i, String str2, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.ML.oX
            public void pA(BSW<Bitmap> bsw) {
                final View view2;
                if (bsw == null) {
                    return;
                }
                final Bitmap bitmapOg = bsw.Og();
                if (!(bitmapOg instanceof Bitmap) || (view2 = (View) weakReference.get()) == null) {
                    return;
                }
                if (xy.ML()) {
                    if (view2 instanceof ImageView) {
                        ((ImageView) view2).setImageDrawable(new BitmapDrawable(view2.getResources(), bitmapOg));
                        return;
                    } else {
                        view2.setBackground(new BitmapDrawable(view2.getResources(), bitmapOg));
                        return;
                    }
                }
                view2.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.aBv.KZx.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        View view3 = view2;
                        if (view3 instanceof ImageView) {
                            ((ImageView) view3).setImageDrawable(new BitmapDrawable(view2.getResources(), (Bitmap) bitmapOg));
                        } else {
                            view3.setBackground(new BitmapDrawable(view2.getResources(), (Bitmap) bitmapOg));
                        }
                    }
                });
            }
        });
    }

    private void ZZv() {
        if (this.KZx == null) {
            this.KZx = new com.bytedance.sdk.openadsdk.aBv.pA.KZx();
        }
    }
}
