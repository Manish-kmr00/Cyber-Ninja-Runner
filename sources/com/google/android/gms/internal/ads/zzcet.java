package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.net.TrafficStats;
import android.net.Uri;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.view.ViewCompat;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.common.util.Predicate;
import com.google.common.net.HttpHeaders;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.internal.partials.AdMobNetworkBridge;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
@ParametersAreNonnullByDefault
public class zzcet extends WebViewClient implements zzcgd {
    public static final /* synthetic */ int zzb = 0;
    private zzdre zzA;
    private boolean zzB;
    private boolean zzC;
    private int zzD;
    private boolean zzE;
    private final zzebe zzG;
    private View.OnAttachStateChangeListener zzH;
    protected zzbxi zza;
    private final zzcel zzc;
    private final zzbbg zzd;
    private com.google.android.gms.ads.internal.client.zza zzg;
    private com.google.android.gms.ads.internal.overlay.zzr zzh;
    private zzcgb zzi;
    private zzcgc zzj;
    private zzbhz zzk;
    private zzbib zzl;
    private zzddc zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzs;
    private boolean zzt;
    private boolean zzu;
    private boolean zzv;
    private com.google.android.gms.ads.internal.overlay.zzac zzw;
    private zzbsb zzx;
    private com.google.android.gms.ads.internal.zzb zzy;
    private final HashMap zze = new HashMap();
    private final Object zzf = new Object();
    private int zzp = 0;
    private String zzq = "";
    private String zzr = "";
    private zzbrw zzz = null;
    private final HashSet zzF = new HashSet(Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfJ)).split(StringUtils.COMMA)));

    public zzcet(zzcel zzcelVar, zzbbg zzbbgVar, boolean z, zzbsb zzbsbVar, zzbrw zzbrwVar, zzebe zzebeVar) {
        this.zzd = zzbbgVar;
        this.zzc = zzcelVar;
        this.zzs = z;
        this.zzx = zzbsbVar;
        this.zzG = zzebeVar;
    }

    private static WebResourceResponse zzW() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzaY)).booleanValue()) {
            return new WebResourceResponse("", "", new ByteArrayInputStream(new byte[0]));
        }
        return null;
    }

    private final WebResourceResponse zzX(String str, Map map) throws IOException {
        URL url = new URL(str);
        try {
            TrafficStats.setThreadStatsTag(264);
            int i = 0;
            while (true) {
                i++;
                if (i > 20) {
                    TrafficStats.clearThreadStatsTag();
                    throw new IOException("Too many redirects (20)");
                }
                int i2 = zzfpj.zzb;
                URLConnection uRLConnectionOpenConnection = url.openConnection();
                uRLConnectionOpenConnection.setConnectTimeout(10000);
                uRLConnectionOpenConnection.setReadTimeout(10000);
                for (Map.Entry entry : map.entrySet()) {
                    uRLConnectionOpenConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
                if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
                    throw new IOException("Invalid protocol.");
                }
                HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
                com.google.android.gms.ads.internal.util.zzs zzsVarZzq = com.google.android.gms.ads.internal.zzv.zzq();
                zzcel zzcelVar = this.zzc;
                zzsVarZzq.zzg(zzcelVar.getContext(), zzcelVar.zzm().afmaVersion, false, httpURLConnection, false, 60000);
                WebResourceResponse webResourceResponseZzb = null;
                com.google.android.gms.ads.internal.util.client.zzl zzlVar = new com.google.android.gms.ads.internal.util.client.zzl(null);
                zzlVar.zzc(httpURLConnection, null);
                int iHttpUrlConnectionGetResponseCode = AdMobNetworkBridge.httpUrlConnectionGetResponseCode(httpURLConnection);
                zzlVar.zze(httpURLConnection, iHttpUrlConnectionGetResponseCode);
                if (iHttpUrlConnectionGetResponseCode < 300 || iHttpUrlConnectionGetResponseCode >= 400) {
                    com.google.android.gms.ads.internal.zzv.zzq();
                    com.google.android.gms.ads.internal.zzv.zzq();
                    String contentType = httpURLConnection.getContentType();
                    String strTrim = "";
                    String strTrim2 = TextUtils.isEmpty(contentType) ? "" : contentType.split(";")[0].trim();
                    com.google.android.gms.ads.internal.zzv.zzq();
                    String contentType2 = httpURLConnection.getContentType();
                    if (!TextUtils.isEmpty(contentType2)) {
                        String[] strArrSplit = contentType2.split(";");
                        if (strArrSplit.length != 1) {
                            for (int i3 = 1; i3 < strArrSplit.length; i3++) {
                                if (strArrSplit[i3].trim().startsWith("charset")) {
                                    String[] strArrSplit2 = strArrSplit[i3].trim().split("=");
                                    if (strArrSplit2.length > 1) {
                                        strTrim = strArrSplit2[1].trim();
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    String str2 = strTrim;
                    Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                    HashMap map2 = new HashMap(headerFields.size());
                    for (Map.Entry<String, List<String>> entry2 : headerFields.entrySet()) {
                        if (entry2.getKey() != null && entry2.getValue() != null && !entry2.getValue().isEmpty()) {
                            map2.put(entry2.getKey(), entry2.getValue().get(0));
                        }
                    }
                    webResourceResponseZzb = com.google.android.gms.ads.internal.zzv.zzr().zzb(strTrim2, str2, AdMobNetworkBridge.httpUrlConnectionGetResponseCode(httpURLConnection), httpURLConnection.getResponseMessage(), map2, AdMobNetworkBridge.urlConnectionGetInputStream(httpURLConnection));
                } else {
                    String headerField = httpURLConnection.getHeaderField("Location");
                    if (headerField == null) {
                        throw new IOException("Missing Location header in redirect");
                    }
                    if (!headerField.startsWith("tel:")) {
                        URL url2 = new URL(url, headerField);
                        String protocol = url2.getProtocol();
                        if (protocol == null) {
                            int i4 = com.google.android.gms.ads.internal.util.zze.zza;
                            com.google.android.gms.ads.internal.util.client.zzo.zzj("Protocol is null");
                            webResourceResponseZzb = zzW();
                        } else if (protocol.equals("http") || protocol.equals("https")) {
                            String str3 = "Redirecting to " + headerField;
                            int i5 = com.google.android.gms.ads.internal.util.zze.zza;
                            com.google.android.gms.ads.internal.util.client.zzo.zze(str3);
                            AdMobNetworkBridge.httpUrlConnectionDisconnect(httpURLConnection);
                            url = url2;
                        } else {
                            int i6 = com.google.android.gms.ads.internal.util.zze.zza;
                            com.google.android.gms.ads.internal.util.client.zzo.zzj("Unsupported scheme: " + protocol);
                            webResourceResponseZzb = zzW();
                        }
                    }
                }
                TrafficStats.clearThreadStatsTag();
                return webResourceResponseZzb;
            }
        } catch (Throwable th) {
            TrafficStats.clearThreadStatsTag();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzY(Map map, List list, String str) {
        if (com.google.android.gms.ads.internal.util.zze.zzc()) {
            com.google.android.gms.ads.internal.util.zze.zza("Received GMSG: ".concat(str));
            for (String str2 : map.keySet()) {
                com.google.android.gms.ads.internal.util.zze.zza("  " + str2 + ": " + ((String) map.get(str2)));
            }
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((zzbjj) it.next()).zza(this.zzc, map);
        }
    }

    private final void zzZ() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.zzH;
        if (onAttachStateChangeListener == null) {
            return;
        }
        ((View) this.zzc).removeOnAttachStateChangeListener(onAttachStateChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaa(final View view, final zzbxi zzbxiVar, final int i) {
        if (!zzbxiVar.zzi() || i <= 0) {
            return;
        }
        zzbxiVar.zzg(view);
        if (zzbxiVar.zzi()) {
            com.google.android.gms.ads.internal.util.zzs.zza.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcem
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzaa(view, zzbxiVar, i - 1);
                }
            }, 100L);
        }
    }

    private static final boolean zzab(zzcel zzcelVar) {
        return zzcelVar.zzD() != null && zzcelVar.zzD().zzb();
    }

    private static final boolean zzac(boolean z, zzcel zzcelVar) {
        return (!z || zzcelVar.zzO().zzi() || zzcelVar.zzU().equals("interstitial_mb")) ? false : true;
    }

    public static /* synthetic */ void zzh(zzcet zzcetVar) {
        zzcel zzcelVar = zzcetVar.zzc;
        zzcelVar.zzad();
        com.google.android.gms.ads.internal.overlay.zzm zzmVarZzL = zzcelVar.zzL();
        if (zzmVarZzL != null) {
            zzmVarZzL.zzz();
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        com.google.android.gms.ads.internal.client.zza zzaVar = this.zzg;
        if (zzaVar != null) {
            zzaVar.onAdClicked();
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        Logger.d("AdMob|SafeDK: Execution> Lcom/google/android/gms/internal/ads/zzcet;->onLoadResource(Landroid/webkit/WebView;Ljava/lang/String;)V");
        CreativeInfoManager.onResourceLoaded(h.h, webView, str);
        safedk_zzcet_onLoadResource_c460f2b7d3b8a825c293b83fb11cfb24(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        Logger.d("AdMob|SafeDK: Execution> Lcom/google/android/gms/internal/ads/zzcet;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V");
        BrandSafetyUtils.onWebViewPageFinished(h.h, webView, str);
        safedk_zzcet_onPageFinished_00b4fb1989ed12d297c919a9adbed2ff(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        BrandSafetyUtils.onWebViewPageStarted(h.h, view, url);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        Logger.d("AdMob|SafeDK: Execution> Lcom/google/android/gms/internal/ads/zzcet;->onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V");
        BrandSafetyUtils.onWebViewReceivedError(h.h, webView, i, str, str2);
        safedk_zzcet_onReceivedError_372bcb1590a0c5f51b3bc9e472ed18e5(webView, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return this.zzc.zzaD(renderProcessGoneDetail.didCrash(), renderProcessGoneDetail.rendererPriorityAtExit());
    }

    public void safedk_zzcet_onLoadResource_c460f2b7d3b8a825c293b83fb11cfb24(WebView p0, String p1) {
        com.google.android.gms.ads.internal.util.zze.zza("Loading resource: ".concat(String.valueOf(p1)));
        Uri uri = Uri.parse(p1);
        if ("gmsg".equalsIgnoreCase(uri.getScheme()) && "mobileads.google.com".equalsIgnoreCase(uri.getHost())) {
            zzn(uri);
        }
    }

    public void safedk_zzcet_onPageFinished_00b4fb1989ed12d297c919a9adbed2ff(WebView p0, String p1) {
        synchronized (this.zzf) {
            zzcel zzcelVar = this.zzc;
            if (zzcelVar.zzaE()) {
                com.google.android.gms.ads.internal.util.zze.zza("Blank page loaded, 1...");
                zzcelVar.zzX();
                return;
            }
            this.zzB = true;
            zzcgc zzcgcVar = this.zzj;
            if (zzcgcVar != null) {
                zzcgcVar.zza();
                this.zzj = null;
            }
            zzk();
            zzcel zzcelVar2 = this.zzc;
            if (zzcelVar2.zzL() != null) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzlY)).booleanValue()) {
                    zzcelVar2.zzL().zzG(p1);
                }
            }
        }
    }

    public void safedk_zzcet_onReceivedError_372bcb1590a0c5f51b3bc9e472ed18e5(WebView p0, int p1, String p2, String p3) {
        this.zzo = true;
        this.zzp = p1;
        this.zzq = p2;
        this.zzr = p3;
    }

    public WebResourceResponse safedk_zzcet_shouldInterceptRequest_c49039228a05972409a44a1d9c1de53e(WebView p0, String p1) {
        return zzc(p1, Collections.emptyMap());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean safedk_zzcet_shouldOverrideUrlLoading_91cb2fe7be4797b401aab594d623a7ed(WebView p0, String p1) {
        com.google.android.gms.ads.internal.util.zze.zza("AdWebView shouldOverrideUrlLoading: ".concat(String.valueOf(p1)));
        Uri uriZza = Uri.parse(p1);
        if ("gmsg".equalsIgnoreCase(uriZza.getScheme()) && "mobileads.google.com".equalsIgnoreCase(uriZza.getHost())) {
            zzn(uriZza);
        } else {
            if (this.zzn && p0 == this.zzc.zzG()) {
                String scheme = uriZza.getScheme();
                if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                    com.google.android.gms.ads.internal.client.zza zzaVar = this.zzg;
                    if (zzaVar != null) {
                        zzaVar.onAdClicked();
                        zzbxi zzbxiVar = this.zza;
                        if (zzbxiVar != null) {
                            zzbxiVar.zzh(p1);
                        }
                        this.zzg = null;
                    }
                    zzddc zzddcVar = this.zzm;
                    if (zzddcVar != null) {
                        zzddcVar.zzdd();
                        this.zzm = null;
                    }
                    return super.shouldOverrideUrlLoading(p0, p1);
                }
            }
            zzcel zzcelVar = this.zzc;
            if (zzcelVar.zzG().willNotDraw()) {
                com.google.android.gms.ads.internal.util.client.zzo.zzj("AdWebView unable to handle URL: ".concat(String.valueOf(p1)));
            } else {
                try {
                    zzauy zzauyVarZzI = zzcelVar.zzI();
                    zzfbt zzfbtVarZzS = zzcelVar.zzS();
                    if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzmc)).booleanValue() || zzfbtVarZzS == null) {
                        if (zzauyVarZzI != null && zzauyVarZzI.zzf(uriZza)) {
                            uriZza = zzauyVarZzI.zza(uriZza, zzcelVar.getContext(), (View) zzcelVar, zzcelVar.zzi());
                        }
                    } else if (zzauyVarZzI != null && zzauyVarZzI.zzf(uriZza)) {
                        uriZza = zzfbtVarZzS.zza(uriZza, zzcelVar.getContext(), (View) zzcelVar, zzcelVar.zzi());
                    }
                } catch (zzauz unused) {
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Unable to append parameter to URL: ".concat(String.valueOf(p1)));
                }
                com.google.android.gms.ads.internal.zzb zzbVar = this.zzy;
                if (zzbVar == null || zzbVar.zzc()) {
                    com.google.android.gms.ads.internal.overlay.zzc zzcVar = new com.google.android.gms.ads.internal.overlay.zzc("android.intent.action.VIEW", uriZza.toString(), null, null, null, null, null, null);
                    zzcel zzcelVar2 = this.zzc;
                    zzv(zzcVar, true, false, zzcelVar2 != null ? zzcelVar2.zzr() : "");
                } else {
                    zzbVar.zzb(p1);
                }
            }
        }
        return true;
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        Logger.d("AdMob|SafeDK: Execution> Lcom/google/android/gms/internal/ads/zzcet;->shouldInterceptRequest(Landroid/webkit/WebView;Ljava/lang/String;)Landroid/webkit/WebResourceResponse;");
        return CreativeInfoManager.onWebViewResponse(h.h, webView, str, safedk_zzcet_shouldInterceptRequest_c49039228a05972409a44a1d9c1de53e(webView, str));
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 79 || keyCode == 222) {
            return true;
        }
        switch (keyCode) {
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
                return true;
            default:
                switch (keyCode) {
                    case 126:
                    case 127:
                    case 128:
                    case 129:
                    case 130:
                        return true;
                    default:
                        return false;
                }
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Logger.d("AdMob|SafeDK: Execution> Lcom/google/android/gms/internal/ads/zzcet;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z");
        boolean zSafedk_zzcet_shouldOverrideUrlLoading_91cb2fe7be4797b401aab594d623a7ed = safedk_zzcet_shouldOverrideUrlLoading_91cb2fe7be4797b401aab594d623a7ed(webView, str);
        BrandSafetyUtils.onShouldOverrideUrlLoading(h.h, webView, str, zSafedk_zzcet_shouldOverrideUrlLoading_91cb2fe7be4797b401aab594d623a7ed);
        return zSafedk_zzcet_shouldOverrideUrlLoading_91cb2fe7be4797b401aab594d623a7ed;
    }

    public final void zzA(boolean z, int i, String str, boolean z2, boolean z3) {
        zzcel zzcelVar = this.zzc;
        boolean zZzaF = zzcelVar.zzaF();
        boolean zZzac = zzac(zZzaF, zzcelVar);
        boolean z4 = true;
        if (!zZzac && z2) {
            z4 = false;
        }
        zzy(new AdOverlayInfoParcel(zZzac ? null : this.zzg, zZzaF ? null : new zzces(zzcelVar, this.zzh), this.zzk, this.zzl, this.zzw, zzcelVar, z, i, str, zzcelVar.zzm(), z4 ? null : this.zzm, zzab(zzcelVar) ? this.zzG : null, z3));
    }

    public final void zzB(String str, zzbjj zzbjjVar) {
        synchronized (this.zzf) {
            HashMap map = this.zze;
            List copyOnWriteArrayList = (List) map.get(str);
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList();
                map.put(str, copyOnWriteArrayList);
            }
            copyOnWriteArrayList.add(zzbjjVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgd
    public final void zzC(zzcgb zzcgbVar) {
        this.zzi = zzcgbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcgd
    public final void zzD(int i, int i2) {
        zzbrw zzbrwVar = this.zzz;
        if (zzbrwVar != null) {
            zzbrwVar.zze(i, i2);
        }
    }

    public final void zzE(boolean z) {
        this.zzn = false;
    }

    @Override // com.google.android.gms.internal.ads.zzcgd
    public final void zzF(boolean z) {
        synchronized (this.zzf) {
            this.zzu = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgd
    public final void zzG(boolean z) {
        synchronized (this.zzf) {
            this.zzv = z;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgd
    public final void zzH() {
        synchronized (this.zzf) {
            this.zzn = false;
            this.zzs = true;
            zzbzk.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcen
                @Override // java.lang.Runnable
                public final void run() {
                    zzcet.zzh(this.zza);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgd
    public final void zzI(boolean z) {
        synchronized (this.zzf) {
            this.zzt = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgd
    public final void zzJ(zzcgc zzcgcVar) {
        this.zzj = zzcgcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcgd
    public final void zzK(zzclx zzclxVar, zzeat zzeatVar, zzfio zzfioVar) {
        zzO("/click");
        if (zzeatVar != null && zzfioVar != null) {
            zzB("/click", new zzfbx(this.zzm, zzclxVar, zzfioVar, zzeatVar));
            return;
        }
        zzddc zzddcVar = this.zzm;
        zzbjj zzbjjVar = zzbji.zza;
        zzB("/click", new zzbih(zzddcVar, zzclxVar));
    }

    @Override // com.google.android.gms.internal.ads.zzcgd
    public final void zzL(zzclx zzclxVar) {
        zzO("/click");
        zzddc zzddcVar = this.zzm;
        zzbjj zzbjjVar = zzbji.zza;
        zzB("/click", new zzbih(zzddcVar, zzclxVar));
    }

    @Override // com.google.android.gms.internal.ads.zzcgd
    public final void zzM(zzclx zzclxVar, zzeat zzeatVar, zzdre zzdreVar) {
        zzO("/open");
        zzB("/open", new zzbjv(this.zzy, this.zzz, zzeatVar, zzdreVar, zzclxVar));
    }

    @Override // com.google.android.gms.internal.ads.zzcgd
    public final void zzN(zzfau zzfauVar) {
        zzcel zzcelVar = this.zzc;
        if (com.google.android.gms.ads.internal.zzv.zzo().zzp(zzcelVar.getContext())) {
            zzO("/logScionEvent");
            new HashMap();
            zzB("/logScionEvent", new zzbjp(zzcelVar.getContext(), zzfauVar.zzaw));
        }
    }

    public final void zzO(String str) {
        synchronized (this.zzf) {
            List list = (List) this.zze.get(str);
            if (list == null) {
                return;
            }
            list.clear();
        }
    }

    public final void zzP(String str, zzbjj zzbjjVar) {
        synchronized (this.zzf) {
            List list = (List) this.zze.get(str);
            if (list == null) {
                return;
            }
            list.remove(zzbjjVar);
        }
    }

    public final void zzQ(String str, Predicate predicate) {
        synchronized (this.zzf) {
            List<zzbjj> list = (List) this.zze.get(str);
            if (list == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (zzbjj zzbjjVar : list) {
                if (predicate.apply(zzbjjVar)) {
                    arrayList.add(zzbjjVar);
                }
            }
            list.removeAll(arrayList);
        }
    }

    public final boolean zzR() {
        boolean z;
        synchronized (this.zzf) {
            z = this.zzu;
        }
        return z;
    }

    public final boolean zzS() {
        boolean z;
        synchronized (this.zzf) {
            z = this.zzv;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzcgd
    public final boolean zzT() {
        boolean z;
        synchronized (this.zzf) {
            z = this.zzs;
        }
        return z;
    }

    public final boolean zzU() {
        boolean z;
        synchronized (this.zzf) {
            z = this.zzt;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzcgd
    public final void zzV(com.google.android.gms.ads.internal.client.zza zzaVar, zzbhz zzbhzVar, com.google.android.gms.ads.internal.overlay.zzr zzrVar, zzbib zzbibVar, com.google.android.gms.ads.internal.overlay.zzac zzacVar, boolean z, zzbjm zzbjmVar, com.google.android.gms.ads.internal.zzb zzbVar, zzbsd zzbsdVar, zzbxi zzbxiVar, final zzeat zzeatVar, final zzfio zzfioVar, zzdre zzdreVar, zzbkd zzbkdVar, zzddc zzddcVar, zzbkc zzbkcVar, zzbjw zzbjwVar, zzbjk zzbjkVar, zzclx zzclxVar) {
        com.google.android.gms.ads.internal.zzb zzbVar2 = zzbVar == null ? new com.google.android.gms.ads.internal.zzb(this.zzc.getContext(), zzbxiVar, null) : zzbVar;
        zzcel zzcelVar = this.zzc;
        this.zzz = new zzbrw(zzcelVar, zzbsdVar);
        this.zza = zzbxiVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzbf)).booleanValue()) {
            zzB("/adMetadata", new zzbhy(zzbhzVar));
        }
        if (zzbibVar != null) {
            zzB("/appEvent", new zzbia(zzbibVar));
        }
        zzB("/backButton", zzbji.zzj);
        zzB("/refresh", zzbji.zzk);
        zzB("/canOpenApp", zzbji.zzb);
        zzB("/canOpenURLs", zzbji.zza);
        zzB("/canOpenIntents", zzbji.zzc);
        zzB("/close", zzbji.zzd);
        zzB("/customClose", zzbji.zze);
        zzB("/instrument", zzbji.zzn);
        zzB("/delayPageLoaded", zzbji.zzp);
        zzB("/delayPageClosed", zzbji.zzq);
        zzB("/getLocationInfo", zzbji.zzr);
        zzB("/log", zzbji.zzg);
        zzB("/mraid", new zzbjq(zzbVar2, this.zzz, zzbsdVar));
        zzbsb zzbsbVar = this.zzx;
        if (zzbsbVar != null) {
            zzB("/mraidLoaded", zzbsbVar);
        }
        com.google.android.gms.ads.internal.zzb zzbVar3 = zzbVar2;
        zzB("/open", new zzbjv(zzbVar2, this.zzz, zzeatVar, zzdreVar, zzclxVar));
        zzB("/precache", new zzcct());
        zzB("/touch", zzbji.zzi);
        zzB("/video", zzbji.zzl);
        zzB("/videoMeta", zzbji.zzm);
        if (zzeatVar == null || zzfioVar == null) {
            zzB("/click", new zzbih(zzddcVar, zzclxVar));
            zzB("/httpTrack", zzbji.zzf);
        } else {
            zzB("/click", new zzfbx(zzddcVar, zzclxVar, zzfioVar, zzeatVar));
            zzB("/httpTrack", new zzbjj() { // from class: com.google.android.gms.internal.ads.zzfby
                @Override // com.google.android.gms.internal.ads.zzbjj
                public final void zza(Object obj, Map map) {
                    zzcec zzcecVar = (zzcec) obj;
                    String str = (String) map.get(ApsMetricsDataMap.APSMETRICS_FIELD_URL);
                    if (str == null) {
                        int i = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzj("URL missing from httpTrack GMSG.");
                        return;
                    }
                    zzfau zzfauVarZzD = zzcecVar.zzD();
                    if (zzfauVarZzD != null && !zzfauVarZzD.zzai) {
                        zzfioVar.zzd(str, zzfauVarZzD.zzax, null, null);
                        return;
                    }
                    zzfax zzfaxVarZzR = ((zzcfo) zzcecVar).zzR();
                    if (zzfaxVarZzR != null) {
                        zzeatVar.zzd(new zzeav(com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis(), zzfaxVarZzR.zzb, str, 2));
                    } else {
                        com.google.android.gms.ads.internal.zzv.zzp().zzw(new IllegalArgumentException("Common configuration cannot be null"), "BufferingGmsgHandlers.getBufferingHttpTrackGmsgHandler");
                    }
                }
            });
        }
        if (com.google.android.gms.ads.internal.zzv.zzo().zzp(zzcelVar.getContext())) {
            Map map = new HashMap();
            if (zzcelVar.zzD() != null) {
                map = zzcelVar.zzD().zzaw;
            }
            zzB("/logScionEvent", new zzbjp(zzcelVar.getContext(), map));
        }
        if (zzbjmVar != null) {
            zzB("/setInterstitialProperties", new zzbjl(zzbjmVar));
        }
        if (zzbkdVar != null) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zziY)).booleanValue()) {
                zzB("/inspectorNetworkExtras", zzbkdVar);
            }
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzjr)).booleanValue() && zzbkcVar != null) {
            zzB("/shareSheet", zzbkcVar);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzjw)).booleanValue() && zzbjwVar != null) {
            zzB("/inspectorOutOfContextTest", zzbjwVar);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzjA)).booleanValue() && zzbjkVar != null) {
            zzB("/inspectorStorage", zzbjkVar);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzlD)).booleanValue()) {
            zzB("/bindPlayStoreOverlay", zzbji.zzu);
            zzB("/presentPlayStoreOverlay", zzbji.zzv);
            zzB("/expandPlayStoreOverlay", zzbji.zzw);
            zzB("/collapsePlayStoreOverlay", zzbji.zzx);
            zzB("/closePlayStoreOverlay", zzbji.zzy);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdy)).booleanValue()) {
            zzB("/setPAIDPersonalizationEnabled", zzbji.zzA);
            zzB("/resetPAID", zzbji.zzz);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzlX)).booleanValue() && zzcelVar.zzD() != null && zzcelVar.zzD().zzar) {
            zzB("/writeToLocalStorage", zzbji.zzB);
            zzB("/clearLocalStorageKeys", zzbji.zzC);
        }
        this.zzg = zzaVar;
        this.zzh = zzrVar;
        this.zzk = zzbhzVar;
        this.zzl = zzbibVar;
        this.zzw = zzacVar;
        this.zzy = zzbVar3;
        this.zzm = zzddcVar;
        this.zzA = zzdreVar;
        this.zzn = z;
    }

    public final ViewTreeObserver.OnGlobalLayoutListener zza() {
        synchronized (this.zzf) {
        }
        return null;
    }

    public final ViewTreeObserver.OnScrollChangedListener zzb() {
        synchronized (this.zzf) {
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0095  */
    /* JADX WARN: Code duplicated, block: B:73:0x01df A[Catch: all -> 0x01c5, TryCatch #2 {all -> 0x01c5, blocks: (B:59:0x017c, B:61:0x018e, B:62:0x0196, B:71:0x01cd, B:73:0x01df, B:74:0x01e6), top: B:103:0x00dd }] */
    /* JADX WARN: Code duplicated, block: B:88:0x0288 A[Catch: NoClassDefFoundError -> 0x02b2, Exception | NoClassDefFoundError -> 0x02b4, TryCatch #11 {Exception | NoClassDefFoundError -> 0x02b4, blocks: (B:3:0x000c, B:5:0x0019, B:6:0x001f, B:8:0x002f, B:10:0x0036, B:12:0x0044, B:14:0x0060, B:16:0x0079, B:18:0x0090, B:19:0x0093, B:21:0x0096, B:24:0x00b0, B:26:0x00c4, B:28:0x00dd, B:63:0x01a1, B:43:0x0161, B:88:0x0288, B:76:0x020f, B:77:0x0235, B:75:0x01ea, B:42:0x013d, B:27:0x00d1, B:78:0x0236, B:80:0x0240, B:82:0x0246, B:84:0x0279, B:90:0x0297, B:92:0x029d, B:94:0x02ab), top: B:106:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:92:0x029d A[Catch: NoClassDefFoundError -> 0x02b2, Exception | NoClassDefFoundError -> 0x02b4, TryCatch #11 {Exception | NoClassDefFoundError -> 0x02b4, blocks: (B:3:0x000c, B:5:0x0019, B:6:0x001f, B:8:0x002f, B:10:0x0036, B:12:0x0044, B:14:0x0060, B:16:0x0079, B:18:0x0090, B:19:0x0093, B:21:0x0096, B:24:0x00b0, B:26:0x00c4, B:28:0x00dd, B:63:0x01a1, B:43:0x0161, B:88:0x0288, B:76:0x020f, B:77:0x0235, B:75:0x01ea, B:42:0x013d, B:27:0x00d1, B:78:0x0236, B:80:0x0240, B:82:0x0246, B:84:0x0279, B:90:0x0297, B:92:0x029d, B:94:0x02ab), top: B:106:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:96:0x02b0 A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v5 */
    protected final WebResourceResponse zzc(String str, Map map) {
        int i;
        InputStream inputStreamZza;
        InputStream inputStreamZzc;
        Long l;
        final boolean z;
        final boolean z2;
        String str2;
        try {
            Map map2 = new HashMap();
            zzcel zzcelVar = this.zzc;
            if (zzcelVar.zzD() != null) {
                map2 = zzcelVar.zzD().zzaw;
            }
            String strZzc = zzbxy.zzc(str, zzcelVar.getContext(), this.zzE, map2);
            if (!strZzc.equals(str)) {
                return zzX(strZzc, map);
            }
            Parcelable.Creator<zzbas> creator = zzbas.CREATOR;
            zzbas zzbasVarZza = zzbas.zza(Uri.parse(str));
            if (zzbasVarZza != null) {
                HashMap map3 = new HashMap();
                map3.put(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
                Uri uri = Uri.parse(str);
                if (uri.getQueryParameterNames().contains(SessionDescription.ATTR_RANGE)) {
                    List listZzf = zzful.zzb(zzfth.zzc('-')).zzf(uri.getQueryParameter(SessionDescription.ATTR_RANGE));
                    if (listZzf.size() == 2) {
                        int i2 = Integer.parseInt((String) listZzf.get(0));
                        int i3 = Integer.parseInt((String) listZzf.get(1)) + 1;
                        if (i2 > 0) {
                            zzbasVarZza.zzh = i2;
                        }
                        i = i3 - i2;
                    } else {
                        i = -1;
                    }
                } else {
                    i = -1;
                }
                final boolean z3 = "X-Afma-Gcache-CachedBytes";
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzex)).booleanValue()) {
                    zzbasVarZza.zzi = zzfun.zzc(zzcelVar.zzr());
                    zzbasVarZza.zzj = zzcelVar.zzf();
                    if (zzbasVarZza.zzg) {
                        l = (Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzez);
                    } else {
                        l = (Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzey);
                    }
                    try {
                        String str3 = "AdWebViewClient.interceptRequest.gcache";
                        long jLongValue = l.longValue();
                        long jElapsedRealtime = com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime();
                        com.google.android.gms.ads.internal.zzv.zzd();
                        Future futureZza = zzbbd.zza(zzcelVar.getContext(), zzbasVarZza);
                        try {
                            zzbbe zzbbeVar = (zzbbe) futureZza.get(jLongValue, TimeUnit.MILLISECONDS);
                            try {
                                try {
                                    map3.put("X-Afma-Gcache-HasAdditionalMetadataFromReadV2", Boolean.toString(zzbbeVar.zzd()));
                                    map3.put("X-Afma-Gcache-IsGcacheHit", Boolean.toString(zzbbeVar.zzf()));
                                    map3.put("X-Afma-Gcache-IsDownloaded", Boolean.toString(zzbbeVar.zze()));
                                    map3.put("X-Afma-Gcache-CachedBytes", Long.toString(zzbbeVar.zza()));
                                    inputStreamZzc = zzbbeVar.zzc();
                                    if (i != -1) {
                                        try {
                                            inputStreamZzc = zzfzm.zza(inputStreamZzc, i);
                                        } catch (InterruptedException e) {
                                            e = e;
                                            z2 = true;
                                            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzeC)).booleanValue()) {
                                                com.google.android.gms.ads.internal.zzv.zzp().zzw(e, str3);
                                            }
                                            futureZza.cancel(true);
                                            Thread.currentThread().interrupt();
                                            final long jElapsedRealtime2 = com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime() - jElapsedRealtime;
                                            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcep
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    this.zza.zzc.zzv(z2, jElapsedRealtime2);
                                                }
                                            });
                                            str2 = "Cache connection took " + jElapsedRealtime2 + "ms";
                                        } catch (ExecutionException e2) {
                                            e = e2;
                                            z = true;
                                            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzeC)).booleanValue()) {
                                                com.google.android.gms.ads.internal.zzv.zzp().zzw(e, str3);
                                            }
                                            futureZza.cancel(true);
                                            final long jElapsedRealtime3 = com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime() - jElapsedRealtime;
                                            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcep
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    this.zza.zzc.zzv(z, jElapsedRealtime3);
                                                }
                                            });
                                            str2 = "Cache connection took " + jElapsedRealtime3 + "ms";
                                        } catch (TimeoutException e3) {
                                            e = e3;
                                            z = true;
                                            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzeC)).booleanValue()) {
                                                com.google.android.gms.ads.internal.zzv.zzp().zzw(e, str3);
                                            }
                                            futureZza.cancel(true);
                                            final long jElapsedRealtime4 = com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime() - jElapsedRealtime;
                                            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcep
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    this.zza.zzc.zzv(z, jElapsedRealtime4);
                                                }
                                            });
                                            str2 = "Cache connection took " + jElapsedRealtime4 + "ms";
                                        }
                                    }
                                    final long jElapsedRealtime5 = com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime() - jElapsedRealtime;
                                    final boolean z4 = true;
                                    com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcep
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            this.zza.zzc.zzv(z4, jElapsedRealtime5);
                                        }
                                    });
                                    str2 = "Cache connection took " + jElapsedRealtime5 + "ms";
                                } catch (InterruptedException e4) {
                                    e = e4;
                                    inputStreamZzc = null;
                                } catch (ExecutionException e5) {
                                    e = e5;
                                    inputStreamZzc = null;
                                    z = true;
                                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzeC)).booleanValue()) {
                                        com.google.android.gms.ads.internal.zzv.zzp().zzw(e, str3);
                                    }
                                    futureZza.cancel(true);
                                    final long jElapsedRealtime6 = com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime() - jElapsedRealtime;
                                    com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcep
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            this.zza.zzc.zzv(z, jElapsedRealtime6);
                                        }
                                    });
                                    str2 = "Cache connection took " + jElapsedRealtime6 + "ms";
                                    com.google.android.gms.ads.internal.util.zze.zza(str2);
                                    inputStreamZza = inputStreamZzc;
                                    if (inputStreamZza != null) {
                                        return new WebResourceResponse("", "", 200, "OK", map3, inputStreamZza);
                                    }
                                    if (com.google.android.gms.ads.internal.util.client.zzl.zzk()) {
                                        return null;
                                    }
                                    return null;
                                } catch (TimeoutException e6) {
                                    e = e6;
                                    inputStreamZzc = null;
                                    z = true;
                                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzeC)).booleanValue()) {
                                        com.google.android.gms.ads.internal.zzv.zzp().zzw(e, str3);
                                    }
                                    futureZza.cancel(true);
                                    final long jElapsedRealtime7 = com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime() - jElapsedRealtime;
                                    com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcep
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            this.zza.zzc.zzv(z, jElapsedRealtime7);
                                        }
                                    });
                                    str2 = "Cache connection took " + jElapsedRealtime7 + "ms";
                                    com.google.android.gms.ads.internal.util.zze.zza(str2);
                                    inputStreamZza = inputStreamZzc;
                                    if (inputStreamZza != null) {
                                        return new WebResourceResponse("", "", 200, "OK", map3, inputStreamZza);
                                    }
                                    if (com.google.android.gms.ads.internal.util.client.zzl.zzk()) {
                                        return null;
                                    }
                                    return null;
                                }
                                com.google.android.gms.ads.internal.util.zze.zza(str2);
                            } catch (Throwable th) {
                                th = th;
                                z3 = 1;
                                final long jElapsedRealtime8 = com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime() - jElapsedRealtime;
                                com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcep
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.zza.zzc.zzv(z3, jElapsedRealtime8);
                                    }
                                });
                                com.google.android.gms.ads.internal.util.zze.zza("Cache connection took " + jElapsedRealtime8 + "ms");
                                throw th;
                            }
                        } catch (InterruptedException e7) {
                            e = e7;
                            inputStreamZzc = null;
                            z2 = false;
                        } catch (ExecutionException e8) {
                            e = e8;
                            str3 = str3;
                            inputStreamZzc = null;
                            z = false;
                            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzeC)).booleanValue()) {
                                com.google.android.gms.ads.internal.zzv.zzp().zzw(e, str3);
                            }
                            futureZza.cancel(true);
                            final long jElapsedRealtime9 = com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime() - jElapsedRealtime;
                            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcep
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.zza.zzc.zzv(z, jElapsedRealtime9);
                                }
                            });
                            str2 = "Cache connection took " + jElapsedRealtime9 + "ms";
                            com.google.android.gms.ads.internal.util.zze.zza(str2);
                            inputStreamZza = inputStreamZzc;
                            if (inputStreamZza != null) {
                                return new WebResourceResponse("", "", 200, "OK", map3, inputStreamZza);
                            }
                            if (com.google.android.gms.ads.internal.util.client.zzl.zzk()) {
                                return null;
                            }
                            return null;
                        } catch (TimeoutException e9) {
                            e = e9;
                            str3 = str3;
                            inputStreamZzc = null;
                            z = false;
                            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzeC)).booleanValue()) {
                                com.google.android.gms.ads.internal.zzv.zzp().zzw(e, str3);
                            }
                            futureZza.cancel(true);
                            final long jElapsedRealtime10 = com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime() - jElapsedRealtime;
                            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcep
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.zza.zzc.zzv(z, jElapsedRealtime10);
                                }
                            });
                            str2 = "Cache connection took " + jElapsedRealtime10 + "ms";
                            com.google.android.gms.ads.internal.util.zze.zza(str2);
                            inputStreamZza = inputStreamZzc;
                            if (inputStreamZza != null) {
                                return new WebResourceResponse("", "", 200, "OK", map3, inputStreamZza);
                            }
                            if (com.google.android.gms.ads.internal.util.client.zzl.zzk()) {
                                return null;
                            }
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            z3 = 0;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } else {
                    zzbap zzbapVarZzb = com.google.android.gms.ads.internal.zzv.zzc().zzb(zzbasVarZza);
                    if (zzbapVarZzb == null || !zzbapVarZzb.zze()) {
                        inputStreamZza = null;
                    } else {
                        map3.put("X-Afma-Gcache-HasAdditionalMetadataFromReadV2", Boolean.toString(zzbapVarZzb.zzd()));
                        map3.put("X-Afma-Gcache-IsGcacheHit", Boolean.toString(zzbapVarZzb.zzg()));
                        map3.put("X-Afma-Gcache-IsDownloaded", Boolean.toString(zzbapVarZzb.zzf()));
                        map3.put("X-Afma-Gcache-CachedBytes", Long.toString(zzbapVarZzb.zza()));
                        inputStreamZzc = zzbapVarZzb.zzc();
                        if (i != -1) {
                            inputStreamZza = zzfzm.zza(inputStreamZzc, i);
                        }
                    }
                    if (inputStreamZza != null) {
                        return new WebResourceResponse("", "", 200, "OK", map3, inputStreamZza);
                    }
                }
                inputStreamZza = inputStreamZzc;
                if (inputStreamZza != null) {
                    return new WebResourceResponse("", "", 200, "OK", map3, inputStreamZza);
                }
            }
            if (com.google.android.gms.ads.internal.util.client.zzl.zzk() || !((Boolean) zzbee.zzb.zze()).booleanValue()) {
                return null;
            }
            return zzX(str, map);
        } catch (Exception | NoClassDefFoundError e10) {
            com.google.android.gms.ads.internal.zzv.zzp().zzw(e10, "AdWebViewClient.interceptRequest");
            return zzW();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgd
    public final com.google.android.gms.ads.internal.zzb zzd() {
        return this.zzy;
    }

    @Override // com.google.android.gms.internal.ads.zzddc
    public final void zzdd() {
        zzddc zzddcVar = this.zzm;
        if (zzddcVar != null) {
            zzddcVar.zzdd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgd
    public final zzdre zze() {
        return this.zzA;
    }

    public final void zzk() {
        if (this.zzi != null && ((this.zzB && this.zzD <= 0) || this.zzC || this.zzo)) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcc)).booleanValue()) {
                zzcel zzcelVar = this.zzc;
                if (zzcelVar.zzl() != null) {
                    zzbcp.zza(zzcelVar.zzl().zza(), zzcelVar.zzk(), "awfllc");
                }
            }
            this.zzi.zza((this.zzC || this.zzo) ? false : true, this.zzp, this.zzq, this.zzr);
            this.zzi = null;
        }
        this.zzc.zzaf();
    }

    public final void zzl() {
        zzbxi zzbxiVar = this.zza;
        if (zzbxiVar != null) {
            zzbxiVar.zzf();
            this.zza = null;
        }
        zzZ();
        synchronized (this.zzf) {
            this.zze.clear();
            this.zzg = null;
            this.zzh = null;
            this.zzi = null;
            this.zzj = null;
            this.zzk = null;
            this.zzl = null;
            this.zzn = false;
            this.zzs = false;
            this.zzt = false;
            this.zzu = false;
            this.zzw = null;
            this.zzy = null;
            this.zzx = null;
            zzbrw zzbrwVar = this.zzz;
            if (zzbrwVar != null) {
                zzbrwVar.zzb(true);
                this.zzz = null;
            }
        }
    }

    public final void zzm(boolean z) {
        this.zzE = z;
    }

    @Override // com.google.android.gms.internal.ads.zzcgd
    public final void zzn(Uri uri) {
        com.google.android.gms.ads.internal.util.zze.zza("Received GMSG: ".concat(String.valueOf(String.valueOf(uri))));
        HashMap map = this.zze;
        String path = uri.getPath();
        List list = (List) map.get(path);
        if (path == null || list == null) {
            com.google.android.gms.ads.internal.util.zze.zza("No GMSG handler found for GMSG: ".concat(String.valueOf(String.valueOf(uri))));
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgI)).booleanValue() || com.google.android.gms.ads.internal.zzv.zzp().zzg() == null) {
                return;
            }
            final String strSubstring = (path == null || path.length() < 2) ? "null" : path.substring(1);
            zzbzk.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzceo
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    int i = zzcet.zzb;
                    com.google.android.gms.ads.internal.zzv.zzp().zzg().zze(strSubstring);
                }
            });
            return;
        }
        String encodedQuery = uri.getEncodedQuery();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfI)).booleanValue() && this.zzF.contains(path) && encodedQuery != null) {
            if (encodedQuery.length() >= ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfK)).intValue()) {
                com.google.android.gms.ads.internal.util.zze.zza("Parsing gmsg query params on BG thread: ".concat(path));
                zzgbs.zzr(com.google.android.gms.ads.internal.zzv.zzq().zzb(uri), new zzcer(this, list, path, uri), zzbzk.zzf);
                return;
            }
        }
        com.google.android.gms.ads.internal.zzv.zzq();
        zzY(com.google.android.gms.ads.internal.util.zzs.zzQ(uri), list, path);
    }

    @Override // com.google.android.gms.internal.ads.zzcgd
    public final void zzo() {
        zzbbg zzbbgVar = this.zzd;
        if (zzbbgVar != null) {
            zzbbgVar.zzc(10005);
        }
        this.zzC = true;
        this.zzp = 10004;
        this.zzq = "Page loaded delay cancel.";
        zzk();
        this.zzc.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzcgd
    public final void zzp() {
        synchronized (this.zzf) {
        }
        this.zzD++;
        zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzcgd
    public final void zzq() {
        this.zzD--;
        zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzcgd
    public final void zzr(int i, int i2, boolean z) {
        zzbsb zzbsbVar = this.zzx;
        if (zzbsbVar != null) {
            zzbsbVar.zzb(i, i2);
        }
        zzbrw zzbrwVar = this.zzz;
        if (zzbrwVar != null) {
            zzbrwVar.zzd(i, i2, false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzcgd
    public final void zzs() {
        zzbxi zzbxiVar = this.zza;
        if (zzbxiVar != null) {
            zzcel zzcelVar = this.zzc;
            WebView webViewZzG = zzcelVar.zzG();
            if (ViewCompat.isAttachedToWindow(webViewZzG)) {
                zzaa(webViewZzG, zzbxiVar, 10);
                return;
            }
            zzZ();
            zzceq zzceqVar = new zzceq(this, zzbxiVar);
            this.zzH = zzceqVar;
            ((View) zzcelVar).addOnAttachStateChangeListener(zzceqVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzddc
    public final void zzu() {
        zzddc zzddcVar = this.zzm;
        if (zzddcVar != null) {
            zzddcVar.zzu();
        }
    }

    public final void zzv(com.google.android.gms.ads.internal.overlay.zzc zzcVar, boolean z, boolean z2, String str) {
        zzcel zzcelVar = this.zzc;
        boolean zZzaF = zzcelVar.zzaF();
        boolean z3 = zzac(zZzaF, zzcelVar) || z2;
        zzy(new AdOverlayInfoParcel(zzcVar, z3 ? null : this.zzg, zZzaF ? null : this.zzh, this.zzw, zzcelVar.zzm(), zzcelVar, z3 || !z ? null : this.zzm, str));
    }

    public final void zzw(String str, String str2, int i) {
        zzebe zzebeVar = this.zzG;
        zzcel zzcelVar = this.zzc;
        zzy(new AdOverlayInfoParcel(zzcelVar, zzcelVar.zzm(), str, str2, 14, zzebeVar));
    }

    public final void zzx(boolean z, int i, boolean z2) {
        zzcel zzcelVar = this.zzc;
        boolean zZzac = zzac(zzcelVar.zzaF(), zzcelVar);
        boolean z3 = true;
        if (!zZzac && z2) {
            z3 = false;
        }
        zzy(new AdOverlayInfoParcel(zZzac ? null : this.zzg, this.zzh, this.zzw, zzcelVar, z, i, zzcelVar.zzm(), z3 ? null : this.zzm, zzab(zzcelVar) ? this.zzG : null));
    }

    public final void zzy(AdOverlayInfoParcel adOverlayInfoParcel) {
        com.google.android.gms.ads.internal.overlay.zzc zzcVar;
        zzbrw zzbrwVar = this.zzz;
        boolean zZzf = zzbrwVar != null ? zzbrwVar.zzf() : false;
        com.google.android.gms.ads.internal.zzv.zzj();
        com.google.android.gms.ads.internal.overlay.zzn.zza(this.zzc.getContext(), adOverlayInfoParcel, !zZzf, this.zzA);
        zzbxi zzbxiVar = this.zza;
        if (zzbxiVar != null) {
            String str = adOverlayInfoParcel.zzl;
            if (str == null && (zzcVar = adOverlayInfoParcel.zza) != null) {
                str = zzcVar.zzb;
            }
            zzbxiVar.zzh(str);
        }
    }

    public final void zzz(boolean z, int i, String str, String str2, boolean z2) {
        zzcel zzcelVar = this.zzc;
        boolean zZzaF = zzcelVar.zzaF();
        boolean zZzac = zzac(zZzaF, zzcelVar);
        boolean z3 = true;
        if (!zZzac && z2) {
            z3 = false;
        }
        zzy(new AdOverlayInfoParcel(zZzac ? null : this.zzg, zZzaF ? null : new zzces(zzcelVar, this.zzh), this.zzk, this.zzl, this.zzw, zzcelVar, z, i, str, str2, zzcelVar.zzm(), z3 ? null : this.zzm, zzab(zzcelVar) ? this.zzG : null));
    }
}
