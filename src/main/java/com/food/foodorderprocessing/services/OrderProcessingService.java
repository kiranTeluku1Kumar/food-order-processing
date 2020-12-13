package com.food.foodorderprocessing.services;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.food.foodorderprocessing.entities.CustomerDetails;
import com.food.foodorderprocessing.entities.MenuItem;
import com.food.foodorderprocessing.entities.OrderDetails;
import com.food.foodorderprocessing.entities.OrderPrime;
import com.food.foodorderprocessing.enums.OrderStatus;
import com.food.foodorderprocessing.exceptions.NoItemFoundException;
import com.food.foodorderprocessing.repos.CustomerRepo;
import com.food.foodorderprocessing.repos.MenuItemsRepo;
import com.food.foodorderprocessing.repos.OrderDetailsRepo;
import com.food.foodorderprocessing.repos.OrderRepository;
import com.food.foodorderprocessing.req.Items;
import com.food.foodorderprocessing.req.OrderRequest;

@Service
public class OrderProcessingService {
	@Autowired
	private OrderRepository orderRepo;
	@Autowired
	private CustomerRepo custRepo;
	@Autowired
	private MenuItemsRepo menuItemRepo;
	@Autowired
	private OrderDetailsRepo orderDetailsRepo;

	public List<OrderPrime> fetchAllOrders() {
		return (List<OrderPrime>) orderRepo.findAll();
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackForClassName = "Exception")
	public int saveOrderAndProcess(OrderRequest ord) {
		OrderPrime inputOrd = getOrdMgmt(ord);
		OrderPrime saved = orderRepo.save(inputOrd);
		int orderNum = saved.getOrderNum();
		System.out.println(orderNum + " is started preparing....");
		processTheOrder(ord, orderNum);
		return orderNum;
	}
	@Transactional
	private void processTheOrder(OrderRequest ord, int orderNum) {
		ord.getItems().stream()
					   .forEach(it -> saveTheOrderdetails(it));
		
	}
	@Transactional
	private void saveTheOrderdetails(Items item) {
		OrderDetails ordDet = new OrderDetails();
		ordDet.setItemId(menuItemRepo.findByItemNameInIgnoreCase(item.getItemName().toUpperCase()).get().getItemId());
		ordDet.setOrdQuantity(item.getQuantity());
		ordDet.setOrdStatus(OrderStatus.TODO.getOrderStaus());
		orderDetailsRepo.save(ordDet);
	}
	@Transactional
	private OrderPrime getOrdMgmt(OrderRequest ord) {
		OrderPrime ordMgmt = new OrderPrime();
		int custId = getCustomerId(ord);
		ordMgmt.setCustId(custId);
		ordMgmt.setTotal(getOrderTotal(ord));
		return ordMgmt;
	}
	@Transactional
	private int getCustomerId(OrderRequest ord) {
		CustomerDetails custDet = new CustomerDetails();
		custDet.setCustName(ord.getCustomerName());
		custDet.setCustPhoneNum(ord.getCustomerPhone());
		int custId = 0;
		Optional<CustomerDetails> findByCustName = custRepo.findByCustName(ord.getCustomerName().toUpperCase());
		if (findByCustName.isPresent()) {
			custId = findByCustName.get().getCustId();
		} else {
			custId = custRepo.save(custDet).getCustId();
		}
		return custId;
	}
	@Transactional
	private Double getOrderTotal(OrderRequest ord){
		Double totalOrderAmt = 0d;

		Iterator<Items> ordItemsIterator = ord.getItems().iterator();
		
		while(ordItemsIterator.hasNext()) {
			Items nextItem = ordItemsIterator.next();
			try {
				totalOrderAmt += getOrderDetailsCost(nextItem.getQuantity(), nextItem.getItemName());
			}catch (NoItemFoundException e) {
				System.out.println("NoItemFoundException:::"+e);
				totalOrderAmt += 0;
			}
		}
		return totalOrderAmt;
	}

	@Transactional
	private Double getOrderDetailsCost(int ordQuantity, String itemName) throws NoItemFoundException {
		Optional<MenuItem> findByItemName = menuItemRepo.findByItemNameInIgnoreCase(itemName.toUpperCase());
		double orderDetailCost;
		if (findByItemName.isPresent()) {
			MenuItem menuItem = findByItemName.get();
			orderDetailCost = menuItem.getCostOfItem() * ordQuantity;
		} else {
			throw new NoItemFoundException(itemName + "::Item Not found in our Menu. Please Choose Another Item...");
		}
		return orderDetailCost;
	}

}
