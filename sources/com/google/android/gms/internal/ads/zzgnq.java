package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgnq {
    private final Map zza;
    private final Map zzb;
    private final Map zzc;
    private final Map zzd;

    public zzgnq() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
        this.zzc = new HashMap();
        this.zzd = new HashMap();
    }

    public final zzgnq zza(zzglb zzglbVar) throws GeneralSecurityException {
        zzgnr zzgnrVar = new zzgnr(zzglbVar.zzd(), zzglbVar.zzc(), null);
        Map map = this.zzb;
        if (map.containsKey(zzgnrVar)) {
            zzglb zzglbVar2 = (zzglb) map.get(zzgnrVar);
            if (!zzglbVar2.equals(zzglbVar) || !zzglbVar.equals(zzglbVar2)) {
                throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: ".concat(zzgnrVar.toString()));
            }
        } else {
            map.put(zzgnrVar, zzglbVar);
        }
        return this;
    }

    public final zzgnq zzb(zzglf zzglfVar) throws GeneralSecurityException {
        zzgns zzgnsVar = new zzgns(zzglfVar.zzc(), zzglfVar.zzd(), null);
        Map map = this.zza;
        if (map.containsKey(zzgnsVar)) {
            zzglf zzglfVar2 = (zzglf) map.get(zzgnsVar);
            if (!zzglfVar2.equals(zzglfVar) || !zzglfVar.equals(zzglfVar2)) {
                throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: ".concat(zzgnsVar.toString()));
            }
        } else {
            map.put(zzgnsVar, zzglfVar);
        }
        return this;
    }

    public final zzgnq zzc(zzgmn zzgmnVar) throws GeneralSecurityException {
        zzgnr zzgnrVar = new zzgnr(zzgmnVar.zzd(), zzgmnVar.zzc(), null);
        Map map = this.zzd;
        if (map.containsKey(zzgnrVar)) {
            zzgmn zzgmnVar2 = (zzgmn) map.get(zzgnrVar);
            if (!zzgmnVar2.equals(zzgmnVar) || !zzgmnVar.equals(zzgmnVar2)) {
                throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: ".concat(zzgnrVar.toString()));
            }
        } else {
            map.put(zzgnrVar, zzgmnVar);
        }
        return this;
    }

    public final zzgnq zzd(zzgmr zzgmrVar) throws GeneralSecurityException {
        zzgns zzgnsVar = new zzgns(zzgmrVar.zzc(), zzgmrVar.zzd(), null);
        Map map = this.zzc;
        if (map.containsKey(zzgnsVar)) {
            zzgmr zzgmrVar2 = (zzgmr) map.get(zzgnsVar);
            if (!zzgmrVar2.equals(zzgmrVar) || !zzgmrVar.equals(zzgmrVar2)) {
                throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: ".concat(zzgnsVar.toString()));
            }
        } else {
            map.put(zzgnsVar, zzgmrVar);
        }
        return this;
    }

    public zzgnq(zzgnu zzgnuVar) {
        this.zza = new HashMap(zzgnuVar.zza);
        this.zzb = new HashMap(zzgnuVar.zzb);
        this.zzc = new HashMap(zzgnuVar.zzc);
        this.zzd = new HashMap(zzgnuVar.zzd);
    }
}
