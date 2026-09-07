package com.mbridge.msdk.dycreator.bus;

/* JADX INFO: loaded from: classes13.dex */
final class Subscription {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Object f4860a;
    final SubscriberMethod b;

    Subscription(Object obj, SubscriberMethod subscriberMethod) {
        this.f4860a = obj;
        this.b = subscriberMethod;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Subscription)) {
            return false;
        }
        Subscription subscription = (Subscription) obj;
        return this.f4860a == subscription.f4860a && this.b.equals(subscription.b);
    }

    public int hashCode() {
        return this.f4860a.hashCode() + this.b.d.hashCode();
    }
}
