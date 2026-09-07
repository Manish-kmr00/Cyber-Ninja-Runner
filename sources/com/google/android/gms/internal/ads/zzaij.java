package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaij {
    public final zzaei zza;
    public zzaiz zzd;
    public zzaif zze;
    public int zzf;
    public int zzg;
    public int zzh;
    public int zzi;
    private final String zzj;
    private boolean zzm;
    public final zzaiy zzb = new zzaiy();
    public final zzek zzc = new zzek();
    private final zzek zzk = new zzek(1);
    private final zzek zzl = new zzek();

    public zzaij(zzaei zzaeiVar, zzaiz zzaizVar, zzaif zzaifVar, String str) {
        this.zza = zzaeiVar;
        this.zzd = zzaizVar;
        this.zze = zzaifVar;
        this.zzj = str;
        zzh(zzaizVar, zzaifVar);
    }

    public final int zza() {
        int i;
        if (this.zzm) {
            i = this.zzb.zzj[this.zzf] ? 1 : 0;
        } else {
            i = this.zzd.zzg[this.zzf];
        }
        return zzf() != null ? i | 1073741824 : i;
    }

    public final int zzb() {
        return !this.zzm ? this.zzd.zzd[this.zzf] : this.zzb.zzh[this.zzf];
    }

    public final int zzc(int i, int i2) {
        zzek zzekVar;
        zzaix zzaixVarZzf = zzf();
        if (zzaixVarZzf == null) {
            return 0;
        }
        int i3 = zzaixVarZzf.zzd;
        if (i3 != 0) {
            zzekVar = this.zzb.zzn;
        } else {
            byte[] bArr = zzaixVarZzf.zze;
            int i4 = zzeu.zza;
            zzek zzekVar2 = this.zzl;
            byte[] bArr2 = bArr;
            int length = bArr2.length;
            zzekVar2.zzJ(bArr2, length);
            zzekVar = zzekVar2;
            i3 = length;
        }
        zzaiy zzaiyVar = this.zzb;
        boolean zZzb = zzaiyVar.zzb(this.zzf);
        boolean z = zZzb || i2 != 0;
        zzek zzekVar3 = this.zzk;
        zzekVar3.zzN()[0] = (byte) ((true != z ? 0 : 128) | i3);
        zzekVar3.zzL(0);
        zzaei zzaeiVar = this.zza;
        zzaeiVar.zzs(zzekVar3, 1, 1);
        zzaeiVar.zzs(zzekVar, i3, 1);
        if (!z) {
            return i3 + 1;
        }
        if (!zZzb) {
            zzek zzekVar4 = this.zzc;
            zzekVar4.zzI(8);
            byte[] bArrZzN = zzekVar4.zzN();
            bArrZzN[0] = 0;
            bArrZzN[1] = 1;
            bArrZzN[2] = 0;
            bArrZzN[3] = (byte) i2;
            bArrZzN[4] = (byte) ((i >> 24) & 255);
            bArrZzN[5] = (byte) ((i >> 16) & 255);
            bArrZzN[6] = (byte) ((i >> 8) & 255);
            bArrZzN[7] = (byte) (i & 255);
            zzaeiVar.zzs(zzekVar4, 8, 1);
            return i3 + 9;
        }
        int i5 = i3 + 1;
        zzek zzekVar5 = zzaiyVar.zzn;
        int iZzq = zzekVar5.zzq();
        zzekVar5.zzM(-2);
        int i6 = (iZzq * 6) + 2;
        if (i2 != 0) {
            zzek zzekVar6 = this.zzc;
            zzekVar6.zzI(i6);
            byte[] bArrZzN2 = zzekVar6.zzN();
            zzekVar5.zzH(bArrZzN2, 0, i6);
            int i7 = (((bArrZzN2[2] & 255) << 8) | (bArrZzN2[3] & 255)) + i2;
            bArrZzN2[2] = (byte) ((i7 >> 8) & 255);
            bArrZzN2[3] = (byte) (i7 & 255);
            zzekVar5 = zzekVar6;
        }
        zzaeiVar.zzs(zzekVar5, i6, 1);
        return i5 + i6;
    }

    public final long zzd() {
        return !this.zzm ? this.zzd.zzc[this.zzf] : this.zzb.zzf[this.zzh];
    }

    public final long zze() {
        if (!this.zzm) {
            return this.zzd.zzf[this.zzf];
        }
        zzaiy zzaiyVar = this.zzb;
        return zzaiyVar.zzi[this.zzf];
    }

    public final zzaix zzf() {
        if (!this.zzm) {
            return null;
        }
        zzaiy zzaiyVar = this.zzb;
        zzaif zzaifVar = zzaiyVar.zza;
        int i = zzeu.zza;
        int i2 = zzaifVar.zza;
        zzaix zzaixVarZzb = zzaiyVar.zzm;
        if (zzaixVarZzb == null) {
            zzaixVarZzb = this.zzd.zza.zzb(i2);
        }
        if (zzaixVarZzb == null || !zzaixVarZzb.zza) {
            return null;
        }
        return zzaixVarZzb;
    }

    public final void zzh(zzaiz zzaizVar, zzaif zzaifVar) {
        this.zzd = zzaizVar;
        this.zze = zzaifVar;
        zzx zzxVarZzb = zzaizVar.zza.zzg.zzb();
        zzxVarZzb.zzE(this.zzj);
        this.zza.zzm(zzxVarZzb.zzaj());
        zzi();
    }

    public final void zzi() {
        zzaiy zzaiyVar = this.zzb;
        zzaiyVar.zzd = 0;
        zzaiyVar.zzp = 0L;
        zzaiyVar.zzq = false;
        zzaiyVar.zzk = false;
        zzaiyVar.zzo = false;
        zzaiyVar.zzm = null;
        this.zzf = 0;
        this.zzh = 0;
        this.zzg = 0;
        this.zzi = 0;
        this.zzm = false;
    }

    public final void zzj(zzs zzsVar) {
        zzaiw zzaiwVar = this.zzd.zza;
        zzaif zzaifVar = this.zzb.zza;
        int i = zzeu.zza;
        zzaix zzaixVarZzb = zzaiwVar.zzb(zzaifVar.zza);
        zzs zzsVarZzb = zzsVar.zzb(zzaixVarZzb != null ? zzaixVarZzb.zzb : null);
        zzz zzzVar = this.zzd.zza.zzg;
        String str = this.zzj;
        zzx zzxVarZzb = zzzVar.zzb();
        zzxVarZzb.zzE(str);
        zzxVarZzb.zzH(zzsVarZzb);
        this.zza.zzm(zzxVarZzb.zzaj());
    }

    public final boolean zzl() {
        this.zzf++;
        if (!this.zzm) {
            return false;
        }
        int i = this.zzg + 1;
        this.zzg = i;
        int[] iArr = this.zzb.zzg;
        int i2 = this.zzh;
        if (i != iArr[i2]) {
            return true;
        }
        this.zzh = i2 + 1;
        this.zzg = 0;
        return false;
    }
}
