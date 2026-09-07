package com.fyber.inneractive.sdk.flow.endcard;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.util.AbstractC3256u;

/* JADX INFO: loaded from: classes2.dex */
public final class w extends a {
    public Bitmap c;
    public final ImageView d;
    public final ViewGroup e;

    public w(v vVar) {
        super(vVar);
        ImageView imageView = new ImageView(IAConfigManager.O.v.a());
        imageView.setId(R.id.ia_inneractive_vast_endcard_static);
        this.d = imageView;
        this.e = a.a(imageView);
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.k
    public final View b() {
        return this.e;
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.a, com.fyber.inneractive.sdk.flow.endcard.k
    public final void destroy() {
        AbstractC3256u.a(b());
        Bitmap bitmap = this.c;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.c = null;
        this.d.setImageBitmap(null);
    }
}
