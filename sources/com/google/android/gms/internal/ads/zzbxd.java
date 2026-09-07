package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
@ParametersAreNonnullByDefault
public final class zzbxd implements zzbxi {
    public static final /* synthetic */ int zzb = 0;
    private static final List zzc = Collections.synchronizedList(new ArrayList());
    boolean zza;
    private final zzhbu zzd;
    private final LinkedHashMap zze;
    private final Context zzh;
    private final zzbxf zzi;
    private final List zzf = new ArrayList();
    private final List zzg = new ArrayList();
    private final Object zzj = new Object();
    private HashSet zzk = new HashSet();
    private boolean zzl = false;
    private boolean zzm = false;

    public zzbxd(Context context, VersionInfoParcel versionInfoParcel, zzbxf zzbxfVar, String str, zzbxe zzbxeVar) {
        Preconditions.checkNotNull(zzbxfVar, "SafeBrowsing config is not present.");
        this.zzh = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zze = new LinkedHashMap();
        this.zzi = zzbxfVar;
        Iterator it = zzbxfVar.zze.iterator();
        while (it.hasNext()) {
            this.zzk.add(((String) it.next()).toLowerCase(Locale.ENGLISH));
        }
        this.zzk.remove("cookie".toLowerCase(Locale.ENGLISH));
        zzhbu zzhbuVarZzc = zzhdt.zzc();
        zzhbuVarZzc.zzn(9);
        zzhbuVarZzc.zzj(str);
        zzhbuVarZzc.zzh(str);
        zzhbv zzhbvVarZzc = zzhbw.zzc();
        String str2 = this.zzi.zza;
        if (str2 != null) {
            zzhbvVarZzc.zza(str2);
        }
        zzhbuVarZzc.zzg((zzhbw) zzhbvVarZzc.zzbr());
        zzhdk zzhdkVarZzc = zzhdl.zzc();
        zzhdkVarZzc.zzc(Wrappers.packageManager(this.zzh).isCallerInstantApp());
        String str3 = versionInfoParcel.afmaVersion;
        if (str3 != null) {
            zzhdkVarZzc.zza(str3);
        }
        long apkVersion = GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zzh);
        if (apkVersion > 0) {
            zzhdkVarZzc.zzb(apkVersion);
        }
        zzhbuVarZzc.zzf((zzhdl) zzhdkVarZzc.zzbr());
        this.zzd = zzhbuVarZzc;
    }

    public static /* synthetic */ ListenableFuture zzb(zzbxd zzbxdVar, Map map) {
        int length;
        zzhdi zzhdiVar;
        ListenableFuture listenableFutureZzm;
        if (map != null) {
            try {
                for (String str : map.keySet()) {
                    JSONArray jSONArrayOptJSONArray = new JSONObject((String) map.get(str)).optJSONArray("matches");
                    if (jSONArrayOptJSONArray != null) {
                        Object obj = zzbxdVar.zzj;
                        synchronized (obj) {
                            length = jSONArrayOptJSONArray.length();
                            synchronized (obj) {
                                try {
                                    zzhdiVar = (zzhdi) zzbxdVar.zze.get(str);
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        }
                        if (zzhdiVar == null) {
                            zzbxh.zza("Cannot find the corresponding resource object for " + str);
                        } else {
                            for (int i = 0; i < length; i++) {
                                zzhdiVar.zza(jSONArrayOptJSONArray.getJSONObject(i).getString("threat_type"));
                            }
                            zzbxdVar.zza = (length > 0) | zzbxdVar.zza;
                        }
                    }
                }
            } catch (JSONException e) {
                if (((Boolean) zzbeq.zza.zze()).booleanValue()) {
                    int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzf("Failed to get SafeBrowsing metadata", e);
                }
                return zzgbs.zzg(new Exception("Safebrowsing report transmission failed."));
            }
        }
        if (zzbxdVar.zza) {
            synchronized (zzbxdVar.zzj) {
                zzbxdVar.zzd.zzn(10);
            }
        }
        boolean z = zzbxdVar.zza;
        if (!(z && zzbxdVar.zzi.zzg) && (!(zzbxdVar.zzm && zzbxdVar.zzi.zzf) && (z || !zzbxdVar.zzi.zzd))) {
            return zzgbs.zzh(null);
        }
        synchronized (zzbxdVar.zzj) {
            Iterator it = zzbxdVar.zze.values().iterator();
            while (it.hasNext()) {
                zzbxdVar.zzd.zzc((zzhdj) ((zzhdi) it.next()).zzbr());
            }
            zzhbu zzhbuVar = zzbxdVar.zzd;
            zzhbuVar.zza(zzbxdVar.zzf);
            zzhbuVar.zzb(zzbxdVar.zzg);
            if (zzbxh.zzb()) {
                StringBuilder sb = new StringBuilder("Sending SB report\n  url: " + zzhbuVar.zzl() + "\n  clickUrl: " + zzhbuVar.zzk() + "\n  resources: \n");
                for (zzhdj zzhdjVar : zzhbuVar.zzm()) {
                    sb.append("    [");
                    sb.append(zzhdjVar.zzc());
                    sb.append("] ");
                    sb.append(zzhdjVar.zzg());
                }
                zzbxh.zza(sb.toString());
            }
            ListenableFuture listenableFutureZzb = new com.google.android.gms.ads.internal.util.zzbo(zzbxdVar.zzh).zzb(1, zzbxdVar.zzi.zzb, null, ((zzhdt) zzhbuVar.zzbr()).zzaV());
            if (zzbxh.zzb()) {
                listenableFutureZzb.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbxa
                    @Override // java.lang.Runnable
                    public final void run() {
                        int i3 = zzbxd.zzb;
                        zzbxh.zza("Pinged SB successfully.");
                    }
                }, zzbzk.zza);
            }
            listenableFutureZzm = zzgbs.zzm(listenableFutureZzb, new zzftl() { // from class: com.google.android.gms.internal.ads.zzbxb
                @Override // com.google.android.gms.internal.ads.zzftl
                public final Object apply(Object obj2) {
                    int i3 = zzbxd.zzb;
                    return null;
                }
            }, zzbzk.zzg);
        }
        return listenableFutureZzm;
    }

    public static /* synthetic */ void zzd(zzbxd zzbxdVar, Bitmap bitmap) {
        zzgwl zzgwlVarZzt = zzgwn.zzt();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, zzgwlVarZzt);
        synchronized (zzbxdVar.zzj) {
            zzhbu zzhbuVar = zzbxdVar.zzd;
            zzhdc zzhdcVarZzc = zzhde.zzc();
            zzhdcVarZzc.zza(zzgwlVarZzt.zzb());
            zzhdcVarZzc.zzb("image/png");
            zzhdcVarZzc.zzc(2);
            zzhbuVar.zzi((zzhde) zzhdcVarZzc.zzbr());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbxi
    public final zzbxf zza() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzbxi
    public final void zze(String str, Map map, int i) {
        synchronized (this.zzj) {
            if (i == 3) {
                this.zzm = true;
            }
            LinkedHashMap linkedHashMap = this.zze;
            if (linkedHashMap.containsKey(str)) {
                if (i == 3) {
                    ((zzhdi) linkedHashMap.get(str)).zze(4);
                }
                return;
            }
            zzhdi zzhdiVarZzd = zzhdj.zzd();
            int iZza = zzhdh.zza(i);
            if (iZza != 0) {
                zzhdiVarZzd.zze(iZza);
            }
            zzhdiVarZzd.zzb(linkedHashMap.size());
            zzhdiVarZzd.zzd(str);
            zzhch zzhchVarZzc = zzhck.zzc();
            if (!this.zzk.isEmpty() && map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    String str2 = entry.getKey() != null ? (String) entry.getKey() : "";
                    String str3 = entry.getValue() != null ? (String) entry.getValue() : "";
                    if (this.zzk.contains(str2.toLowerCase(Locale.ENGLISH))) {
                        zzhcf zzhcfVarZzc = zzhcg.zzc();
                        zzhcfVarZzc.zza(zzgwn.zzw(str2));
                        zzhcfVarZzc.zzb(zzgwn.zzw(str3));
                        zzhchVarZzc.zza((zzhcg) zzhcfVarZzc.zzbr());
                    }
                }
            }
            zzhdiVarZzd.zzc((zzhck) zzhchVarZzc.zzbr());
            linkedHashMap.put(str, zzhdiVarZzd);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbxi
    public final void zzf() {
        synchronized (this.zzj) {
            this.zze.keySet();
            ListenableFuture listenableFutureZzn = zzgbs.zzn(zzgbs.zzh(Collections.emptyMap()), new zzgaz() { // from class: com.google.android.gms.internal.ads.zzbwy
                @Override // com.google.android.gms.internal.ads.zzgaz
                public final ListenableFuture zza(Object obj) {
                    return zzbxd.zzb(this.zza, (Map) obj);
                }
            }, zzbzk.zzg);
            ListenableFuture listenableFutureZzo = zzgbs.zzo(listenableFutureZzn, 10L, TimeUnit.SECONDS, zzbzk.zzd);
            zzgbs.zzr(listenableFutureZzn, new zzbxc(this, listenableFutureZzo), zzbzk.zzg);
            zzc.add(listenableFutureZzo);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbxi
    public final void zzg(View view) {
        Bitmap bitmapCreateBitmap;
        if (this.zzi.zzc && !this.zzl) {
            com.google.android.gms.ads.internal.zzv.zzq();
            final Bitmap bitmap = null;
            if (view != null) {
                try {
                    boolean zIsDrawingCacheEnabled = view.isDrawingCacheEnabled();
                    view.setDrawingCacheEnabled(true);
                    Bitmap drawingCache = view.getDrawingCache();
                    bitmapCreateBitmap = drawingCache != null ? Bitmap.createBitmap(drawingCache) : null;
                    try {
                        view.setDrawingCacheEnabled(zIsDrawingCacheEnabled);
                    } catch (RuntimeException e) {
                        e = e;
                        int i = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzh("Fail to capture the web view", e);
                    }
                } catch (RuntimeException e2) {
                    e = e2;
                    bitmapCreateBitmap = null;
                }
                if (bitmapCreateBitmap == null) {
                    try {
                        int width = view.getWidth();
                        int height = view.getHeight();
                        if (width == 0 || height == 0) {
                            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                            com.google.android.gms.ads.internal.util.client.zzo.zzj("Width or height of view is zero");
                        } else {
                            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
                            Canvas canvas = new Canvas(bitmapCreateBitmap2);
                            view.layout(0, 0, width, height);
                            view.draw(canvas);
                            bitmap = bitmapCreateBitmap2;
                        }
                    } catch (RuntimeException e3) {
                        int i3 = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzh("Fail to capture the webview", e3);
                    }
                } else {
                    bitmap = bitmapCreateBitmap;
                }
            }
            if (bitmap == null) {
                zzbxh.zza("Failed to capture the webview bitmap.");
            } else {
                this.zzl = true;
                com.google.android.gms.ads.internal.util.zzs.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbwz
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzbxd.zzd(this.zza, bitmap);
                    }
                });
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbxi
    public final void zzh(String str) {
        synchronized (this.zzj) {
            try {
                if (str == null) {
                    this.zzd.zzd();
                } else {
                    this.zzd.zze(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbxi
    public final boolean zzi() {
        return PlatformVersion.isAtLeastKitKat() && this.zzi.zzc && !this.zzl;
    }
}
