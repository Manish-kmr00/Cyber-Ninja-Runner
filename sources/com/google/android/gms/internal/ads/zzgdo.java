package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgdo {
    private final List zza = new ArrayList();
    private final zzglq zzb = zzglq.zza;
    private boolean zzc = false;

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzd() {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            ((zzgdm) it.next()).zza = false;
        }
    }

    public final zzgdo zza(zzgdm zzgdmVar) {
        if (zzgdmVar.zzf != null) {
            throw new IllegalStateException("Entry has already been added to a KeysetHandle.Builder");
        }
        if (zzgdmVar.zza) {
            zzd();
        }
        zzgdmVar.zzf = this;
        this.zza.add(zzgdmVar);
        return this;
    }

    public final zzgdr zzb() throws GeneralSecurityException {
        int i;
        int i2;
        if (this.zzc) {
            throw new GeneralSecurityException("KeysetHandle.Builder#build must only be called once");
        }
        char c = 1;
        this.zzc = true;
        List<zzgdm> list = this.zza;
        zzgsx zzgsxVarZzc = zzgtb.zzc();
        ArrayList arrayList = new ArrayList(list.size());
        int i3 = 0;
        int i4 = 0;
        while (i4 < list.size() - 1) {
            int i5 = i4 + 1;
            if (((zzgdm) list.get(i4)).zze == zzgdn.zza && ((zzgdm) list.get(i5)).zze != zzgdn.zza) {
                throw new GeneralSecurityException("Entries with 'withRandomId()' may only be followed by other entries with 'withRandomId()'.");
            }
            i4 = i5;
        }
        HashSet hashSet = new HashSet();
        Integer num = null;
        for (zzgdm zzgdmVar : list) {
            zzgdj unused = zzgdmVar.zzb;
            if (zzgdmVar.zze == null) {
                throw new GeneralSecurityException("No ID was set (with withFixedId or withRandomId)");
            }
            if (zzgdmVar.zze == zzgdn.zza) {
                i = i3;
                while (true) {
                    if (i != 0 && !hashSet.contains(Integer.valueOf(i))) {
                        break;
                    }
                    int i6 = zzgnx.zza;
                    i = i3;
                    while (i == 0) {
                        byte[] bArrZzb = zzgno.zzb(4);
                        i = (bArrZzb[3] & 255) | ((bArrZzb[i3] & 255) << 24) | ((bArrZzb[c] & 255) << 16) | ((bArrZzb[2] & 255) << 8);
                    }
                }
            } else {
                zzgdn unused2 = zzgdmVar.zze;
                i = i3;
            }
            Integer numValueOf = Integer.valueOf(i);
            if (hashSet.contains(numValueOf)) {
                throw new GeneralSecurityException("Id " + i + " is used twice in the keyset");
            }
            hashSet.add(numValueOf);
            zzgdm.zza(zzgdmVar);
            zzgdh zzgdhVarZza = zzgly.zzb().zza(zzgdmVar.zzd, c != zzgdmVar.zzd.zza() ? null : numValueOf);
            zzgdp zzgdpVar = new zzgdp(zzgdhVarZza, zzgdmVar.zzb, i, zzgdmVar.zza, null);
            zzgdj zzgdjVar = zzgdmVar.zzb;
            zzgnl zzgnlVar = (zzgnl) zzgmi.zzc().zzd(zzgdhVarZza, zzgnl.class, zzgdz.zza());
            Integer numZzf = zzgnlVar.zzf();
            if (numZzf != null && numZzf.intValue() != i) {
                throw new GeneralSecurityException("Wrong ID set for key with ID requirement");
            }
            zzgdj zzgdjVar2 = zzgdj.zza;
            if (zzgdjVar2.equals(zzgdjVar)) {
                i2 = 3;
            } else if (zzgdj.zzb.equals(zzgdjVar)) {
                i2 = 4;
            } else {
                if (!zzgdj.zzc.equals(zzgdjVar)) {
                    throw new IllegalStateException("Unknown key status");
                }
                i2 = 5;
            }
            zzgsy zzgsyVarZzc = zzgsz.zzc();
            zzgsm zzgsmVarZza = zzgsp.zza();
            zzgsmVarZza.zzb(zzgnlVar.zzg());
            zzgsmVarZza.zzc(zzgnlVar.zze());
            zzgsmVarZza.zza(zzgnlVar.zzb());
            zzgsyVarZzc.zza(zzgsmVarZza);
            zzgsyVarZzc.zzd(i2);
            zzgsyVarZzc.zzb(i);
            zzgsyVarZzc.zzc(zzgnlVar.zzc());
            zzgsxVarZzc.zza((zzgsz) zzgsyVarZzc.zzbr());
            if (zzgdmVar.zza) {
                if (num != null) {
                    throw new GeneralSecurityException("Two primaries were set");
                }
                if (zzgdmVar.zzb != zzgdjVar2) {
                    throw new GeneralSecurityException("Primary key is not enabled");
                }
                num = numValueOf;
            }
            arrayList.add(zzgdpVar);
            c = 1;
            i3 = 0;
        }
        if (num == null) {
            throw new GeneralSecurityException("No primary was set");
        }
        zzgsxVarZzc.zzb(num.intValue());
        zzgtb zzgtbVar = (zzgtb) zzgsxVarZzc.zzbr();
        zzgdr.zzj(zzgtbVar);
        return new zzgdr(zzgtbVar, arrayList, this.zzb, null);
    }
}
