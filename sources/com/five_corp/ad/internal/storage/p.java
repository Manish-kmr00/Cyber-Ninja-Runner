package com.five_corp.ad.internal.storage;

import java.util.Random;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public final class p {
    public static final Pattern b = Pattern.compile("(\\.\\w+)$");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Random f1539a;

    public p(Random random) {
        this.f1539a = random;
    }

    public static String a(String str) {
        int iLastIndexOf = str.lastIndexOf(".");
        if (iLastIndexOf >= 0) {
            str = str.substring(0, iLastIndexOf);
        }
        String[] strArrSplit = str.split("=");
        if (strArrSplit.length != 3) {
            return null;
        }
        return strArrSplit[1];
    }
}
