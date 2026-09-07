package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzako implements zzaka {
    private final zzek zza = new zzek();
    private final zzek zzb = new zzek();
    private final zzakn zzc = new zzakn();
    private Inflater zzd;

    @Override // com.google.android.gms.internal.ads.zzaka
    public final void zza(byte[] bArr, int i, int i2, zzajz zzajzVar, zzdk zzdkVar) {
        zzek zzekVar = this.zza;
        zzekVar.zzJ(bArr, i2 + i);
        zzekVar.zzL(i);
        if (this.zzd == null) {
            this.zzd = new Inflater();
        }
        zzek zzekVar2 = this.zzb;
        if (zzeu.zzO(zzekVar, zzekVar2, this.zzd)) {
            zzekVar.zzJ(zzekVar2.zzN(), zzekVar2.zzd());
        }
        zzakn zzaknVar = this.zzc;
        zzaknVar.zze();
        ArrayList arrayList = new ArrayList();
        while (zzekVar.zza() >= 3) {
            int iZzd = zzekVar.zzd();
            int iZzm = zzekVar.zzm();
            int iZzq = zzekVar.zzq();
            int iZzc = zzekVar.zzc() + iZzq;
            zzcu zzcuVar = null;
            if (iZzc > iZzd) {
                zzekVar.zzL(iZzd);
            } else {
                if (iZzm != 128) {
                    switch (iZzm) {
                        case 20:
                            zzakn.zzd(zzaknVar, zzekVar, iZzq);
                            break;
                        case 21:
                            zzakn.zzb(zzaknVar, zzekVar, iZzq);
                            break;
                        case 22:
                            zzakn.zzc(zzaknVar, zzekVar, iZzq);
                            break;
                    }
                } else {
                    zzcu zzcuVarZza = zzaknVar.zza();
                    zzaknVar.zze();
                    zzcuVar = zzcuVarZza;
                }
                zzekVar.zzL(iZzc);
            }
            if (zzcuVar != null) {
                arrayList.add(zzcuVar);
            }
        }
        zzdkVar.zza(new zzajs(arrayList, -9223372036854775807L, -9223372036854775807L));
    }
}
