package io.appmetrica.analytics;

/* JADX INFO: loaded from: classes9.dex */
public interface DeferredDeeplinkListener {

    public enum Error {
        NOT_A_FIRST_LAUNCH("Deferred deeplink can be requested during first launch only."),
        PARSE_ERROR("Google Play referrer did not contain deferred deeplink."),
        NO_REFERRER("No referrer was found"),
        UNKNOWN("Unknown error");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10914a;

        Error(String str) {
            this.f10914a = str;
        }

        public String getDescription() {
            return this.f10914a;
        }
    }

    void onDeeplinkLoaded(String str);

    void onError(Error error, String str);
}
