package io.bidmachine.rendering.model;

import android.text.TextUtils;
import io.bidmachine.rendering.measurer.MeasurerFactory;
import io.bidmachine.rendering.utils.Utils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class AdElementParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AdElementType f12397a;
    private final String b;
    private final String c;
    private final String d;
    private final ElementLayoutParams e;
    private final AppearanceParams f;
    private final Map g;
    private final MeasurerFactory h;
    private final List i;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AdElementType f12398a;
        private final String b;
        private final ElementLayoutParams c;
        private final AppearanceParams d;
        private final Map e = new HashMap();
        private String f;
        private String g;
        private MeasurerFactory h;
        private List i;

        public Builder(AdElementType adElementType, String name, ElementLayoutParams elementLayoutParams, AppearanceParams appearanceParams) {
            this.f12398a = adElementType;
            this.b = name;
            this.c = elementLayoutParams;
            this.d = appearanceParams;
        }

        public AdElementParams build() {
            return new AdElementParams(this.f12398a, this.b, this.f, this.g, this.c, this.d, this.e, this.h, this.i);
        }

        public Builder setCustomParams(Map<String, String> customParams) {
            Utils.set(this.e, customParams);
            return this;
        }

        public Builder setMeasurerFactory(MeasurerFactory measurerFactory) {
            this.h = measurerFactory;
            return this;
        }

        public Builder setMeasurerParamsList(List<MeasurerParams> measurerParamsList) {
            this.i = measurerParamsList;
            return this;
        }

        public Builder setPlaceholder(String placeholder) {
            this.g = placeholder;
            return this;
        }

        public Builder setSource(String source) {
            this.f = source;
            return this;
        }
    }

    public AdElementParams(AdElementType adElementType, String name, String source, String placeholder, ElementLayoutParams elementLayoutParams, AppearanceParams appearanceParams, Map<String, String> customParams, MeasurerFactory measurerFactory, List<MeasurerParams> measurerParamsList) {
        this.f12397a = adElementType;
        this.b = name.toLowerCase();
        this.c = source;
        this.d = placeholder;
        this.e = elementLayoutParams;
        this.f = appearanceParams;
        this.g = customParams;
        this.h = measurerFactory;
        this.i = measurerParamsList;
    }

    public AdElementParams addCustomParams(String key, String value) {
        if (!TextUtils.isEmpty(key) && value != null) {
            this.g.put(key, value);
        }
        return this;
    }

    public AdElementType getAdElementType() {
        return this.f12397a;
    }

    public AppearanceParams getAppearanceParams() {
        return this.f;
    }

    public String getCustomParam(String key) {
        return (String) this.g.get(key);
    }

    public Map<String, String> getCustomParams() {
        return this.g;
    }

    public ElementLayoutParams getLayoutParams() {
        return this.e;
    }

    public MeasurerFactory getMeasurerFactory() {
        return this.h;
    }

    public List<MeasurerParams> getMeasurerParamsList() {
        return this.i;
    }

    public String getName() {
        return this.b;
    }

    public String getPlaceholder() {
        return this.d;
    }

    public String getSource() {
        return this.c;
    }
}
