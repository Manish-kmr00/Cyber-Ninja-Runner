package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzwl {
    private final zzek zza = new zzek(32);
    private zzwk zzb;
    private zzwk zzc;
    private zzwk zzd;
    private long zze;
    private final zzze zzf;

    public zzwl(zzze zzzeVar) {
        this.zzf = zzzeVar;
        zzwk zzwkVar = new zzwk(0L, 65536);
        this.zzb = zzwkVar;
        this.zzc = zzwkVar;
        this.zzd = zzwkVar;
    }

    private final int zzi(int i) {
        zzwk zzwkVar = this.zzd;
        if (zzwkVar.zzc == null) {
            zzyx zzyxVarZzb = this.zzf.zzb();
            zzwk zzwkVar2 = new zzwk(this.zzd.zzb, 65536);
            zzwkVar.zzc = zzyxVarZzb;
            zzwkVar.zzd = zzwkVar2;
        }
        return Math.min(i, (int) (this.zzd.zzb - this.zze));
    }

    private static zzwk zzj(zzwk zzwkVar, long j) {
        while (j >= zzwkVar.zzb) {
            zzwkVar = zzwkVar.zzd;
        }
        return zzwkVar;
    }

    private static zzwk zzk(zzwk zzwkVar, long j, ByteBuffer byteBuffer, int i) {
        zzwk zzwkVarZzj = zzj(zzwkVar, j);
        while (i > 0) {
            int iMin = Math.min(i, (int) (zzwkVarZzj.zzb - j));
            byteBuffer.put(zzwkVarZzj.zzc.zza, zzwkVarZzj.zza(j), iMin);
            i -= iMin;
            j += (long) iMin;
            if (j == zzwkVarZzj.zzb) {
                zzwkVarZzj = zzwkVarZzj.zzd;
            }
        }
        return zzwkVarZzj;
    }

    private static zzwk zzl(zzwk zzwkVar, long j, byte[] bArr, int i) {
        zzwk zzwkVarZzj = zzj(zzwkVar, j);
        int i2 = i;
        while (i2 > 0) {
            int iMin = Math.min(i2, (int) (zzwkVarZzj.zzb - j));
            System.arraycopy(zzwkVarZzj.zzc.zza, zzwkVarZzj.zza(j), bArr, i - i2, iMin);
            i2 -= iMin;
            j += (long) iMin;
            if (j == zzwkVarZzj.zzb) {
                zzwkVarZzj = zzwkVarZzj.zzd;
            }
        }
        return zzwkVarZzj;
    }

    private static zzwk zzm(zzwk zzwkVar, zzhn zzhnVar, zzwn zzwnVar, zzek zzekVar) {
        zzwk zzwkVarZzl;
        if (zzhnVar.zzl()) {
            long j = zzwnVar.zzb;
            int iZzq = 1;
            zzekVar.zzI(1);
            zzwk zzwkVarZzl2 = zzl(zzwkVar, j, zzekVar.zzN(), 1);
            long j2 = j + 1;
            byte b = zzekVar.zzN()[0];
            int i = b & 128;
            int i2 = b & 127;
            zzhk zzhkVar = zzhnVar.zzb;
            byte[] bArr = zzhkVar.zza;
            if (bArr == null) {
                zzhkVar.zza = new byte[16];
            } else {
                Arrays.fill(bArr, (byte) 0);
            }
            boolean z = i != 0;
            zzwkVarZzl = zzl(zzwkVarZzl2, j2, zzhkVar.zza, i2);
            long j3 = j2 + ((long) i2);
            if (z) {
                zzekVar.zzI(2);
                zzwkVarZzl = zzl(zzwkVarZzl, j3, zzekVar.zzN(), 2);
                j3 += 2;
                iZzq = zzekVar.zzq();
            }
            int i3 = iZzq;
            int[] iArr = zzhkVar.zzd;
            if (iArr == null || iArr.length < i3) {
                iArr = new int[i3];
            }
            int[] iArr2 = iArr;
            int[] iArr3 = zzhkVar.zze;
            if (iArr3 == null || iArr3.length < i3) {
                iArr3 = new int[i3];
            }
            int[] iArr4 = iArr3;
            if (z) {
                int i4 = i3 * 6;
                zzekVar.zzI(i4);
                zzwkVarZzl = zzl(zzwkVarZzl, j3, zzekVar.zzN(), i4);
                j3 += (long) i4;
                zzekVar.zzL(0);
                for (int i5 = 0; i5 < i3; i5++) {
                    iArr2[i5] = zzekVar.zzq();
                    iArr4[i5] = zzekVar.zzp();
                }
            } else {
                iArr2[0] = 0;
                iArr4[0] = zzwnVar.zza - ((int) (j3 - zzwnVar.zzb));
            }
            zzaeh zzaehVar = zzwnVar.zzc;
            int i6 = zzeu.zza;
            zzhkVar.zzc(i3, iArr2, iArr4, zzaehVar.zzb, zzhkVar.zza, zzaehVar.zza, zzaehVar.zzc, zzaehVar.zzd);
            long j4 = zzwnVar.zzb;
            int i7 = (int) (j3 - j4);
            zzwnVar.zzb = j4 + ((long) i7);
            zzwnVar.zza -= i7;
        } else {
            zzwkVarZzl = zzwkVar;
        }
        if (!zzhnVar.zze()) {
            zzhnVar.zzj(zzwnVar.zza);
            return zzk(zzwkVarZzl, zzwnVar.zzb, zzhnVar.zzc, zzwnVar.zza);
        }
        zzekVar.zzI(4);
        zzwk zzwkVarZzl3 = zzl(zzwkVarZzl, zzwnVar.zzb, zzekVar.zzN(), 4);
        int iZzp = zzekVar.zzp();
        zzwnVar.zzb += 4;
        zzwnVar.zza -= 4;
        zzhnVar.zzj(iZzp);
        zzwk zzwkVarZzk = zzk(zzwkVarZzl3, zzwnVar.zzb, zzhnVar.zzc, iZzp);
        zzwnVar.zzb += (long) iZzp;
        int i8 = zzwnVar.zza - iZzp;
        zzwnVar.zza = i8;
        ByteBuffer byteBuffer = zzhnVar.zzf;
        if (byteBuffer == null || byteBuffer.capacity() < i8) {
            zzhnVar.zzf = ByteBuffer.allocate(i8);
        } else {
            zzhnVar.zzf.clear();
        }
        return zzk(zzwkVarZzk, zzwnVar.zzb, zzhnVar.zzf, zzwnVar.zza);
    }

    private final void zzn(int i) {
        long j = this.zze + ((long) i);
        this.zze = j;
        zzwk zzwkVar = this.zzd;
        if (j == zzwkVar.zzb) {
            this.zzd = zzwkVar.zzd;
        }
    }

    public final int zza(zzl zzlVar, int i, boolean z) throws IOException {
        int iZzi = zzi(i);
        zzwk zzwkVar = this.zzd;
        int iZza = zzlVar.zza(zzwkVar.zzc.zza, zzwkVar.zza(this.zze), iZzi);
        if (iZza != -1) {
            zzn(iZza);
            return iZza;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    public final long zzb() {
        return this.zze;
    }

    public final void zzc(long j) {
        zzwk zzwkVar;
        if (j != -1) {
            while (true) {
                zzwkVar = this.zzb;
                if (j < zzwkVar.zzb) {
                    break;
                }
                this.zzf.zzc(zzwkVar.zzc);
                this.zzb = this.zzb.zzb();
            }
            if (this.zzc.zza < zzwkVar.zza) {
                this.zzc = zzwkVar;
            }
        }
    }

    public final void zzd(zzhn zzhnVar, zzwn zzwnVar) {
        zzm(this.zzc, zzhnVar, zzwnVar, this.zza);
    }

    public final void zze(zzhn zzhnVar, zzwn zzwnVar) {
        this.zzc = zzm(this.zzc, zzhnVar, zzwnVar, this.zza);
    }

    public final void zzf() {
        zzwk zzwkVar = this.zzb;
        if (zzwkVar.zzc != null) {
            this.zzf.zzd(zzwkVar);
            zzwkVar.zzb();
        }
        this.zzb.zze(0L, 65536);
        zzwk zzwkVar2 = this.zzb;
        this.zzc = zzwkVar2;
        this.zzd = zzwkVar2;
        this.zze = 0L;
        this.zzf.zzg();
    }

    public final void zzg() {
        this.zzc = this.zzb;
    }

    public final void zzh(zzek zzekVar, int i) {
        while (i > 0) {
            int iZzi = zzi(i);
            zzwk zzwkVar = this.zzd;
            zzekVar.zzH(zzwkVar.zzc.zza, zzwkVar.zza(this.zze), iZzi);
            i -= iZzi;
            zzn(iZzi);
        }
    }
}
