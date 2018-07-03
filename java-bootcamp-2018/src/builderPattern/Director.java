package builderPattern;

public class Director {

	IBuilderDB builder;
    public void setConnectionBuilder(IBuilderDB cb) { builder = cb; }
    public ConnectionDB getConnectionDB() { return builder.getConnectionDB(); }
 
    public void BuildConnection() {
    	builder.buildUser();
    	builder.buildPass();
    }
}
