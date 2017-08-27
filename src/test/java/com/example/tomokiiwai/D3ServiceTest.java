package com.example.tomokiiwai;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * サービステスト
 *
 * @author tomoki.iwai
 */
public class D3ServiceTest extends D3AbstractTest {
	@Autowired
	private D3Service service;

	@Test
	public void テスト1() throws Exception {
		//
		// MySQLではなくH2Databaseを使っていることを確認(=データが無い)
		//
		final List<Map<String, Object>> beforeTest = service.selectAll();
		assertThat(beforeTest).isEmpty();

		final String name = "hoge";
		final String password = "password";

		//
		// 登録
		//
		boolean result = service.register(name, password);
		assertThat(result).isTrue();

		final List<Map<String, Object>> afterTest = service.selectAll();
		assertThat(afterTest).hasSize(1);
		assertThat(afterTest.get(0)).containsEntry("name", name);
		assertThat(afterTest.get(0)).containsEntry("password", password);
	}

	@Test
	public void テスト2() throws Exception {
		//
		// 当然、トランザクションが異なるので、再度クリーンな状態からテストを始められる
		//
		final List<Map<String, Object>> beforeTest = service.selectAll();
		assertThat(beforeTest).isEmpty();
	}
}
