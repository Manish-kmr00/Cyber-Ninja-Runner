package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.Predicate;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
@ParametersAreNonnullByDefault
public interface zzcel extends com.google.android.gms.ads.internal.client.zza, zzddc, zzcec, zzbme, zzcfo, zzcfs, zzbmq, zzayh, zzcfv, com.google.android.gms.ads.internal.zzn, zzcfy, zzcfz, zzcbg, zzcga {
    boolean canGoBack();

    void destroy();

    @Override // com.google.android.gms.internal.ads.zzcfs, com.google.android.gms.internal.ads.zzcbg
    Context getContext();

    int getHeight();

    ViewGroup.LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    int getMeasuredHeight();

    int getMeasuredWidth();

    ViewParent getParent();

    int getWidth();

    void goBack();

    boolean isAttachedToWindow();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    void measure(int i, int i2);

    void onPause();

    void onResume();

    @Override // com.google.android.gms.internal.ads.zzcbg
    void setBackgroundColor(int i);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setOnTouchListener(View.OnTouchListener onTouchListener);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    @Override // com.google.android.gms.internal.ads.zzcbg
    void zzC(zzcfn zzcfnVar);

    @Override // com.google.android.gms.internal.ads.zzcec
    zzfau zzD();

    Context zzE();

    @Override // com.google.android.gms.internal.ads.zzcga
    View zzF();

    WebView zzG();

    WebViewClient zzH();

    @Override // com.google.android.gms.internal.ads.zzcfy
    zzauy zzI();

    zzazu zzJ();

    zzbfh zzK();

    com.google.android.gms.ads.internal.overlay.zzm zzL();

    com.google.android.gms.ads.internal.overlay.zzm zzM();

    zzcgd zzN();

    @Override // com.google.android.gms.internal.ads.zzcfx
    zzcgf zzO();

    zzeby zzP();

    zzeca zzQ();

    @Override // com.google.android.gms.internal.ads.zzcfo
    zzfax zzR();

    zzfbt zzS();

    ListenableFuture zzT();

    String zzU();

    List zzV();

    void zzW(zzfau zzfauVar, zzfax zzfaxVar);

    void zzX();

    void zzY();

    void zzZ(int i);

    void zzaA(String str, Predicate predicate);

    boolean zzaB();

    boolean zzaC();

    boolean zzaD(boolean z, int i);

    boolean zzaE();

    boolean zzaF();

    boolean zzaG();

    boolean zzaH();

    void zzaa();

    void zzab();

    void zzac(boolean z);

    void zzad();

    void zzae(String str, String str2, String str3);

    void zzaf();

    void zzag(String str, zzbjj zzbjjVar);

    void zzah();

    void zzai(com.google.android.gms.ads.internal.overlay.zzm zzmVar);

    void zzaj(zzcgf zzcgfVar);

    void zzak(zzazu zzazuVar);

    void zzal(boolean z);

    void zzam();

    void zzan(Context context);

    void zzao(boolean z);

    void zzap(zzbff zzbffVar);

    void zzaq(boolean z);

    void zzar(zzbfh zzbfhVar);

    void zzas(zzeby zzebyVar);

    void zzat(zzeca zzecaVar);

    void zzau(int i);

    void zzav(boolean z);

    void zzaw(com.google.android.gms.ads.internal.overlay.zzm zzmVar);

    void zzax(boolean z);

    void zzay(boolean z);

    void zzaz(String str, zzbjj zzbjjVar);

    @Override // com.google.android.gms.internal.ads.zzcfs, com.google.android.gms.internal.ads.zzcbg
    Activity zzi();

    @Override // com.google.android.gms.internal.ads.zzcbg
    com.google.android.gms.ads.internal.zza zzj();

    @Override // com.google.android.gms.internal.ads.zzcbg
    zzbcv zzl();

    @Override // com.google.android.gms.internal.ads.zzcfz, com.google.android.gms.internal.ads.zzcbg
    VersionInfoParcel zzm();

    @Override // com.google.android.gms.internal.ads.zzcbg
    zzcfn zzq();

    @Override // com.google.android.gms.internal.ads.zzcbg
    void zzt(String str, zzccs zzccsVar);
}
