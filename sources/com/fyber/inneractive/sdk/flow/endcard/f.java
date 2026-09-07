package com.fyber.inneractive.sdk.flow.endcard;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.text.TextUtils;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.util.j0;

/* JADX INFO: loaded from: classes.dex */
public final class f extends a {
    public final ViewGroup c;
    public final ImageView d;
    public final Button e;
    public final TextView f;

    public f(b bVar) {
        super(bVar);
        View viewInflate = LayoutInflater.from(IAConfigManager.O.v.a()).inflate(R.layout.ia_layout_default_video_end_card, (ViewGroup) null);
        this.d = (ImageView) viewInflate.findViewById(R.id.hand_animation);
        this.e = (Button) viewInflate.findViewById(R.id.ia_b_end_card_call_to_action);
        this.f = (TextView) viewInflate.findViewById(R.id.ia_endcard_tv_app_info_button);
        this.c = a.a(viewInflate);
    }

    public final void a(com.fyber.inneractive.sdk.player.ui.b bVar, com.fyber.inneractive.sdk.player.ui.n nVar) {
        com.fyber.inneractive.sdk.ignite.m mVar;
        Context context = this.e.getContext();
        this.e.setAllCaps(bVar.b);
        this.e.setVisibility(0);
        if (IAConfigManager.O.E.n() && (mVar = bVar.m) != null && mVar == com.fyber.inneractive.sdk.ignite.m.TRUE_SINGLE_TAP) {
            this.e.setText(R.string.ia_video_instant_install_text);
            if (bVar.h) {
                String str = bVar.i;
                if (str != null && str.length() == 1) {
                    TextView textView = this.f;
                    int dimensionPixelSize = textView.getContext().getResources().getDimensionPixelSize(R.dimen.ia_image_control_size);
                    textView.setBackgroundResource(R.drawable.ia_bg_circle_overlay);
                    ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
                    layoutParams.width = dimensionPixelSize;
                    layoutParams.height = dimensionPixelSize;
                    textView.setLayoutParams(layoutParams);
                }
                this.f.setText(str);
                this.f.setVisibility(0);
            }
        } else {
            this.f.setVisibility(8);
            Button button = this.e;
            Context context2 = this.c.getContext();
            String str2 = bVar.c;
            button.setText(!TextUtils.isEmpty(str2) ? j0.a(str2, 15) : context2.getString(R.string.ia_video_install_now_text));
        }
        if (bVar.g) {
            this.e.setBackgroundResource(R.drawable.ia_bg_green);
            this.d.setVisibility(0);
            ImageView imageView = this.d;
            float f = bVar.j;
            ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(imageView, PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_X, f), PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_Y, f));
            objectAnimatorOfPropertyValuesHolder.setRepeatCount(-1);
            objectAnimatorOfPropertyValuesHolder.setRepeatMode(2);
            objectAnimatorOfPropertyValuesHolder.setDuration(700L);
            objectAnimatorOfPropertyValuesHolder.start();
        } else {
            this.e.setBackgroundResource(R.drawable.ia_bg_green);
            this.e.setTextSize(0, context.getResources().getDimension(R.dimen.ia_video_overlay_text_large_plus));
        }
        TextView textView2 = this.f;
        if (nVar != null) {
            textView2.setOnTouchListener(new e(10, nVar));
        } else {
            textView2.setOnTouchListener(null);
        }
        Button button2 = this.e;
        if (nVar != null) {
            button2.setOnTouchListener(new e(8, nVar));
        } else {
            button2.setOnTouchListener(null);
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.k
    public final View b() {
        return this.c;
    }
}
