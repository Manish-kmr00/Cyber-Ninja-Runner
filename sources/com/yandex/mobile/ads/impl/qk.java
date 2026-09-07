package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes4.dex */
public abstract class qk implements di1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final b52.d f10026a = new b52.d();

    @Override // com.yandex.mobile.ads.impl.di1
    public final boolean hasNextMediaItem() {
        o60 o60Var = (o60) this;
        b52 currentTimeline = o60Var.getCurrentTimeline();
        if (currentTimeline.c()) {
            return false;
        }
        int currentMediaItemIndex = o60Var.getCurrentMediaItemIndex();
        o60Var.d();
        o60Var.e();
        return currentTimeline.a(currentMediaItemIndex, 0, false) != -1;
    }

    @Override // com.yandex.mobile.ads.impl.di1
    public final boolean hasPreviousMediaItem() {
        o60 o60Var = (o60) this;
        b52 currentTimeline = o60Var.getCurrentTimeline();
        if (currentTimeline.c()) {
            return false;
        }
        int currentMediaItemIndex = o60Var.getCurrentMediaItemIndex();
        o60Var.d();
        o60Var.e();
        return currentTimeline.b(currentMediaItemIndex, 0, false) != -1;
    }

    protected qk() {
    }

    public final boolean b() {
        o60 o60Var = (o60) this;
        return o60Var.getPlaybackState() == 3 && o60Var.getPlayWhenReady() && o60Var.getPlaybackSuppressionReason() == 0;
    }

    @Override // com.yandex.mobile.ads.impl.di1
    public final boolean isCurrentMediaItemDynamic() {
        o60 o60Var = (o60) this;
        b52 currentTimeline = o60Var.getCurrentTimeline();
        return !currentTimeline.c() && currentTimeline.a(o60Var.getCurrentMediaItemIndex(), this.f10026a, 0L).j;
    }

    @Override // com.yandex.mobile.ads.impl.di1
    public final boolean isCurrentMediaItemLive() {
        o60 o60Var = (o60) this;
        b52 currentTimeline = o60Var.getCurrentTimeline();
        return !currentTimeline.c() && currentTimeline.a(o60Var.getCurrentMediaItemIndex(), this.f10026a, 0L).a();
    }

    @Override // com.yandex.mobile.ads.impl.di1
    public final boolean isCurrentMediaItemSeekable() {
        o60 o60Var = (o60) this;
        b52 currentTimeline = o60Var.getCurrentTimeline();
        return !currentTimeline.c() && currentTimeline.a(o60Var.getCurrentMediaItemIndex(), this.f10026a, 0L).i;
    }
}
