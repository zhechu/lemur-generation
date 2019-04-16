package cn.afterturn.gen.modular.system.warpper;

import java.util.List;
import java.util.Map;

import cn.afterturn.gen.common.constant.factory.ConstantFactory;
import cn.afterturn.gen.common.constant.state.IsMenu;
import cn.afterturn.gen.core.base.warpper.BaseControllerWarpper;

/**
 * 菜单列表的包装类
 *
 * @author fengshuonan
 * @date 2017年2月19日15:07:29
 */
public class MenuWarpper extends BaseControllerWarpper {

    public MenuWarpper(List<Map<String, Object>> list) {
        super(list);
    }

    @Override
    public void warpTheMap(Map<String, Object> map) {
        map.put("statusName", ConstantFactory.me().getMenuStatusName((Integer) map.get("status")));
        map.put("isMenuName", IsMenu.valueOf((Integer) map.get("ismenu")));
    }

}
