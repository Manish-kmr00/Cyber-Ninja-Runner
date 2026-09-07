package com.applovin.mediation;

import com.applovin.impl.mediation.MaxAdViewConfigurationImpl;
import com.pubmatic.sdk.common.POBCommonConstants;

/* JADX INFO: loaded from: classes5.dex */
public abstract class MaxAdViewConfiguration {

    public enum AdaptiveType {
        NONE("none"),
        ANCHORED("anchored"),
        INLINE(POBCommonConstants.BANNER_PLACEMENT_TYPE);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f782a;

        AdaptiveType(String str) {
            this.f782a = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.f782a;
        }
    }

    public interface Builder {
        MaxAdViewConfiguration build();

        Builder setAdaptiveType(AdaptiveType adaptiveType);

        Builder setAdaptiveWidth(int i);

        Builder setInlineMaximumHeight(int i);
    }

    public static Builder builder() {
        return new MaxAdViewConfigurationImpl.BuilderImpl();
    }

    public abstract AdaptiveType getAdaptiveType();

    public abstract int getAdaptiveWidth();

    public abstract int getInlineMaximumHeight();
}
