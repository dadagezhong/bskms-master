package com.bskms.bean;

import java.util.Date;

public class Children extends BaseBean{
    private Integer id;

    private String name;

    private Integer sex;

    private Date birthday;

    private Integer classId;

    private String hobby;

    private String food;

    private Date entrance;
    
    private String className;
    
    private String csrq;
    
    
    private String userId;
    private Integer childrenId;
    private Integer isFaMa;
    private Integer isJinji;
    private Integer ucId;

    public Integer getUcId() {
		return ucId;
	}

	public void setUcId(Integer ucId) {
		this.ucId = ucId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getChildrenId() {
		return childrenId;
	}

	public void setChildrenId(Integer childrenId) {
		this.childrenId = childrenId;
	}

	public Integer getIsFaMa() {
		return isFaMa;
	}

	public void setIsFaMa(Integer isFaMa) {
		this.isFaMa = isFaMa;
	}

	public Integer getIsJinji() {
		return isJinji;
	}

	public void setIsJinji(Integer isJinji) {
		this.isJinji = isJinji;
	}

    public String getCsrq() {
		return csrq;
	}

	public void setCsrq(String csrq) {
		this.csrq = csrq;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

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
        this.name = name == null ? null : name.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby == null ? null : hobby.trim();
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food == null ? null : food.trim();
    }

    public Date getEntrance() {
        return entrance;
    }

    public void setEntrance(Date entrance) {
        this.entrance = entrance;
    }
}