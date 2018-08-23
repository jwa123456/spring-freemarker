package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author wei.jiang
 * @since 2018/8/23
 */
public interface UserDao extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {

    User queryById(String id);

    List<User> queryByRegionId(int regionId);

//    @Insert("insert into t_user(id, user_name,email,age,comment,region_id) values(#{id}, #{userName}, #{email}, #{age}, #{comment},#{regionId})")
//    @SelectKey(keyProperty = "id", resultType = String.class, before = true,
//            statement = "select replace(uuid(), '-', '') as id from dual")
//    int insert(User user);
//
//    @Update("update t_user set user_name=#{userName}, email=#{email},age=#{age}, comment=#{comment} WHERE id=#{id}")
//    int update(User user);

    Page<User> findByRegionId(int regionId, Pageable pageable);
}
