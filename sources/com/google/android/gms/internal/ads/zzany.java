package com.google.android.gms.internal.ads;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.vungle.ads.internal.protos.Sdk;
import java.math.RoundingMode;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzany implements zzanz {
    private static final int[] zza = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};
    private static final int[] zzb = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE, 130, 143, 157, 173, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 209, 230, 253, 279, 307, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};
    private final zzadf zzc;
    private final zzaei zzd;
    private final zzaoc zze;
    private final int zzf;
    private final byte[] zzg;
    private final zzek zzh;
    private final int zzi;
    private final zzz zzj;
    private int zzk;
    private long zzl;
    private int zzm;
    private long zzn;

    public zzany(zzadf zzadfVar, zzaei zzaeiVar, zzaoc zzaocVar) throws zzaz {
        this.zzc = zzadfVar;
        this.zzd = zzaeiVar;
        this.zze = zzaocVar;
        int iMax = Math.max(1, zzaocVar.zzc / 10);
        this.zzi = iMax;
        zzek zzekVar = new zzek(zzaocVar.zzf);
        zzekVar.zzk();
        int iZzk = zzekVar.zzk();
        this.zzf = iZzk;
        int i = zzaocVar.zzb;
        int i2 = (((zzaocVar.zzd - (i * 4)) * 8) / (zzaocVar.zze * i)) + 1;
        if (iZzk != i2) {
            throw zzaz.zza("Expected frames per block: " + i2 + "; got: " + iZzk, null);
        }
        int i3 = zzeu.zza;
        int i4 = ((iMax + iZzk) - 1) / iZzk;
        this.zzg = new byte[zzaocVar.zzd * i4];
        this.zzh = new zzek(i4 * (iZzk + iZzk) * i);
        int i5 = ((zzaocVar.zzc * zzaocVar.zzd) * 8) / iZzk;
        zzx zzxVar = new zzx();
        zzxVar.zzad("audio/raw");
        zzxVar.zzA(i5);
        zzxVar.zzY(i5);
        zzxVar.zzT((iMax + iMax) * i);
        zzxVar.zzB(zzaocVar.zzb);
        zzxVar.zzae(zzaocVar.zzc);
        zzxVar.zzX(2);
        this.zzj = zzxVar.zzaj();
    }

    private final int zzd(int i) {
        int i2 = this.zze.zzb;
        return i / (i2 + i2);
    }

    private final int zze(int i) {
        return (i + i) * this.zze.zzb;
    }

    private final void zzf(int i) {
        long jZzu = this.zzl + zzeu.zzu(this.zzn, 1000000L, this.zze.zzc, RoundingMode.DOWN);
        int iZze = zze(i);
        this.zzd.zzt(jZzu, 1, iZze, this.zzm - iZze, null);
        this.zzn += (long) i;
        this.zzm -= iZze;
    }

    @Override // com.google.android.gms.internal.ads.zzanz
    public final void zza(int i, long j) {
        zzaof zzaofVar = new zzaof(this.zze, this.zzf, i, j);
        this.zzc.zzP(zzaofVar);
        zzaei zzaeiVar = this.zzd;
        zzaeiVar.zzm(this.zzj);
        zzaeiVar.zzl(zzaofVar.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzanz
    public final void zzb(long j) {
        this.zzk = 0;
        this.zzl = j;
        this.zzm = 0;
        this.zzn = 0L;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x003f A[LOOP:0: B:6:0x0024->B:12:0x003f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:42:0x0045 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x0021 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0026  */
    /* JADX WARN: Code duplicated, block: B:9:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x003c -> B:4:0x0021). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // com.google.android.gms.internal.ads.zzanz
    public final boolean zzc(com.google.android.gms.internal.ads.zzadd r26, long r27) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 349
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzany.zzc(com.google.android.gms.internal.ads.zzadd, long):boolean");
    }
}
