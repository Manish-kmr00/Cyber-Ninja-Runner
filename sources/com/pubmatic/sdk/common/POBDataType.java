package com.pubmatic.sdk.common;

/* JADX INFO: loaded from: classes9.dex */
public interface POBDataType {

    public enum POBAdState {
        DEFAULT,
        LOAD_DEFERRED,
        LOADING,
        READY,
        SHOWING,
        SHOWN,
        AD_SERVER_READY,
        EXPIRED,
        BID_RECEIVED,
        BID_FAILED,
        DESTROYED
    }

    public enum POBVideoAdEventType {
        FIRST_QUARTILE,
        MID_POINT,
        THIRD_QUARTILE,
        COMPLETE,
        SKIPPED,
        MUTE,
        UNMUTE,
        CLICKED,
        PAUSE,
        RESUME,
        ICON_CLICKED
    }
}
