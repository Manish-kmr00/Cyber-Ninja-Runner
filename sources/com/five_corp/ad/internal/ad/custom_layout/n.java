package com.five_corp.ad.internal.ad.custom_layout;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes8.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1285a;
    public final Integer b;
    public final Integer c;

    public n(int i, Integer num, Integer num2) {
        this.f1285a = i;
        this.b = num;
        this.c = num2;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("TimeRange{timeRangeType=");
        int i = this.f1285a;
        if (i == 1) {
            str = "ALL_TIME";
        } else if (i == 2) {
            str = "AFTER_VIEW_THROUGH";
        } else if (i == 3) {
            str = "BEFORE_VIEW_THROUGH";
        } else if (i != 4) {
            str = i != 5 ? "null" : "START_MS_TO_BEFORE_VIEW_THROUGH";
        } else {
            str = "START_END";
        }
        return sb.append(str).append(", startPlayTimeMs=").append(this.b).append(", endPlayTimeMs=").append(this.c).append(AbstractJsonLexerKt.END_OBJ).toString();
    }
}
