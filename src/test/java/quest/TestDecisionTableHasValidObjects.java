package quest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import quest.Quest;
import quest.Quest.QuestType;

class TestDecisionTableHasValidObjects {

	//Decision table hasValidObjects(); R1.
	@Test
	public void Should_ThrowException_When_ListIsEmpty() {

		ArrayList<Object> testObjects = new ArrayList<>();

		assertThrows(IllegalStateException.class, () -> {
			new Quest("TestQuest", testObjects,  1000, 100, "TestQuest blablabla", false);
		});

	}

	//Decision table hasValidObjects(); R2.
	@Test
	public void Should_ThrowException_When_InvalidObjectInList() {

		ArrayList<Object> testObjects = new ArrayList<>();
		testObjects.add(10.0);

		assertThrows(IllegalArgumentException.class, () -> {
			new Quest("TestQuest", testObjects,  1000, 100, "TestQuest blablabla", false);
		});
	}

	//Decision table hasValidObjects(); R3a.
	@Test
	public void Should_ThrowException_When_ListContainsMoreThanOneInteger() {

		ArrayList<Object> testObjects = new ArrayList<>();
		testObjects.add(10);
		testObjects.add(20);
		testObjects.add(QuestType.ALL);

		assertThrows(IllegalArgumentException.class, () -> {
			new Quest("TestQuest", testObjects,  1000, 100, "TestQuest blablabla", false);
		});
	}

	//Decision table hasValidObjects(); R3b.
	@Test
	public void Should_ThrowException_When_ListContainsZeroIntegers() {

		ArrayList<Object> testObjects = new ArrayList<>();
		testObjects.add(QuestType.ALL);

		assertThrows(IllegalArgumentException.class, () -> {
			new Quest("TestQuest", testObjects,  1000, 100, "TestQuest blablabla", false);
		});
	}

	//Decision table hasValidObjects(); R4a.
	@Test
	public void Should_ThrowException_When_ListContainsMoreThanOneQuestType() {

		ArrayList<Object> testObjects = new ArrayList<>();
		testObjects.add(QuestType.ALL);
		testObjects.add(QuestType.KNIGHT);
		testObjects.add(10);

		assertThrows(IllegalArgumentException.class, () -> {
			new Quest("TestQuest", testObjects,  1000, 100, "TestQuest blablabla", false);
		});
	}

	//Decision table hasValidObjects(); R4b.
	@Test
	public void Should_ThrowException_When_ListContainsZeroQuestTypes() {

		ArrayList<Object> testObjects = new ArrayList<>();
		testObjects.add(10);

		assertThrows(IllegalArgumentException.class, () -> {
			new Quest("TestQuest", testObjects,  1000, 100, "TestQuest blablabla", false);
		});
	}

	//Decision table hasValidObjects(); R5.
	@Test
	public void QuestConstructor_ValidParameters_ShouldSucceed() {

		ArrayList<Object> testObjects = new ArrayList<>();
		testObjects.add(QuestType.ALL);
		testObjects.add(10);

		Quest quest = new Quest("TestQuest", testObjects,  1000, 100, "TestQuest blablabla", false);

		assertEquals("TestQuest", quest.getName());
		assertEquals(1000, quest.getExperience());
		assertEquals(100, quest.getCurrency());
		assertEquals("TestQuest blablabla", quest.getQuestDescription());

	}

}
