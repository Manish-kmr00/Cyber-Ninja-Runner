package com.moloco.sdk.internal;

import android.content.Context;
import com.moloco.sdk.internal.services.i0;
import com.moloco.sdk.publisher.Banner;
import com.moloco.sdk.publisher.InterstitialAd;
import com.moloco.sdk.publisher.NativeAd;
import com.moloco.sdk.publisher.RewardedInterstitialAd;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.j0;

/* JADX INFO: loaded from: classes12.dex */
public interface a {
    Banner a(Context context, com.moloco.sdk.internal.services.f fVar, String str, j0 j0Var, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m mVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.t tVar, com.moloco.sdk.internal.publisher.a aVar, a0 a0Var, i iVar);

    InterstitialAd a(Context context, com.moloco.sdk.internal.services.f fVar, String str, j0 j0Var, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m mVar, com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i iVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.t tVar, com.moloco.sdk.internal.publisher.a aVar);

    NativeAd a(Context context, com.moloco.sdk.internal.services.f fVar, com.moloco.sdk.internal.services.n nVar, String str, j0 j0Var, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m mVar, com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i iVar, a0 a0Var, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.t tVar, com.moloco.sdk.internal.publisher.a aVar, i0 i0Var);

    Banner b(Context context, com.moloco.sdk.internal.services.f fVar, String str, j0 j0Var, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m mVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.t tVar, com.moloco.sdk.internal.publisher.a aVar, a0 a0Var, i iVar);

    RewardedInterstitialAd b(Context context, com.moloco.sdk.internal.services.f fVar, String str, j0 j0Var, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m mVar, com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i iVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.t tVar, com.moloco.sdk.internal.publisher.a aVar);

    Banner c(Context context, com.moloco.sdk.internal.services.f fVar, String str, j0 j0Var, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m mVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.t tVar, com.moloco.sdk.internal.publisher.a aVar, a0 a0Var, i iVar);
}
