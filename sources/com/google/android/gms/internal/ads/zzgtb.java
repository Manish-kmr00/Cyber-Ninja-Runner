package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgtb extends zzgxv implements zzgzh {
    private static final zzgtb zza;
    private static volatile zzgzo zzb;
    private int zzc;
    private zzgyh zzd = zzbK();

    static {
        zzgtb zzgtbVar = new zzgtb();
        zza = zzgtbVar;
        zzgxv.zzbZ(zzgtb.class, zzgtbVar);
    }

    private zzgtb() {
    }

    public static zzgsx zzc() {
        return (zzgsx) zza.zzaZ();
    }

    public static zzgtb zzg(InputStream inputStream, zzgxf zzgxfVar) throws IOException {
        return (zzgtb) zzgxv.zzbu(zza, inputStream, zzgxfVar);
    }

    static /* synthetic */ void zzi(zzgtb zzgtbVar, zzgsz zzgszVar) {
        zzgszVar.getClass();
        zzgyh zzgyhVar = zzgtbVar.zzd;
        if (!zzgyhVar.zzc()) {
            zzgtbVar.zzd = zzgxv.zzbL(zzgyhVar);
        }
        zzgtbVar.zzd.add(zzgszVar);
    }

    public final int zza() {
        return this.zzd.size();
    }

    public final int zzb() {
        return this.zzc;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zzgsz zzd(int i) {
        return (zzgsz) this.zzd.get(i);
    }

    @Override // com.google.android.gms.internal.ads.zzgxv
    protected final Object zzdc(zzgxu zzgxuVar, Object obj, Object obj2) {
        int iOrdinal = zzgxuVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbQ(zza, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzc", "zzd", zzgsz.class});
        }
        if (iOrdinal == 3) {
            return new zzgtb();
        }
        zzgta zzgtaVar = null;
        if (iOrdinal == 4) {
            return new zzgsx(zzgtaVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzb;
        if (zzgxqVar == null) {
            synchronized (zzgtb.class) {
                zzgxqVar = zzb;
                if (zzgxqVar == null) {
                    zzgxqVar = new zzgxq(zza);
                    zzb = zzgxqVar;
                }
            }
        }
        return zzgxqVar;
    }

    public final List zzh() {
        return this.zzd;
    }
}
