package com.example.demo.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public class UserRequest implements Serializable {

	@NotEmpty(message="名前を入力してください")
	@Size(max=100,message="名前は100文字以内で入力してください")
	private String name;

	@NotEmpty(message="住所を入力してください")
	@Size(max=100,message="住所は100文字以内で入力してください")
	private String address;


}
