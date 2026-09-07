package com.bykv.vk.openvk.pA.pA.Og;

import android.content.Context;
import com.bykv.vk.openvk.pA.pA.pA.pA.Og;
import net.pubnative.lite.sdk.models.AdExperience;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class pA {
    public static int KZx = 10;
    private static Og ML = null;
    public static int Og = 10;
    public static int ZZv = 10;
    public static int pA = 10;

    public static void pA(Context context) {
        com.bykv.vk.openvk.pA.pA.pA.SD.pA.pA(context);
    }

    public static void pA(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            pA = jSONObject.optInt("splash", 10);
            Og = jSONObject.optInt("reward", 10);
            KZx = jSONObject.optInt(AdExperience.BRAND, 10);
            int iOptInt = jSONObject.optInt("other", 10);
            ZZv = iOptInt;
            if (pA < 0) {
                pA = 10;
            }
            if (Og < 0) {
                Og = 10;
            }
            if (KZx < 0) {
                KZx = 10;
            }
            if (iOptInt < 0) {
                ZZv = 10;
            }
            new Object[]{"splash=", Integer.valueOf(pA), ",reward=", Integer.valueOf(Og), ",brand=", Integer.valueOf(KZx), ",other=", Integer.valueOf(ZZv)};
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public static void pA(Og og) {
        ML = og;
    }

    public static void pA() {
        Og og = ML;
        if (og != null) {
            og.ZZv();
        }
    }

    public static int Og() {
        return pA;
    }

    public static int KZx() {
        return Og;
    }

    public static int ZZv() {
        return KZx;
    }

    public static int ML() {
        return ZZv;
    }
}
