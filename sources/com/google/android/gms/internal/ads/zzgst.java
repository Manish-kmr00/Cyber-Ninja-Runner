package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgst extends zzgxv implements zzgzh {
    private static final zzgst zza;
    private static volatile zzgzo zzb;
    private String zzc = "";
    private zzgwn zzd = zzgwn.zzb;
    private int zze;

    static {
        zzgst zzgstVar = new zzgst();
        zza = zzgstVar;
        zzgxv.zzbZ(zzgst.class, zzgstVar);
    }

    private zzgst() {
    }

    public static zzgsr zza() {
        return (zzgsr) zza.zzaZ();
    }

    public static zzgsr zzb(zzgst zzgstVar) {
        return (zzgsr) zza.zzba(zzgstVar);
    }

    public static zzgst zzd() {
        return zza;
    }

    public static zzgst zzf(byte[] bArr, zzgxf zzgxfVar) throws zzgyk {
        return (zzgst) zzgxv.zzbx(zza, bArr, zzgxfVar);
    }

    static /* synthetic */ void zzk(zzgst zzgstVar, String str) {
        str.getClass();
        zzgstVar.zzc = str;
    }

    static /* synthetic */ void zzl(zzgst zzgstVar, zzgwn zzgwnVar) {
        zzgwnVar.getClass();
        zzgstVar.zzd = zzgwnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgxv
    protected final Object zzdc(zzgxu zzgxuVar, Object obj, Object obj2) {
        int iOrdinal = zzgxuVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbQ(zza, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzc", "zzd", "zze"});
        }
        if (iOrdinal == 3) {
            return new zzgst();
        }
        zzgss zzgssVar = null;
        if (iOrdinal == 4) {
            return new zzgsr(zzgssVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzb;
        if (zzgxqVar == null) {
            synchronized (zzgst.class) {
                zzgxqVar = zzb;
                if (zzgxqVar == null) {
                    zzgxqVar = new zzgxq(zza);
                    zzb = zzgxqVar;
                }
            }
        }
        return zzgxqVar;
    }

    public final zzgtt zzg() {
        zzgtt zzgttVarZzb = zzgtt.zzb(this.zze);
        return zzgttVarZzb == null ? zzgtt.UNRECOGNIZED : zzgttVarZzb;
    }

    public final zzgwn zzh() {
        return this.zzd;
    }

    public final String zzi() {
        return this.zzc;
    }
}
