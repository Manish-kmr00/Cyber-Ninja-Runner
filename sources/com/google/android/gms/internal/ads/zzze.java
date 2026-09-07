package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzze {
    private int zza;
    private int zzb;
    private int zzc = 0;
    private zzyx[] zzd = new zzyx[100];

    public zzze(boolean z, int i) {
    }

    public final synchronized int zza() {
        return this.zzb * 65536;
    }

    public final synchronized zzyx zzb() {
        zzyx zzyxVar;
        this.zzb++;
        int i = this.zzc;
        if (i > 0) {
            zzyx[] zzyxVarArr = this.zzd;
            int i2 = i - 1;
            this.zzc = i2;
            zzyxVar = zzyxVarArr[i2];
            if (zzyxVar == null) {
                throw null;
            }
            zzyxVarArr[i2] = null;
        } else {
            zzyxVar = new zzyx(new byte[65536], 0);
            int i3 = this.zzb;
            zzyx[] zzyxVarArr2 = this.zzd;
            int length = zzyxVarArr2.length;
            if (i3 > length) {
                this.zzd = (zzyx[]) Arrays.copyOf(zzyxVarArr2, length + length);
                return zzyxVar;
            }
        }
        return zzyxVar;
    }

    public final synchronized void zzc(zzyx zzyxVar) {
        zzyx[] zzyxVarArr = this.zzd;
        int i = this.zzc;
        this.zzc = i + 1;
        zzyxVarArr[i] = zzyxVar;
        this.zzb--;
        notifyAll();
    }

    public final synchronized void zzd(zzyy zzyyVar) {
        while (zzyyVar != null) {
            zzyx[] zzyxVarArr = this.zzd;
            int i = this.zzc;
            this.zzc = i + 1;
            zzyxVarArr[i] = zzyyVar.zzc();
            this.zzb--;
            zzyyVar = zzyyVar.zzd();
        }
        notifyAll();
    }

    public final synchronized void zze() {
        zzf(0);
    }

    public final synchronized void zzf(int i) {
        int i2 = this.zza;
        this.zza = i;
        if (i < i2) {
            zzg();
        }
    }

    public final synchronized void zzg() {
        int i = this.zza;
        int i2 = zzeu.zza;
        int iMax = Math.max(0, ((i + 65535) / 65536) - this.zzb);
        int i3 = this.zzc;
        if (iMax >= i3) {
            return;
        }
        Arrays.fill(this.zzd, iMax, i3, (Object) null);
        this.zzc = iMax;
    }
}
