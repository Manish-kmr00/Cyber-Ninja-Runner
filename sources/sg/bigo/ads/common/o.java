package sg.bigo.ads.common;

import android.content.Context;
import android.text.TextUtils;
import com.safedk.android.analytics.brandsafety.FileUploadManager;
import com.vungle.ads.internal.model.AdPayload;
import java.io.File;
import net.pubnative.lite.sdk.mraid.MRAIDNativeFeature;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes3.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f13229a = "";

    public static String a(Context context) {
        if (sg.bigo.ads.common.n.d.b() && !q.a((CharSequence) f13229a)) {
            return f13229a;
        }
        if (q.a((CharSequence) f13229a)) {
            f13229a = context == null ? "" : context.getFilesDir() + File.separator + "sg_bigo_ad";
        }
        File file = new File(f13229a);
        if (!file.exists()) {
            file.mkdirs();
        }
        return f13229a;
    }

    public static boolean a(Context context, String str) {
        return str != null && str.equals(b(context));
    }

    public static String b(Context context) {
        return i(context) + File.separator + FileUploadManager.i;
    }

    public static String b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return AdPayload.FILE_SCHEME + d(context) + File.separator + str;
    }

    public static String c(Context context) {
        return i(context) + File.separator + MRAIDNativeFeature.VPAID;
    }

    public static String d(Context context) {
        return i(context) + File.separator + "thumb";
    }

    public static String e(Context context) {
        return a(context) + File.separator + "image";
    }

    public static String f(Context context) {
        return a(context) + File.separator + "icon";
    }

    public static String g(Context context) {
        return a(context) + File.separator + "omsdk";
    }

    public static String h(Context context) {
        return a(context) + File.separator + "bannerjs";
    }

    private static String i(Context context) {
        return a(context) + File.separator + "video";
    }
}
