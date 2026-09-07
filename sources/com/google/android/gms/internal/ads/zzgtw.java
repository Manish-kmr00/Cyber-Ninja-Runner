package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
@Deprecated
public final class zzgtw extends zzgxv implements zzgzh {
    public static final /* synthetic */ int zza = 0;
    private static final zzgtw zzb;
    private static volatile zzgzo zzc;
    private String zzd = "";
    private zzgyh zze = zzbK();

    static {
        zzgtw zzgtwVar = new zzgtw();
        zzb = zzgtwVar;
        zzgxv.zzbZ(zzgtw.class, zzgtwVar);
    }

    private zzgtw() {
    }

    @Override // com.google.android.gms.internal.ads.zzgxv
    protected final Object zzdc(zzgxu zzgxuVar, Object obj, Object obj2) {
        int iOrdinal = zzgxuVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbQ(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zzd", "zze", zzgsw.class});
        }
        if (iOrdinal == 3) {
            return new zzgtw();
        }
        zzgtv zzgtvVar = null;
        if (iOrdinal == 4) {
            return new zzgtu(zzgtvVar);
        }
        if (iOrdinal == 5) {
            return zzb;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzc;
        if (zzgxqVar == null) {
            synchronized (zzgtw.class) {
                zzgxqVar = zzc;
                if (zzgxqVar == null) {
                    zzgxqVar = new zzgxq(zzb);
                    zzc = zzgxqVar;
                }
            }
        }
        return zzgxqVar;
    }
}
