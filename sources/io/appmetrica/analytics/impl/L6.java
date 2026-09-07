package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.control.DataSendingRestrictionController;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import java.util.HashSet;

/* JADX INFO: loaded from: classes5.dex */
public final class L6 implements DataSendingRestrictionController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final J6 f11238a;
    public Boolean b;
    public final HashSet c = new HashSet();
    public final HashSet d = new HashSet();

    public L6(J6 j6) {
        this.f11238a = j6;
        this.b = ((K6) j6).a();
    }

    public final synchronized void a(Boolean bool) {
        if (In.a(bool) || this.b == null) {
            Boolean boolValueOf = Boolean.valueOf(Boolean.FALSE.equals(bool));
            this.b = boolValueOf;
            J6 j6 = this.f11238a;
            ((K6) j6).f11220a.c(boolValueOf.booleanValue()).b();
        }
    }

    @Override // io.appmetrica.analytics.coreapi.internal.control.DataSendingRestrictionController
    public final boolean isRestrictedForBackgroundDataCollection() {
        Boolean bool = this.b;
        if (bool == null) {
            return !this.c.isEmpty() || this.d.isEmpty();
        }
        return bool.booleanValue();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.control.DataSendingRestrictionController
    public final synchronized boolean isRestrictedForReporter() {
        boolean zBooleanValue;
        Boolean bool = this.b;
        if (bool == null) {
            zBooleanValue = this.d.isEmpty() && this.c.isEmpty();
        } else {
            zBooleanValue = bool.booleanValue();
        }
        return zBooleanValue;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.control.DataSendingRestrictionController
    public final synchronized boolean isRestrictedForSdk() {
        Boolean bool;
        bool = this.b;
        return bool == null ? this.d.isEmpty() : bool.booleanValue();
    }

    public final synchronized void a(String str, Boolean bool) {
        if (In.a(bool) || (!this.d.contains(str) && !this.c.contains(str))) {
            if (((Boolean) WrapUtils.getOrDefault(bool, Boolean.TRUE)).booleanValue()) {
                this.d.add(str);
                this.c.remove(str);
            } else {
                this.c.add(str);
                this.d.remove(str);
            }
        }
    }
}
