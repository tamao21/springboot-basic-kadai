package com.example.springkadaiform.controller;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springkadaiform.form.ContactForm;

@Controller
public class ContactFormController {
	// フォーム表示
	@GetMapping("/form")
	public String showForm(Model model) {
		// 初回アクセス時は新しいフォームを渡す
		if (!model.containsAttribute("contactForm")) {
			model.addAttribute("contactForm", new ContactForm());
		}
		return "contactFormView";
	}

	// 確認画面表示
	@PostMapping("/confirm")
	public String confirm(@Valid @ModelAttribute("contactForm") ContactForm form,
			BindingResult result,
			RedirectAttributes redirectAttributes,
			Model model) {
		if (result.hasErrors()) {
			// バリデーションNG → 入力値とエラーをFlashAttributesに入れてリダイレクト
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.contactForm", result);
			redirectAttributes.addFlashAttribute("contactForm", form);
			return "redirect:/form";
		}
		// バリデーションOK → 確認画面へ
		model.addAttribute("contactForm", form);
		return "confirmView";
	}

}
