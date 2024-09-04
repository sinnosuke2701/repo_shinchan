package com.shinnosuke.infra.restaurant;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantDao {
	
	List<RestaurantDto> selectList();
	
	public int insert(RestaurantDto RestaurantDto);
	
	public RestaurantDto selectOne(RestaurantDto restaurantDto);
	
}
