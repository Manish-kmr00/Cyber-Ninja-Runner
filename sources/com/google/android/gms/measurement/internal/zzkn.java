package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzoj;
import com.google.android.gms.internal.measurement.zzph;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
/* JADX INFO: loaded from: classes14.dex */
final class zzkn extends zzmx {
    private static String zza(String str, String str2) {
        throw new SecurityException("This implementation should not be used.");
    }

    @Override // com.google.android.gms.measurement.internal.zzmx
    protected final boolean zzc() {
        return false;
    }

    public zzkn(zznc zzncVar) {
        super(zzncVar);
    }

    public final byte[] zza(zzbd zzbdVar, String str) {
        zznq next;
        long j;
        zzaz zzazVarZza;
        zzt();
        this.zzu.zzy();
        Preconditions.checkNotNull(zzbdVar);
        Preconditions.checkNotEmpty(str);
        if (!zze().zze(str, zzbf.zzbg)) {
            zzj().zzc().zza("Generating ScionPayload disabled. packageName", str);
            return new byte[0];
        }
        if (!"_iap".equals(zzbdVar.zza) && !"_iapx".equals(zzbdVar.zza)) {
            zzj().zzc().zza("Generating a payload for this event is not available. package_name, event_name", str, zzbdVar.zza);
            return null;
        }
        com.google.android.gms.internal.measurement.zzfn.zzj.zzb zzbVarZzb = com.google.android.gms.internal.measurement.zzfn.zzj.zzb();
        zzh().zzp();
        try {
            zzg zzgVarZze = zzh().zze(str);
            if (zzgVarZze == null) {
                zzj().zzc().zza("Log and bundle not available. package_name", str);
                byte[] bArr = new byte[0];
                zzh().zzu();
                return bArr;
            }
            if (!zzgVarZze.zzar()) {
                zzj().zzc().zza("Log and bundle disabled. package_name", str);
                byte[] bArr2 = new byte[0];
                zzh().zzu();
                return bArr2;
            }
            com.google.android.gms.internal.measurement.zzfn.zzk.zza zzaVarZzp = com.google.android.gms.internal.measurement.zzfn.zzk.zzw().zzh(1).zzp("android");
            if (!TextUtils.isEmpty(zzgVarZze.zzac())) {
                zzaVarZzp.zzb(zzgVarZze.zzac());
            }
            if (!TextUtils.isEmpty(zzgVarZze.zzae())) {
                zzaVarZzp.zzd((String) Preconditions.checkNotNull(zzgVarZze.zzae()));
            }
            if (!TextUtils.isEmpty(zzgVarZze.zzaf())) {
                zzaVarZzp.zze((String) Preconditions.checkNotNull(zzgVarZze.zzaf()));
            }
            if (zzgVarZze.zze() != -2147483648L) {
                zzaVarZzp.zze((int) zzgVarZze.zze());
            }
            zzaVarZzp.zzf(zzgVarZze.zzq()).zzd(zzgVarZze.zzo());
            String strZzah = zzgVarZze.zzah();
            String strZzaa = zzgVarZze.zzaa();
            if (!TextUtils.isEmpty(strZzah)) {
                zzaVarZzp.zzm(strZzah);
            } else if (!TextUtils.isEmpty(strZzaa)) {
                zzaVarZzp.zza(strZzaa);
            }
            zzaVarZzp.zzj(zzgVarZze.zzw());
            zzin zzinVarZzb = this.zzf.zzb(str);
            zzaVarZzp.zzc(zzgVarZze.zzn());
            if (this.zzu.zzac() && zze().zzj(zzaVarZzp.zzt()) && zzinVarZzb.zzi() && !TextUtils.isEmpty(null)) {
                zzaVarZzp.zzj((String) null);
            }
            zzaVarZzp.zzg(zzinVarZzb.zzg());
            if (zzinVarZzb.zzi() && zzgVarZze.zzaq()) {
                Pair<String, Boolean> pairZza = zzn().zza(zzgVarZze.zzac(), zzinVarZzb);
                if (zzgVarZze.zzaq() && pairZza != null && !TextUtils.isEmpty((CharSequence) pairZza.first)) {
                    try {
                        zzaVarZzp.zzq(zza((String) pairZza.first, Long.toString(zzbdVar.zzd)));
                        if (pairZza.second != null) {
                            zzaVarZzp.zzc(((Boolean) pairZza.second).booleanValue());
                        }
                    } catch (SecurityException e) {
                        zzj().zzc().zza("Resettable device id encryption failed", e.getMessage());
                        byte[] bArr3 = new byte[0];
                        zzh().zzu();
                        return bArr3;
                    }
                }
            }
            zzf().zzac();
            com.google.android.gms.internal.measurement.zzfn.zzk.zza zzaVarZzi = zzaVarZzp.zzi(Build.MODEL);
            zzf().zzac();
            zzaVarZzi.zzo(Build.VERSION.RELEASE).zzj((int) zzf().zzg()).zzs(zzf().zzh());
            try {
                if (zzinVarZzb.zzj() && zzgVarZze.zzad() != null) {
                    zzaVarZzp.zzc(zza((String) Preconditions.checkNotNull(zzgVarZze.zzad()), Long.toString(zzbdVar.zzd)));
                }
                if (!TextUtils.isEmpty(zzgVarZze.zzag())) {
                    zzaVarZzp.zzl((String) Preconditions.checkNotNull(zzgVarZze.zzag()));
                }
                String strZzac = zzgVarZze.zzac();
                List<zznq> listZzk = zzh().zzk(strZzac);
                Iterator<zznq> it = listZzk.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!"_lte".equals(next.zzc));
                if (next == null || next.zze == null) {
                    zznq zznqVar = new zznq(strZzac, "auto", "_lte", zzb().currentTimeMillis(), 0L);
                    listZzk.add(zznqVar);
                    zzh().zza(zznqVar);
                }
                com.google.android.gms.internal.measurement.zzfn.zzo[] zzoVarArr = new com.google.android.gms.internal.measurement.zzfn.zzo[listZzk.size()];
                for (int i = 0; i < listZzk.size(); i++) {
                    com.google.android.gms.internal.measurement.zzfn.zzo.zza zzaVarZzb = com.google.android.gms.internal.measurement.zzfn.zzo.zze().zza(listZzk.get(i).zzc).zzb(listZzk.get(i).zzd);
                    g_().zza(zzaVarZzb, listZzk.get(i).zze);
                    zzoVarArr[i] = (com.google.android.gms.internal.measurement.zzfn.zzo) ((com.google.android.gms.internal.measurement.zzjk) zzaVarZzb.zzai());
                }
                zzaVarZzp.zze(Arrays.asList(zzoVarArr));
                g_().zza(zzaVarZzp);
                this.zzf.zza(zzgVarZze, zzaVarZzp);
                if (zzoj.zza() && zze().zza(zzbf.zzcm)) {
                    this.zzf.zzb(zzgVarZze, zzaVarZzp);
                }
                zzga zzgaVarZza = zzga.zza(zzbdVar);
                zzq().zza(zzgaVarZza.zzb, zzh().zzd(str));
                zzq().zza(zzgaVarZza, zze().zzb(str));
                Bundle bundle = zzgaVarZza.zzb;
                bundle.putLong("_c", 1L);
                zzj().zzc().zza("Marking in-app purchase as real-time");
                bundle.putLong("_r", 1L);
                bundle.putString("_o", zzbdVar.zzc);
                if (zzq().zzd(zzaVarZzp.zzt(), zzgVarZze.zzam())) {
                    zzq().zza(bundle, "_dbg", (Object) 1L);
                    zzq().zza(bundle, "_r", (Object) 1L);
                }
                zzaz zzazVarZzd = zzh().zzd(str, zzbdVar.zza);
                if (zzazVarZzd == null) {
                    zzazVarZza = new zzaz(str, zzbdVar.zza, 0L, 0L, zzbdVar.zzd, 0L, null, null, null, null);
                    j = 0;
                } else {
                    j = zzazVarZzd.zzf;
                    zzazVarZza = zzazVarZzd.zza(zzbdVar.zzd);
                }
                zzh().zza(zzazVarZza);
                zzba zzbaVar = new zzba(this.zzu, zzbdVar.zzc, str, zzbdVar.zza, zzbdVar.zzd, j, bundle);
                com.google.android.gms.internal.measurement.zzfn.zzf.zza zzaVarZza = com.google.android.gms.internal.measurement.zzfn.zzf.zze().zzb(zzbaVar.zzc).zza(zzbaVar.zzb).zza(zzbaVar.zzd);
                for (String str2 : zzbaVar.zze) {
                    com.google.android.gms.internal.measurement.zzfn.zzh.zza zzaVarZza2 = com.google.android.gms.internal.measurement.zzfn.zzh.zze().zza(str2);
                    Object objZzc = zzbaVar.zze.zzc(str2);
                    if (objZzc != null) {
                        g_().zza(zzaVarZza2, objZzc);
                        zzaVarZza.zza(zzaVarZza2);
                    }
                }
                zzaVarZzp.zza(zzaVarZza).zza(com.google.android.gms.internal.measurement.zzfn.zzl.zza().zza(com.google.android.gms.internal.measurement.zzfn.zzg.zza().zza(zzazVarZza.zzc).zza(zzbdVar.zza)));
                zzaVarZzp.zza(zzg().zza(zzgVarZze.zzac(), Collections.emptyList(), zzaVarZzp.zzab(), Long.valueOf(zzaVarZza.zzc()), Long.valueOf(zzaVarZza.zzc())));
                if (zzaVarZza.zzg()) {
                    zzaVarZzp.zzi(zzaVarZza.zzc()).zze(zzaVarZza.zzc());
                }
                long jZzs = zzgVarZze.zzs();
                if (jZzs != 0) {
                    zzaVarZzp.zzg(jZzs);
                }
                long jZzu = zzgVarZze.zzu();
                if (jZzu != 0) {
                    zzaVarZzp.zzh(jZzu);
                } else if (jZzs != 0) {
                    zzaVarZzp.zzh(jZzs);
                }
                String strZzal = zzgVarZze.zzal();
                if (zzph.zza() && zze().zze(str, zzbf.zzbr) && strZzal != null) {
                    zzaVarZzp.zzr(strZzal);
                }
                zzgVarZze.zzap();
                zzaVarZzp.zzf((int) zzgVarZze.zzt()).zzl(97001L).zzk(zzb().currentTimeMillis()).zzd(Boolean.TRUE.booleanValue());
                this.zzf.zza(zzaVarZzp.zzt(), zzaVarZzp);
                zzbVarZzb.zza(zzaVarZzp);
                zzgVarZze.zzr(zzaVarZzp.zzf());
                zzgVarZze.zzp(zzaVarZzp.zze());
                zzh().zza(zzgVarZze, false, false);
                zzh().zzw();
                zzh().zzu();
                try {
                    return g_().zzb(((com.google.android.gms.internal.measurement.zzfn.zzj) ((com.google.android.gms.internal.measurement.zzjk) zzbVarZzb.zzai())).zzbz());
                } catch (IOException e2) {
                    zzj().zzg().zza("Data loss. Failed to bundle and serialize. appId", zzfw.zza(str), e2);
                    return 0;
                }
            } catch (SecurityException e3) {
                zzj().zzc().zza("app instance id encryption failed", e3.getMessage());
                byte[] bArr4 = new byte[0];
                zzh().zzu();
                return bArr4;
            }
        } catch (Throwable th) {
            zzh().zzu();
            throw th;
        }
    }
}
