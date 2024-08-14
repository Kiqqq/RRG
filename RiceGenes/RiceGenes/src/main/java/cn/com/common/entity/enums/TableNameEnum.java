package cn.com.common.entity.enums;

/**
 * 水稻表枚举
 *
 * @author zhaohai
 * @date 2023/11/04
 */
public enum TableNameEnum {

    LEAF_COLD("leaf_cold"),
    LEAF_MOCK("leaf_mock"),
    LEAF_HEAT("leaf_heat"),
    LEAF_DROUGHT("leaf_drought"),
    LEAF_SALT("leaf_salt"),
    LEAF_HORMONE("leaf_hormone"),
    LEAF_DISEASES("leaf_diseases"),
    LEAF_METAL("leaf_metal"),
    PANICLE_COLD("panicle_cold"),
    PANICLE_MOCK("panicle_mock"),
    PANICLE_HEAT("panicle_heat"),
    PANICLE_DROUGHT("panicle_drought"),
    PANICLE_SALT("panicle_salt"),
    PANICLE_HORMONE("panicle_hormone"),
    PANICLE_DISEASES("panicle_diseases"),
    PANICLE_METAL("panicle_metal"),
    ROOT_COLD("root_cold"),
    ROOT_MOCK("root_mock"),
    ROOT_HEAT("root_heat"),
    ROOT_DROUGHT("root_drought"),
    ROOT_SALT("root_salt"),
    ROOT_HORMONE("root_hormone"),
    ROOT_DISEASES("root_diseases"),
    ROOT_METAL("root_metal"),
    SEED_COLD("seed_cold"),
    SEED_MOCK("seed_mock"),
    SEED_HEAT("seed_heat"),
    SEED_DROUGHT("seed_drought"),
    SEED_SALT("seed_salt"),
    SEED_HORMONE("seed_hormone"),
    SEED_DISEASES("seed_diseases"),
    SEED_METAL("seed_metal"),
    SEEDLING_COLD("seedling_cold"),
    SEEDLING_MOCK("seedling_mock"),
    SEEDLING_HEAT("seedling_heat"),
    SEEDLING_DROUGHT("seedling_drought"),
    SEEDLING_SALT("seedling_salt"),
    SEEDLING_HORMONE("seedling_hormone"),
    SEEDLING_DISEASES("seedling_diseases"),
    SEEDLING_METAL("seedling_metal");

    TableNameEnum(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    /**
     * 根据表名获取对应的枚举值
     *
     * @param name 表名
     * @return TableNameEnum
     */
    public static TableNameEnum getTableNameEnum(String name) {
        for (TableNameEnum tableNameEnum : TableNameEnum.values()) {
            if (tableNameEnum.getName().equals(name)) {
                return tableNameEnum;
            }
        }
        return null;
    }

}
