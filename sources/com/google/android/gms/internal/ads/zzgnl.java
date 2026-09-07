package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgnl implements zzgnp {
    private final String zza;
    private final zzgvs zzb;
    private final zzgwn zzc;
    private final zzgsn zzd;
    private final zzgtt zze;

    @Nullable
    private final Integer zzf;

    private zzgnl(String str, zzgvs zzgvsVar, zzgwn zzgwnVar, zzgsn zzgsnVar, zzgtt zzgttVar, @Nullable Integer num) {
        this.zza = str;
        this.zzb = zzgvsVar;
        this.zzc = zzgwnVar;
        this.zzd = zzgsnVar;
        this.zze = zzgttVar;
        this.zzf = num;
    }

    public static zzgnl zza(String str, zzgwn zzgwnVar, zzgsn zzgsnVar, zzgtt zzgttVar, @Nullable Integer num) throws GeneralSecurityException {
        if (zzgttVar == zzgtt.RAW) {
            if (num != null) {
                throw new GeneralSecurityException("Keys with output prefix type raw should not have an id requirement.");
            }
        } else if (num == null) {
            throw new GeneralSecurityException("Keys with output prefix type different from raw should have an id requirement.");
        }
        return new zzgnl(str, zzgnx.zza(str), zzgwnVar, zzgsnVar, zzgttVar, num);
    }

    public final zzgsn zzb() {
        return this.zzd;
    }

    public final zzgtt zzc() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzgnp
    public final zzgvs zzd() {
        return this.zzb;
    }

    public final zzgwn zze() {
        return this.zzc;
    }

    @Nullable
    public final Integer zzf() {
        return this.zzf;
    }

    public final String zzg() {
        return this.zza;
    }
}
