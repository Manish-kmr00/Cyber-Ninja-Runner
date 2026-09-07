package com.fyber.inneractive.sdk.flow.endcard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.util.AbstractC3256u;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1788a = IAlog.a(this);
    public final b b;

    public a(b bVar) {
        this.b = bVar;
    }

    public static ViewGroup a(View view) {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(view.getContext()).inflate(R.layout.ia_endcard_container, (ViewGroup) null);
        viewGroup.addView(view);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        view.setLayoutParams(layoutParams);
        return viewGroup;
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.k
    public void destroy() {
        a();
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.k
    public void a() {
        AbstractC3256u.a(b());
    }
}
