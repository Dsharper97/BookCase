package edu.temple.temple;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

import edu.temple.cis3515_bookcase.R;

public class BookCaseActivity extends AppCompatActivity implements BookListFragment.OnListClickListener {

    Boolean Windows;
    ArrayList<String> books;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookcase);

         Windows= (findViewById(R.id.bookDetailsContainer) != null);

        String[] b = getResources().getStringArray(R.array.books);
        books = new ArrayList<>(b.length);
        books.addAll(Arrays.asList(b));

        Bundle args = new Bundle();
        args.putStringArrayList(BookListFragment.ARG_BOOKS, books);

        if (Windows) {

            Fragment bookListFrag = BookListFragment.newInstance(args);
            getSupportFragmentManager().beginTransaction().replace(R.id.bookListContainer, bookListFrag).commit();
            Fragment bookDetailsFrag = BookDetailsFragment.newInstance("");
            getSupportFragmentManager().beginTransaction().replace(R.id.bookDetailsContainer, bookDetailsFrag).commit();

        } else { //portrait mode
            Fragment viewPagerFrag = ViewPagerFragment.newInstance(args);
            getSupportFragmentManager().beginTransaction().replace(R.id.viewPagerContainer, viewPagerFrag).commit();
        }


    }
@Override
public void displayBookDetails(String Title) {
    Log.d("bookindex", Title);

    ((BookDetailsFragment) getSupportFragmentManager().findFragmentById(R.id.bookDetailsContainer)).displayDetails(Title);
}
}
