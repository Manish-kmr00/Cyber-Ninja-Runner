package com.bytedance.adsdk.Og.ML;

import android.util.JsonReader;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class ZZv {
    public static com.bytedance.adsdk.Og.KZx.pA.Og pA(JsonReader jsonReader, com.bytedance.adsdk.Og.SD sd) throws IOException {
        return pA(jsonReader, sd, true);
    }

    public static com.bytedance.adsdk.Og.KZx.pA.Og pA(JsonReader jsonReader, com.bytedance.adsdk.Og.SD sd, boolean z) throws IOException {
        return new com.bytedance.adsdk.Og.KZx.pA.Og(pA(jsonReader, z ? com.bytedance.adsdk.Og.JG.JG.pA() : 1.0f, sd, WV.pA));
    }

    static com.bytedance.adsdk.Og.KZx.pA.ZZv Og(JsonReader jsonReader, com.bytedance.adsdk.Og.SD sd) throws IOException {
        return new com.bytedance.adsdk.Og.KZx.pA.ZZv(pA(jsonReader, sd, XT.pA));
    }

    static com.bytedance.adsdk.Og.KZx.pA.JG KZx(JsonReader jsonReader, com.bytedance.adsdk.Og.SD sd) throws IOException {
        return new com.bytedance.adsdk.Og.KZx.pA.JG(TX.pA(jsonReader, sd, com.bytedance.adsdk.Og.JG.JG.pA(), Mc.pA, true));
    }

    static com.bytedance.adsdk.Og.KZx.pA.SD ZZv(JsonReader jsonReader, com.bytedance.adsdk.Og.SD sd) throws IOException {
        return new com.bytedance.adsdk.Og.KZx.pA.SD(pA(jsonReader, sd, qmB.pA));
    }

    static com.bytedance.adsdk.Og.KZx.pA.omh ML(JsonReader jsonReader, com.bytedance.adsdk.Og.SD sd) throws IOException {
        return new com.bytedance.adsdk.Og.KZx.pA.omh(pA(jsonReader, com.bytedance.adsdk.Og.JG.JG.pA(), sd, gbA.pA));
    }

    static com.bytedance.adsdk.Og.KZx.pA.SGo JG(JsonReader jsonReader, com.bytedance.adsdk.Og.SD sd) throws IOException {
        return new com.bytedance.adsdk.Og.KZx.pA.SGo(pA(jsonReader, com.bytedance.adsdk.Og.JG.JG.pA(), sd, Bzk.pA));
    }

    static com.bytedance.adsdk.Og.KZx.pA.pA SD(JsonReader jsonReader, com.bytedance.adsdk.Og.SD sd) throws IOException {
        return new com.bytedance.adsdk.Og.KZx.pA.pA(pA(jsonReader, sd, SD.pA));
    }

    static com.bytedance.adsdk.Og.KZx.pA.KZx pA(JsonReader jsonReader, com.bytedance.adsdk.Og.SD sd, int i) throws IOException {
        return new com.bytedance.adsdk.Og.KZx.pA.KZx(pA(jsonReader, sd, new DX(i)));
    }

    private static <T> List<com.bytedance.adsdk.Og.SD.pA<T>> pA(JsonReader jsonReader, com.bytedance.adsdk.Og.SD sd, HSv<T> hSv) throws IOException {
        return TX.pA(jsonReader, sd, 1.0f, hSv, false);
    }

    private static <T> List<com.bytedance.adsdk.Og.SD.pA<T>> pA(JsonReader jsonReader, float f, com.bytedance.adsdk.Og.SD sd, HSv<T> hSv) throws IOException {
        return TX.pA(jsonReader, sd, f, hSv, false);
    }
}
