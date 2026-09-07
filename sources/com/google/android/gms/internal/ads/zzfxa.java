package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzfxa extends zzfwp {
    Object[] zzd;
    private int zze;

    public zzfxa() {
        super(4);
    }

    @Override // com.google.android.gms.internal.ads.zzfwp, com.google.android.gms.internal.ads.zzfwq
    public final /* bridge */ /* synthetic */ zzfwq zzb(Object obj) {
        zzf(obj);
        return this;
    }

    public final zzfxa zzg(Object... objArr) {
        if (this.zzd != null) {
            for (int i = 0; i < 2; i++) {
                zzf(objArr[i]);
            }
        } else {
            zzd(objArr, 2);
        }
        return this;
    }

    zzfxa(int i, boolean z) {
        super(i);
        this.zzd = new Object[zzfxb.zzh(i)];
    }

    public final zzfxa zzh(Iterable iterable) {
        iterable.getClass();
        if (this.zzd != null) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                zzf(it.next());
            }
        } else {
            super.zzc(iterable);
        }
        return this;
    }

    public final zzfxb zzi() {
        zzfxb zzfxbVarZzv;
        int i = this.zzb;
        if (i == 0) {
            return zzfyo.zza;
        }
        if (i == 1) {
            return new zzfyz(Objects.requireNonNull(this.zza[0]));
        }
        if (this.zzd == null || zzfxb.zzh(i) != this.zzd.length) {
            zzfxbVarZzv = zzfxb.zzv(this.zzb, this.zza);
            this.zzb = zzfxbVarZzv.size();
        } else {
            int i2 = this.zzb;
            Object[] objArrCopyOf = this.zza;
            if (zzfxb.zzw(i2, objArrCopyOf.length)) {
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, i2);
            }
            int i3 = this.zze;
            Object[] objArr = this.zzd;
            zzfxbVarZzv = new zzfyo(objArrCopyOf, i3, objArr, objArr.length - 1, this.zzb);
        }
        this.zzc = true;
        this.zzd = null;
        return zzfxbVarZzv;
    }

    public final zzfxa zzf(Object obj) {
        obj.getClass();
        if (this.zzd != null) {
            int iZzh = zzfxb.zzh(this.zzb);
            Object[] objArr = this.zzd;
            if (iZzh <= objArr.length) {
                Objects.requireNonNull(objArr);
                int length = this.zzd.length - 1;
                int iHashCode = obj.hashCode();
                int iZza = zzfwo.zza(iHashCode);
                while (true) {
                    int i = iZza & length;
                    Object[] objArr2 = this.zzd;
                    Object obj2 = objArr2[i];
                    if (obj2 != null) {
                        if (obj2.equals(obj)) {
                            break;
                        }
                        iZza = i + 1;
                    } else {
                        objArr2[i] = obj;
                        this.zze += iHashCode;
                        super.zza(obj);
                        break;
                    }
                }
                return this;
            }
        }
        this.zzd = null;
        super.zza(obj);
        return this;
    }
}
