package com.bskms.bean;

import java.util.Date;

public class Pay extends BaseBean{
    private Integer id;

    private String name;

    private Double base;

    private Double overtime;

    private Double traffic;

    private Double meal;

    private Double vacation;

    private Double bonus;

    private Double other;

    private Date paymentTime;
    
    private String userName;

    private Double minBase;
    
    private Double maxBase;
    
    private String minDate;
    
    private String maxDate;
    
	public String getMinDate() {
		return minDate;
	}

	public void setMinDate(String minDate) {
		this.minDate = minDate;
	}

	public String getMaxDate() {
		return maxDate;
	}

	public void setMaxDate(String maxDate) {
		this.maxDate = maxDate;
	}

	public Double getMinBase() {
		return minBase;
	}

	public void setMinBase(Double minBase) {
		this.minBase = minBase;
	}

	public Double getMaxBase() {
		return maxBase;
	}

	public void setMaxBase(Double maxBase) {
		this.maxBase = maxBase;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

    public Double getBase() {
        return base;
    }

    public void setBase(Double base) {
        this.base = base;
    }

    public Double getOvertime() {
        return overtime;
    }

    public void setOvertime(Double overtime) {
        this.overtime = overtime;
    }

    public Double getTraffic() {
        return traffic;
    }

    public void setTraffic(Double traffic) {
        this.traffic = traffic;
    }

    public Double getMeal() {
        return meal;
    }

    public void setMeal(Double meal) {
        this.meal = meal;
    }

    public Double getVacation() {
        return vacation;
    }

    public void setVacation(Double vacation) {
        this.vacation = vacation;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public Double getOther() {
        return other;
    }

    public void setOther(Double other) {
        this.other = other;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }
}