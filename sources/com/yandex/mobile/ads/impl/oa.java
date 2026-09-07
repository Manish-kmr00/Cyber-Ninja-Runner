package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Base64;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
public final class oa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f9797a = (long) (Math.floor(Math.random() * 4294967295L) + ((double) 1));
    public static final /* synthetic */ int b = 0;

    private static String a(String str, Map map) {
        if (map == null) {
            return str;
        }
        Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
        for (Map.Entry entry : map.entrySet()) {
            Uri uri = Uri.parse("?" + ((String) entry.getKey()) + "=" + ((String) entry.getValue()));
            for (String str2 : uri.getQueryParameterNames()) {
                builderBuildUpon.appendQueryParameter(str2, uri.getQueryParameter(str2));
            }
        }
        String string = builderBuildUpon.build().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @JvmStatic
    public static final ArrayList a(o8 adResponse, Map map) {
        yx1 yx1Var;
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        List<String> listL = adResponse.l();
        List<Long> listF = adResponse.f();
        List<Integer> listQ = adResponse.q();
        ArrayList arrayList = new ArrayList();
        if (listL != null && listF != null && listQ != null) {
            int size = listL.size();
            int i = 0;
            while (i < size) {
                String url = a(listL.get(i), map);
                long jLongValue = listF.size() > i ? listF.get(i).longValue() : 0L;
                int iIntValue = listQ.size() > i ? listQ.get(i).intValue() : 0;
                Intrinsics.checkNotNullParameter(url, "url");
                if (StringsKt.contains$default((CharSequence) url, (CharSequence) "/rtbcount/", false, 2, (Object) null)) {
                    yx1Var = yx1.c;
                } else if (StringsKt.contains$default((CharSequence) url, (CharSequence) "/count/", false, 2, (Object) null)) {
                    yx1Var = yx1.b;
                } else {
                    yx1Var = yx1.d;
                }
                arrayList.add(new xx1(iIntValue, jLongValue, yx1Var, url));
                i++;
            }
        }
        return arrayList;
    }

    public static Bitmap a(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            String strSubstring = data.substring(StringsKt.indexOf$default((CharSequence) data, StringUtils.COMMA, 0, false, 6, (Object) null) + 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            if (strSubstring.length() <= 0) {
                return null;
            }
            byte[] bArrDecode = Base64.decode(strSubstring, 0);
            return BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
        } catch (Exception unused) {
            return null;
        }
    }

    @JvmStatic
    public static final <T> String a(T t) {
        String string = t != null ? t.toString() : null;
        return string == null ? "" : string;
    }

    public static boolean a(qo qoVar) {
        return qoVar == null || qoVar.a();
    }

    @JvmStatic
    public static final boolean a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            return kj2.a(context) != null;
        } catch (Throwable unused) {
        }
    }

    public static long a() {
        return f9797a;
    }
}
