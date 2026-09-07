package com.bytedance.adsdk.ugeno.Bzk.pA;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.Bzk.JG.Og;
import com.bytedance.adsdk.ugeno.SD.ZZv;
import com.bytedance.adsdk.ugeno.SD.omh;

/* JADX INFO: loaded from: classes3.dex */
public class pA extends Og {
    private boolean PU;
    private int Xj;
    private String ZZv;
    private int dGZ;
    private String guZ;
    private String npn;
    private com.bytedance.adsdk.ugeno.SD.pA.C0175pA qQU;
    private String rjD;
    private boolean vkV;

    public pA(Context context) {
        super(context);
        this.guZ = "row";
    }

    @Override // com.bytedance.adsdk.ugeno.Bzk.JG.Og, com.bytedance.adsdk.ugeno.Og.KZx
    public void Og() {
        super.Og();
        KZx();
        ((com.bytedance.adsdk.ugeno.Bzk.JG.pA) this.omh).setGravity(17);
    }

    @Override // com.bytedance.adsdk.ugeno.Og.KZx
    protected void CIG() {
        super.CIG();
        if (this.vkV) {
            ((com.bytedance.adsdk.ugeno.Bzk.JG.pA) this.omh).setTextColor(this.Xj);
        }
        if (this.PU) {
            if (this.xkn) {
                pA(this.qQU);
            } else {
                ZZv(this.dGZ);
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.Og.KZx
    protected void SzT() {
        super.SzT();
        if (this.vkV) {
            ((com.bytedance.adsdk.ugeno.Bzk.JG.pA) this.omh).setTextColor(this.Og);
        }
        if (this.PU) {
            if (this.xkn) {
                pA(this.mK);
            } else {
                ZZv(this.FQ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:19:0x0037  */
    public void Og(Drawable drawable) {
        byte b;
        if (drawable == null) {
            return;
        }
        switch (this.guZ) {
            case "column_reverse":
                b = 2;
                break;
            case "column":
                b = 1;
                break;
            case "row_reverse":
                b = 0;
                break;
            case "row":
                b = 3;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            ((com.bytedance.adsdk.ugeno.Bzk.JG.pA) this.omh).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            return;
        }
        if (b == 1) {
            ((com.bytedance.adsdk.ugeno.Bzk.JG.pA) this.omh).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, drawable, (Drawable) null, (Drawable) null);
        } else if (b == 2) {
            ((com.bytedance.adsdk.ugeno.Bzk.JG.pA) this.omh).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, drawable);
        } else {
            ((com.bytedance.adsdk.ugeno.Bzk.JG.pA) this.omh).setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    private void KZx() {
        if (TextUtils.isEmpty(this.ZZv)) {
            return;
        }
        ((com.bytedance.adsdk.ugeno.Bzk.JG.pA) this.omh).setCompoundDrawables(null, null, null, null);
        if (this.ZZv.startsWith("local://")) {
            try {
                Og(omh.pA(this.ML, ZZv.pA(this.ML, this.ZZv.replace("local://", ""))));
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        com.bytedance.adsdk.ugeno.ZZv.pA().Og().pA(this.WV, this.ZZv, new com.bytedance.adsdk.ugeno.pA.InterfaceC0181pA() { // from class: com.bytedance.adsdk.ugeno.Bzk.pA.pA.1
            @Override // com.bytedance.adsdk.ugeno.pA.InterfaceC0181pA
            public void pA(final Bitmap bitmap) {
                if (bitmap == null) {
                    return;
                }
                omh.pA(new Runnable() { // from class: com.bytedance.adsdk.ugeno.Bzk.pA.pA.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        pA.this.Og(new BitmapDrawable(pA.this.ML.getResources(), bitmap));
                    }
                });
            }
        });
    }

    @Override // com.bytedance.adsdk.ugeno.Bzk.JG.Og, com.bytedance.adsdk.ugeno.Og.KZx
    public void pA(String str, String str2) {
        super.pA(str, str2);
        str.hashCode();
        switch (str) {
            case "direction":
                this.guZ = str2;
                break;
            case "highlightTextColor":
            case "highlightedTextColor":
                this.Xj = com.bytedance.adsdk.ugeno.SD.pA.pA(str2);
                this.vkV = true;
                break;
            case "image":
                this.ZZv = str2;
                break;
            case "highlightImage":
                this.npn = str2;
                break;
            case "highlightBackgroundColor":
                if (com.bytedance.adsdk.ugeno.SD.pA.KZx(str2)) {
                    this.xkn = true;
                    this.qQU = com.bytedance.adsdk.ugeno.SD.pA.Og(str2);
                } else {
                    this.dGZ = com.bytedance.adsdk.ugeno.SD.pA.pA(str2);
                    this.xkn = false;
                }
                this.PU = true;
                break;
            case "highlightBackgroundImage":
                this.rjD = str2;
                break;
        }
    }
}
