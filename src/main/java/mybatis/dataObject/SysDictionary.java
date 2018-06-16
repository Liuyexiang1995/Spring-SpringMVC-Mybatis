package mybatis.dataObject;

import java.io.Serializable;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table sys_dictionary
 *
 * @mbggenerated do_not_delete_during_merge
 */
public class SysDictionary implements Serializable {
    /**
     * Database Column Remarks:
     *   主键
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_dictionary.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * Database Column Remarks:
     *   类别
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_dictionary.code
     *
     * @mbggenerated
     */
    private String code;

    /**
     * Database Column Remarks:
     *   字典名
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_dictionary.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * Database Column Remarks:
     *   字典值
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_dictionary.value
     *
     * @mbggenerated
     */
    private String value;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_dictionary
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_dictionary.id
     *
     * @return the value of sys_dictionary.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_dictionary.id
     *
     * @param id the value for sys_dictionary.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_dictionary.code
     *
     * @return the value of sys_dictionary.code
     *
     * @mbggenerated
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_dictionary.code
     *
     * @param code the value for sys_dictionary.code
     *
     * @mbggenerated
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_dictionary.name
     *
     * @return the value of sys_dictionary.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_dictionary.name
     *
     * @param name the value for sys_dictionary.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_dictionary.value
     *
     * @return the value of sys_dictionary.value
     *
     * @mbggenerated
     */
    public String getValue() {
        return value;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_dictionary.value
     *
     * @param value the value for sys_dictionary.value
     *
     * @mbggenerated
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dictionary
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", code=").append(code);
        sb.append(", name=").append(name);
        sb.append(", value=").append(value);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}