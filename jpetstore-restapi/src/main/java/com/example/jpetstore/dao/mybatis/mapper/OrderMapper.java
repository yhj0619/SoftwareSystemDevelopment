/*
 *    Copyright 2010-2013 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.example.jpetstore.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.CacheNamespaceRef;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import com.example.jpetstore.domain.Order;

/**
 * @author Eduardo Macarron
 * @modified by Chang-Sup Park
 */
@Mapper
@CacheNamespaceRef(value=OrderMapper.class)
public interface OrderMapper {

  List<Order> getOrdersByUsername(String username);

  Order getOrder(int orderId);
  
  void insertOrder(Order order);
  
  void insertOrderStatus(Order order);

  int msSqlServerInsertOrder(Order order);
  
  @Delete("delete from ORDERS where ORDERID = #{orderId}")
  void deleteOrder(int orderId);
  
  @Delete("delete from ORDERSTATUS where ORDERID = #{orderId}")
  void deleteOrderStatus(int orderId);
}
