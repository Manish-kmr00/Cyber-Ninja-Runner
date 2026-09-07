package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.browser.customtabs.CustomTabsClient;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzbjv implements zzbjj {
    private final com.google.android.gms.ads.internal.zzb zza;
    private final zzdre zzb;
    private final zzbrw zzd;
    private final zzeat zze;
    private final zzclx zzf;
    private com.google.android.gms.ads.internal.overlay.zzaa zzg = null;
    private final zzgcd zzh = zzbzk.zzg;
    private final com.google.android.gms.ads.internal.util.client.zzu zzc = new com.google.android.gms.ads.internal.util.client.zzu(null);

    public zzbjv(com.google.android.gms.ads.internal.zzb zzbVar, zzbrw zzbrwVar, zzeat zzeatVar, zzdre zzdreVar, zzclx zzclxVar) {
        this.zza = zzbVar;
        this.zzd = zzbrwVar;
        this.zze = zzeatVar;
        this.zzb = zzdreVar;
        this.zzf = zzclxVar;
    }

    public static int zzb(Map map) {
        String str = (String) map.get("o");
        if (str == null) {
            return -1;
        }
        if ("p".equalsIgnoreCase(str)) {
            return 7;
        }
        if ("l".equalsIgnoreCase(str)) {
            return 6;
        }
        return ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM.equalsIgnoreCase(str) ? 14 : -1;
    }

    static Uri zzc(Context context, zzauy zzauyVar, Uri uri, View view, Activity activity, zzfbt zzfbtVar) {
        if (zzauyVar == null) {
            return uri;
        }
        try {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzmc)).booleanValue() || zzfbtVar == null) {
                if (zzauyVar.zze(uri)) {
                    uri = zzauyVar.zza(uri, context, view, activity);
                }
            } else if (zzauyVar.zze(uri)) {
                uri = zzfbtVar.zza(uri, context, view, activity);
            }
        } catch (zzauz unused) {
        } catch (Exception e) {
            com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "OpenGmsgHandler.maybeAddClickSignalsToUri");
        }
        return uri;
    }

    static Uri zzd(Uri uri) {
        try {
            if (uri.getQueryParameter("aclk_ms") != null) {
                return uri.buildUpon().appendQueryParameter("aclk_upms", String.valueOf(SystemClock.uptimeMillis())).build();
            }
        } catch (UnsupportedOperationException e) {
            String strValueOf = String.valueOf(uri.toString());
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Error adding click uptime parameter to url: ".concat(strValueOf), e);
        }
        return uri;
    }

    public static boolean zzf(Map map) {
        return "1".equals(map.get("custom_close"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:116:0x02f3  */
    public final void zzh(String str, com.google.android.gms.ads.internal.client.zza zzaVar, Map map, String str2) {
        String str3;
        boolean zZzb;
        HashMap map2;
        Object obj;
        boolean z;
        String string;
        zzcel zzcelVar = (zzcel) zzaVar;
        zzfau zzfauVarZzD = zzcelVar.zzD();
        zzfax zzfaxVarZzR = zzcelVar.zzR();
        boolean zZzg = false;
        if (zzfauVarZzD == null || zzfaxVarZzR == null) {
            str3 = "";
            zZzb = false;
        } else {
            String str4 = zzfaxVarZzR.zzb;
            zZzb = zzfauVarZzD.zzb();
            str3 = str4;
        }
        boolean z2 = (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzkO)).booleanValue() && map.containsKey("sc") && ((String) map.get("sc")).equals("0")) ? false : true;
        boolean z3 = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzmN)).booleanValue() && map.containsKey("ig_cl") && ((String) map.get("ig_cl")).equals("true");
        if ("expand".equalsIgnoreCase(str2)) {
            if (zzcelVar.zzaF()) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Cannot expand WebView that is already expanded.");
                return;
            } else {
                zzk(false);
                ((zzcfv) zzaVar).zzaL(zzf(map), zzb(map), z2);
                return;
            }
        }
        if ("webapp".equalsIgnoreCase(str2)) {
            zzk(false);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzlY)).booleanValue() && Objects.equals(map.get("is_allowed_for_lock_screen"), "1")) {
                zZzg = true;
            }
            if (str != null) {
                ((zzcfv) zzaVar).zzaN(zzf(map), zzb(map), str, z2, zZzg);
                return;
            } else {
                ((zzcfv) zzaVar).zzaM(zzf(map), zzb(map), (String) map.get("html"), (String) map.get("baseurl"), z2);
                return;
            }
        }
        Intent uri = null;
        if ("chrome_custom_tab".equalsIgnoreCase(str2)) {
            Context context = zzcelVar.getContext();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzeS)).booleanValue()) {
                com.google.android.gms.ads.internal.util.zze.zza("User opt out chrome custom tab.");
                zzm(10);
            } else {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzeN)).booleanValue()) {
                    int i2 = zzbdh.zza;
                    if (CustomTabsClient.getPackageName(context, null) != null) {
                        zZzg = true;
                    }
                } else {
                    zZzg = zzbdj.zzg(context);
                }
                if (zZzg) {
                    zzk(true);
                    if (TextUtils.isEmpty(str)) {
                        int i3 = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzj("Cannot open browser with null or empty url");
                        zzm(7);
                        return;
                    }
                    Uri uriZzd = zzd(zzc(zzcelVar.getContext(), zzcelVar.zzI(), Uri.parse(str), zzcelVar.zzF(), zzcelVar.zzi(), zzcelVar.zzS()));
                    if (zZzb && this.zze != null && zzl(zzaVar, zzcelVar.getContext(), uriZzd.toString(), str3)) {
                        return;
                    }
                    this.zzg = new zzbjs(this);
                    ((zzcfv) zzaVar).zzaJ(new com.google.android.gms.ads.internal.overlay.zzc(null, uriZzd.toString(), null, null, null, null, null, null, ObjectWrapper.wrap(this.zzg).asBinder(), true), z2, z3, str3);
                    return;
                }
                zzm(4);
            }
            map.put("use_first_package", "true");
            map.put("use_running_process", "true");
            zzj(zzaVar, map, zZzb, str3, z2, z3);
            return;
        }
        if ("app".equalsIgnoreCase(str2) && "true".equalsIgnoreCase((String) map.get("system_browser"))) {
            zzj(zzaVar, map, zZzb, str3, z2, z3);
            return;
        }
        if ("open_app".equalsIgnoreCase(str2)) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzio)).booleanValue()) {
                zzk(true);
                String str5 = (String) map.get("p");
                if (str5 == null) {
                    int i4 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Package name missing from open app action.");
                    return;
                }
                if (zZzb && this.zze != null && zzl(zzaVar, zzcelVar.getContext(), str5, str3)) {
                    return;
                }
                PackageManager packageManager = zzcelVar.getContext().getPackageManager();
                if (packageManager == null) {
                    int i5 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Cannot get package manager from open app action.");
                    return;
                } else {
                    Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str5);
                    if (launchIntentForPackage != null) {
                        ((zzcfv) zzaVar).zzaJ(new com.google.android.gms.ads.internal.overlay.zzc(launchIntentForPackage, this.zzg), z2, z3, str3);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        zzk(true);
        String str6 = (String) map.get("intent_url");
        if (!TextUtils.isEmpty(str6)) {
            try {
                uri = Intent.parseUri(str6, 0);
            } catch (URISyntaxException e) {
                String strValueOf = String.valueOf(str6);
                int i6 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Error parsing the url: ".concat(strValueOf), e);
            }
        }
        Intent intent = uri;
        if (intent != null && intent.getData() != null) {
            Uri data = intent.getData();
            if (!Uri.EMPTY.equals(data)) {
                Uri uriZzd2 = zzd(zzc(zzcelVar.getContext(), zzcelVar.zzI(), data, zzcelVar.zzF(), zzcelVar.zzi(), zzcelVar.zzS()));
                if (TextUtils.isEmpty(intent.getType())) {
                    intent.setData(uriZzd2);
                } else {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzip)).booleanValue()) {
                        intent.setDataAndType(uriZzd2, intent.getType());
                    } else {
                        intent.setData(uriZzd2);
                    }
                }
            }
        }
        boolean z4 = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zziK)).booleanValue() && "intent_async".equalsIgnoreCase(str2) && map.containsKey("event_id");
        HashMap map3 = new HashMap();
        if (z4) {
            map2 = map3;
            obj = "event_id";
            this.zzg = new zzbjt(this, z2, zzaVar, map2, map);
            z = false;
        } else {
            map2 = map3;
            obj = "event_id";
            z = z2;
        }
        if (intent != null) {
            if (!zZzb || this.zze == null || !zzl(zzaVar, zzcelVar.getContext(), intent.getData().toString(), str3)) {
                ((zzcfv) zzaVar).zzaJ(new com.google.android.gms.ads.internal.overlay.zzc(intent, this.zzg), z, z3, str3);
                return;
            } else {
                if (z4) {
                    HashMap map4 = map2;
                    map4.put((String) map.get(obj), true);
                    ((zzbme) zzaVar).zzd("openIntentAsync", map4);
                    return;
                }
                return;
            }
        }
        HashMap map5 = map2;
        if (TextUtils.isEmpty(str)) {
            string = str;
        } else {
            string = zzd(zzc(zzcelVar.getContext(), zzcelVar.zzI(), Uri.parse(str), zzcelVar.zzF(), zzcelVar.zzi(), zzcelVar.zzS())).toString();
        }
        if (!zZzb || this.zze == null || !zzl(zzaVar, zzcelVar.getContext(), string, str3)) {
            ((zzcfv) zzaVar).zzaJ(new com.google.android.gms.ads.internal.overlay.zzc((String) map.get("i"), string, (String) map.get("m"), (String) map.get("p"), (String) map.get(ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM), (String) map.get(InneractiveMediationDefs.GENDER_FEMALE), (String) map.get("e"), this.zzg), z, z3, str3);
        } else if (z4) {
            map5.put((String) map.get(obj), true);
            ((zzbme) zzaVar).zzd("openIntentAsync", map5);
        }
    }

    private final void zzi(Context context, String str, String str2) {
        zzeat zzeatVar = this.zze;
        zzeatVar.zzc(str);
        zzdre zzdreVar = this.zzb;
        if (zzdreVar != null) {
            zzebe.zzp(context, zzdreVar, zzeatVar, str, "dialog_not_shown", zzfwz.zze("dialog_not_shown_reason", str2));
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x010a  */
    /* JADX WARN: Code duplicated, block: B:32:0x0112  */
    /* JADX WARN: Code duplicated, block: B:46:0x015c A[PHI: r22
  0x015c: PHI (r22v2 java.util.ArrayList) = (r22v1 java.util.ArrayList), (r22v1 java.util.ArrayList), (r22v1 java.util.ArrayList), (r22v3 java.util.ArrayList) binds: [B:32:0x0112, B:33:0x0114, B:35:0x011a, B:66:0x015c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:48:0x0160  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v22, types: [android.content.Intent] */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    private final void zzj(com.google.android.gms.ads.internal.client.zza zzaVar, Map map, boolean z, String str, boolean z2, boolean z3) {
        ?? r2;
        ArrayList arrayList;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ResolveInfo resolveInfoZzc;
        Intent intentZzb;
        com.google.android.gms.ads.internal.client.zza zzaVar2;
        boolean z4 = true;
        zzk(true);
        zzcel zzcelVar = (zzcel) zzaVar;
        Context context = zzcelVar.getContext();
        zzauy zzauyVarZzI = zzcelVar.zzI();
        View viewZzF = zzcelVar.zzF();
        zzfbt zzfbtVarZzS = zzcelVar.zzS();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        String str2 = (String) map.get(ApsMetricsDataMap.APSMETRICS_FIELD_URL);
        Object objBuild = null;
        if (TextUtils.isEmpty(str2)) {
            r2 = objBuild;
        } else {
            Uri uriZzd = zzd(zzc(context, zzauyVarZzI, Uri.parse(str2), viewZzF, null, zzfbtVarZzS));
            boolean z5 = Boolean.parseBoolean((String) map.get("use_first_package"));
            boolean z6 = Boolean.parseBoolean((String) map.get("use_running_process"));
            if (!Boolean.parseBoolean((String) map.get("use_custom_tabs"))) {
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzeJ)).booleanValue()) {
                    z4 = false;
                }
            }
            if ("http".equalsIgnoreCase(uriZzd.getScheme())) {
                objBuild = uriZzd.buildUpon().scheme("https").build();
            } else if ("https".equalsIgnoreCase(uriZzd.getScheme())) {
                objBuild = uriZzd.buildUpon().scheme("http").build();
            }
            ?? r3 = objBuild;
            ArrayList arrayList2 = new ArrayList();
            Intent intentZza = zzbju.zza(uriZzd, context, zzauyVarZzI, viewZzF, zzfbtVarZzS);
            Intent intentZza2 = zzbju.zza(r3, context, zzauyVarZzI, viewZzF, zzfbtVarZzS);
            if (z4) {
                com.google.android.gms.ads.internal.zzv.zzq();
                com.google.android.gms.ads.internal.util.zzs.zzp(context, intentZza);
                com.google.android.gms.ads.internal.zzv.zzq();
                com.google.android.gms.ads.internal.util.zzs.zzp(context, intentZza2);
            }
            ArrayList arrayList3 = arrayList2;
            ResolveInfo resolveInfoZzd = zzbju.zzd(intentZza, arrayList2, context, zzauyVarZzI, viewZzF, zzfbtVarZzS);
            if (resolveInfoZzd != null) {
                objBuild = zzbju.zzb(intentZza, resolveInfoZzd, context, zzauyVarZzI, viewZzF, zzfbtVarZzS);
            } else if (intentZza2 == null || (resolveInfoZzc = zzbju.zzc(intentZza2, context, zzauyVarZzI, viewZzF, zzfbtVarZzS)) == null) {
                r2 = intentZzb;
                if (!arrayList3.isEmpty()) {
                    if (z6 || activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                        arrayList = arrayList3;
                        if (z5) {
                            objBuild = zzbju.zzb(intentZza, (ResolveInfo) arrayList.get(0), context, zzauyVarZzI, viewZzF, zzfbtVarZzS);
                        }
                    } else {
                        int size = arrayList3.size();
                        int i = 0;
                        while (true) {
                            if (i < size) {
                                ArrayList arrayList4 = arrayList3;
                                ResolveInfo resolveInfo = (ResolveInfo) arrayList4.get(i);
                                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                                while (true) {
                                    int i2 = i + 1;
                                    if (!it.hasNext()) {
                                        arrayList3 = arrayList4;
                                        i = i2;
                                    } else if (it.next().processName.equals(resolveInfo.activityInfo.packageName)) {
                                        objBuild = zzbju.zzb(intentZza, resolveInfo, context, zzauyVarZzI, viewZzF, zzfbtVarZzS);
                                    }
                                }
                            } else {
                                arrayList = arrayList3;
                                if (z5) {
                                    objBuild = zzbju.zzb(intentZza, (ResolveInfo) arrayList.get(0), context, zzauyVarZzI, viewZzF, zzfbtVarZzS);
                                }
                            }
                        }
                    }
                }
                r2 = intentZza;
            } else {
                intentZzb = zzbju.zzb(intentZza, resolveInfoZzc, context, zzauyVarZzI, viewZzF, zzfbtVarZzS);
                if (zzbju.zzc(intentZzb, context, zzauyVarZzI, viewZzF, zzfbtVarZzS) == null) {
                    r2 = intentZzb;
                    if (!arrayList3.isEmpty()) {
                        if (z6) {
                            arrayList = arrayList3;
                            if (z5) {
                                objBuild = zzbju.zzb(intentZza, (ResolveInfo) arrayList.get(0), context, zzauyVarZzI, viewZzF, zzfbtVarZzS);
                            }
                        } else {
                            arrayList = arrayList3;
                            if (z5) {
                                objBuild = zzbju.zzb(intentZza, (ResolveInfo) arrayList.get(0), context, zzauyVarZzI, viewZzF, zzfbtVarZzS);
                            }
                        }
                    }
                    r2 = intentZza;
                }
            }
            r2 = objBuild;
        }
        if (!z || this.zze == null || r2 == 0) {
            zzaVar2 = zzaVar;
        } else {
            zzaVar2 = zzaVar;
            if (zzl(zzaVar2, zzcelVar.getContext(), r2.getData().toString(), str)) {
                return;
            }
        }
        try {
            ((zzcfv) zzaVar2).zzaJ(new com.google.android.gms.ads.internal.overlay.zzc(r2, this.zzg), z2, z3, str);
        } catch (ActivityNotFoundException e) {
            String message = e.getMessage();
            int i3 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj(message);
        }
    }

    private final void zzk(boolean z) {
        zzbrw zzbrwVar = this.zzd;
        if (zzbrwVar != null) {
            zzbrwVar.zzb(z);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x005e, code lost:
    
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(com.google.android.gms.internal.ads.zzbci.zziE)).booleanValue() != false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00c8, code lost:
    
        if ((android.os.Build.VERSION.SDK_INT < 33 ? ((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(com.google.android.gms.internal.ads.zzbci.zziz)).booleanValue() : ((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(com.google.android.gms.internal.ads.zzbci.zziy)).booleanValue()) != false) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean zzl(com.google.android.gms.ads.internal.client.zza r9, android.content.Context r10, java.lang.String r11, java.lang.String r12) {
        /*
            Method dump skipped, instruction units count: 335
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbjv.zzl(com.google.android.gms.ads.internal.client.zza, android.content.Context, java.lang.String, java.lang.String):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzm(int i) {
        zzdre zzdreVar;
        String str;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzeM)).booleanValue() || (zzdreVar = this.zzb) == null) {
            return;
        }
        zzdrd zzdrdVarZza = zzdreVar.zza();
        zzdrdVarZza.zzb("action", "cct_action");
        switch (i) {
            case 2:
                str = "CONTEXT_NOT_AN_ACTIVITY";
                break;
            case 3:
                str = "CONTEXT_NULL";
                break;
            case 4:
                str = "CCT_NOT_SUPPORTED";
                break;
            case 5:
                str = "CCT_READY_TO_OPEN";
                break;
            case 6:
                str = "ACTIVITY_NOT_FOUND";
                break;
            case 7:
                str = "EMPTY_URL";
                break;
            case 8:
                str = "UNKNOWN";
                break;
            case 9:
                str = "WRONG_EXP_SETUP";
                break;
            default:
                str = "OPT_OUT";
                break;
        }
        zzdrdVarZza.zzb("cct_open_status", str);
        zzdrdVarZza.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzbjj
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzclx zzclxVar;
        com.google.android.gms.ads.internal.client.zza zzaVar = (com.google.android.gms.ads.internal.client.zza) obj;
        String str = (String) map.get(ApsMetricsDataMap.APSMETRICS_FIELD_URL);
        Map map2 = new HashMap();
        zzcel zzcelVar = (zzcel) zzaVar;
        if (zzcelVar.zzD() != null) {
            map2 = zzcelVar.zzD().zzaw;
        }
        String strZzc = zzbxy.zzc(str, zzcelVar.getContext(), true, map2);
        String str2 = (String) map.get("a");
        if (str2 == null) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Action missing from an open GMSG.");
            return;
        }
        com.google.android.gms.ads.internal.zzb zzbVar = this.zza;
        if (zzbVar == null || zzbVar.zzc()) {
            zzgbs.zzr((((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzkf)).booleanValue() && (zzclxVar = this.zzf) != null && zzclx.zzj(strZzc)) ? zzclxVar.zze(strZzc, com.google.android.gms.ads.internal.client.zzbb.zze()) : zzgbs.zzh(strZzc), new zzbjr(this, map, zzaVar, str2), this.zzh);
        } else {
            zzbVar.zzb(strZzc);
        }
    }
}
