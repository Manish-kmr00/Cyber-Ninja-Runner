package com.smaato.sdk.core.util;

import java.lang.Enum;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class StateMachine<Event extends Enum<Event>, State extends Enum<State>> {
    private final Map graph;
    private boolean inTransition;
    private final LinkedHashSet listeners;
    private Enum state;

    public interface Listener<State> {
        void onStateChanged(State state, State state2, Metadata metadata);
    }

    private StateMachine(Map map, Enum r3) {
        this.listeners = new LinkedHashSet();
        this.graph = map;
        this.state = r3;
    }

    public void onEvent(Event event) {
        onEvent(event, null);
    }

    public synchronized void onEvent(Event event, Metadata metadata) {
        List list = (List) this.graph.get(Pair.of(event, this.state));
        if (list == null) {
            return;
        }
        if (this.inTransition) {
            throw new IllegalStateException("can not start a new transition, because there is an on-going unfinished transition");
        }
        int size = list.size();
        int i = 0;
        while (i < size) {
            this.inTransition = i < size + (-1);
            Enum r3 = this.state;
            Enum r4 = (Enum) list.get(i);
            this.state = r4;
            java.util.Iterator it = new ArrayList(this.listeners).iterator();
            while (it.hasNext()) {
                ((Listener) it.next()).onStateChanged(r3, r4, metadata);
            }
            i++;
        }
    }

    public synchronized boolean isTransitionAllowed(Event event) {
        return this.graph.get(Pair.of(event, this.state)) != null;
    }

    public synchronized State getCurrentState() {
        return (State) this.state;
    }

    public synchronized void addListener(Listener<State> listener) {
        Objects.requireNonNull(listener, "listener can not be null");
        this.listeners.add(listener);
    }

    public synchronized void deleteListeners() {
        this.listeners.clear();
    }

    public synchronized void deleteListener(Listener<State> listener) {
        this.listeners.remove(listener);
    }

    public static class Builder<Event extends Enum<Event>, State extends Enum<State>> {
        private final Map graph = new HashMap();
        private Enum initialState;

        public Builder<Event, State> setInitialState(State state) {
            this.initialState = (Enum) Objects.requireNonNull(state, "initialState can not be null");
            return this;
        }

        public Builder<Event, State> addTransition(Event event, List<State> list) {
            Objects.requireNonNull(event, "event can not be null");
            ArrayList arrayList = new ArrayList((Collection) Objects.requireNonNull(list, "statePath can not be null"));
            if (arrayList.size() < 2) {
                throw new IllegalArgumentException("statePath must have at least 2 states");
            }
            java.util.Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Objects.requireNonNull((Enum) it.next(), "a state can not be null");
            }
            if (arrayList.size() > EnumSet.copyOf((Collection) arrayList).size()) {
                throw new IllegalArgumentException("a statePath must consist of unique states");
            }
            Enum r5 = (Enum) arrayList.remove(0);
            Pair pairOf = Pair.of(event, r5);
            if (this.graph.containsKey(pairOf)) {
                throw new IllegalArgumentException("a statePath with the same start state " + r5 + " is already defined for the event " + event);
            }
            this.graph.put(pairOf, arrayList);
            return this;
        }

        public Builder<Event, State> addLoopTransition(Event event, State state) {
            Objects.requireNonNull(event, "event cannot be null");
            Objects.requireNonNull(state, "state cannot be null");
            Pair pairOf = Pair.of(event, state);
            if (this.graph.containsKey(pairOf)) {
                throw new IllegalArgumentException("a statePath with the same start state " + state + " is already defined for the event " + event);
            }
            this.graph.put(pairOf, Collections.singletonList(state));
            return this;
        }

        public StateMachine<Event, State> build() {
            if (this.initialState == null) {
                throw new IllegalStateException("initialState must be set");
            }
            if (this.graph.isEmpty()) {
                throw new IllegalStateException("at least one transition must be added");
            }
            return new StateMachine<>(this.graph, this.initialState);
        }
    }
}
