package com.bskms.bean;

import java.util.Date;

public class Sign extends BaseBean{
    private Integer id;

    private String kqrId;

    private Integer state;

    private String describe;

    private Integer type;

    private Integer kqrType;

    private Date signIn;
    
    private String userName;
    
    private String startTime;
    
    private String endTime;
    
    private String name;
    
    private String className;
    

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKqrId() {
        return kqrId;
    }

    public void setKqrId(String kqrId) {
        this.kqrId = kqrId == null ? null : kqrId.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getKqrType() {
        return kqrType;
    }

    public void setKqrType(Integer kqrType) {
        this.kqrType = kqrType;
    }

    public Date getSignIn() {
        return signIn;
    }

    public void setSignIn(Date signIn) {
        this.signIn = signIn;
    }
}