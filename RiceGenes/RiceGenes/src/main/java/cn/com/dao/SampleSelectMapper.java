package cn.com.dao;

import cn.com.common.entity.dto.RiceGenesCategoriesPjDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 操作水稻基因表【RICE_GENES_CATEGORIES】
 */

@Mapper
public interface SampleSelectMapper {

    /**
     * 查询LEAF_COLD表数据
     *
     * @param sampleList sampleList
     * @return List<RiceGenesCategoriesPjDto>
     */
    List<RiceGenesCategoriesPjDto> selectLeafCold(@Param("sampleList") List<String> sampleList);

    /**
     * 查询LEAF_MOCK表数据
     *
     * @param sampleList sampleList
     * @return List<RiceGenesCategoriesPjDto>
     */
    List<RiceGenesCategoriesPjDto> selectLeafMock(@Param("sampleList") List<String> sampleList);

    /**
     * 查询LEAF_HEAT表数据
     *
     * @param sampleList sampleList
     * @return List<RiceGenesCategoriesPjDto>
     */
    List<RiceGenesCategoriesPjDto> selectLeafHeat(@Param("sampleList") List<String> sampleList);

    /**
     * 查询LEAF_SALT表数据
     *
     * @param sampleList sampleList
     * @return List<RiceGenesCategoriesPjDto>
     */
    List<RiceGenesCategoriesPjDto> selectLeafSalt(@Param("sampleList") List<String> sampleList);

    /**
     * 查询LEAF_DROUGHT表数据
     *
     * @param sampleList sampleList
     * @return List<RiceGenesCategoriesPjDto>
     */
    List<RiceGenesCategoriesPjDto> selectLeafDrought(@Param("sampleList") List<String> sampleList);

    /**
     * 查询LEAF_HORMONE表数据
     *
     * @param sampleList sampleList
     * @return List<RiceGenesCategoriesPjDto>
     */
    List<RiceGenesCategoriesPjDto> selectLeafHormone(@Param("sampleList") List<String> sampleList);

    /**
     * 查询LEAF_DISEASES表数据
     *
     * @param sampleList sampleList
     * @return List<RiceGenesCategoriesPjDto>
     */
    List<RiceGenesCategoriesPjDto> selectLeafDiseases(@Param("sampleList") List<String> sampleList);

    /**
     * 查询LEAF_METAL表数据
     *
     * @param sampleList sampleList
     * @return List<RiceGenesCategoriesPjDto>
     */
    List<RiceGenesCategoriesPjDto> selectLeafMetal(@Param("sampleList") List<String> sampleList);

    /**
     * 查询PANICLE_COLD表数据
     *
     * @param sampleList sampleList
     * @return List<RiceGenesCategoriesPjDto>
     */
    List<RiceGenesCategoriesPjDto> selectPanicleCold(@Param("sampleList") List<String> sampleList);

    /**
     * 查询PANICLE_MOCK表数据
     *
     * @param sampleList sampleList
     * @return List<RiceGenesCategoriesPjDto>
     */
    List<RiceGenesCategoriesPjDto> selectPanicleMock(@Param("sampleList") List<String> sampleList);

    /**
     * 查询PANICLE_HEAT表数据
     *
     * @param sampleList sampleList
     * @return List<RiceGenesCategoriesPjDto>
     */
    List<RiceGenesCategoriesPjDto> selectPanicleHeat(@Param("sampleList") List<String> sampleList);

    /**
     * 查询PANICLE_DROUGHT表数据
     *
     * @param sampleList sampleList
     * @return List<RiceGenesCategoriesPjDto>
     */
    List<RiceGenesCategoriesPjDto> selectPanicleDrought(@Param("sampleList") List<String> sampleList);

    /**
     * 查询PANICLE_SALT表数据
     *
     * @param sampleList sampleList
     * @return List<RiceGenesCategoriesPjDto>
     */
    List<RiceGenesCategoriesPjDto> selectPanicleSalt(@Param("sampleList") List<String> sampleList);

    /**
     * 查询PANICLE_HORMONE表数据
     *
     * @param sampleList sampleList
     * @return List<RiceGenesCategoriesPjDto>
     */
    List<RiceGenesCategoriesPjDto> selectPanicleHormone(@Param("sampleList") List<String> sampleList);

    /**
     * 查询PANICLE_DISEASES表数据
     *
     * @param sampleList sampleList
     * @return List<RiceGenesCategoriesPjDto>
     */
    List<RiceGenesCategoriesPjDto> selectPanicleDiseases(@Param("sampleList") List<String> sampleList);

    /**
     * 查询PANICLE_METAL表数据
     *
     * @param sampleList sampleList
     * @return List<RiceGenesCategoriesPjDto>
     */
    List<RiceGenesCategoriesPjDto> selectPanicleMetal(@Param("sampleList") List<String> sampleList);

    /**
     * 查询ROOT_COLD表数据
     *
     * @param sampleList sampleList
     * @return List<RiceGenesCategoriesPjDto>
     */
    List<RiceGenesCategoriesPjDto> selectRootCold(@Param("sampleList") List<String> sampleList);

    /**
     * 查询ROOT_MOCK表数据
     *
     * @param sampleList sampleList
     * @return List<RiceGenesCategoriesPjDto>
     */
    List<RiceGenesCategoriesPjDto> selectRootMock(@Param("sampleList") List<String> sampleList);

    /**
     * 查询ROOT_HEAT表数据
     *
     * @param sampleList sampleList
     * @return List<RiceGenesCategoriesPjDto>
     */
    List<RiceGenesCategoriesPjDto> selectRootHeat(@Param("sampleList") List<String> sampleList);

    /**
     * 查询ROOT_DROUGHT表数据
     *
     * @param sampleList sampleList
     * @return List<RiceGenesCategoriesPjDto>
     */
    List<RiceGenesCategoriesPjDto> selectRootDrought(@Param("sampleList") List<String> sampleList);

    /**
     * 查询ROOT_SALT表数据
     *
     * @param sampleList sampleList
     * @return List<RiceGenesCategoriesPjDto>
     */
    List<RiceGenesCategoriesPjDto> selectRootSalt(@Param("sampleList") List<String> sampleList);

    /**
     * 查询ROOT_HORMONE表数据
     *
     * @param sampleList sampleList
     * @return List<RiceGenesCategoriesPjDto>
     */
    List<RiceGenesCategoriesPjDto> selectRootHormone(@Param("sampleList") List<String> sampleList);

    /**
     * 查询ROOT_DISEASES表数据
     *
     * @param sampleList sampleList
     * @return List<RiceGenesCategoriesPjDto>
     */
    List<RiceGenesCategoriesPjDto> selectRootDiseases(@Param("sampleList") List<String> sampleList);

    /**
     * 查询ROOT_METAL表数据
     *
     * @param sampleList sampleList
     * @return List<RiceGenesCategoriesPjDto>
     */
    List<RiceGenesCategoriesPjDto> selectRootMetal(@Param("sampleList") List<String> sampleList);

    /**
     * 查询SEED_COLD表数据
     *
     * @param sampleList sampleList
     * @return List<RiceGenesCategoriesPjDto>
     */
    List<RiceGenesCategoriesPjDto> selectSeedCold(@Param("sampleList") List<String> sampleList);

    /**
     * 查询SEED_MOCK表数据
     *
     * @param sampleList sampleList
     * @return List<RiceGenesCategoriesPjDto>
     */
    List<RiceGenesCategoriesPjDto> selectSeedMock(@Param("sampleList") List<String> sampleList);

    /**
     * 查询SEED_HEAT表数据
     *
     * @param sampleList sampleList
     * @return List<RiceGenesCategoriesPjDto>
     */
    List<RiceGenesCategoriesPjDto> selectSeedHeat(@Param("sampleList") List<String> sampleList);

    /**
     * 查询SEED_DROUGHT表数据
     *
     * @param sampleList sampleList
     * @return List<RiceGenesCategoriesPjDto>
     */
    List<RiceGenesCategoriesPjDto> selectSeedDrought(@Param("sampleList") List<String> sampleList);

    /**
     * 查询SEED_SALT表数据
     *
     * @param sampleList sampleList
     * @return List<RiceGenesCategoriesPjDto>
     */
    List<RiceGenesCategoriesPjDto> selectSeedSalt(@Param("sampleList") List<String> sampleList);

    /**
     * 查询SEED_HORMONE表数据
     *
     * @param sampleList sampleList
     * @return List<RiceGenesCategoriesPjDto>
     */
    List<RiceGenesCategoriesPjDto> selectSeedHormone(@Param("sampleList") List<String> sampleList);

    /**
     * 查询SEED_DISEASES表数据
     *
     * @param sampleList sampleList
     * @return List<RiceGenesCategoriesPjDto>
     */
    List<RiceGenesCategoriesPjDto> selectSeedDiseases(@Param("sampleList") List<String> sampleList);

    /**
     * 查询SEED_METAL表数据
     *
     * @param sampleList sampleList
     * @return List<RiceGenesCategoriesPjDto>
     */
    List<RiceGenesCategoriesPjDto> selectSeedMetal(@Param("sampleList") List<String> sampleList);

    /**
     * 查询SEEDLING_COLD表数据
     *
     * @param sampleList sampleList
     * @return List<RiceGenesCategoriesPjDto>
     */
    List<RiceGenesCategoriesPjDto> selectSeedlingCold(@Param("sampleList") List<String> sampleList);

    /**
     * 查询SEEDLING_MOCK表数据
     *
     * @param sampleList sampleList
     * @return List<RiceGenesCategoriesPjDto>
     */
    List<RiceGenesCategoriesPjDto> selectSeedlingMock(@Param("sampleList") List<String> sampleList);

    /**
     * 查询SEEDLING_HEAT表数据
     *
     * @param sampleList sampleList
     * @return List<RiceGenesCategoriesPjDto>
     */
    List<RiceGenesCategoriesPjDto> selectSeedlingHeat(@Param("sampleList") List<String> sampleList);

    /**
     * 查询SEEDLING_DROUGHT表数据
     *
     * @param sampleList sampleList
     * @return List<RiceGenesCategoriesPjDto>
     */
    List<RiceGenesCategoriesPjDto> selectSeedlingDrought(@Param("sampleList") List<String> sampleList);

    /**
     * 查询SEEDLING_SALT表数据
     *
     * @param sampleList sampleList
     * @return List<RiceGenesCategoriesPjDto>
     */
    List<RiceGenesCategoriesPjDto> selectSeedlingSalt(@Param("sampleList") List<String> sampleList);

    /**
     * 查询SEEDLING_HORMONE表数据
     *
     * @param sampleList sampleList
     * @return List<RiceGenesCategoriesPjDto>
     */
    List<RiceGenesCategoriesPjDto> selectSeedlingHormone(@Param("sampleList") List<String> sampleList);

    /**
     * 查询SEEDLING_DISEASES表数据
     *
     * @param sampleList sampleList
     * @return List<RiceGenesCategoriesPjDto>
     */
    List<RiceGenesCategoriesPjDto> selectSeedlingDiseases(@Param("sampleList") List<String> sampleList);

    /**
     * 查询SEEDLING_METAL表数据
     *
     * @param sampleList sampleList
     * @return List<RiceGenesCategoriesPjDto>
     */
    List<RiceGenesCategoriesPjDto> selectSeedlingMetal(@Param("sampleList") List<String> sampleList);

}
