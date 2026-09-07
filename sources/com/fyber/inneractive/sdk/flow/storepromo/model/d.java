package com.fyber.inneractive.sdk.flow.storepromo.model;

import com.fyber.inneractive.sdk.util.C3244h;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes12.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1827a;
    public final String b;
    public final String c;

    public d(String str, String str2, String str3) {
        String str4;
        this.c = "";
        this.f1827a = str;
        this.b = str2;
        C3244h c3244h = new C3244h(str3);
        Long l = c3244h.f2363a;
        if (l == null) {
            str4 = "N/A";
        } else {
            double dLongValue = l.longValue() / 1024.0d;
            double d = dLongValue / 1024.0d;
            double d2 = d / 1024.0d;
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            String str5 = decimalFormat.format(c3244h.f2363a) + " bytes";
            if (d > 850.0d) {
                str4 = decimalFormat.format(d2) + " GB";
            } else if (dLongValue > 850.0d) {
                str4 = decimalFormat.format(d) + " MB";
            } else if (c3244h.f2363a.longValue() > 850) {
                str4 = decimalFormat.format(dLongValue) + " kB";
            } else {
                str4 = str5;
            }
        }
        this.c = str4;
    }
}
