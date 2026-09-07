package com.mbridge.msdk.interstitial.signalcommon;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.mbridge.msdk.click.c;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.net.wrapper.e;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.interstitial.view.MBInterstitialActivity;
import com.mbridge.msdk.mbsignalcommon.windvane.AbsFeedBackForH5;
import com.mbridge.msdk.mbsignalcommon.windvane.f;
import com.safedk.android.internal.partials.MintegralNetworkBridge;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class interstitial extends AbsFeedBackForH5 {
    private static final String h = "com.mbridge.msdk.interstitial.signalcommon.interstitial";
    public static final /* synthetic */ int i = 0;
    private Object g;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f5108a;
        final /* synthetic */ String b;

        a(List list, String str) {
            this.f5108a = list;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.mbridge.msdk.interstitial.cache.a aVarA = com.mbridge.msdk.interstitial.cache.a.a();
            if (aVarA != null) {
                aVarA.a(this.f5108a, this.b);
            }
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f5109a;

        b(List list) {
            this.f5109a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i = 0; i < this.f5109a.size(); i++) {
                CampaignEx campaignEx = (CampaignEx) this.f5109a.get(i);
                if (campaignEx != null) {
                    j.a(g.a(((com.mbridge.msdk.mbsignalcommon.windvane.g) interstitial.this).f5263a)).b(campaignEx.getId());
                }
            }
        }
    }

    private void b() {
        try {
            Context context = this.f5263a;
            if (context == null) {
                return;
            }
            if (a(context) == 1) {
                try {
                    MBInterstitialActivity mBInterstitialActivity = (MBInterstitialActivity) this.f5263a;
                    if (mBInterstitialActivity != null) {
                        mBInterstitialActivity.hideLoading();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void c() {
        try {
            f.a().b(this.g, "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void d() {
        MBInterstitialActivity mBInterstitialActivity;
        try {
            Context context = this.f5263a;
            if (context == null || a(context) != 1 || (mBInterstitialActivity = (MBInterstitialActivity) this.f5263a) == null) {
                return;
            }
            mBInterstitialActivity.showWebView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getExcludeIdList(String str) {
        Exception e;
        ArrayList arrayList;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String strOptString = MintegralNetworkBridge.jsonObjectInit(str).optString(e.h);
            if (TextUtils.isEmpty(strOptString)) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(strOptString);
            if (jSONArray.length() <= 0) {
                return null;
            }
            arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    if (!TextUtils.isEmpty(jSONArray.optString(i2))) {
                        arrayList.add(jSONArray.optString(i2));
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                }
            }
            return arrayList;
        } catch (Exception e3) {
            e = e3;
            arrayList = null;
        }
        e.printStackTrace();
        return arrayList;
    }

    public void getInfo(Object obj, String str) {
        try {
            this.g = obj;
            Context context = this.f5263a;
            if (context == null) {
                c();
                return;
            }
            int iA = a(context);
            if (TextUtils.isEmpty(a())) {
                c();
            } else if (iA == 1) {
                a(obj, str);
            }
        } catch (Exception e) {
            e.printStackTrace();
            c();
        }
    }

    public void install(Object obj, String str) {
        try {
            Context context = this.f5263a;
            if (context != null && (context instanceof MBInterstitialActivity)) {
                ((MBInterstitialActivity) context).clickTracking();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openURL(Object obj, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObjectJsonObjectInit = MintegralNetworkBridge.jsonObjectInit(str);
            String strOptString = jSONObjectJsonObjectInit.optString("url");
            int iOptInt = jSONObjectJsonObjectInit.optInt("type");
            if (iOptInt == 1) {
                c.c(this.f5263a, strOptString);
            } else if (iOptInt == 2) {
                c.e(this.f5263a, strOptString);
            }
        } catch (JSONException e) {
            o0.b(h, e.getMessage());
        } catch (Throwable th) {
            o0.b(h, th.getMessage());
        }
    }

    private void a(Object obj, String str) {
        try {
            b();
            d();
            Context context = this.f5263a;
            if (context == null) {
                c();
                return;
            }
            if (a(context) != 1) {
                c();
                return;
            }
            Context context2 = this.f5263a;
            if (context2 instanceof MBInterstitialActivity) {
                ((MBInterstitialActivity) context2).mIsMBPage = true;
            }
            String strA = a();
            if (TextUtils.isEmpty(strA)) {
                c();
                return;
            }
            List<CampaignEx> listA = a(strA);
            if (listA == null) {
                c();
                return;
            }
            String strA2 = a(listA);
            if (TextUtils.isEmpty(strA2)) {
                c();
                return;
            }
            f.a().b(obj, strA2);
            a(strA, listA);
            b(strA, listA);
            a(listA, strA);
        } catch (Exception e) {
            e.printStackTrace();
            c();
        }
    }

    private void b(String str, List<CampaignEx> list) {
        try {
            if (!TextUtils.isEmpty(str) && list != null && list.size() != 0) {
                new Thread(new b(list)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<CampaignEx> a(String str) {
        try {
            if (!TextUtils.isEmpty(str) && com.mbridge.msdk.interstitial.cache.a.a() != null) {
                return com.mbridge.msdk.interstitial.cache.a.a().a(str, 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void a(List<CampaignEx> list, String str) {
        try {
            new Thread(new a(list, str)).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String a(List<CampaignEx> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    JSONArray camplistToJson = CampaignEx.parseCamplistToJson(list);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("campaignList", camplistToJson);
                    String string = jSONObject.toString();
                    if (!TextUtils.isEmpty(string)) {
                        return Base64.encodeToString(string.getBytes(), 2);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    private int a(Context context) {
        return (context == null || !(context instanceof MBInterstitialActivity)) ? -1 : 1;
    }

    private String a() {
        MBInterstitialActivity mBInterstitialActivity;
        String str = null;
        try {
            Context context = this.f5263a;
            if (context == null) {
                return null;
            }
            if (a(context) == 1) {
                try {
                    Context context2 = this.f5263a;
                    if (context2 != null && (context2 instanceof MBInterstitialActivity) && (mBInterstitialActivity = (MBInterstitialActivity) context2) != null) {
                        str = mBInterstitialActivity.mUnitid;
                        return str;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return str;
    }

    private void a(String str, List<CampaignEx> list) {
        try {
            if (!TextUtils.isEmpty(str) && list != null && list.size() != 0) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    CampaignEx campaignEx = list.get(i2);
                    if (campaignEx != null) {
                        com.mbridge.msdk.foundation.same.buffer.b.a(str, campaignEx, "interstitial");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
