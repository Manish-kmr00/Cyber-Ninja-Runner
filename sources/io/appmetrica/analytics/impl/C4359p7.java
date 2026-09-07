package io.appmetrica.analytics.impl;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
import kotlin.jvm.internal.Ref;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.p7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4359p7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11715a;
    public final int b;
    public final X8 c;
    public final E8 d;
    public final C4028c0 e;
    public final N8 f;
    public final C4433s7 g;
    public final C3984a6 h;

    public C4359p7(Context context, C4571xk c4571xk, int i, X8 x8, E8 e8, C4028c0 c4028c0, N8 n8, C4433s7 c4433s7) {
        this.f11715a = context;
        this.b = i;
        this.c = x8;
        this.d = e8;
        this.e = c4028c0;
        this.f = n8;
        this.g = c4433s7;
        this.h = e8.f11119a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String b() {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Lm lmA = C4486ua.E.A();
        C4334o7 c4334o7 = new C4334o7(objectRef);
        synchronized (lmA) {
            lmA.b.a(c4334o7);
        }
        return (String) objectRef.element;
    }

    public final C4259l7 a() throws JSONException {
        JSONObject jSONObjectOptJSONObject;
        eo eoVar;
        Integer numValueOf = Integer.valueOf(this.h.e);
        String name = this.h.getName();
        String value = this.h.getValue();
        X8 x8 = this.c;
        int i = this.b;
        Un un = x8.f11415a.f11432a;
        synchronized (un) {
            jSONObjectOptJSONObject = un.f11384a.a().optJSONObject("numbers_of_type");
        }
        long jOptLong = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optLong(String.valueOf(i)) : 0L;
        x8.f11415a.a(i, 1 + jOptLong);
        Long lValueOf = Long.valueOf(jOptLong);
        C4433s7 c4433s7 = this.g;
        c4433s7.getClass();
        Pb pbL = C4486ua.E.l();
        Location userLocation = pbL.getUserLocation();
        if (userLocation != null) {
            int i2 = eo.b;
            Location location = new Location(userLocation);
            String provider = location.getProvider();
            location.setProvider("");
            eoVar = new eo(location, provider);
        } else {
            Location systemLocation = pbL.getSystemLocation();
            eoVar = systemLocation != null ? new eo(new Location(systemLocation), "") : null;
        }
        boolean z = c4433s7.f11760a.d;
        Double dValueOf = eoVar != null ? Double.valueOf(eoVar.getLatitude()) : null;
        Double dValueOf2 = eoVar != null ? Double.valueOf(eoVar.getLongitude()) : null;
        Long lValueOf2 = eoVar != null ? Long.valueOf(eoVar.getTime()) : null;
        Integer numValueOf2 = eoVar != null ? Integer.valueOf((int) eoVar.getAccuracy()) : null;
        Integer numValueOf3 = eoVar != null ? Integer.valueOf((int) eoVar.getBearing()) : null;
        Integer numValueOf4 = eoVar != null ? Integer.valueOf((int) eoVar.getSpeed()) : null;
        C4384q7 c4384q7 = new C4384q7(Boolean.valueOf(z), dValueOf2, dValueOf, eoVar != null ? Integer.valueOf((int) eoVar.getAltitude()) : null, numValueOf3, numValueOf2, numValueOf4, lValueOf2, eoVar != null ? eoVar.getProvider() : null, eoVar != null ? eoVar.f11538a : null);
        String str = this.h.c;
        C4028c0 c4028c0 = this.e;
        String str2 = c4028c0.f11486a;
        Long lValueOf3 = Long.valueOf(c4028c0.b);
        Integer numValueOf5 = Integer.valueOf(this.h.g);
        Context context = this.f11715a;
        SafePackageManager safePackageManager = AbstractC4515ve.f11816a;
        Integer numValueOf6 = Integer.valueOf(((Integer) AbstractC4515ve.d.a((EnumC4490ue) SystemServiceUtils.accessSystemServiceSafelyOrDefault((ConnectivityManager) context.getSystemService("connectivity"), "getting connection type", "ConnectivityManager", EnumC4490ue.UNDEFINED, new C4465te()))).intValue());
        String strB = b();
        M8 m8 = this.d.b;
        C3984a6 c3984a6 = this.h;
        return new C4259l7(numValueOf, name, value, lValueOf, c4384q7, str, str2, lValueOf3, numValueOf5, numValueOf6, strB, m8, c3984a6.h, c3984a6.k, c3984a6.l, c3984a6.n, c3984a6.o, this.f.fromModel(c3984a6.p));
    }

    public /* synthetic */ C4359p7(Context context, C4571xk c4571xk, int i, X8 x8, E8 e8, C4045ch c4045ch, C4028c0 c4028c0) {
        this(context, c4571xk, i, x8, e8, c4028c0, new N8(), new C4433s7(c4045ch));
    }
}
