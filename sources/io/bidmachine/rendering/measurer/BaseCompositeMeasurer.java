package io.bidmachine.rendering.measurer;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import io.bidmachine.rendering.measurer.Measurer;
import io.bidmachine.rendering.model.Error;
import io.bidmachine.rendering.utils.CountDownPostback;
import io.bidmachine.rendering.utils.Utils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes13.dex */
public class BaseCompositeMeasurer<MeasurerType extends Measurer<ViewType>, ViewType extends View> implements Measurer<ViewType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final List f12396a;

    public BaseCompositeMeasurer(List<MeasurerType> measurerList) {
        this.f12396a = new CopyOnWriteArrayList(measurerList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Handler handler, Runnable runnable) {
        this.f12396a.clear();
        handler.post(runnable);
    }

    @Override // io.bidmachine.rendering.measurer.Measurer
    public void destroy(final Runnable postback) {
        final Handler handlerCreateHandlerWithMyOrMainLooper = Utils.createHandlerWithMyOrMainLooper();
        CountDownPostback countDownPostback = postback != null ? new CountDownPostback(this.f12396a.size(), new Runnable() { // from class: io.bidmachine.rendering.measurer.BaseCompositeMeasurer$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(handlerCreateHandlerWithMyOrMainLooper, postback);
            }
        }) : null;
        Iterator it = this.f12396a.iterator();
        while (it.hasNext()) {
            ((Measurer) it.next()).destroy(countDownPostback);
        }
    }

    @Override // io.bidmachine.rendering.measurer.Measurer
    public void onClicked() {
        Iterator it = this.f12396a.iterator();
        while (it.hasNext()) {
            ((Measurer) it.next()).onClicked();
        }
    }

    @Override // io.bidmachine.rendering.measurer.Measurer
    public void onError(Error error) {
        Iterator it = this.f12396a.iterator();
        while (it.hasNext()) {
            ((Measurer) it.next()).onError(error);
        }
    }

    @Override // io.bidmachine.rendering.measurer.Measurer
    public void onShown() {
        Iterator it = this.f12396a.iterator();
        while (it.hasNext()) {
            ((Measurer) it.next()).onShown();
        }
    }

    @Override // io.bidmachine.rendering.measurer.Measurer
    public void onViewAddedToContainer(ViewType viewType, ViewGroup container) {
        Iterator it = this.f12396a.iterator();
        while (it.hasNext()) {
            ((Measurer) it.next()).onViewAddedToContainer(viewType, container);
        }
    }

    @Override // io.bidmachine.rendering.measurer.Measurer
    public void onViewCreated(ViewType viewType) {
        Iterator it = this.f12396a.iterator();
        while (it.hasNext()) {
            ((Measurer) it.next()).onViewCreated(viewType);
        }
    }

    @Override // io.bidmachine.rendering.measurer.Measurer
    public void onViewReady(ViewType viewType) {
        Iterator it = this.f12396a.iterator();
        while (it.hasNext()) {
            ((Measurer) it.next()).onViewReady(viewType);
        }
    }
}
