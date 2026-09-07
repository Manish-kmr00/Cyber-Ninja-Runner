package com.smaato.sdk.video.vast.tracking;

import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.simplehttp.SimpleHttpClient;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.Threads;
import com.smaato.sdk.video.vast.model.VastBeaconEvent;
import com.smaato.sdk.video.vast.tracking.macro.MacroInjector;
import com.smaato.sdk.video.vast.tracking.macro.PlayerState;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes11.dex */
public class VastBeaconTracker {
    private final MacroInjector macroInjector;
    private final SimpleHttpClient simpleHttpClient;
    private final VastTrackingBeaconsManager vastTrackingBeaconsManager;

    VastBeaconTracker(Logger logger, SimpleHttpClient simpleHttpClient, MacroInjector macroInjector, VastTrackingBeaconsManager vastTrackingBeaconsManager) {
        this.macroInjector = (MacroInjector) Objects.requireNonNull(macroInjector);
        this.vastTrackingBeaconsManager = (VastTrackingBeaconsManager) Objects.requireNonNull(vastTrackingBeaconsManager);
        this.simpleHttpClient = (SimpleHttpClient) Objects.requireNonNull(simpleHttpClient);
    }

    public void trigger(VastBeaconEvent vastBeaconEvent, PlayerState playerState) {
        if (this.vastTrackingBeaconsManager.isTracked(vastBeaconEvent)) {
            return;
        }
        Set urlsToTrack = getUrlsToTrack(vastBeaconEvent, playerState);
        if (urlsToTrack.isEmpty()) {
            return;
        }
        trackBeaconUrls(vastBeaconEvent, urlsToTrack);
    }

    private Set getUrlsToTrack(VastBeaconEvent vastBeaconEvent, PlayerState playerState) {
        Set<String> notSentBeaconUrls = this.vastTrackingBeaconsManager.getNotSentBeaconUrls(vastBeaconEvent);
        if (!notSentBeaconUrls.isEmpty()) {
            return Collections.unmodifiableSet(this.macroInjector.injectMacros(notSentBeaconUrls, playerState));
        }
        return Collections.emptySet();
    }

    private void trackBeaconUrls(VastBeaconEvent vastBeaconEvent, final Set set) {
        this.vastTrackingBeaconsManager.markAsTracked(vastBeaconEvent);
        Threads.runOnBackgroundThread(new Runnable() { // from class: com.smaato.sdk.video.vast.tracking.VastBeaconTracker$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5722xbcca2c64(set);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$trackBeaconUrls$0$com-smaato-sdk-video-vast-tracking-VastBeaconTracker, reason: not valid java name */
    /* synthetic */ void m5722xbcca2c64(Set set) {
        this.simpleHttpClient.fireAndForget(new ArrayList(set));
    }
}
