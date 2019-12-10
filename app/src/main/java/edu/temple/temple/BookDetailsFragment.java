package edu.temple.temple;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.temple.cis3515_bookcase.R;


public class BookDetailsFragment extends Fragment {
    View V;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String ARG_DETAILS = "details_displayed";

    // TODO: Rename and change types of parameters
    private String Details;

    public BookDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment BookDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BookDetailsFragment newInstance(String b) {
        BookDetailsFragment fragment = new BookDetailsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_DETAILS,b);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Details = getArguments().getString(ARG_DETAILS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater Inflater, ViewGroup Container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        V = Inflater.inflate(R.layout.fragment_book_details, Container, false);
        TextView textView =V.findViewById(R.id.viewDetails);
        textView.setText(Details);
        return V;
    }

    public void displayDetails(String Title){
        //assert index > -1;
        TextView textView = V.findViewById(R.id.viewDetails);
        textView.setText(Title);

    }
}
