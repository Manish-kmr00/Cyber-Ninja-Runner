package com.fyber.inneractive.sdk.model.vast;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.util.IAlog;
import com.smaato.sdk.core.dns.DnsName;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes12.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1876a;
    public final String b;
    public int c;
    public final int d;

    /* JADX WARN: Code duplicated, block: B:22:0x0056  */
    /* JADX WARN: Code duplicated, block: B:24:0x005e  */
    /* JADX WARN: Code duplicated, block: B:35:0x009a  */
    public e(String str, String str2) {
        int i;
        String str3;
        ArrayList arrayListA;
        this.f1876a = str;
        this.b = str2;
        int iIntValue = -1;
        if (TextUtils.isEmpty(str2) || str2.startsWith("-")) {
            i = 0;
        } else if (str2.endsWith("%") && str2.endsWith("%")) {
            try {
                int i2 = TextUtils.isEmpty(str2) ? -1 : Integer.parseInt(str2.substring(0, str2.length() - 1));
                if (i2 >= 0 && i2 <= 100) {
                    i = 1;
                } else if (str2.contains(":")) {
                    arrayListA = a(str2);
                    if (arrayListA.isEmpty()) {
                        i = 0;
                    } else {
                        i = 0;
                    }
                } else {
                    i = 0;
                }
            } catch (NumberFormatException e) {
                IAlog.f("ProgressTrackingEvent: failed isPercentageOffsetValid with %s", e.getMessage());
            }
        } else if (str2.contains(":")) {
            arrayListA = a(str2);
            if (arrayListA.isEmpty() || ((Integer) arrayListA.get(0)).intValue() < 0 || ((Integer) arrayListA.get(1)).intValue() < 0 || ((Integer) arrayListA.get(2)).intValue() < 0 || ((Integer) arrayListA.get(3)).intValue() < 0) {
                i = 0;
            } else {
                i = 2;
            }
        } else {
            i = 0;
        }
        this.d = i;
        if (i == 2 && (str3 = this.b) != null) {
            ArrayList arrayListA2 = a(str3);
            iIntValue = ((Integer) arrayListA2.get(3)).intValue() + ((((Integer) arrayListA2.get(2)).intValue() + (((Integer) arrayListA2.get(1)).intValue() * 60) + (((Integer) arrayListA2.get(0)).intValue() * 3600)) * 1000);
        }
        this.c = iIntValue;
    }

    public static ArrayList a(String str) {
        ArrayList arrayList = new ArrayList();
        if (str == null) {
            return arrayList;
        }
        String[] strArrSplit = str.split(":");
        if (strArrSplit.length != 3) {
            return arrayList;
        }
        String str2 = strArrSplit[0];
        String str3 = strArrSplit[1];
        String[] strArrSplit2 = strArrSplit[2].split(DnsName.ESCAPED_DOT);
        String str4 = strArrSplit2[0];
        String str5 = strArrSplit2.length > 1 ? strArrSplit2[1] : "000";
        try {
            arrayList.add(Integer.valueOf(Integer.parseInt(str2)));
            arrayList.add(Integer.valueOf(Integer.parseInt(str3)));
            arrayList.add(Integer.valueOf(Integer.parseInt(str4)));
            arrayList.add(Integer.valueOf(Integer.parseInt(str5)));
            return arrayList;
        } catch (NumberFormatException e) {
            IAlog.f("ProgressTrackingEvent: failed convertOffsetToTimeList with %s", e.getMessage());
            return new ArrayList();
        }
    }
}
