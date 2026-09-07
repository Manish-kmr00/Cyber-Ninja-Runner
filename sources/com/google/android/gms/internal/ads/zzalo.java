package com.google.android.gms.internal.ads;

import com.smaato.sdk.core.dns.DnsName;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzalo {
    public final String zza;
    public final int zzb;
    public final String zzc;
    public final Set zzd;

    private zzalo(String str, int i, String str2, Set set) {
        this.zzb = i;
        this.zza = str;
        this.zzc = str2;
        this.zzd = set;
    }

    public static zzalo zza(String str, int i) {
        String str2;
        String strTrim = str.trim();
        zzdc.zzd(!strTrim.isEmpty());
        int iIndexOf = strTrim.indexOf(" ");
        if (iIndexOf == -1) {
            str2 = "";
        } else {
            String strTrim2 = strTrim.substring(iIndexOf).trim();
            strTrim = strTrim.substring(0, iIndexOf);
            str2 = strTrim2;
        }
        int i2 = zzeu.zza;
        String[] strArrSplit = strTrim.split(DnsName.ESCAPED_DOT, -1);
        String str3 = strArrSplit[0];
        HashSet hashSet = new HashSet();
        for (int i3 = 1; i3 < strArrSplit.length; i3++) {
            hashSet.add(strArrSplit[i3]);
        }
        return new zzalo(str3, i, str2, hashSet);
    }

    public static zzalo zzb() {
        return new zzalo("", 0, "", Collections.emptySet());
    }
}
