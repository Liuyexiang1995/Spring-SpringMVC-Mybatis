package mybatis.dataObject;

import java.io.Serializable;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table sys_role_privilege
 *
 * @mbggenerated do_not_delete_during_merge
 */
public class SysRolePrivilege implements Serializable {
    /**
     * Database Column Remarks:
     *   角色ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role_privilege.role_id
     *
     * @mbggenerated
     */
    private Long roleId;

    /**
     * Database Column Remarks:
     *   权限ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role_privilege.privilege_id
     *
     * @mbggenerated
     */
    private Long privilegeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_role_privilege
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role_privilege.role_id
     *
     * @return the value of sys_role_privilege.role_id
     *
     * @mbggenerated
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role_privilege.role_id
     *
     * @param roleId the value for sys_role_privilege.role_id
     *
     * @mbggenerated
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role_privilege.privilege_id
     *
     * @return the value of sys_role_privilege.privilege_id
     *
     * @mbggenerated
     */
    public Long getPrivilegeId() {
        return privilegeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role_privilege.privilege_id
     *
     * @param privilegeId the value for sys_role_privilege.privilege_id
     *
     * @mbggenerated
     */
    public void setPrivilegeId(Long privilegeId) {
        this.privilegeId = privilegeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_privilege
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", roleId=").append(roleId);
        sb.append(", privilegeId=").append(privilegeId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}