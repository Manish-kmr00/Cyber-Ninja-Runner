package com.fyber.inneractive.sdk.player.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes13.dex */
public final class q extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f2239a;

    public q(t tVar) {
        this.f2239a = tVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        t tVar = this.f2239a;
        ViewGroup viewGroup = tVar.r;
        if (viewGroup == null || viewGroup.getParent() == null) {
            return;
        }
        ((View) tVar.r.getParent()).setOnTouchListener(null);
    }
}
