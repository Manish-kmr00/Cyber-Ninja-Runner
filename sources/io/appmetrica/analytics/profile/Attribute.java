package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C4512vb;
import io.appmetrica.analytics.impl.C4598ym;
import io.appmetrica.analytics.impl.D4;
import io.appmetrica.analytics.impl.Lb;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;

/* JADX INFO: loaded from: classes13.dex */
public final class Attribute {
    public static BirthDateAttribute birthDate() {
        return new BirthDateAttribute();
    }

    public static BooleanAttribute customBoolean(String str) {
        return new BooleanAttribute(str, new C4512vb(), new Lb(new D4(100)));
    }

    public static CounterAttribute customCounter(String str) {
        return new CounterAttribute(str, new C4512vb(), new Lb(new D4(100)));
    }

    public static NumberAttribute customNumber(String str) {
        return new NumberAttribute(str, new C4512vb(), new Lb(new D4(100)));
    }

    public static StringAttribute customString(String str) {
        return new StringAttribute(str, new C4598ym(200, "String attribute \"" + str + "\"", PublicLogger.getAnonymousInstance()), new C4512vb(), new Lb(new D4(100)));
    }

    public static GenderAttribute gender() {
        return new GenderAttribute();
    }

    public static NameAttribute name() {
        return new NameAttribute();
    }

    public static NotificationsEnabledAttribute notificationsEnabled() {
        return new NotificationsEnabledAttribute();
    }
}
