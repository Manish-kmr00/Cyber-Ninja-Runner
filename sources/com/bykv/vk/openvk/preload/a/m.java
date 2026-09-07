package com.bykv.vk.openvk.preload.a;

import java.math.BigInteger;

/* JADX INFO: compiled from: JsonPrimitive.java */
/* JADX INFO: loaded from: classes12.dex */
public final class m extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f893a;

    public m(Boolean bool) {
        this.f893a = com.bykv.vk.openvk.preload.falconx.a.a.a(bool);
    }

    public m(Number number) {
        this.f893a = com.bykv.vk.openvk.preload.falconx.a.a.a(number);
    }

    public m(String str) {
        this.f893a = com.bykv.vk.openvk.preload.falconx.a.a.a(str);
    }

    public final boolean g() {
        return this.f893a instanceof Boolean;
    }

    public final boolean h() {
        return this.f893a instanceof Number;
    }

    @Override // com.bykv.vk.openvk.preload.a.h
    public final Number a() {
        Object obj = this.f893a;
        return obj instanceof String ? new com.bykv.vk.openvk.preload.a.b.f((String) this.f893a) : (Number) obj;
    }

    public final boolean i() {
        return this.f893a instanceof String;
    }

    public final int hashCode() {
        long jDoubleToLongBits;
        if (this.f893a == null) {
            return 31;
        }
        if (a(this)) {
            jDoubleToLongBits = a().longValue();
        } else {
            Object obj = this.f893a;
            if (obj instanceof Number) {
                jDoubleToLongBits = Double.doubleToLongBits(a().doubleValue());
            } else {
                return obj.hashCode();
            }
        }
        return (int) ((jDoubleToLongBits >>> 32) ^ jDoubleToLongBits);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        if (this.f893a == null) {
            return mVar.f893a == null;
        }
        if (a(this) && a(mVar)) {
            return a().longValue() == mVar.a().longValue();
        }
        Object obj2 = this.f893a;
        if ((obj2 instanceof Number) && (mVar.f893a instanceof Number)) {
            double dDoubleValue = a().doubleValue();
            double dDoubleValue2 = mVar.a().doubleValue();
            return dDoubleValue == dDoubleValue2 || (Double.isNaN(dDoubleValue) && Double.isNaN(dDoubleValue2));
        }
        return obj2.equals(mVar.f893a);
    }

    private static boolean a(m mVar) {
        Object obj = mVar.f893a;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    @Override // com.bykv.vk.openvk.preload.a.h
    public final boolean f() {
        Object obj = this.f893a;
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return Boolean.parseBoolean(b());
    }

    @Override // com.bykv.vk.openvk.preload.a.h
    public final String b() {
        Object obj = this.f893a;
        if (obj instanceof Number) {
            return a().toString();
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).toString();
        }
        return (String) obj;
    }

    @Override // com.bykv.vk.openvk.preload.a.h
    public final double c() {
        return this.f893a instanceof Number ? a().doubleValue() : Double.parseDouble(b());
    }

    @Override // com.bykv.vk.openvk.preload.a.h
    public final long d() {
        return this.f893a instanceof Number ? a().longValue() : Long.parseLong(b());
    }

    @Override // com.bykv.vk.openvk.preload.a.h
    public final int e() {
        return this.f893a instanceof Number ? a().intValue() : Integer.parseInt(b());
    }
}
