package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzaxg extends zzaxo {
    private final StackTraceElement[] zzh;

    public zzaxg(zzawb zzawbVar, String str, String str2, zzarz zzarzVar, int i, int i2, StackTraceElement[] stackTraceElementArr) {
        super(zzawbVar, "9wvnViXgITvEao5ly+BRRyQrzFTt3bYFFawK/4VAi8rGNT0AvgE+boySJAbIF/vH", "ZZ4V/Y3/WcXV1iobSsNLXr6TJ7vZy9r1U0ttG6Pb6Z4=", zzarzVar, i, 45);
        this.zzh = stackTraceElementArr;
    }

    @Override // com.google.android.gms.internal.ads.zzaxo
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        StackTraceElement[] stackTraceElementArr = this.zzh;
        if (stackTraceElementArr != null) {
            zzavs zzavsVar = new zzavs((String) this.zze.invoke(null, stackTraceElementArr));
            zzarz zzarzVar = this.zzd;
            synchronized (zzarzVar) {
                zzarzVar.zzD(zzavsVar.zza.longValue());
                if (zzavsVar.zzb.booleanValue()) {
                    zzarzVar.zzZ(true != zzavsVar.zzc.booleanValue() ? 2 : 1);
                } else {
                    zzarzVar.zzZ(3);
                }
            }
        }
    }
}
