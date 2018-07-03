package builderPattern;

public class BuilderExample {
	 public static void main(String[] args) {
		 //create a director
		 Director director = new Director();
		 //instance the director whit a new builder (user)
		 director.setConnectionBuilder(new UserBuilderDB());
		 //get connection
		 director.BuildConnection();
		 director.getConnectionDB().connect();
		//instance the same director whit a new builder (admin)
		 director.setConnectionBuilder(new AdminBuilderDB());
		 //get connection
		 director.BuildConnection();
		 director.getConnectionDB().connect();
	 }
}
