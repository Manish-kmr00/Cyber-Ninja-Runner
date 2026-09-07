package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.collection.ArrayMap;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdhl extends zzcqg {
    public static final /* synthetic */ int zzc = 0;
    private final Executor zzd;
    private final zzdhq zze;
    private final zzdhy zzf;
    private final zzdiq zzg;
    private final zzdhv zzh;
    private final zzdib zzi;
    private final zzhes zzj;
    private final zzhes zzk;
    private final zzhes zzl;
    private final zzhes zzm;
    private final zzhes zzn;
    private zzdjo zzo;
    private boolean zzp;
    private boolean zzq;
    private boolean zzr;
    private final zzbxs zzs;
    private final zzauy zzt;
    private final VersionInfoParcel zzu;
    private final Context zzv;
    private final zzdhn zzw;
    private final zzeju zzx;
    private final Map zzy;
    private final List zzz;

    static {
        zzfww.zzs("3010", "3008", "1005", "1009", "2011", "2007");
    }

    public zzdhl(zzcqf zzcqfVar, Executor executor, zzdhq zzdhqVar, zzdhy zzdhyVar, zzdiq zzdiqVar, zzdhv zzdhvVar, zzdib zzdibVar, zzhes zzhesVar, zzhes zzhesVar2, zzhes zzhesVar3, zzhes zzhesVar4, zzhes zzhesVar5, zzbxs zzbxsVar, zzauy zzauyVar, VersionInfoParcel versionInfoParcel, Context context, zzdhn zzdhnVar, zzeju zzejuVar, zzayj zzayjVar) {
        super(zzcqfVar);
        this.zzd = executor;
        this.zze = zzdhqVar;
        this.zzf = zzdhyVar;
        this.zzg = zzdiqVar;
        this.zzh = zzdhvVar;
        this.zzi = zzdibVar;
        this.zzj = zzhesVar;
        this.zzk = zzhesVar2;
        this.zzl = zzhesVar3;
        this.zzm = zzhesVar4;
        this.zzn = zzhesVar5;
        this.zzs = zzbxsVar;
        this.zzt = zzauyVar;
        this.zzu = versionInfoParcel;
        this.zzv = context;
        this.zzw = zzdhnVar;
        this.zzx = zzejuVar;
        this.zzy = new HashMap();
        this.zzz = new ArrayList();
    }

    public static boolean zzY(View view) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzkI)).booleanValue()) {
            return view.isShown() && view.getGlobalVisibleRect(new Rect(), new Point());
        }
        com.google.android.gms.ads.internal.zzv.zzq();
        long jZzx = com.google.android.gms.ads.internal.util.zzs.zzx(view);
        if (view.isShown() && view.getGlobalVisibleRect(new Rect(), new Point())) {
            if (jZzx >= ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzkJ)).intValue()) {
                return true;
            }
        }
        return false;
    }

    private final synchronized ImageView.ScaleType zzaa() {
        zzdjo zzdjoVar = this.zzo;
        if (zzdjoVar == null) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zze("Ad should be associated with an ad view before calling getMediaviewScaleType()");
            return null;
        }
        IObjectWrapper iObjectWrapperZzj = zzdjoVar.zzj();
        if (iObjectWrapperZzj != null) {
            return (ImageView.ScaleType) ObjectWrapper.unwrap(iObjectWrapperZzj);
        }
        return zzdiq.zza;
    }

    private final void zzab(String str, boolean z) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzft)).booleanValue()) {
            zzf("Google", true);
            return;
        }
        ListenableFuture listenableFutureZzw = this.zze.zzw();
        if (listenableFutureZzw == null) {
            return;
        }
        zzgbs.zzr(listenableFutureZzw, new zzdhj(this, "Google", true), this.zzd);
    }

    private final synchronized void zzac(View view, Map map, Map map2) {
        this.zzg.zzd(this.zzo);
        this.zzf.zzs(view, map, map2, zzaa());
        this.zzq = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzad(View view, zzeca zzecaVar) {
        zzcel zzcelVarZzr = this.zze.zzr();
        if (!this.zzh.zzd() || zzecaVar == null || zzcelVarZzr == null || view == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzv.zzB().zzj(zzecaVar.zza(), view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzae(zzdjo zzdjoVar) {
        Iterator<String> itKeys;
        View view;
        zzaut zzautVarZzc;
        if (!this.zzp) {
            this.zzo = zzdjoVar;
            this.zzg.zze(zzdjoVar);
            this.zzf.zzA(zzdjoVar.zzf(), zzdjoVar.zzm(), zzdjoVar.zzn(), zzdjoVar, zzdjoVar);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcQ)).booleanValue() && (zzautVarZzc = this.zzt.zzc()) != null) {
                zzautVarZzc.zzo(zzdjoVar.zzf());
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzbW)).booleanValue()) {
                zzfau zzfauVar = this.zzb;
                if (zzfauVar.zzak && (itKeys = zzfauVar.zzaj.keys()) != null) {
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        zzdjo zzdjoVar2 = this.zzo;
                        WeakReference weakReference = zzdjoVar2 == null ? null : (WeakReference) zzdjoVar2.zzl().get(next);
                        this.zzy.put(next, false);
                        if (weakReference != null && (view = (View) weakReference.get()) != null) {
                            zzayi zzayiVar = new zzayi(this.zzv, view);
                            this.zzz.add(zzayiVar);
                            zzayiVar.zzd(new zzdhi(this, next));
                        }
                    }
                }
            }
            if (zzdjoVar.zzi() != null) {
                zzdjoVar.zzi().zzd(this.zzs);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaf(zzdjo zzdjoVar) {
        this.zzf.zzB(zzdjoVar.zzf(), zzdjoVar.zzl());
        if (zzdjoVar.zzh() != null) {
            zzdjoVar.zzh().setClickable(false);
            zzdjoVar.zzh().removeAllViews();
        }
        if (zzdjoVar.zzi() != null) {
            zzdjoVar.zzi().zze(this.zzs);
        }
        this.zzo = null;
    }

    public static /* synthetic */ void zzs(zzdhl zzdhlVar, boolean z) {
        zzdjo zzdjoVar = zzdhlVar.zzo;
        if (zzdjoVar != null) {
            zzdhlVar.zzf.zzq(null, zzdjoVar.zzf(), zzdhlVar.zzo.zzl(), zzdhlVar.zzo.zzm(), z, zzdhlVar.zzaa(), 0);
        } else {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zze("Ad should be associated with an ad view before calling recordCustomClickGesture()");
        }
    }

    public static /* synthetic */ void zzu(zzdhl zzdhlVar, View view, boolean z, int i) {
        zzdjo zzdjoVar = zzdhlVar.zzo;
        if (zzdjoVar != null) {
            zzdhlVar.zzf.zzq(view, zzdjoVar.zzf(), zzdhlVar.zzo.zzl(), zzdhlVar.zzo.zzm(), z, zzdhlVar.zzaa(), i);
        } else {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zze("Ad should be associated with an ad view before calling performClickForCustomGesture()");
        }
    }

    public static /* synthetic */ void zzv(zzdhl zzdhlVar) {
        zzdhlVar.zzf.zzk();
        zzdhlVar.zze.zzI();
    }

    public final synchronized void zzA() {
        this.zzf.zzj();
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0044 A[Catch: all -> 0x008c, TryCatch #0 {, blocks: (B:3:0x0001, B:6:0x0007, B:8:0x0019, B:10:0x001f, B:11:0x0029, B:13:0x002f, B:17:0x0044, B:20:0x0058, B:21:0x0060, B:23:0x0066, B:25:0x007a, B:27:0x0080, B:32:0x0087), top: B:38:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:23:0x0066 A[Catch: all -> 0x008c, TryCatch #0 {, blocks: (B:3:0x0001, B:6:0x0007, B:8:0x0019, B:10:0x001f, B:11:0x0029, B:13:0x002f, B:17:0x0044, B:20:0x0058, B:21:0x0060, B:23:0x0066, B:25:0x007a, B:27:0x0080, B:32:0x0087), top: B:38:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x0087 A[Catch: all -> 0x008c, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:6:0x0007, B:8:0x0019, B:10:0x001f, B:11:0x0029, B:13:0x002f, B:17:0x0044, B:20:0x0058, B:21:0x0060, B:23:0x0066, B:25:0x007a, B:27:0x0080, B:32:0x0087), top: B:38:0x0001 }] */
    public final synchronized void zzB(View view, Map map, Map map2, boolean z) {
        Iterator it;
        View view2;
        if (!this.zzq) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzbW)).booleanValue() && this.zzb.zzak) {
                Map map3 = this.zzy;
                Iterator it2 = map3.keySet().iterator();
                while (it2.hasNext()) {
                    if (!((Boolean) map3.get((String) it2.next())).booleanValue()) {
                    }
                }
                if (!z) {
                    zzac(view, map, map2);
                    return;
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzee)).booleanValue()) {
                    it = map.entrySet().iterator();
                    while (it.hasNext()) {
                        view2 = (View) ((WeakReference) ((Map.Entry) it.next()).getValue()).get();
                        if (view2 == null) {
                        }
                    }
                }
            } else {
                if (!z) {
                    zzac(view, map, map2);
                    return;
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzee)).booleanValue() && map != null) {
                    it = map.entrySet().iterator();
                    while (it.hasNext()) {
                        view2 = (View) ((WeakReference) ((Map.Entry) it.next()).getValue()).get();
                        if (view2 == null && zzY(view2)) {
                            zzac(view, map, map2);
                            return;
                        }
                    }
                }
            }
        }
    }

    public final synchronized void zzC(com.google.android.gms.ads.internal.client.zzdg zzdgVar) {
        this.zzf.zzl(zzdgVar);
    }

    public final synchronized void zzD(View view, View view2, Map map, Map map2, boolean z) {
        zzcel zzcelVarZzs;
        this.zzg.zzc(this.zzo);
        this.zzf.zzm(view, view2, map, map2, z, zzaa());
        if (this.zzr) {
            zzdhq zzdhqVar = this.zze;
            if (zzdhqVar.zzs() != null && (zzcelVarZzs = zzdhqVar.zzs()) != null) {
                zzcelVarZzs.zzd("onSdkAdUserInteractionClick", new ArrayMap());
            }
        }
    }

    public final synchronized void zzE(final View view, final int i) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzlE)).booleanValue()) {
            zzdjo zzdjoVar = this.zzo;
            if (zzdjoVar == null) {
                int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zze("Ad should be associated with an ad view before calling performClickForCustomGesture()");
            } else {
                final boolean z = zzdjoVar instanceof zzdik;
                this.zzd.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdhf
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzdhl.zzu(this.zza, view, z, i);
                    }
                });
            }
        }
    }

    public final synchronized void zzF(String str) {
        this.zzf.zzn(str);
    }

    public final synchronized void zzG(Bundle bundle) {
        this.zzf.zzo(bundle);
    }

    public final synchronized void zzH() {
        zzdjo zzdjoVar = this.zzo;
        if (zzdjoVar == null) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zze("Ad should be associated with an ad view before calling recordCustomClickGesture()");
        } else {
            final boolean z = zzdjoVar instanceof zzdik;
            this.zzd.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdhh
                @Override // java.lang.Runnable
                public final void run() {
                    zzdhl.zzs(this.zza, z);
                }
            });
        }
    }

    public final void zzI(Bundle bundle) {
        final zzcel zzcelVarZzs = this.zze.zzs();
        if (zzcelVarZzs == null) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Video webview is null");
            return;
        }
        try {
            final JSONObject jSONObject = new JSONObject();
            for (String str : bundle.keySet()) {
                jSONObject.put(str, bundle.get(str));
            }
            this.zzd.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdhe
                @Override // java.lang.Runnable
                public final void run() {
                    int i2 = zzdhl.zzc;
                    zzcelVarZzs.zze("onVideoEvent", jSONObject);
                }
            });
        } catch (JSONException e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Error reading event signals", e);
        }
    }

    public final synchronized void zzJ() {
        if (this.zzq) {
            return;
        }
        this.zzf.zzt();
    }

    public final void zzK(View view) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzft)).booleanValue()) {
            zzdhq zzdhqVar = this.zze;
            if (zzdhqVar.zzc() != 3) {
                zzbzp zzbzpVarZzp = zzdhqVar.zzp();
                if (zzbzpVarZzp == null) {
                    return;
                }
                zzgbs.zzr(zzbzpVarZzp, new zzdhk(this, view), this.zzd);
                return;
            }
        }
        zzad(view, this.zze.zzu());
    }

    public final synchronized void zzL(View view, MotionEvent motionEvent, View view2) {
        this.zzf.zzu(view, motionEvent, view2);
    }

    public final synchronized void zzM(Bundle bundle) {
        this.zzf.zzv(bundle);
    }

    public final synchronized void zzN(View view) {
        this.zzf.zzw(view);
    }

    public final synchronized void zzO() {
        this.zzf.zzx();
    }

    public final synchronized void zzP(com.google.android.gms.ads.internal.client.zzdc zzdcVar) {
        this.zzf.zzy(zzdcVar);
    }

    public final synchronized void zzQ(com.google.android.gms.ads.internal.client.zzdq zzdqVar) {
        this.zzx.zza(zzdqVar);
    }

    public final synchronized void zzR(zzbhk zzbhkVar) {
        this.zzf.zzz(zzbhkVar);
    }

    public final synchronized void zzS(final zzdjo zzdjoVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzbU)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdha
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzae(zzdjoVar);
                }
            });
        } else {
            zzae(zzdjoVar);
        }
    }

    public final synchronized void zzT(final zzdjo zzdjoVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzbU)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdhb
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzaf(zzdjoVar);
                }
            });
        } else {
            zzaf(zzdjoVar);
        }
    }

    public final boolean zzU() {
        return this.zzh.zze();
    }

    public final synchronized boolean zzV() {
        return this.zzf.zzC();
    }

    public final synchronized boolean zzW() {
        return this.zzf.zzD();
    }

    public final boolean zzX() {
        return this.zzh.zzd();
    }

    public final synchronized boolean zzZ(Bundle bundle) {
        if (this.zzq) {
            return true;
        }
        boolean zZzE = this.zzf.zzE(bundle);
        this.zzq = zZzE;
        return zZzE;
    }

    public final synchronized int zza() {
        return this.zzf.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzcqg
    public final synchronized void zzb() {
        this.zzp = true;
        this.zzd.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdhg
            @Override // java.lang.Runnable
            public final void run() {
                zzdhl.zzv(this.zza);
            }
        });
        super.zzb();
    }

    public final zzdhn zzc() {
        return this.zzw;
    }

    public final zzeca zzf(String str, boolean z) {
        boolean z2;
        String str2;
        zzebw zzebwVar;
        zzebx zzebxVar;
        String str3;
        zzdhv zzdhvVar = this.zzh;
        if (zzdhvVar.zzd() && !TextUtils.isEmpty(str)) {
            zzdhq zzdhqVar = this.zze;
            zzcel zzcelVarZzr = zzdhqVar.zzr();
            zzcel zzcelVarZzs = zzdhqVar.zzs();
            if (zzcelVarZzr == null && zzcelVarZzs == null) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Omid display and video webview are null. Skipping initialization.");
                return null;
            }
            zzdhvVar.zza();
            int iZzc = zzdhvVar.zza().zzc();
            int i2 = iZzc - 1;
            boolean z3 = false;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (iZzc != 1) {
                        str3 = iZzc != 2 ? "UNKNOWN" : "DISPLAY";
                    } else {
                        str3 = ShareConstants.VIDEO_URL;
                    }
                    int i3 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Unknown omid media type: " + str3 + ". Not initializing Omid.");
                    return null;
                }
                if (zzcelVarZzr == null) {
                    int i4 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Omid media type was display but there was no display webview.");
                    return null;
                }
                z2 = false;
                z3 = true;
            } else if (zzcelVarZzs != null) {
                z2 = true;
            } else {
                int i5 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Omid media type was video but there was no video webview.");
            }
            if (z3) {
                str2 = null;
            } else {
                str2 = "javascript";
                zzcelVarZzr = zzcelVarZzs;
            }
            if (zzcelVarZzr == null) {
                int i6 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Webview is null in InternalNativeAd");
                return null;
            }
            if (!com.google.android.gms.ads.internal.zzv.zzB().zzl(this.zzv)) {
                int i7 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to initialize omid in InternalNativeAd");
                return null;
            }
            VersionInfoParcel versionInfoParcel = this.zzu;
            String str4 = versionInfoParcel.buddyApkVersion + "." + versionInfoParcel.clientJarVersion;
            if (z2) {
                zzebwVar = zzebw.VIDEO;
                zzebxVar = zzebx.DEFINED_BY_JAVASCRIPT;
            } else {
                zzebwVar = zzebw.NATIVE_DISPLAY;
                zzebxVar = zzdhqVar.zzc() == 3 ? zzebx.UNSPECIFIED : zzebx.ONE_PIXEL;
            }
            zzeca zzecaVarZzb = com.google.android.gms.ads.internal.zzv.zzB().zzb(str4, zzcelVarZzr.zzG(), "", "javascript", str2, str, zzebxVar, zzebwVar, this.zzb.zzal);
            if (zzecaVarZzb == null) {
                int i8 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to create omid session in InternalNativeAd");
                return null;
            }
            zzdhqVar.zzW(zzecaVarZzb);
            zzcelVarZzr.zzat(zzecaVarZzb);
            if (z2) {
                zzfjv zzfjvVarZza = zzecaVarZzb.zza();
                if (zzcelVarZzs != null) {
                    com.google.android.gms.ads.internal.zzv.zzB().zzj(zzfjvVarZza, zzcelVarZzs.zzF());
                }
                this.zzr = true;
            }
            if (z) {
                com.google.android.gms.ads.internal.zzv.zzB().zzk(zzecaVarZzb.zza());
                zzcelVarZzr.zzd("onSdkLoaded", new ArrayMap());
            }
            return zzecaVarZzb;
        }
        return null;
    }

    public final String zzg() {
        return this.zzh.zzb();
    }

    public final synchronized JSONObject zzi(View view, Map map, Map map2) {
        return this.zzf.zzf(view, map, map2, zzaa());
    }

    public final synchronized JSONObject zzj(View view, Map map, Map map2) {
        return this.zzf.zzg(view, map, map2, zzaa());
    }

    @Override // com.google.android.gms.internal.ads.zzcqg
    public final void zzk() {
        Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzdhc
            @Override // java.lang.Runnable
            public final void run() {
                zzdhl.zzt(this.zza);
            }
        };
        Executor executor = this.zzd;
        executor.execute(runnable);
        if (this.zze.zzc() != 7) {
            final zzdhy zzdhyVar = this.zzf;
            Objects.requireNonNull(zzdhyVar);
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdhd
                @Override // java.lang.Runnable
                public final void run() {
                    zzdhyVar.zzr();
                }
            });
        }
        super.zzk();
    }

    public final void zzz(View view) {
        zzeca zzecaVarZzu = this.zze.zzu();
        if (!this.zzh.zzd() || zzecaVarZzu == null || view == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzv.zzB().zzg(zzecaVarZzu.zza(), view);
    }

    public static /* synthetic */ void zzt(zzdhl zzdhlVar) {
        try {
            zzdhq zzdhqVar = zzdhlVar.zze;
            int iZzc = zzdhqVar.zzc();
            if (iZzc == 1) {
                zzbgu zzbguVarZzb = zzdhlVar.zzi.zzb();
                if (zzbguVarZzb != null) {
                    zzdhlVar.zzab("Google", true);
                    zzbguVarZzb.zze((zzbgk) zzdhlVar.zzj.zzb());
                    return;
                }
                return;
            }
            if (iZzc == 2) {
                zzbgr zzbgrVarZza = zzdhlVar.zzi.zza();
                if (zzbgrVarZza != null) {
                    zzdhlVar.zzab("Google", true);
                    zzbgrVarZza.zze((zzbgi) zzdhlVar.zzk.zzb());
                    return;
                }
                return;
            }
            if (iZzc == 3) {
                zzbha zzbhaVarZzd = zzdhlVar.zzi.zzd(zzdhqVar.zzA());
                if (zzbhaVarZzd != null) {
                    if (zzdhqVar.zzs() != null) {
                        zzdhlVar.zzf("Google", true);
                    }
                    zzbhaVarZzd.zze((zzbgn) zzdhlVar.zzn.zzb());
                    return;
                }
                return;
            }
            if (iZzc == 6) {
                zzbhh zzbhhVarZzf = zzdhlVar.zzi.zzf();
                if (zzbhhVarZzf != null) {
                    zzdhlVar.zzab("Google", true);
                    zzbhhVarZzf.zze((zzbhn) zzdhlVar.zzl.zzb());
                    return;
                }
                return;
            }
            if (iZzc != 7) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Wrong native template id!");
            } else {
                zzbmc zzbmcVarZzg = zzdhlVar.zzi.zzg();
                if (zzbmcVarZzg != null) {
                    zzbmcVarZzg.zzg((zzblw) zzdhlVar.zzm.zzb());
                }
            }
        } catch (RemoteException e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("RemoteException when notifyAdLoad is called", e);
        }
    }
}
