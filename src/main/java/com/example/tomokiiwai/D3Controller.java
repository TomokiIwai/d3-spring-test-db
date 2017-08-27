package com.example.tomokiiwai;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * コントローラー
 *
 * @author tomoki.iwai
 */
@Controller
public class D3Controller {
	private final D3Service service;

	/**
	 * Constructor
	 */
	public D3Controller(final D3Service service) {
		this.service = service;
	}

	/**
	 * トップページ
	 */
	@RequestMapping("/")
	public String index() {
		return "/index.html";
	}

	/**
	 * データ取得
	 */
	@RequestMapping("/selectAll")
	@ResponseBody
	public String selectAll() {
		try {
			return new ObjectMapper().writeValueAsString(service.selectAll());
		} catch (JsonProcessingException e) {
			return "{code: \"failed\"}";
		}
	}

	/**
	 * データ登録
	 *
	 * @param name     名前
	 * @param password パスワード
	 */
	@RequestMapping("/register")
	@ResponseBody
	public String register(@RequestParam("username") final String name, @RequestParam("password") final String password) {
		boolean result = service.register(name, password);

		return result ? "OK" : "NG";
	}
}
