package com.bytedance.sdk.openadsdk.aBv.pA;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.sdk.component.ML.BSW;
import com.bytedance.sdk.component.ML.oX;
import com.bytedance.sdk.component.ML.omh;
import com.bytedance.sdk.openadsdk.Bzk.ZZv;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class pA {

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.aBv.pA.pA$pA, reason: collision with other inner class name */
    public interface InterfaceC0220pA {
        void pA(int i, String str, Throwable th);

        void pA(String str, Og og);
    }

    public void pA(com.bytedance.sdk.openadsdk.aBv.pA pAVar, final InterfaceC0220pA interfaceC0220pA, int i, int i2, ImageView.ScaleType scaleType, String str, final int i3, yFO yfo) {
        ZZv.pA(pAVar.pA).pA(pAVar.Og).pA(i).Og(i2).ML(Vgu.ZZv(aBv.pA())).ZZv(Vgu.KZx(aBv.pA())).Og(str).pA(Bitmap.Config.RGB_565).pA(scaleType).pA(!TextUtils.isEmpty(str)).pA(new omh() { // from class: com.bytedance.sdk.openadsdk.aBv.pA.pA.2
            @Override // com.bytedance.sdk.component.ML.omh
            public Bitmap pA(Bitmap bitmap) {
                return i3 <= 0 ? bitmap : com.bytedance.sdk.component.adexpress.ZZv.pA.pA(aBv.pA(), bitmap, i3);
            }
        }).pA(new com.bytedance.sdk.openadsdk.Bzk.Og(yfo, pAVar.pA, new oX() { // from class: com.bytedance.sdk.openadsdk.aBv.pA.pA.1
            @Override // com.bytedance.sdk.component.ML.oX
            public void pA(BSW bsw) {
                pA.this.pA(bsw, interfaceC0220pA);
            }

            @Override // com.bytedance.sdk.component.ML.oX
            public void pA(int i4, String str2, Throwable th) {
                pA.this.pA(i4, str2, th, interfaceC0220pA);
            }
        }));
    }

    protected void pA(BSW bsw, InterfaceC0220pA interfaceC0220pA) {
        if (interfaceC0220pA != null) {
            Object objOg = bsw.Og();
            int iPA = pA(bsw);
            if (objOg instanceof byte[]) {
                interfaceC0220pA.pA(bsw.pA(), new Og((byte[]) objOg, iPA));
                return;
            }
            if (objOg instanceof Bitmap) {
                interfaceC0220pA.pA(bsw.pA(), new Og((Bitmap) objOg, bsw.KZx() instanceof Bitmap ? (Bitmap) bsw.KZx() : null, iPA));
            } else {
                interfaceC0220pA.pA(0, "not bitmap or gif result!", null);
            }
        }
    }

    private int pA(BSW bsw) {
        Object obj;
        Map<String, String> mapZZv = bsw.ZZv();
        if (mapZZv == null || (obj = mapZZv.get(CampaignEx.JSON_KEY_IMAGE_SIZE)) == null || !(obj instanceof Integer)) {
            return 0;
        }
        return ((Integer) obj).intValue();
    }

    protected void pA(int i, String str, Throwable th, InterfaceC0220pA interfaceC0220pA) {
        if (interfaceC0220pA != null) {
            interfaceC0220pA.pA(i, str, th);
        }
    }
}
