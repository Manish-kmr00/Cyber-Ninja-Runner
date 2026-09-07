package com.google.android.gms.internal.ads;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseArray;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzang implements zzadc {
    private boolean zze;
    private boolean zzf;
    private boolean zzg;
    private long zzh;
    private zzand zzi;
    private zzadf zzj;
    private boolean zzk;
    private final zzer zza = new zzer(0);
    private final zzek zzc = new zzek(4096);
    private final SparseArray zzb = new SparseArray();
    private final zzane zzd = new zzane();

    /* JADX WARN: Code duplicated, block: B:64:0x013c  */
    @Override // com.google.android.gms.internal.ads.zzadc
    public final int zzb(zzadd zzaddVar, zzady zzadyVar) throws IOException {
        zzamg zzamiVar;
        zzdc.zzb(this.zzj);
        long jZzd = zzaddVar.zzd();
        if (jZzd != -1) {
            zzane zzaneVar = this.zzd;
            if (!zzaneVar.zze()) {
                return zzaneVar.zza(zzaddVar, zzadyVar);
            }
        }
        if (!this.zzk) {
            this.zzk = true;
            zzane zzaneVar2 = this.zzd;
            if (zzaneVar2.zzb() != -9223372036854775807L) {
                zzand zzandVar = new zzand(zzaneVar2.zzd(), zzaneVar2.zzb(), jZzd);
                this.zzi = zzandVar;
                this.zzj.zzP(zzandVar.zzb());
            } else {
                this.zzj.zzP(new zzaea(zzaneVar2.zzb(), 0L));
            }
        }
        zzand zzandVar2 = this.zzi;
        if (zzandVar2 != null && zzandVar2.zze()) {
            return zzandVar2.zza(zzaddVar, zzadyVar);
        }
        zzaddVar.zzj();
        long jZze = jZzd != -1 ? jZzd - zzaddVar.zze() : -1L;
        if (jZze != -1 && jZze < 4) {
            return -1;
        }
        zzek zzekVar = this.zzc;
        if (!zzaddVar.zzm(zzekVar.zzN(), 0, 4, true)) {
            return -1;
        }
        zzekVar.zzL(0);
        int iZzg = zzekVar.zzg();
        if (iZzg == 441) {
            return -1;
        }
        if (iZzg == 442) {
            zzaddVar.zzh(zzekVar.zzN(), 0, 10);
            zzekVar.zzL(9);
            zzaddVar.zzk((zzekVar.zzm() & 7) + 14);
            return 0;
        }
        if (iZzg == 443) {
            zzaddVar.zzh(zzekVar.zzN(), 0, 2);
            zzekVar.zzL(0);
            zzaddVar.zzk(zzekVar.zzq() + 6);
            return 0;
        }
        if ((iZzg >> 8) != 1) {
            zzaddVar.zzk(1);
            return 0;
        }
        int i = iZzg & 255;
        SparseArray sparseArray = this.zzb;
        zzanf zzanfVar = (zzanf) sparseArray.get(i);
        if (!this.zze) {
            if (zzanfVar == null) {
                zzamg zzamgVar = null;
                if (i == 189) {
                    zzamiVar = new zzaly(null, 0, "video/mp2p");
                    this.zzf = true;
                    this.zzh = zzaddVar.zzf();
                } else if ((iZzg & 224) == 192) {
                    zzamiVar = new zzams(null, 0, "video/mp2p");
                    this.zzf = true;
                    this.zzh = zzaddVar.zzf();
                } else if ((iZzg & 240) == 224) {
                    zzamiVar = new zzami(null, "video/mp2p");
                    this.zzg = true;
                    this.zzh = zzaddVar.zzf();
                } else if (zzamgVar != null) {
                    zzamgVar.zzb(this.zzj, new zzanu(Integer.MIN_VALUE, i, 256));
                    zzanfVar = new zzanf(zzamgVar, this.zza);
                    sparseArray.put(i, zzanfVar);
                }
                zzamgVar = zzamiVar;
                if (zzamgVar != null) {
                    zzamgVar.zzb(this.zzj, new zzanu(Integer.MIN_VALUE, i, 256));
                    zzanfVar = new zzanf(zzamgVar, this.zza);
                    sparseArray.put(i, zzanfVar);
                }
            }
            boolean z = this.zzf;
            long j = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            if (z && this.zzg) {
                j = this.zzh + PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            if (zzaddVar.zzf() > j) {
                this.zze = true;
                this.zzj.zzG();
            }
        }
        zzaddVar.zzh(zzekVar.zzN(), 0, 2);
        zzekVar.zzL(0);
        int iZzq = zzekVar.zzq() + 6;
        if (zzanfVar == null) {
            zzaddVar.zzk(iZzq);
        } else {
            zzekVar.zzI(iZzq);
            zzaddVar.zzi(zzekVar.zzN(), 0, iZzq);
            zzekVar.zzL(6);
            zzanfVar.zza(zzekVar);
            zzekVar.zzK(zzekVar.zzb());
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final /* synthetic */ zzadc zzc() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final /* synthetic */ List zzd() {
        return zzfww.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final void zze(zzadf zzadfVar) {
        this.zzj = zzadfVar;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0021  */
    @Override // com.google.android.gms.internal.ads.zzadc
    public final void zzf(long j, long j2) {
        zzer zzerVar = this.zza;
        if (zzerVar.zzf() != -9223372036854775807L) {
            long jZzd = zzerVar.zzd();
            if (jZzd != -9223372036854775807L && jZzd != 0 && jZzd != j2) {
                zzerVar.zzi(j2);
            }
        } else {
            zzerVar.zzi(j2);
        }
        zzand zzandVar = this.zzi;
        int i = 0;
        if (zzandVar != null) {
            zzandVar.zzd(j2);
        }
        while (true) {
            SparseArray sparseArray = this.zzb;
            if (i >= sparseArray.size()) {
                return;
            }
            ((zzanf) sparseArray.valueAt(i)).zzb();
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final boolean zzi(zzadd zzaddVar) throws IOException {
        byte[] bArr = new byte[14];
        zzacr zzacrVar = (zzacr) zzaddVar;
        zzacrVar.zzm(bArr, 0, 14, false);
        if ((((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) != 442 || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        zzacrVar.zzl(bArr[13] & 7, false);
        zzacrVar.zzm(bArr, 0, 3, false);
        return ((((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)) | (bArr[2] & 255)) == 1;
    }
}
