package io.bidmachine.rendering.model;

import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public class MeasurerParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12415a;
    private final Map b;

    public MeasurerParams(String name, Map<String, String> parameters) {
        this.f12415a = name;
        this.b = parameters;
    }

    public String getName() {
        return this.f12415a;
    }

    public Map<String, String> getParameters() {
        return this.b;
    }
}
