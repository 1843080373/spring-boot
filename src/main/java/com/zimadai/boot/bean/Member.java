package com.zimadai.boot.bean;

public class Member {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_member.id
	 * @mbg.generated  Mon Mar 25 16:03:18 CST 2019
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_member.m_name
	 * @mbg.generated  Mon Mar 25 16:03:18 CST 2019
	 */
	private String mName;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_member.id
	 * @return  the value of t_member.id
	 * @mbg.generated  Mon Mar 25 16:03:18 CST 2019
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_member.id
	 * @param id  the value for t_member.id
	 * @mbg.generated  Mon Mar 25 16:03:18 CST 2019
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_member.m_name
	 * @return  the value of t_member.m_name
	 * @mbg.generated  Mon Mar 25 16:03:18 CST 2019
	 */
	public String getmName() {
		return mName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_member.m_name
	 * @param mName  the value for t_member.m_name
	 * @mbg.generated  Mon Mar 25 16:03:18 CST 2019
	 */
	public void setmName(String mName) {
		this.mName = mName;
	}
}