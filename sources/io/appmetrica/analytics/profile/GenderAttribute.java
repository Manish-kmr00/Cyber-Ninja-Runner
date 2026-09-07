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

/* JADX INFO: loaded from: classes.dex */
public class GenderAttribute {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final A6 f11964a = new A6("appmetrica_gender", new C4136g8(), new C3999al());

    public enum Gender {
        MALE("M"),
        FEMALE("F"),
        OTHER("O");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f11965a;

        Gender(String str) {
            this.f11965a = str;
        }

        public String getStringValue() {
            return this.f11965a;
        }
    }

    GenderAttribute() {
    }

    public UserProfileUpdate<? extends Bn> withValue(Gender gender) {
        String str = this.f11964a.c;
        String stringValue = gender.getStringValue();
        C4111f8 c4111f8 = new C4111f8();
        A6 a6 = this.f11964a;
        return new UserProfileUpdate<>(new C4623zm(str, stringValue, c4111f8, a6.f11054a, new J4(a6.b)));
    }

    public UserProfileUpdate<? extends Bn> withValueIfUndefined(Gender gender) {
        String str = this.f11964a.c;
        String stringValue = gender.getStringValue();
        C4111f8 c4111f8 = new C4111f8();
        A6 a6 = this.f11964a;
        return new UserProfileUpdate<>(new C4623zm(str, stringValue, c4111f8, a6.f11054a, new Bk(a6.b)));
    }

    public UserProfileUpdate<? extends Bn> withValueReset() {
        A6 a6 = this.f11964a;
        return new UserProfileUpdate<>(new C4419ri(0, a6.c, a6.f11054a, a6.b));
    }
}
