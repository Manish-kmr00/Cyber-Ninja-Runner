package com.inmobi.media;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import com.inmobi.adquality.models.AdQualityResult;
import com.inmobi.commons.core.configs.AdConfig;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class G5 extends S8 {
    public final AdQualityResult y;
    public final AdConfig.AdQualityConfig z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public G5(AdQualityResult result, C3545rc uidMap, AdConfig.AdQualityConfig config) {
        super("POST", result.getBeaconUrl(), uidMap, false, (L4) null, "application/json", 64);
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(uidMap, "uidMap");
        Intrinsics.checkNotNullParameter(config, "config");
        this.y = result;
        this.z = config;
    }

    @Override // com.inmobi.media.S8
    public final void f() {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        Intrinsics.checkNotNullParameter("JsonBeaconRequest", "tag");
        Intrinsics.checkNotNullParameter("preparing beacon request", "message");
        Log.i("JsonBeaconRequest", "preparing beacon request");
        this.t = false;
        this.u = false;
        this.x = false;
        this.v = false;
        super.f();
        Intrinsics.checkNotNullParameter("JsonBeaconRequest", "tag");
        Intrinsics.checkNotNullParameter("getScreenshot", "message");
        Log.i("JsonBeaconRequest", "getScreenshot");
        if (this.y.getImageLocation().length() > 0) {
            Intrinsics.checkNotNullParameter("JsonBeaconRequest", "tag");
            Intrinsics.checkNotNullParameter("screen shot image found in DB", "message");
            Log.i("JsonBeaconRequest", "screen shot image found in DB");
            try {
                Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(this.y.getImageLocation());
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                if (bitmapDecodeFile != null) {
                    bitmapDecodeFile.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
                if (byteArray.length != 0 && (jSONObject2 = this.l) != null) {
                    jSONObject2.put("screenshotImageByte", Base64.encodeToString(byteArray, 0));
                }
            } catch (FileNotFoundException e) {
                Intrinsics.checkNotNullParameter("JsonBeaconRequest", "tag");
                Intrinsics.checkNotNullParameter("image file not found...", "message");
                Log.e("JsonBeaconRequest", "image file not found...", e);
                Intrinsics.checkNotNullParameter("JsonBeaconRequest", "tag");
                Intrinsics.checkNotNullParameter("result produced no screenshot", "message");
                Log.i("JsonBeaconRequest", "result produced no screenshot");
            }
        } else {
            Intrinsics.checkNotNullParameter("JsonBeaconRequest", "tag");
            Intrinsics.checkNotNullParameter("result produced no screenshot", "message");
            Log.i("JsonBeaconRequest", "result produced no screenshot");
        }
        Intrinsics.checkNotNullParameter("JsonBeaconRequest", "tag");
        Intrinsics.checkNotNullParameter("getExtras", "message");
        Log.i("JsonBeaconRequest", "getExtras");
        try {
            if (AbstractC3420j2.a(this.y.getExtras())) {
                String extras = this.y.getExtras();
                if (extras != null && (jSONObject = this.l) != null) {
                    jSONObject.put("templateInfo", new JSONObject(extras));
                }
            } else {
                Intrinsics.checkNotNullParameter("JsonBeaconRequest", "tag");
                Intrinsics.checkNotNullParameter("result has no extras", "message");
                Log.i("JsonBeaconRequest", "result has no extras");
            }
        } catch (JSONException e2) {
            Intrinsics.checkNotNullParameter("JsonBeaconRequest", "tag");
            Intrinsics.checkNotNullParameter("error while adding extras", "message");
            Log.e("JsonBeaconRequest", "error while adding extras", e2);
        }
        Intrinsics.checkNotNullParameter("JsonBeaconRequest", "tag");
        Intrinsics.checkNotNullParameter("getExtras", "message");
        Log.i("JsonBeaconRequest", "getExtras");
        if (!AbstractC3420j2.a(this.y.getSdkModelResult())) {
            Intrinsics.checkNotNullParameter("JsonBeaconRequest", "tag");
            Intrinsics.checkNotNullParameter("result has no model info", "message");
            Log.i("JsonBeaconRequest", "result has no model info");
        } else {
            JSONObject jSONObject3 = this.l;
            if (jSONObject3 != null) {
                jSONObject3.put("sdkModelInfo", this.y.getSdkModelResult());
            }
        }
    }
}
