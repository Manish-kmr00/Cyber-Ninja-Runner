package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.view.Surface;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzcdt extends zzcax implements zzhe, zzmj {
    public static final /* synthetic */ int zza = 0;
    private final Context zzb;
    private final zzcde zzc;
    private final zzyn zzd;
    private final zzcbf zze;
    private final WeakReference zzf;
    private final zzwh zzg;
    private zzit zzh;
    private ByteBuffer zzi;
    private boolean zzj;
    private zzcaw zzk;
    private int zzl;
    private int zzm;
    private long zzn;
    private final String zzo;
    private final int zzp;
    private Integer zzr;
    private final ArrayList zzs;
    private volatile zzcdg zzt;
    private final Object zzq = new Object();
    private final Set zzu = new HashSet();

    /* JADX WARN: Code duplicated, block: B:21:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:23:0x00e9  */
    public zzcdt(Context context, zzcbf zzcbfVar, zzcbg zzcbgVar, Integer num) {
        final boolean z;
        final zzgd zzgdVar;
        this.zzb = context;
        this.zze = zzcbfVar;
        this.zzr = num;
        this.zzf = new WeakReference(zzcbgVar);
        zzcde zzcdeVar = new zzcde();
        this.zzc = zzcdeVar;
        zzyn zzynVar = new zzyn(context);
        this.zzd = zzynVar;
        if (com.google.android.gms.ads.internal.util.zze.zzc()) {
            com.google.android.gms.ads.internal.util.zze.zza("SimpleExoPlayerAdapter initialize ".concat(toString()));
        }
        zzD().incrementAndGet();
        zzmb zzmbVar = new zzmb(context, new zzcdr(this));
        zzmbVar.zzb(zzynVar);
        zzmbVar.zza(zzcdeVar);
        zzmc zzmcVarZzc = zzmbVar.zzc();
        this.zzh = zzmcVarZzc;
        zzmcVarZzc.zzz(this);
        this.zzl = 0;
        this.zzn = 0L;
        this.zzm = 0;
        this.zzs = new ArrayList();
        this.zzt = null;
        this.zzo = (String) zzftu.zzd(zzcbgVar != null ? zzcbgVar.zzr() : null).zzb("");
        this.zzp = zzcbgVar != null ? zzcbgVar.zzf() : 0;
        final String strZzc = com.google.android.gms.ads.internal.zzv.zzq().zzc(context, zzcbgVar.zzm().afmaVersion);
        if (!this.zzj || this.zzi.limit() <= 0) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzck)).booleanValue()) {
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcc)).booleanValue()) {
                    z = zzcbfVar.zzi ? false : true;
                }
            } else if (zzcbfVar.zzi) {
            }
            final zzgd zzgdVar2 = zzcbfVar.zzl ? new zzgd() { // from class: com.google.android.gms.internal.ads.zzcdk
                @Override // com.google.android.gms.internal.ads.zzgd
                public final zzge zza() {
                    return zzcdt.zzW(this.zza, strZzc, z);
                }
            } : zzcbfVar.zzh > 0 ? new zzgd() { // from class: com.google.android.gms.internal.ads.zzcdl
                @Override // com.google.android.gms.internal.ads.zzgd
                public final zzge zza() {
                    return zzcdt.zzX(this.zza, strZzc, z);
                }
            } : new zzgd() { // from class: com.google.android.gms.internal.ads.zzcdm
                @Override // com.google.android.gms.internal.ads.zzgd
                public final zzge zza() {
                    return zzcdt.zzY(this.zza, strZzc, z);
                }
            };
            zzgdVar = zzcbfVar.zzi ? new zzgd() { // from class: com.google.android.gms.internal.ads.zzcdn
                @Override // com.google.android.gms.internal.ads.zzgd
                public final zzge zza() {
                    return zzcdt.zzZ(this.zza, zzgdVar2);
                }
            } : zzgdVar2;
            ByteBuffer byteBuffer = this.zzi;
            if (byteBuffer != null && byteBuffer.limit() > 0) {
                final byte[] bArr = new byte[this.zzi.limit()];
                this.zzi.get(bArr);
                zzgdVar = new zzgd() { // from class: com.google.android.gms.internal.ads.zzcdo
                    @Override // com.google.android.gms.internal.ads.zzgd
                    public final zzge zza() {
                        int i = zzcdt.zza;
                        zzge zzgeVarZza = zzgdVar.zza();
                        byte[] bArr2 = bArr;
                        return new zzcdh(new zzfz(bArr2), bArr2.length, zzgeVarZza);
                    }
                };
            }
        } else {
            final byte[] bArr2 = new byte[this.zzi.limit()];
            this.zzi.get(bArr2);
            zzgdVar = new zzgd() { // from class: com.google.android.gms.internal.ads.zzcdi
                @Override // com.google.android.gms.internal.ads.zzgd
                public final zzge zza() {
                    int i = zzcdt.zza;
                    return new zzfz(bArr2);
                }
            };
        }
        this.zzg = new zzwh(zzgdVar, new zzwg(((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzm)).booleanValue() ? new zzadh() { // from class: com.google.android.gms.internal.ads.zzcds
            @Override // com.google.android.gms.internal.ads.zzadh
            public final /* synthetic */ zzadc[] zza(Uri uri, Map map) {
                int i = zzcdt.zza;
                return new zzadc[]{new zzaiq(), new zzahf(), new zzaik(zzajy.zza, 32, null, null, zzfww.zzn(), null)};
            }
        } : new zzadh() { // from class: com.google.android.gms.internal.ads.zzcdj
            @Override // com.google.android.gms.internal.ads.zzadh
            public final /* synthetic */ zzadc[] zza(Uri uri, Map map) {
                int i = zzcdt.zza;
                return new zzadc[]{new zzaiq(), new zzahf()};
            }
        }));
    }

    public static /* synthetic */ zzge zzW(zzcdt zzcdtVar, String str, boolean z) {
        zzcdt zzcdtVar2 = true != z ? null : zzcdtVar;
        zzcbf zzcbfVar = zzcdtVar.zze;
        return new zzcdw(str, zzcdtVar2, zzcbfVar.zzd, zzcbfVar.zze, zzcbfVar.zzm, zzcbfVar.zzn);
    }

    public static /* synthetic */ zzge zzX(zzcdt zzcdtVar, String str, boolean z) {
        zzcdt zzcdtVar2 = true != z ? null : zzcdtVar;
        zzcbf zzcbfVar = zzcdtVar.zze;
        zzcdd zzcddVar = new zzcdd(str, zzcdtVar2, zzcbfVar.zzd, zzcbfVar.zze, zzcbfVar.zzh);
        zzcdtVar.zzu.add(new WeakReference(zzcddVar));
        return zzcddVar;
    }

    public static /* synthetic */ zzge zzY(zzcdt zzcdtVar, String str, boolean z) {
        zzgm zzgmVar = new zzgm();
        zzgmVar.zzf(str);
        zzgmVar.zze(true != z ? null : zzcdtVar);
        zzcbf zzcbfVar = zzcdtVar.zze;
        zzgmVar.zzc(zzcbfVar.zzd);
        zzgmVar.zzd(zzcbfVar.zze);
        zzgmVar.zzb(true);
        return zzgmVar.zza();
    }

    public static /* synthetic */ zzge zzZ(zzcdt zzcdtVar, zzgd zzgdVar) {
        zzge zzgeVarZza = zzgdVar.zza();
        zzcdq zzcdqVar = new zzcdq(zzcdtVar);
        return new zzcdg(zzcdtVar.zzb, zzgeVarZza, zzcdtVar.zzo, zzcdtVar.zzp, zzcdtVar, zzcdqVar);
    }

    public static /* synthetic */ void zzab(zzcdt zzcdtVar, boolean z, long j) {
        zzcaw zzcawVar = zzcdtVar.zzk;
        if (zzcawVar != null) {
            zzcawVar.zzi(z, j);
        }
    }

    public static /* synthetic */ zzlu[] zzac(zzcdt zzcdtVar, Handler handler, zzabs zzabsVar, zzpy zzpyVar, zzxg zzxgVar, zztw zztwVar) {
        zzti zztiVar = zzti.zza;
        Context context = zzcdtVar.zzb;
        zzrl zzrlVar = new zzrl(context, new zzso(context, null, null), zztiVar, false, handler, zzpyVar, new zzqt(context).zzc());
        zzaaj zzaajVar = new zzaaj(context);
        zzaajVar.zzg(zztiVar);
        zzaajVar.zze(handler);
        zzaajVar.zzf(zzabsVar);
        return new zzlu[]{zzrlVar, zzaajVar.zzh()};
    }

    private final boolean zzad() {
        return this.zzt != null && this.zzt.zzq();
    }

    public final void finalize() {
        zzD().decrementAndGet();
        if (com.google.android.gms.ads.internal.util.zze.zzc()) {
            com.google.android.gms.ads.internal.util.zze.zza("SimpleExoPlayerAdapter finalize ".concat(toString()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcax
    public final long zzA() {
        if (zzad()) {
            return 0L;
        }
        return this.zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzcax
    public final long zzB() {
        if (zzad()) {
            return this.zzt.zzl();
        }
        synchronized (this.zzq) {
            while (true) {
                ArrayList arrayList = this.zzs;
                if (!arrayList.isEmpty()) {
                    long j = this.zzn;
                    Map mapZze = ((zzgz) arrayList.remove(0)).zze();
                    long j2 = 0;
                    if (mapZze != null) {
                        for (Map.Entry entry : mapZze.entrySet()) {
                            if (entry != null) {
                                try {
                                    if (entry.getKey() != null && zzftc.zzc("content-length", (CharSequence) entry.getKey()) && entry.getValue() != null && ((List) entry.getValue()).get(0) != null) {
                                        j2 = Long.parseLong((String) ((List) entry.getValue()).get(0));
                                        break;
                                    }
                                } catch (NumberFormatException unused) {
                                    continue;
                                }
                            }
                        }
                    }
                    this.zzn = j + j2;
                }
            }
        }
        return this.zzn;
    }

    @Override // com.google.android.gms.internal.ads.zzcax
    public final Integer zzC() {
        return this.zzr;
    }

    @Override // com.google.android.gms.internal.ads.zzcax
    public final void zzF(Uri[] uriArr, String str) {
        zzG(uriArr, str, ByteBuffer.allocate(0), false);
    }

    @Override // com.google.android.gms.internal.ads.zzcax
    public final void zzH() {
        zzit zzitVar = this.zzh;
        if (zzitVar != null) {
            zzitVar.zzB(this);
            this.zzh.zzA();
            this.zzh = null;
            zzE().decrementAndGet();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcax
    public final void zzI(long j) {
        this.zzh.zza(j);
    }

    @Override // com.google.android.gms.internal.ads.zzcax
    public final void zzJ(int i) {
        this.zzc.zzl(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcax
    public final void zzK(int i) {
        this.zzc.zzm(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcax
    public final void zzL(zzcaw zzcawVar) {
        this.zzk = zzcawVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcax
    public final void zzM(int i) {
        this.zzc.zzn(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcax
    public final void zzN(int i) {
        this.zzc.zzo(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcax
    public final void zzO(boolean z) {
        this.zzh.zzr(z);
    }

    @Override // com.google.android.gms.internal.ads.zzcax
    public final void zzP(Integer num) {
        this.zzr = num;
    }

    @Override // com.google.android.gms.internal.ads.zzcax
    public final void zzQ(boolean z) {
        if (this.zzh == null) {
            return;
        }
        int i = 0;
        while (true) {
            this.zzh.zzy();
            if (i >= 2) {
                return;
            }
            zzyn zzynVar = this.zzd;
            zzya zzyaVarZzc = zzynVar.zzf().zzc();
            zzyaVarZzc.zzx(i, !z);
            zzynVar.zzl(zzyaVarZzc);
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcax
    public final void zzR(int i) {
        Iterator it = this.zzu.iterator();
        while (it.hasNext()) {
            zzcdd zzcddVar = (zzcdd) ((WeakReference) it.next()).get();
            if (zzcddVar != null) {
                zzcddVar.zzm(i);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcax
    public final void zzS(Surface surface, boolean z) {
        zzit zzitVar = this.zzh;
        if (zzitVar != null) {
            zzitVar.zzs(surface);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcax
    public final void zzT(float f, boolean z) {
        zzit zzitVar = this.zzh;
        if (zzitVar != null) {
            zzitVar.zzt(f);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcax
    public final void zzU() {
        this.zzh.zzu();
    }

    @Override // com.google.android.gms.internal.ads.zzcax
    public final boolean zzV() {
        return this.zzh != null;
    }

    @Override // com.google.android.gms.internal.ads.zzhe
    public final void zza(zzge zzgeVar, zzgj zzgjVar, boolean z, int i) {
        this.zzl += i;
    }

    final zzva zzaa(Uri uri) {
        zzad zzadVar = new zzad();
        zzadVar.zzb(uri);
        zzap zzapVarZzc = zzadVar.zzc();
        zzwh zzwhVar = this.zzg;
        zzwhVar.zza(this.zze.zzf);
        return zzwhVar.zzb(zzapVarZzc);
    }

    @Override // com.google.android.gms.internal.ads.zzhe
    public final void zzb(zzge zzgeVar, zzgj zzgjVar, boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzhe
    public final void zzc(zzge zzgeVar, zzgj zzgjVar, boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzhe
    public final void zzd(zzge zzgeVar, zzgj zzgjVar, boolean z) {
        if (zzgeVar instanceof zzgz) {
            synchronized (this.zzq) {
                this.zzs.add((zzgz) zzgeVar);
            }
        } else if (zzgeVar instanceof zzcdg) {
            this.zzt = (zzcdg) zzgeVar;
            final zzcbg zzcbgVar = (zzcbg) this.zzf.get();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcc)).booleanValue() && zzcbgVar != null && this.zzt.zzn()) {
                final HashMap map = new HashMap();
                map.put("gcacheHit", String.valueOf(this.zzt.zzp()));
                map.put("gcacheDownloaded", String.valueOf(this.zzt.zzo()));
                com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcdp
                    @Override // java.lang.Runnable
                    public final void run() {
                        int i = zzcdt.zza;
                        zzcbgVar.zzd("onGcacheInfoEvent", map);
                    }
                });
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmj
    public final void zze(zzmh zzmhVar, zzz zzzVar, zzhz zzhzVar) {
        zzcbg zzcbgVar = (zzcbg) this.zzf.get();
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcc)).booleanValue() || zzcbgVar == null) {
            return;
        }
        HashMap map = new HashMap();
        String str = zzzVar.zzn;
        if (str != null) {
            map.put("audioMime", str);
        }
        String str2 = zzzVar.zzo;
        if (str2 != null) {
            map.put("audioSampleMime", str2);
        }
        String str3 = zzzVar.zzk;
        if (str3 != null) {
            map.put("audioCodec", str3);
        }
        zzcbgVar.zzd("onMetadataEvent", map);
    }

    @Override // com.google.android.gms.internal.ads.zzmj
    public final /* synthetic */ void zzf(zzmh zzmhVar, int i, long j, long j2) {
    }

    @Override // com.google.android.gms.internal.ads.zzmj
    public final /* synthetic */ void zzg(zzmh zzmhVar, zzuu zzuuVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzmj
    public final void zzh(zzmh zzmhVar, int i, long j) {
        this.zzm += i;
    }

    @Override // com.google.android.gms.internal.ads.zzmj
    public final /* synthetic */ void zzi(zzbh zzbhVar, zzmi zzmiVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzmj
    public final void zzj(zzmh zzmhVar, zzup zzupVar, zzuu zzuuVar, IOException iOException, boolean z) {
        zzcaw zzcawVar = this.zzk;
        if (zzcawVar != null) {
            if (this.zze.zzj) {
                zzcawVar.zzl("onLoadException", iOException);
            } else {
                zzcawVar.zzk("onLoadError", iOException);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmj
    public final void zzk(zzmh zzmhVar, int i) {
        zzcaw zzcawVar = this.zzk;
        if (zzcawVar != null) {
            zzcawVar.zzm(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmj
    public final void zzl(zzmh zzmhVar, zzba zzbaVar) {
        zzcaw zzcawVar = this.zzk;
        if (zzcawVar != null) {
            zzcawVar.zzk("onPlayerError", zzbaVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmj
    public final /* synthetic */ void zzm(zzmh zzmhVar, zzbf zzbfVar, zzbf zzbfVar2, int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzmj
    public final void zzn(zzmh zzmhVar, Object obj, long j) {
        zzcaw zzcawVar = this.zzk;
        if (zzcawVar != null) {
            zzcawVar.zzv();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmj
    public final /* synthetic */ void zzo(zzmh zzmhVar, zzhy zzhyVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzmj
    public final void zzp(zzmh zzmhVar, zzz zzzVar, zzhz zzhzVar) {
        zzcbg zzcbgVar = (zzcbg) this.zzf.get();
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcc)).booleanValue() || zzcbgVar == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("frameRate", String.valueOf(zzzVar.zzx));
        map.put("bitRate", String.valueOf(zzzVar.zzj));
        map.put("resolution", zzzVar.zzv + VastAttributes.HORIZONTAL_POSITION + zzzVar.zzw);
        String str = zzzVar.zzn;
        if (str != null) {
            map.put("videoMime", str);
        }
        String str2 = zzzVar.zzo;
        if (str2 != null) {
            map.put("videoSampleMime", str2);
        }
        String str3 = zzzVar.zzk;
        if (str3 != null) {
            map.put("videoCodec", str3);
        }
        zzcbgVar.zzd("onMetadataEvent", map);
    }

    @Override // com.google.android.gms.internal.ads.zzmj
    public final void zzq(zzmh zzmhVar, zzcd zzcdVar) {
        zzcaw zzcawVar = this.zzk;
        if (zzcawVar != null) {
            zzcawVar.zzD(zzcdVar.zzb, zzcdVar.zzc);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcax
    public final int zzr() {
        return this.zzm;
    }

    @Override // com.google.android.gms.internal.ads.zzcax
    public final int zzt() {
        return this.zzh.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzcax
    public final long zzv() {
        return this.zzh.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzcax
    public final long zzw() {
        return this.zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzcax
    public final long zzx() {
        if (zzad() && this.zzt.zzp()) {
            return Math.min(this.zzl, this.zzt.zzk());
        }
        return 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzcax
    public final long zzy() {
        return this.zzh.zzl();
    }

    @Override // com.google.android.gms.internal.ads.zzcax
    public final long zzz() {
        return this.zzh.zzm();
    }

    @Override // com.google.android.gms.internal.ads.zzcax
    public final void zzG(Uri[] uriArr, String str, ByteBuffer byteBuffer, boolean z) {
        zzva zzvsVar;
        if (this.zzh != null) {
            this.zzi = byteBuffer;
            this.zzj = z;
            int length = uriArr.length;
            if (length == 1) {
                zzvsVar = zzaa(uriArr[0]);
            } else {
                zzva[] zzvaVarArr = new zzva[length];
                for (int i = 0; i < uriArr.length; i++) {
                    zzvaVarArr[i] = zzaa(uriArr[i]);
                }
                zzvsVar = new zzvs(false, false, new zzuj(), zzvaVarArr);
            }
            this.zzh.zzC(zzvsVar);
            this.zzh.zzq();
            zzE().incrementAndGet();
        }
    }
}
