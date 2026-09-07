package com.smaato.sdk.richmedia.mraid.dataprovider;

import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.StateMachine;
import java.util.Arrays;

/* JADX INFO: loaded from: classes10.dex */
public final class MraidStateMachineFactory {
    private final State initialState;

    public enum Event {
        LOAD_COMPLETE,
        CLOSE,
        RESIZE,
        EXPAND,
        ERROR,
        RESIZING_FINISHED,
        EXPANDING_FINISHED,
        CLOSE_FINISHED,
        VISIBILITY_PARAMS_CHECK
    }

    public enum State {
        HIDDEN,
        LOADING,
        DEFAULT,
        RESIZED,
        EXPANDED,
        RESIZE_IN_PROGRESS,
        EXPAND_IN_PROGRESS,
        COLLAPSE_IN_PROGRESS
    }

    public MraidStateMachineFactory(State state) {
        this.initialState = (State) Objects.requireNonNull(state);
    }

    public StateMachine<Event, State> newInstanceForBanner() {
        StateMachine.Builder initialState = new StateMachine.Builder().setInitialState(this.initialState);
        Event event = Event.LOAD_COMPLETE;
        State state = State.DEFAULT;
        StateMachine.Builder builderAddTransition = initialState.addTransition(event, Arrays.asList(State.LOADING, state));
        Event event2 = Event.RESIZE;
        State state2 = State.RESIZE_IN_PROGRESS;
        StateMachine.Builder builderAddTransition2 = builderAddTransition.addTransition(event2, Arrays.asList(state, state2));
        State state3 = State.RESIZED;
        StateMachine.Builder builderAddTransition3 = builderAddTransition2.addTransition(event2, Arrays.asList(state3, state2)).addLoopTransition(event2, state2).addTransition(Event.RESIZING_FINISHED, Arrays.asList(state2, state3));
        Event event3 = Event.EXPAND;
        State state4 = State.EXPAND_IN_PROGRESS;
        StateMachine.Builder builderAddTransition4 = builderAddTransition3.addTransition(event3, Arrays.asList(state, state4)).addTransition(event3, Arrays.asList(state3, state4)).addTransition(event3, Arrays.asList(state2, state4));
        Event event4 = Event.EXPANDING_FINISHED;
        State state5 = State.EXPANDED;
        StateMachine.Builder builderAddTransition5 = builderAddTransition4.addTransition(event4, Arrays.asList(state4, state5));
        Event event5 = Event.CLOSE;
        State state6 = State.COLLAPSE_IN_PROGRESS;
        StateMachine.Builder builderAddTransition6 = builderAddTransition5.addTransition(event5, Arrays.asList(state3, state6)).addTransition(event5, Arrays.asList(state5, state6));
        Event event6 = Event.ERROR;
        StateMachine.Builder builderAddTransition7 = builderAddTransition6.addTransition(event6, Arrays.asList(state2, state)).addTransition(event6, Arrays.asList(state4, state)).addTransition(Event.CLOSE_FINISHED, Arrays.asList(state6, state));
        Event event7 = Event.VISIBILITY_PARAMS_CHECK;
        return builderAddTransition7.addLoopTransition(event7, state).addLoopTransition(event7, state3).addLoopTransition(event7, state5).build();
    }

    public StateMachine<Event, State> newInstanceForInterstitial() {
        StateMachine.Builder initialState = new StateMachine.Builder().setInitialState(this.initialState);
        Event event = Event.LOAD_COMPLETE;
        State state = State.DEFAULT;
        return initialState.addTransition(event, Arrays.asList(State.LOADING, state)).addTransition(Event.CLOSE, Arrays.asList(state, State.HIDDEN)).addLoopTransition(Event.VISIBILITY_PARAMS_CHECK, state).build();
    }
}
