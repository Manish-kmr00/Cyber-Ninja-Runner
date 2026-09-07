package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.LocaleList;
import android.os.StatFs;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzetg implements zzesv {
    private final zzgcd zza;
    private final Context zzb;

    public zzetg(zzgcd zzgcdVar, Context context) {
        this.zza = zzgcdVar;
        this.zzb = context;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:39:0x0138  */
    /* JADX WARN: Code duplicated, block: B:52:0x0172  */
    /* JADX WARN: Code duplicated, block: B:53:0x0174  */
    /* JADX WARN: Code duplicated, block: B:56:0x0178  */
    /* JADX WARN: Code duplicated, block: B:8:0x005d  */
    public static /* synthetic */ zzete zzc(zzetg zzetgVar) {
        ActivityInfo activityInfo;
        String str;
        String str2;
        boolean zEquals;
        boolean z;
        String str3;
        String string;
        boolean z2;
        Context context = zzetgVar.zzb;
        PackageManager packageManager = context.getPackageManager();
        Locale locale = Locale.getDefault();
        ResolveInfo resolveInfoZzd = zzd(packageManager, "geo:0,0?q=donuts");
        ResolveInfo resolveInfoZzd2 = zzd(packageManager, "http://www.google.com");
        String country = locale.getCountry();
        com.google.android.gms.ads.internal.zzv.zzq();
        com.google.android.gms.ads.internal.client.zzbb.zzb();
        boolean zZzs = com.google.android.gms.ads.internal.util.client.zzf.zzs();
        boolean zIsLatchsky = DeviceProperties.isLatchsky(context);
        boolean zIsSidewinder = DeviceProperties.isSidewinder(context);
        String language = locale.getLanguage();
        ArrayList arrayList = new ArrayList();
        LocaleList localeList = LocaleList.getDefault();
        for (int i = 0; i < localeList.size(); i++) {
            arrayList.add(localeList.get(i).getLanguage());
        }
        ResolveInfo resolveInfoZzd3 = zzd(packageManager, "market://details?id=com.google.android.gms.ads");
        if (resolveInfoZzd3 == null || (activityInfo = resolveInfoZzd3.activityInfo) == null) {
            str = null;
        } else {
            try {
                PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(activityInfo.packageName, 0);
                if (packageInfo != null) {
                    str = packageInfo.versionCode + "." + activityInfo.packageName;
                } else {
                    str = null;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        try {
            PackageInfo packageInfo2 = Wrappers.packageManager(zzetgVar.zzb).getPackageInfo("com.android.vending", 128);
            str2 = packageInfo2 != null ? packageInfo2.versionCode + "." + packageInfo2.packageName : null;
        } catch (Exception unused2) {
        }
        Context context2 = zzetgVar.zzb;
        String str4 = Build.FINGERPRINT;
        if (packageManager == null) {
            zEquals = false;
            break;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
        ResolveInfo resolveInfoResolveActivity = packageManager.resolveActivity(intent, 0);
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
        if (listQueryIntentActivities == null || resolveInfoResolveActivity == null) {
            zEquals = false;
            break;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= listQueryIntentActivities.size()) {
                zEquals = false;
                break;
            }
            List<ResolveInfo> list = listQueryIntentActivities;
            if (resolveInfoResolveActivity.activityInfo.name.equals(listQueryIntentActivities.get(i2).activityInfo.name)) {
                zEquals = resolveInfoResolveActivity.activityInfo.packageName.equals(zzhfo.zza(context2));
                break;
            }
            i2++;
            listQueryIntentActivities = list;
        }
        com.google.android.gms.ads.internal.zzv.zzq();
        long availableBytes = new StatFs(Environment.getDataDirectory().getAbsolutePath()).getAvailableBytes() / 1024;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzlv)).booleanValue()) {
            com.google.android.gms.ads.internal.zzv.zzq();
            if (com.google.android.gms.ads.internal.util.zzs.zzC(context2)) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzlz)).booleanValue()) {
            try {
                Bundle bundle = Wrappers.packageManager(context2).getApplicationInfo(context2.getPackageName(), 128).metaData;
                if (bundle == null || !bundle.containsKey("com.google.unity.ads.UNITY_VERSION")) {
                    str3 = null;
                } else {
                    string = bundle.getString("com.google.unity.ads.UNITY_VERSION");
                }
            } catch (PackageManager.NameNotFoundException unused3) {
            }
            if (resolveInfoZzd2 != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            return new zzete(resolveInfoZzd != null, z2, country, zZzs, zIsLatchsky, zIsSidewinder, language, arrayList, str, str2, str4, zEquals, Build.MODEL, availableBytes, z, str3, Build.VERSION.SDK_INT);
        }
        string = "";
        str3 = string;
        if (resolveInfoZzd2 != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        return new zzete(resolveInfoZzd != null, z2, country, zZzs, zIsLatchsky, zIsSidewinder, language, arrayList, str, str2, str4, zEquals, Build.MODEL, availableBytes, z, str3, Build.VERSION.SDK_INT);
    }

    private static ResolveInfo zzd(PackageManager packageManager, String str) {
        return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final int zza() {
        return 38;
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzetf
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzetg.zzc(this.zza);
            }
        });
    }
}
