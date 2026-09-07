package com.smaato.sdk.video.vast.vastplayer;

import com.smaato.sdk.core.SmaatoSdk;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.StateMachine;
import com.smaato.sdk.video.vast.model.VastCompanionScenario;
import com.smaato.sdk.video.vast.model.VastScenario;
import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public class VastVideoPlayerStateMachineFactory {
    private final VastPlayerState initialState;

    VastVideoPlayerStateMachineFactory(VastPlayerState vastPlayerState) {
        this.initialState = (VastPlayerState) Objects.requireNonNull(vastPlayerState);
    }

    public StateMachine<VastPlayerEvent, VastPlayerState> create(VastScenario vastScenario) {
        VastPlayerState vastPlayerState;
        VastPlayerState vastPlayerState2;
        VastCompanionScenario vastCompanionScenario = vastScenario.vastCompanionScenario;
        StateMachine.Builder builder = new StateMachine.Builder();
        boolean z = vastCompanionScenario == null || vastCompanionScenario.resourceData.isCompanionInvalid();
        if (z || SmaatoSdk.isCompanionAdSkippable()) {
            vastPlayerState = VastPlayerState.CLOSE_PLAYER;
        } else {
            vastPlayerState = VastPlayerState.SHOW_COMPANION;
        }
        if (z || SmaatoSdk.isCompanionAdSkippable()) {
            vastPlayerState2 = VastPlayerState.IDLE_PLAYER;
        } else {
            vastPlayerState2 = VastPlayerState.SHOW_COMPANION;
        }
        StateMachine.Builder initialState = builder.setInitialState(this.initialState);
        VastPlayerEvent vastPlayerEvent = VastPlayerEvent.ERROR;
        VastPlayerState vastPlayerState3 = VastPlayerState.SHOW_VIDEO;
        VastPlayerState vastPlayerState4 = VastPlayerState.CLOSE_PLAYER;
        StateMachine.Builder builderAddTransition = initialState.addTransition(vastPlayerEvent, Arrays.asList(vastPlayerState3, vastPlayerState4));
        VastPlayerState vastPlayerState5 = VastPlayerState.SHOW_COMPANION;
        StateMachine.Builder builderAddTransition2 = builderAddTransition.addTransition(vastPlayerEvent, Arrays.asList(vastPlayerState5, vastPlayerState4));
        VastPlayerState vastPlayerState6 = VastPlayerState.PAUSE_PLAYER;
        StateMachine.Builder builderAddTransition3 = builderAddTransition2.addTransition(vastPlayerEvent, Arrays.asList(vastPlayerState6, vastPlayerState));
        VastPlayerState vastPlayerState7 = VastPlayerState.VIDEO_COMPLETED_BEFORE_PAUSE;
        StateMachine.Builder builderAddTransition4 = builderAddTransition3.addTransition(vastPlayerEvent, Arrays.asList(vastPlayerState7, vastPlayerState));
        VastPlayerEvent vastPlayerEvent2 = VastPlayerEvent.CLICKED;
        StateMachine.Builder builderAddTransition5 = builderAddTransition4.addTransition(vastPlayerEvent2, Arrays.asList(vastPlayerState3, vastPlayerState6));
        VastPlayerEvent vastPlayerEvent3 = VastPlayerEvent.RESUME;
        StateMachine.Builder builderAddTransition6 = builderAddTransition5.addTransition(vastPlayerEvent3, Arrays.asList(vastPlayerState6, vastPlayerState3)).addTransition(vastPlayerEvent3, Arrays.asList(vastPlayerState7, vastPlayerState2));
        VastPlayerState vastPlayerState8 = VastPlayerState.SHOW_COMPANION_AFTER_CLICK;
        StateMachine.Builder builderAddTransition7 = builderAddTransition6.addTransition(vastPlayerEvent2, Arrays.asList(vastPlayerState5, vastPlayerState8));
        VastPlayerEvent vastPlayerEvent4 = VastPlayerEvent.VIDEO_COMPLETED;
        StateMachine.Builder builderAddTransition8 = builderAddTransition7.addTransition(vastPlayerEvent4, Arrays.asList(vastPlayerState3, vastPlayerState2)).addTransition(vastPlayerEvent4, Arrays.asList(vastPlayerState6, vastPlayerState2)).addTransition(VastPlayerEvent.VIDEO_SKIPPED, Arrays.asList(vastPlayerState3, vastPlayerState));
        VastPlayerEvent vastPlayerEvent5 = VastPlayerEvent.CLOSE_BUTTON_CLICKED;
        builderAddTransition8.addTransition(vastPlayerEvent5, Arrays.asList(vastPlayerState3, vastPlayerState4)).addTransition(vastPlayerEvent5, Arrays.asList(vastPlayerState6, vastPlayerState4)).addTransition(vastPlayerEvent5, Arrays.asList(VastPlayerState.IDLE_PLAYER, vastPlayerState4)).addTransition(vastPlayerEvent5, Arrays.asList(vastPlayerState5, vastPlayerState4)).addTransition(vastPlayerEvent5, Arrays.asList(vastPlayerState8, vastPlayerState4));
        return builder.build();
    }
}
