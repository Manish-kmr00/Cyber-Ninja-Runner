package com.mbridge.msdk.video.dynview.wrapper;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.foundation.tools.m0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.foundation.tools.x;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ViewOptionWrapper.java */
/* JADX INFO: loaded from: classes12.dex */
public class c {
    public com.mbridge.msdk.video.dynview.c a(Context context, List<CampaignEx> list) throws Throwable {
        String mof_template_url;
        int iA;
        int mof_tplid;
        int dynamicTempCode;
        if (list == null) {
            return null;
        }
        try {
            float fG = t0.g(com.mbridge.msdk.foundation.controller.c.m().d());
            float f = t0.f(com.mbridge.msdk.foundation.controller.c.m().d());
            List<String> arrayList = new ArrayList<>();
            if (list.size() <= 0 || list.get(0) == null) {
                mof_template_url = "";
                iA = 1;
                mof_tplid = 0;
                dynamicTempCode = 0;
            } else {
                iA = com.mbridge.msdk.video.dynview.util.a.a(list.get(0));
                mof_tplid = list.get(0).getMof_tplid();
                mof_template_url = list.get(0).getMof_template_url();
                dynamicTempCode = list.get(0).getDynamicTempCode();
            }
            if (mof_tplid != 0 && !TextUtils.isEmpty(mof_template_url)) {
                arrayList = m0.a(x.a(0, mof_tplid + "", mof_template_url), "template_" + mof_tplid + "_" + iA);
            }
            String str = "mbridge_same_choice_one_layout_portrait";
            if (iA != 1) {
                if (iA == 2) {
                    str = "mbridge_same_choice_one_layout_landscape";
                } else if (com.mbridge.msdk.video.dynview.util.a.a(context)) {
                    str = "mbridge_same_choice_one_layout_landscape";
                    iA = 2;
                } else {
                    iA = 1;
                }
            }
            return com.mbridge.msdk.video.dynview.c.a().a(context).c(str).b(1).b(f).a(fG).a(list).orientation(iA).fileDirs(arrayList).d(dynamicTempCode).a(mof_tplid).build();
        } catch (Exception e) {
            o0.b("ViewOptionWrapper", e.getMessage());
            return null;
        }
    }

    public com.mbridge.msdk.video.dynview.c b(View view, CampaignEx campaignEx) {
        String strE;
        int iF;
        String str;
        if (campaignEx == null) {
            return null;
        }
        try {
            List<String> arrayList = new ArrayList<>();
            String campaignUnitId = campaignEx.getCampaignUnitId();
            if (campaignEx.getRewardTemplateMode() != null) {
                iF = campaignEx.getRewardTemplateMode().f();
                strE = campaignEx.getRewardTemplateMode().e();
            } else {
                strE = "";
                iF = 0;
            }
            int iA = t0.a(strE, "ia_tp", -5);
            if (iF != 0 && iF != 102 && iF != 202) {
                str = "mbridge_reward_layer_floor_" + iF;
            } else {
                str = "mbridge_reward_layer_floor";
            }
            if (!TextUtils.isEmpty(strE)) {
                arrayList = m0.a(x.a(1, iF + "", strE), "template_" + iF);
            }
            boolean zA = com.mbridge.msdk.video.dynview.util.a.a(strE);
            String strA = com.mbridge.msdk.video.dynview.util.a.a(strE, "whs_chn");
            com.mbridge.msdk.videocommon.setting.c cVarA = com.mbridge.msdk.videocommon.setting.b.b().a(com.mbridge.msdk.foundation.controller.c.m().b(), campaignUnitId, false);
            int iD = cVarA != null ? cVarA.D() : 0;
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(campaignEx);
            return com.mbridge.msdk.video.dynview.c.a().c(str).b(2).a(arrayList2).a(view.getContext()).a(view).c(iD).f(iA).orientation(k0.F(view.getContext())).a(iF).a(zA).b(strA).fileDirs(arrayList).d(campaignEx.getDynamicTempCode()).build();
        } catch (Exception e) {
            o0.b("ViewOptionWrapper", e.getMessage());
            return null;
        }
    }

    public com.mbridge.msdk.video.dynview.c b(Context context, List<CampaignEx> list) throws Throwable {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    float fG = t0.g(com.mbridge.msdk.foundation.controller.c.m().d());
                    float f = t0.f(com.mbridge.msdk.foundation.controller.c.m().d());
                    List<String> arrayList = new ArrayList<>();
                    int dynamicTempCode = list.get(0).getDynamicTempCode();
                    int mof_tplid = list.get(0).getMof_tplid();
                    String mof_template_url = list.get(0).getMof_template_url();
                    int iF = k0.F(context);
                    if (mof_tplid != 0 && !TextUtils.isEmpty(mof_template_url)) {
                        arrayList = m0.a(x.a(0, mof_tplid + "", mof_template_url), "template_" + mof_tplid + "_" + iF);
                    }
                    return com.mbridge.msdk.video.dynview.c.a().c(iF == 1 ? "mbridge_order_layout_list_portrait" : "mbridge_order_layout_list_landscape").b(5).a(context).b(f).a(fG).a(list).orientation(iF).fileDirs(arrayList).d(dynamicTempCode).a(mof_tplid).build();
                }
            } catch (Exception e) {
                o0.b("ViewOptionWrapper", e.getMessage());
            }
        }
        return null;
    }

    public com.mbridge.msdk.video.dynview.c a(View view, CampaignEx campaignEx) {
        if (campaignEx == null) {
            return null;
        }
        try {
            com.mbridge.msdk.videocommon.setting.c cVarA = com.mbridge.msdk.videocommon.setting.b.b().a(com.mbridge.msdk.foundation.controller.c.m().b(), campaignEx.getCampaignUnitId(), false);
            int iD = cVarA != null ? cVarA.D() : 0;
            ArrayList arrayList = new ArrayList();
            arrayList.add(campaignEx);
            return com.mbridge.msdk.video.dynview.c.a().c("mbridge_reward_layer_floor_bottom").b(3).a(arrayList).a(view.getContext()).a(view).c(iD).orientation(k0.F(view.getContext())).build();
        } catch (Exception e) {
            o0.b("ViewOptionWrapper", e.getMessage());
            return null;
        }
    }

    public com.mbridge.msdk.video.dynview.c a(Context context, CampaignEx campaignEx, int i, String str) throws Throwable {
        String string;
        String str2;
        if (campaignEx == null) {
            return null;
        }
        try {
            long ecTemplateId = campaignEx.getEcTemplateId();
            int iF = k0.F(context);
            int iA = t0.a(campaignEx.getendcard_url(), "n_logo", 1);
            if (ecTemplateId == 1302) {
                string = (iF == 1 ? new StringBuilder().append("mbridge_reward_end_card_layout_portrait_") : new StringBuilder().append("mbridge_reward_end_card_layout_landscape_")).append(ecTemplateId).toString();
                str2 = "template_" + str + iF + "_" + ecTemplateId;
            } else {
                string = iF == 1 ? "mbridge_reward_end_card_layout_portrait" : "mbridge_reward_end_card_layout_landscape";
                str2 = "template_" + str + iF;
            }
            List<String> arrayList = new ArrayList<>();
            if (!TextUtils.isEmpty(campaignEx.getendcard_url())) {
                arrayList = m0.a(x.a(2, i + "", campaignEx.getendcard_url()), str2);
            }
            return com.mbridge.msdk.video.dynview.c.a().c(string).b(4).a(context).orientation(k0.F(context)).fileDirs(arrayList).d(campaignEx.getDynamicTempCode()).a(i).a(str).e(iA).build();
        } catch (Exception e) {
            o0.b("ViewOptionWrapper", e.getMessage());
            return null;
        }
    }
}
