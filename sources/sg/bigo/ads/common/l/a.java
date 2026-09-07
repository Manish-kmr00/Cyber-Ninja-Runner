package sg.bigo.ads.common.l;

import android.content.Context;
import com.json.b9;

/* JADX INFO: loaded from: classes11.dex */
final class a {
    public static sg.bigo.ads.common.a a(Context context) {
        try {
            Object objInvoke = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", Context.class).invoke(null, context);
            Boolean bool = (Boolean) objInvoke.getClass().getMethod(b9.i.M, new Class[0]).invoke(objInvoke, new Object[0]);
            String str = (String) objInvoke.getClass().getMethod("getId", new Class[0]).invoke(objInvoke, new Object[0]);
            if (str != null && bool != null) {
                return new sg.bigo.ads.common.a(str, bool.booleanValue());
            }
        } catch (Exception unused) {
        }
        return null;
    }
}
