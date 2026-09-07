package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.util.IOUtils;
import com.safedk.android.internal.partials.AdMobNetworkBridge;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdyy implements zzfex {
    protected final Context zza;
    protected final String zzb;

    public zzdyy(Context context, String str, zzbvg zzbvgVar, int i) {
        this.zza = context;
        this.zzb = str;
    }

    @Override // com.google.android.gms.internal.ads.zzfex
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzdyx zza(zzdyw zzdywVar) throws zzdvg {
        return zzc(zzdywVar.zza, zzdywVar.zzb, zzdywVar.zzc, zzdywVar.zzd, zzdywVar.zze, com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime());
    }

    protected final zzdyx zzc(String str, int i, Map map, byte[] bArr, String str2, long j) throws MalformedURLException, zzdvg {
        HttpURLConnection httpURLConnection;
        URL url;
        try {
            zzdyx zzdyxVar = new zzdyx();
            String str3 = this.zzb;
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("SDK version: " + str3);
            com.google.android.gms.ads.internal.util.client.zzo.zze("AdRequestServiceImpl: Sending request: " + str);
            URL url2 = new URL(str);
            HashMap map2 = new HashMap();
            int i3 = 0;
            while (true) {
                int i4 = zzfpj.zzb;
                httpURLConnection = (HttpURLConnection) url2.openConnection();
                try {
                    try {
                        com.google.android.gms.ads.internal.zzv.zzq().zzg(this.zza, str3, false, httpURLConnection, false, i);
                        for (Map.Entry entry : map.entrySet()) {
                            httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            httpURLConnection.setRequestProperty("Content-Type", str2);
                        }
                        Closeable closeable = null;
                        com.google.android.gms.ads.internal.util.client.zzl zzlVar = new com.google.android.gms.ads.internal.util.client.zzl(null);
                        try {
                            zzlVar.zzc(httpURLConnection, bArr);
                        } catch (Throwable th) {
                            com.google.android.gms.ads.internal.util.client.zzo.zzh("Network request logging failed.", th);
                            com.google.android.gms.ads.internal.zzv.zzp().zzv(th, "HttpRequestFunction.logAdRequest");
                        }
                        int length = bArr.length;
                        if (length > 0) {
                            httpURLConnection.setDoOutput(true);
                            httpURLConnection.setFixedLengthStreamingMode(length);
                            try {
                                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(AdMobNetworkBridge.urlConnectionGetOutputStream(httpURLConnection));
                                try {
                                    bufferedOutputStream.write(bArr);
                                    IOUtils.closeQuietly(bufferedOutputStream);
                                } catch (Throwable th2) {
                                    th = th2;
                                    closeable = bufferedOutputStream;
                                    IOUtils.closeQuietly(closeable);
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        }
                        int iHttpUrlConnectionGetResponseCode = AdMobNetworkBridge.httpUrlConnectionGetResponseCode(httpURLConnection);
                        for (Map.Entry<String, List<String>> entry2 : httpURLConnection.getHeaderFields().entrySet()) {
                            String key = entry2.getKey();
                            List<String> value = entry2.getValue();
                            if (map2.containsKey(key)) {
                                ((List) map2.get(key)).addAll(value);
                            } else {
                                map2.put(key, new ArrayList(value));
                            }
                        }
                        zzlVar.zze(httpURLConnection, iHttpUrlConnectionGetResponseCode);
                        zzdyxVar.zza = iHttpUrlConnectionGetResponseCode;
                        zzdyxVar.zzb = map2;
                        zzdyxVar.zzc = "";
                        if (iHttpUrlConnectionGetResponseCode >= 200 && iHttpUrlConnectionGetResponseCode < 300) {
                            try {
                                InputStreamReader inputStreamReader = new InputStreamReader(AdMobNetworkBridge.urlConnectionGetInputStream(httpURLConnection));
                                try {
                                    com.google.android.gms.ads.internal.zzv.zzq();
                                    StringBuilder sb = new StringBuilder(8192);
                                    char[] cArr = new char[2048];
                                    while (true) {
                                        int i5 = inputStreamReader.read(cArr);
                                        if (i5 == -1) {
                                            break;
                                        }
                                        sb.append(cArr, 0, i5);
                                    }
                                    String string = sb.toString();
                                    IOUtils.closeQuietly(inputStreamReader);
                                    zzlVar.zzg(string);
                                    zzdyxVar.zzc = string;
                                    if (TextUtils.isEmpty(string)) {
                                        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfC)).booleanValue()) {
                                            throw new zzdvg(3);
                                        }
                                    }
                                    zzdyxVar.zzd = com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime() - j;
                                    break;
                                } catch (Throwable th4) {
                                    th = th4;
                                    closeable = inputStreamReader;
                                    IOUtils.closeQuietly(closeable);
                                    throw th;
                                }
                            } catch (Throwable th5) {
                                th = th5;
                            }
                        } else {
                            if (iHttpUrlConnectionGetResponseCode < 300 || iHttpUrlConnectionGetResponseCode >= 400) {
                                com.google.android.gms.ads.internal.util.client.zzo.zzj("Received error HTTP response code: " + iHttpUrlConnectionGetResponseCode);
                                throw new zzdvg(1, "Received error HTTP response code: " + iHttpUrlConnectionGetResponseCode);
                            }
                            String headerField = httpURLConnection.getHeaderField("Location");
                            if (TextUtils.isEmpty(headerField)) {
                                com.google.android.gms.ads.internal.util.client.zzo.zzj("No location header to follow redirect.");
                                throw new zzdvg(1, "No location header to follow redirect");
                            }
                            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzhR)).booleanValue()) {
                                try {
                                    url = new URI(headerField).toURL();
                                } catch (URISyntaxException e) {
                                    throw new zzdvg(1, e.getMessage(), e);
                                }
                            } else {
                                url = new URL(headerField);
                            }
                            int i6 = i3 + 1;
                            if (i6 > ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfl)).intValue()) {
                                com.google.android.gms.ads.internal.util.client.zzo.zzj("Too many redirects.");
                                throw new zzdvg(1, "Too many redirects");
                            }
                            AdMobNetworkBridge.httpUrlConnectionDisconnect(httpURLConnection);
                            i3 = i6;
                            url2 = url;
                        }
                    } catch (zzdvg e2) {
                        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzis)).booleanValue()) {
                            throw e2;
                        }
                        zzdyxVar.zzd = com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime() - j;
                    }
                } catch (Throwable th6) {
                    AdMobNetworkBridge.httpUrlConnectionDisconnect(httpURLConnection);
                    throw th6;
                }
            }
            AdMobNetworkBridge.httpUrlConnectionDisconnect(httpURLConnection);
            return zzdyxVar;
        } catch (IOException e3) {
            String strValueOf = String.valueOf(e3.getMessage());
            int i7 = com.google.android.gms.ads.internal.util.zze.zza;
            String strConcat = "Error while connecting to ad server: ".concat(strValueOf);
            com.google.android.gms.ads.internal.util.client.zzo.zzj(strConcat);
            throw new zzdvg(1, strConcat, e3);
        }
    }
}
