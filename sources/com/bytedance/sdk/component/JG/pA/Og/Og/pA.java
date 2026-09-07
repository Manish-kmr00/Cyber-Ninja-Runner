package com.bytedance.sdk.component.JG.pA.Og.Og;

import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.JG.pA.omh;
import com.bytedance.sdk.component.JG.pA.pA.pA.JG;
import com.bytedance.sdk.component.JG.pA.pA.pA.SD;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public class pA {
    private static ContentResolver KZx() {
        try {
            if (omh.SD().JG() != null) {
                return omh.SD().JG().getContentResolver();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void pA() {
        if (omh.SD().JG() == null) {
            return;
        }
        try {
            ContentResolver contentResolverKZx = KZx();
            if (contentResolverKZx != null) {
                contentResolverKZx.getType(Uri.parse(ZZv() + "adLogStart"));
            }
        } catch (Throwable unused) {
        }
    }

    public static void Og() {
        if (omh.SD().JG() == null) {
            return;
        }
        try {
            ContentResolver contentResolverKZx = KZx();
            if (contentResolverKZx != null) {
                contentResolverKZx.getType(Uri.parse(ZZv() + "adLogStop"));
            }
        } catch (Throwable unused) {
        }
    }

    public static void pA(com.bytedance.sdk.component.JG.pA.ZZv.pA pAVar) {
        if (pAVar == null) {
            return;
        }
        try {
            ContentResolver contentResolverKZx = KZx();
            if (contentResolverKZx != null) {
                contentResolverKZx.getType(Uri.parse(ZZv() + "adLogDispatch?event=" + JG.pA(pAVar.JG())));
            }
        } catch (Throwable th) {
            th.toString();
        }
    }

    public static void pA(String str, List<String> list, boolean z) {
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb.append(JG.pA(it.next())).append(StringUtils.COMMA);
            }
            String str2 = "?did=" + String.valueOf(str) + "&track=" + String.valueOf(JG.pA(sb.toString())) + "&replace=" + String.valueOf(z);
            ContentResolver contentResolverKZx = KZx();
            if (contentResolverKZx != null) {
                contentResolverKZx.getType(Uri.parse(ZZv() + "trackAdUrl" + str2));
            }
        } catch (Throwable unused) {
        }
    }

    public static void pA(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentResolver contentResolverKZx = KZx();
            if (contentResolverKZx != null) {
                contentResolverKZx.getType(Uri.parse(ZZv() + "trackAdFailed?did=" + String.valueOf(str)));
            }
        } catch (Throwable unused) {
        }
    }

    private static String ZZv() {
        return SD.Og + "/ad_log_event/";
    }
}
