package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgdr implements zzglh {
    private final zzgtb zza;
    private final List zzb;
    private final zzglq zzc;

    private zzgdr(zzgtb zzgtbVar, List list) {
        this.zza = zzgtbVar;
        this.zzb = list;
        this.zzc = zzglq.zza;
    }

    /* synthetic */ zzgdr(zzgtb zzgtbVar, List list, zzglq zzglqVar, zzgdq zzgdqVar) {
        this.zza = zzgtbVar;
        this.zzb = list;
        this.zzc = zzglqVar;
    }

    static final zzgdr zzb(zzgtb zzgtbVar) throws GeneralSecurityException {
        zzj(zzgtbVar);
        return new zzgdr(zzgtbVar, zzi(zzgtbVar));
    }

    public static final zzgdr zzc(zzgdv zzgdvVar) throws GeneralSecurityException {
        zzgdo zzgdoVar = new zzgdo();
        zzgdm zzgdmVar = new zzgdm(zzgdvVar, null);
        zzgdmVar.zzd();
        zzgdmVar.zzc();
        zzgdoVar.zza(zzgdmVar);
        return zzgdoVar.zzb();
    }

    private static List zzi(zzgtb zzgtbVar) {
        zzgdj zzgdjVar;
        ArrayList arrayList = new ArrayList(zzgtbVar.zza());
        for (zzgsz zzgszVar : zzgtbVar.zzh()) {
            int iZza = zzgszVar.zza();
            try {
                zzgnl zzgnlVarZza = zzgnl.zza(zzgszVar.zzb().zzg(), zzgszVar.zzb().zzf(), zzgszVar.zzb().zzb(), zzgszVar.zzf(), zzgszVar.zzf() == zzgtt.RAW ? null : Integer.valueOf(zzgszVar.zza()));
                zzgmi zzgmiVarZzc = zzgmi.zzc();
                zzgdz zzgdzVarZza = zzgdz.zza();
                zzgdh zzglmVar = !zzgmiVarZzc.zzj(zzgnlVarZza) ? new zzglm(zzgnlVarZza, zzgdzVarZza) : zzgmiVarZzc.zza(zzgnlVarZza, zzgdzVarZza);
                int iZzk = zzgszVar.zzk() - 2;
                if (iZzk == 1) {
                    zzgdjVar = zzgdj.zza;
                } else if (iZzk == 2) {
                    zzgdjVar = zzgdj.zzb;
                } else {
                    if (iZzk != 3) {
                        throw new GeneralSecurityException("Unknown key status");
                    }
                    zzgdjVar = zzgdj.zzc;
                }
                arrayList.add(new zzgdp(zzglmVar, zzgdjVar, iZza, iZza == zzgtbVar.zzb(), null));
            } catch (GeneralSecurityException unused) {
                arrayList.add(null);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzj(zzgtb zzgtbVar) throws GeneralSecurityException {
        if (zzgtbVar == null || zzgtbVar.zza() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
    }

    public final String toString() {
        int i = zzgec.zza;
        zzgtc zzgtcVarZza = zzgtg.zza();
        zzgtb zzgtbVar = this.zza;
        zzgtcVarZza.zzb(zzgtbVar.zzb());
        for (zzgsz zzgszVar : zzgtbVar.zzh()) {
            zzgtd zzgtdVarZza = zzgte.zza();
            zzgtdVarZza.zzc(zzgszVar.zzb().zzg());
            zzgtdVarZza.zzd(zzgszVar.zzk());
            zzgtdVarZza.zzb(zzgszVar.zzf());
            zzgtdVarZza.zza(zzgszVar.zza());
            zzgtcVarZza.zza((zzgte) zzgtdVarZza.zzbr());
        }
        return ((zzgtg) zzgtcVarZza.zzbr()).toString();
    }

    @Override // com.google.android.gms.internal.ads.zzglh
    public final int zza() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzglh
    public final /* bridge */ /* synthetic */ zzglg zzd(int i) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzglh
    public final /* bridge */ /* synthetic */ zzglg zze() {
        throw null;
    }

    final zzgtb zzf() {
        return this.zza;
    }

    public final Object zzg(zzgdc zzgdcVar, Class cls) throws GeneralSecurityException {
        if (!(zzgdcVar instanceof zzgkw)) {
            throw new GeneralSecurityException("Currently only subclasses of InternalConfiguration are accepted");
        }
        zzgkw zzgkwVar = (zzgkw) zzgdcVar;
        Class clsZza = zzgkwVar.zza(cls);
        zzgtb zzgtbVar = this.zza;
        int i = zzgec.zza;
        int iZzb = zzgtbVar.zzb();
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        boolean z2 = true;
        for (zzgsz zzgszVar : zzgtbVar.zzh()) {
            if (zzgszVar.zzk() == 3) {
                if (!zzgszVar.zzj()) {
                    throw new GeneralSecurityException(String.format("key %d has no key data", Integer.valueOf(zzgszVar.zza())));
                }
                if (zzgszVar.zzf() == zzgtt.UNKNOWN_PREFIX) {
                    throw new GeneralSecurityException(String.format("key %d has unknown prefix", Integer.valueOf(zzgszVar.zza())));
                }
                if (zzgszVar.zzk() == 2) {
                    throw new GeneralSecurityException(String.format("key %d has unknown status", Integer.valueOf(zzgszVar.zza())));
                }
                if (zzgszVar.zza() == iZzb) {
                    if (z) {
                        throw new GeneralSecurityException("keyset contains multiple primary keys");
                    }
                    z = true;
                }
                z2 &= zzgszVar.zzb().zzb() == zzgsn.ASYMMETRIC_PUBLIC;
                i3++;
            }
        }
        if (i3 == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        }
        if (!z && !z2) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
        zzgnf zzgnfVarZzb = zzgnj.zzb(clsZza);
        while (true) {
            List list = this.zzb;
            if (i2 >= list.size()) {
                return zzgkwVar.zzc(zzgnfVarZzb.zzc(), this.zzc, new zzgdl(zzgkwVar, clsZza), cls);
            }
            zzgsz zzgszVarZzd = zzgtbVar.zzd(i2);
            if (zzgszVarZzd.zzk() == 3) {
                zzgdp zzgdpVar = (zzgdp) list.get(i2);
                if (zzgdpVar == null) {
                    throw new GeneralSecurityException("Key parsing of key with index " + i2 + " and type_url " + zzgszVarZzd.zzb().zzg() + " failed, unable to get primitive");
                }
                zzgdh zzgdhVarZzb = zzgdpVar.zzb();
                if (zzgszVarZzd.zza() == zzgtbVar.zzb()) {
                    zzgnfVarZzb.zzb(zzgdhVarZzb, zzgszVarZzd);
                } else {
                    zzgnfVarZzb.zza(zzgdhVarZzb, zzgszVarZzd);
                }
            }
            i2++;
        }
    }
}
