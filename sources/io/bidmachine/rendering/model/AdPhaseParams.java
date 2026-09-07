package io.bidmachine.rendering.model;

import androidx.core.view.ViewCompat;
import io.bidmachine.rendering.utils.Utils;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public class AdPhaseParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f12402a;
    private final List b;
    private final List c;
    private final Map d;
    private final Map e;
    private final int f;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f12403a = new ArrayList();
        private final List b = new ArrayList();
        private final List c = new ArrayList();
        private final Map d = new HashMap();
        private final Map e = new HashMap();
        private int f = ViewCompat.MEASURED_STATE_MASK;

        public Builder addAdsElementParams(AdElementParams adElementParams) {
            this.f12403a.add(adElementParams);
            return this;
        }

        public Builder addControlsElementParams(AdElementParams adElementParams) {
            this.b.add(adElementParams);
            return this;
        }

        public Builder addEventParams(EventParams eventParams) {
            String source = eventParams.getSource();
            EventType eventType = eventParams.getEventType();
            List<EventTaskParams> eventTaskParamsList = eventParams.getEventTaskParamsList();
            if (eventTaskParamsList.isEmpty()) {
                return this;
            }
            Map enumMap = (Map) this.d.get(source);
            if (enumMap == null) {
                enumMap = new EnumMap(EventType.class);
                this.d.put(source, enumMap);
            }
            List arrayList = (List) enumMap.get(eventType);
            if (arrayList == null) {
                arrayList = new ArrayList();
                enumMap.put(eventType, arrayList);
            }
            arrayList.addAll(eventTaskParamsList);
            return this;
        }

        public Builder addMethodParams(MethodParams methodParams) {
            this.c.add(methodParams);
            return this;
        }

        public AdPhaseParams build() {
            return new AdPhaseParams(this.f12403a, this.b, this.c, this.d, this.e, this.f);
        }

        public Builder setAdsElementParamsList(List<AdElementParams> adsElementParamsList) {
            Utils.set(this.f12403a, adsElementParamsList);
            return this;
        }

        public Builder setBackgroundColor(int backgroundColor) {
            this.f = backgroundColor;
            return this;
        }

        public Builder setControlsElementParamsList(List<AdElementParams> controlsElementParamsList) {
            Utils.set(this.b, controlsElementParamsList);
            return this;
        }

        public Builder setCustomParams(Map<String, String> customParams) {
            Utils.set(this.e, customParams);
            return this;
        }

        public Builder setEventParamsList(Map<String, Map<EventType, List<EventTaskParams>>> sourceEventTypeMap) {
            Utils.set(this.d, sourceEventTypeMap);
            return this;
        }

        public Builder setMethodParamsList(List<MethodParams> methodParamsList) {
            Utils.set(this.c, methodParamsList);
            return this;
        }
    }

    public AdPhaseParams(List<AdElementParams> adsList, List<AdElementParams> controlsList, List<MethodParams> methodParamsList, Map<String, Map<EventType, List<EventTaskParams>>> sourceEventTypeMap, Map<String, String> customParams, int backgroundColor) {
        this.f12402a = adsList;
        this.b = controlsList;
        this.c = methodParamsList;
        this.d = sourceEventTypeMap;
        this.e = customParams;
        this.f = backgroundColor;
    }

    public List<AdElementParams> getAdsList() {
        return this.f12402a;
    }

    public int getBackgroundColor() {
        return this.f;
    }

    public List<AdElementParams> getControlsList() {
        return this.b;
    }

    public String getCustomParam(String key) {
        return (String) this.e.get(key);
    }

    public Map<String, String> getCustomParams() {
        return this.e;
    }

    public Map<EventType, List<EventTaskParams>> getEventTypeMap(String sourceName) {
        return getSourceEventTypeMap().get(sourceName);
    }

    public List<MethodParams> getMethodParamsList() {
        return this.c;
    }

    public Map<String, Map<EventType, List<EventTaskParams>>> getSourceEventTypeMap() {
        return this.d;
    }
}
