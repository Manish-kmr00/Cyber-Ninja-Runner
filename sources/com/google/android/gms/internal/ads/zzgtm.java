package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgtm extends zzgxv implements zzgzh {
    private static final zzgtm zza;
    private static volatile zzgzo zzb;
    private String zzc = "";

    static {
        zzgtm zzgtmVar = new zzgtm();
        zza = zzgtmVar;
        zzgxv.zzbZ(zzgtm.class, zzgtmVar);
    }

    private zzgtm() {
    }

    public static zzgtk zza() {
        return (zzgtk) zza.zzaZ();
    }

    public static zzgtm zzc() {
        return zza;
    }

    public static zzgtm zzd(zzgwn zzgwnVar, zzgxf zzgxfVar) throws zzgyk {
        return (zzgtm) zzgxv.zzbr(zza, zzgwnVar, zzgxfVar);
    }

    static /* synthetic */ void zzg(zzgtm zzgtmVar, String str) {
        str.getClass();
        zzgtmVar.zzc = str;
    }

    @Override // com.google.android.gms.internal.ads.zzgxv
    protected final Object zzdc(zzgxu zzgxuVar, Object obj, Object obj2) {
        int iOrdinal = zzgxuVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbQ(zza, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zzc"});
        }
        if (iOrdinal == 3) {
            return new zzgtm();
        }
        zzgtl zzgtlVar = null;
        if (iOrdinal == 4) {
            return new zzgtk(zzgtlVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzb;
        if (zzgxqVar == null) {
            synchronized (zzgtm.class) {
                zzgxqVar = zzb;
                if (zzgxqVar == null) {
                    zzgxqVar = new zzgxq(zza);
                    zzb = zzgxqVar;
                }
            }
        }
        return zzgxqVar;
    }

    public final String zzf() {
        return this.zzc;
    }
}
