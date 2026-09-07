package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import com.json.b9;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdwu {
    private static final Pattern zza = Pattern.compile("\\?");
    private final zzcgl zzb;
    private final Context zzc;
    private final VersionInfoParcel zzd;
    private final zzfbp zze;
    private final Executor zzf;
    private final ScheduledExecutorService zzg;
    private final String zzh;
    private final zzfgn zzi;
    private final zzdqy zzj;
    private final zzfio zzk;
    private final Object zzl = new Object();
    private String zzm;
    private List zzn;
    private final zzbvg zzo;

    zzdwu(zzcgl zzcglVar, Context context, VersionInfoParcel versionInfoParcel, zzfbp zzfbpVar, Executor executor, String str, zzfgn zzfgnVar, zzdqy zzdqyVar, zzbvg zzbvgVar, zzdyz zzdyzVar, ScheduledExecutorService scheduledExecutorService, zzfio zzfioVar) {
        this.zzb = zzcglVar;
        this.zzc = context;
        this.zzd = versionInfoParcel;
        this.zze = zzfbpVar;
        this.zzf = executor;
        this.zzh = str;
        this.zzi = zzfgnVar;
        zzcglVar.zzw();
        this.zzj = zzdqyVar;
        this.zzo = zzbvgVar;
        this.zzg = scheduledExecutorService;
        this.zzk = zzfioVar;
    }

    public static /* synthetic */ ListenableFuture zza(zzdwu zzdwuVar, List list, Exception exc) {
        zzefy zzefyVar;
        com.google.android.gms.ads.internal.zzv.zzp().zzv(exc, "PreloadedLoader.getTypeTwoAdResponseString");
        if (exc instanceof TimeoutException) {
            zzefyVar = new zzefy(1, "Timed out waiting for ad response.");
        } else if (exc instanceof zzefy) {
            zzefyVar = (zzefy) exc;
        } else {
            zzefyVar = new zzefy(1, exc.getMessage() == null ? "Fetch failed." : exc.getMessage());
        }
        String message = zzefyVar.getMessage() == null ? "" : zzefyVar.getMessage();
        if (list != null && !list.isEmpty()) {
            String str = "0.6.0.0";
            if (!TextUtils.isEmpty(message)) {
                if (message.contains("Timed out waiting for ad response.")) {
                    message = "timeout";
                    str = "0.2.0.0";
                } else if (message.contains("Received HTTP error code from ad server:")) {
                    List listZzf = zzful.zzb(zzfth.zzc(AbstractJsonLexerKt.COLON)).zzf(message);
                    if (listZzf.size() == 2) {
                        message = (String) listZzf.get(1);
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(zzfik.zzc(zzfik.zzc((String) it.next(), "@gw_adnetstatus@", str), "@error_code@", message));
            }
            zzdwuVar.zzk.zze(arrayList, null);
        }
        return zzgbs.zzg(zzefyVar);
    }

    public static /* synthetic */ String zzd(zzdwu zzdwuVar, zzdyw zzdywVar) throws zzefy {
        zzdwuVar.zzg(zzdqm.RENDERING_ADSTRING_TYPE2_FETCH_START);
        int i = 0;
        int i2 = -1;
        while (true) {
            try {
                if (i >= ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzhf)).intValue()) {
                    throw new zzefy(1, "Received HTTP error code from ad server:" + i2);
                }
                zzdyx zzdyxVarZzb = new zzdyy(zzdwuVar.zzc, zzdwuVar.zzd.afmaVersion, zzdwuVar.zzo, Binder.getCallingUid()).zza(zzdywVar);
                zzdyx zzdyxVar = zzdyxVarZzb;
                int i3 = zzdyxVarZzb.zza;
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzhg)).booleanValue()) {
                    zzdwuVar.zzj.zzd("fr", String.valueOf(i));
                }
                if (i3 == 200) {
                    zzdwuVar.zzg(zzdqm.RENDERING_ADSTRING_TYPE2_FETCH_END);
                    return zzdyxVarZzb.zzc;
                }
                i++;
                i2 = i3;
            } catch (Exception e) {
                throw new zzefy(1, e.getMessage() == null ? "Fetch failed." : e.getMessage(), e);
            }
        }
    }

    private final ListenableFuture zze(String str, final String str2) {
        ListenableFuture listenableFutureZzh;
        String str3 = "";
        if (TextUtils.isEmpty(str)) {
            return zzgbs.zzg(new zzefy(15, "Invalid ad string."));
        }
        Context context = this.zzc;
        zzfgc zzfgcVarZza = zzfgb.zza(context, 11);
        zzfgcVarZza.zzi();
        final zzbnq zzbnqVarZza = com.google.android.gms.ads.internal.zzv.zzg().zza(context, this.zzd, this.zzb.zzy()).zza("google.afma.response.normalize", zzbnx.zza, zzbnx.zza);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzhb)).booleanValue()) {
            try {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.zzm = jSONObject.optString("fetch_url", "");
                    this.zzn = com.google.android.gms.ads.internal.util.zzbs.zzc(new JSONObject(jSONObject.optString("settings", "")).getJSONArray("nofill_urls"), null);
                } catch (JSONException unused) {
                    int i = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Invalid ad response.");
                }
            } catch (JSONException unused2) {
            }
            String string = this.zzm;
            final List list = this.zzn;
            if (TextUtils.isEmpty(string)) {
                listenableFutureZzh = zzgbs.zzh(str);
                this.zzj.zzd("sst", "1");
            } else {
                this.zzj.zzd("sst", "2");
                String str4 = (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzhd);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzhc)).booleanValue()) {
                    List listZzf = zzful.zzc(zza).zzf(string);
                    if (listZzf.size() < 2) {
                        listenableFutureZzh = zzgbs.zzg(new zzefy(1, "Invalid fetch URL."));
                    } else {
                        str3 = (String) listZzf.get(1);
                        com.google.android.gms.ads.internal.zzv.zzq();
                        string = Uri.parse(string).buildUpon().query(null).build().toString();
                        final zzdyw zzdywVar = new zzdyw(string, 60000, new HashMap(), str3.getBytes(StandardCharsets.UTF_8), str4, false);
                        listenableFutureZzh = (zzgbj) zzgbs.zzf((zzgbj) zzgbs.zzo(zzgbj.zzE(zzbzk.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzdws
                            @Override // java.util.concurrent.Callable
                            public final Object call() {
                                return zzdwu.zzd(this.zza, zzdywVar);
                            }
                        })), ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzhe)).intValue(), TimeUnit.MILLISECONDS, this.zzg), Exception.class, new zzgaz() { // from class: com.google.android.gms.internal.ads.zzdwt
                            @Override // com.google.android.gms.internal.ads.zzgaz
                            public final ListenableFuture zza(Object obj) {
                                return zzdwu.zza(this.zza, list, (Exception) obj);
                            }
                        }, this.zzf);
                    }
                } else {
                    final zzdyw zzdywVar2 = new zzdyw(string, 60000, new HashMap(), str3.getBytes(StandardCharsets.UTF_8), str4, false);
                    listenableFutureZzh = (zzgbj) zzgbs.zzf((zzgbj) zzgbs.zzo(zzgbj.zzE(zzbzk.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzdws
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            return zzdwu.zzd(this.zza, zzdywVar2);
                        }
                    })), ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzhe)).intValue(), TimeUnit.MILLISECONDS, this.zzg), Exception.class, new zzgaz() { // from class: com.google.android.gms.internal.ads.zzdwt
                        @Override // com.google.android.gms.internal.ads.zzgaz
                        public final ListenableFuture zza(Object obj) {
                            return zzdwu.zza(this.zza, list, (Exception) obj);
                        }
                    }, this.zzf);
                }
            }
        } else {
            listenableFutureZzh = zzgbs.zzh(str);
            this.zzj.zzd("sst", "1");
        }
        zzgaz zzgazVar = new zzgaz(this) { // from class: com.google.android.gms.internal.ads.zzdwp
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj) throws JSONException {
                String str5 = (String) obj;
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                JSONObject jSONObject4 = new JSONObject();
                String str6 = str2;
                try {
                    jSONObject4.put("headers", new JSONObject());
                    jSONObject4.put("body", str5);
                    jSONObject3.put("base_url", "");
                    jSONObject3.put("signals", new JSONObject(str6));
                    jSONObject2.put("request", jSONObject3);
                    jSONObject2.put("response", jSONObject4);
                    jSONObject2.put("flags", new JSONObject());
                    return zzgbs.zzh(jSONObject2);
                } catch (JSONException e) {
                    throw new JSONException("Preloaded loader: ".concat(String.valueOf(String.valueOf(e.getCause()))));
                }
            }
        };
        Executor executor = this.zzf;
        ListenableFuture listenableFutureZzn = zzgbs.zzn(zzgbs.zzn(zzgbs.zzn(listenableFutureZzh, zzgazVar, executor), new zzgaz() { // from class: com.google.android.gms.internal.ads.zzdwq
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj) {
                return zzbnqVarZza.zzb((JSONObject) obj);
            }
        }, executor), new zzgaz() { // from class: com.google.android.gms.internal.ads.zzdwr
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj) {
                return zzgbs.zzh(new zzfbg(new zzfbd(this.zza.zze), zzfbf.zza(new StringReader(((JSONObject) obj).toString()), null)));
            }
        }, executor);
        zzfgm.zza(listenableFutureZzn, this.zzi, zzfgcVarZza);
        return listenableFutureZzn;
    }

    private final String zzf(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = jSONObject.getJSONArray("ad_types");
            if (jSONArray != null && "unknown".equals(jSONArray.getString(0))) {
                jSONObject.put("ad_types", new JSONArray().put(this.zzh));
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            String strConcat = "Failed to update the ad types for rendering. ".concat(e.toString());
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj(strConcat);
            return str;
        }
    }

    private final void zzg(zzdqm zzdqmVar) {
        Bundle bundleZza = this.zzj.zza();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzhg)).booleanValue()) {
            bundleZza.putLong(zzdqmVar.zza(), com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis());
        }
    }

    private static final String zzh(String str) {
        try {
            return new JSONObject(str).optString("request_id", "");
        } catch (JSONException unused) {
            return "";
        }
    }

    /* JADX WARN: Code duplicated, block: B:114:0x00f9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:32:0x00d0 A[Catch: all -> 0x0210, TRY_ENTER, TryCatch #2 {, blocks: (B:18:0x0051, B:20:0x0071, B:22:0x0077, B:24:0x008e, B:26:0x0096, B:32:0x00d0, B:34:0x00d8, B:36:0x00de, B:40:0x00e7, B:47:0x011d, B:43:0x00f9, B:46:0x0106, B:52:0x0125, B:29:0x00c0, B:53:0x013b, B:60:0x0154, B:63:0x015c, B:67:0x0180, B:69:0x0195, B:73:0x01b8, B:75:0x01cd, B:78:0x01e1, B:80:0x01e7, B:81:0x01f4, B:83:0x01f6, B:86:0x01ff, B:85:0x01fc, B:74:0x01c2, B:70:0x01a8, B:66:0x016a, B:57:0x0144, B:58:0x0149), top: B:111:0x0051, inners: #6 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x00d8 A[Catch: all -> 0x0210, TryCatch #2 {, blocks: (B:18:0x0051, B:20:0x0071, B:22:0x0077, B:24:0x008e, B:26:0x0096, B:32:0x00d0, B:34:0x00d8, B:36:0x00de, B:40:0x00e7, B:47:0x011d, B:43:0x00f9, B:46:0x0106, B:52:0x0125, B:29:0x00c0, B:53:0x013b, B:60:0x0154, B:63:0x015c, B:67:0x0180, B:69:0x0195, B:73:0x01b8, B:75:0x01cd, B:78:0x01e1, B:80:0x01e7, B:81:0x01f4, B:83:0x01f6, B:86:0x01ff, B:85:0x01fc, B:74:0x01c2, B:70:0x01a8, B:66:0x016a, B:57:0x0144, B:58:0x0149), top: B:111:0x0051, inners: #6 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:39:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:42:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:85:0x01fc A[Catch: all -> 0x0210, TryCatch #2 {, blocks: (B:18:0x0051, B:20:0x0071, B:22:0x0077, B:24:0x008e, B:26:0x0096, B:32:0x00d0, B:34:0x00d8, B:36:0x00de, B:40:0x00e7, B:47:0x011d, B:43:0x00f9, B:46:0x0106, B:52:0x0125, B:29:0x00c0, B:53:0x013b, B:60:0x0154, B:63:0x015c, B:67:0x0180, B:69:0x0195, B:73:0x01b8, B:75:0x01cd, B:78:0x01e1, B:80:0x01e7, B:81:0x01f4, B:83:0x01f6, B:86:0x01ff, B:85:0x01fc, B:74:0x01c2, B:70:0x01a8, B:66:0x016a, B:57:0x0144, B:58:0x0149), top: B:111:0x0051, inners: #6 }] */
    public final ListenableFuture zzc() {
        String strOptString;
        int i;
        int iLastIndexOf;
        String strSubstring;
        String string;
        String strZzb = this.zze.zzd.zzx;
        if (!TextUtils.isEmpty(strZzb)) {
            String strZzh = zzh(strZzb);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgY)).booleanValue() && strZzh.isEmpty()) {
                int iLastIndexOf2 = strZzb.lastIndexOf("&request_id=");
                strZzh = iLastIndexOf2 != -1 ? strZzb.substring(iLastIndexOf2 + 12) : "";
            }
            if (TextUtils.isEmpty(strZzh)) {
                return zzgbs.zzg(new zzefy(15, "Invalid ad string."));
            }
            synchronized (this.zzl) {
                com.google.android.gms.ads.nonagon.signalgeneration.zzv zzvVarZzn = this.zzb.zzn();
                zzdqy zzdqyVar = this.zzj;
                String strZzb2 = zzvVarZzn.zzb(strZzh, zzdqyVar);
                String str = null;
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgY)).booleanValue() && !TextUtils.isEmpty(strZzb2)) {
                    try {
                        JSONObject jSONObject = new JSONObject(strZzb2);
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgZ)).booleanValue()) {
                            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("extras");
                            if (jSONObjectOptJSONObject != null) {
                                if (Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzha)).split(StringUtils.COMMA)).contains(com.google.android.gms.ads.nonagon.signalgeneration.zzaa.zzb(jSONObjectOptJSONObject.optString("query_info_type", "")))) {
                                    iLastIndexOf = strZzb.lastIndexOf(b9.i.c);
                                    if (iLastIndexOf != -1) {
                                        strSubstring = strZzb.substring(0, iLastIndexOf);
                                    } else {
                                        strSubstring = null;
                                    }
                                    if (!TextUtils.isEmpty(strSubstring)) {
                                        try {
                                            byte[] bArrDecode = Base64.decode(strSubstring, 11);
                                            byte[] bytes = strZzh.getBytes("UTF-8");
                                            if (TextUtils.isEmpty(strZzb2)) {
                                                string = null;
                                            } else {
                                                try {
                                                    string = new JSONObject(strZzb2).getString("arek");
                                                } catch (JSONException e) {
                                                    com.google.android.gms.ads.internal.util.zze.zza("Failed to get key from QueryJSONMap".concat(e.toString()));
                                                    com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "CryptoUtils.getKeyFromQueryJsonMap");
                                                    string = null;
                                                }
                                            }
                                            strZzb = zzfce.zzb(bArrDecode, bytes, string, zzdqyVar);
                                        } catch (UnsupportedEncodingException | IllegalArgumentException e2) {
                                            com.google.android.gms.ads.internal.util.zze.zza("Failed to decode the adResponse. ".concat(e2.toString()));
                                            com.google.android.gms.ads.internal.zzv.zzp().zzw(e2, "PreloadedLoader.decryptAdResponseIfNecessary");
                                        }
                                    }
                                }
                            }
                        } else if (jSONObject.optString("is_gbid").equals("true")) {
                            iLastIndexOf = strZzb.lastIndexOf(b9.i.c);
                            if (iLastIndexOf != -1) {
                                strSubstring = strZzb.substring(0, iLastIndexOf);
                            } else {
                                strSubstring = null;
                            }
                            if (!TextUtils.isEmpty(strSubstring)) {
                                byte[] bArrDecode2 = Base64.decode(strSubstring, 11);
                                byte[] bytes2 = strZzh.getBytes("UTF-8");
                                if (TextUtils.isEmpty(strZzb2)) {
                                    string = null;
                                } else {
                                    string = new JSONObject(strZzb2).getString("arek");
                                }
                                strZzb = zzfce.zzb(bArrDecode2, bytes2, string, zzdqyVar);
                            }
                        }
                    } catch (JSONException unused) {
                    }
                }
                if (TextUtils.isEmpty(strZzb)) {
                    strOptString = "";
                } else {
                    try {
                        strOptString = new JSONObject(strZzb).optString("render_id", "");
                    } catch (JSONException unused2) {
                        strOptString = "";
                    }
                }
                if (TextUtils.isEmpty(strOptString)) {
                    i = 0;
                } else {
                    String str2 = "";
                    try {
                        str2 = new String(Base64.decode(strOptString, 0), StandardCharsets.UTF_8);
                    } catch (IllegalArgumentException e3) {
                        com.google.android.gms.ads.internal.util.zze.zza("Ad grouping: Has render_id, but not base64 encoded: ".concat(String.valueOf(strOptString)));
                        com.google.android.gms.ads.internal.zzv.zzp().zzw(e3, "PreloadedLoader.decodeRenderId");
                    }
                    List listZzf = zzful.zzb(zzfth.zzc(AbstractJsonLexerKt.COLON)).zzf(str2);
                    if (listZzf.size() == 2) {
                        str = (String) listZzf.get(0);
                        i = Integer.parseInt((String) listZzf.get(1));
                    } else {
                        com.google.android.gms.ads.internal.util.zze.zza("Ad grouping: Has render_id, but invalid format: ".concat(String.valueOf(strOptString)));
                        i = 0;
                    }
                }
                Pair pair = str != null ? new Pair(str, Integer.valueOf(i)) : new Pair("", 0);
                String str3 = (String) pair.first;
                int iIntValue = ((Integer) pair.second).intValue();
                if (TextUtils.isEmpty(str3) || iIntValue <= 0) {
                    zzvVarZzn.zzf(strZzh);
                } else {
                    if (zzvVarZzn.zzh(strZzh, str3)) {
                        return zzgbs.zzg(new zzefy(10, "The ad has already been shown."));
                    }
                    if (!zzvVarZzn.zzg(strZzh, str3, iIntValue)) {
                        zzvVarZzn.zzf(strZzh);
                    }
                }
                if (!TextUtils.isEmpty(strZzb2)) {
                    return zze(strZzb, zzf(strZzb2));
                }
            }
        }
        com.google.android.gms.ads.internal.client.zzc zzcVar = this.zze.zzd.zzs;
        if (zzcVar != null) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgQ)).booleanValue()) {
                String str4 = zzcVar.zza;
                String str5 = zzcVar.zzb;
                String strZzh2 = zzh(str4);
                String strZzh3 = zzh(str5);
                if (TextUtils.isEmpty(strZzh3) || !strZzh2.equals(strZzh3)) {
                    this.zzj.zzb().put("ridmm", "true");
                } else {
                    this.zzb.zzn().zzf(strZzh2);
                    this.zzj.zzb().put("request_id", strZzh2);
                }
            }
            return zze(zzcVar.zza, zzf(zzcVar.zzb));
        }
        return zzgbs.zzg(new zzefy(14, "Mismatch request IDs."));
    }
}
