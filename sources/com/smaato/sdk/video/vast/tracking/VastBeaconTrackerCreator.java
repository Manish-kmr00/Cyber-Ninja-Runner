package com.smaato.sdk.video.vast.tracking;

import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.simplehttp.SimpleHttpClient;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.collections.Iterables;
import com.smaato.sdk.core.util.collections.Sets;
import com.smaato.sdk.core.util.fi.Function;
import com.smaato.sdk.video.vast.model.IconClicks;
import com.smaato.sdk.video.vast.model.VastBeacon;
import com.smaato.sdk.video.vast.model.VastBeaconEvent;
import com.smaato.sdk.video.vast.model.VastCompanionScenario;
import com.smaato.sdk.video.vast.model.VastIconScenario;
import com.smaato.sdk.video.vast.model.VastMediaFileScenario;
import com.smaato.sdk.video.vast.model.VastScenario;
import com.smaato.sdk.video.vast.model.VideoClicks;
import com.smaato.sdk.video.vast.model.ViewableImpression;
import com.smaato.sdk.video.vast.tracking.macro.MacrosInjectorProviderFunction;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class VastBeaconTrackerCreator {
    private final Function beaconToUrlMapper = new Function() { // from class: com.smaato.sdk.video.vast.tracking.VastBeaconTrackerCreator$$ExternalSyntheticLambda0
        @Override // com.smaato.sdk.core.util.fi.Function
        public final Object apply(Object obj) {
            return ((VastBeacon) obj).uri;
        }
    };
    private final Logger logger;
    private final MacrosInjectorProviderFunction macrosInjectorProvider;
    private final SimpleHttpClient simpleHttpClient;

    public VastBeaconTrackerCreator(Logger logger, SimpleHttpClient simpleHttpClient, MacrosInjectorProviderFunction macrosInjectorProviderFunction) {
        this.logger = (Logger) Objects.requireNonNull(logger);
        this.simpleHttpClient = (SimpleHttpClient) Objects.requireNonNull(simpleHttpClient);
        this.macrosInjectorProvider = (MacrosInjectorProviderFunction) Objects.requireNonNull(macrosInjectorProviderFunction);
    }

    public VastBeaconTracker createBeaconTracker(VastScenario vastScenario) {
        return new VastBeaconTracker(this.logger, this.simpleHttpClient, this.macrosInjectorProvider.apply(vastScenario), createTrackingBeaconsManager(vastScenario));
    }

    private VastTrackingBeaconsManager createTrackingBeaconsManager(VastScenario vastScenario) {
        return new VastTrackingBeaconsManager(createVastBeaconEventsMap(vastScenario));
    }

    private Map createVastBeaconEventsMap(VastScenario vastScenario) {
        HashMap map = new HashMap();
        fillForKey(map, VastBeaconEvent.SMAATO_IMPRESSION, Iterables.map(vastScenario.impressions, this.beaconToUrlMapper));
        ViewableImpression viewableImpression = vastScenario.viewableImpression;
        if (viewableImpression != null) {
            fillForKey(map, VastBeaconEvent.SMAATO_VIEWABLE_IMPRESSION, viewableImpression.viewable);
        }
        VastMediaFileScenario vastMediaFileScenario = vastScenario.vastMediaFileScenario;
        VideoClicks videoClicks = vastMediaFileScenario.videoClicks;
        if (videoClicks != null) {
            fillForKey(map, VastBeaconEvent.SMAATO_VIDEO_CLICK_TRACKING, Iterables.map(videoClicks.clickTrackings, this.beaconToUrlMapper));
        }
        VastIconScenario vastIconScenario = vastMediaFileScenario.vastIconScenario;
        if (vastIconScenario != null) {
            IconClicks iconClicks = vastIconScenario.iconClicks;
            if (iconClicks != null) {
                fillForKey(map, VastBeaconEvent.SMAATO_ICON_CLICK_TRACKING, Iterables.map(iconClicks.iconClickTrackings, this.beaconToUrlMapper));
            }
            fillForKey(map, VastBeaconEvent.SMAATO_ICON_VIEW_TRACKING, vastIconScenario.iconViewTrackings);
        }
        VastCompanionScenario vastCompanionScenario = vastScenario.vastCompanionScenario;
        if (vastCompanionScenario != null) {
            fillForKey(map, VastBeaconEvent.SMAATO_COMPANION_CLICK_TRACKING, Iterables.map(vastCompanionScenario.companionClickTrackings, this.beaconToUrlMapper));
        }
        return Collections.unmodifiableMap(map);
    }

    private void fillForKey(Map map, VastBeaconEvent vastBeaconEvent, Iterable iterable) {
        if (map.containsKey(vastBeaconEvent)) {
            throw new IllegalArgumentException(String.format("beaconsEventsMap already contains %s event", vastBeaconEvent));
        }
        map.put(vastBeaconEvent, Collections.unmodifiableSet(Sets.toSet(iterable)));
    }
}
