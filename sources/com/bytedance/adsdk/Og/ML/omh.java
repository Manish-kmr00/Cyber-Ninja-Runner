package com.bytedance.adsdk.Og.ML;

import android.util.JsonReader;
import com.google.common.base.Ascii;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.b;
import java.io.IOException;

/* JADX INFO: loaded from: classes7.dex */
class omh {
    static com.bytedance.adsdk.Og.KZx.Og.KZx pA(JsonReader jsonReader, com.bytedance.adsdk.Og.SD sd) throws IOException {
        com.bytedance.adsdk.Og.KZx.Og.KZx kZxPA;
        String strNextString;
        jsonReader.beginObject();
        byte b = 2;
        int iNextInt = 2;
        while (true) {
            kZxPA = null;
            if (!jsonReader.hasNext()) {
                strNextString = null;
                break;
            }
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("d")) {
                iNextInt = jsonReader.nextInt();
            } else {
                if (strNextName.equals("ty")) {
                    strNextString = jsonReader.nextString();
                    break;
                }
                jsonReader.skipValue();
            }
        }
        if (strNextString == null) {
            return null;
        }
        strNextString.hashCode();
        switch (strNextString.hashCode()) {
            case 3239:
                b = !strNextString.equals("el") ? (byte) -1 : (byte) 0;
                break;
            case 3270:
                b = !strNextString.equals("fl") ? (byte) -1 : (byte) 1;
                break;
            case 3295:
                if (!strNextString.equals("gf")) {
                    b = -1;
                }
                break;
            case IronSourceConstants.BN_INSTANCE_RELOAD_NO_FILL /* 3307 */:
                b = !strNextString.equals("gr") ? (byte) -1 : (byte) 3;
                break;
            case IronSourceConstants.BN_INSTANCE_BOUND /* 3308 */:
                b = !strNextString.equals("gs") ? (byte) -1 : (byte) 4;
                break;
            case 3488:
                b = !strNextString.equals("mm") ? (byte) -1 : (byte) 5;
                break;
            case 3633:
                b = !strNextString.equals(DownloadCommon.DOWNLOAD_REPORT_RETRY_COUNT) ? (byte) -1 : (byte) 6;
                break;
            case 3634:
                b = !strNextString.equals("rd") ? (byte) -1 : (byte) 7;
                break;
            case 3646:
                b = !strNextString.equals("rp") ? (byte) -1 : (byte) 8;
                break;
            case 3669:
                b = !strNextString.equals(b.JSON_KEY_SH) ? (byte) -1 : (byte) 9;
                break;
            case 3679:
                b = !strNextString.equals("sr") ? (byte) -1 : (byte) 10;
                break;
            case 3681:
                b = !strNextString.equals("st") ? (byte) -1 : Ascii.VT;
                break;
            case 3705:
                b = !strNextString.equals("tm") ? (byte) -1 : Ascii.FF;
                break;
            case 3710:
                b = !strNextString.equals("tr") ? (byte) -1 : Ascii.CR;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                kZxPA = JG.pA(jsonReader, sd, iNextInt);
                break;
            case 1:
                kZxPA = Vgu.pA(jsonReader, sd);
                break;
            case 2:
                kZxPA = oX.pA(jsonReader, sd);
                break;
            case 3:
                kZxPA = CIG.pA(jsonReader, sd);
                break;
            case 4:
                kZxPA = aBv.pA(jsonReader, sd);
                break;
            case 5:
                kZxPA = du.pA(jsonReader);
                sd.pA("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
                break;
            case 6:
                kZxPA = lT.pA(jsonReader, sd);
                break;
            case 7:
                kZxPA = xy.pA(jsonReader, sd);
                break;
            case 8:
                kZxPA = rB.pA(jsonReader, sd);
                break;
            case 9:
                kZxPA = SzT.pA(jsonReader, sd);
                break;
            case 10:
                kZxPA = IG.pA(jsonReader, sd, iNextInt);
                break;
            case 11:
                kZxPA = FQ.pA(jsonReader, sd);
                break;
            case 12:
                kZxPA = Gx.pA(jsonReader, sd);
                break;
            case 13:
                kZxPA = KZx.pA(jsonReader, sd);
                break;
        }
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endObject();
        return kZxPA;
    }
}
