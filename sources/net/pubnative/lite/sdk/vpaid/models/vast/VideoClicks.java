package net.pubnative.lite.sdk.vpaid.models.vast;

import java.util.List;
import net.pubnative.lite.sdk.vpaid.xml.Tag;

/* JADX INFO: loaded from: classes14.dex */
public class VideoClicks {

    @Tag
    private ClickThrough clickThrough;

    @Tag("ClickTracking")
    private List<ClickTracking> clickTrackingList;

    @Tag("CustomClick")
    private List<CustomClick> customClickList;

    public List<ClickTracking> getClickTrackingList() {
        return this.clickTrackingList;
    }

    public ClickThrough getClickThrough() {
        return this.clickThrough;
    }

    public List<CustomClick> getCustomClickList() {
        return this.customClickList;
    }
}
