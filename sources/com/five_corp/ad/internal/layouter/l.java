package com.five_corp.ad.internal.layouter;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.util.Base64;
import android.util.Log;
import com.json.b9;

/* JADX INFO: loaded from: classes10.dex */
public abstract class l {
    public static BitmapDrawable a(String str, Resources resources, com.five_corp.ad.internal.logger.a aVar) {
        if (str == null) {
            return null;
        }
        try {
            byte[] bArrDecode = Base64.decode(str, 0);
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
            if (bitmapDecodeByteArray == null) {
                aVar.a("WatermarkDrawableBuilder.build BitmapFactory.decodeByteArray failed, input: [" + str + b9.i.e, 4);
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(resources, bitmapDecodeByteArray);
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            bitmapDrawable.setTileModeXY(tileMode, tileMode);
            bitmapDrawable.setTargetDensity(resources.getDisplayMetrics());
            return bitmapDrawable;
        } catch (Exception e) {
            aVar.a("WatermarkDrawableBuilder.build Base64.decode failed, input: [" + str + "], exception: " + Log.getStackTraceString(e), 4);
            return null;
        }
    }
}
