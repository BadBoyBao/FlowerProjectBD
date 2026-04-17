package com.xpxp.mapper;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file FlowerMapper
 * @author thexpxp233
 * @date 2025/11/11
 * My name is lixiaopei
 **/

import com.github.pagehelper.Page;
import com.xpxp.DTO.FlowerAddDTO;
import com.xpxp.DTO.FlowerQueryParmDTO;
import com.xpxp.DTO.FlowerUpdateDTO;
import com.xpxp.entity.Flowers;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface FlowerMapper {

	/**
	 * 获取所有鲜花
	 *
	 * @return
	 */
	@Select("select * from flowers where shop_id =#{shopId} ")
	List<Flowers> getAllFlowers(Integer shopId);


	/**
	 * 根据鲜花ID查询鲜花详情
	 *
	 * @param flowerId
	 * @return Flowers
	 */
	Flowers selectById(Integer flowerId);


	/**
	 * 根据对应的id删除鲜花
	 *
	 * @param flowerId
	 * @return
	 */
	@Delete("delete from flowers where flower_id = #{flowerId}")
	int deleteById(Integer flowerId);

	/**
	 * 根据分类ID查询分类下鲜花数量
	 *
	 * @param categoryId
	 * @return int
	 */
	@Select("select count(*) from flowers where category_id = #{categoryId}")
	int selectCountByCategoryId(Integer categoryId);

	/**
	 * 新增鲜花
	 *
	 * @param flowerAddDTO
	 */
	void addFlower(FlowerAddDTO flowerAddDTO);

	/**
	 * 修改鲜花
	 *
	 * @param flowerUpdateDTO
	 */
	void updateFlower(FlowerUpdateDTO flowerUpdateDTO);

	/**
	 * 切换状态
	 *
	 * @param flowerId
	 * @param status
	 */
	@Update("update flowers set status = #{status} where flower_id = #{flowerId}")
	void updateStatusByFlowerId(Integer flowerId, Integer status);

	/**
	 * 分页查询
	 *
	 * @param flowerQueryParmDTO
	 * @return
	 */
	Page<Flowers> page(FlowerQueryParmDTO flowerQueryParmDTO);


	/**
	 * 根据分类id查询鲜花
	 *
	 * @param categoryId
	 * @return
	 */
	@Select("select * from flowers where category_id = #{categoryId}")
	List<Flowers> listByCategoryId(Integer categoryId);
}