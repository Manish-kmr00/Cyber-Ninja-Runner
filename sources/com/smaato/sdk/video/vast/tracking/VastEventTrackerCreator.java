package com.smaato.sdk.video.vast.tracking;

import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.simplehttp.SimpleHttpClient;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.video.vast.exceptions.VastElementMissingException;
import com.smaato.sdk.video.vast.model.Tracking;
import com.smaato.sdk.video.vast.model.VastCompanionScenario;
import com.smaato.sdk.video.vast.model.VastEvent;
import com.smaato.sdk.video.vast.model.VastScenario;
import com.smaato.sdk.video.vast.tracking.macro.MacrosInjectorProviderFunction;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class VastEventTrackerCreator {
    private final Logger logger;
    private final MacrosInjectorProviderFunction macroInjectorProvider;
    SimpleHttpClient simpleHttpClient;

    public VastEventTrackerCreator(Logger logger, SimpleHttpClient simpleHttpClient, MacrosInjectorProviderFunction macrosInjectorProviderFunction) {
        this.logger = (Logger) Objects.requireNonNull(logger);
        this.macroInjectorProvider = (MacrosInjectorProviderFunction) Objects.requireNonNull(macrosInjectorProviderFunction);
        this.simpleHttpClient = simpleHttpClient;
    }

    public VastEventTracker createEventTracker(VastScenario vastScenario) {
        Map mapCreateTrackingEventsMap = createTrackingEventsMap(vastScenario);
        Logger logger = this.logger;
        return new VastEventTracker(logger, this.simpleHttpClient, mapCreateTrackingEventsMap, OffsetEventsManager.fromTrackingsMap(mapCreateTrackingEventsMap, vastScenario.vastMediaFileScenario.duration, logger), this.macroInjectorProvider.apply(vastScenario));
    }

    private Map createTrackingEventsMap(VastScenario vastScenario) {
        HashMap map = new HashMap();
        extractTrackingsToMap(map, vastScenario.vastMediaFileScenario.trackingEvents);
        VastCompanionScenario vastCompanionScenario = vastScenario.vastCompanionScenario;
        if (vastCompanionScenario != null) {
            extractTrackingsToMapForCompanionAd(map, vastCompanionScenario.trackingEvents);
        }
        return Collections.unmodifiableMap(map);
    }

    private void extractTrackingsToMap(Map map, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            final Tracking tracking = (Tracking) it.next();
            if (!map.containsKey(tracking.vastEvent)) {
                map.put(tracking.vastEvent, new LinkedList());
            }
            Objects.onNotNull((LinkedList) map.get(tracking.vastEvent), new Consumer() { // from class: com.smaato.sdk.video.vast.tracking.VastEventTrackerCreator$$ExternalSyntheticLambda0
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((LinkedList) obj).add(tracking);
                }
            });
        }
    }

    private void extractTrackingsToMapForCompanionAd(Map map, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            final Tracking tracking = (Tracking) it.next();
            Object obj = tracking.vastEvent;
            if (obj == VastEvent.CREATIVE_VIEW) {
                VastEvent vastEvent = VastEvent.CREATIVE_VIEW_COMPANION;
                if (!map.containsKey(vastEvent)) {
                    map.put(vastEvent, new LinkedList());
                }
                try {
                    Tracking.Builder builder = new Tracking.Builder();
                    builder.setVastEvent(vastEvent).setOffset(tracking.offset).setUrl(tracking.url);
                    final Tracking trackingBuild = builder.build();
                    Objects.onNotNull((LinkedList) map.get(vastEvent), new Consumer() { // from class: com.smaato.sdk.video.vast.tracking.VastEventTrackerCreator$$ExternalSyntheticLambda1
                        @Override // com.smaato.sdk.core.util.fi.Consumer
                        public final void accept(Object obj2) {
                            ((LinkedList) obj2).add(trackingBuild);
                        }
                    });
                } catch (VastElementMissingException e) {
                    this.logger.error(LogDomain.VAST, e, "VastElementMissingException in extractTrackingsToMapForCompanionAd", new Object[0]);
                }
            } else {
                if (!map.containsKey(obj)) {
                    map.put(tracking.vastEvent, new LinkedList());
                }
                Objects.onNotNull((LinkedList) map.get(tracking.vastEvent), new Consumer() { // from class: com.smaato.sdk.video.vast.tracking.VastEventTrackerCreator$$ExternalSyntheticLambda2
                    @Override // com.smaato.sdk.core.util.fi.Consumer
                    public final void accept(Object obj2) {
                        ((LinkedList) obj2).add(tracking);
                    }
                });
            }
        }
    }
}
