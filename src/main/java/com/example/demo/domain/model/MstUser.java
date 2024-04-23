package com.example.demo.domain.model;

import java.util.Date;

public class MstUser {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mst_user.employee_no
     *
     * @mbg.generated Tue Apr 16 08:58:15 JST 2024
     */
    private String employee_no;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mst_user.name
     *
     * @mbg.generated Tue Apr 16 08:58:15 JST 2024
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mst_user.name_kana
     *
     * @mbg.generated Tue Apr 16 08:58:15 JST 2024
     */
    private String name_kana;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mst_user.department
     *
     * @mbg.generated Tue Apr 16 08:58:15 JST 2024
     */
    private String department;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mst_user.tel_no
     *
     * @mbg.generated Tue Apr 16 08:58:15 JST 2024
     */
    private String tel_no;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mst_user.mail_adress
     *
     * @mbg.generated Tue Apr 16 08:58:15 JST 2024
     */
    private String mail_adress;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mst_user.age
     *
     * @mbg.generated Tue Apr 16 08:58:15 JST 2024
     */
    private Integer age;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mst_user.gender
     *
     * @mbg.generated Tue Apr 16 08:58:15 JST 2024
     */
    private Integer gender;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mst_user.position
     *
     * @mbg.generated Tue Apr 16 08:58:15 JST 2024
     */
    private String position;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mst_user.account_level
     *
     * @mbg.generated Tue Apr 16 08:58:15 JST 2024
     */
    private String account_level;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mst_user.retire_date
     *
     * @mbg.generated Tue Apr 16 08:58:15 JST 2024
     */
    private Date retire_date;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mst_user.register_date
     *
     * @mbg.generated Tue Apr 16 08:58:15 JST 2024
     */
    private Date register_date;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mst_user.update_date
     *
     * @mbg.generated Tue Apr 16 08:58:15 JST 2024
     */
    private Date update_date;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mst_user.delete_flag
     *
     * @mbg.generated Tue Apr 16 08:58:15 JST 2024
     */
    private Boolean delete_flag;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mst_user.employee_no
     *
     * @return the value of mst_user.employee_no
     *
     * @mbg.generated Tue Apr 16 08:58:15 JST 2024
     */
    public String getEmployee_no() {
        return employee_no;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mst_user.employee_no
     *
     * @param employee_no the value for mst_user.employee_no
     *
     * @mbg.generated Tue Apr 16 08:58:15 JST 2024
     */
    public void setEmployee_no(String employee_no) {
        this.employee_no = employee_no == null ? null : employee_no.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mst_user.name
     *
     * @return the value of mst_user.name
     *
     * @mbg.generated Tue Apr 16 08:58:15 JST 2024
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mst_user.name
     *
     * @param name the value for mst_user.name
     *
     * @mbg.generated Tue Apr 16 08:58:15 JST 2024
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mst_user.name_kana
     *
     * @return the value of mst_user.name_kana
     *
     * @mbg.generated Tue Apr 16 08:58:15 JST 2024
     */
    public String getName_kana() {
        return name_kana;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mst_user.name_kana
     *
     * @param name_kana the value for mst_user.name_kana
     *
     * @mbg.generated Tue Apr 16 08:58:15 JST 2024
     */
    public void setName_kana(String name_kana) {
        this.name_kana = name_kana == null ? null : name_kana.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mst_user.department
     *
     * @return the value of mst_user.department
     *
     * @mbg.generated Tue Apr 16 08:58:15 JST 2024
     */
    public String getDepartment() {
        return department;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mst_user.department
     *
     * @param department the value for mst_user.department
     *
     * @mbg.generated Tue Apr 16 08:58:15 JST 2024
     */
    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mst_user.tel_no
     *
     * @return the value of mst_user.tel_no
     *
     * @mbg.generated Tue Apr 16 08:58:15 JST 2024
     */
    public String getTel_no() {
        return tel_no;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mst_user.tel_no
     *
     * @param tel_no the value for mst_user.tel_no
     *
     * @mbg.generated Tue Apr 16 08:58:15 JST 2024
     */
    public void setTel_no(String tel_no) {
        this.tel_no = tel_no == null ? null : tel_no.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mst_user.mail_adress
     *
     * @return the value of mst_user.mail_adress
     *
     * @mbg.generated Tue Apr 16 08:58:15 JST 2024
     */
    public String getMail_adress() {
        return mail_adress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mst_user.mail_adress
     *
     * @param mail_adress the value for mst_user.mail_adress
     *
     * @mbg.generated Tue Apr 16 08:58:15 JST 2024
     */
    public void setMail_adress(String mail_adress) {
        this.mail_adress = mail_adress == null ? null : mail_adress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mst_user.age
     *
     * @return the value of mst_user.age
     *
     * @mbg.generated Tue Apr 16 08:58:15 JST 2024
     */
    public Integer getAge() {
        return age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mst_user.age
     *
     * @param age the value for mst_user.age
     *
     * @mbg.generated Tue Apr 16 08:58:15 JST 2024
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mst_user.gender
     *
     * @return the value of mst_user.gender
     *
     * @mbg.generated Tue Apr 16 08:58:15 JST 2024
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mst_user.gender
     *
     * @param gender the value for mst_user.gender
     *
     * @mbg.generated Tue Apr 16 08:58:15 JST 2024
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mst_user.position
     *
     * @return the value of mst_user.position
     *
     * @mbg.generated Tue Apr 16 08:58:15 JST 2024
     */
    public String getPosition() {
        return position;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mst_user.position
     *
     * @param position the value for mst_user.position
     *
     * @mbg.generated Tue Apr 16 08:58:15 JST 2024
     */
    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mst_user.account_level
     *
     * @return the value of mst_user.account_level
     *
     * @mbg.generated Tue Apr 16 08:58:15 JST 2024
     */
    public String getAccount_level() {
        return account_level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mst_user.account_level
     *
     * @param account_level the value for mst_user.account_level
     *
     * @mbg.generated Tue Apr 16 08:58:15 JST 2024
     */
    public void setAccount_level(String account_level) {
        this.account_level = account_level == null ? null : account_level.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mst_user.retire_date
     *
     * @return the value of mst_user.retire_date
     *
     * @mbg.generated Tue Apr 16 08:58:15 JST 2024
     */
    public Date getRetire_date() {
        return retire_date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mst_user.retire_date
     *
     * @param retire_date the value for mst_user.retire_date
     *
     * @mbg.generated Tue Apr 16 08:58:15 JST 2024
     */
    public void setRetire_date(Date retire_date) {
        this.retire_date = retire_date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mst_user.register_date
     *
     * @return the value of mst_user.register_date
     *
     * @mbg.generated Tue Apr 16 08:58:15 JST 2024
     */
    public Date getRegister_date() {
        return register_date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mst_user.register_date
     *
     * @param register_date the value for mst_user.register_date
     *
     * @mbg.generated Tue Apr 16 08:58:15 JST 2024
     */
    public void setRegister_date(Date register_date) {
        this.register_date = register_date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mst_user.update_date
     *
     * @return the value of mst_user.update_date
     *
     * @mbg.generated Tue Apr 16 08:58:15 JST 2024
     */
    public Date getUpdate_date() {
        return update_date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mst_user.update_date
     *
     * @param update_date the value for mst_user.update_date
     *
     * @mbg.generated Tue Apr 16 08:58:15 JST 2024
     */
    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mst_user.delete_flag
     *
     * @return the value of mst_user.delete_flag
     *
     * @mbg.generated Tue Apr 16 08:58:15 JST 2024
     */
    public Boolean getDelete_flag() {
        return delete_flag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mst_user.delete_flag
     *
     * @param delete_flag the value for mst_user.delete_flag
     *
     * @mbg.generated Tue Apr 16 08:58:15 JST 2024
     */
    public void setDelete_flag(Boolean delete_flag) {
        this.delete_flag = delete_flag;
    }
}