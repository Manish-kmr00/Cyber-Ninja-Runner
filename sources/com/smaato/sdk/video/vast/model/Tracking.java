package com.smaato.sdk.video.vast.model;

import com.smaato.sdk.core.util.TextUtils;
import com.smaato.sdk.video.vast.exceptions.VastElementMissingException;
import com.smaato.sdk.video.vast.utils.VastModels;

/* JADX INFO: loaded from: classes.dex */
public class Tracking {
    public static final String EVENT = "event";
    public static final String NAME = "Tracking";
    public static final String OFFSET = "offset";
    public static final String URL = "url";
    public final String offset;
    public final String url;
    public final VastEvent vastEvent;

    Tracking(VastEvent vastEvent, String str, String str2) {
        this.vastEvent = vastEvent;
        this.url = str;
        this.offset = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Tracking tracking = (Tracking) obj;
        if (!this.url.equals(tracking.url) || this.vastEvent != tracking.vastEvent) {
            return false;
        }
        String str = this.offset;
        String str2 = tracking.offset;
        if (str != null) {
            return str.equals(str2);
        }
        return str2 == null;
    }

    public int hashCode() {
        int iHashCode = ((this.url.hashCode() * 31) + this.vastEvent.hashCode()) * 31;
        String str = this.offset;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public static class Builder {
        private String offset;
        private String url;
        private VastEvent vastEvent;

        public Builder setUrl(String str) {
            this.url = str;
            return this;
        }

        public Builder setVastEvent(VastEvent vastEvent) {
            this.vastEvent = vastEvent;
            return this;
        }

        public Builder setOffset(String str) {
            this.offset = str;
            return this;
        }

        public Tracking build() throws VastElementMissingException {
            VastModels.requireNonNull(this.vastEvent, "Cannot build Tracking: event is missing");
            VastModels.requireNonNull(this.url, "Cannot build Tracking: url is missing");
            String offsetForQuarterEvent = TextUtils.isEmpty(this.offset) ? getOffsetForQuarterEvent(this.vastEvent) : this.offset;
            this.offset = offsetForQuarterEvent;
            return new Tracking(this.vastEvent, this.url, offsetForQuarterEvent);
        }

        private String getOffsetForQuarterEvent(VastEvent vastEvent) {
            int i = AnonymousClass1.$SwitchMap$com$smaato$sdk$video$vast$model$VastEvent[vastEvent.ordinal()];
            if (i == 1) {
                return "75%";
            }
            if (i == 2) {
                return "50%";
            }
            if (i == 3) {
                return "25%";
            }
            if (i != 4) {
                return null;
            }
            return "0%";
        }
    }

    /* JADX INFO: renamed from: com.smaato.sdk.video.vast.model.Tracking$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$smaato$sdk$video$vast$model$VastEvent;

        static {
            int[] iArr = new int[VastEvent.values().length];
            $SwitchMap$com$smaato$sdk$video$vast$model$VastEvent = iArr;
            try {
                iArr[VastEvent.THIRD_QUARTILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$smaato$sdk$video$vast$model$VastEvent[VastEvent.MID_POINT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$smaato$sdk$video$vast$model$VastEvent[VastEvent.FIRST_QUARTILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$smaato$sdk$video$vast$model$VastEvent[VastEvent.START.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
