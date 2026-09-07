package com.google.android.gms.internal.ads;

import android.text.Layout;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzald {
    private String zza;
    private int zzb;
    private boolean zzc;
    private int zzd;
    private boolean zze;
    private float zzk;
    private String zzl;
    private Layout.Alignment zzo;
    private Layout.Alignment zzp;
    private zzakw zzr;
    private String zzt;
    private String zzu;
    private int zzf = -1;
    private int zzg = -1;
    private int zzh = -1;
    private int zzi = -1;
    private int zzj = -1;
    private int zzm = -1;
    private int zzn = -1;
    private int zzq = -1;
    private float zzs = Float.MAX_VALUE;

    public final zzald zzA(float f) {
        this.zzs = f;
        return this;
    }

    public final zzald zzB(Layout.Alignment alignment) {
        this.zzo = alignment;
        return this;
    }

    public final zzald zzC(boolean z) {
        this.zzq = z ? 1 : 0;
        return this;
    }

    public final zzald zzD(zzakw zzakwVar) {
        this.zzr = zzakwVar;
        return this;
    }

    public final zzald zzE(boolean z) {
        this.zzg = z ? 1 : 0;
        return this;
    }

    public final String zzF() {
        return this.zzu;
    }

    public final String zzG() {
        return this.zza;
    }

    public final String zzH() {
        return this.zzl;
    }

    public final String zzI() {
        return this.zzt;
    }

    public final boolean zzJ() {
        return this.zzq == 1;
    }

    public final boolean zzK() {
        return this.zze;
    }

    public final boolean zzL() {
        return this.zzc;
    }

    public final boolean zzM() {
        return this.zzf == 1;
    }

    public final boolean zzN() {
        return this.zzg == 1;
    }

    public final float zza() {
        return this.zzk;
    }

    public final float zzb() {
        return this.zzs;
    }

    public final int zzc() {
        if (this.zze) {
            return this.zzd;
        }
        throw new IllegalStateException("Background color has not been defined.");
    }

    public final int zzd() {
        if (this.zzc) {
            return this.zzb;
        }
        throw new IllegalStateException("Font color has not been defined.");
    }

    public final int zze() {
        return this.zzj;
    }

    public final int zzf() {
        return this.zzn;
    }

    public final int zzg() {
        return this.zzm;
    }

    public final int zzh() {
        int i = this.zzh;
        if (i == -1 && this.zzi == -1) {
            return -1;
        }
        return (i == 1 ? 1 : 0) | (this.zzi == 1 ? 2 : 0);
    }

    public final Layout.Alignment zzi() {
        return this.zzp;
    }

    public final Layout.Alignment zzj() {
        return this.zzo;
    }

    public final zzakw zzk() {
        return this.zzr;
    }

    public final zzald zzl(zzald zzaldVar) {
        int i;
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        String str;
        if (zzaldVar != null) {
            if (!this.zzc && zzaldVar.zzc) {
                zzp(zzaldVar.zzb);
            }
            if (this.zzh == -1) {
                this.zzh = zzaldVar.zzh;
            }
            if (this.zzi == -1) {
                this.zzi = zzaldVar.zzi;
            }
            if (this.zza == null && (str = zzaldVar.zza) != null) {
                this.zza = str;
            }
            if (this.zzf == -1) {
                this.zzf = zzaldVar.zzf;
            }
            if (this.zzg == -1) {
                this.zzg = zzaldVar.zzg;
            }
            if (this.zzn == -1) {
                this.zzn = zzaldVar.zzn;
            }
            if (this.zzo == null && (alignment2 = zzaldVar.zzo) != null) {
                this.zzo = alignment2;
            }
            if (this.zzp == null && (alignment = zzaldVar.zzp) != null) {
                this.zzp = alignment;
            }
            if (this.zzq == -1) {
                this.zzq = zzaldVar.zzq;
            }
            if (this.zzj == -1) {
                this.zzj = zzaldVar.zzj;
                this.zzk = zzaldVar.zzk;
            }
            if (this.zzr == null) {
                this.zzr = zzaldVar.zzr;
            }
            if (this.zzs == Float.MAX_VALUE) {
                this.zzs = zzaldVar.zzs;
            }
            if (this.zzt == null) {
                this.zzt = zzaldVar.zzt;
            }
            if (this.zzu == null) {
                this.zzu = zzaldVar.zzu;
            }
            if (!this.zze && zzaldVar.zze) {
                zzm(zzaldVar.zzd);
            }
            if (this.zzm == -1 && (i = zzaldVar.zzm) != -1) {
                this.zzm = i;
            }
        }
        return this;
    }

    public final zzald zzm(int i) {
        this.zzd = i;
        this.zze = true;
        return this;
    }

    public final zzald zzn(boolean z) {
        this.zzh = z ? 1 : 0;
        return this;
    }

    public final zzald zzo(String str) {
        this.zzu = str;
        return this;
    }

    public final zzald zzp(int i) {
        this.zzb = i;
        this.zzc = true;
        return this;
    }

    public final zzald zzq(String str) {
        this.zza = str;
        return this;
    }

    public final zzald zzr(float f) {
        this.zzk = f;
        return this;
    }

    public final zzald zzs(int i) {
        this.zzj = i;
        return this;
    }

    public final zzald zzt(String str) {
        this.zzl = str;
        return this;
    }

    public final zzald zzu(boolean z) {
        this.zzi = z ? 1 : 0;
        return this;
    }

    public final zzald zzv(boolean z) {
        this.zzf = z ? 1 : 0;
        return this;
    }

    public final zzald zzw(Layout.Alignment alignment) {
        this.zzp = alignment;
        return this;
    }

    public final zzald zzx(String str) {
        this.zzt = str;
        return this;
    }

    public final zzald zzy(int i) {
        this.zzn = i;
        return this;
    }

    public final zzald zzz(int i) {
        this.zzm = i;
        return this;
    }
}
