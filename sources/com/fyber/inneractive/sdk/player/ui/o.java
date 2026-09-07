package com.fyber.inneractive.sdk.player.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.global.features.w;
import com.fyber.inneractive.sdk.flow.C3102g;
import com.fyber.inneractive.sdk.ui.IAsmoothProgressBar;
import com.fyber.inneractive.sdk.ui.IFyberAdIdentifier;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes13.dex */
public final class o extends l {
    public final ViewGroup L;
    public final TextView M;
    public final TextView N;
    public final ImageView O;
    public final ImageView P;
    public final IAsmoothProgressBar Q;
    public final View R;
    public final View S;
    public final View T;
    public final TextView U;
    public final TextView V;

    public o(Context context, C3102g c3102g, a aVar, com.fyber.inneractive.sdk.config.global.r rVar, boolean z, String str) {
        super(context, c3102g, aVar, rVar, str);
        this.R = null;
        this.B.inflate(R.layout.ia_layout_video_view, (ViewGroup) this, true);
        this.l = (ViewGroup) findViewById(R.id.ia_texture_view_host);
        this.q = (ViewGroup) findViewById(R.id.ia_default_endcard_video_overlay);
        this.r = (ViewGroup) findViewById(R.id.ia_endcard_video_overlay);
        this.m = (Button) findViewById(R.id.ia_b_end_card_call_to_action);
        this.u = (TextView) findViewById(R.id.ia_endcard_tv_app_info_button);
        a(this.u, 10);
        a(this.m, 8);
        a(this.l, 7);
        a(this.q, -1);
        ImageView imageView = (ImageView) findViewById(R.id.ia_iv_expand_collapse_button);
        this.P = imageView;
        View viewFindViewById = findViewById(R.id.ia_paused_video_overlay);
        this.T = viewFindViewById;
        TextView textView = (TextView) findViewById(R.id.ia_tv_app_info_button);
        this.M = textView;
        TextView textView2 = (TextView) findViewById(R.id.ia_tv_call_to_action);
        this.N = textView2;
        IAsmoothProgressBar iAsmoothProgressBar = (IAsmoothProgressBar) findViewById(R.id.ia_video_progressbar);
        this.Q = iAsmoothProgressBar;
        this.L = (ViewGroup) findViewById(R.id.ia_identifier_overlay);
        this.R = findViewById(R.id.ia_click_overlay);
        iAsmoothProgressBar.setVisibility(0);
        ImageView imageView2 = (ImageView) findViewById(R.id.ia_iv_mute_button);
        this.O = imageView2;
        imageView2.setVisibility(0);
        this.S = findViewById(R.id.ia_buffering_overlay);
        this.U = (TextView) findViewById(R.id.ia_tv_remaining_time);
        TextView textView3 = (TextView) findViewById(R.id.ia_tv_skip);
        this.V = textView3;
        a(this, 7);
        a(textView2, 3);
        a(imageView2, 1);
        a(textView, 10);
        a(imageView, 5);
        a(viewFindViewById, 9);
        a(textView3, 6);
        C3102g c3102g2 = this.C;
        if (c3102g2 != null) {
            IFyberAdIdentifier.Corner corner = IFyberAdIdentifier.Corner.BOTTOM_LEFT;
            IFyberAdIdentifier iFyberAdIdentifier = c3102g2.d;
            iFyberAdIdentifier.k = corner;
            iFyberAdIdentifier.a(this);
        }
        String string = getContext().getString(R.string.ia_video_app_info_text);
        com.fyber.inneractive.sdk.config.global.r rVar2 = this.v;
        if (rVar2 != null) {
            Boolean boolC = ((w) rVar2.a(w.class)).c("show_ad_identifier_original_design");
            this.J = boolC != null ? boolC.booleanValue() : true;
            string = ((com.fyber.inneractive.sdk.config.global.features.o) this.v.a(com.fyber.inneractive.sdk.config.global.features.o.class)).a("app_info_button_text", "App Info");
            if (string != null && string.length() > 30) {
                string = string.substring(0, 30);
            }
        }
        if (z && this.J) {
            b(false);
            a(true, string);
            c(true);
        } else if (z) {
            b(false);
            a(true, string);
            c(false);
        } else if (!this.J) {
            b(true);
            c(false);
        } else {
            a(false, (String) null);
            b(false);
            c(true);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.l, com.fyber.inneractive.sdk.player.ui.t
    public final void a(int i, int i2) {
        IAsmoothProgressBar iAsmoothProgressBar = this.Q;
        if (iAsmoothProgressBar == null) {
            return;
        }
        iAsmoothProgressBar.setMax(i);
        super.a(i, i2);
    }

    @Override // com.fyber.inneractive.sdk.player.ui.e
    public final void b() {
        this.h = true;
        j();
    }

    @Override // com.fyber.inneractive.sdk.player.ui.e
    public final void c() {
        this.h = false;
        k();
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void d(boolean z) {
        ImageView imageView = this.O;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t, com.fyber.inneractive.sdk.player.ui.m
    public final void destroy() {
        super.destroy();
        k kVar = this.F;
        if (kVar != null) {
            removeCallbacks(kVar);
            this.F = null;
        }
        p();
        ViewGroup viewGroup = this.l;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.l, com.fyber.inneractive.sdk.player.ui.t, com.fyber.inneractive.sdk.player.ui.e, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.p, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void e(boolean z) {
        View view = this.T;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void f() {
        TextView textView = this.V;
        if (textView != null) {
            textView.setEnabled(true);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void g() {
        g(false);
        d(false);
        f(false);
        this.N.setVisibility(4);
        ImageView imageView = this.P;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
        c(false);
        a(false, (String) null);
        b(false);
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public View[] getTrackingFriendlyView() {
        return new View[]{this.N, this.U, this.V, this.O, this.Q, this.R, this.u};
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public View[] getTrackingFriendlyViewObstructionPurposeOther() {
        return new View[]{this.M, this.L};
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final boolean i() {
        TextView textView = this.V;
        return textView != null && textView.getVisibility() == 0 && this.V.isEnabled();
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final boolean l() {
        return this.U == null && this.Q == null;
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void m() {
        ImageView imageView = this.P;
        if (imageView != null) {
            imageView.setVisibility(0);
            this.P.setSelected(true);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void n() {
        ImageView imageView = this.P;
        if (imageView != null) {
            imageView.setVisibility(0);
            this.P.setSelected(false);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public void setAppInfoButtonRound(TextView textView) {
        if (textView == null) {
            return;
        }
        textView.setBackgroundResource(R.drawable.ia_bg_circle_overlay);
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams.width = (int) getContext().getResources().getDimension(R.dimen.ia_image_control_size);
        layoutParams.height = (int) getContext().getResources().getDimension(R.dimen.ia_image_control_size);
        textView.setLayoutParams(layoutParams);
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public void setMuteButtonState(boolean z) {
        ImageView imageView = this.O;
        if (imageView != null) {
            imageView.setSelected(z);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public void setRemainingTime(String str) {
        TextView textView = this.U;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public void setSkipText(String str) {
        if (this.V != null) {
            try {
                Integer.parseInt(str);
                int i = R.string.ia_video_before_skip_format;
                str = String.format(Locale.US, IAConfigManager.O.v.a().getString(i), Integer.valueOf(Integer.parseInt(str)));
            } catch (Exception unused) {
            }
            this.V.setText(str);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void b(boolean z) {
        TextView textView = this.U;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void c(boolean z) {
        ViewGroup viewGroup = this.L;
        if (viewGroup != null) {
            viewGroup.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void f(boolean z) {
        IAsmoothProgressBar iAsmoothProgressBar = this.Q;
        if (iAsmoothProgressBar != null) {
            iAsmoothProgressBar.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.l
    public final void a(int i) {
        IAsmoothProgressBar iAsmoothProgressBar = this.Q;
        if (iAsmoothProgressBar != null) {
            iAsmoothProgressBar.setProgress(i);
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x004a  */
    /* JADX WARN: Code duplicated, block: B:19:0x0054  */
    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void a(boolean z, com.fyber.inneractive.sdk.ignite.m mVar) {
        String localizedCtaButtonText;
        Boolean boolC;
        TextView textView = this.N;
        if (textView != null) {
            com.fyber.inneractive.sdk.config.global.r rVar = this.v;
            textView.setAllCaps((rVar == null || rVar.a(w.class) == null || (boolC = ((w) this.v.a(w.class)).c("cta_text_all_caps")) == null) ? false : boolC.booleanValue());
            TextView textView2 = this.N;
            if (IAConfigManager.O.E.n()) {
                mVar.getClass();
                if (mVar == com.fyber.inneractive.sdk.ignite.m.TRUE_SINGLE_TAP) {
                    localizedCtaButtonText = getContext().getString(R.string.ia_video_instant_install_text);
                } else {
                    localizedCtaButtonText = getLocalizedCtaButtonText();
                    if (TextUtils.isEmpty(localizedCtaButtonText)) {
                        localizedCtaButtonText = getContext().getString(R.string.ia_video_install_now_text);
                    }
                }
            } else {
                localizedCtaButtonText = getLocalizedCtaButtonText();
                if (TextUtils.isEmpty(localizedCtaButtonText)) {
                    localizedCtaButtonText = getContext().getString(R.string.ia_video_install_now_text);
                }
            }
            if (!TextUtils.isEmpty(this.y)) {
                localizedCtaButtonText = this.y;
            }
            textView2.setText(localizedCtaButtonText);
            this.N.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void g(boolean z) {
        TextView textView = this.V;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void a(boolean z, String str) {
        TextView textView = this.M;
        if (textView != null) {
            textView.setText(str);
            if (str != null && str.length() == 1) {
                setAppInfoButtonRound(this.M);
            }
            if (z) {
                ViewGroup.LayoutParams layoutParams = this.N.getLayoutParams();
                layoutParams.width = -2;
                this.N.setLayoutParams(layoutParams);
                this.N.setTextSize(0, getResources().getDimension(R.dimen.ia_video_overlay_text_large_for_cta));
            }
            this.M.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void a(boolean z) {
        View view = this.S;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }
}
