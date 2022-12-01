package com.ycj.arithmetic.others;

/**
 * 抽奖实例对象
 * @author FlyerZuo
 *
 */
public class Record {

	//抽奖活动编码
	private String awardCode;

	//针对微信抽奖的openId
	private String openId;

	//中奖概率
	private int rate;

	private int min;

	private int max;

	public Record() {

	}

	public Record(String awardCode, String openId, int rate) {
		this.awardCode = awardCode;
		this.openId = openId;
		this.rate = rate;
	}

	public Record(String awardCode, String openId, int rate, int min, int max) {
		this.awardCode = awardCode;
		this.openId = openId;
		this.rate = rate;
		this.min = min;
		this.max = max;
	}

	public String getAwardCode() {
		return awardCode;
	}

	public void setAwardCode(String awardCode) {
		this.awardCode = awardCode;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}
	
	public String toString()
	{
		return "openId:"+openId+",awardCode="+awardCode;
	}

}
