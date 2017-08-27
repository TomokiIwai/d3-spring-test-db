package com.example.tomokiiwai;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * 抽象テストクラス
 *
 * @author tomoki.iwai
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles("test")
public abstract class D3AbstractTest {
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	@Before
	public void setUp() {
		// テスト初期データの投入など
		jdbcTemplate.update("truncate table user");
	}
}
