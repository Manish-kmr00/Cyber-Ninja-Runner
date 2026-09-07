package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgnu {
    private final Map zza;
    private final Map zzb;
    private final Map zzc;
    private final Map zzd;

    /* synthetic */ zzgnu(zzgnq zzgnqVar, zzgnt zzgntVar) {
        this.zza = new HashMap(zzgnqVar.zza);
        this.zzb = new HashMap(zzgnqVar.zzb);
        this.zzc = new HashMap(zzgnqVar.zzc);
        this.zzd = new HashMap(zzgnqVar.zzd);
    }

    public final zzgdh zza(zzgnp zzgnpVar, @Nullable zzgdz zzgdzVar) throws GeneralSecurityException {
        zzgnr zzgnrVar = new zzgnr(zzgnpVar.getClass(), zzgnpVar.zzd(), null);
        Map map = this.zzb;
        if (map.containsKey(zzgnrVar)) {
            return ((zzglb) map.get(zzgnrVar)).zza(zzgnpVar, zzgdzVar);
        }
        throw new GeneralSecurityException("No Key Parser for requested key type " + zzgnrVar.toString() + " available");
    }

    public final zzgdv zzb(zzgnp zzgnpVar) throws GeneralSecurityException {
        zzgnr zzgnrVar = new zzgnr(zzgnpVar.getClass(), zzgnpVar.zzd(), null);
        Map map = this.zzd;
        if (map.containsKey(zzgnrVar)) {
            return ((zzgmn) map.get(zzgnrVar)).zza(zzgnpVar);
        }
        throw new GeneralSecurityException("No Parameters Parser for requested key type " + zzgnrVar.toString() + " available");
    }

    public final zzgnp zzc(zzgdh zzgdhVar, Class cls, @Nullable zzgdz zzgdzVar) throws GeneralSecurityException {
        zzgns zzgnsVar = new zzgns(zzgdhVar.getClass(), cls, null);
        Map map = this.zza;
        if (map.containsKey(zzgnsVar)) {
            return ((zzglf) map.get(zzgnsVar)).zza(zzgdhVar, zzgdzVar);
        }
        throw new GeneralSecurityException("No Key serializer for " + zzgnsVar.toString() + " available");
    }

    public final zzgnp zzd(zzgdv zzgdvVar, Class cls) throws GeneralSecurityException {
        zzgns zzgnsVar = new zzgns(zzgdvVar.getClass(), cls, null);
        Map map = this.zzc;
        if (map.containsKey(zzgnsVar)) {
            return ((zzgmr) map.get(zzgnsVar)).zza(zzgdvVar);
        }
        throw new GeneralSecurityException("No Key Format serializer for " + zzgnsVar.toString() + " available");
    }

    public final boolean zzi(zzgnp zzgnpVar) {
        return this.zzb.containsKey(new zzgnr(zzgnpVar.getClass(), zzgnpVar.zzd(), null));
    }

    public final boolean zzj(zzgnp zzgnpVar) {
        return this.zzd.containsKey(new zzgnr(zzgnpVar.getClass(), zzgnpVar.zzd(), null));
    }
}
