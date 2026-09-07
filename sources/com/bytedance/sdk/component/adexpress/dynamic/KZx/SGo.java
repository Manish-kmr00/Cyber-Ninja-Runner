package com.bytedance.sdk.component.adexpress.dynamic.KZx;

import android.content.Context;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.json.mediationsdk.utils.IronSourceConstants;
import net.pubnative.lite.sdk.models.Protocol;

/* JADX INFO: loaded from: classes13.dex */
public class SGo {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static SD pA(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML ml, com.bytedance.sdk.component.adexpress.dynamic.ZZv.SD sd, com.bytedance.sdk.component.adexpress.dynamic.ZZv.SGo sGo, com.bytedance.sdk.component.adexpress.Og.Wx wx) {
        if (context == null || ml == null || sd == null) {
            return null;
        }
        String strGx = sd.Gx();
        String strWQf = wx.WQf();
        strGx.hashCode();
        byte b = -1;
        switch (strGx.hashCode()) {
            case 48:
                if (strGx.equals("0")) {
                    b = 0;
                }
                break;
            case 49:
                if (strGx.equals("1")) {
                    b = 1;
                }
                break;
            case 50:
                if (strGx.equals("2")) {
                    b = 2;
                }
                break;
            case 53:
                if (strGx.equals("5")) {
                    b = 3;
                }
                break;
            case 54:
                if (strGx.equals("6")) {
                    b = 4;
                }
                break;
            case 55:
                if (strGx.equals("7")) {
                    b = 5;
                }
                break;
            case 56:
                if (strGx.equals("8")) {
                    b = 6;
                }
                break;
            case 57:
                if (strGx.equals("9")) {
                    b = 7;
                }
                break;
            case 1567:
                if (strGx.equals("10")) {
                    b = 8;
                }
                break;
            case 1568:
                if (strGx.equals(Protocol.VAST_4_1)) {
                    b = 9;
                }
                break;
            case 1569:
                if (strGx.equals(Protocol.VAST_4_1_WRAPPER)) {
                    b = 10;
                }
                break;
            case 1570:
                if (strGx.equals(Protocol.VAST_4_2)) {
                    b = Ascii.VT;
                }
                break;
            case 1571:
                if (strGx.equals(Protocol.VAST_4_2_WRAPPER)) {
                    b = Ascii.FF;
                }
                break;
            case 1573:
                if (strGx.equals("16")) {
                    b = Ascii.CR;
                }
                break;
            case 1574:
                if (strGx.equals("17")) {
                    b = Ascii.SO;
                }
                break;
            case 1575:
                if (strGx.equals("18")) {
                    b = Ascii.SI;
                }
                break;
            case 1598:
                if (strGx.equals("20")) {
                    b = Ascii.DLE;
                }
                break;
            case IronSourceConstants.RV_OPERATIONAL_LOAD_AD /* 1600 */:
                if (strGx.equals("22")) {
                    b = 17;
                }
                break;
            case IronSourceConstants.RV_OPERATIONAL_LOAD_SUCCESS /* 1601 */:
                if (strGx.equals("23")) {
                    b = Ascii.DC2;
                }
                break;
            case IronSourceConstants.RV_OPERATIONAL_LOAD_FAILED /* 1602 */:
                if (strGx.equals("24")) {
                    b = 19;
                }
                break;
            case 1603:
                if (strGx.equals("25")) {
                    b = Ascii.DC4;
                }
                break;
            case 1607:
                if (strGx.equals("29")) {
                    b = Ascii.NAK;
                }
                break;
        }
        switch (b) {
            case 0:
                return new ML(context, ml, sd);
            case 1:
                return new KZx(context, ml, sd);
            case 2:
                return new Og(context, ml, sd);
            case 3:
                if (sd.HSv() == 1) {
                    return new aBv(context, ml, sd, sd.lx());
                }
                return new oX(context, ml, sd);
            case 4:
            case 9:
                return new Sn(context, ml, sd);
            case 5:
            case 12:
                return new WV(context, ml, sd);
            case 6:
                return new Wx(context, ml, sd);
            case 7:
            case 13:
                return new DX(context, ml, sd, strGx, sGo.pA(), sGo.Og(), sGo.ZZv(), sGo.SD());
            case 8:
                return new ZZv(context, ml, sd);
            case 10:
                return new oX(context, ml, sd);
            case 11:
                return new aBv(context, ml, sd);
            case 14:
            case 15:
                return new yFO(context, ml, sd, strGx, sGo);
            case 16:
                if (com.bytedance.sdk.component.adexpress.ZZv.Og()) {
                    return new BSW(context, ml, sd, strWQf + "static/lotties/glass-swipe/glass-swipe.json", "20");
                }
                return new BSW(context, ml, sd, TextUtils.isEmpty(strWQf) ? null : strWQf + "brush_mask.json", "20");
            case 17:
                if (com.bytedance.sdk.component.adexpress.ZZv.Og()) {
                    return new BSW(context, ml, sd, strWQf + "static/lotties/202327swiper-up-star/index.json", "22");
                }
                return new XT(context, ml, sd);
            case 18:
                if (com.bytedance.sdk.component.adexpress.ZZv.Og()) {
                    return new BSW(context, ml, sd, strWQf + "static/lotties/202327swiper-up-star/click.json", "23");
                }
                return null;
            case 19:
                if (com.bytedance.sdk.component.adexpress.ZZv.Og()) {
                    return new pA(context, ml, sd);
                }
                return new BSW(context, ml, sd, TextUtils.isEmpty(strWQf) ? null : strWQf + "swiper_up_star.json", "24");
            case 20:
                if (com.bytedance.sdk.component.adexpress.ZZv.Og()) {
                    return new BSW(context, ml, sd, strWQf + "static/lotties/gesture-slide.json", "25");
                }
                return null;
            case 21:
                return new JG(context, ml, sd, sGo.pA(), sGo.Og(), sGo.ZZv(), sGo.SD());
            default:
                return null;
        }
    }
}
