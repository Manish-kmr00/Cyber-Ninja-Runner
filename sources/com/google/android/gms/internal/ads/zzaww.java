package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzaww extends zzaxo {
    private static volatile Long zzh;
    private static final Object zzi = new Object();

    public zzaww(zzawb zzawbVar, String str, String str2, zzarz zzarzVar, int i, int i2) {
        super(zzawbVar, "H4NeENBKOLO5GsuUIu0GvJZls7gDyB61uJDl+ZI/plLYxQkTY7P5qtOjaPRY3afS", "ZSxlKJLhR/xxP0dGh2CPRvOgPQo1U18GKPodZAq8glc=", zzarzVar, i, 22);
    }

    @Override // com.google.android.gms.internal.ads.zzaxo
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        if (zzh == null) {
            synchronized (zzi) {
                if (zzh == null) {
                    zzh = (Long) this.zze.invoke(null, new Object[0]);
                }
            }
        }
        zzarz zzarzVar = this.zzd;
        synchronized (zzarzVar) {
            zzarzVar.zzw(zzh.longValue());
        }
    }
}
