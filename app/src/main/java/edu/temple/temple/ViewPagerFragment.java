package edu.temple.temple;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import edu.temple.cis3515_bookcase.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ViewPagerFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ViewPagerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewPagerFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String ARG_BOOKS = "books";

    // TODO: Rename and change types of parameters
    ArrayList<String> books;
    ArrayList<Fragment> fragments;

    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    private OnFragmentInteractionListener mListener;

    public ViewPagerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ViewPagerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ViewPagerFragment newInstance(Bundle b) {
        ViewPagerFragment fragment = new ViewPagerFragment();
        fragment.setArguments(b);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            books = getArguments().getStringArrayList(ARG_BOOKS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater Inflater, ViewGroup Container,
                             Bundle savedInstanceState) {
        View V = Inflater.inflate(R.layout.fragment_view_pager, Container, false);

        fragments = new ArrayList<>(books.size());
        for (int i = 0; i < books.size(); i++) {
            Fragment bookDetailFrag = BookDetailsFragment.newInstance(books.get(i));
            fragments.add(bookDetailFrag);
        }
        viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager(),fragments);

        viewPager = V.findViewById(R.id.viewPager);
        viewPager.setAdapter(viewPagerAdapter);

        return V;
    }
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}