package com.pubmatic.sdk.video.vastmodels;

import com.json.b9;
import com.pubmatic.sdk.video.xmlserialiser.POBXMLNodeListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.pubnative.lite.sdk.vpaid.enums.EventConstants;

/* JADX INFO: loaded from: classes6.dex */
public abstract class POBVastCreative implements POBXMLNodeListener {
    protected String mClickThroughURL;
    protected List<String> mClickTrackers;

    public enum CreativeType {
        LINEAR,
        NONLINEAR,
        COMPANION
    }

    public enum POBEventTypes {
        CREATIVE_VIEW("creativeview"),
        START("start"),
        FIRST_QUARTILE("firstquartile"),
        MID_POINT("midpoint"),
        THIRD_QUARTILE(EventConstants.THIRD_QUARTILE),
        COMPLETE("complete"),
        MUTE("mute"),
        UNMUTE("unmute"),
        PAUSE("pause"),
        REWIND(EventConstants.REWIND),
        RESUME("resume"),
        FULL_SCREEN("fullscreen"),
        EXIT_FULL_SCREEN("exitFullscreen"),
        EXPAND("expand"),
        COLLAPSE("collapse"),
        ACCEPT_INVITATION_LINEAR("acceptInvitationLinear"),
        CLOSE_LINEAR(EventConstants.CLOSE_LINEAR),
        SKIP(EventConstants.SKIP),
        PROGRESS("progress"),
        AD_EXPAND(EventConstants.AD_EXPAND),
        AD_COLLAPSE(EventConstants.AD_COLLAPSE),
        MINIMIZE(EventConstants.MINIMIZE),
        OVERLAY_VIEW_DURATION(EventConstants.OVERLAY_VIEW_DURATION),
        CLOSE("close"),
        OTHER_AD_INTERACTION(EventConstants.OTHER_AD_INTERACTION),
        LOADED(b9.h.r),
        PLAYER_EXPAND(EventConstants.PLAYER_EXPAND),
        PLAYER_COLLAPSE(EventConstants.PLAYER_COLLAPSE),
        NOT_USED(EventConstants.NOT_USED);

        private final String b;

        POBEventTypes(String str) {
            this.b = str;
        }

        public String getValue() {
            return this.b;
        }
    }

    public String getClickThroughURL() {
        return this.mClickThroughURL;
    }

    public List<String> getClickTrackers() {
        return this.mClickTrackers;
    }

    public List<String> getTrackingEventUrls(POBEventTypes pOBEventTypes) {
        ArrayList arrayList = new ArrayList();
        List<POBTracking> trackingEvents = getTrackingEvents(pOBEventTypes);
        if (trackingEvents != null) {
            Iterator<POBTracking> it = trackingEvents.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getUrl());
            }
        }
        return arrayList;
    }

    abstract List getTrackingEvents();

    public List<POBTracking> getTrackingEvents(POBEventTypes pOBEventTypes) {
        ArrayList arrayList = new ArrayList();
        List<POBTracking> trackingEvents = getTrackingEvents();
        if (trackingEvents != null) {
            for (POBTracking pOBTracking : trackingEvents) {
                if (pOBTracking.getEvent() != null && pOBTracking.getEvent().equalsIgnoreCase(pOBEventTypes.getValue())) {
                    arrayList.add(pOBTracking);
                }
            }
        }
        return arrayList;
    }

    public abstract CreativeType getVastCreativeType();
}
