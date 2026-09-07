package com.smaato.sdk.video.vast.tracking;

import android.text.TextUtils;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.simplehttp.SimpleHttpClient;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.Threads;
import com.smaato.sdk.video.vast.tracking.macro.MacroInjector;
import com.smaato.sdk.video.vast.tracking.macro.PlayerState;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes12.dex */
public class VastErrorTracker {
    private final Set errorUrls;
    private final Logger logger;
    private final MacroInjector macroInjector;
    private final SimpleHttpClient simpleHttpClient;

    public VastErrorTracker(Logger logger, SimpleHttpClient simpleHttpClient, MacroInjector macroInjector, Collection<String> collection) {
        this.logger = (Logger) Objects.requireNonNull(logger);
        this.macroInjector = (MacroInjector) Objects.requireNonNull(macroInjector);
        this.errorUrls = new HashSet((Collection) Objects.requireNonNull(collection));
        this.simpleHttpClient = simpleHttpClient;
    }

    public void track(PlayerState playerState) {
        if (this.errorUrls.isEmpty()) {
            this.logger.info(LogDomain.VAST, "Wanted to track VastError [%d], but no beacon URLs available", playerState.errorCode);
            return;
        }
        this.logger.info(LogDomain.VAST, "Tracking VastError [%d]", playerState.errorCode);
        for (String str : this.errorUrls) {
            if (!TextUtils.isEmpty(str)) {
                final String strInjectMacros = this.macroInjector.injectMacros(str, playerState);
                Threads.runOnBackgroundThread(new Runnable() { // from class: com.smaato.sdk.video.vast.tracking.VastErrorTracker$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m5723x18bb4018(strInjectMacros);
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: lambda$track$0$com-smaato-sdk-video-vast-tracking-VastErrorTracker, reason: not valid java name */
    /* synthetic */ void m5723x18bb4018(String str) {
        this.simpleHttpClient.fireAndForget(Collections.singletonList(str));
    }
}
