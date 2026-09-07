package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzyg extends zzyi implements Comparable {
    private final int zze;
    private final boolean zzf;
    private final boolean zzg;
    private final boolean zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final boolean zzm;

    public zzyg(int i, zzbm zzbmVar, int i2, zzyb zzybVar, int i3, String str, String str2) {
        int iZzc;
        int i4;
        super(i, zzbmVar, i2);
        int i5 = 0;
        this.zzf = zzlv.zza(i3, false);
        int i6 = this.zzd.zze;
        int i7 = zzybVar.zzy;
        this.zzg = 1 == (i6 & 1);
        this.zzh = (i6 & 2) != 0;
        zzfww zzfwwVarZzo = str2 != null ? zzfww.zzo(str2) : zzybVar.zzv.isEmpty() ? zzfww.zzo("") : zzybVar.zzv;
        int i8 = 0;
        while (true) {
            if (i8 >= zzfwwVarZzo.size()) {
                i8 = Integer.MAX_VALUE;
                iZzc = 0;
                break;
            }
            zzz zzzVar = this.zzd;
            String str3 = (String) zzfwwVarZzo.get(i8);
            boolean z = zzybVar.zzz;
            iZzc = zzyn.zzc(zzzVar, str3, false);
            if (iZzc > 0) {
                break;
            } else {
                i8++;
            }
        }
        this.zzi = i8;
        this.zzj = iZzc;
        if (str2 != null) {
            i4 = 1088;
        } else {
            int i9 = zzybVar.zzw;
            i4 = 0;
        }
        int iZzb = zzyn.zzb(this.zzd.zzf, i4);
        this.zzk = iZzb;
        this.zzm = (1088 & this.zzd.zzf) != 0;
        int iZzc2 = zzyn.zzc(this.zzd, str, zzyn.zzh(str) == null);
        this.zzl = iZzc2;
        boolean z2 = iZzc > 0 || (zzybVar.zzv.isEmpty() && iZzb > 0) || this.zzg || (this.zzh && iZzc2 > 0);
        if (zzlv.zza(i3, zzybVar.zzR) && z2) {
            i5 = 1;
        }
        this.zze = i5;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzyg zzygVar) {
        zzfwl zzfwlVarZzc = zzfwl.zzj().zzd(this.zzf, zzygVar.zzf).zzc(Integer.valueOf(this.zzi), Integer.valueOf(zzygVar.zzi), zzfyh.zzc().zza());
        int i = this.zzj;
        zzfwl zzfwlVarZzb = zzfwlVarZzc.zzb(i, zzygVar.zzj);
        int i2 = this.zzk;
        zzfwl zzfwlVarZzb2 = zzfwlVarZzb.zzb(i2, zzygVar.zzk).zzd(this.zzg, zzygVar.zzg).zzc(Boolean.valueOf(this.zzh), Boolean.valueOf(zzygVar.zzh), i == 0 ? zzfyh.zzc() : zzfyh.zzc().zza()).zzb(this.zzl, zzygVar.zzl);
        if (i2 == 0) {
            zzfwlVarZzb2 = zzfwlVarZzb2.zze(this.zzm, zzygVar.zzm);
        }
        return zzfwlVarZzb2.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzyi
    public final int zzb() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzyi
    public final /* bridge */ /* synthetic */ boolean zzc(zzyi zzyiVar) {
        return false;
    }
}
