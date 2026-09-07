package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes14.dex */
@ParametersAreNonnullByDefault
public final class zzdjt implements zzdhy {
    private final zzbpn zza;
    private final zzcvu zzb;
    private final zzcva zzc;
    private final zzdda zzd;
    private final Context zze;
    private final zzfau zzf;
    private final VersionInfoParcel zzg;
    private final zzfbp zzh;
    private boolean zzi = false;
    private boolean zzj = false;
    private boolean zzk = true;
    private final zzbpj zzl;
    private final zzbpk zzm;

    public zzdjt(zzbpj zzbpjVar, zzbpk zzbpkVar, zzbpn zzbpnVar, zzcvu zzcvuVar, zzcva zzcvaVar, zzdda zzddaVar, Context context, zzfau zzfauVar, VersionInfoParcel versionInfoParcel, zzfbp zzfbpVar) {
        this.zzl = zzbpjVar;
        this.zzm = zzbpkVar;
        this.zza = zzbpnVar;
        this.zzb = zzcvuVar;
        this.zzc = zzcvaVar;
        this.zzd = zzddaVar;
        this.zze = context;
        this.zzf = zzfauVar;
        this.zzg = versionInfoParcel;
        this.zzh = zzfbpVar;
    }

    private final void zzb(View view) {
        try {
            zzbpn zzbpnVar = this.zza;
            if (zzbpnVar != null && !zzbpnVar.zzA()) {
                zzbpnVar.zzw(ObjectWrapper.wrap(view));
                this.zzc.onAdClicked();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzkQ)).booleanValue()) {
                    this.zzd.zzdd();
                    return;
                }
                return;
            }
            zzbpj zzbpjVar = this.zzl;
            if (zzbpjVar != null && !zzbpjVar.zzx()) {
                zzbpjVar.zzs(ObjectWrapper.wrap(view));
                this.zzc.onAdClicked();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzkQ)).booleanValue()) {
                    this.zzd.zzdd();
                    return;
                }
                return;
            }
            zzbpk zzbpkVar = this.zzm;
            if (zzbpkVar == null || zzbpkVar.zzv()) {
                return;
            }
            zzbpkVar.zzq(ObjectWrapper.wrap(view));
            this.zzc.onAdClicked();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzkQ)).booleanValue()) {
                this.zzd.zzdd();
            }
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed to call handleClick", e);
        }
    }

    private static final HashMap zzc(Map map) {
        HashMap map2 = new HashMap();
        if (map != null) {
            synchronized (map) {
                for (Map.Entry entry : map.entrySet()) {
                    View view = (View) ((WeakReference) entry.getValue()).get();
                    if (view != null) {
                        map2.put((String) entry.getKey(), view);
                    }
                }
            }
        }
        return map2;
    }

    /* JADX WARN: Code duplicated, block: B:50:0x00cc A[Catch: JSONException -> 0x0044, RemoteException -> 0x011e, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0044, blocks: (B:47:0x00b1, B:48:0x00c6, B:50:0x00cc), top: B:72:0x00b1 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x005f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:87:0x0044 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x00c6 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzdhy
    public final void zzA(View view, Map map, Map map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        Object obj;
        ClassLoader classLoader;
        Iterator it;
        IObjectWrapper iObjectWrapperZzn;
        try {
            IObjectWrapper iObjectWrapperWrap = ObjectWrapper.wrap(view);
            JSONObject jSONObject = this.zzf.zzaj;
            boolean z = true;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzbJ)).booleanValue() && jSONObject.length() != 0) {
                Map map3 = map == null ? new HashMap() : map;
                Map map4 = map2 == null ? new HashMap() : map2;
                HashMap map5 = new HashMap();
                map5.putAll(map3);
                map5.putAll(map4);
                Iterator<String> itKeys = jSONObject.keys();
                loop0: while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(next);
                    if (jSONArrayOptJSONArray != null) {
                        WeakReference weakReference = (WeakReference) map5.get(next);
                        if (weakReference != null && (obj = weakReference.get()) != null) {
                            Class<?> cls = obj.getClass();
                            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzbK)).booleanValue() && next.equals("3010")) {
                                zzbpn zzbpnVar = this.zza;
                                Object objUnwrap = null;
                                if (zzbpnVar != null) {
                                    try {
                                        iObjectWrapperZzn = zzbpnVar.zzn();
                                    } catch (RemoteException | IllegalArgumentException unused) {
                                    }
                                } else {
                                    zzbpj zzbpjVar = this.zzl;
                                    if (zzbpjVar != null) {
                                        iObjectWrapperZzn = zzbpjVar.zzk();
                                    } else {
                                        zzbpk zzbpkVar = this.zzm;
                                        iObjectWrapperZzn = zzbpkVar != null ? zzbpkVar.zzj() : null;
                                    }
                                }
                                if (iObjectWrapperZzn != null) {
                                    objUnwrap = ObjectWrapper.unwrap(iObjectWrapperZzn);
                                }
                                if (objUnwrap != null) {
                                    cls = objUnwrap.getClass();
                                    ArrayList arrayList = new ArrayList();
                                    com.google.android.gms.ads.internal.util.zzbs.zzc(jSONArrayOptJSONArray, arrayList);
                                    com.google.android.gms.ads.internal.zzv.zzq();
                                    classLoader = this.zze.getClassLoader();
                                    it = arrayList.iterator();
                                    while (true) {
                                        if (it.hasNext()) {
                                            if (Class.forName((String) it.next(), false, classLoader).isAssignableFrom(cls)) {
                                            }
                                        }
                                    }
                                }
                            } else {
                                try {
                                    ArrayList arrayList2 = new ArrayList();
                                    com.google.android.gms.ads.internal.util.zzbs.zzc(jSONArrayOptJSONArray, arrayList2);
                                    com.google.android.gms.ads.internal.zzv.zzq();
                                    classLoader = this.zze.getClassLoader();
                                    it = arrayList2.iterator();
                                    while (true) {
                                        if (it.hasNext()) {
                                            if (Class.forName((String) it.next(), false, classLoader).isAssignableFrom(cls)) {
                                            }
                                        }
                                    }
                                } catch (JSONException unused2) {
                                    continue;
                                }
                            }
                        }
                        z = false;
                        break;
                    }
                }
            }
            this.zzk = z;
            HashMap mapZzc = zzc(map);
            HashMap mapZzc2 = zzc(map2);
            zzbpn zzbpnVar2 = this.zza;
            if (zzbpnVar2 != null) {
                zzbpnVar2.zzy(iObjectWrapperWrap, ObjectWrapper.wrap(mapZzc), ObjectWrapper.wrap(mapZzc2));
                return;
            }
            zzbpj zzbpjVar2 = this.zzl;
            if (zzbpjVar2 != null) {
                zzbpjVar2.zzv(iObjectWrapperWrap, ObjectWrapper.wrap(mapZzc), ObjectWrapper.wrap(mapZzc2));
                zzbpjVar2.zzu(iObjectWrapperWrap);
                return;
            }
            zzbpk zzbpkVar2 = this.zzm;
            if (zzbpkVar2 != null) {
                zzbpkVar2.zzt(iObjectWrapperWrap, ObjectWrapper.wrap(mapZzc), ObjectWrapper.wrap(mapZzc2));
                zzbpkVar2.zzs(iObjectWrapperWrap);
            }
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed to call trackView", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdhy
    public final void zzB(View view, Map map) {
        try {
            IObjectWrapper iObjectWrapperWrap = ObjectWrapper.wrap(view);
            zzbpn zzbpnVar = this.zza;
            if (zzbpnVar != null) {
                zzbpnVar.zzz(iObjectWrapperWrap);
                return;
            }
            zzbpj zzbpjVar = this.zzl;
            if (zzbpjVar != null) {
                zzbpjVar.zzw(iObjectWrapperWrap);
                return;
            }
            zzbpk zzbpkVar = this.zzm;
            if (zzbpkVar != null) {
                zzbpkVar.zzu(iObjectWrapperWrap);
            }
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed to call untrackView", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdhy
    public final boolean zzC() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdhy
    public final boolean zzD() {
        return this.zzf.zzL;
    }

    @Override // com.google.android.gms.internal.ads.zzdhy
    public final boolean zzE(Bundle bundle) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzdhy
    public final int zza() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdhy
    public final JSONObject zzf(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdhy
    public final JSONObject zzg(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdhy
    public final void zzi() {
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzdhy
    public final void zzj() {
    }

    @Override // com.google.android.gms.internal.ads.zzdhy
    public final void zzk() {
    }

    @Override // com.google.android.gms.internal.ads.zzdhy
    public final void zzl(com.google.android.gms.ads.internal.client.zzdg zzdgVar) {
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzdhy
    public final void zzm(View view, View view2, Map map, Map map2, boolean z, ImageView.ScaleType scaleType) {
        if (this.zzj && this.zzf.zzL) {
            return;
        }
        zzb(view);
    }

    @Override // com.google.android.gms.internal.ads.zzdhy
    public final void zzn(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzdhy
    public final void zzo(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzdhy
    public final void zzq(View view, View view2, Map map, Map map2, boolean z, ImageView.ScaleType scaleType, int i) {
        if (!this.zzj) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Custom click reporting for 3p ads failed. enableCustomClickGesture is not set.");
        } else if (this.zzf.zzL) {
            zzb(view2);
        } else {
            int i3 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Custom click reporting for 3p ads failed. Ad unit id not in allow list.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdhy
    public final void zzr() {
    }

    @Override // com.google.android.gms.internal.ads.zzdhy
    public final void zzs(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
        try {
            if (!this.zzi) {
                this.zzi = com.google.android.gms.ads.internal.zzv.zzt().zzn(this.zze, this.zzg.afmaVersion, this.zzf.zzC.toString(), this.zzh.zzf);
            }
            if (this.zzk) {
                zzbpn zzbpnVar = this.zza;
                if (zzbpnVar != null && !zzbpnVar.zzB()) {
                    zzbpnVar.zzx();
                    this.zzb.zza();
                    return;
                }
                zzbpj zzbpjVar = this.zzl;
                if (zzbpjVar != null && !zzbpjVar.zzy()) {
                    zzbpjVar.zzt();
                    this.zzb.zza();
                    return;
                }
                zzbpk zzbpkVar = this.zzm;
                if (zzbpkVar == null || zzbpkVar.zzw()) {
                    return;
                }
                zzbpkVar.zzr();
                this.zzb.zza();
            }
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed to call recordImpression", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdhy
    public final void zzt() {
    }

    @Override // com.google.android.gms.internal.ads.zzdhy
    public final void zzu(View view, MotionEvent motionEvent, View view2) {
    }

    @Override // com.google.android.gms.internal.ads.zzdhy
    public final void zzv(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzdhy
    public final void zzw(View view) {
    }

    @Override // com.google.android.gms.internal.ads.zzdhy
    public final void zzx() {
        this.zzj = true;
    }

    @Override // com.google.android.gms.internal.ads.zzdhy
    public final void zzy(com.google.android.gms.ads.internal.client.zzdc zzdcVar) {
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzdhy
    public final void zzz(zzbhk zzbhkVar) {
    }
}
