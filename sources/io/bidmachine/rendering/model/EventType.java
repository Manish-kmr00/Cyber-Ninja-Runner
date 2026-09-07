package io.bidmachine.rendering.model;

import io.bidmachine.rendering.utils.KeyHolder;
import io.bidmachine.rendering.utils.Utils;

/* JADX INFO: loaded from: classes13.dex */
public enum EventType implements KeyHolder {
    OnImpression("on_impression"),
    OnClick("on_click"),
    OnMute("on_mute"),
    OnUnMute("on_unmute"),
    OnPause("on_pause"),
    OnResume("on_resume"),
    OnSkip("on_skip"),
    OnClose("on_close"),
    OnStart("on_start"),
    OnFirstQuartile("on_first_quartile"),
    OnMidpoint("on_midpoint"),
    OnThirdQuartile("on_third_quartile"),
    OnComplete("on_complete"),
    OnProgress("on_progress"),
    OnUseCustomClose("on_use_custom_close"),
    OnScheduled("on_scheduled"),
    OnNavigate("on_navigate");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12413a;

    EventType(String key) {
        this.f12413a = key;
    }

    public static EventType fromKey(String key) {
        return (EventType) Utils.fromKey(key, values());
    }

    @Override // io.bidmachine.rendering.utils.KeyHolder
    public String getKey() {
        return this.f12413a;
    }
}
