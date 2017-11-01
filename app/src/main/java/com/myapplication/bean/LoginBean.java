package com.myapplication.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.myapplication.BR;

/**
 * Created by Administrator on 2017/8/24.
 */

public class LoginBean extends BaseObservable{
    private String operate_mode;
    private String token;
    private String ab_user;
    /**
     * is_employee : 0
     * province : 青海
     * vip_surplus_day : 267
     * id_number : 000000000000000000
     * ip :
     * address :
     * updated_at : 2017-10-11T16:30:17.686576
     * is_freeze : false
     * is_test : false
     * room_count : 10
     * backups_at : null
     * deleted_at : null
     * id : 2365
     * city : 黄南
     * is_channel : 0
     * vip_expire_at : 2018-07-26
     * area :
     * vip_expire_time : 2018-07-26
     * can_modify_company_postfix : true
     * created_by : null
     * terminal : ANDROID
     * company_postfix :
     * version : 0
     * role : boss
     * vip_level : 1
     * credit_ceiling : 0
     * email :
     * status : 1
     * legal_person : null
     * updated_by : null
     * vip_action : 1
     * company :
     * idauth_type : 1
     * is_franchisee : false
     * idauth_status : 0
     * is_delete : false
     * phone : 15936562980
     * url_from : xiaoshuidi
     * role_name :
     * user : 2611
     * is_online : false
     * ip_city :
     * name : 15936562980
     * vip_status : 3
     * is_first_login : true
     * is_loan : 0
     * credit_used : 0
     * level : 0
     * created_at : 2017-09-01T09:29:53.099814
     * interval : null
     * deleted_by : null
     * username : 15936562980
     * avatar : null
     * referral :
     * company_brand :
     * operate_city : null
     */

    private int is_employee;
    private String province;
    private int vip_surplus_day;
    private String id_number;
    private String ip;
    private String address;
    private String updated_at;
    private boolean is_freeze;
    private boolean is_test;
    private int room_count;
    private Object backups_at;
    private Object deleted_at;
    private int id;
    private String city;
    private int is_channel;
    private String vip_expire_at;
    private String area;
    private String vip_expire_time;
    private boolean can_modify_company_postfix;
    private Object created_by;
    private String terminal;
    private String company_postfix;
    private int version;
    private String role;
    private int vip_level;
    private int credit_ceiling;
    private String email;
    private int status;
    private Object legal_person;
    private Object updated_by;
    private int vip_action;
    private String company;
    private int idauth_type;
    private boolean is_franchisee;
    private int idauth_status;
    private boolean is_delete;
    private String phone;
    private String url_from;
    private String role_name;
    private int user;
    private boolean is_online;
    private String ip_city;
    private String name;
    private int vip_status;
    private boolean is_first_login;
    private int is_loan;
    private int credit_used;
    private int level;
    private String created_at;
    private Object interval;
    private Object deleted_by;
    private String username;
    private Object avatar;
    private String referral;
    private String company_brand;
    private Object operate_city;
//    private ObservableField<String> updated_at;
//
//    public ObservableField<String> getUpdated_at() {
//        return updated_at;
//    }
//
//    public void setUpdated_at(ObservableField<String> updated_at) {
//        this.updated_at = updated_at;
//    }

    public String getTp_user() {
        return tp_user;
    }

    public void setTp_user(String tp_user) {
        this.tp_user = tp_user;
    }

    private String tp_user;

    public String getAb_user() {
        return ab_user;
    }

    public void setAb_user(String ab_user) {
        this.ab_user = ab_user;
    }

    public String getOperate_mode() {
        return operate_mode;
    }

    public void setOperate_mode(String operate_mode) {
        this.operate_mode = operate_mode;
    }
@Bindable
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
        notifyPropertyChanged(BR.token);
    }

    public int getIs_employee() {
        return is_employee;
    }

    public void setIs_employee(int is_employee) {
        this.is_employee = is_employee;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getVip_surplus_day() {
        return vip_surplus_day;
    }

    public void setVip_surplus_day(int vip_surplus_day) {
        this.vip_surplus_day = vip_surplus_day;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public boolean isIs_freeze() {
        return is_freeze;
    }

    public void setIs_freeze(boolean is_freeze) {
        this.is_freeze = is_freeze;
    }

    public boolean isIs_test() {
        return is_test;
    }

    public void setIs_test(boolean is_test) {
        this.is_test = is_test;
    }

    public int getRoom_count() {
        return room_count;
    }

    public void setRoom_count(int room_count) {
        this.room_count = room_count;
    }

    public Object getBackups_at() {
        return backups_at;
    }

    public void setBackups_at(Object backups_at) {
        this.backups_at = backups_at;
    }

    public Object getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(Object deleted_at) {
        this.deleted_at = deleted_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getIs_channel() {
        return is_channel;
    }

    public void setIs_channel(int is_channel) {
        this.is_channel = is_channel;
    }

    public String getVip_expire_at() {
        return vip_expire_at;
    }

    public void setVip_expire_at(String vip_expire_at) {
        this.vip_expire_at = vip_expire_at;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getVip_expire_time() {
        return vip_expire_time;
    }

    public void setVip_expire_time(String vip_expire_time) {
        this.vip_expire_time = vip_expire_time;
    }

    public boolean isCan_modify_company_postfix() {
        return can_modify_company_postfix;
    }

    public void setCan_modify_company_postfix(boolean can_modify_company_postfix) {
        this.can_modify_company_postfix = can_modify_company_postfix;
    }

    public Object getCreated_by() {
        return created_by;
    }

    public void setCreated_by(Object created_by) {
        this.created_by = created_by;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getCompany_postfix() {
        return company_postfix;
    }

    public void setCompany_postfix(String company_postfix) {
        this.company_postfix = company_postfix;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getVip_level() {
        return vip_level;
    }

    public void setVip_level(int vip_level) {
        this.vip_level = vip_level;
    }

    public int getCredit_ceiling() {
        return credit_ceiling;
    }

    public void setCredit_ceiling(int credit_ceiling) {
        this.credit_ceiling = credit_ceiling;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getLegal_person() {
        return legal_person;
    }

    public void setLegal_person(Object legal_person) {
        this.legal_person = legal_person;
    }

    public Object getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(Object updated_by) {
        this.updated_by = updated_by;
    }

    public int getVip_action() {
        return vip_action;
    }

    public void setVip_action(int vip_action) {
        this.vip_action = vip_action;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getIdauth_type() {
        return idauth_type;
    }

    public void setIdauth_type(int idauth_type) {
        this.idauth_type = idauth_type;
    }

    public boolean isIs_franchisee() {
        return is_franchisee;
    }

    public void setIs_franchisee(boolean is_franchisee) {
        this.is_franchisee = is_franchisee;
    }

    public int getIdauth_status() {
        return idauth_status;
    }

    public void setIdauth_status(int idauth_status) {
        this.idauth_status = idauth_status;
    }

    public boolean isIs_delete() {
        return is_delete;
    }

    public void setIs_delete(boolean is_delete) {
        this.is_delete = is_delete;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUrl_from() {
        return url_from;
    }

    public void setUrl_from(String url_from) {
        this.url_from = url_from;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public boolean isIs_online() {
        return is_online;
    }

    public void setIs_online(boolean is_online) {
        this.is_online = is_online;
    }

    public String getIp_city() {
        return ip_city;
    }

    public void setIp_city(String ip_city) {
        this.ip_city = ip_city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVip_status() {
        return vip_status;
    }

    public void setVip_status(int vip_status) {
        this.vip_status = vip_status;
    }

    public boolean isIs_first_login() {
        return is_first_login;
    }

    public void setIs_first_login(boolean is_first_login) {
        this.is_first_login = is_first_login;
    }

    public int getIs_loan() {
        return is_loan;
    }

    public void setIs_loan(int is_loan) {
        this.is_loan = is_loan;
    }

    public int getCredit_used() {
        return credit_used;
    }

    public void setCredit_used(int credit_used) {
        this.credit_used = credit_used;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public Object getInterval() {
        return interval;
    }

    public void setInterval(Object interval) {
        this.interval = interval;
    }

    public Object getDeleted_by() {
        return deleted_by;
    }

    public void setDeleted_by(Object deleted_by) {
        this.deleted_by = deleted_by;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Object getAvatar() {
        return avatar;
    }

    public void setAvatar(Object avatar) {
        this.avatar = avatar;
    }

    public String getReferral() {
        return referral;
    }

    public void setReferral(String referral) {
        this.referral = referral;
    }

    public String getCompany_brand() {
        return company_brand;
    }

    public void setCompany_brand(String company_brand) {
        this.company_brand = company_brand;
    }

    public Object getOperate_city() {
        return operate_city;
    }

    public void setOperate_city(Object operate_city) {
        this.operate_city = operate_city;
    }
}
