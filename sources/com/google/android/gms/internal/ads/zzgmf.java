package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgmf {
    private static final zzgmf zza = new zzgmf();
    private final AtomicReference zzb = new AtomicReference(new zzgne(new zzgnb(null), null));

    zzgmf() {
    }

    public static zzgmf zza() {
        return zza;
    }

    public final Object zzb(zzgdh zzgdhVar, Class cls) throws GeneralSecurityException {
        return ((zzgne) this.zzb.get()).zzc(zzgdhVar, cls);
    }

    public final synchronized void zzc(zzgna zzgnaVar) throws GeneralSecurityException {
        AtomicReference atomicReference = this.zzb;
        zzgnb zzgnbVar = new zzgnb((zzgne) atomicReference.get(), null);
        zzgnbVar.zza(zzgnaVar);
        atomicReference.set(new zzgne(zzgnbVar, null));
    }

    public final synchronized void zzd(zzgnk zzgnkVar) throws GeneralSecurityException {
        AtomicReference atomicReference = this.zzb;
        zzgnb zzgnbVar = new zzgnb((zzgne) atomicReference.get(), null);
        zzgnbVar.zzb(zzgnkVar);
        atomicReference.set(new zzgne(zzgnbVar, null));
    }
}
