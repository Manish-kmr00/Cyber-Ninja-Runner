package com.fyber.inneractive.sdk.util;

import com.amazon.aps.shared.util.APSSharedUtil;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j0 {
    public static String a(String str, int i) {
        return (i <= 0 || str.length() <= i) ? str : str.substring(0, i - 3) + APSSharedUtil.TRUNCATE_SEPARATOR;
    }
}
