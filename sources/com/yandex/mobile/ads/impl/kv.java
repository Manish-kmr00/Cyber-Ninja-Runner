package com.yandex.mobile.ads.impl;

import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class kv implements wv0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CheckBox f9451a;
    private final ProgressBar b;
    private final TextView c;

    public kv() {
        this(0);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof kv)) {
            return false;
        }
        kv kvVar = (kv) obj;
        return Intrinsics.areEqual(this.f9451a, kvVar.f9451a) && Intrinsics.areEqual(this.b, kvVar.b) && Intrinsics.areEqual(this.c, kvVar.c);
    }

    public final int hashCode() {
        CheckBox checkBox = this.f9451a;
        int iHashCode = (checkBox == null ? 0 : checkBox.hashCode()) * 31;
        ProgressBar progressBar = this.b;
        int iHashCode2 = (iHashCode + (progressBar == null ? 0 : progressBar.hashCode())) * 31;
        TextView textView = this.c;
        return iHashCode2 + (textView != null ? textView.hashCode() : 0);
    }

    public final String toString() {
        return "CustomControlsContainer(muteControl=" + this.f9451a + ", videoProgress=" + this.b + ", countDownProgress=" + this.c + ")";
    }

    public /* synthetic */ kv(int i) {
        this(null, null, null);
    }

    @Override // com.yandex.mobile.ads.impl.wv0
    public final CheckBox getMuteControl() {
        return this.f9451a;
    }

    @Override // com.yandex.mobile.ads.impl.wv0
    public final ProgressBar getVideoProgress() {
        return this.b;
    }

    public kv(CheckBox checkBox, ProgressBar progressBar, TextView textView) {
        this.f9451a = checkBox;
        this.b = progressBar;
        this.c = textView;
    }

    @Override // com.yandex.mobile.ads.impl.wv0
    public final TextView getCountDownProgress() {
        return this.c;
    }
}
