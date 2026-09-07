package com.smaato.sdk.video.utils;

import com.smaato.sdk.core.util.Objects;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public final class EventValidator<Event, State> {
    private final Map validStatesForEvent;

    private EventValidator(Map map) {
        this.validStatesForEvent = map;
    }

    public boolean isValid(Event event, State state) {
        List list = (List) this.validStatesForEvent.get(event);
        if (list == null) {
            return false;
        }
        return list.contains(state);
    }

    public static class Builder<Event, State> {
        private final Map validStatesForEvent = new HashMap();

        public Builder<Event, State> setValidStatesForEvent(Event event, List<? extends State> list) {
            Objects.requireNonNull(event, "Parameter event can not be null");
            ArrayList arrayList = new ArrayList((Collection) Objects.requireNonNull(list, "Parameter states can not be null"));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Objects.requireNonNull(it.next(), "a state can not be null");
            }
            if (arrayList.size() > new HashSet(list).size()) {
                throw new IllegalArgumentException("a states must consist of unique states");
            }
            this.validStatesForEvent.put(event, arrayList);
            return this;
        }

        public EventValidator<Event, State> build() {
            if (this.validStatesForEvent.isEmpty()) {
                throw new IllegalStateException("At least one valid event for states should be added.");
            }
            return new EventValidator<>(this.validStatesForEvent);
        }
    }
}
