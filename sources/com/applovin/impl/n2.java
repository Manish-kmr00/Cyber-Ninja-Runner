package com.applovin.impl;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

/* JADX INFO: loaded from: classes2.dex */
public class n2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f557a;
    public TextView b;
    public ImageView c;
    public ImageView d;
    private o2 e;
    private int f;

    public void a(int i) {
        this.f = i;
    }

    public o2 b() {
        return this.e;
    }

    public int a() {
        return this.f;
    }

    public void a(o2 o2Var) {
        this.e = o2Var;
        this.f557a.setText(o2Var.k());
        this.f557a.setTextColor(o2Var.l());
        if (this.b != null) {
            if (!TextUtils.isEmpty(o2Var.f())) {
                this.b.setTypeface(null, 0);
                this.b.setVisibility(0);
                this.b.setText(o2Var.f());
                this.b.setTextColor(o2Var.g());
                if (o2Var.p()) {
                    this.b.setTypeface(null, 1);
                }
            } else {
                this.b.setVisibility(8);
            }
        }
        if (this.c != null) {
            if (o2Var.h() > 0) {
                this.c.setImageResource(o2Var.h());
                this.c.setColorFilter(o2Var.i());
                this.c.setVisibility(0);
            } else {
                this.c.setVisibility(8);
            }
        }
        if (this.d != null) {
            if (o2Var.d() > 0) {
                this.d.setImageResource(o2Var.d());
                this.d.setColorFilter(o2Var.e());
                this.d.setVisibility(0);
                return;
            }
            this.d.setVisibility(8);
        }
    }
}
