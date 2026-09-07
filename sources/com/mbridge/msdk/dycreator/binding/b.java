package com.mbridge.msdk.dycreator.binding;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mbridge.msdk.dycreator.baseview.MBApkInfoView;
import com.mbridge.msdk.dycreator.baseview.MBFeedBack;
import com.mbridge.msdk.dycreator.baseview.MBLogoTextView;
import com.mbridge.msdk.dycreator.baseview.MBSplashClickView;
import com.mbridge.msdk.dycreator.baseview.MBSplashImageBgView;
import com.mbridge.msdk.dycreator.baseview.MBSplashPortView;
import com.mbridge.msdk.dycreator.baseview.MBSplashShakeView;
import com.mbridge.msdk.dycreator.baseview.inter.InterBase;
import com.mbridge.msdk.dycreator.binding.response.SplashResData;
import com.mbridge.msdk.dycreator.bridge.MBSplashData;
import com.mbridge.msdk.dycreator.bus.EventBus;
import com.mbridge.msdk.dycreator.listener.DyCountDownListenerWrapper;
import com.mbridge.msdk.dycreator.listener.action.EAction;
import com.mbridge.msdk.dycreator.viewmodel.BaseViewModel;
import com.mbridge.msdk.dycreator.viewobserver.h;
import com.mbridge.msdk.dycreator.viewobserver.i;
import com.mbridge.msdk.dycreator.wrapper.DyOption;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.foundation.tools.n0;
import com.mbridge.msdk.foundation.tools.o0;
import io.bidmachine.iab.vast.tags.VastAttributes;

/* JADX INFO: compiled from: MBDataBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    private static volatile b g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.mbridge.msdk.dycreator.viewobserver.d f4837a = (com.mbridge.msdk.dycreator.viewobserver.d) com.mbridge.msdk.dycreator.subjectfactory.a.a().a(com.mbridge.msdk.dycreator.subjectfactory.a.b.VIEW_OBSERVER);
    private com.mbridge.msdk.dycreator.viewobserver.c b = (com.mbridge.msdk.dycreator.viewobserver.c) com.mbridge.msdk.dycreator.subjectfactory.a.a().a(com.mbridge.msdk.dycreator.subjectfactory.a.b.CLICK_OBSERVER);
    private com.mbridge.msdk.dycreator.viewobserver.f c = (com.mbridge.msdk.dycreator.viewobserver.f) com.mbridge.msdk.dycreator.subjectfactory.a.a().a(com.mbridge.msdk.dycreator.subjectfactory.a.b.EFFECT_OBSERVER);
    private h d = (h) com.mbridge.msdk.dycreator.subjectfactory.a.a().a(com.mbridge.msdk.dycreator.subjectfactory.a.b.REPORT_OBSERVER);
    private BaseViewModel e;
    private com.mbridge.msdk.shake.b f;

    /* JADX INFO: compiled from: MBDataBinding.java */
    class a implements com.mbridge.msdk.dycreator.viewobserver.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f4838a;

        a(View view) {
            this.f4838a = view;
        }

        @Override // com.mbridge.msdk.dycreator.viewobserver.g
        public void a(Object obj) {
            try {
                KeyEvent.Callback callback = this.f4838a;
                if (callback instanceof InterBase) {
                    b.this.b((InterBase) callback, obj);
                }
            } catch (Exception e) {
                o0.b("MBDataBinding", e.getMessage());
            }
        }
    }

    /* JADX INFO: renamed from: com.mbridge.msdk.dycreator.binding.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MBDataBinding.java */
    class C0425b implements com.mbridge.msdk.dycreator.viewobserver.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f4839a;

        C0425b(View view) {
            this.f4839a = view;
        }

        @Override // com.mbridge.msdk.dycreator.viewobserver.e
        public void a(Object obj) {
            try {
                KeyEvent.Callback callback = this.f4839a;
                if (callback instanceof InterBase) {
                    b.this.a((InterBase) callback, obj);
                }
            } catch (Exception e) {
                o0.b("MBDataBinding", e.getMessage());
            }
        }
    }

    /* JADX INFO: compiled from: MBDataBinding.java */
    class c implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f4840a;

        c(View view) {
            this.f4840a = view;
        }

        @Override // com.mbridge.msdk.dycreator.viewobserver.i
        public void a(Object obj) {
            try {
                KeyEvent.Callback callback = this.f4840a;
                if (callback instanceof InterBase) {
                    b.this.c((InterBase) callback, obj);
                }
            } catch (Exception e) {
                o0.b("MBDataBinding", e.getMessage());
            }
        }
    }

    /* JADX INFO: compiled from: MBDataBinding.java */
    class d implements com.mbridge.msdk.dycreator.viewobserver.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f4841a;

        d(View view) {
            this.f4841a = view;
        }

        @Override // com.mbridge.msdk.dycreator.viewobserver.b
        public void a(Object obj) {
            if (obj == null) {
                return;
            }
            try {
                if (com.mbridge.msdk.dycreator.utils.d.a(this.f4841a, (com.mbridge.msdk.dycreator.viewdata.base.a) obj)) {
                    b.this.a(this.f4841a, obj);
                }
            } catch (Exception e) {
                o0.b("MBDataBinding", e.getMessage());
            }
        }
    }

    /* JADX INFO: compiled from: MBDataBinding.java */
    class e implements DyCountDownListenerWrapper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f4842a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ View d;

        e(boolean z, String str, String str2, View view) {
            this.f4842a = z;
            this.b = str;
            this.c = str2;
            this.d = view;
        }

        @Override // com.mbridge.msdk.dycreator.listener.DyCountDownListenerWrapper
        public void getCountDownValue(int i) {
            if (i != 0) {
                ((TextView) this.d).setText(com.mbridge.msdk.dycreator.utils.d.a(this.f4842a, i, this.b, this.c));
            } else {
                SplashResData splashResData = new SplashResData();
                splashResData.seteAction(EAction.CLOSE);
                EventBus.getDefault().post(splashResData);
            }
        }
    }

    /* JADX INFO: compiled from: MBDataBinding.java */
    class f implements com.mbridge.msdk.foundation.same.image.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.dycreator.viewdata.base.a f4843a;
        final /* synthetic */ View b;

        f(com.mbridge.msdk.dycreator.viewdata.base.a aVar, View view) {
            this.f4843a = aVar;
            this.b = view;
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onFailedLoad(String str, String str2) {
            View view = this.b;
            if (view != null) {
                ((ImageView) view).setBackgroundColor(-7829368);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onSuccessLoad(Bitmap bitmap, String str) {
            if (bitmap != null) {
                try {
                    if (!bitmap.isRecycled()) {
                        boolean z = bitmap.getWidth() > bitmap.getHeight();
                        if ((this.f4843a.getEffectData().getOrientation() == 1 ? this.b.getResources().getConfiguration().orientation : this.f4843a.getEffectData().getOrientation()) == 1) {
                            if (z) {
                                View view = this.b;
                                if (view instanceof MBSplashPortView) {
                                    if (view.getParent() != null) {
                                        ((ViewGroup) this.b.getParent()).setVisibility(8);
                                        return;
                                    }
                                    return;
                                } else if (view instanceof MBSplashImageBgView) {
                                    view.setVisibility(0);
                                    Bitmap bitmapA = n0.a(bitmap);
                                    ((MBSplashImageBgView) this.b).setScaleType(ImageView.ScaleType.CENTER_CROP);
                                    ((MBSplashImageBgView) this.b).setImageBitmap(bitmapA);
                                    return;
                                }
                            } else {
                                View view2 = this.b;
                                if (view2 instanceof MBSplashPortView) {
                                    view2.setVisibility(0);
                                    ((MBSplashPortView) this.b).setScaleType(ImageView.ScaleType.FIT_CENTER);
                                    ((MBSplashPortView) this.b).setImageBitmap(bitmap);
                                    return;
                                } else if (view2 instanceof MBSplashImageBgView) {
                                    view2.setVisibility(8);
                                    return;
                                } else if (view2 instanceof InterBase) {
                                    String effectDes = ((InterBase) view2).getEffectDes();
                                    ViewGroup viewGroup = (ViewGroup) this.b.getParent();
                                    if (viewGroup != null) {
                                        com.mbridge.msdk.dycreator.utils.d.a(effectDes, viewGroup, true);
                                    }
                                }
                            }
                        } else if (z) {
                            View view3 = this.b;
                            if (view3 instanceof MBSplashPortView) {
                                view3.setVisibility(0);
                                ((MBSplashPortView) this.b).setScaleType(ImageView.ScaleType.FIT_XY);
                                ((ImageView) this.b).setImageBitmap(bitmap);
                                return;
                            } else if (view3 instanceof MBSplashImageBgView) {
                                view3.setVisibility(8);
                                ((MBSplashImageBgView) this.b).setImageBitmap(n0.a(bitmap));
                                return;
                            } else if (view3 instanceof InterBase) {
                                String effectDes2 = ((InterBase) view3).getEffectDes();
                                ViewGroup viewGroup2 = (ViewGroup) this.b.getParent();
                                if (viewGroup2 != null) {
                                    com.mbridge.msdk.dycreator.utils.d.a(effectDes2, viewGroup2, true);
                                }
                            }
                        } else {
                            View view4 = this.b;
                            if (view4 instanceof MBSplashPortView) {
                                view4.setVisibility(0);
                                ((MBSplashPortView) this.b).setImageBitmap(bitmap);
                                return;
                            } else {
                                if (view4 instanceof MBSplashImageBgView) {
                                    view4.setVisibility(0);
                                    Bitmap bitmapA2 = n0.a(bitmap);
                                    ((MBSplashImageBgView) this.b).setScaleType(ImageView.ScaleType.CENTER_CROP);
                                    ((MBSplashImageBgView) this.b).setImageBitmap(bitmapA2);
                                    return;
                                }
                                if (view4 instanceof InterBase) {
                                    String effectDes3 = ((InterBase) view4).getEffectDes();
                                    ViewGroup viewGroup3 = (ViewGroup) this.b.getParent();
                                    if (viewGroup3 != null) {
                                        com.mbridge.msdk.dycreator.utils.d.a(effectDes3, viewGroup3, true);
                                    }
                                }
                            }
                        }
                        ((ImageView) this.b).setImageBitmap(bitmap);
                        return;
                    }
                } catch (Exception e) {
                    o0.b("MBDataBinding", e.getMessage());
                    return;
                }
            }
            ((ImageView) this.b).setBackgroundColor(-7829368);
        }
    }

    /* JADX INFO: compiled from: MBDataBinding.java */
    class g extends com.mbridge.msdk.shake.b {
        final /* synthetic */ View g;
        final /* synthetic */ MBSplashData h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(int i, int i2, View view, MBSplashData mBSplashData) {
            super(i, i2);
            this.g = view;
            this.h = mBSplashData;
        }

        @Override // com.mbridge.msdk.shake.b
        public void a() {
            View view = this.g;
            if (view != null) {
                try {
                    if (view.getGlobalVisibleRect(new Rect())) {
                        SplashResData splashResData = new SplashResData();
                        this.h.setClickType(4);
                        splashResData.setBaseViewData(this.h);
                        splashResData.seteAction(EAction.DOWNLOAD);
                        EventBus.getDefault().post(splashResData);
                        com.mbridge.msdk.shake.a.a().b(b.this.f);
                    }
                } catch (Exception e) {
                    o0.b("MBDataBinding", e.getMessage());
                }
            }
        }
    }

    private b() {
    }

    public void d(View view) {
        a(new a(view), view.getId());
    }

    public void b(View view) {
        a(new c(view), view.getId());
    }

    public void c(View view) {
        a(new C0425b(view), view.getId());
    }

    public static b a() {
        if (g == null) {
            synchronized (b.class) {
                if (g == null) {
                    g = new b();
                }
            }
        }
        return g;
    }

    private void a(i iVar, int i) {
        com.mbridge.msdk.dycreator.viewobserver.d dVar = this.f4837a;
        if (dVar != null) {
            dVar.a(iVar, i);
        }
    }

    private void a(com.mbridge.msdk.dycreator.viewobserver.b bVar, int i) {
        com.mbridge.msdk.dycreator.viewobserver.c cVar = this.b;
        if (cVar != null) {
            cVar.a(bVar, i);
        }
    }

    private void a(com.mbridge.msdk.dycreator.viewobserver.e eVar, int i) {
        com.mbridge.msdk.dycreator.viewobserver.f fVar = this.c;
        if (fVar != null) {
            fVar.a(eVar, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(InterBase interBase, Object obj) {
        if (interBase == null || obj == null) {
            return;
        }
        String reportDes = interBase.getReportDes();
        if (TextUtils.isEmpty(reportDes)) {
            return;
        }
        try {
            if (!(obj instanceof com.mbridge.msdk.dycreator.viewdata.base.a) || ((com.mbridge.msdk.dycreator.viewdata.base.a) obj).getBindData() == null) {
                return;
            }
            interBase.setDynamicReport(reportDes, ((com.mbridge.msdk.dycreator.viewdata.base.a) obj).getBindData());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void c(InterBase interBase, Object obj) {
        if (interBase == 0 || obj == null) {
            return;
        }
        String bindDataDes = interBase.getBindDataDes();
        if (TextUtils.isEmpty(bindDataDes)) {
            return;
        }
        try {
            Object objA = com.mbridge.msdk.dycreator.utils.d.a(obj, bindDataDes);
            if (objA == null) {
                return;
            }
            if (interBase instanceof ViewGroup) {
                b((ViewGroup) interBase, objA, (com.mbridge.msdk.dycreator.viewdata.base.a) obj);
            } else if (interBase instanceof View) {
                a((View) interBase, objA, (com.mbridge.msdk.dycreator.viewdata.base.a) obj);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(com.mbridge.msdk.dycreator.viewobserver.g gVar, int i) {
        h hVar = this.d;
        if (hVar != null) {
            hVar.a(gVar, i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(View view) {
        if (view != 0) {
            try {
                if (view instanceof InterBase) {
                    String actionDes = ((InterBase) view).getActionDes();
                    if (!TextUtils.isEmpty(actionDes)) {
                        if (actionDes.startsWith("click")) {
                            a(new d(view), view.getId());
                        } else if (!actionDes.equals("move") && !actionDes.equals("long_click")) {
                            actionDes.equals("wobble");
                        }
                    }
                }
            } catch (Exception e2) {
                o0.b("MBDataBinding", e2.getMessage());
            }
        }
    }

    private void b(ViewGroup viewGroup, Object obj, com.mbridge.msdk.dycreator.viewdata.base.a aVar) {
        if (viewGroup != null) {
            if (viewGroup instanceof MBSplashClickView) {
                if (aVar == null || aVar.getEffectData() == null || !aVar.getEffectData().isClickButtonVisible() || aVar.getEffectData().isShakeVisible()) {
                    viewGroup.setVisibility(8);
                } else if (obj != null && !TextUtils.isEmpty(obj.toString())) {
                    viewGroup.setVisibility(0);
                    ((MBSplashClickView) viewGroup).initView(obj.toString());
                }
            }
            if (viewGroup instanceof MBSplashShakeView) {
                if (aVar != null && aVar.getEffectData() != null && aVar.getEffectData().isShakeVisible()) {
                    if (obj == null || TextUtils.isEmpty(obj.toString())) {
                        return;
                    }
                    viewGroup.setVisibility(0);
                    ((MBSplashShakeView) viewGroup).initView(obj.toString());
                    return;
                }
                viewGroup.setVisibility(8);
            }
        }
    }

    public synchronized void b() {
        com.mbridge.msdk.dycreator.viewobserver.c cVar = this.b;
        if (cVar != null) {
            cVar.a();
        }
        com.mbridge.msdk.dycreator.viewobserver.d dVar = this.f4837a;
        if (dVar != null) {
            dVar.a();
        }
        com.mbridge.msdk.dycreator.viewobserver.f fVar = this.c;
        if (fVar != null) {
            fVar.a();
        }
        if (this.e != null) {
            this.e = null;
        }
        if (this.f != null) {
            this.f = null;
        }
        if (g != null) {
            g = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(InterBase interBase, Object obj) {
        if (interBase == 0 || obj == null) {
            return;
        }
        String effectDes = interBase.getEffectDes();
        if (TextUtils.isEmpty(effectDes)) {
            return;
        }
        try {
            if (interBase instanceof ViewGroup) {
                a((ViewGroup) interBase, (Object) effectDes, (com.mbridge.msdk.dycreator.viewdata.base.a) obj);
            } else if (interBase instanceof View) {
                a((View) interBase, effectDes, obj);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(ViewGroup viewGroup, Object obj, com.mbridge.msdk.dycreator.viewdata.base.a aVar) {
        if (obj == null || !(obj instanceof String)) {
            return;
        }
        if (obj.equals("wobble") && (viewGroup instanceof MBSplashShakeView)) {
            if (aVar.getEffectData().isShakeVisible()) {
                if (this.f != null) {
                    com.mbridge.msdk.shake.a.a().b(this.f);
                }
                com.mbridge.msdk.shake.a.a().a(a((View) viewGroup, (MBSplashData) aVar));
            } else if (this.f != null) {
                com.mbridge.msdk.shake.a.a().b(this.f);
            }
        }
        if (obj.equals(VastAttributes.VISIBLE) && (viewGroup instanceof MBApkInfoView)) {
            if (aVar.getEffectData().isApkInfoVisible()) {
                if ((aVar instanceof MBSplashData) && !TextUtils.isEmpty(((MBSplashData) aVar).getAppInfo())) {
                    viewGroup.setVisibility(0);
                } else {
                    viewGroup.setVisibility(4);
                }
            } else {
                viewGroup.setVisibility(8);
            }
        }
        obj.equals("anim");
    }

    private void a(View view, Object obj, Object obj2) {
        int countDownTime;
        boolean z;
        if (obj == null || !(obj instanceof String)) {
            return;
        }
        com.mbridge.msdk.dycreator.viewdata.base.a aVar = (com.mbridge.msdk.dycreator.viewdata.base.a) obj2;
        if (obj.equals("countdown") && view != null && (view instanceof TextView) && aVar != null) {
            TextView textView = (TextView) view;
            String str = (String) textView.getText();
            String strP = k0.p(view.getContext());
            DyOption effectData = aVar.getEffectData();
            if (effectData != null) {
                boolean zIsCanSkip = effectData.isCanSkip();
                countDownTime = effectData.getCountDownTime();
                z = zIsCanSkip;
            } else {
                countDownTime = 5;
                z = false;
            }
            textView.setText(com.mbridge.msdk.dycreator.utils.d.a(z, countDownTime, str, strP));
            aVar.getEffectData().setDyCountDownListenerWrapper(new e(z, str, strP, view));
        }
        obj.equals("anim");
        if (obj.equals(VastAttributes.VISIBLE)) {
            if (view instanceof MBFeedBack) {
                if (com.mbridge.msdk.foundation.feedback.b.b().a()) {
                    view.setVisibility(0);
                } else {
                    view.setVisibility(8);
                }
            }
            if (!(view instanceof MBLogoTextView) || aVar == null || aVar.getEffectData() == null || aVar.getEffectData().isLogoVisible()) {
                return;
            }
            ((MBLogoTextView) view).setCompoundDrawables(null, null, null, null);
        }
    }

    private void a(View view, Object obj, com.mbridge.msdk.dycreator.viewdata.base.a aVar) {
        if (view == null || obj == null) {
            return;
        }
        try {
            if (view instanceof TextView) {
                try {
                    ((TextView) view).setText(String.valueOf(obj).replace("\\n", "\n"));
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            if (view instanceof ImageView) {
                if (obj instanceof Integer) {
                    ((ImageView) view).setImageResource(((Integer) obj).intValue());
                }
                if (obj instanceof String) {
                    com.mbridge.msdk.foundation.same.image.b.a(com.mbridge.msdk.foundation.controller.c.m().d()).a(obj.toString(), new f(aVar, view));
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, Object obj) {
        if (view == null || obj == null || !(obj instanceof com.mbridge.msdk.dycreator.viewdata.base.a)) {
            return;
        }
        view.setOnClickListener(new com.mbridge.msdk.dycreator.binding.a((com.mbridge.msdk.dycreator.viewdata.base.a) obj));
    }

    public void a(BaseViewModel baseViewModel) {
        this.e = baseViewModel;
        if (baseViewModel != null) {
            baseViewModel.setClickSubject(this.b);
            this.e.setConcreteSubject(this.f4837a);
            this.e.setEffectSubject(this.c);
            this.e.setReportSubject(this.d);
        }
    }

    private com.mbridge.msdk.shake.b a(View view, MBSplashData mBSplashData) {
        if (mBSplashData != null) {
            try {
                DyOption dyOption = mBSplashData.getDyOption();
                if (dyOption != null && dyOption.isShakeVisible() && this.f == null) {
                    this.f = new g(dyOption.getShakeStrenght(), dyOption.getShakeTime() * 1000, view, mBSplashData);
                }
            } catch (Exception e2) {
                o0.b("MBDataBinding", e2.getMessage());
            }
        }
        return this.f;
    }
}
