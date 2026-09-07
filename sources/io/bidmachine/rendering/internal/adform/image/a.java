package io.bidmachine.rendering.internal.adform.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import io.bidmachine.rendering.internal.i;
import io.bidmachine.rendering.internal.repository.c;
import io.bidmachine.rendering.model.AdElementParams;
import io.bidmachine.rendering.model.Error;
import io.bidmachine.rendering.model.MediaSource;

/* JADX INFO: loaded from: classes9.dex */
public class a extends io.bidmachine.rendering.internal.adform.a {
    final ImageView i;

    private class b implements c {
        private b() {
        }

        @Override // io.bidmachine.rendering.internal.repository.c
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Bitmap bitmap) {
            a.this.i.setImageBitmap(bitmap);
        }

        @Override // io.bidmachine.rendering.internal.repository.c
        public void onError(Error error) {
        }
    }

    public a(Context context, io.bidmachine.rendering.internal.repository.a aVar, AdElementParams adElementParams, io.bidmachine.rendering.internal.adform.c cVar, io.bidmachine.rendering.internal.event.a aVar2) {
        super(context, aVar, adElementParams, cVar, aVar2);
        ImageView imageView = new ImageView(context);
        this.i = imageView;
        Bitmap bitmapB = i.b(adElementParams.getPlaceholder());
        if (bitmapB != null) {
            imageView.setImageBitmap(bitmapB);
        }
    }

    @Override // io.bidmachine.rendering.internal.a
    public void c() {
        r().b(this);
        String source = i().getSource();
        if (TextUtils.isEmpty(source)) {
            return;
        }
        t().b(s(), new MediaSource(source, MediaSource.DeliveryType.PRELOAD), new b());
    }

    @Override // io.bidmachine.rendering.internal.a
    public View k() {
        return this.i;
    }
}
