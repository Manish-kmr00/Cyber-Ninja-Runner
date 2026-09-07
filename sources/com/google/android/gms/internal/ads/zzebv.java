package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes6.dex */
public interface zzebv {
    zzeca zza(String str, WebView webView, String str2, String str3, String str4, zzebx zzebxVar, zzebw zzebwVar, String str5);

    zzeca zzb(String str, WebView webView, String str2, String str3, String str4, String str5, zzebx zzebxVar, zzebw zzebwVar, String str6);

    zzfkg zze(VersionInfoParcel versionInfoParcel, WebView webView, boolean z);

    String zzf(Context context);

    void zzg(zzfjv zzfjvVar, View view);

    void zzh(zzfkg zzfkgVar, View view);

    void zzi(zzfjv zzfjvVar);

    void zzj(zzfjv zzfjvVar, View view);

    void zzk(zzfjv zzfjvVar);

    boolean zzl(Context context);

    void zzm(zzfkg zzfkgVar, zzcfc zzcfcVar);
}
