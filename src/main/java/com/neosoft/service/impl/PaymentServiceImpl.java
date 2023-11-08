package com.neosoft.service.impl;

import com.neosoft.exception.paymentFailedException;
import com.neosoft.model.Payment;
import com.neosoft.repository.PaymentRepository;
import com.neosoft.service.PaymentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;
    @Transactional
    @Override
    public void processPayment(Payment payment) {
        if(payment==null || payment.getAmount()<=0.0){
            payment.setSuccessful(false);
        }else{
            payment.setSuccessful(true);
        }
        paymentRepository.save(payment);

        if(!payment.isSuccessful()){
            throw new paymentFailedException("Payment Failed for the exception :"+payment.getOrderId());
        }
    }
}
