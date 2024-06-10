package modele;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import src.main.java.modele.Article;

public class TestArticle {

	private Article ArticleTest;

	@Before
	public void setUp() throws Exception {
		this.ArticleTest = new Article(null, "DDD", 0.0F);
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
