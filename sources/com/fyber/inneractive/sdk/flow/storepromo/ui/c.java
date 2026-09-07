package com.fyber.inneractive.sdk.flow.storepromo.ui;

import android.content.Context;
import android.content.IntentFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.config.C3085o;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.util.AbstractC3251o;

/* JADX INFO: loaded from: classes11.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f1831a;
    public ViewGroup b;
    public final Animation c;
    public final Animation d;
    public b e;
    public com.fyber.inneractive.sdk.flow.storepromo.b f;
    public final float g;
    public int h = -1;
    public final a i = new a(this);

    public c(Context context, View view, com.fyber.inneractive.sdk.flow.storepromo.b bVar) {
        float f;
        this.f1831a = view;
        this.c = AnimationUtils.loadAnimation(context, R.anim.store_promo_appear_anim);
        this.d = AnimationUtils.loadAnimation(context, R.anim.store_promo_disappear_anim);
        C3085o c3085o = IAConfigManager.O.u.b;
        c3085o.getClass();
        try {
            f = Float.parseFloat(c3085o.a("dtx_store_promo_height", Float.toString(0.7f)));
        } catch (Throwable unused) {
            f = 0.7f;
        }
        this.g = Math.max(f, 0.7f);
        this.f = bVar;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.dt_store_promo_layout, (ViewGroup) null);
        this.b = viewGroup;
        viewGroup.setOnClickListener(null);
        this.b.setBackgroundColor(context.getResources().getColor(R.color.dtx_store_promo_bg_fade));
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(12);
        this.f1831a.setLayoutParams(layoutParams2);
        this.b.setVisibility(8);
        ViewGroup viewGroup2 = this.b;
        if (viewGroup2 != null) {
            viewGroup2.setLayoutParams(layoutParams);
            this.b.addView(this.f1831a);
        }
        if (this.e == null) {
            b bVar2 = new b(this);
            this.e = bVar2;
            AbstractC3251o.f2370a.registerReceiver(bVar2, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
        }
    }

    public final void a() {
        if (this.b == null || this.f1831a == null) {
            return;
        }
        this.d.setAnimationListener(this.i);
        this.f1831a.setAnimation(this.d);
        this.f1831a.setVisibility(8);
    }

    public final void b() {
        View view;
        int iD = AbstractC3251o.d();
        if (iD == this.h || (view = this.f1831a) == null || view.getLayoutParams() == null) {
            return;
        }
        this.h = iD;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f1831a.getLayoutParams();
        layoutParams.height = iD == 2 ? AbstractC3251o.f() : (int) (AbstractC3251o.e() * this.g);
        this.f1831a.setLayoutParams(layoutParams);
    }
}
