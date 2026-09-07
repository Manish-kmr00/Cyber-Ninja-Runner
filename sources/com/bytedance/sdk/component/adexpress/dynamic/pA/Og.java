package com.bytedance.sdk.component.adexpress.dynamic.pA;

import android.content.Context;
import com.bytedance.sdk.component.adexpress.Og.Wx;
import com.bytedance.sdk.component.adexpress.ZZv;
import com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.BF;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.BSW;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Bzk;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DX;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicRootView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.IG;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.KZx;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Mc;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.SD;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.SGo;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Sn;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.TV;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.TX;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.WQf;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.WV;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.XT;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.aBv;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.du;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.eG;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.lT;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.oX;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.rB;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.roi;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vZF;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.xy;

/* JADX INFO: loaded from: classes9.dex */
public class Og {
    public static ML pA(Context context, DynamicRootView dynamicRootView, omh omhVar) {
        Wx renderRequest;
        if (context == null || dynamicRootView == null || omhVar == null || omhVar.SGo() == null) {
            return null;
        }
        switch (omhVar.SGo().pA()) {
            case -1:
                return new lT(context, dynamicRootView, omhVar);
            case 0:
                return new du(context, dynamicRootView, omhVar);
            case 1:
                return new BSW(context, dynamicRootView, omhVar);
            case 2:
                return new SD(context, dynamicRootView, omhVar);
            case 3:
                return new Bzk(context, dynamicRootView, omhVar);
            case 4:
                return new com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Wx(context, dynamicRootView, omhVar);
            case 5:
                return new Sn(context, dynamicRootView, omhVar);
            case 6:
            case 9:
            case 17:
                return new JG(context, dynamicRootView, omhVar);
            case 7:
                return new xy(context, dynamicRootView, omhVar);
            case 8:
                return new XT(context, dynamicRootView, omhVar);
            case 10:
                return new oX(context, dynamicRootView, omhVar);
            case 11:
                return new TV(context, dynamicRootView, omhVar);
            case 12:
                return new SGo(context, dynamicRootView, omhVar);
            case 13:
                return new eG(context, dynamicRootView, omhVar);
            case 14:
                return new roi(context, dynamicRootView, omhVar);
            case 15:
                if (ZZv.Og()) {
                    return new Mc(context, dynamicRootView, omhVar);
                }
                return new IG(context, dynamicRootView, omhVar);
            case 16:
                return new BSW(context, dynamicRootView, omhVar);
            case 18:
                return new WQf(context, dynamicRootView, omhVar);
            case 19:
                return new BF(context, dynamicRootView, omhVar);
            case 20:
                return new vZF(context, dynamicRootView, omhVar);
            case 21:
                return new TX(context, dynamicRootView, omhVar);
            case 22:
                return new com.bytedance.sdk.component.adexpress.dynamic.dynamicview.omh(context, dynamicRootView, omhVar);
            case 23:
                return new aBv(context, dynamicRootView, omhVar);
            case 24:
                return new com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ZZv(context, dynamicRootView, omhVar);
            case 25:
                return new WV(context, dynamicRootView, omhVar);
            case 26:
                if ("vertical".equals(omhVar.SGo().ML().Ld())) {
                    return new rB(context, dynamicRootView, omhVar);
                }
                return new KZx(context, dynamicRootView, omhVar);
            case 27:
                return new IG(context, dynamicRootView, omhVar);
            case 28:
                if (!ZZv.Og() || (renderRequest = dynamicRootView.getRenderRequest()) == null) {
                    return null;
                }
                return new DX(context, dynamicRootView, omhVar, renderRequest.WQf());
            default:
                return null;
        }
    }
}
