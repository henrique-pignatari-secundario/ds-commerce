package com.henrique.dscommerce.services;

import com.henrique.dscommerce.dto.OrderDTO;
import com.henrique.dscommerce.entities.Order;
import com.henrique.dscommerce.repositories.OrderRepository;
import com.henrique.dscommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id){
        Order order = orderRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Recurso não encontrado"));

        return  new OrderDTO(order);
    }
}
