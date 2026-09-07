package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
final class zzgzw implements Iterator {
    private final ArrayDeque zza;
    private zzgwj zzb;

    /* synthetic */ zzgzw(zzgwn zzgwnVar, zzgzx zzgzxVar) {
        if (!(zzgwnVar instanceof zzgzy)) {
            this.zza = null;
            this.zzb = (zzgwj) zzgwnVar;
            return;
        }
        zzgzy zzgzyVar = (zzgzy) zzgwnVar;
        ArrayDeque arrayDeque = new ArrayDeque(zzgzyVar.zzf());
        this.zza = arrayDeque;
        arrayDeque.push(zzgzyVar);
        this.zzb = zzb(zzgzyVar.zzd);
    }

    private final zzgwj zzb(zzgwn zzgwnVar) {
        while (zzgwnVar instanceof zzgzy) {
            zzgzy zzgzyVar = (zzgzy) zzgwnVar;
            this.zza.push(zzgzyVar);
            zzgwnVar = zzgzyVar.zzd;
        }
        return (zzgwj) zzgwnVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb != null;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzgwj next() {
        zzgwj zzgwjVarZzb;
        zzgwj zzgwjVar = this.zzb;
        if (zzgwjVar == null) {
            throw new NoSuchElementException();
        }
        do {
            ArrayDeque arrayDeque = this.zza;
            zzgwjVarZzb = null;
            if (arrayDeque == null || arrayDeque.isEmpty()) {
                break;
            }
            zzgwjVarZzb = zzb(((zzgzy) arrayDeque.pop()).zze);
        } while (zzgwjVarZzb.zzd() == 0);
        this.zzb = zzgwjVarZzb;
        return zzgwjVar;
    }
}
