package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.yandex.mobile.ads.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class hx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9144a;
    private final bz0 b;
    private final pz0 c;

    public hx(Context context, bz0 versionValidator, pz0 networkErrorMapper) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(versionValidator, "versionValidator");
        Intrinsics.checkNotNullParameter(networkErrorMapper, "networkErrorMapper");
        this.f9144a = context;
        this.b = versionValidator;
        this.c = networkErrorMapper;
    }

    private final void a(List<fy> list, ow owVar) {
        yx yxVar;
        int i;
        if (owVar.a() instanceof ow.a.c) {
            String string = this.f9144a.getString(R.string.not_integrated);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            yxVar = new yx(string, 0, null, 0, 14);
        } else {
            String strF = owVar.f();
            if (strF != null && !StringsKt.isBlank(strF)) {
                String lowerCase = owVar.f().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                yxVar = new yx("SDK " + lowerCase, 0, null, 0, 14);
            } else {
                String string2 = this.f9144a.getString(R.string.sdk_undefined);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                yxVar = new yx(string2, 0, null, 0, 14);
            }
        }
        yx yxVar2 = yxVar;
        ow.a aVarA = owVar.a();
        ow.a.b bVar = aVarA instanceof ow.a.b ? (ow.a.b) aVarA : null;
        oz0 oz0VarA = bVar != null ? bVar.a() : null;
        StringBuilder sb = new StringBuilder();
        if (owVar.b() != null) {
            sb.append("Adapter " + owVar.b() + "  ");
        }
        if (owVar.c() != null) {
            sb.append("Latest " + owVar.c());
        }
        String string3 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
        String strB = owVar.b();
        if (strB != null && !StringsKt.isBlank(strB) && !this.b.a(owVar.b(), owVar.c())) {
            i = R.attr.debug_panel_color_orange;
        } else {
            i = R.attr.debug_panel_label_secondary;
        }
        list.add(new fy.g(owVar.e(), owVar.d(), yxVar2, new ww(string3, i), this.c.a(oz0VarA), null, null, null, null, null, owVar.f(), 992));
    }

    private final yx a(Boolean bool) {
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            String string = this.f9144a.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return new yx(string, 0, null, 0, 14);
        }
        if (Intrinsics.areEqual(bool, Boolean.FALSE)) {
            String string2 = this.f9144a.getString(R.string.no);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return new yx(string2, 0, null, 0, 14);
        }
        if (bool == null) {
            String string3 = this.f9144a.getString(R.string.no_value_set);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            return new yx(string3, 0, null, 0, 14);
        }
        throw new NoWhenBranchMatchedException();
    }

    public final List<fy> a(fx debugPanelData) {
        yx yxVar;
        int iA;
        yx yxVar2;
        Intrinsics.checkNotNullParameter(debugPanelData, "debugPanelData");
        List<fy> listCreateListBuilder = CollectionsKt.createListBuilder();
        uw uwVarC = debugPanelData.c();
        fy.d dVar = fy.d.f8946a;
        listCreateListBuilder.add(dVar);
        String string = this.f9144a.getString(R.string.application_info);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        listCreateListBuilder.add(new fy.e(string));
        listCreateListBuilder.add(new fy.f("Application ID", uwVarC.b()));
        String string2 = this.f9144a.getString(R.string.app_version);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        listCreateListBuilder.add(new fy.f(string2, uwVarC.c()));
        String string3 = this.f9144a.getString(R.string.system);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        listCreateListBuilder.add(new fy.f(string3, uwVarC.d()));
        String string4 = this.f9144a.getString(R.string.api_level);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        listCreateListBuilder.add(new fy.f(string4, uwVarC.a()));
        wx wxVarF = debugPanelData.f();
        listCreateListBuilder.add(dVar);
        String string5 = this.f9144a.getString(R.string.sdk_integration);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        listCreateListBuilder.add(new fy.e(string5));
        String string6 = this.f9144a.getString(R.string.ads_sdk_version);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
        listCreateListBuilder.add(new fy.f(string6, wxVarF.b()));
        int iOrdinal = wxVarF.a().b().ordinal();
        if (iOrdinal == 0) {
            String string7 = this.f9144a.getString(R.string.integrated);
            Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
            yxVar = new yx(string7, R.attr.debug_panel_color_green, Integer.valueOf(R.drawable.debug_panel_icon_success), 0, 8);
        } else if (iOrdinal != 1) {
            if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            String string8 = this.f9144a.getString(R.string.integration_errors);
            Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
            yxVar = new yx(string8, R.attr.debug_panel_color_red, Integer.valueOf(R.drawable.debug_panel_icon_error), 0, 8);
        } else {
            String string9 = this.f9144a.getString(R.string.integrated);
            Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
            yxVar = new yx(string9, R.attr.debug_panel_color_red, Integer.valueOf(R.drawable.debug_panel_icon_error), 0, 8);
        }
        if (wxVarF.a().b() == xx.a.b) {
            iA = R.attr.debug_panel_label_primary;
        } else {
            iA = yxVar.a();
        }
        List<String> listA = wxVarF.a().a();
        listCreateListBuilder.add(new fy.f(this.f9144a.getString(R.string.sdk_integration_status), yxVar, listA != null ? new ww(iA, R.style.DebugPanelText_Body2, CollectionsKt.joinToString$default(listA, "\n", null, null, 0, null, null, 62, null)) : null));
        dw dwVarA = debugPanelData.a();
        if (dwVarA.c() != null || dwVarA.a() != null || dwVarA.b() != null) {
            listCreateListBuilder.add(dVar);
            String string10 = this.f9144a.getString(R.string.advertisement_network_settings);
            Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
            listCreateListBuilder.add(new fy.e(string10));
            String strC = dwVarA.c();
            if (strC != null) {
                listCreateListBuilder.add(new fy.f("Page ID", strC));
            }
            String strB = dwVarA.b();
            if (strB != null) {
                String string11 = this.f9144a.getString(R.string.app_review_status);
                Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
                listCreateListBuilder.add(new fy.f(string11, strB));
            }
            String strA = dwVarA.a();
            if (strA != null) {
                listCreateListBuilder.add(new fy.f("app-ads.txt", strA));
            }
            listCreateListBuilder.add(fy.b.f8944a);
        }
        qw qwVarB = debugPanelData.b();
        if (!qwVarB.a().isEmpty()) {
            listCreateListBuilder.add(dVar);
            List listSortedWith = CollectionsKt.sortedWith(qwVarB.a(), new gx());
            ArrayList arrayList = new ArrayList();
            for (Object obj : listSortedWith) {
                if (((ow) obj).a() instanceof ow.a.C0753a) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : listSortedWith) {
                if (((ow) obj2).a() instanceof ow.a.b) {
                    arrayList2.add(obj2);
                }
            }
            ArrayList arrayList3 = new ArrayList();
            for (Object obj3 : listSortedWith) {
                if (((ow) obj3).a() instanceof ow.a.c) {
                    arrayList3.add(obj3);
                }
            }
            if (!arrayList.isEmpty()) {
                String string12 = this.f9144a.getString(R.string.completed_integration);
                Intrinsics.checkNotNullExpressionValue(string12, "getString(...)");
                listCreateListBuilder.add(new fy.e(string12));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    a(listCreateListBuilder, (ow) it.next());
                }
            }
            if (!arrayList2.isEmpty()) {
                String string13 = this.f9144a.getString(R.string.invalid_integration);
                Intrinsics.checkNotNullExpressionValue(string13, "getString(...)");
                listCreateListBuilder.add(new fy.e(string13));
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    a(listCreateListBuilder, (ow) it2.next());
                }
            }
            if (!arrayList3.isEmpty()) {
                String string14 = this.f9144a.getString(R.string.missing_integration);
                Intrinsics.checkNotNullExpressionValue(string14, "getString(...)");
                listCreateListBuilder.add(new fy.e(string14));
                Iterator it3 = arrayList3.iterator();
                while (it3.hasNext()) {
                    a(listCreateListBuilder, (ow) it3.next());
                }
            }
        }
        xw xwVarD = debugPanelData.d();
        fy.d dVar2 = fy.d.f8946a;
        listCreateListBuilder.add(dVar2);
        String string15 = this.f9144a.getString(R.string.user_privacy);
        Intrinsics.checkNotNullExpressionValue(string15, "getString(...)");
        listCreateListBuilder.add(new fy.e(string15));
        listCreateListBuilder.add(new fy.f(this.f9144a.getString(R.string.age_restricted_user), a(xwVarD.a()), null));
        listCreateListBuilder.add(new fy.f(this.f9144a.getString(R.string.has_location_consent), a(Boolean.valueOf(xwVarD.c())), null));
        listCreateListBuilder.add(new fy.f(this.f9144a.getString(R.string.has_user_consent), a(xwVarD.d()), null));
        String string16 = this.f9144a.getString(R.string.tcf_consent);
        if (xwVarD.b()) {
            String string17 = this.f9144a.getString(R.string.provided);
            Intrinsics.checkNotNullExpressionValue(string17, "getString(...)");
            yxVar2 = new yx(string17, 0, null, 0, 14);
        } else {
            String string18 = this.f9144a.getString(R.string.no_value_set);
            Intrinsics.checkNotNullExpressionValue(string18, "getString(...)");
            yxVar2 = new yx(string18, 0, null, 0, 14);
        }
        listCreateListBuilder.add(new fy.f(string16, yxVar2, null));
        ex exVarE = debugPanelData.e();
        listCreateListBuilder.add(dVar2);
        String string19 = this.f9144a.getString(R.string.features);
        Intrinsics.checkNotNullExpressionValue(string19, "getString(...)");
        listCreateListBuilder.add(new fy.e(string19));
        fy.h.a aVar = fy.h.a.DEBUG_ERROR_INDICATOR;
        listCreateListBuilder.add(new fy.h(exVarE.a()));
        return CollectionsKt.build(listCreateListBuilder);
    }
}
