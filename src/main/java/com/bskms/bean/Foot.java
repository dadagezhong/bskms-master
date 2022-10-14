package com.bskms.bean;

import java.util.Date;

public class Foot extends BaseBean{
    private Integer id;

    private String breakfast;

    private String lunch;

    private String dinner;

    private Date createTime;

    private String startTime;
    
    private String endTime;
    
    private String breakfastDesc;

    private String lunchDesc;

    private String dinnerDesc;
    
    
    
    public String getBreakfastDesc() {
		return breakfastDesc;
	}

	public void setBreakfastDesc(String breakfastDesc) {
		this.breakfastDesc = breakfastDesc;
	}

	public String getLunchDesc() {
		return lunchDesc;
	}

	public void setLunchDesc(String lunchDesc) {
		this.lunchDesc = lunchDesc;
	}

	public String getDinnerDesc() {
		return dinnerDesc;
	}

	public void setDinnerDesc(String dinnerDesc) {
		this.dinnerDesc = dinnerDesc;
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

    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast == null ? null : breakfast.trim();
    }

    public String getLunch() {
        return lunch;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch == null ? null : lunch.trim();
    }

    public String getDinner() {
        return dinner;
    }

    public void setDinner(String dinner) {
        this.dinner = dinner == null ? null : dinner.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}