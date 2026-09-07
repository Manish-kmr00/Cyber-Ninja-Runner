package com.safedk.android.analytics.brandsafety.creatives;

import android.text.TextUtils;
import com.safedk.android.utils.Logger;
import java.util.Arrays;

/* JADX INFO: loaded from: classes8.dex */
public class f extends i {
    private static final String b = "PrefetchVastAdTagUri";
    private static final String c = "\\[[\\s\\S].*?\\]";
    private final String[] d;

    public f(String str) {
        super(str);
        this.d = a(str);
        Logger.d(b, "Prefetch URI, unique parts: " + Arrays.toString(this.d));
    }

    private String[] a(String str) {
        return str != null ? str.split(c) : new String[0];
    }

    private boolean b(String str) {
        for (String str2 : this.d) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            int iIndexOf = str.indexOf(str2);
            if (iIndexOf < 0) {
                return a(str2, str);
            }
            str = str.substring(str2.length() + iIndexOf);
        }
        return true;
    }

    private static boolean a(String str, String str2) {
        int iIndexOf = str2.indexOf(38);
        if (iIndexOf > 0) {
            str2 = str2.substring(iIndexOf);
        }
        if (!str.contains(str2)) {
            return false;
        }
        Logger.d(b, "Prefetch URI, VastAdTagUri in the prefetch has a tail that is not included in the loaded URL");
        return true;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.i
    public boolean equals(Object obj) {
        return b(obj.toString());
    }
}
