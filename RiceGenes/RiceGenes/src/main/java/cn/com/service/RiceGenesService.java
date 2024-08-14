package cn.com.service;

import cn.com.common.entity.request.RiceGenesCategoriesRequest;
import cn.com.common.entity.response.RiceScreenResponse;
import cn.com.common.entity.vo.RiceGenesCategoriesVo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface RiceGenesService {

    /**
     * 将excel中的数据入库
     *
     * @param file 文件
     */
    void excelInsertToRiceGenesCategoriesMapper(MultipartFile file);

    /**
     * 将excel中的数据入库
     *
     * @param file 文件
     */
    void excelInsertToRiceGenesCategoriesPjMapper(MultipartFile file);

}
