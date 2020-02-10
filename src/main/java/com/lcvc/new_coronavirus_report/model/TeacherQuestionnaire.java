package com.lcvc.new_coronavirus_report.model;

import java.util.Date;

/**
 * 教职工自觉居家观察健康状况表
 */
public class TeacherQuestionnaire {
    private Integer id;//主键
    private String name;//姓名。取消表单该字段
    private String workType;//岗位或所授学科.工作岗位
    private String myHealth;//当天本人健康状况。单选列表：健康，发热，咳嗽，发热和咳嗽。该字段用于所有表相关的“是否有咳嗽、胸闷、发烧等不适症状”说明
    private String myfamilyHealth;//当天家庭成员健康状况。单选列表：健康，发热，咳嗽，发热和咳嗽。
    private Boolean touchHuBeiPerson;//当天是否密切接触来自或到达过武汉及湖北其他地区人员。true表示有，false表示没有。
    private Boolean confirmIll;//是否为疑似病例或确诊病例。两个选项：医院已确诊；否，身体健康。true表示有，false表示没有。

    private String intro;//其他说明。用于备注字段
    //非表单字段，系统录入
    private String ip;//ip地址，由系统自动填入
    private Date createTime;//填表时间，由数据库写入

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getMyHealth() {
        return myHealth;
    }

    public void setMyHealth(String myHealth) {
        this.myHealth = myHealth;
    }

    public String getMyfamilyHealth() {
        return myfamilyHealth;
    }

    public void setMyfamilyHealth(String myfamilyHealth) {
        this.myfamilyHealth = myfamilyHealth;
    }

    public Boolean getTouchHuBeiPerson() {
        return touchHuBeiPerson;
    }

    public void setTouchHuBeiPerson(Boolean touchHuBeiPerson) {
        this.touchHuBeiPerson = touchHuBeiPerson;
    }

    public Boolean getConfirmIll() {
        return confirmIll;
    }

    public void setConfirmIll(Boolean confirmIll) {
        this.confirmIll = confirmIll;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
