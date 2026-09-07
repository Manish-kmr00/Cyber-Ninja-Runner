package com.smaato.sdk.video.vast.tracking;

import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.simplehttp.SimpleHttpClient;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.Threads;
import com.smaato.sdk.core.util.collections.Sets;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.core.util.fi.Predicate;
import com.smaato.sdk.video.vast.model.Tracking;
import com.smaato.sdk.video.vast.model.VastEvent;
import com.smaato.sdk.video.vast.tracking.macro.MacroInjector;
import com.smaato.sdk.video.vast.tracking.macro.PlayerState;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes9.dex */
public class VastEventTracker {
    private final Logger logger;
    private final MacroInjector macroInjector;
    private final OffsetEventsManager offsetEventsManager;
    private final SimpleHttpClient simpleHttpClient;
    private final Set trackedEvents = Collections.synchronizedSet(new HashSet());
    private final Map trackingEvents;

    VastEventTracker(Logger logger, SimpleHttpClient simpleHttpClient, Map<VastEvent, List<Tracking>> map, OffsetEventsManager offsetEventsManager, MacroInjector macroInjector) {
        this.logger = (Logger) Objects.requireNonNull(logger);
        this.macroInjector = (MacroInjector) Objects.requireNonNull(macroInjector);
        this.trackingEvents = (Map) Objects.requireNonNull(map);
        this.offsetEventsManager = (OffsetEventsManager) Objects.requireNonNull(offsetEventsManager);
        this.simpleHttpClient = simpleHttpClient;
    }

    public void triggerProgressDependentEvent(PlayerState playerState, long j) {
        Long l = playerState.offsetMillis;
        if (l == null) {
            return;
        }
        m5726xd19c2b9(this.offsetEventsManager.getOffsettedTrackingsToTrackNow(this.logger, l.longValue(), j), playerState);
    }

    public void triggerEventByName(VastEvent vastEvent, final PlayerState playerState) {
        Objects.onNotNull((List) this.trackingEvents.get(vastEvent), new Consumer() { // from class: com.smaato.sdk.video.vast.tracking.VastEventTracker$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5726xd19c2b9(playerState, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: trackIfNotSent, reason: merged with bridge method [inline-methods] */
    public void m5726xd19c2b9(Collection collection, PlayerState playerState) {
        Set setRetainToSet = Sets.retainToSet(collection, new Predicate() { // from class: com.smaato.sdk.video.vast.tracking.VastEventTracker$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.util.fi.Predicate
            public final boolean test(Object obj) {
                return this.f$0.m5725x9940cbb9((Tracking) obj);
            }
        });
        if (setRetainToSet.isEmpty()) {
            return;
        }
        markAsTracked(setRetainToSet);
        track(setRetainToSet, playerState);
    }

    /* JADX INFO: renamed from: lambda$trackIfNotSent$1$com-smaato-sdk-video-vast-tracking-VastEventTracker, reason: not valid java name */
    /* synthetic */ boolean m5725x9940cbb9(Tracking tracking) {
        VastEvent vastEvent = tracking.vastEvent;
        return (vastEvent.oneTime && this.trackedEvents.contains(vastEvent)) ? false : true;
    }

    private void markAsTracked(Tracking tracking) {
        this.offsetEventsManager.markAsTracked(tracking);
        this.trackedEvents.add(tracking.vastEvent);
    }

    private void markAsTracked(Set set) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            markAsTracked((Tracking) it.next());
        }
    }

    private void track(Collection collection, PlayerState playerState) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            track((Tracking) it.next(), playerState);
        }
    }

    private void track(final Tracking tracking, final PlayerState playerState) {
        Threads.runOnBackgroundThread(new Runnable() { // from class: com.smaato.sdk.video.vast.tracking.VastEventTracker$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5724x5a869a48(tracking, playerState);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$track$2$com-smaato-sdk-video-vast-tracking-VastEventTracker, reason: not valid java name */
    /* synthetic */ void m5724x5a869a48(Tracking tracking, PlayerState playerState) {
        this.simpleHttpClient.fireAndForget(Collections.singletonList(this.macroInjector.injectMacros(tracking.url, playerState)));
    }
}
