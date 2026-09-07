package com.mbridge.msdk.out;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes4.dex */
public class MBMuteState {
    public static final int MUTE = 1;
    public static final int UN_MUTE = 2;

    @Retention(RetentionPolicy.SOURCE)
    public @interface MuteState {
    }

    private MBMuteState() {
    }
}
