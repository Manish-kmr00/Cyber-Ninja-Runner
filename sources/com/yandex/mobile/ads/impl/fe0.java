package com.yandex.mobile.ads.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public final class fe0 {
    private static final Pattern c = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8887a = -1;
    public int b = -1;

    public final void a(g01 g01Var) {
        for (int i = 0; i < g01Var.c(); i++) {
            g01.b bVarA = g01Var.a(i);
            if (bVarA instanceof rq) {
                rq rqVar = (rq) bVarA;
                if ("iTunSMPB".equals(rqVar.d) && a(rqVar.e)) {
                    return;
                }
            } else if (bVarA instanceof mp0) {
                mp0 mp0Var = (mp0) bVarA;
                if ("com.apple.iTunes".equals(mp0Var.c) && "iTunSMPB".equals(mp0Var.d) && a(mp0Var.e)) {
                    return;
                }
            } else {
                continue;
            }
        }
    }

    private boolean a(String str) {
        Matcher matcher = c.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            String strGroup = matcher.group(1);
            int i = x82.f10629a;
            int i2 = Integer.parseInt(strGroup, 16);
            int i3 = Integer.parseInt(matcher.group(2), 16);
            if (i2 <= 0 && i3 <= 0) {
                return false;
            }
            this.f8887a = i2;
            this.b = i3;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }
}
