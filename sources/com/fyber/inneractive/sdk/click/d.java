package com.fyber.inneractive.sdk.click;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.network.Z;
import com.fyber.inneractive.sdk.util.AbstractC3254s;
import com.fyber.inneractive.sdk.util.H;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.l0;
import com.fyber.inneractive.sdk.util.m0;
import java.util.List;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: classes13.dex */
public final class d implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1655a = false;

    @Override // com.fyber.inneractive.sdk.click.a
    public final boolean a(Uri uri, r rVar) {
        return "smartlink".equalsIgnoreCase(uri.getScheme()) && !this.f1655a;
    }

    @Override // com.fyber.inneractive.sdk.click.a
    public final void cancel() {
        this.f1655a = true;
    }

    @Override // com.fyber.inneractive.sdk.click.a
    public final b a(Context context, Uri uri, List list) {
        m0 m0Var;
        Uri uri2;
        Uri uri3;
        if (!a(uri, null)) {
            return null;
        }
        PriorityQueue priorityQueue = new PriorityQueue();
        String queryParameter = uri.getQueryParameter("primaryUrl");
        boolean zA = false;
        if (!TextUtils.isEmpty(queryParameter) && AbstractC3254s.a(context, Uri.parse(queryParameter))) {
            List<String> queryParameters = uri.getQueryParameters("primaryTrackingUrl");
            l0 l0Var = l0.Primary;
            try {
                uri3 = Uri.parse(queryParameter);
            } catch (Exception unused) {
                uri3 = null;
            }
            if (uri3 != null) {
                priorityQueue.offer(new m0(l0Var, uri3, queryParameters));
            }
            if (list != null) {
                list.add(new j(uri.toString(), true, q.OPEN_IN_EXTERNAL_APPLICATION, null));
            }
        } else if (list != null) {
            list.add(new j(uri.toString(), false, q.DEEP_LINK, null));
        }
        String queryParameter2 = uri.getQueryParameter("fallbackUrl");
        if (!TextUtils.isEmpty(queryParameter2) && AbstractC3254s.a(context, Uri.parse(queryParameter2))) {
            List<String> queryParameters2 = uri.getQueryParameters("fallbackTrackingUrl");
            l0 l0Var2 = l0.FallBack;
            try {
                uri2 = Uri.parse(queryParameter2);
            } catch (Exception unused2) {
                uri2 = null;
            }
            if (uri2 != null) {
                priorityQueue.offer(new m0(l0Var2, uri2, queryParameters2));
            }
            if (list != null) {
                list.add(new j(queryParameter2, true, q.OPENED_IN_EXTERNAL_BROWSER, null));
            }
        } else if (list != null && queryParameter2 != null) {
            list.add(new j(queryParameter2, false, q.DEEP_LINK, null));
        }
        if (priorityQueue.size() <= 0) {
            return r.a(uri.toString(), "FyberDeepLink", "fyberDeepLink is not valid");
        }
        do {
            m0Var = (m0) priorityQueue.poll();
            if (m0Var == null) {
                break;
            }
        } while (!AbstractC3254s.a(context, m0Var.b));
        if (m0Var != null && (zA = H.a(context, new Intent("android.intent.action.VIEW", m0Var.b)))) {
            for (String str : m0Var.c) {
                if (!TextUtils.isEmpty(str)) {
                    IAlog.d("%s %s", "SMART_LINK", str);
                }
                Z.b(str);
            }
        }
        return zA ? new b(uri.toString(), q.OPEN_IN_EXTERNAL_APPLICATION, "FyberDeepLink", null) : r.a(uri.toString(), "FyberDeepLink", "IADeeplinkUtil.tryHandleDeepLinkWithExternalApp has failed");
    }
}
