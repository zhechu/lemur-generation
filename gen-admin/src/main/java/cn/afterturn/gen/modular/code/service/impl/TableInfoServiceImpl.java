package cn.afterturn.gen.modular.code.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import cn.afterturn.gen.core.model.GenBeanEntity;
import cn.afterturn.gen.core.model.GenFieldEntity;
import cn.afterturn.gen.modular.code.dao.TableInfoDao;
import cn.afterturn.gen.modular.code.model.TableInfoModel;
import cn.afterturn.gen.modular.code.service.ITableFieldService;
import cn.afterturn.gen.modular.code.service.ITableInfoService;
import cn.afterturn.gen.modular.code.service.ITableServiceConfigService;

/**
 * Service
 *
 * @author JueYue
 * @Date 2017-09-20 09:18
 */
@Service
public class TableInfoServiceImpl implements ITableInfoService {

    @Autowired
    private TableInfoDao tableInfoDao;
    @Autowired
    private ITableServiceConfigService tableServiceConfigService;
    @Autowired
    private ITableFieldService tableFieldService;

    @Override
    @Transactional
    public Integer insert(TableInfoModel entity) {
        //table插入
        tableInfoDao.insert(entity);
        //table 配置更新
        for (int i = 0; i < entity.getServiceConfig().size(); i++) {
            entity.getServiceConfig().get(i).setTableId(entity.getId());
        }
        tableServiceConfigService.batchSaveOrUpdateServiceConfig(entity.getServiceConfig());
        for (int i = 0; i < entity.getTableFields().size(); i++) {
            entity.getTableFields().get(i).setTableId(entity.getId());
        }
        //table字段更新
        tableFieldService.batchSaveOrUpdate(entity.getTableFields());
        return 1;
    }

    @Override
    @Transactional
    public Integer deleteById(Integer id) {
        //删除数据需要把所有关联的都删除了
        tableServiceConfigService.deleteById(id);
        tableFieldService.deleteById(id);
        return tableInfoDao.deleteById(id);
    }

    @Override
    @Transactional
    public Integer updateById(TableInfoModel entity) {
        //table插入
        tableInfoDao.updateById(entity);
        //table 配置更新
        for (int i = 0; i < entity.getServiceConfig().size(); i++) {
            entity.getServiceConfig().get(i).setTableId(entity.getId());
        }
        tableServiceConfigService.batchSaveOrUpdateServiceConfig(entity.getServiceConfig());
        for (int i = 0; i < entity.getTableFields().size(); i++) {
            entity.getTableFields().get(i).setTableId(entity.getId());
        }
        //table字段更新
        tableFieldService.batchSaveOrUpdate(entity.getTableFields());
        return 1;
    }

    @Override
    public TableInfoModel selectById(Integer id) {
        TableInfoModel model = tableInfoDao.selectById(id);
        model.setServiceConfig(tableServiceConfigService.selectByTableId(id));
        model.setTableFields(tableFieldService.selectByTableId(id));
        return model;
    }

    @Override
    public TableInfoModel selectOne(TableInfoModel entity) {
        return tableInfoDao.selectOne(entity);
    }

    @Override
    public Integer selectCount(TableInfoModel model) {
        return tableInfoDao.selectCount(model);
    }

    @Override
    public List<TableInfoModel> selectList(TableInfoModel model) {
        return tableInfoDao.selectList(model);
    }

    @Override
    public List<TableInfoModel> selectPage(Pagination pagination, TableInfoModel model, Wrapper<TableInfoModel> wrapper) {
        return tableInfoDao.selectPage(pagination, model, wrapper);
    }

    @Override
    public GenBeanEntity getGenBean(Integer tableId) {
        TableInfoModel model = selectById(tableId);
        GenBeanEntity genBean = new GenBeanEntity();
        genBean.setTableName(model.getTableName());
        genBean.setName(model.getClassName());
        genBean.setChinaName(model.getContent());
        genBean.setFields(new ArrayList<GenFieldEntity>());
        for (int i = 0; i < model.getTableFields().size(); i++) {
            GenFieldEntity fieldEntity = new GenFieldEntity();
            fieldEntity.setChinaName(model.getTableFields().get(i).getContent());
            BeanUtils.copyProperties(model.getTableFields().get(i), fieldEntity);
            BeanUtils.copyProperties(model.getTableFields().get(i).getDbinfoModel(), fieldEntity);
            BeanUtils.copyProperties(model.getTableFields().get(i).getVerifyModel(), fieldEntity);
            genBean.getFields().add(fieldEntity);
            // 设置主键信息
            if (fieldEntity.getIsKey() != null && fieldEntity.getIsKey().intValue() == 2) {
                genBean.setIdFieldName(fieldEntity.getFieldName());
                genBean.setIdName(fieldEntity.getName());
                genBean.setIdType(fieldEntity.getType());
                genBean.setIdJdbcType(fieldEntity.getJdbcType());
            }
        }
        return genBean;
    }

}
