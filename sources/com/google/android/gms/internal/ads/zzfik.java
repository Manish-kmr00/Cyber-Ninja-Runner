package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzfik {
    private final zzefu zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final Context zze;
    private final zzfbh zzf;
    private final zzfbi zzg;
    private final Clock zzh;
    private final zzauy zzi;

    public zzfik(zzefu zzefuVar, VersionInfoParcel versionInfoParcel, String str, String str2, Context context, zzfbh zzfbhVar, zzfbi zzfbiVar, Clock clock, zzauy zzauyVar) {
        this.zza = zzefuVar;
        this.zzb = versionInfoParcel.afmaVersion;
        this.zzc = str;
        this.zzd = str2;
        this.zze = context;
        this.zzf = zzfbhVar;
        this.zzg = zzfbiVar;
        this.zzh = clock;
        this.zzi = zzauyVar;
    }

    public static String zzc(String str, String str2, String str3) {
        if (true == TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        return str.replaceAll(str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String zzg(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return com.google.android.gms.ads.internal.util.client.zzl.zzk() ? "fakeForAdDebugLog" : str;
    }

    public final List zzd(zzfbg zzfbgVar, zzfau zzfauVar, List list) {
        return zze(zzfbgVar, zzfauVar, false, "", "", list);
    }

    public final List zze(zzfbg zzfbgVar, zzfau zzfauVar, boolean z, String str, String str2, List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            boolean z2 = true;
            String strZzc = zzc(zzc(zzc((String) it.next(), "@gw_adlocid@", zzfbgVar.zza.zza.zzf), "@gw_adnetrefresh@", true != z ? "0" : "1"), "@gw_sdkver@", this.zzb);
            if (zzfauVar != null) {
                String strZzc2 = zzc(zzc(zzc(strZzc, "@gw_qdata@", zzfauVar.zzy), "@gw_adnetid@", zzfauVar.zzx), "@gw_allocid@", zzfauVar.zzw);
                Context context = this.zze;
                strZzc = zzbxy.zzc(strZzc2, context, zzfauVar.zzW, zzfauVar.zzaw);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zznp)).booleanValue() && zzfauVar.zze == 4) {
                    com.google.android.gms.ads.internal.zzv.zzq();
                    strZzc = zzc(strZzc, "@gw_aps@", true == com.google.android.gms.ads.internal.util.zzs.zzH(context) ? "1" : "0");
                }
            }
            zzefu zzefuVar = this.zza;
            String strZzc3 = zzc(zzc(zzc(zzc(strZzc, "@gw_adnetstatus@", zzefuVar.zzg()), "@gw_ttr@", Long.toString(zzefuVar.zza(), 10)), "@gw_seqnum@", this.zzc), "@gw_sessid@", this.zzd);
            boolean z3 = false;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdL)).booleanValue() && !TextUtils.isEmpty(str)) {
                z3 = true;
            }
            boolean zIsEmpty = TextUtils.isEmpty(str2);
            boolean z4 = !zIsEmpty;
            if (z3) {
                z2 = z4;
            } else {
                if (!zIsEmpty) {
                }
                arrayList.add(strZzc3);
            }
            if (this.zzi.zzf(Uri.parse(strZzc3))) {
                Uri.Builder builderBuildUpon = Uri.parse(strZzc3).buildUpon();
                if (z3) {
                    builderBuildUpon = builderBuildUpon.appendQueryParameter("ms", str);
                }
                if (z2) {
                    builderBuildUpon = builderBuildUpon.appendQueryParameter("attok", str2);
                }
                strZzc3 = builderBuildUpon.build().toString();
            }
            arrayList.add(strZzc3);
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0065 A[LOOP:0: B:13:0x005f->B:15:0x0065, LOOP_END] */
    public final List zzf(zzfau zzfauVar, List list, zzbvk zzbvkVar) {
        zzfbh zzfbhVar;
        zzftu zzftuVarZzd;
        String str;
        String str2;
        Iterator it;
        ArrayList arrayList = new ArrayList();
        long jCurrentTimeMillis = this.zzh.currentTimeMillis();
        try {
            String strZzc = zzbvkVar.zzc();
            String string = Integer.toString(zzbvkVar.zzb());
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdM)).booleanValue()) {
                zzfbi zzfbiVar = this.zzg;
                if (zzfbiVar == null) {
                    zzftuVarZzd = zzftu.zzc();
                } else {
                    zzfbhVar = zzfbiVar.zza;
                }
                str = (String) zzftuVarZzd.zza(new zzftl() { // from class: com.google.android.gms.internal.ads.zzfii
                    @Override // com.google.android.gms.internal.ads.zzftl
                    public final Object apply(Object obj) {
                        return zzfik.zzg(((zzfbh) obj).zza);
                    }
                }).zzb("");
                str2 = (String) zzftuVarZzd.zza(new zzftl() { // from class: com.google.android.gms.internal.ads.zzfij
                    @Override // com.google.android.gms.internal.ads.zzftl
                    public final Object apply(Object obj) {
                        return zzfik.zzg(((zzfbh) obj).zzb);
                    }
                }).zzb("");
                it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(zzbxy.zzc(zzc(zzc(zzc(zzc(zzc(zzc((String) it.next(), "@gw_rwd_userid@", Uri.encode(str)), "@gw_rwd_custom_data@", Uri.encode(str2)), "@gw_tmstmp@", Long.toString(jCurrentTimeMillis)), "@gw_rwd_itm@", Uri.encode(strZzc)), "@gw_rwd_amt@", string), "@gw_sdkver@", this.zzb), this.zze, zzfauVar.zzW, zzfauVar.zzaw));
                }
                return arrayList;
            }
            zzfbhVar = this.zzf;
            zzftuVarZzd = zzftu.zzd(zzfbhVar);
            str = (String) zzftuVarZzd.zza(new zzftl() { // from class: com.google.android.gms.internal.ads.zzfii
                @Override // com.google.android.gms.internal.ads.zzftl
                public final Object apply(Object obj) {
                    return zzfik.zzg(((zzfbh) obj).zza);
                }
            }).zzb("");
            str2 = (String) zzftuVarZzd.zza(new zzftl() { // from class: com.google.android.gms.internal.ads.zzfij
                @Override // com.google.android.gms.internal.ads.zzftl
                public final Object apply(Object obj) {
                    return zzfik.zzg(((zzfbh) obj).zzb);
                }
            }).zzb("");
            it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(zzbxy.zzc(zzc(zzc(zzc(zzc(zzc(zzc((String) it.next(), "@gw_rwd_userid@", Uri.encode(str)), "@gw_rwd_custom_data@", Uri.encode(str2)), "@gw_tmstmp@", Long.toString(jCurrentTimeMillis)), "@gw_rwd_itm@", Uri.encode(strZzc)), "@gw_rwd_amt@", string), "@gw_sdkver@", this.zzb), this.zze, zzfauVar.zzW, zzfauVar.zzaw));
            }
            return arrayList;
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Unable to determine award type and amount.", e);
            return arrayList;
        }
    }
}
