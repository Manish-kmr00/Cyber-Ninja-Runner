package com.bytedance.adsdk.ugeno.Bzk.KZx;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.bytedance.adsdk.ugeno.Bzk.ZZv.KZx;

/* JADX INFO: loaded from: classes11.dex */
public abstract class pA extends KZx {
    private int ZZv;

    public abstract String SD(String str);

    public pA(Context context) {
        super(context);
        this.ZZv = ViewCompat.MEASURED_STATE_MASK;
    }

    @Override // com.bytedance.adsdk.ugeno.Bzk.ZZv.KZx, com.bytedance.adsdk.ugeno.Og.KZx
    public void Og() {
        this.pA = Bzk(this.pA);
        super.Og();
        ((com.bytedance.adsdk.ugeno.Bzk.ZZv.pA) this.omh).setColorFilter(this.ZZv);
        ((com.bytedance.adsdk.ugeno.Bzk.ZZv.pA) this.omh).setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    private String Bzk(String str) {
        String strSD = SD(str);
        if (TextUtils.isEmpty(strSD)) {
            return "";
        }
        return "local://".concat(String.valueOf(strSD));
    }

    @Override // com.bytedance.adsdk.ugeno.Bzk.ZZv.KZx, com.bytedance.adsdk.ugeno.Og.KZx
    public void pA(String str, String str2) {
        super.pA(str, str2);
        str.hashCode();
        if (str.equals("textColor")) {
            this.ZZv = com.bytedance.adsdk.ugeno.SD.pA.pA(str2);
        }
    }
}
