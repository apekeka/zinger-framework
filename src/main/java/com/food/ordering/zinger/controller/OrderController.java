package com.food.ordering.zinger.controller;

import com.food.ordering.zinger.constant.Column.UserColumn;
import com.food.ordering.zinger.model.*;
import com.food.ordering.zinger.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.food.ordering.zinger.constant.ApiConfig.OrderApi.*;

@RestController
@RequestMapping(BASE_URL)
public class OrderController {

    @Autowired
    OrderServiceImpl orderServiceImpl;

    @PostMapping(value = insertOrder)
    public Response<TransactionTokenModel> insertOrder(@RequestBody OrderItemListModel orderItemList, @RequestHeader(value = UserColumn.oauthId) String oauthId, @RequestHeader(value = UserColumn.id) Integer id, @RequestHeader(value = UserColumn.role) String role) {
        return orderServiceImpl.insertOrder(orderItemList, oauthId, id, role);
    }

    @PostMapping(value = placeOrder)
    public Response<String> placeOrder(@PathVariable("orderId") Integer orderId, @RequestHeader(value = UserColumn.oauthId) String oauthId, @RequestHeader(value = UserColumn.id) Integer id, @RequestHeader(value = UserColumn.role) String role) {
        return orderServiceImpl.placeOrder(orderId, oauthId, id, role);
    }

    @GetMapping(value = getOrderByUserId)
    public Response<List<OrderItemListModel>> getOrderByUserId(@PathVariable("userId") Integer userId, @PathVariable("pageNum") Integer pageNum, @PathVariable("pageCount") Integer pageCount, @RequestHeader(value = UserColumn.oauthId) String oauthId, @RequestHeader(value = UserColumn.id) Integer id, @RequestHeader(value = UserColumn.role) String role) {
        return orderServiceImpl.getOrderByUserId(userId, pageNum, pageCount, oauthId, id, role);
    }

    @GetMapping(value = getOrderByShopIdPagination)
    public Response<List<OrderItemListModel>> getOrderByShopIdPagination(@PathVariable("shopId") Integer shopId, @PathVariable("pageNum") Integer pageNum, @PathVariable("pageCount") Integer pageCount, @RequestHeader(value = UserColumn.oauthId) String oauthId, @RequestHeader(value = UserColumn.id) Integer id, @RequestHeader(value = UserColumn.role) String role) {
        return orderServiceImpl.getOrderByShopIdPagination(shopId, pageNum, pageCount, oauthId, id, role);
    }

    @GetMapping(value = getOrderByShopId)
    public Response<List<OrderItemListModel>> getOrderByShopId(@PathVariable("shopId") Integer shopId, @RequestHeader(value = UserColumn.oauthId) String oauthId, @RequestHeader(value = UserColumn.id) Integer id, @RequestHeader(value = UserColumn.role) String role) {
        return orderServiceImpl.getOrderByShopId(shopId, oauthId, id, role);
    }

    @GetMapping(value = getOrderById)
    public Response<TransactionModel> getOrderById(@PathVariable("id") Integer id, @RequestHeader(value = UserColumn.oauthId) String oauthId, @RequestHeader(value = UserColumn.id) Integer idRh, @RequestHeader(value = UserColumn.role) String role) {
        return orderServiceImpl.getOrderById(id, oauthId, idRh, role);
    }

    @PatchMapping(value = updateOrderRating)
    public Response<String> updateOrderRating(@RequestBody OrderModel orderModel, @RequestHeader(value = UserColumn.oauthId) String oauthId, @RequestHeader(value = UserColumn.id) Integer id, @RequestHeader(value = UserColumn.role) String role) {
        return orderServiceImpl.updateOrderRating(orderModel, oauthId, id, role);
    }

    @PatchMapping(value = updateOrderStatus)
    public Response<String> updateOrderStatus(@RequestBody OrderModel orderModel, @RequestHeader(value = UserColumn.oauthId) String oauthId, @RequestHeader(value = UserColumn.id) Integer id, @RequestHeader(value = UserColumn.role) String role) {
        return orderServiceImpl.updateOrderStatus(orderModel, oauthId, id, role);
    }
}
