package com.google.android.gms.internal.ads;

import com.unity3d.services.core.di.ServiceProvider;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzie implements zzkr {
    private final zzze zza;
    private final long zzb;
    private final long zzc;
    private final long zzd;
    private final long zze;
    private final long zzf;
    private final HashMap zzg;
    private long zzh;

    public zzie() {
        zzze zzzeVar = new zzze(true, 65536);
        zzl(1000, 0, "bufferForPlaybackMs", "0");
        zzl(2000, 0, "bufferForPlaybackAfterRebufferMs", "0");
        zzl(50000, 1000, "minBufferMs", "bufferForPlaybackMs");
        zzl(50000, 2000, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        zzl(50000, 50000, "maxBufferMs", "minBufferMs");
        zzl(0, 0, "backBufferDurationMs", "0");
        this.zza = zzzeVar;
        this.zzb = zzeu.zzs(ServiceProvider.SCAR_SIGNALS_FETCH_TIMEOUT);
        this.zzc = zzeu.zzs(ServiceProvider.SCAR_SIGNALS_FETCH_TIMEOUT);
        this.zzd = zzeu.zzs(1000L);
        this.zze = zzeu.zzs(2000L);
        this.zzf = zzeu.zzs(0L);
        this.zzg = new HashMap();
        this.zzh = -1L;
    }

    private static void zzl(int i, int i2, String str, String str2) {
        zzdc.zze(i >= i2, str + " cannot be less than " + str2);
    }

    private final void zzm(zzoz zzozVar) {
        if (this.zzg.remove(zzozVar) != null) {
            zzn();
        }
    }

    private final void zzn() {
        if (this.zzg.isEmpty()) {
            this.zza.zze();
        } else {
            this.zza.zzf(zza());
        }
    }

    final int zza() {
        Iterator it = this.zzg.values().iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((zzic) it.next()).zzb;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzkr
    public final long zzb(zzoz zzozVar) {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzkr
    public final void zzc(zzoz zzozVar) {
        long id = Thread.currentThread().getId();
        long j = this.zzh;
        boolean z = true;
        if (j != -1 && j != id) {
            z = false;
        }
        zzdc.zzg(z, "Players that share the same LoadControl must share the same playback thread. See ExoPlayer.Builder.setPlaybackLooper(Looper).");
        this.zzh = id;
        HashMap map = this.zzg;
        if (!map.containsKey(zzozVar)) {
            map.put(zzozVar, new zzic(null));
        }
        zzic zzicVar = (zzic) map.get(zzozVar);
        zzicVar.getClass();
        zzicVar.zzb = 13107200;
        zzicVar.zza = false;
    }

    @Override // com.google.android.gms.internal.ads.zzkr
    public final void zzd(zzoz zzozVar) {
        zzm(zzozVar);
        if (this.zzg.isEmpty()) {
            this.zzh = -1L;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzkr
    public final void zze(zzoz zzozVar) {
        zzm(zzozVar);
    }

    @Override // com.google.android.gms.internal.ads.zzkr
    public final void zzf(zzkq zzkqVar, zzxd zzxdVar, zzyp[] zzypVarArr) {
        zzic zzicVar = (zzic) this.zzg.get(zzkqVar.zza);
        zzicVar.getClass();
        int length = zzypVarArr.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = 13107200;
            if (i >= length) {
                zzicVar.zzb = Math.max(13107200, i2);
                zzn();
                return;
            }
            zzyp zzypVar = zzypVarArr[i];
            if (zzypVar != null) {
                switch (zzypVar.zzg().zzc) {
                    case -1:
                    case 1:
                        break;
                    case 0:
                        i3 = 144310272;
                        break;
                    case 2:
                        i3 = 131072000;
                        break;
                    case 3:
                    case 4:
                    case 5:
                    default:
                        i3 = 131072;
                        break;
                }
                i2 += i3;
            }
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzkr
    public final boolean zzg(zzoz zzozVar) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzkr
    public final boolean zzh(zzkq zzkqVar) {
        zzic zzicVar = (zzic) this.zzg.get(zzkqVar.zza);
        zzicVar.getClass();
        int iZza = this.zza.zza();
        int iZza2 = zza();
        long jMin = this.zzb;
        float f = zzkqVar.zzc;
        if (f > 1.0f) {
            jMin = Math.min(zzeu.zzq(jMin, f), this.zzc);
        }
        long j = zzkqVar.zzb;
        if (j < Math.max(jMin, 500000L)) {
            boolean z = iZza < iZza2;
            zzicVar.zza = z;
            if (!z && j < 500000) {
                zzdx.zzf("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j >= this.zzc || iZza >= iZza2) {
            zzicVar.zza = false;
        }
        return zzicVar.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzkr
    public final boolean zzi(zzbl zzblVar, zzuy zzuyVar, long j) {
        Iterator it = this.zzg.values().iterator();
        while (it.hasNext()) {
            if (((zzic) it.next()).zza) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzkr
    public final boolean zzj(zzkq zzkqVar) {
        boolean z = zzkqVar.zzd;
        long jZzr = zzeu.zzr(zzkqVar.zzb, zzkqVar.zzc);
        long jMin = z ? this.zze : this.zzd;
        long j = zzkqVar.zze;
        if (j != -9223372036854775807L) {
            jMin = Math.min(j / 2, jMin);
        }
        return jMin <= 0 || jZzr >= jMin || this.zza.zza() >= zza();
    }

    @Override // com.google.android.gms.internal.ads.zzkr
    public final zzze zzk() {
        return this.zza;
    }
}
