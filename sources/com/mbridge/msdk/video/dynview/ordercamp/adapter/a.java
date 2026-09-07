package com.mbridge.msdk.video.dynview.ordercamp.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.dycreator.baseview.MBFrameLayout;
import com.mbridge.msdk.dycreator.baseview.MBHeatLevelLayoutView;
import com.mbridge.msdk.dycreator.baseview.MBStarLevelLayoutView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBCusRoundImageView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBRotationView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeImageView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeTextView;
import com.mbridge.msdk.dycreator.wrapper.DyAdType;
import com.mbridge.msdk.dycreator.wrapper.DyOption;
import com.mbridge.msdk.dycreator.wrapper.DynamicViewCreator;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.image.c;
import com.mbridge.msdk.foundation.tools.g0;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.foundation.tools.m0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.setting.h;
import com.mbridge.msdk.video.dynview.widget.MBridgeLevelLayoutView;
import com.mbridge.msdk.videocommon.view.RoundImageView;
import java.io.File;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: OrderCampAdapter.java */
/* JADX INFO: loaded from: classes12.dex */
public class a extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5738a = false;
    private b b;
    private List<CampaignEx> c;

    /* JADX INFO: renamed from: com.mbridge.msdk.video.dynview.ordercamp.adapter.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OrderCampAdapter.java */
    class C0507a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImageView f5739a;
        final /* synthetic */ boolean b;

        C0507a(ImageView imageView, boolean z) {
            this.f5739a = imageView;
            this.b = z;
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onFailedLoad(String str, String str2) {
            if (this.b) {
                this.f5739a.setVisibility(8);
            }
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onSuccessLoad(Bitmap bitmap, String str) {
            try {
                if (bitmap.isRecycled()) {
                    return;
                }
                this.f5739a.setImageBitmap(bitmap);
            } catch (Throwable th) {
                o0.b("OrderCampAdapter", th.getMessage());
            }
        }
    }

    /* JADX INFO: compiled from: OrderCampAdapter.java */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        RelativeLayout f5740a;
        MBRotationView b;
        MBridgeImageView c;
        RoundImageView d;
        TextView e;
        TextView f;
        TextView g;
        TextView h;
        MBridgeLevelLayoutView i;
        ImageView j;
        ImageView k;
        MBCusRoundImageView l;
        MBCusRoundImageView m;
        MBStarLevelLayoutView n;
        MBHeatLevelLayoutView o;
        MBFrameLayout p;

        b() {
        }
    }

    public a(List<CampaignEx> list) {
        this.c = list;
    }

    private void a(int i, ViewGroup viewGroup) {
        List<CampaignEx> list = this.c;
        if (list == null || this.b == null || list.size() == 0) {
            return;
        }
        MBridgeImageView mBridgeImageView = this.b.c;
        if (mBridgeImageView != null) {
            a(mBridgeImageView, this.c.get(i).getImageUrl(), false);
        }
        ImageView imageView = this.b.k;
        if (imageView != null) {
            a(imageView, this.c.get(i).getImageUrl(), false);
        }
        RoundImageView roundImageView = this.b.d;
        if (roundImageView != null) {
            roundImageView.setBorderRadius(25);
            a(this.b.d, this.c.get(i).getIconUrl(), true);
        }
        double rating = this.c.get(i).getRating();
        if (rating <= 0.0d) {
            rating = 5.0d;
        }
        MBridgeLevelLayoutView mBridgeLevelLayoutView = this.b.i;
        if (mBridgeLevelLayoutView != null) {
            mBridgeLevelLayoutView.setRatingAndUser(rating, this.c.get(i).getNumberRating());
            this.b.i.setOrientation(0);
        }
        MBRotationView mBRotationView = this.b.b;
        if (mBRotationView != null) {
            mBRotationView.setWidthRatio(1.0f);
            this.b.b.setHeightRatio(1.0f);
            this.b.b.setAutoscroll(false);
        }
        MBridgeImageView mBridgeImageView2 = this.b.c;
        if (mBridgeImageView2 != null) {
            mBridgeImageView2.setCustomBorder(30, 30, 30, 30, 10, -1728053248);
        }
    }

    private int c(String str) {
        return g0.a(com.mbridge.msdk.foundation.controller.c.m().d().getApplicationContext(), str, "id");
    }

    public int d(String str) {
        return g0.a(com.mbridge.msdk.foundation.controller.c.m().d().getApplicationContext(), str, "layout");
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<CampaignEx> list = this.c;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        return this.c.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List<CampaignEx> list = this.c;
        if (list != null) {
            return list.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) throws Throwable {
        try {
            if (view == null) {
                view = b(i);
            } else {
                this.b = (b) view.getTag();
            }
            a(view);
            if (this.f5738a) {
                b(i, viewGroup);
            } else {
                a(i, viewGroup);
            }
            a(i);
        } catch (Exception e) {
            o0.b("OrderCampAdapter", e.getMessage());
        }
        return view;
    }

    private View b(int i) throws Throwable {
        View viewA;
        String str;
        try {
            List<CampaignEx> list = this.c;
            String cMPTEntryUrl = "";
            if (list != null && list.get(i) != null) {
                str = this.c.get(i).getMof_tplid() + "";
                cMPTEntryUrl = this.c.get(i).getCMPTEntryUrl();
            } else {
                str = "501";
            }
            if (TextUtils.isEmpty(cMPTEntryUrl)) {
                return a();
            }
            int iF = k0.F(com.mbridge.msdk.foundation.controller.c.m().d());
            String strA = x.a(0, str, cMPTEntryUrl);
            if (TextUtils.isEmpty(strA)) {
                return a();
            }
            File file = new File(strA + File.separator + "template_config.json");
            if (file.isFile() && file.exists()) {
                List<String> listA = m0.a(strA, "template_" + str + "_" + iF + "_item");
                if (listA == null) {
                    return a();
                }
                viewA = a(i, listA);
                return this.f5738a ? viewA : a();
            }
            return a();
        } catch (Exception e) {
            o0.b("OrderCampAdapter", e.getMessage());
            viewA = null;
        }
    }

    private View a(int i, List<String> list) {
        int iF = k0.F(com.mbridge.msdk.foundation.controller.c.m().d());
        h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
        View viewCreateDynamicView = DynamicViewCreator.getInstance().createDynamicView(new DyOption.Builder().campaignEx(this.c.get(i)).fileDirs(list).dyAdType(DyAdType.REWARD).orientation(iF).adChoiceLink(t0.a(this.c.get(i))).build());
        if (viewCreateDynamicView != null) {
            this.f5738a = true;
            b bVar = new b();
            this.b = bVar;
            bVar.l = (MBCusRoundImageView) viewCreateDynamicView.findViewById(b("mbridge_lv_iv"));
            this.b.k = (ImageView) viewCreateDynamicView.findViewById(b("mbridge_lv_iv_burl"));
            this.b.m = (MBCusRoundImageView) viewCreateDynamicView.findViewById(b("mbridge_lv_icon_iv"));
            this.b.n = (MBStarLevelLayoutView) viewCreateDynamicView.findViewById(b("mbridge_lv_sv_starlevel"));
            this.b.p = (MBFrameLayout) viewCreateDynamicView.findViewById(b("mbridge_lv_ration"));
            viewCreateDynamicView.setTag(this.b);
        }
        return viewCreateDynamicView;
    }

    private void b(int i, ViewGroup viewGroup) {
        List<CampaignEx> list = this.c;
        if (list == null || this.b == null || list.size() == 0) {
            return;
        }
        MBCusRoundImageView mBCusRoundImageView = this.b.l;
        if (mBCusRoundImageView != null && (mBCusRoundImageView instanceof MBCusRoundImageView)) {
            mBCusRoundImageView.setCustomBorder(30, 30, 30, 30, 10, -1728053248);
            a(this.b.l, this.c.get(i).getImageUrl(), false);
        }
        ImageView imageView = this.b.k;
        if (imageView != null) {
            a(imageView, this.c.get(i).getImageUrl(), false);
        }
        MBCusRoundImageView mBCusRoundImageView2 = this.b.m;
        if (mBCusRoundImageView2 != null && (mBCusRoundImageView2 instanceof MBCusRoundImageView)) {
            mBCusRoundImageView2.setBorder(50, 20, -1);
            a(this.b.m, this.c.get(i).getIconUrl(), true);
        }
        double rating = this.c.get(i).getRating();
        if (rating <= 0.0d) {
            rating = 5.0d;
        }
        MBStarLevelLayoutView mBStarLevelLayoutView = this.b.n;
        if (mBStarLevelLayoutView != null) {
            mBStarLevelLayoutView.setRating((int) rating);
            this.b.n.setOrientation(0);
        }
        MBHeatLevelLayoutView mBHeatLevelLayoutView = this.b.o;
        if (mBHeatLevelLayoutView != null) {
            mBHeatLevelLayoutView.setHeatCount(this.c.get(i).getNumberRating());
        }
    }

    private View a() {
        View viewInflate = LayoutInflater.from(com.mbridge.msdk.foundation.controller.c.m().d()).inflate(d("mbridge_order_layout_item"), (ViewGroup) null);
        b bVar = new b();
        this.b = bVar;
        bVar.c = (MBridgeImageView) viewInflate.findViewById(c("mbridge_lv_iv"));
        this.b.k = (ImageView) viewInflate.findViewById(c("mbridge_lv_iv_burl"));
        this.b.d = (RoundImageView) viewInflate.findViewById(c("mbridge_lv_icon_iv"));
        this.b.i = (MBridgeLevelLayoutView) viewInflate.findViewById(c("mbridge_lv_sv_starlevel"));
        this.b.b = (MBRotationView) viewInflate.findViewById(c("mbridge_lv_ration"));
        viewInflate.setTag(this.b);
        return viewInflate;
    }

    private void a(View view) {
        this.b.f5740a = (RelativeLayout) view.findViewById(a("mbridge_lv_item_rl"));
        this.b.e = (TextView) view.findViewById(a("mbridge_lv_title_tv"));
        this.b.g = (TextView) view.findViewById(a("mbridge_lv_tv_install"));
        this.b.o = (MBHeatLevelLayoutView) view.findViewById(a("mbridge_lv_sv_heat_level"));
        this.b.f = (TextView) view.findViewById(a("mbridge_lv_desc_tv"));
        this.b.j = (ImageView) view.findViewById(a("mbridge_iv_flag"));
        this.b.h = (TextView) view.findViewById(a("mbridge_order_viewed_tv"));
    }

    private void a(ImageView imageView, String str, boolean z) {
        if (imageView == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            com.mbridge.msdk.foundation.same.image.b.a(imageView.getContext()).a(str, new C0507a(imageView, z));
        } else if (z) {
            imageView.setVisibility(8);
        }
    }

    private int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return str.hashCode();
    }

    private void a(int i) {
        b bVar = this.b;
        if (bVar != null) {
            if (bVar.e != null) {
                this.b.e.setText(this.c.get(i).getAppName());
            }
            if (this.b.f != null) {
                this.b.f.setText(this.c.get(i).getAppDesc());
            }
            if (this.b.g != null) {
                String adCall = this.c.get(i).getAdCall();
                if (this.b.g instanceof MBridgeTextView) {
                    ((MBridgeTextView) this.b.g).setObjectAnimator(new com.mbridge.msdk.video.dynview.ui.b().a(this.b.g));
                }
                this.b.g.setText(adCall);
            }
            if (this.b.j != null) {
                try {
                    String language = Locale.getDefault().getLanguage();
                    Context contextD = com.mbridge.msdk.foundation.controller.c.m().d();
                    if (contextD != null) {
                        if (!TextUtils.isEmpty(language) && language.equals("zh")) {
                            this.b.j.setImageDrawable(contextD.getResources().getDrawable(contextD.getResources().getIdentifier("mbridge_reward_flag_cn", "drawable", com.mbridge.msdk.foundation.controller.c.m().h())));
                        } else {
                            this.b.j.setImageDrawable(contextD.getResources().getDrawable(contextD.getResources().getIdentifier("mbridge_reward_flag_en", "drawable", com.mbridge.msdk.foundation.controller.c.m().h())));
                        }
                    }
                } catch (Exception e) {
                    o0.b("OrderCampAdapter", e.getMessage());
                }
                t0.a(2, this.b.j, this.c.get(i), com.mbridge.msdk.foundation.controller.c.m().d(), false, null);
            }
            if (this.b.h != null) {
                try {
                    this.b.h.setText(com.mbridge.msdk.foundation.controller.c.m().d().getResources().getString(com.mbridge.msdk.foundation.controller.c.m().d().getResources().getIdentifier("mbridge_reward_viewed_text_str", "string", com.mbridge.msdk.foundation.controller.c.m().h())));
                    this.b.h.setVisibility(0);
                } catch (Exception e2) {
                    o0.b("OrderCampAdapter", e2.getMessage());
                }
            }
        }
    }

    private int a(String str) {
        if (this.f5738a) {
            return b(str);
        }
        return c(str);
    }
}
