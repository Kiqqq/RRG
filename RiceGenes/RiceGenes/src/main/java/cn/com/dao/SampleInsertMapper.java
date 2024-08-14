package cn.com.dao;

import cn.com.common.entity.dto.RiceGenesCategoriesPjDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * 操作水稻基因表【RICE_GENES_CATEGORIES】
 */

@Mapper
public interface SampleInsertMapper {

    /**
     * 插入LEAF_MOCK表
     *
     * @param riceGenesCategoriesPjDto riceGenesCategoriesPjDto
     */
    void insertLeafMock(@Param("item") RiceGenesCategoriesPjDto riceGenesCategoriesPjDto);

    /**
     * 插入LEAF_COLD表
     *
     * @param riceGenesCategoriesPjDto riceGenesCategoriesPjDto
     */
    void insertLeafCold(@Param("item") RiceGenesCategoriesPjDto riceGenesCategoriesPjDto);

    /**
     * 插入LEAF_HEAT表
     *
     * @param riceGenesCategoriesPjDto riceGenesCategoriesPjDto
     */
    void insertLeafHeat(@Param("item") RiceGenesCategoriesPjDto riceGenesCategoriesPjDto);

    /**
     * 插入LEAF_DROUGHT表
     *
     * @param riceGenesCategoriesPjDto riceGenesCategoriesPjDto
     */
    void insertLeafDrought(@Param("item") RiceGenesCategoriesPjDto riceGenesCategoriesPjDto);

    /**
     * 插入LEAF_SALT表
     *
     * @param riceGenesCategoriesPjDto riceGenesCategoriesPjDto
     */
    void insertLeafSalt(@Param("item") RiceGenesCategoriesPjDto riceGenesCategoriesPjDto);

    /**
     * 插入LEAF_HORMONE表
     *
     * @param riceGenesCategoriesPjDto riceGenesCategoriesPjDto
     */
    void insertLeafHormone(@Param("item") RiceGenesCategoriesPjDto riceGenesCategoriesPjDto);

    /**
     * 插入LEAF_DISEASES表
     *
     * @param riceGenesCategoriesPjDto riceGenesCategoriesPjDto
     */
    void insertLeafDiseases(@Param("item") RiceGenesCategoriesPjDto riceGenesCategoriesPjDto);

    /**
     * 插入LEAF_METAL表
     *
     * @param riceGenesCategoriesPjDto riceGenesCategoriesPjDto
     */
    void insertLeafMetal(@Param("item") RiceGenesCategoriesPjDto riceGenesCategoriesPjDto);

    /**
     * 插入PANICLE_COLD表
     *
     * @param riceGenesCategoriesPjDto riceGenesCategoriesPjDto
     */
    void insertPanicleCold(@Param("item") RiceGenesCategoriesPjDto riceGenesCategoriesPjDto);

    /**
     * 插入PANICLE_MOCK表
     *
     * @param riceGenesCategoriesPjDto riceGenesCategoriesPjDto
     */
    void insertPanicleMock(@Param("item") RiceGenesCategoriesPjDto riceGenesCategoriesPjDto);

    /**
     * 插入PANICLE_HEAT表
     *
     * @param riceGenesCategoriesPjDto riceGenesCategoriesPjDto
     */
    void insertPanicleHeat(@Param("item") RiceGenesCategoriesPjDto riceGenesCategoriesPjDto);

    /**
     * 插入PANICLE_DROUGHT表
     *
     * @param riceGenesCategoriesPjDto riceGenesCategoriesPjDto
     */
    void insertPanicleDrought(@Param("item") RiceGenesCategoriesPjDto riceGenesCategoriesPjDto);

    /**
     * 插入PANICLE_SALT表
     *
     * @param riceGenesCategoriesPjDto riceGenesCategoriesPjDto
     */
    void insertPanicleSalt(@Param("item") RiceGenesCategoriesPjDto riceGenesCategoriesPjDto);

    /**
     * 插入PANICLE_HORMONE表
     *
     * @param riceGenesCategoriesPjDto riceGenesCategoriesPjDto
     */
    void insertPanicleHormone(@Param("item") RiceGenesCategoriesPjDto riceGenesCategoriesPjDto);

    /**
     * 插入PANICLE_DISEASES表
     *
     * @param riceGenesCategoriesPjDto riceGenesCategoriesPjDto
     */
    void insertPanicleDiseases(@Param("item") RiceGenesCategoriesPjDto riceGenesCategoriesPjDto);

    /**
     * 插入PANICLE_METAL表
     *
     * @param riceGenesCategoriesPjDto riceGenesCategoriesPjDto
     */
    void insertPanicleMetal(@Param("item") RiceGenesCategoriesPjDto riceGenesCategoriesPjDto);

    /**
     * 插入ROOT_COLD表
     *
     * @param riceGenesCategoriesPjDto riceGenesCategoriesPjDto
     */
    void insertRootCold(@Param("item") RiceGenesCategoriesPjDto riceGenesCategoriesPjDto);

    /**
     * 插入ROOT_MOCK表
     *
     * @param riceGenesCategoriesPjDto riceGenesCategoriesPjDto
     */
    void insertRootMock(@Param("item") RiceGenesCategoriesPjDto riceGenesCategoriesPjDto);

    /**
     * 插入ROOT_HEAT表
     *
     * @param riceGenesCategoriesPjDto riceGenesCategoriesPjDto
     */
    void insertRootHeat(@Param("item") RiceGenesCategoriesPjDto riceGenesCategoriesPjDto);

    /**
     * 插入ROOT_DROUGHT表
     *
     * @param riceGenesCategoriesPjDto riceGenesCategoriesPjDto
     */
    void insertRootDrought(@Param("item") RiceGenesCategoriesPjDto riceGenesCategoriesPjDto);

    /**
     * 插入ROOT_SALT表
     *
     * @param riceGenesCategoriesPjDto riceGenesCategoriesPjDto
     */
    void insertRootSalt(@Param("item") RiceGenesCategoriesPjDto riceGenesCategoriesPjDto);

    /**
     * 插入ROOT_HORMONE表
     *
     * @param riceGenesCategoriesPjDto riceGenesCategoriesPjDto
     */
    void insertRootHormone(@Param("item") RiceGenesCategoriesPjDto riceGenesCategoriesPjDto);

    /**
     * 插入ROOT_DISEASES表
     *
     * @param riceGenesCategoriesPjDto riceGenesCategoriesPjDto
     */
    void insertRootDiseases(@Param("item") RiceGenesCategoriesPjDto riceGenesCategoriesPjDto);

    /**
     * 插入ROOT_METAL表
     *
     * @param riceGenesCategoriesPjDto riceGenesCategoriesPjDto
     */
    void insertRootMetal(@Param("item") RiceGenesCategoriesPjDto riceGenesCategoriesPjDto);

    /**
     * 插入SEED_COLD表
     *
     * @param riceGenesCategoriesPjDto riceGenesCategoriesPjDto
     */
    void insertSeedCold(@Param("item") RiceGenesCategoriesPjDto riceGenesCategoriesPjDto);

    /**
     * 插入SEED_MOCK表
     *
     * @param riceGenesCategoriesPjDto riceGenesCategoriesPjDto
     */
    void insertSeedMock(@Param("item") RiceGenesCategoriesPjDto riceGenesCategoriesPjDto);

    /**
     * 插入SEED_HEAT表
     *
     * @param riceGenesCategoriesPjDto riceGenesCategoriesPjDto
     */
    void insertSeedHeat(@Param("item") RiceGenesCategoriesPjDto riceGenesCategoriesPjDto);

    /**
     * 插入SEED_DROUGHT表
     *
     * @param riceGenesCategoriesPjDto riceGenesCategoriesPjDto
     */
    void insertSeedDrought(@Param("item") RiceGenesCategoriesPjDto riceGenesCategoriesPjDto);

    /**
     * 插入SEED_SALT表
     *
     * @param riceGenesCategoriesPjDto riceGenesCategoriesPjDto
     */
    void insertSeedSalt(@Param("item") RiceGenesCategoriesPjDto riceGenesCategoriesPjDto);

    /**
     * 插入SEED_HORMONE表
     *
     * @param riceGenesCategoriesPjDto riceGenesCategoriesPjDto
     */
    void insertSeedHormone(@Param("item") RiceGenesCategoriesPjDto riceGenesCategoriesPjDto);

    /**
     * 插入SEED_DISEASES表
     *
     * @param riceGenesCategoriesPjDto riceGenesCategoriesPjDto
     */
    void insertSeedDiseases(@Param("item") RiceGenesCategoriesPjDto riceGenesCategoriesPjDto);

    /**
     * 插入SEED_METAL表
     *
     * @param riceGenesCategoriesPjDto riceGenesCategoriesPjDto
     */
    void insertSeedMetal(@Param("item") RiceGenesCategoriesPjDto riceGenesCategoriesPjDto);

    /**
     * 插入SEEDLING_COLD表
     *
     * @param riceGenesCategoriesPjDto riceGenesCategoriesPjDto
     */
    void insertSeedlingCold(@Param("item") RiceGenesCategoriesPjDto riceGenesCategoriesPjDto);

    /**
     * 插入SEEDLING_MOCK表
     *
     * @param riceGenesCategoriesPjDto riceGenesCategoriesPjDto
     */
    void insertSeedlingMock(@Param("item") RiceGenesCategoriesPjDto riceGenesCategoriesPjDto);

    /**
     * 插入SEEDLING_HEAT表
     *
     * @param riceGenesCategoriesPjDto riceGenesCategoriesPjDto
     */
    void insertSeedlingHeat(@Param("item") RiceGenesCategoriesPjDto riceGenesCategoriesPjDto);

    /**
     * 插入SEEDLING_DROUGHT表
     *
     * @param riceGenesCategoriesPjDto riceGenesCategoriesPjDto
     */
    void insertSeedlingDrought(@Param("item") RiceGenesCategoriesPjDto riceGenesCategoriesPjDto);

    /**
     * 插入SEEDLING_SALT表
     *
     * @param riceGenesCategoriesPjDto riceGenesCategoriesPjDto
     */
    void insertSeedlingSalt(@Param("item") RiceGenesCategoriesPjDto riceGenesCategoriesPjDto);

    /**
     * 插入SEEDLING_HORMONE表
     *
     * @param riceGenesCategoriesPjDto riceGenesCategoriesPjDto
     */
    void insertSeedlingHormone(@Param("item") RiceGenesCategoriesPjDto riceGenesCategoriesPjDto);

    /**
     * 插入SEEDLING_DISEASES表
     *
     * @param riceGenesCategoriesPjDto riceGenesCategoriesPjDto
     */
    void insertSeedlingDiseases(@Param("item") RiceGenesCategoriesPjDto riceGenesCategoriesPjDto);

    /**
     * 插入SEEDLING_METAL表
     *
     * @param riceGenesCategoriesPjDto riceGenesCategoriesPjDto
     */
    void insertSeedlingMetal(@Param("item") RiceGenesCategoriesPjDto riceGenesCategoriesPjDto);

}
