package com.zimadai.boot.dao;

import com.zimadai.boot.bean.Member;

public interface MemberMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_member
     *
     * @mbg.generated Mon Mar 25 16:02:28 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_member
     *
     * @mbg.generated Mon Mar 25 16:02:28 CST 2019
     */
    int insert(Member record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_member
     *
     * @mbg.generated Mon Mar 25 16:02:28 CST 2019
     */
    int insertSelective(Member record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_member
     *
     * @mbg.generated Mon Mar 25 16:02:28 CST 2019
     */
    Member selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_member
     *
     * @mbg.generated Mon Mar 25 16:02:28 CST 2019
     */
    int updateByPrimaryKeySelective(Member record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_member
     *
     * @mbg.generated Mon Mar 25 16:02:28 CST 2019
     */
    int updateByPrimaryKey(Member record);
}