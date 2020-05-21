package new_world.com.quotesapp2;

public class Quote {
    private String quote;

    public Quote(String quote) {
        this.quote = quote;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    @Override
    public String toString() {
        return quote;
    }
}//class
