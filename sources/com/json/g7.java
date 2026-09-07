package com.json;

import com.json.mediationsdk.logger.IronLog;

/* JADX INFO: loaded from: classes10.dex */
class g7 extends q2 {
    g7(o2 o2Var, fm fmVar) {
        super(o2Var, fmVar);
    }

    private boolean n() {
        return b().b() > 0;
    }

    private boolean p() {
        return b().d() >= 0;
    }

    void l() {
        if (o()) {
            IronLog.INTERNAL.verbose();
            i();
        }
    }

    void m() {
        if (o()) {
            IronLog.INTERNAL.verbose();
            i();
        }
    }

    boolean o() {
        return b().a() == o2.a.MANUAL_WITH_LOAD_ON_SHOW;
    }

    void q() {
        if (o() && d()) {
            IronLog.INTERNAL.verbose();
            a(b().c());
        }
    }

    void r() {
        if (!n()) {
            IronLog.INTERNAL.verbose("banner reload interval is disabled");
        } else if (o() && p()) {
            IronLog.INTERNAL.verbose();
            a(b().d());
        }
    }
}
