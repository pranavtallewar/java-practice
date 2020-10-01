package designpattern.creational;

public class BuilderDemo {

	public static void main(String[] args) {
		Coffee coffee = new Coffee.Builder("Latte").milk(true).sugar(true).size("Medium").build();

		System.out.println(coffee);
	}

}

class Coffee {

	private String type;
	private boolean sugar;
	private boolean milk;
	private String size;

	public Coffee(Builder builder) {
		this.type = builder.type;
		this.sugar = builder.sugar;
		this.milk = builder.milk;
		this.size = builder.size;
	}

	public static class Builder {
		private String type;
		private boolean sugar;
		private boolean milk;
		private String size;

		public Builder(String type) {
			this.type = type;
		}

		public Builder sugar(boolean sugar) {
			this.sugar = sugar;
			return this;
		}

		public Builder milk(boolean milk) {
			this.milk = milk;
			return this;
		}

		public Builder size(String size) {
			this.size = size;
			return this;
		}

		public Coffee build() {
			return new Coffee(this);
		}
	}

	@Override
	public String toString() {
		return "Coffee [type=" + type + ", sugar=" + sugar + ", milk=" + milk + ", size=" + size + "]";
	}

}
