package com.bytedance.adsdk.Og.ML;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;

/* JADX INFO: loaded from: classes13.dex */
public class KZx {
    public static com.bytedance.adsdk.Og.KZx.pA.WV pA(JsonReader jsonReader, com.bytedance.adsdk.Og.SD sd) throws IOException {
        boolean z = jsonReader.peek() == JsonToken.BEGIN_OBJECT;
        if (z) {
            jsonReader.beginObject();
        }
        com.bytedance.adsdk.Og.KZx.pA.Og og = null;
        com.bytedance.adsdk.Og.KZx.pA.ML mlPA = null;
        com.bytedance.adsdk.Og.KZx.pA.Wx<PointF, PointF> wxOg = null;
        com.bytedance.adsdk.Og.KZx.pA.SD sdZZv = null;
        com.bytedance.adsdk.Og.KZx.pA.Og ogPA = null;
        com.bytedance.adsdk.Og.KZx.pA.Og ogPA2 = null;
        com.bytedance.adsdk.Og.KZx.pA.ZZv zZvOg = null;
        com.bytedance.adsdk.Og.KZx.pA.Og ogPA3 = null;
        com.bytedance.adsdk.Og.KZx.pA.Og ogPA4 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "a":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String strNextName2 = jsonReader.nextName();
                        strNextName2.hashCode();
                        if (strNextName2.equals(CampaignEx.JSON_KEY_AD_K)) {
                            mlPA = pA.pA(jsonReader, sd);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    continue;
                    break;
                case "o":
                    zZvOg = ZZv.Og(jsonReader, sd);
                    continue;
                    break;
                case "p":
                    wxOg = pA.Og(jsonReader, sd);
                    continue;
                    break;
                case "r":
                    break;
                case "s":
                    sdZZv = ZZv.ZZv(jsonReader, sd);
                    continue;
                    break;
                case "eo":
                    ogPA4 = ZZv.pA(jsonReader, sd, false);
                    continue;
                    break;
                case "rz":
                    sd.pA("Lottie doesn't support 3D layers.");
                    break;
                case "sa":
                    ogPA2 = ZZv.pA(jsonReader, sd, false);
                    continue;
                    break;
                case "sk":
                    ogPA = ZZv.pA(jsonReader, sd, false);
                    continue;
                    break;
                case "so":
                    ogPA3 = ZZv.pA(jsonReader, sd, false);
                    continue;
                    break;
                default:
                    jsonReader.skipValue();
                    continue;
                    break;
            }
            com.bytedance.adsdk.Og.KZx.pA.Og ogPA5 = ZZv.pA(jsonReader, sd, false);
            if (ogPA5.KZx().isEmpty()) {
                ogPA5.KZx().add(new com.bytedance.adsdk.Og.SD.pA(sd, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(sd.SD())));
            } else if (((com.bytedance.adsdk.Og.SD.pA) ogPA5.KZx().get(0)).pA == 0) {
                ogPA5.KZx().set(0, new com.bytedance.adsdk.Og.SD.pA(sd, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(sd.SD())));
            }
            og = ogPA5;
        }
        if (z) {
            jsonReader.endObject();
        }
        com.bytedance.adsdk.Og.KZx.pA.ML ml = pA(mlPA) ? null : mlPA;
        if (pA(wxOg)) {
            wxOg = null;
        }
        return new com.bytedance.adsdk.Og.KZx.pA.WV(ml, wxOg, pA(sdZZv) ? null : sdZZv, pA(og) ? null : og, zZvOg, ogPA3, ogPA4, Og(ogPA) ? null : ogPA, KZx(ogPA2) ? null : ogPA2);
    }

    private static boolean pA(com.bytedance.adsdk.Og.KZx.pA.ML ml) {
        if (ml != null) {
            return ml.Og() && ml.KZx().get(0).pA.equals(0.0f, 0.0f);
        }
        return true;
    }

    private static boolean pA(com.bytedance.adsdk.Og.KZx.pA.Wx<PointF, PointF> wx) {
        if (wx != null) {
            return !(wx instanceof com.bytedance.adsdk.Og.KZx.pA.Bzk) && wx.Og() && wx.KZx().get(0).pA.equals(0.0f, 0.0f);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean pA(com.bytedance.adsdk.Og.KZx.pA.Og og) {
        if (og != null) {
            return og.Og() && ((Float) ((com.bytedance.adsdk.Og.SD.pA) og.KZx().get(0)).pA).floatValue() == 0.0f;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean pA(com.bytedance.adsdk.Og.KZx.pA.SD sd) {
        if (sd != null) {
            return sd.Og() && ((com.bytedance.adsdk.Og.SD.KZx) ((com.bytedance.adsdk.Og.SD.pA) sd.KZx().get(0)).pA).Og(1.0f, 1.0f);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean Og(com.bytedance.adsdk.Og.KZx.pA.Og og) {
        if (og != null) {
            return og.Og() && ((Float) ((com.bytedance.adsdk.Og.SD.pA) og.KZx().get(0)).pA).floatValue() == 0.0f;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean KZx(com.bytedance.adsdk.Og.KZx.pA.Og og) {
        if (og != null) {
            return og.Og() && ((Float) ((com.bytedance.adsdk.Og.SD.pA) og.KZx().get(0)).pA).floatValue() == 0.0f;
        }
        return true;
    }
}
