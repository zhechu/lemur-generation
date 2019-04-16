package cn.afterturn.gen.modular.code.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 *
 * @author JueYue
 * @Date 2017-09-18 13:40
 */
@TableName("t_code_table_base_field")
public class TableBaseFieldModel extends Model<TableBaseFieldModel> {

    private static final long serialVersionUID = 1L;

	
		     /**
		     * Id
		     * 
		     */
			@TableId(value = "id",type = IdType.AUTO)
			private Integer id;
		
		     /**
		     * 用户ID
		     * 
		     */
			@TableField(value="user_id")
			private Integer userId;
		
		     /**
		     * 基础字段组名称
		     * 
		     */
			@TableField(value="name")
			private String name;
		
		     /**
		     * 描述
		     * 
		     */
			@TableField(value="desc")
			private String desc;
		
		     /**
		     * 创建人
		     * 
		     */
			@TableField(value="CRT_USER_ID")
			private String crtUserId;
		
		     /**
		     * 创建时间
		     * 
		     */
			@TableField(value="CRT_TIME")
			private Date crtTime;
		
		     /**
		     * 修改人
		     * 
		     */
			@TableField(value="MDF_USER_ID")
			private String mdfUserId;
		
		     /**
		     * 修改时间
		     * 
		     */
			@TableField(value="MDF_TIME")
			private Date mdfTime;
		
    
		     /**
		     * 获取: Id
		     * 
		     */
		    public Integer getId() {
			return id;
		    }
		     /**
		     * 设置: Id
		     * 
		     */
		    public void setId(Integer id) {
			this.id = id;
		    }
		     /**
		     * 获取: 用户ID
		     * 
		     */
		    public Integer getUserId() {
			return userId;
		    }
		     /**
		     * 设置: 用户ID
		     * 
		     */
		    public void setUserId(Integer userId) {
			this.userId = userId;
		    }
		     /**
		     * 获取: 基础字段组名称
		     * 
		     */
		    public String getName() {
			return name;
		    }
		     /**
		     * 设置: 基础字段组名称
		     * 
		     */
		    public void setName(String name) {
			this.name = name;
		    }
		     /**
		     * 获取: 描述
		     * 
		     */
		    public String getDesc() {
			return desc;
		    }
		     /**
		     * 设置: 描述
		     * 
		     */
		    public void setDesc(String desc) {
			this.desc = desc;
		    }
		     /**
		     * 获取: 创建人
		     * 
		     */
		    public String getCrtUserId() {
			return crtUserId;
		    }
		     /**
		     * 设置: 创建人
		     * 
		     */
		    public void setCrtUserId(String crtUserId) {
			this.crtUserId = crtUserId;
		    }
		     /**
		     * 获取: 创建时间
		     * 
		     */
		    public Date getCrtTime() {
			return crtTime;
		    }
		     /**
		     * 设置: 创建时间
		     * 
		     */
		    public void setCrtTime(Date crtTime) {
			this.crtTime = crtTime;
		    }
		     /**
		     * 获取: 修改人
		     * 
		     */
		    public String getMdfUserId() {
			return mdfUserId;
		    }
		     /**
		     * 设置: 修改人
		     * 
		     */
		    public void setMdfUserId(String mdfUserId) {
			this.mdfUserId = mdfUserId;
		    }
		     /**
		     * 获取: 修改时间
		     * 
		     */
		    public Date getMdfTime() {
			return mdfTime;
		    }
		     /**
		     * 设置: 修改时间
		     * 
		     */
		    public void setMdfTime(Date mdfTime) {
			this.mdfTime = mdfTime;
		    }
       
 
   

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
