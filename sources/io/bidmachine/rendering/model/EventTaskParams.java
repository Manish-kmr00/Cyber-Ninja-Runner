package io.bidmachine.rendering.model;

/* JADX INFO: loaded from: classes13.dex */
public class EventTaskParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EventTaskType f12411a;
    private final String b;
    private final Object c;

    public EventTaskParams(EventTaskType eventTaskType, String target) {
        this(eventTaskType, target, null);
    }

    public EventTaskType getEventTaskType() {
        return this.f12411a;
    }

    public String getTarget() {
        return this.b;
    }

    public Object getValue() {
        return this.c;
    }

    public EventTaskParams(EventTaskType eventTaskType, String target, Object value) {
        this.f12411a = eventTaskType;
        this.b = target.toLowerCase();
        this.c = value;
    }
}
