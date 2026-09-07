package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzfmb implements zzflc {
    private static final zzfmb zza = new zzfmb();
    private static final Handler zzb = new Handler(Looper.getMainLooper());
    private static Handler zzc = null;
    private static final Runnable zzd = new zzflx();
    private static final Runnable zze = new zzfly();
    private int zzg;
    private long zzm;
    private final List zzf = new ArrayList();
    private boolean zzh = false;
    private final List zzi = new ArrayList();
    private final zzflu zzk = new zzflu();
    private final zzfle zzj = new zzfle();
    private final zzflv zzl = new zzflv(new zzfme());

    zzfmb() {
    }

    public static zzfmb zzd() {
        return zza;
    }

    static /* bridge */ /* synthetic */ void zzg(zzfmb zzfmbVar) {
        zzfmbVar.zzg = 0;
        zzfmbVar.zzi.clear();
        zzfmbVar.zzh = false;
        for (zzfjz zzfjzVar : zzfkr.zza().zzb()) {
        }
        zzfmbVar.zzm = System.nanoTime();
        zzflu zzfluVar = zzfmbVar.zzk;
        zzfluVar.zzi();
        long jNanoTime = System.nanoTime();
        zzfle zzfleVar = zzfmbVar.zzj;
        zzfld zzfldVarZza = zzfleVar.zza();
        if (zzfluVar.zze().size() > 0) {
            for (String str : zzfluVar.zze()) {
                JSONObject jSONObjectZza = zzfldVarZza.zza(null);
                View viewZza = zzfluVar.zza(str);
                zzfld zzfldVarZzb = zzfleVar.zzb();
                String strZzc = zzfluVar.zzc(str);
                if (strZzc != null) {
                    JSONObject jSONObjectZza2 = zzfldVarZzb.zza(viewZza);
                    zzfln.zzb(jSONObjectZza2, str);
                    try {
                        jSONObjectZza2.put("notVisibleReason", strZzc);
                    } catch (JSONException e) {
                        zzflo.zza("Error with setting not visible reason", e);
                    }
                    zzfln.zzc(jSONObjectZza, jSONObjectZza2);
                }
                zzfln.zzf(jSONObjectZza);
                HashSet hashSet = new HashSet();
                hashSet.add(str);
                zzfmbVar.zzl.zzc(jSONObjectZza, hashSet, jNanoTime);
            }
        }
        zzflu zzfluVar2 = zzfmbVar.zzk;
        if (zzfluVar2.zzf().size() > 0) {
            JSONObject jSONObjectZza3 = zzfldVarZza.zza(null);
            zzfmbVar.zzk(null, zzfldVarZza, jSONObjectZza3, 1, false);
            zzfln.zzf(jSONObjectZza3);
            zzfmbVar.zzl.zzd(jSONObjectZza3, zzfluVar2.zzf(), jNanoTime);
            boolean z = zzfmbVar.zzh;
        } else {
            zzfmbVar.zzl.zzb();
        }
        zzfluVar2.zzg();
        long jNanoTime2 = System.nanoTime() - zzfmbVar.zzm;
        List<zzfma> list = zzfmbVar.zzf;
        if (list.size() > 0) {
            for (zzfma zzfmaVar : list) {
                int i = zzfmbVar.zzg;
                TimeUnit.NANOSECONDS.toMillis(jNanoTime2);
                zzfmaVar.zzb();
                if (zzfmaVar instanceof zzflz) {
                    int i2 = zzfmbVar.zzg;
                    ((zzflz) zzfmaVar).zza();
                }
            }
        }
        zzflb.zza().zzc();
    }

    private final void zzk(View view, zzfld zzfldVar, JSONObject jSONObject, int i, boolean z) {
        zzfldVar.zzb(view, jSONObject, this, i == 1, z);
    }

    private static final void zzl() {
        Handler handler = zzc;
        if (handler != null) {
            handler.removeCallbacks(zze);
            zzc = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzflc
    public final void zza(View view, zzfld zzfldVar, JSONObject jSONObject, boolean z) {
        zzflu zzfluVar;
        int iZzl;
        boolean z2;
        if (zzfls.zza(view) != null || (iZzl = (zzfluVar = this.zzk).zzl(view)) == 3) {
            return;
        }
        JSONObject jSONObjectZza = zzfldVar.zza(view);
        zzfln.zzc(jSONObject, jSONObjectZza);
        String strZzd = zzfluVar.zzd(view);
        if (strZzd != null) {
            zzfln.zzb(jSONObjectZza, strZzd);
            try {
                jSONObjectZza.put("hasWindowFocus", Boolean.valueOf(this.zzk.zzk(view)));
            } catch (JSONException e) {
                zzflo.zza("Error with setting has window focus", e);
            }
            Boolean boolValueOf = Boolean.valueOf(this.zzk.zzj(strZzd));
            if (boolValueOf.booleanValue()) {
                try {
                    jSONObjectZza.put("isPipActive", boolValueOf);
                } catch (JSONException e2) {
                    zzflo.zza("Error with setting is picture-in-picture active", e2);
                }
            }
            this.zzk.zzh();
        } else {
            zzflt zzfltVarZzb = zzfluVar.zzb(view);
            if (zzfltVarZzb != null) {
                zzfku zzfkuVarZza = zzfltVarZzb.zza();
                JSONArray jSONArray = new JSONArray();
                ArrayList arrayListZzb = zzfltVarZzb.zzb();
                int size = arrayListZzb.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put((String) arrayListZzb.get(i));
                }
                try {
                    jSONObjectZza.put("isFriendlyObstructionFor", jSONArray);
                    jSONObjectZza.put("friendlyObstructionClass", zzfkuVarZza.zzd());
                    jSONObjectZza.put("friendlyObstructionPurpose", zzfkuVarZza.zza());
                    jSONObjectZza.put("friendlyObstructionReason", zzfkuVarZza.zzc());
                } catch (JSONException e3) {
                    zzflo.zza("Error with setting friendly obstruction", e3);
                }
                z2 = true;
            } else {
                z2 = false;
            }
            zzk(view, zzfldVar, jSONObjectZza, iZzl, z || z2);
        }
        this.zzg++;
    }

    public final void zzh() {
        zzl();
    }

    public final void zzi() {
        if (zzc == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            zzc = handler;
            handler.post(zzd);
            zzc.postDelayed(zze, 200L);
        }
    }

    public final void zzj() {
        zzl();
        this.zzf.clear();
        zzb.post(new zzflw(this));
    }
}
