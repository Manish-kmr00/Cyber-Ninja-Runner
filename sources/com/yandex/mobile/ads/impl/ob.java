package com.yandex.mobile.ads.impl;

import android.app.Dialog;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.yandex.mobile.ads.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class ob {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ac f9800a;
    private final vq0 b;

    private static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Dialog f9801a;
        private final vq0 b;

        public a(Dialog dialog, vq0 keyboardUtils) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            Intrinsics.checkNotNullParameter(keyboardUtils, "keyboardUtils");
            this.f9801a = dialog;
            this.b = keyboardUtils;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.b.getClass();
            vq0.a(view);
            k10.a(this.f9801a);
        }
    }

    private static final class b implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f9802a;
        private final Dialog b;
        private final vq0 c;
        private float d;

        public b(ViewGroup adTuneContainer, Dialog dialog, vq0 keyboardUtils) {
            Intrinsics.checkNotNullParameter(adTuneContainer, "adTuneContainer");
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            Intrinsics.checkNotNullParameter(keyboardUtils, "keyboardUtils");
            this.f9802a = adTuneContainer;
            this.b = dialog;
            this.c = keyboardUtils;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent event) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(event, "event");
            float rawY = event.getRawY();
            int action = event.getAction();
            if (action == 0) {
                this.d = rawY;
                return true;
            }
            if (action == 1) {
                if (rawY <= this.d) {
                    return true;
                }
                this.c.getClass();
                vq0.a(view);
                k10.a(this.b);
                return true;
            }
            if (action != 2) {
                return false;
            }
            float f = this.d;
            if (rawY <= f) {
                this.f9802a.setTranslationY(0.0f);
                return true;
            }
            this.f9802a.setTranslationY(rawY - f);
            return true;
        }
    }

    public final void a(ViewGroup adTuneContainer, Dialog dialog) {
        Intrinsics.checkNotNullParameter(adTuneContainer, "adTuneContainer");
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        this.f9800a.getClass();
        Intrinsics.checkNotNullParameter(adTuneContainer, "adTuneContainer");
        View viewFindViewById = adTuneContainer.findViewById(R.id.adtune_drag_view_container);
        if (viewFindViewById != null) {
            viewFindViewById.setOnTouchListener(new b(adTuneContainer, dialog, this.b));
        }
        this.f9800a.getClass();
        Intrinsics.checkNotNullParameter(adTuneContainer, "adTuneContainer");
        ViewGroup viewGroup = (ViewGroup) adTuneContainer.findViewById(R.id.adtune_background_view);
        if (viewGroup != null) {
            viewGroup.setOnClickListener(new a(dialog, this.b));
        }
    }

    public /* synthetic */ ob() {
        this(new ac(), new vq0());
    }

    public ob(ac adtuneViewProvider, vq0 keyboardUtils) {
        Intrinsics.checkNotNullParameter(adtuneViewProvider, "adtuneViewProvider");
        Intrinsics.checkNotNullParameter(keyboardUtils, "keyboardUtils");
        this.f9800a = adtuneViewProvider;
        this.b = keyboardUtils;
    }
}
