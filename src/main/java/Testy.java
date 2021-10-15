public class Testy {
	public static String helloWorld() {
		return "HelloWorld";
	}
	public static int increment(int i) {
		if (i > 2)
			throw new IllegalStateException("värdet får inte vara mer än 2");
		return i+1;
	}


}
