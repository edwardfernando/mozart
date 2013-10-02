package mozart.common.transformer;

public class IntegerTransformer implements Transformer<Integer> {

	@Override
	public Integer transform(String string) {
		return Integer.valueOf(string);
	}

}
