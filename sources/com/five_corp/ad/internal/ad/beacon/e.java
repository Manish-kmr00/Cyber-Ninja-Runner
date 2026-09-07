package com.five_corp.ad.internal.ad.beacon;

/* JADX INFO: loaded from: classes10.dex */
public enum e {
    IMPRESSION(1),
    /* JADX INFO: Fake field, exist only in values array */
    VT_25(2),
    /* JADX INFO: Fake field, exist only in values array */
    VT_50(3),
    /* JADX INFO: Fake field, exist only in values array */
    VT_75(4),
    VT_100(5),
    ERROR(6),
    LOADED(7),
    PAUSE(8, 0),
    RESUME(9, 0),
    REWIND(10, 0),
    CLOSE(11),
    CLICK_BEACON(12, 0),
    /* JADX INFO: Fake field, exist only in values array */
    MUTE(13),
    /* JADX INFO: Fake field, exist only in values array */
    START(14),
    /* JADX INFO: Fake field, exist only in values array */
    START(15),
    /* JADX INFO: Fake field, exist only in values array */
    START(16),
    /* JADX INFO: Fake field, exist only in values array */
    START(17),
    /* JADX INFO: Fake field, exist only in values array */
    START(18),
    /* JADX INFO: Fake field, exist only in values array */
    START(19),
    /* JADX INFO: Fake field, exist only in values array */
    START(20),
    /* JADX INFO: Fake field, exist only in values array */
    START(21),
    VIEWABLE_IMPRESSION(22);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1270a;
    public final boolean b = false;

    e(int i) {
        this.f1270a = i;
    }

    e(int i, int i2) {
        this.f1270a = i;
    }
}
