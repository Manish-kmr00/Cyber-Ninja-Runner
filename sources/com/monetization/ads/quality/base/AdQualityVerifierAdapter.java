package com.monetization.ads.quality.base;

import android.content.Context;
import com.monetization.ads.quality.base.model.AdQualityVerifierAdapterInfo;
import com.monetization.ads.quality.base.model.configuration.AdQualityVerificationAdConfiguration;
import com.monetization.ads.quality.base.model.configuration.AdQualityVerifierAdapterConfiguration;
import com.monetization.ads.quality.base.result.AdQualityVerificationResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH¦@¢\u0006\u0002\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/monetization/ads/quality/base/AdQualityVerifierAdapter;", "Lcom/monetization/ads/quality/base/AdQualityVerifierAdEventListener;", "()V", "adapterInfo", "Lcom/monetization/ads/quality/base/model/AdQualityVerifierAdapterInfo;", "getAdapterInfo", "()Lcom/monetization/ads/quality/base/model/AdQualityVerifierAdapterInfo;", "verifyAd", "Lcom/monetization/ads/quality/base/result/AdQualityVerificationResult;", "context", "Landroid/content/Context;", "verifierConfiguration", "Lcom/monetization/ads/quality/base/model/configuration/AdQualityVerifierAdapterConfiguration;", "adConfiguration", "Lcom/monetization/ads/quality/base/model/configuration/AdQualityVerificationAdConfiguration;", "(Landroid/content/Context;Lcom/monetization/ads/quality/base/model/configuration/AdQualityVerifierAdapterConfiguration;Lcom/monetization/ads/quality/base/model/configuration/AdQualityVerificationAdConfiguration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class AdQualityVerifierAdapter implements AdQualityVerifierAdEventListener {
    public AdQualityVerifierAdapterInfo getAdapterInfo() {
        return new AdQualityVerifierAdapterInfo.Builder().build();
    }

    public abstract Object verifyAd(Context context, AdQualityVerifierAdapterConfiguration adQualityVerifierAdapterConfiguration, AdQualityVerificationAdConfiguration adQualityVerificationAdConfiguration, Continuation<? super AdQualityVerificationResult> continuation);
}
