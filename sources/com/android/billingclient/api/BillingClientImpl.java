package com.android.billingclient.api;

import android.R;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.View;
import androidx.core.app.BundleCompat;
import com.android.billingclient.BuildConfig;
import com.android.billingclient.api.BillingFlowParams;
import com.google.android.gms.internal.play_billing.zzev;
import com.google.android.gms.internal.play_billing.zzfb;
import com.google.android.gms.internal.play_billing.zzfm;
import com.google.android.gms.internal.play_billing.zzfn;
import com.google.android.gms.internal.play_billing.zzjx;
import com.google.android.gms.internal.play_billing.zzjz;
import com.google.android.gms.internal.play_billing.zzkb;
import com.google.android.gms.internal.play_billing.zzkd;
import com.google.android.gms.internal.play_billing.zzke;
import com.google.android.gms.internal.play_billing.zzkg;
import com.google.android.gms.internal.play_billing.zzki;
import com.google.android.gms.internal.play_billing.zzks;
import com.google.android.gms.internal.play_billing.zzku;
import com.google.android.gms.internal.play_billing.zzky;
import com.google.android.gms.internal.play_billing.zzlb;
import com.google.android.gms.internal.play_billing.zzlv;
import com.google.android.gms.internal.play_billing.zzlx;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.discoveries.t;
import com.safedk.android.utils.Logger;
import com.vungle.ads.internal.protos.Sdk;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;
import java.util.function.Predicate;
import org.json.JSONException;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.1 */
/* JADX INFO: loaded from: classes2.dex */
class BillingClientImpl extends BillingClient {
    private boolean zzA;
    private PendingPurchasesParams zzB;
    private boolean zzC;
    private ExecutorService zzD;
    private volatile zzev zzE;
    private final Long zzF;
    private final Object zza;
    private volatile int zzb;
    private final String zzc;
    private final Handler zzd;
    private volatile zzn zze;
    private Context zzf;
    private zzch zzg;
    private volatile com.google.android.gms.internal.play_billing.zzan zzh;
    private volatile zzba zzi;
    private boolean zzj;
    private boolean zzk;
    private int zzl;
    private boolean zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private boolean zzt;
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private boolean zzx;
    private boolean zzy;
    private boolean zzz;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    private BillingClientImpl(Activity activity, PendingPurchasesParams pendingPurchasesParams, String str) {
        this(activity.getApplicationContext(), pendingPurchasesParams, new zzbm(), str, null, null, null, null);
    }

    private void initialize(Context context, PurchasesUpdatedListener purchasesUpdatedListener, PendingPurchasesParams pendingPurchasesParams, zzb zzbVar, String str, zzch zzchVar) {
        this.zzf = context.getApplicationContext();
        zzks zzksVarZzc = zzku.zzc();
        zzksVarZzc.zzo(str);
        zzksVarZzc.zzn(this.zzf.getPackageName());
        zzksVarZzc.zzm(this.zzF.longValue());
        if (zzchVar != null) {
            this.zzg = zzchVar;
        } else {
            this.zzg = new zzcl(this.zzf, (zzku) zzksVarZzc.zzf());
        }
        if (purchasesUpdatedListener == null) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.zze = new zzn(this.zzf, purchasesUpdatedListener, null, zzbVar, null, this.zzg);
        this.zzB = pendingPurchasesParams;
        this.zzC = zzbVar != null;
        this.zzf.getPackageName();
    }

    private int launchBillingFlowCpp(Activity activity, BillingFlowParams billingFlowParams) {
        return launchBillingFlow(activity, billingFlowParams).getResponseCode();
    }

    public static void safedk_Activity_startActivity_9d898b58165fa4ba0e12c3900a2b8533(Activity p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, BuildConfig.APPLICATION_ID);
        p0.startActivity(p1);
    }

    private void startConnection(long j) {
        startConnection(new zzbm(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Future zzE(Callable callable, long j, final Runnable runnable, Handler handler, ExecutorService executorService) {
        try {
            final Future futureSubmit = executorService.submit(callable);
            handler.postDelayed(new Runnable() { // from class: com.android.billingclient.api.zzaf
                @Override // java.lang.Runnable
                public final void run() {
                    Future future = futureSubmit;
                    if (future.isDone() || future.isCancelled()) {
                        return;
                    }
                    Runnable runnable2 = runnable;
                    future.cancel(true);
                    com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Async task is taking too long, cancel it!");
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                }
            }, (long) (j * 0.95d));
            return futureSubmit;
        } catch (Exception e) {
            com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", "Async task throws exception!", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BillingResult zzaA() {
        BillingResult billingResult;
        int[] iArr = {0, 3};
        synchronized (this.zza) {
            for (int i = 0; i < 2; i++) {
                if (this.zzb == iArr[i]) {
                    billingResult = zzcj.zzm;
                }
            }
            billingResult = zzcj.zzk;
        }
        return billingResult;
    }

    private final String zzaB(QueryProductDetailsParams queryProductDetailsParams) {
        if (TextUtils.isEmpty(null)) {
            return this.zzf.getPackageName();
        }
        return null;
    }

    private static String zzaC() {
        try {
            return (String) Class.forName("com.android.billingclient.ktx.BuildConfig").getField(t.e).get(null);
        } catch (Exception unused) {
            return BuildConfig.VERSION_NAME;
        }
    }

    private final synchronized ExecutorService zzaD() {
        if (this.zzD == null) {
            this.zzD = Executors.newFixedThreadPool(com.google.android.gms.internal.play_billing.zze.zza, new zzas(this));
        }
        return this.zzD;
    }

    private final void zzaE(ConsumeParams consumeParams, ConsumeResponseListener consumeResponseListener) {
        com.google.android.gms.internal.play_billing.zzan zzanVar;
        int iZza;
        String strZzh;
        String purchaseToken = consumeParams.getPurchaseToken();
        try {
            com.google.android.gms.internal.play_billing.zze.zzk("BillingClient", "Consuming purchase with token: " + purchaseToken);
            synchronized (this.zza) {
                zzanVar = this.zzh;
            }
            if (zzanVar == null) {
                zzaW(consumeResponseListener, purchaseToken, zzcj.zzm, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE, "Service has been reset to null.", null);
                return;
            }
            if (this.zzo) {
                String packageName = this.zzf.getPackageName();
                boolean z = this.zzo;
                String str = this.zzc;
                long jLongValue = this.zzF.longValue();
                Bundle bundle = new Bundle();
                if (z) {
                    com.google.android.gms.internal.play_billing.zze.zzc(bundle, str, jLongValue);
                }
                Bundle bundleZze = zzanVar.zze(9, packageName, purchaseToken, bundle);
                iZza = bundleZze.getInt("RESPONSE_CODE");
                strZzh = com.google.android.gms.internal.play_billing.zze.zzh(bundleZze, "BillingClient");
            } else {
                iZza = zzanVar.zza(3, this.zzf.getPackageName(), purchaseToken);
                strZzh = "";
            }
            BillingResult billingResultZza = zzcj.zza(iZza, strZzh);
            if (iZza == 0) {
                com.google.android.gms.internal.play_billing.zze.zzk("BillingClient", "Successfully consumed purchase.");
                consumeResponseListener.onConsumeResponse(billingResultZza, purchaseToken);
            } else {
                zzaW(consumeResponseListener, purchaseToken, billingResultZza, 23, "Error consuming purchase with token. Response code: " + iZza, null);
            }
        } catch (DeadObjectException e) {
            zzaW(consumeResponseListener, purchaseToken, zzcj.zzm, 29, "Error consuming purchase!", e);
        } catch (Exception e2) {
            zzaW(consumeResponseListener, purchaseToken, zzcj.zzk, 29, "Error consuming purchase!", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaF(zzjz zzjzVar) {
        try {
            this.zzg.zzb(zzjzVar, this.zzl);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", "Unable to log.", th);
        }
    }

    private final void zzaG(zzkd zzkdVar) {
        try {
            this.zzg.zzd(zzkdVar, this.zzl);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", "Unable to log.", th);
        }
    }

    private final void zzaH(String str, final PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        if (!isReady()) {
            zzbe(2, 11, zzcj.zzm);
            purchaseHistoryResponseListener.onPurchaseHistoryResponse(zzcj.zzm, null);
        } else if (zzE(new zzau(this, str, purchaseHistoryResponseListener), 30000L, new Runnable() { // from class: com.android.billingclient.api.zzal
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzak(purchaseHistoryResponseListener);
            }
        }, zzax(), zzaD()) == null) {
            BillingResult billingResultZzaA = zzaA();
            zzbe(25, 11, billingResultZzaA);
            purchaseHistoryResponseListener.onPurchaseHistoryResponse(billingResultZzaA, null);
        }
    }

    private final void zzaI(String str, final PurchasesResponseListener purchasesResponseListener) {
        if (!isReady()) {
            zzbe(2, 9, zzcj.zzm);
            purchasesResponseListener.onQueryPurchasesResponse(zzcj.zzm, com.google.android.gms.internal.play_billing.zzco.zzl());
        } else if (TextUtils.isEmpty(str)) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Please provide a valid product type.");
            zzbe(50, 9, zzcj.zzh);
            purchasesResponseListener.onQueryPurchasesResponse(zzcj.zzh, com.google.android.gms.internal.play_billing.zzco.zzl());
        } else if (zzE(new zzat(this, str, purchasesResponseListener), 30000L, new Runnable() { // from class: com.android.billingclient.api.zzac
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzal(purchasesResponseListener);
            }
        }, zzax(), zzaD()) == null) {
            BillingResult billingResultZzaA = zzaA();
            zzbe(25, 9, billingResultZzaA);
            purchasesResponseListener.onQueryPurchasesResponse(billingResultZzaA, com.google.android.gms.internal.play_billing.zzco.zzl());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaJ(int i) {
        synchronized (this.zza) {
            if (this.zzb == 3) {
                return;
            }
            com.google.android.gms.internal.play_billing.zze.zzk("BillingClient", "Setting clientState from " + zzaN(this.zzb) + " to " + zzaN(i));
            this.zzb = i;
        }
    }

    private final synchronized void zzaK() {
        ExecutorService executorService = this.zzD;
        if (executorService != null) {
            executorService.shutdownNow();
            this.zzD = null;
            this.zzE = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaL() {
        synchronized (this.zza) {
            if (this.zzi != null) {
                try {
                    this.zzf.unbindService(this.zzi);
                    this.zzh = null;
                    this.zzi = null;
                } catch (Throwable th) {
                    try {
                        com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", "There was an exception while unbinding service!", th);
                        this.zzh = null;
                        this.zzi = null;
                    } catch (Throwable th2) {
                        this.zzh = null;
                        this.zzi = null;
                        throw th2;
                    }
                }
            }
        }
    }

    private final boolean zzaM() {
        return this.zzw && this.zzB.isEnabledForPrepaidPlans();
    }

    private static final String zzaN(int i) {
        if (i == 0) {
            return "DISCONNECTED";
        }
        if (i != 1) {
            return i != 2 ? "CLOSED" : "CONNECTED";
        }
        return "CONNECTING";
    }

    private final zzbj zzaO(BillingResult billingResult, int i, String str, Exception exc) {
        com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", str, exc);
        zzbf(i, 7, billingResult, zzcg.zza(exc));
        return new zzbj(billingResult.getResponseCode(), billingResult.getDebugMessage(), new ArrayList());
    }

    private final zzbk zzaP(BillingResult billingResult, int i, String str, Exception exc) {
        com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", str, exc);
        zzbf(i, 11, billingResult, zzcg.zza(exc));
        return new zzbk(billingResult, null);
    }

    private final zzcv zzaQ(int i, BillingResult billingResult, int i2, String str, Exception exc) {
        zzbf(i2, 9, billingResult, zzcg.zza(exc));
        com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", str, exc);
        return new zzcv(billingResult, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzcv zzaR(String str, int i) {
        com.google.android.gms.internal.play_billing.zzan zzanVar;
        com.google.android.gms.internal.play_billing.zze.zzk("BillingClient", "Querying owned items, item type: ".concat(String.valueOf(str)));
        ArrayList arrayList = new ArrayList();
        Bundle bundleZzd = com.google.android.gms.internal.play_billing.zze.zzd(this.zzo, this.zzw, this.zzB.isEnabledForOneTimeProducts(), this.zzB.isEnabledForPrepaidPlans(), this.zzc, this.zzF.longValue());
        String string = null;
        do {
            try {
                synchronized (this.zza) {
                    zzanVar = this.zzh;
                }
                if (zzanVar == null) {
                    return zzaQ(9, zzcj.zzm, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE, "Service has been reset to null", null);
                }
                Bundle bundleZzj = this.zzo ? zzanVar.zzj(true != this.zzw ? 9 : 19, this.zzf.getPackageName(), str, string, bundleZzd) : zzanVar.zzi(3, this.zzf.getPackageName(), str, string);
                zzcx zzcxVarZza = zzcy.zza(bundleZzj, "BillingClient", "getPurchase()");
                BillingResult billingResultZza = zzcxVarZza.zza();
                if (billingResultZza != zzcj.zzl) {
                    return zzaQ(9, billingResultZza, zzcxVarZza.zzb(), "Purchase bundle invalid", null);
                }
                ArrayList<String> stringArrayList = bundleZzj.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String> stringArrayList2 = bundleZzj.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList<String> stringArrayList3 = bundleZzj.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                boolean z = false;
                for (int i2 = 0; i2 < stringArrayList2.size(); i2++) {
                    String str2 = stringArrayList2.get(i2);
                    String str3 = stringArrayList3.get(i2);
                    com.google.android.gms.internal.play_billing.zze.zzk("BillingClient", "Sku is owned: ".concat(String.valueOf(stringArrayList.get(i2))));
                    try {
                        Purchase purchase = new Purchase(str2, str3);
                        if (TextUtils.isEmpty(purchase.getPurchaseToken())) {
                            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "BUG: empty/null token!");
                            z = true;
                        }
                        arrayList.add(purchase);
                    } catch (JSONException e) {
                        return zzaQ(9, zzcj.zzk, 51, "Got an exception trying to decode the purchase!", e);
                    }
                }
                if (z) {
                    zzbe(26, 9, zzcj.zzk);
                }
                string = bundleZzj.getString("INAPP_CONTINUATION_TOKEN");
                com.google.android.gms.internal.play_billing.zze.zzk("BillingClient", "Continuation token: ".concat(String.valueOf(string)));
            } catch (DeadObjectException e2) {
                return zzaQ(9, zzcj.zzm, 52, "Got exception trying to get purchases try to reconnect", e2);
            } catch (Exception e3) {
                return zzaQ(9, zzcj.zzk, 52, "Got exception trying to get purchases try to reconnect", e3);
            }
        } while (!TextUtils.isEmpty(string));
        return new zzcv(zzcj.zzl, arrayList);
    }

    private final zzdc zzaS(BillingResult billingResult, int i, String str, Exception exc) {
        com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", str, exc);
        zzbf(i, 8, billingResult, zzcg.zza(exc));
        return new zzdc(billingResult.getResponseCode(), billingResult.getDebugMessage(), null);
    }

    private final void zzaT(BillingResult billingResult, int i, int i2) {
        zzkd zzkdVar = null;
        zzjz zzjzVar = null;
        if (billingResult.getResponseCode() == 0) {
            int i3 = zzcg.zza;
            try {
                zzkb zzkbVarZzc = zzkd.zzc();
                zzkbVarZzc.zzn(5);
                zzky zzkyVarZzc = zzlb.zzc();
                zzkyVarZzc.zza(i2);
                zzkbVarZzc.zza((zzlb) zzkyVarZzc.zzf());
                zzkdVar = (zzkd) zzkbVarZzc.zzf();
            } catch (Exception e) {
                com.google.android.gms.internal.play_billing.zze.zzm("BillingLogger", "Unable to create logging payload", e);
            }
            zzaG(zzkdVar);
            return;
        }
        int i4 = zzcg.zza;
        try {
            zzjx zzjxVarZzc = zzjz.zzc();
            zzke zzkeVarZzc = zzki.zzc();
            zzkeVarZzc.zzn(billingResult.getResponseCode());
            zzkeVarZzc.zzm(billingResult.getDebugMessage());
            zzkeVarZzc.zzo(i);
            zzjxVarZzc.zza(zzkeVarZzc);
            zzjxVarZzc.zzn(5);
            zzky zzkyVarZzc2 = zzlb.zzc();
            zzkyVarZzc2.zza(i2);
            zzjxVarZzc.zzm((zzlb) zzkyVarZzc2.zzf());
            zzjzVar = (zzjz) zzjxVarZzc.zzf();
        } catch (Exception e2) {
            com.google.android.gms.internal.play_billing.zze.zzm("BillingLogger", "Unable to create logging payload", e2);
        }
        zzaF(zzjzVar);
    }

    private final void zzaU(AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener, BillingResult billingResult, int i, Exception exc) {
        com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", "Error in acknowledge purchase!", exc);
        zzbf(i, 3, billingResult, zzcg.zza(exc));
        acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResult);
    }

    private final void zzaV(AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener, BillingResult billingResult, int i, Exception exc) {
        zzbf(i, 14, billingResult, zzcg.zza(exc));
        alternativeBillingOnlyAvailabilityListener.onAlternativeBillingOnlyAvailabilityResponse(billingResult);
    }

    private final void zzaW(ConsumeResponseListener consumeResponseListener, String str, BillingResult billingResult, int i, String str2, Exception exc) {
        com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", str2, exc);
        zzbf(i, 4, billingResult, zzcg.zza(exc));
        consumeResponseListener.onConsumeResponse(billingResult, str);
    }

    private final void zzaX(AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener, BillingResult billingResult, int i, Exception exc) {
        zzbf(i, 15, billingResult, zzcg.zza(exc));
        alternativeBillingOnlyReportingDetailsListener.onAlternativeBillingOnlyTokenResponse(billingResult, null);
    }

    private final void zzaY(ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener, BillingResult billingResult, int i, Exception exc) {
        zzbf(i, 24, billingResult, zzcg.zza(exc));
        externalOfferReportingDetailsListener.onExternalOfferReportingDetailsResponse(billingResult, null);
    }

    private final void zzaZ(ExternalOfferAvailabilityListener externalOfferAvailabilityListener, BillingResult billingResult, int i, Exception exc) {
        zzbf(i, 23, billingResult, zzcg.zza(exc));
        externalOfferAvailabilityListener.onExternalOfferAvailabilityResponse(billingResult);
    }

    static /* bridge */ /* synthetic */ boolean zzaq(BillingClientImpl billingClientImpl) {
        boolean z;
        synchronized (billingClientImpl.zza) {
            z = true;
            if (billingClientImpl.zzb != 1) {
                z = false;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler zzax() {
        return Looper.myLooper() == null ? this.zzd : new Handler(Looper.myLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzbk zzay(String str) {
        com.google.android.gms.internal.play_billing.zzan zzanVar;
        com.google.android.gms.internal.play_billing.zze.zzk("BillingClient", "Querying purchase history, item type: ".concat(String.valueOf(str)));
        ArrayList arrayList = new ArrayList();
        Bundle bundleZzd = com.google.android.gms.internal.play_billing.zze.zzd(this.zzo, this.zzw, this.zzB.isEnabledForOneTimeProducts(), this.zzB.isEnabledForPrepaidPlans(), this.zzc, this.zzF.longValue());
        String string = null;
        while (this.zzm) {
            try {
                synchronized (this.zza) {
                    zzanVar = this.zzh;
                }
                if (zzanVar == null) {
                    return zzaP(zzcj.zzm, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE, "Service reset to null", null);
                }
                Bundle bundleZzh = zzanVar.zzh(6, this.zzf.getPackageName(), str, string, bundleZzd);
                zzcx zzcxVarZza = zzcy.zza(bundleZzh, "BillingClient", "getPurchaseHistory()");
                BillingResult billingResultZza = zzcxVarZza.zza();
                if (billingResultZza != zzcj.zzl) {
                    zzbe(zzcxVarZza.zzb(), 11, billingResultZza);
                    return new zzbk(billingResultZza, null);
                }
                ArrayList<String> stringArrayList = bundleZzh.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String> stringArrayList2 = bundleZzh.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList<String> stringArrayList3 = bundleZzh.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                boolean z = false;
                for (int i = 0; i < stringArrayList2.size(); i++) {
                    String str2 = stringArrayList2.get(i);
                    String str3 = stringArrayList3.get(i);
                    com.google.android.gms.internal.play_billing.zze.zzk("BillingClient", "Purchase record found for sku : ".concat(String.valueOf(stringArrayList.get(i))));
                    try {
                        PurchaseHistoryRecord purchaseHistoryRecord = new PurchaseHistoryRecord(str2, str3);
                        if (TextUtils.isEmpty(purchaseHistoryRecord.getPurchaseToken())) {
                            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "BUG: empty/null token!");
                            z = true;
                        }
                        arrayList.add(purchaseHistoryRecord);
                    } catch (JSONException e) {
                        return zzaP(zzcj.zzk, 51, "Got an exception trying to decode the purchase!", e);
                    }
                }
                if (z) {
                    zzbe(26, 11, zzcj.zzk);
                }
                string = bundleZzh.getString("INAPP_CONTINUATION_TOKEN");
                com.google.android.gms.internal.play_billing.zze.zzk("BillingClient", "Continuation token: ".concat(String.valueOf(string)));
                if (TextUtils.isEmpty(string)) {
                    return new zzbk(zzcj.zzl, arrayList);
                }
            } catch (DeadObjectException e2) {
                return zzaP(zzcj.zzm, 59, "Got exception trying to get purchase history", e2);
            } catch (Exception e3) {
                return zzaP(zzcj.zzk, 59, "Got exception trying to get purchase history", e3);
            }
        }
        com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "getPurchaseHistory is not supported on current device");
        return new zzbk(zzcj.zzq, null);
    }

    private final BillingResult zzaz() {
        com.google.android.gms.internal.play_billing.zze.zzk("BillingClient", "Service connection is valid. No need to re-initialize.");
        zzkb zzkbVarZzc = zzkd.zzc();
        zzkbVarZzc.zzn(6);
        zzlv zzlvVarZzc = zzlx.zzc();
        zzlvVarZzc.zza(true);
        zzkbVarZzc.zzm(zzlvVarZzc);
        zzaG((zzkd) zzkbVarZzc.zzf());
        return zzcj.zzl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzba(ExternalOfferInformationDialogListener externalOfferInformationDialogListener, BillingResult billingResult, int i, Exception exc) {
        zzbf(i, 25, billingResult, zzcg.zza(exc));
        externalOfferInformationDialogListener.onExternalOfferInformationDialogResponse(billingResult);
    }

    private final void zzbb(BillingConfigResponseListener billingConfigResponseListener, BillingResult billingResult, int i, Exception exc) {
        com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", "getBillingConfig got an exception.", exc);
        zzbf(i, 13, billingResult, zzcg.zza(exc));
        billingConfigResponseListener.onBillingConfigResponse(billingResult, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbc(AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener, BillingResult billingResult, int i, Exception exc) {
        zzbf(i, 16, billingResult, zzcg.zza(exc));
        alternativeBillingOnlyInformationDialogListener.onAlternativeBillingOnlyInformationDialogResponse(billingResult);
    }

    private final void zzbd(int i, int i2, Exception exc) {
        zzjz zzjzVar;
        com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", "showInAppMessages error.", exc);
        zzch zzchVar = this.zzg;
        String strZza = zzcg.zza(exc);
        try {
            zzke zzkeVarZzc = zzki.zzc();
            zzkeVarZzc.zzn(i);
            zzkeVarZzc.zzo(i2);
            if (strZza != null) {
                zzkeVarZzc.zza(strZza);
            }
            zzjx zzjxVarZzc = zzjz.zzc();
            zzjxVarZzc.zza(zzkeVarZzc);
            zzjxVarZzc.zzn(30);
            zzjzVar = (zzjz) zzjxVarZzc.zzf();
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zze.zzm("BillingLogger", "Unable to create logging payload", th);
            zzjzVar = null;
        }
        zzchVar.zza(zzjzVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzbe(int i, int i2, BillingResult billingResult) {
        try {
            zzaF(zzcg.zzb(i, i2, billingResult));
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", "Unable to log.", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbf(int i, int i2, BillingResult billingResult, String str) {
        try {
            zzaF(zzcg.zzc(i, i2, billingResult, str));
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", "Unable to log.", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzbg(int i) {
        try {
            zzaG(zzcg.zzd(i));
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void acknowledgePurchase(final AcknowledgePurchaseParams acknowledgePurchaseParams, final AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        if (!isReady()) {
            zzbe(2, 3, zzcj.zzm);
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzcj.zzm);
            return;
        }
        if (TextUtils.isEmpty(acknowledgePurchaseParams.getPurchaseToken())) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Please provide a valid purchase token.");
            zzbe(26, 3, zzcj.zzj);
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzcj.zzj);
        } else if (!this.zzo) {
            zzbe(27, 3, zzcj.zzb);
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzcj.zzb);
        } else if (zzE(new Callable() { // from class: com.android.billingclient.api.zzt
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                this.zza.zzs(acknowledgePurchaseResponseListener, acknowledgePurchaseParams);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzu
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzab(acknowledgePurchaseResponseListener);
            }
        }, zzax(), zzaD()) == null) {
            BillingResult billingResultZzaA = zzaA();
            zzbe(25, 3, billingResultZzaA);
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResultZzaA);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void consumeAsync(final ConsumeParams consumeParams, final ConsumeResponseListener consumeResponseListener) {
        if (!isReady()) {
            zzbe(2, 4, zzcj.zzm);
            consumeResponseListener.onConsumeResponse(zzcj.zzm, consumeParams.getPurchaseToken());
        } else if (zzE(new Callable() { // from class: com.android.billingclient.api.zzag
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                this.zza.zzt(consumeParams, consumeResponseListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzah
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzad(consumeResponseListener, consumeParams);
            }
        }, zzax(), zzaD()) == null) {
            BillingResult billingResultZzaA = zzaA();
            zzbe(25, 4, billingResultZzaA);
            consumeResponseListener.onConsumeResponse(billingResultZzaA, consumeParams.getPurchaseToken());
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void createAlternativeBillingOnlyReportingDetailsAsync(final AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener) {
        if (!isReady()) {
            zzaX(alternativeBillingOnlyReportingDetailsListener, zzcj.zzm, 2, null);
            return;
        }
        if (!this.zzy) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Current client doesn't support alternative billing only.");
            zzaX(alternativeBillingOnlyReportingDetailsListener, zzcj.zzE, 66, null);
        } else if (zzE(new Callable() { // from class: com.android.billingclient.api.zzx
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                this.zza.zzx(alternativeBillingOnlyReportingDetailsListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzy
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzae(alternativeBillingOnlyReportingDetailsListener);
            }
        }, zzax(), zzaD()) == null) {
            zzaX(alternativeBillingOnlyReportingDetailsListener, zzaA(), 25, null);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void createExternalOfferReportingDetailsAsync(final ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener) {
        if (!isReady()) {
            zzaY(externalOfferReportingDetailsListener, zzcj.zzm, 2, null);
            return;
        }
        if (!this.zzz) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Current client doesn't support external offer.");
            zzaY(externalOfferReportingDetailsListener, zzcj.zzx, 103, null);
        } else if (zzE(new Callable() { // from class: com.android.billingclient.api.zzaa
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                this.zza.zzy(externalOfferReportingDetailsListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzaj
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzaf(externalOfferReportingDetailsListener);
            }
        }, zzax(), zzaD()) == null) {
            zzaY(externalOfferReportingDetailsListener, zzaA(), 25, null);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void endConnection() {
        zzbg(12);
        synchronized (this.zza) {
            try {
                if (this.zze != null) {
                    this.zze.zzf();
                    try {
                        com.google.android.gms.internal.play_billing.zze.zzk("BillingClient", "Unbinding from service.");
                        zzaL();
                    } catch (Throwable th) {
                        com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", "There was an exception while unbinding from the service while ending connection!", th);
                    }
                    try {
                        zzaK();
                    } catch (Throwable th2) {
                        try {
                            com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", "There was an exception while shutting down the executor service while ending connection!", th2);
                        } catch (Throwable th3) {
                            zzaJ(3);
                            throw th3;
                        }
                    }
                    zzaJ(3);
                } else {
                    com.google.android.gms.internal.play_billing.zze.zzk("BillingClient", "Unbinding from service.");
                    zzaL();
                    zzaK();
                    zzaJ(3);
                }
            } catch (Throwable th4) {
                com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", "There was an exception while shutting down broadcast manager while ending connection!", th4);
            }
            throw th;
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void getBillingConfigAsync(GetBillingConfigParams getBillingConfigParams, final BillingConfigResponseListener billingConfigResponseListener) {
        if (!isReady()) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Service disconnected.");
            zzbe(2, 13, zzcj.zzm);
            billingConfigResponseListener.onBillingConfigResponse(zzcj.zzm, null);
        } else if (!this.zzv) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Current client doesn't support get billing config.");
            zzbe(32, 13, zzcj.zzA);
            billingConfigResponseListener.onBillingConfigResponse(zzcj.zzA, null);
        } else if (zzE(new Callable() { // from class: com.android.billingclient.api.zzv
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                this.zza.zzu(billingConfigResponseListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzw
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzag(billingConfigResponseListener);
            }
        }, zzax(), zzaD()) == null) {
            BillingResult billingResultZzaA = zzaA();
            zzbe(25, 13, billingResultZzaA);
            billingConfigResponseListener.onBillingConfigResponse(billingResultZzaA, null);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final int getConnectionState() {
        int i;
        synchronized (this.zza) {
            i = this.zzb;
        }
        return i;
    }

    @Override // com.android.billingclient.api.BillingClient
    public void isAlternativeBillingOnlyAvailableAsync(final AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener) {
        if (!isReady()) {
            zzaV(alternativeBillingOnlyAvailabilityListener, zzcj.zzm, 2, null);
            return;
        }
        if (!this.zzy) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Current client doesn't support alternative billing only.");
            zzaV(alternativeBillingOnlyAvailabilityListener, zzcj.zzE, 66, null);
        } else if (zzE(new Callable() { // from class: com.android.billingclient.api.zzad
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                this.zza.zzz(alternativeBillingOnlyAvailabilityListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzae
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzah(alternativeBillingOnlyAvailabilityListener);
            }
        }, zzax(), zzaD()) == null) {
            zzaV(alternativeBillingOnlyAvailabilityListener, zzaA(), 25, null);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void isExternalOfferAvailableAsync(final ExternalOfferAvailabilityListener externalOfferAvailabilityListener) {
        if (!isReady()) {
            zzaZ(externalOfferAvailabilityListener, zzcj.zzm, 2, null);
            return;
        }
        if (!this.zzz) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Current client doesn't support external offer.");
            zzaZ(externalOfferAvailabilityListener, zzcj.zzx, 103, null);
        } else if (zzE(new Callable() { // from class: com.android.billingclient.api.zzap
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                this.zza.zzA(externalOfferAvailabilityListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzaq
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzai(externalOfferAvailabilityListener);
            }
        }, zzax(), zzaD()) == null) {
            zzaZ(externalOfferAvailabilityListener, zzaA(), 25, null);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:58:0x00da  */
    @Override // com.android.billingclient.api.BillingClient
    public final BillingResult isFeatureSupported(String str) {
        if (!isReady()) {
            BillingResult billingResult = zzcj.zzm;
            if (billingResult.getResponseCode() != 0) {
                zzbe(2, 5, billingResult);
            } else {
                zzbg(5);
            }
            return zzcj.zzm;
        }
        int i = zzcj.zzH;
        switch (str) {
            case "subscriptions":
                BillingResult billingResult2 = this.zzj ? zzcj.zzl : zzcj.zzo;
                zzaT(billingResult2, 9, 2);
                return billingResult2;
            case "subscriptionsUpdate":
                BillingResult billingResult3 = this.zzk ? zzcj.zzl : zzcj.zzp;
                zzaT(billingResult3, 10, 3);
                return billingResult3;
            case "priceChangeConfirmation":
                BillingResult billingResult4 = this.zzn ? zzcj.zzl : zzcj.zzr;
                zzaT(billingResult4, 35, 4);
                return billingResult4;
            case "bbb":
                BillingResult billingResult5 = this.zzq ? zzcj.zzl : zzcj.zzw;
                zzaT(billingResult5, 30, 5);
                return billingResult5;
            case "aaa":
                BillingResult billingResult6 = this.zzs ? zzcj.zzl : zzcj.zzs;
                zzaT(billingResult6, 31, 6);
                return billingResult6;
            case "ddd":
                BillingResult billingResult7 = this.zzr ? zzcj.zzl : zzcj.zzu;
                zzaT(billingResult7, 21, 7);
                return billingResult7;
            case "ccc":
                BillingResult billingResult8 = this.zzt ? zzcj.zzl : zzcj.zzt;
                zzaT(billingResult8, 19, 8);
                return billingResult8;
            case "eee":
                BillingResult billingResult9 = this.zzt ? zzcj.zzl : zzcj.zzt;
                zzaT(billingResult9, 61, 9);
                return billingResult9;
            case "fff":
                BillingResult billingResult10 = this.zzu ? zzcj.zzl : zzcj.zzv;
                zzaT(billingResult10, 20, 10);
                return billingResult10;
            case "ggg":
                BillingResult billingResult11 = this.zzv ? zzcj.zzl : zzcj.zzA;
                zzaT(billingResult11, 32, 11);
                return billingResult11;
            case "hhh":
                BillingResult billingResult12 = this.zzv ? zzcj.zzl : zzcj.zzB;
                zzaT(billingResult12, 33, 12);
                return billingResult12;
            case "iii":
                BillingResult billingResult13 = this.zzx ? zzcj.zzl : zzcj.zzD;
                zzaT(billingResult13, 60, 13);
                return billingResult13;
            case "jjj":
                BillingResult billingResult14 = this.zzy ? zzcj.zzl : zzcj.zzE;
                zzaT(billingResult14, 66, 14);
                return billingResult14;
            case "kkk":
                BillingResult billingResult15 = this.zzz ? zzcj.zzl : zzcj.zzx;
                zzaT(billingResult15, 103, 18);
                return billingResult15;
            case "lll":
                BillingResult billingResult16 = this.zzA ? zzcj.zzl : zzcj.zzy;
                zzaT(billingResult16, 116, 19);
                return billingResult16;
            default:
                com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Unsupported feature: ".concat(String.valueOf(str)));
                zzaT(zzcj.zzz, 34, 1);
                return zzcj.zzz;
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final boolean isReady() {
        boolean z;
        synchronized (this.zza) {
            z = false;
            if (this.zzb == 2 && this.zzh != null && this.zzi != null) {
                z = true;
            }
        }
        return z;
    }

    /* JADX WARN: Code duplicated, block: B:173:0x047a  */
    /* JADX WARN: Code duplicated, block: B:176:0x0485  */
    /* JADX WARN: Code duplicated, block: B:177:0x048d  */
    /* JADX WARN: Code duplicated, block: B:179:0x049b  */
    /* JADX WARN: Code duplicated, block: B:192:0x04cd  */
    /* JADX WARN: Code duplicated, block: B:194:0x04d1 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:196:0x04d6  */
    /* JADX WARN: Code duplicated, block: B:198:0x04da  */
    /* JADX WARN: Code duplicated, block: B:199:0x04dd  */
    @Override // com.android.billingclient.api.BillingClient
    public BillingResult launchBillingFlow(Activity activity, final BillingFlowParams billingFlowParams) {
        final String productId;
        final String productType;
        String str;
        String str2;
        Future futureZzE;
        int iZza;
        int i;
        String string;
        int i2;
        boolean z;
        SkuDetails skuDetails;
        BillingFlowParams.ProductDetailsParams productDetailsParams;
        boolean z2;
        Intent intent;
        String str3;
        int i3;
        final int i4;
        final BillingClientImpl billingClientImpl = this;
        if (billingClientImpl.zze == null || billingClientImpl.zze.zzd() == null) {
            billingClientImpl.zzbe(12, 2, zzcj.zzF);
            return zzcj.zzF;
        }
        if (!isReady()) {
            billingClientImpl.zzbe(2, 2, zzcj.zzm);
            BillingResult billingResult = zzcj.zzm;
            billingClientImpl.zzm(billingResult);
            return billingResult;
        }
        ArrayList<SkuDetails> arrayListZzg = billingFlowParams.zzg();
        List listZzh = billingFlowParams.zzh();
        SkuDetails skuDetails2 = (SkuDetails) com.google.android.gms.internal.play_billing.zzcx.zza(arrayListZzg, null);
        BillingFlowParams.ProductDetailsParams productDetailsParams2 = (BillingFlowParams.ProductDetailsParams) com.google.android.gms.internal.play_billing.zzcx.zza(listZzh, null);
        if (skuDetails2 != null) {
            productId = skuDetails2.getSku();
            productType = skuDetails2.getType();
        } else {
            productId = productDetailsParams2.zza().getProductId();
            productType = productDetailsParams2.zza().getProductType();
        }
        if (productType.equals("subs") && !billingClientImpl.zzj) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Current client doesn't support subscriptions.");
            billingClientImpl.zzbe(9, 2, zzcj.zzo);
            BillingResult billingResult2 = zzcj.zzo;
            billingClientImpl.zzm(billingResult2);
            return billingResult2;
        }
        if (billingFlowParams.zzq() && !billingClientImpl.zzm) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Current client doesn't support extra params for buy intent.");
            billingClientImpl.zzbe(18, 2, zzcj.zzi);
            BillingResult billingResult3 = zzcj.zzi;
            billingClientImpl.zzm(billingResult3);
            return billingResult3;
        }
        if (arrayListZzg.size() > 1 && !billingClientImpl.zzt) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Current client doesn't support multi-item purchases.");
            billingClientImpl.zzbe(19, 2, zzcj.zzt);
            BillingResult billingResult4 = zzcj.zzt;
            billingClientImpl.zzm(billingResult4);
            return billingResult4;
        }
        if (!listZzh.isEmpty() && !billingClientImpl.zzu) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Current client doesn't support purchases with ProductDetails.");
            billingClientImpl.zzbe(20, 2, zzcj.zzv);
            BillingResult billingResult5 = zzcj.zzv;
            billingClientImpl.zzm(billingResult5);
            return billingResult5;
        }
        BillingResult billingResultZzb = billingFlowParams.zzb();
        if (billingResultZzb != zzcj.zzl) {
            billingClientImpl.zzbe(120, 2, billingResultZzb);
            billingClientImpl.zzm(billingResultZzb);
            return billingResultZzb;
        }
        if (billingClientImpl.zzm) {
            boolean z3 = billingClientImpl.zzo;
            boolean z4 = billingClientImpl.zzw;
            boolean zIsEnabledForOneTimeProducts = billingClientImpl.zzB.isEnabledForOneTimeProducts();
            boolean zIsEnabledForPrepaidPlans = billingClientImpl.zzB.isEnabledForPrepaidPlans();
            boolean z5 = billingClientImpl.zzC;
            String str4 = billingClientImpl.zzc;
            final String str5 = productId;
            final String str6 = productType;
            long jLongValue = billingClientImpl.zzF.longValue();
            final String packageName = billingClientImpl.zzf.getPackageName();
            final Bundle bundle = new Bundle();
            com.google.android.gms.internal.play_billing.zze.zzc(bundle, str4, jLongValue);
            if (billingFlowParams.zza() != 0) {
                bundle.putInt("prorationMode", billingFlowParams.zza());
            }
            if (!TextUtils.isEmpty(billingFlowParams.zzc())) {
                bundle.putString(BillingFlowParams.EXTRA_PARAM_KEY_ACCOUNT_ID, billingFlowParams.zzc());
            }
            if (!TextUtils.isEmpty(billingFlowParams.zzd())) {
                bundle.putString("obfuscatedProfileId", billingFlowParams.zzd());
            }
            if (billingFlowParams.zzp()) {
                i2 = 1;
                bundle.putBoolean("isOfferPersonalizedByDeveloper", true);
            } else {
                i2 = 1;
            }
            if (!TextUtils.isEmpty(null)) {
                String[] strArr = new String[i2];
                strArr[0] = null;
                bundle.putStringArrayList("skusToReplace", new ArrayList<>(Arrays.asList(strArr)));
            }
            if (!TextUtils.isEmpty(billingFlowParams.zze())) {
                bundle.putString("oldSkuPurchaseToken", billingFlowParams.zze());
            }
            if (!TextUtils.isEmpty(null)) {
                bundle.putString("oldSkuPurchaseId", null);
            }
            if (!TextUtils.isEmpty(billingFlowParams.zzf())) {
                bundle.putString("originalExternalTransactionId", billingFlowParams.zzf());
            }
            if (!TextUtils.isEmpty(null)) {
                bundle.putString("paymentsPurchaseParams", null);
            }
            if (z3 && zIsEnabledForOneTimeProducts) {
                z = true;
                bundle.putBoolean("enablePendingPurchases", true);
            } else {
                z = true;
            }
            if (z4 && zIsEnabledForPrepaidPlans) {
                bundle.putBoolean("enablePendingPurchaseForSubscriptions", z);
            }
            if (z5) {
                bundle.putBoolean("enableAlternativeBilling", z);
            }
            if (billingFlowParams.zzh().stream().anyMatch(new Predicate() { // from class: com.google.android.gms.internal.play_billing.zza
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    int i5 = zze.zza;
                    return false;
                }
            })) {
                zzfm zzfmVarZza = zzfn.zza();
                zzfmVarZza.zza((Iterable) billingFlowParams.zzh().stream().filter(new Predicate() { // from class: com.google.android.gms.internal.play_billing.zzb
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        int i5 = zze.zza;
                        return false;
                    }
                }).map(new Function() { // from class: com.google.android.gms.internal.play_billing.zzc
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        int i5 = zze.zza;
                        String productId2 = ((BillingFlowParams.ProductDetailsParams) obj).zza().getProductId();
                        zzfk zzfkVarZza = zzfl.zza();
                        zzfp zzfpVarZza = zzfq.zza();
                        zzfpVarZza.zza("subs:" + packageName + ":" + productId2);
                        zzfkVarZza.zza(zzfpVarZza);
                        zzfq.zza();
                        throw null;
                    }
                }).collect(com.google.android.gms.internal.play_billing.zzco.zzo()));
                bundle.putByteArray("subscriptionProductReplacementParamsList", ((zzfn) zzfmVarZza.zzf()).zzh());
            }
            String str7 = "additionalSkuTypes";
            if (arrayListZzg.isEmpty()) {
                skuDetails = skuDetails2;
                productDetailsParams = productDetailsParams2;
                ArrayList<String> arrayList = new ArrayList<>(listZzh.size() - 1);
                ArrayList<String> arrayList2 = new ArrayList<>(listZzh.size() - 1);
                ArrayList<String> arrayList3 = new ArrayList<>();
                ArrayList<String> arrayList4 = new ArrayList<>();
                ArrayList<String> arrayList5 = new ArrayList<>();
                ArrayList<Integer> arrayList6 = new ArrayList<>();
                int i5 = 0;
                while (i5 < listZzh.size()) {
                    BillingFlowParams.ProductDetailsParams productDetailsParams3 = (BillingFlowParams.ProductDetailsParams) listZzh.get(i5);
                    ProductDetails productDetailsZza = productDetailsParams3.zza();
                    if (!productDetailsZza.zzb().isEmpty()) {
                        arrayList3.add(productDetailsZza.zzb());
                    }
                    arrayList4.add(productDetailsParams3.zzb());
                    String strZzc = productDetailsZza.zzc();
                    if (productDetailsZza.zzd() != null && !productDetailsZza.zzd().isEmpty()) {
                        for (ProductDetails.OneTimePurchaseOfferDetails oneTimePurchaseOfferDetails : productDetailsZza.zzd()) {
                            if (!TextUtils.isEmpty(oneTimePurchaseOfferDetails.zzc())) {
                                strZzc = oneTimePurchaseOfferDetails.zzc();
                                break;
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(strZzc)) {
                        arrayList5.add(strZzc);
                    }
                    if (i5 > 0) {
                        arrayList.add(((BillingFlowParams.ProductDetailsParams) listZzh.get(i5)).zza().getProductId());
                        arrayList2.add(((BillingFlowParams.ProductDetailsParams) listZzh.get(i5)).zza().getProductType());
                    }
                    i5++;
                    str7 = str7;
                }
                String str8 = str7;
                bundle.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList4);
                bundle.putIntegerArrayList("AUTO_PAY_BALANCE_THRESHOLD_LIST", arrayList6);
                if (!arrayList3.isEmpty()) {
                    bundle.putStringArrayList("skuDetailsTokens", arrayList3);
                }
                if (!arrayList5.isEmpty()) {
                    bundle.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList5);
                }
                if (!arrayList.isEmpty()) {
                    bundle.putStringArrayList("additionalSkus", arrayList);
                    bundle.putStringArrayList(str8, arrayList2);
                }
            } else {
                ArrayList<String> arrayList7 = new ArrayList<>();
                ArrayList<String> arrayList8 = new ArrayList<>();
                ArrayList<String> arrayList9 = new ArrayList<>();
                ArrayList<Integer> arrayList10 = new ArrayList<>();
                ArrayList<String> arrayList11 = new ArrayList<>();
                boolean z6 = false;
                boolean z7 = false;
                boolean z8 = false;
                boolean z9 = false;
                for (SkuDetails skuDetails3 : arrayListZzg) {
                    if (!skuDetails3.zzf().isEmpty()) {
                        arrayList7.add(skuDetails3.zzf());
                    }
                    String strZzc2 = skuDetails3.zzc();
                    SkuDetails skuDetails4 = skuDetails2;
                    String strZzb = skuDetails3.zzb();
                    int iZza2 = skuDetails3.zza();
                    String strZze = skuDetails3.zze();
                    arrayList8.add(strZzc2);
                    z6 |= !TextUtils.isEmpty(strZzc2);
                    arrayList9.add(strZzb);
                    z7 |= !TextUtils.isEmpty(strZzb);
                    arrayList10.add(Integer.valueOf(iZza2));
                    z8 |= iZza2 != 0;
                    z9 |= !TextUtils.isEmpty(strZze);
                    arrayList11.add(strZze);
                    productDetailsParams2 = productDetailsParams2;
                    skuDetails2 = skuDetails4;
                }
                skuDetails = skuDetails2;
                productDetailsParams = productDetailsParams2;
                if (!arrayList7.isEmpty()) {
                    bundle.putStringArrayList("skuDetailsTokens", arrayList7);
                }
                if (z6) {
                    bundle.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList8);
                }
                if (z7) {
                    bundle.putStringArrayList("SKU_OFFER_ID_LIST", arrayList9);
                }
                if (z8) {
                    bundle.putIntegerArrayList("SKU_OFFER_TYPE_LIST", arrayList10);
                }
                if (z9) {
                    bundle.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList11);
                }
                if (arrayListZzg.size() > 1) {
                    ArrayList<String> arrayList12 = new ArrayList<>(arrayListZzg.size() - 1);
                    ArrayList<String> arrayList13 = new ArrayList<>(arrayListZzg.size() - 1);
                    for (int i6 = 1; i6 < arrayListZzg.size(); i6++) {
                        arrayList12.add(((SkuDetails) arrayListZzg.get(i6)).getSku());
                        arrayList13.add(((SkuDetails) arrayListZzg.get(i6)).getType());
                    }
                    bundle.putStringArrayList("additionalSkus", arrayList12);
                    bundle.putStringArrayList("additionalSkuTypes", arrayList13);
                }
            }
            billingClientImpl = this;
            if (bundle.containsKey("SKU_OFFER_ID_TOKEN_LIST") && !billingClientImpl.zzr) {
                billingClientImpl.zzbe(21, 2, zzcj.zzu);
                BillingResult billingResult6 = zzcj.zzu;
                billingClientImpl.zzm(billingResult6);
                return billingResult6;
            }
            if (skuDetails == null || TextUtils.isEmpty(skuDetails.zzd())) {
                if (productDetailsParams == null || TextUtils.isEmpty(productDetailsParams.zza().zza())) {
                    z2 = false;
                } else {
                    bundle.putString("skuPackageName", productDetailsParams.zza().zza());
                }
                str = null;
                if (!TextUtils.isEmpty(null)) {
                    bundle.putString("accountName", null);
                }
                intent = activity.getIntent();
                if (intent == null) {
                    str2 = "BillingClient";
                    com.google.android.gms.internal.play_billing.zze.zzl(str2, "Activity's intent is null.");
                } else {
                    str2 = r14;
                    if (!TextUtils.isEmpty(intent.getStringExtra("PROXY_PACKAGE"))) {
                        String stringExtra = intent.getStringExtra("PROXY_PACKAGE");
                        bundle.putString("proxyPackage", stringExtra);
                        try {
                            str3 = "proxyPackageVersion";
                            try {
                                bundle.putString(str3, billingClientImpl.zzf.getPackageManager().getPackageInfo(stringExtra, 0).versionName);
                            } catch (PackageManager.NameNotFoundException unused) {
                                bundle.putString(str3, "package not found");
                            }
                        } catch (PackageManager.NameNotFoundException unused2) {
                            str3 = "proxyPackageVersion";
                        }
                    }
                }
                if (!billingClientImpl.zzu && !listZzh.isEmpty()) {
                    i3 = 17;
                } else if (billingClientImpl.zzs || !z2) {
                    if (billingClientImpl.zzo) {
                        i4 = 9;
                    } else {
                        i3 = 6;
                    }
                    futureZzE = zzE(new Callable() { // from class: com.android.billingclient.api.zzar
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            return this.zza.zzd(i4, str5, str6, billingFlowParams, bundle);
                        }
                    }, 5000L, null, billingClientImpl.zzd, zzaD());
                } else {
                    i3 = 15;
                }
                i4 = i3;
                futureZzE = zzE(new Callable() { // from class: com.android.billingclient.api.zzar
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return this.zza.zzd(i4, str5, str6, billingFlowParams, bundle);
                    }
                }, 5000L, null, billingClientImpl.zzd, zzaD());
            } else {
                bundle.putString("skuPackageName", skuDetails.zzd());
            }
            z2 = true;
            str = null;
            if (!TextUtils.isEmpty(null)) {
                bundle.putString("accountName", null);
            }
            intent = activity.getIntent();
            if (intent == null) {
                str2 = "BillingClient";
                com.google.android.gms.internal.play_billing.zze.zzl(str2, "Activity's intent is null.");
            } else {
                str2 = r14;
                if (!TextUtils.isEmpty(intent.getStringExtra("PROXY_PACKAGE"))) {
                    String stringExtra2 = intent.getStringExtra("PROXY_PACKAGE");
                    bundle.putString("proxyPackage", stringExtra2);
                    str3 = "proxyPackageVersion";
                    bundle.putString(str3, billingClientImpl.zzf.getPackageManager().getPackageInfo(stringExtra2, 0).versionName);
                }
            }
            if (!billingClientImpl.zzu) {
                if (billingClientImpl.zzs) {
                    if (billingClientImpl.zzo) {
                        i4 = 9;
                    } else {
                        i3 = 6;
                        i4 = i3;
                    }
                } else if (billingClientImpl.zzo) {
                    i4 = 9;
                } else {
                    i3 = 6;
                    i4 = i3;
                }
            } else if (billingClientImpl.zzs) {
                if (billingClientImpl.zzo) {
                    i4 = 9;
                } else {
                    i3 = 6;
                    i4 = i3;
                }
            } else if (billingClientImpl.zzo) {
                i4 = 9;
            } else {
                i3 = 6;
                i4 = i3;
            }
            futureZzE = zzE(new Callable() { // from class: com.android.billingclient.api.zzar
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zza.zzd(i4, str5, str6, billingFlowParams, bundle);
                }
            }, 5000L, null, billingClientImpl.zzd, zzaD());
        } else {
            str = null;
            str2 = "BillingClient";
            futureZzE = zzE(new Callable() { // from class: com.android.billingclient.api.zzq
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zza.zze(productId, productType);
                }
            }, 5000L, null, billingClientImpl.zzd, zzaD());
        }
        try {
            if (futureZzE == null) {
                billingClientImpl.zzbe(25, 2, zzcj.zzd);
                BillingResult billingResult7 = zzcj.zzd;
                billingClientImpl.zzm(billingResult7);
                return billingResult7;
            }
            Bundle bundle2 = (Bundle) futureZzE.get(5000L, TimeUnit.MILLISECONDS);
            int iZzb = com.google.android.gms.internal.play_billing.zze.zzb(bundle2, str2);
            String strZzh = com.google.android.gms.internal.play_billing.zze.zzh(bundle2, str2);
            if (iZzb == 0) {
                Intent intent2 = new Intent(activity, (Class<?>) ProxyBillingActivity.class);
                intent2.putExtra("BUY_INTENT", (PendingIntent) bundle2.getParcelable("BUY_INTENT"));
                safedk_Activity_startActivity_9d898b58165fa4ba0e12c3900a2b8533(activity, intent2);
                return zzcj.zzl;
            }
            com.google.android.gms.internal.play_billing.zze.zzl(str2, "Unable to buy item, Error response code: " + iZzb);
            BillingResult billingResultZza = zzcj.zza(iZzb, strZzh);
            if (bundle2 == null) {
                i = 1;
                iZza = 1;
            } else {
                try {
                    Object obj = bundle2.get("LOG_REASON");
                    if (obj != null) {
                        if (obj instanceof Integer) {
                            iZza = zzkg.zza(((Integer) obj).intValue());
                            i = 1;
                        } else {
                            com.google.android.gms.internal.play_billing.zze.zzl(str2, "Unexpected type for bundle log reason: " + obj.getClass().getName());
                        }
                    }
                } catch (Throwable th) {
                    com.google.android.gms.internal.play_billing.zze.zzl(str2, "Failed to get log reason from bundle: ".concat(String.valueOf(th.getMessage())));
                }
                i = 1;
                iZza = 1;
            }
            if (iZza == i) {
                iZza = 23;
            }
            if (bundle2 == null) {
                string = str;
            } else {
                try {
                    string = bundle2.getString("ADDITIONAL_LOG_DETAILS");
                } catch (Throwable th2) {
                    com.google.android.gms.internal.play_billing.zze.zzl(str2, "Failed to get additional log details from bundle: ".concat(String.valueOf(th2.getMessage())));
                    string = str;
                }
            }
            billingClientImpl.zzbf(iZza, 2, billingResultZza, string);
            billingClientImpl.zzm(billingResultZza);
            return billingResultZza;
        } catch (CancellationException e) {
            e = e;
            com.google.android.gms.internal.play_billing.zze.zzm(str2, "Time out while launching billing flow. Try to reconnect", e);
            billingClientImpl.zzbf(4, 2, zzcj.zzn, zzcg.zza(e));
            BillingResult billingResult8 = zzcj.zzn;
            billingClientImpl.zzm(billingResult8);
            return billingResult8;
        } catch (TimeoutException e2) {
            e = e2;
            com.google.android.gms.internal.play_billing.zze.zzm(str2, "Time out while launching billing flow. Try to reconnect", e);
            billingClientImpl.zzbf(4, 2, zzcj.zzn, zzcg.zza(e));
            BillingResult billingResult9 = zzcj.zzn;
            billingClientImpl.zzm(billingResult9);
            return billingResult9;
        } catch (Exception e3) {
            com.google.android.gms.internal.play_billing.zze.zzm(str2, "Exception while launching billing flow. Try to reconnect", e3);
            billingClientImpl.zzbf(5, 2, zzcj.zzm, zzcg.zza(e3));
            BillingResult billingResult10 = zzcj.zzm;
            billingClientImpl.zzm(billingResult10);
            return billingResult10;
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void queryProductDetailsAsync(final QueryProductDetailsParams queryProductDetailsParams, final ProductDetailsResponseListener productDetailsResponseListener) {
        if (!isReady()) {
            zzbe(2, 7, zzcj.zzm);
            productDetailsResponseListener.onProductDetailsResponse(zzcj.zzm, new ArrayList());
        } else if (!this.zzu) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Querying product details is not supported.");
            zzbe(20, 7, zzcj.zzv);
            productDetailsResponseListener.onProductDetailsResponse(zzcj.zzv, new ArrayList());
        } else if (zzE(new Callable() { // from class: com.android.billingclient.api.zzam
            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzbj zzbjVarZzh = this.zza.zzh(queryProductDetailsParams);
                productDetailsResponseListener.onProductDetailsResponse(zzcj.zza(zzbjVarZzh.zza(), zzbjVarZzh.zzb()), zzbjVarZzh.zzc());
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzan
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzaj(productDetailsResponseListener);
            }
        }, zzax(), zzaD()) == null) {
            BillingResult billingResultZzaA = zzaA();
            zzbe(25, 7, billingResultZzaA);
            productDetailsResponseListener.onProductDetailsResponse(billingResultZzaA, new ArrayList());
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void queryPurchaseHistoryAsync(QueryPurchaseHistoryParams queryPurchaseHistoryParams, PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        zzaH(queryPurchaseHistoryParams.zza(), purchaseHistoryResponseListener);
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void queryPurchasesAsync(QueryPurchasesParams queryPurchasesParams, PurchasesResponseListener purchasesResponseListener) {
        zzaI(queryPurchasesParams.zza(), purchasesResponseListener);
    }

    @Override // com.android.billingclient.api.BillingClient
    public void querySkuDetailsAsync(SkuDetailsParams skuDetailsParams, final SkuDetailsResponseListener skuDetailsResponseListener) {
        if (!isReady()) {
            zzbe(2, 8, zzcj.zzm);
            skuDetailsResponseListener.onSkuDetailsResponse(zzcj.zzm, null);
            return;
        }
        final String skuType = skuDetailsParams.getSkuType();
        final List<String> skusList = skuDetailsParams.getSkusList();
        if (TextUtils.isEmpty(skuType)) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Please fix the input params. SKU type can't be empty.");
            zzbe(49, 8, zzcj.zzg);
            skuDetailsResponseListener.onSkuDetailsResponse(zzcj.zzg, null);
        } else if (skusList == null) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Please fix the input params. The list of SKUs can't be empty.");
            zzbe(48, 8, zzcj.zzf);
            skuDetailsResponseListener.onSkuDetailsResponse(zzcj.zzf, null);
        } else {
            final String str = null;
            if (zzE(new Callable(skuType, skusList, str, skuDetailsResponseListener) { // from class: com.android.billingclient.api.zzz
                public final /* synthetic */ String zzb;
                public final /* synthetic */ List zzc;
                public final /* synthetic */ SkuDetailsResponseListener zzd;

                {
                    this.zzd = skuDetailsResponseListener;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    zzdc zzdcVarZzn = this.zza.zzn(this.zzb, this.zzc, null);
                    this.zzd.onSkuDetailsResponse(zzcj.zza(zzdcVarZzn.zza(), zzdcVarZzn.zzb()), zzdcVarZzn.zzc());
                    return null;
                }
            }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzab
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzam(skuDetailsResponseListener);
                }
            }, zzax(), zzaD()) == null) {
                BillingResult billingResultZzaA = zzaA();
                zzbe(25, 8, billingResultZzaA);
                skuDetailsResponseListener.onSkuDetailsResponse(billingResultZzaA, null);
            }
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final BillingResult showInAppMessages(final Activity activity, InAppMessageParams inAppMessageParams, InAppMessageResponseListener inAppMessageResponseListener) {
        if (!isReady()) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Service disconnected.");
            return zzcj.zzm;
        }
        if (!this.zzq) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Current client doesn't support showing in-app messages.");
            return zzcj.zzw;
        }
        View viewFindViewById = activity.findViewById(R.id.content);
        IBinder windowToken = viewFindViewById.getWindowToken();
        Rect rect = new Rect();
        viewFindViewById.getGlobalVisibleRect(rect);
        final Bundle bundle = new Bundle();
        BundleCompat.putBinder(bundle, "KEY_WINDOW_TOKEN", windowToken);
        bundle.putInt("KEY_DIMEN_LEFT", rect.left);
        bundle.putInt("KEY_DIMEN_TOP", rect.top);
        bundle.putInt("KEY_DIMEN_RIGHT", rect.right);
        bundle.putInt("KEY_DIMEN_BOTTOM", rect.bottom);
        bundle.putString("playBillingLibraryVersion", this.zzc);
        bundle.putIntegerArrayList("KEY_CATEGORY_IDS", inAppMessageParams.zza());
        final zzav zzavVar = new zzav(this, this.zzd, inAppMessageResponseListener);
        zzE(new Callable() { // from class: com.android.billingclient.api.zzao
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                this.zza.zzv(bundle, activity, zzavVar);
                return null;
            }
        }, 5000L, null, this.zzd, zzaD());
        return zzcj.zzl;
    }

    final /* synthetic */ Void zzA(ExternalOfferAvailabilityListener externalOfferAvailabilityListener) throws Exception {
        com.google.android.gms.internal.play_billing.zzan zzanVar;
        zzbl zzblVar = null;
        try {
            synchronized (this.zza) {
                zzanVar = this.zzh;
            }
            if (zzanVar == null) {
                zzaZ(externalOfferAvailabilityListener, zzcj.zzm, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE, null);
            } else {
                zzanVar.zzs(22, this.zzf.getPackageName(), com.google.android.gms.internal.play_billing.zze.zze(this.zzc, this.zzF.longValue()), new zzbh(externalOfferAvailabilityListener, this.zzg, this.zzl, zzblVar));
            }
        } catch (DeadObjectException e) {
            zzaZ(externalOfferAvailabilityListener, zzcj.zzm, 91, e);
        } catch (Exception e2) {
            zzaZ(externalOfferAvailabilityListener, zzcj.zzk, 91, e2);
        }
        return null;
    }

    final /* synthetic */ Void zzB(AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener, Activity activity, ResultReceiver resultReceiver) throws Exception {
        com.google.android.gms.internal.play_billing.zzan zzanVar;
        zzbl zzblVar = null;
        try {
            synchronized (this.zza) {
                zzanVar = this.zzh;
            }
            if (zzanVar == null) {
                zzbc(alternativeBillingOnlyInformationDialogListener, zzcj.zzm, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE, null);
            } else {
                zzanVar.zzo(21, this.zzf.getPackageName(), com.google.android.gms.internal.play_billing.zze.zze(this.zzc, this.zzF.longValue()), new zzbd(new WeakReference(activity), resultReceiver, zzblVar));
            }
        } catch (DeadObjectException e) {
            zzbc(alternativeBillingOnlyInformationDialogListener, zzcj.zzm, 74, e);
        } catch (Exception e2) {
            zzbc(alternativeBillingOnlyInformationDialogListener, zzcj.zzk, 74, e2);
        }
        return null;
    }

    final /* synthetic */ Void zzC(ExternalOfferInformationDialogListener externalOfferInformationDialogListener, Activity activity, ResultReceiver resultReceiver) throws Exception {
        com.google.android.gms.internal.play_billing.zzan zzanVar;
        zzbl zzblVar = null;
        try {
            synchronized (this.zza) {
                zzanVar = this.zzh;
            }
            if (zzanVar == null) {
                zzba(externalOfferInformationDialogListener, zzcj.zzm, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE, null);
            } else {
                zzanVar.zzq(22, this.zzf.getPackageName(), com.google.android.gms.internal.play_billing.zze.zze(this.zzc, this.zzF.longValue()), new zzbf(new WeakReference(activity), resultReceiver, zzblVar));
            }
        } catch (DeadObjectException e) {
            zzba(externalOfferInformationDialogListener, zzcj.zzm, 98, e);
        } catch (Exception e2) {
            zzba(externalOfferInformationDialogListener, zzcj.zzk, 98, e2);
        }
        return null;
    }

    final /* synthetic */ void zzab(AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        zzbe(24, 3, zzcj.zzn);
        acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzcj.zzn);
    }

    final /* synthetic */ void zzac(BillingResult billingResult) {
        if (this.zze.zzd() != null) {
            this.zze.zzd().onPurchasesUpdated(billingResult, null);
        } else {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "No valid listener is set in BroadcastManager");
        }
    }

    final /* synthetic */ void zzad(ConsumeResponseListener consumeResponseListener, ConsumeParams consumeParams) {
        zzbe(24, 4, zzcj.zzn);
        consumeResponseListener.onConsumeResponse(zzcj.zzn, consumeParams.getPurchaseToken());
    }

    final /* synthetic */ void zzae(AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener) {
        zzaX(alternativeBillingOnlyReportingDetailsListener, zzcj.zzn, 24, null);
    }

    final /* synthetic */ void zzaf(ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener) {
        zzaY(externalOfferReportingDetailsListener, zzcj.zzn, 24, null);
    }

    final /* synthetic */ void zzag(BillingConfigResponseListener billingConfigResponseListener) {
        zzbe(24, 13, zzcj.zzn);
        billingConfigResponseListener.onBillingConfigResponse(zzcj.zzn, null);
    }

    final /* synthetic */ void zzah(AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener) {
        zzaV(alternativeBillingOnlyAvailabilityListener, zzcj.zzn, 24, null);
    }

    final /* synthetic */ void zzai(ExternalOfferAvailabilityListener externalOfferAvailabilityListener) {
        zzaZ(externalOfferAvailabilityListener, zzcj.zzn, 24, null);
    }

    final /* synthetic */ void zzaj(ProductDetailsResponseListener productDetailsResponseListener) {
        zzbe(24, 7, zzcj.zzn);
        productDetailsResponseListener.onProductDetailsResponse(zzcj.zzn, new ArrayList());
    }

    final /* synthetic */ void zzak(PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        zzbe(24, 11, zzcj.zzn);
        purchaseHistoryResponseListener.onPurchaseHistoryResponse(zzcj.zzn, null);
    }

    final /* synthetic */ void zzal(PurchasesResponseListener purchasesResponseListener) {
        zzbe(24, 9, zzcj.zzn);
        purchasesResponseListener.onQueryPurchasesResponse(zzcj.zzn, com.google.android.gms.internal.play_billing.zzco.zzl());
    }

    final /* synthetic */ void zzam(SkuDetailsResponseListener skuDetailsResponseListener) {
        zzbe(24, 8, zzcj.zzn);
        skuDetailsResponseListener.onSkuDetailsResponse(zzcj.zzn, null);
    }

    final /* synthetic */ void zzan(AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener) {
        zzbc(alternativeBillingOnlyInformationDialogListener, zzcj.zzn, 24, null);
    }

    final /* synthetic */ void zzao(ExternalOfferInformationDialogListener externalOfferInformationDialogListener) {
        zzba(externalOfferInformationDialogListener, zzcj.zzn, 24, null);
    }

    final /* synthetic */ Bundle zzd(int i, String str, String str2, BillingFlowParams billingFlowParams, Bundle bundle) throws Exception {
        com.google.android.gms.internal.play_billing.zzan zzanVar;
        try {
            synchronized (this.zza) {
                zzanVar = this.zzh;
            }
            return zzanVar == null ? com.google.android.gms.internal.play_billing.zze.zzn(zzcj.zzm, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE) : zzanVar.zzg(i, this.zzf.getPackageName(), str, str2, null, bundle);
        } catch (DeadObjectException e) {
            return com.google.android.gms.internal.play_billing.zze.zzo(zzcj.zzm, 5, zzcg.zza(e));
        } catch (Exception e2) {
            return com.google.android.gms.internal.play_billing.zze.zzo(zzcj.zzk, 5, zzcg.zza(e2));
        }
    }

    final /* synthetic */ Bundle zze(String str, String str2) throws Exception {
        com.google.android.gms.internal.play_billing.zzan zzanVar;
        try {
            synchronized (this.zza) {
                zzanVar = this.zzh;
            }
            return zzanVar == null ? com.google.android.gms.internal.play_billing.zze.zzn(zzcj.zzm, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE) : zzanVar.zzf(3, this.zzf.getPackageName(), str, str2, null);
        } catch (DeadObjectException e) {
            return com.google.android.gms.internal.play_billing.zze.zzo(zzcj.zzm, 5, zzcg.zza(e));
        } catch (Exception e2) {
            return com.google.android.gms.internal.play_billing.zze.zzo(zzcj.zzk, 5, zzcg.zza(e2));
        }
    }

    final zzbj zzh(QueryProductDetailsParams queryProductDetailsParams) {
        com.google.android.gms.internal.play_billing.zzan zzanVar;
        ArrayList arrayList = new ArrayList();
        String strZzb = queryProductDetailsParams.zzb();
        com.google.android.gms.internal.play_billing.zzco zzcoVarZza = queryProductDetailsParams.zza();
        int size = zzcoVarZza.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 20;
            ArrayList arrayList2 = new ArrayList(zzcoVarZza.subList(i, i2 > size ? size : i2));
            ArrayList<String> arrayList3 = new ArrayList<>();
            int size2 = arrayList2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                arrayList3.add(((QueryProductDetailsParams.Product) arrayList2.get(i3)).zza());
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList3);
            bundle.putString("playBillingLibraryVersion", this.zzc);
            try {
                synchronized (this.zza) {
                    zzanVar = this.zzh;
                }
                if (zzanVar == null) {
                    return zzaO(zzcj.zzm, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE, "Service has been reset to null.", null);
                }
                int i4 = true != this.zzx ? 17 : 20;
                String packageName = this.zzf.getPackageName();
                boolean zZzaM = zzaM();
                String str = this.zzc;
                zzaB(queryProductDetailsParams);
                zzaB(queryProductDetailsParams);
                zzaB(queryProductDetailsParams);
                zzaB(queryProductDetailsParams);
                long jLongValue = this.zzF.longValue();
                Bundle bundle2 = new Bundle();
                com.google.android.gms.internal.play_billing.zze.zzc(bundle2, str, jLongValue);
                bundle2.putBoolean("enablePendingPurchases", true);
                bundle2.putString("SKU_DETAILS_RESPONSE_FORMAT", "PRODUCT_DETAILS");
                if (zZzaM) {
                    bundle2.putBoolean("enablePendingPurchaseForSubscriptions", true);
                }
                ArrayList<String> arrayList4 = new ArrayList<>();
                ArrayList<String> arrayList5 = new ArrayList<>();
                int size3 = arrayList2.size();
                int i5 = 0;
                boolean z = false;
                boolean z2 = false;
                while (i5 < size3) {
                    QueryProductDetailsParams.Product product = (QueryProductDetailsParams.Product) arrayList2.get(i5);
                    arrayList4.add(null);
                    z |= !TextUtils.isEmpty(null);
                    String strZzb2 = product.zzb();
                    ArrayList arrayList6 = arrayList2;
                    if (strZzb2.equals("first_party")) {
                        com.google.android.gms.internal.play_billing.zzbe.zzc(null, "Serialized DocId is required for constructing ExtraParams to query ProductDetails for all first party products.");
                        arrayList5.add(null);
                        z2 = true;
                    }
                    i5++;
                    arrayList2 = arrayList6;
                }
                if (z) {
                    bundle2.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList4);
                }
                if (!arrayList5.isEmpty()) {
                    bundle2.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList5);
                }
                if (z2 && !TextUtils.isEmpty(null)) {
                    bundle2.putString("accountName", null);
                }
                Bundle bundleZzl = zzanVar.zzl(i4, packageName, strZzb, bundle, bundle2);
                if (bundleZzl == null) {
                    return zzaO(zzcj.zzC, 44, "queryProductDetailsAsync got empty product details response.", null);
                }
                if (!bundleZzl.containsKey("DETAILS_LIST")) {
                    int iZzb = com.google.android.gms.internal.play_billing.zze.zzb(bundleZzl, "BillingClient");
                    String strZzh = com.google.android.gms.internal.play_billing.zze.zzh(bundleZzl, "BillingClient");
                    if (iZzb == 0) {
                        return zzaO(zzcj.zza(6, strZzh), 45, "getSkuDetails() returned a bundle with neither an error nor a product detail list for queryProductDetailsAsync.", null);
                    }
                    return zzaO(zzcj.zza(iZzb, strZzh), 23, "getSkuDetails() failed for queryProductDetailsAsync. Response code: " + iZzb, null);
                }
                ArrayList<String> stringArrayList = bundleZzl.getStringArrayList("DETAILS_LIST");
                if (stringArrayList == null) {
                    return zzaO(zzcj.zzC, 46, "queryProductDetailsAsync got null response list", null);
                }
                for (int i6 = 0; i6 < stringArrayList.size(); i6++) {
                    try {
                        ProductDetails productDetails = new ProductDetails(stringArrayList.get(i6));
                        com.google.android.gms.internal.play_billing.zze.zzk("BillingClient", "Got product details: ".concat(productDetails.toString()));
                        arrayList.add(productDetails);
                    } catch (JSONException e) {
                        return zzaO(zzcj.zza(6, "Error trying to decode SkuDetails."), 47, "Got a JSON exception trying to decode ProductDetails. \n Exception: ", e);
                    }
                }
                i = i2;
            } catch (DeadObjectException e2) {
                return zzaO(zzcj.zzm, 43, "queryProductDetailsAsync got a remote exception (try to reconnect).", e2);
            } catch (Exception e3) {
                return zzaO(zzcj.zzk, 43, "queryProductDetailsAsync got a remote exception (try to reconnect).", e3);
            }
        }
        return new zzbj(0, "", arrayList);
    }

    final zzch zzk() {
        return this.zzg;
    }

    final BillingResult zzm(final BillingResult billingResult) {
        if (Thread.interrupted()) {
            return billingResult;
        }
        this.zzd.post(new Runnable() { // from class: com.android.billingclient.api.zzp
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzac(billingResult);
            }
        });
        return billingResult;
    }

    final zzdc zzn(String str, List list, String str2) {
        com.google.android.gms.internal.play_billing.zzan zzanVar;
        Bundle bundleZzk;
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 20;
            ArrayList<String> arrayList2 = new ArrayList<>(list.subList(i, i2 > size ? size : i2));
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList2);
            bundle.putString("playBillingLibraryVersion", this.zzc);
            try {
                synchronized (this.zza) {
                    zzanVar = this.zzh;
                }
                if (zzanVar == null) {
                    return zzaS(zzcj.zzm, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE, "Service has been reset to null.", null);
                }
                if (this.zzp) {
                    String packageName = this.zzf.getPackageName();
                    int i3 = this.zzl;
                    boolean zIsEnabledForOneTimeProducts = this.zzB.isEnabledForOneTimeProducts();
                    boolean zZzaM = zzaM();
                    String str3 = this.zzc;
                    long jLongValue = this.zzF.longValue();
                    Bundle bundle2 = new Bundle();
                    if (i3 >= 9) {
                        com.google.android.gms.internal.play_billing.zze.zzc(bundle2, str3, jLongValue);
                    }
                    if (i3 >= 9 && zIsEnabledForOneTimeProducts) {
                        bundle2.putBoolean("enablePendingPurchases", true);
                    }
                    if (zZzaM) {
                        bundle2.putBoolean("enablePendingPurchaseForSubscriptions", true);
                    }
                    bundleZzk = zzanVar.zzl(10, packageName, str, bundle, bundle2);
                } else {
                    bundleZzk = zzanVar.zzk(3, this.zzf.getPackageName(), str, bundle);
                }
                if (bundleZzk == null) {
                    return zzaS(zzcj.zzC, 44, "querySkuDetailsAsync got null sku details list", null);
                }
                if (!bundleZzk.containsKey("DETAILS_LIST")) {
                    int iZzb = com.google.android.gms.internal.play_billing.zze.zzb(bundleZzk, "BillingClient");
                    String strZzh = com.google.android.gms.internal.play_billing.zze.zzh(bundleZzk, "BillingClient");
                    if (iZzb == 0) {
                        return zzaS(zzcj.zza(6, strZzh), 45, "getSkuDetails() returned a bundle with neither an error nor a detail list.", null);
                    }
                    return zzaS(zzcj.zza(iZzb, strZzh), 23, "getSkuDetails() failed. Response code: " + iZzb, null);
                }
                ArrayList<String> stringArrayList = bundleZzk.getStringArrayList("DETAILS_LIST");
                if (stringArrayList == null) {
                    return zzaS(zzcj.zzC, 46, "querySkuDetailsAsync got null response list", null);
                }
                for (int i4 = 0; i4 < stringArrayList.size(); i4++) {
                    try {
                        SkuDetails skuDetails = new SkuDetails(stringArrayList.get(i4));
                        com.google.android.gms.internal.play_billing.zze.zzk("BillingClient", "Got sku details: ".concat(skuDetails.toString()));
                        arrayList.add(skuDetails);
                    } catch (JSONException e) {
                        return zzaS(zzcj.zza(6, "Error trying to decode SkuDetails."), 47, "Got a JSON exception trying to decode SkuDetails.", e);
                    }
                }
                i = i2;
            } catch (DeadObjectException e2) {
                return zzaS(zzcj.zzm, 43, "querySkuDetailsAsync got a remote exception (try to reconnect).", e2);
            } catch (Exception e3) {
                return zzaS(zzcj.zzk, 43, "querySkuDetailsAsync got a remote exception (try to reconnect).", e3);
            }
        }
        return new zzdc(0, "", arrayList);
    }

    final synchronized zzev zzp() {
        if (this.zzE == null) {
            this.zzE = zzfb.zza(zzaD());
        }
        return this.zzE;
    }

    final /* synthetic */ Object zzs(AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener, AcknowledgePurchaseParams acknowledgePurchaseParams) throws Exception {
        com.google.android.gms.internal.play_billing.zzan zzanVar;
        try {
            synchronized (this.zza) {
                zzanVar = this.zzh;
            }
            if (zzanVar == null) {
                zzaU(acknowledgePurchaseResponseListener, zzcj.zzm, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE, null);
                return null;
            }
            String packageName = this.zzf.getPackageName();
            String purchaseToken = acknowledgePurchaseParams.getPurchaseToken();
            String str = this.zzc;
            long jLongValue = this.zzF.longValue();
            Bundle bundle = new Bundle();
            com.google.android.gms.internal.play_billing.zze.zzc(bundle, str, jLongValue);
            Bundle bundleZzd = zzanVar.zzd(9, packageName, purchaseToken, bundle);
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzcj.zza(com.google.android.gms.internal.play_billing.zze.zzb(bundleZzd, "BillingClient"), com.google.android.gms.internal.play_billing.zze.zzh(bundleZzd, "BillingClient")));
            return null;
        } catch (DeadObjectException e) {
            zzaU(acknowledgePurchaseResponseListener, zzcj.zzm, 28, e);
            return null;
        } catch (Exception e2) {
            zzaU(acknowledgePurchaseResponseListener, zzcj.zzk, 28, e2);
            return null;
        }
    }

    final /* synthetic */ Object zzt(ConsumeParams consumeParams, ConsumeResponseListener consumeResponseListener) throws Exception {
        zzaE(consumeParams, consumeResponseListener);
        return null;
    }

    final /* synthetic */ Object zzu(BillingConfigResponseListener billingConfigResponseListener) throws Exception {
        com.google.android.gms.internal.play_billing.zzan zzanVar;
        zzbl zzblVar = null;
        try {
            synchronized (this.zza) {
                zzanVar = this.zzh;
            }
            if (zzanVar == null) {
                zzbb(billingConfigResponseListener, zzcj.zzm, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE, null);
            } else {
                String packageName = this.zzf.getPackageName();
                String str = this.zzc;
                long jLongValue = this.zzF.longValue();
                Bundle bundle = new Bundle();
                com.google.android.gms.internal.play_billing.zze.zzc(bundle, str, jLongValue);
                zzanVar.zzp(18, packageName, bundle, new zzbe(billingConfigResponseListener, this.zzg, this.zzl, zzblVar));
            }
        } catch (DeadObjectException e) {
            zzbb(billingConfigResponseListener, zzcj.zzm, 62, e);
        } catch (Exception e2) {
            zzbb(billingConfigResponseListener, zzcj.zzk, 62, e2);
        }
        return null;
    }

    final /* synthetic */ Object zzv(Bundle bundle, Activity activity, ResultReceiver resultReceiver) throws Exception {
        com.google.android.gms.internal.play_billing.zzan zzanVar;
        zzbl zzblVar = null;
        try {
            synchronized (this.zza) {
                zzanVar = this.zzh;
            }
            if (zzanVar == null) {
                zzbd(-1, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE, null);
            } else {
                zzanVar.zzt(12, this.zzf.getPackageName(), bundle, new zzbi(new WeakReference(activity), resultReceiver, zzblVar));
            }
        } catch (DeadObjectException e) {
            zzbd(-1, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE, e);
        } catch (Exception e2) {
            zzbd(6, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE, e2);
        }
        return null;
    }

    final /* synthetic */ Void zzx(AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener) throws Exception {
        com.google.android.gms.internal.play_billing.zzan zzanVar;
        zzbl zzblVar = null;
        try {
            synchronized (this.zza) {
                zzanVar = this.zzh;
            }
            if (zzanVar == null) {
                zzaX(alternativeBillingOnlyReportingDetailsListener, zzcj.zzm, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE, null);
            } else {
                zzanVar.zzm(21, this.zzf.getPackageName(), com.google.android.gms.internal.play_billing.zze.zze(this.zzc, this.zzF.longValue()), new zzbb(alternativeBillingOnlyReportingDetailsListener, this.zzg, this.zzl, zzblVar));
            }
        } catch (DeadObjectException e) {
            zzaX(alternativeBillingOnlyReportingDetailsListener, zzcj.zzm, 70, e);
        } catch (Exception e2) {
            zzaX(alternativeBillingOnlyReportingDetailsListener, zzcj.zzk, 70, e2);
        }
        return null;
    }

    final /* synthetic */ Void zzy(ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener) throws Exception {
        com.google.android.gms.internal.play_billing.zzan zzanVar;
        zzbl zzblVar = null;
        try {
            synchronized (this.zza) {
                zzanVar = this.zzh;
            }
            if (zzanVar == null) {
                zzaY(externalOfferReportingDetailsListener, zzcj.zzm, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE, null);
            } else {
                zzanVar.zzn(22, this.zzf.getPackageName(), com.google.android.gms.internal.play_billing.zze.zze(this.zzc, this.zzF.longValue()), new zzbc(externalOfferReportingDetailsListener, this.zzg, this.zzl, zzblVar));
            }
        } catch (DeadObjectException e) {
            zzaY(externalOfferReportingDetailsListener, zzcj.zzm, 94, e);
        } catch (Exception e2) {
            zzaY(externalOfferReportingDetailsListener, zzcj.zzk, 94, e2);
        }
        return null;
    }

    final /* synthetic */ Void zzz(AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener) throws Exception {
        com.google.android.gms.internal.play_billing.zzan zzanVar;
        zzbl zzblVar = null;
        try {
            synchronized (this.zza) {
                zzanVar = this.zzh;
            }
            if (zzanVar == null) {
                zzaV(alternativeBillingOnlyAvailabilityListener, zzcj.zzm, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE, null);
            } else {
                zzanVar.zzr(21, this.zzf.getPackageName(), com.google.android.gms.internal.play_billing.zze.zze(this.zzc, this.zzF.longValue()), new zzbg(alternativeBillingOnlyAvailabilityListener, this.zzg, this.zzl, zzblVar));
            }
        } catch (DeadObjectException e) {
            zzaV(alternativeBillingOnlyAvailabilityListener, zzcj.zzm, 69, e);
        } catch (Exception e2) {
            zzaV(alternativeBillingOnlyAvailabilityListener, zzcj.zzk, 69, e2);
        }
        return null;
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void queryPurchaseHistoryAsync(String str, PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        zzaH(str, purchaseHistoryResponseListener);
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void queryPurchasesAsync(String str, PurchasesResponseListener purchasesResponseListener) {
        zzaI(str, purchasesResponseListener);
    }

    @Override // com.android.billingclient.api.BillingClient
    public BillingResult showAlternativeBillingOnlyInformationDialog(final Activity activity, final AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener) {
        if (activity == null) {
            throw new IllegalArgumentException("Please provide a valid activity.");
        }
        if (!isReady()) {
            zzbe(2, 16, zzcj.zzm);
            return zzcj.zzm;
        }
        if (!this.zzy) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Current Play Store version doesn't support alternative billing only.");
            zzbe(66, 16, zzcj.zzE);
            return zzcj.zzE;
        }
        final zzaw zzawVar = new zzaw(this, this.zzd, alternativeBillingOnlyInformationDialogListener);
        if (zzE(new Callable() { // from class: com.android.billingclient.api.zzr
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                this.zza.zzB(alternativeBillingOnlyInformationDialogListener, activity, zzawVar);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzs
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzan(alternativeBillingOnlyInformationDialogListener);
            }
        }, this.zzd, zzaD()) != null) {
            return zzcj.zzl;
        }
        BillingResult billingResultZzaA = zzaA();
        zzbe(25, 16, billingResultZzaA);
        return billingResultZzaA;
    }

    @Override // com.android.billingclient.api.BillingClient
    public BillingResult showExternalOfferInformationDialog(final Activity activity, final ExternalOfferInformationDialogListener externalOfferInformationDialogListener) {
        if (activity == null) {
            throw new IllegalArgumentException("Please provide a valid activity.");
        }
        if (!isReady()) {
            zzbe(2, 25, zzcj.zzm);
            return zzcj.zzm;
        }
        if (!this.zzz) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Current Play Store version doesn't support external offer.");
            zzbe(103, 25, zzcj.zzx);
            return zzcj.zzx;
        }
        final zzax zzaxVar = new zzax(this, this.zzd, externalOfferInformationDialogListener);
        if (zzE(new Callable() { // from class: com.android.billingclient.api.zzai
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                this.zza.zzC(externalOfferInformationDialogListener, activity, zzaxVar);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzak
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzao(externalOfferInformationDialogListener);
            }
        }, this.zzd, zzaD()) != null) {
            return zzcj.zzl;
        }
        BillingResult billingResultZzaA = zzaA();
        zzbe(25, 25, billingResultZzaA);
        return billingResultZzaA;
    }

    @Override // com.android.billingclient.api.BillingClient
    public void startConnection(BillingClientStateListener billingClientStateListener) {
        BillingResult billingResultZzaz;
        synchronized (this.zza) {
            if (isReady()) {
                billingResultZzaz = zzaz();
            } else if (this.zzb == 1) {
                com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Client is already in the process of connecting to billing service.");
                zzbe(37, 6, zzcj.zze);
                billingResultZzaz = zzcj.zze;
            } else if (this.zzb == 3) {
                com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
                zzbe(38, 6, zzcj.zzm);
                billingResultZzaz = zzcj.zzm;
            } else {
                zzaJ(1);
                zzaL();
                com.google.android.gms.internal.play_billing.zze.zzk("BillingClient", "Starting in-app billing setup.");
                this.zzi = new zzba(this, billingClientStateListener, null);
                Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
                intent.setPackage("com.android.vending");
                List<ResolveInfo> listQueryIntentServices = this.zzf.getPackageManager().queryIntentServices(intent, 0);
                int i = 41;
                if (listQueryIntentServices != null && !listQueryIntentServices.isEmpty()) {
                    ResolveInfo resolveInfo = listQueryIntentServices.get(0);
                    if (resolveInfo.serviceInfo != null) {
                        String str = resolveInfo.serviceInfo.packageName;
                        String str2 = resolveInfo.serviceInfo.name;
                        if (!Objects.equals(str, "com.android.vending") || str2 == null) {
                            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "The device doesn't have valid Play Store.");
                        } else {
                            ComponentName componentName = new ComponentName(str, str2);
                            Intent intent2 = new Intent(intent);
                            intent2.setComponent(componentName);
                            intent2.putExtra("playBillingLibraryVersion", this.zzc);
                            synchronized (this.zza) {
                                if (this.zzb == 2) {
                                    billingResultZzaz = zzaz();
                                } else if (this.zzb != 1) {
                                    com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Client state no longer CONNECTING, returning service disconnected.");
                                    zzbe(117, 6, zzcj.zzm);
                                    billingResultZzaz = zzcj.zzm;
                                } else {
                                    zzba zzbaVar = this.zzi;
                                    if (this.zzf.bindService(intent2, zzbaVar, 1)) {
                                        com.google.android.gms.internal.play_billing.zze.zzk("BillingClient", "Service was bonded successfully.");
                                        billingResultZzaz = null;
                                    } else {
                                        com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Connection to Billing service is blocked.");
                                        i = 39;
                                    }
                                }
                            }
                        }
                    } else {
                        com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "The device doesn't have valid Play Store.");
                    }
                    i = 40;
                }
                zzaJ(0);
                com.google.android.gms.internal.play_billing.zze.zzk("BillingClient", "Billing service unavailable on device.");
                zzbe(i, 6, zzcj.zzc);
                billingResultZzaz = zzcj.zzc;
            }
        }
        if (billingResultZzaz != null) {
            billingClientStateListener.onBillingSetupFinished(billingResultZzaz);
        }
    }

    private BillingClientImpl(Context context, PendingPurchasesParams pendingPurchasesParams, PurchasesUpdatedListener purchasesUpdatedListener, String str, String str2, UserChoiceBillingListener userChoiceBillingListener, zzch zzchVar, ExecutorService executorService) {
        this.zza = new Object();
        this.zzb = 0;
        this.zzd = new Handler(Looper.getMainLooper());
        this.zzl = 0;
        this.zzF = Long.valueOf(new Random().nextLong());
        this.zzc = str;
        initialize(context, purchasesUpdatedListener, pendingPurchasesParams, userChoiceBillingListener, str, (zzch) null);
    }

    private BillingClientImpl(String str) {
        this.zza = new Object();
        this.zzb = 0;
        this.zzd = new Handler(Looper.getMainLooper());
        this.zzl = 0;
        this.zzF = Long.valueOf(new Random().nextLong());
        this.zzc = str;
    }

    BillingClientImpl(String str, Context context, zzch zzchVar, ExecutorService executorService) {
        this.zza = new Object();
        this.zzb = 0;
        this.zzd = new Handler(Looper.getMainLooper());
        this.zzl = 0;
        Long lValueOf = Long.valueOf(new Random().nextLong());
        this.zzF = lValueOf;
        String strZzaC = zzaC();
        this.zzc = strZzaC;
        this.zzf = context.getApplicationContext();
        zzks zzksVarZzc = zzku.zzc();
        zzksVarZzc.zzo(strZzaC);
        zzksVarZzc.zzn(this.zzf.getPackageName());
        zzksVarZzc.zzm(lValueOf.longValue());
        this.zzg = new zzcl(this.zzf, (zzku) zzksVarZzc.zzf());
        this.zzf.getPackageName();
    }

    private void initialize(Context context, PurchasesUpdatedListener purchasesUpdatedListener, PendingPurchasesParams pendingPurchasesParams, UserChoiceBillingListener userChoiceBillingListener, String str, zzch zzchVar) {
        this.zzf = context.getApplicationContext();
        zzks zzksVarZzc = zzku.zzc();
        zzksVarZzc.zzo(str);
        zzksVarZzc.zzn(this.zzf.getPackageName());
        zzksVarZzc.zzm(this.zzF.longValue());
        if (zzchVar != null) {
            this.zzg = zzchVar;
        } else {
            this.zzg = new zzcl(this.zzf, (zzku) zzksVarZzc.zzf());
        }
        if (purchasesUpdatedListener == null) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.zze = new zzn(this.zzf, purchasesUpdatedListener, null, null, userChoiceBillingListener, this.zzg);
        this.zzB = pendingPurchasesParams;
        this.zzC = userChoiceBillingListener != null;
    }

    BillingClientImpl(String str, PendingPurchasesParams pendingPurchasesParams, Context context, zzco zzcoVar, zzch zzchVar, ExecutorService executorService) {
        this.zza = new Object();
        this.zzb = 0;
        this.zzd = new Handler(Looper.getMainLooper());
        this.zzl = 0;
        Long lValueOf = Long.valueOf(new Random().nextLong());
        this.zzF = lValueOf;
        this.zzc = zzaC();
        this.zzf = context.getApplicationContext();
        zzks zzksVarZzc = zzku.zzc();
        zzksVarZzc.zzo(zzaC());
        zzksVarZzc.zzn(this.zzf.getPackageName());
        zzksVarZzc.zzm(lValueOf.longValue());
        this.zzg = new zzcl(this.zzf, (zzku) zzksVarZzc.zzf());
        com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Billing client should have a valid listener but the provided is null.");
        this.zze = new zzn(this.zzf, null, null, null, null, this.zzg);
        this.zzB = pendingPurchasesParams;
        this.zzf.getPackageName();
    }

    BillingClientImpl(String str, PendingPurchasesParams pendingPurchasesParams, Context context, PurchasesUpdatedListener purchasesUpdatedListener, zzb zzbVar, zzch zzchVar, ExecutorService executorService) {
        String strZzaC = zzaC();
        this.zza = new Object();
        this.zzb = 0;
        this.zzd = new Handler(Looper.getMainLooper());
        this.zzl = 0;
        this.zzF = Long.valueOf(new Random().nextLong());
        this.zzc = strZzaC;
        initialize(context, purchasesUpdatedListener, pendingPurchasesParams, (zzb) null, strZzaC, (zzch) null);
    }

    BillingClientImpl(String str, PendingPurchasesParams pendingPurchasesParams, Context context, PurchasesUpdatedListener purchasesUpdatedListener, UserChoiceBillingListener userChoiceBillingListener, zzch zzchVar, ExecutorService executorService) {
        this(context, pendingPurchasesParams, purchasesUpdatedListener, zzaC(), null, userChoiceBillingListener, null, null);
    }
}
