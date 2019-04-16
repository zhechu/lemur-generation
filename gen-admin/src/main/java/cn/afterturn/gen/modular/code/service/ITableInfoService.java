package cn.afterturn.gen.modular.code.service;

import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import cn.afterturn.gen.core.model.GenBeanEntity;
import cn.afterturn.gen.modular.code.model.TableInfoModel;


/**
 * Service
 *
 * @author JueYue
 * @Date 2017-09-20 09:18
 */
public interface ITableInfoService {

     /**
     * <p>
     * 插入一条记录
     * </p>
     *
     * @param entity 实体对象
     * @return int
     */
    Integer insert(TableInfoModel entity);

    /**
     * <p>
     * 根据 ID 删除
     * </p>
     *
     * @param id 主键ID
     * @return int
     */
    Integer deleteById(Integer id);

    /**
     * <p>
     * 根据 ID 修改
     * </p>
     *
     * @param entity 实体对象
     * @return int
     */
    Integer updateById(TableInfoModel entity);

    /**
     * <p>
     * 根据 ID 查询
     * </p>
     *
     * @param id 主键ID
     * @return TableInfoModel
     */
    TableInfoModel selectById(Integer id);

    /**
     * <p>
     * 根据 entity 条件，查询一条记录
     * </p>
     *
     * @param entity 实体对象
     * @return TableInfoModel
     */
    TableInfoModel selectOne(TableInfoModel entity);

    /**
     * <p>
     * 根据 model 条件，查询总记录数
     * </p>
     *
     * @param model 实体对象
     * @return int
     */
    Integer selectCount(TableInfoModel model);

    /**
     * <p>
     * 根据 entity 条件，查询全部记录
     * </p>
     *
     * @param model 实体对象封装操作类（可以为 null）
     * @return List<TableInfoModel>
     */
    List<TableInfoModel> selectList(TableInfoModel model);


    /**
     * <p>
     * 根据 entity 条件，查询全部记录（并翻页）
     * </p>
     *
     * @param pagination 分页查询条件
     * @param model   实体对象封装操作可以为 null）
     * @param wrapper   SQL包装
     * @return List<TableInfoModel>
     */
    List<TableInfoModel> selectPage(Pagination pagination, TableInfoModel model,Wrapper<TableInfoModel> wrapper);

    /**
     * 返回生成代码的对象
     * @param tableId
     * @return
     */
    GenBeanEntity getGenBean(Integer tableId);
}
