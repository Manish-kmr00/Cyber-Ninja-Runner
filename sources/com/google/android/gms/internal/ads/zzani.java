package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzani implements zzanv {
    private final zzanh zza;
    private final zzek zzb = new zzek(32);
    private int zzc;
    private int zzd;
    private boolean zze;
    private boolean zzf;

    public zzani(zzanh zzanhVar) {
        this.zza = zzanhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzanv
    public final void zza(zzek zzekVar, int i) {
        int iZzc;
        int i2 = i & 1;
        if (i2 != 0) {
            iZzc = zzekVar.zzc() + zzekVar.zzm();
        } else {
            iZzc = -1;
        }
        if (this.zzf) {
            if (i2 == 0) {
                return;
            }
            this.zzf = false;
            zzekVar.zzL(iZzc);
            this.zzd = 0;
        }
        while (zzekVar.zza() > 0) {
            int i3 = this.zzd;
            if (i3 < 3) {
                if (i3 == 0) {
                    int iZzm = zzekVar.zzm();
                    zzekVar.zzL(zzekVar.zzc() - 1);
                    if (iZzm == 255) {
                        this.zzf = true;
                        return;
                    }
                }
                int iMin = Math.min(zzekVar.zza(), 3 - this.zzd);
                zzek zzekVar2 = this.zzb;
                zzekVar.zzH(zzekVar2.zzN(), this.zzd, iMin);
                int i4 = this.zzd + iMin;
                this.zzd = i4;
                if (i4 == 3) {
                    zzekVar2.zzL(0);
                    zzekVar2.zzK(3);
                    zzekVar2.zzM(1);
                    int iZzm2 = zzekVar2.zzm();
                    boolean z = (iZzm2 & 128) != 0;
                    int iZzm3 = zzekVar2.zzm();
                    this.zze = z;
                    this.zzc = (((iZzm2 & 15) << 8) | iZzm3) + 3;
                    int iZzb = zzekVar2.zzb();
                    int i5 = this.zzc;
                    if (iZzb < i5) {
                        int iZzb2 = zzekVar2.zzb();
                        zzekVar2.zzF(Math.min(4098, Math.max(i5, iZzb2 + iZzb2)));
                    }
                }
            } else {
                int iMin2 = Math.min(zzekVar.zza(), this.zzc - this.zzd);
                zzek zzekVar3 = this.zzb;
                zzekVar.zzH(zzekVar3.zzN(), this.zzd, iMin2);
                int i6 = this.zzd + iMin2;
                this.zzd = i6;
                int i7 = this.zzc;
                if (i6 != i7) {
                    continue;
                } else {
                    if (!this.zze) {
                        zzekVar3.zzK(i7);
                    } else {
                        if (zzeu.zzf(zzekVar3.zzN(), 0, i7, -1) != 0) {
                            this.zzf = true;
                            return;
                        }
                        zzekVar3.zzK(this.zzc - 4);
                    }
                    zzekVar3.zzL(0);
                    this.zza.zza(zzekVar3);
                    this.zzd = 0;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanv
    public final void zzb(zzer zzerVar, zzadf zzadfVar, zzanu zzanuVar) {
        this.zza.zzb(zzerVar, zzadfVar, zzanuVar);
        this.zzf = true;
    }

    @Override // com.google.android.gms.internal.ads.zzanv
    public final void zzc() {
        this.zzf = true;
    }
}
