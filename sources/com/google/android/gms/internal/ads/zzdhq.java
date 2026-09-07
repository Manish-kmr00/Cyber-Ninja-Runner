package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import com.json.b9;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdhq {
    private int zza;
    private com.google.android.gms.ads.internal.client.zzea zzb;
    private zzbfm zzc;
    private View zzd;
    private List zze;
    private com.google.android.gms.ads.internal.client.zzev zzg;
    private Bundle zzh;
    private zzcel zzi;
    private zzcel zzj;
    private zzcel zzk;
    private zzeca zzl;
    private ListenableFuture zzm;
    private zzbzp zzn;
    private View zzo;
    private View zzp;
    private IObjectWrapper zzq;
    private double zzr;
    private zzbft zzs;
    private zzbft zzt;
    private String zzu;
    private float zzx;
    private String zzy;
    private final SimpleArrayMap zzv = new SimpleArrayMap();
    private final SimpleArrayMap zzw = new SimpleArrayMap();
    private List zzf = Collections.emptyList();

    public static zzdhq zzag(zzbpj zzbpjVar) {
        try {
            zzdhp zzdhpVarZzak = zzak(zzbpjVar.zzg(), null);
            zzbfm zzbfmVarZzh = zzbpjVar.zzh();
            View view = (View) zzam(zzbpjVar.zzj());
            String strZzo = zzbpjVar.zzo();
            List listZzr = zzbpjVar.zzr();
            String strZzm = zzbpjVar.zzm();
            Bundle bundleZzf = zzbpjVar.zzf();
            String strZzn = zzbpjVar.zzn();
            View view2 = (View) zzam(zzbpjVar.zzk());
            IObjectWrapper iObjectWrapperZzl = zzbpjVar.zzl();
            String strZzq = zzbpjVar.zzq();
            String strZzp = zzbpjVar.zzp();
            double dZze = zzbpjVar.zze();
            zzbft zzbftVarZzi = zzbpjVar.zzi();
            zzdhq zzdhqVar = new zzdhq();
            zzdhqVar.zza = 2;
            zzdhqVar.zzb = zzdhpVarZzak;
            zzdhqVar.zzc = zzbfmVarZzh;
            zzdhqVar.zzd = view;
            zzdhqVar.zzZ("headline", strZzo);
            zzdhqVar.zze = listZzr;
            zzdhqVar.zzZ("body", strZzm);
            zzdhqVar.zzh = bundleZzf;
            zzdhqVar.zzZ("call_to_action", strZzn);
            zzdhqVar.zzo = view2;
            zzdhqVar.zzq = iObjectWrapperZzl;
            zzdhqVar.zzZ(b9.h.U, strZzq);
            zzdhqVar.zzZ("price", strZzp);
            zzdhqVar.zzr = dZze;
            zzdhqVar.zzs = zzbftVarZzi;
            return zzdhqVar;
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed to get native ad from app install ad mapper", e);
            return null;
        }
    }

    public static zzdhq zzah(zzbpk zzbpkVar) {
        try {
            zzdhp zzdhpVarZzak = zzak(zzbpkVar.zzf(), null);
            zzbfm zzbfmVarZzg = zzbpkVar.zzg();
            View view = (View) zzam(zzbpkVar.zzi());
            String strZzo = zzbpkVar.zzo();
            List listZzp = zzbpkVar.zzp();
            String strZzm = zzbpkVar.zzm();
            Bundle bundleZze = zzbpkVar.zze();
            String strZzn = zzbpkVar.zzn();
            View view2 = (View) zzam(zzbpkVar.zzj());
            IObjectWrapper iObjectWrapperZzk = zzbpkVar.zzk();
            String strZzl = zzbpkVar.zzl();
            zzbft zzbftVarZzh = zzbpkVar.zzh();
            zzdhq zzdhqVar = new zzdhq();
            zzdhqVar.zza = 1;
            zzdhqVar.zzb = zzdhpVarZzak;
            zzdhqVar.zzc = zzbfmVarZzg;
            zzdhqVar.zzd = view;
            zzdhqVar.zzZ("headline", strZzo);
            zzdhqVar.zze = listZzp;
            zzdhqVar.zzZ("body", strZzm);
            zzdhqVar.zzh = bundleZze;
            zzdhqVar.zzZ("call_to_action", strZzn);
            zzdhqVar.zzo = view2;
            zzdhqVar.zzq = iObjectWrapperZzk;
            zzdhqVar.zzZ(b9.h.F0, strZzl);
            zzdhqVar.zzt = zzbftVarZzh;
            return zzdhqVar;
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed to get native ad from content ad mapper", e);
            return null;
        }
    }

    public static zzdhq zzai(zzbpj zzbpjVar) {
        try {
            return zzal(zzak(zzbpjVar.zzg(), null), zzbpjVar.zzh(), (View) zzam(zzbpjVar.zzj()), zzbpjVar.zzo(), zzbpjVar.zzr(), zzbpjVar.zzm(), zzbpjVar.zzf(), zzbpjVar.zzn(), (View) zzam(zzbpjVar.zzk()), zzbpjVar.zzl(), zzbpjVar.zzq(), zzbpjVar.zzp(), zzbpjVar.zze(), zzbpjVar.zzi(), null, 0.0f);
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed to get native ad assets from app install ad mapper", e);
            return null;
        }
    }

    public static zzdhq zzaj(zzbpk zzbpkVar) {
        try {
            return zzal(zzak(zzbpkVar.zzf(), null), zzbpkVar.zzg(), (View) zzam(zzbpkVar.zzi()), zzbpkVar.zzo(), zzbpkVar.zzp(), zzbpkVar.zzm(), zzbpkVar.zze(), zzbpkVar.zzn(), (View) zzam(zzbpkVar.zzj()), zzbpkVar.zzk(), null, null, -1.0d, zzbpkVar.zzh(), zzbpkVar.zzl(), 0.0f);
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed to get native ad assets from content ad mapper", e);
            return null;
        }
    }

    private static zzdhp zzak(com.google.android.gms.ads.internal.client.zzea zzeaVar, zzbpn zzbpnVar) {
        if (zzeaVar == null) {
            return null;
        }
        return new zzdhp(zzeaVar, zzbpnVar);
    }

    private static zzdhq zzal(com.google.android.gms.ads.internal.client.zzea zzeaVar, zzbfm zzbfmVar, View view, String str, List list, String str2, Bundle bundle, String str3, View view2, IObjectWrapper iObjectWrapper, String str4, String str5, double d, zzbft zzbftVar, String str6, float f) {
        zzdhq zzdhqVar = new zzdhq();
        zzdhqVar.zza = 6;
        zzdhqVar.zzb = zzeaVar;
        zzdhqVar.zzc = zzbfmVar;
        zzdhqVar.zzd = view;
        zzdhqVar.zzZ("headline", str);
        zzdhqVar.zze = list;
        zzdhqVar.zzZ("body", str2);
        zzdhqVar.zzh = bundle;
        zzdhqVar.zzZ("call_to_action", str3);
        zzdhqVar.zzo = view2;
        zzdhqVar.zzq = iObjectWrapper;
        zzdhqVar.zzZ(b9.h.U, str4);
        zzdhqVar.zzZ("price", str5);
        zzdhqVar.zzr = d;
        zzdhqVar.zzs = zzbftVar;
        zzdhqVar.zzZ(b9.h.F0, str6);
        zzdhqVar.zzR(f);
        return zzdhqVar;
    }

    private static Object zzam(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null) {
            return null;
        }
        return ObjectWrapper.unwrap(iObjectWrapper);
    }

    public static zzdhq zzt(zzbpn zzbpnVar) {
        try {
            return zzal(zzak(zzbpnVar.zzj(), zzbpnVar), zzbpnVar.zzk(), (View) zzam(zzbpnVar.zzm()), zzbpnVar.zzs(), zzbpnVar.zzv(), zzbpnVar.zzq(), zzbpnVar.zzi(), zzbpnVar.zzr(), (View) zzam(zzbpnVar.zzn()), zzbpnVar.zzo(), zzbpnVar.zzu(), zzbpnVar.zzt(), zzbpnVar.zze(), zzbpnVar.zzl(), zzbpnVar.zzp(), zzbpnVar.zzf());
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed to get native ad assets from unified ad mapper", e);
            return null;
        }
    }

    public final synchronized String zzA() {
        return this.zzu;
    }

    public final synchronized String zzB() {
        return zzF("headline");
    }

    public final synchronized String zzC() {
        return this.zzy;
    }

    public final synchronized String zzD() {
        return zzF("price");
    }

    public final synchronized String zzE() {
        return zzF(b9.h.U);
    }

    public final synchronized String zzF(String str) {
        return (String) this.zzw.get(str);
    }

    public final synchronized List zzG() {
        return this.zze;
    }

    public final synchronized List zzH() {
        return this.zzf;
    }

    public final synchronized void zzI() {
        zzcel zzcelVar = this.zzi;
        if (zzcelVar != null) {
            zzcelVar.destroy();
            this.zzi = null;
        }
        zzcel zzcelVar2 = this.zzj;
        if (zzcelVar2 != null) {
            zzcelVar2.destroy();
            this.zzj = null;
        }
        zzcel zzcelVar3 = this.zzk;
        if (zzcelVar3 != null) {
            zzcelVar3.destroy();
            this.zzk = null;
        }
        ListenableFuture listenableFuture = this.zzm;
        if (listenableFuture != null) {
            listenableFuture.cancel(false);
            this.zzm = null;
        }
        zzbzp zzbzpVar = this.zzn;
        if (zzbzpVar != null) {
            zzbzpVar.cancel(false);
            this.zzn = null;
        }
        this.zzl = null;
        this.zzv.clear();
        this.zzw.clear();
        this.zzb = null;
        this.zzc = null;
        this.zzd = null;
        this.zze = null;
        this.zzh = null;
        this.zzo = null;
        this.zzp = null;
        this.zzq = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
    }

    public final synchronized void zzJ(zzbfm zzbfmVar) {
        this.zzc = zzbfmVar;
    }

    public final synchronized void zzK(String str) {
        this.zzu = str;
    }

    public final synchronized void zzL(com.google.android.gms.ads.internal.client.zzev zzevVar) {
        this.zzg = zzevVar;
    }

    public final synchronized void zzM(zzbft zzbftVar) {
        this.zzs = zzbftVar;
    }

    public final synchronized void zzN(String str, zzbfg zzbfgVar) {
        try {
            if (zzbfgVar == null) {
                this.zzv.remove(str);
            } else {
                this.zzv.put(str, zzbfgVar);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzO(zzcel zzcelVar) {
        this.zzj = zzcelVar;
    }

    public final synchronized void zzP(List list) {
        this.zze = list;
    }

    public final synchronized void zzQ(zzbft zzbftVar) {
        this.zzt = zzbftVar;
    }

    public final synchronized void zzR(float f) {
        this.zzx = f;
    }

    public final synchronized void zzS(List list) {
        this.zzf = list;
    }

    public final synchronized void zzT(zzcel zzcelVar) {
        this.zzk = zzcelVar;
    }

    public final synchronized void zzU(ListenableFuture listenableFuture) {
        this.zzm = listenableFuture;
    }

    public final synchronized void zzV(String str) {
        this.zzy = str;
    }

    public final synchronized void zzW(zzeca zzecaVar) {
        this.zzl = zzecaVar;
    }

    public final synchronized void zzX(zzbzp zzbzpVar) {
        this.zzn = zzbzpVar;
    }

    public final synchronized void zzY(double d) {
        this.zzr = d;
    }

    public final synchronized void zzZ(String str, String str2) {
        try {
            if (str2 == null) {
                this.zzw.remove(str);
            } else {
                this.zzw.put(str, str2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized double zza() {
        return this.zzr;
    }

    public final synchronized void zzaa(int i) {
        this.zza = i;
    }

    public final synchronized void zzab(com.google.android.gms.ads.internal.client.zzea zzeaVar) {
        this.zzb = zzeaVar;
    }

    public final synchronized void zzac(View view) {
        this.zzo = view;
    }

    public final synchronized void zzad(zzcel zzcelVar) {
        this.zzi = zzcelVar;
    }

    public final synchronized void zzae(View view) {
        this.zzp = view;
    }

    public final synchronized boolean zzaf() {
        return this.zzj != null;
    }

    public final synchronized float zzb() {
        return this.zzx;
    }

    public final synchronized int zzc() {
        return this.zza;
    }

    public final synchronized Bundle zzd() {
        if (this.zzh == null) {
            this.zzh = new Bundle();
        }
        return this.zzh;
    }

    public final synchronized View zze() {
        return this.zzd;
    }

    public final synchronized View zzf() {
        return this.zzo;
    }

    public final synchronized View zzg() {
        return this.zzp;
    }

    public final synchronized SimpleArrayMap zzh() {
        return this.zzv;
    }

    public final synchronized SimpleArrayMap zzi() {
        return this.zzw;
    }

    public final synchronized com.google.android.gms.ads.internal.client.zzea zzj() {
        return this.zzb;
    }

    public final synchronized com.google.android.gms.ads.internal.client.zzev zzk() {
        return this.zzg;
    }

    public final synchronized zzbfm zzl() {
        return this.zzc;
    }

    public final zzbft zzm() {
        List list = this.zze;
        if (list == null || list.isEmpty()) {
            return null;
        }
        Object obj = this.zze.get(0);
        if (obj instanceof IBinder) {
            return zzbfs.zzg((IBinder) obj);
        }
        return null;
    }

    public final synchronized zzbft zzn() {
        return this.zzs;
    }

    public final synchronized zzbft zzo() {
        return this.zzt;
    }

    public final synchronized zzbzp zzp() {
        return this.zzn;
    }

    public final synchronized zzcel zzq() {
        return this.zzj;
    }

    public final synchronized zzcel zzr() {
        return this.zzk;
    }

    public final synchronized zzcel zzs() {
        return this.zzi;
    }

    public final synchronized zzeca zzu() {
        return this.zzl;
    }

    public final synchronized IObjectWrapper zzv() {
        return this.zzq;
    }

    public final synchronized ListenableFuture zzw() {
        return this.zzm;
    }

    public final synchronized String zzx() {
        return zzF(b9.h.F0);
    }

    public final synchronized String zzy() {
        return zzF("body");
    }

    public final synchronized String zzz() {
        return zzF("call_to_action");
    }
}
