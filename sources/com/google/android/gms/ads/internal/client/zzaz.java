package com.google.android.gms.ads.internal.client;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.h5.OnH5AdsEventListener;
import com.google.android.gms.internal.ads.zzbfx;
import com.google.android.gms.internal.ads.zzbgd;
import com.google.android.gms.internal.ads.zzbhp;
import com.google.android.gms.internal.ads.zzbhq;
import com.google.android.gms.internal.ads.zzbkl;
import com.google.android.gms.internal.ads.zzboy;
import com.google.android.gms.internal.ads.zzbsr;
import com.google.android.gms.internal.ads.zzbsv;
import com.google.android.gms.internal.ads.zzbsy;
import com.google.android.gms.internal.ads.zzbtx;
import com.google.android.gms.internal.ads.zzbwd;
import com.google.android.gms.internal.ads.zzbwp;
import com.google.android.gms.internal.ads.zzbyi;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaz {
    private final zzk zza;
    private final zzi zzb;
    private final zzfa zzc;
    private final zzbhp zzd;
    private final zzbsv zze;
    private final zzbhq zzf;
    private zzbtx zzg;
    private final zzl zzh;

    public zzaz(zzk zzkVar, zzi zziVar, zzfa zzfaVar, zzbhp zzbhpVar, zzbwp zzbwpVar, zzbsv zzbsvVar, zzbhq zzbhqVar, zzl zzlVar) {
        this.zza = zzkVar;
        this.zzb = zziVar;
        this.zzc = zzfaVar;
        this.zzd = zzbhpVar;
        this.zze = zzbsvVar;
        this.zzf = zzbhqVar;
        this.zzh = zzlVar;
    }

    static /* bridge */ /* synthetic */ void zzv(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "no_ads_fallback");
        bundle.putString("flow", str);
        zzbb.zzb().zzo(context, zzbb.zzc().afmaVersion, "gmob-apps", bundle, true);
    }

    public final zzbt zzd(Context context, String str, zzboy zzboyVar) {
        return (zzbt) new zzaq(this, context, str, zzboyVar).zzd(context, false);
    }

    public final zzbx zze(Context context, zzr zzrVar, String str, zzboy zzboyVar) {
        return (zzbx) new zzam(this, context, zzrVar, str, zzboyVar).zzd(context, false);
    }

    public final zzbx zzf(Context context, zzr zzrVar, String str, zzboy zzboyVar) {
        return (zzbx) new zzao(this, context, zzrVar, str, zzboyVar).zzd(context, false);
    }

    public final zzch zzg(Context context, zzboy zzboyVar) {
        return (zzch) new zzas(this, context, zzboyVar).zzd(context, false);
    }

    public final zzdt zzh(Context context, zzboy zzboyVar) {
        return (zzdt) new zzae(this, context, zzboyVar).zzd(context, false);
    }

    public final zzbfx zzj(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        return (zzbfx) new zzaw(this, frameLayout, frameLayout2, context).zzd(context, false);
    }

    public final zzbgd zzk(View view, HashMap map, HashMap map2) {
        return (zzbgd) new zzay(this, view, map, map2).zzd(view.getContext(), false);
    }

    public final zzbkl zzn(Context context, zzboy zzboyVar, OnH5AdsEventListener onH5AdsEventListener) {
        return (zzbkl) new zzak(this, context, zzboyVar, onH5AdsEventListener).zzd(context, false);
    }

    public final zzbsr zzo(Context context, zzboy zzboyVar) {
        return (zzbsr) new zzai(this, context, zzboyVar).zzd(context, false);
    }

    public final zzbsy zzq(Activity activity) {
        zzac zzacVar = new zzac(this, activity);
        Intent intent = activity.getIntent();
        boolean booleanExtra = false;
        if (intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            booleanExtra = intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        } else {
            com.google.android.gms.ads.internal.util.client.zzo.zzg("useClientJar flag not found in activity intent extras.");
        }
        return (zzbsy) zzacVar.zzd(activity, booleanExtra);
    }

    public final zzbwd zzs(Context context, String str, zzboy zzboyVar) {
        return (zzbwd) new zzaa(this, context, str, zzboyVar).zzd(context, false);
    }

    public final zzbyi zzt(Context context, zzboy zzboyVar) {
        return (zzbyi) new zzag(this, context, zzboyVar).zzd(context, false);
    }
}
