package com.yw.spring.finalex.controller;

import com.yw.spring.finalex.model.Payment;
import com.yw.spring.finalex.repository.PaymentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentRepository paymentRepository;

    public PaymentController(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @GetMapping
    public String paymentForm(Model model) {
        model.addAttribute("payment", new Payment());
        return "payment";
    }

    @PostMapping
    public String savePayment(@ModelAttribute Payment payment, Model model) {
        paymentRepository.save(payment);
        model.addAttribute("payment", payment);
        return "payment_success";
    }
}
