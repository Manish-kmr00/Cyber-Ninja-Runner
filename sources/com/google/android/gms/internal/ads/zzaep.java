package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaep implements zzadc {
    private static final int[] zza = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
    private static final int[] zzb = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
    private static final byte[] zzc;
    private static final byte[] zzd;
    private final byte[] zze;
    private final zzaei zzf;
    private boolean zzg;
    private long zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private long zzm;
    private zzadf zzn;
    private zzaei zzo;
    private zzaei zzp;
    private zzaeb zzq;
    private long zzr;
    private boolean zzs;

    static {
        int i = zzeu.zza;
        zzc = "#!AMR\n".getBytes(StandardCharsets.UTF_8);
        zzd = "#!AMR-WB\n".getBytes(StandardCharsets.UTF_8);
    }

    public zzaep() {
        throw null;
    }

    public zzaep(int i) {
        this.zze = new byte[1];
        this.zzk = -1;
        zzacx zzacxVar = new zzacx();
        this.zzf = zzacxVar;
        this.zzp = zzacxVar;
    }

    private static boolean zzg(zzadd zzaddVar, byte[] bArr) throws IOException {
        zzaddVar.zzj();
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        zzaddVar.zzh(bArr2, 0, length);
        return Arrays.equals(bArr2, bArr);
    }

    private final boolean zzh(zzadd zzaddVar) throws IOException {
        byte[] bArr = zzc;
        if (zzg(zzaddVar, bArr)) {
            this.zzg = false;
            zzaddVar.zzk(bArr.length);
            return true;
        }
        byte[] bArr2 = zzd;
        if (!zzg(zzaddVar, bArr2)) {
            return false;
        }
        this.zzg = true;
        zzaddVar.zzk(bArr2.length);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final int zzb(zzadd zzaddVar, zzady zzadyVar) throws IOException {
        zzdc.zzb(this.zzo);
        int i = zzeu.zza;
        if (zzaddVar.zzf() == 0 && !zzh(zzaddVar)) {
            throw zzaz.zza("Could not find AMR header.", null);
        }
        if (!this.zzs) {
            this.zzs = true;
            boolean z = this.zzg;
            String str = true != z ? "audio/amr" : "audio/amr-wb";
            String str2 = true != z ? "audio/3gpp" : "audio/amr-wb";
            int i2 = true != z ? 8000 : 16000;
            int i3 = z ? zzb[8] : zza[7];
            zzaei zzaeiVar = this.zzo;
            zzx zzxVar = new zzx();
            zzxVar.zzE(str);
            zzxVar.zzad(str2);
            zzxVar.zzT(i3);
            zzxVar.zzB(1);
            zzxVar.zzae(i2);
            zzaeiVar.zzm(zzxVar.zzaj());
        }
        int iZza = zza(zzaddVar);
        if (this.zzq == null) {
            zzaea zzaeaVar = new zzaea(-9223372036854775807L, 0L);
            this.zzq = zzaeaVar;
            this.zzn.zzP(zzaeaVar);
        }
        return iZza == -1 ? -1 : 0;
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
        this.zzn = zzadfVar;
        zzaei zzaeiVarZzw = zzadfVar.zzw(0, 1);
        this.zzo = zzaeiVarZzw;
        this.zzp = zzaeiVarZzw;
        zzadfVar.zzG();
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final void zzf(long j, long j2) {
        this.zzh = 0L;
        this.zzi = 0;
        this.zzj = 0;
        this.zzr = j2;
        this.zzm = 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final boolean zzi(zzadd zzaddVar) throws IOException {
        return zzh(zzaddVar);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002c  */
    /* JADX WARN: Code duplicated, block: B:15:0x002e  */
    /* JADX WARN: Code duplicated, block: B:39:0x0080  */
    @RequiresNonNull({"realTrackOutput"})
    private final int zza(zzadd zzaddVar) throws IOException {
        int i = this.zzj;
        if (i == 0) {
            try {
                zzaddVar.zzj();
                byte[] bArr = this.zze;
                zzaddVar.zzh(bArr, 0, 1);
                byte b = bArr[0];
                if ((b & 131) > 0) {
                    throw zzaz.zza("Invalid padding bits for frame header " + ((int) b), null);
                }
                int i2 = b >> 3;
                boolean z = this.zzg;
                int i3 = i2 & 15;
                if (!z) {
                    if (!z) {
                        if (i3 >= 12 && i3 <= 14) {
                        }
                    }
                    throw zzaz.zza("Illegal AMR " + (true != z ? "NB" : "WB") + " frame type " + i3, null);
                }
                if (i3 >= 10 && i3 <= 13) {
                    if (!z) {
                        if (i3 >= 12) {
                        }
                    }
                    if (true != z) {
                    }
                    throw zzaz.zza("Illegal AMR " + (true != z ? "NB" : "WB") + " frame type " + i3, null);
                }
                i = z ? zzb[i3] : zza[i3];
                this.zzi = i;
                this.zzj = i;
                int i4 = this.zzk;
                if (i4 == -1) {
                    this.zzk = i;
                    i4 = i;
                }
                if (i4 == i) {
                    this.zzl++;
                }
            } catch (EOFException unused) {
                return -1;
            }
        }
        int iZzf = this.zzp.zzf(zzaddVar, i, true);
        if (iZzf == -1) {
            return -1;
        }
        int i5 = this.zzj - iZzf;
        this.zzj = i5;
        if (i5 > 0) {
            return 0;
        }
        this.zzp.zzt(this.zzh, 1, this.zzi, 0, null);
        this.zzh += 20000;
        return 0;
    }
}
