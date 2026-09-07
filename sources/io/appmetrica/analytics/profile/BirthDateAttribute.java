package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.A6;
import io.appmetrica.analytics.impl.Bk;
import io.appmetrica.analytics.impl.Bn;
import io.appmetrica.analytics.impl.C3999al;
import io.appmetrica.analytics.impl.C4111f8;
import io.appmetrica.analytics.impl.C4136g8;
import io.appmetrica.analytics.impl.C4419ri;
import io.appmetrica.analytics.impl.C4623zm;
import io.appmetrica.analytics.impl.J4;
import io.appmetrica.analytics.impl.U2;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/* JADX INFO: loaded from: classes13.dex */
public class BirthDateAttribute {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final A6 f11961a = new A6("appmetrica_birth_date", new C4136g8(), new C3999al());

    BirthDateAttribute() {
    }

    final UserProfileUpdate a(Calendar calendar, String str, U2 u2) {
        return new UserProfileUpdate(new C4623zm(this.f11961a.c, new SimpleDateFormat(str).format(calendar.getTime()), new C4111f8(), new C4136g8(), u2));
    }

    public UserProfileUpdate<? extends Bn> withAge(int i) {
        int i2 = Calendar.getInstance(Locale.US).get(1) - i;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i2);
        return a(gregorianCalendar, "yyyy", new J4(this.f11961a.b));
    }

    public UserProfileUpdate<? extends Bn> withAgeIfUndefined(int i) {
        int i2 = Calendar.getInstance(Locale.US).get(1) - i;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i2);
        return a(gregorianCalendar, "yyyy", new Bk(this.f11961a.b));
    }

    public UserProfileUpdate<? extends Bn> withBirthDate(Calendar calendar) {
        return a(calendar, "yyyy-MM-dd", new J4(this.f11961a.b));
    }

    public UserProfileUpdate<? extends Bn> withBirthDateIfUndefined(Calendar calendar) {
        return a(calendar, "yyyy-MM-dd", new Bk(this.f11961a.b));
    }

    public UserProfileUpdate<? extends Bn> withValueReset() {
        return new UserProfileUpdate<>(new C4419ri(0, this.f11961a.c, new C4136g8(), new C3999al()));
    }

    public UserProfileUpdate<? extends Bn> withBirthDate(int i) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        return a(gregorianCalendar, "yyyy", new J4(this.f11961a.b));
    }

    public UserProfileUpdate<? extends Bn> withBirthDateIfUndefined(int i) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        return a(gregorianCalendar, "yyyy", new Bk(this.f11961a.b));
    }

    public UserProfileUpdate<? extends Bn> withBirthDate(int i, int i2) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        gregorianCalendar.set(2, i2 - 1);
        gregorianCalendar.set(5, 1);
        return a(gregorianCalendar, "yyyy-MM", new J4(this.f11961a.b));
    }

    public UserProfileUpdate<? extends Bn> withBirthDateIfUndefined(int i, int i2) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        gregorianCalendar.set(2, i2 - 1);
        gregorianCalendar.set(5, 1);
        return a(gregorianCalendar, "yyyy-MM", new Bk(this.f11961a.b));
    }

    public UserProfileUpdate<? extends Bn> withBirthDate(int i, int i2, int i3) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        gregorianCalendar.set(2, i2 - 1);
        gregorianCalendar.set(5, i3);
        return a(gregorianCalendar, "yyyy-MM-dd", new J4(this.f11961a.b));
    }

    public UserProfileUpdate<? extends Bn> withBirthDateIfUndefined(int i, int i2, int i3) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        gregorianCalendar.set(2, i2 - 1);
        gregorianCalendar.set(5, i3);
        return a(gregorianCalendar, "yyyy-MM-dd", new Bk(this.f11961a.b));
    }
}
