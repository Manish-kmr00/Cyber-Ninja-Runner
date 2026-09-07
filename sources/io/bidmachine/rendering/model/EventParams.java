package io.bidmachine.rendering.model;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class EventParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EventType f12410a;
    private final String b;
    private final List c;

    public EventParams(EventType eventType, String source) {
        this(eventType, source, new ArrayList());
    }

    public EventParams addTaskParams(EventTaskParams eventTaskParams) {
        this.c.add(eventTaskParams);
        return this;
    }

    public List<EventTaskParams> getEventTaskParamsList() {
        return this.c;
    }

    public EventType getEventType() {
        return this.f12410a;
    }

    public String getSource() {
        return this.b;
    }

    public EventParams(EventType eventType, String source, List<EventTaskParams> eventTaskParamsList) {
        this.f12410a = eventType;
        this.b = source.toLowerCase();
        this.c = eventTaskParamsList;
    }
}
