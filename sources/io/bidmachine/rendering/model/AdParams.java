package io.bidmachine.rendering.model;

import io.bidmachine.rendering.internal.i;
import io.bidmachine.rendering.utils.Utils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/* JADX INFO: loaded from: classes6.dex */
public class AdParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CacheType f12400a;
    private final Queue b;
    private final VisibilityParams c;
    private final AdPhaseParams d;
    private final Orientation e;
    private final Map f;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Queue f12401a = new LinkedList();
        private final Map b = new HashMap();
        private CacheType c;
        private AdPhaseParams d;
        private VisibilityParams e;
        private Orientation f;

        public Builder addAdPhaseParams(AdPhaseParams adPhaseParams) {
            this.f12401a.add(adPhaseParams);
            return this;
        }

        public AdParams build() {
            CacheType cacheType = this.c;
            if (cacheType == null) {
                cacheType = i.f12366a;
            }
            CacheType cacheType2 = cacheType;
            Queue queue = this.f12401a;
            VisibilityParams visibilityParamsBuild = this.e;
            if (visibilityParamsBuild == null) {
                visibilityParamsBuild = new VisibilityParams.Builder().build();
            }
            return new AdParams(cacheType2, queue, visibilityParamsBuild, this.d, this.f, this.b);
        }

        public Builder setAdPhaseParamsQueue(Queue<AdPhaseParams> adPhaseParamsQueue) {
            Utils.set(this.f12401a, adPhaseParamsQueue);
            return this;
        }

        public Builder setCacheType(CacheType cacheType) {
            this.c = cacheType;
            return this;
        }

        public Builder setCustomParams(Map<String, String> customParams) {
            Utils.set(this.b, customParams);
            return this;
        }

        public Builder setOrientation(Orientation orientation) {
            this.f = orientation;
            return this;
        }

        public Builder setPlaceholderParams(AdPhaseParams placeholderParams) {
            this.d = placeholderParams;
            return this;
        }

        public Builder setVisibilityParams(VisibilityParams visibilityParams) {
            this.e = visibilityParams;
            return this;
        }
    }

    public AdParams(CacheType cacheType, Queue<AdPhaseParams> adPhaseParamsQueue, VisibilityParams visibilityParams, AdPhaseParams placeholderParams, Orientation orientation, Map<String, String> customParams) {
        this.f12400a = cacheType;
        this.b = adPhaseParamsQueue;
        this.c = visibilityParams;
        this.d = placeholderParams;
        this.e = orientation;
        this.f = customParams;
    }

    public Queue<AdPhaseParams> getAdPhaseParamsQueue() {
        return this.b;
    }

    public CacheType getCacheType() {
        return this.f12400a;
    }

    public String getCustomParam(String key) {
        return (String) this.f.get(key);
    }

    public Map<String, String> getCustomParams() {
        return this.f;
    }

    public Orientation getOrientation() {
        return this.e;
    }

    public AdPhaseParams getPlaceholderParams() {
        return this.d;
    }

    public VisibilityParams getVisibilityParams() {
        return this.c;
    }
}
