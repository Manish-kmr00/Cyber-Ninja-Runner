package com.fyber.inneractive.sdk.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.global.r;
import com.fyber.inneractive.sdk.network.W;
import com.fyber.inneractive.sdk.util.AbstractC3251o;
import com.fyber.inneractive.sdk.util.IAlog;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;

/* JADX INFO: loaded from: classes13.dex */
public class FyberAdIdentifierLocal extends IFyberAdIdentifier implements View.OnClickListener {
    public ImageView m;
    public TextView n;
    public boolean o;
    public Animator p;
    public float q;
    public Bitmap r;

    public FyberAdIdentifierLocal(r rVar) {
        super(rVar);
        this.o = false;
        this.q = 0.0f;
    }

    @Override // com.fyber.inneractive.sdk.ui.IFyberAdIdentifier
    public final void a(View view) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(view.getContext());
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.ia_identifier_overlay);
        int i = 0;
        ViewGroup viewGroup2 = (ViewGroup) layoutInflaterFrom.inflate(R.layout.ia_layout_fyber_ad_identifier, viewGroup, false);
        this.m = (ImageView) viewGroup2.findViewById(R.id.ia_fyber_identifier_image);
        TextView textView = (TextView) viewGroup2.findViewById(R.id.ia_fyber_identifier_text);
        this.n = textView;
        if (this.j) {
            int i2 = this.b;
            int i3 = this.c;
            if (textView != null && textView.getLayoutParams() != null) {
                textView.getLayoutParams().width = AbstractC3251o.a(i2);
                textView.getLayoutParams().height = AbstractC3251o.a(i3);
            }
            ImageView imageView = this.m;
            int i4 = this.d;
            int i5 = this.e;
            if (imageView != null && imageView.getLayoutParams() != null) {
                imageView.getLayoutParams().width = AbstractC3251o.a(i4);
                imageView.getLayoutParams().height = AbstractC3251o.a(i5);
            }
            TextView textView2 = this.n;
            int i6 = this.f;
            if (textView2 instanceof TextView) {
                textView2.setTextSize(i6);
            }
            a(this.m, this.g);
            this.n.setOnClickListener(this);
            this.n.setText(this.h);
            String str = this.i;
            if (!TextUtils.isEmpty(str)) {
                IAConfigManager.O.s.b(new W(new b(this), viewGroup.getContext(), new com.fyber.inneractive.sdk.cache.b(str)));
            }
        }
        IFyberAdIdentifier.Corner corner = this.k;
        if (corner == IFyberAdIdentifier.Corner.TOP_LEFT || corner == IFyberAdIdentifier.Corner.BOTTOM_LEFT) {
            viewGroup2.removeView(this.n);
            viewGroup2.addView(this.n);
            viewGroup2.setLayoutDirection(0);
        }
        viewGroup2.addOnLayoutChangeListener(new c(this));
        this.m.setOnClickListener(this);
        a();
        viewGroup.addView(viewGroup2);
        IFyberAdIdentifier.Corner corner2 = this.k;
        corner2.getClass();
        int i7 = j.f2342a[corner2.ordinal()];
        if (i7 == 1) {
            i = 51;
        } else if (i7 == 2) {
            i = 53;
        } else if (i7 == 3) {
            i = 83;
        } else if (i7 == 4) {
            i = 85;
        }
        AbstractC3251o.a(viewGroup2, i);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Logger.d("DTExchange|SafeDK: Execution> Lcom/fyber/inneractive/sdk/ui/FyberAdIdentifierLocal;->onClick(Landroid/view/View;)V");
        CreativeInfoManager.onViewClicked(com.safedk.android.utils.h.p, view);
        safedk_FyberAdIdentifierLocal_onClick_89450e1d2505e7faa72ce8c17442a8db(view);
    }

    public void safedk_FyberAdIdentifierLocal_onClick_89450e1d2505e7faa72ce8c17442a8db(View p0) {
        if (p0 != this.m) {
            if (p0 == this.n && this.l == com.fyber.inneractive.sdk.config.global.features.a.OPEN) {
                a();
                IFyberAdIdentifier.ClickListener clickListener = this.f2332a;
                if (clickListener != null) {
                    clickListener.a();
                    return;
                }
                return;
            }
            return;
        }
        if (this.p != null) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        ImageView imageView = this.m;
        Property property = View.ROTATION_X;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, (Property<ImageView, Float>) property, 90.0f);
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this.m, "imageAlpha", 255, 25);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(objectAnimatorOfFloat, objectAnimatorOfInt);
        animatorSet2.addListener(new d(this, animatorSet));
        animatorSet2.setDuration(225L);
        this.p = animatorSet2;
        animatorSet2.start();
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.m, (Property<ImageView, Float>) property, 0.0f);
        ObjectAnimator objectAnimatorOfInt2 = ObjectAnimator.ofInt(this.m, "imageAlpha", 25, 255);
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playTogether(objectAnimatorOfFloat2, objectAnimatorOfInt2);
        animatorSet3.setDuration(225L);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.n, (Property<TextView, Float>) View.TRANSLATION_X, this.o ? this.q : 0.0f);
        objectAnimatorOfFloat3.setDuration(450L);
        animatorSet.setDuration(450L);
        animatorSet.playTogether(objectAnimatorOfFloat3, animatorSet3);
        animatorSet.addListener(new e(this));
    }

    public final void a() {
        this.o = false;
        this.n.setTranslationX(0.0f);
        this.m.setImageResource(R.drawable.ia_fyber_info_button);
        a(this.m, this.g);
        Animator animator = this.p;
        if (animator != null) {
            animator.removeAllListeners();
            this.p = null;
        }
    }

    public static void a(ImageView imageView, String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                com.fyber.inneractive.sdk.widget.a.a(imageView, ColorStateList.valueOf(Color.parseColor(str)));
                return;
            } catch (Exception unused) {
                IAlog.f("could not parse color %s", str);
                return;
            }
        }
        com.fyber.inneractive.sdk.widget.a.a(imageView, null);
    }
}
