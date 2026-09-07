package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzalc {
    public static zzald zza(zzald zzaldVar, String[] strArr, Map map) {
        int length;
        int i = 0;
        if (zzaldVar == null) {
            if (strArr == null) {
                return null;
            }
            int length2 = strArr.length;
            if (length2 == 1) {
                return (zzald) map.get(strArr[0]);
            }
            if (length2 > 1) {
                zzald zzaldVar2 = new zzald();
                while (i < length2) {
                    zzaldVar2.zzl((zzald) map.get(strArr[i]));
                    i++;
                }
                return zzaldVar2;
            }
        } else {
            if (strArr != null && strArr.length == 1) {
                zzaldVar.zzl((zzald) map.get(strArr[0]));
                return zzaldVar;
            }
            if (strArr != null && (length = strArr.length) > 1) {
                while (i < length) {
                    zzaldVar.zzl((zzald) map.get(strArr[i]));
                    i++;
                }
            }
        }
        return zzaldVar;
    }
}
