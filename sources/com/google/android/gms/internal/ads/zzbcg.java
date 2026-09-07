package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.text.TextUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.wrappers.Wrappers;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
@ParametersAreNonnullByDefault
public final class zzbcg implements SharedPreferences.OnSharedPreferenceChangeListener {
    private Context zzg;
    private final Object zzb = new Object();
    private final ConditionVariable zzc = new ConditionVariable();
    private volatile boolean zzd = false;
    volatile boolean zza = false;
    private SharedPreferences zze = null;
    private Bundle zzf = new Bundle();
    private JSONObject zzh = new JSONObject();
    private boolean zzi = false;
    private boolean zzj = false;

    private final void zzg(final SharedPreferences sharedPreferences) {
        if (sharedPreferences != null) {
            try {
                this.zzh = new JSONObject((String) zzbck.zza(new zzfuo() { // from class: com.google.android.gms.internal.ads.zzbcd
                    @Override // com.google.android.gms.internal.ads.zzfuo
                    public final Object zza() {
                        return sharedPreferences.getString("flag_configuration", JsonUtils.EMPTY_JSON);
                    }
                }));
            } catch (JSONException unused) {
            }
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("flag_configuration".equals(str)) {
            zzg(sharedPreferences);
        }
    }

    public final Object zzb(final zzbbz zzbbzVar) {
        if (!this.zzc.block(5000L)) {
            synchronized (this.zzb) {
                if (!this.zza) {
                    throw new IllegalStateException("Flags.initialize() was not called!");
                }
            }
        }
        if (!this.zzd || this.zze == null || this.zzj) {
            synchronized (this.zzb) {
                if (this.zzd && this.zze != null && !this.zzj) {
                }
                return zzbbzVar.zzk();
            }
        }
        if (zzbbzVar.zze() != 2) {
            return (zzbbzVar.zze() == 1 && this.zzh.has(zzbbzVar.zzl())) ? zzbbzVar.zza(this.zzh) : zzbck.zza(new zzfuo() { // from class: com.google.android.gms.internal.ads.zzbce
                @Override // com.google.android.gms.internal.ads.zzfuo
                public final Object zza() {
                    return zzbbzVar.zzc(this.zza.zze);
                }
            });
        }
        Bundle bundle = this.zzf;
        return bundle == null ? zzbbzVar.zzk() : zzbbzVar.zzb(bundle);
    }

    /* JADX WARN: Code duplicated, block: B:63:0x011d A[Catch: all -> 0x015d, TRY_ENTER, TryCatch #3 {, blocks: (B:7:0x0008, B:9:0x000c, B:11:0x000e, B:13:0x0013, B:14:0x0015, B:16:0x0027, B:17:0x002b, B:18:0x002d, B:38:0x0099, B:39:0x00a0, B:48:0x00d1, B:49:0x00d8, B:63:0x011d, B:64:0x0124, B:72:0x014b, B:73:0x0152, B:76:0x0155, B:77:0x015c, B:20:0x0042, B:23:0x004c, B:27:0x0055, B:30:0x0060, B:31:0x0068, B:33:0x006e, B:35:0x007e, B:37:0x0095, B:41:0x00a2, B:43:0x00a6, B:45:0x00b6, B:47:0x00cd, B:51:0x00da, B:61:0x0119, B:66:0x0126, B:68:0x013d, B:70:0x0141, B:71:0x0144, B:54:0x00eb, B:56:0x00f9, B:58:0x0101, B:59:0x010c), top: B:88:0x0008, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x0126 A[Catch: all -> 0x0154, TRY_ENTER, TryCatch #0 {all -> 0x0154, blocks: (B:20:0x0042, B:23:0x004c, B:27:0x0055, B:30:0x0060, B:31:0x0068, B:33:0x006e, B:35:0x007e, B:37:0x0095, B:41:0x00a2, B:43:0x00a6, B:45:0x00b6, B:47:0x00cd, B:51:0x00da, B:61:0x0119, B:66:0x0126, B:68:0x013d, B:70:0x0141, B:71:0x0144, B:54:0x00eb, B:56:0x00f9, B:58:0x0101, B:59:0x010c), top: B:83:0x0042, outer: #3 }] */
    public final void zzd(Context context) {
        SharedPreferences sharedPreferencesZza;
        final SharedPreferences sharedPreferences;
        SharedPreferences sharedPreferences2;
        if (this.zzd) {
            return;
        }
        synchronized (this.zzb) {
            if (this.zzd) {
                return;
            }
            if (!this.zza) {
                this.zza = true;
            }
            this.zzi = TextUtils.equals(context.getPackageName(), "com.google.android.gms");
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.zzg = context;
            try {
                this.zzf = Wrappers.packageManager(context).getApplicationInfo(this.zzg.getPackageName(), 128).metaData;
            } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            }
            try {
                Context context2 = this.zzg;
                Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context2);
                if (remoteContext != null || context2 == null || (remoteContext = context2.getApplicationContext()) != null) {
                    context2 = remoteContext;
                }
                if (context2 != null) {
                    com.google.android.gms.ads.internal.client.zzbd.zzb();
                    sharedPreferencesZza = zzbcb.zza(context2);
                } else {
                    sharedPreferencesZza = null;
                }
                if (sharedPreferencesZza != null) {
                    zzbez.zzc(new zzbcf(this, sharedPreferencesZza));
                }
                if (!this.zzi && ((Long) zzbea.zzd.zze()).longValue() > 0 && zzbbs.zza(this.zzg) >= ((Long) zzbea.zzd.zze()).longValue()) {
                    this.zzj = true;
                    this.zzd = true;
                    this.zza = false;
                    this.zzc.open();
                    return;
                }
                if (!this.zzi && ((Long) zzbea.zzf.zze()).longValue() > 0 && zzbbs.zzb(this.zzg) >= ((Long) zzbea.zzf.zze()).longValue()) {
                    this.zzj = true;
                    this.zzd = true;
                    this.zza = false;
                    this.zzc.open();
                    return;
                }
                Context context3 = this.zzg;
                if (!((Boolean) zzbei.zzg.zze()).booleanValue()) {
                    if (((Boolean) zzbei.zzh.zze()).booleanValue() && (sharedPreferences = context3.getSharedPreferences("admob", 0)) != null) {
                        try {
                            if (new JSONObject((String) zzbck.zza(new zzfuo() { // from class: com.google.android.gms.internal.ads.zzbcc
                                @Override // com.google.android.gms.internal.ads.zzfuo
                                public final Object zza() {
                                    return sharedPreferences.getString("app_settings_json", JsonUtils.EMPTY_JSON);
                                }
                            })).optBoolean("local_flags_enabled")) {
                            }
                        } catch (JSONException unused2) {
                        }
                    }
                    if (context2 == null) {
                        this.zza = false;
                        this.zzc.open();
                        return;
                    }
                    com.google.android.gms.ads.internal.client.zzbd.zzb();
                    this.zze = zzbcb.zza(context2);
                    if (!((Boolean) zzbei.zza.zze()).booleanValue() && (sharedPreferences2 = this.zze) != null) {
                        sharedPreferences2.registerOnSharedPreferenceChangeListener(this);
                    }
                    zzg(this.zze);
                    this.zzd = true;
                    this.zza = false;
                    this.zzc.open();
                }
                context2 = this.zzg;
                if (context2 == null) {
                    this.zza = false;
                    this.zzc.open();
                    return;
                }
                com.google.android.gms.ads.internal.client.zzbd.zzb();
                this.zze = zzbcb.zza(context2);
                if (!((Boolean) zzbei.zza.zze()).booleanValue()) {
                    sharedPreferences2.registerOnSharedPreferenceChangeListener(this);
                }
                zzg(this.zze);
                this.zzd = true;
                this.zza = false;
                this.zzc.open();
            } catch (Throwable th) {
                this.zza = false;
                this.zzc.open();
                throw th;
            }
        }
    }

    public final boolean zze() {
        return this.zzj;
    }

    final boolean zzf() {
        return this.zzi;
    }

    public final Object zzc(zzbbz zzbbzVar) {
        return (this.zzd || this.zza) ? zzb(zzbbzVar) : zzbbzVar.zzk();
    }
}
