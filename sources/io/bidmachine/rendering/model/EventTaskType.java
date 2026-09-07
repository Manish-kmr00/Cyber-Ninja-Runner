package io.bidmachine.rendering.model;

import com.json.m5;
import io.bidmachine.rendering.utils.KeyHolder;
import io.bidmachine.rendering.utils.Utils;
import net.pubnative.lite.sdk.vpaid.enums.EventConstants;

/* JADX INFO: loaded from: classes6.dex */
public enum EventTaskType implements KeyHolder {
    Track("track"),
    Open("open"),
    NotifyOpen("notify_open"),
    Skip(EventConstants.SKIP),
    Close("close"),
    Mute("mute"),
    UnMute("unmute"),
    Show(m5.v),
    Hide("hide"),
    Progress("progress"),
    Schedule("schedule"),
    Start("start"),
    LockVisibility("lock_visibility"),
    UnlockVisibility("unlock_visibility"),
    SimulateClick("simulate_click"),
    OpenPrivacySheet("open_privacy_sheet");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12412a;

    EventTaskType(String key) {
        this.f12412a = key;
    }

    public static EventTaskType fromKey(String key) {
        return (EventTaskType) Utils.fromKey(key, values());
    }

    @Override // io.bidmachine.rendering.utils.KeyHolder
    public String getKey() {
        return this.f12412a;
    }
}
