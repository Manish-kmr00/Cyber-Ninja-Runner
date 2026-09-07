package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaml implements zzamg {
    private static final float[] zza = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};
    private final zzanx zzb;
    private zzamk zzg;
    private long zzh;
    private String zzi;
    private zzaei zzj;
    private boolean zzk;
    private final boolean[] zzd = new boolean[4];
    private final zzamj zze = new zzamj(128);
    private long zzl = -9223372036854775807L;
    private final zzamy zzf = new zzamy(178, 128);
    private final zzek zzc = new zzek();

    zzaml(zzanx zzanxVar, String str) {
        this.zzb = zzanxVar;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x010f  */
    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zza(zzek zzekVar) {
        int i;
        int i2;
        zzdc.zzb(this.zzg);
        zzdc.zzb(this.zzj);
        int iZzc = zzekVar.zzc();
        int iZzd = zzekVar.zzd();
        byte[] bArrZzN = zzekVar.zzN();
        this.zzh += (long) zzekVar.zza();
        this.zzj.zzr(zzekVar, zzekVar.zza());
        while (true) {
            int iZza = zzfq.zza(bArrZzN, iZzc, iZzd, this.zzd);
            if (iZza == iZzd) {
                break;
            }
            int i3 = iZza + 3;
            int i4 = zzekVar.zzN()[i3] & 255;
            int i5 = iZza - iZzc;
            if (!this.zzk) {
                if (i5 > 0) {
                    this.zze.zza(bArrZzN, iZzc, iZza);
                }
                int i6 = i5 < 0 ? -i5 : 0;
                zzamj zzamjVar = this.zze;
                if (zzamjVar.zzc(i4, i6)) {
                    zzaei zzaeiVar = this.zzj;
                    int i7 = zzamjVar.zzb;
                    String str = this.zzi;
                    str.getClass();
                    byte[] bArrCopyOf = Arrays.copyOf(zzamjVar.zzc, zzamjVar.zza);
                    zzej zzejVar = new zzej(bArrCopyOf, bArrCopyOf.length);
                    zzejVar.zzo(i7);
                    zzejVar.zzo(4);
                    zzejVar.zzm();
                    zzejVar.zzn(8);
                    if (zzejVar.zzp()) {
                        zzejVar.zzn(4);
                        zzejVar.zzn(3);
                    }
                    int iZzd2 = zzejVar.zzd(4);
                    float f = 1.0f;
                    if (iZzd2 == 15) {
                        int iZzd3 = zzejVar.zzd(8);
                        int iZzd4 = zzejVar.zzd(8);
                        if (iZzd4 == 0) {
                            zzdx.zzf("H263Reader", "Invalid aspect ratio");
                        } else {
                            f = iZzd3 / iZzd4;
                        }
                    } else if (iZzd2 < 7) {
                        f = zza[iZzd2];
                    } else {
                        zzdx.zzf("H263Reader", "Invalid aspect ratio");
                    }
                    float f2 = f;
                    if (zzejVar.zzp()) {
                        zzejVar.zzn(2);
                        zzejVar.zzn(1);
                        if (zzejVar.zzp()) {
                            zzejVar.zzn(15);
                            zzejVar.zzm();
                            zzejVar.zzn(15);
                            zzejVar.zzm();
                            zzejVar.zzn(15);
                            zzejVar.zzm();
                            zzejVar.zzn(3);
                            zzejVar.zzn(11);
                            zzejVar.zzm();
                            zzejVar.zzn(15);
                            zzejVar.zzm();
                            i2 = 2;
                        } else {
                            i2 = 2;
                        }
                    } else {
                        i2 = 2;
                    }
                    if (zzejVar.zzd(i2) != 0) {
                        zzdx.zzf("H263Reader", "Unhandled video object layer shape");
                    }
                    zzejVar.zzm();
                    int iZzd5 = zzejVar.zzd(16);
                    zzejVar.zzm();
                    if (zzejVar.zzp()) {
                        if (iZzd5 == 0) {
                            zzdx.zzf("H263Reader", "Invalid vop_increment_time_resolution");
                        } else {
                            int i8 = iZzd5 - 1;
                            int i9 = 0;
                            while (i8 > 0) {
                                i8 >>= 1;
                                i9++;
                            }
                            zzejVar.zzn(i9);
                        }
                    }
                    zzejVar.zzm();
                    int iZzd6 = zzejVar.zzd(13);
                    zzejVar.zzm();
                    int iZzd7 = zzejVar.zzd(13);
                    zzejVar.zzm();
                    zzejVar.zzm();
                    zzx zzxVar = new zzx();
                    zzxVar.zzO(str);
                    zzxVar.zzE("video/mp2t");
                    zzxVar.zzad("video/mp4v-es");
                    zzxVar.zzai(iZzd6);
                    zzxVar.zzM(iZzd7);
                    zzxVar.zzZ(f2);
                    zzxVar.zzP(Collections.singletonList(bArrCopyOf));
                    zzaeiVar.zzm(zzxVar.zzaj());
                    this.zzk = true;
                }
            }
            this.zzg.zza(bArrZzN, iZzc, iZza);
            zzamy zzamyVar = this.zzf;
            if (i5 > 0) {
                zzamyVar.zza(bArrZzN, iZzc, iZza);
                i = 0;
            } else {
                i = -i5;
            }
            if (zzamyVar.zzd(i)) {
                int iZzc2 = zzfq.zzc(zzamyVar.zza, zzamyVar.zzb);
                zzek zzekVar2 = this.zzc;
                int i10 = zzeu.zza;
                zzekVar2.zzJ(zzamyVar.zza, iZzc2);
                this.zzb.zza(this.zzl, zzekVar2);
            }
            if (i4 == 178) {
                if (zzekVar.zzN()[iZza + 2] == 1) {
                    zzamyVar.zzc(178);
                }
                i4 = 178;
            }
            int i11 = iZzd - iZza;
            this.zzg.zzb(this.zzh - ((long) i11), i11, this.zzk);
            this.zzg.zzc(i4, this.zzl);
            iZzc = i3;
        }
        if (!this.zzk) {
            this.zze.zza(bArrZzN, iZzc, iZzd);
        }
        this.zzg.zza(bArrZzN, iZzc, iZzd);
        this.zzf.zza(bArrZzN, iZzc, iZzd);
    }

    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zzb(zzadf zzadfVar, zzanu zzanuVar) {
        zzanuVar.zzc();
        this.zzi = zzanuVar.zzb();
        this.zzj = zzadfVar.zzw(zzanuVar.zza(), 2);
        this.zzg = new zzamk(this.zzj);
        this.zzb.zzb(zzadfVar, zzanuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zzc(boolean z) {
        zzdc.zzb(this.zzg);
        if (z) {
            this.zzg.zzb(this.zzh, 0, this.zzk);
            this.zzg.zzd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zzd(long j, int i) {
        this.zzl = j;
    }

    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zze() {
        zzfq.zzi(this.zzd);
        this.zze.zzb();
        zzamk zzamkVar = this.zzg;
        if (zzamkVar != null) {
            zzamkVar.zzd();
        }
        this.zzf.zzb();
        this.zzh = 0L;
        this.zzl = -9223372036854775807L;
    }
}
