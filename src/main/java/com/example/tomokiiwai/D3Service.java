package com.example.tomokiiwai;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * サービス
 *
 * @author tomoki.iwai
 */
@Service
public class D3Service {
	private final JdbcTemplate jdbcTemplate;

	/**
	 * Constructor
	 */
	public D3Service(final JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 登録します。
	 *
	 * @param name     名前
	 * @param password パスワード
	 * @return true:OK false:NG
	 */
	@Transactional
	public boolean register(final String name, final String password) {
		// レコードの有無をチェック
		final Integer count = jdbcTemplate.queryForObject("select count(*) from user where name = ?", new Object[]{name}, Integer.class);
		if (count > 0) {
			return false;
		}

		// レコードを登録
		final int result = jdbcTemplate.update("insert into user (name, password) values (?, ?)", new Object[]{name, password});
		return result > 0;
	}

	/**
	 * 取得します。
	 *
	 * @return データ
	 */
	public List<Map<String, Object>> selectAll() {
		return jdbcTemplate.queryForList("select * from user");
	}
}
