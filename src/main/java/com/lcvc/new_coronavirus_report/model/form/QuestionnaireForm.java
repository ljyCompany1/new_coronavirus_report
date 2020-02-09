package com.lcvc.new_coronavirus_report.model.form;

import java.util.Date;

/**
 * 负责接收调查问卷表单
 * 统计1月16日后的信息
 */
public class QuestionnaireForm {
    private String identity;//填表人身份。"teacher"表示教师；"student"表示学生
    private String sex;//性别。两个选项：男，女
    private String workType;//教师：工作岗位
    private String teacherNumber;//教师：教工号
    private String studentNumber;//学生：学号
    private Boolean practice;//学生：是否正在实习。true表示有，false表示没有。
    private String name;//姓名
    private String registeredPlace;//户口所在地
    private String identityCard;//身份证号
    private String tel;//手机号
    private Boolean comefromHuBei;//是否来自湖北(不包括武汉市)——统计1月16日后的。true表示是，false表示不是
    private Boolean comefromWuHan;//是否来自武汉市。——统计1月16日后的。true表示是，false表示不是
    private Boolean arriveHuBei;//1月16日后，是否去过湖北(不包括武汉市)。true表示是，false表示不是
    private Boolean arriveWuHan;//1月16日后，是否到过武汉。true表示是，false表示不是
    private String epidemicArea;//疫区居住地。只要去过湖北或武汉，或是来自湖北或武汉，都要填；否则为空
    private String addressInLiuZhou;//柳州居住地。只要去过湖北或武汉，或是来自湖北或武汉，都要填；否则为空
    private Date leaveHubei;//离开湖北的时间。包括武汉。只要去过湖北或武汉，或是来自湖北或武汉，都要填；否则为空
    private Date leaveHubeiWay;//离开湖北的方式。提示用户填（用文本框）：车次/航班/汽车/自驾。只要去过湖北或武汉，或是来自湖北或武汉，都要填；否则为空
    private String  leaveTogetherPersonName;//离开时同行的人姓名，可以多写。只要去过湖北或武汉，或是来自湖北或武汉，都要填；否则为空
    private Boolean illness;//是否有咳嗽、胸闷、发烧等不适症状.true表示有，false表示没有。
    private Boolean touchHUbeiPerson;//当天是否密切接触来自或到达过武汉及湖北其他地区人员。.true表示有，false表示没有。
    private Boolean confirmIll;//是否为疑似病例或确诊病例。true表示有，false表示没有。
    private String myHealth;//当天本人健康状况。多选列表：健康，发热，咳嗽，呼吸困难，咽喉疼痛，其他症状；提交时组合成字符串提交。注意审核，选健康就不能选其他字段
    private String myfamilyHealth;//当天家庭成员健康状况。多选列表：健康，发热，咳嗽，呼吸困难，咽喉疼痛，其他症状；提交时组合成字符串提交。注意审核，选健康就不能选其他字段
    private Date createTime;//填表时间，由数据库写入


}
