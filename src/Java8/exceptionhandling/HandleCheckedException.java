package Java8.exceptionhandling;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class HandleCheckedException {

	public static void main(String[] args) {

		System.out.println("\n######Checked EH########");
		List<Integer> list2 = Arrays.asList(1000, 2000);
		list2.forEach(handleCheckedExceptionConsumer(s -> {
			Thread.sleep(s);
			System.out.println(s);
		}));
		System.out.println("\nProgram exit");
	}

	static <Target> Consumer<Target> handleCheckedExceptionConsumer(
			CheckedExceptionHandlerConsumer<Target, Exception> handlerConsumer) {
		return obj -> {
			try {
				handlerConsumer.accept(obj);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		};
	}

}

@FunctionalInterface
interface CheckedExceptionHandlerConsumer<Target, ExObj extends Exception> {

	public void accept(Target target) throws ExObj;
}
