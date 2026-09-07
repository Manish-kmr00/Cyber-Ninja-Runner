package com.yandex.mobile.ads.impl;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.yandex.mobile.ads.R;
import com.yandex.mobile.ads.features.debugpanel.ui.IntegrationInspectorActivity;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ey {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final nw f8841a;
    private final TextView b;
    private final ProgressBar c;

    public ey(IntegrationInspectorActivity activity, final Function1<? super zx, Unit> onAction, ix imageLoader, LinearLayoutManager layoutManager, nw debugPanelAdapter) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(onAction, "onAction");
        Intrinsics.checkNotNullParameter(imageLoader, "imageLoader");
        Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
        Intrinsics.checkNotNullParameter(debugPanelAdapter, "debugPanelAdapter");
        this.f8841a = debugPanelAdapter;
        ImageButton imageButton = (ImageButton) activity.findViewById(R.id.toolbar_navigation_button);
        this.b = (TextView) activity.findViewById(R.id.toolbar_title);
        this.c = (ProgressBar) activity.findViewById(R.id.loading_view);
        RecyclerView recyclerView = (RecyclerView) activity.findViewById(R.id.recycler_view);
        jx jxVar = new jx();
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.yandex.mobile.ads.impl.ey$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ey.a(onAction, view);
            }
        });
        recyclerView.setAdapter(debugPanelAdapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(jxVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Function1 onAction, View view) {
        Intrinsics.checkNotNullParameter(onAction, "$onAction");
        onAction.invoke(zx.d.f10860a);
    }

    public final void a(dy state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state.d()) {
            this.f8841a.submitList(CollectionsKt.emptyList());
            this.c.setVisibility(0);
        } else {
            this.f8841a.submitList(state.c());
            this.c.setVisibility(8);
        }
        this.b.setText(state.a().a());
    }
}
