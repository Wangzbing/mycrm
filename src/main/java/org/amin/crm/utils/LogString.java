package org.amin.crm.utils;

/**
 * @author Amin
 * @Create 2018-12-04 22:52
 */
public class LogString {
    public static String getDirectServiceName(String serviceName) {
        /*获取服务的名称*/
        if (serviceName != null) {
            if (serviceName.equals("ContractItemServiceImpl")) {
                return "合同明细管理";
            } else if (serviceName.equals("ContractServiceImpl")) {
                return "合同管理";
            } else if (serviceName.equals("CustomerDevPlanServiceImpl")) {
                return "客户开发计划管理";
            } else if (serviceName.equals("CustomerServiceImpl")) {
                return "客户信息管理";
            } else if (serviceName.equals("CustomerTraceHistoryServiceImpl")) {
                return "客户跟进历史管理";
            } else if (serviceName.equals("CustomerTransferServiceImpl")) {
                return "客户移交记录管理";
            } else if (serviceName.equals("DepartmentServiceImpl")) {
                return "部门管理";
            } else if (serviceName.equals("EmployeeServiceImpl")) {
                return "员工管理";
            } else if (serviceName.equals("GuaranteeServiceImpl")) {
                return "保修单管理";
            } else if (serviceName.equals("GuaranteetItemServiceImpl")) {
                return "保修单明细管理";
            } else if (serviceName.equals("OrderServiceImpl")) {
                return "定金订单管理";
            } else if (serviceName.equals("PermissionServiceImpl")) {
                return "权限管理";
            } else if (serviceName.equals("PotentialCustomerServiceImpl")) {
                return "潜在客户管理";
            } else if (serviceName.equals("ResourceServiceImpl")) {
                return "资源管理";
            } else if (serviceName.equals("RoleServiceImpl")) {
                return "角色管理";
            } else if (serviceName.equals("SystemDictionaryItemServiceImpl")) {
                return "数据字典明细管理";
            } else if (serviceName.equals("SystemDictionaryTypeServiceImpl")) {
                return "数据字典管理";
            } else if (serviceName.equals("SystemLogServiceImpl")) {
                return "系统日志管理";
            } else if (serviceName.equals("SystemMenuServiceImpl")) {
                return "系统菜单管理";
            } else {
                return "未知模块";
            }
        }
        return "未知模块";
    }
    /*获取方法名称*/
    public static String getDirectFunctionName(String functionName) {
        if (functionName != null) {
            if (functionName.equals("login")) {
                return "登录";
            } else if (functionName.equals("check")) {
                return "检查登录";
            } else if (functionName.equals("index")) {
                return "页面导向";
            } else if (functionName.equals("page")) {
                return "列表";
            } else if (functionName.equals("insert")) {
                return "保存/修改";
            } else if (functionName.equals("delete")) {
                return "删除";
            } else if (functionName.equals("queryByPage")) {
                return "分页查询";
            } else if (functionName.equals("findOne")) {
                return "一个条件查询";
            } else if (functionName.equals("findAll")) {
                return "查询所有";
            } else if (functionName.equals("left")) {
                return "停用/离职";
            } else if (functionName.equals("rework")) {
                return "启用/复职";
            } else {
                return "未知方法";
            }
        } else {
            return "未知方法";
        }
    }

    public static String getDirectparams(String paramsName) {
        if (paramsName != null) {
            if (paramsName.startsWith("Employee")) {
                return "员工";
            } else if (paramsName.startsWith("ContractItem")) {
                return "合同明细";
            } else if (paramsName.startsWith("Contract")) {
                return "合同";
            } else if (paramsName.startsWith("CustomerDevPlan")) {
                return "客户开发计划";
            } else if (paramsName.startsWith("Customer")) {
                return "客户";
            } else if (paramsName.startsWith("CustomerTraceHistoryServiceImpl")) {
                return "客户跟进历史";
            } else if (paramsName.startsWith("Customer")) {
                return "客户移交记录";
            } else if (paramsName.startsWith("Department")) {
                return "员工部门";
            } else if (paramsName.startsWith("Employee")) {
                return "员工";
            } else if (paramsName.startsWith("Order")) {
                return "订单";
            } else if (paramsName.startsWith("Permission")) {
                return "权限";
            } else if (paramsName.startsWith("PotentialCustomer")) {
                return "潜在客户";
            } else if (paramsName.startsWith("RepairItem")) {
                return "保修单详细";
            } else if (paramsName.startsWith("Repair")) {
                return "保修单";
            } else if (paramsName.startsWith("Resource")) {
                return "系统资源";
            } else if (paramsName.startsWith("Role")) {
                return "角色";
            } else if (paramsName.startsWith("SystemDictionary")) {
                return "数据字典";
            } else if (paramsName.startsWith("SystemDictionaryItemServiceImpl")) {
                return "数据字典明细";
            } else if (paramsName.startsWith("SystemLog")) {
                return "系统日志";
            } else if (paramsName.startsWith("SystemMenu")) {
                return "系统菜单";
            } else {
                return "未知参数";
            }
        } else {
            return null;
        }
    }
}
