package sg.bigo.ads.common.form;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Map;
import sg.bigo.ads.R;
import sg.bigo.ads.api.a.e;
import sg.bigo.ads.api.a.f;
import sg.bigo.ads.common.form.render.a.d;
import sg.bigo.ads.common.utils.k;
import sg.bigo.ads.common.utils.q;
import sg.bigo.ads.common.utils.u;
import sg.bigo.ads.common.view.HeightScrollView;
import sg.bigo.ads.common.view.Indicator;
import sg.bigo.ads.common.view.PrivacyCheckBox;
import sg.bigo.ads.common.view.ViewFlow;

/* JADX INFO: loaded from: classes8.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final sg.bigo.ads.common.form.render.b f13159a;
    public final RelativeLayout b;
    public final ViewFlow c;
    public final Indicator d;
    public final LinearLayout e;

    private c(RelativeLayout relativeLayout, sg.bigo.ads.common.form.render.b bVar) {
        this.b = relativeLayout;
        this.f13159a = bVar;
        this.c = (ViewFlow) relativeLayout.findViewById(R.id.inter_image_view_flow);
        this.d = (Indicator) relativeLayout.findViewById(R.id.inter_image_indicator);
        this.e = (LinearLayout) relativeLayout.findViewById(R.id.inter_form_content);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public static c a(Context context, e eVar, Map<String, Object> map, boolean z, int i, int i2, sg.bigo.ads.common.form.render.b.a aVar) {
        View view;
        int iA;
        sg.bigo.ads.common.form.render.b bVar = new sg.bigo.ads.common.form.render.b(context, eVar, map, i, i2, aVar);
        RelativeLayout relativeLayout = null;
        ViewGroup.LayoutParams layoutParams = null;
        sg.bigo.ads.common.form.render.a.a bVar2 = null;
        bVar.e = (RelativeLayout) sg.bigo.ads.common.utils.a.a(bVar.f13168a, sg.bigo.ads.common.form.render.a.a(3), null, false);
        if (bVar.e != null) {
            RelativeLayout relativeLayout2 = bVar.e;
            if (z) {
                sg.bigo.ads.common.form.render.c.a(relativeLayout2, bVar.f13168a, bVar.b, bVar, 5);
            } else {
                sg.bigo.ads.common.form.render.b.a((TextView) relativeLayout2.findViewById(R.id.inter_form_content_title), bVar.b.a());
                sg.bigo.ads.common.form.render.b.a((TextView) bVar.e.findViewById(R.id.inter_form_content_description), bVar.b.b());
                RelativeLayout relativeLayout3 = bVar.e;
                e eVar2 = bVar.b;
                int i3 = 1;
                if (eVar2.k() == null || !q.b((CharSequence) eVar2.k().c())) {
                    ViewGroup viewGroup = (ViewGroup) relativeLayout3.findViewById(R.id.inter_form_icon_layout);
                    if (viewGroup != null) {
                        viewGroup.setVisibility(8);
                    }
                    ViewGroup viewGroup2 = (ViewGroup) relativeLayout3.findViewById(R.id.inter_form_content_layout);
                    if (viewGroup2 != null) {
                        viewGroup2.setPadding(0, 0, 0, 0);
                    }
                } else {
                    ImageView imageView = (ImageView) relativeLayout3.findViewById(R.id.inter_form_content_icon);
                    if (imageView != null) {
                        new sg.bigo.ads.common.p.b(imageView, (byte) 0).a(null, eVar2.k().c(), true);
                    }
                }
                RelativeLayout relativeLayout4 = bVar.e;
                Context context2 = bVar.f13168a;
                e eVar3 = bVar.b;
                View viewFindViewById = relativeLayout4.findViewById(R.id.inter_blank_viewholder);
                if (viewFindViewById != null && eVar3.j() != null) {
                    int iA2 = sg.bigo.ads.common.form.render.c.a(context2, eVar3);
                    ViewGroup.LayoutParams layoutParams2 = viewFindViewById.getLayoutParams();
                    layoutParams2.height = iA2 - sg.bigo.ads.common.utils.e.a(context2, 8);
                    viewFindViewById.setLayoutParams(layoutParams2);
                }
                FrameLayout frameLayout = (FrameLayout) relativeLayout4.findViewById(R.id.inter_form_icon_layout);
                if (frameLayout != null) {
                    if (eVar3.j() == null) {
                        iA = 0;
                    } else {
                        iA = sg.bigo.ads.common.form.render.c.a(context2, eVar3) - sg.bigo.ads.common.utils.e.a(context2, 33);
                        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) frameLayout.getLayoutParams();
                        layoutParams3.topMargin = iA;
                        frameLayout.setLayoutParams(layoutParams3);
                    }
                    HeightScrollView heightScrollView = (HeightScrollView) relativeLayout4.findViewById(R.id.inter_form_scroll);
                    if (heightScrollView != null) {
                        heightScrollView.setBlankView(viewFindViewById);
                        heightScrollView.setOnScrollListener(new HeightScrollView.a() { // from class: sg.bigo.ads.common.form.render.c.6

                            /* JADX INFO: renamed from: a */
                            final /* synthetic */ FrameLayout f13177a;
                            final /* synthetic */ int b;

                            public AnonymousClass6() {
                                frameLayout = frameLayout;
                                i = iA;
                            }

                            @Override // sg.bigo.ads.common.view.HeightScrollView.a
                            public final void a(int i4) {
                                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) frameLayout.getLayoutParams();
                                marginLayoutParams.topMargin = i - i4;
                                frameLayout.setLayoutParams(marginLayoutParams);
                            }
                        });
                    }
                }
                bVar.d = (Button) bVar.e.findViewById(R.id.inter_form_submit);
                if (bVar.d != null) {
                    bVar.d.setText(a.a(bVar.f13168a, R.string.bigo_ad_form_submit));
                    bVar.d.setOnClickListener(new View.OnClickListener() { // from class: sg.bigo.ads.common.form.render.b.3
                        public AnonymousClass3() {
                        }

                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            View viewC;
                            GradientDrawable gradientDrawable;
                            b bVar3 = b.this;
                            bVar3.a(3, bVar3.g, System.currentTimeMillis() - b.this.f);
                            b bVar4 = b.this;
                            if (bVar4.c == null) {
                                viewC = null;
                                break;
                            }
                            sg.bigo.ads.common.form.render.a.c cVar = bVar4.c;
                            int size = cVar.g == null ? 0 : cVar.g.size();
                            int i4 = 0;
                            while (true) {
                                if (i4 < size) {
                                    sg.bigo.ads.common.form.render.a.a aVar2 = cVar.g.get(i4);
                                    if (aVar2 != null && aVar2.a()) {
                                        viewC = aVar2.c();
                                        break;
                                    }
                                    i4++;
                                } else {
                                    viewC = null;
                                    break;
                                }
                            }
                            if (viewC != null) {
                                RelativeLayout relativeLayout5 = b.this.e;
                                HeightScrollView heightScrollView2 = (HeightScrollView) relativeLayout5.findViewById(R.id.inter_form_scroll);
                                View viewFindViewById2 = relativeLayout5.findViewById(R.id.inter_blank_viewholder);
                                int height = viewFindViewById2 != null ? viewFindViewById2.getHeight() : 0;
                                if (heightScrollView2 != null) {
                                    heightScrollView2.scrollTo(0, viewC.getTop() + height);
                                    return;
                                }
                                return;
                            }
                            if (b.this.c.b()) {
                                c.a(b.this.e, b.this.f13168a, b.this.b, b.this, 1);
                                return;
                            }
                            RelativeLayout relativeLayout6 = b.this.e;
                            Context context3 = b.this.f13168a;
                            e eVar4 = b.this.b;
                            b bVar5 = b.this;
                            ViewGroup viewGroup3 = (ViewGroup) relativeLayout6.findViewById(R.id.inter_privacy_notice_container);
                            View viewA = sg.bigo.ads.common.utils.a.a(context3, sg.bigo.ads.common.form.render.a.a(4), null, false);
                            if (viewA != null && viewGroup3 != null) {
                                u.a(viewA, viewGroup3, null, -1);
                                TextView textView = (TextView) viewA.findViewById(R.id.bigo_ad_form_btn_cancel);
                                if (textView != null) {
                                    if (context3 == null) {
                                        gradientDrawable = null;
                                    } else {
                                        int i5 = sg.bigo.ads.common.form.render.a.f13161a ? -14931661 : -1;
                                        int i6 = sg.bigo.ads.common.form.render.a.f13161a ? -10456960 : -4009768;
                                        gradientDrawable = new GradientDrawable();
                                        gradientDrawable.setShape(0);
                                        gradientDrawable.setStroke(sg.bigo.ads.common.utils.e.a(context3, 1), i6);
                                        gradientDrawable.setColor(i5);
                                        gradientDrawable.setCornerRadius(sg.bigo.ads.common.utils.e.a(context3, 8));
                                    }
                                    textView.setBackground(gradientDrawable);
                                    textView.setText(sg.bigo.ads.common.form.a.a(context3, R.string.bigo_ad_form_cancel));
                                    textView.setOnClickListener(new View.OnClickListener() { // from class: sg.bigo.ads.common.form.render.c.1

                                        /* JADX INFO: renamed from: a */
                                        final /* synthetic */ View f13172a;
                                        final /* synthetic */ a b;

                                        AnonymousClass1() {
                                            view = viewA;
                                            aVar = bVar5;
                                        }

                                        @Override // android.view.View.OnClickListener
                                        public final void onClick(View view3) {
                                            u.b(view);
                                            a aVar3 = aVar;
                                            if (aVar3 != null) {
                                                aVar3.b();
                                            }
                                        }
                                    });
                                }
                                TextView textView2 = (TextView) viewA.findViewById(R.id.bigo_ad_form_btn_agree);
                                if (textView2 != null) {
                                    textView2.setText(sg.bigo.ads.common.form.a.a(context3, R.string.bigo_ad_form_agree));
                                    textView2.setOnClickListener(new View.OnClickListener() { // from class: sg.bigo.ads.common.form.render.c.2

                                        /* JADX INFO: renamed from: a */
                                        final /* synthetic */ View f13173a;
                                        final /* synthetic */ ViewGroup b;
                                        final /* synthetic */ Context c;
                                        final /* synthetic */ e d;
                                        final /* synthetic */ a e;

                                        AnonymousClass2() {
                                            view = viewA;
                                            viewGroup = relativeLayout6;
                                            context = context3;
                                            eVar = eVar4;
                                            aVar = bVar5;
                                        }

                                        @Override // android.view.View.OnClickListener
                                        public final void onClick(View view3) {
                                            u.b(view);
                                            c.a(viewGroup, context, eVar, aVar, 2);
                                            a aVar3 = aVar;
                                            if (aVar3 != null) {
                                                aVar3.c();
                                            }
                                        }
                                    });
                                }
                                PrivacyCheckBox privacyCheckBox = (PrivacyCheckBox) viewA.findViewById(R.id.inter_form_check_box);
                                if (privacyCheckBox != null && textView2 != null) {
                                    privacyCheckBox.setOnCheckChangeListener(new PrivacyCheckBox.d() { // from class: sg.bigo.ads.common.form.render.c.3

                                        /* JADX INFO: renamed from: a */
                                        final /* synthetic */ TextView f13174a;

                                        AnonymousClass3() {
                                            textView = textView2;
                                        }

                                        @Override // sg.bigo.ads.common.view.PrivacyCheckBox.d
                                        public final void a(boolean z2) {
                                            int i7;
                                            if (z2) {
                                                i7 = R.drawable.bigo_ad_btn_background;
                                            } else {
                                                i7 = sg.bigo.ads.common.form.render.a.f13161a ? R.drawable.bigo_ad_btn_background_white_dark : R.drawable.bigo_ad_btn_background_white;
                                            }
                                            textView.setBackgroundResource(i7);
                                            textView.setClickable(z2);
                                        }
                                    });
                                }
                                c.a(viewA, eVar4, null, bVar5);
                            }
                            b bVar6 = b.this;
                            bVar6.a(4, bVar6.g, System.currentTimeMillis() - b.this.f);
                        }
                    });
                }
                ViewGroup viewGroup3 = (ViewGroup) bVar.e.findViewById(R.id.inter_form_content);
                if (viewGroup3 != null) {
                    sg.bigo.ads.common.form.render.a.c cVar = bVar.c;
                    cVar.e = sg.bigo.ads.common.utils.a.a(cVar.f13165a, sg.bigo.ads.common.form.render.a.a(5), null, false);
                    if (cVar.e == null) {
                        view = null;
                    } else {
                        ViewGroup viewGroup4 = (ViewGroup) cVar.e.findViewById(R.id.bigo_ad_id_form_question);
                        if (cVar.d != null && viewGroup4 != null) {
                            e.c[] cVarArr = cVar.d;
                            int length = cVarArr.length;
                            int i4 = 0;
                            while (i4 < length) {
                                e.c cVar2 = cVarArr[i4];
                                Map<String, Object> map2 = cVar.b;
                                Context context3 = cVar.f13165a;
                                if (cVar2 != null) {
                                    int i5 = cVar2.b;
                                    bVar2 = i5 != i3 ? (i5 == 2 || i5 == 3) ? new sg.bigo.ads.common.form.render.a.b(cVar2, map2, context3, cVar) : null : new d(cVar2, map2, context3, cVar);
                                }
                                if (bVar2 != null) {
                                    cVar.g.add(bVar2);
                                    View viewB = bVar2.b();
                                    RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
                                    layoutParams4.bottomMargin = sg.bigo.ads.common.utils.e.a(cVar.f13165a, 27);
                                    u.a(viewB, viewGroup4, layoutParams4, -1);
                                }
                                i4++;
                                bVar2 = null;
                                i3 = 1;
                            }
                        }
                        TextView textView = (TextView) cVar.e.findViewById(R.id.inter_form_question_purpose);
                        if (textView != null) {
                            textView.setText(cVar.c.h());
                        }
                        cVar.f = sg.bigo.ads.common.form.render.c.a(cVar.e, cVar.c, cVar.b, cVar.h);
                        view = cVar.e;
                        layoutParams = null;
                    }
                    u.a(view, viewGroup3, layoutParams, -1);
                }
            }
            u.a(bVar.e, new View.OnAttachStateChangeListener() { // from class: sg.bigo.ads.common.form.render.b.2
                public AnonymousClass2() {
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public final void onViewAttachedToWindow(View view2) {
                    sg.bigo.ads.common.n.d.a(2, b.this.h);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public final void onViewDetachedFromWindow(View view2) {
                    b bVar3 = b.this;
                    bVar3.a(12, bVar3.g, System.currentTimeMillis() - b.this.f);
                }
            });
            relativeLayout = bVar.e;
        }
        c cVar3 = new c(relativeLayout, bVar);
        cVar3.d.setType(0);
        cVar3.d.setRadius(sg.bigo.ads.common.utils.e.a(context, 3));
        cVar3.d.setPadding(sg.bigo.ads.common.utils.e.a(context, 4), sg.bigo.ads.common.utils.e.a(context, 3), sg.bigo.ads.common.utils.e.a(context, 4), sg.bigo.ads.common.utils.e.a(context, 3));
        cVar3.c.setViewStyle(3);
        cVar3.c.setFlipInterval(5000);
        cVar3.c.setOnItemChangeListener(new ViewFlow.c() { // from class: sg.bigo.ads.common.form.c.1
            @Override // sg.bigo.ads.common.view.ViewFlow.c
            public final void a(int i6) {
                Indicator indicator;
                int i7;
                c.this.d.setNum(i6);
                if (i6 > 1) {
                    indicator = c.this.d;
                    i7 = 0;
                } else {
                    indicator = c.this.d;
                    i7 = 4;
                }
                indicator.setVisibility(i7);
            }

            @Override // sg.bigo.ads.common.view.ViewFlow.c
            public final void a(int i6, int i7) {
            }

            @Override // sg.bigo.ads.common.view.ViewFlow.c
            public final void a(View view2, int i6) {
                c.this.d.a(i6);
            }

            @Override // sg.bigo.ads.common.view.ViewFlow.c
            public final void a(View view2, int i6, float f) {
                c.this.d.a(f, i6);
            }
        });
        cVar3.c.getLayoutParams().height = sg.bigo.ads.common.form.render.c.a(context, eVar);
        f[] fVarArrI = eVar.i();
        if (!k.a(fVarArrI)) {
            for (f fVar : fVarArrI) {
                ImageView imageView2 = new ImageView(context);
                new sg.bigo.ads.common.p.b(imageView2).a(null, fVar.c(), false);
                imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                ViewFlow.b bVar3 = new ViewFlow.b();
                bVar3.width = -1;
                bVar3.height = -2;
                bVar3.e = 48;
                bVar3.d = 3;
                cVar3.c.addView(imageView2, bVar3);
                if (eVar.f() == 0) {
                    break;
                }
            }
        }
        return cVar3;
    }
}
