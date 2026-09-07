package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.common.util.Clock;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzccy extends zzccs implements zzhe {
    private static final AtomicInteger zzd = new AtomicInteger(0);
    private String zze;
    private final zzcbf zzf;
    private boolean zzg;
    private final zzccx zzh;
    private final zzccc zzi;
    private ByteBuffer zzj;
    private boolean zzk;
    private final Object zzl;
    private final String zzm;
    private final int zzn;
    private boolean zzo;

    public zzccy(zzcbg zzcbgVar, zzcbf zzcbfVar) {
        super(zzcbgVar);
        this.zzf = zzcbfVar;
        this.zzh = new zzccx();
        this.zzi = new zzccc();
        this.zzl = new Object();
        this.zzm = (String) zzftu.zzd(zzcbgVar != null ? zzcbgVar.zzr() : null).zzb("");
        this.zzn = zzcbgVar != null ? zzcbgVar.zzf() : 0;
        zzd.incrementAndGet();
    }

    public static int zzi() {
        return zzd.get();
    }

    protected static final String zzv(String str) {
        return "cache:".concat(String.valueOf(com.google.android.gms.ads.internal.util.client.zzf.zzg(str)));
    }

    private final void zzx() {
        int iZza = (int) this.zzh.zza();
        int iZza2 = (int) this.zzi.zza(this.zzj);
        int iPosition = this.zzj.position();
        int iRound = Math.round(iZza2 * (iPosition / iZza));
        int iZzs = zzcax.zzs();
        int iZzu = zzcax.zzu();
        String str = this.zze;
        zzn(str, zzv(str), iPosition, iZza, iRound, iZza2, iRound > 0, iZzs, iZzu);
    }

    @Override // com.google.android.gms.internal.ads.zzccs, com.google.android.gms.common.api.Releasable
    public final void release() {
        zzd.decrementAndGet();
    }

    @Override // com.google.android.gms.internal.ads.zzhe
    public final void zza(zzge zzgeVar, zzgj zzgjVar, boolean z, int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzhe
    public final void zzb(zzge zzgeVar, zzgj zzgjVar, boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzhe
    public final void zzc(zzge zzgeVar, zzgj zzgjVar, boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzhe
    public final void zzd(zzge zzgeVar, zzgj zzgjVar, boolean z) {
        if (zzgeVar instanceof zzgr) {
            this.zzh.zzb((zzgr) zzgeVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void zzf() {
        this.zzg = true;
    }

    public final String zzk() {
        return this.zze;
    }

    public final ByteBuffer zzl() {
        synchronized (this.zzl) {
            ByteBuffer byteBuffer = this.zzj;
            if (byteBuffer != null && !this.zzk) {
                byteBuffer.flip();
                this.zzk = true;
            }
            this.zzg = true;
        }
        return this.zzj;
    }

    public final boolean zzm() {
        return this.zzo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:? -> B:45:0x0143). Please report as a decompilation issue!!! */
    @Override // com.google.android.gms.internal.ads.zzccs
    public final boolean zzt(String str) throws Throwable {
        String str2;
        this.zze = str;
        String str3 = "error";
        String strZzv = zzv(str);
        int i = 0;
        try {
            zzgm zzgmVar = new zzgm();
            zzgmVar.zzf(this.zzb);
            zzcbf zzcbfVar = this.zzf;
            zzgmVar.zzc(zzcbfVar.zzd);
            zzgmVar.zzd(zzcbfVar.zze);
            zzgmVar.zzb(true);
            zzgmVar.zze(this);
            zzge zzgeVarZza = zzgmVar.zza();
            if (zzcbfVar.zzi) {
                zzgeVarZza = new zzcca(this.zza, zzgeVarZza, this.zzm, this.zzn, null, null);
            }
            zzgeVarZza.zzb(new zzgj(Uri.parse(str), 0L, -1L, null));
            zzcbg zzcbgVar = (zzcbg) this.zzc.get();
            if (zzcbgVar != null) {
                zzcbgVar.zzt(strZzv, this);
            }
            Clock clockZzC = com.google.android.gms.ads.internal.zzv.zzC();
            long jCurrentTimeMillis = clockZzC.currentTimeMillis();
            long jLongValue = ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzO)).longValue();
            long jLongValue2 = ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzN)).longValue();
            this.zzj = ByteBuffer.allocate(zzcbfVar.zzc);
            int i2 = 8192;
            byte[] bArr = new byte[8192];
            long j = jCurrentTimeMillis;
            while (true) {
                int iZza = zzgeVarZza.zza(bArr, i, Math.min(this.zzj.remaining(), i2));
                if (iZza == -1) {
                    this.zzo = true;
                    zzj(str, strZzv, (int) this.zzi.zza(this.zzj));
                    break;
                }
                synchronized (this.zzl) {
                    try {
                        if (!this.zzg) {
                            try {
                                this.zzj.put(bArr, 0, iZza);
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        }
                        try {
                            if (this.zzj.remaining() <= 0) {
                                zzx();
                                break;
                            }
                            str2 = 1;
                            try {
                                if (this.zzg) {
                                    throw new IOException("Precache abort at " + this.zzj.limit() + " bytes");
                                }
                                long jCurrentTimeMillis2 = clockZzC.currentTimeMillis();
                                if (jCurrentTimeMillis2 - j >= jLongValue) {
                                    zzx();
                                    j = jCurrentTimeMillis2;
                                }
                                if (jCurrentTimeMillis2 - jCurrentTimeMillis > 1000 * jLongValue2) {
                                    throw new IOException("Timeout exceeded. Limit: " + jLongValue2 + " sec");
                                }
                                str3 = str3;
                                i = 0;
                                i2 = 8192;
                            } catch (Exception e) {
                                e = e;
                                String str4 = e.getClass().getCanonicalName() + ":" + e.getMessage();
                                int i3 = com.google.android.gms.ads.internal.util.zze.zza;
                                com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to preload url " + str + " Exception: " + str4);
                                zzg(str, strZzv, str2, str4);
                                return false;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            str2 = str3;
                            String str5 = e.getClass().getCanonicalName() + ":" + e.getMessage();
                            int i4 = com.google.android.gms.ads.internal.util.zze.zza;
                            com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to preload url " + str + " Exception: " + str5);
                            zzg(str, strZzv, str2, str5);
                            return false;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
            }
            return true;
        } catch (Exception e3) {
            e = e3;
            str3 = str3;
        }
    }
}
