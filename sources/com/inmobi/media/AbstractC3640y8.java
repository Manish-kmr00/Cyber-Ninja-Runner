package com.inmobi.media;

import android.content.Context;
import android.view.View;
import com.inmobi.commons.core.configs.AdConfig;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.y8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractC3640y8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList f3487a = new LinkedList();
    public int b;
    public int c;
    public final /* synthetic */ K8 d;

    public AbstractC3640y8(K8 k8) {
        this.d = k8;
    }

    public abstract View a(Context context);

    public void a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        HashMap map = K8.c;
        C3584u8.a(view);
        view.setOnClickListener(null);
        this.f3487a.add(view);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        this.d.f3115a++;
    }

    public final String toString() {
        return "Size:" + this.f3487a.size() + " Miss Count:" + this.b + " Hit Count:" + this.c;
    }

    public void a(View view, C3455l7 asset, AdConfig adConfig) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        view.setVisibility(asset.v);
        view.setOnClickListener(null);
    }
}
