package com.fyber.inneractive.sdk.ui;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.activities.InneractiveFullscreenAdActivity;
import com.fyber.inneractive.sdk.util.AbstractC3251o;

/* JADX INFO: loaded from: classes7.dex */
public class CloseButtonFlowManager implements com.fyber.inneractive.sdk.flow.storepromo.observer.a, CloseButtonConfigurationChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f2329a;
    public final TextView b;
    public final View c;
    public final ImageView d;
    public final FrameLayout e;
    public boolean f = false;
    public final CloseButtonConfiguration g = new CloseButtonConfiguration(this);

    public CloseButtonFlowManager(InneractiveFullscreenAdActivity inneractiveFullscreenAdActivity) {
        View viewFindViewById = inneractiveFullscreenAdActivity.findViewById(R.id.ia_fl_close_button);
        this.f2329a = viewFindViewById;
        this.b = (TextView) inneractiveFullscreenAdActivity.findViewById(R.id.ia_tv_close_button);
        View viewFindViewById2 = inneractiveFullscreenAdActivity.findViewById(R.id.ia_clickable_close_button);
        this.c = viewFindViewById2;
        this.d = (ImageView) inneractiveFullscreenAdActivity.findViewById(R.id.ia_iv_close_button);
        this.e = (FrameLayout) inneractiveFullscreenAdActivity.findViewById(R.id.close_button_container);
        viewFindViewById.setVisibility(8);
        viewFindViewById2.setOnClickListener(new a(inneractiveFullscreenAdActivity));
    }

    @Override // com.fyber.inneractive.sdk.ui.CloseButtonConfigurationChangeListener
    public final void a(CloseButtonConfiguration closeButtonConfiguration) {
        int i;
        int i2;
        if (closeButtonConfiguration.f) {
            this.f2329a.setVisibility(8);
            this.b.setVisibility(8);
            this.d.setVisibility(8);
            this.c.setVisibility(8);
            return;
        }
        CloseButtonConfiguration closeButtonConfiguration2 = this.g;
        if (closeButtonConfiguration2.b) {
            if (!closeButtonConfiguration2.c || this.f) {
                this.f2329a.setAlpha(1.0f);
                this.d.setAlpha(1.0f);
            } else {
                this.f2329a.setAlpha(0.0f);
                this.d.setAlpha(0.0f);
            }
            this.b.setText("");
            this.b.setVisibility(8);
            int i3 = closeButtonConfiguration2.d;
            if (i3 >= 5) {
                int iRound = Math.round((AbstractC3251o.b() * i3) + 0.5f);
                this.d.getLayoutParams().width = iRound;
                this.d.getLayoutParams().height = iRound;
            }
            int i4 = closeButtonConfiguration2.e;
            if (i4 >= 5) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.d.getLayoutParams();
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f2329a.getLayoutParams();
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.c.getLayoutParams();
                int iRound2 = Math.round((AbstractC3251o.b() * i4) + 0.5f);
                int i5 = layoutParams.width;
                int i6 = iRound2 - i5;
                if (iRound2 <= i5 || i6 <= (i2 = layoutParams2.rightMargin)) {
                    layoutParams3.width = iRound2;
                    layoutParams3.height = iRound2;
                    i = layoutParams2.rightMargin;
                    if (i6 < i) {
                        i -= i6 / 2;
                    }
                } else {
                    int i7 = (i5 / 2) + (iRound2 / 2) + i2;
                    layoutParams3.width = i7;
                    layoutParams3.height = i7;
                    layoutParams2.gravity = 53;
                    i = 0;
                }
                layoutParams3.setMargins(i, i, i, i);
                layoutParams3.gravity = 17;
            }
        }
        this.f2329a.setVisibility((closeButtonConfiguration.f2328a || closeButtonConfiguration.b) ? 0 : 8);
        this.b.setVisibility(closeButtonConfiguration.f2328a ? 0 : 8);
        int i8 = closeButtonConfiguration.b ? 0 : 8;
        this.d.setVisibility(i8);
        this.c.setVisibility(i8);
        this.c.setEnabled(closeButtonConfiguration.b);
    }

    @Override // com.fyber.inneractive.sdk.flow.storepromo.observer.a
    public final void a(com.fyber.inneractive.sdk.flow.storepromo.observer.b bVar) {
        CloseButtonConfiguration closeButtonConfiguration = this.g;
        closeButtonConfiguration.f = bVar.f1828a;
        closeButtonConfiguration.g.a(closeButtonConfiguration);
    }
}
