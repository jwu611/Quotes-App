package new_world.com.quotesapp2;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public TextView quoteTextView;
    public ImageView backbuttonImageView;
    public ImageView heartbuttonImageView;
    public ArrayList<Quote> quoteList;
    public int index;
    public int quotesLength;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quoteTextView = (TextView)findViewById(R.id.quote_textview);
        backbuttonImageView = (ImageView) findViewById (R.id.backbutton);
        heartbuttonImageView = (ImageView) findViewById(R.id.heartbutton);

        //setup quoteslist
        Resources res = getResources();
        String[] allQuotes = res.getStringArray(R.array.quotes);
        quoteList = new ArrayList<>();
        addToQuoteList(allQuotes);
        quotesLength = quoteList.size();

        backbuttonImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = increment(index, quotesLength);
                quoteTextView.setText(quoteList.get(index).toString());
            }
        });

        heartbuttonImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View a) {
                index = 0;
                quoteTextView.setText(quoteList.get(index).toString());
            }
        });




    }

    //Add quotes from string array to arraylist of Quote objects
    public void addToQuoteList(String[] allQuotes){
        for(int i = 0; i < allQuotes.length; i++){
            String quote = allQuotes[i];
            Quote newquote = new Quote(quote);
            quoteList.add(newquote);
        }
    }

    public int getRandomQuote(int length){
        return (int) (Math.random() * length) + 1;
    }

    public int increment(int n, int length){
        if(n == length-1){
            n = 0;
        }
            n++;
         return n;
    }

}//main
