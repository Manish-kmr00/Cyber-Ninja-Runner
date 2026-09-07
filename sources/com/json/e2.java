package com.json;

import com.json.mediationsdk.IronSource;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.utils.IronSourceConstants;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class e2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f3637a;
    private final IronSource.AD_UNIT b;
    private final b c;
    private d2 d;
    private final s7 e;
    public ki f;
    public zl g;
    public av h;
    public r4 i;
    public n0 j;
    public fv k;
    public vo l;
    private Map<b2, a> m;
    private Map<b2, a> n;
    private Map<b2, a> o;
    private Map<b2, a> p;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f3638a;
        private final int b;

        public a(int i, int i2) {
            this.f3638a = i;
            this.b = i2;
        }

        int a(b bVar) {
            return b.MEDIATION.equals(bVar) ? this.f3638a : this.b;
        }
    }

    public enum b {
        MEDIATION,
        PROVIDER
    }

    public e2(IronSource.AD_UNIT ad_unit, b bVar, d2 d2Var) {
        this(ad_unit, bVar, d2Var, a(ad_unit));
    }

    public e2(IronSource.AD_UNIT ad_unit, b bVar, d2 d2Var, s7 s7Var) {
        this.f3637a = -1;
        this.b = ad_unit;
        this.c = bVar;
        this.d = d2Var;
        this.e = s7Var == null ? a(ad_unit) : s7Var;
        b();
        this.f = new ki(this);
        this.g = new zl(this);
        this.h = new av(this);
        this.i = new r4(this);
        this.j = new n0(this);
        this.k = new fv(this);
        this.l = new vo(this);
    }

    private int a(b2 b2Var) {
        try {
            if (IronSource.AD_UNIT.INTERSTITIAL.equals(this.b) && this.m.containsKey(b2Var)) {
                return this.m.get(b2Var).a(this.c);
            }
            if (IronSource.AD_UNIT.REWARDED_VIDEO.equals(this.b) && this.n.containsKey(b2Var)) {
                return this.n.get(b2Var).a(this.c);
            }
            if (IronSource.AD_UNIT.BANNER.equals(this.b) && this.o.containsKey(b2Var)) {
                return this.o.get(b2Var).a(this.c);
            }
            if (IronSource.AD_UNIT.NATIVE_AD.equals(this.b) && this.p.containsKey(b2Var)) {
                return this.p.get(b2Var).a(this.c);
            }
            return -1;
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return -1;
        }
    }

    private static s7 a(IronSource.AD_UNIT ad_unit) {
        return ad_unit.equals(IronSource.AD_UNIT.REWARDED_VIDEO) ? ar.i() : oj.i();
    }

    private void d() {
        HashMap map = new HashMap();
        this.p = map;
        map.put(b2.INIT_STARTED, new a(IronSourceConstants.NT_MANAGER_INIT_STARTED, -1));
        this.p.put(b2.INIT_ENDED, new a(IronSourceConstants.NT_MANAGER_INIT_ENDED, -1));
        this.p.put(b2.PLACEMENT_CAPPED, new a(IronSourceConstants.NT_PLACEMENT_CAPPED, -1));
        this.p.put(b2.AUCTION_REQUEST, new a(IronSourceConstants.NT_AUCTION_REQUEST, -1));
        this.p.put(b2.AUCTION_SUCCESS, new a(IronSourceConstants.NT_AUCTION_SUCCESS, -1));
        this.p.put(b2.AUCTION_FAILED, new a(IronSourceConstants.NT_AUCTION_FAILED, -1));
        this.p.put(b2.AUCTION_FAILED_NO_CANDIDATES, new a(IronSourceConstants.NT_AUCTION_FAILED, -1));
        this.p.put(b2.AUCTION_REQUEST_WATERFALL, new a(IronSourceConstants.NT_AUCTION_REQUEST_WATERFALL, -1));
        this.p.put(b2.AUCTION_RESULT_WATERFALL, new a(IronSourceConstants.NT_AUCTION_RESPONSE_WATERFALL, -1));
        this.p.put(b2.INIT_SUCCESS, new a(-1, -1));
        this.p.put(b2.INIT_FAILED, new a(-1, -1));
        this.p.put(b2.AD_OPENED, new a(IronSourceConstants.NT_CALLBACK_SHOW, IronSourceConstants.NT_INSTANCE_SHOW));
        this.p.put(b2.AD_CLICKED, new a(IronSourceConstants.NT_CALLBACK_CLICK, IronSourceConstants.NT_INSTANCE_CLICK));
        this.p.put(b2.LOAD_AD, new a(4001, 4002));
        this.p.put(b2.LOAD_AD_SUCCESS, new a(IronSourceConstants.NT_CALLBACK_LOAD_SUCCESS, 4005));
        this.p.put(b2.LOAD_AD_FAILED_WITH_REASON, new a(IronSourceConstants.NT_CALLBACK_LOAD_ERROR, IronSourceConstants.NT_INSTANCE_LOAD_ERROR));
        this.p.put(b2.LOAD_AD_NO_FILL, new a(-1, IronSourceConstants.NT_INSTANCE_LOAD_NO_FILL));
        this.p.put(b2.AD_FORMAT_CAPPED, new a(IronSourceConstants.NT_AD_UNIT_CAPPED, -1));
        this.p.put(b2.COLLECT_TOKEN, new a(IronSourceConstants.NT_COLLECT_TOKENS, IronSourceConstants.NT_INSTANCE_COLLECT_TOKEN));
        this.p.put(b2.COLLECT_TOKENS_COMPLETED, new a(IronSourceConstants.NT_COLLECT_TOKENS_COMPLETED, -1));
        this.p.put(b2.COLLECT_TOKENS_FAILED, new a(IronSourceConstants.NT_COLLECT_TOKENS_FAILED, -1));
        this.p.put(b2.INSTANCE_COLLECT_TOKEN, new a(IronSourceConstants.NT_INSTANCE_COLLECT_TOKEN, -1));
        this.p.put(b2.INSTANCE_COLLECT_TOKEN_SUCCESS, new a(IronSourceConstants.NT_INSTANCE_COLLECT_TOKEN_SUCCESS, IronSourceConstants.NT_INSTANCE_COLLECT_TOKEN_SUCCESS));
        this.p.put(b2.INSTANCE_COLLECT_TOKEN_FAILED, new a(IronSourceConstants.NT_INSTANCE_COLLECT_TOKEN_FAILED, IronSourceConstants.NT_INSTANCE_COLLECT_TOKEN_FAILED));
        this.p.put(b2.INSTANCE_COLLECT_TOKEN_TIMED_OUT, new a(IronSourceConstants.NT_INSTANCE_COLLECT_TOKEN_TIMED_OUT, IronSourceConstants.NT_INSTANCE_COLLECT_TOKEN_TIMED_OUT));
        this.p.put(b2.DESTROY_AD, new a(4100, IronSourceConstants.NT_INSTANCE_DESTROY));
        this.p.put(b2.TROUBLESHOOT_PROVIDER_SETTINGS_MISSING, new a(IronSourceConstants.TROUBLESHOOTING_NT_PROVIDER_SETTINGS_MISSING, IronSourceConstants.TROUBLESHOOTING_NT_PROVIDER_SETTINGS_MISSING));
        this.p.put(b2.TROUBLESHOOT_UNEXPECTED_INIT_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_INIT_SUCCESS, IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_INIT_SUCCESS));
        this.p.put(b2.TROUBLESHOOT_UNEXPECTED_INIT_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_INIT_FAILED, IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_INIT_FAILED));
        this.p.put(b2.TROUBLESHOOT_UNEXPECTED_AUCTION_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_AUCTION_SUCCESS, IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_AUCTION_SUCCESS));
        this.p.put(b2.TROUBLESHOOT_UNEXPECTED_AUCTION_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_AUCTION_FAILED, IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_AUCTION_FAILED));
        this.p.put(b2.TROUBLESHOOT_UNEXPECTED_LOAD_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_LOAD_SUCCESS, IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_LOAD_SUCCESS));
        this.p.put(b2.TROUBLESHOOT_UNEXPECTED_LOAD_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_LOAD_FAILED, IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_LOAD_FAILED));
        this.p.put(b2.TROUBLESHOOT_UNEXPECTED_TIMEOUT, new a(IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_TIMEOUT, IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_TIMEOUT));
        this.p.put(b2.TROUBLESHOOT_UNEXPECTED_OPENED, new a(IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_OPENED, IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_OPENED));
        this.p.put(b2.TROUBLESHOOT_INTERNAL_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_NT_INTERNAL_ERROR, IronSourceConstants.TROUBLESHOOTING_NT_INTERNAL_ERROR));
        this.p.put(b2.TROUBLESHOOT_ADAPTER_REPOSITORY_INTERNAL_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR));
        this.p.put(b2.TROUBLESHOOT_AUCTION_SUCCESSFUL_RECOVERY_ERROR, new a(88002, 88002));
        this.p.put(b2.TROUBLESHOOT_NOTIFICATION_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_NT_NOTIFICATIONS_ERROR, -1));
    }

    void a() {
        HashMap map = new HashMap();
        this.o = map;
        map.put(b2.INIT_STARTED, new a(IronSourceConstants.BN_MANAGER_INIT_STARTED, -1));
        this.o.put(b2.INIT_ENDED, new a(IronSourceConstants.BN_MANAGER_INIT_ENDED, -1));
        this.o.put(b2.PLACEMENT_CAPPED, new a(IronSourceConstants.BN_PLACEMENT_CAPPED, -1));
        this.o.put(b2.AUCTION_REQUEST, new a(IronSourceConstants.BN_AUCTION_REQUEST, -1));
        this.o.put(b2.AUCTION_SUCCESS, new a(IronSourceConstants.BN_AUCTION_SUCCESS, -1));
        this.o.put(b2.AUCTION_FAILED, new a(IronSourceConstants.BN_AUCTION_FAILED, -1));
        this.o.put(b2.AUCTION_FAILED_NO_CANDIDATES, new a(IronSourceConstants.BN_AUCTION_FAILED, -1));
        this.o.put(b2.AUCTION_REQUEST_WATERFALL, new a(IronSourceConstants.BN_AUCTION_REQUEST_WATERFALL, -1));
        this.o.put(b2.AUCTION_RESULT_WATERFALL, new a(IronSourceConstants.BN_AUCTION_RESPONSE_WATERFALL, -1));
        this.o.put(b2.INIT_SUCCESS, new a(-1, -1));
        this.o.put(b2.INIT_FAILED, new a(-1, -1));
        this.o.put(b2.AD_OPENED, new a(IronSourceConstants.BN_CALLBACK_SHOW, 3009));
        this.o.put(b2.AD_CLICKED, new a(IronSourceConstants.BN_CALLBACK_CLICK, 3008));
        this.o.put(b2.LOAD_AD, new a(3001, 3002));
        this.o.put(b2.RELOAD_AD, new a(IronSourceConstants.BN_RELOAD, IronSourceConstants.BN_INSTANCE_RELOAD));
        this.o.put(b2.LOAD_AD_SUCCESS, new a(IronSourceConstants.BN_CALLBACK_LOAD_SUCCESS, 3005));
        this.o.put(b2.RELOAD_AD_SUCCESS, new a(IronSourceConstants.BN_CALLBACK_RELOAD_SUCCESS, IronSourceConstants.BN_INSTANCE_RELOAD_SUCCESS));
        this.o.put(b2.LOAD_AD_FAILED_WITH_REASON, new a(IronSourceConstants.BN_CALLBACK_LOAD_ERROR, 3300));
        this.o.put(b2.RELOAD_AD_FAILED_WITH_REASON, new a(3201, IronSourceConstants.BN_INSTANCE_RELOAD_ERROR));
        this.o.put(b2.LOAD_AD_NO_FILL, new a(-1, 3306));
        this.o.put(b2.RELOAD_AD_NO_FILL, new a(-1, IronSourceConstants.BN_INSTANCE_RELOAD_NO_FILL));
        this.o.put(b2.AD_FORMAT_CAPPED, new a(IronSourceConstants.BN_AD_UNIT_CAPPED, -1));
        this.o.put(b2.COLLECT_TOKEN, new a(IronSourceConstants.BN_COLLECT_TOKENS, -1));
        this.o.put(b2.COLLECT_TOKENS_COMPLETED, new a(IronSourceConstants.BN_COLLECT_TOKENS_COMPLETED, -1));
        this.o.put(b2.COLLECT_TOKENS_FAILED, new a(IronSourceConstants.BN_COLLECT_TOKENS_FAILED, -1));
        this.o.put(b2.INSTANCE_COLLECT_TOKEN, new a(IronSourceConstants.BN_INSTANCE_COLLECT_TOKEN, -1));
        this.o.put(b2.INSTANCE_COLLECT_TOKEN_SUCCESS, new a(IronSourceConstants.BN_INSTANCE_COLLECT_TOKEN_SUCCESS, IronSourceConstants.BN_INSTANCE_COLLECT_TOKEN_SUCCESS));
        this.o.put(b2.INSTANCE_COLLECT_TOKEN_FAILED, new a(IronSourceConstants.BN_INSTANCE_COLLECT_TOKEN_FAILED, IronSourceConstants.BN_INSTANCE_COLLECT_TOKEN_FAILED));
        this.o.put(b2.INSTANCE_COLLECT_TOKEN_TIMED_OUT, new a(IronSourceConstants.BN_INSTANCE_COLLECT_TOKEN_TIMED_OUT, IronSourceConstants.BN_INSTANCE_COLLECT_TOKEN_TIMED_OUT));
        this.o.put(b2.DESTROY_AD, new a(3100, 3305));
        this.o.put(b2.SKIP_RELOAD_AD, new a(3200, -1));
        this.o.put(b2.AD_LEFT_APPLICATION, new a(IronSourceConstants.BN_CALLBACK_LEAVE_APP, 3304));
        this.o.put(b2.AD_PRESENT_SCREEN, new a(IronSourceConstants.BN_CALLBACK_PRESENT_SCREEN, IronSourceConstants.BN_INSTANCE_PRESENT_SCREEN));
        this.o.put(b2.AD_DISMISS_SCREEN, new a(IronSourceConstants.BN_CALLBACK_DISMISS_SCREEN, IronSourceConstants.BN_INSTANCE_DISMISS_SCREEN));
        this.o.put(b2.AD_VIEW_BOUND, new a(3204, IronSourceConstants.BN_INSTANCE_BOUND));
        this.o.put(b2.PAUSE_AD, new a(IronSourceConstants.BN_REFRESH_PAUSE, -1));
        this.o.put(b2.RESUME_AD, new a(IronSourceConstants.BN_REFRESH_RESUME, -1));
        this.o.put(b2.TROUBLESHOOT_PROVIDER_SETTINGS_MISSING, new a(IronSourceConstants.TROUBLESHOOTING_BN_PROVIDER_SETTINGS_MISSING, IronSourceConstants.TROUBLESHOOTING_BN_PROVIDER_SETTINGS_MISSING));
        this.o.put(b2.TROUBLESHOOT_UNEXPECTED_INIT_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_INIT_SUCCESS, IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_INIT_SUCCESS));
        this.o.put(b2.TROUBLESHOOT_UNEXPECTED_INIT_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_INIT_FAILED, IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_INIT_FAILED));
        this.o.put(b2.TROUBLESHOOT_UNEXPECTED_AUCTION_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_AUCTION_SUCCESS, IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_AUCTION_SUCCESS));
        this.o.put(b2.TROUBLESHOOT_UNEXPECTED_AUCTION_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_AUCTION_FAILED, IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_AUCTION_FAILED));
        this.o.put(b2.TROUBLESHOOT_UNEXPECTED_LOAD_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_LOAD_SUCCESS, IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_LOAD_SUCCESS));
        this.o.put(b2.TROUBLESHOOT_UNEXPECTED_LOAD_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_LOAD_FAILED, IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_LOAD_FAILED));
        this.o.put(b2.TROUBLESHOOT_UNEXPECTED_RELOAD_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_RELOAD_SUCCESS, IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_RELOAD_SUCCESS));
        this.o.put(b2.TROUBLESHOOT_UNEXPECTED_RELOAD_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_RELOAD_FAILED, IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_RELOAD_FAILED));
        this.o.put(b2.TROUBLESHOOT_UNEXPECTED_TIMEOUT, new a(IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_TIMEOUT, IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_TIMEOUT));
        this.o.put(b2.TROUBLESHOOT_UNEXPECTED_OPENED, new a(IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_OPENED, IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_OPENED));
        this.o.put(b2.TROUBLESHOOT_INTERNAL_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_BN_INTERNAL_ERROR, IronSourceConstants.TROUBLESHOOTING_BN_INTERNAL_ERROR));
        this.o.put(b2.TROUBLESHOOT_ADAPTER_REPOSITORY_INTERNAL_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR));
        this.o.put(b2.TROUBLESHOOT_AUCTION_SUCCESSFUL_RECOVERY_ERROR, new a(88002, 88002));
        this.o.put(b2.TROUBLESHOOT_NOTIFICATION_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_BN_NOTIFICATIONS_ERROR, -1));
        this.o.put(b2.TROUBLESHOOT_BN_RELOAD_EXCEPTION, new a(IronSourceConstants.TROUBLESHOOTING_BN_RELOAD_EXCEPTION, -1));
        this.o.put(b2.TROUBLESHOOT_IMPRESSION_TIMEOUT, new a(IronSourceConstants.TROUBLESHOOTING_BN_IMPRESSION_TIMEOUT_REACHED, -1));
        this.o.put(b2.TROUBLESHOOT_BANNER_REFRESH_PAUSED, new a(IronSourceConstants.TROUBLESHOOT_BN_BANNER_REFRESH_PAUSED, -1));
        this.o.put(b2.TROUBLESHOOT_BANNER_REFRESH_RESUMED, new a(IronSourceConstants.TROUBLESHOOT_BN_BANNER_REFRESH_RESUMED, -1));
        this.o.put(b2.TROUBLESHOOT_BANNER_REFRESH_TRIGGER_PAUSE, new a(IronSourceConstants.TROUBLESHOOT_BN_BANNER_REFRESH_TRIGGER_PAUSE, -1));
        this.o.put(b2.TROUBLESHOOT_BANNER_REFRESH_TRIGGER_RESUME, new a(IronSourceConstants.TROUBLESHOOT_BN_BANNER_REFRESH_TRIGGER_RESUME, -1));
        this.o.put(b2.TROUBLESHOOT_BANNER_REFRESH_TRANSITION, new a(IronSourceConstants.TROUBLESHOOT_BN_BANNER_REFRESH_TRANSITION, IronSourceConstants.TROUBLESHOOT_BN_BANNER_REFRESH_TRANSITION));
        this.o.put(b2.TROUBLESHOOT_BANNER_REFRESH_ANIMATED, new a(IronSourceConstants.TROUBLESHOOT_BN_BANNER_REFRESH_ANIMATED, IronSourceConstants.TROUBLESHOOT_BN_BANNER_REFRESH_ANIMATED));
    }

    protected void a(b2 b2Var, Map<String, Object> map) {
        a(b2Var, map, Calendar.getInstance().getTimeInMillis());
    }

    public void a(b2 b2Var, Map<String, Object> map, long j) {
        int iA = a(b2Var);
        if (-1 == iA) {
            return;
        }
        HashMap map2 = new HashMap();
        d2 d2Var = this.d;
        if (d2Var != null) {
            map2.putAll(d2Var.a(b2Var));
        }
        if (map != null && !map.isEmpty()) {
            map2.putAll(map);
        }
        this.e.a(new zb(iA, j, new JSONObject(map2)));
    }

    void b() {
        c();
        e();
        a();
        d();
    }

    void c() {
        HashMap map = new HashMap();
        this.m = map;
        map.put(b2.INIT_STARTED, new a(IronSourceConstants.IS_MANAGER_INIT_STARTED, -1));
        this.m.put(b2.INIT_ENDED, new a(IronSourceConstants.IS_MANAGER_INIT_ENDED, -1));
        this.m.put(b2.SESSION_CAPPED, new a(-1, IronSourceConstants.IS_CAP_SESSION));
        this.m.put(b2.PLACEMENT_CAPPED, new a(IronSourceConstants.IS_CAP_PLACEMENT, -1));
        this.m.put(b2.CHECK_PLACEMENT_CAPPED, new a(2104, -1));
        this.m.put(b2.AUCTION_REQUEST, new a(2000, -1));
        this.m.put(b2.AUCTION_SUCCESS, new a(2301, -1));
        this.m.put(b2.AUCTION_FAILED, new a(2300, -1));
        this.m.put(b2.AUCTION_FAILED_NO_CANDIDATES, new a(2300, -1));
        this.m.put(b2.AUCTION_REQUEST_WATERFALL, new a(IronSourceConstants.IS_AUCTION_REQUEST_WATERFALL, -1));
        this.m.put(b2.AUCTION_RESULT_WATERFALL, new a(IronSourceConstants.IS_RESULT_WATERFALL, -1));
        this.m.put(b2.INIT_SUCCESS, new a(-1, -1));
        this.m.put(b2.INIT_FAILED, new a(-1, -1));
        this.m.put(b2.SHOW_AD_SUCCESS, new a(IronSourceConstants.IS_CALLBACK_AD_DISPLAYED, 2202));
        this.m.put(b2.AD_OPENED, new a(-1, 2005));
        this.m.put(b2.AD_CLOSED, new a(IronSourceConstants.IS_CALLBACK_AD_CLOSED, 2204));
        this.m.put(b2.AD_CLICKED, new a(IronSourceConstants.IS_CALLBACK_AD_CLICKED, 2006));
        this.m.put(b2.AD_INFO_CHANGED, new a(IronSourceConstants.IS_CALLBACK_AD_INFO_CHANGED, -1));
        this.m.put(b2.LOAD_AD, new a(2001, 2002));
        this.m.put(b2.LOAD_AD_SUCCESS, new a(2004, 2003));
        this.m.put(b2.LOAD_AD_FAILED_WITH_REASON, new a(2110, 2200));
        this.m.put(b2.LOAD_AD_NO_FILL, new a(-1, 2213));
        this.m.put(b2.SHOW_AD, new a(2100, 2201));
        this.m.put(b2.SHOW_AD_FAILED, new a(IronSourceConstants.IS_CALLBACK_AD_SHOW_ERROR, 2203));
        this.m.put(b2.AD_FORMAT_CAPPED, new a(2303, -1));
        this.m.put(b2.AD_UNIT_CAPPED, new a(IronSourceConstants.IS_AD_UNIT_CAPPED, -1));
        this.m.put(b2.COLLECT_TOKEN, new a(IronSourceConstants.IS_COLLECT_TOKENS, -1));
        this.m.put(b2.COLLECT_TOKENS_COMPLETED, new a(IronSourceConstants.IS_COLLECT_TOKENS_COMPLETED, -1));
        this.m.put(b2.COLLECT_TOKENS_FAILED, new a(IronSourceConstants.IS_COLLECT_TOKENS_FAILED, -1));
        this.m.put(b2.INSTANCE_COLLECT_TOKEN, new a(2020, -1));
        this.m.put(b2.INSTANCE_COLLECT_TOKEN_SUCCESS, new a(IronSourceConstants.IS_INSTANCE_COLLECT_TOKEN_SUCCESS, -1));
        this.m.put(b2.INSTANCE_COLLECT_TOKEN_FAILED, new a(IronSourceConstants.IS_INSTANCE_COLLECT_TOKEN_FAILED, -1));
        this.m.put(b2.INSTANCE_COLLECT_TOKEN_TIMED_OUT, new a(IronSourceConstants.IS_INSTANCE_COLLECT_TOKEN_TIMED_OUT, -1));
        this.m.put(b2.AD_READY_TRUE, new a(2101, -1));
        this.m.put(b2.AD_READY_FALSE, new a(2102, -1));
        this.m.put(b2.OPERATIONAL_LOAD_AD, new a(IronSourceConstants.IS_OPERATIONAL_LOAD_AD, -1));
        this.m.put(b2.OPERATIONAL_LOAD_SUCCESS, new a(IronSourceConstants.IS_OPERATIONAL_LOAD_SUCCESS, -1));
        this.m.put(b2.OPERATIONAL_LOAD_FAILED, new a(IronSourceConstants.IS_OPERATIONAL_LOAD_FAILED, -1));
        this.m.put(b2.TROUBLESHOOT_PROVIDER_SETTINGS_MISSING, new a(IronSourceConstants.TROUBLESHOOTING_IS_PROVIDER_SETTINGS_MISSING, IronSourceConstants.TROUBLESHOOTING_IS_PROVIDER_SETTINGS_MISSING));
        this.m.put(b2.TROUBLESHOOT_UNEXPECTED_INIT_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_INIT_SUCCESS, IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_INIT_SUCCESS));
        this.m.put(b2.TROUBLESHOOT_UNEXPECTED_INIT_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_INIT_FAILED, IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_INIT_FAILED));
        this.m.put(b2.TROUBLESHOOT_UNEXPECTED_AUCTION_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_AUCTION_SUCCESS, IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_AUCTION_SUCCESS));
        this.m.put(b2.TROUBLESHOOT_UNEXPECTED_AUCTION_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_AUCTION_FAILED, IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_AUCTION_FAILED));
        this.m.put(b2.TROUBLESHOOT_UNEXPECTED_LOAD_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_LOAD_SUCCESS, IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_LOAD_SUCCESS));
        this.m.put(b2.TROUBLESHOOT_UNEXPECTED_LOAD_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_LOAD_FAILED, IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_LOAD_FAILED));
        this.m.put(b2.TROUBLESHOOT_UNEXPECTED_SHOW_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_SHOW_FAILED, IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_SHOW_FAILED));
        this.m.put(b2.TROUBLESHOOT_UNEXPECTED_CLOSED, new a(IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_CLOSED, IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_CLOSED));
        this.m.put(b2.TROUBLESHOOT_UNEXPECTED_TIMEOUT, new a(IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_TIMEOUT, IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_TIMEOUT));
        this.m.put(b2.TROUBLESHOOT_INTERNAL_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_IS_INTERNAL_ERROR, IronSourceConstants.TROUBLESHOOTING_IS_INTERNAL_ERROR));
        this.m.put(b2.TROUBLESHOOT_ADAPTER_REPOSITORY_INTERNAL_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR));
        this.m.put(b2.TROUBLESHOOT_AUCTION_SUCCESSFUL_RECOVERY_ERROR, new a(88002, 88002));
        this.m.put(b2.TROUBLESHOOT_NOTIFICATION_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_IS_NOTIFICATIONS_ERROR, -1));
        this.m.put(b2.TROUBLESHOOT_AD_EXPIRED, new a(IronSourceConstants.TROUBLESHOOTING_IS_AD_EXPIRED, IronSourceConstants.TROUBLESHOOTING_IS_AD_EXPIRED));
        this.m.put(b2.TROUBLESHOOT_LOAD, new a(IronSourceConstants.TROUBLESHOOTING_IS_LOAD, -1));
        this.m.put(b2.TROUBLESHOOT_LOAD_WHILE_LOADED, new a(IronSourceConstants.TROUBLESHOOTING_IS_LOAD_WHILE_LOADED, -1));
        this.m.put(b2.TROUBLESHOOT_LOAD_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_IS_LOAD_SUCCESS, -1));
        this.m.put(b2.TROUBLESHOOT_LOAD_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_IS_LOAD_FAILED, -1));
        this.m.put(b2.TROUBLESHOOT_SHOW, new a(IronSourceConstants.TROUBLESHOOTING_IS_SHOW, -1));
        this.m.put(b2.TROUBLESHOOT_SHOW_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_IS_SHOW_SUCCESS, -1));
        this.m.put(b2.TROUBLESHOOT_SHOW_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_IS_SHOW_FAILED, -1));
        this.m.put(b2.TROUBLESHOOT_ILLEGAL_STATE, new a(IronSourceConstants.TROUBLESHOOTING_IS_ILLEGAL_STATE, -1));
        this.m.put(b2.TROUBLESHOOT_AD_INFO_CHANGED, new a(IronSourceConstants.TROUBLESHOOT_IS_AD_INFO_CHANGED, -1));
        this.m.put(b2.TROUBLESHOOT_DISPOSE, new a(IronSourceConstants.TROUBLESHOOTING_IS_DISPOSE, -1));
    }

    void e() {
        HashMap map = new HashMap();
        this.n = map;
        map.put(b2.INIT_STARTED, new a(IronSourceConstants.RV_MANAGER_INIT_STARTED, -1));
        this.n.put(b2.INIT_ENDED, new a(IronSourceConstants.RV_MANAGER_INIT_ENDED, -1));
        this.n.put(b2.SESSION_CAPPED, new a(-1, IronSourceConstants.RV_CAP_SESSION));
        this.n.put(b2.PLACEMENT_CAPPED, new a(IronSourceConstants.RV_CAP_PLACEMENT, -1));
        this.n.put(b2.CHECK_PLACEMENT_CAPPED, new a(IronSourceConstants.RV_CHECK_PLACEMENT_CAPPED, -1));
        this.n.put(b2.AUCTION_REQUEST, new a(IronSourceConstants.RV_AUCTION_REQUEST, -1));
        this.n.put(b2.AUCTION_SUCCESS, new a(IronSourceConstants.RV_AUCTION_SUCCESS, -1));
        this.n.put(b2.AUCTION_FAILED, new a(1301, -1));
        this.n.put(b2.AUCTION_FAILED_NO_CANDIDATES, new a(1301, -1));
        this.n.put(b2.AUCTION_REQUEST_WATERFALL, new a(IronSourceConstants.RV_AUCTION_REQUEST_WATERFALL, -1));
        this.n.put(b2.AUCTION_RESULT_WATERFALL, new a(IronSourceConstants.RV_AUCTION_RESPONSE_WATERFALL, -1));
        this.n.put(b2.INIT_SUCCESS, new a(-1, -1));
        this.n.put(b2.INIT_FAILED, new a(-1, -1));
        this.n.put(b2.AD_VISIBLE, new a(-1, 1206));
        this.n.put(b2.SHOW_AD_SUCCESS, new a(IronSourceConstants.RV_CALLBACK_AD_DISPLAYED, -1));
        this.n.put(b2.AD_OPENED, new a(-1, 1005));
        this.n.put(b2.AD_CLOSED, new a(-1, 1203));
        this.n.put(b2.AD_STARTED, new a(-1, IronSourceConstants.RV_INSTANCE_STARTED));
        this.n.put(b2.AD_ENDED, new a(-1, IronSourceConstants.RV_INSTANCE_ENDED));
        this.n.put(b2.AD_CLICKED, new a(IronSourceConstants.RV_CALLBACK_AD_CLICKED, 1006));
        this.n.put(b2.AD_INFO_CHANGED, new a(IronSourceConstants.RV_CALLBACK_AD_INFO_CHANGED, -1));
        this.n.put(b2.AD_REWARDED, new a(-1, 1010));
        this.n.put(b2.AD_AVAILABILITY_CHANGED_TRUE, new a(IronSourceConstants.RV_CALLBACK_AVAILABILITY_TRUE, IronSourceConstants.RV_INSTANCE_AVAILABILITY_TRUE));
        this.n.put(b2.AD_AVAILABILITY_CHANGED_FALSE, new a(IronSourceConstants.RV_CALLBACK_AVAILABILITY_FALSE, IronSourceConstants.RV_INSTANCE_AVAILABILITY_FALSE));
        this.n.put(b2.LOAD_AD, new a(1000, 1001));
        this.n.put(b2.LOAD_AD_SUCCESS, new a(1003, 1002));
        this.n.put(b2.LOAD_AD_FAILED, new a(-1, 1200));
        this.n.put(b2.LOAD_AD_FAILED_WITH_REASON, new a(IronSourceConstants.RV_MEDIATION_LOAD_ERROR, IronSourceConstants.RV_INSTANCE_LOAD_FAILED_REASON));
        this.n.put(b2.LOAD_AD_NO_FILL, new a(-1, 1213));
        this.n.put(b2.SHOW_AD, new a(1100, 1201));
        this.n.put(b2.SHOW_AD_CHANCE, new a(-1, IronSourceConstants.RV_INSTANCE_SHOW_CHANCE));
        this.n.put(b2.SHOW_AD_FAILED, new a(IronSourceConstants.RV_CALLBACK_SHOW_FAILED, 1202));
        this.n.put(b2.AD_FORMAT_CAPPED, new a(IronSourceConstants.RV_AD_UNIT_CAPPED, -1));
        this.n.put(b2.COLLECT_TOKEN, new a(IronSourceConstants.RV_COLLECT_TOKENS, -1));
        this.n.put(b2.COLLECT_TOKENS_COMPLETED, new a(IronSourceConstants.RV_COLLECT_TOKENS_COMPLETED, -1));
        this.n.put(b2.COLLECT_TOKENS_FAILED, new a(IronSourceConstants.RV_COLLECT_TOKENS_FAILED, -1));
        this.n.put(b2.INSTANCE_COLLECT_TOKEN, new a(1020, -1));
        this.n.put(b2.INSTANCE_COLLECT_TOKEN_SUCCESS, new a(1021, 1021));
        this.n.put(b2.INSTANCE_COLLECT_TOKEN_FAILED, new a(1022, 1022));
        this.n.put(b2.INSTANCE_COLLECT_TOKEN_TIMED_OUT, new a(1023, 1023));
        this.n.put(b2.AD_READY_TRUE, new a(IronSourceConstants.RV_CHECK_READY_TRUE, -1));
        this.n.put(b2.AD_READY_FALSE, new a(IronSourceConstants.RV_CHECK_READY_FALSE, -1));
        this.n.put(b2.OPERATIONAL_LOAD_AD, new a(IronSourceConstants.RV_OPERATIONAL_LOAD_AD, -1));
        this.n.put(b2.OPERATIONAL_LOAD_SUCCESS, new a(IronSourceConstants.RV_OPERATIONAL_LOAD_SUCCESS, -1));
        this.n.put(b2.OPERATIONAL_LOAD_FAILED, new a(IronSourceConstants.RV_OPERATIONAL_LOAD_FAILED, -1));
        this.n.put(b2.TROUBLESHOOT_PROVIDER_SETTINGS_MISSING, new a(IronSourceConstants.TROUBLESHOOTING_RV_PROVIDER_SETTINGS_MISSING, IronSourceConstants.TROUBLESHOOTING_RV_PROVIDER_SETTINGS_MISSING));
        this.n.put(b2.TROUBLESHOOT_UNEXPECTED_INIT_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_INIT_SUCCESS, IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_INIT_SUCCESS));
        this.n.put(b2.TROUBLESHOOT_UNEXPECTED_INIT_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_INIT_FAILED, IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_INIT_FAILED));
        this.n.put(b2.TROUBLESHOOT_UNEXPECTED_AUCTION_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_AUCTION_SUCCESS, IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_AUCTION_SUCCESS));
        this.n.put(b2.TROUBLESHOOT_UNEXPECTED_AUCTION_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_AUCTION_FAILED, IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_AUCTION_FAILED));
        this.n.put(b2.TROUBLESHOOT_UNEXPECTED_LOAD_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_LOAD_SUCCESS, IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_LOAD_SUCCESS));
        this.n.put(b2.TROUBLESHOOT_UNEXPECTED_LOAD_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_LOAD_FAILED, IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_LOAD_FAILED));
        this.n.put(b2.TROUBLESHOOT_UNEXPECTED_SHOW_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_SHOW_FAILED, IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_SHOW_FAILED));
        this.n.put(b2.TROUBLESHOOT_UNEXPECTED_TIMEOUT, new a(IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_TIMEOUT, IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_TIMEOUT));
        this.n.put(b2.TROUBLESHOOT_UNEXPECTED_CLOSED, new a(IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_CLOSED, IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_CLOSED));
        this.n.put(b2.TROUBLESHOOT_LOAD_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_RV_LOAD_FAILED, IronSourceConstants.TROUBLESHOOTING_RV_LOAD_FAILED));
        this.n.put(b2.TROUBLESHOOT_INTERNAL_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_RV_INTERNAL_ERROR, IronSourceConstants.TROUBLESHOOTING_RV_INTERNAL_ERROR));
        this.n.put(b2.TROUBLESHOOT_ADAPTER_REPOSITORY_INTERNAL_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR));
        this.n.put(b2.TROUBLESHOOT_WATERFALL_OVERHEAD, new a(IronSourceConstants.TROUBLESHOOTING_RV_WATERFALL_OVERHEAD, IronSourceConstants.TROUBLESHOOTING_RV_WATERFALL_OVERHEAD));
        this.n.put(b2.TROUBLESHOOT_NOTIFICATION_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_RV_NOTIFICATIONS_ERROR, -1));
        this.n.put(b2.TROUBLESHOOT_AD_EXPIRED, new a(IronSourceConstants.TROUBLESHOOTING_RV_AD_EXPIRED, IronSourceConstants.TROUBLESHOOTING_RV_AD_EXPIRED));
        this.n.put(b2.TROUBLESHOOT_LOAD, new a(IronSourceConstants.TROUBLESHOOTING_RV_LOAD, -1));
        this.n.put(b2.TROUBLESHOOT_LOAD_WHILE_LOADED, new a(IronSourceConstants.TROUBLESHOOTING_RV_LOAD_WHILE_LOADED, -1));
        this.n.put(b2.TROUBLESHOOT_LOAD_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_RV_LOAD_SUCCESS, -1));
        this.n.put(b2.TROUBLESHOOT_SHOW, new a(IronSourceConstants.TROUBLESHOOTING_RV_SHOW, -1));
        this.n.put(b2.TROUBLESHOOT_SHOW_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_RV_SHOW_SUCCESS, -1));
        this.n.put(b2.TROUBLESHOOT_SHOW_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_RV_SHOW_FAILED, -1));
        this.n.put(b2.TROUBLESHOOT_ILLEGAL_STATE, new a(IronSourceConstants.TROUBLESHOOTING_RV_ILLEGAL_STATE, -1));
        this.n.put(b2.TROUBLESHOOT_AD_INFO_CHANGED, new a(IronSourceConstants.TROUBLESHOOT_RV_AD_INFO_CHANGED, -1));
        this.n.put(b2.TROUBLESHOOT_DISPOSE, new a(IronSourceConstants.TROUBLESHOOTING_RV_DISPOSE, -1));
    }

    public void f() {
        this.d = null;
        this.h = null;
        this.i = null;
        this.f = null;
        this.g = null;
        this.j = null;
        this.k = null;
        this.l = null;
    }
}
