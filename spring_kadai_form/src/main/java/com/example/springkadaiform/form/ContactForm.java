package com.example.springkadaiform.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class ContactForm {
	// ユーザー名
	@NotBlank(message = "お名前を入力してください。")
    private String name;

    // メールアドレス
	@NotBlank(message = "メールアドレスを入力してください。")
    @Email(message = "メールアドレスの形式が不正です。")
    private String email;

    // お問い合わせ内容
	@NotBlank(message = "お問い合わせ内容を入力してください。")
    private String message;

}
