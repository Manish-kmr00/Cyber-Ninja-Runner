package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
final class zzgzv {
    private final ArrayDeque zza = new ArrayDeque();

    private zzgzv() {
    }

    static /* bridge */ /* synthetic */ zzgwn zza(zzgzv zzgzvVar, zzgwn zzgwnVar, zzgwn zzgwnVar2) {
        zzgzvVar.zzb(zzgwnVar);
        zzgzvVar.zzb(zzgwnVar2);
        ArrayDeque arrayDeque = zzgzvVar.zza;
        zzgwn zzgzyVar = (zzgwn) arrayDeque.pop();
        while (!arrayDeque.isEmpty()) {
            zzgzyVar = new zzgzy((zzgwn) arrayDeque.pop(), zzgzyVar);
        }
        return zzgzyVar;
    }

    private final void zzb(zzgwn zzgwnVar) {
        zzgzx zzgzxVar;
        if (!zzgwnVar.zzh()) {
            if (!(zzgwnVar instanceof zzgzy)) {
                throw new IllegalArgumentException("Has a new type of ByteString been created? Found ".concat(String.valueOf(String.valueOf(zzgwnVar.getClass()))));
            }
            zzgzy zzgzyVar = (zzgzy) zzgwnVar;
            zzb(zzgzyVar.zzd);
            zzb(zzgzyVar.zze);
            return;
        }
        int iZzc = zzc(zzgwnVar.zzd());
        ArrayDeque arrayDeque = this.zza;
        int iZzc2 = zzgzy.zzc(iZzc + 1);
        if (arrayDeque.isEmpty() || ((zzgwn) arrayDeque.peek()).zzd() >= iZzc2) {
            arrayDeque.push(zzgwnVar);
            return;
        }
        int iZzc3 = zzgzy.zzc(iZzc);
        zzgwn zzgzyVar2 = (zzgwn) arrayDeque.pop();
        while (true) {
            zzgzxVar = null;
            if (arrayDeque.isEmpty() || ((zzgwn) arrayDeque.peek()).zzd() >= iZzc3) {
                break;
            } else {
                zzgzyVar2 = new zzgzy((zzgwn) arrayDeque.pop(), zzgzyVar2);
            }
        }
        zzgzy zzgzyVar3 = new zzgzy(zzgzyVar2, zzgwnVar);
        while (!arrayDeque.isEmpty()) {
            if (((zzgwn) arrayDeque.peek()).zzd() >= zzgzy.zzc(zzc(zzgzyVar3.zzd()) + 1)) {
                break;
            } else {
                zzgzyVar3 = new zzgzy((zzgwn) arrayDeque.pop(), zzgzyVar3);
            }
        }
        arrayDeque.push(zzgzyVar3);
    }

    private static final int zzc(int i) {
        int iBinarySearch = Arrays.binarySearch(zzgzy.zza, i);
        return iBinarySearch < 0 ? (-(iBinarySearch + 1)) - 1 : iBinarySearch;
    }

    /* synthetic */ zzgzv(zzgzx zzgzxVar) {
    }
}
