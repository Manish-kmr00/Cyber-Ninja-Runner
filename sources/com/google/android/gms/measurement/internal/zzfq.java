package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.wrappers.InstantApps;
import com.google.android.gms.internal.measurement.zzpg;
import com.google.android.gms.internal.measurement.zzps;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzfq extends zze {
    private String zza;
    private String zzb;
    private int zzc;
    private String zzd;
    private long zze;
    private long zzf;
    private List<String> zzg;
    private String zzh;
    private int zzi;
    private String zzj;
    private String zzk;
    private String zzl;
    private long zzm;
    private String zzn;

    final int zzaa() {
        zzu();
        return this.zzi;
    }

    @Override // com.google.android.gms.measurement.internal.zze
    protected final boolean zzz() {
        return true;
    }

    final int zzab() {
        zzu();
        return this.zzc;
    }

    @Override // com.google.android.gms.measurement.internal.zzij, com.google.android.gms.measurement.internal.zzil
    @Pure
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzij, com.google.android.gms.measurement.internal.zzil
    @Pure
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzb zzc() {
        return super.zzc();
    }

    /* JADX WARN: Code duplicated, block: B:44:0x0165  */
    /* JADX WARN: Code duplicated, block: B:45:0x0168  */
    /* JADX WARN: Code duplicated, block: B:51:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:57:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:63:0x01fc  */
    final zzo zza(String str) {
        long jMin;
        List<String> list;
        String str2;
        long j;
        boolean z;
        boolean z2;
        String str3;
        Boolean boolZze;
        boolean zBooleanValue;
        int iZzc;
        long jZzh;
        String strZzb;
        zzt();
        String strZzad = zzad();
        String strZzae = zzae();
        zzu();
        String str4 = this.zzb;
        long jZzab = zzab();
        zzu();
        Preconditions.checkNotNull(this.zzd);
        String str5 = this.zzd;
        zzu();
        zzt();
        if (this.zze == 0) {
            this.zze = this.zzu.zzt().zza(zza(), zza().getPackageName());
        }
        long j2 = this.zze;
        boolean zZzac = this.zzu.zzac();
        boolean z3 = !zzk().zzm;
        zzt();
        String strZzah = !this.zzu.zzac() ? null : zzah();
        zzhj zzhjVar = this.zzu;
        long jZza = zzhjVar.zzn().zzc.zza();
        if (jZza == 0) {
            jMin = zzhjVar.zza;
        } else {
            jMin = Math.min(zzhjVar.zza, jZza);
        }
        long j3 = jMin;
        int iZzaa = zzaa();
        boolean zZzu = zze().zzu();
        zzgh zzghVarZzk = zzk();
        zzghVarZzk.zzt();
        boolean z4 = zzghVarZzk.zzg().getBoolean("deferred_analytics_collection", false);
        String strZzac = zzac();
        Boolean boolZze2 = zze().zze("google_analytics_default_allow_ad_personalization_signals");
        Boolean boolValueOf = boolZze2 == null ? null : Boolean.valueOf(!boolZze2.booleanValue());
        long j4 = this.zzf;
        List<String> list2 = this.zzg;
        String strZzh = zzk().zzn().zzh();
        if (this.zzh == null) {
            this.zzh = zzq().zzp();
        }
        String str6 = this.zzh;
        if (com.google.android.gms.internal.measurement.zznk.zza()) {
            list = list2;
            str2 = str6;
            if (zze().zza(zzbf.zzcu) && !zzk().zzn().zza(zzin.zza.ANALYTICS_STORAGE)) {
                z = zZzac;
                z2 = z3;
                j = 0;
                str3 = null;
            }
            boolZze = zze().zze("google_analytics_sgtm_upload_enabled");
            if (boolZze == null) {
                zBooleanValue = false;
            } else {
                zBooleanValue = boolZze.booleanValue();
            }
            long jZzc = zzq().zzc(zzad());
            int iZza = zzk().zzn().zza();
            String strZzf = zzk().zzm().zzf();
            if (zzpg.zza() || !zze().zza(zzbf.zzca)) {
                iZzc = 0;
            } else {
                zzq();
                iZzc = zznp.zzc();
            }
            if (zzpg.zza() || !zze().zza(zzbf.zzca)) {
                jZzh = j;
            } else {
                jZzh = zzq().zzh();
            }
            String strZzp = zze().zzp();
            if (!com.google.android.gms.internal.measurement.zzne.zza() && zze().zza(zzbf.zzcq)) {
                strZzb = new zzgi(zze().zzc("google_analytics_default_allow_ad_personalization_signals", true)).zzb();
            } else {
                strZzb = "";
            }
            return new zzo(strZzad, strZzae, str4, jZzab, str5, 97001L, j2, str, z, z2, strZzah, 0L, j3, iZzaa, zZzu, z4, strZzac, boolValueOf, j4, list, (String) null, strZzh, str2, str3, zBooleanValue, jZzc, iZza, strZzf, iZzc, jZzh, strZzp, strZzb);
        }
        list = list2;
        str2 = str6;
        zzt();
        j = 0;
        if (this.zzm != 0) {
            z = zZzac;
            z2 = z3;
            long jCurrentTimeMillis = zzb().currentTimeMillis() - this.zzm;
            if (this.zzl != null && jCurrentTimeMillis > 86400000 && this.zzn == null) {
                zzag();
            }
        } else {
            z = zZzac;
            z2 = z3;
        }
        if (this.zzl == null) {
            zzag();
        }
        str3 = this.zzl;
        boolZze = zze().zze("google_analytics_sgtm_upload_enabled");
        if (boolZze == null) {
            zBooleanValue = false;
        } else {
            zBooleanValue = boolZze.booleanValue();
        }
        long jZzc2 = zzq().zzc(zzad());
        int iZza2 = zzk().zzn().zza();
        String strZzf2 = zzk().zzm().zzf();
        if (zzpg.zza()) {
            iZzc = 0;
        } else {
            iZzc = 0;
        }
        if (zzpg.zza()) {
            jZzh = j;
        } else {
            jZzh = j;
        }
        String strZzp2 = zze().zzp();
        if (!com.google.android.gms.internal.measurement.zzne.zza()) {
            strZzb = "";
        } else {
            strZzb = "";
        }
        return new zzo(strZzad, strZzae, str4, jZzab, str5, 97001L, j2, str, z, z2, strZzah, 0L, j3, iZzaa, zZzu, z4, strZzac, boolValueOf, j4, list, (String) null, strZzh, str2, str3, zBooleanValue, jZzc2, iZza2, strZzf2, iZzc, jZzh, strZzp2, strZzb);
    }

    @Override // com.google.android.gms.measurement.internal.zzij, com.google.android.gms.measurement.internal.zzil
    @Pure
    public final /* bridge */ /* synthetic */ zzab zzd() {
        return super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzij
    @Pure
    public final /* bridge */ /* synthetic */ zzag zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzij
    @Pure
    public final /* bridge */ /* synthetic */ zzax zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzfq zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzfp zzh() {
        return super.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzij
    @Pure
    public final /* bridge */ /* synthetic */ zzfr zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzij, com.google.android.gms.measurement.internal.zzil
    @Pure
    public final /* bridge */ /* synthetic */ zzfw zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzij
    @Pure
    public final /* bridge */ /* synthetic */ zzgh zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzij, com.google.android.gms.measurement.internal.zzil
    @Pure
    public final /* bridge */ /* synthetic */ zzhc zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zziv zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzks zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzkx zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzmh zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzij
    @Pure
    public final /* bridge */ /* synthetic */ zznp zzq() {
        return super.zzq();
    }

    final String zzac() {
        zzu();
        return this.zzk;
    }

    final String zzad() {
        zzu();
        Preconditions.checkNotNull(this.zza);
        return this.zza;
    }

    private final String zzah() {
        if (zzps.zza() && zze().zza(zzbf.zzbm)) {
            zzj().zzp().zza("Disabled IID for tests.");
            return null;
        }
        try {
            Class<?> clsLoadClass = zza().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
            if (clsLoadClass == null) {
                return null;
            }
            try {
                Object objInvoke = clsLoadClass.getDeclaredMethod("getInstance", Context.class).invoke(null, zza());
                if (objInvoke == null) {
                    return null;
                }
                try {
                    return (String) clsLoadClass.getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(objInvoke, new Object[0]);
                } catch (Exception unused) {
                    zzj().zzv().zza("Failed to retrieve Firebase Instance Id");
                    return null;
                }
            } catch (Exception unused2) {
                zzj().zzw().zza("Failed to obtain Firebase Analytics instance");
                return null;
            }
        } catch (ClassNotFoundException unused3) {
        }
    }

    final String zzae() {
        zzt();
        zzu();
        Preconditions.checkNotNull(this.zzj);
        return this.zzj;
    }

    final List<String> zzaf() {
        return this.zzg;
    }

    zzfq(zzhj zzhjVar, long j) {
        super(zzhjVar);
        this.zzm = 0L;
        this.zzn = null;
        this.zzf = j;
    }

    @Override // com.google.android.gms.measurement.internal.zzf, com.google.android.gms.measurement.internal.zzij
    public final /* bridge */ /* synthetic */ void zzr() {
        super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzf, com.google.android.gms.measurement.internal.zzij
    public final /* bridge */ /* synthetic */ void zzs() {
        super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzf, com.google.android.gms.measurement.internal.zzij
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.measurement.internal.zze
    @EnsuresNonNull({RemoteConfigConstants.RequestFieldKey.APP_ID, "appStore", "appName", "gmpAppId", "gaAppId"})
    protected final void zzx() {
        String str;
        String packageName = zza().getPackageName();
        PackageManager packageManager = zza().getPackageManager();
        String str2 = "";
        String installerPackageName = "unknown";
        String str3 = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        int i = Integer.MIN_VALUE;
        if (packageManager == null) {
            zzj().zzg().zza("PackageManager is null, app identity information might be inaccurate. appId", zzfw.zza(packageName));
        } else {
            try {
                installerPackageName = packageManager.getInstallerPackageName(packageName);
            } catch (IllegalArgumentException unused) {
                zzj().zzg().zza("Error retrieving app installer package name. appId", zzfw.zza(packageName));
            }
            if (installerPackageName == null) {
                installerPackageName = "manual_install";
            } else if ("com.android.vending".equals(installerPackageName)) {
                installerPackageName = "";
            }
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(zza().getPackageName(), 0);
                if (packageInfo != null) {
                    CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                    String string = !TextUtils.isEmpty(applicationLabel) ? applicationLabel.toString() : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                    try {
                        str3 = packageInfo.versionName;
                        i = packageInfo.versionCode;
                    } catch (PackageManager.NameNotFoundException unused2) {
                        str = str3;
                        str3 = string;
                        zzj().zzg().zza("Error retrieving package info. appId, appName", zzfw.zza(packageName), str3);
                        str3 = str;
                    }
                }
            } catch (PackageManager.NameNotFoundException unused3) {
                str = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
            }
        }
        this.zza = packageName;
        this.zzd = installerPackageName;
        this.zzb = str3;
        this.zzc = i;
        this.zze = 0L;
        byte b = !TextUtils.isEmpty(this.zzu.zzu()) && "am".equals(this.zzu.zzv());
        int iZzc = this.zzu.zzc();
        switch (iZzc) {
            case 0:
                zzj().zzp().zza("App measurement collection enabled");
                break;
            case 1:
                zzj().zzn().zza("App measurement deactivated via the manifest");
                break;
            case 2:
                zzj().zzp().zza("App measurement deactivated via the init parameters");
                break;
            case 3:
                zzj().zzn().zza("App measurement disabled by setAnalyticsCollectionEnabled(false)");
                break;
            case 4:
                zzj().zzn().zza("App measurement disabled via the manifest");
                break;
            case 5:
                zzj().zzp().zza("App measurement disabled via the init parameters");
                break;
            case 6:
                zzj().zzv().zza("App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics");
                break;
            case 7:
                zzj().zzn().zza("App measurement disabled via the global data collection setting");
                break;
            case 8:
                zzj().zzn().zza("App measurement disabled due to denied storage consent");
                break;
            default:
                zzj().zzn().zza("App measurement disabled");
                zzj().zzm().zza("Invalid scion state in identity");
                break;
        }
        boolean z = iZzc == 0;
        this.zzj = "";
        this.zzk = "";
        if (b != false) {
            this.zzk = this.zzu.zzu();
        }
        try {
            String strZza = new zzhd(zza(), this.zzu.zzx()).zza("google_app_id");
            if (!TextUtils.isEmpty(strZza)) {
                str2 = strZza;
            }
            this.zzj = str2;
            if (!TextUtils.isEmpty(strZza)) {
                this.zzk = new zzhd(zza(), this.zzu.zzx()).zza("admob_app_id");
            }
            if (z) {
                zzj().zzp().zza("App measurement enabled for app package, google app id", this.zza, TextUtils.isEmpty(this.zzj) ? this.zzk : this.zzj);
            }
        } catch (IllegalStateException e) {
            zzj().zzg().zza("Fetching Google App Id failed with exception. appId", zzfw.zza(packageName), e);
        }
        this.zzg = null;
        List<String> listZzg = zze().zzg("analytics.safelisted_events");
        if (listZzg != null) {
            if (listZzg.isEmpty()) {
                zzj().zzv().zza("Safelisted event list is empty. Ignoring");
            } else {
                Iterator<String> it = listZzg.iterator();
                do {
                    if (!it.hasNext()) {
                        this.zzg = listZzg;
                    }
                } while (zzq().zzb("safelisted event", it.next()));
            }
        } else {
            this.zzg = listZzg;
        }
        if (packageManager != null) {
            this.zzi = InstantApps.isInstantApp(zza()) ? 1 : 0;
        } else {
            this.zzi = 0;
        }
    }

    final void zzag() {
        String str;
        zzt();
        if (!zzk().zzn().zza(zzin.zza.ANALYTICS_STORAGE)) {
            zzj().zzc().zza("Analytics Storage consent is not granted");
            str = null;
        } else {
            byte[] bArr = new byte[16];
            zzq().zzv().nextBytes(bArr);
            str = String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        }
        zzj().zzc().zza(String.format("Resetting session stitching token to %s", str == null ? "null" : "not null"));
        this.zzl = str;
        this.zzm = zzb().currentTimeMillis();
    }

    final boolean zzb(String str) {
        String str2 = this.zzn;
        boolean z = (str2 == null || str2.equals(str)) ? false : true;
        this.zzn = str;
        return z;
    }
}
