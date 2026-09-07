package net.pubnative.lite.sdk.vpaid.helpers;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import net.pubnative.lite.sdk.HyBid;

/* JADX INFO: loaded from: classes13.dex */
public class BitmapHelper {
    public static Bitmap toBitmap(Context context, Integer num, Integer num2) {
        if (context == null || num == null) {
            return null;
        }
        try {
            return BitmapFactory.decodeResource(context.getResources(), num.intValue());
        } catch (Exception e) {
            HyBid.reportException(e);
            return BitmapFactory.decodeResource(context.getResources(), num2.intValue());
        }
    }

    public static Bitmap decodeResource(Context context, Integer num) {
        return BitmapFactory.decodeResource(context.getResources(), num.intValue());
    }
}
