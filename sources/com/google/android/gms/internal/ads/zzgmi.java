package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgmi {
    private static final zzgmi zza = (zzgmi) zzgnw.zza(new zzgnv() { // from class: com.google.android.gms.internal.ads.zzgmg
        @Override // com.google.android.gms.internal.ads.zzgnv
        public final Object zza() throws GeneralSecurityException {
            zzgmi zzgmiVar = new zzgmi();
            zzgmiVar.zzg(new zzglc(zzglm.class, zzgnl.class, new zzgld() { // from class: com.google.android.gms.internal.ads.zzgmh
                @Override // com.google.android.gms.internal.ads.zzgld
                public final zzgnp zza(zzgdh zzgdhVar, zzgdz zzgdzVar) {
                    return ((zzglm) zzgdhVar).zzb(zzgdzVar);
                }
            }));
            return zzgmiVar;
        }
    });
    private final AtomicReference zzb = new AtomicReference(new zzgnu(new zzgnq(), null));

    public static zzgmi zzc() {
        return zza;
    }

    public final zzgdh zza(zzgnp zzgnpVar, @Nullable zzgdz zzgdzVar) throws GeneralSecurityException {
        return ((zzgnu) this.zzb.get()).zza(zzgnpVar, zzgdzVar);
    }

    public final zzgdv zzb(zzgnp zzgnpVar) throws GeneralSecurityException {
        return ((zzgnu) this.zzb.get()).zzb(zzgnpVar);
    }

    public final zzgnp zzd(zzgdh zzgdhVar, Class cls, @Nullable zzgdz zzgdzVar) throws GeneralSecurityException {
        return ((zzgnu) this.zzb.get()).zzc(zzgdhVar, cls, zzgdzVar);
    }

    public final zzgnp zze(zzgdv zzgdvVar, Class cls) throws GeneralSecurityException {
        return ((zzgnu) this.zzb.get()).zzd(zzgdvVar, cls);
    }

    public final synchronized void zzf(zzglb zzglbVar) throws GeneralSecurityException {
        AtomicReference atomicReference = this.zzb;
        zzgnq zzgnqVar = new zzgnq((zzgnu) atomicReference.get());
        zzgnqVar.zza(zzglbVar);
        atomicReference.set(new zzgnu(zzgnqVar, null));
    }

    public final synchronized void zzg(zzglf zzglfVar) throws GeneralSecurityException {
        AtomicReference atomicReference = this.zzb;
        zzgnq zzgnqVar = new zzgnq((zzgnu) atomicReference.get());
        zzgnqVar.zzb(zzglfVar);
        atomicReference.set(new zzgnu(zzgnqVar, null));
    }

    public final synchronized void zzh(zzgmn zzgmnVar) throws GeneralSecurityException {
        AtomicReference atomicReference = this.zzb;
        zzgnq zzgnqVar = new zzgnq((zzgnu) atomicReference.get());
        zzgnqVar.zzc(zzgmnVar);
        atomicReference.set(new zzgnu(zzgnqVar, null));
    }

    public final synchronized void zzi(zzgmr zzgmrVar) throws GeneralSecurityException {
        AtomicReference atomicReference = this.zzb;
        zzgnq zzgnqVar = new zzgnq((zzgnu) atomicReference.get());
        zzgnqVar.zzd(zzgmrVar);
        atomicReference.set(new zzgnu(zzgnqVar, null));
    }

    public final boolean zzj(zzgnp zzgnpVar) {
        return ((zzgnu) this.zzb.get()).zzi(zzgnpVar);
    }

    public final boolean zzk(zzgnp zzgnpVar) {
        return ((zzgnu) this.zzb.get()).zzj(zzgnpVar);
    }
}
