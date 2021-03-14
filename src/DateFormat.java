import java.util.PriorityQueue;

public class DateFormat {

	public static void main(String[] args) {
		PriorityQueue pq = new PriorityQueue<>();
		pq.add("dishes");
		pq.add("laundry");
		pq.add("bills");
		pq.offer("bills");
		System.out.println(pq.size() + " " + pq.poll());
		System.out.println(" " + pq.peek() + " " + pq.poll());
		System.out.println(" " + pq.poll() + " " + pq.poll());

	}

}
