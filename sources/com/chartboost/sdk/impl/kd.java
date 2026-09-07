package com.chartboost.sdk.impl;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes5.dex */
public class kd {
    public static final Pattern b = Pattern.compile("^[a-zA-Z0-9 ]+$");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<fd> f1064a = new ArrayList();

    public List<fd> a() {
        return this.f1064a;
    }

    public final fd b(View view) {
        for (fd fdVar : this.f1064a) {
            if (fdVar.c().get() == view) {
                return fdVar;
            }
        }
        return null;
    }

    public final void a(View view) {
        if (view == null) {
            throw new IllegalArgumentException("FriendlyObstruction is null");
        }
    }

    public void b() {
        this.f1064a.clear();
    }

    public void a(View view, h5 h5Var, String str) {
        a(view);
        a(str);
        if (b(view) == null) {
            this.f1064a.add(new fd(view, h5Var, str));
        }
    }

    public final void a(String str) {
        if (str != null) {
            if (str.length() > 50) {
                throw new IllegalArgumentException("FriendlyObstruction has detailed reason over 50 characters in length");
            }
            if (!b.matcher(str).matches()) {
                throw new IllegalArgumentException("FriendlyObstruction has detailed reason that contains characters not in [a-z][A-Z][0-9] or space");
            }
        }
    }
}
