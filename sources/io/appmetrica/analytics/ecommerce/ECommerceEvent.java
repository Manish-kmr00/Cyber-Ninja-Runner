package io.appmetrica.analytics.ecommerce;

import io.appmetrica.analytics.impl.B3;
import io.appmetrica.analytics.impl.C4117fe;
import io.appmetrica.analytics.impl.Dk;
import io.appmetrica.analytics.impl.Fk;
import io.appmetrica.analytics.impl.Hk;
import io.appmetrica.analytics.impl.InterfaceC4566xf;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public abstract class ECommerceEvent implements InterfaceC4566xf {
    protected ECommerceEvent() {
    }

    public static ECommerceEvent addCartItemEvent(ECommerceCartItem eCommerceCartItem) {
        return new B3(4, eCommerceCartItem);
    }

    public static ECommerceEvent beginCheckoutEvent(ECommerceOrder eCommerceOrder) {
        return new C4117fe(6, eCommerceOrder);
    }

    public static ECommerceEvent purchaseEvent(ECommerceOrder eCommerceOrder) {
        return new C4117fe(7, eCommerceOrder);
    }

    public static ECommerceEvent removeCartItemEvent(ECommerceCartItem eCommerceCartItem) {
        return new B3(5, eCommerceCartItem);
    }

    public static ECommerceEvent showProductCardEvent(ECommerceProduct eCommerceProduct, ECommerceScreen eCommerceScreen) {
        return new Dk(eCommerceProduct, eCommerceScreen);
    }

    public static ECommerceEvent showProductDetailsEvent(ECommerceProduct eCommerceProduct, ECommerceReferrer eCommerceReferrer) {
        return new Fk(eCommerceProduct, eCommerceReferrer);
    }

    public static ECommerceEvent showScreenEvent(ECommerceScreen eCommerceScreen) {
        return new Hk(eCommerceScreen);
    }

    public String getPublicDescription() {
        return "E-commerce base event";
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4566xf
    public abstract /* synthetic */ List toProto();
}
