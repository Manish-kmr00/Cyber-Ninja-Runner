package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.feed.FeedAdAppearance;
import com.yandex.mobile.ads.feed.FeedAdRequestConfiguration;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b90 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final v80 f8482a;

    public /* synthetic */ b90() {
        this(new v80());
    }

    public b90(v80 appearanceParametersProvider) {
        Intrinsics.checkNotNullParameter(appearanceParametersProvider, "appearanceParametersProvider");
        this.f8482a = appearanceParametersProvider;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x003c  */
    public final v7 a(FeedAdRequestConfiguration feedAdRequestConfiguration, FeedAdAppearance appearance) {
        Map mapEmptyMap;
        if (appearance != null) {
            this.f8482a.getClass();
            Intrinsics.checkNotNullParameter(appearance, "appearance");
            Map mapCreateMapBuilder = MapsKt.createMapBuilder();
            if (appearance.getCardCornerRadius() != null) {
                mapCreateMapBuilder.put("card_corner_radius", appearance.getCardCornerRadius().toString());
            }
            if (appearance.getCardWidth() != null) {
                mapCreateMapBuilder.put("card_width", appearance.getCardWidth().toString());
            }
            mapEmptyMap = MapsKt.build(mapCreateMapBuilder);
            if (mapEmptyMap == null) {
                mapEmptyMap = MapsKt.emptyMap();
            }
        } else {
            mapEmptyMap = MapsKt.emptyMap();
        }
        Map mapCreateMapBuilder2 = MapsKt.createMapBuilder();
        if ((feedAdRequestConfiguration != null ? feedAdRequestConfiguration.getParameters() : null) != null) {
            mapCreateMapBuilder2.putAll(feedAdRequestConfiguration.getParameters());
        }
        mapCreateMapBuilder2.putAll(mapEmptyMap);
        Map<String, String> mapBuild = MapsKt.build(mapCreateMapBuilder2);
        String adUnitId = feedAdRequestConfiguration != null ? feedAdRequestConfiguration.getAdUnitId() : null;
        if (adUnitId == null) {
            adUnitId = "";
        }
        return new v7.a(adUnitId).a(feedAdRequestConfiguration != null ? feedAdRequestConfiguration.getAge() : null).c(feedAdRequestConfiguration != null ? feedAdRequestConfiguration.getGender() : null).b(feedAdRequestConfiguration != null ? feedAdRequestConfiguration.getContextQuery() : null).a(feedAdRequestConfiguration != null ? feedAdRequestConfiguration.getContextTags() : null).a(feedAdRequestConfiguration != null ? feedAdRequestConfiguration.getLocation() : null).a(mapBuild).a();
    }
}
