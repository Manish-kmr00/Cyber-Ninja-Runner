package com.yandex.div.storage.db;

import kotlin.Metadata;

/* JADX INFO: compiled from: DB.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/yandex/div/storage/db/TemplateSchema;", "", "()V", "CREATE_TEMPLATES_TABLE_QUERY", "", "CREATE_TEMPLATE_USAGES_TABLE_QUERY", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TemplateSchema {
    public static final String CREATE_TEMPLATES_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS `templates` (`template_id` TEXT NOT NULL, `template_data` BLOB NOT NULL, PRIMARY KEY(`template_id`))";
    public static final String CREATE_TEMPLATE_USAGES_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS `template_usages` (`card_id` TEXT NOT NULL, `template_id` TEXT NOT NULL, PRIMARY KEY(`card_id`, `template_id`))";
    public static final TemplateSchema INSTANCE = new TemplateSchema();

    private TemplateSchema() {
    }
}
