package org.d3ifcool.tabungkeun;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class ProfileFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View profile_frag = inflater.inflate(R.layout.fragment_profile, container, false);
        setHasOptionsMenu(true);

        return profile_frag;
    }
}
