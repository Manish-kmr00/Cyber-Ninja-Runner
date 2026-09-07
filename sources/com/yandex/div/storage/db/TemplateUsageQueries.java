package com.yandex.div.storage.db;

import kotlin.Metadata;

/* JADX INFO: compiled from: DB.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/yandex/div/storage/db/TemplateUsageQueries;", "", "()V", "DELETE_ALL_TEMPLATE_USAGES_QUERY", "", "DELETE_TEMPLATE_USAGE_BY_CARD_ID_QUERY_TEMPLATE", "INSERT_TEMPLATE_USAGE_QUERY_TEMPLATE", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TemplateUsageQueries {
    public static final String DELETE_ALL_TEMPLATE_USAGES_QUERY = "DELETE FROM template_usages";
    public static final String DELETE_TEMPLATE_USAGE_BY_CARD_ID_QUERY_TEMPLATE = "DELETE FROM template_usages WHERE card_id = ?";
    public static final String INSERT_TEMPLATE_USAGE_QUERY_TEMPLATE = "INSERT OR IGNORE INTO `template_usages` (`card_id`,`template_id`) VALUES (?,?)";
    public static final TemplateUsageQueries INSTANCE = new TemplateUsageQueries();

    private TemplateUsageQueries() {
    }
}
