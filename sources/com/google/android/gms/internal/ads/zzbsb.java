package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbsb extends zzbsc implements zzbjj {
    DisplayMetrics zza;
    int zzb;
    int zzc;
    int zzd;
    int zze;
    int zzf;
    int zzg;
    private final zzcel zzh;
    private final Context zzi;
    private final WindowManager zzj;
    private final zzbbq zzk;
    private float zzl;
    private int zzm;

    public zzbsb(zzcel zzcelVar, Context context, zzbbq zzbbqVar) {
        super(zzcelVar, "");
        this.zzb = -1;
        this.zzc = -1;
        this.zzd = -1;
        this.zze = -1;
        this.zzf = -1;
        this.zzg = -1;
        this.zzh = zzcelVar;
        this.zzi = context;
        this.zzk = zzbbqVar;
        this.zzj = (WindowManager) context.getSystemService("window");
    }

    @Override // com.google.android.gms.internal.ads.zzbjj
    public final /* synthetic */ void zza(Object obj, Map map) {
        JSONObject jSONObjectPut;
        this.zza = new DisplayMetrics();
        Display defaultDisplay = this.zzj.getDefaultDisplay();
        defaultDisplay.getMetrics(this.zza);
        this.zzl = this.zza.density;
        this.zzm = defaultDisplay.getRotation();
        com.google.android.gms.ads.internal.client.zzbb.zzb();
        DisplayMetrics displayMetrics = this.zza;
        this.zzb = com.google.android.gms.ads.internal.util.client.zzf.zzw(displayMetrics, displayMetrics.widthPixels);
        com.google.android.gms.ads.internal.client.zzbb.zzb();
        DisplayMetrics displayMetrics2 = this.zza;
        this.zzc = com.google.android.gms.ads.internal.util.client.zzf.zzw(displayMetrics2, displayMetrics2.heightPixels);
        zzcel zzcelVar = this.zzh;
        Activity activityZzi = zzcelVar.zzi();
        if (activityZzi == null || activityZzi.getWindow() == null) {
            this.zzd = this.zzb;
            this.zze = this.zzc;
        } else {
            com.google.android.gms.ads.internal.zzv.zzq();
            int[] iArrZzR = com.google.android.gms.ads.internal.util.zzs.zzR(activityZzi);
            com.google.android.gms.ads.internal.client.zzbb.zzb();
            this.zzd = com.google.android.gms.ads.internal.util.client.zzf.zzw(this.zza, iArrZzR[0]);
            com.google.android.gms.ads.internal.client.zzbb.zzb();
            this.zze = com.google.android.gms.ads.internal.util.client.zzf.zzw(this.zza, iArrZzR[1]);
        }
        if (zzcelVar.zzO().zzi()) {
            this.zzf = this.zzb;
            this.zzg = this.zzc;
        } else {
            zzcelVar.measure(0, 0);
        }
        zzj(this.zzb, this.zzc, this.zzd, this.zze, this.zzl, this.zzm);
        zzbsa zzbsaVar = new zzbsa();
        zzbbq zzbbqVar = this.zzk;
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        zzbsaVar.zze(zzbbqVar.zza(intent));
        Intent intent2 = new Intent("android.intent.action.VIEW");
        intent2.setData(Uri.parse("sms:"));
        zzbsaVar.zzc(zzbbqVar.zza(intent2));
        zzbsaVar.zza(zzbbqVar.zzb());
        zzbsaVar.zzd(zzbbqVar.zzc());
        zzbsaVar.zzb(true);
        boolean z = zzbsaVar.zza;
        boolean z2 = zzbsaVar.zzb;
        boolean z3 = zzbsaVar.zzc;
        boolean z4 = zzbsaVar.zzd;
        try {
            jSONObjectPut = new JSONObject().put("sms", z).put("tel", z2).put("calendar", z3).put("storePicture", z4).put("inlineVideo", zzbsaVar.zze);
        } catch (JSONException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Error occurred while obtaining the MRAID capabilities.", e);
            jSONObjectPut = null;
        }
        zzcelVar.zze("onDeviceFeaturesReceived", jSONObjectPut);
        int[] iArr = new int[2];
        zzcelVar.getLocationOnScreen(iArr);
        Context context = this.zzi;
        zzb(com.google.android.gms.ads.internal.client.zzbb.zzb().zzb(context, iArr[0]), com.google.android.gms.ads.internal.client.zzbb.zzb().zzb(context, iArr[1]));
        if (com.google.android.gms.ads.internal.util.zze.zzm(2)) {
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Dispatching Ready Event.");
        }
        zzi(zzcelVar.zzm().afmaVersion);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0060 A[PHI: r4
  0x0060: PHI (r4v2 int) = (r4v1 int), (r4v6 int) binds: [B:11:0x003f, B:17:0x0051] A[DONT_GENERATE, DONT_INLINE]] */
    public final void zzb(int i, int i2) {
        int i3;
        Context context = this.zzi;
        int i4 = 0;
        if (context instanceof Activity) {
            com.google.android.gms.ads.internal.zzv.zzq();
            i3 = com.google.android.gms.ads.internal.util.zzs.zzS((Activity) context)[0];
        } else {
            i3 = 0;
        }
        zzcel zzcelVar = this.zzh;
        if (zzcelVar.zzO() == null || !zzcelVar.zzO().zzi()) {
            int width = zzcelVar.getWidth();
            int height = zzcelVar.getHeight();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzag)).booleanValue()) {
                if (width == 0) {
                    width = zzcelVar.zzO() != null ? zzcelVar.zzO().zzb : 0;
                }
                if (height != 0) {
                    i4 = height;
                } else if (zzcelVar.zzO() != null) {
                    i4 = zzcelVar.zzO().zza;
                }
            } else {
                i4 = height;
            }
            this.zzf = com.google.android.gms.ads.internal.client.zzbb.zzb().zzb(context, width);
            this.zzg = com.google.android.gms.ads.internal.client.zzbb.zzb().zzb(context, i4);
        }
        zzg(i, i2 - i3, this.zzf, this.zzg);
        zzcelVar.zzN().zzD(i, i2);
    }
}
